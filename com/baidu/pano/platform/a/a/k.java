package com.baidu.pano.platform.a.a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* loaded from: classes6.dex */
public class k extends ByteArrayOutputStream {

    /* renamed from: a  reason: collision with root package name */
    private final b f3860a;

    public k(b bVar, int i) {
        this.f3860a = bVar;
        this.buf = this.f3860a.a(Math.max(i, 256));
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f3860a.a(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.f3860a.a(this.buf);
    }

    private void a(int i) {
        if (this.count + i > this.buf.length) {
            byte[] a2 = this.f3860a.a((this.count + i) * 2);
            System.arraycopy(this.buf, 0, a2, 0, this.count);
            this.f3860a.a(this.buf);
            this.buf = a2;
        }
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        a(i2);
        super.write(bArr, i, i2);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int i) {
        a(1);
        super.write(i);
    }
}
