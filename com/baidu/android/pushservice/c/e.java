package com.baidu.android.pushservice.c;

import android.content.Context;
/* loaded from: classes2.dex */
public abstract class e extends a {
    public e(l lVar, Context context) {
        super(lVar, context);
    }

    @Override // com.baidu.android.pushservice.c.a
    public boolean c() {
        com.baidu.android.pushservice.e.a.b("SendApiProcessor", "networkConnect");
        this.c += "channel";
        return super.c();
    }
}
