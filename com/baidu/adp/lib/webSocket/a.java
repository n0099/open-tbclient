package com.baidu.adp.lib.webSocket;

import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a extends OutputStream {
    private final int zl;
    private final int zm;
    private ByteBuffer zn;

    public a() {
        this(131072, 65536);
    }

    public a(int i, int i2) {
        this.zl = i;
        this.zm = i2;
        this.zn = ByteBuffer.allocateDirect(this.zl);
        this.zn.clear();
    }

    public ByteBuffer ju() {
        return this.zn;
    }

    public Buffer flip() {
        return this.zn.flip();
    }

    public Buffer clear() {
        return this.zn.clear();
    }

    public int remaining() {
        return this.zn.remaining();
    }

    public synchronized void al(int i) {
        if (i > this.zn.capacity()) {
            ByteBuffer byteBuffer = this.zn;
            int position = this.zn.position();
            this.zn = ByteBuffer.allocateDirect(((i / this.zm) + 1) * this.zm);
            byteBuffer.clear();
            this.zn.clear();
            this.zn.put(byteBuffer);
            this.zn.position(position);
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) {
        if (this.zn.position() + 1 > this.zn.capacity()) {
            al(this.zn.capacity() + 1);
        }
        this.zn.put((byte) i);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        if (this.zn.position() + i2 > this.zn.capacity()) {
            al(this.zn.capacity() + i2);
        }
        this.zn.put(bArr, i, i2);
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
