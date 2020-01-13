package com.baidu.n;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.baidu.n.a.e;
/* loaded from: classes5.dex */
public class c {
    private static c lBu;
    private Context mCtx;
    private static String TAG = "UnionIDHelper";
    private static boolean DEBUG = false;

    private c(Context context) {
        this.mCtx = context.getApplicationContext();
    }

    public static c ge(Context context) {
        if (lBu == null) {
            synchronized (c.class) {
                if (lBu == null) {
                    lBu = new c(context);
                    com.baidu.n.a.a.gf(context);
                }
            }
        }
        return lBu;
    }

    public void a(b bVar) {
        a(new d().GW(1).uR(false), bVar, Looper.getMainLooper());
    }

    public void a(d dVar, final b bVar, Looper looper) {
        e.dgE().a(this.mCtx, looper, new com.baidu.n.a.a.b() { // from class: com.baidu.n.c.1
            @Override // com.baidu.n.a.a.b
            public void a(com.baidu.n.a.a.c cVar) {
                if (c.DEBUG) {
                    Log.d(c.TAG, "异步回调 结果:" + cVar);
                    Log.d(c.TAG, "异步回调 (listener != null):" + (bVar != null));
                }
                if (bVar != null) {
                    bVar.a(0, cVar == null ? null : new a(cVar.dgy(), cVar.isSupport(), cVar.dgJ(), cVar.dgK(), cVar.dgL(), cVar.getStatusCode()));
                }
            }
        });
    }

    public a dgA() {
        com.baidu.n.a.a.c gh = e.dgE().gh(this.mCtx);
        if (DEBUG) {
            Log.d(TAG, "同步 结果:" + gh);
        }
        if (gh == null) {
            return null;
        }
        return new a(gh.dgy(), gh.isSupport(), gh.dgJ(), gh.dgK(), gh.dgL(), gh.getStatusCode());
    }
}
