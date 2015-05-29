package com.baidu.adp.lib.d;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements LocationListener {
    final /* synthetic */ a uG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.uG = aVar;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        f fVar;
        f fVar2;
        f fVar3;
        if (location != null) {
            fVar = this.uG.uC;
            if (fVar == null) {
                this.uG.uC = new f(this.uG, null);
                fVar2 = this.uG.uC;
                fVar2.setSelfExecute(true);
                fVar3 = this.uG.uC;
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
