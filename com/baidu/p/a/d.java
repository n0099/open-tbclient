package com.baidu.p.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes5.dex */
class d {
    private com.baidu.p.a.a.c oPt;
    private static String TAG = "UnionIDFactory";
    private static boolean DEBUG = a.ejW();

    public d(Context context) {
        int ejX = b.ejX();
        if (DEBUG) {
            Log.e(TAG, "UnionIDFactory manufacturer:" + ejX);
        }
        switch (ejX) {
            case 10001:
                this.oPt = new com.baidu.p.a.b.a(context);
                return;
            case 10002:
                if (DEBUG) {
                    Log.e(TAG, "UnionIDFactory XMUnionID");
                }
                this.oPt = new com.baidu.p.a.b.c(context);
                return;
            default:
                this.oPt = new com.baidu.p.a.b.b(context);
                return;
        }
    }

    public com.baidu.p.a.a.c ejY() {
        return this.oPt;
    }
}
