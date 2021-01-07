package b.a.a.a.a;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes4.dex */
public final class f extends ag implements LocationListener, Runnable {
    public long c;
    private HandlerThread d;
    private Handler e;

    public f(w wVar, y yVar) {
        super(wVar, yVar);
        this.c = 0L;
    }

    private static boolean a(double d) {
        return Math.abs(((double) Double.valueOf(d).longValue()) - d) < Double.MIN_VALUE;
    }

    @Override // b.a.a.a.a.ah
    public final void b(Handler handler) {
        this.d = new HandlerThread("gps_provider");
        this.d.start();
        this.e = new Handler(this.d.getLooper());
        this.e.post(this);
        this.c = 0L;
    }

    @Override // b.a.a.a.a.ah
    public final void c() {
        if (this.Bm.c()) {
            try {
                this.Bm.AZ.removeUpdates(this);
            } catch (Throwable th) {
            }
        }
        if (this.d != null) {
            this.d.quit();
            this.d = null;
        }
        this.c = 0L;
    }

    @Override // b.a.a.a.a.ah
    public final String d() {
        return "GpsPro";
    }

    public final boolean f() {
        LocationManager locationManager = this.Bm.AZ;
        if (locationManager == null) {
            return false;
        }
        try {
            return locationManager.isProviderEnabled("gps");
        } catch (Throwable th) {
            return false;
        }
    }

    public final Location hJ() {
        Location location = null;
        try {
            if (this.Bm.c()) {
                location = this.Bm.AZ.getLastKnownLocation("network");
            }
        } catch (Throwable th) {
        }
        return location == null ? aa.f1049a : location;
    }

    @Override // android.location.LocationListener
    public final void onLocationChanged(Location location) {
        boolean z = false;
        if (location != null) {
            try {
                if ("gps".equals(location.getProvider())) {
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    if (location.getAccuracy() <= 10000.0f && ((!a(latitude) || !a(longitude)) && Math.abs(latitude) >= 1.0E-8d && Math.abs(longitude) >= 1.0E-8d && Math.abs(latitude - 1.0d) >= 1.0E-8d && Math.abs(longitude - 1.0d) >= 1.0E-8d && latitude >= -90.0d && latitude <= 90.0d && longitude >= -180.0d && longitude <= 180.0d)) {
                        z = true;
                    }
                    if (z) {
                        this.c = System.currentTimeMillis();
                        a(new aa(location, this.c));
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    @Override // android.location.LocationListener
    public final void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public final void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.Bm.c()) {
            try {
                this.Bm.AZ.requestLocationUpdates("passive", 1000L, 0.0f, this, this.d.getLooper());
            } catch (Throwable th) {
            }
        }
    }
}
