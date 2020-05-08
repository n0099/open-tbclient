package com.baidu.l.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes6.dex */
class d {
    private com.baidu.l.a.a.c lPH;
    private static String TAG = "UnionIDFactory";
    private static boolean DEBUG = a.dlC();

    public d(Context context) {
        int dlD = b.dlD();
        if (DEBUG) {
            Log.e(TAG, "UnionIDFactory manufacturer:" + dlD);
        }
        switch (dlD) {
            case 10001:
                this.lPH = new com.baidu.l.a.b.a(context);
                return;
            case 10002:
                if (DEBUG) {
                    Log.e(TAG, "UnionIDFactory XMUnionID");
                }
                this.lPH = new com.baidu.l.a.b.c(context);
                return;
            default:
                this.lPH = new com.baidu.l.a.b.b(context);
                return;
        }
    }

    public com.baidu.l.a.a.c dlE() {
        return this.lPH;
    }
}
