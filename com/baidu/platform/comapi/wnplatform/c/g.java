package com.baidu.platform.comapi.wnplatform.c;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class g implements LocationListener {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.a = dVar;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        Location location2;
        Location location3;
        Location location4;
        if (location != null) {
            location2 = this.a.u;
            if (location2 == null) {
                this.a.a(location);
            } else {
                d dVar = this.a;
                location3 = this.a.u;
                if (dVar.a(location, location3)) {
                    this.a.u = location;
                }
                d dVar2 = this.a;
                location4 = this.a.u;
                dVar2.a(location4);
            }
            this.a.h = true;
        }
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
        for (a aVar : this.a.f) {
            if (aVar != null) {
                aVar.d(4);
            }
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
        for (a aVar : this.a.f) {
            if (aVar != null) {
                aVar.d(5);
            }
        }
    }
}
