package com.baidu.platform.comapi.wnplatform.b;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class e implements LocationListener {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.a = cVar;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        Location location2;
        com.baidu.platform.comapi.wnplatform.d.a.a aVar;
        Location location3;
        Location location4;
        if (location != null) {
            location2 = this.a.m;
            if (location2 == null) {
                this.a.a(location);
            } else {
                c cVar = this.a;
                location3 = this.a.m;
                if (cVar.a(location, location3)) {
                    this.a.m = location;
                }
                c cVar2 = this.a;
                location4 = this.a.m;
                cVar2.a(location4);
            }
            c cVar3 = this.a;
            aVar = this.a.b;
            cVar3.b(aVar);
            this.a.g = true;
        }
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
        for (a aVar : this.a.e) {
            if (aVar != null) {
                aVar.d(4);
            }
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
        for (a aVar : this.a.e) {
            if (aVar != null) {
                aVar.d(5);
            }
        }
    }
}
