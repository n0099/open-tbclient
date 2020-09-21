package com.baidu.prologue.service.network;

import android.content.Context;
/* loaded from: classes10.dex */
public final class c extends b {
    private static e bOp;
    private final e bOq;

    private c(Context context) {
        this.bOq = new h(context);
    }

    public static e aS(Context context) {
        if (bOp == null) {
            synchronized (e.class) {
                if (bOp == null) {
                    bOp = new c(context);
                }
            }
        }
        return bOp;
    }

    @Override // com.baidu.prologue.service.network.e
    public void a(Request request, l lVar) {
        this.bOq.a(request, lVar);
    }
}
