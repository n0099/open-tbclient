package com.baidu.adp.lib.webSocket;

import com.tencent.mm.sdk.contact.RContact;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class b extends FilterOutputStream {

    /* renamed from: a  reason: collision with root package name */
    private boolean f462a;
    private int b;
    private byte[] c;
    private int d;
    private int e;
    private boolean f;
    private byte[] g;
    private boolean h;
    private int i;
    private byte[] j;

    public b(OutputStream outputStream, int i) {
        super(outputStream);
        byte[] c;
        this.f = (i & 8) != 0;
        this.f462a = (i & 1) != 0;
        this.d = this.f462a ? 3 : 4;
        this.c = new byte[this.d];
        this.b = 0;
        this.e = 0;
        this.h = false;
        this.g = new byte[4];
        this.i = i;
        c = a.c(i);
        this.j = c;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) {
        int b;
        byte[] b2;
        if (this.h) {
            this.out.write(i);
        } else if (this.f462a) {
            byte[] bArr = this.c;
            int i2 = this.b;
            this.b = i2 + 1;
            bArr[i2] = (byte) i;
            if (this.b >= this.d) {
                OutputStream outputStream = this.out;
                b2 = a.b(this.g, this.c, this.d, this.i);
                outputStream.write(b2);
                this.e += 4;
                if (this.f && this.e >= 76) {
                    this.out.write(10);
                    this.e = 0;
                }
                this.b = 0;
            }
        } else if (this.j[i & RContact.MM_CONTACTFLAG_ALL] > -5) {
            byte[] bArr2 = this.c;
            int i3 = this.b;
            this.b = i3 + 1;
            bArr2[i3] = (byte) i;
            if (this.b >= this.d) {
                b = a.b(this.c, 0, this.g, 0, this.i);
                this.out.write(this.g, 0, b);
                this.b = 0;
            }
        } else if (this.j[i & RContact.MM_CONTACTFLAG_ALL] != -5) {
            throw new IOException("Invalid character in Base64 data.");
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        if (this.h) {
            this.out.write(bArr, i, i2);
            return;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            write(bArr[i + i3]);
        }
    }

    public void a() {
        byte[] b;
        if (this.b > 0) {
            if (this.f462a) {
                OutputStream outputStream = this.out;
                b = a.b(this.g, this.c, this.b, this.i);
                outputStream.write(b);
                this.b = 0;
                return;
            }
            throw new IOException("Base64 input not properly padded.");
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
        super.close();
        this.c = null;
        this.out = null;
    }
}
