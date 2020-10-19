package com.baidu.browser.core;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
/* loaded from: classes10.dex */
public class b extends ContextWrapper {
    private static b aes;
    private h aet;

    public b() {
        super(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.content.ContextWrapper, android.content.Context
    /* renamed from: te */
    public h getResources() {
        if (this.aet == null) {
            this.aet = new h(super.getResources(), getAssets(), super.getResources().getDisplayMetrics(), super.getResources().getConfiguration());
        }
        return this.aet;
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public static synchronized b tf() {
        b bVar;
        synchronized (b.class) {
            if (aes == null) {
                aes = new b();
            }
            bVar = aes;
        }
        return bVar;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        return com.baidu.browser.core.util.c.R(this) ? d.c(str, this) : super.getSharedPreferences(str, i);
    }
}
