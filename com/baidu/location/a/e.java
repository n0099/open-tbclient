package com.baidu.location.a;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Location f1911a;
    final /* synthetic */ d b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, Location location) {
        this.b = dVar;
        this.f1911a = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.b(this.f1911a);
    }
}
