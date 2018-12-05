package com.baidu.browser.core;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;
/* loaded from: classes2.dex */
public class a extends ContextWrapper {
    private static a UE;
    private c UF;

    public a() {
        super(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.content.ContextWrapper, android.content.Context
    /* renamed from: qc */
    public c getResources() {
        if (this.UF == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.UF = new c(super.getResources(), getAssets(), super.getResources().getDisplayMetrics(), super.getResources().getConfiguration());
            Log.e("hejunwei", "new resources cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        }
        return this.UF;
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public static synchronized a qd() {
        a aVar;
        synchronized (a.class) {
            if (UE == null) {
                UE = new a();
            }
            aVar = UE;
        }
        return aVar;
    }
}
