package com.baidu.crabsdk.sender;

import android.content.Context;
import com.baidu.crabsdk.b.r;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j implements Runnable {
    final /* synthetic */ Context VY;
    final /* synthetic */ Throwable VZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Throwable th, Context context) {
        this.VZ = th;
        this.VY = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Map<String, Object> a = d.a(this.VZ, this.VY);
            d.b(a);
            a.put("exceptionThread", r.a(Thread.currentThread()));
            f.b(this.VY, f.k(a));
            h.o(this.VY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
