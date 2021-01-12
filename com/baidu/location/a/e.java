package com.baidu.location.a;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Location f2546a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ d f2547b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, Location location) {
        this.f2547b = dVar;
        this.f2546a = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2547b.b(this.f2546a);
    }
}
