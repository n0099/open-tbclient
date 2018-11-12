package com.baidu.mapapi.walknavi.controllers.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.walknavi.adapter.IWEngineInitListener;
import com.baidu.mapapi.walknavi.adapter.IWRouteGuidanceListener;
import com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener;
import com.baidu.mapapi.walknavi.adapter.IWTTSPlayer;
import com.baidu.mapapi.walknavi.controllers.WNavigatorWrapper;
import com.baidu.platform.comapi.walknavi.WalkNaviModeSwitchListener;
import com.baidu.platform.comapi.walknavi.widget.ArCameraView;
import com.baidu.platform.comapi.wnplatform.walkmap.WNaviBaiduMap;
/* loaded from: classes4.dex */
public class a {
    private static IWTTSPlayer b;
    private static com.baidu.platform.comapi.wnplatform.m.c j = new f();
    private FrameLayout d;
    private RelativeLayout e;
    private ArCameraView f;
    private com.baidu.platform.comapi.walknavi.d.a g;
    private RelativeLayout h;
    private WalkNaviModeSwitchListener i;
    private MapView c = null;
    View a = null;

    public void a(Activity activity, IWEngineInitListener iWEngineInitListener) {
        if (iWEngineInitListener == null) {
            throw new com.baidu.mapapi.walknavi.controllers.a("engine init listener cannot be null");
        }
        if (this.c == null) {
            this.c = new MapView(activity);
        }
        com.baidu.platform.comapi.walknavi.b.a().a(activity, this.c);
        com.baidu.platform.comapi.walknavi.b.a().a(activity, WNaviBaiduMap.getId(), new b(this, iWEngineInitListener));
    }

    public boolean a() {
        return WNavigatorWrapper.getWNavigator().h();
    }

    public void a(com.baidu.platform.comapi.walknavi.e.c cVar, IWRoutePlanListener iWRoutePlanListener) {
        b(cVar, iWRoutePlanListener);
    }

    public void a(Activity activity, IWRouteGuidanceListener iWRouteGuidanceListener) {
        WNavigatorWrapper.getWNavigator().a(activity, iWRouteGuidanceListener);
    }

    public void a(IWTTSPlayer iWTTSPlayer) {
        b = iWTTSPlayer;
    }

