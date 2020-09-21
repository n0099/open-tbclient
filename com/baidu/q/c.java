package com.baidu.q;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.baidu.q.a.e;
/* loaded from: classes12.dex */
public class c {
    private static c nrl;
    private Context mCtx;
    private static String TAG = "UnionIDHelper";
    private static boolean DEBUG = false;

    private c(Context context) {
        this.mCtx = context.getApplicationContext();
    }

    public static c gh(Context context) {
        if (nrl == null) {
            synchronized (c.class) {
                if (nrl == null) {
                    nrl = new c(context);
                    com.baidu.q.a.a.gi(context);
                }
            }
        }
        return nrl;
    }

    public void a(b bVar) {
        a(new d().Lk(1).xU(false), bVar, Looper.getMainLooper());
    }

    public void a(d dVar, final b bVar, Looper looper) {
        e.dQY().a(this.mCtx, looper, new com.baidu.q.a.a.b() { // from class: com.baidu.q.c.1
            @Override // com.baidu.q.a.a.b
            public void a(com.baidu.q.a.a.c cVar) {
                if (c.DEBUG) {
                    Log.d(c.TAG, "异步回调 结果:" + cVar);
                    Log.d(c.TAG, "异步回调 (listener != null):" + (bVar != null));
                }
                if (bVar != null) {
                    bVar.a(0, cVar == null ? null : new a(cVar.dQS(), cVar.isSupport(), cVar.getOAID(), cVar.getAAID(), cVar.getVAID(), cVar.getStatusCode()));
                }
            }
        });
    }

    public a dQU() {
        com.baidu.q.a.a.c gk = e.dQY().gk(this.mCtx);
        if (DEBUG) {
            Log.d(TAG, "同步 结果:" + gk);
        }
        if (gk == null) {
            return null;
        }
        return new a(gk.dQS(), gk.isSupport(), gk.getOAID(), gk.getAAID(), gk.getVAID(), gk.getStatusCode());
    }
}
