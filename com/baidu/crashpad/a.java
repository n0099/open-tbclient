package com.baidu.crashpad;
/* loaded from: classes11.dex */
public final class a {
    private byte[] a;
    private int b;
    private int c;
    private byte[] d;

    public a(String str) {
        this.d = str.getBytes();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        byte[] bArr = this.d;
        this.b = 0;
        this.c = 0;
        if (this.a == null) {
            this.a = new byte[256];
        }
        for (int i = 0; i < 256; i++) {
            this.a[i] = (byte) i;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            i2 = (i2 + (bArr[i3] & 255) + this.a[i4]) & 255;
            byte b = this.a[i4];
            this.a[i4] = this.a[i2];
            this.a[i2] = b;
            i3 = (i3 + 1) % bArr.length;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(byte[] bArr, int i, byte[] bArr2) {
        if (i + 0 > bArr.length) {
            throw new RuntimeException("input buffer too short");
        }
        if (i + 0 > bArr2.length) {
            throw new RuntimeException("output buffer too short");
        }
        for (int i2 = 0; i2 < i; i2++) {
            this.b = (this.b + 1) & 255;
            this.c = (this.a[this.b] + this.c) & 255;
            byte b = this.a[this.b];
            this.a[this.b] = this.a[this.c];
            this.a[this.c] = b;
            bArr2[i2 + 0] = (byte) (bArr[i2 + 0] ^ this.a[(this.a[this.b] + this.a[this.c]) & 255]);
        }
    }
}