    public View a(Activity activity) {
        if (activity != null) {
            activity.getWindow().setFlags(128, 128);
        }
        if (this.d != null) {
            return this.d;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.d = new FrameLayout(activity);
        this.d.setLayoutParams(layoutParams);
        this.a = com.baidu.platform.comapi.walknavi.b.a().b(activity);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        this.e = new RelativeLayout(activity);
        this.e.setLayoutParams(layoutParams2);
        this.d.addView(this.e);
        this.d.addView(this.c);
        this.d.addView(this.a);
        this.h = com.baidu.platform.comapi.walknavi.b.a().i();
        if (this.h != null) {
            this.g = new com.baidu.platform.comapi.walknavi.d.a(activity);
            this.g.b().getMap().getUiSettings().setAllGesturesEnabled(false);
            this.g.b().getMap().setOnMapTouchListener(new c(this));
            this.h.addView(this.g);
        }
        return this.d;
    }

    public void a(Activity activity, int i, WalkNaviModeSwitchListener walkNaviModeSwitchListener) {
        this.i = walkNaviModeSwitchListener;
        if (i == 1) {
            g();
            this.i.onSuccess();
        } else if (i == 2) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (activity.checkSelfPermission("android.permission.CAMERA") == 0) {
                    b(activity);
                    return;
                } else {
                    activity.requestPermissions(new String[]{"android.permission.CAMERA"}, 3001);
                    return;
                }
            }
            b(activity);
        }
    }

    public void b(Activity activity) {
        if (this.f == null) {
            this.f = new ArCameraView(activity);
            this.e.addView(this.f);
            this.c.setZOrderMediaOverlay(true);
        } else {
            this.f.resumeCamera();
        }
        c(activity);
    }

    @TargetApi(11)
    private void c(Activity activity) {
        if (this.e != null) {
            if (this.f == null) {
                this.f = new ArCameraView(activity);
                this.e.addView(this.f);
            }
            this.e.setVisibility(0);
            this.c.setZOrderMediaOverlay(true);
        }
        com.baidu.platform.comapi.walknavi.b.a().B().d();
        com.baidu.platform.comapi.walknavi.b.a().B().a(false);
        com.baidu.platform.comapi.walknavi.b.a().B().f();
        MapStatus mapStatus = this.c.getMap().getMapStatus();
        this.c.getMap().setMapStatus(MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder(mapStatus).zoom(26.0f).build()));
        new Handler(Looper.getMainLooper()).postDelayed(new d(this, mapStatus), 100L);
        this.c.getMap().setPixelFormatTransparent(true);
        this.c.getMap().hideSDKLayer();
        this.c.setBackgroundColor(0);
        this.c.setAlpha(1.0f);
        this.i.onSuccess();
    }

    public void b() {
        if (this.g != null && this.g.b() != null && this.h.getVisibility() == 0) {
            this.g.b().onPause();
        }
        if (this.c != null) {
            this.c.onPause();
        }
    }

    public void c() {
        if (this.g != null && this.g.b() != null && this.h.getVisibility() == 0) {
            this.g.b().onResume();
        }
        if (this.c != null) {
            this.c.onResume();
        }
    }

    public void d() {
        if (this.g != null && this.g.b() != null) {
            this.g.c();
            this.g = null;
        }
        if (this.c != null) {
            this.c.getMap().clear();
            this.c.onDestroy();
            this.c = null;
        }
        g();
        h();
        if (this.d != null && this.d.getParent() != null) {
            ((ViewGroup) this.d.getParent()).removeAllViews();
        }
        this.d = null;
    }

    private void g() {
        if (this.e != null && this.f != null) {
            this.e.removeView(this.f);
            this.e.setVisibility(8);
        }
        if (this.f != null) {
            this.f.releaseCamera();
            this.f = null;
        }
        if (this.c != null) {
            this.c.getMap().showSDKLayer();
            this.c.getMap().setPixelFormatTransparent(false);
            com.baidu.platform.comapi.walknavi.b.a().B().e();
            com.baidu.platform.comapi.walknavi.b.a().B().a(true);
            com.baidu.platform.comapi.walknavi.b.a().B().g();
            this.c.getMap().setMapStatus(MapStatusUpdateFactory.zoomTo(19.0f));
            this.c.getMap().setBaiduHeatMapEnabled(false);
            this.c.getMap().setTrafficEnabled(false);
        }
    }

    private void h() {
        if (this.e != null) {
            this.e.removeAllViews();
            if (this.f != null) {
                this.e.removeView(this.f);
                this.f.releaseCamera();
                this.f = null;
            }
        }
    }

    private void b(com.baidu.platform.comapi.walknavi.e.c cVar, IWRoutePlanListener iWRoutePlanListener) {
        WNavigatorWrapper.getWNavigator().a(0, 0);
        if (cVar.b("end_x") != null) {
            int length = cVar.b("end_x").length;
            int[] iArr = new int[length + 1];
            int[] iArr2 = new int[length + 1];
            int[] iArr3 = new int[length + 1];
            int[] iArr4 = new int[length + 1];
            iArr[0] = cVar.a("start_x", 0);
            iArr2[0] = cVar.a("start_y", 0);
            iArr3[0] = cVar.a("start_cityid", 0);
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
                iArr4[i4 + 1] = i4 + 1;
            }
            if (WNavigatorWrapper.getWNavigator().x().a(iArr, iArr2, iArr3, iArr4)) {
                WNavigatorWrapper.getWNavigator().a(j);
                WNavigatorWrapper.getWNavigator().a(new e(this, iWRoutePlanListener));
                e();
                WNavigatorWrapper.getWNavigator().x().a(13, cVar.a("route_data_mode", 0), cVar.a("vehicle", 0), cVar.a("route_buff"));
            }
        }
    }

    public static void e() {
        if (WNavigatorWrapper.getWNavigator().s()) {
            WNavigatorWrapper.getWNavigator().p();
        }
    }
}
