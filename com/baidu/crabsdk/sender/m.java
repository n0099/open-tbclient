package com.baidu.crabsdk.sender;

import android.content.Context;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class m implements Runnable {
    final /* synthetic */ Context amK;
    final /* synthetic */ Throwable amL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Throwable th, Context context) {
        this.amL = th;
        this.amK = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Map<String, Object> a = g.a(this.amL, this.amK);
            g.b(a);
            a.put("exceptionThread", com.baidu.crabsdk.b.s.a(Thread.currentThread()));
            i.b(this.amK, i.e(a));
            k.n(this.amK);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
