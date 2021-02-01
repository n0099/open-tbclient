package com.baidu.mobads.utils;

import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f3493a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Intent f3494b;
    final /* synthetic */ h c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, Context context, Intent intent) {
        this.c = hVar;
        this.f3493a = context;
        this.f3494b = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3493a.startActivity(this.f3494b);
    }
}
