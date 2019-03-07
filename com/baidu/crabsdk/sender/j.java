package com.baidu.crabsdk.sender;

import android.content.Context;
import com.baidu.crabsdk.b.r;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class j implements Runnable {
    final /* synthetic */ Context acx;
    final /* synthetic */ Throwable acy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Throwable th, Context context) {
        this.acy = th;
        this.acx = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Map<String, Object> a = d.a(this.acy, this.acx);
            d.b(a);
            a.put("exceptionThread", r.a(Thread.currentThread()));
            f.b(this.acx, f.j(a));
            h.o(this.acx);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
