package com.baidu.adp.lib.webSocket;

import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a extends OutputStream {
    private final int zk;
    private final int zl;
    private ByteBuffer zm;

    public a() {
        this(131072, 65536);
    }

    public a(int i, int i2) {
        this.zk = i;
        this.zl = i2;
        this.zm = ByteBuffer.allocateDirect(this.zk);
        this.zm.clear();
    }

    public ByteBuffer js() {
        return this.zm;
    }

    public Buffer flip() {
        return this.zm.flip();
    }

    public Buffer clear() {
        return this.zm.clear();
    }

    public int remaining() {
        return this.zm.remaining();
    }

    public synchronized void al(int i) {
        if (i > this.zm.capacity()) {
            ByteBuffer byteBuffer = this.zm;
            int position = this.zm.position();
            this.zm = ByteBuffer.allocateDirect(((i / this.zl) + 1) * this.zl);
            byteBuffer.clear();
            this.zm.clear();
            this.zm.put(byteBuffer);
            this.zm.position(position);
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) {
        if (this.zm.position() + 1 > this.zm.capacity()) {
            al(this.zm.capacity() + 1);
        }
        this.zm.put((byte) i);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        if (this.zm.position() + i2 > this.zm.capacity()) {
            al(this.zm.capacity() + i2);
        }
        this.zm.put(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public synchronized void write(String str) {
        write(str.getBytes("UTF-8"));
    }

    public synchronized void jt() {
        write(13);
        write(10);
    }
}
