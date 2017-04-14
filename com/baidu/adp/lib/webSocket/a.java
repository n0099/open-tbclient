package com.baidu.adp.lib.webSocket;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a extends OutputStream {
    private final int zH;
    private final int zI;
    private ByteBuffer zJ;

    public a() {
        this(131072, 65536);
    }

    public a(int i, int i2) {
        this.zH = i;
        this.zI = i2;
        this.zJ = ByteBuffer.allocateDirect(this.zH);
        this.zJ.clear();
    }

    public ByteBuffer hQ() {
        return this.zJ;
    }

    public Buffer flip() {
        return this.zJ.flip();
    }

    public Buffer clear() {
        return this.zJ.clear();
    }

    public int remaining() {
        return this.zJ.remaining();
    }

    public synchronized void aA(int i) {
        if (i > this.zJ.capacity()) {
            ByteBuffer byteBuffer = this.zJ;
            int position = this.zJ.position();
            this.zJ = ByteBuffer.allocateDirect(((i / this.zI) + 1) * this.zI);
            byteBuffer.clear();
            this.zJ.clear();
            this.zJ.put(byteBuffer);
            this.zJ.position(position);
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) throws IOException {
        if (this.zJ.position() + 1 > this.zJ.capacity()) {
            aA(this.zJ.capacity() + 1);
        }
        this.zJ.put((byte) i);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.zJ.position() + i2 > this.zJ.capacity()) {
            aA(this.zJ.capacity() + i2);
        }
        this.zJ.put(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public synchronized void write(String str) throws IOException {
        write(str.getBytes("UTF-8"));
    }

    public synchronized void hR() throws IOException {
        write(13);
        write(10);
    }
}
