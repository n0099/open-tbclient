package com.baidu.browser.core;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
/* loaded from: classes19.dex */
public class b extends ContextWrapper {
    private static b adH;
    private h adI;

    public b() {
        super(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.content.ContextWrapper, android.content.Context
    /* renamed from: sZ */
    public h getResources() {
        if (this.adI == null) {
            this.adI = new h(super.getResources(), getAssets(), super.getResources().getDisplayMetrics(), super.getResources().getConfiguration());
        }
        return this.adI;
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public static synchronized b ta() {
        b bVar;
        synchronized (b.class) {
            if (adH == null) {
                adH = new b();
            }
            bVar = adH;
        }
        return bVar;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        return com.baidu.browser.core.util.c.R(this) ? d.c(str, this) : super.getSharedPreferences(str, i);
    }
}
