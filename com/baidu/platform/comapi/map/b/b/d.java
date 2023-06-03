package com.baidu.platform.comapi.map.b.b;

import android.graphics.Point;
import android.util.Pair;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.x;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.MapViewInterface;
import com.baidu.platform.comapi.map.al;
import com.baidu.platform.comapi.map.b.a;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.chromium.net.NetError;
/* loaded from: classes3.dex */
public class d extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public GeoPoint b;
    public int c;
    public float d;
    public Queue<a.c> e;
    public a.c f;
    public a.c g;
    public boolean h;
    public com.baidu.platform.comapi.map.b.a.b i;
    public boolean j;
    public double k;
    public boolean l;
    public long m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(MapController mapController) {
        super(mapController);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mapController};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((MapController) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new LinkedList();
        this.h = false;
        this.j = false;
        this.k = 0.0d;
        this.l = false;
        this.m = 0L;
    }

    private int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (!this.j) {
                return 0;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.e);
            if (linkedList.size() < 2) {
                return 0;
            }
            int i = (int) (((a.c) linkedList.get(linkedList.size() - 2)).a * 8.0d);
            if (i >= 180) {
                return 179;
            }
            if (i <= -180) {
                return NetError.ERR_WRONG_VERSION_ON_EARLY_DATA;
            }
            return i;
        }
        return invokeV.intValue;
    }

    private void a(MapStatus mapStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, mapStatus) == null) {
            float log = this.d + ((float) (Math.log(this.f.b) / Math.log(2.0d)));
            mapStatus.level = log;
            if (log < 4.0f) {
                log = 4.0f;
            }
            mapStatus.level = log;
        }
    }

    private void a(MapStatus mapStatus, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65539, this, mapStatus, i) == null) && i != 0) {
            mapStatus.rotation = (mapStatus.rotation + i) % 360;
            this.a.setMapStatusWithAnimation(mapStatus, 600);
        }
    }

    private void b(MapStatus mapStatus) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, mapStatus) == null) && this.b != null) {
            if (Math.abs(this.g.c.a) > 0.0d || Math.abs(this.g.c.b) > 0.0d) {
                a.b a = this.i.a.a();
                a.b a2 = this.i.c.a();
                double d = a2.a;
                double d2 = a.a;
                double d3 = a2.b;
                double d4 = a.b;
                double sqrt = Math.sqrt(((d - d2) * (d - d2)) + ((d3 - d4) * (d3 - d4)));
                if (MapController.isCompass && sqrt < 100.0d) {
                    return;
                }
                if (!MapController.isCompass && !this.l) {
                    mapStatus.centerPtX = this.b.getLongitude();
                    mapStatus.centerPtY = this.b.getLatitude();
                    a.b a3 = this.i.c.a();
                    mapStatus.xOffset = (float) (a3.a - ((mapStatus.winRound.left + (this.a.getScreenWidth() / 2)) + mapStatus.xScreenOffset));
                    mapStatus.yOffset = ((float) (a3.b - ((mapStatus.winRound.top + (this.a.getScreenHeight() / 2)) + mapStatus.yScreenOffset))) * (-1.0f);
                    return;
                }
                this.l = false;
                com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a.a());
                MapViewInterface mapView = this.a.getMapView();
                if (mapView == null) {
                    return;
                }
                a.b a4 = this.i.c.a();
                this.b = mapView.getProjection().fromPixels((int) a4.a, (int) a4.b);
            }
        }
    }

    private void c(MapStatus mapStatus) {
        boolean z;
        boolean z2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, mapStatus) == null) {
            com.baidu.platform.comapi.map.b.a.b bVar = this.i;
            double abs = Math.abs(new a.c(new a.C0133a(bVar.b.a, bVar.c.a), this.i.b).a);
            com.baidu.platform.comapi.map.b.a.b bVar2 = this.i;
            double abs2 = Math.abs(new a.c(new a.C0133a(bVar2.b.b, bVar2.c.b), this.i.b).a);
            double d = this.k;
            boolean z3 = false;
            if (d != 0.0d && d * this.g.b < 0.0d) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return;
            }
            if (this.j) {
                mapStatus.rotation = (int) ((this.c + this.f.a) % 360.0d);
            } else {
                if ((this.g.b < 1.0d && abs > 60.0d) || (this.g.b > 1.0d && Math.abs(abs - 180.0d) > 60.0d)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if ((this.g.b > 1.0d && abs2 > 60.0d) || (this.g.b < 1.0d && Math.abs(abs2 - 180.0d) > 60.0d)) {
                    z3 = true;
                }
                if (z2 || z3) {
                    double abs3 = Math.abs(this.f.a);
                    if (MapController.isCompass) {
                        i = 30;
                    } else {
                        i = 10;
                    }
                    if (abs3 > i) {
                        this.j = true;
                        this.a.getGestureMonitor().c();
                        this.c = (int) (this.c - this.f.a);
                        if (MapController.isCompass) {
                            this.l = true;
                            com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a.a());
                        }
                    }
                }
            }
            this.k = this.g.b;
        }
    }

    public void a(MapStatus mapStatus, com.baidu.platform.comapi.map.b.a.b bVar, Pair<a.d, a.d> pair) {
        boolean z;
        a.c cVar;
        double d;
        boolean z2;
        boolean z3;
        int i;
        boolean z4;
        int i2;
        double d2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048576, this, mapStatus, bVar, pair) == null) && pair != null) {
            int a = a();
            Object obj = pair.first;
            double d3 = ((a.d) obj).a;
            Object obj2 = pair.second;
            if (d3 * ((a.d) obj2).a > 0.0d && ((a.d) obj).b * ((a.d) obj2).b > 0.0d) {
                a(mapStatus, a);
            } else if (Math.abs(((a.d) pair.first).a - ((a.d) pair.second).a) >= 1.0d && Math.abs(((a.d) pair.first).b - ((a.d) pair.second).b) >= 1.0d) {
                double abs = Math.abs(new a.c(new a.C0133a(bVar.b.a, bVar.c.a), bVar.b).a);
                double abs2 = Math.abs(new a.c(new a.C0133a(bVar.b.b, bVar.c.b), bVar.b).a);
                double d4 = this.k;
                if (d4 != 0.0d && d4 * this.g.b < 0.0d) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    a(mapStatus, a);
                    return;
                }
                Object obj3 = pair.first;
                Object obj4 = pair.second;
                float sqrt = ((float) Math.sqrt((((a.d) obj3).a * ((a.d) obj3).a) + (((a.d) obj4).a * ((a.d) obj4).a) + (((a.d) obj3).b * ((a.d) obj3).b) + (((a.d) obj4).b * ((a.d) obj4).b))) * 2.0f;
                if (sqrt > (SysOSUtil.getInstance().getDensityDPI() * 100) / 320) {
                    mapStatus.hasAnimation = 1;
                    mapStatus.animationTime = 600;
                    a.c cVar2 = null;
                    a.c cVar3 = null;
                    int i3 = 0;
                    int i4 = 0;
                    int i5 = 0;
                    while (i3 < this.e.size()) {
                        a.c poll = this.e.poll();
                        if (poll != null) {
                            if (this.e.isEmpty()) {
                                d2 = 1.0d;
                                i2 = a;
                                if (Math.abs(poll.b - 1.0d) < 0.01d) {
                                    a(mapStatus, i2);
                                    return;
                                }
                            } else {
                                i2 = a;
                                d2 = 1.0d;
                            }
                            a.c cVar4 = cVar2;
                            a.c cVar5 = cVar3;
                            if (poll.b > d2) {
                                i4++;
                                cVar2 = cVar4;
                                cVar3 = poll;
                            } else {
                                i5++;
                                cVar2 = poll;
                                cVar3 = cVar5;
                            }
                        } else {
                            i2 = a;
                        }
                        i3++;
                        a = i2;
                    }
                    int i6 = a;
                    a.c cVar6 = cVar2;
                    a.c cVar7 = cVar3;
                    if (i4 >= i5) {
                        cVar = cVar7;
                    } else {
                        cVar = cVar6;
                    }
                    if (cVar != null) {
                        d = 1.0d;
                        if (Math.abs(cVar.b - 1.0d) < 0.01d) {
                            a(mapStatus, i6);
                            return;
                        }
                    } else {
                        d = 1.0d;
                    }
                    if ((cVar.b < d && abs > 60.0d) || (cVar.b > d && Math.abs(abs - 180.0d) > 60.0d)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if ((cVar.b > 1.0d && abs2 > 60.0d) || (cVar.b < 1.0d && Math.abs(abs2 - 180.0d) > 60.0d)) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z2 || z3) {
                        double abs3 = Math.abs(this.f.a);
                        if (MapController.isCompass) {
                            i = 30;
                        } else {
                            i = 15;
                        }
                        if (abs3 > i) {
                            a(mapStatus, i6);
                            return;
                        }
                    }
                    if (cVar.b > 1.0d) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    this.h = z4;
                    float densityDPI = sqrt / (AdaptiveTrackSelection.DEFAULT_MAX_INITIAL_BITRATE / SysOSUtil.getInstance().getDensityDPI());
                    if (densityDPI > 2.0f) {
                        densityDPI = 2.0f;
                    }
                    if (!this.h) {
                        mapStatus.level -= densityDPI;
                    } else {
                        mapStatus.level += densityDPI;
                    }
                    float f = mapStatus.level;
                    if (f < 4.0f) {
                        f = 4.0f;
                    }
                    mapStatus.level = f;
                    if (i6 != 0) {
                        mapStatus.rotation = (mapStatus.rotation + i6) % 360;
                    }
                    this.a.setMapStatus(mapStatus);
                    this.a.mIsAnimating = true;
                }
            } else {
                a(mapStatus, a);
            }
        }
    }

    @Override // com.baidu.platform.comapi.map.b.b.a
    public void a(com.baidu.platform.comapi.map.b.a.b bVar) {
        MapViewInterface mapView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) != null) || (mapView = this.a.getMapView()) == null) {
            return;
        }
        MapStatus mapStatus = this.a.getMapStatus();
        a.b a = bVar.a.a();
        this.b = mapView.getProjection().fromPixels((int) a.a, (int) a.b);
        this.d = this.a.getZoomLevel();
        this.c = mapStatus.rotation;
        this.k = 0.0d;
    }

    @Override // com.baidu.platform.comapi.map.b.b.a
    public void a(com.baidu.platform.comapi.map.b.a.b bVar, Pair<a.d, a.d> pair) {
        MapViewInterface mapView;
        double d;
        double d2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bVar, pair) != null) || (mapView = this.a.getMapView()) == null) {
            return;
        }
        MapStatus mapStatus = this.a.getMapStatus();
        int x = (int) bVar.d.getX();
        int y = (int) bVar.d.getY();
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
        GeoPoint fromPixels = mapView.getProjection().fromPixels((int) ((this.a.getScreenWidth() / 2) + mapStatus.winRound.left + mapStatus.xScreenOffset), (int) ((this.a.getScreenHeight() / 2) + mapStatus.winRound.top + mapStatus.yScreenOffset));
        if (fromPixels != null) {
            double longitude = fromPixels.getLongitude();
            d2 = fromPixels.getLatitude();
            d = longitude;
        } else {
            d = 0.0d;
            d2 = 0.0d;
        }
        this.a.MapMsgProc(5, 1, (y << 16) | x, 0, 0, d, d2, 0.0d, 0.0d);
        this.a.getGestureMonitor().a(this.a.getZoomLevel());
        if (System.currentTimeMillis() - this.m <= 100) {
            MapController mapController = this.a;
            if (mapController.mIsInertialAnimation && mapController.isEnableZoom()) {
                a(this.a.getMapStatus(), bVar, pair);
            }
        }
    }

    @Override // com.baidu.platform.comapi.map.b.b.a
    public void a(com.baidu.platform.comapi.map.b.a.b bVar, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, bVar, motionEvent) == null) {
            this.i = bVar;
            this.f = new a.c(bVar.a, bVar.c);
            this.g = new a.c(bVar.b, bVar.c);
            List<al> listeners = this.a.getListeners();
            if (listeners != null) {
                x mapStatusInner = this.a.getMapStatusInner();
                float x = motionEvent.getX(1) - motionEvent.getX(0);
                float y = motionEvent.getY(1) - motionEvent.getY(0);
                Point point = new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
                Point point2 = new Point((int) (motionEvent.getRawX() + x), (int) (motionEvent.getRawY() + y));
                for (int i = 0; i < listeners.size(); i++) {
                    al alVar = listeners.get(i);
                    if (alVar != null && alVar.a(point, point2, mapStatusInner)) {
                        return;
                    }
                }
            }
            MapStatus mapStatus = this.a.getMapStatus();
            if (this.a.isEnableZoom()) {
                a(mapStatus);
            }
            if (this.a.is3DGestureEnable() && this.a.getMapControlMode() != MapController.MapControlMode.STREET) {
                if (mapStatus.overlooking == 0 && this.a.isCanTouchMove()) {
                    b(mapStatus);
                }
                c(mapStatus);
            }
            this.a.setMapStatus(mapStatus);
            if (this.a.isNaviMode() && this.a.getNaviMapViewListener() != null) {
                this.a.getNaviMapViewListener().onAction(520, null);
            }
            this.a.mapStatusChangeStart();
            if (this.e.size() >= 10) {
                this.e.poll();
            }
            this.e.offer(this.g);
            com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a.d());
            this.m = System.currentTimeMillis();
        }
    }
}
