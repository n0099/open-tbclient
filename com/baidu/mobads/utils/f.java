package com.baidu.mobads.utils;

import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f2440a;
    final /* synthetic */ Intent b;
    final /* synthetic */ e c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, Context context, Intent intent) {
        this.c = eVar;
        this.f2440a = context;
        this.b = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2440a.startActivity(this.b);
    }
}
