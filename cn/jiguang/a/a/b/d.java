package cn.jiguang.a.a.b;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class d implements LocationListener {
    final /* synthetic */ c jZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.jZ = cVar;
    }

    @Override // android.location.LocationListener
    public final void onLocationChanged(Location location) {
        String str;
        if (location != null) {
            c cVar = this.jZ;
            str = this.jZ.c;
            cVar.a(location, str, false);
        }
        this.jZ.d();
    }

    @Override // android.location.LocationListener
    public final void onProviderDisabled(String str) {
        this.jZ.d();
    }

    @Override // android.location.LocationListener
    public final void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public final void onStatusChanged(String str, int i, Bundle bundle) {
        if (i == 0) {
            this.jZ.d();
        }
    }
}
