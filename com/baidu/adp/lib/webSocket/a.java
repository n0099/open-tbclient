package com.baidu.adp.lib.webSocket;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a extends OutputStream {
    private final int sP;
    private final int sQ;
    private ByteBuffer sR;

    public a() {
        this(131072, 65536);
    }

    public a(int i, int i2) {
        this.sP = i;
        this.sQ = i2;
        this.sR = ByteBuffer.allocateDirect(this.sP);
        this.sR.clear();
    }

    public ByteBuffer gR() {
        return this.sR;
    }

    public Buffer flip() {
        return this.sR.flip();
    }

    public Buffer clear() {
        return this.sR.clear();
    }

    public int remaining() {
        return this.sR.remaining();
    }

    public synchronized void aB(int i) {
        if (i > this.sR.capacity()) {
            ByteBuffer byteBuffer = this.sR;
            int position = this.sR.position();
            this.sR = ByteBuffer.allocateDirect(((i / this.sQ) + 1) * this.sQ);
            byteBuffer.clear();
            this.sR.clear();
            this.sR.put(byteBuffer);
            this.sR.position(position);
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) throws IOException {
        if (this.sR.position() + 1 > this.sR.capacity()) {
            aB(this.sR.capacity() + 1);
        }
        this.sR.put((byte) i);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.sR.position() + i2 > this.sR.capacity()) {
            aB(this.sR.capacity() + i2);
        }
        this.sR.put(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public synchronized void write(String str) throws IOException {
        write(str.getBytes("UTF-8"));
    }

    public synchronized void gS() throws IOException {
        write(13);
        write(10);
    }
}
