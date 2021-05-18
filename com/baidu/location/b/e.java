package com.baidu.location.b;

import android.location.Location;
/* loaded from: classes2.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Location f6579a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f6580b;

    public e(d dVar, Location location) {
        this.f6580b = dVar;
        this.f6579a = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6580b.b(this.f6579a);
    }
}
