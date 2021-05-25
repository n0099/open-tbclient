package com.baidu.searchbox.v8engine.net.io;

import androidx.annotation.Nullable;
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f10037a;

    /* renamed from: b  reason: collision with root package name */
    public int f10038b;

    /* renamed from: c  reason: collision with root package name */
    public int f10039c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f10040d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f10041e;

    /* renamed from: f  reason: collision with root package name */
    public e f10042f;

    /* renamed from: g  reason: collision with root package name */
    public e f10043g;

    public e() {
        this.f10037a = new byte[8192];
        this.f10041e = true;
        this.f10040d = false;
    }

    public e a() {
        this.f10040d = true;
        return new e(this.f10037a, this.f10038b, this.f10039c, true, false);
    }

    @Nullable
    public e b() {
        e eVar = this.f10042f;
        if (eVar == this) {
            eVar = null;
        }
        e eVar2 = this.f10043g;
        eVar2.f10042f = this.f10042f;
        this.f10042f.f10043g = eVar2;
        this.f10042f = null;
        this.f10043g = null;
        return eVar;
    }

    public e a(e eVar) {
        eVar.f10043g = this;
        eVar.f10042f = this.f10042f;
        this.f10042f.f10043g = eVar;
        this.f10042f = eVar;
        return eVar;
    }

    public e(byte[] bArr, int i2, int i3, boolean z, boolean z2) {
        this.f10037a = bArr;
        this.f10038b = i2;
        this.f10039c = i3;
        this.f10040d = z;
        this.f10041e = z2;
    }
}
