package com.baidu.adp.lib.webSocket;

import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a extends OutputStream {
    private final int zq;
    private final int zr;
    private ByteBuffer zs;

    public a() {
        this(131072, 65536);
    }

    public a(int i, int i2) {
        this.zq = i;
        this.zr = i2;
        this.zs = ByteBuffer.allocateDirect(this.zq);
        this.zs.clear();
    }

    public ByteBuffer ju() {
        return this.zs;
    }

    public Buffer flip() {
        return this.zs.flip();
    }

    public Buffer clear() {
        return this.zs.clear();
    }

    public int remaining() {
        return this.zs.remaining();
    }

    public synchronized void am(int i) {
        if (i > this.zs.capacity()) {
            ByteBuffer byteBuffer = this.zs;
            int position = this.zs.position();
            this.zs = ByteBuffer.allocateDirect(((i / this.zr) + 1) * this.zr);
            byteBuffer.clear();
            this.zs.clear();
            this.zs.put(byteBuffer);
            this.zs.position(position);
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) {
        if (this.zs.position() + 1 > this.zs.capacity()) {
            am(this.zs.capacity() + 1);
        }
        this.zs.put((byte) i);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        if (this.zs.position() + i2 > this.zs.capacity()) {
            am(this.zs.capacity() + i2);
        }
        this.zs.put(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public synchronized void write(String str) {
        write(str.getBytes("UTF-8"));
    }

    public synchronized void jv() {
        write(13);
        write(10);
    }
}
