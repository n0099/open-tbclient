package com.baidu.platform.comapi.wnplatform.c;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class g implements LocationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f4619a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.f4619a = dVar;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        Location location2;
        Location location3;
        Location location4;
        if (location != null) {
            location2 = this.f4619a.v;
            if (location2 == null) {
                this.f4619a.a(location);
            } else {
                d dVar = this.f4619a;
                location3 = this.f4619a.v;
                if (dVar.a(location, location3)) {
                    this.f4619a.v = location;
                }
                d dVar2 = this.f4619a;
                location4 = this.f4619a.v;
                dVar2.a(location4);
            }
            this.f4619a.h = true;
        }
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
        for (a aVar : this.f4619a.f) {
            if (aVar != null) {
                aVar.d(4);
            }
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
        for (a aVar : this.f4619a.f) {
            if (aVar != null) {
                aVar.d(5);
            }
        }
    }
}
