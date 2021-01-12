package com.baidu.mobads.production;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f3446a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f3447b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, Context context) {
        this.f3447b = bVar;
        this.f3446a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3447b.a(this.f3446a);
    }
}
