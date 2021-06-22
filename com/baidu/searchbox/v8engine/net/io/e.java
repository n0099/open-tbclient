package com.baidu.searchbox.v8engine.net.io;

import androidx.annotation.Nullable;
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f10131a;

    /* renamed from: b  reason: collision with root package name */
    public int f10132b;

    /* renamed from: c  reason: collision with root package name */
    public int f10133c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f10134d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f10135e;

    /* renamed from: f  reason: collision with root package name */
    public e f10136f;

    /* renamed from: g  reason: collision with root package name */
    public e f10137g;

    public e() {
        this.f10131a = new byte[8192];
        this.f10135e = true;
        this.f10134d = false;
    }

    public e a() {
        this.f10134d = true;
        return new e(this.f10131a, this.f10132b, this.f10133c, true, false);
    }

    @Nullable
    public e b() {
        e eVar = this.f10136f;
        if (eVar == this) {
            eVar = null;
        }
        e eVar2 = this.f10137g;
        eVar2.f10136f = this.f10136f;
        this.f10136f.f10137g = eVar2;
        this.f10136f = null;
        this.f10137g = null;
        return eVar;
    }

    public e a(e eVar) {
        eVar.f10137g = this;
        eVar.f10136f = this.f10136f;
        this.f10136f.f10137g = eVar;
        this.f10136f = eVar;
        return eVar;
    }

    public e(byte[] bArr, int i2, int i3, boolean z, boolean z2) {
        this.f10131a = bArr;
        this.f10132b = i2;
        this.f10133c = i3;
        this.f10134d = z;
        this.f10135e = z2;
    }
}
