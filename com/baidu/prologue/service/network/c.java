package com.baidu.prologue.service.network;

import android.content.Context;
/* loaded from: classes6.dex */
public final class c extends b {
    private static e btU;
    private final e btV;

    private c(Context context) {
        this.btV = new h(context);
    }

    public static e aC(Context context) {
        if (btU == null) {
            synchronized (e.class) {
                if (btU == null) {
                    btU = new c(context);
                }
            }
        }
        return btU;
    }

    @Override // com.baidu.prologue.service.network.e
    public void a(Request request, l lVar) {
        this.btV.a(request, lVar);
    }
}
