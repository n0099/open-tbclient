package com.baidu.adp.lib.stats;

import android.content.Context;
/* loaded from: classes.dex */
public class b extends c {
    public b(Context context, String str) {
        super(context, str);
        this.h = 50;
        this.a = "err";
        this.b = ".log";
    }

    @Override // com.baidu.adp.lib.stats.c, com.baidu.adp.lib.stats.f
    public void a(String str) {
        super.a(str);
        n.a().c(this.r, this.p);
    }
}
