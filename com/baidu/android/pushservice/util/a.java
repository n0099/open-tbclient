package com.baidu.android.pushservice.util;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.InputStream;
import java.math.BigInteger;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    byte[] f354a = new byte[8];
    private DataInputStream b;

    public a(InputStream inputStream) {
        this.b = new DataInputStream(inputStream);
    }

    private int a(int i) {
        int i2 = 0;
        while (i2 < i) {
            int read = this.b.read(this.f354a, i2, i - i2);
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
        return ((this.f354a[3] & 255) << 24) | ((this.f354a[2] & 255) << 16) | ((this.f354a[1] & 255) << 8) | (this.f354a[0] & 255);
    }

    public final void a(byte[] bArr) {
        this.b.readFully(bArr, 0, bArr.length);
    }

    public final short b() {
        if (a(2) < 0) {
            throw new EOFException();
        }
        return (short) (((this.f354a[1] & 255) << 8) | (this.f354a[0] & 255));
    }

    public final long c() {
        if (a(8) < 0) {
            throw new EOFException();
        }
        int i = ((this.f354a[7] & 255) << 24) | ((this.f354a[6] & 255) << 16) | ((this.f354a[5] & 255) << 8) | (this.f354a[4] & 255);
        return ((((this.f354a[3] & 255) << 24) | ((this.f354a[2] & 255) << 16) | ((this.f354a[1] & 255) << 8) | (this.f354a[0] & 255)) & 4294967295L) | ((i & 4294967295L) << 32);
    }

    public final b d() {
        if (a(8) < 0) {
            throw new EOFException();
        }
        byte[] bArr = new byte[8];
        for (int i = 0; i < 8; i++) {
            bArr[i] = this.f354a[7 - i];
        }
        String bigInteger = new BigInteger(1, bArr).toString();
        int i2 = ((this.f354a[7] & 255) << 24) | ((this.f354a[6] & 255) << 16) | ((this.f354a[5] & 255) << 8) | (this.f354a[4] & 255);
        int i3 = ((this.f354a[3] & 255) << 24) | ((this.f354a[2] & 255) << 16) | ((this.f354a[1] & 255) << 8);
        b bVar = new b();
        bVar.f355a = bigInteger;
        bVar.b = ((i2 & 4294967295L) << 32) | (((this.f354a[0] & 255) | i3) & 4294967295L);
        return bVar;
    }
}
