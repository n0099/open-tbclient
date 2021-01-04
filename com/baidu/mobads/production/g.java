package com.baidu.mobads.production;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f3483a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f3484b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, Context context) {
        this.f3484b = bVar;
        this.f3483a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3484b.a(this.f3483a);
    }
}
