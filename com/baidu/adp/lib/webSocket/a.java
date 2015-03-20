package com.baidu.adp.lib.webSocket;

import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a extends OutputStream {
    private final int zL;
    private final int zM;
    private ByteBuffer zN;

    public a() {
        this(131072, 65536);
    }

    public a(int i, int i2) {
        this.zL = i;
        this.zM = i2;
        this.zN = ByteBuffer.allocateDirect(this.zL);
        this.zN.clear();
    }

    public ByteBuffer jk() {
        return this.zN;
    }

    public Buffer flip() {
        return this.zN.flip();
    }

    public Buffer clear() {
        return this.zN.clear();
    }

    public int remaining() {
        return this.zN.remaining();
    }

    public synchronized void al(int i) {
        if (i > this.zN.capacity()) {
            ByteBuffer byteBuffer = this.zN;
            int position = this.zN.position();
            this.zN = ByteBuffer.allocateDirect(((i / this.zM) + 1) * this.zM);
            byteBuffer.clear();
            this.zN.clear();
            this.zN.put(byteBuffer);
            this.zN.position(position);
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) {
        if (this.zN.position() + 1 > this.zN.capacity()) {
            al(this.zN.capacity() + 1);
        }
        this.zN.put((byte) i);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        if (this.zN.position() + i2 > this.zN.capacity()) {
            al(this.zN.capacity() + i2);
        }
        this.zN.put(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public synchronized void write(String str) {
        write(str.getBytes("UTF-8"));
    }

    public synchronized void jl() {
        write(13);
        write(10);
    }
}
