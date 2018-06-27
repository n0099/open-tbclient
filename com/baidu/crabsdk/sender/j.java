package com.baidu.crabsdk.sender;

import android.content.Context;
import com.baidu.crabsdk.b.r;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j implements Runnable {
    final /* synthetic */ Context Ty;
    final /* synthetic */ Throwable Tz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Throwable th, Context context) {
        this.Tz = th;
        this.Ty = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Map<String, Object> a = d.a(this.Tz, this.Ty);
            d.b(a);
            a.put("exceptionThread", r.b(Thread.currentThread()));
            f.b(this.Ty, f.j(a));
            h.o(this.Ty);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
