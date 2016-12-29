package com.baidu.adp.lib.webSocket;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a extends OutputStream {
    private final int sY;
    private final int sZ;
    private ByteBuffer tb;

    public a() {
        this(131072, 65536);
    }

    public a(int i, int i2) {
        this.sY = i;
        this.sZ = i2;
        this.tb = ByteBuffer.allocateDirect(this.sY);
        this.tb.clear();
    }

    public ByteBuffer gT() {
        return this.tb;
    }

    public Buffer flip() {
        return this.tb.flip();
    }

    public Buffer clear() {
        return this.tb.clear();
    }

    public int remaining() {
        return this.tb.remaining();
    }

    public synchronized void aB(int i) {
        if (i > this.tb.capacity()) {
            ByteBuffer byteBuffer = this.tb;
            int position = this.tb.position();
            this.tb = ByteBuffer.allocateDirect(((i / this.sZ) + 1) * this.sZ);
            byteBuffer.clear();
            this.tb.clear();
            this.tb.put(byteBuffer);
            this.tb.position(position);
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) throws IOException {
        if (this.tb.position() + 1 > this.tb.capacity()) {
            aB(this.tb.capacity() + 1);
        }
        this.tb.put((byte) i);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.tb.position() + i2 > this.tb.capacity()) {
            aB(this.tb.capacity() + i2);
        }
        this.tb.put(bArr, i, i2);
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
