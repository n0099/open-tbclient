package com.baidu.prologue;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.prologue.business.c;
import com.baidu.prologue.business.d;
import com.baidu.prologue.business.data.e;
/* loaded from: classes6.dex */
public class a {
    private static a bzt = new a();
    private d bzu;
    private c bzv = new c() { // from class: com.baidu.prologue.a.1
        @Override // com.baidu.prologue.business.c
        public void a(@NonNull e eVar) {
            int f = com.baidu.prologue.business.data.d.f(eVar);
            Log.e("PrologueSdk", "onAdSuccess: " + f);
            if (f == 0) {
                com.baidu.prologue.business.e.a(a.this.mContext, eVar, a.this.bzu).build();
            } else if (com.baidu.prologue.a.b.a.bzx.get().ND()) {
                throw new IllegalStateException("query后物料效验失败");
            } else {
                com.baidu.prologue.business.data.b.Oc();
                a.this.bzu.NU();
                com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.bzx.get());
            }
        }

        @Override // com.baidu.prologue.business.c
        public void n(Throwable th) {
            a.this.bzu.NU();
            com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.bzx.get());
            com.baidu.prologue.business.data.b.Oc();
        }
    };
    private Context mContext;

    private a() {
    }

    public static a Nr() {
        return bzt;
    }

    public void a(Context context, d dVar) {
        if (com.baidu.prologue.a.b.a.bzx.get() == null) {
            dVar.NU();
            return;
        }
        this.bzu = dVar;
        this.mContext = context;
        com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.bzx.get(), this.bzv);
    }
}
