package com.baidu.ar.speech;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes3.dex */
public class AudioInputStream extends InputStream {
    private static final String a = AudioInputStream.class.getSimpleName();
    private static volatile boolean g = false;
    private static volatile boolean h = false;
    private ConcurrentLinkedQueue<ByteBuffer> b;
    private ConcurrentLinkedQueue<ByteBuffer> c;
    private int d;
    private int e;
    private int f = 0;

    public AudioInputStream(int i, int i2) {
        this.b = null;
        this.c = null;
        this.d = 0;
        this.e = 0;
        this.d = i;
        this.e = i2;
        this.b = new ConcurrentLinkedQueue<>();
        this.c = new ConcurrentLinkedQueue<>();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Log.d(a, "close() !!!");
        g = false;
        h = false;
        this.b.clear();
        this.c.clear();
        this.f = 0;
    }

    public void closeByUser() {
        Log.d(a, "closeByUser() sReading = " + g);
        if (g) {
            h = true;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        return 0;
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) {
        if (!g) {
            g = true;
            h = false;
        }
        if (h) {
            Log.d(a, "read() sStopReading = " + h);
            throw new IOException("stop AudioInputStream by IOException");
        } else if (this.b.isEmpty()) {
            i2 = 0;
        } else {
            ByteBuffer poll = this.b.poll();
            if (poll != null) {
                poll.flip();
                if (poll.capacity() < i2) {
                    i2 = 0;
                } else {
                    System.arraycopy(poll.array(), 0, bArr, i, i2);
                    if (this.c != null) {
                        this.c.offer(poll);
                    }
                }
            }
        }
        return i2;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        Log.d(a, "reset() !!!");
        g = false;
    }

    public synchronized void writeFrameData(ByteBuffer byteBuffer) {
        ByteBuffer poll;
        if (g) {
            try {
                if (!this.c.isEmpty()) {
                    poll = this.c.poll();
                } else if (this.f < this.e) {
                    poll = ByteBuffer.allocate(this.d);
                    if (poll != null) {
                        this.f++;
                    }
                } else {
                    poll = this.b.poll();
                }
                if (this.b != null && poll != null) {
                    this.b.offer(poll);
                    if (byteBuffer != null && poll.capacity() >= byteBuffer.capacity()) {
                        poll.clear();
                        poll.put(byteBuffer);
                        byteBuffer.flip();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
