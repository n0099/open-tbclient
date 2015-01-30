package com.baidu.adp.lib.webSocket;

import android.support.v4.media.TransportMediator;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class b extends FilterOutputStream {
    private byte[] buffer;
    private boolean oQ;
    private int oR;
    private int oS;
    private boolean oT;
    private byte[] oU;
    private boolean oV;
    private int oW;
    private byte[] oX;
    private int position;

    public b(OutputStream outputStream, int i) {
        super(outputStream);
        byte[] al;
        this.oT = (i & 8) != 0;
        this.oQ = (i & 1) != 0;
        this.oR = this.oQ ? 3 : 4;
        this.buffer = new byte[this.oR];
        this.position = 0;
        this.oS = 0;
        this.oV = false;
        this.oU = new byte[4];
        this.oW = i;
        al = a.al(i);
        this.oX = al;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) {
        int a;
        byte[] a2;
        if (this.oV) {
            this.out.write(i);
        } else if (this.oQ) {
            byte[] bArr = this.buffer;
            int i2 = this.position;
            this.position = i2 + 1;
            bArr[i2] = (byte) i;
            if (this.position >= this.oR) {
                OutputStream outputStream = this.out;
                a2 = a.a(this.oU, this.buffer, this.oR, this.oW);
                outputStream.write(a2);
                this.oS += 4;
                if (this.oT && this.oS >= 76) {
                    this.out.write(10);
                    this.oS = 0;
                }
                this.position = 0;
            }
        } else if (this.oX[i & TransportMediator.KEYCODE_MEDIA_PAUSE] > -5) {
            byte[] bArr2 = this.buffer;
            int i3 = this.position;
            this.position = i3 + 1;
            bArr2[i3] = (byte) i;
            if (this.position >= this.oR) {
                a = a.a(this.buffer, 0, this.oU, 0, this.oW);
                this.out.write(this.oU, 0, a);
                this.position = 0;
            }
        } else if (this.oX[i & TransportMediator.KEYCODE_MEDIA_PAUSE] != -5) {
            throw new IOException("Invalid character in Base64 data.");
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        if (this.oV) {
            this.out.write(bArr, i, i2);
            return;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            write(bArr[i + i3]);
        }
    }

    public void fN() {
        byte[] a;
        if (this.position > 0) {
            if (this.oQ) {
                OutputStream outputStream = this.out;
                a = a.a(this.oU, this.buffer, this.position, this.oW);
                outputStream.write(a);
                this.position = 0;
                return;
            }
            throw new IOException("Base64 input not properly padded.");
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        fN();
        super.close();
        this.buffer = null;
        this.out = null;
    }
}
