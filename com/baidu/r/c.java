package com.baidu.r;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.baidu.r.a.e;
/* loaded from: classes5.dex */
public class c {
    private static c oIX;
    private Context mCtx;
    private static String TAG = "UnionIDHelper";
    private static boolean DEBUG = false;

    private c(Context context) {
        this.mCtx = context.getApplicationContext();
    }

    public static c gZ(Context context) {
        if (oIX == null) {
            synchronized (c.class) {
                if (oIX == null) {
                    oIX = new c(context);
                    com.baidu.r.a.a.ha(context);
                }
            }
        }
        return oIX;
    }

    public void a(b bVar) {
        a(new d().OM(1).An(false), bVar, Looper.getMainLooper());
    }

    public void a(d dVar, final b bVar, Looper looper) {
        e.ejT().a(this.mCtx, looper, new com.baidu.r.a.a.b() { // from class: com.baidu.r.c.1
            @Override // com.baidu.r.a.a.b
            public void a(com.baidu.r.a.a.c cVar) {
                if (c.DEBUG) {
                    Log.d(c.TAG, "异步回调 结果:" + cVar);
                    Log.d(c.TAG, "异步回调 (listener != null):" + (bVar != null));
                }
                if (bVar != null) {
                    bVar.a(0, cVar == null ? null : new a(cVar.ejY(), cVar.isSupport(), cVar.getOAID(), cVar.getAAID(), cVar.getVAID(), cVar.getStatusCode()));
                }
            }
        });
    }
}
