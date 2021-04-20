package com.baidu.platform.comapi.wnplatform.c;

import android.location.GpsStatus;
import android.os.SystemClock;
/* loaded from: classes2.dex */
public class e implements GpsStatus.Listener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f9813a;

    public e(d dVar) {
        this.f9813a = dVar;
    }

    @Override // android.location.GpsStatus.Listener
    public void onGpsStatusChanged(int i) {
        int i2;
        this.f9813a.n = i;
        i2 = this.f9813a.n;
        if (i2 == 4) {
            this.f9813a.m = SystemClock.elapsedRealtime();
        }
    }
}
