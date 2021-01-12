package com.baidu.pano.platform.a;

import android.content.Intent;
/* loaded from: classes6.dex */
public class a extends v {

    /* renamed from: b  reason: collision with root package name */
    private Intent f3846b;

    public a() {
    }

    public a(l lVar) {
        super(lVar);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f3846b != null ? "User needs to (re)enter credentials." : super.getMessage();
    }
}
