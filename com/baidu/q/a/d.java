package com.baidu.q.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes5.dex */
class d {
    private com.baidu.q.a.a.c nGS;
    private static String TAG = "UnionIDFactory";
    private static boolean DEBUG = a.dUG();

    public d(Context context) {
        int dUH = b.dUH();
        if (DEBUG) {
            Log.e(TAG, "UnionIDFactory manufacturer:" + dUH);
        }
        switch (dUH) {
            case 10001:
                this.nGS = new com.baidu.q.a.b.a(context);
                return;
            case 10002:
                if (DEBUG) {
                    Log.e(TAG, "UnionIDFactory XMUnionID");
                }
                this.nGS = new com.baidu.q.a.b.c(context);
                return;
            default:
                this.nGS = new com.baidu.q.a.b.b(context);
                return;
        }
    }

    public com.baidu.q.a.a.c dUI() {
        return this.nGS;
    }
}
