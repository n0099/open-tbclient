package com.baidu.mobads.utils;

import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f2484a;
    final /* synthetic */ Intent b;
    final /* synthetic */ h c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, Context context, Intent intent) {
        this.c = hVar;
        this.f2484a = context;
        this.b = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2484a.startActivity(this.b);
    }
}
