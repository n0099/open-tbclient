package com.baidu.prologue;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.prologue.business.c;
import com.baidu.prologue.business.d;
import com.baidu.prologue.business.data.e;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class a {
    private static a coj = new a();
    private WeakReference<d> cok;
    private c col = new c() { // from class: com.baidu.prologue.a.1
        @Override // com.baidu.prologue.business.c
        public void a(@NonNull e eVar) {
            int f = com.baidu.prologue.business.data.d.f(eVar);
            Log.e("PrologueSdk", "onAdSuccess: " + f);
            if (f == 0) {
                if (a.this.cok != null && a.this.cok.get() != null) {
                    com.baidu.prologue.business.e.a(a.this.mContext, eVar, (d) a.this.cok.get()).build();
                }
            } else if (com.baidu.prologue.a.b.a.cop.get().acv()) {
                throw new IllegalStateException("query后物料效验失败");
            } else {
                com.baidu.prologue.business.data.b.acU();
                if (a.this.cok != null && a.this.cok.get() != null) {
                    ((d) a.this.cok.get()).acM();
                }
                com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.cop.get());
            }
        }

        @Override // com.baidu.prologue.business.c
        public void k(Throwable th) {
            if (a.this.cok != null && a.this.cok.get() != null) {
                ((d) a.this.cok.get()).acM();
            }
            com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.cop.get());
            com.baidu.prologue.business.data.b.acU();
        }
    };
    private Context mContext;

    private a() {
    }

    public static a acj() {
        return coj;
    }

    public void a(Context context, d dVar) {
        if (com.baidu.prologue.a.b.a.cop.get() == null) {
            dVar.acM();
            return;
        }
        this.cok = new WeakReference<>(dVar);
        this.mContext = context;
        com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.cop.get(), this.col);
    }
}
