package com.baidu.n;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.baidu.n.a.e;
/* loaded from: classes3.dex */
public class c {
    private static c oKE;
    private Context mCtx;
    private static String TAG = "UnionIDHelper";
    private static boolean DEBUG = false;

    private c(Context context) {
        this.mCtx = context.getApplicationContext();
    }

    public static c hm(Context context) {
        if (oKE == null) {
            synchronized (c.class) {
                if (oKE == null) {
                    oKE = new c(context);
                    com.baidu.n.a.a.hn(context);
                }
            }
        }
        return oKE;
    }

    public void a(b bVar) {
        a(new d().MU(1).Ak(false), bVar, Looper.getMainLooper());
    }

    public void a(d dVar, final b bVar, Looper looper) {
        e.egg().a(this.mCtx, looper, new com.baidu.n.a.a.b() { // from class: com.baidu.n.c.1
            @Override // com.baidu.n.a.a.b
            public void a(com.baidu.n.a.a.c cVar) {
                if (c.DEBUG) {
                    Log.d(c.TAG, "异步回调 结果:" + cVar);
                    Log.d(c.TAG, "异步回调 (listener != null):" + (bVar != null));
                }
                if (bVar != null) {
                    bVar.a(0, cVar == null ? null : new a(cVar.egl(), cVar.isSupport(), cVar.getOAID(), cVar.getAAID(), cVar.getVAID(), cVar.getStatusCode()));
                }
            }
        });
    }
}
