package com.baidu.location.a;

import android.location.Location;
/* loaded from: classes2.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Location f6490a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f6491b;

    public e(d dVar, Location location) {
        this.f6491b = dVar;
        this.f6490a = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6491b.b(this.f6490a);
    }
}
