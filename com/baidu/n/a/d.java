package com.baidu.n.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes4.dex */
class d {
    private com.baidu.n.a.a.c oXD;
    private static String TAG = "UnionIDFactory";
    private static boolean DEBUG = a.eiN();

    public d(Context context) {
        int eiO = b.eiO();
        if (DEBUG) {
            Log.e(TAG, "UnionIDFactory manufacturer:" + eiO);
        }
        switch (eiO) {
            case 10001:
                this.oXD = new com.baidu.n.a.b.a(context);
                return;
            case 10002:
                if (DEBUG) {
                    Log.e(TAG, "UnionIDFactory XMUnionID");
                }
                this.oXD = new com.baidu.n.a.b.c(context);
                return;
            default:
                this.oXD = new com.baidu.n.a.b.b(context);
                return;
        }
    }

    public com.baidu.n.a.a.c eiP() {
        return this.oXD;
    }
}
