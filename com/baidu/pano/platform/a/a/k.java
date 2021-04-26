package com.baidu.pano.platform.a.a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* loaded from: classes2.dex */
public class k extends ByteArrayOutputStream {

    /* renamed from: a  reason: collision with root package name */
    public final b f9227a;

    public k(b bVar, int i2) {
        this.f9227a = bVar;
        ((ByteArrayOutputStream) this).buf = bVar.a(Math.max(i2, 256));
    }

    private void a(int i2) {
        int i3 = ((ByteArrayOutputStream) this).count;
        if (i3 + i2 <= ((ByteArrayOutputStream) this).buf.length) {
            return;
        }
        byte[] a2 = this.f9227a.a((i3 + i2) * 2);
        System.arraycopy(((ByteArrayOutputStream) this).buf, 0, a2, 0, ((ByteArrayOutputStream) this).count);
        this.f9227a.a(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = a2;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f9227a.a(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = null;
        super.close();
    }

    public void finalize() {
        this.f9227a.a(((ByteArrayOutputStream) this).buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i2, int i3) {
        a(i3);
        super.write(bArr, i2, i3);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int i2) {
        a(1);
        super.write(i2);
    }
}
