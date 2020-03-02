package com.baidu.n.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes6.dex */
class d {
    private com.baidu.n.a.a.c lCv;
    private static String TAG = "UnionIDFactory";
    private static boolean DEBUG = a.dhT();

    public d(Context context) {
        int dhU = b.dhU();
        if (DEBUG) {
            Log.e(TAG, "UnionIDFactory manufacturer:" + dhU);
        }
        switch (dhU) {
            case 10001:
                this.lCv = new com.baidu.n.a.b.a(context);
                return;
            case 10002:
                if (DEBUG) {
                    Log.e(TAG, "UnionIDFactory XMUnionID");
                }
                this.lCv = new com.baidu.n.a.b.c(context);
                return;
            default:
                this.lCv = new com.baidu.n.a.b.b(context);
                return;
        }
    }

    public com.baidu.n.a.a.c dhV() {
        return this.lCv;
    }
}
