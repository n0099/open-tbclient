package com.baidu.android.pushservice.util;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class a {
    byte[] a = new byte[8];
    private DataInputStream b;

    public a(InputStream inputStream) {
        this.b = new DataInputStream(inputStream);
    }

    private int a(int i) {
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

    public final int a() {
        if (a(4) < 0) {
            throw new EOFException();
        }
        return ((this.a[3] & 255) << 24) | ((this.a[2] & 255) << 16) | ((this.a[1] & 255) << 8) | (this.a[0] & 255);
    }

    public final void a(byte[] bArr) {
        this.b.readFully(bArr, 0, bArr.length);
    }

    public final short b() {
        if (a(2) < 0) {
            throw new EOFException();
        }
        return (short) (((this.a[1] & 255) << 8) | (this.a[0] & 255));
    }

    public final long c() {
        if (a(8) < 0) {
            throw new EOFException();
        }
        int i = ((this.a[7] & 255) << 24) | ((this.a[6] & 255) << 16) | ((this.a[5] & 255) << 8) | (this.a[4] & 255);
        return ((((this.a[3] & 255) << 24) | ((this.a[2] & 255) << 16) | ((this.a[1] & 255) << 8) | (this.a[0] & 255)) & 4294967295L) | ((i & 4294967295L) << 32);
    }
}
