package com.baidu.adp.lib.webSocket;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a extends OutputStream {
    private final int QP;
    private final int QR;
    private ByteBuffer mBuffer;

    public a() {
        this(131072, 65536);
    }

    public a(int i, int i2) {
        this.QP = i;
        this.QR = i2;
        this.mBuffer = ByteBuffer.allocateDirect(this.QP);
        this.mBuffer.clear();
    }

    public ByteBuffer getBuffer() {
        return this.mBuffer;
    }

    public Buffer ou() {
        return this.mBuffer.flip();
    }

    public Buffer ov() {
        return this.mBuffer.clear();
    }

    public int ow() {
        return this.mBuffer.remaining();
    }

    public synchronized void aG(int i) {
        if (i > this.mBuffer.capacity()) {
            ByteBuffer byteBuffer = this.mBuffer;
            int position = this.mBuffer.position();
            this.mBuffer = ByteBuffer.allocateDirect(((i / this.QR) + 1) * this.QR);
            byteBuffer.clear();
            this.mBuffer.clear();
            this.mBuffer.put(byteBuffer);
            this.mBuffer.position(position);
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) throws IOException {
        if (this.mBuffer.position() + 1 > this.mBuffer.capacity()) {
            aG(this.mBuffer.capacity() + 1);
        }
        this.mBuffer.put((byte) i);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.mBuffer.position() + i2 > this.mBuffer.capacity()) {
            aG(this.mBuffer.capacity() + i2);
        }
        this.mBuffer.put(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public synchronized void write(String str) throws IOException {
        write(str.getBytes("UTF-8"));
    }

    public synchronized void ox() throws IOException {
        write(13);
        write(10);
    }
}
