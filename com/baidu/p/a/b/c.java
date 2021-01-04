package com.baidu.p.a.b;

import android.content.Context;
import android.util.Log;
import com.baidu.p.a.a.d;
/* loaded from: classes5.dex */
public class c extends d {
    private static String TAG = "XMUnionID";
    private static boolean DEBUG = com.baidu.p.a.a.ejW();

    public c(Context context) {
        super(context);
        if (DEBUG) {
            Log.e(TAG, "xiaomi XMUnionID !!");
        }
        this.oPd = "";
        this.oPb = false;
        this.oPD = false;
        this.mStatusCode = -200;
    }

    @Override // com.baidu.p.a.a.c
    public com.baidu.p.a.a.c ekd() {
        try {
            this.oPD = com.b.b.a.isSupported();
            this.oPd = com.b.b.a.cg(this.mCtx);
            this.mStatusCode = 0;
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "xiaomi init4UnionId error", e);
            }
        }
        return this;
    }
}
