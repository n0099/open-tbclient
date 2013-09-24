package com.baidu.adp.lib.webSocket;

import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class c extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    private final int f463a;
    private ByteBuffer b;

    public ByteBuffer a() {
        return this.b;
    }

    public Buffer b() {
        return this.b.flip();
    }

    public Buffer c() {
        return this.b.clear();
    }

    public int d() {
        return this.b.remaining();
    }

    public synchronized void a(int i) {
        if (i > this.b.capacity()) {
            ByteBuffer byteBuffer = this.b;
            int position = this.b.position();
            this.b = ByteBuffer.allocateDirect(((i / this.f463a) + 1) * this.f463a);
            byteBuffer.clear();
            this.b.clear();
            this.b.put(byteBuffer);
            this.b.position(position);
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) {
        if (this.b.position() + 1 > this.b.capacity()) {
            a(this.b.capacity() + 1);
        }
        this.b.put((byte) i);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        if (this.b.position() + i2 > this.b.capacity()) {
            a(this.b.capacity() + i2);
        }
        this.b.put(bArr, i, i2);
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
