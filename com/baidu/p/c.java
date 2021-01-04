package com.baidu.p;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.baidu.p.a.e;
/* loaded from: classes3.dex */
public class c {
    private static c oPg;
    private Context mCtx;
    private static String TAG = "UnionIDHelper";
    private static boolean DEBUG = false;

    private c(Context context) {
        this.mCtx = context.getApplicationContext();
    }

    public static c ho(Context context) {
        if (oPg == null) {
            synchronized (c.class) {
                if (oPg == null) {
                    oPg = new c(context);
                    com.baidu.p.a.a.hp(context);
                }
            }
        }
        return oPg;
    }

    public void a(b bVar) {
        a(new d().OB(1).Ao(false), bVar, Looper.getMainLooper());
    }

    public void a(d dVar, final b bVar, Looper looper) {
        e.ejZ().a(this.mCtx, looper, new com.baidu.p.a.a.b() { // from class: com.baidu.p.c.1
            @Override // com.baidu.p.a.a.b
            public void a(com.baidu.p.a.a.c cVar) {
                if (c.DEBUG) {
                    Log.d(c.TAG, "异步回调 结果:" + cVar);
                    Log.d(c.TAG, "异步回调 (listener != null):" + (bVar != null));
                }
                if (bVar != null) {
                    bVar.a(0, cVar == null ? null : new a(cVar.eke(), cVar.isSupport(), cVar.getOAID(), cVar.getAAID(), cVar.getVAID(), cVar.getStatusCode()));
                }
            }
        });
    }
}
