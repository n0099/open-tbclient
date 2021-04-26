package com.baidu.android.pushservice.j;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f3460a = new byte[8];

    /* renamed from: b  reason: collision with root package name */
    public DataOutputStream f3461b;

    public e(OutputStream outputStream) {
        this.f3461b = new DataOutputStream(outputStream);
    }

    public void a() throws IOException {
        this.f3461b.close();
    }

    public final void a(int i2) throws Exception {
        byte[] bArr = this.f3460a;
        bArr[1] = (byte) (i2 >> 8);
        bArr[0] = (byte) i2;
        this.f3461b.write(bArr, 0, 2);
    }

    public final void a(long j) throws Exception {
        byte[] bArr = this.f3460a;
        bArr[7] = (byte) (j >> 56);
        bArr[6] = (byte) (j >> 48);
        bArr[5] = (byte) (j >> 40);
        bArr[4] = (byte) (j >> 32);
        bArr[3] = (byte) (j >> 24);
        bArr[2] = (byte) (j >> 16);
        bArr[1] = (byte) (j >> 8);
        bArr[0] = (byte) j;
        this.f3461b.write(bArr, 0, 8);
    }

    public void a(byte[] bArr) throws Exception {
        this.f3461b.write(bArr);
    }

    public final void b(int i2) throws Exception {
        byte[] bArr = this.f3460a;
        bArr[3] = (byte) (i2 >> 24);
        bArr[2] = (byte) (i2 >> 16);
        bArr[1] = (byte) (i2 >> 8);
        bArr[0] = (byte) i2;
        this.f3461b.write(bArr, 0, 4);
    }
}
