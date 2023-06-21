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
import com.baidu.tieba.R;
import com.baidu.tieba.gh4;
import com.baidu.tieba.js1;
import com.baidu.tieba.qp3;
import com.baidu.tieba.rh4;
import com.baidu.tieba.sh4;
import com.baidu.tieba.th4;
import com.baidu.tieba.uh4;
import com.baidu.tieba.vh4;
import com.baidu.tieba.xh4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class OpenLocationBottomMenu extends LinearLayout implements OpenLocationMenuItem.b {
    public static final boolean m = js1.a;
    public static final List<String> n = Arrays.asList(BaiduMap.e, "GaodeMap");
    public static uh4 o;
    public static boolean p;
    public Context a;
    public OpenLocationMenuItem b;
    public OpenLocationMenuItem c;
    public LinearLayout.LayoutParams d;
    public gh4 e;
    public LatLng f;
    public OnGetRoutePlanResultListener g;
    public LatLng h;
    public boolean i;
    public String j;
    public String k;
    public Map<OpenLocationMenuItem.MenuItemType, th4> l;

    /* loaded from: classes4.dex */
    public class a implements OnGetRoutePlanResultListener {
        public final /* synthetic */ xh4 a;

        @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
        public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {
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

        public a(xh4 xh4Var) {
            this.a = xh4Var;
        }

        @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
        public void onGetDrivingRouteResult(DrivingRouteResult drivingRouteResult) {
            SearchResult.ERRORNO errorno;
            if (OpenLocationBottomMenu.m) {
                Log.e("OpenLocationBottomMenu", "onGetDrivingRouteResult thread  " + Thread.currentThread().getName());
            }
            this.a.a();
            if (drivingRouteResult == null || (errorno = drivingRouteResult.error) != SearchResult.ERRORNO.NO_ERROR || errorno == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
                boolean unused = OpenLocationBottomMenu.p = false;
                if (OpenLocationBottomMenu.m) {
                    if (drivingRouteResult == null) {
                        Log.e("OpenLocationBottomMenu", "onGetDrivingRouteResult error, result is null ");
                        return;
                    }
                    Log.e("OpenLocationBottomMenu", "onGetDrivingRouteResult error, error code = " + drivingRouteResult.error);
                    return;
                }
                return;
            }
            BaiduMap n3 = OpenLocationBottomMenu.this.e.n3();
            if (n3 == null) {
                boolean unused2 = OpenLocationBottomMenu.p = false;
                if (OpenLocationBottomMenu.m) {
                    Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                }
            } else if (OpenLocationBottomMenu.p) {
                uh4 unused3 = OpenLocationBottomMenu.o = new vh4(n3);
                n3.setOnMarkerClickListener(OpenLocationBottomMenu.o);
                OpenLocationBottomMenu.o.h(drivingRouteResult.getRouteLines().get(0));
                OpenLocationBottomMenu.o.a();
                OpenLocationBottomMenu.o.d();
                if (OpenLocationBottomMenu.m) {
                    Log.e("OpenLocationBottomMenu", "showPath success");
                }
                OpenLocationBottomMenu.this.e.v3(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[OpenLocationMenuItem.MenuItemType.values().length];
            a = iArr;
            try {
                iArr[OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static void l() {
        if (m) {
            Log.e("OpenLocationBottomMenu", "resetItemClickFlag");
        }
        p = false;
        o = null;
    }

    public final void i() {
        gh4 gh4Var = this.e;
        if (gh4Var == null || !gh4Var.l3()) {
            return;
        }
        uh4 uh4Var = o;
        if (uh4Var != null) {
            uh4Var.c();
            if (m) {
                Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan success");
            }
        }
        if (m) {
            Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan clicked");
        }
    }

    public OpenLocationBottomMenu(Context context) {
        super(context);
        this.i = false;
        j(context);
    }

    public final void j(Context context) {
        this.a = context;
        setOrientation(1);
    }

    public void setFragment(gh4 gh4Var) {
        this.e = gh4Var;
        k();
        g();
    }

    public OpenLocationBottomMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = false;
        j(context);
    }

    public final void h(BaiduMap baiduMap, uh4 uh4Var) {
        if (baiduMap != null && uh4Var != null) {
            baiduMap.setOnMarkerClickListener(uh4Var);
            uh4Var.a();
            uh4Var.d();
        }
    }

    private Map<OpenLocationMenuItem.MenuItemType, th4> getMapApps() {
        ArrayList<String> arrayList = new ArrayList(n);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        gh4 gh4Var = this.e;
        if (gh4Var != null) {
            List<String> m3 = gh4Var.m3();
            if (m3 != null) {
                m3.remove(BaiduMap.e);
                arrayList.removeAll(m3);
            }
            for (String str : arrayList) {
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -1943115423) {
                    if (hashCode == -1647700090 && str.equals("GaodeMap")) {
                        c = 1;
                    }
                } else if (str.equals(BaiduMap.e)) {
                    c = 0;
                }
                if (c != 0) {
                    if (c == 1) {
                        linkedHashMap.put(OpenLocationMenuItem.MenuItemType.OPENLOCATION_GAODE_MAP, new sh4(this.a));
                    }
                } else {
                    linkedHashMap.put(OpenLocationMenuItem.MenuItemType.OPENLOCATION_BAIDU_MAP, new rh4(this.a));
                }
            }
        }
        return linkedHashMap;
    }

    public final void k() {
        if (this.e == null) {
            return;
        }
        String str = "";
        if (this.f == null) {
            if (m) {
                Log.e("OpenLocationBottomMenu", "getStartPosi again");
            }
            BDLocation k3 = this.e.k3();
            if (k3 == null) {
                return;
            }
            this.f = new LatLng(k3.getLatitude(), k3.getLongitude());
            String addrStr = k3.getAddrStr();
            if (TextUtils.isEmpty(addrStr)) {
                if (TextUtils.isEmpty(k3.getStreet())) {
                    addrStr = "";
                } else {
                    addrStr = k3.getStreet();
                }
            }
            this.j = addrStr;
        }
        if (this.h == null) {
            Bundle o2 = this.e.o();
            this.h = new LatLng(o2.getDouble("latitude"), o2.getDouble("longitude"));
            String string = o2.getString("name");
            if (!TextUtils.isEmpty(string)) {
                str = string;
            }
            this.k = str;
        }
    }

    @Override // com.baidu.swan.map.item.OpenLocationMenuItem.b
    public void a(OpenLocationMenuItem openLocationMenuItem) {
        gh4 gh4Var = this.e;
        if (gh4Var != null) {
            gh4Var.j3();
        }
        OpenLocationMenuItem.MenuItemType type = openLocationMenuItem.getType();
        int i = b.a[type.ordinal()];
        if (i != 1) {
            if (i != 2) {
                k();
                th4 th4Var = this.l.get(type);
                if (th4Var != null) {
                    th4Var.d(this.a, this.f, this.h, this.j, this.k);
                    return;
                }
                return;
            }
            return;
        }
        boolean z = !p;
        p = z;
        if (!z) {
            i();
        } else if (o == null) {
            m();
            if (m) {
                Log.e("OpenLocationBottomMenu", "use a new path");
            }
        } else {
            gh4 gh4Var2 = this.e;
            if (gh4Var2 == null) {
                return;
            }
            h(gh4Var2.n3(), o);
            this.e.v3(true);
            if (m) {
                Log.e("OpenLocationBottomMenu", "use a cache path");
            }
        }
    }

    public final void g() {
        String string;
        if (m) {
            Log.e("OpenLocationBottomMenu", "addMenuItem run");
        }
        if (!p) {
            string = this.a.getString(R.string.obfuscated_res_0x7f0f0ec6);
        } else {
            string = this.a.getString(R.string.obfuscated_res_0x7f0f0ec5);
        }
        OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.a, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
        this.b = openLocationMenuItem;
        openLocationMenuItem.c(this);
        addView(this.b.b());
        Map<OpenLocationMenuItem.MenuItemType, th4> mapApps = getMapApps();
        this.l = mapApps;
        for (OpenLocationMenuItem.MenuItemType menuItemType : mapApps.keySet()) {
            th4 th4Var = this.l.get(menuItemType);
            if (th4Var.c(this.a) || th4Var.b()) {
                OpenLocationMenuItem openLocationMenuItem2 = new OpenLocationMenuItem(this.a, th4Var.a(), menuItemType);
                openLocationMenuItem2.c(this);
                if (!this.i) {
                    ((LinearLayout.LayoutParams) openLocationMenuItem2.b().getLayoutParams()).topMargin = qp3.g(7.0f);
                    this.i = true;
                }
                addView(openLocationMenuItem2.b());
            }
        }
        Context context = this.a;
        OpenLocationMenuItem openLocationMenuItem3 = new OpenLocationMenuItem(context, context.getString(R.string.obfuscated_res_0x7f0f0c2a), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
        this.c = openLocationMenuItem3;
        openLocationMenuItem3.c(this);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.c.b().getLayoutParams();
        this.d = layoutParams;
        layoutParams.topMargin = qp3.g(7.0f);
        addView(this.c.b());
    }

    public final void m() {
        gh4 gh4Var = this.e;
        if (gh4Var == null) {
            p = false;
            if (m) {
                Log.e("OpenLocationBottomMenu", "getFragment null");
                return;
            }
            return;
        }
        gh4Var.v3(false);
        xh4 b2 = xh4.b();
        a aVar = new a(b2);
        this.g = aVar;
        LatLng latLng = this.f;
        if (latLng == null) {
            p = false;
            if (m) {
                Log.e("OpenLocationBottomMenu", "getStartPosition null");
                return;
            }
            return;
        }
        b2.c(latLng, this.h, aVar);
    }
}
