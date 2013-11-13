package com.baidu.android.pushservice.util;

import java.io.DataOutputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    byte[] f753a = new byte[8];
    private DataOutputStream b;

    public c(OutputStream outputStream) {
        this.b = new DataOutputStream(outputStream);
    }

    public void a() {
        this.b.close();
    }

    public final void a(int i) {
        this.f753a[1] = (byte) (i >> 8);
        this.f753a[0] = (byte) i;
        this.b.write(this.f753a, 0, 2);
    }

    public final void a(long j) {
        this.f753a[7] = (byte) (j >> 56);
        this.f753a[6] = (byte) (j >> 48);
        this.f753a[5] = (byte) (j >> 40);
        this.f753a[4] = (byte) (j >> 32);
        this.f753a[3] = (byte) (j >> 24);
        this.f753a[2] = (byte) (j >> 16);
        this.f753a[1] = (byte) (j >> 8);
        this.f753a[0] = (byte) j;
        this.b.write(this.f753a, 0, 8);
    }

    public void a(byte[] bArr) {
        this.b.write(bArr);
    }

    public final void b(int i) {
        this.f753a[3] = (byte) (i >> 24);
        this.f753a[2] = (byte) (i >> 16);
        this.f753a[1] = (byte) (i >> 8);
        this.f753a[0] = (byte) i;
        this.b.write(this.f753a, 0, 4);
    }
}
