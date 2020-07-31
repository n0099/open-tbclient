package com.baidu.crabsdk.sender;

import android.content.Context;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public final class m implements Runnable {
    final /* synthetic */ Context anY;
    final /* synthetic */ Throwable anZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Throwable th, Context context) {
        this.anZ = th;
        this.anY = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Map<String, Object> a = g.a(this.anZ, this.anY);
            g.b(a);
            a.put("exceptionThread", com.baidu.crabsdk.b.s.a(Thread.currentThread()));
            i.b(this.anY, i.e(a));
            k.n(this.anY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
