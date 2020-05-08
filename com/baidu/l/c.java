package com.baidu.l;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.baidu.l.a.e;
/* loaded from: classes6.dex */
public class c {
    private static c lPu;
    private Context mCtx;
    private static String TAG = "UnionIDHelper";
    private static boolean DEBUG = false;

    private c(Context context) {
        this.mCtx = context.getApplicationContext();
    }

    public static c fu(Context context) {
        if (lPu == null) {
            synchronized (c.class) {
                if (lPu == null) {
                    lPu = new c(context);
                    com.baidu.l.a.a.fv(context);
                }
            }
        }
        return lPu;
    }

    public void a(b bVar) {
        a(new d().FO(1).vs(false), bVar, Looper.getMainLooper());
    }

    public void a(d dVar, final b bVar, Looper looper) {
        e.dlF().a(this.mCtx, looper, new com.baidu.l.a.a.b() { // from class: com.baidu.l.c.1
            @Override // com.baidu.l.a.a.b
            public void a(com.baidu.l.a.a.c cVar) {
                if (c.DEBUG) {
                    Log.d(c.TAG, "异步回调 结果:" + cVar);
                    Log.d(c.TAG, "异步回调 (listener != null):" + (bVar != null));
                }
                if (bVar != null) {
                    bVar.a(0, cVar == null ? null : new a(cVar.dlz(), cVar.isSupport(), cVar.dlK(), cVar.dlL(), cVar.dlM(), cVar.getStatusCode()));
                }
            }
        });
    }

    public a dlB() {
        com.baidu.l.a.a.c fx = e.dlF().fx(this.mCtx);
        if (DEBUG) {
            Log.d(TAG, "同步 结果:" + fx);
        }
        if (fx == null) {
            return null;
        }
        return new a(fx.dlz(), fx.isSupport(), fx.dlK(), fx.dlL(), fx.dlM(), fx.getStatusCode());
    }
}
