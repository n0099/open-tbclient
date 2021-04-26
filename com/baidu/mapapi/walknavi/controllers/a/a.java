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
    public static IWTTSPlayer f7726b;

    /* renamed from: h  reason: collision with root package name */
    public static com.baidu.platform.comapi.wnplatform.m.c f7727h = new d();

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f7730d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f7731e;

    /* renamed from: f  reason: collision with root package name */
    public ArCameraView f7732f;

    /* renamed from: g  reason: collision with root package name */
    public WalkNaviModeSwitchListener f7733g;

    /* renamed from: c  reason: collision with root package name */
    public MapView f7729c = null;

    /* renamed from: a  reason: collision with root package name */
    public View f7728a = null;

    @TargetApi(11)
    private void c(Activity activity) {
        RelativeLayout relativeLayout = this.f7731e;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        com.baidu.platform.comapi.walknavi.b.a().G().d();
        com.baidu.platform.comapi.walknavi.b.a().G().a(false);
        com.baidu.platform.comapi.walknavi.b.a().G().f();
        this.f7729c.getMap().setMapStatus(MapStatusUpdateFactory.zoomTo(1096.0f));
        this.f7729c.getMap().setPixelFormatTransparent(true);
        this.f7729c.getMap().hideSDKLayer();
        this.f7729c.setBackgroundColor(0);
        this.f7729c.setAlpha(1.0f);
        this.f7733g.onSuccess();
    }

    public static void f() {
        if (WNavigatorWrapper.getWNavigator().x()) {
            WNavigatorWrapper.getWNavigator().v();
        }
    }

    private void h() {
        RelativeLayout relativeLayout = this.f7731e;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        ArCameraView arCameraView = this.f7732f;
        if (arCameraView != null) {
            arCameraView.pauseCamera();
        }
        MapView mapView = this.f7729c;
        if (mapView != null) {
            mapView.getMap().showSDKLayer();
            this.f7729c.getMap().setPixelFormatTransparent(false);
            com.baidu.platform.comapi.walknavi.b.a().G().e();
            com.baidu.platform.comapi.walknavi.b.a().G().a(true);
            com.baidu.platform.comapi.walknavi.b.a().G().g();
            this.f7729c.getMap().setMapStatus(MapStatusUpdateFactory.zoomTo(19.0f));
            this.f7729c.getMap().setBaiduHeatMapEnabled(false);
            this.f7729c.getMap().setTrafficEnabled(false);
        }
    }

    private void i() {
        ArCameraView arCameraView;
        RelativeLayout relativeLayout = this.f7731e;
        if (relativeLayout == null || (arCameraView = this.f7732f) == null) {
            return;
        }
        relativeLayout.removeView(arCameraView);
        this.f7732f.releaseCamera();
        this.f7732f = null;
        this.f7731e = null;
    }

    public void a(Activity activity, IWEngineInitListener iWEngineInitListener) {
        if (iWEngineInitListener != null) {
            if (this.f7729c == null) {
                this.f7729c = new MapView(activity);
            }
            com.baidu.platform.comapi.walknavi.b.a().a(activity, this.f7729c);
            com.baidu.platform.comapi.walknavi.b.a().a(activity, WNaviBaiduMap.getId(), new b(this, iWEngineInitListener));
            return;
        }
        throw new com.baidu.mapapi.walknavi.controllers.a("engine init listener cannot be null");
    }

    public ArrayList<BaseNpcModel> b() {
        return com.baidu.platform.comapi.walknavi.b.a().o();
    }

    public void d() {
        MapView mapView = this.f7729c;
        if (mapView != null) {
            mapView.onResume();
        }
    }

    public void e() {
        if (f7726b != null) {
            f7726b = null;
        }
        MapView mapView = this.f7729c;
        if (mapView != null) {
            mapView.getMap().clear();
            this.f7729c.onDestroy();
            this.f7729c = null;
        }
        h();
        i();
        FrameLayout frameLayout = this.f7730d;
        if (frameLayout != null && frameLayout.getParent() != null) {
            ((ViewGroup) this.f7730d.getParent()).removeAllViews();
        }
        this.f7730d = null;
    }

    public void b(Activity activity) {
        ArCameraView arCameraView = this.f7732f;
        if (arCameraView == null) {
            ArCameraView arCameraView2 = new ArCameraView(activity);
            this.f7732f = arCameraView2;
            this.f7731e.addView(arCameraView2);
        } else {
            arCameraView.resumeCamera();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.f7729c.setZOrderMediaOverlay(true);
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
        int i2 = length + 1;
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        int[] iArr3 = new int[i2];
        int[] iArr4 = new int[i2];
        iArr[0] = cVar.a("start_x", 0);
        iArr2[0] = cVar.a("start_y", 0);
        iArr3[0] = cVar.a("start_cityid", 0);
        iArr4[0] = -1;
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + 1;
            iArr[i4] = cVar.b("end_x")[i3];
            i3 = i4;
        }
        int i5 = 0;
        while (i5 < length) {
            int i6 = i5 + 1;
            iArr2[i6] = cVar.b("end_y")[i5];
            i5 = i6;
        }
        int i7 = 0;
        while (i7 < length) {
            int i8 = i7 + 1;
            iArr3[i8] = cVar.b("end_cityid")[i7];
            i7 = i8;
        }
        int i9 = 0;
        while (i9 < length) {
            i9++;
            iArr4[i9] = i9;
        }
        if (WNavigatorWrapper.getWNavigator().C().a(iArr, iArr2, iArr3, iArr4)) {
            WNavigatorWrapper.getWNavigator().a(f7727h);
            WNavigatorWrapper.getWNavigator().a(new c(this, iWRoutePlanListener));
            f();
            WNavigatorWrapper.getWNavigator().C().a(13, cVar.a("route_data_mode", 0), cVar.a("vehicle", 0), cVar.a("route_buff"));
        }
    }

    public void a(Activity activity, IWRouteGuidanceListener iWRouteGuidanceListener) {
        WNavigatorWrapper.getWNavigator().a(activity, iWRouteGuidanceListener);
    }

    public void a(IWTTSPlayer iWTTSPlayer) {
        f7726b = iWTTSPlayer;
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
        MapView mapView = this.f7729c;
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
        FrameLayout frameLayout = this.f7730d;
        if (frameLayout != null) {
            return frameLayout;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        FrameLayout frameLayout2 = new FrameLayout(activity);
        this.f7730d = frameLayout2;
        frameLayout2.setLayoutParams(layoutParams);
        this.f7728a = com.baidu.platform.comapi.walknavi.b.a().b(activity);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        RelativeLayout relativeLayout = new RelativeLayout(activity);
        this.f7731e = relativeLayout;
        relativeLayout.setLayoutParams(layoutParams2);
        this.f7730d.addView(this.f7729c);
        this.f7730d.addView(this.f7731e);
        this.f7730d.addView(this.f7728a);
        return this.f7730d;
    }

    public void a(Activity activity, int i2, WalkNaviModeSwitchListener walkNaviModeSwitchListener) {
        this.f7733g = walkNaviModeSwitchListener;
        if (i2 == 1) {
            h();
            this.f7733g.onSuccess();
        } else if (i2 == 2) {
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
