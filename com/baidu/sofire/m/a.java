package com.baidu.sofire.m;

import android.database.ContentObserver;
/* loaded from: classes14.dex */
public final class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private c f5303a;

    public a(c cVar) {
        super(null);
        this.f5303a = cVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        if (this.f5303a != null) {
            c cVar = this.f5303a;
            cVar.f5306b = cVar.f5305a.a();
        }
    }
}
