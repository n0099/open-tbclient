package com.baidu.n.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes6.dex */
class d {
    private com.baidu.n.a.a.c oUY;
    private static String TAG = "UnionIDFactory";
    private static boolean DEBUG = a.eiv();

    public d(Context context) {
        int eiw = b.eiw();
        if (DEBUG) {
            Log.e(TAG, "UnionIDFactory manufacturer:" + eiw);
        }
        switch (eiw) {
            case 10001:
                this.oUY = new com.baidu.n.a.b.a(context);
                return;
            case 10002:
                if (DEBUG) {
                    Log.e(TAG, "UnionIDFactory XMUnionID");
                }
                this.oUY = new com.baidu.n.a.b.c(context);
                return;
            default:
                this.oUY = new com.baidu.n.a.b.b(context);
                return;
        }
    }

    public com.baidu.n.a.a.c eix() {
        return this.oUY;
    }
}
