package com.baidu.m;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.baidu.m.a.e;
/* loaded from: classes8.dex */
public class c {
    private static c mOa;
    private Context mCtx;
    private static String TAG = "UnionIDHelper";
    private static boolean DEBUG = false;

    private c(Context context) {
        this.mCtx = context.getApplicationContext();
    }

    public static c fN(Context context) {
        if (mOa == null) {
            synchronized (c.class) {
                if (mOa == null) {
                    mOa = new c(context);
                    com.baidu.m.a.a.fO(context);
                }
            }
        }
        return mOa;
    }

    public void a(b bVar) {
        a(new d().If(1).wT(false), bVar, Looper.getMainLooper());
    }

    public void a(d dVar, final b bVar, Looper looper) {
        e.dBd().a(this.mCtx, looper, new com.baidu.m.a.a.b() { // from class: com.baidu.m.c.1
            @Override // com.baidu.m.a.a.b
            public void a(com.baidu.m.a.a.c cVar) {
                if (c.DEBUG) {
                    Log.d(c.TAG, "异步回调 结果:" + cVar);
                    Log.d(c.TAG, "异步回调 (listener != null):" + (bVar != null));
                }
                if (bVar != null) {
                    bVar.a(0, cVar == null ? null : new a(cVar.dAX(), cVar.isSupport(), cVar.getOAID(), cVar.getAAID(), cVar.getVAID(), cVar.getStatusCode()));
                }
            }
        });
    }

    public a dAZ() {
        com.baidu.m.a.a.c fQ = e.dBd().fQ(this.mCtx);
        if (DEBUG) {
            Log.d(TAG, "同步 结果:" + fQ);
        }
        if (fQ == null) {
            return null;
        }
        return new a(fQ.dAX(), fQ.isSupport(), fQ.getOAID(), fQ.getAAID(), fQ.getVAID(), fQ.getStatusCode());
    }
}
