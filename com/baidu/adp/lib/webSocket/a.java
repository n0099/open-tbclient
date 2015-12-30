package com.baidu.adp.lib.webSocket;

import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a extends OutputStream {
    private final int zs;
    private final int zt;
    private ByteBuffer zu;

    public a() {
        this(131072, 65536);
    }

    public a(int i, int i2) {
        this.zs = i;
        this.zt = i2;
        this.zu = ByteBuffer.allocateDirect(this.zs);
        this.zu.clear();
    }

    public ByteBuffer jv() {
        return this.zu;
    }

    public Buffer flip() {
        return this.zu.flip();
    }

    public Buffer clear() {
        return this.zu.clear();
    }

    public int remaining() {
        return this.zu.remaining();
    }

    public synchronized void am(int i) {
        if (i > this.zu.capacity()) {
            ByteBuffer byteBuffer = this.zu;
            int position = this.zu.position();
            this.zu = ByteBuffer.allocateDirect(((i / this.zt) + 1) * this.zt);
            byteBuffer.clear();
            this.zu.clear();
            this.zu.put(byteBuffer);
            this.zu.position(position);
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) {
        if (this.zu.position() + 1 > this.zu.capacity()) {
            am(this.zu.capacity() + 1);
        }
        this.zu.put((byte) i);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        if (this.zu.position() + i2 > this.zu.capacity()) {
            am(this.zu.capacity() + i2);
        }
        this.zu.put(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public synchronized void write(String str) {
        write(str.getBytes("UTF-8"));
    }

    public synchronized void jw() {
        write(13);
        write(10);
    }
}
