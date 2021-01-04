package com.baidu.prologue.service.network;

import android.content.Context;
/* loaded from: classes5.dex */
public final class c extends b {
    private static e cvl;
    private final e cvm;

    private c(Context context) {
        this.cvm = new h(context);
    }

    public static e bP(Context context) {
        if (cvl == null) {
            synchronized (e.class) {
                if (cvl == null) {
                    cvl = new c(context);
                }
            }
        }
        return cvl;
    }

    @Override // com.baidu.prologue.service.network.e
    public void a(Request request, l lVar) {
        this.cvm.a(request, lVar);
    }
}
