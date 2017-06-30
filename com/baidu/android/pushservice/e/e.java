package com.baidu.android.pushservice.e;

import android.content.Context;
/* loaded from: classes2.dex */
public abstract class e extends a {
    public e(l lVar, Context context) {
        super(lVar, context);
    }

    @Override // com.baidu.android.pushservice.e.a
    public boolean c() {
        com.baidu.android.pushservice.g.a.b("SendApiProcessor", "networkConnect");
        this.c += "channel";
        return super.c();
    }
}
