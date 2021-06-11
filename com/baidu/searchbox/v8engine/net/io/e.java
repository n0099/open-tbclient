package com.baidu.searchbox.v8engine.net.io;

import androidx.annotation.Nullable;
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f10099a;

    /* renamed from: b  reason: collision with root package name */
    public int f10100b;

    /* renamed from: c  reason: collision with root package name */
    public int f10101c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f10102d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f10103e;

    /* renamed from: f  reason: collision with root package name */
    public e f10104f;

    /* renamed from: g  reason: collision with root package name */
    public e f10105g;

    public e() {
        this.f10099a = new byte[8192];
        this.f10103e = true;
        this.f10102d = false;
    }

    public e a() {
        this.f10102d = true;
        return new e(this.f10099a, this.f10100b, this.f10101c, true, false);
    }

    @Nullable
    public e b() {
        e eVar = this.f10104f;
        if (eVar == this) {
            eVar = null;
        }
        e eVar2 = this.f10105g;
        eVar2.f10104f = this.f10104f;
        this.f10104f.f10105g = eVar2;
        this.f10104f = null;
        this.f10105g = null;
        return eVar;
    }

    public e a(e eVar) {
        eVar.f10105g = this;
        eVar.f10104f = this.f10104f;
        this.f10104f.f10105g = eVar;
        this.f10104f = eVar;
        return eVar;
    }

    public e(byte[] bArr, int i2, int i3, boolean z, boolean z2) {
        this.f10099a = bArr;
        this.f10100b = i2;
        this.f10101c = i3;
        this.f10102d = z;
        this.f10103e = z2;
    }
}
