package com.baidu.r.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes14.dex */
class d {
    private com.baidu.r.a.a.c oJm;
    private static String TAG = "UnionIDFactory";
    private static boolean DEBUG = a.ejR();

    public d(Context context) {
        int ejS = b.ejS();
        if (DEBUG) {
            Log.e(TAG, "UnionIDFactory manufacturer:" + ejS);
        }
        switch (ejS) {
            case 10001:
                this.oJm = new com.baidu.r.a.b.a(context);
                return;
            case 10002:
                if (DEBUG) {
                    Log.e(TAG, "UnionIDFactory XMUnionID");
                }
                this.oJm = new com.baidu.r.a.b.c(context);
                return;
            default:
                this.oJm = new com.baidu.r.a.b.b(context);
                return;
        }
    }

    public com.baidu.r.a.a.c ejT() {
        return this.oJm;
    }
}
