package com.baidu.location.b;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Location f2622a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ g f2623b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, Location location) {
        this.f2623b = gVar;
        this.f2622a = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2623b.b(this.f2622a);
    }
}
