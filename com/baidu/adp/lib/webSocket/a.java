package com.baidu.adp.lib.webSocket;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a extends OutputStream {
    private final int qH;
    private final int qI;
    private ByteBuffer qJ;

    public a() {
        this(131072, 65536);
    }

    public a(int i, int i2) {
        this.qH = i;
        this.qI = i2;
        this.qJ = ByteBuffer.allocateDirect(this.qH);
        this.qJ.clear();
    }

    public ByteBuffer fX() {
        return this.qJ;
    }

    public Buffer flip() {
        return this.qJ.flip();
    }

    public Buffer clear() {
        return this.qJ.clear();
    }

    public int remaining() {
        return this.qJ.remaining();
    }

    public synchronized void an(int i) {
        if (i > this.qJ.capacity()) {
            ByteBuffer byteBuffer = this.qJ;
            int position = this.qJ.position();
            this.qJ = ByteBuffer.allocateDirect(((i / this.qI) + 1) * this.qI);
            byteBuffer.clear();
            this.qJ.clear();
            this.qJ.put(byteBuffer);
            this.qJ.position(position);
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) throws IOException {
        if (this.qJ.position() + 1 > this.qJ.capacity()) {
            an(this.qJ.capacity() + 1);
        }
        this.qJ.put((byte) i);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.qJ.position() + i2 > this.qJ.capacity()) {
            an(this.qJ.capacity() + i2);
        }
        this.qJ.put(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public synchronized void write(String str) throws IOException {
        write(str.getBytes("UTF-8"));
    }

    public synchronized void fY() throws IOException {
        write(13);
        write(10);
    }
}
