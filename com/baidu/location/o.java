package com.baidu.location;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationManager;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements GpsStatus.Listener, GpsStatus.NmeaListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f479a;

    private o(m mVar) {
        this.f479a = mVar;
    }

    @Override // android.location.GpsStatus.Listener
    public void onGpsStatusChanged(int i) {
        LocationManager locationManager;
        GpsStatus gpsStatus;
        LocationManager locationManager2;
        GpsStatus gpsStatus2;
        GpsStatus gpsStatus3;
        int i2;
        int i3;
        LocationManager locationManager3;
        locationManager = this.f479a.c;
        if (locationManager == null) {
            return;
        }
        switch (i) {
            case 2:
                this.f479a.b((Location) null);
                this.f479a.b(false);
                int unused = m.h = 0;
                return;
            case 3:
            default:
                return;
            case 4:
                ap.a("baidu_location_service", "gps status change");
                gpsStatus = this.f479a.f;
                if (gpsStatus == null) {
                    m mVar = this.f479a;
                    locationManager3 = this.f479a.c;
                    mVar.f = locationManager3.getGpsStatus(null);
                } else {
                    locationManager2 = this.f479a.c;
                    gpsStatus2 = this.f479a.f;
                    locationManager2.getGpsStatus(gpsStatus2);
                }
                gpsStatus3 = this.f479a.f;
                int i4 = 0;
                for (GpsSatellite gpsSatellite : gpsStatus3.getSatellites()) {
                    i4 = gpsSatellite.usedInFix() ? i4 + 1 : i4;
                }
                ap.a("baidu_location_service", "gps nunmber in count:" + i4);
                i2 = m.h;
                if (i2 >= 3 && i4 < 3) {
                    this.f479a.i = System.currentTimeMillis();
                }
                if (i4 < 3) {
                    this.f479a.b(false);
                }
                i3 = m.h;
                if (i3 <= 3 && i4 > 3) {
                    this.f479a.b(true);
                }
                int unused2 = m.h = i4;
                return;
        }
    }

    @Override // android.location.GpsStatus.NmeaListener
    public void onNmeaReceived(long j, String str) {
        long j2;
        List list;
        boolean z;
        List list2;
        List list3;
        List list4;
        String str2;
        String str3;
        String str4;
        if (str == null || str.equals("")) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        j2 = this.f479a.p;
        if (currentTimeMillis - j2 > 400) {
            z = this.f479a.s;
            if (z) {
                list2 = this.f479a.t;
                if (list2.size() > 0) {
                    try {
                        m mVar = this.f479a;
                        list4 = this.f479a.t;
                        str2 = this.f479a.u;
                        str3 = this.f479a.v;
                        str4 = this.f479a.w;
                        q qVar = new q(mVar, list4, str2, str3, str4);
                        if (qVar.c()) {
                            ap.f = qVar.b();
                            if (ap.f > 0) {
                                String unused = m.x = String.format("&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&nmea=%.1f|%.1f&ll_t=%d&g_tp=%d", Double.valueOf(qVar.e()), Double.valueOf(qVar.d()), Double.valueOf(qVar.g()), Double.valueOf(qVar.h()), 0, Integer.valueOf(qVar.k()), Double.valueOf(qVar.f()), Double.valueOf(qVar.j()), Double.valueOf(qVar.i()), Long.valueOf(currentTimeMillis / 1000), Integer.valueOf(ap.f));
                            }
                        } else {
                            ap.f = 0;
                            ap.a("baidu_location_service", "nmea invalid");
                        }
                    } catch (Exception e) {
                        ap.f = 0;
                    }
                    list3 = this.f479a.t;
                    list3.clear();
                    this.f479a.u = this.f479a.v = this.f479a.w = null;
                    this.f479a.s = false;
                }
            }
        }
        if (str.startsWith("$GPGGA")) {
            this.f479a.s = true;
            this.f479a.u = str.trim();
        } else if (str.startsWith("$GPGSV")) {
            list = this.f479a.t;
            list.add(str.trim());
        } else if (str.startsWith("$GPRMC")) {
            this.f479a.v = str.trim();
        } else if (str.startsWith("$GPGSA")) {
            this.f479a.w = str.trim();
        }
        this.f479a.p = System.currentTimeMillis();
    }
}
