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
    public static IBTTSPlayer f7014b;

    /* renamed from: d  reason: collision with root package name */
    public static com.baidu.platform.comapi.wnplatform.m.c f7015d = new d();

    /* renamed from: a  reason: collision with root package name */
    public FrameLayout f7016a;

    /* renamed from: c  reason: collision with root package name */
    public MapView f7017c = null;

    public static void e() {
        if (BNavigatorWrapper.getWNavigator().x()) {
            BNavigatorWrapper.getWNavigator().v();
        }
    }

    public void a(Activity activity, IBEngineInitListener iBEngineInitListener) {
        if (iBEngineInitListener != null) {
            if (this.f7017c == null) {
                this.f7017c = new MapView(activity);
            }
            com.baidu.platform.comapi.walknavi.b.a().a(activity, this.f7017c);
            long id = WNaviBaiduMap.getId();
            com.baidu.platform.comapi.wnplatform.d.a.b("mapHandle", "mapHandle " + id);
            com.baidu.platform.comapi.walknavi.b.a().a(activity, id, new b(this, iBEngineInitListener));
            return;
        }
        throw new UnsupportedBikeNaviException("engine init listener cannot be null");
    }

    public void b() {
        MapView mapView = this.f7017c;
        if (mapView != null) {
            mapView.onPause();
        }
    }

    public void c() {
        MapView mapView = this.f7017c;
        if (mapView != null) {
            mapView.onResume();
        }
    }

    public void d() {
        if (f7014b != null) {
            f7014b = null;
        }
        MapView mapView = this.f7017c;
        if (mapView != null) {
            mapView.getMap().clear();
            this.f7017c.onDestroy();
        }
        this.f7017c = null;
        FrameLayout frameLayout = this.f7016a;
        if (frameLayout != null && frameLayout.getParent() != null) {
            ((ViewGroup) this.f7016a.getParent()).removeAllViews();
        }
        this.f7016a = null;
    }

    public MapView f() {
        return this.f7017c;
    }

    private void b(com.baidu.platform.comapi.walknavi.e.a aVar, IBRoutePlanListener iBRoutePlanListener) {
        BNavigatorWrapper.getWNavigator().a(1, 1);
        if (aVar.b("end_x") == null) {
            return;
        }
        int length = aVar.b("end_x").length;
        int i2 = length + 1;
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        int[] iArr3 = new int[i2];
        int[] iArr4 = new int[i2];
        iArr[0] = aVar.a("start_x", 0);
        iArr2[0] = aVar.a("start_y", 0);
        iArr3[0] = aVar.a("start_cityid", 0);
        iArr4[0] = -1;
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + 1;
            iArr[i4] = aVar.b("end_x")[i3];
            i3 = i4;
        }
        int i5 = 0;
        while (i5 < length) {
            int i6 = i5 + 1;
            iArr2[i6] = aVar.b("end_y")[i5];
            i5 = i6;
        }
        int i7 = 0;
        while (i7 < length) {
            int i8 = i7 + 1;
            iArr3[i8] = aVar.b("end_cityid")[i7];
            i7 = i8;
        }
        int i9 = 0;
        while (i9 < length) {
            i9++;
            iArr4[i9] = i9;
        }
        if (BNavigatorWrapper.getWNavigator().C().a(iArr, iArr2, iArr3, iArr4)) {
            BNavigatorWrapper.getWNavigator().a(f7015d);
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
        f7014b = iBTTSPlayer;
    }

    public void a(WLocData wLocData) {
        com.baidu.platform.comapi.walknavi.b.a().a(wLocData);
    }

    public View a(Activity activity) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        FrameLayout frameLayout = new FrameLayout(activity);
        this.f7016a = frameLayout;
        frameLayout.setLayoutParams(layoutParams);
        View b2 = BNavigatorWrapper.getWNavigator().b(activity);
        this.f7016a.addView(this.f7017c);
        this.f7016a.addView(b2);
        return this.f7016a;
    }

    public void a(String str) {
        BNavigatorWrapper.getWNavigator().Q().a(str);
    }
}
