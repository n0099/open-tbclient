package com.baidu.n;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.baidu.n.a.e;
/* loaded from: classes5.dex */
public class c {
    private static c oVm;
    private Context mCtx;
    private static String TAG = "UnionIDHelper";
    private static boolean DEBUG = false;

    private c(Context context) {
        this.mCtx = context.getApplicationContext();
    }

    public static c hp(Context context) {
        if (oVm == null) {
            synchronized (c.class) {
                if (oVm == null) {
                    oVm = new c(context);
                    com.baidu.n.a.a.hq(context);
                }
            }
        }
        return oVm;
    }

    public void a(b bVar) {
        a(new d().Nr(1).AD(false), bVar, Looper.getMainLooper());
    }

    public void a(d dVar, final b bVar, Looper looper) {
        e.eiG().a(this.mCtx, looper, new com.baidu.n.a.a.b() { // from class: com.baidu.n.c.1
            @Override // com.baidu.n.a.a.b
            public void a(com.baidu.n.a.a.c cVar) {
                if (c.DEBUG) {
                    Log.d(c.TAG, "异步回调 结果:" + cVar);
                    Log.d(c.TAG, "异步回调 (listener != null):" + (bVar != null));
                }
                if (bVar != null) {
                    bVar.a(0, cVar == null ? null : new a(cVar.eiL(), cVar.isSupport(), cVar.getOAID(), cVar.getAAID(), cVar.getVAID(), cVar.getStatusCode()));
                }
            }
        });
    }
}
