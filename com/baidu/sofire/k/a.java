package com.baidu.sofire.k;

import android.database.ContentObserver;
/* loaded from: classes2.dex */
public final class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public c f11489a;

    public a(c cVar) {
        super(null);
        this.f11489a = cVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        c cVar = this.f11489a;
        if (cVar != null) {
            cVar.f11492b = cVar.f11491a.a();
        }
    }
}
