package com.baidu.n.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes5.dex */
class d {
    private com.baidu.n.a.a.c lBM;
    private static String TAG = "UnionIDFactory";
    private static boolean DEBUG = a.dgD();

    public d(Context context) {
        int dgE = b.dgE();
        if (DEBUG) {
            Log.e(TAG, "UnionIDFactory manufacturer:" + dgE);
        }
        switch (dgE) {
            case 10001:
                this.lBM = new com.baidu.n.a.b.a(context);
                return;
            case 10002:
                if (DEBUG) {
                    Log.e(TAG, "UnionIDFactory XMUnionID");
                }
                this.lBM = new com.baidu.n.a.b.c(context);
                return;
            default:
                this.lBM = new com.baidu.n.a.b.b(context);
                return;
        }
    }

    public com.baidu.n.a.a.c dgF() {
        return this.lBM;
    }
}
