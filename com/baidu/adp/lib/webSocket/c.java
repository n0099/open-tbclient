package com.baidu.adp.lib.webSocket;

import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class c extends OutputStream {
    private final int oT;
    private final int oU;
    private ByteBuffer oV;

    public c() {
        this(131072, 65536);
    }

    public c(int i, int i2) {
        this.oT = i;
        this.oU = i2;
        this.oV = ByteBuffer.allocateDirect(this.oT);
        this.oV.clear();
    }

    public ByteBuffer fP() {
        return this.oV;
    }

    public Buffer flip() {
        return this.oV.flip();
    }

    public Buffer clear() {
        return this.oV.clear();
    }

    public int remaining() {
        return this.oV.remaining();
    }

    public synchronized void ai(int i) {
        if (i > this.oV.capacity()) {
            ByteBuffer byteBuffer = this.oV;
            int position = this.oV.position();
            this.oV = ByteBuffer.allocateDirect(((i / this.oU) + 1) * this.oU);
            byteBuffer.clear();
            this.oV.clear();
            this.oV.put(byteBuffer);
            this.oV.position(position);
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) {
        if (this.oV.position() + 1 > this.oV.capacity()) {
            ai(this.oV.capacity() + 1);
        }
        this.oV.put((byte) i);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        if (this.oV.position() + i2 > this.oV.capacity()) {
            ai(this.oV.capacity() + i2);
        }
        this.oV.put(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public synchronized void write(String str) {
        write(str.getBytes("UTF-8"));
    }

    public synchronized void fQ() {
        write(13);
        write(10);
    }
}
