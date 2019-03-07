package cn.jiguang.a.a.d;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class f implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ b kY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar, Context context) {
        this.kY = bVar;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.b(this.kY, this.a);
    }
}
