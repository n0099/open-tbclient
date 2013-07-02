package com.baidu.android.pushservice.util;

import java.io.DataOutputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class b {
    byte[] a = new byte[8];
    private DataOutputStream b;

    public b(OutputStream outputStream) {
        this.b = new DataOutputStream(outputStream);
    }

    public void a() {
        this.b.close();
    }

    public final void a(int i) {
        this.a[1] = (byte) (i >> 8);
        this.a[0] = (byte) i;
        this.b.write(this.a, 0, 2);
    }

    public final void a(long j) {
        this.a[7] = (byte) (j >> 56);
        this.a[6] = (byte) (j >> 48);
        this.a[5] = (byte) (j >> 40);
        this.a[4] = (byte) (j >> 32);
        this.a[3] = (byte) (j >> 24);
        this.a[2] = (byte) (j >> 16);
        this.a[1] = (byte) (j >> 8);
        this.a[0] = (byte) j;
        this.b.write(this.a, 0, 8);
    }

    public void a(byte[] bArr) {
        this.b.write(bArr);
    }

    public final void b(int i) {
        this.a[3] = (byte) (i >> 24);
        this.a[2] = (byte) (i >> 16);
        this.a[1] = (byte) (i >> 8);
        this.a[0] = (byte) i;
        this.b.write(this.a, 0, 4);
    }
}
