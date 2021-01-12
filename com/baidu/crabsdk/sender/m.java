package com.baidu.crabsdk.sender;

import android.content.Context;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public final class m implements Runnable {
    final /* synthetic */ Context aqW;
    final /* synthetic */ Throwable aqX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Throwable th, Context context) {
        this.aqX = th;
        this.aqW = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Map<String, Object> a2 = g.a(this.aqX, this.aqW);
            g.b(a2);
            a2.put("exceptionThread", com.baidu.crabsdk.b.s.a(Thread.currentThread()));
            i.b(this.aqW, i.e(a2));
            k.n(this.aqW);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
