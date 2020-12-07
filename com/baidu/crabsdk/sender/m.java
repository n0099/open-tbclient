package com.baidu.crabsdk.sender;

import android.content.Context;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class m implements Runnable {
    final /* synthetic */ Context arn;
    final /* synthetic */ Throwable aro;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Throwable th, Context context) {
        this.aro = th;
        this.arn = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Map<String, Object> a2 = g.a(this.aro, this.arn);
            g.b(a2);
            a2.put("exceptionThread", com.baidu.crabsdk.b.s.a(Thread.currentThread()));
            i.b(this.arn, i.e(a2));
            k.n(this.arn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
