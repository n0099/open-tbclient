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
/* loaded from: classes8.dex */
public class a {
    private static IWTTSPlayer b;
    private static com.baidu.platform.comapi.wnplatform.m.c h = new d();
    private FrameLayout d;
    private RelativeLayout e;
    private ArCameraView f;
    private WalkNaviModeSwitchListener g;
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
        return WNavigatorWrapper.getWNavigator().j();
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
        return com.baidu.platform.comapi.walknavi.b.a().o();
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
        this.d.addView(this.c);
        this.d.addView(this.e);
        this.d.addView(this.a);
        return this.d;
    }

    public void a(Activity activity, int i, WalkNaviModeSwitchListener walkNaviModeSwitchListener) {
        this.g = walkNaviModeSwitchListener;
        if (i == 1) {
            h();
            this.g.onSuccess();
        } else if (i == 2) {
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
        if (this.f == null) {
            this.f = new ArCameraView(activity);
            this.e.addView(this.f);
        } else {
            this.f.resumeCamera();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.c.setZOrderMediaOverlay(true);
        }
        c(activity);
    }

    @TargetApi(11)
    private void c(Activity activity) {
        if (this.e != null) {
            this.e.setVisibility(0);
        }
        com.baidu.platform.comapi.walknavi.b.a().G().d();
        com.baidu.platform.comapi.walknavi.b.a().G().a(false);
        com.baidu.platform.comapi.walknavi.b.a().G().f();
        this.c.getMap().setMapStatus(MapStatusUpdateFactory.zoomTo(1096.0f));
        this.c.getMap().setPixelFormatTransparent(true);
        this.c.getMap().hideSDKLayer();
        this.c.setBackgroundColor(0);
        this.c.setAlpha(1.0f);
        this.g.onSuccess();
    }

    public void c() {
        if (this.c != null) {
            this.c.onPause();
        }
    }

    public void d() {
        if (this.c != null) {
            this.c.onResume();
        }
    }

    public void e() {
        if (b != null) {
            b = null;
        }
        if (this.c != null) {
            this.c.getMap().clear();
            this.c.onDestroy();
            this.c = null;
        }
        h();
        i();
        if (this.d != null && this.d.getParent() != null) {
            ((ViewGroup) this.d.getParent()).removeAllViews();
        }
        this.d = null;
    }

    private void h() {
        if (this.e != null) {
            this.e.setVisibility(8);
        }
        if (this.f != null) {
            this.f.pauseCamera();
        }
        if (this.c != null) {
            this.c.getMap().showSDKLayer();
            this.c.getMap().setPixelFormatTransparent(false);
            com.baidu.platform.comapi.walknavi.b.a().G().e();
            com.baidu.platform.comapi.walknavi.b.a().G().a(true);
            com.baidu.platform.comapi.walknavi.b.a().G().g();
            this.c.getMap().setMapStatus(MapStatusUpdateFactory.zoomTo(19.0f));
            this.c.getMap().setBaiduHeatMapEnabled(false);
            this.c.getMap().setTrafficEnabled(false);
        }
    }

    private void i() {
        if (this.e != null && this.f != null) {
            this.e.removeView(this.f);
            this.f.releaseCamera();
            this.f = null;
            this.e = null;
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
            if (WNavigatorWrapper.getWNavigator().C().a(iArr, iArr2, iArr3, iArr4)) {
                WNavigatorWrapper.getWNavigator().a(h);
                WNavigatorWrapper.getWNavigator().a(new c(this, iWRoutePlanListener));
                f();
                WNavigatorWrapper.getWNavigator().C().a(13, cVar.a("route_data_mode", 0), cVar.a("vehicle", 0), cVar.a("route_buff"));
            }
        }
    }

    public static void f() {
        if (WNavigatorWrapper.getWNavigator().x()) {
            WNavigatorWrapper.getWNavigator().v();
        }
    }
}
