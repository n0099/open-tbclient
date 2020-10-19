package com.baidu.android.imsdk.utils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes5.dex */
public class BigEndianDataOutputStream {
    byte[] buff = new byte[8];
    private DataOutputStream mDos;

    public BigEndianDataOutputStream(OutputStream outputStream) {
        this.mDos = new DataOutputStream(outputStream);
    }

    public final void writeByte(byte b) throws IOException {
        this.buff[0] = b;
        this.mDos.write(this.buff, 0, 1);
    }

    public final void writeShort(int i) throws IOException {
        this.buff[1] = (byte) (i >> 8);
        this.buff[0] = (byte) i;
        this.mDos.write(this.buff, 0, 2);
    }

    public final void writeInt(int i) throws IOException {
        this.buff[0] = (byte) (i >> 24);
        this.buff[1] = (byte) (i >> 16);
        this.buff[2] = (byte) (i >> 8);
        this.buff[3] = (byte) i;
        this.mDos.write(this.buff, 0, 4);
    }

    public void close() throws IOException {
        this.mDos.close();
    }

    public void write(byte[] bArr) throws IOException {
        this.mDos.write(bArr);
    }

    public final void writeLong(long j) throws IOException {
        this.buff[0] = (byte) (j >> 56);
        this.buff[1] = (byte) (j >> 48);
        this.buff[2] = (byte) (j >> 40);
        this.buff[3] = (byte) (j >> 32);
        this.buff[4] = (byte) (j >> 24);
        this.buff[5] = (byte) (j >> 16);
        this.buff[6] = (byte) (j >> 8);
        this.buff[7] = (byte) j;
        this.mDos.write(this.buff, 0, 8);
    }
}
