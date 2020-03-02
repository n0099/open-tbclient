package com.baidu.n;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.baidu.n.a.e;
/* loaded from: classes6.dex */
public class c {
    private static c lCi;
    private Context mCtx;
    private static String TAG = "UnionIDHelper";
    private static boolean DEBUG = false;

    private c(Context context) {
        this.mCtx = context.getApplicationContext();
    }

    public static c gc(Context context) {
        if (lCi == null) {
            synchronized (c.class) {
                if (lCi == null) {
                    lCi = new c(context);
                    com.baidu.n.a.a.ge(context);
                }
            }
        }
        return lCi;
    }

    public void a(b bVar) {
        a(new d().Hb(1).uV(false), bVar, Looper.getMainLooper());
    }

    public void a(d dVar, final b bVar, Looper looper) {
        e.dhW().a(this.mCtx, looper, new com.baidu.n.a.a.b() { // from class: com.baidu.n.c.1
            @Override // com.baidu.n.a.a.b
            public void a(com.baidu.n.a.a.c cVar) {
                if (c.DEBUG) {
                    Log.d(c.TAG, "异步回调 结果:" + cVar);
                    Log.d(c.TAG, "异步回调 (listener != null):" + (bVar != null));
                }
                if (bVar != null) {
                    bVar.a(0, cVar == null ? null : new a(cVar.dhQ(), cVar.isSupport(), cVar.dib(), cVar.dic(), cVar.did(), cVar.getStatusCode()));
                }
            }
        });
    }

    public a dhS() {
        com.baidu.n.a.a.c gg = e.dhW().gg(this.mCtx);
        if (DEBUG) {
            Log.d(TAG, "同步 结果:" + gg);
        }
        if (gg == null) {
            return null;
        }
        return new a(gg.dhQ(), gg.isSupport(), gg.dib(), gg.dic(), gg.did(), gg.getStatusCode());
    }
}
