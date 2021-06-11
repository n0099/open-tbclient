package com.baidu.location.b;

import android.location.Location;
/* loaded from: classes2.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Location f6522a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f6523b;

    public e(d dVar, Location location) {
        this.f6523b = dVar;
        this.f6522a = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6523b.b(this.f6522a);
    }
}
