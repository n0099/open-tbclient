package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
abstract class b {
    private static final String TAG = b.class.getSimpleName();
    protected static long cij = 0;
    protected static int cik = 10000;
    protected e cif;
    protected c cig;
    protected boolean cih;
    protected MediaCodec mEncoder;
    private int cic = -1;
    private boolean cie = false;
    protected long cii = 0;
    protected MediaCodec.BufferInfo mBufferInfo = new MediaCodec.BufferInfo();

    protected abstract void adm();

    public void adp() {
        this.mEncoder.start();
        if (this.cig != null) {
            this.cig.dQ(true);
        }
    }

    public void dV(boolean z) {
        if (z) {
            if (this.cif != null && this.cif.adq()) {
                this.mEncoder.signalEndOfInputStream();
            } else if (this.cig != null) {
                this.cig.dS(true);
                return;
            } else {
                return;
            }
        }
        f(z, 10000);
    }

    public long acN() {
        return this.cii * 1000;
    }

    public void b(boolean z, ByteBuffer byteBuffer, int i, long j) {
        if (!this.cie || this.cic != -1) {
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
            f(z, cik);
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

    public void ado() {
        try {
            this.mEncoder.stop();
        } catch (Exception e) {
            Log.e(TAG, "MediaCodec IllegalStateException Exception ");
        }
    }

    public void adn() {
        this.mEncoder.release();
        this.mEncoder = null;
        this.cif = null;
    }

    public void a(c cVar) {
        this.cig = cVar;
    }

    private void f(boolean z, int i) {
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
                    if (this.cif.adq()) {
                        Log.e(TAG, "format changed twice!!!!");
                        return;
                    }
                    MediaFormat outputFormat = this.mEncoder.getOutputFormat();
                    Log.d(TAG, "encoder output format changed: " + outputFormat);
                    this.cic = this.cif.b(outputFormat);
                    this.cie = true;
                    if (this.cig != null) {
                        this.cig.dR(this.cie);
                    }
                    if (this.cih) {
                        this.cif.adr();
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
                        if (this.cif.adq()) {
                            byteBuffer.position(this.mBufferInfo.offset);
                            byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                            adm();
                            this.cif.b(this.cic, byteBuffer, this.mBufferInfo);
                        } else {
                            Log.d(TAG, "drainEncoder wait for mMuxer start !!!");
                        }
                    }
                    this.mEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((this.mBufferInfo.flags & 4) != 0) {
                        if (z) {
                            if (this.cih) {
                                this.cif.ads();
                            }
                            if (this.cig != null) {
                                this.cig.dS(true);
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
