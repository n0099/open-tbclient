package com.baidu.android.nebula.localserver.util;

import com.baidu.location.LocationClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ BDLocationManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BDLocationManager bDLocationManager, long j) {
        this.b = bDLocationManager;
        this.a = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        LocationClient locationClient;
        if (this.a > 0) {
            try {
                Thread.sleep(this.a);
            } catch (InterruptedException e) {
            }
        }
        this.b.h = true;
        this.b.j = System.currentTimeMillis();
        locationClient = this.b.d;
        locationClient.requestLocation();
    }
}
