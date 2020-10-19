package com.baidu.platform.comapi.wnplatform.c;

import android.location.GpsStatus;
import android.os.SystemClock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class e implements GpsStatus.Listener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f3101a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.f3101a = dVar;
    }

    @Override // android.location.GpsStatus.Listener
    public void onGpsStatusChanged(int i) {
        int i2;
        this.f3101a.o = i;
        i2 = this.f3101a.o;
        if (i2 == 4) {
            this.f3101a.n = SystemClock.elapsedRealtime();
        }
    }
}
