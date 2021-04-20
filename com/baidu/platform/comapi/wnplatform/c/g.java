package com.baidu.platform.comapi.wnplatform.c;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
/* loaded from: classes2.dex */
public class g implements LocationListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f9815a;

    public g(d dVar) {
        this.f9815a = dVar;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        Location location2;
        Location location3;
        Location location4;
        if (location != null) {
            location2 = this.f9815a.u;
            if (location2 != null) {
                d dVar = this.f9815a;
                location3 = dVar.u;
                if (dVar.a(location, location3)) {
                    this.f9815a.u = location;
                }
                d dVar2 = this.f9815a;
                location4 = dVar2.u;
                dVar2.a(location4);
            } else {
                this.f9815a.a(location);
            }
            this.f9815a.f9811h = true;
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
        for (a aVar : this.f9815a.f9810f) {
            if (aVar != null) {
                aVar.d(5);
            }
        }
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
        for (a aVar : this.f9815a.f9810f) {
            if (aVar != null) {
                aVar.d(4);
            }
        }
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
