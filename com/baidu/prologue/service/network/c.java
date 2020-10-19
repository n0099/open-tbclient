package com.baidu.prologue.service.network;

import android.content.Context;
/* loaded from: classes19.dex */
public final class c extends b {
    private static e bUY;
    private final e bUZ;

    private c(Context context) {
        this.bUZ = new h(context);
    }

    public static e aW(Context context) {
        if (bUY == null) {
            synchronized (e.class) {
                if (bUY == null) {
                    bUY = new c(context);
                }
            }
        }
        return bUY;
    }

    @Override // com.baidu.prologue.service.network.e
    public void a(Request request, l lVar) {
        this.bUZ.a(request, lVar);
    }
}
