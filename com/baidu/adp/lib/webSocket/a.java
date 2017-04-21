package com.baidu.adp.lib.webSocket;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a extends OutputStream {
    private final int zK;
    private final int zL;
    private ByteBuffer zM;

    public a() {
        this(131072, 65536);
    }

    public a(int i, int i2) {
        this.zK = i;
        this.zL = i2;
        this.zM = ByteBuffer.allocateDirect(this.zK);
        this.zM.clear();
    }

    public ByteBuffer hR() {
        return this.zM;
    }

    public Buffer flip() {
        return this.zM.flip();
    }

    public Buffer clear() {
        return this.zM.clear();
    }

    public int remaining() {
        return this.zM.remaining();
    }

    public synchronized void aA(int i) {
        if (i > this.zM.capacity()) {
            ByteBuffer byteBuffer = this.zM;
            int position = this.zM.position();
            this.zM = ByteBuffer.allocateDirect(((i / this.zL) + 1) * this.zL);
            byteBuffer.clear();
            this.zM.clear();
            this.zM.put(byteBuffer);
            this.zM.position(position);
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) throws IOException {
        if (this.zM.position() + 1 > this.zM.capacity()) {
            aA(this.zM.capacity() + 1);
        }
        this.zM.put((byte) i);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.zM.position() + i2 > this.zM.capacity()) {
            aA(this.zM.capacity() + i2);
        }
        this.zM.put(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public synchronized void write(String str) throws IOException {
        write(str.getBytes("UTF-8"));
    }

    public synchronized void hS() throws IOException {
        write(13);
        write(10);
    }
}
