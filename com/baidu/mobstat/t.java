package com.baidu.mobstat;

import android.content.Context;
/* loaded from: classes2.dex */
public class t {
    public static synchronized a a(Context context) {
        u uVar;
        synchronized (t.class) {
            ba.c().a("getBPStretegyController begin");
            uVar = new u();
            ba.c().a("Get BPStretegyController load local class");
            v.a(context, uVar);
            ba.c().a("getBPStretegyController end");
        }
        return uVar;
    }
}
