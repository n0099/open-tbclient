package com.baidu.adp.lib.util;

import android.support.v4.media.TransportMediator;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class d extends FilterOutputStream {
    private byte[] buffer;
    private int position;
    private boolean xZ;
    private int ya;
    private int yb;
    private boolean yc;
    private byte[] yd;
    private boolean ye;
    private int yf;
    private byte[] yg;

    public d(OutputStream outputStream, int i) {
        super(outputStream);
        byte[] ad;
        this.yc = (i & 8) != 0;
        this.xZ = (i & 1) != 0;
        this.ya = this.xZ ? 3 : 4;
        this.buffer = new byte[this.ya];
        this.position = 0;
        this.yb = 0;
        this.ye = false;
        this.yd = new byte[4];
        this.yf = i;
        ad = c.ad(i);
        this.yg = ad;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) {
        int a;
        byte[] a2;
        if (this.ye) {
            this.out.write(i);
        } else if (this.xZ) {
            byte[] bArr = this.buffer;
            int i2 = this.position;
            this.position = i2 + 1;
            bArr[i2] = (byte) i;
            if (this.position >= this.ya) {
                OutputStream outputStream = this.out;
                a2 = c.a(this.yd, this.buffer, this.ya, this.yf);
                outputStream.write(a2);
                this.yb += 4;
                if (this.yc && this.yb >= 76) {
                    this.out.write(10);
                    this.yb = 0;
                }
                this.position = 0;
            }
        } else if (this.yg[i & TransportMediator.KEYCODE_MEDIA_PAUSE] > -5) {
            byte[] bArr2 = this.buffer;
            int i3 = this.position;
            this.position = i3 + 1;
            bArr2[i3] = (byte) i;
            if (this.position >= this.ya) {
                a = c.a(this.buffer, 0, this.yd, 0, this.yf);
                this.out.write(this.yd, 0, a);
                this.position = 0;
            }
        } else if (this.yg[i & TransportMediator.KEYCODE_MEDIA_PAUSE] != -5) {
            throw new IOException("Invalid character in Base64 data.");
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        if (this.ye) {
            this.out.write(bArr, i, i2);
            return;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            write(bArr[i + i3]);
        }
    }

    public void is() {
        byte[] a;
        if (this.position > 0) {
            if (this.xZ) {
                OutputStream outputStream = this.out;
                a = c.a(this.yd, this.buffer, this.position, this.yf);
                outputStream.write(a);
                this.position = 0;
                return;
            }
            throw new IOException("Base64 input not properly padded.");
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        is();
        super.close();
        this.buffer = null;
        this.out = null;
    }
}
