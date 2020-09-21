package com.baidu.platform.comapi.map.b.b;

import android.util.Pair;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.b.a;
/* loaded from: classes3.dex */
public class c extends a {
    private boolean b;
    private long c;

    public c(MapController mapController) {
        super(mapController);
        this.b = true;
    }

    private void a(double d, MapStatus mapStatus) {
        if (this.c == 0) {
            this.c = System.currentTimeMillis();
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.c = currentTimeMillis;
        if (currentTimeMillis - this.c > 50 || Math.abs(d) < 4.0d) {
            return;
        }
        if (d > 0.0d) {
            mapStatus.overlooking -= 4;
        } else {
            mapStatus.overlooking = (int) (mapStatus.overlooking + 2.0d);
        }
    }

    @Override // com.baidu.platform.comapi.map.b.b.a
    public void a(com.baidu.platform.comapi.map.b.a.b bVar, Pair<a.d, a.d> pair) {
        MapStatus mapStatus = this.a.getMapStatus();
        if (mapStatus.bOverlookSpringback) {
            if (mapStatus.overlooking > 0) {
                mapStatus.overlooking = 0;
            } else {
                mapStatus.overlooking = mapStatus.minOverlooking;
            }
            this.a.setMapStatusWithAnimation(mapStatus, 200);
        }
    }

    @Override // com.baidu.platform.comapi.map.b.b.a
    public void b(com.baidu.platform.comapi.map.b.a.b bVar) {
        a.C0240a c0240a = bVar.b;
        a.C0240a c0240a2 = bVar.c;
        MapStatus mapStatus = this.a.getMapStatus();
        double d = c0240a2.a.b - c0240a.a.b;
        double d2 = c0240a2.b.b - c0240a.b.b;
        if (d * d2 > 0.0d) {
            a(d, mapStatus);
        } else if (d * d2 == 0.0d) {
            if (d != 0.0d) {
                a(d, mapStatus);
            } else if (d2 != 0.0d) {
                a(d2, mapStatus);
            }
        } else if (Math.abs(d) > Math.abs(d2)) {
            a(d, mapStatus);
        } else {
            a(d2, mapStatus);
        }
        this.a.setMapStatus(mapStatus);
        if (this.b) {
            this.b = false;
            this.a.getGestureMonitor().d();
        }
    }
}
