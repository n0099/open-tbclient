package com.baidu.android.pushservice.p;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes.dex */
public abstract class c extends a {
    public c(i iVar, Context context) {
        super(iVar, context);
    }

    @Override // com.baidu.android.pushservice.p.a
    public boolean d() {
        String a = com.baidu.android.pushservice.j.a(this.c).a();
        if (TextUtils.isEmpty(a)) {
            a = "channel";
        }
        this.e += a;
        return super.d();
    }
}
