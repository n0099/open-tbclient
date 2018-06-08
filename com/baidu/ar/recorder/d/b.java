package com.baidu.ar.recorder.d;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
abstract class b {
    private static final String g = b.class.getSimpleName();
    protected e a;
    protected MediaCodec b;
    protected c d;
    protected boolean e;
    private int h = -1;
    private boolean i = false;
    protected long f = 0;
    protected MediaCodec.BufferInfo c = new MediaCodec.BufferInfo();

    private boolean a(int i, ByteBuffer byteBuffer, int i2, long j) {
        ByteBuffer byteBuffer2 = this.b.getInputBuffers()[i];
        if (byteBuffer2.capacity() >= byteBuffer.capacity()) {
            byteBuffer2.position(0);
            byteBuffer2.put(byteBuffer);
            byteBuffer2.flip();
            this.c.offset = 0;
            this.c.size = i2;
            this.c.presentationTimeUs = j / 1000;
            return true;
        }
        return false;
    }

    private void b(boolean z) {
        try {
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
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    protected abstract void a();

    public void a(c cVar) {
        this.d = cVar;
    }

    public void a(boolean z) {
        if (z) {
            if (this.a == null || !this.a.b()) {
                if (this.d != null) {
                    this.d.d(true);
                    return;
                }
                return;
            }
            this.b.signalEndOfInputStream();
        }
        b(z);
    }

    public void a(boolean z, ByteBuffer byteBuffer, int i, long j) {
        try {
            if (this.i && this.h == -1) {
                return;
            }
            int dequeueInputBuffer = this.b.dequeueInputBuffer(10000L);
            if (dequeueInputBuffer < 0) {
                Log.d(g, "drainBuffer encode input buffer not available");
            } else if (z) {
                Log.d(g, "drainBuffer sending EOS to drainBufferEncoder");
                this.b.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
            } else if (!a(dequeueInputBuffer, byteBuffer, i, j)) {
                return;
            } else {
                this.b.queueInputBuffer(dequeueInputBuffer, this.c.offset, this.c.size, this.c.presentationTimeUs, 0);
            }
            b(z);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public void b() {
        try {
            this.b.release();
            this.b = null;
            this.a = null;
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public void c() {
        try {
            this.b.stop();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public void d() {
        try {
            this.b.start();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        if (this.d != null) {
            this.d.b(true);
        }
    }
}
