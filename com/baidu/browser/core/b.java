package com.baidu.browser.core;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
/* loaded from: classes11.dex */
public class b extends ContextWrapper {
    private static b aft;
    private h afu;

    public b() {
        super(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.content.ContextWrapper, android.content.Context
    /* renamed from: th */
    public h getResources() {
        if (this.afu == null) {
            this.afu = new h(super.getResources(), getAssets(), super.getResources().getDisplayMetrics(), super.getResources().getConfiguration());
        }
        return this.afu;
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public static synchronized b ti() {
        b bVar;
        synchronized (b.class) {
            if (aft == null) {
                aft = new b();
            }
            bVar = aft;
        }
        return bVar;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        return com.baidu.browser.core.util.c.S(this) ? d.c(str, this) : super.getSharedPreferences(str, i);
    }
}
