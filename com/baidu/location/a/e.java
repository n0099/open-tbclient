package com.baidu.location.a;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Location f2544a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ d f2545b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, Location location) {
        this.f2545b = dVar;
        this.f2544a = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2545b.b(this.f2544a);
    }
}
