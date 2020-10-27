package com.baidu.android.pushservice.i;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes10.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    byte[] f1148a = new byte[8];
    private DataOutputStream b;

    public e(OutputStream outputStream) {
        this.b = new DataOutputStream(outputStream);
    }

    public void a() throws IOException {
        this.b.close();
    }

    public final void a(int i) throws Exception {
        this.f1148a[1] = (byte) (i >> 8);
        this.f1148a[0] = (byte) i;
        this.b.write(this.f1148a, 0, 2);
    }

    public final void a(long j) throws Exception {
        this.f1148a[7] = (byte) (j >> 56);
        this.f1148a[6] = (byte) (j >> 48);
        this.f1148a[5] = (byte) (j >> 40);
        this.f1148a[4] = (byte) (j >> 32);
        this.f1148a[3] = (byte) (j >> 24);
        this.f1148a[2] = (byte) (j >> 16);
        this.f1148a[1] = (byte) (j >> 8);
        this.f1148a[0] = (byte) j;
        this.b.write(this.f1148a, 0, 8);
    }

    public void a(byte[] bArr) throws Exception {
        this.b.write(bArr);
    }

    public final void b(int i) throws Exception {
        this.f1148a[3] = (byte) (i >> 24);
        this.f1148a[2] = (byte) (i >> 16);
        this.f1148a[1] = (byte) (i >> 8);
        this.f1148a[0] = (byte) i;
        this.b.write(this.f1148a, 0, 4);
    }
}
