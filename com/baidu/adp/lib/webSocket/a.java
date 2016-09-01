package com.baidu.adp.lib.webSocket;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a extends OutputStream {
    private final int sX;
    private final int sY;
    private ByteBuffer sZ;

    public a() {
        this(131072, 65536);
    }

    public a(int i, int i2) {
        this.sX = i;
        this.sY = i2;
        this.sZ = ByteBuffer.allocateDirect(this.sX);
        this.sZ.clear();
    }

    public ByteBuffer gT() {
        return this.sZ;
    }

    public Buffer flip() {
        return this.sZ.flip();
    }

    public Buffer clear() {
        return this.sZ.clear();
    }

    public int remaining() {
        return this.sZ.remaining();
    }

    public synchronized void aA(int i) {
        if (i > this.sZ.capacity()) {
            ByteBuffer byteBuffer = this.sZ;
            int position = this.sZ.position();
            this.sZ = ByteBuffer.allocateDirect(((i / this.sY) + 1) * this.sY);
            byteBuffer.clear();
            this.sZ.clear();
            this.sZ.put(byteBuffer);
            this.sZ.position(position);
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) throws IOException {
        if (this.sZ.position() + 1 > this.sZ.capacity()) {
            aA(this.sZ.capacity() + 1);
        }
        this.sZ.put((byte) i);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.sZ.position() + i2 > this.sZ.capacity()) {
            aA(this.sZ.capacity() + i2);
        }
        this.sZ.put(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public synchronized void write(String str) throws IOException {
        write(str.getBytes("UTF-8"));
    }

    public synchronized void gU() throws IOException {
        write(13);
        write(10);
    }
}
