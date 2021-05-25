package com.baidu.sofire.k;

import android.database.ContentObserver;
/* loaded from: classes2.dex */
public final class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public c f10290a;

    public a(c cVar) {
        super(null);
        this.f10290a = cVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        c cVar = this.f10290a;
        if (cVar != null) {
            cVar.f10293b = cVar.f10292a.a();
        }
    }
}
