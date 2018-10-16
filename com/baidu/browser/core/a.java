package com.baidu.browser.core;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;
/* loaded from: classes2.dex */
public class a extends ContextWrapper {
    private static a UC;
    private c UD;

    public a() {
        super(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.content.ContextWrapper, android.content.Context
    /* renamed from: qf */
    public c getResources() {
        if (this.UD == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.UD = new c(super.getResources(), getAssets(), super.getResources().getDisplayMetrics(), super.getResources().getConfiguration());
            Log.e("hejunwei", "new resources cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        }
        return this.UD;
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public static synchronized a qg() {
        a aVar;
        synchronized (a.class) {
            if (UC == null) {
                UC = new a();
            }
            aVar = UC;
        }
        return aVar;
    }
}
