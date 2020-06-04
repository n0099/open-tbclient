package com.baidu.l;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.baidu.l.a.e;
/* loaded from: classes6.dex */
public class c {
    private static c mjV;
    private Context mCtx;
    private static String TAG = "UnionIDHelper";
    private static boolean DEBUG = false;

    private c(Context context) {
        this.mCtx = context.getApplicationContext();
    }

    public static c fJ(Context context) {
        if (mjV == null) {
            synchronized (c.class) {
                if (mjV == null) {
                    mjV = new c(context);
                    com.baidu.l.a.a.fK(context);
                }
            }
        }
        return mjV;
    }

    public void a(b bVar) {
        a(new d().GD(1).vS(false), bVar, Looper.getMainLooper());
    }

    public void a(d dVar, final b bVar, Looper looper) {
        e.dtj().a(this.mCtx, looper, new com.baidu.l.a.a.b() { // from class: com.baidu.l.c.1
            @Override // com.baidu.l.a.a.b
            public void a(com.baidu.l.a.a.c cVar) {
                if (c.DEBUG) {
                    Log.d(c.TAG, "异步回调 结果:" + cVar);
                    Log.d(c.TAG, "异步回调 (listener != null):" + (bVar != null));
                }
                if (bVar != null) {
                    bVar.a(0, cVar == null ? null : new a(cVar.dtd(), cVar.isSupport(), cVar.getOAID(), cVar.getAAID(), cVar.getVAID(), cVar.getStatusCode()));
                }
            }
        });
    }

    public a dtf() {
        com.baidu.l.a.a.c fM = e.dtj().fM(this.mCtx);
        if (DEBUG) {
            Log.d(TAG, "同步 结果:" + fM);
        }
        if (fM == null) {
            return null;
        }
        return new a(fM.dtd(), fM.isSupport(), fM.getOAID(), fM.getAAID(), fM.getVAID(), fM.getStatusCode());
    }
}
