package com.baidu.mobads.production;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class h implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(b bVar, Context context) {
        this.b = bVar;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        new Thread(new i(this)).start();
    }
}
