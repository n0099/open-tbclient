package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
abstract class b {
    private static final String TAG = b.class.getSimpleName();
    protected static long bXT = 0;
    protected static int bXU = 10000;
    protected e bXP;
    protected c bXQ;
    protected boolean bXR;
    protected MediaCodec mEncoder;
    private int bXN = -1;
    private boolean bXO = false;
    protected long bXS = 0;
    protected MediaCodec.BufferInfo mBufferInfo = new MediaCodec.BufferInfo();

    protected abstract void ZH();

    public void ZK() {
        this.mEncoder.start();
        if (this.bXQ != null) {
            this.bXQ.dt(true);
        }
    }

    public void dy(boolean z) {
        if (z) {
            if (this.bXP != null && this.bXP.ZL()) {
                this.mEncoder.signalEndOfInputStream();
            } else if (this.bXQ != null) {
                this.bXQ.dv(true);
                return;
            } else {
                return;
            }
        }
        g(z, 10000);
    }

    public long Zi() {
        return this.bXS * 1000;
    }

    public void b(boolean z, ByteBuffer byteBuffer, int i, long j) {
        if (!this.bXO || this.bXN != -1) {
            int dequeueInputBuffer = this.mEncoder.dequeueInputBuffer(10000L);
            if (dequeueInputBuffer >= 0) {
                if (z) {
                    Log.d(TAG, "drainBuffer sending EOS to drainBufferEncoder");
                    this.mEncoder.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                } else if (b(dequeueInputBuffer, byteBuffer, i, j)) {
                    this.mEncoder.queueInputBuffer(dequeueInputBuffer, this.mBufferInfo.offset, this.mBufferInfo.size, this.mBufferInfo.presentationTimeUs, 0);
                } else {
                    return;
                }
            } else {
                Log.d(TAG, "drainBuffer encode input buffer not available");
            }
            g(z, bXU);
        }
    }

    private boolean b(int i, ByteBuffer byteBuffer, int i2, long j) {
        ByteBuffer byteBuffer2 = this.mEncoder.getInputBuffers()[i];
        if (byteBuffer2.capacity() >= byteBuffer.capacity()) {
            byteBuffer2.position(0);
            byteBuffer2.put(byteBuffer);
            byteBuffer2.flip();
            this.mBufferInfo.offset = 0;
            this.mBufferInfo.size = i2;
            this.mBufferInfo.presentationTimeUs = j / 1000;
            return true;
        }
        return false;
    }

    public void ZJ() {
        try {
            this.mEncoder.stop();
        } catch (Exception e) {
            Log.e(TAG, "MediaCodec IllegalStateException Exception ");
        }
    }

    public void ZI() {
        this.mEncoder.release();
        this.mEncoder = null;
        this.bXP = null;
    }

    public void a(c cVar) {
        this.bXQ = cVar;
    }

    private void g(boolean z, int i) {
        ByteBuffer[] outputBuffers = this.mEncoder.getOutputBuffers();
        while (true) {
            try {
                int dequeueOutputBuffer = this.mEncoder.dequeueOutputBuffer(this.mBufferInfo, i);
                if (dequeueOutputBuffer == -1) {
                    if (z) {
                        Log.d(TAG, "no output available, spinning to await EOS");
                    } else {
                        return;
                    }
                } else if (dequeueOutputBuffer == -3) {
                    outputBuffers = this.mEncoder.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    if (this.bXP.ZL()) {
                        Log.e(TAG, "format changed twice!!!!");
                        return;
                    }
                    MediaFormat outputFormat = this.mEncoder.getOutputFormat();
                    Log.d(TAG, "encoder output format changed: " + outputFormat);
                    this.bXN = this.bXP.b(outputFormat);
                    this.bXO = true;
                    if (this.bXQ != null) {
                        this.bXQ.du(this.bXO);
                    }
                    if (this.bXR) {
                        this.bXP.ZM();
                    }
                } else if (dequeueOutputBuffer < 0) {
                    Log.w(TAG, "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                } else {
                    ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                    if (byteBuffer == null) {
                        throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                    }
                    if ((this.mBufferInfo.flags & 2) != 0) {
                        Log.d(TAG, "ignoring BUFFER_FLAG_CODEC_CONFIG");
                        this.mBufferInfo.size = 0;
                    }
                    if (this.mBufferInfo.size != 0) {
                        if (this.bXP.ZL()) {
                            byteBuffer.position(this.mBufferInfo.offset);
                            byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                            ZH();
                            this.bXP.b(this.bXN, byteBuffer, this.mBufferInfo);
                        } else {
                            Log.d(TAG, "drainEncoder wait for mMuxer start !!!");
                        }
                    }
                    this.mEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((this.mBufferInfo.flags & 4) != 0) {
                        if (z) {
                            if (this.bXR) {
                                this.bXP.ZN();
                            }
                            if (this.bXQ != null) {
                                this.bXQ.dv(true);
                                return;
                            }
                            return;
                        }
                        Log.e(TAG, "reached end of stream unexpectedly");
                        return;
                    }
                }
            } catch (IllegalStateException e) {
                System.getProperty("ro.board.platform");
                Log.i(TAG, "mEncoder.dequeueOutputBuffer IllegalStateException error hard:" + System.getProperty("ro.board.platform"));
                return;
            }
        }
    }
}
