package com.baidu.platform.comapi.wnplatform.c;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;
/* loaded from: classes2.dex */
public class f implements LocationListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f10255a;

    public f(d dVar) {
        this.f10255a = dVar;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        Location location2;
        WLocData wLocData;
        Location location3;
        Location location4;
        if (location != null) {
            location2 = this.f10255a.u;
            if (location2 != null) {
                d dVar = this.f10255a;
                location3 = dVar.u;
                if (dVar.a(location, location3)) {
                    this.f10255a.u = location;
                }
                d dVar2 = this.f10255a;
                location4 = dVar2.u;
                dVar2.a(location4);
            } else {
                this.f10255a.a(location);
            }
            d dVar3 = this.f10255a;
            wLocData = dVar3.f10248c;
            dVar3.a(wLocData, "gps");
            this.f10255a.f10252h = true;
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
        for (a aVar : this.f10255a.f10251f) {
            if (aVar != null) {
                aVar.d(5);
            }
        }
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
        for (a aVar : this.f10255a.f10251f) {
            if (aVar != null) {
                aVar.d(4);
            }
        }
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
