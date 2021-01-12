package com.baidu.browser.core;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
/* loaded from: classes4.dex */
public class b extends ContextWrapper {
    private static b aff;
    private h afg;

    public b() {
        super(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.content.ContextWrapper, android.content.Context
    /* renamed from: sw */
    public h getResources() {
        if (this.afg == null) {
            this.afg = new h(super.getResources(), getAssets(), super.getResources().getDisplayMetrics(), super.getResources().getConfiguration());
        }
        return this.afg;
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public static synchronized b sx() {
        b bVar;
        synchronized (b.class) {
            if (aff == null) {
                aff = new b();
            }
            bVar = aff;
        }
        return bVar;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        return com.baidu.browser.core.util.c.R(this) ? d.c(str, this) : super.getSharedPreferences(str, i);
    }
}
