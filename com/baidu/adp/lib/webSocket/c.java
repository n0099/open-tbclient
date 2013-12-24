package com.baidu.adp.lib.webSocket;

import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class c extends OutputStream {
    private final int a;
    private final int b;
    private ByteBuffer c;

    public c() {
        this(131072, 65536);
    }

    public c(int i, int i2) {
        this.a = i;
        this.b = i2;
        this.c = ByteBuffer.allocateDirect(this.a);
        this.c.clear();
    }

    public ByteBuffer a() {
        return this.c;
    }

    public Buffer b() {
        return this.c.flip();
    }

    public Buffer c() {
        return this.c.clear();
    }

    public int d() {
        return this.c.remaining();
    }

    public synchronized void a(int i) {
        if (i > this.c.capacity()) {
            ByteBuffer byteBuffer = this.c;
            int position = this.c.position();
            this.c = ByteBuffer.allocateDirect(((i / this.b) + 1) * this.b);
            byteBuffer.clear();
            this.c.clear();
            this.c.put(byteBuffer);
            this.c.position(position);
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) {
        if (this.c.position() + 1 > this.c.capacity()) {
            a(this.c.capacity() + 1);
        }
        this.c.put((byte) i);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        if (this.c.position() + i2 > this.c.capacity()) {
            a(this.c.capacity() + i2);
        }
        this.c.put(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public synchronized void a(String str) {
        write(str.getBytes("UTF-8"));
    }

    public synchronized void e() {
        write(13);
        write(10);
    }
}
