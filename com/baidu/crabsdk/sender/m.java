package com.baidu.crabsdk.sender;

import android.content.Context;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class m implements Runnable {
    final /* synthetic */ Context apB;
    final /* synthetic */ Throwable apC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Throwable th, Context context) {
        this.apC = th;
        this.apB = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Map<String, Object> a = g.a(this.apC, this.apB);
            g.b(a);
            a.put("exceptionThread", com.baidu.crabsdk.b.s.a(Thread.currentThread()));
            i.b(this.apB, i.e(a));
            k.n(this.apB);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
