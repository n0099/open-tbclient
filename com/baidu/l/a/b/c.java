package com.baidu.l.a.b;

import android.content.Context;
import android.util.Log;
import com.baidu.l.a.a.d;
/* loaded from: classes6.dex */
public class c extends d {
    private static String TAG = "XMUnionID";
    private static boolean DEBUG = com.baidu.l.a.a.dxN();

    public c(Context context) {
        super(context);
        if (DEBUG) {
            Log.e(TAG, "xiaomi XMUnionID !!");
        }
        this.mFR = "";
        this.mFP = false;
        this.mGs = false;
        this.mStatusCode = -200;
    }

    @Override // com.baidu.l.a.a.c
    public com.baidu.l.a.a.c dxU() {
        try {
            this.mGs = com.b.b.a.isSupported();
            this.mFR = com.b.b.a.gc(this.mCtx);
            this.mStatusCode = 0;
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "xiaomi init4UnionId error", e);
            }
        }
        return this;
    }
}
