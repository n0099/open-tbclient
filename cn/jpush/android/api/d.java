package cn.jpush.android.api;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class d implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ cn.jpush.android.data.b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context, cn.jpush.android.data.b bVar) {
        this.a = context;
        this.b = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c.b(this.a, this.b);
    }
}
