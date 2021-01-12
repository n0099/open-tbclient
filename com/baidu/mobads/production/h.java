package com.baidu.mobads.production;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f3452a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f3453b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(b bVar, Context context) {
        this.f3453b = bVar;
        this.f3452a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        new Thread(new i(this)).start();
    }
}
