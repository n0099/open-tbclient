package com.baidu.android.pushservice.d;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes.dex */
public abstract class c extends a {
    public c(i iVar, Context context) {
        super(iVar, context);
    }

    @Override // com.baidu.android.pushservice.d.a
    public boolean c() {
        String a2 = com.baidu.android.pushservice.k.a(((a) this).f2943a).a();
        if (TextUtils.isEmpty(a2)) {
            a2 = "channel";
        }
        this.f2945c += a2;
        return super.c();
    }
}
