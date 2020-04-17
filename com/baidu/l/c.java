package com.baidu.l;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.baidu.l.a.e;
/* loaded from: classes6.dex */
public class c {
    private static c lPq;
    private Context mCtx;
    private static String TAG = "UnionIDHelper";
    private static boolean DEBUG = false;

    private c(Context context) {
        this.mCtx = context.getApplicationContext();
    }

    public static c fG(Context context) {
        if (lPq == null) {
            synchronized (c.class) {
                if (lPq == null) {
                    lPq = new c(context);
                    com.baidu.l.a.a.fH(context);
                }
            }
        }
        return lPq;
    }

    public void a(b bVar) {
        a(new d().FO(1).vs(false), bVar, Looper.getMainLooper());
    }

    public void a(d dVar, final b bVar, Looper looper) {
        e.dlI().a(this.mCtx, looper, new com.baidu.l.a.a.b() { // from class: com.baidu.l.c.1
            @Override // com.baidu.l.a.a.b
            public void a(com.baidu.l.a.a.c cVar) {
                if (c.DEBUG) {
                    Log.d(c.TAG, "异步回调 结果:" + cVar);
                    Log.d(c.TAG, "异步回调 (listener != null):" + (bVar != null));
                }
                if (bVar != null) {
                    bVar.a(0, cVar == null ? null : new a(cVar.dlC(), cVar.isSupport(), cVar.dlN(), cVar.dlO(), cVar.dlP(), cVar.getStatusCode()));
                }
            }
        });
    }

    public a dlE() {
        com.baidu.l.a.a.c fJ = e.dlI().fJ(this.mCtx);
        if (DEBUG) {
            Log.d(TAG, "同步 结果:" + fJ);
        }
        if (fJ == null) {
            return null;
        }
        return new a(fJ.dlC(), fJ.isSupport(), fJ.dlN(), fJ.dlO(), fJ.dlP(), fJ.getStatusCode());
    }
}
