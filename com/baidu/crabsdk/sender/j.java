package com.baidu.crabsdk.sender;

import android.content.Context;
import com.baidu.crabsdk.b.r;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class j implements Runnable {
    final /* synthetic */ Context acy;
    final /* synthetic */ Throwable acz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Throwable th, Context context) {
        this.acz = th;
        this.acy = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Map<String, Object> a = d.a(this.acz, this.acy);
            d.b(a);
            a.put("exceptionThread", r.a(Thread.currentThread()));
            f.b(this.acy, f.j(a));
            h.o(this.acy);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
