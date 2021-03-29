package com.baidu.swan.impl.map.view;

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
import com.baidu.swan.impl.map.item.OpenLocationMenuItem;
import com.baidu.tieba.R;
import d.b.g0.a.i2.h0;
import d.b.g0.a.k;
import d.b.g0.h.a.k.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class OpenLocationBottomMenu extends LinearLayout implements OpenLocationMenuItem.b {
    public static final boolean q = k.f45051a;
    public static final List<String> r = Arrays.asList(BaiduMap.f6807e, "GaodeMap");
    public static d.b.g0.h.a.l.a s;
    public static boolean t;

    /* renamed from: e  reason: collision with root package name */
    public Context f12975e;

    /* renamed from: f  reason: collision with root package name */
    public OpenLocationMenuItem f12976f;

    /* renamed from: g  reason: collision with root package name */
    public OpenLocationMenuItem f12977g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout.LayoutParams f12978h;
    public d.b.g0.h.a.h.a i;
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
        public final /* synthetic */ d.b.g0.h.a.m.a f12979a;

        public a(d.b.g0.h.a.m.a aVar) {
            this.f12979a = aVar;
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
            this.f12979a.a();
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
            BaiduMap Q2 = OpenLocationBottomMenu.this.i.Q2();
            if (Q2 == null) {
                boolean unused2 = OpenLocationBottomMenu.t = false;
                if (OpenLocationBottomMenu.q) {
                    Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                }
            } else if (OpenLocationBottomMenu.t) {
                d.b.g0.h.a.l.a unused3 = OpenLocationBottomMenu.s = new d.b.g0.h.a.l.b(Q2);
                Q2.setOnMarkerClickListener(OpenLocationBottomMenu.s);
                OpenLocationBottomMenu.s.h(drivingRouteResult.getRouteLines().get(0));
                OpenLocationBottomMenu.s.a();
                OpenLocationBottomMenu.s.d();
                if (OpenLocationBottomMenu.q) {
                    Log.e("OpenLocationBottomMenu", "showPath success");
                }
                OpenLocationBottomMenu.this.i.Y2(true);
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
        public static final /* synthetic */ int[] f12981a;

        static {
            int[] iArr = new int[OpenLocationMenuItem.MenuItemType.values().length];
            f12981a = iArr;
            try {
                iArr[OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12981a[OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL.ordinal()] = 2;
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
        d.b.g0.h.a.h.a aVar = this.i;
        if (aVar != null) {
            List<String> P2 = aVar.P2();
            if (P2 != null) {
                P2.remove(BaiduMap.f6807e);
                arrayList.removeAll(P2);
            }
            for (String str : arrayList) {
                char c2 = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -1943115423) {
                    if (hashCode == -1647700090 && str.equals("GaodeMap")) {
                        c2 = 1;
                    }
                } else if (str.equals(BaiduMap.f6807e)) {
                    c2 = 0;
                }
                if (c2 == 0) {
                    linkedHashMap.put(OpenLocationMenuItem.MenuItemType.OPENLOCATION_BAIDU_MAP, new d.b.g0.h.a.k.a(this.f12975e));
                } else if (c2 == 1) {
                    linkedHashMap.put(OpenLocationMenuItem.MenuItemType.OPENLOCATION_GAODE_MAP, new d.b.g0.h.a.k.b(this.f12975e));
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

    @Override // com.baidu.swan.impl.map.item.OpenLocationMenuItem.b
    public void a(OpenLocationMenuItem openLocationMenuItem) {
        d.b.g0.h.a.h.a aVar = this.i;
        if (aVar != null) {
            aVar.M2();
        }
        OpenLocationMenuItem.MenuItemType c2 = openLocationMenuItem.c();
        int i = b.f12981a[c2.ordinal()];
        if (i != 1) {
            if (i != 2) {
                k();
                c cVar = this.p.get(c2);
                if (cVar != null) {
                    cVar.d(this.f12975e, this.j, this.l, this.n, this.o);
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
            d.b.g0.h.a.h.a aVar2 = this.i;
            if (aVar2 == null) {
                return;
            }
            h(aVar2.Q2(), s);
            this.i.Y2(true);
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
            string = this.f12975e.getString(R.string.openlocation_bottommenu_showpath);
        } else {
            string = this.f12975e.getString(R.string.openlocation_bottommenu_hidepath);
        }
        OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.f12975e, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
        this.f12976f = openLocationMenuItem;
        openLocationMenuItem.d(this);
        addView(this.f12976f.b());
        Map<OpenLocationMenuItem.MenuItemType, c> mapApps = getMapApps();
        this.p = mapApps;
        for (OpenLocationMenuItem.MenuItemType menuItemType : mapApps.keySet()) {
            c cVar = this.p.get(menuItemType);
            if (cVar.c(this.f12975e) || cVar.b()) {
                OpenLocationMenuItem openLocationMenuItem2 = new OpenLocationMenuItem(this.f12975e, cVar.a(), menuItemType);
                openLocationMenuItem2.d(this);
                if (!this.m) {
                    ((LinearLayout.LayoutParams) openLocationMenuItem2.b().getLayoutParams()).topMargin = h0.f(7.0f);
                    this.m = true;
                }
                addView(openLocationMenuItem2.b());
            }
        }
        Context context = this.f12975e;
        OpenLocationMenuItem openLocationMenuItem3 = new OpenLocationMenuItem(context, context.getString(R.string.openlocation_bottommenu_cancel), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
        this.f12977g = openLocationMenuItem3;
        openLocationMenuItem3.d(this);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f12977g.b().getLayoutParams();
        this.f12978h = layoutParams;
        layoutParams.topMargin = h0.f(7.0f);
        addView(this.f12977g.b());
    }

    public final void h(BaiduMap baiduMap, d.b.g0.h.a.l.a aVar) {
        if (baiduMap == null || aVar == null) {
            return;
        }
        baiduMap.setOnMarkerClickListener(aVar);
        aVar.a();
        aVar.d();
    }

    public final void i() {
        d.b.g0.h.a.h.a aVar = this.i;
        if (aVar != null && aVar.O2()) {
            d.b.g0.h.a.l.a aVar2 = s;
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
        this.f12975e = context;
        setOrientation(1);
    }

    public final void k() {
        if (this.i == null) {
            return;
        }
        if (this.j == null) {
            if (q) {
                Log.e("OpenLocationBottomMenu", "getStartPosi again");
            }
            BDLocation N2 = this.i.N2();
            if (N2 == null) {
                return;
            }
            this.j = new LatLng(N2.getLatitude(), N2.getLongitude());
            String addrStr = N2.getAddrStr();
            if (TextUtils.isEmpty(addrStr)) {
                addrStr = TextUtils.isEmpty(N2.getStreet()) ? "" : N2.getStreet();
            }
            this.n = addrStr;
        }
        if (this.l == null) {
            Bundle j = this.i.j();
            this.l = new LatLng(j.getDouble("latitude"), j.getDouble("longitude"));
            String string = j.getString("name");
            this.o = TextUtils.isEmpty(string) ? "" : string;
        }
    }

    public final void m() {
        d.b.g0.h.a.h.a aVar = this.i;
        if (aVar == null) {
            t = false;
            if (q) {
                Log.e("OpenLocationBottomMenu", "getFragment null");
                return;
            }
            return;
        }
        aVar.Y2(false);
        d.b.g0.h.a.m.a b2 = d.b.g0.h.a.m.a.b();
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

    public void setFragment(d.b.g0.h.a.h.a aVar) {
        this.i = aVar;
        k();
        g();
    }

    public OpenLocationBottomMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = false;
        j(context);
    }
}
