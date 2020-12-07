package com.baidu.r.a.b;

import android.content.Context;
import android.util.Log;
import com.baidu.r.a.a.d;
/* loaded from: classes14.dex */
public class c extends d {
    private static String TAG = "XMUnionID";
    private static boolean DEBUG = com.baidu.r.a.a.ejQ();

    public c(Context context) {
        super(context);
        if (DEBUG) {
            Log.e(TAG, "xiaomi XMUnionID !!");
        }
        this.oIU = "";
        this.oIS = false;
        this.oJu = false;
        this.mStatusCode = -200;
    }

    @Override // com.baidu.r.a.a.c
    public com.baidu.r.a.a.c ejX() {
        try {
            this.oJu = com.a.b.a.isSupported();
            this.oIU = com.a.b.a.bZ(this.mCtx);
            this.mStatusCode = 0;
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "xiaomi init4UnionId error", e);
            }
        }
        return this;
    }
}
