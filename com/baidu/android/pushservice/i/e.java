package com.baidu.android.pushservice.i;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes8.dex */
public class e {
    byte[] a = new byte[8];
    private DataOutputStream b;

    public e(OutputStream outputStream) {
        this.b = new DataOutputStream(outputStream);
    }

    public void a() throws IOException {
        this.b.close();
    }

    public final void a(int i) throws Exception {
        this.a[1] = (byte) (i >> 8);
        this.a[0] = (byte) i;
        this.b.write(this.a, 0, 2);
    }

    public final void a(long j) throws Exception {
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

    public void a(byte[] bArr) throws Exception {
        this.b.write(bArr);
    }

    public final void b(int i) throws Exception {
        this.a[3] = (byte) (i >> 24);
        this.a[2] = (byte) (i >> 16);
        this.a[1] = (byte) (i >> 8);
        this.a[0] = (byte) i;
        this.b.write(this.a, 0, 4);
    }
}
