package com.baidu.location.b;

import android.location.Location;
/* loaded from: classes2.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Location f6479a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f6480b;

    public e(d dVar, Location location) {
        this.f6480b = dVar;
        this.f6479a = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6480b.b(this.f6479a);
    }
}
