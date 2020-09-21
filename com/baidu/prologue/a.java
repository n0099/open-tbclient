package com.baidu.prologue;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.prologue.business.c;
import com.baidu.prologue.business.d;
import com.baidu.prologue.business.data.e;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class a {
    private static a bMi = new a();
    private WeakReference<d> bMj;
    private c bMk = new c() { // from class: com.baidu.prologue.a.1
        @Override // com.baidu.prologue.business.c
        public void a(@NonNull e eVar) {
            int f = com.baidu.prologue.business.data.d.f(eVar);
            Log.e("PrologueSdk", "onAdSuccess: " + f);
            if (f == 0) {
                if (a.this.bMj != null && a.this.bMj.get() != null) {
                    com.baidu.prologue.business.e.a(a.this.mContext, eVar, (d) a.this.bMj.get()).build();
                }
            } else if (com.baidu.prologue.a.b.a.bMm.get().VD()) {
                throw new IllegalStateException("query后物料效验失败");
            } else {
                com.baidu.prologue.business.data.b.Wc();
                if (a.this.bMj != null && a.this.bMj.get() != null) {
                    ((d) a.this.bMj.get()).VU();
                }
                com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.bMm.get());
            }
        }

        @Override // com.baidu.prologue.business.c
        public void m(Throwable th) {
            if (a.this.bMj != null && a.this.bMj.get() != null) {
                ((d) a.this.bMj.get()).VU();
            }
            com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.bMm.get());
            com.baidu.prologue.business.data.b.Wc();
        }
    };
    private Context mContext;

    private a() {
    }

    public static a Vr() {
        return bMi;
    }

    public void a(Context context, d dVar) {
        if (com.baidu.prologue.a.b.a.bMm.get() == null) {
            dVar.VU();
            return;
        }
        this.bMj = new WeakReference<>(dVar);
        this.mContext = context;
        com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.bMm.get(), this.bMk);
    }
}
