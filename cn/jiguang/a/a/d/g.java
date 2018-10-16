package cn.jiguang.a.a.d;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class g implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ b kW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, Context context) {
        this.kW = bVar;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.b(this.kW, this.a);
    }
}
