package com.baidu.prologue.service.network;

import android.content.Context;
/* loaded from: classes19.dex */
public final class c extends b {
    private static e cji;
    private final e cjj;

    private c(Context context) {
        this.cjj = new h(context);
    }

    public static e aW(Context context) {
        if (cji == null) {
            synchronized (e.class) {
                if (cji == null) {
                    cji = new c(context);
                }
            }
        }
        return cji;
    }

    @Override // com.baidu.prologue.service.network.e
    public void a(Request request, l lVar) {
        this.cjj.a(request, lVar);
    }
}
