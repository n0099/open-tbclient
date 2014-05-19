package com.baidu.adp.lib.stats;

import android.content.Context;
/* loaded from: classes.dex */
public class g extends c {
    public g(Context context, String str) {
        super(context, str);
        this.h = 10;
        this.a = "stat";
        this.b = ".log";
        this.c = false;
        this.d = false;
    }

    @Override // com.baidu.adp.lib.stats.c, com.baidu.adp.lib.stats.f
    public String c() {
        return "stat";
    }

    @Override // com.baidu.adp.lib.stats.c, com.baidu.adp.lib.stats.f
    public void a(String str) {
        super.a(str);
        n.a().a(this.r, this.p);
    }
}
