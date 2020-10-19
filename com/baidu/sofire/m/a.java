package com.baidu.sofire.m;

import android.database.ContentObserver;
/* loaded from: classes15.dex */
public final class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private c f3658a;

    public a(c cVar) {
        super(null);
        this.f3658a = cVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        if (this.f3658a != null) {
            c cVar = this.f3658a;
            cVar.b = cVar.f3660a.a();
        }
    }
}
