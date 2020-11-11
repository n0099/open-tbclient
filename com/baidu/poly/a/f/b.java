package com.baidu.poly.a.f;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class b implements Closeable {
    private byte[] buf;
    private final Charset charset;
    private int end;
    private final InputStream in;
    private int pos;

    /* loaded from: classes6.dex */
    class a extends ByteArrayOutputStream {
        a(int i) {
            super(i);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i = ((ByteArrayOutputStream) this).count;
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, (i <= 0 || ((ByteArrayOutputStream) this).buf[i + (-1)] != 13) ? ((ByteArrayOutputStream) this).count : i - 1, b.this.charset.name());
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void abf() {
        InputStream inputStream = this.in;
        byte[] bArr = this.buf;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.pos = 0;
            this.end = read;
            return;
        }
        throw new EOFException();
    }

    public boolean abg() {
        return this.end == -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.in) {
            if (this.buf != null) {
                this.buf = null;
                this.in.close();
            }
        }
    }

    public String readLine() {
        int i;
        String aVar;
        int i2;
        synchronized (this.in) {
            if (this.buf != null) {
                if (this.pos >= this.end) {
                    abf();
                }
                int i3 = this.pos;
                while (true) {
                    if (i3 != this.end) {
                        if (this.buf[i3] == 10) {
                            if (i3 != this.pos) {
                                int i4 = i3 - 1;
                                if (this.buf[i4] == 13) {
                                    i2 = i4;
                                    aVar = new String(this.buf, this.pos, i2 - this.pos, this.charset.name());
                                    this.pos = i3 + 1;
                                }
                            }
                            i2 = i3;
                            aVar = new String(this.buf, this.pos, i2 - this.pos, this.charset.name());
                            this.pos = i3 + 1;
                        } else {
                            i3++;
                        }
                    } else {
                        a aVar2 = new a((this.end - this.pos) + 80);
                        loop1: while (true) {
                            aVar2.write(this.buf, this.pos, this.end - this.pos);
                            this.end = -1;
                            abf();
                            i = this.pos;
                            while (i != this.end) {
                                if (this.buf[i] == 10) {
                                    break loop1;
                                }
                                i++;
                            }
                        }
                        if (i != this.pos) {
                            aVar2.write(this.buf, this.pos, i - this.pos);
                        }
                        this.pos = i + 1;
                        aVar = aVar2.toString();
                    }
                }
            } else {
                throw new IOException("LineReader is closed");
            }
        }
        return aVar;
    }

    public b(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        }
        if (i >= 0) {
            if (charset.equals(c.US_ASCII)) {
                this.in = inputStream;
                this.charset = charset;
                this.buf = new byte[i];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw new IllegalArgumentException("capacity <= 0");
    }
}
