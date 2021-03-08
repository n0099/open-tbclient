package com.baidu.sofire.m;

import android.database.ContentObserver;
/* loaded from: classes4.dex */
public final class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private c f3565a;

    public a(c cVar) {
        super(null);
        this.f3565a = cVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        if (this.f3565a != null) {
            c cVar = this.f3565a;
            cVar.b = cVar.f3567a.a();
        }
    }
}
