package com.baidu.q.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes10.dex */
class d {
    private com.baidu.q.a.a.c nhx;
    private static String TAG = "UnionIDFactory";
    private static boolean DEBUG = a.dMX();

    public d(Context context) {
        int dMY = b.dMY();
        if (DEBUG) {
            Log.e(TAG, "UnionIDFactory manufacturer:" + dMY);
        }
        switch (dMY) {
            case 10001:
                this.nhx = new com.baidu.q.a.b.a(context);
                return;
            case 10002:
                if (DEBUG) {
                    Log.e(TAG, "UnionIDFactory XMUnionID");
                }
                this.nhx = new com.baidu.q.a.b.c(context);
                return;
            default:
                this.nhx = new com.baidu.q.a.b.b(context);
                return;
        }
    }

    public com.baidu.q.a.a.c dMZ() {
        return this.nhx;
    }
}
