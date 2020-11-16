package com.baidu.prologue.service.network;

import android.content.Context;
/* loaded from: classes14.dex */
public final class c extends b {
    private static e chw;
    private final e chx;

    private c(Context context) {
        this.chx = new h(context);
    }

    public static e aW(Context context) {
        if (chw == null) {
            synchronized (e.class) {
                if (chw == null) {
                    chw = new c(context);
                }
            }
        }
        return chw;
    }

    @Override // com.baidu.prologue.service.network.e
    public void a(Request request, l lVar) {
        this.chx.a(request, lVar);
    }
}
