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
    private static a cha = new a();
    private WeakReference<d> chb;
    private c chc = new c() { // from class: com.baidu.prologue.a.1
        @Override // com.baidu.prologue.business.c
        public void a(@NonNull e eVar) {
            int f = com.baidu.prologue.business.data.d.f(eVar);
            Log.e("PrologueSdk", "onAdSuccess: " + f);
            if (f == 0) {
                if (a.this.chb != null && a.this.chb.get() != null) {
                    com.baidu.prologue.business.e.a(a.this.mContext, eVar, (d) a.this.chb.get()).build();
                }
            } else if (com.baidu.prologue.a.b.a.che.get().abT()) {
                throw new IllegalStateException("query后物料效验失败");
            } else {
                com.baidu.prologue.business.data.b.acs();
                if (a.this.chb != null && a.this.chb.get() != null) {
                    ((d) a.this.chb.get()).ack();
                }
                com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.che.get());
            }
        }

        @Override // com.baidu.prologue.business.c
        public void m(Throwable th) {
            if (a.this.chb != null && a.this.chb.get() != null) {
                ((d) a.this.chb.get()).ack();
            }
            com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.che.get());
            com.baidu.prologue.business.data.b.acs();
        }
    };
    private Context mContext;

    private a() {
    }

    public static a abH() {
        return cha;
    }

    public void a(Context context, d dVar) {
        if (com.baidu.prologue.a.b.a.che.get() == null) {
            dVar.ack();
            return;
        }
        this.chb = new WeakReference<>(dVar);
        this.mContext = context;
        com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.che.get(), this.chc);
    }
}
