package com.baidu.prologue.service.network;

import android.content.Context;
/* loaded from: classes6.dex */
public final class c extends b {
    private static e bGm;
    private final e bGn;

    private c(Context context) {
        this.bGn = new h(context);
    }

    public static e aN(Context context) {
        if (bGm == null) {
            synchronized (e.class) {
                if (bGm == null) {
                    bGm = new c(context);
                }
            }
        }
        return bGm;
    }

    @Override // com.baidu.prologue.service.network.e
    public void a(Request request, l lVar) {
        this.bGn.a(request, lVar);
    }
}
