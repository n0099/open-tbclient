package com.baidu.crabsdk.sender;

import android.content.Context;
import com.baidu.crabsdk.b.r;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j implements Runnable {
    final /* synthetic */ Context Tv;
    final /* synthetic */ Throwable Tw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Throwable th, Context context) {
        this.Tw = th;
        this.Tv = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Map<String, Object> a = d.a(this.Tw, this.Tv);
            d.b(a);
            a.put("exceptionThread", r.a(Thread.currentThread()));
            f.b(this.Tv, f.j(a));
            h.o(this.Tv);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
