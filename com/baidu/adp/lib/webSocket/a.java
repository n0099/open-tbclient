package com.baidu.adp.lib.webSocket;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a extends OutputStream {
    private final int NX;
    private final int NY;
    private ByteBuffer mBuffer;

    public a() {
        this(131072, 65536);
    }

    public a(int i, int i2) {
        this.NX = i;
        this.NY = i2;
        this.mBuffer = ByteBuffer.allocateDirect(this.NX);
        this.mBuffer.clear();
    }

    public ByteBuffer my() {
        return this.mBuffer;
    }

    public Buffer mz() {
        return this.mBuffer.flip();
    }

    public Buffer mA() {
        return this.mBuffer.clear();
    }

    public int mB() {
        return this.mBuffer.remaining();
    }

    public synchronized void expand(int i) {
        if (i > this.mBuffer.capacity()) {
            ByteBuffer byteBuffer = this.mBuffer;
            int position = this.mBuffer.position();
            this.mBuffer = ByteBuffer.allocateDirect(((i / this.NY) + 1) * this.NY);
            byteBuffer.clear();
            this.mBuffer.clear();
            this.mBuffer.put(byteBuffer);
            this.mBuffer.position(position);
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) throws IOException {
        if (this.mBuffer.position() + 1 > this.mBuffer.capacity()) {
            expand(this.mBuffer.capacity() + 1);
        }
        this.mBuffer.put((byte) i);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.mBuffer.position() + i2 > this.mBuffer.capacity()) {
            expand(this.mBuffer.capacity() + i2);
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

    public synchronized void mC() throws IOException {
        write(13);
        write(10);
    }
}
