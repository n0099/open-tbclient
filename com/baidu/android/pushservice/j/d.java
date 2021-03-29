package com.baidu.android.pushservice.j;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f3388a = new byte[8];

    /* renamed from: b  reason: collision with root package name */
    public DataInputStream f3389b;

    public d(InputStream inputStream) {
        this.f3389b = new DataInputStream(inputStream);
    }

    private int a(int i) throws IOException {
        int i2 = 0;
        while (i2 < i) {
            int read = this.f3389b.read(this.f3388a, i2, i - i2);
            if (read == -1) {
                return read;
            }
            i2 += read;
        }
        return i2;
    }

    public void a() throws IOException {
        this.f3389b.close();
    }

    public final void a(byte[] bArr) throws IOException {
        this.f3389b.readFully(bArr, 0, bArr.length);
    }

    public final int b() throws IOException {
        if (a(4) >= 0) {
            byte[] bArr = this.f3388a;
            return (bArr[0] & 255) | ((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[1] & 255) << 8);
        }
        throw new EOFException();
    }

    public final short c() throws IOException {
        if (a(2) >= 0) {
            byte[] bArr = this.f3388a;
            return (short) ((bArr[0] & 255) | ((bArr[1] & 255) << 8));
        }
        throw new EOFException();
    }

    public final long d() throws IOException {
        if (a(8) >= 0) {
            byte[] bArr = this.f3388a;
            return (((((((bArr[7] & 255) << 24) | ((bArr[6] & 255) << 16)) | ((bArr[5] & 255) << 8)) | (bArr[4] & 255)) & 4294967295L) << 32) | (4294967295L & (((bArr[1] & 255) << 8) | ((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | (bArr[0] & 255)));
        }
        throw new EOFException();
    }
}
