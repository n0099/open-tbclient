package com.baidu.adp.lib.webSocket;

import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a extends OutputStream {
    private final int qf;
    private final int qg;
    private ByteBuffer qh;

    public a() {
        this(131072, 65536);
    }

    public a(int i, int i2) {
        this.qf = i;
        this.qg = i2;
        this.qh = ByteBuffer.allocateDirect(this.qf);
        this.qh.clear();
    }

    public ByteBuffer fY() {
        return this.qh;
    }

    public Buffer flip() {
        return this.qh.flip();
    }

    public Buffer clear() {
        return this.qh.clear();
    }

    public int remaining() {
        return this.qh.remaining();
    }

    public synchronized void ak(int i) {
        if (i > this.qh.capacity()) {
            ByteBuffer byteBuffer = this.qh;
            int position = this.qh.position();
            this.qh = ByteBuffer.allocateDirect(((i / this.qg) + 1) * this.qg);
            byteBuffer.clear();
            this.qh.clear();
            this.qh.put(byteBuffer);
            this.qh.position(position);
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) {
        if (this.qh.position() + 1 > this.qh.capacity()) {
            ak(this.qh.capacity() + 1);
        }
        this.qh.put((byte) i);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        if (this.qh.position() + i2 > this.qh.capacity()) {
            ak(this.qh.capacity() + i2);
        }
        this.qh.put(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public synchronized void write(String str) {
        write(str.getBytes("UTF-8"));
    }

    public synchronized void fZ() {
        write(13);
        write(10);
    }
}
