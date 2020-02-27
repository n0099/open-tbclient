package com.baidu.mobads.utils;

import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class f implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ Intent b;
    final /* synthetic */ e c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, Context context, Intent intent) {
        this.c = eVar;
        this.a = context;
        this.b = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.startActivity(this.b);
    }
}
