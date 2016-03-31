package com.baidu.adp.lib.webSocket;

import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a extends OutputStream {
    private final int zS;
    private final int zT;
    private ByteBuffer zU;

    public a() {
        this(131072, 65536);
    }

    public a(int i, int i2) {
        this.zS = i;
        this.zT = i2;
        this.zU = ByteBuffer.allocateDirect(this.zS);
        this.zU.clear();
    }

    public ByteBuffer jK() {
        return this.zU;
    }

    public Buffer flip() {
        return this.zU.flip();
    }

    public Buffer clear() {
        return this.zU.clear();
    }

    public int remaining() {
        return this.zU.remaining();
    }

    public synchronized void expand(int i) {
        if (i > this.zU.capacity()) {
            ByteBuffer byteBuffer = this.zU;
            int position = this.zU.position();
            this.zU = ByteBuffer.allocateDirect(((i / this.zT) + 1) * this.zT);
            byteBuffer.clear();
            this.zU.clear();
            this.zU.put(byteBuffer);
            this.zU.position(position);
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) {
        if (this.zU.position() + 1 > this.zU.capacity()) {
            expand(this.zU.capacity() + 1);
        }
        this.zU.put((byte) i);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        if (this.zU.position() + i2 > this.zU.capacity()) {
            expand(this.zU.capacity() + i2);
        }
        this.zU.put(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public synchronized void write(String str) {
        write(str.getBytes("UTF-8"));
    }

    public synchronized void jL() {
        write(13);
        write(10);
    }
}
