package com.baidu.platform.comapi.wnplatform.c;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class f implements LocationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f4617a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.f4617a = dVar;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        boolean z;
        Location location2;
        WLocData wLocData;
        Location location3;
        Location location4;
        if (location != null && !com.baidu.platform.comapi.wnplatform.a.a().d()) {
            z = this.f4617a.i;
            if (!z) {
                location2 = this.f4617a.v;
                if (location2 == null) {
                    this.f4617a.a(location);
                } else {
                    d dVar = this.f4617a;
                    location3 = this.f4617a.v;
                    if (dVar.a(location, location3)) {
                        this.f4617a.v = location;
                    }
                    d dVar2 = this.f4617a;
                    location4 = this.f4617a.v;
                    dVar2.a(location4);
                }
                d dVar3 = this.f4617a;
                wLocData = this.f4617a.c;
                dVar3.a(wLocData, "gps");
                this.f4617a.h = true;
            }
        }
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
        for (a aVar : this.f4617a.f) {
            if (aVar != null) {
                aVar.d(4);
            }
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
        for (a aVar : this.f4617a.f) {
            if (aVar != null) {
                aVar.d(5);
            }
        }
    }
}
