package com.baidu.prologue.service.network;

import android.content.Context;
/* loaded from: classes5.dex */
public final class c extends b {
    private static e cqt;
    private final e cqu;

    private c(Context context) {
        this.cqu = new h(context);
    }

    public static e bO(Context context) {
        if (cqt == null) {
            synchronized (e.class) {
                if (cqt == null) {
                    cqt = new c(context);
                }
            }
        }
        return cqt;
    }

    @Override // com.baidu.prologue.service.network.e
    public void a(Request request, l lVar) {
        this.cqu.a(request, lVar);
    }
}
