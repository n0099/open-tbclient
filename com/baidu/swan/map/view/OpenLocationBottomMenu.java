package com.baidu.swan.map.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import d.a.q0.a.v2.n0;
import d.a.q0.j.g;
import d.a.q0.j.p.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class OpenLocationBottomMenu extends LinearLayout implements OpenLocationMenuItem.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean q;
    public static final List<String> r;
    public static d.a.q0.j.q.a s;
    public static boolean t;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f11997e;

    /* renamed from: f  reason: collision with root package name */
    public OpenLocationMenuItem f11998f;

    /* renamed from: g  reason: collision with root package name */
    public OpenLocationMenuItem f11999g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout.LayoutParams f12000h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.q0.j.m.a f12001i;
    public LatLng j;
    public OnGetRoutePlanResultListener k;
    public LatLng l;
    public boolean m;
    public String n;
    public String o;
    public Map<OpenLocationMenuItem.MenuItemType, c> p;

    /* loaded from: classes4.dex */
    public class a implements OnGetRoutePlanResultListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.j.r.a f12002a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OpenLocationBottomMenu f12003b;

        public a(OpenLocationBottomMenu openLocationBottomMenu, d.a.q0.j.r.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {openLocationBottomMenu, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12003b = openLocationBottomMenu;
            this.f12002a = aVar;
        }

        @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
        public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bikingRouteResult) == null) {
            }
        }

        @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
        public void onGetDrivingRouteResult(DrivingRouteResult drivingRouteResult) {
            SearchResult.ERRORNO errorno;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drivingRouteResult) == null) {
                if (OpenLocationBottomMenu.q) {
                    Log.e("OpenLocationBottomMenu", "onGetDrivingRouteResult thread  " + Thread.currentThread().getName());
                }
                this.f12002a.a();
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
                BaiduMap W2 = this.f12003b.f12001i.W2();
                if (W2 == null) {
                    boolean unused2 = OpenLocationBottomMenu.t = false;
                    if (OpenLocationBottomMenu.q) {
                        Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                    }
                } else if (OpenLocationBottomMenu.t) {
                    d.a.q0.j.q.a unused3 = OpenLocationBottomMenu.s = new d.a.q0.j.q.b(W2);
                    W2.setOnMarkerClickListener(OpenLocationBottomMenu.s);
                    OpenLocationBottomMenu.s.h(drivingRouteResult.getRouteLines().get(0));
                    OpenLocationBottomMenu.s.a();
                    OpenLocationBottomMenu.s.d();
                    if (OpenLocationBottomMenu.q) {
                        Log.e("OpenLocationBottomMenu", "showPath success");
                    }
                    this.f12003b.f12001i.e3(true);
                }
            }
        }

        @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
        public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, indoorRouteResult) == null) {
            }
        }

        @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
        public void onGetMassTransitRouteResult(MassTransitRouteResult massTransitRouteResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, massTransitRouteResult) == null) {
            }
        }

        @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
        public void onGetTransitRouteResult(TransitRouteResult transitRouteResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, transitRouteResult) == null) {
            }
        }

        @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
        public void onGetWalkingRouteResult(WalkingRouteResult walkingRouteResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, walkingRouteResult) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f12004a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1606941331, "Lcom/baidu/swan/map/view/OpenLocationBottomMenu$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1606941331, "Lcom/baidu/swan/map/view/OpenLocationBottomMenu$b;");
                    return;
                }
            }
            int[] iArr = new int[OpenLocationMenuItem.MenuItemType.values().length];
            f12004a = iArr;
            try {
                iArr[OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12004a[OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(449724011, "Lcom/baidu/swan/map/view/OpenLocationBottomMenu;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(449724011, "Lcom/baidu/swan/map/view/OpenLocationBottomMenu;");
                return;
            }
        }
        q = k.f49133a;
        r = Arrays.asList(BaiduMap.f6863e, "GaodeMap");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpenLocationBottomMenu(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = false;
        j(context);
    }

    private Map<OpenLocationMenuItem.MenuItemType, c> getMapApps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            ArrayList<String> arrayList = new ArrayList(r);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            d.a.q0.j.m.a aVar = this.f12001i;
            if (aVar != null) {
                List<String> V2 = aVar.V2();
                if (V2 != null) {
                    V2.remove(BaiduMap.f6863e);
                    arrayList.removeAll(V2);
                }
                for (String str : arrayList) {
                    char c2 = 65535;
                    int hashCode = str.hashCode();
                    if (hashCode != -1943115423) {
                        if (hashCode == -1647700090 && str.equals("GaodeMap")) {
                            c2 = 1;
                        }
                    } else if (str.equals(BaiduMap.f6863e)) {
                        c2 = 0;
                    }
                    if (c2 == 0) {
                        linkedHashMap.put(OpenLocationMenuItem.MenuItemType.OPENLOCATION_BAIDU_MAP, new d.a.q0.j.p.a(this.f11997e));
                    } else if (c2 == 1) {
                        linkedHashMap.put(OpenLocationMenuItem.MenuItemType.OPENLOCATION_GAODE_MAP, new d.a.q0.j.p.b(this.f11997e));
                    }
                }
            }
            return linkedHashMap;
        }
        return (Map) invokeV.objValue;
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            if (q) {
                Log.e("OpenLocationBottomMenu", "resetItemClickFlag");
            }
            t = false;
            s = null;
        }
    }

    @Override // com.baidu.swan.map.item.OpenLocationMenuItem.b
    public void a(OpenLocationMenuItem openLocationMenuItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, openLocationMenuItem) == null) {
            d.a.q0.j.m.a aVar = this.f12001i;
            if (aVar != null) {
                aVar.S2();
            }
            OpenLocationMenuItem.MenuItemType c2 = openLocationMenuItem.c();
            int i2 = b.f12004a[c2.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    k();
                    c cVar = this.p.get(c2);
                    if (cVar != null) {
                        cVar.d(this.f11997e, this.j, this.l, this.n, this.o);
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
                d.a.q0.j.m.a aVar2 = this.f12001i;
                if (aVar2 == null) {
                    return;
                }
                h(aVar2.W2(), s);
                this.f12001i.e3(true);
                if (q) {
                    Log.e("OpenLocationBottomMenu", "use a cache path");
                }
            }
        }
    }

    public final void g() {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (q) {
                Log.e("OpenLocationBottomMenu", "addMenuItem run");
            }
            if (!t) {
                string = this.f11997e.getString(g.openlocation_bottommenu_showpath);
            } else {
                string = this.f11997e.getString(g.openlocation_bottommenu_hidepath);
            }
            OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.f11997e, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
            this.f11998f = openLocationMenuItem;
            openLocationMenuItem.d(this);
            addView(this.f11998f.b());
            Map<OpenLocationMenuItem.MenuItemType, c> mapApps = getMapApps();
            this.p = mapApps;
            for (OpenLocationMenuItem.MenuItemType menuItemType : mapApps.keySet()) {
                c cVar = this.p.get(menuItemType);
                if (cVar.c(this.f11997e) || cVar.b()) {
                    OpenLocationMenuItem openLocationMenuItem2 = new OpenLocationMenuItem(this.f11997e, cVar.a(), menuItemType);
                    openLocationMenuItem2.d(this);
                    if (!this.m) {
                        ((LinearLayout.LayoutParams) openLocationMenuItem2.b().getLayoutParams()).topMargin = n0.g(7.0f);
                        this.m = true;
                    }
                    addView(openLocationMenuItem2.b());
                }
            }
            Context context = this.f11997e;
            OpenLocationMenuItem openLocationMenuItem3 = new OpenLocationMenuItem(context, context.getString(g.map_location_cancel), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
            this.f11999g = openLocationMenuItem3;
            openLocationMenuItem3.d(this);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f11999g.b().getLayoutParams();
            this.f12000h = layoutParams;
            layoutParams.topMargin = n0.g(7.0f);
            addView(this.f11999g.b());
        }
    }

    public final void h(BaiduMap baiduMap, d.a.q0.j.q.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, baiduMap, aVar) == null) || baiduMap == null || aVar == null) {
            return;
        }
        baiduMap.setOnMarkerClickListener(aVar);
        aVar.a();
        aVar.d();
    }

    public final void i() {
        d.a.q0.j.m.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (aVar = this.f12001i) != null && aVar.U2()) {
            d.a.q0.j.q.a aVar2 = s;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            this.f11997e = context;
            setOrientation(1);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f12001i == null) {
            return;
        }
        if (this.j == null) {
            if (q) {
                Log.e("OpenLocationBottomMenu", "getStartPosi again");
            }
            BDLocation T2 = this.f12001i.T2();
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
            Bundle n = this.f12001i.n();
            this.l = new LatLng(n.getDouble("latitude"), n.getDouble("longitude"));
            String string = n.getString("name");
            this.o = TextUtils.isEmpty(string) ? "" : string;
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d.a.q0.j.m.a aVar = this.f12001i;
            if (aVar == null) {
                t = false;
                if (q) {
                    Log.e("OpenLocationBottomMenu", "getFragment null");
                    return;
                }
                return;
            }
            aVar.e3(false);
            d.a.q0.j.r.a b2 = d.a.q0.j.r.a.b();
            a aVar2 = new a(this, b2);
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
    }

    public void setFragment(d.a.q0.j.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f12001i = aVar;
            k();
            g();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpenLocationBottomMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.m = false;
        j(context);
    }
}
