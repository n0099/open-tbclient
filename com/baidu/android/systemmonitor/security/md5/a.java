package com.baidu.android.systemmonitor.security.md5;

import java.io.FilterInputStream;
import java.io.InputStream;
/* loaded from: classes.dex */
public class a extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private MD5 f814a;

    public a(InputStream inputStream) {
        super(inputStream);
        this.f814a = new MD5();
    }

    public byte[] a() {
        return this.f814a.b();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int read = this.in.read();
        if (read == -1) {
            return -1;
        }
        if ((read & (-256)) == 0) {
            this.f814a.a(read);
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int read = this.in.read(bArr, i, i2);
        if (read != -1) {
            this.f814a.a(bArr, i, read);
        }
        return read;
    }
}
