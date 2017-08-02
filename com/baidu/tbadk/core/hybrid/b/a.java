package com.baidu.tbadk.core.hybrid.b;

import android.support.v4.view.MotionEventCompat;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
/* loaded from: classes.dex */
public class a extends InputStream {
    static final /* synthetic */ boolean $assertionsDisabled;
    boolean adk;
    volatile boolean adl;
    Thread adm;
    Thread adn;
    protected byte[] buffer;
    boolean connected;
    protected int in;
    protected int out;

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
    }

    public a(b bVar) throws IOException {
        this(bVar, 131072);
    }

    public a(b bVar, int i) throws IOException {
        this.adk = false;
        this.adl = false;
        this.connected = false;
        this.in = -1;
        this.out = 0;
        cy(i);
        a(bVar);
    }

    public a() {
        this.adk = false;
        this.adl = false;
        this.connected = false;
        this.in = -1;
        this.out = 0;
        cy(131072);
    }

    private void cy(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Pipe Size <= 0");
        }
        this.buffer = new byte[i];
    }

    public void a(b bVar) throws IOException {
        bVar.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void receive(int i) throws IOException {
        uj();
        this.adn = Thread.currentThread();
        if (this.in == this.out) {
            uk();
        }
        if (this.in < 0) {
            this.in = 0;
            this.out = 0;
        }
        byte[] bArr = this.buffer;
        int i2 = this.in;
        this.in = i2 + 1;
        bArr[i2] = (byte) (i & MotionEventCompat.ACTION_MASK);
        if (this.in >= this.buffer.length) {
            this.in = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void j(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        uj();
        this.adn = Thread.currentThread();
        int i4 = i2;
        while (i4 > 0) {
            if (this.in == this.out) {
                uk();
            }
            if (this.out < this.in) {
                i3 = this.buffer.length - this.in;
            } else if (this.in >= this.out) {
                i3 = 0;
            } else if (this.in == -1) {
                this.out = 0;
                this.in = 0;
                i3 = this.buffer.length - this.in;
            } else {
                i3 = this.out - this.in;
            }
            if (i3 > i4) {
                i3 = i4;
            }
            if (!$assertionsDisabled && i3 <= 0) {
                throw new AssertionError();
            }
            System.arraycopy(bArr, i, this.buffer, this.in, i3);
            i4 -= i3;
            i += i3;
            this.in = i3 + this.in;
            if (this.in >= this.buffer.length) {
                this.in = 0;
            }
        }
    }

    private void uj() throws IOException {
        if (!this.connected) {
            throw new IOException("Pipe not connected");
        }
        if (this.adk || this.adl) {
            throw new IOException("Pipe closed");
        }
        if (this.adm != null && !this.adm.isAlive()) {
            throw new IOException("Read end dead");
        }
    }

    private void uk() throws IOException {
        while (this.in == this.out) {
            uj();
            notifyAll();
            try {
                wait(100L);
            } catch (InterruptedException e) {
                throw new InterruptedIOException();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void ul() {
        this.adk = true;
        notifyAll();
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        int i = -1;
        synchronized (this) {
            if (!this.connected) {
                throw new IOException("Pipe not connected");
            }
            if (this.adl) {
                throw new IOException("Pipe closed");
            }
            if (this.adn != null && !this.adn.isAlive() && !this.adk && this.in < 0) {
                throw new IOException("Write end dead");
            }
            this.adm = Thread.currentThread();
            int i2 = 2;
            while (true) {
                if (this.in < 0) {
                    if (this.adk) {
                        break;
                    } else if (this.adn != null && !this.adn.isAlive() && i2 - 1 < 0) {
                        throw new IOException("Pipe broken");
                    } else {
                        notifyAll();
                        try {
                            wait(100L);
                        } catch (InterruptedException e) {
                            throw new InterruptedIOException();
                        }
                    }
                } else {
                    byte[] bArr = this.buffer;
                    int i3 = this.out;
                    this.out = i3 + 1;
                    i = bArr[i3] & 255;
                    if (this.out >= this.buffer.length) {
                        this.out = 0;
                    }
                    if (this.in == this.out) {
                        this.in = -1;
                    }
                }
            }
        }
        return i;
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        int length;
        int i3 = 0;
        synchronized (this) {
            if (bArr == null) {
                throw new NullPointerException();
            }
            if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
                throw new IndexOutOfBoundsException();
            }
            if (i2 != 0) {
                int read = read();
                if (read < 0) {
                    i3 = -1;
                } else {
                    bArr[i] = (byte) read;
                    i3 = 1;
                    while (this.in >= 0 && i2 > 1) {
                        if (this.in > this.out) {
                            length = Math.min(this.buffer.length - this.out, this.in - this.out);
                        } else {
                            length = this.buffer.length - this.out;
                        }
                        if (length > i2 - 1) {
                            length = i2 - 1;
                        }
                        System.arraycopy(this.buffer, this.out, bArr, i + i3, length);
                        this.out += length;
                        i3 += length;
                        i2 -= length;
                        if (this.out >= this.buffer.length) {
                            this.out = 0;
                        }
                        if (this.in == this.out) {
                            this.in = -1;
                        }
                    }
                }
            }
        }
        return i3;
    }

    @Override // java.io.InputStream
    public synchronized int available() throws IOException {
        int length;
        if (this.in < 0) {
            length = 0;
        } else if (this.in == this.out) {
            length = this.buffer.length;
        } else if (this.in > this.out) {
            length = this.in - this.out;
        } else {
            length = (this.in + this.buffer.length) - this.out;
        }
        return length;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.adl = true;
        synchronized (this) {
            this.in = -1;
        }
    }
}
