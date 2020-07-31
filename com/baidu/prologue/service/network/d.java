package com.baidu.prologue.service.network;

import android.util.Log;
/* loaded from: classes8.dex */
class d {
    private static final int TIME_OUT = Math.max(200, com.baidu.prologue.a.b.a.bEI.get().Pk());
    static final int CONNECT_TIME_OUT = TIME_OUT;
    static final int READ_TIME_OUT = TIME_OUT;
    static final int bGN = TIME_OUT;

    static {
        Log.e("HttpRequestConstan", "static initializer: " + TIME_OUT + " " + CONNECT_TIME_OUT);
    }
}
