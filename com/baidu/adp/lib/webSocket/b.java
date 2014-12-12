package com.baidu.adp.lib.webSocket;

import android.support.v4.media.TransportMediator;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class b extends FilterOutputStream {
    private byte[] buffer;
    private boolean oL;
    private int oM;
    private int oN;
    private boolean oO;
    private byte[] oP;
    private boolean oQ;
    private int oR;
    private byte[] oS;
    private int position;

    public b(OutputStream outputStream, int i) {
        super(outputStream);
        byte[] ag;
        this.oO = (i & 8) != 0;
        this.oL = (i & 1) != 0;
        this.oM = this.oL ? 3 : 4;
        this.buffer = new byte[this.oM];
        this.position = 0;
        this.oN = 0;
        this.oQ = false;
        this.oP = new byte[4];
        this.oR = i;
        ag = a.ag(i);
        this.oS = ag;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) {
        int a;
        byte[] a2;
        if (this.oQ) {
            this.out.write(i);
        } else if (this.oL) {
            byte[] bArr = this.buffer;
            int i2 = this.position;
            this.position = i2 + 1;
            bArr[i2] = (byte) i;
            if (this.position >= this.oM) {
                OutputStream outputStream = this.out;
                a2 = a.a(this.oP, this.buffer, this.oM, this.oR);
                outputStream.write(a2);
                this.oN += 4;
                if (this.oO && this.oN >= 76) {
                    this.out.write(10);
                    this.oN = 0;
                }
                this.position = 0;
            }
        } else if (this.oS[i & TransportMediator.KEYCODE_MEDIA_PAUSE] > -5) {
            byte[] bArr2 = this.buffer;
            int i3 = this.position;
            this.position = i3 + 1;
            bArr2[i3] = (byte) i;
            if (this.position >= this.oM) {
                a = a.a(this.buffer, 0, this.oP, 0, this.oR);
                this.out.write(this.oP, 0, a);
                this.position = 0;
            }
        } else if (this.oS[i & TransportMediator.KEYCODE_MEDIA_PAUSE] != -5) {
            throw new IOException("Invalid character in Base64 data.");
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        if (this.oQ) {
            this.out.write(bArr, i, i2);
            return;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            write(bArr[i + i3]);
        }
    }

    public void fO() {
        byte[] a;
        if (this.position > 0) {
            if (this.oL) {
                OutputStream outputStream = this.out;
                a = a.a(this.oP, this.buffer, this.position, this.oR);
                outputStream.write(a);
                this.position = 0;
                return;
            }
            throw new IOException("Base64 input not properly padded.");
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        fO();
        super.close();
        this.buffer = null;
        this.out = null;
    }
}
