package com.baidu.searchbox.v8engine.net.io;

import androidx.annotation.Nullable;
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f10137a;

    /* renamed from: b  reason: collision with root package name */
    public int f10138b;

    /* renamed from: c  reason: collision with root package name */
    public int f10139c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f10140d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f10141e;

    /* renamed from: f  reason: collision with root package name */
    public e f10142f;

    /* renamed from: g  reason: collision with root package name */
    public e f10143g;

    public e() {
        this.f10137a = new byte[8192];
        this.f10141e = true;
        this.f10140d = false;
    }

    public e a() {
        this.f10140d = true;
        return new e(this.f10137a, this.f10138b, this.f10139c, true, false);
    }

    @Nullable
    public e b() {
        e eVar = this.f10142f;
        if (eVar == this) {
            eVar = null;
        }
        e eVar2 = this.f10143g;
        eVar2.f10142f = this.f10142f;
        this.f10142f.f10143g = eVar2;
        this.f10142f = null;
        this.f10143g = null;
        return eVar;
    }

    public e a(e eVar) {
        eVar.f10143g = this;
        eVar.f10142f = this.f10142f;
        this.f10142f.f10143g = eVar;
        this.f10142f = eVar;
        return eVar;
    }

    public e(byte[] bArr, int i2, int i3, boolean z, boolean z2) {
        this.f10137a = bArr;
        this.f10138b = i2;
        this.f10139c = i3;
        this.f10140d = z;
        this.f10141e = z2;
    }
}
