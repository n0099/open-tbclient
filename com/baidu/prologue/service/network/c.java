package com.baidu.prologue.service.network;

import android.content.Context;
/* loaded from: classes6.dex */
public final class c extends b {
    private static e bBy;
    private final e bBz;

    private c(Context context) {
        this.bBz = new h(context);
    }

    public static e aM(Context context) {
        if (bBy == null) {
            synchronized (e.class) {
                if (bBy == null) {
                    bBy = new c(context);
                }
            }
        }
        return bBy;
    }

    @Override // com.baidu.prologue.service.network.e
    public void a(Request request, l lVar) {
        this.bBz.a(request, lVar);
    }
}
