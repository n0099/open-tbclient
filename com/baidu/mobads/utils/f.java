package com.baidu.mobads.utils;

import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f3494a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Intent f3495b;
    final /* synthetic */ e c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, Context context, Intent intent) {
        this.c = eVar;
        this.f3494a = context;
        this.f3495b = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3494a.startActivity(this.f3495b);
    }
}
