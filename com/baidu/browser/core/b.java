package com.baidu.browser.core;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
/* loaded from: classes10.dex */
public class b extends ContextWrapper {
    private static b aeb;
    private h aec;

    public b() {
        super(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.content.ContextWrapper, android.content.Context
    /* renamed from: te */
    public h getResources() {
        if (this.aec == null) {
            this.aec = new h(super.getResources(), getAssets(), super.getResources().getDisplayMetrics(), super.getResources().getConfiguration());
        }
        return this.aec;
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public static synchronized b tf() {
        b bVar;
        synchronized (b.class) {
            if (aeb == null) {
                aeb = new b();
            }
            bVar = aeb;
        }
        return bVar;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        return com.baidu.browser.core.util.c.R(this) ? d.c(str, this) : super.getSharedPreferences(str, i);
    }
}
