package com.baidu.android.nebula.util;

import android.os.SystemClock;
import com.baidu.location.LocationClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BDLocationManager f581a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BDLocationManager bDLocationManager) {
        this.f581a = bDLocationManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        LocationClient locationClient;
        LocationClient locationClient2;
        LocationClient locationClient3;
        locationClient = this.f581a.d;
        if (locationClient != null) {
            locationClient2 = this.f581a.d;
            if (locationClient2.requestLocation() == 1) {
                locationClient3 = this.f581a.d;
                locationClient3.start();
            }
            this.f581a.k = SystemClock.elapsedRealtime();
            this.f581a.i = true;
        }
    }
}
