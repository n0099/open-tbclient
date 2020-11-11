package com.baidu.q.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes5.dex */
class d {
    private com.baidu.q.a.a.c osA;
    private static String TAG = "UnionIDFactory";
    private static boolean DEBUG = a.eeg();

    public d(Context context) {
        int eeh = b.eeh();
        if (DEBUG) {
            Log.e(TAG, "UnionIDFactory manufacturer:" + eeh);
        }
        switch (eeh) {
            case 10001:
                this.osA = new com.baidu.q.a.b.a(context);
                return;
            case 10002:
                if (DEBUG) {
                    Log.e(TAG, "UnionIDFactory XMUnionID");
                }
                this.osA = new com.baidu.q.a.b.c(context);
                return;
            default:
                this.osA = new com.baidu.q.a.b.b(context);
                return;
        }
    }

    public com.baidu.q.a.a.c eei() {
        return this.osA;
    }
}
