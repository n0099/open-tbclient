package com.baidu.crabsdk.sender;

import android.content.Context;
import com.baidu.crabsdk.b.r;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j implements Runnable {
    final /* synthetic */ Context Tw;
    final /* synthetic */ Throwable Tx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Throwable th, Context context) {
        this.Tx = th;
        this.Tw = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Map<String, Object> a = d.a(this.Tx, this.Tw);
            d.b(a);
            a.put("exceptionThread", r.b(Thread.currentThread()));
            f.b(this.Tw, f.j(a));
            h.o(this.Tw);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
