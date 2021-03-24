package com.baidu.sofire.k;

import android.database.ContentObserver;
/* loaded from: classes3.dex */
public final class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public c f11827a;

    public a(c cVar) {
        super(null);
        this.f11827a = cVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        c cVar = this.f11827a;
        if (cVar != null) {
            cVar.f11830b = cVar.f11829a.a();
        }
    }
}
