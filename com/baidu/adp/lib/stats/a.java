package com.baidu.adp.lib.stats;

import android.content.Context;
/* loaded from: classes.dex */
public class a extends c {
    public a(Context context, String str) {
        super(context, str);
        this.h = 500;
        this.a = "dbg";
        this.b = ".log";
    }

    @Override // com.baidu.adp.lib.stats.c, com.baidu.adp.lib.stats.f
    public void a(String str) {
        super.a(str);
        n.a().b(this.r, this.p);
    }
}
