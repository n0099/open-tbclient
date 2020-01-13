package com.baidu.crabsdk.sender;

import android.content.Context;
import com.baidu.crabsdk.b.r;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class m implements Runnable {
    final /* synthetic */ Context Re;
    final /* synthetic */ Throwable Rf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Throwable th, Context context) {
        this.Rf = th;
        this.Re = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Map<String, Object> a = g.a(this.Rf, this.Re);
            g.b(a);
            a.put("exceptionThread", r.a(Thread.currentThread()));
            i.b(this.Re, i.g(a));
            k.o(this.Re);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
