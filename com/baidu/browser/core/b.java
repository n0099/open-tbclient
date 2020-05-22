package com.baidu.browser.core;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
/* loaded from: classes11.dex */
public class b extends ContextWrapper {
    private static b abA;
    private h abB;

    public b() {
        super(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.content.ContextWrapper, android.content.Context
    /* renamed from: qU */
    public h getResources() {
        if (this.abB == null) {
            this.abB = new h(super.getResources(), getAssets(), super.getResources().getDisplayMetrics(), super.getResources().getConfiguration());
        }
        return this.abB;
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public static synchronized b qV() {
        b bVar;
        synchronized (b.class) {
            if (abA == null) {
                abA = new b();
            }
            bVar = abA;
        }
        return bVar;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        return com.baidu.browser.core.util.c.O(this) ? d.c(str, this) : super.getSharedPreferences(str, i);
    }
}
