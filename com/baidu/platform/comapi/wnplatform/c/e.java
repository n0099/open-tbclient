package com.baidu.platform.comapi.wnplatform.c;

import android.location.GpsStatus;
import android.os.SystemClock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class e implements GpsStatus.Listener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f4399a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.f4399a = dVar;
    }

    @Override // android.location.GpsStatus.Listener
    public void onGpsStatusChanged(int i) {
        int i2;
        this.f4399a.n = i;
        i2 = this.f4399a.n;
        if (i2 == 4) {
            this.f4399a.m = SystemClock.elapsedRealtime();
        }
    }
}
