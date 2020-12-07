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
    private static a clV = new a();
    private WeakReference<d> clW;
    private c clX = new c() { // from class: com.baidu.prologue.a.1
        @Override // com.baidu.prologue.business.c
        public void a(@NonNull e eVar) {
            int f = com.baidu.prologue.business.data.d.f(eVar);
            Log.e("PrologueSdk", "onAdSuccess: " + f);
            if (f == 0) {
                if (a.this.clW != null && a.this.clW.get() != null) {
                    com.baidu.prologue.business.e.a(a.this.mContext, eVar, (d) a.this.clW.get()).build();
                }
            } else if (com.baidu.prologue.a.b.a.clZ.get().aes()) {
                throw new IllegalStateException("query后物料效验失败");
            } else {
                com.baidu.prologue.business.data.b.aeR();
                if (a.this.clW != null && a.this.clW.get() != null) {
                    ((d) a.this.clW.get()).aeJ();
                }
                com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.clZ.get());
            }
        }

        @Override // com.baidu.prologue.business.c
        public void m(Throwable th) {
            if (a.this.clW != null && a.this.clW.get() != null) {
                ((d) a.this.clW.get()).aeJ();
            }
            com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.clZ.get());
            com.baidu.prologue.business.data.b.aeR();
        }
    };
    private Context mContext;

    private a() {
    }

    public static a aeg() {
        return clV;
    }

    public void a(Context context, d dVar) {
        if (com.baidu.prologue.a.b.a.clZ.get() == null) {
            dVar.aeJ();
            return;
        }
        this.clW = new WeakReference<>(dVar);
        this.mContext = context;
        com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.clZ.get(), this.clX);
    }
}
