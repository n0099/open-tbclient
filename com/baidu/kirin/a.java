package com.baidu.kirin;

import android.content.Context;
/* loaded from: classes.dex */
final class a implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ boolean b;
    final /* synthetic */ CheckUpdateListener c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, boolean z, CheckUpdateListener checkUpdateListener) {
        this.a = context;
        this.b = z;
        this.c = checkUpdateListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        StatUpdateAgent.b(this.a, this.b, this.c);
    }
}
