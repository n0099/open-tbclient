package com.baidu.l.a.b;

import android.content.Context;
import android.util.Log;
import com.baidu.l.a.a.d;
/* loaded from: classes6.dex */
public class c extends d {
    private static String TAG = "XMUnionID";
    private static boolean DEBUG = com.baidu.l.a.a.dsS();

    public c(Context context) {
        super(context);
        if (DEBUG) {
            Log.e(TAG, "xiaomi XMUnionID !!");
        }
        this.miI = "";
        this.miG = false;
        this.mjj = false;
        this.mStatusCode = -200;
    }

    @Override // com.baidu.l.a.a.c
    public com.baidu.l.a.a.c dsZ() {
        try {
            this.mjj = com.b.b.a.isSupported();
            this.miI = com.b.b.a.gb(this.mCtx);
            this.mStatusCode = 0;
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "xiaomi init4UnionId error", e);
            }
        }
        return this;
    }
}
