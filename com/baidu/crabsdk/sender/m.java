package com.baidu.crabsdk.sender;

import android.content.Context;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class m implements Runnable {
    final /* synthetic */ Context asl;
    final /* synthetic */ Throwable asn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Throwable th, Context context) {
        this.asn = th;
        this.asl = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Map<String, Object> a2 = g.a(this.asn, this.asl);
            g.b(a2);
            a2.put("exceptionThread", com.baidu.crabsdk.b.s.a(Thread.currentThread()));
            i.b(this.asl, i.e(a2));
            k.n(this.asl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
