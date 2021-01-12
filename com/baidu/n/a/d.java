package com.baidu.n.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes4.dex */
class d {
    private com.baidu.n.a.a.c oKR;
    private static String TAG = "UnionIDFactory";
    private static boolean DEBUG = a.egd();

    public d(Context context) {
        int ege = b.ege();
        if (DEBUG) {
            Log.e(TAG, "UnionIDFactory manufacturer:" + ege);
        }
        switch (ege) {
            case 10001:
                this.oKR = new com.baidu.n.a.b.a(context);
                return;
            case 10002:
                if (DEBUG) {
                    Log.e(TAG, "UnionIDFactory XMUnionID");
                }
                this.oKR = new com.baidu.n.a.b.c(context);
                return;
            default:
                this.oKR = new com.baidu.n.a.b.b(context);
                return;
        }
    }

    public com.baidu.n.a.a.c egf() {
        return this.oKR;
    }
}
