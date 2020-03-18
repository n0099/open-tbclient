package com.baidu.n.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes6.dex */
class d {
    private com.baidu.n.a.a.c lEk;
    private static String TAG = "UnionIDFactory";
    private static boolean DEBUG = a.dir();

    public d(Context context) {
        int dis = b.dis();
        if (DEBUG) {
            Log.e(TAG, "UnionIDFactory manufacturer:" + dis);
        }
        switch (dis) {
            case 10001:
                this.lEk = new com.baidu.n.a.b.a(context);
                return;
            case 10002:
                if (DEBUG) {
                    Log.e(TAG, "UnionIDFactory XMUnionID");
                }
                this.lEk = new com.baidu.n.a.b.c(context);
                return;
            default:
                this.lEk = new com.baidu.n.a.b.b(context);
                return;
        }
    }

    public com.baidu.n.a.a.c dit() {
        return this.lEk;
    }
}
