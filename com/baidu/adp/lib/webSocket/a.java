package com.baidu.adp.lib.webSocket;

import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a extends OutputStream {
    private final int zj;
    private final int zk;
    private ByteBuffer zl;

    public a() {
        this(131072, 65536);
    }

    public a(int i, int i2) {
        this.zj = i;
        this.zk = i2;
        this.zl = ByteBuffer.allocateDirect(this.zj);
        this.zl.clear();
    }

    public ByteBuffer jr() {
        return this.zl;
    }

    public Buffer flip() {
        return this.zl.flip();
    }

    public Buffer clear() {
        return this.zl.clear();
    }

    public int remaining() {
        return this.zl.remaining();
    }

    public synchronized void al(int i) {
        if (i > this.zl.capacity()) {
            ByteBuffer byteBuffer = this.zl;
            int position = this.zl.position();
            this.zl = ByteBuffer.allocateDirect(((i / this.zk) + 1) * this.zk);
            byteBuffer.clear();
            this.zl.clear();
            this.zl.put(byteBuffer);
            this.zl.position(position);
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) {
        if (this.zl.position() + 1 > this.zl.capacity()) {
            al(this.zl.capacity() + 1);
        }
        this.zl.put((byte) i);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        if (this.zl.position() + i2 > this.zl.capacity()) {
            al(this.zl.capacity() + i2);
        }
        this.zl.put(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public synchronized void write(String str) {
        write(str.getBytes("UTF-8"));
    }

    public synchronized void js() {
        write(13);
        write(10);
    }
}
