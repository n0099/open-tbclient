package com.baidu.browser.core;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
/* loaded from: classes10.dex */
public class b extends ContextWrapper {
    private static b aet;
    private h aeu;

    public b() {
        super(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.content.ContextWrapper, android.content.Context
    /* renamed from: te */
    public h getResources() {
        if (this.aeu == null) {
            this.aeu = new h(super.getResources(), getAssets(), super.getResources().getDisplayMetrics(), super.getResources().getConfiguration());
        }
        return this.aeu;
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public static synchronized b tf() {
        b bVar;
        synchronized (b.class) {
            if (aet == null) {
                aet = new b();
            }
            bVar = aet;
        }
        return bVar;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        return com.baidu.browser.core.util.c.R(this) ? d.c(str, this) : super.getSharedPreferences(str, i);
    }
}
