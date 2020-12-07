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
/* loaded from: classes26.dex */
public class d extends a {
    private GeoPoint b;
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
            int i = (int) (((a.c) linkedList.get(linkedList.size() - 2)).f2906a * 8.0d);
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
        mapStatus.level = this.d + ((float) (Math.log(this.f.b) / Math.log(2.0d)));
        mapStatus.level = mapStatus.level >= 4.0f ? mapStatus.level : 4.0f;
    }

    private void a(MapStatus mapStatus, int i) {
        if (i != 0) {
            mapStatus.rotation = (mapStatus.rotation + i) % EncoderTextureDrawer.X264_WIDTH;
            this.f2909a.setMapStatusWithAnimation(mapStatus, 600);
        }
    }

    private void b(MapStatus mapStatus) {
        if (this.b != null) {
            if (Math.abs(this.g.c.f2907a) > 0.0d || Math.abs(this.g.c.b) > 0.0d) {
                a.b a2 = this.i.f2904a.a();
                a.b a3 = this.i.c.a();
                double sqrt = Math.sqrt(((a3.b - a2.b) * (a3.b - a2.b)) + ((a3.f2905a - a2.f2905a) * (a3.f2905a - a2.f2905a)));
                if (!MapController.isCompass || sqrt >= 100.0d) {
                    if (!MapController.isCompass && !this.l) {
                        mapStatus.centerPtX = this.b.getLongitude();
                        mapStatus.centerPtY = this.b.getLatitude();
                        a.b a4 = this.i.c.a();
                        mapStatus.xOffset = (float) (a4.f2905a - (this.f2909a.getScreenWidth() / 2));
                        mapStatus.yOffset = ((float) (a4.b - (this.f2909a.getScreenHeight() / 2))) * (-1.0f);
                        return;
                    }
                    this.l = false;
                    com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a.a());
                    MapViewInterface mapView = this.f2909a.getMapView();
                    if (mapView != null) {
                        a.b a5 = this.i.c.a();
                        this.b = mapView.getProjection().fromPixels((int) a5.f2905a, (int) a5.b);
                    }
                }
            }
        }
    }

    private void c(MapStatus mapStatus) {
        double abs = Math.abs(new a.c(new a.C0290a(this.i.b.f2903a, this.i.c.f2903a), this.i.b).f2906a);
        double abs2 = Math.abs(new a.c(new a.C0290a(this.i.b.b, this.i.c.b), this.i.b).f2906a);
        if (this.k != 0.0d && this.k * this.g.b < 0.0d) {
            return;
        }
        if (this.j) {
            mapStatus.rotation = (int) ((this.c + this.f.f2906a) % 360.0d);
        } else {
            boolean z = (this.g.b < 1.0d && abs > 60.0d) || (this.g.b > 1.0d && Math.abs(abs - 180.0d) > 60.0d);
            boolean z2 = (this.g.b > 1.0d && abs2 > 60.0d) || (this.g.b < 1.0d && Math.abs(abs2 - 180.0d) > 60.0d);
            if (z || z2) {
                if (Math.abs(this.f.f2906a) > (MapController.isCompass ? 30 : 10)) {
                    this.j = true;
                    this.f2909a.getGestureMonitor().c();
                    this.c = (int) (this.c - this.f.f2906a);
                    if (MapController.isCompass) {
                        this.l = true;
                        com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a.a());
                    }
                }
            }
        }
        this.k = this.g.b;
    }

    public void a(MapStatus mapStatus, com.baidu.platform.comapi.map.b.a.b bVar, Pair<a.d, a.d> pair) {
        int i;
        int i2;
        a.c cVar;
        a.c cVar2;
        if (pair != null) {
            int a2 = a();
            if (((a.d) pair.second).f2907a * ((a.d) pair.first).f2907a > 0.0d) {
                if (((a.d) pair.second).b * ((a.d) pair.first).b > 0.0d) {
                    a(mapStatus, a2);
                    return;
                }
            }
            if (Math.abs(((a.d) pair.first).f2907a - ((a.d) pair.second).f2907a) < 1.0d || Math.abs(((a.d) pair.first).b - ((a.d) pair.second).b) < 1.0d) {
                a(mapStatus, a2);
                return;
            }
            double abs = Math.abs(new a.c(new a.C0290a(bVar.b.f2903a, bVar.c.f2903a), bVar.b).f2906a);
            double abs2 = Math.abs(new a.c(new a.C0290a(bVar.b.b, bVar.c.b), bVar.b).f2906a);
            if (this.k != 0.0d && this.k * this.g.b < 0.0d) {
                a(mapStatus, a2);
                return;
            }
            float sqrt = ((float) Math.sqrt((((a.d) pair.second).b * ((a.d) pair.second).b) + (((a.d) pair.first).f2907a * ((a.d) pair.first).f2907a) + (((a.d) pair.second).f2907a * ((a.d) pair.second).f2907a) + (((a.d) pair.first).b * ((a.d) pair.first).b))) * 2.0f;
            Log.d("zoom_speed:", String.valueOf(sqrt));
            if (sqrt > (SysOSUtil.getInstance().getDensityDPI() * 100) / 320) {
                mapStatus.hasAnimation = 1;
                mapStatus.animationTime = 600;
                a.c cVar3 = null;
                a.c cVar4 = null;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                while (i5 < this.e.size()) {
                    a.c poll = this.e.poll();
                    if (poll != null) {
                        Log.d("zoom_scale" + i5, poll.b + "");
                        if (this.e.isEmpty() && Math.abs(poll.b - 1.0d) < 0.01d) {
                            a(mapStatus, a2);
                            return;
                        } else if (poll.b > 1.0d) {
                            int i6 = i4;
                            i2 = i3 + 1;
                            cVar = cVar4;
                            cVar2 = poll;
                            i = i6;
                        } else {
                            cVar2 = cVar3;
                            int i7 = i3;
                            cVar = poll;
                            i = i4 + 1;
                            i2 = i7;
                        }
                    } else {
                        i = i4;
                        i2 = i3;
                        cVar = cVar4;
                        cVar2 = cVar3;
                    }
                    i5++;
                    cVar3 = cVar2;
                    cVar4 = cVar;
                    i3 = i2;
                    i4 = i;
                }
                if (i3 < i4) {
                    cVar3 = cVar4;
                }
                if (cVar3 != null && Math.abs(cVar3.b - 1.0d) < 0.01d) {
                    a(mapStatus, a2);
                    return;
                }
                boolean z = (cVar3.b < 1.0d && abs > 60.0d) || (cVar3.b > 1.0d && Math.abs(abs - 180.0d) > 60.0d);
                if (z) {
                    Log.d("zoom_ratote", "aMoved");
                }
                boolean z2 = (cVar3.b > 1.0d && abs2 > 60.0d) || (cVar3.b < 1.0d && Math.abs(abs2 - 180.0d) > 60.0d);
                if (z2) {
                    Log.d("zoom_ratote", "bMoved");
                }
                Log.d("zoom_ratote", String.valueOf(this.f.f2906a));
                if (z || z2) {
                    if (Math.abs(this.f.f2906a) > (MapController.isCompass ? 30 : 15)) {
                        a(mapStatus, a2);
                        return;
                    }
                }
                Log.d("zoom_scale", String.valueOf(cVar3.b));
                this.h = cVar3.b > 1.0d;
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
                this.f2909a.setMapStatus(mapStatus);
            }
        }
    }

    @Override // com.baidu.platform.comapi.map.b.b.a
    public void a(com.baidu.platform.comapi.map.b.a.b bVar) {
        MapViewInterface mapView = this.f2909a.getMapView();
        if (mapView == null) {
            return;
        }
        MapStatus mapStatus = this.f2909a.getMapStatus();
        a.b a2 = bVar.f2904a.a();
        this.b = mapView.getProjection().fromPixels((int) a2.f2905a, (int) a2.b);
        this.d = this.f2909a.getZoomLevel();
        this.c = mapStatus.rotation;
        this.k = 0.0d;
    }

    @Override // com.baidu.platform.comapi.map.b.b.a
    public void a(com.baidu.platform.comapi.map.b.a.b bVar, Pair<a.d, a.d> pair) {
        MapViewInterface mapView = this.f2909a.getMapView();
        if (mapView == null) {
            return;
        }
        double d = 0.0d;
        double d2 = 0.0d;
        int x = (int) bVar.d.getX();
        int y = (int) bVar.d.getY();
        int i = x < 0 ? 0 : x;
        int i2 = y < 0 ? 0 : y;
        GeoPoint fromPixels = mapView.getProjection().fromPixels(this.f2909a.getScreenWidth() / 2, this.f2909a.getScreenHeight() / 2);
        if (fromPixels != null) {
            d = fromPixels.getLongitude();
            d2 = fromPixels.getLatitude();
        }
        this.f2909a.MapMsgProc(5, 1, (i2 << 16) | i, 0, 0, d, d2, 0.0d, 0.0d);
        this.f2909a.getGestureMonitor().a(this.f2909a.getZoomLevel());
        if (System.currentTimeMillis() - this.m > 100 || !this.f2909a.isEnableZoom()) {
            return;
        }
        a(this.f2909a.getMapStatus(), bVar, pair);
    }

    @Override // com.baidu.platform.comapi.map.b.b.a
    public void b(com.baidu.platform.comapi.map.b.a.b bVar) {
        this.i = bVar;
        this.f = new a.c(bVar.f2904a, bVar.c);
        this.g = new a.c(bVar.b, bVar.c);
        MapStatus mapStatus = this.f2909a.getMapStatus();
        if (this.f2909a.isEnableZoom()) {
            a(mapStatus);
        }
        if (this.f2909a.is3DGestureEnable() && this.f2909a.getMapControlMode() != MapController.MapControlMode.STREET) {
            if (mapStatus.overlooking == 0 && this.f2909a.isCanTouchMove()) {
                b(mapStatus);
            }
            c(mapStatus);
        }
        this.f2909a.setMapStatus(mapStatus);
        if (this.f2909a.isNaviMode() && this.f2909a.getNaviMapViewListener() != null) {
            this.f2909a.getNaviMapViewListener().onAction(520, null);
        }
        this.f2909a.mapStatusChangeStart();
        if (this.e.size() >= 10) {
            this.e.poll();
        }
        this.e.offer(this.g);
        com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a.d());
        this.m = System.currentTimeMillis();
    }
}
