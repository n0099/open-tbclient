package com.baidu.android.pushservice.i;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    byte[] f1427a = new byte[8];

    /* renamed from: b  reason: collision with root package name */
    private DataOutputStream f1428b;

    public e(OutputStream outputStream) {
        this.f1428b = new DataOutputStream(outputStream);
    }

    public void a() throws IOException {
        this.f1428b.close();
    }

    public final void a(int i) throws Exception {
        this.f1427a[1] = (byte) (i >> 8);
        this.f1427a[0] = (byte) i;
        this.f1428b.write(this.f1427a, 0, 2);
    }

    public final void a(long j) throws Exception {
        this.f1427a[7] = (byte) (j >> 56);
        this.f1427a[6] = (byte) (j >> 48);
        this.f1427a[5] = (byte) (j >> 40);
        this.f1427a[4] = (byte) (j >> 32);
        this.f1427a[3] = (byte) (j >> 24);
        this.f1427a[2] = (byte) (j >> 16);
        this.f1427a[1] = (byte) (j >> 8);
        this.f1427a[0] = (byte) j;
        this.f1428b.write(this.f1427a, 0, 8);
    }

    public void a(byte[] bArr) throws Exception {
        this.f1428b.write(bArr);
    }

    public final void b(int i) throws Exception {
        this.f1427a[3] = (byte) (i >> 24);
        this.f1427a[2] = (byte) (i >> 16);
        this.f1427a[1] = (byte) (i >> 8);
        this.f1427a[0] = (byte) i;
        this.f1428b.write(this.f1427a, 0, 4);
    }
}
