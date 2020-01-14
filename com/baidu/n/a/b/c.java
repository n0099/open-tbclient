package com.baidu.n.a.b;

import android.content.Context;
import android.util.Log;
import com.baidu.n.a.a.d;
/* loaded from: classes5.dex */
public class c extends d {
    private static String TAG = "XMUnionID";
    private static boolean DEBUG = com.baidu.n.a.a.dgD();

    public c(Context context) {
        super(context);
        if (DEBUG) {
            Log.e(TAG, "xiaomi XMUnionID !!");
        }
        this.lBw = "";
        this.lBu = false;
        this.lBX = false;
        this.mStatusCode = -200;
    }

    @Override // com.baidu.n.a.a.c
    public com.baidu.n.a.a.c dgK() {
        try {
            this.lBX = com.c.b.a.isSupported();
            this.lBw = com.c.b.a.gw(this.mCtx);
            this.mStatusCode = 0;
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "xiaomi init4UnionId error", e);
            }
        }
        return this;
    }
}
