package com.baidu.mapapi.bikenavi.controllers.a;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.mapapi.bikenavi.adapter.IBEngineInitListener;
import com.baidu.mapapi.bikenavi.adapter.IBRouteGuidanceListener;
import com.baidu.mapapi.bikenavi.adapter.IBRoutePlanListener;
import com.baidu.mapapi.bikenavi.adapter.IBTTSPlayer;
import com.baidu.mapapi.bikenavi.controllers.BNavigatorWrapper;
import com.baidu.mapapi.bikenavi.controllers.UnsupportedBikeNaviException;
import com.baidu.mapapi.map.MapView;
import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;
import com.baidu.platform.comapi.wnplatform.walkmap.WNaviBaiduMap;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static IBTTSPlayer f6743b;

    /* renamed from: d  reason: collision with root package name */
    public static com.baidu.platform.comapi.wnplatform.m.c f6744d = new d();

    /* renamed from: a  reason: collision with root package name */
    public FrameLayout f6745a;

    /* renamed from: c  reason: collision with root package name */
    public MapView f6746c = null;

    public static void e() {
        if (BNavigatorWrapper.getWNavigator().x()) {
            BNavigatorWrapper.getWNavigator().v();
        }
    }

    public void a(Activity activity, IBEngineInitListener iBEngineInitListener) {
        if (iBEngineInitListener != null) {
            if (this.f6746c == null) {
                this.f6746c = new MapView(activity);
            }
            com.baidu.platform.comapi.walknavi.b.a().a(activity, this.f6746c);
            long id = WNaviBaiduMap.getId();
            com.baidu.platform.comapi.wnplatform.d.a.b("mapHandle", "mapHandle " + id);
            com.baidu.platform.comapi.walknavi.b.a().a(activity, id, new b(this, iBEngineInitListener));
            return;
        }
        throw new UnsupportedBikeNaviException("engine init listener cannot be null");
    }

    public void b() {
        MapView mapView = this.f6746c;
        if (mapView != null) {
            mapView.onPause();
        }
    }

    public void c() {
        MapView mapView = this.f6746c;
        if (mapView != null) {
            mapView.onResume();
        }
    }

    public void d() {
        if (f6743b != null) {
            f6743b = null;
        }
        MapView mapView = this.f6746c;
        if (mapView != null) {
            mapView.getMap().clear();
            this.f6746c.onDestroy();
        }
        this.f6746c = null;
        FrameLayout frameLayout = this.f6745a;
        if (frameLayout != null && frameLayout.getParent() != null) {
            ((ViewGroup) this.f6745a.getParent()).removeAllViews();
        }
        this.f6745a = null;
    }

    public MapView f() {
        return this.f6746c;
    }

    private void b(com.baidu.platform.comapi.walknavi.e.a aVar, IBRoutePlanListener iBRoutePlanListener) {
        BNavigatorWrapper.getWNavigator().a(1, 1);
        if (aVar.b("end_x") == null) {
            return;
        }
        int length = aVar.b("end_x").length;
        int i = length + 1;
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        int[] iArr3 = new int[i];
        int[] iArr4 = new int[i];
        iArr[0] = aVar.a("start_x", 0);
        iArr2[0] = aVar.a("start_y", 0);
        iArr3[0] = aVar.a("start_cityid", 0);
        iArr4[0] = -1;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            iArr[i3] = aVar.b("end_x")[i2];
            i2 = i3;
        }
        int i4 = 0;
        while (i4 < length) {
            int i5 = i4 + 1;
            iArr2[i5] = aVar.b("end_y")[i4];
            i4 = i5;
        }
        int i6 = 0;
        while (i6 < length) {
            int i7 = i6 + 1;
            iArr3[i7] = aVar.b("end_cityid")[i6];
            i6 = i7;
        }
        int i8 = 0;
        while (i8 < length) {
            i8++;
            iArr4[i8] = i8;
        }
        if (BNavigatorWrapper.getWNavigator().C().a(iArr, iArr2, iArr3, iArr4)) {
            BNavigatorWrapper.getWNavigator().a(f6744d);
            BNavigatorWrapper.getWNavigator().a(new c(this, iBRoutePlanListener));
            e();
            BNavigatorWrapper.getWNavigator().C().a(14, aVar.a("route_data_mode", 0), aVar.a("vehicle", 0), aVar.a("route_buff"));
        }
    }

    public boolean a() {
        return BNavigatorWrapper.getWNavigator().j();
    }

    public void a(com.baidu.platform.comapi.walknavi.e.a aVar, IBRoutePlanListener iBRoutePlanListener) {
        b(aVar, iBRoutePlanListener);
    }

    public void a(Activity activity, IBRouteGuidanceListener iBRouteGuidanceListener) {
        BNavigatorWrapper.getWNavigator().a(activity, iBRouteGuidanceListener);
    }

    public void a(IBTTSPlayer iBTTSPlayer) {
        f6743b = iBTTSPlayer;
    }

    public void a(WLocData wLocData) {
        com.baidu.platform.comapi.walknavi.b.a().a(wLocData);
    }

    public View a(Activity activity) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        FrameLayout frameLayout = new FrameLayout(activity);
        this.f6745a = frameLayout;
        frameLayout.setLayoutParams(layoutParams);
        View b2 = BNavigatorWrapper.getWNavigator().b(activity);
        this.f6745a.addView(this.f6746c);
        this.f6745a.addView(b2);
        return this.f6745a;
    }

    public void a(String str) {
        BNavigatorWrapper.getWNavigator().Q().a(str);
    }
}
