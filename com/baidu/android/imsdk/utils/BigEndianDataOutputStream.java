package com.baidu.android.imsdk.utils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class BigEndianDataOutputStream {
    public byte[] buff = new byte[8];
    public DataOutputStream mDos;

    public BigEndianDataOutputStream(OutputStream outputStream) {
        this.mDos = new DataOutputStream(outputStream);
    }

    public void close() throws IOException {
        this.mDos.close();
    }

    public void write(byte[] bArr) throws IOException {
        this.mDos.write(bArr);
    }

    public final void writeByte(byte b2) throws IOException {
        byte[] bArr = this.buff;
        bArr[0] = b2;
        this.mDos.write(bArr, 0, 1);
    }

    public final void writeInt(int i) throws IOException {
        byte[] bArr = this.buff;
        bArr[0] = (byte) (i >> 24);
        bArr[1] = (byte) (i >> 16);
        bArr[2] = (byte) (i >> 8);
        bArr[3] = (byte) i;
        this.mDos.write(bArr, 0, 4);
    }

    public final void writeLong(long j) throws IOException {
        byte[] bArr = this.buff;
        bArr[0] = (byte) (j >> 56);
        bArr[1] = (byte) (j >> 48);
        bArr[2] = (byte) (j >> 40);
        bArr[3] = (byte) (j >> 32);
        bArr[4] = (byte) (j >> 24);
        bArr[5] = (byte) (j >> 16);
        bArr[6] = (byte) (j >> 8);
        bArr[7] = (byte) j;
        this.mDos.write(bArr, 0, 8);
    }

    public final void writeShort(int i) throws IOException {
        byte[] bArr = this.buff;
        bArr[1] = (byte) (i >> 8);
        bArr[0] = (byte) i;
        this.mDos.write(bArr, 0, 2);
    }
}
