package com.baidu.n;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.baidu.n.a.e;
/* loaded from: classes4.dex */
public class c {
    private static c lxV;
    private Context mCtx;
    private static String TAG = "UnionIDHelper";
    private static boolean DEBUG = false;

    private c(Context context) {
        this.mCtx = context.getApplicationContext();
    }

    public static c gc(Context context) {
        if (lxV == null) {
            synchronized (c.class) {
                if (lxV == null) {
                    lxV = new c(context);
                    com.baidu.n.a.a.ge(context);
                }
            }
        }
        return lxV;
    }

    public void a(b bVar) {
        a(new d().GR(1).uG(false), bVar, Looper.getMainLooper());
    }

    public void a(d dVar, final b bVar, Looper looper) {
        e.dfC().a(this.mCtx, looper, new com.baidu.n.a.a.b() { // from class: com.baidu.n.c.1
            @Override // com.baidu.n.a.a.b
            public void a(com.baidu.n.a.a.c cVar) {
                if (c.DEBUG) {
                    Log.d(c.TAG, "异步回调 结果:" + cVar);
                    Log.d(c.TAG, "异步回调 (listener != null):" + (bVar != null));
                }
                if (bVar != null) {
                    bVar.a(0, cVar == null ? null : new a(cVar.dfw(), cVar.isSupport(), cVar.dfH(), cVar.dfI(), cVar.dfJ(), cVar.getStatusCode()));
                }
            }
        });
    }

    public a dfy() {
        com.baidu.n.a.a.c gg = e.dfC().gg(this.mCtx);
        if (DEBUG) {
            Log.d(TAG, "同步 结果:" + gg);
        }
        if (gg == null) {
            return null;
        }
        return new a(gg.dfw(), gg.isSupport(), gg.dfH(), gg.dfI(), gg.dfJ(), gg.getStatusCode());
    }
}
