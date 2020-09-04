package com.baidu.prologue.service.network;

import android.content.Context;
/* loaded from: classes9.dex */
public final class c extends b {
    private static e bMp;
    private final e bMq;

    private c(Context context) {
        this.bMq = new h(context);
    }

    public static e aT(Context context) {
        if (bMp == null) {
            synchronized (e.class) {
                if (bMp == null) {
                    bMp = new c(context);
                }
            }
        }
        return bMp;
    }

    @Override // com.baidu.prologue.service.network.e
    public void a(Request request, l lVar) {
        this.bMq.a(request, lVar);
    }
}
