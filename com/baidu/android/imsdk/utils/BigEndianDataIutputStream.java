package com.baidu.android.imsdk.utils;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes18.dex */
public class BigEndianDataIutputStream {
    byte[] buff = new byte[8];
    private DataInputStream mDis;

    public BigEndianDataIutputStream(InputStream inputStream) {
        this.mDis = new DataInputStream(inputStream);
    }

    public void close() throws IOException {
        this.mDis.close();
    }

    private int readToBuff(int i) throws IOException {
        int i2 = 0;
        while (i2 < i) {
            int read = this.mDis.read(this.buff, i2, i - i2);
            if (read != -1) {
                i2 += read;
            } else {
                return read;
            }
        }
        return i2;
    }

    public final byte readByte() throws IOException {
        if (readToBuff(1) < 0) {
            throw new EOFException();
        }
        return this.buff[0];
    }

    public final int readInt() throws IOException {
        if (readToBuff(4) < 0) {
            throw new EOFException();
        }
        return ((this.buff[0] & 255) << 24) | ((this.buff[1] & 255) << 16) | ((this.buff[2] & 255) << 8) | (this.buff[3] & 255);
    }

    public final short readShort() throws IOException {
        if (readToBuff(2) < 0) {
            throw new EOFException();
        }
        return (short) (((this.buff[0] & 255) << 8) | (this.buff[1] & 255));
    }

    public final long readLong() throws IOException {
        if (readToBuff(8) < 0) {
            throw new EOFException();
        }
        int i = ((this.buff[0] & 255) << 24) | ((this.buff[1] & 255) << 16) | ((this.buff[2] & 255) << 8) | (this.buff[3] & 255);
        return ((((this.buff[4] & 255) << 24) | ((this.buff[5] & 255) << 16) | ((this.buff[6] & 255) << 8) | (this.buff[7] & 255)) & 4294967295L) | ((i & 4294967295L) << 32);
    }

    public final void readFully(byte[] bArr) throws IOException {
        this.mDis.readFully(bArr, 0, bArr.length);
    }

    public final void skipBytes(int i) throws IOException {
        this.mDis.skipBytes(i);
    }
}
