package com.baidu.adp.lib.webSocket;

import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class c extends OutputStream {
    private final int oY;
    private final int oZ;
    private ByteBuffer pa;

    public c() {
        this(131072, 65536);
    }

    public c(int i, int i2) {
        this.oY = i;
        this.oZ = i2;
        this.pa = ByteBuffer.allocateDirect(this.oY);
        this.pa.clear();
    }

    public ByteBuffer fO() {
        return this.pa;
    }

    public Buffer flip() {
        return this.pa.flip();
    }

    public Buffer clear() {
        return this.pa.clear();
    }

    public int remaining() {
        return this.pa.remaining();
    }

    public synchronized void an(int i) {
        if (i > this.pa.capacity()) {
            ByteBuffer byteBuffer = this.pa;
            int position = this.pa.position();
            this.pa = ByteBuffer.allocateDirect(((i / this.oZ) + 1) * this.oZ);
            byteBuffer.clear();
            this.pa.clear();
            this.pa.put(byteBuffer);
            this.pa.position(position);
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) {
        if (this.pa.position() + 1 > this.pa.capacity()) {
            an(this.pa.capacity() + 1);
        }
        this.pa.put((byte) i);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        if (this.pa.position() + i2 > this.pa.capacity()) {
            an(this.pa.capacity() + i2);
        }
        this.pa.put(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public synchronized void write(String str) {
        write(str.getBytes("UTF-8"));
    }

    public synchronized void fP() {
        write(13);
        write(10);
    }
}
