package com.baidu.prologue;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.prologue.business.c;
import com.baidu.prologue.business.d;
import com.baidu.prologue.business.data.e;
/* loaded from: classes6.dex */
public class a {
    private static a brM = new a();
    private d brN;
    private c brO = new c() { // from class: com.baidu.prologue.a.1
        @Override // com.baidu.prologue.business.c
        public void a(@NonNull e eVar) {
            int f = com.baidu.prologue.business.data.d.f(eVar);
            Log.e("PrologueSdk", "onAdSuccess: " + f);
            if (f == 0) {
                com.baidu.prologue.business.e.a(a.this.mContext, eVar, a.this.brN).build();
            } else if (com.baidu.prologue.a.b.a.brQ.get().Lr()) {
                throw new IllegalStateException("query后物料效验失败");
            } else {
                com.baidu.prologue.business.data.b.LQ();
                a.this.brN.LI();
                com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.brQ.get());
            }
        }

        @Override // com.baidu.prologue.business.c
        public void m(Throwable th) {
            a.this.brN.LI();
            com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.brQ.get());
            com.baidu.prologue.business.data.b.LQ();
        }
    };
    private Context mContext;

    private a() {
    }

    public static a Lf() {
        return brM;
    }

    public void a(Context context, d dVar) {
        if (com.baidu.prologue.a.b.a.brQ.get() == null) {
            dVar.LI();
            return;
        }
        this.brN = dVar;
        this.mContext = context;
        com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.brQ.get(), this.brO);
    }
}
