package com.baidu.n.a.b;

import android.content.Context;
import android.util.Log;
import com.baidu.n.a.a.d;
/* loaded from: classes6.dex */
public class c extends d {
    private static String TAG = "XMUnionID";
    private static boolean DEBUG = com.baidu.n.a.a.dir();

    public c(Context context) {
        super(context);
        if (DEBUG) {
            Log.e(TAG, "xiaomi XMUnionID !!");
        }
        this.lDU = "";
        this.lDS = false;
        this.lEv = false;
        this.mStatusCode = -200;
    }

    @Override // com.baidu.n.a.a.c
    public com.baidu.n.a.a.c diy() {
        try {
            this.lEv = com.c.b.a.isSupported();
            this.lDU = com.c.b.a.gu(this.mCtx);
            this.mStatusCode = 0;
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "xiaomi init4UnionId error", e);
            }
        }
        return this;
    }
}
