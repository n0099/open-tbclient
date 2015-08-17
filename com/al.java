package com;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.baidu.cloudsdk.common.util.CoordinateManager;
/* loaded from: classes.dex */
public class al implements LocationListener {
    final /* synthetic */ CoordinateManager.a cWY;

    public al(CoordinateManager.a aVar) {
        this.cWY = aVar;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        CoordinateManager.this.c = this.cWY.c = location;
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
