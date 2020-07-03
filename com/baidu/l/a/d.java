package com.baidu.l.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes6.dex */
class d {
    private com.baidu.l.a.a.c mGe;
    private static String TAG = "UnionIDFactory";
    private static boolean DEBUG = a.dxJ();

    public d(Context context) {
        int dxK = b.dxK();
        if (DEBUG) {
            Log.e(TAG, "UnionIDFactory manufacturer:" + dxK);
        }
        switch (dxK) {
            case 10001:
                this.mGe = new com.baidu.l.a.b.a(context);
                return;
            case 10002:
                if (DEBUG) {
                    Log.e(TAG, "UnionIDFactory XMUnionID");
                }
                this.mGe = new com.baidu.l.a.b.c(context);
                return;
            default:
                this.mGe = new com.baidu.l.a.b.b(context);
                return;
        }
    }

    public com.baidu.l.a.a.c dxL() {
        return this.mGe;
    }
}
