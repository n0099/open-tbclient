package com.baidu.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
/* loaded from: classes.dex */
class p implements LocationListener {
    final /* synthetic */ m a;

    private p(m mVar) {
        this.a = mVar;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        m.a(this.a, location);
        m.a(this.a, false);
        if (m.a(this.a)) {
            m.b(this.a, true);
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
        m.a(this.a, (Location) null);
        m.b(this.a, false);
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
        switch (i) {
            case 0:
                m.a(this.a, (Location) null);
                m.b(this.a, false);
                return;
            case 1:
                m.a(this.a, System.currentTimeMillis());
                m.a(this.a, true);
                m.b(this.a, false);
                return;
            case 2:
                m.a(this.a, false);
                return;
            default:
                return;
        }
    }
}
