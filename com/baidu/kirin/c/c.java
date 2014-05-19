package com.baidu.kirin.c;

import android.content.Context;
/* loaded from: classes.dex */
public class c extends a {
    public c(Context context, String str) {
        super(context, str);
        this.c = getClass().getName();
    }

    @Override // com.baidu.kirin.c.a
    protected void b() {
        try {
            this.d.put("logID", com.baidu.kirin.b.a.a(this.a).d());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
