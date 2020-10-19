package com.baidu.prologue;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.prologue.business.c;
import com.baidu.prologue.business.d;
import com.baidu.prologue.business.data.e;
import java.lang.ref.WeakReference;
/* loaded from: classes19.dex */
public class a {
    private static a bSR = new a();
    private WeakReference<d> bSS;
    private c bST = new c() { // from class: com.baidu.prologue.a.1
        @Override // com.baidu.prologue.business.c
        public void a(@NonNull e eVar) {
            int f = com.baidu.prologue.business.data.d.f(eVar);
            Log.e("PrologueSdk", "onAdSuccess: " + f);
            if (f == 0) {
                if (a.this.bSS != null && a.this.bSS.get() != null) {
                    com.baidu.prologue.business.e.a(a.this.mContext, eVar, (d) a.this.bSS.get()).build();
                }
            } else if (com.baidu.prologue.a.b.a.bSV.get().XA()) {
                throw new IllegalStateException("query后物料效验失败");
            } else {
                com.baidu.prologue.business.data.b.XZ();
                if (a.this.bSS != null && a.this.bSS.get() != null) {
                    ((d) a.this.bSS.get()).XR();
                }
                com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.bSV.get());
            }
        }

        @Override // com.baidu.prologue.business.c
        public void m(Throwable th) {
            if (a.this.bSS != null && a.this.bSS.get() != null) {
                ((d) a.this.bSS.get()).XR();
            }
            com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.bSV.get());
            com.baidu.prologue.business.data.b.XZ();
        }
    };
    private Context mContext;

    private a() {
    }

    public static a Xo() {
        return bSR;
    }

    public void a(Context context, d dVar) {
        if (com.baidu.prologue.a.b.a.bSV.get() == null) {
            dVar.XR();
            return;
        }
        this.bSS = new WeakReference<>(dVar);
        this.mContext = context;
        com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.bSV.get(), this.bST);
    }
}
