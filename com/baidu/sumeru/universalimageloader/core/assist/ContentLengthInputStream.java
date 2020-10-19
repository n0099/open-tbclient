package com.baidu.sumeru.universalimageloader.core.assist;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes12.dex */
public class ContentLengthInputStream extends InputStream {
    private final long length;
    private long pos;
    private final InputStream stream;

    public ContentLengthInputStream(InputStream inputStream, long j) {
        this.stream = inputStream;
        this.length = j;
    }

    @Override // java.io.InputStream
    public synchronized int available() {
        return (int) (this.length - this.pos);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.stream.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.pos = i;
        this.stream.mark(i);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        this.pos++;
        return this.stream.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        this.pos += i2;
        return this.stream.read(bArr, i, i2);
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.pos = 0L;
        this.stream.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        this.pos += j;
        return this.stream.skip(j);
    }
}
