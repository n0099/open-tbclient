package com.baidu.mario.b.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
abstract class b {
    private static final String TAG = b.class.getSimpleName();
    protected static long afb = 0;
    protected e aeX;
    protected c aeY;
    protected boolean aeZ;
    protected MediaCodec mEncoder;
    private int aeV = -1;
    private boolean aeW = false;
    protected long afa = 0;
    protected MediaCodec.BufferInfo mBufferInfo = new MediaCodec.BufferInfo();

    protected abstract void tN();

    public void tQ() {
        this.mEncoder.start();
        if (this.aeY != null) {
            this.aeY.aJ(true);
        }
    }

    public void aO(boolean z) {
        if (z) {
            if (this.aeX != null && this.aeX.uf()) {
                this.mEncoder.signalEndOfInputStream();
            } else if (this.aeY != null) {
                this.aeY.aL(true);
                return;
            } else {
                return;
            }
        }
        drainEncoder(z);
    }

    public long tm() {
        return this.afa * 1000;
    }

    public void b(boolean z, ByteBuffer byteBuffer, int i, long j) {
        if (!this.aeW || this.aeV != -1) {
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
            drainEncoder(z);
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

    public void tP() {
        this.mEncoder.stop();
    }

    public void tO() {
        this.mEncoder.release();
        this.mEncoder = null;
        this.aeX = null;
    }

    public void a(c cVar) {
        this.aeY = cVar;
    }

    private void drainEncoder(boolean z) {
        ByteBuffer[] outputBuffers = this.mEncoder.getOutputBuffers();
        while (true) {
            try {
                int dequeueOutputBuffer = this.mEncoder.dequeueOutputBuffer(this.mBufferInfo, 10000L);
                if (dequeueOutputBuffer == -1) {
                    if (z) {
                        Log.d(TAG, "no output available, spinning to await EOS");
                    } else {
                        return;
                    }
                } else if (dequeueOutputBuffer == -3) {
                    outputBuffers = this.mEncoder.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    if (this.aeX.uf()) {
                        Log.e(TAG, "format changed twice!!!!");
                        return;
                    }
                    MediaFormat outputFormat = this.mEncoder.getOutputFormat();
                    Log.d(TAG, "encoder output format changed: " + outputFormat);
                    this.aeV = this.aeX.b(outputFormat);
                    this.aeW = true;
                    if (this.aeY != null) {
                        this.aeY.aK(this.aeW);
                    }
                    if (this.aeZ) {
                        this.aeX.ug();
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
                        if (this.aeX.uf()) {
                            byteBuffer.position(this.mBufferInfo.offset);
                            byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                            tN();
                            this.aeX.b(this.aeV, byteBuffer, this.mBufferInfo);
                        } else {
                            Log.d(TAG, "drainEncoder wait for mMuxer start !!!");
                        }
                    }
                    this.mEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((this.mBufferInfo.flags & 4) != 0) {
                        if (z) {
                            if (this.aeZ) {
                                this.aeX.uh();
                            }
                            if (this.aeY != null) {
                                this.aeY.aL(true);
                                return;
                            }
                            return;
                        }
                        Log.e(TAG, "reached end of stream unexpectedly");
                        return;
                    }
                }
            } catch (IllegalStateException e) {
                Log.i(TAG, "mEncoder.dequeueOutputBuffer IllegalStateException error");
                tP();
                return;
            }
        }
    }
}
