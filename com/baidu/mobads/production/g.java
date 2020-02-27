package com.baidu.mobads.production;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class g implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, Context context) {
        this.b = bVar;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a(this.a);
    }
}
