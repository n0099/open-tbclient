package com.baidu.ar.recorder.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
abstract class b {
    private static final String TAG = b.class.getSimpleName();
    protected d uc;
    protected MediaCodec ud;
    protected c uf;
    protected boolean ug;
    private int ua = -1;
    private boolean ub = false;
    protected long uh = 0;
    protected MediaCodec.BufferInfo ue = new MediaCodec.BufferInfo();

    private void T(boolean z) {
        ByteBuffer[] byteBufferArr;
        int i;
        com.baidu.ar.g.b.c(TAG, "drainEncoder endOfStream = " + z);
        try {
            byteBufferArr = this.ud.getOutputBuffers();
        } catch (Exception e) {
            e.printStackTrace();
            byteBufferArr = null;
        }
        if (byteBufferArr == null) {
            return;
        }
        while (true) {
            try {
                i = this.ud.dequeueOutputBuffer(this.ue, 10000L);
            } catch (Exception e2) {
                e2.printStackTrace();
                i = 0;
            }
            com.baidu.ar.g.b.c(TAG, "drainEncoder encoderStatus = " + i);
            if (i == -1) {
                if (!z) {
                    return;
                }
                com.baidu.ar.g.b.c(TAG, "no output available, spinning to await EOS");
            } else if (i == -3) {
                byteBufferArr = this.ud.getOutputBuffers();
            } else if (i == -2) {
                if (this.uc.fT()) {
                    com.baidu.ar.g.b.b(TAG, "format changed twice!!!!");
                    return;
                }
                MediaFormat outputFormat = this.ud.getOutputFormat();
                com.baidu.ar.g.b.c(TAG, "encoder output format changed: " + outputFormat);
                this.ua = this.uc.a(outputFormat);
                this.ub = true;
                if (this.uf != null) {
                    this.uf.O(this.ub);
                }
                if (this.ug) {
                    this.uc.fU();
                }
            } else if (i < 0) {
                com.baidu.ar.g.b.l(TAG, "unexpected result from encoder.dequeueOutputBuffer: " + i);
            } else {
                ByteBuffer byteBuffer = byteBufferArr[i];
                if (byteBuffer == null) {
                    throw new RuntimeException("encoderOutputBuffer " + i + " was null");
                }
                if ((this.ue.flags & 2) != 0) {
                    com.baidu.ar.g.b.c(TAG, "ignoring BUFFER_FLAG_CODEC_CONFIG");
                    this.ue.size = 0;
                }
                if (this.ue.size != 0) {
                    if (this.uc.fT()) {
                        byteBuffer.position(this.ue.offset);
                        byteBuffer.limit(this.ue.offset + this.ue.size);
                        fP();
                        com.baidu.ar.g.b.c(TAG, "drainEncoder writeSampleData mBufferInfo = " + this.ue.presentationTimeUs + "&& size = " + this.ue.size);
                        this.uc.a(this.ua, byteBuffer, this.ue);
                    } else {
                        com.baidu.ar.g.b.c(TAG, "drainEncoder wait for mMuxer start !!!");
                    }
                }
                this.ud.releaseOutputBuffer(i, false);
                if ((this.ue.flags & 4) != 0) {
                    if (!z) {
                        com.baidu.ar.g.b.b(TAG, "reached end of stream unexpectedly");
                        return;
                    }
                    if (this.ug) {
                        this.uc.fV();
                    }
                    if (this.uf != null) {
                        this.uf.P(true);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private boolean a(int i, ByteBuffer byteBuffer, int i2, long j) {
        ByteBuffer byteBuffer2 = this.ud.getInputBuffers()[i];
        if (byteBuffer2.capacity() >= byteBuffer.capacity()) {
            byteBuffer2.position(0);
            byteBuffer2.put(byteBuffer);
            byteBuffer2.flip();
            this.ue.offset = 0;
            this.ue.size = i2;
            this.ue.presentationTimeUs = j / 1000;
            return true;
        }
        return false;
    }

    public void S(boolean z) {
        com.baidu.ar.g.b.c(TAG, "drainSurface endOfStream = " + z);
        if (z) {
            if (this.uc == null || !this.uc.fT()) {
                if (this.uf != null) {
                    this.uf.P(true);
                    return;
                }
                return;
            }
            this.ud.signalEndOfInputStream();
        }
        T(z);
    }

    public void a(c cVar) {
        this.uf = cVar;
    }

    public void a(boolean z, ByteBuffer byteBuffer, int i, long j) {
        if (this.ud != null) {
            if (this.ub && this.ua == -1) {
                return;
            }
            int i2 = -1;
            try {
                i2 = this.ud.dequeueInputBuffer(10000L);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (i2 < 0) {
                com.baidu.ar.g.b.c(TAG, "drainBuffer encode input buffer not available");
            } else if (z) {
                com.baidu.ar.g.b.c(TAG, "drainBuffer sending EOS to drainBufferEncoder");
                this.ud.queueInputBuffer(i2, 0, 0, 0L, 4);
            } else if (!a(i2, byteBuffer, i, j)) {
                return;
            } else {
                this.ud.queueInputBuffer(i2, this.ue.offset, this.ue.size, this.ue.presentationTimeUs, 0);
            }
            T(z);
        }
    }

    protected abstract void fP();

    public void fQ() {
        this.ud.release();
        this.ud = null;
        this.uc = null;
    }

    public void fR() {
        com.baidu.ar.g.b.c(TAG, "stopEncoder !!!");
        if (this.ud != null) {
            try {
                this.ud.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void fS() {
        com.baidu.ar.g.b.c(TAG, "startEncoder !!!");
        boolean z = true;
        if (this.ud != null) {
            try {
                this.ud.start();
            } catch (Exception e) {
                z = false;
                e.printStackTrace();
            }
        }
        if (this.uf != null) {
            this.uf.N(z);
        }
    }
}
