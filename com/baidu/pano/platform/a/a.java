package com.baidu.pano.platform.a;

import android.content.Intent;
/* loaded from: classes8.dex */
public class a extends v {
    private Intent b;

    public a() {
    }

    public a(l lVar) {
        super(lVar);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.b != null ? "User needs to (re)enter credentials." : super.getMessage();
    }
}
