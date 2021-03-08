package com.baidu.ar.recorder.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
abstract class b {
    private static final String TAG = b.class.getSimpleName();
    protected d uP;
    protected MediaCodec uQ;
    protected c uS;
    protected boolean uT;
    private int uN = -1;
    private boolean uO = false;
    protected long uU = 0;
    protected MediaCodec.BufferInfo uR = new MediaCodec.BufferInfo();

    private void R(boolean z) {
        ByteBuffer[] byteBufferArr;
        int i;
        com.baidu.ar.h.b.c(TAG, "drainEncoder endOfStream = " + z);
        try {
            byteBufferArr = this.uQ.getOutputBuffers();
        } catch (Exception e) {
            e.printStackTrace();
            byteBufferArr = null;
        }
        if (byteBufferArr == null) {
            return;
        }
        while (true) {
            try {
                i = this.uQ.dequeueOutputBuffer(this.uR, 10000L);
            } catch (Exception e2) {
                e2.printStackTrace();
                i = 0;
            }
            com.baidu.ar.h.b.c(TAG, "drainEncoder encoderStatus = " + i);
            if (i == -1) {
                if (!z) {
                    return;
                }
                com.baidu.ar.h.b.c(TAG, "no output available, spinning to await EOS");
            } else if (i == -3) {
                byteBufferArr = this.uQ.getOutputBuffers();
            } else if (i == -2) {
                if (this.uP.fU()) {
                    com.baidu.ar.h.b.b(TAG, "format changed twice!!!!");
                    return;
                }
                MediaFormat outputFormat = this.uQ.getOutputFormat();
                com.baidu.ar.h.b.c(TAG, "encoder output format changed: " + outputFormat);
                this.uN = this.uP.a(outputFormat);
                this.uO = true;
                if (this.uS != null) {
                    this.uS.M(this.uO);
                }
                if (this.uT) {
                    this.uP.fV();
                }
            } else if (i < 0) {
                com.baidu.ar.h.b.l(TAG, "unexpected result from encoder.dequeueOutputBuffer: " + i);
            } else {
                ByteBuffer byteBuffer = byteBufferArr[i];
                if (byteBuffer == null) {
                    throw new RuntimeException("encoderOutputBuffer " + i + " was null");
                }
                if ((this.uR.flags & 2) != 0) {
                    com.baidu.ar.h.b.c(TAG, "ignoring BUFFER_FLAG_CODEC_CONFIG");
                    this.uR.size = 0;
                }
                if (this.uR.size != 0) {
                    if (this.uP.fU()) {
                        byteBuffer.position(this.uR.offset);
                        byteBuffer.limit(this.uR.offset + this.uR.size);
                        fQ();
                        com.baidu.ar.h.b.c(TAG, "drainEncoder writeSampleData mBufferInfo = " + this.uR.presentationTimeUs + "&& size = " + this.uR.size);
                        this.uP.a(this.uN, byteBuffer, this.uR);
                    } else {
                        com.baidu.ar.h.b.c(TAG, "drainEncoder wait for mMuxer start !!!");
                    }
                }
                this.uQ.releaseOutputBuffer(i, false);
                if ((this.uR.flags & 4) != 0) {
                    if (!z) {
                        com.baidu.ar.h.b.b(TAG, "reached end of stream unexpectedly");
                        return;
                    }
                    if (this.uT) {
                        this.uP.fW();
                    }
                    if (this.uS != null) {
                        this.uS.N(true);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private boolean a(int i, ByteBuffer byteBuffer, int i2, long j) {
        ByteBuffer byteBuffer2 = this.uQ.getInputBuffers()[i];
        if (byteBuffer2.capacity() >= byteBuffer.capacity()) {
            byteBuffer2.position(0);
            byteBuffer2.put(byteBuffer);
            byteBuffer2.flip();
            this.uR.offset = 0;
            this.uR.size = i2;
            this.uR.presentationTimeUs = j / 1000;
            return true;
        }
        return false;
    }

    public void Q(boolean z) {
        com.baidu.ar.h.b.c(TAG, "drainSurface endOfStream = " + z);
        if (z) {
            if (this.uP == null || !this.uP.fU()) {
                if (this.uS != null) {
                    this.uS.N(true);
                    return;
                }
                return;
            }
            this.uQ.signalEndOfInputStream();
        }
        R(z);
    }

    public void a(c cVar) {
        this.uS = cVar;
    }

    public void a(boolean z, ByteBuffer byteBuffer, int i, long j) {
        if (this.uQ != null) {
            if (this.uO && this.uN == -1) {
                return;
            }
            int i2 = -1;
            try {
                i2 = this.uQ.dequeueInputBuffer(10000L);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (i2 < 0) {
                com.baidu.ar.h.b.c(TAG, "drainBuffer encode input buffer not available");
            } else if (z) {
                com.baidu.ar.h.b.c(TAG, "drainBuffer sending EOS to drainBufferEncoder");
                this.uQ.queueInputBuffer(i2, 0, 0, 0L, 4);
            } else if (!a(i2, byteBuffer, i, j)) {
                return;
            } else {
                this.uQ.queueInputBuffer(i2, this.uR.offset, this.uR.size, this.uR.presentationTimeUs, 0);
            }
            R(z);
        }
    }

    protected abstract void fQ();

    public void fR() {
        this.uQ.release();
        this.uQ = null;
        this.uP = null;
    }

    public void fS() {
        com.baidu.ar.h.b.c(TAG, "stopEncoder !!!");
        if (this.uQ != null) {
            try {
                this.uQ.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void fT() {
        com.baidu.ar.h.b.c(TAG, "startEncoder !!!");
        boolean z = true;
        if (this.uQ != null) {
            try {
                this.uQ.start();
            } catch (Exception e) {
                z = false;
                e.printStackTrace();
            }
        }
        if (this.uS != null) {
            this.uS.L(z);
        }
    }
}
