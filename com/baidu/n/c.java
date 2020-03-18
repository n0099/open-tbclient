package com.baidu.n;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.baidu.n.a.e;
/* loaded from: classes6.dex */
public class c {
    private static c lDX;
    private Context mCtx;
    private static String TAG = "UnionIDHelper";
    private static boolean DEBUG = false;

    private c(Context context) {
        this.mCtx = context.getApplicationContext();
    }

    public static c gb(Context context) {
        if (lDX == null) {
            synchronized (c.class) {
                if (lDX == null) {
                    lDX = new c(context);
                    com.baidu.n.a.a.gc(context);
                }
            }
        }
        return lDX;
    }

    public void a(b bVar) {
        a(new d().Hh(1).vc(false), bVar, Looper.getMainLooper());
    }

    public void a(d dVar, final b bVar, Looper looper) {
        e.diu().a(this.mCtx, looper, new com.baidu.n.a.a.b() { // from class: com.baidu.n.c.1
            @Override // com.baidu.n.a.a.b
            public void a(com.baidu.n.a.a.c cVar) {
                if (c.DEBUG) {
                    Log.d(c.TAG, "异步回调 结果:" + cVar);
                    Log.d(c.TAG, "异步回调 (listener != null):" + (bVar != null));
                }
                if (bVar != null) {
                    bVar.a(0, cVar == null ? null : new a(cVar.dio(), cVar.isSupport(), cVar.diz(), cVar.diA(), cVar.diB(), cVar.getStatusCode()));
                }
            }
        });
    }

    public a diq() {
        com.baidu.n.a.a.c gf = e.diu().gf(this.mCtx);
        if (DEBUG) {
            Log.d(TAG, "同步 结果:" + gf);
        }
        if (gf == null) {
            return null;
        }
        return new a(gf.dio(), gf.isSupport(), gf.diz(), gf.diA(), gf.diB(), gf.getStatusCode());
    }
}
