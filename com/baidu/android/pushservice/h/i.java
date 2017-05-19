package com.baidu.android.pushservice.h;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class i {
    byte[] a = new byte[8];
    private DataInputStream b;

    public i(InputStream inputStream) {
        this.b = new DataInputStream(inputStream);
    }

    private int a(int i) throws IOException {
        int i2 = 0;
        while (i2 < i) {
            int read = this.b.read(this.a, i2, i - i2);
            if (read == -1) {
                return read;
            }
            i2 += read;
        }
        return i2;
    }

    public void a() throws IOException {
        this.b.close();
    }

    public final void a(byte[] bArr) throws IOException {
        this.b.readFully(bArr, 0, bArr.length);
    }

    public final int b() throws IOException {
        if (a(4) < 0) {
            throw new EOFException();
        }
        return ((this.a[3] & 255) << 24) | ((this.a[2] & 255) << 16) | ((this.a[1] & 255) << 8) | (this.a[0] & 255);
    }

    public final short c() throws IOException {
        if (a(2) < 0) {
            throw new EOFException();
        }
        return (short) (((this.a[1] & 255) << 8) | (this.a[0] & 255));
    }

    public final long d() throws IOException {
        if (a(8) < 0) {
            throw new EOFException();
        }
        int i = ((this.a[7] & 255) << 24) | ((this.a[6] & 255) << 16) | ((this.a[5] & 255) << 8) | (this.a[4] & 255);
        return ((((this.a[3] & 255) << 24) | ((this.a[2] & 255) << 16) | ((this.a[1] & 255) << 8) | (this.a[0] & 255)) & 4294967295L) | ((i & 4294967295L) << 32);
    }
}
