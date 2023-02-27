package com.baidu.searchbox.v8engine.net.io;

import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public final class e {
    public final byte[] a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;
    public e f;
    public e g;

    public e() {
        this.a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    public e a() {
        this.d = true;
        return new e(this.a, this.b, this.c, true, false);
    }

    @Nullable
    public e b() {
        e eVar = this.f;
        if (eVar == this) {
            eVar = null;
        }
        e eVar2 = this.g;
        eVar2.f = this.f;
        this.f.g = eVar2;
        this.f = null;
        this.g = null;
        return eVar;
    }

    public e(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = z2;
    }

    public e a(e eVar) {
        eVar.g = this;
        eVar.f = this.f;
        this.f.g = eVar;
        this.f = eVar;
        return eVar;
    }
}
