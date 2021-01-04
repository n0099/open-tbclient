package com.baidu.browser.core;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
/* loaded from: classes4.dex */
public class b extends ContextWrapper {
    private static b afW;
    private h afX;

    public b() {
        super(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.content.ContextWrapper, android.content.Context
    /* renamed from: sH */
    public h getResources() {
        if (this.afX == null) {
            this.afX = new h(super.getResources(), getAssets(), super.getResources().getDisplayMetrics(), super.getResources().getConfiguration());
        }
        return this.afX;
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public static synchronized b sI() {
        b bVar;
        synchronized (b.class) {
            if (afW == null) {
                afW = new b();
            }
            bVar = afW;
        }
        return bVar;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        return com.baidu.browser.core.util.c.S(this) ? d.c(str, this) : super.getSharedPreferences(str, i);
    }
}
