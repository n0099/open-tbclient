package com.baidu.pano.platform.a;

import android.content.Intent;
/* loaded from: classes3.dex */
public class a extends v {

    /* renamed from: b  reason: collision with root package name */
    private Intent f3884b;

    public a() {
    }

    public a(l lVar) {
        super(lVar);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f3884b != null ? "User needs to (re)enter credentials." : super.getMessage();
    }
}
