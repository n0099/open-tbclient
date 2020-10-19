package com.baidu.mapapi.walknavi.controllers.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.walknavi.adapter.IWEngineInitListener;
import com.baidu.mapapi.walknavi.adapter.IWMoreNPCModelOnClickListener;
import com.baidu.mapapi.walknavi.adapter.IWNPCLoadAndInitListener;
import com.baidu.mapapi.walknavi.adapter.IWNaviCalcRouteListener;
import com.baidu.mapapi.walknavi.adapter.IWRouteGuidanceListener;
import com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener;
import com.baidu.mapapi.walknavi.adapter.IWTTSPlayer;
import com.baidu.mapapi.walknavi.controllers.WNavigatorWrapper;
import com.baidu.mapapi.walknavi.model.BaseNpcModel;
import com.baidu.mapapi.walknavi.model.MultiRouteDisplayOption;
import com.baidu.mapapi.walknavi.model.WalkNaviDisplayOption;
import com.baidu.mapapi.walknavi.model.WalkRoutePlanError;
import com.baidu.platform.comapi.walknavi.WalkNaviModeSwitchListener;
import com.baidu.platform.comapi.walknavi.widget.ArCameraView;
import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;
import com.baidu.platform.comapi.wnplatform.p.g;
import com.baidu.platform.comapi.wnplatform.walkmap.WNaviBaiduMap;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static IWTTSPlayer f2169a;
    private static com.baidu.platform.comapi.wnplatform.n.c h = new e();
    private FrameLayout c;
    private RelativeLayout d;
    private ArCameraView e;
    private WalkNaviModeSwitchListener g;
    private MapView b = null;
    private View f = null;

    public void a(Activity activity, IWEngineInitListener iWEngineInitListener) {
        if (iWEngineInitListener == null) {
            throw new com.baidu.mapapi.walknavi.controllers.a("BDMapSDKException: engine init listener cannot be null");
        }
        if (this.b == null) {
            this.b = new MapView(activity);
        }
        com.baidu.platform.comapi.walknavi.b.a().a(activity, this.b);
        com.baidu.platform.comapi.walknavi.b.a().a(activity, WNaviBaiduMap.getId(), new b(this, iWEngineInitListener));
    }

    public boolean a() {
        return WNavigatorWrapper.getWNavigator().l();
    }

    public boolean a(com.baidu.platform.comapi.walknavi.e.c cVar) {
        if (!b(cVar)) {
            return false;
        }
        WNavigatorWrapper.getWNavigator().a(h);
        h();
        return true;
    }

    public void a(com.baidu.platform.comapi.walknavi.e.c cVar, IWRoutePlanListener iWRoutePlanListener) {
        b(cVar, iWRoutePlanListener);
    }

    public void a(Activity activity, IWRouteGuidanceListener iWRouteGuidanceListener) {
        WNavigatorWrapper.getWNavigator().a(activity, iWRouteGuidanceListener);
    }

    public void a(IWTTSPlayer iWTTSPlayer) {
        f2169a = iWTTSPlayer;
    }

    public void a(WLocData wLocData) {
        com.baidu.platform.comapi.walknavi.b.a().a(wLocData);
    }

    public void a(WalkNaviDisplayOption walkNaviDisplayOption) {
        com.baidu.platform.comapi.walknavi.b.a().a(walkNaviDisplayOption);
    }

    public void a(ArrayList<BaseNpcModel> arrayList) {
        com.baidu.platform.comapi.walknavi.b.a().a(arrayList);
    }

    public ArrayList<BaseNpcModel> b() {
        return com.baidu.platform.comapi.walknavi.b.a().r();
    }

    public void a(BaseNpcModel baseNpcModel) {
        com.baidu.platform.comapi.walknavi.b.a().a(baseNpcModel);
    }

    public void a(IWMoreNPCModelOnClickListener iWMoreNPCModelOnClickListener) {
        com.baidu.platform.comapi.walknavi.b.a().a(iWMoreNPCModelOnClickListener);
    }

    public void a(IWNPCLoadAndInitListener iWNPCLoadAndInitListener) {
        com.baidu.platform.comapi.walknavi.b.a().a(iWNPCLoadAndInitListener);
    }

    public View a(Activity activity) {
        if (activity == null) {
            return null;
        }
        activity.getWindow().setFlags(128, 128);
        if (this.c != null) {
            return this.c;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.c = new FrameLayout(activity);
        this.c.setLayoutParams(layoutParams);
        this.f = com.baidu.platform.comapi.walknavi.b.a().b(activity);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        this.d = new RelativeLayout(activity);
        this.d.setLayoutParams(layoutParams2);
        this.c.addView(this.b);
        this.c.addView(this.d);
        this.c.addView(this.f);
        return this.c;
    }

    public void a(Activity activity, int i, WalkNaviModeSwitchListener walkNaviModeSwitchListener) {
        this.g = walkNaviModeSwitchListener;
        if (com.baidu.platform.comapi.wnplatform.a.a().b()) {
            f();
            this.g.onSuccess();
        } else if (com.baidu.platform.comapi.wnplatform.a.a().c()) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (activity.checkSelfPermission(PermissionRequest.RESOURCE_VIDEO_CAPTURE) == 0) {
                    b(activity);
                    return;
                } else {
                    activity.requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 3001);
                    return;
                }
            }
            b(activity);
        }
    }

    public void b(Activity activity) {
        if (this.e == null) {
            this.e = new ArCameraView(activity);
            this.d.addView(this.e);
        } else {
            this.e.resumeCamera();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.b.setZOrderMediaOverlay(true);
        }
        c(activity);
    }

    @TargetApi(11)
    private void c(Activity activity) {
        if (this.d != null) {
            this.d.setVisibility(0);
        }
        com.baidu.platform.comapi.walknavi.b.a().J().d();
        com.baidu.platform.comapi.walknavi.b.a().J().a(false);
        com.baidu.platform.comapi.walknavi.b.a().J().f();
        this.b.getMap().setMapStatus(MapStatusUpdateFactory.zoomTo(1096.0f));
        this.b.getMap().setPixelFormatTransparent(true);
        this.b.getMap().hideSDKLayer();
        this.b.setBackgroundColor(0);
        this.b.setAlpha(1.0f);
        this.g.onSuccess();
    }

    public void c() {
        if (this.b != null) {
            this.b.onPause();
        }
    }

    public void d() {
        if (this.b != null) {
            this.b.onResume();
        }
    }

    public void e() {
        if (f2169a != null) {
            f2169a = null;
        }
        if (this.b != null) {
            this.b.getMap().clear();
            this.b.onDestroy();
            this.b = null;
        }
        if (this.c != null && this.c.getParent() != null) {
            ((ViewGroup) this.c.getParent()).removeAllViews();
        }
        this.c = null;
    }

    public void f() {
        if (this.d != null) {
            this.d.setVisibility(8);
        }
        if (this.e != null) {
            this.e.pauseCamera();
        }
        if (this.b != null) {
            this.b.getMap().showSDKLayer();
            this.b.getMap().setPixelFormatTransparent(false);
            com.baidu.platform.comapi.walknavi.b.a().J().e();
            com.baidu.platform.comapi.walknavi.b.a().J().a(true);
            com.baidu.platform.comapi.walknavi.b.a().J().g();
            this.b.getMap().setMapStatus(MapStatusUpdateFactory.zoomTo(19.0f));
            this.b.getMap().setBaiduHeatMapEnabled(false);
            this.b.getMap().setTrafficEnabled(false);
        }
    }

    public void g() {
        if (this.d != null && this.e != null) {
            this.d.removeView(this.e);
            this.e.releaseCamera();
            this.e = null;
            this.d = null;
        }
    }

    private boolean b(com.baidu.platform.comapi.walknavi.e.c cVar) {
        if (cVar.b("end_x") == null) {
            return false;
        }
        int length = cVar.b("end_x").length;
        int[] iArr = new int[length + 1];
        int[] iArr2 = new int[length + 1];
        int[] iArr3 = new int[length + 1];
        int[] iArr4 = new int[length + 1];
        String[] strArr = new String[length + 1];
        String[] strArr2 = new String[length + 1];
        iArr[0] = cVar.a("start_x", 0);
        iArr2[0] = cVar.a("start_y", 0);
        iArr3[0] = cVar.a("start_cityid", 0);
        strArr[0] = cVar.a("start_floor", "");
        strArr2[0] = cVar.a("start_building", "");
        iArr4[0] = -1;
        for (int i = 0; i < length; i++) {
            iArr[i + 1] = cVar.b("end_x")[i];
        }
        for (int i2 = 0; i2 < length; i2++) {
            iArr2[i2 + 1] = cVar.b("end_y")[i2];
        }
        for (int i3 = 0; i3 < length; i3++) {
            iArr3[i3 + 1] = cVar.b("end_cityid")[i3];
        }
        for (int i4 = 0; i4 < length; i4++) {
            iArr4[i4 + 1] = -2;
        }
        for (int i5 = 0; i5 < length; i5++) {
            strArr[i5 + 1] = "";
        }
        for (int i6 = 0; i6 < length; i6++) {
            strArr2[i6 + 1] = "";
        }
        String[] c = cVar.c("end_floor");
        String[] c2 = cVar.c("end_building");
        if (c != null && length == c.length) {
            for (int i7 = 0; i7 < length; i7++) {
                if (!TextUtils.isEmpty(c[i7])) {
                    strArr[i7 + 1] = c[i7];
                } else {
                    strArr[i7 + 1] = "";
                }
            }
        }
        if (c2 != null && length == c2.length) {
            for (int i8 = 0; i8 < length; i8++) {
                if (!TextUtils.isEmpty(c2[i8])) {
                    strArr2[i8 + 1] = c2[i8];
                } else {
                    strArr2[i8 + 1] = "";
                }
            }
        }
        return WNavigatorWrapper.getWNavigator().F().a(iArr, iArr2, iArr3, iArr4, strArr, strArr2);
    }

    private void b(com.baidu.platform.comapi.walknavi.e.c cVar, IWRoutePlanListener iWRoutePlanListener) {
        WNavigatorWrapper.getWNavigator().a(0, 0);
        if (!b(cVar)) {
            iWRoutePlanListener.onRoutePlanFail(WalkRoutePlanError.PARSE_FAIL);
        }
        WNavigatorWrapper.getWNavigator().a(h);
        WNavigatorWrapper.getWNavigator().F().a(new c(this, iWRoutePlanListener));
        h();
        WNavigatorWrapper.getWNavigator().F().a(13, cVar.a("route_data_mode", 0), 0, cVar.a("vehicle", 0), cVar.a("route_buff"));
    }

    public void a(com.baidu.platform.comapi.walknavi.e.c cVar, int i, IWNaviCalcRouteListener iWNaviCalcRouteListener) {
        WNavigatorWrapper.getWNavigator().F().a(new d(this, iWNaviCalcRouteListener));
        WNavigatorWrapper.getWNavigator().F().a(13, cVar.a("route_data_mode", 0), i, 0, cVar.a("route_buff"));
    }

    public List<Polyline> a(MapView mapView, MultiRouteDisplayOption multiRouteDisplayOption) {
        ArrayList arrayList = new ArrayList();
        com.baidu.f.a.d Q = com.baidu.platform.comapi.walknavi.b.a().Q();
        if (Q == null) {
            return null;
        }
        if (Q.vR() > 0) {
            int vR = Q.vR();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < vR; i++) {
                ArrayList<LatLng> b = g.b(Q, i);
                if (b.size() >= 2) {
                    PolylineOptions polylineOptions = new PolylineOptions();
                    Bundle bundle = new Bundle();
                    bundle.putInt("routeIndex", i);
                    polylineOptions.points(b);
                    polylineOptions.extraInfo(bundle);
                    if (i == 0) {
                        if (multiRouteDisplayOption != null && multiRouteDisplayOption.getFocusRouteBitmapDescriptor() != null) {
                            polylineOptions.customTexture(multiRouteDisplayOption.getFocusRouteBitmapDescriptor()).dottedLine(true);
                        } else if (multiRouteDisplayOption != null && multiRouteDisplayOption.getFocusColor() != 0) {
                            polylineOptions.color(multiRouteDisplayOption.getFocusColor());
                        } else {
                            polylineOptions.color(-11950337);
                        }
                        if (multiRouteDisplayOption != null && multiRouteDisplayOption.getFocusRouteWidth() != 0) {
                            polylineOptions.width(multiRouteDisplayOption.getFocusRouteWidth());
                        } else {
                            polylineOptions.width(20);
                        }
                    } else {
                        if (multiRouteDisplayOption != null && multiRouteDisplayOption.getNoFocusRouteBitmapDescriptor() != null) {
                            polylineOptions.customTexture(multiRouteDisplayOption.getNoFocusRouteBitmapDescriptor()).dottedLine(true);
                        } else if (multiRouteDisplayOption != null && multiRouteDisplayOption.getNoFocusColor() != 0) {
                            polylineOptions.color(multiRouteDisplayOption.getNoFocusColor());
                        } else {
                            polylineOptions.color(-12883501);
                        }
                        if (multiRouteDisplayOption != null && multiRouteDisplayOption.getNoFocusRouteWidth() != 0) {
                            polylineOptions.width(multiRouteDisplayOption.getNoFocusRouteWidth());
                        } else {
                            polylineOptions.width(20);
                        }
                    }
                    if (mapView != null && mapView.getMap() != null) {
                        arrayList.add((Polyline) mapView.getMap().addOverlay(polylineOptions));
                    }
                    arrayList2.addAll(b);
                }
            }
            if (arrayList2.size() < 2) {
                return null;
            }
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                builder.include((LatLng) it.next());
            }
            if (mapView != null && mapView.getMap() != null) {
                mapView.getMap().setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build(), 100, 100, 100, 100));
            }
        }
        return arrayList;
    }

    public static void h() {
        if (WNavigatorWrapper.getWNavigator().A()) {
            WNavigatorWrapper.getWNavigator().y();
        }
    }

    public MapView i() {
        return this.b;
    }
}
