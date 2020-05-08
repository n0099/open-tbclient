package com.baidu.crabsdk.sender;

import android.content.Context;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class m implements Runnable {
    final /* synthetic */ Context alh;
    final /* synthetic */ Throwable ali;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Throwable th, Context context) {
        this.ali = th;
        this.alh = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Map<String, Object> a = g.a(this.ali, this.alh);
            g.b(a);
            a.put("exceptionThread", com.baidu.crabsdk.b.s.a(Thread.currentThread()));
            i.b(this.alh, i.d(a));
            k.n(this.alh);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
