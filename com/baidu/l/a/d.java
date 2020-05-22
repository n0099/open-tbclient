package com.baidu.l.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes6.dex */
class d {
    private com.baidu.l.a.a.c miY;
    private static String TAG = "UnionIDFactory";
    private static boolean DEBUG = a.dsS();

    public d(Context context) {
        int dsT = b.dsT();
        if (DEBUG) {
            Log.e(TAG, "UnionIDFactory manufacturer:" + dsT);
        }
        switch (dsT) {
            case 10001:
                this.miY = new com.baidu.l.a.b.a(context);
                return;
            case 10002:
                if (DEBUG) {
                    Log.e(TAG, "UnionIDFactory XMUnionID");
                }
                this.miY = new com.baidu.l.a.b.c(context);
                return;
            default:
                this.miY = new com.baidu.l.a.b.b(context);
                return;
        }
    }

    public com.baidu.l.a.a.c dsU() {
        return this.miY;
    }
}
