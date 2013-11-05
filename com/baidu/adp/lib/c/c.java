package com.baidu.adp.lib.c;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements LocationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f422a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.f422a = aVar;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        f fVar;
        f fVar2;
        f fVar3;
        if (location != null) {
            fVar = this.f422a.m;
            if (fVar == null) {
                this.f422a.m = new f(this.f422a, null);
                fVar2 = this.f422a.m;
                fVar2.setSelfExecute(true);
                fVar3 = this.f422a.m;
                fVar3.execute(location);
            }
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
