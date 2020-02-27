package com.baidu.browser.core;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
/* loaded from: classes11.dex */
public class b extends ContextWrapper {
    private static b HY;
    private h HZ;

    public b() {
        super(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.content.ContextWrapper, android.content.Context
    /* renamed from: mm */
    public h getResources() {
        if (this.HZ == null) {
            this.HZ = new h(super.getResources(), getAssets(), super.getResources().getDisplayMetrics(), super.getResources().getConfiguration());
        }
        return this.HZ;
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public static synchronized b mn() {
        b bVar;
        synchronized (b.class) {
            if (HY == null) {
                HY = new b();
            }
            bVar = HY;
        }
        return bVar;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        return com.baidu.browser.core.util.c.ai(this) ? d.c(str, this) : super.getSharedPreferences(str, i);
    }
}
