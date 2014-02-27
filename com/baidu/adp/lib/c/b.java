package com.baidu.adp.lib.c;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements LocationListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // android.location.LocationListener
    public final void onLocationChanged(Location location) {
        f fVar;
        f fVar2;
        f fVar3;
        if (location != null) {
            fVar = this.a.m;
            if (fVar == null) {
                this.a.m = new f(this.a, (byte) 0);
                fVar2 = this.a.m;
                fVar2.setSelfExecute(true);
                fVar3 = this.a.m;
                fVar3.execute(location);
            }
        }
    }

    @Override // android.location.LocationListener
    public final void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public final void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
