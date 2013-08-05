package com.baidu.android.systemmonitor.security.md5;

import java.io.FilterInputStream;
import java.io.InputStream;
/* loaded from: classes.dex */
public class b extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private MD5 f703a;

    public b(InputStream inputStream) {
        super(inputStream);
        this.f703a = new MD5();
    }

    public byte[] a() {
        return this.f703a.b();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int read = this.in.read();
        if (read == -1) {
            return -1;
        }
        if ((read & (-256)) == 0) {
            this.f703a.a(read);
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int read = this.in.read(bArr, i, i2);
        if (read != -1) {
            this.f703a.a(bArr, i, read);
        }
        return read;
    }
}
