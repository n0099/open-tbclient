package com.baidu.adp.lib.webSocket;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a extends OutputStream {
    private final int Ah;
    private final int Ai;
    private ByteBuffer Aj;

    public a() {
        this(131072, 65536);
    }

    public a(int i, int i2) {
        this.Ah = i;
        this.Ai = i2;
        this.Aj = ByteBuffer.allocateDirect(this.Ah);
        this.Aj.clear();
    }

    public ByteBuffer hL() {
        return this.Aj;
    }

    public Buffer flip() {
        return this.Aj.flip();
    }

    public Buffer clear() {
        return this.Aj.clear();
    }

    public int remaining() {
        return this.Aj.remaining();
    }

    public synchronized void aB(int i) {
        if (i > this.Aj.capacity()) {
            ByteBuffer byteBuffer = this.Aj;
            int position = this.Aj.position();
            this.Aj = ByteBuffer.allocateDirect(((i / this.Ai) + 1) * this.Ai);
            byteBuffer.clear();
            this.Aj.clear();
            this.Aj.put(byteBuffer);
            this.Aj.position(position);
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) throws IOException {
        if (this.Aj.position() + 1 > this.Aj.capacity()) {
            aB(this.Aj.capacity() + 1);
        }
        this.Aj.put((byte) i);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.Aj.position() + i2 > this.Aj.capacity()) {
            aB(this.Aj.capacity() + i2);
        }
        this.Aj.put(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public synchronized void write(String str) throws IOException {
        write(str.getBytes("UTF-8"));
    }

    public synchronized void hM() throws IOException {
        write(13);
        write(10);
    }
}
