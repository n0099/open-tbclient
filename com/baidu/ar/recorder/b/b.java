package com.baidu.ar.recorder.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
abstract class b {
    private static final String TAG = b.class.getSimpleName();
    protected c tA;
    protected boolean tB;
    protected d tx;
    protected MediaCodec ty;

    /* renamed from: tv  reason: collision with root package name */
    private int f982tv = -1;
    private boolean tw = false;
    protected long tC = 0;
    protected MediaCodec.BufferInfo tz = new MediaCodec.BufferInfo();

    private void S(boolean z) {
        ByteBuffer[] byteBufferArr;
        int i;
        com.baidu.ar.f.b.c(TAG, "drainEncoder endOfStream = " + z);
        try {
            byteBufferArr = this.ty.getOutputBuffers();
        } catch (Exception e) {
            e.printStackTrace();
            byteBufferArr = null;
        }
        if (byteBufferArr == null) {
            return;
        }
        while (true) {
            try {
                i = this.ty.dequeueOutputBuffer(this.tz, 10000L);
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
                byteBufferArr = this.ty.getOutputBuffers();
            } else if (i == -2) {
                if (this.tx.eH()) {
                    com.baidu.ar.f.b.b(TAG, "format changed twice!!!!");
                    return;
                }
                MediaFormat outputFormat = this.ty.getOutputFormat();
                com.baidu.ar.f.b.c(TAG, "encoder output format changed: " + outputFormat);
                this.f982tv = this.tx.a(outputFormat);
                this.tw = true;
                if (this.tA != null) {
                    this.tA.N(this.tw);
                }
                if (this.tB) {
                    this.tx.eI();
                }
            } else if (i < 0) {
                com.baidu.ar.f.b.j(TAG, "unexpected result from encoder.dequeueOutputBuffer: " + i);
            } else {
                ByteBuffer byteBuffer = byteBufferArr[i];
                if (byteBuffer == null) {
                    throw new RuntimeException("encoderOutputBuffer " + i + " was null");
                }
                if ((this.tz.flags & 2) != 0) {
                    com.baidu.ar.f.b.c(TAG, "ignoring BUFFER_FLAG_CODEC_CONFIG");
                    this.tz.size = 0;
                }
                if (this.tz.size != 0) {
                    if (this.tx.eH()) {
                        byteBuffer.position(this.tz.offset);
                        byteBuffer.limit(this.tz.offset + this.tz.size);
                        eD();
                        com.baidu.ar.f.b.c(TAG, "drainEncoder writeSampleData mBufferInfo = " + this.tz.presentationTimeUs + "&& size = " + this.tz.size);
                        this.tx.a(this.f982tv, byteBuffer, this.tz);
                    } else {
                        com.baidu.ar.f.b.c(TAG, "drainEncoder wait for mMuxer start !!!");
                    }
                }
                this.ty.releaseOutputBuffer(i, false);
                if ((this.tz.flags & 4) != 0) {
                    if (!z) {
                        com.baidu.ar.f.b.b(TAG, "reached end of stream unexpectedly");
                        return;
                    }
                    if (this.tB) {
                        this.tx.eJ();
                    }
                    if (this.tA != null) {
                        this.tA.O(true);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private boolean a(int i, ByteBuffer byteBuffer, int i2, long j) {
        ByteBuffer byteBuffer2 = this.ty.getInputBuffers()[i];
        if (byteBuffer2.capacity() >= byteBuffer.capacity()) {
            byteBuffer2.position(0);
            byteBuffer2.put(byteBuffer);
            byteBuffer2.flip();
            this.tz.offset = 0;
            this.tz.size = i2;
            this.tz.presentationTimeUs = j / 1000;
            return true;
        }
        return false;
    }

    public void R(boolean z) {
        com.baidu.ar.f.b.c(TAG, "drainSurface endOfStream = " + z);
        if (z) {
            if (this.tx == null || !this.tx.eH()) {
                if (this.tA != null) {
                    this.tA.O(true);
                    return;
                }
                return;
            }
            this.ty.signalEndOfInputStream();
        }
        S(z);
    }

    public void a(c cVar) {
        this.tA = cVar;
    }

    public void a(boolean z, ByteBuffer byteBuffer, int i, long j) {
        if (this.ty != null) {
            if (this.tw && this.f982tv == -1) {
                return;
            }
            int i2 = -1;
            try {
                i2 = this.ty.dequeueInputBuffer(10000L);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (i2 < 0) {
                com.baidu.ar.f.b.c(TAG, "drainBuffer encode input buffer not available");
            } else if (z) {
                com.baidu.ar.f.b.c(TAG, "drainBuffer sending EOS to drainBufferEncoder");
                this.ty.queueInputBuffer(i2, 0, 0, 0L, 4);
            } else if (!a(i2, byteBuffer, i, j)) {
                return;
            } else {
                this.ty.queueInputBuffer(i2, this.tz.offset, this.tz.size, this.tz.presentationTimeUs, 0);
            }
            S(z);
        }
    }

    protected abstract void eD();

    public void eE() {
        this.ty.release();
        this.ty = null;
        this.tx = null;
    }

    public void eF() {
        com.baidu.ar.f.b.c(TAG, "stopEncoder !!!");
        if (this.ty != null) {
            try {
                this.ty.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void eG() {
        com.baidu.ar.f.b.c(TAG, "startEncoder !!!");
        boolean z = true;
        if (this.ty != null) {
            try {
                this.ty.start();
            } catch (Exception e) {
                z = false;
                e.printStackTrace();
            }
        }
        if (this.tA != null) {
            this.tA.M(z);
        }
    }
}
