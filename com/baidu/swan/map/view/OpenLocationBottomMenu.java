package com.baidu.swan.map.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import c.a.p0.a.p2.n0;
import c.a.p0.m.k.c;
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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class OpenLocationBottomMenu extends LinearLayout implements OpenLocationMenuItem.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean DEBUG;
    public static final List<String> q;
    public static c.a.p0.m.l.a r;
    public static boolean s;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f38556e;

    /* renamed from: f  reason: collision with root package name */
    public OpenLocationMenuItem f38557f;

    /* renamed from: g  reason: collision with root package name */
    public OpenLocationMenuItem f38558g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout.LayoutParams f38559h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.p0.m.h.a f38560i;

    /* renamed from: j  reason: collision with root package name */
    public LatLng f38561j;
    public OnGetRoutePlanResultListener k;
    public LatLng l;
    public boolean m;
    public String n;
    public String o;
    public Map<OpenLocationMenuItem.MenuItemType, c> p;

    /* loaded from: classes5.dex */
    public class a implements OnGetRoutePlanResultListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.m.m.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OpenLocationBottomMenu f38562b;

        public a(OpenLocationBottomMenu openLocationBottomMenu, c.a.p0.m.m.a aVar) {
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
            this.f38562b = openLocationBottomMenu;
            this.a = aVar;
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
                if (OpenLocationBottomMenu.DEBUG) {
                    String str = "onGetDrivingRouteResult thread  " + Thread.currentThread().getName();
                }
                this.a.a();
                if (drivingRouteResult == null || (errorno = drivingRouteResult.error) != SearchResult.ERRORNO.NO_ERROR || errorno == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
                    boolean unused = OpenLocationBottomMenu.s = false;
                    if (!OpenLocationBottomMenu.DEBUG || drivingRouteResult == null) {
                        return;
                    }
                    String str2 = "onGetDrivingRouteResult error, error code = " + drivingRouteResult.error;
                    return;
                }
                BaiduMap f3 = this.f38562b.f38560i.f3();
                if (f3 == null) {
                    boolean unused2 = OpenLocationBottomMenu.s = false;
                    boolean z = OpenLocationBottomMenu.DEBUG;
                } else if (OpenLocationBottomMenu.s) {
                    c.a.p0.m.l.a unused3 = OpenLocationBottomMenu.r = new c.a.p0.m.l.b(f3);
                    f3.setOnMarkerClickListener(OpenLocationBottomMenu.r);
                    OpenLocationBottomMenu.r.h(drivingRouteResult.getRouteLines().get(0));
                    OpenLocationBottomMenu.r.a();
                    OpenLocationBottomMenu.r.d();
                    boolean z2 = OpenLocationBottomMenu.DEBUG;
                    this.f38562b.f38560i.n3(true);
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

    /* loaded from: classes5.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
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
        DEBUG = c.a.p0.a.a.a;
        q = Arrays.asList(BaiduMap.f33849e, "GaodeMap");
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
        i(context);
    }

    private Map<OpenLocationMenuItem.MenuItemType, c> getMapApps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            ArrayList<String> arrayList = new ArrayList(q);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            c.a.p0.m.h.a aVar = this.f38560i;
            if (aVar != null) {
                List<String> e3 = aVar.e3();
                if (e3 != null) {
                    e3.remove(BaiduMap.f33849e);
                    arrayList.removeAll(e3);
                }
                for (String str : arrayList) {
                    char c2 = 65535;
                    int hashCode = str.hashCode();
                    if (hashCode != -1943115423) {
                        if (hashCode == -1647700090 && str.equals("GaodeMap")) {
                            c2 = 1;
                        }
                    } else if (str.equals(BaiduMap.f33849e)) {
                        c2 = 0;
                    }
                    if (c2 == 0) {
                        linkedHashMap.put(OpenLocationMenuItem.MenuItemType.OPENLOCATION_BAIDU_MAP, new c.a.p0.m.k.a(this.f38556e));
                    } else if (c2 == 1) {
                        linkedHashMap.put(OpenLocationMenuItem.MenuItemType.OPENLOCATION_GAODE_MAP, new c.a.p0.m.k.b(this.f38556e));
                    }
                }
            }
            return linkedHashMap;
        }
        return (Map) invokeV.objValue;
    }

    public static void resetItemClickFlag() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            boolean z = DEBUG;
            s = false;
            r = null;
        }
    }

    public final void f() {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            boolean z = DEBUG;
            if (!s) {
                string = this.f38556e.getString(R.string.openlocation_bottommenu_showpath);
            } else {
                string = this.f38556e.getString(R.string.openlocation_bottommenu_hidepath);
            }
            OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.f38556e, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
            this.f38557f = openLocationMenuItem;
            openLocationMenuItem.c(this);
            addView(this.f38557f.b());
            Map<OpenLocationMenuItem.MenuItemType, c> mapApps = getMapApps();
            this.p = mapApps;
            for (OpenLocationMenuItem.MenuItemType menuItemType : mapApps.keySet()) {
                c cVar = this.p.get(menuItemType);
                if (cVar.c(this.f38556e) || cVar.b()) {
                    OpenLocationMenuItem openLocationMenuItem2 = new OpenLocationMenuItem(this.f38556e, cVar.a(), menuItemType);
                    openLocationMenuItem2.c(this);
                    if (!this.m) {
                        ((LinearLayout.LayoutParams) openLocationMenuItem2.b().getLayoutParams()).topMargin = n0.g(7.0f);
                        this.m = true;
                    }
                    addView(openLocationMenuItem2.b());
                }
            }
            Context context = this.f38556e;
            OpenLocationMenuItem openLocationMenuItem3 = new OpenLocationMenuItem(context, context.getString(R.string.map_location_cancel), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
            this.f38558g = openLocationMenuItem3;
            openLocationMenuItem3.c(this);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f38558g.b().getLayoutParams();
            this.f38559h = layoutParams;
            layoutParams.topMargin = n0.g(7.0f);
            addView(this.f38558g.b());
        }
    }

    public final void g(BaiduMap baiduMap, c.a.p0.m.l.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baiduMap, aVar) == null) || baiduMap == null || aVar == null) {
            return;
        }
        baiduMap.setOnMarkerClickListener(aVar);
        aVar.a();
        aVar.d();
    }

    public final void h() {
        c.a.p0.m.h.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (aVar = this.f38560i) != null && aVar.d3()) {
            c.a.p0.m.l.a aVar2 = r;
            if (aVar2 != null) {
                aVar2.c();
                boolean z = DEBUG;
            }
            boolean z2 = DEBUG;
        }
    }

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.f38556e = context;
            setOrientation(1);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f38560i == null) {
            return;
        }
        if (this.f38561j == null) {
            boolean z = DEBUG;
            BDLocation c3 = this.f38560i.c3();
            if (c3 == null) {
                return;
            }
            this.f38561j = new LatLng(c3.getLatitude(), c3.getLongitude());
            String addrStr = c3.getAddrStr();
            if (TextUtils.isEmpty(addrStr)) {
                addrStr = TextUtils.isEmpty(c3.getStreet()) ? "" : c3.getStreet();
            }
            this.n = addrStr;
        }
        if (this.l == null) {
            Bundle t = this.f38560i.t();
            this.l = new LatLng(t.getDouble("latitude"), t.getDouble("longitude"));
            String string = t.getString("name");
            this.o = TextUtils.isEmpty(string) ? "" : string;
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.p0.m.h.a aVar = this.f38560i;
            if (aVar == null) {
                s = false;
                boolean z = DEBUG;
                return;
            }
            aVar.n3(false);
            c.a.p0.m.m.a b2 = c.a.p0.m.m.a.b();
            a aVar2 = new a(this, b2);
            this.k = aVar2;
            LatLng latLng = this.f38561j;
            if (latLng == null) {
                s = false;
                boolean z2 = DEBUG;
                return;
            }
            b2.c(latLng, this.l, aVar2);
        }
    }

    @Override // com.baidu.swan.map.item.OpenLocationMenuItem.b
    public void onMenuItemClick(OpenLocationMenuItem openLocationMenuItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, openLocationMenuItem) == null) {
            c.a.p0.m.h.a aVar = this.f38560i;
            if (aVar != null) {
                aVar.b3();
            }
            OpenLocationMenuItem.MenuItemType type = openLocationMenuItem.getType();
            int i2 = b.a[type.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    j();
                    c cVar = this.p.get(type);
                    if (cVar != null) {
                        cVar.d(this.f38556e, this.f38561j, this.l, this.n, this.o);
                        return;
                    }
                    return;
                }
                return;
            }
            boolean z = !s;
            s = z;
            if (!z) {
                h();
            } else if (r == null) {
                k();
                boolean z2 = DEBUG;
            } else {
                c.a.p0.m.h.a aVar2 = this.f38560i;
                if (aVar2 == null) {
                    return;
                }
                g(aVar2.f3(), r);
                this.f38560i.n3(true);
                boolean z3 = DEBUG;
            }
        }
    }

    public void setFragment(c.a.p0.m.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f38560i = aVar;
            j();
            f();
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
        i(context);
    }
}
