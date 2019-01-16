package com.baidu.crabsdk.sender;

import android.content.Context;
import com.baidu.crabsdk.b.r;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class j implements Runnable {
    final /* synthetic */ Context YT;
    final /* synthetic */ Throwable YU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Throwable th, Context context) {
        this.YU = th;
        this.YT = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Map<String, Object> a = d.a(this.YU, this.YT);
            d.b(a);
            a.put("exceptionThread", r.a(Thread.currentThread()));
            f.b(this.YT, f.j(a));
            h.o(this.YT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
