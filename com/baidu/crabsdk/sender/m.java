package com.baidu.crabsdk.sender;

import android.content.Context;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class m implements Runnable {
    final /* synthetic */ Context aoV;
    final /* synthetic */ Throwable aoW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Throwable th, Context context) {
        this.aoW = th;
        this.aoV = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Map<String, Object> a = g.a(this.aoW, this.aoV);
            g.b(a);
            a.put("exceptionThread", com.baidu.crabsdk.b.s.a(Thread.currentThread()));
            i.b(this.aoV, i.e(a));
            k.n(this.aoV);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
