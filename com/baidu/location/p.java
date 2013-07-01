package com.baidu.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements LocationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f480a;

    private p(m mVar) {
        this.f480a = mVar;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        m.a(this.f480a, location);
        m.a(this.f480a, false);
        if (m.a(this.f480a)) {
            m.b(this.f480a, true);
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
        m.a(this.f480a, (Location) null);
        m.b(this.f480a, false);
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
        switch (i) {
            case 0:
                m.a(this.f480a, (Location) null);
                m.b(this.f480a, false);
                return;
            case 1:
                m.a(this.f480a, System.currentTimeMillis());
                m.a(this.f480a, true);
                m.b(this.f480a, false);
                return;
            case 2:
                m.a(this.f480a, false);
                return;
            default:
                return;
        }
    }
}
