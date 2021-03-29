package com.baidu.android.imsdk.utils;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class BigEndianDataIutputStream {
    public byte[] buff = new byte[8];
    public DataInputStream mDis;

    public BigEndianDataIutputStream(InputStream inputStream) {
        this.mDis = new DataInputStream(inputStream);
    }

    private int readToBuff(int i) throws IOException {
        int i2 = 0;
        while (i2 < i) {
            int read = this.mDis.read(this.buff, i2, i - i2);
            if (read == -1) {
                return read;
            }
            i2 += read;
        }
        return i2;
    }

    public void close() throws IOException {
        this.mDis.close();
    }

    public final byte readByte() throws IOException {
        if (readToBuff(1) >= 0) {
            return this.buff[0];
        }
        throw new EOFException();
    }

    public final void readFully(byte[] bArr) throws IOException {
        this.mDis.readFully(bArr, 0, bArr.length);
    }

    public final int readInt() throws IOException {
        if (readToBuff(4) >= 0) {
            byte[] bArr = this.buff;
            return (bArr[3] & 255) | ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8);
        }
        throw new EOFException();
    }

    public final long readLong() throws IOException {
        if (readToBuff(8) >= 0) {
            byte[] bArr = this.buff;
            return (((((((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16)) | ((bArr[2] & 255) << 8)) | (bArr[3] & 255)) & 4294967295L) << 32) | (4294967295L & (((bArr[6] & 255) << 8) | ((bArr[4] & 255) << 24) | ((bArr[5] & 255) << 16) | (bArr[7] & 255)));
        }
        throw new EOFException();
    }

    public final short readShort() throws IOException {
        if (readToBuff(2) >= 0) {
            byte[] bArr = this.buff;
            return (short) ((bArr[1] & 255) | ((bArr[0] & 255) << 8));
        }
        throw new EOFException();
    }

    public final void skipBytes(int i) throws IOException {
        this.mDis.skipBytes(i);
    }
}
