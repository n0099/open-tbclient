package com.baidu.sofire.m;

import android.database.ContentObserver;
/* loaded from: classes20.dex */
public final class a extends ContentObserver {
    private c a;

    public a(c cVar) {
        super(null);
        this.a = cVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        if (this.a != null) {
            c cVar = this.a;
            cVar.b = cVar.a.a();
        }
    }
}
