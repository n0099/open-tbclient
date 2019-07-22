package com.baidu.crabsdk.sender;

import android.content.Context;
import com.baidu.crabsdk.b.r;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class m implements Runnable {
    final /* synthetic */ Context aaO;
    final /* synthetic */ Throwable aaP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Throwable th, Context context) {
        this.aaP = th;
        this.aaO = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Map<String, Object> a = g.a(this.aaP, this.aaO);
            g.b(a);
            a.put("exceptionThread", r.a(Thread.currentThread()));
            i.b(this.aaO, i.i(a));
            k.o(this.aaO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
