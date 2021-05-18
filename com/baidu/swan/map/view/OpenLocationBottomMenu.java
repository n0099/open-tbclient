package com.baidu.swan.map.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.route.BikingRouteResult;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.IndoorRouteResult;
import com.baidu.mapapi.search.route.MassTransitRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRouteResult;
import com.baidu.swan.map.item.OpenLocationMenuItem;
import d.a.i0.a.k;
import d.a.i0.a.v2.n0;
import d.a.i0.j.g;
import d.a.i0.j.p.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class OpenLocationBottomMenu extends LinearLayout implements OpenLocationMenuItem.b {
    public static final boolean q = k.f43025a;
    public static final List<String> r = Arrays.asList(BaiduMap.f6890e, "GaodeMap");
    public static d.a.i0.j.q.a s;
    public static boolean t;

    /* renamed from: e  reason: collision with root package name */
    public Context f11885e;

    /* renamed from: f  reason: collision with root package name */
    public OpenLocationMenuItem f11886f;

    /* renamed from: g  reason: collision with root package name */
    public OpenLocationMenuItem f11887g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout.LayoutParams f11888h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.i0.j.m.a f11889i;
    public LatLng j;
    public OnGetRoutePlanResultListener k;
    public LatLng l;
    public boolean m;
    public String n;
    public String o;
    public Map<OpenLocationMenuItem.MenuItemType, c> p;

    /* loaded from: classes3.dex */
    public class a implements OnGetRoutePlanResultListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.j.r.a f11890a;

        public a(d.a.i0.j.r.a aVar) {
            this.f11890a = aVar;
        }

        @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
        public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {
        }

        @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
        public void onGetDrivingRouteResult(DrivingRouteResult drivingRouteResult) {
            SearchResult.ERRORNO errorno;
            if (OpenLocationBottomMenu.q) {
                Log.e("OpenLocationBottomMenu", "onGetDrivingRouteResult thread  " + Thread.currentThread().getName());
            }
            this.f11890a.a();
            if (drivingRouteResult == null || (errorno = drivingRouteResult.error) != SearchResult.ERRORNO.NO_ERROR || errorno == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
                boolean unused = OpenLocationBottomMenu.t = false;
                if (OpenLocationBottomMenu.q) {
                    if (drivingRouteResult == null) {
                        Log.e("OpenLocationBottomMenu", "onGetDrivingRouteResult error, result is null ");
                        return;
                    }
                    Log.e("OpenLocationBottomMenu", "onGetDrivingRouteResult error, error code = " + drivingRouteResult.error);
                    return;
                }
                return;
            }
            BaiduMap W2 = OpenLocationBottomMenu.this.f11889i.W2();
            if (W2 == null) {
                boolean unused2 = OpenLocationBottomMenu.t = false;
                if (OpenLocationBottomMenu.q) {
                    Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                }
            } else if (OpenLocationBottomMenu.t) {
                d.a.i0.j.q.a unused3 = OpenLocationBottomMenu.s = new d.a.i0.j.q.b(W2);
                W2.setOnMarkerClickListener(OpenLocationBottomMenu.s);
                OpenLocationBottomMenu.s.h(drivingRouteResult.getRouteLines().get(0));
                OpenLocationBottomMenu.s.a();
                OpenLocationBottomMenu.s.d();
                if (OpenLocationBottomMenu.q) {
                    Log.e("OpenLocationBottomMenu", "showPath success");
                }
                OpenLocationBottomMenu.this.f11889i.e3(true);
            }
        }

        @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
        public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {
        }

        @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
        public void onGetMassTransitRouteResult(MassTransitRouteResult massTransitRouteResult) {
        }

        @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
        public void onGetTransitRouteResult(TransitRouteResult transitRouteResult) {
        }

        @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
        public void onGetWalkingRouteResult(WalkingRouteResult walkingRouteResult) {
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f11892a;

        static {
            int[] iArr = new int[OpenLocationMenuItem.MenuItemType.values().length];
            f11892a = iArr;
            try {
                iArr[OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11892a[OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public OpenLocationBottomMenu(Context context) {
        super(context);
        this.m = false;
        j(context);
    }

    private Map<OpenLocationMenuItem.MenuItemType, c> getMapApps() {
        ArrayList<String> arrayList = new ArrayList(r);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        d.a.i0.j.m.a aVar = this.f11889i;
        if (aVar != null) {
            List<String> V2 = aVar.V2();
            if (V2 != null) {
                V2.remove(BaiduMap.f6890e);
                arrayList.removeAll(V2);
            }
            for (String str : arrayList) {
                char c2 = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -1943115423) {
                    if (hashCode == -1647700090 && str.equals("GaodeMap")) {
                        c2 = 1;
                    }
                } else if (str.equals(BaiduMap.f6890e)) {
                    c2 = 0;
                }
                if (c2 == 0) {
                    linkedHashMap.put(OpenLocationMenuItem.MenuItemType.OPENLOCATION_BAIDU_MAP, new d.a.i0.j.p.a(this.f11885e));
                } else if (c2 == 1) {
                    linkedHashMap.put(OpenLocationMenuItem.MenuItemType.OPENLOCATION_GAODE_MAP, new d.a.i0.j.p.b(this.f11885e));
                }
            }
        }
        return linkedHashMap;
    }

    public static void l() {
        if (q) {
            Log.e("OpenLocationBottomMenu", "resetItemClickFlag");
        }
        t = false;
        s = null;
    }

    @Override // com.baidu.swan.map.item.OpenLocationMenuItem.b
    public void a(OpenLocationMenuItem openLocationMenuItem) {
        d.a.i0.j.m.a aVar = this.f11889i;
        if (aVar != null) {
            aVar.S2();
        }
        OpenLocationMenuItem.MenuItemType c2 = openLocationMenuItem.c();
        int i2 = b.f11892a[c2.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                k();
                c cVar = this.p.get(c2);
                if (cVar != null) {
                    cVar.d(this.f11885e, this.j, this.l, this.n, this.o);
                    return;
                }
                return;
            }
            return;
        }
        boolean z = !t;
        t = z;
        if (!z) {
            i();
        } else if (s == null) {
            m();
            if (q) {
                Log.e("OpenLocationBottomMenu", "use a new path");
            }
        } else {
            d.a.i0.j.m.a aVar2 = this.f11889i;
            if (aVar2 == null) {
                return;
            }
            h(aVar2.W2(), s);
            this.f11889i.e3(true);
            if (q) {
                Log.e("OpenLocationBottomMenu", "use a cache path");
            }
        }
    }

    public final void g() {
        String string;
        if (q) {
            Log.e("OpenLocationBottomMenu", "addMenuItem run");
        }
        if (!t) {
            string = this.f11885e.getString(g.openlocation_bottommenu_showpath);
        } else {
            string = this.f11885e.getString(g.openlocation_bottommenu_hidepath);
        }
        OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.f11885e, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
        this.f11886f = openLocationMenuItem;
        openLocationMenuItem.d(this);
        addView(this.f11886f.b());
        Map<OpenLocationMenuItem.MenuItemType, c> mapApps = getMapApps();
        this.p = mapApps;
        for (OpenLocationMenuItem.MenuItemType menuItemType : mapApps.keySet()) {
            c cVar = this.p.get(menuItemType);
            if (cVar.c(this.f11885e) || cVar.b()) {
                OpenLocationMenuItem openLocationMenuItem2 = new OpenLocationMenuItem(this.f11885e, cVar.a(), menuItemType);
                openLocationMenuItem2.d(this);
                if (!this.m) {
                    ((LinearLayout.LayoutParams) openLocationMenuItem2.b().getLayoutParams()).topMargin = n0.g(7.0f);
                    this.m = true;
                }
                addView(openLocationMenuItem2.b());
            }
        }
        Context context = this.f11885e;
        OpenLocationMenuItem openLocationMenuItem3 = new OpenLocationMenuItem(context, context.getString(g.map_location_cancel), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
        this.f11887g = openLocationMenuItem3;
        openLocationMenuItem3.d(this);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f11887g.b().getLayoutParams();
        this.f11888h = layoutParams;
        layoutParams.topMargin = n0.g(7.0f);
        addView(this.f11887g.b());
    }

    public final void h(BaiduMap baiduMap, d.a.i0.j.q.a aVar) {
        if (baiduMap == null || aVar == null) {
            return;
        }
        baiduMap.setOnMarkerClickListener(aVar);
        aVar.a();
        aVar.d();
    }

    public final void i() {
        d.a.i0.j.m.a aVar = this.f11889i;
        if (aVar != null && aVar.U2()) {
            d.a.i0.j.q.a aVar2 = s;
            if (aVar2 != null) {
                aVar2.c();
                if (q) {
                    Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan success");
                }
            }
            if (q) {
                Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan clicked");
            }
        }
    }

    public final void j(Context context) {
        this.f11885e = context;
        setOrientation(1);
    }

    public final void k() {
        if (this.f11889i == null) {
            return;
        }
        if (this.j == null) {
            if (q) {
                Log.e("OpenLocationBottomMenu", "getStartPosi again");
            }
            BDLocation T2 = this.f11889i.T2();
            if (T2 == null) {
                return;
            }
            this.j = new LatLng(T2.getLatitude(), T2.getLongitude());
            String addrStr = T2.getAddrStr();
            if (TextUtils.isEmpty(addrStr)) {
                addrStr = TextUtils.isEmpty(T2.getStreet()) ? "" : T2.getStreet();
            }
            this.n = addrStr;
        }
        if (this.l == null) {
            Bundle n = this.f11889i.n();
            this.l = new LatLng(n.getDouble("latitude"), n.getDouble("longitude"));
            String string = n.getString("name");
            this.o = TextUtils.isEmpty(string) ? "" : string;
        }
    }

    public final void m() {
        d.a.i0.j.m.a aVar = this.f11889i;
        if (aVar == null) {
            t = false;
            if (q) {
                Log.e("OpenLocationBottomMenu", "getFragment null");
                return;
            }
            return;
        }
        aVar.e3(false);
        d.a.i0.j.r.a b2 = d.a.i0.j.r.a.b();
        a aVar2 = new a(b2);
        this.k = aVar2;
        LatLng latLng = this.j;
        if (latLng == null) {
            t = false;
            if (q) {
                Log.e("OpenLocationBottomMenu", "getStartPosition null");
                return;
            }
            return;
        }
        b2.c(latLng, this.l, aVar2);
    }

    public void setFragment(d.a.i0.j.m.a aVar) {
        this.f11889i = aVar;
        k();
        g();
    }

    public OpenLocationBottomMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = false;
        j(context);
    }
}
