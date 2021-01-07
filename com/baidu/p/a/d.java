package com.baidu.p.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes5.dex */
class d {
    private com.baidu.p.a.a.c oPt;
    private static String TAG = "UnionIDFactory";
    private static boolean DEBUG = a.ejX();

    public d(Context context) {
        int ejY = b.ejY();
        if (DEBUG) {
            Log.e(TAG, "UnionIDFactory manufacturer:" + ejY);
        }
        switch (ejY) {
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

    public com.baidu.p.a.a.c ejZ() {
        return this.oPt;
    }
}
