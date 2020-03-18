package com.baidu.crabsdk.sender;

import android.content.Context;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class m implements Runnable {
    final /* synthetic */ Context SO;
    final /* synthetic */ Throwable SQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Throwable th, Context context) {
        this.SQ = th;
        this.SO = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Map<String, Object> a = g.a(this.SQ, this.SO);
            g.b(a);
            a.put("exceptionThread", com.baidu.crabsdk.b.s.a(Thread.currentThread()));
            i.b(this.SO, i.g(a));
            k.n(this.SO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
