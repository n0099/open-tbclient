package com.baidu.prologue.business;

import android.content.Context;
/* loaded from: classes19.dex */
public final class e {
    public static com.baidu.prologue.business.c.b a(Context context, com.baidu.prologue.business.data.e eVar, d dVar) {
        com.baidu.prologue.business.b.a cVar;
        com.baidu.prologue.business.c.b dVar2;
        if (eVar.Yg()) {
            cVar = new com.baidu.prologue.business.b.b(context, eVar);
            dVar2 = new com.baidu.prologue.business.c.c(context);
        } else {
            cVar = new com.baidu.prologue.business.b.c(context, eVar);
            dVar2 = new com.baidu.prologue.business.c.d(context);
        }
        cVar.a(dVar);
        dVar2.a(cVar);
        return dVar2;
    }
}
