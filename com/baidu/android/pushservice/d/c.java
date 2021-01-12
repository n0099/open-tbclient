package com.baidu.android.pushservice.d;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes14.dex */
public abstract class c extends a {
    public c(i iVar, Context context) {
        super(iVar, context);
    }

    @Override // com.baidu.android.pushservice.d.a
    public boolean c() {
        String a2 = com.baidu.android.pushservice.j.a(this.f1264a).a();
        if (TextUtils.isEmpty(a2)) {
            a2 = "channel";
        }
        this.c += a2;
        return super.c();
    }
}
