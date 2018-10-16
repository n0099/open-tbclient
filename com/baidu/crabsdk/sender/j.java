package com.baidu.crabsdk.sender;

import android.content.Context;
import com.baidu.crabsdk.b.r;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class j implements Runnable {
    final /* synthetic */ Context YK;
    final /* synthetic */ Throwable YL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Throwable th, Context context) {
        this.YL = th;
        this.YK = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Map<String, Object> a = d.a(this.YL, this.YK);
            d.b(a);
            a.put("exceptionThread", r.a(Thread.currentThread()));
            f.b(this.YK, f.j(a));
            h.o(this.YK);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
