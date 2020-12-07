package com.baidu.r.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes14.dex */
class d {
    private com.baidu.r.a.a.c oJk;
    private static String TAG = "UnionIDFactory";
    private static boolean DEBUG = a.ejQ();

    public d(Context context) {
        int ejR = b.ejR();
        if (DEBUG) {
            Log.e(TAG, "UnionIDFactory manufacturer:" + ejR);
        }
        switch (ejR) {
            case 10001:
                this.oJk = new com.baidu.r.a.b.a(context);
                return;
            case 10002:
                if (DEBUG) {
                    Log.e(TAG, "UnionIDFactory XMUnionID");
                }
                this.oJk = new com.baidu.r.a.b.c(context);
                return;
            default:
                this.oJk = new com.baidu.r.a.b.b(context);
                return;
        }
    }

    public com.baidu.r.a.a.c ejS() {
        return this.oJk;
    }
}
