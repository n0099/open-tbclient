package com.baidu.q.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes25.dex */
class d {
    private com.baidu.q.a.a.c nry;
    private static String TAG = "UnionIDFactory";
    private static boolean DEBUG = a.dQV();

    public d(Context context) {
        int dQW = b.dQW();
        if (DEBUG) {
            Log.e(TAG, "UnionIDFactory manufacturer:" + dQW);
        }
        switch (dQW) {
            case 10001:
                this.nry = new com.baidu.q.a.b.a(context);
                return;
            case 10002:
                if (DEBUG) {
                    Log.e(TAG, "UnionIDFactory XMUnionID");
                }
                this.nry = new com.baidu.q.a.b.c(context);
                return;
            default:
                this.nry = new com.baidu.q.a.b.b(context);
                return;
        }
    }

    public com.baidu.q.a.a.c dQX() {
        return this.nry;
    }
}
