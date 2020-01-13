package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
abstract class b {
    private static final String TAG = b.class.getSimpleName();
    protected static long aGM = 0;
    protected static int aGN = 10000;
    protected e aGI;
    protected c aGJ;
    protected boolean aGK;
    protected MediaCodec mEncoder;
    private int aGG = -1;
    private boolean aGH = false;
    protected long aGL = 0;
    protected MediaCodec.BufferInfo mBufferInfo = new MediaCodec.BufferInfo();

    protected abstract void AT();

    public void AV() {
        this.mEncoder.start();
        if (this.aGJ != null) {
            this.aGJ.bv(true);
        }
    }

    public void bA(boolean z) {
        if (z) {
            if (this.aGI != null && this.aGI.Bk()) {
                this.mEncoder.signalEndOfInputStream();
            } else if (this.aGJ != null) {
                this.aGJ.bx(true);
                return;
            } else {
                return;
            }
        }
        d(z, 10000);
    }

    public long Au() {
        return this.aGL * 1000;
    }

    public void b(boolean z, ByteBuffer byteBuffer, int i, long j) {
        if (!this.aGH || this.aGG != -1) {
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
            d(z, aGN);
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

    public void AU() {
        try {
            this.mEncoder.stop();
        } catch (Exception e) {
            Log.e(TAG, "MediaCodec IllegalStateException Exception ");
        }
    }

    public void releaseEncoder() {
        this.mEncoder.release();
        this.mEncoder = null;
        this.aGI = null;
    }

    public void a(c cVar) {
        this.aGJ = cVar;
    }

    private void d(boolean z, int i) {
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
                    if (this.aGI.Bk()) {
                        Log.e(TAG, "format changed twice!!!!");
                        return;
                    }
                    MediaFormat outputFormat = this.mEncoder.getOutputFormat();
                    Log.d(TAG, "encoder output format changed: " + outputFormat);
                    this.aGG = this.aGI.c(outputFormat);
                    this.aGH = true;
                    if (this.aGJ != null) {
                        this.aGJ.bw(this.aGH);
                    }
                    if (this.aGK) {
                        this.aGI.Bl();
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
                        if (this.aGI.Bk()) {
                            byteBuffer.position(this.mBufferInfo.offset);
                            byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                            AT();
                            this.aGI.b(this.aGG, byteBuffer, this.mBufferInfo);
                        } else {
                            Log.d(TAG, "drainEncoder wait for mMuxer start !!!");
                        }
                    }
                    this.mEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((this.mBufferInfo.flags & 4) != 0) {
                        if (z) {
                            if (this.aGK) {
                                this.aGI.Bm();
                            }
                            if (this.aGJ != null) {
                                this.aGJ.bx(true);
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
