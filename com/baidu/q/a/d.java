package com.baidu.q.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes7.dex */
class d {
    private com.baidu.q.a.a.c oud;
    private static String TAG = "UnionIDFactory";
    private static boolean DEBUG = a.eed();

    public d(Context context) {
        int eee = b.eee();
        if (DEBUG) {
            Log.e(TAG, "UnionIDFactory manufacturer:" + eee);
        }
        switch (eee) {
            case 10001:
                this.oud = new com.baidu.q.a.b.a(context);
                return;
            case 10002:
                if (DEBUG) {
                    Log.e(TAG, "UnionIDFactory XMUnionID");
                }
                this.oud = new com.baidu.q.a.b.c(context);
                return;
            default:
                this.oud = new com.baidu.q.a.b.b(context);
                return;
        }
    }

    public com.baidu.q.a.a.c eef() {
        return this.oud;
    }
}
