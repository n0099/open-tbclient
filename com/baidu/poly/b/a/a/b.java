package com.baidu.poly.b.a.a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
/* loaded from: classes2.dex */
class b implements Closeable {
    private byte[] aii;
    private final Charset charset;
    private int end;
    private final InputStream in;
    private int pos;

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public b(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(c.aik)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.in = inputStream;
        this.charset = charset;
        this.aii = new byte[i];
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.in) {
            if (this.aii != null) {
                this.aii = null;
                this.in.close();
            }
        }
    }

    public String readLine() throws IOException {
        int i;
        String byteArrayOutputStream;
        synchronized (this.in) {
            if (this.aii == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.pos >= this.end) {
                uT();
            }
            int i2 = this.pos;
            while (true) {
                if (i2 != this.end) {
                    if (this.aii[i2] != 10) {
                        i2++;
                    } else {
                        byteArrayOutputStream = new String(this.aii, this.pos, ((i2 == this.pos || this.aii[i2 + (-1)] != 13) ? i2 : i2 - 1) - this.pos, this.charset.name());
                        this.pos = i2 + 1;
                    }
                } else {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream((this.end - this.pos) + 80) { // from class: com.baidu.poly.b.a.a.b.1
                        @Override // java.io.ByteArrayOutputStream
                        public String toString() {
                            try {
                                return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + (-1)] != 13) ? this.count : this.count - 1, b.this.charset.name());
                            } catch (UnsupportedEncodingException e) {
                                throw new AssertionError(e);
                            }
                        }
                    };
                    loop1: while (true) {
                        byteArrayOutputStream2.write(this.aii, this.pos, this.end - this.pos);
                        this.end = -1;
                        uT();
                        i = this.pos;
                        while (i != this.end) {
                            if (this.aii[i] == 10) {
                                break loop1;
                            }
                            i++;
                        }
                    }
                    if (i != this.pos) {
                        byteArrayOutputStream2.write(this.aii, this.pos, i - this.pos);
                    }
                    this.pos = i + 1;
                    byteArrayOutputStream = byteArrayOutputStream2.toString();
                }
            }
            return byteArrayOutputStream;
        }
    }

    public boolean uS() {
        return this.end == -1;
    }

    private void uT() throws IOException {
        int read = this.in.read(this.aii, 0, this.aii.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.pos = 0;
        this.end = read;
    }
}
