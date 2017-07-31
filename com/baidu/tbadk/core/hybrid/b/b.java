package com.baidu.tbadk.core.hybrid.b;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class b extends OutputStream {
    private a aeJ;

    public synchronized void a(a aVar) throws IOException {
        if (aVar == null) {
            throw new NullPointerException();
        }
        if (this.aeJ != null || aVar.connected) {
            throw new IOException("Already connected");
        }
        this.aeJ = aVar;
        aVar.in = -1;
        aVar.out = 0;
        aVar.connected = true;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        if (this.aeJ == null) {
            throw new IOException("Pipe not connected");
        }
        this.aeJ.receive(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.aeJ == null) {
            throw new IOException("Pipe not connected");
        }
        if (bArr == null) {
            throw new NullPointerException();
        }
        if (i < 0 || i > bArr.length || i2 < 0 || i + i2 > bArr.length || i + i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 != 0) {
            this.aeJ.j(bArr, i, i2);
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.aeJ != null) {
            synchronized (this.aeJ) {
                this.aeJ.notifyAll();
            }
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.aeJ != null) {
            this.aeJ.uv();
        }
    }
}
