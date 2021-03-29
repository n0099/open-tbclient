package com.baidu.platform.comapi.wnplatform.c;

import android.location.GpsStatus;
import android.os.SystemClock;
/* loaded from: classes2.dex */
public class e implements GpsStatus.Listener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f10255a;

    public e(d dVar) {
        this.f10255a = dVar;
    }

    @Override // android.location.GpsStatus.Listener
    public void onGpsStatusChanged(int i) {
        int i2;
        this.f10255a.n = i;
        i2 = this.f10255a.n;
        if (i2 == 4) {
            this.f10255a.m = SystemClock.elapsedRealtime();
        }
    }
}
