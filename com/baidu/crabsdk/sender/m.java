package com.baidu.crabsdk.sender;

import android.content.Context;
import com.baidu.crabsdk.b.r;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class m implements Runnable {
    final /* synthetic */ Context QZ;
    final /* synthetic */ Throwable Ra;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Throwable th, Context context) {
        this.Ra = th;
        this.QZ = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Map<String, Object> a = g.a(this.Ra, this.QZ);
            g.b(a);
            a.put("exceptionThread", r.a(Thread.currentThread()));
            i.b(this.QZ, i.g(a));
            k.o(this.QZ);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
