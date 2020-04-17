package com.baidu.prologue.service.network;

import android.content.Context;
/* loaded from: classes6.dex */
public final class c extends b {
    private static e btQ;
    private final e btR;

    private c(Context context) {
        this.btR = new h(context);
    }

    public static e aO(Context context) {
        if (btQ == null) {
            synchronized (e.class) {
                if (btQ == null) {
                    btQ = new c(context);
                }
            }
        }
        return btQ;
    }

    @Override // com.baidu.prologue.service.network.e
    public void a(Request request, l lVar) {
        this.btR.a(request, lVar);
    }
}
