package com.baidu.n.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes6.dex */
class d {
    private com.baidu.n.a.a.c lCt;
    private static String TAG = "UnionIDFactory";
    private static boolean DEBUG = a.dhR();

    public d(Context context) {
        int dhS = b.dhS();
        if (DEBUG) {
            Log.e(TAG, "UnionIDFactory manufacturer:" + dhS);
        }
        switch (dhS) {
            case 10001:
                this.lCt = new com.baidu.n.a.b.a(context);
                return;
            case 10002:
                if (DEBUG) {
                    Log.e(TAG, "UnionIDFactory XMUnionID");
                }
                this.lCt = new com.baidu.n.a.b.c(context);
                return;
            default:
                this.lCt = new com.baidu.n.a.b.b(context);
                return;
        }
    }

    public com.baidu.n.a.a.c dhT() {
        return this.lCt;
    }
}
