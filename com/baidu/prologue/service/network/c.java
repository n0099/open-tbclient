package com.baidu.prologue.service.network;

import android.content.Context;
/* loaded from: classes8.dex */
public final class c extends b {
    private static e bGL;
    private final e bGM;

    private c(Context context) {
        this.bGM = new h(context);
    }

    public static e aO(Context context) {
        if (bGL == null) {
            synchronized (e.class) {
                if (bGL == null) {
                    bGL = new c(context);
                }
            }
        }
        return bGL;
    }

    @Override // com.baidu.prologue.service.network.e
    public void a(Request request, l lVar) {
        this.bGM.a(request, lVar);
    }
}
