package com.baidu.q;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.baidu.q.a.e;
/* loaded from: classes12.dex */
public class c {
    private static c nhk;
    private Context mCtx;
    private static String TAG = "UnionIDHelper";
    private static boolean DEBUG = false;

    private c(Context context) {
        this.mCtx = context.getApplicationContext();
    }

    public static c ga(Context context) {
        if (nhk == null) {
            synchronized (c.class) {
                if (nhk == null) {
                    nhk = new c(context);
                    com.baidu.q.a.a.gb(context);
                }
            }
        }
        return nhk;
    }

    public void a(b bVar) {
        a(new d().KF(1).xL(false), bVar, Looper.getMainLooper());
    }

    public void a(d dVar, final b bVar, Looper looper) {
        e.dNa().a(this.mCtx, looper, new com.baidu.q.a.a.b() { // from class: com.baidu.q.c.1
            @Override // com.baidu.q.a.a.b
            public void a(com.baidu.q.a.a.c cVar) {
                if (c.DEBUG) {
                    Log.d(c.TAG, "异步回调 结果:" + cVar);
                    Log.d(c.TAG, "异步回调 (listener != null):" + (bVar != null));
                }
                if (bVar != null) {
                    bVar.a(0, cVar == null ? null : new a(cVar.dMU(), cVar.isSupport(), cVar.getOAID(), cVar.getAAID(), cVar.getVAID(), cVar.getStatusCode()));
                }
            }
        });
    }

    public a dMW() {
        com.baidu.q.a.a.c ge = e.dNa().ge(this.mCtx);
        if (DEBUG) {
            Log.d(TAG, "同步 结果:" + ge);
        }
        if (ge == null) {
            return null;
        }
        return new a(ge.dMU(), ge.isSupport(), ge.getOAID(), ge.getAAID(), ge.getVAID(), ge.getStatusCode());
    }
}
