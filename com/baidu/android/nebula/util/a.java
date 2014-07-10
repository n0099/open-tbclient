package com.baidu.android.nebula.util;

import android.os.SystemClock;
import com.baidu.location.LocationClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Runnable {
    final /* synthetic */ BDLocationManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BDLocationManager bDLocationManager) {
        this.a = bDLocationManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        LocationClient locationClient;
        LocationClient locationClient2;
        LocationClient locationClient3;
        LocationClient locationClient4;
        locationClient = this.a.d;
        if (locationClient != null) {
            locationClient2 = this.a.d;
            if (locationClient2.isStarted()) {
                this.a.i = true;
                locationClient3 = this.a.d;
                if (locationClient3.requestLocation() == 1) {
                    locationClient4 = this.a.d;
                    locationClient4.start();
                }
                this.a.k = SystemClock.elapsedRealtime();
            }
        }
    }
}
