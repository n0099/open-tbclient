package com.baidu.adp.lib.webSocket;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class a extends OutputStream {
    private ByteBuffer mBuffer;
    private final int sf;
    private final int sg;

    public a() {
        this(131072, 65536);
    }

    public a(int i, int i2) {
        this.sf = i;
        this.sg = i2;
        this.mBuffer = ByteBuffer.allocateDirect(this.sf);
        this.mBuffer.clear();
    }

    public ByteBuffer hi() {
        return this.mBuffer;
    }

    public Buffer hj() {
        return this.mBuffer.flip();
    }

    public Buffer hk() {
        return this.mBuffer.clear();
    }

    public int hl() {
        return this.mBuffer.remaining();
    }

    public synchronized void W(int i) {
        if (i > this.mBuffer.capacity()) {
            ByteBuffer byteBuffer = this.mBuffer;
            int position = this.mBuffer.position();
            this.mBuffer = ByteBuffer.allocateDirect(((i / this.sg) + 1) * this.sg);
            byteBuffer.clear();
            this.mBuffer.clear();
            this.mBuffer.put(byteBuffer);
            this.mBuffer.position(position);
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) throws IOException {
        if (this.mBuffer.position() + 1 > this.mBuffer.capacity()) {
            W(this.mBuffer.capacity() + 1);
        }
        this.mBuffer.put((byte) i);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.mBuffer.position() + i2 > this.mBuffer.capacity()) {
            W(this.mBuffer.capacity() + i2);
        }
        this.mBuffer.put(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public synchronized void ax(String str) throws IOException {
        write(str.getBytes(HTTP.UTF_8));
    }

    public synchronized void hm() throws IOException {
        write(13);
        write(10);
    }
}
