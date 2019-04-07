package com.baidu.crabsdk.sender;

import android.content.Context;
import com.baidu.crabsdk.b.r;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class m implements Runnable {
    final /* synthetic */ Context acD;
    final /* synthetic */ Throwable acE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Throwable th, Context context) {
        this.acE = th;
        this.acD = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Map<String, Object> a = g.a(this.acE, this.acD);
            g.b(a);
            a.put("exceptionThread", r.a(Thread.currentThread()));
            i.b(this.acD, i.j(a));
            k.o(this.acD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
