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
import com.baidu.tieba.bk3;
import com.baidu.tieba.cc4;
import com.baidu.tieba.dc4;
import com.baidu.tieba.ec4;
import com.baidu.tieba.fc4;
import com.baidu.tieba.gc4;
import com.baidu.tieba.ic4;
import com.baidu.tieba.rb4;
import com.baidu.tieba.vm1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class OpenLocationBottomMenu extends LinearLayout implements OpenLocationMenuItem.b {
    public static final boolean m = vm1.a;
    public static final List<String> n = Arrays.asList(BaiduMap.e, "GaodeMap");
    public static fc4 o;
    public static boolean p;
    public Context a;
    public OpenLocationMenuItem b;
    public OpenLocationMenuItem c;
    public LinearLayout.LayoutParams d;
    public rb4 e;
    public LatLng f;
    public OnGetRoutePlanResultListener g;
    public LatLng h;
    public boolean i;
    public String j;
    public String k;
    public Map<OpenLocationMenuItem.MenuItemType, ec4> l;

    /* loaded from: classes4.dex */
    public class a implements OnGetRoutePlanResultListener {
        public final /* synthetic */ ic4 a;

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

        public a(ic4 ic4Var) {
            this.a = ic4Var;
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
            BaiduMap s3 = OpenLocationBottomMenu.this.e.s3();
            if (s3 == null) {
                boolean unused2 = OpenLocationBottomMenu.p = false;
                if (OpenLocationBottomMenu.m) {
                    Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                }
            } else if (OpenLocationBottomMenu.p) {
                fc4 unused3 = OpenLocationBottomMenu.o = new gc4(s3);
                s3.setOnMarkerClickListener(OpenLocationBottomMenu.o);
                OpenLocationBottomMenu.o.h(drivingRouteResult.getRouteLines().get(0));
                OpenLocationBottomMenu.o.a();
                OpenLocationBottomMenu.o.d();
                if (OpenLocationBottomMenu.m) {
                    Log.e("OpenLocationBottomMenu", "showPath success");
                }
                OpenLocationBottomMenu.this.e.A3(true);
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
        rb4 rb4Var = this.e;
        if (rb4Var == null || !rb4Var.q3()) {
            return;
        }
        fc4 fc4Var = o;
        if (fc4Var != null) {
            fc4Var.c();
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

    public void setFragment(rb4 rb4Var) {
        this.e = rb4Var;
        k();
        g();
    }

    public OpenLocationBottomMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = false;
        j(context);
    }

    public final void h(BaiduMap baiduMap, fc4 fc4Var) {
        if (baiduMap != null && fc4Var != null) {
            baiduMap.setOnMarkerClickListener(fc4Var);
            fc4Var.a();
            fc4Var.d();
        }
    }

    private Map<OpenLocationMenuItem.MenuItemType, ec4> getMapApps() {
        ArrayList<String> arrayList = new ArrayList(n);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        rb4 rb4Var = this.e;
        if (rb4Var != null) {
            List<String> r3 = rb4Var.r3();
            if (r3 != null) {
                r3.remove(BaiduMap.e);
                arrayList.removeAll(r3);
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
                        linkedHashMap.put(OpenLocationMenuItem.MenuItemType.OPENLOCATION_GAODE_MAP, new dc4(this.a));
                    }
                } else {
                    linkedHashMap.put(OpenLocationMenuItem.MenuItemType.OPENLOCATION_BAIDU_MAP, new cc4(this.a));
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
            BDLocation p3 = this.e.p3();
            if (p3 == null) {
                return;
            }
            this.f = new LatLng(p3.getLatitude(), p3.getLongitude());
            String addrStr = p3.getAddrStr();
            if (TextUtils.isEmpty(addrStr)) {
                if (TextUtils.isEmpty(p3.getStreet())) {
                    addrStr = "";
                } else {
                    addrStr = p3.getStreet();
                }
            }
            this.j = addrStr;
        }
        if (this.h == null) {
            Bundle r = this.e.r();
            this.h = new LatLng(r.getDouble("latitude"), r.getDouble("longitude"));
            String string = r.getString("name");
            if (!TextUtils.isEmpty(string)) {
                str = string;
            }
            this.k = str;
        }
    }

    @Override // com.baidu.swan.map.item.OpenLocationMenuItem.b
    public void a(OpenLocationMenuItem openLocationMenuItem) {
        rb4 rb4Var = this.e;
        if (rb4Var != null) {
            rb4Var.o3();
        }
        OpenLocationMenuItem.MenuItemType c = openLocationMenuItem.c();
        int i = b.a[c.ordinal()];
        if (i != 1) {
            if (i != 2) {
                k();
                ec4 ec4Var = this.l.get(c);
                if (ec4Var != null) {
                    ec4Var.d(this.a, this.f, this.h, this.j, this.k);
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
            rb4 rb4Var2 = this.e;
            if (rb4Var2 == null) {
                return;
            }
            h(rb4Var2.s3(), o);
            this.e.A3(true);
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
            string = this.a.getString(R.string.obfuscated_res_0x7f0f0f4a);
        } else {
            string = this.a.getString(R.string.obfuscated_res_0x7f0f0f49);
        }
        OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.a, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
        this.b = openLocationMenuItem;
        openLocationMenuItem.d(this);
        addView(this.b.b());
        Map<OpenLocationMenuItem.MenuItemType, ec4> mapApps = getMapApps();
        this.l = mapApps;
        for (OpenLocationMenuItem.MenuItemType menuItemType : mapApps.keySet()) {
            ec4 ec4Var = this.l.get(menuItemType);
            if (ec4Var.c(this.a) || ec4Var.b()) {
                OpenLocationMenuItem openLocationMenuItem2 = new OpenLocationMenuItem(this.a, ec4Var.a(), menuItemType);
                openLocationMenuItem2.d(this);
                if (!this.i) {
                    ((LinearLayout.LayoutParams) openLocationMenuItem2.b().getLayoutParams()).topMargin = bk3.g(7.0f);
                    this.i = true;
                }
                addView(openLocationMenuItem2.b());
            }
        }
        Context context = this.a;
        OpenLocationMenuItem openLocationMenuItem3 = new OpenLocationMenuItem(context, context.getString(R.string.obfuscated_res_0x7f0f0c88), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
        this.c = openLocationMenuItem3;
        openLocationMenuItem3.d(this);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.c.b().getLayoutParams();
        this.d = layoutParams;
        layoutParams.topMargin = bk3.g(7.0f);
        addView(this.c.b());
    }

    public final void m() {
        rb4 rb4Var = this.e;
        if (rb4Var == null) {
            p = false;
            if (m) {
                Log.e("OpenLocationBottomMenu", "getFragment null");
                return;
            }
            return;
        }
        rb4Var.A3(false);
        ic4 b2 = ic4.b();
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
