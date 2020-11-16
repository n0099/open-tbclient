package com.baidu.q.a.b;

import android.content.Context;
import android.util.Log;
import com.baidu.q.a.a.d;
/* loaded from: classes7.dex */
public class c extends d {
    private static String TAG = "XMUnionID";
    private static boolean DEBUG = com.baidu.q.a.a.eed();

    public c(Context context) {
        super(context);
        if (DEBUG) {
            Log.e(TAG, "xiaomi XMUnionID !!");
        }
        this.otN = "";
        this.otL = false;
        this.oun = false;
        this.mStatusCode = -200;
    }

    @Override // com.baidu.q.a.a.c
    public com.baidu.q.a.a.c eek() {
        try {
            this.oun = com.a.b.a.isSupported();
            this.otN = com.a.b.a.bt(this.mCtx);
            this.mStatusCode = 0;
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "xiaomi init4UnionId error", e);
            }
        }
        return this;
    }
}
