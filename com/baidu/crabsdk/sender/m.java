package com.baidu.crabsdk.sender;

import android.content.Context;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class m implements Runnable {
    final /* synthetic */ Context aoX;
    final /* synthetic */ Throwable aoY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Throwable th, Context context) {
        this.aoY = th;
        this.aoX = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Map<String, Object> a = g.a(this.aoY, this.aoX);
            g.b(a);
            a.put("exceptionThread", com.baidu.crabsdk.b.s.a(Thread.currentThread()));
            i.b(this.aoX, i.e(a));
            k.n(this.aoX);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
