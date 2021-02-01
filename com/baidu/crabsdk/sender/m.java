package com.baidu.crabsdk.sender;

import android.content.Context;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class m implements Runnable {
    final /* synthetic */ Context aqM;
    final /* synthetic */ Throwable aqN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Throwable th, Context context) {
        this.aqN = th;
        this.aqM = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Map<String, Object> a2 = g.a(this.aqN, this.aqM);
            g.b(a2);
            a2.put("exceptionThread", com.baidu.crabsdk.b.s.a(Thread.currentThread()));
            i.b(this.aqM, i.e(a2));
            k.n(this.aqM);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
