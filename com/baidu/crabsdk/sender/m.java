package com.baidu.crabsdk.sender;

import android.content.Context;
import com.baidu.crabsdk.b.r;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class m implements Runnable {
    final /* synthetic */ Context aar;
    final /* synthetic */ Throwable aas;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Throwable th, Context context) {
        this.aas = th;
        this.aar = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Map<String, Object> a = g.a(this.aas, this.aar);
            g.b(a);
            a.put("exceptionThread", r.a(Thread.currentThread()));
            i.b(this.aar, i.i(a));
            k.o(this.aar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
