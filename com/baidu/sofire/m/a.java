package com.baidu.sofire.m;

import android.database.ContentObserver;
/* loaded from: classes2.dex */
public final class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public c f10366a;

    public a(c cVar) {
        super(null);
        this.f10366a = cVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        c cVar = this.f10366a;
        if (cVar != null) {
            cVar.f10369b = cVar.f10368a.a();
        }
    }
}
