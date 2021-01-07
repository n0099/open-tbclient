package com.baidu.mobads.utils;

import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f3532a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Intent f3533b;
    final /* synthetic */ e c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, Context context, Intent intent) {
        this.c = eVar;
        this.f3532a = context;
        this.f3533b = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3532a.startActivity(this.f3533b);
    }
}
