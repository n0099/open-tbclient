package com.baidu.browser.core;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;
/* loaded from: classes2.dex */
public class a extends ContextWrapper {
    private static a UN;
    private c UO;

    public a() {
        super(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.content.ContextWrapper, android.content.Context
    /* renamed from: qg */
    public c getResources() {
        if (this.UO == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.UO = new c(super.getResources(), getAssets(), super.getResources().getDisplayMetrics(), super.getResources().getConfiguration());
            Log.e("hejunwei", "new resources cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        }
        return this.UO;
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public static synchronized a qh() {
        a aVar;
        synchronized (a.class) {
            if (UN == null) {
                UN = new a();
            }
            aVar = UN;
        }
        return aVar;
    }
}
