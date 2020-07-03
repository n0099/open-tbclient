package com.baidu.l;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.baidu.l.a.e;
/* loaded from: classes6.dex */
public class c {
    private static c mFR;
    private Context mCtx;
    private static String TAG = "UnionIDHelper";
    private static boolean DEBUG = false;

    private c(Context context) {
        this.mCtx = context.getApplicationContext();
    }

    public static c fK(Context context) {
        if (mFR == null) {
            synchronized (c.class) {
                if (mFR == null) {
                    mFR = new c(context);
                    com.baidu.l.a.a.fL(context);
                }
            }
        }
        return mFR;
    }

    public void a(b bVar) {
        a(new d().HK(1).wo(false), bVar, Looper.getMainLooper());
    }

    public void a(d dVar, final b bVar, Looper looper) {
        e.dxM().a(this.mCtx, looper, new com.baidu.l.a.a.b() { // from class: com.baidu.l.c.1
            @Override // com.baidu.l.a.a.b
            public void a(com.baidu.l.a.a.c cVar) {
                if (c.DEBUG) {
                    Log.d(c.TAG, "异步回调 结果:" + cVar);
                    Log.d(c.TAG, "异步回调 (listener != null):" + (bVar != null));
                }
                if (bVar != null) {
                    bVar.a(0, cVar == null ? null : new a(cVar.dxG(), cVar.isSupport(), cVar.getOAID(), cVar.getAAID(), cVar.getVAID(), cVar.getStatusCode()));
                }
            }
        });
    }

    public a dxI() {
        com.baidu.l.a.a.c fN = e.dxM().fN(this.mCtx);
        if (DEBUG) {
            Log.d(TAG, "同步 结果:" + fN);
        }
        if (fN == null) {
            return null;
        }
        return new a(fN.dxG(), fN.isSupport(), fN.getOAID(), fN.getAAID(), fN.getVAID(), fN.getStatusCode());
    }
}
