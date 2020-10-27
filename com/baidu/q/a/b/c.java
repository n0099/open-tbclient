package com.baidu.q.a.b;

import android.content.Context;
import android.util.Log;
import com.baidu.q.a.a.d;
/* loaded from: classes5.dex */
public class c extends d {
    private static String TAG = "XMUnionID";
    private static boolean DEBUG = com.baidu.q.a.a.eay();

    public c(Context context) {
        super(context);
        if (DEBUG) {
            Log.e(TAG, "xiaomi XMUnionID !!");
        }
        this.oje = "";
        this.ojc = false;
        this.ojF = false;
        this.mStatusCode = -200;
    }

    @Override // com.baidu.q.a.a.c
    public com.baidu.q.a.a.c eaF() {
        try {
            this.ojF = com.a.b.a.isSupported();
            this.oje = com.a.b.a.bt(this.mCtx);
            this.mStatusCode = 0;
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "xiaomi init4UnionId error", e);
            }
        }
        return this;
    }
}
