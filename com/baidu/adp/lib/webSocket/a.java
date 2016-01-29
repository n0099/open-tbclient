package com.baidu.adp.lib.webSocket;

import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a extends OutputStream {
    private final int zA;
    private final int zB;
    private ByteBuffer zC;

    public a() {
        this(131072, 65536);
    }

    public a(int i, int i2) {
        this.zA = i;
        this.zB = i2;
        this.zC = ByteBuffer.allocateDirect(this.zA);
        this.zC.clear();
    }

    public ByteBuffer jE() {
        return this.zC;
    }

    public Buffer flip() {
        return this.zC.flip();
    }

    public Buffer clear() {
        return this.zC.clear();
    }

    public int remaining() {
        return this.zC.remaining();
    }

    public synchronized void expand(int i) {
        if (i > this.zC.capacity()) {
            ByteBuffer byteBuffer = this.zC;
            int position = this.zC.position();
            this.zC = ByteBuffer.allocateDirect(((i / this.zB) + 1) * this.zB);
            byteBuffer.clear();
            this.zC.clear();
            this.zC.put(byteBuffer);
            this.zC.position(position);
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) {
        if (this.zC.position() + 1 > this.zC.capacity()) {
            expand(this.zC.capacity() + 1);
        }
        this.zC.put((byte) i);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        if (this.zC.position() + i2 > this.zC.capacity()) {
            expand(this.zC.capacity() + i2);
        }
        this.zC.put(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public synchronized void write(String str) {
        write(str.getBytes("UTF-8"));
    }

    public synchronized void jF() {
        write(13);
        write(10);
    }
}
