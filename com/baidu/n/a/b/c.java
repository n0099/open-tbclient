package com.baidu.n.a.b;

import android.content.Context;
import android.util.Log;
import com.baidu.n.a.a.d;
/* loaded from: classes6.dex */
public class c extends d {
    private static String TAG = "XMUnionID";
    private static boolean DEBUG = com.baidu.n.a.a.eiD();

    public c(Context context) {
        super(context);
        if (DEBUG) {
            Log.e(TAG, "xiaomi XMUnionID !!");
        }
        this.oVj = "";
        this.oVi = false;
        this.oVI = false;
        this.mStatusCode = -200;
    }

    @Override // com.baidu.n.a.a.c
    public com.baidu.n.a.a.c eiK() {
        try {
            this.oVI = com.b.b.a.isSupported();
            this.oVj = com.b.b.a.ce(this.mCtx);
            this.mStatusCode = 0;
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "xiaomi init4UnionId error", e);
            }
        }
        return this;
    }
}
