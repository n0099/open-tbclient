package com.baidu.browser.core;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
/* loaded from: classes11.dex */
public class b extends ContextWrapper {
    private static b abj;
    private h abk;

    public b() {
        super(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.content.ContextWrapper, android.content.Context
    /* renamed from: qO */
    public h getResources() {
        if (this.abk == null) {
            this.abk = new h(super.getResources(), getAssets(), super.getResources().getDisplayMetrics(), super.getResources().getConfiguration());
        }
        return this.abk;
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public static synchronized b qP() {
        b bVar;
        synchronized (b.class) {
            if (abj == null) {
                abj = new b();
            }
            bVar = abj;
        }
        return bVar;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        return com.baidu.browser.core.util.c.M(this) ? d.c(str, this) : super.getSharedPreferences(str, i);
    }
}
