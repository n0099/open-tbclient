package com.baidu.n.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes5.dex */
class d {
    private com.baidu.n.a.a.c lBH;
    private static String TAG = "UnionIDFactory";
    private static boolean DEBUG = a.dgB();

    public d(Context context) {
        int dgC = b.dgC();
        if (DEBUG) {
            Log.e(TAG, "UnionIDFactory manufacturer:" + dgC);
        }
        switch (dgC) {
            case 10001:
                this.lBH = new com.baidu.n.a.b.a(context);
                return;
            case 10002:
                if (DEBUG) {
                    Log.e(TAG, "UnionIDFactory XMUnionID");
                }
                this.lBH = new com.baidu.n.a.b.c(context);
                return;
            default:
                this.lBH = new com.baidu.n.a.b.b(context);
                return;
        }
    }

    public com.baidu.n.a.a.c dgD() {
        return this.lBH;
    }
}
