package com.baidu.b.c.a;
/* loaded from: classes7.dex */
abstract class f {
    final b adA;
    final int c;
    byte[] d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar) {
        this.adA = bVar;
        this.c = bVar.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(boolean z, String str, byte[] bArr, byte[] bArr2);

    abstract void a(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b();

    abstract void b(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        a(bArr, i, i2, bArr2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        b(bArr, i, i2, bArr2, i3);
    }
}
