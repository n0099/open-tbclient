package com.baidu.n.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes6.dex */
class d {
    private com.baidu.n.a.a.c lCG;
    private static String TAG = "UnionIDFactory";
    private static boolean DEBUG = a.dhU();

    public d(Context context) {
        int dhV = b.dhV();
        if (DEBUG) {
            Log.e(TAG, "UnionIDFactory manufacturer:" + dhV);
        }
        switch (dhV) {
            case 10001:
                this.lCG = new com.baidu.n.a.b.a(context);
                return;
            case 10002:
                if (DEBUG) {
                    Log.e(TAG, "UnionIDFactory XMUnionID");
                }
                this.lCG = new com.baidu.n.a.b.c(context);
                return;
            default:
                this.lCG = new com.baidu.n.a.b.b(context);
                return;
        }
    }

    public com.baidu.n.a.a.c dhW() {
        return this.lCG;
    }
}
