package com.baidu.prologue;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.prologue.business.c;
import com.baidu.prologue.business.d;
import com.baidu.prologue.business.data.e;
/* loaded from: classes6.dex */
public class a {
    private static a brQ = new a();
    private d brR;
    private c brS = new c() { // from class: com.baidu.prologue.a.1
        @Override // com.baidu.prologue.business.c
        public void a(@NonNull e eVar) {
            int f = com.baidu.prologue.business.data.d.f(eVar);
            Log.e("PrologueSdk", "onAdSuccess: " + f);
            if (f == 0) {
                com.baidu.prologue.business.e.a(a.this.mContext, eVar, a.this.brR).build();
            } else if (com.baidu.prologue.a.b.a.brU.get().Lq()) {
                throw new IllegalStateException("query后物料效验失败");
            } else {
                com.baidu.prologue.business.data.b.LP();
                a.this.brR.LH();
                com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.brU.get());
            }
        }

        @Override // com.baidu.prologue.business.c
        public void m(Throwable th) {
            a.this.brR.LH();
            com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.brU.get());
            com.baidu.prologue.business.data.b.LP();
        }
    };
    private Context mContext;

    private a() {
    }

    public static a Le() {
        return brQ;
    }

    public void a(Context context, d dVar) {
        if (com.baidu.prologue.a.b.a.brU.get() == null) {
            dVar.LH();
            return;
        }
        this.brR = dVar;
        this.mContext = context;
        com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.brU.get(), this.brS);
    }
}
