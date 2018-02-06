package com.baidu.ar.recorder.encoder;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
abstract class b {
    private static final String g = b.class.getSimpleName();
    protected d a;
    protected MediaCodec b;
    protected c d;
    protected boolean e;
    private int h = -1;
    private boolean i = false;
    protected long f = 0;
    protected MediaCodec.BufferInfo c = new MediaCodec.BufferInfo();

    private void a(int i, ByteBuffer byteBuffer, int i2, long j) {
        ByteBuffer byteBuffer2 = this.b.getInputBuffers()[i];
        byteBuffer2.position(0);
        byteBuffer2.put(byteBuffer);
        byteBuffer2.flip();
        this.c.offset = 0;
        this.c.size = i2;
        this.c.presentationTimeUs = j / 1000;
    }

    private void b(boolean z) {
        ByteBuffer[] outputBuffers = this.b.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.b.dequeueOutputBuffer(this.c, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
                Log.d(g, "no output available, spinning to await EOS");
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.b.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (this.a.b()) {
                    Log.e(g, "format changed twice!!!!");
                    return;
                }
                MediaFormat outputFormat = this.b.getOutputFormat();
                Log.d(g, "encoder output format changed: " + outputFormat);
                this.h = this.a.a(outputFormat);
                this.i = true;
                if (this.d != null) {
                    this.d.c(this.i);
                }
                if (this.e) {
                    this.a.c();
                }
            } else if (dequeueOutputBuffer < 0) {
                Log.w(g, "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else {
                ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                if (byteBuffer == null) {
                    throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                }
                if ((this.c.flags & 2) != 0) {
                    Log.d(g, "ignoring BUFFER_FLAG_CODEC_CONFIG");
                    this.c.size = 0;
                }
                if (this.c.size != 0) {
                    if (this.a.b()) {
                        byteBuffer.position(this.c.offset);
                        byteBuffer.limit(this.c.offset + this.c.size);
                        a();
                        this.a.a(this.h, byteBuffer, this.c);
                    } else {
                        Log.d(g, "drainEncoder wait for mMuxer start !!!");
                    }
                }
                this.b.releaseOutputBuffer(dequeueOutputBuffer, false);
                if ((this.c.flags & 4) != 0) {
                    if (!z) {
                        Log.e(g, "reached end of stream unexpectedly");
                        return;
                    }
                    if (this.e) {
                        this.a.d();
                    }
                    if (this.d != null) {
                        this.d.d(true);
                        return;
                    }
                    return;
                }
            }
        }
    }

    protected abstract void a();

    public void a(c cVar) {
        this.d = cVar;
    }

    public void a(boolean z) {
        if (z) {
            if (this.a == null || !this.a.b()) {
                return;
            }
            this.b.signalEndOfInputStream();
        }
        b(z);
    }

    public void a(boolean z, ByteBuffer byteBuffer, int i, long j) {
        if (this.i && this.h == -1) {
            return;
        }
        int dequeueInputBuffer = this.b.dequeueInputBuffer(10000L);
        if (dequeueInputBuffer < 0) {
            Log.d(g, "drainBuffer encode input buffer not available");
        } else if (z) {
            Log.d(g, "drainBuffer sending EOS to drainBufferEncoder");
            this.b.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
        } else {
            a(dequeueInputBuffer, byteBuffer, i, j);
            this.b.queueInputBuffer(dequeueInputBuffer, this.c.offset, this.c.size, this.c.presentationTimeUs, 0);
        }
        b(z);
    }

    public void b() {
        this.b.release();
        this.b = null;
        this.a = null;
    }

    public void c() {
        this.b.stop();
    }

    public void d() {
        this.b.start();
        if (this.d != null) {
            this.d.b(true);
        }
    }
}
