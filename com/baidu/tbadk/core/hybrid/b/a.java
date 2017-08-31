package com.baidu.tbadk.core.hybrid.b;

import android.support.v4.view.MotionEventCompat;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
/* loaded from: classes.dex */
public class a extends InputStream {
    static final /* synthetic */ boolean $assertionsDisabled;
    boolean adP;
    volatile boolean adQ;
    Thread adR;
    Thread adS;
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
        this.adP = false;
        this.adQ = false;
        this.connected = false;
        this.in = -1;
        this.out = 0;
        cA(i);
        a(bVar);
    }

    public a() {
        this.adP = false;
        this.adQ = false;
        this.connected = false;
        this.in = -1;
        this.out = 0;
        cA(131072);
    }

    private void cA(int i) {
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
        up();
        this.adS = Thread.currentThread();
        if (this.in == this.out) {
            uq();
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
        up();
        this.adS = Thread.currentThread();
        int i4 = i2;
        while (i4 > 0) {
            if (this.in == this.out) {
                uq();
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

    private void up() throws IOException {
        if (!this.connected) {
            throw new IOException("Pipe not connected");
        }
        if (this.adP || this.adQ) {
            throw new IOException("Pipe closed");
        }
        if (this.adR != null && !this.adR.isAlive()) {
            throw new IOException("Read end dead");
        }
    }

    private void uq() throws IOException {
        while (this.in == this.out) {
            up();
            notifyAll();
            try {
                wait(100L);
            } catch (InterruptedException e) {
                throw new InterruptedIOException();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void ur() {
        this.adP = true;
        notifyAll();
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        int i = -1;
        synchronized (this) {
            if (!this.connected) {
                throw new IOException("Pipe not connected");
            }
            if (this.adQ) {
                throw new IOException("Pipe closed");
            }
            if (this.adS != null && !this.adS.isAlive() && !this.adP && this.in < 0) {
                throw new IOException("Write end dead");
            }
            this.adR = Thread.currentThread();
            int i2 = 2;
            while (true) {
                if (this.in < 0) {
                    if (this.adP) {
                        break;
                    } else if (this.adS != null && !this.adS.isAlive() && i2 - 1 < 0) {
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
        this.adQ = true;
        synchronized (this) {
            this.in = -1;
        }
    }
}
