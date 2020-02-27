package com.baidu.crabsdk.sender;

import android.content.Context;
import com.baidu.crabsdk.b.r;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class m implements Runnable {
    final /* synthetic */ Context SK;
    final /* synthetic */ Throwable SL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Throwable th, Context context) {
        this.SL = th;
        this.SK = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Map<String, Object> a = g.a(this.SL, this.SK);
            g.b(a);
            a.put("exceptionThread", r.a(Thread.currentThread()));
            i.b(this.SK, i.g(a));
            k.o(this.SK);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
