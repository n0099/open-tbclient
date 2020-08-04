package com.baidu.m.a.b;

import android.content.Context;
import android.util.Log;
import com.baidu.m.a.a.d;
/* loaded from: classes12.dex */
public class c extends d {
    private static String TAG = "XMUnionID";
    private static boolean DEBUG = com.baidu.m.a.a.dBa();

    public c(Context context) {
        super(context);
        if (DEBUG) {
            Log.e(TAG, "xiaomi XMUnionID !!");
        }
        this.mNX = "";
        this.mNV = false;
        this.mOy = false;
        this.mStatusCode = -200;
    }

    @Override // com.baidu.m.a.a.c
    public com.baidu.m.a.a.c dBh() {
        try {
            this.mOy = com.b.b.a.isSupported();
            this.mNX = com.b.b.a.gk(this.mCtx);
            this.mStatusCode = 0;
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "xiaomi init4UnionId error", e);
            }
        }
        return this;
    }
}
