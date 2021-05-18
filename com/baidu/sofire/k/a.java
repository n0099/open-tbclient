package com.baidu.sofire.k;

import android.database.ContentObserver;
/* loaded from: classes2.dex */
public final class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public c f10389a;

    public a(c cVar) {
        super(null);
        this.f10389a = cVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        c cVar = this.f10389a;
        if (cVar != null) {
            cVar.f10392b = cVar.f10391a.a();
        }
    }
}
