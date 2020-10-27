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
    private static a cbo = new a();
    private WeakReference<d> cbp;
    private c cbq = new c() { // from class: com.baidu.prologue.a.1
        @Override // com.baidu.prologue.business.c
        public void a(@NonNull e eVar) {
            int f = com.baidu.prologue.business.data.d.f(eVar);
            Log.e("PrologueSdk", "onAdSuccess: " + f);
            if (f == 0) {
                if (a.this.cbp != null && a.this.cbp.get() != null) {
                    com.baidu.prologue.business.e.a(a.this.mContext, eVar, (d) a.this.cbp.get()).build();
                }
            } else if (com.baidu.prologue.a.b.a.cbs.get().Zu()) {
                throw new IllegalStateException("query后物料效验失败");
            } else {
                com.baidu.prologue.business.data.b.ZT();
                if (a.this.cbp != null && a.this.cbp.get() != null) {
                    ((d) a.this.cbp.get()).ZL();
                }
                com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.cbs.get());
            }
        }

        @Override // com.baidu.prologue.business.c
        public void m(Throwable th) {
            if (a.this.cbp != null && a.this.cbp.get() != null) {
                ((d) a.this.cbp.get()).ZL();
            }
            com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.cbs.get());
            com.baidu.prologue.business.data.b.ZT();
        }
    };
    private Context mContext;

    private a() {
    }

    public static a Zi() {
        return cbo;
    }

    public void a(Context context, d dVar) {
        if (com.baidu.prologue.a.b.a.cbs.get() == null) {
            dVar.ZL();
            return;
        }
        this.cbp = new WeakReference<>(dVar);
        this.mContext = context;
        com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.cbs.get(), this.cbq);
    }
}
