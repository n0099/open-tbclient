package com.baidu.q;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.baidu.q.a.e;
/* loaded from: classes15.dex */
public class c {
    private static c otQ;
    private Context mCtx;
    private static String TAG = "UnionIDHelper";
    private static boolean DEBUG = false;

    private c(Context context) {
        this.mCtx = context.getApplicationContext();
    }

    public static c gp(Context context) {
        if (otQ == null) {
            synchronized (c.class) {
                if (otQ == null) {
                    otQ = new c(context);
                    com.baidu.q.a.a.gq(context);
                }
            }
        }
        return otQ;
    }

    public void a(b bVar) {
        a(new d().NO(1).zJ(false), bVar, Looper.getMainLooper());
    }

    public void a(d dVar, final b bVar, Looper looper) {
        e.eeg().a(this.mCtx, looper, new com.baidu.q.a.a.b() { // from class: com.baidu.q.c.1
            @Override // com.baidu.q.a.a.b
            public void a(com.baidu.q.a.a.c cVar) {
                if (c.DEBUG) {
                    Log.d(c.TAG, "异步回调 结果:" + cVar);
                    Log.d(c.TAG, "异步回调 (listener != null):" + (bVar != null));
                }
                if (bVar != null) {
                    bVar.a(0, cVar == null ? null : new a(cVar.eel(), cVar.isSupport(), cVar.getOAID(), cVar.getAAID(), cVar.getVAID(), cVar.getStatusCode()));
                }
            }
        });
    }
}
