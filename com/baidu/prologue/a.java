package com.baidu.prologue;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.prologue.business.c;
import com.baidu.prologue.business.d;
import com.baidu.prologue.business.data.e;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class a {
    private static a bEE = new a();
    private WeakReference<d> bEF;
    private c bEG = new c() { // from class: com.baidu.prologue.a.1
        @Override // com.baidu.prologue.business.c
        public void a(@NonNull e eVar) {
            int f = com.baidu.prologue.business.data.d.f(eVar);
            Log.e("PrologueSdk", "onAdSuccess: " + f);
            if (f == 0) {
                if (a.this.bEF != null && a.this.bEF.get() != null) {
                    com.baidu.prologue.business.e.a(a.this.mContext, eVar, (d) a.this.bEF.get()).build();
                }
            } else if (com.baidu.prologue.a.b.a.bEI.get().OY()) {
                throw new IllegalStateException("query后物料效验失败");
            } else {
                com.baidu.prologue.business.data.b.Px();
                if (a.this.bEF != null && a.this.bEF.get() != null) {
                    ((d) a.this.bEF.get()).Pp();
                }
                com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.bEI.get());
            }
        }

        @Override // com.baidu.prologue.business.c
        public void n(Throwable th) {
            if (a.this.bEF != null && a.this.bEF.get() != null) {
                ((d) a.this.bEF.get()).Pp();
            }
            com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.bEI.get());
            com.baidu.prologue.business.data.b.Px();
        }
    };
    private Context mContext;

    private a() {
    }

    public static a OM() {
        return bEE;
    }

    public void a(Context context, d dVar) {
        if (com.baidu.prologue.a.b.a.bEI.get() == null) {
            dVar.Pp();
            return;
        }
        this.bEF = new WeakReference<>(dVar);
        this.mContext = context;
        com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.bEI.get(), this.bEG);
    }
}
