package com.baidu.adp.lib.d;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements LocationListener {
    final /* synthetic */ a ke;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ke = aVar;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        f fVar;
        f fVar2;
        f fVar3;
        if (location != null) {
            fVar = this.ke.jZ;
            if (fVar == null) {
                this.ke.jZ = new f(this.ke, null);
                fVar2 = this.ke.jZ;
                fVar2.setSelfExecute(true);
                fVar3 = this.ke.jZ;
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
