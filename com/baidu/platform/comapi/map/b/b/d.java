package com.baidu.platform.comapi.map.b.b;

import android.util.Log;
import android.util.Pair;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.MapViewInterface;
import com.baidu.platform.comapi.map.b.a;
import com.baidu.platform.comapi.util.SysOSUtil;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes3.dex */
public class d extends a {

    /* renamed from: b  reason: collision with root package name */
    private GeoPoint f4327b;
    private int c;
    private float d;
    private Queue<a.c> e;
    private a.c f;
    private a.c g;
    private boolean h;
    private com.baidu.platform.comapi.map.b.a.b i;
    private boolean j;
    private double k;
    private boolean l;
    private long m;

    public d(MapController mapController) {
        super(mapController);
        this.e = new LinkedList();
        this.h = false;
        this.j = false;
        this.k = 0.0d;
        this.l = false;
        this.m = 0L;
    }

    private int a() {
        if (this.j) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.e);
            if (linkedList.size() < 2) {
                return 0;
            }
            int i = (int) (((a.c) linkedList.get(linkedList.size() - 2)).f4317a * 8.0d);
            if (i >= 180) {
                return 179;
            }
            if (i <= -180) {
                return -179;
            }
            return i;
        }
        return 0;
    }

    private void a(MapStatus mapStatus) {
        mapStatus.level = this.d + ((float) (Math.log(this.f.f4318b) / Math.log(2.0d)));
        mapStatus.level = mapStatus.level >= 4.0f ? mapStatus.level : 4.0f;
    }

    private void a(MapStatus mapStatus, int i) {
        if (i != 0) {
            mapStatus.rotation = (mapStatus.rotation + i) % EncoderTextureDrawer.X264_WIDTH;
            this.f4323a.setMapStatusWithAnimation(mapStatus, 600);
        }
    }

    private void b(MapStatus mapStatus) {
        if (this.f4327b != null) {
            if (Math.abs(this.g.c.f4319a) > 0.0d || Math.abs(this.g.c.f4320b) > 0.0d) {
                a.b a2 = this.i.f4313a.a();
                a.b a3 = this.i.c.a();
                double sqrt = Math.sqrt(((a3.f4316b - a2.f4316b) * (a3.f4316b - a2.f4316b)) + ((a3.f4315a - a2.f4315a) * (a3.f4315a - a2.f4315a)));
                if (!MapController.isCompass || sqrt >= 100.0d) {
                    if (!MapController.isCompass && !this.l) {
                        mapStatus.centerPtX = this.f4327b.getLongitude();
                        mapStatus.centerPtY = this.f4327b.getLatitude();
                        a.b a4 = this.i.c.a();
                        mapStatus.xOffset = (float) (a4.f4315a - (this.f4323a.getScreenWidth() / 2));
                        mapStatus.yOffset = ((float) (a4.f4316b - (this.f4323a.getScreenHeight() / 2))) * (-1.0f);
                        return;
                    }
                    this.l = false;
                    com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a.a());
                    MapViewInterface mapView = this.f4323a.getMapView();
                    if (mapView != null) {
                        a.b a5 = this.i.c.a();
                        this.f4327b = mapView.getProjection().fromPixels((int) a5.f4315a, (int) a5.f4316b);
                    }
                }
            }
        }
    }

    private void c(MapStatus mapStatus) {
        double abs = Math.abs(new a.c(new a.C0290a(this.i.f4314b.f4311a, this.i.c.f4311a), this.i.f4314b).f4317a);
        double abs2 = Math.abs(new a.c(new a.C0290a(this.i.f4314b.f4312b, this.i.c.f4312b), this.i.f4314b).f4317a);
        if (this.k != 0.0d && this.k * this.g.f4318b < 0.0d) {
            return;
        }
        if (this.j) {
            mapStatus.rotation = (int) ((this.c + this.f.f4317a) % 360.0d);
        } else {
            boolean z = (this.g.f4318b < 1.0d && abs > 60.0d) || (this.g.f4318b > 1.0d && Math.abs(abs - 180.0d) > 60.0d);
            boolean z2 = (this.g.f4318b > 1.0d && abs2 > 60.0d) || (this.g.f4318b < 1.0d && Math.abs(abs2 - 180.0d) > 60.0d);
            if (z || z2) {
                if (Math.abs(this.f.f4317a) > (MapController.isCompass ? 30 : 10)) {
                    this.j = true;
                    this.f4323a.getGestureMonitor().c();
                    this.c = (int) (this.c - this.f.f4317a);
                    if (MapController.isCompass) {
                        this.l = true;
                        com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a.a());
                    }
                }
            }
        }
        this.k = this.g.f4318b;
    }

    public void a(MapStatus mapStatus, com.baidu.platform.comapi.map.b.a.b bVar, Pair<a.d, a.d> pair) {
        if (pair == null) {
            return;
        }
        int a2 = a();
        if (((a.d) pair.second).f4319a * ((a.d) pair.first).f4319a > 0.0d) {
            if (((a.d) pair.second).f4320b * ((a.d) pair.first).f4320b > 0.0d) {
                a(mapStatus, a2);
                return;
            }
        }
        if (Math.abs(((a.d) pair.first).f4319a - ((a.d) pair.second).f4319a) < 1.0d || Math.abs(((a.d) pair.first).f4320b - ((a.d) pair.second).f4320b) < 1.0d) {
            a(mapStatus, a2);
            return;
        }
        double abs = Math.abs(new a.c(new a.C0290a(bVar.f4314b.f4311a, bVar.c.f4311a), bVar.f4314b).f4317a);
        double abs2 = Math.abs(new a.c(new a.C0290a(bVar.f4314b.f4312b, bVar.c.f4312b), bVar.f4314b).f4317a);
        if (this.k != 0.0d && this.k * this.g.f4318b < 0.0d) {
            a(mapStatus, a2);
            return;
        }
        float sqrt = ((float) Math.sqrt((((a.d) pair.second).f4320b * ((a.d) pair.second).f4320b) + (((a.d) pair.first).f4319a * ((a.d) pair.first).f4319a) + (((a.d) pair.second).f4319a * ((a.d) pair.second).f4319a) + (((a.d) pair.first).f4320b * ((a.d) pair.first).f4320b))) * 2.0f;
        Log.d("zoom_speed:", String.valueOf(sqrt));
        if (sqrt <= (SysOSUtil.getInstance().getDensityDPI() * 100) / 320) {
            return;
        }
        mapStatus.hasAnimation = 1;
        mapStatus.animationTime = 600;
        a.c cVar = null;
        a.c cVar2 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.e.size()) {
                if (i < i2) {
                    cVar = cVar2;
                }
                if (cVar != null && Math.abs(cVar.f4318b - 1.0d) < 0.01d) {
                    a(mapStatus, a2);
                    return;
                }
                boolean z = (cVar.f4318b < 1.0d && abs > 60.0d) || (cVar.f4318b > 1.0d && Math.abs(abs - 180.0d) > 60.0d);
                if (z) {
                    Log.d("zoom_ratote", "aMoved");
                }
                boolean z2 = (cVar.f4318b > 1.0d && abs2 > 60.0d) || (cVar.f4318b < 1.0d && Math.abs(abs2 - 180.0d) > 60.0d);
                if (z2) {
                    Log.d("zoom_ratote", "bMoved");
                }
                Log.d("zoom_ratote", String.valueOf(this.f.f4317a));
                if (z || z2) {
                    if (Math.abs(this.f.f4317a) > (MapController.isCompass ? 30 : 15)) {
                        a(mapStatus, a2);
                        return;
                    }
                }
                Log.d("zoom_scale", String.valueOf(cVar.f4318b));
                this.h = cVar.f4318b > 1.0d;
                float densityDPI = sqrt / (800000 / SysOSUtil.getInstance().getDensityDPI());
                if (densityDPI > 2.0f) {
                    densityDPI = 2.0f;
                }
                if (this.h) {
                    mapStatus.level = densityDPI + mapStatus.level;
                } else {
                    mapStatus.level -= densityDPI;
                }
                mapStatus.level = mapStatus.level < 4.0f ? 4.0f : mapStatus.level;
                if (a2 != 0) {
                    mapStatus.rotation = (mapStatus.rotation + a2) % EncoderTextureDrawer.X264_WIDTH;
                }
                Log.d("zoom_level:", String.valueOf(mapStatus.level));
                this.f4323a.setMapStatus(mapStatus);
                return;
            }
            a.c poll = this.e.poll();
            if (poll != null) {
                Log.d("zoom_scale" + i4, poll.f4318b + "");
                if (this.e.isEmpty() && Math.abs(poll.f4318b - 1.0d) < 0.01d) {
                    a(mapStatus, a2);
                    return;
                } else if (poll.f4318b > 1.0d) {
                    i++;
                    cVar = poll;
                } else {
                    i2++;
                    cVar2 = poll;
                }
            }
            i3 = i4 + 1;
        }
    }

    @Override // com.baidu.platform.comapi.map.b.b.a
    public void a(com.baidu.platform.comapi.map.b.a.b bVar) {
        MapViewInterface mapView = this.f4323a.getMapView();
        if (mapView == null) {
            return;
        }
        MapStatus mapStatus = this.f4323a.getMapStatus();
        a.b a2 = bVar.f4313a.a();
        this.f4327b = mapView.getProjection().fromPixels((int) a2.f4315a, (int) a2.f4316b);
        this.d = this.f4323a.getZoomLevel();
        this.c = mapStatus.rotation;
        this.k = 0.0d;
    }

    @Override // com.baidu.platform.comapi.map.b.b.a
    public void a(com.baidu.platform.comapi.map.b.a.b bVar, Pair<a.d, a.d> pair) {
        MapViewInterface mapView = this.f4323a.getMapView();
        if (mapView == null) {
            return;
        }
        double d = 0.0d;
        double d2 = 0.0d;
        int x = (int) bVar.d.getX();
        int y = (int) bVar.d.getY();
        int i = x < 0 ? 0 : x;
        int i2 = y < 0 ? 0 : y;
        GeoPoint fromPixels = mapView.getProjection().fromPixels(this.f4323a.getScreenWidth() / 2, this.f4323a.getScreenHeight() / 2);
        if (fromPixels != null) {
            d = fromPixels.getLongitude();
            d2 = fromPixels.getLatitude();
        }
        this.f4323a.MapMsgProc(5, 1, (i2 << 16) | i, 0, 0, d, d2, 0.0d, 0.0d);
        this.f4323a.getGestureMonitor().a(this.f4323a.getZoomLevel());
        if (System.currentTimeMillis() - this.m > 100 || !this.f4323a.isEnableZoom()) {
            return;
        }
        a(this.f4323a.getMapStatus(), bVar, pair);
    }

    @Override // com.baidu.platform.comapi.map.b.b.a
    public void b(com.baidu.platform.comapi.map.b.a.b bVar) {
        this.i = bVar;
        this.f = new a.c(bVar.f4313a, bVar.c);
        this.g = new a.c(bVar.f4314b, bVar.c);
        MapStatus mapStatus = this.f4323a.getMapStatus();
        if (this.f4323a.isEnableZoom()) {
            a(mapStatus);
        }
        if (this.f4323a.is3DGestureEnable() && this.f4323a.getMapControlMode() != MapController.MapControlMode.STREET) {
            if (mapStatus.overlooking == 0 && this.f4323a.isCanTouchMove()) {
                b(mapStatus);
            }
            c(mapStatus);
        }
        this.f4323a.setMapStatus(mapStatus);
        if (this.f4323a.isNaviMode() && this.f4323a.getNaviMapViewListener() != null) {
            this.f4323a.getNaviMapViewListener().onAction(520, null);
        }
        this.f4323a.mapStatusChangeStart();
        if (this.e.size() >= 10) {
            this.e.poll();
        }
        this.e.offer(this.g);
        com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a.d());
        this.m = System.currentTimeMillis();
    }
}
