package com.baidu.crabsdk.sender;

import android.content.Context;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class m implements Runnable {
    final /* synthetic */ Context aqk;
    final /* synthetic */ Throwable aql;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Throwable th, Context context) {
        this.aql = th;
        this.aqk = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Map<String, Object> a2 = g.a(this.aql, this.aqk);
            g.b(a2);
            a2.put("exceptionThread", com.baidu.crabsdk.b.s.a(Thread.currentThread()));
            i.b(this.aqk, i.e(a2));
            k.n(this.aqk);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
