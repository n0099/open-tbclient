package com.baidu.sofire.m;

import android.database.ContentObserver;
/* loaded from: classes15.dex */
public final class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private c f5585a;

    public a(c cVar) {
        super(null);
        this.f5585a = cVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        if (this.f5585a != null) {
            c cVar = this.f5585a;
            cVar.f5588b = cVar.f5587a.a();
        }
    }
}
