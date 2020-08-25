package com.baidu.prologue.service.network;

import android.content.Context;
/* loaded from: classes9.dex */
public final class c extends b {
    private static e bMl;
    private final e bMm;

    private c(Context context) {
        this.bMm = new h(context);
    }

    public static e aT(Context context) {
        if (bMl == null) {
            synchronized (e.class) {
                if (bMl == null) {
                    bMl = new c(context);
                }
            }
        }
        return bMl;
    }

    @Override // com.baidu.prologue.service.network.e
    public void a(Request request, l lVar) {
        this.bMm.a(request, lVar);
    }
}
