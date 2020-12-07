package com.baidu.mobads.production;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f2416a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(b bVar, Context context) {
        this.b = bVar;
        this.f2416a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        new Thread(new i(this)).start();
    }
}
