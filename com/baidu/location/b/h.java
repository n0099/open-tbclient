package com.baidu.location.b;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Location f1888a;
    final /* synthetic */ g b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, Location location) {
        this.b = gVar;
        this.f1888a = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.b(this.f1888a);
    }
}
