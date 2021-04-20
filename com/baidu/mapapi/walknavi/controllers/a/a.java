package com.baidu.mapapi.walknavi.controllers.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.walknavi.adapter.IWEngineInitListener;
import com.baidu.mapapi.walknavi.adapter.IWMoreNPCModelOnClickListener;
import com.baidu.mapapi.walknavi.adapter.IWNPCLoadAndInitListener;
import com.baidu.mapapi.walknavi.adapter.IWRouteGuidanceListener;
import com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener;
import com.baidu.mapapi.walknavi.adapter.IWTTSPlayer;
import com.baidu.mapapi.walknavi.controllers.WNavigatorWrapper;
import com.baidu.mapapi.walknavi.model.BaseNpcModel;
import com.baidu.mapapi.walknavi.model.WalkNaviDisplayOption;
import com.baidu.platform.comapi.walknavi.WalkNaviModeSwitchListener;
import com.baidu.platform.comapi.walknavi.widget.ArCameraView;
import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;
import com.baidu.platform.comapi.wnplatform.walkmap.WNaviBaiduMap;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static IWTTSPlayer f7459b;

    /* renamed from: h  reason: collision with root package name */
    public static com.baidu.platform.comapi.wnplatform.m.c f7460h = new d();

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f7463d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f7464e;

    /* renamed from: f  reason: collision with root package name */
    public ArCameraView f7465f;

    /* renamed from: g  reason: collision with root package name */
    public WalkNaviModeSwitchListener f7466g;

    /* renamed from: c  reason: collision with root package name */
    public MapView f7462c = null;

    /* renamed from: a  reason: collision with root package name */
    public View f7461a = null;

    @TargetApi(11)
    private void c(Activity activity) {
        RelativeLayout relativeLayout = this.f7464e;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        com.baidu.platform.comapi.walknavi.b.a().G().d();
        com.baidu.platform.comapi.walknavi.b.a().G().a(false);
        com.baidu.platform.comapi.walknavi.b.a().G().f();
        this.f7462c.getMap().setMapStatus(MapStatusUpdateFactory.zoomTo(1096.0f));
        this.f7462c.getMap().setPixelFormatTransparent(true);
        this.f7462c.getMap().hideSDKLayer();
        this.f7462c.setBackgroundColor(0);
        this.f7462c.setAlpha(1.0f);
        this.f7466g.onSuccess();
    }

    public static void f() {
        if (WNavigatorWrapper.getWNavigator().x()) {
            WNavigatorWrapper.getWNavigator().v();
        }
    }

    private void h() {
        RelativeLayout relativeLayout = this.f7464e;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        ArCameraView arCameraView = this.f7465f;
        if (arCameraView != null) {
            arCameraView.pauseCamera();
        }
        MapView mapView = this.f7462c;
        if (mapView != null) {
            mapView.getMap().showSDKLayer();
            this.f7462c.getMap().setPixelFormatTransparent(false);
            com.baidu.platform.comapi.walknavi.b.a().G().e();
            com.baidu.platform.comapi.walknavi.b.a().G().a(true);
            com.baidu.platform.comapi.walknavi.b.a().G().g();
            this.f7462c.getMap().setMapStatus(MapStatusUpdateFactory.zoomTo(19.0f));
            this.f7462c.getMap().setBaiduHeatMapEnabled(false);
            this.f7462c.getMap().setTrafficEnabled(false);
        }
    }

    private void i() {
        ArCameraView arCameraView;
        RelativeLayout relativeLayout = this.f7464e;
        if (relativeLayout == null || (arCameraView = this.f7465f) == null) {
            return;
        }
        relativeLayout.removeView(arCameraView);
        this.f7465f.releaseCamera();
        this.f7465f = null;
        this.f7464e = null;
    }

    public void a(Activity activity, IWEngineInitListener iWEngineInitListener) {
        if (iWEngineInitListener != null) {
            if (this.f7462c == null) {
                this.f7462c = new MapView(activity);
            }
            com.baidu.platform.comapi.walknavi.b.a().a(activity, this.f7462c);
            com.baidu.platform.comapi.walknavi.b.a().a(activity, WNaviBaiduMap.getId(), new b(this, iWEngineInitListener));
            return;
        }
        throw new com.baidu.mapapi.walknavi.controllers.a("engine init listener cannot be null");
    }

    public ArrayList<BaseNpcModel> b() {
        return com.baidu.platform.comapi.walknavi.b.a().o();
    }

    public void d() {
        MapView mapView = this.f7462c;
        if (mapView != null) {
            mapView.onResume();
        }
    }

    public void e() {
        if (f7459b != null) {
            f7459b = null;
        }
        MapView mapView = this.f7462c;
        if (mapView != null) {
            mapView.getMap().clear();
            this.f7462c.onDestroy();
            this.f7462c = null;
        }
        h();
        i();
        FrameLayout frameLayout = this.f7463d;
        if (frameLayout != null && frameLayout.getParent() != null) {
            ((ViewGroup) this.f7463d.getParent()).removeAllViews();
        }
        this.f7463d = null;
    }

    public void b(Activity activity) {
        ArCameraView arCameraView = this.f7465f;
        if (arCameraView == null) {
            ArCameraView arCameraView2 = new ArCameraView(activity);
            this.f7465f = arCameraView2;
            this.f7464e.addView(arCameraView2);
        } else {
            arCameraView.resumeCamera();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.f7462c.setZOrderMediaOverlay(true);
        }
        c(activity);
    }

    public boolean a() {
        return WNavigatorWrapper.getWNavigator().j();
    }

    public void a(com.baidu.platform.comapi.walknavi.e.c cVar, IWRoutePlanListener iWRoutePlanListener) {
        b(cVar, iWRoutePlanListener);
    }

    private void b(com.baidu.platform.comapi.walknavi.e.c cVar, IWRoutePlanListener iWRoutePlanListener) {
        WNavigatorWrapper.getWNavigator().a(0, 0);
        if (cVar.b("end_x") == null) {
            return;
        }
        int length = cVar.b("end_x").length;
        int i = length + 1;
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        int[] iArr3 = new int[i];
        int[] iArr4 = new int[i];
        iArr[0] = cVar.a("start_x", 0);
        iArr2[0] = cVar.a("start_y", 0);
        iArr3[0] = cVar.a("start_cityid", 0);
        iArr4[0] = -1;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            iArr[i3] = cVar.b("end_x")[i2];
            i2 = i3;
        }
        int i4 = 0;
        while (i4 < length) {
            int i5 = i4 + 1;
            iArr2[i5] = cVar.b("end_y")[i4];
            i4 = i5;
        }
        int i6 = 0;
        while (i6 < length) {
            int i7 = i6 + 1;
            iArr3[i7] = cVar.b("end_cityid")[i6];
            i6 = i7;
        }
        int i8 = 0;
        while (i8 < length) {
            i8++;
            iArr4[i8] = i8;
        }
        if (WNavigatorWrapper.getWNavigator().C().a(iArr, iArr2, iArr3, iArr4)) {
            WNavigatorWrapper.getWNavigator().a(f7460h);
            WNavigatorWrapper.getWNavigator().a(new c(this, iWRoutePlanListener));
            f();
            WNavigatorWrapper.getWNavigator().C().a(13, cVar.a("route_data_mode", 0), cVar.a("vehicle", 0), cVar.a("route_buff"));
        }
    }

    public void a(Activity activity, IWRouteGuidanceListener iWRouteGuidanceListener) {
        WNavigatorWrapper.getWNavigator().a(activity, iWRouteGuidanceListener);
    }

    public void a(IWTTSPlayer iWTTSPlayer) {
        f7459b = iWTTSPlayer;
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

    public void c() {
        MapView mapView = this.f7462c;
        if (mapView != null) {
            mapView.onPause();
        }
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
        FrameLayout frameLayout = this.f7463d;
        if (frameLayout != null) {
            return frameLayout;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        FrameLayout frameLayout2 = new FrameLayout(activity);
        this.f7463d = frameLayout2;
        frameLayout2.setLayoutParams(layoutParams);
        this.f7461a = com.baidu.platform.comapi.walknavi.b.a().b(activity);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        RelativeLayout relativeLayout = new RelativeLayout(activity);
        this.f7464e = relativeLayout;
        relativeLayout.setLayoutParams(layoutParams2);
        this.f7463d.addView(this.f7462c);
        this.f7463d.addView(this.f7464e);
        this.f7463d.addView(this.f7461a);
        return this.f7463d;
    }

    public void a(Activity activity, int i, WalkNaviModeSwitchListener walkNaviModeSwitchListener) {
        this.f7466g = walkNaviModeSwitchListener;
        if (i == 1) {
            h();
            this.f7466g.onSuccess();
        } else if (i == 2) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (activity.checkSelfPermission(PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
                    activity.requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 3001);
                    return;
                } else {
                    b(activity);
                    return;
                }
            }
            b(activity);
        }
    }
}
