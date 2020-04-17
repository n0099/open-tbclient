package com.baidu.ar.recorder.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
abstract class b {
    private static final String TAG = b.class.getSimpleName();
    protected d sX;
    protected MediaCodec sY;
    protected c ta;
    protected boolean tb;
    private int sV = -1;
    private boolean sW = false;
    protected long tc = 0;
    protected MediaCodec.BufferInfo sZ = new MediaCodec.BufferInfo();

    private void R(boolean z) {
        ByteBuffer[] byteBufferArr;
        int i;
        com.baidu.ar.f.b.c(TAG, "drainEncoder endOfStream = " + z);
        try {
            byteBufferArr = this.sY.getOutputBuffers();
        } catch (Exception e) {
            e.printStackTrace();
            byteBufferArr = null;
        }
        if (byteBufferArr == null) {
            return;
        }
        while (true) {
            try {
                i = this.sY.dequeueOutputBuffer(this.sZ, 10000L);
            } catch (Exception e2) {
                e2.printStackTrace();
                i = 0;
            }
            com.baidu.ar.f.b.c(TAG, "drainEncoder encoderStatus = " + i);
            if (i == -1) {
                if (!z) {
                    return;
                }
                com.baidu.ar.f.b.c(TAG, "no output available, spinning to await EOS");
            } else if (i == -3) {
                byteBufferArr = this.sY.getOutputBuffers();
            } else if (i == -2) {
                if (this.sX.er()) {
                    com.baidu.ar.f.b.b(TAG, "format changed twice!!!!");
                    return;
                }
                MediaFormat outputFormat = this.sY.getOutputFormat();
                com.baidu.ar.f.b.c(TAG, "encoder output format changed: " + outputFormat);
                this.sV = this.sX.a(outputFormat);
                this.sW = true;
                if (this.ta != null) {
                    this.ta.M(this.sW);
                }
                if (this.tb) {
                    this.sX.es();
                }
            } else if (i < 0) {
                com.baidu.ar.f.b.j(TAG, "unexpected result from encoder.dequeueOutputBuffer: " + i);
            } else {
                ByteBuffer byteBuffer = byteBufferArr[i];
                if (byteBuffer == null) {
                    throw new RuntimeException("encoderOutputBuffer " + i + " was null");
                }
                if ((this.sZ.flags & 2) != 0) {
                    com.baidu.ar.f.b.c(TAG, "ignoring BUFFER_FLAG_CODEC_CONFIG");
                    this.sZ.size = 0;
                }
                if (this.sZ.size != 0) {
                    if (this.sX.er()) {
                        byteBuffer.position(this.sZ.offset);
                        byteBuffer.limit(this.sZ.offset + this.sZ.size);
                        en();
                        com.baidu.ar.f.b.c(TAG, "drainEncoder writeSampleData mBufferInfo = " + this.sZ.presentationTimeUs + "&& size = " + this.sZ.size);
                        this.sX.a(this.sV, byteBuffer, this.sZ);
                    } else {
                        com.baidu.ar.f.b.c(TAG, "drainEncoder wait for mMuxer start !!!");
                    }
                }
                this.sY.releaseOutputBuffer(i, false);
                if ((this.sZ.flags & 4) != 0) {
                    if (!z) {
                        com.baidu.ar.f.b.b(TAG, "reached end of stream unexpectedly");
                        return;
                    }
                    if (this.tb) {
                        this.sX.et();
                    }
                    if (this.ta != null) {
                        this.ta.N(true);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private boolean a(int i, ByteBuffer byteBuffer, int i2, long j) {
        ByteBuffer byteBuffer2 = this.sY.getInputBuffers()[i];
        if (byteBuffer2.capacity() >= byteBuffer.capacity()) {
            byteBuffer2.position(0);
            byteBuffer2.put(byteBuffer);
            byteBuffer2.flip();
            this.sZ.offset = 0;
            this.sZ.size = i2;
            this.sZ.presentationTimeUs = j / 1000;
            return true;
        }
        return false;
    }

    public void Q(boolean z) {
        com.baidu.ar.f.b.c(TAG, "drainSurface endOfStream = " + z);
        if (z) {
            if (this.sX == null || !this.sX.er()) {
                if (this.ta != null) {
                    this.ta.N(true);
                    return;
                }
                return;
            }
            this.sY.signalEndOfInputStream();
        }
        R(z);
    }

    public void a(c cVar) {
        this.ta = cVar;
    }

    public void a(boolean z, ByteBuffer byteBuffer, int i, long j) {
        if (this.sY != null) {
            if (this.sW && this.sV == -1) {
                return;
            }
            int i2 = -1;
            try {
                i2 = this.sY.dequeueInputBuffer(10000L);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (i2 < 0) {
                com.baidu.ar.f.b.c(TAG, "drainBuffer encode input buffer not available");
            } else if (z) {
                com.baidu.ar.f.b.c(TAG, "drainBuffer sending EOS to drainBufferEncoder");
                this.sY.queueInputBuffer(i2, 0, 0, 0L, 4);
            } else if (!a(i2, byteBuffer, i, j)) {
                return;
            } else {
                this.sY.queueInputBuffer(i2, this.sZ.offset, this.sZ.size, this.sZ.presentationTimeUs, 0);
            }
            R(z);
        }
    }

    protected abstract void en();

    public void eo() {
        this.sY.release();
        this.sY = null;
        this.sX = null;
    }

    public void ep() {
        com.baidu.ar.f.b.c(TAG, "stopEncoder !!!");
        if (this.sY != null) {
            try {
                this.sY.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void eq() {
        com.baidu.ar.f.b.c(TAG, "startEncoder !!!");
        boolean z = true;
        if (this.sY != null) {
            try {
                this.sY.start();
            } catch (Exception e) {
                z = false;
                e.printStackTrace();
            }
        }
        if (this.ta != null) {
            this.ta.L(z);
        }
    }
}
