package com.baidu.q.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes5.dex */
class d {
    private com.baidu.q.a.a.c oju;
    private static String TAG = "UnionIDFactory";
    private static boolean DEBUG = a.eay();

    public d(Context context) {
        int eaz = b.eaz();
        if (DEBUG) {
            Log.e(TAG, "UnionIDFactory manufacturer:" + eaz);
        }
        switch (eaz) {
            case 10001:
                this.oju = new com.baidu.q.a.b.a(context);
                return;
            case 10002:
                if (DEBUG) {
                    Log.e(TAG, "UnionIDFactory XMUnionID");
                }
                this.oju = new com.baidu.q.a.b.c(context);
                return;
            default:
                this.oju = new com.baidu.q.a.b.b(context);
                return;
        }
    }

    public com.baidu.q.a.a.c eaA() {
        return this.oju;
    }
}
