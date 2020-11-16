package com.baidu.prologue;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.prologue.business.c;
import com.baidu.prologue.business.d;
import com.baidu.prologue.business.data.e;
import java.lang.ref.WeakReference;
/* loaded from: classes14.dex */
public class a {
    private static a cfp = new a();
    private WeakReference<d> cfq;
    private c cfr = new c() { // from class: com.baidu.prologue.a.1
        @Override // com.baidu.prologue.business.c
        public void a(@NonNull e eVar) {
            int f = com.baidu.prologue.business.data.d.f(eVar);
            Log.e("PrologueSdk", "onAdSuccess: " + f);
            if (f == 0) {
                if (a.this.cfq != null && a.this.cfq.get() != null) {
                    com.baidu.prologue.business.e.a(a.this.mContext, eVar, (d) a.this.cfq.get()).build();
                }
            } else if (com.baidu.prologue.a.b.a.cft.get().abk()) {
                throw new IllegalStateException("query后物料效验失败");
            } else {
                com.baidu.prologue.business.data.b.abJ();
                if (a.this.cfq != null && a.this.cfq.get() != null) {
                    ((d) a.this.cfq.get()).abB();
                }
                com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.cft.get());
            }
        }

        @Override // com.baidu.prologue.business.c
        public void m(Throwable th) {
            if (a.this.cfq != null && a.this.cfq.get() != null) {
                ((d) a.this.cfq.get()).abB();
            }
            com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.cft.get());
            com.baidu.prologue.business.data.b.abJ();
        }
    };
    private Context mContext;

    private a() {
    }

    public static a aaY() {
        return cfp;
    }

    public void a(Context context, d dVar) {
        if (com.baidu.prologue.a.b.a.cft.get() == null) {
            dVar.abB();
            return;
        }
        this.cfq = new WeakReference<>(dVar);
        this.mContext = context;
        com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.cft.get(), this.cfr);
    }
}
