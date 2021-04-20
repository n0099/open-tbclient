package com.baidu.pano.platform.a;

import android.content.Intent;
/* loaded from: classes2.dex */
public class a extends v {

    /* renamed from: b  reason: collision with root package name */
    public Intent f8871b;

    public a() {
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f8871b != null ? "User needs to (re)enter credentials." : super.getMessage();
    }

    public a(l lVar) {
        super(lVar);
    }
}
