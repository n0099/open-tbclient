package com.baidu.prologue.service.network;

import android.util.Log;
/* loaded from: classes6.dex */
class d {
    private static final int TIME_OUT = Math.max(200, com.baidu.prologue.a.b.a.brQ.get().LD());
    static final int CONNECT_TIME_OUT = TIME_OUT;
    static final int READ_TIME_OUT = TIME_OUT;
    static final int btS = TIME_OUT;

    static {
        Log.e("HttpRequestConstan", "static initializer: " + TIME_OUT + " " + CONNECT_TIME_OUT);
    }
}
