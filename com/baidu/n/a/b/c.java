package com.baidu.n.a.b;

import android.content.Context;
import android.util.Log;
import com.baidu.n.a.a.d;
/* loaded from: classes5.dex */
public class c extends d {
    private static String TAG = "XMUnionID";
    private static boolean DEBUG = com.baidu.n.a.a.dgB();

    public c(Context context) {
        super(context);
        if (DEBUG) {
            Log.e(TAG, "xiaomi XMUnionID !!");
        }
        this.lBr = "";
        this.lBp = false;
        this.lBS = false;
        this.mStatusCode = -200;
    }

    @Override // com.baidu.n.a.a.c
    public com.baidu.n.a.a.c dgI() {
        try {
            this.lBS = com.c.b.a.isSupported();
            this.lBr = com.c.b.a.gw(this.mCtx);
            this.mStatusCode = 0;
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "xiaomi init4UnionId error", e);
            }
        }
        return this;
    }
}
