package com.baidu.n;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.baidu.n.a.e;
/* loaded from: classes5.dex */
public class c {
    private static c lBz;
    private Context mCtx;
    private static String TAG = "UnionIDHelper";
    private static boolean DEBUG = false;

    private c(Context context) {
        this.mCtx = context.getApplicationContext();
    }

    public static c ge(Context context) {
        if (lBz == null) {
            synchronized (c.class) {
                if (lBz == null) {
                    lBz = new c(context);
                    com.baidu.n.a.a.gf(context);
                }
            }
        }
        return lBz;
    }

    public void a(b bVar) {
        a(new d().GW(1).uR(false), bVar, Looper.getMainLooper());
    }

    public void a(d dVar, final b bVar, Looper looper) {
        e.dgG().a(this.mCtx, looper, new com.baidu.n.a.a.b() { // from class: com.baidu.n.c.1
            @Override // com.baidu.n.a.a.b
            public void a(com.baidu.n.a.a.c cVar) {
                if (c.DEBUG) {
                    Log.d(c.TAG, "异步回调 结果:" + cVar);
                    Log.d(c.TAG, "异步回调 (listener != null):" + (bVar != null));
                }
                if (bVar != null) {
                    bVar.a(0, cVar == null ? null : new a(cVar.dgA(), cVar.isSupport(), cVar.dgL(), cVar.dgM(), cVar.dgN(), cVar.getStatusCode()));
                }
            }
        });
    }

    public a dgC() {
        com.baidu.n.a.a.c gh = e.dgG().gh(this.mCtx);
        if (DEBUG) {
            Log.d(TAG, "同步 结果:" + gh);
        }
        if (gh == null) {
            return null;
        }
        return new a(gh.dgA(), gh.isSupport(), gh.dgL(), gh.dgM(), gh.dgN(), gh.getStatusCode());
    }
}
