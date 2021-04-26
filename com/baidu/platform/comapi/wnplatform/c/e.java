package com.baidu.platform.comapi.wnplatform.c;

import android.location.GpsStatus;
import android.os.SystemClock;
/* loaded from: classes2.dex */
public class e implements GpsStatus.Listener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f10178a;

    public e(d dVar) {
        this.f10178a = dVar;
    }

    @Override // android.location.GpsStatus.Listener
    public void onGpsStatusChanged(int i2) {
        int i3;
        this.f10178a.n = i2;
        i3 = this.f10178a.n;
        if (i3 == 4) {
            this.f10178a.m = SystemClock.elapsedRealtime();
        }
    }
}
