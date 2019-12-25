package com.baidu.n.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes4.dex */
class d {
    private com.baidu.n.a.a.c lyi;
    private static String TAG = "UnionIDFactory";
    private static boolean DEBUG = a.dfz();

    public d(Context context) {
        int dfA = b.dfA();
        if (DEBUG) {
            Log.e(TAG, "UnionIDFactory manufacturer:" + dfA);
        }
        switch (dfA) {
            case 10001:
                this.lyi = new com.baidu.n.a.b.a(context);
                return;
            case 10002:
                if (DEBUG) {
                    Log.e(TAG, "UnionIDFactory XMUnionID");
                }
                this.lyi = new com.baidu.n.a.b.c(context);
                return;
            default:
                this.lyi = new com.baidu.n.a.b.b(context);
                return;
        }
    }

    public com.baidu.n.a.a.c dfB() {
        return this.lyi;
    }
}
