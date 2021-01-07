package com.baidu.android.pushservice.i;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    byte[] f1419a = new byte[8];

    /* renamed from: b  reason: collision with root package name */
    private DataInputStream f1420b;

    public d(InputStream inputStream) {
        this.f1420b = new DataInputStream(inputStream);
    }

    private int a(int i) throws IOException {
        int i2 = 0;
        while (i2 < i) {
            int read = this.f1420b.read(this.f1419a, i2, i - i2);
            if (read == -1) {
                return read;
            }
            i2 += read;
        }
        return i2;
    }

    public void a() throws IOException {
        this.f1420b.close();
    }

    public final void a(byte[] bArr) throws IOException {
        this.f1420b.readFully(bArr, 0, bArr.length);
    }

    public final int b() throws IOException {
        if (a(4) < 0) {
            throw new EOFException();
        }
        return ((this.f1419a[3] & 255) << 24) | ((this.f1419a[2] & 255) << 16) | ((this.f1419a[1] & 255) << 8) | (this.f1419a[0] & 255);
    }

    public final short c() throws IOException {
        if (a(2) < 0) {
            throw new EOFException();
        }
        return (short) (((this.f1419a[1] & 255) << 8) | (this.f1419a[0] & 255));
    }

    public final long d() throws IOException {
        if (a(8) < 0) {
            throw new EOFException();
        }
        int i = ((this.f1419a[7] & 255) << 24) | ((this.f1419a[6] & 255) << 16) | ((this.f1419a[5] & 255) << 8) | (this.f1419a[4] & 255);
        return ((((this.f1419a[3] & 255) << 24) | ((this.f1419a[2] & 255) << 16) | ((this.f1419a[1] & 255) << 8) | (this.f1419a[0] & 255)) & 4294967295L) | ((i & 4294967295L) << 32);
    }
}
