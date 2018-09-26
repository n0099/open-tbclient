package cn.jiguang.a.a.d;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class e implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ b kq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, Context context) {
        this.kq = bVar;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.a(this.kq, this.a);
    }
}
