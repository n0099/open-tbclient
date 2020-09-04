package com.baidu.prologue;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.prologue.business.c;
import com.baidu.prologue.business.d;
import com.baidu.prologue.business.data.e;
import java.lang.ref.WeakReference;
/* loaded from: classes9.dex */
public class a {
    private static a bKi = new a();
    private WeakReference<d> bKj;
    private c bKk = new c() { // from class: com.baidu.prologue.a.1
        @Override // com.baidu.prologue.business.c
        public void a(@NonNull e eVar) {
            int f = com.baidu.prologue.business.data.d.f(eVar);
            Log.e("PrologueSdk", "onAdSuccess: " + f);
            if (f == 0) {
                if (a.this.bKj != null && a.this.bKj.get() != null) {
                    com.baidu.prologue.business.e.a(a.this.mContext, eVar, (d) a.this.bKj.get()).build();
                }
            } else if (com.baidu.prologue.a.b.a.bKm.get().UU()) {
                throw new IllegalStateException("query后物料效验失败");
            } else {
                com.baidu.prologue.business.data.b.Vt();
                if (a.this.bKj != null && a.this.bKj.get() != null) {
                    ((d) a.this.bKj.get()).Vl();
                }
                com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.bKm.get());
            }
        }

        @Override // com.baidu.prologue.business.c
        public void m(Throwable th) {
            if (a.this.bKj != null && a.this.bKj.get() != null) {
                ((d) a.this.bKj.get()).Vl();
            }
            com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.bKm.get());
            com.baidu.prologue.business.data.b.Vt();
        }
    };
    private Context mContext;

    private a() {
    }

    public static a UI() {
        return bKi;
    }

    public void a(Context context, d dVar) {
        if (com.baidu.prologue.a.b.a.bKm.get() == null) {
            dVar.Vl();
            return;
        }
        this.bKj = new WeakReference<>(dVar);
        this.mContext = context;
        com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.bKm.get(), this.bKk);
    }
}
