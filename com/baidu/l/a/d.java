package com.baidu.l.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes6.dex */
class d {
    private com.baidu.l.a.a.c mGh;
    private static String TAG = "UnionIDFactory";
    private static boolean DEBUG = a.dxN();

    public d(Context context) {
        int dxO = b.dxO();
        if (DEBUG) {
            Log.e(TAG, "UnionIDFactory manufacturer:" + dxO);
        }
        switch (dxO) {
            case 10001:
                this.mGh = new com.baidu.l.a.b.a(context);
                return;
            case 10002:
                if (DEBUG) {
                    Log.e(TAG, "UnionIDFactory XMUnionID");
                }
                this.mGh = new com.baidu.l.a.b.c(context);
                return;
            default:
                this.mGh = new com.baidu.l.a.b.b(context);
                return;
        }
    }

    public com.baidu.l.a.a.c dxP() {
        return this.mGh;
    }
}
