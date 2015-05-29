package com.baidu.adp.lib.util;

import android.support.v4.media.TransportMediator;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class d extends FilterOutputStream {
    private byte[] buffer;
    private int position;
    private boolean xO;
    private int xP;
    private int xQ;
    private boolean xR;
    private byte[] xS;
    private boolean xT;
    private int xU;
    private byte[] xV;

    public d(OutputStream outputStream, int i) {
        super(outputStream);
        byte[] ab;
        this.xR = (i & 8) != 0;
        this.xO = (i & 1) != 0;
        this.xP = this.xO ? 3 : 4;
        this.buffer = new byte[this.xP];
        this.position = 0;
        this.xQ = 0;
        this.xT = false;
        this.xS = new byte[4];
        this.xU = i;
        ab = c.ab(i);
        this.xV = ab;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) {
        int a;
        byte[] a2;
        if (this.xT) {
            this.out.write(i);
        } else if (this.xO) {
            byte[] bArr = this.buffer;
            int i2 = this.position;
            this.position = i2 + 1;
            bArr[i2] = (byte) i;
            if (this.position >= this.xP) {
                OutputStream outputStream = this.out;
                a2 = c.a(this.xS, this.buffer, this.xP, this.xU);
                outputStream.write(a2);
                this.xQ += 4;
                if (this.xR && this.xQ >= 76) {
                    this.out.write(10);
                    this.xQ = 0;
                }
                this.position = 0;
            }
        } else if (this.xV[i & TransportMediator.KEYCODE_MEDIA_PAUSE] > -5) {
            byte[] bArr2 = this.buffer;
            int i3 = this.position;
            this.position = i3 + 1;
            bArr2[i3] = (byte) i;
            if (this.position >= this.xP) {
                a = c.a(this.buffer, 0, this.xS, 0, this.xU);
                this.out.write(this.xS, 0, a);
                this.position = 0;
            }
        } else if (this.xV[i & TransportMediator.KEYCODE_MEDIA_PAUSE] != -5) {
            throw new IOException("Invalid character in Base64 data.");
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        if (this.xT) {
            this.out.write(bArr, i, i2);
            return;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            write(bArr[i + i3]);
        }
    }

    public void iJ() {
        byte[] a;
        if (this.position > 0) {
            if (this.xO) {
                OutputStream outputStream = this.out;
                a = c.a(this.xS, this.buffer, this.position, this.xU);
                outputStream.write(a);
                this.position = 0;
                return;
            }
            throw new IOException("Base64 input not properly padded.");
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        iJ();
        super.close();
        this.buffer = null;
        this.out = null;
    }
}
