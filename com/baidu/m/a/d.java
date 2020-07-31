package com.baidu.m.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes12.dex */
class d {
    private com.baidu.m.a.a.c mOl;
    private static String TAG = "UnionIDFactory";
    private static boolean DEBUG = a.dAZ();

    public d(Context context) {
        int dBa = b.dBa();
        if (DEBUG) {
            Log.e(TAG, "UnionIDFactory manufacturer:" + dBa);
        }
        switch (dBa) {
            case 10001:
                this.mOl = new com.baidu.m.a.b.a(context);
                return;
            case 10002:
                if (DEBUG) {
                    Log.e(TAG, "UnionIDFactory XMUnionID");
                }
                this.mOl = new com.baidu.m.a.b.c(context);
                return;
            default:
                this.mOl = new com.baidu.m.a.b.b(context);
                return;
        }
    }

    public com.baidu.m.a.a.c dBb() {
        return this.mOl;
    }
}
