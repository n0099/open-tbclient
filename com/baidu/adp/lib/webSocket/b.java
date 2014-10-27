package com.baidu.adp.lib.webSocket;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class b extends FilterOutputStream {
    private byte[] buffer;
    private boolean oM;
    private int oN;
    private int oO;
    private boolean oP;
    private byte[] oQ;
    private boolean oR;
    private int oS;
    private byte[] oT;
    private int position;

    public b(OutputStream outputStream, int i) {
        super(outputStream);
        byte[] Y;
        this.oP = (i & 8) != 0;
        this.oM = (i & 1) != 0;
        this.oN = this.oM ? 3 : 4;
        this.buffer = new byte[this.oN];
        this.position = 0;
        this.oO = 0;
        this.oR = false;
        this.oQ = new byte[4];
        this.oS = i;
        Y = a.Y(i);
        this.oT = Y;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) {
        int a;
        byte[] a2;
        if (this.oR) {
            this.out.write(i);
        } else if (this.oM) {
            byte[] bArr = this.buffer;
            int i2 = this.position;
            this.position = i2 + 1;
            bArr[i2] = (byte) i;
            if (this.position >= this.oN) {
                OutputStream outputStream = this.out;
                a2 = a.a(this.oQ, this.buffer, this.oN, this.oS);
                outputStream.write(a2);
                this.oO += 4;
                if (this.oP && this.oO >= 76) {
                    this.out.write(10);
                    this.oO = 0;
                }
                this.position = 0;
            }
        } else if (this.oT[i & 127] > -5) {
            byte[] bArr2 = this.buffer;
            int i3 = this.position;
            this.position = i3 + 1;
            bArr2[i3] = (byte) i;
            if (this.position >= this.oN) {
                a = a.a(this.buffer, 0, this.oQ, 0, this.oS);
                this.out.write(this.oQ, 0, a);
                this.position = 0;
            }
        } else if (this.oT[i & 127] != -5) {
            throw new IOException("Invalid character in Base64 data.");
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        if (this.oR) {
            this.out.write(bArr, i, i2);
            return;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            write(bArr[i + i3]);
        }
    }

    public void fM() {
        byte[] a;
        if (this.position > 0) {
            if (this.oM) {
                OutputStream outputStream = this.out;
                a = a.a(this.oQ, this.buffer, this.position, this.oS);
                outputStream.write(a);
                this.position = 0;
                return;
            }
            throw new IOException("Base64 input not properly padded.");
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        fM();
        super.close();
        this.buffer = null;
        this.out = null;
    }
}
