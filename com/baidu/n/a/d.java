package com.baidu.n.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes6.dex */
class d {
    private com.baidu.n.a.a.c oVy;
    private static String TAG = "UnionIDFactory";
    private static boolean DEBUG = a.eiD();

    public d(Context context) {
        int eiE = b.eiE();
        if (DEBUG) {
            Log.e(TAG, "UnionIDFactory manufacturer:" + eiE);
        }
        switch (eiE) {
            case 10001:
                this.oVy = new com.baidu.n.a.b.a(context);
                return;
            case 10002:
                if (DEBUG) {
                    Log.e(TAG, "UnionIDFactory XMUnionID");
                }
                this.oVy = new com.baidu.n.a.b.c(context);
                return;
            default:
                this.oVy = new com.baidu.n.a.b.b(context);
                return;
        }
    }

    public com.baidu.n.a.a.c eiF() {
        return this.oVy;
    }
}
