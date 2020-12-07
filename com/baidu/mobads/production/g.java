package com.baidu.mobads.production;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f2411a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, Context context) {
        this.b = bVar;
        this.f2411a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a(this.f2411a);
    }
}
