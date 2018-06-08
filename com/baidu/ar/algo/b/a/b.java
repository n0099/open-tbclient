package com.baidu.ar.algo.b.a;

import android.util.Log;
/* loaded from: classes3.dex */
public abstract class b implements Runnable {
    protected int a;
    protected int b;
    protected a c;
    int d;
    private byte[] e;

    public b() {
        this.d = 0;
    }

    public b(a aVar) {
        this.d = 0;
        this.c = aVar;
    }

    public b(byte[] bArr, int i, int i2, a aVar) {
        this(bArr, i, i2, aVar, 0);
    }

    public b(byte[] bArr, int i, int i2, a aVar, int i3) {
        this.d = 0;
        this.d = i3;
        this.c = aVar;
        a(bArr, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        c a;
        if (this.e == null || (a = c.a()) == null) {
            return;
        }
        a.a(this.e, this.d);
        this.e = null;
    }

    public void a(byte[] bArr, int i, int i2) {
        c a = c.a();
        if (a == null) {
            return;
        }
        this.e = a.a(this.d);
        if (this.e != null) {
            System.arraycopy(bArr, 0, this.e, 0, this.e.length);
        }
        this.a = i;
        this.b = i2;
    }

    public abstract void b();

    public byte[] c() {
        return this.e;
    }

    public int d() {
        return this.d;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.e == null) {
            Log.e("AlgoRunnable", "bdar: data is null!!!");
            return;
        }
        try {
            b();
        } finally {
            a();
        }
    }
}
