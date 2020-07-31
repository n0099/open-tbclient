package com.baidu.browser.core;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
/* loaded from: classes10.dex */
public class b extends ContextWrapper {
    private static b abZ;
    private h aca;

    public b() {
        super(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.content.ContextWrapper, android.content.Context
    /* renamed from: rn */
    public h getResources() {
        if (this.aca == null) {
            this.aca = new h(super.getResources(), getAssets(), super.getResources().getDisplayMetrics(), super.getResources().getConfiguration());
        }
        return this.aca;
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public static synchronized b ro() {
        b bVar;
        synchronized (b.class) {
            if (abZ == null) {
                abZ = new b();
            }
            bVar = abZ;
        }
        return bVar;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        return com.baidu.browser.core.util.c.O(this) ? d.c(str, this) : super.getSharedPreferences(str, i);
    }
}
