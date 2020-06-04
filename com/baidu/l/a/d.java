package com.baidu.l.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes6.dex */
class d {
    private com.baidu.l.a.a.c mki;
    private static String TAG = "UnionIDFactory";
    private static boolean DEBUG = a.dtg();

    public d(Context context) {
        int dth = b.dth();
        if (DEBUG) {
            Log.e(TAG, "UnionIDFactory manufacturer:" + dth);
        }
        switch (dth) {
            case 10001:
                this.mki = new com.baidu.l.a.b.a(context);
                return;
            case 10002:
                if (DEBUG) {
                    Log.e(TAG, "UnionIDFactory XMUnionID");
                }
                this.mki = new com.baidu.l.a.b.c(context);
                return;
            default:
                this.mki = new com.baidu.l.a.b.b(context);
                return;
        }
    }

    public com.baidu.l.a.a.c dti() {
        return this.mki;
    }
}
