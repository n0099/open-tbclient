package com.baidu.q;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.baidu.q.a.e;
/* loaded from: classes7.dex */
public class c {
    private static c osn;
    private Context mCtx;
    private static String TAG = "UnionIDHelper";
    private static boolean DEBUG = false;

    private c(Context context) {
        this.mCtx = context.getApplicationContext();
    }

    public static c gq(Context context) {
        if (osn == null) {
            synchronized (c.class) {
                if (osn == null) {
                    osn = new c(context);
                    com.baidu.q.a.a.gr(context);
                }
            }
        }
        return osn;
    }

    public void a(b bVar) {
        a(new d().Nl(1).zC(false), bVar, Looper.getMainLooper());
    }

    public void a(d dVar, final b bVar, Looper looper) {
        e.eej().a(this.mCtx, looper, new com.baidu.q.a.a.b() { // from class: com.baidu.q.c.1
            @Override // com.baidu.q.a.a.b
            public void a(com.baidu.q.a.a.c cVar) {
                if (c.DEBUG) {
                    Log.d(c.TAG, "异步回调 结果:" + cVar);
                    Log.d(c.TAG, "异步回调 (listener != null):" + (bVar != null));
                }
                if (bVar != null) {
                    bVar.a(0, cVar == null ? null : new a(cVar.eed(), cVar.isSupport(), cVar.getOAID(), cVar.getAAID(), cVar.getVAID(), cVar.getStatusCode()));
                }
            }
        });
    }

    public a eef() {
        com.baidu.q.a.a.c gt = e.eej().gt(this.mCtx);
        if (DEBUG) {
            Log.d(TAG, "同步 结果:" + gt);
        }
        if (gt == null) {
            return null;
        }
        return new a(gt.eed(), gt.isSupport(), gt.getOAID(), gt.getAAID(), gt.getVAID(), gt.getStatusCode());
    }
}
