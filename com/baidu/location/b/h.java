package com.baidu.location.b;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Location f2621a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ g f2622b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, Location location) {
        this.f2622b = gVar;
        this.f2621a = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2622b.b(this.f2621a);
    }
}
