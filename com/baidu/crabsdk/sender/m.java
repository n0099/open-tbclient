package com.baidu.crabsdk.sender;

import android.content.Context;
import com.baidu.crabsdk.b.r;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class m implements Runnable {
    final /* synthetic */ Context Ku;
    final /* synthetic */ Throwable Kv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Throwable th, Context context) {
        this.Kv = th;
        this.Ku = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Map<String, Object> a = g.a(this.Kv, this.Ku);
            g.b(a);
            a.put("exceptionThread", r.a(Thread.currentThread()));
            i.b(this.Ku, i.g(a));
            k.o(this.Ku);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
