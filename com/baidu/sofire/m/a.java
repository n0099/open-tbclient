package com.baidu.sofire.m;

import android.database.ContentObserver;
/* loaded from: classes8.dex */
public final class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private c f3664a;

    public a(c cVar) {
        super(null);
        this.f3664a = cVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        if (this.f3664a != null) {
            c cVar = this.f3664a;
            cVar.b = cVar.f3666a.a();
        }
    }
}
