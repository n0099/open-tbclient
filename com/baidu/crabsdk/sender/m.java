package com.baidu.crabsdk.sender;

import android.content.Context;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class m implements Runnable {
    final /* synthetic */ Context aqr;
    final /* synthetic */ Throwable aqs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Throwable th, Context context) {
        this.aqs = th;
        this.aqr = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Map<String, Object> a2 = g.a(this.aqs, this.aqr);
            g.b(a2);
            a2.put("exceptionThread", com.baidu.crabsdk.b.s.a(Thread.currentThread()));
            i.b(this.aqr, i.e(a2));
            k.n(this.aqr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
