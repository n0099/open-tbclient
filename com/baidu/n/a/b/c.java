package com.baidu.n.a.b;

import android.content.Context;
import android.util.Log;
import com.baidu.n.a.a.d;
/* loaded from: classes4.dex */
public class c extends d {
    private static String TAG = "XMUnionID";
    private static boolean DEBUG = com.baidu.n.a.a.egd();

    public c(Context context) {
        super(context);
        if (DEBUG) {
            Log.e(TAG, "xiaomi XMUnionID !!");
        }
        this.oKB = "";
        this.oKz = false;
        this.oLb = false;
        this.mStatusCode = -200;
    }

    @Override // com.baidu.n.a.a.c
    public com.baidu.n.a.a.c egk() {
        try {
            this.oLb = com.b.b.a.isSupported();
            this.oKB = com.b.b.a.cf(this.mCtx);
            this.mStatusCode = 0;
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "xiaomi init4UnionId error", e);
            }
        }
        return this;
    }
}
