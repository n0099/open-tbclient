package com.baidu.android.pushservice.c;

import android.content.Context;
/* loaded from: classes2.dex */
public abstract class c extends a {
    public c(l lVar, Context context) {
        super(lVar, context);
    }

    @Override // com.baidu.android.pushservice.c.a
    public boolean c() {
        this.c += com.baidu.android.pushservice.j.a(this.a).a();
        return super.c();
    }
}
