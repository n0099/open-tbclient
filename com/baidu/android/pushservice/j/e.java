package com.baidu.android.pushservice.j;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f3390a = new byte[8];

    /* renamed from: b  reason: collision with root package name */
    public DataOutputStream f3391b;

    public e(OutputStream outputStream) {
        this.f3391b = new DataOutputStream(outputStream);
    }

    public void a() throws IOException {
        this.f3391b.close();
    }

    public final void a(int i) throws Exception {
        byte[] bArr = this.f3390a;
        bArr[1] = (byte) (i >> 8);
        bArr[0] = (byte) i;
        this.f3391b.write(bArr, 0, 2);
    }

    public final void a(long j) throws Exception {
        byte[] bArr = this.f3390a;
        bArr[7] = (byte) (j >> 56);
        bArr[6] = (byte) (j >> 48);
        bArr[5] = (byte) (j >> 40);
        bArr[4] = (byte) (j >> 32);
        bArr[3] = (byte) (j >> 24);
        bArr[2] = (byte) (j >> 16);
        bArr[1] = (byte) (j >> 8);
        bArr[0] = (byte) j;
        this.f3391b.write(bArr, 0, 8);
    }

    public void a(byte[] bArr) throws Exception {
        this.f3391b.write(bArr);
    }

    public final void b(int i) throws Exception {
        byte[] bArr = this.f3390a;
        bArr[3] = (byte) (i >> 24);
        bArr[2] = (byte) (i >> 16);
        bArr[1] = (byte) (i >> 8);
        bArr[0] = (byte) i;
        this.f3391b.write(bArr, 0, 4);
    }
}
