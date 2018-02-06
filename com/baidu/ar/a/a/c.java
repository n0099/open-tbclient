package com.baidu.ar.a.a;
/* loaded from: classes3.dex */
public abstract class c implements Runnable {
    protected int a;
    protected int b;
    protected a c;
    private byte[] d;

    public c() {
    }

    public c(a aVar) {
        this.c = aVar;
    }

    public c(byte[] bArr, int i, int i2, a aVar) {
        this.c = aVar;
        a(bArr, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        d a;
        if (this.d == null || (a = d.a()) == null) {
            return;
        }
        a.a(this.d);
        this.d = null;
    }

    public void a(byte[] bArr, int i, int i2) {
        this.d = d.a().b();
        if (this.d != null) {
            com.baidu.ar.util.b.a("bdar: data length = " + this.d.length);
            System.arraycopy(bArr, 0, this.d, 0, this.d.length);
        }
        this.a = i;
        this.b = i2;
    }

    public abstract void b();

    public byte[] c() {
        return this.d;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.d == null) {
            com.baidu.ar.util.b.d("bdar: data is null!!!");
            return;
        }
        try {
            b();
        } finally {
            a();
        }
    }
}
