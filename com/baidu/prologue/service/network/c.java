package com.baidu.prologue.service.network;

import android.content.Context;
/* loaded from: classes19.dex */
public final class c extends b {
    private static e cdx;
    private final e cdy;

    private c(Context context) {
        this.cdy = new h(context);
    }

    public static e aW(Context context) {
        if (cdx == null) {
            synchronized (e.class) {
                if (cdx == null) {
                    cdx = new c(context);
                }
            }
        }
        return cdx;
    }

    @Override // com.baidu.prologue.service.network.e
    public void a(Request request, l lVar) {
        this.cdy.a(request, lVar);
    }
}
