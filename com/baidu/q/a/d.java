package com.baidu.q.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes10.dex */
class d {
    private com.baidu.q.a.a.c nhf;
    private static String TAG = "UnionIDFactory";
    private static boolean DEBUG = a.dMO();

    public d(Context context) {
        int dMP = b.dMP();
        if (DEBUG) {
            Log.e(TAG, "UnionIDFactory manufacturer:" + dMP);
        }
        switch (dMP) {
            case 10001:
                this.nhf = new com.baidu.q.a.b.a(context);
                return;
            case 10002:
                if (DEBUG) {
                    Log.e(TAG, "UnionIDFactory XMUnionID");
                }
                this.nhf = new com.baidu.q.a.b.c(context);
                return;
            default:
                this.nhf = new com.baidu.q.a.b.b(context);
                return;
        }
    }

    public com.baidu.q.a.a.c dMQ() {
        return this.nhf;
    }
}
