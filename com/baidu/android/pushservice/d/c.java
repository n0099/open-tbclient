package com.baidu.android.pushservice.d;

import android.content.Context;
/* loaded from: classes8.dex */
public abstract class c extends a {
    public c(l lVar, Context context) {
        super(lVar, context);
    }

    @Override // com.baidu.android.pushservice.d.a
    public boolean c() {
        this.c += com.baidu.android.pushservice.i.a(this.a).a();
        return super.c();
    }
}
