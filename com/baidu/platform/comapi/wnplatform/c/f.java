package com.baidu.platform.comapi.wnplatform.c;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class f implements LocationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f3104a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.f3104a = dVar;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        boolean z;
        Location location2;
        WLocData wLocData;
        Location location3;
        Location location4;
        if (location != null && !com.baidu.platform.comapi.wnplatform.a.a().d()) {
            z = this.f3104a.i;
            if (!z) {
                location2 = this.f3104a.v;
                if (location2 == null) {
                    this.f3104a.a(location);
                } else {
                    d dVar = this.f3104a;
                    location3 = this.f3104a.v;
                    if (dVar.a(location, location3)) {
                        this.f3104a.v = location;
                    }
                    d dVar2 = this.f3104a;
                    location4 = this.f3104a.v;
                    dVar2.a(location4);
                }
                d dVar3 = this.f3104a;
                wLocData = this.f3104a.c;
                dVar3.a(wLocData, "gps");
                this.f3104a.h = true;
            }
        }
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
        for (a aVar : this.f3104a.f) {
            if (aVar != null) {
                aVar.d(4);
            }
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
        for (a aVar : this.f3104a.f) {
            if (aVar != null) {
                aVar.d(5);
            }
        }
    }
}
