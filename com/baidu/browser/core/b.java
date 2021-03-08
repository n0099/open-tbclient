package com.baidu.browser.core;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
/* loaded from: classes14.dex */
public class b extends ContextWrapper {
    private static b agr;
    private h ags;

    public b() {
        super(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.content.ContextWrapper, android.content.Context
    /* renamed from: st */
    public h getResources() {
        if (this.ags == null) {
            this.ags = new h(super.getResources(), getAssets(), super.getResources().getDisplayMetrics(), super.getResources().getConfiguration());
        }
        return this.ags;
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public static synchronized b su() {
        b bVar;
        synchronized (b.class) {
            if (agr == null) {
                agr = new b();
            }
            bVar = agr;
        }
        return bVar;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        return com.baidu.browser.core.util.c.Q(this) ? d.c(str, this) : super.getSharedPreferences(str, i);
    }
}
