package com.baidu.android.pushservice.a0;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class e {
    public DataOutputStream a;
    public byte[] b = new byte[8];

    public e(OutputStream outputStream) {
        this.a = new DataOutputStream(outputStream);
    }

    public void a() throws IOException {
        this.a.close();
    }

    public final void a(int i) throws Exception {
        byte[] bArr = this.b;
        bArr[3] = (byte) (i >> 24);
        bArr[2] = (byte) (i >> 16);
        bArr[1] = (byte) (i >> 8);
        bArr[0] = (byte) i;
        this.a.write(bArr, 0, 4);
    }

    public final void a(long j) throws Exception {
        byte[] bArr = this.b;
        bArr[7] = (byte) (j >> 56);
        bArr[6] = (byte) (j >> 48);
        bArr[5] = (byte) (j >> 40);
        bArr[4] = (byte) (j >> 32);
        bArr[3] = (byte) (j >> 24);
        bArr[2] = (byte) (j >> 16);
        bArr[1] = (byte) (j >> 8);
        bArr[0] = (byte) j;
        this.a.write(bArr, 0, 8);
    }

    public void a(byte[] bArr) throws Exception {
        this.a.write(bArr);
    }

    public final void b(int i) throws Exception {
        byte[] bArr = this.b;
        bArr[1] = (byte) (i >> 8);
        bArr[0] = (byte) i;
        this.a.write(bArr, 0, 2);
    }
}
