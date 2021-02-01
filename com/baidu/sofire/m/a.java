package com.baidu.sofire.m;

import android.database.ContentObserver;
/* loaded from: classes3.dex */
public final class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private c f5305a;

    public a(c cVar) {
        super(null);
        this.f5305a = cVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        if (this.f5305a != null) {
            c cVar = this.f5305a;
            cVar.f5308b = cVar.f5307a.a();
        }
    }
}
