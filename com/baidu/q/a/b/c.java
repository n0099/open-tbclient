package com.baidu.q.a.b;

import android.content.Context;
import android.util.Log;
import com.baidu.q.a.a.d;
/* loaded from: classes10.dex */
public class c extends d {
    private static String TAG = "XMUnionID";
    private static boolean DEBUG = com.baidu.q.a.a.dMO();

    public c(Context context) {
        super(context);
        if (DEBUG) {
            Log.e(TAG, "xiaomi XMUnionID !!");
        }
        this.ngP = "";
        this.ngN = false;
        this.nhq = false;
        this.mStatusCode = -200;
    }

    @Override // com.baidu.q.a.a.c
    public com.baidu.q.a.a.c dMV() {
        try {
            this.nhq = com.a.b.a.isSupported();
            this.ngP = com.a.b.a.bo(this.mCtx);
            this.mStatusCode = 0;
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "xiaomi init4UnionId error", e);
            }
        }
        return this;
    }
}
