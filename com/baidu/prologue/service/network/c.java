package com.baidu.prologue.service.network;

import android.content.Context;
/* loaded from: classes14.dex */
public final class c extends b {
    private static e coe;
    private final e cof;

    private c(Context context) {
        this.cof = new h(context);
    }

    public static e bC(Context context) {
        if (coe == null) {
            synchronized (e.class) {
                if (coe == null) {
                    coe = new c(context);
                }
            }
        }
        return coe;
    }

    @Override // com.baidu.prologue.service.network.e
    public void a(Request request, l lVar) {
        this.cof.a(request, lVar);
    }
}
