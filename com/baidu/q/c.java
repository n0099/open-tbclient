package com.baidu.q;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.baidu.q.a.e;
/* loaded from: classes7.dex */
public class c {
    private static c nGF;
    private Context mCtx;
    private static String TAG = "UnionIDHelper";
    private static boolean DEBUG = false;

    private c(Context context) {
        this.mCtx = context.getApplicationContext();
    }

    public static c go(Context context) {
        if (nGF == null) {
            synchronized (c.class) {
                if (nGF == null) {
                    nGF = new c(context);
                    com.baidu.q.a.a.gp(context);
                }
            }
        }
        return nGF;
    }

    public void a(b bVar) {
        a(new d().LQ(1).yB(false), bVar, Looper.getMainLooper());
    }

    public void a(d dVar, final b bVar, Looper looper) {
        e.dUJ().a(this.mCtx, looper, new com.baidu.q.a.a.b() { // from class: com.baidu.q.c.1
            @Override // com.baidu.q.a.a.b
            public void a(com.baidu.q.a.a.c cVar) {
                if (c.DEBUG) {
                    Log.d(c.TAG, "异步回调 结果:" + cVar);
                    Log.d(c.TAG, "异步回调 (listener != null):" + (bVar != null));
                }
                if (bVar != null) {
                    bVar.a(0, cVar == null ? null : new a(cVar.dUD(), cVar.isSupport(), cVar.getOAID(), cVar.getAAID(), cVar.getVAID(), cVar.getStatusCode()));
                }
            }
        });
    }

    public a dUF() {
        com.baidu.q.a.a.c gr = e.dUJ().gr(this.mCtx);
        if (DEBUG) {
            Log.d(TAG, "同步 结果:" + gr);
        }
        if (gr == null) {
            return null;
        }
        return new a(gr.dUD(), gr.isSupport(), gr.getOAID(), gr.getAAID(), gr.getVAID(), gr.getStatusCode());
    }
}
