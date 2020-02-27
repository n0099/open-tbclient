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
/* loaded from: classes8.dex */
public class a {
    private static IBTTSPlayer b;
    private static com.baidu.platform.comapi.wnplatform.m.c d = new d();
    FrameLayout a;
    private MapView c = null;

    public void a(Activity activity, IBEngineInitListener iBEngineInitListener) {
        if (iBEngineInitListener == null) {
            throw new UnsupportedBikeNaviException("engine init listener cannot be null");
        }
        if (this.c == null) {
            this.c = new MapView(activity);
        }
        com.baidu.platform.comapi.walknavi.b.a().a(activity, this.c);
        long id = WNaviBaiduMap.getId();
        com.baidu.platform.comapi.wnplatform.d.a.b("mapHandle", "mapHandle " + id);
        com.baidu.platform.comapi.walknavi.b.a().a(activity, id, new b(this, iBEngineInitListener));
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
        b = iBTTSPlayer;
    }

    public void a(WLocData wLocData) {
        com.baidu.platform.comapi.walknavi.b.a().a(wLocData);
    }

    public View a(Activity activity) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.a = new FrameLayout(activity);
        this.a.setLayoutParams(layoutParams);
        View b2 = BNavigatorWrapper.getWNavigator().b(activity);
        this.a.addView(this.c);
        this.a.addView(b2);
        return this.a;
    }

    public void b() {
        if (this.c != null) {
            this.c.onPause();
        }
    }

    public void c() {
        if (this.c != null) {
            this.c.onResume();
        }
    }

    public void d() {
        if (b != null) {
            b = null;
        }
        if (this.c != null) {
            this.c.getMap().clear();
            this.c.onDestroy();
        }
        this.c = null;
        if (this.a != null && this.a.getParent() != null) {
            ((ViewGroup) this.a.getParent()).removeAllViews();
        }
        this.a = null;
    }

    private void b(com.baidu.platform.comapi.walknavi.e.a aVar, IBRoutePlanListener iBRoutePlanListener) {
        BNavigatorWrapper.getWNavigator().a(1, 1);
        if (aVar.b("end_x") != null) {
            int length = aVar.b("end_x").length;
            int[] iArr = new int[length + 1];
            int[] iArr2 = new int[length + 1];
            int[] iArr3 = new int[length + 1];
            int[] iArr4 = new int[length + 1];
            iArr[0] = aVar.a("start_x", 0);
            iArr2[0] = aVar.a("start_y", 0);
            iArr3[0] = aVar.a("start_cityid", 0);
            iArr4[0] = -1;
            for (int i = 0; i < length; i++) {
                iArr[i + 1] = aVar.b("end_x")[i];
            }
            for (int i2 = 0; i2 < length; i2++) {
                iArr2[i2 + 1] = aVar.b("end_y")[i2];
            }
            for (int i3 = 0; i3 < length; i3++) {
                iArr3[i3 + 1] = aVar.b("end_cityid")[i3];
            }
            for (int i4 = 0; i4 < length; i4++) {
                iArr4[i4 + 1] = i4 + 1;
            }
            if (BNavigatorWrapper.getWNavigator().C().a(iArr, iArr2, iArr3, iArr4)) {
                BNavigatorWrapper.getWNavigator().a(d);
                BNavigatorWrapper.getWNavigator().a(new c(this, iBRoutePlanListener));
                e();
                BNavigatorWrapper.getWNavigator().C().a(14, aVar.a("route_data_mode", 0), aVar.a("vehicle", 0), aVar.a("route_buff"));
            }
        }
    }

    public static void e() {
        if (BNavigatorWrapper.getWNavigator().x()) {
            BNavigatorWrapper.getWNavigator().v();
        }
    }

    public void a(String str) {
        BNavigatorWrapper.getWNavigator().Q().a(str);
    }

    public MapView f() {
        return this.c;
    }
}
