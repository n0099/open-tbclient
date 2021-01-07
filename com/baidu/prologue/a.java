package com.baidu.prologue;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.prologue.business.c;
import com.baidu.prologue.business.d;
import com.baidu.prologue.business.data.e;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class a {
    private static a csY = new a();
    private WeakReference<d> csZ;
    private c cta = new c() { // from class: com.baidu.prologue.a.1
        @Override // com.baidu.prologue.business.c
        public void a(@NonNull e eVar) {
            int f = com.baidu.prologue.business.data.d.f(eVar);
            Log.e("PrologueSdk", "onAdSuccess: " + f);
            if (f == 0) {
                if (a.this.csZ != null && a.this.csZ.get() != null) {
                    com.baidu.prologue.business.e.a(a.this.mContext, eVar, (d) a.this.csZ.get()).build();
                }
            } else if (com.baidu.prologue.a.b.a.ctd.get().agp()) {
                throw new IllegalStateException("query后物料效验失败");
            } else {
                com.baidu.prologue.business.data.b.agO();
                if (a.this.csZ != null && a.this.csZ.get() != null) {
                    ((d) a.this.csZ.get()).agG();
                }
                com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.ctd.get());
            }
        }

        @Override // com.baidu.prologue.business.c
        public void k(Throwable th) {
            if (a.this.csZ != null && a.this.csZ.get() != null) {
                ((d) a.this.csZ.get()).agG();
            }
            com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.ctd.get());
            com.baidu.prologue.business.data.b.agO();
        }
    };
    private Context mContext;

    private a() {
    }

    public static a agd() {
        return csY;
    }

    public void a(Context context, d dVar) {
        if (com.baidu.prologue.a.b.a.ctd.get() == null) {
            dVar.agG();
            return;
        }
        this.csZ = new WeakReference<>(dVar);
        this.mContext = context;
        com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.ctd.get(), this.cta);
    }
}
