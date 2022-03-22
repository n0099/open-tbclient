package com.baidu.swan.map.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import c.a.n0.a.p2.n0;
import c.a.n0.m.k.c;
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
/* loaded from: classes4.dex */
public class OpenLocationBottomMenu extends LinearLayout implements OpenLocationMenuItem.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public static final List<String> n;
    public static c.a.n0.m.l.a o;
    public static boolean p;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public OpenLocationMenuItem f29642b;

    /* renamed from: c  reason: collision with root package name */
    public OpenLocationMenuItem f29643c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout.LayoutParams f29644d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.n0.m.h.a f29645e;

    /* renamed from: f  reason: collision with root package name */
    public LatLng f29646f;

    /* renamed from: g  reason: collision with root package name */
    public OnGetRoutePlanResultListener f29647g;

    /* renamed from: h  reason: collision with root package name */
    public LatLng f29648h;
    public boolean i;
    public String j;
    public String k;
    public Map<OpenLocationMenuItem.MenuItemType, c> l;

    /* loaded from: classes4.dex */
    public class a implements OnGetRoutePlanResultListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.m.m.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OpenLocationBottomMenu f29649b;

        public a(OpenLocationBottomMenu openLocationBottomMenu, c.a.n0.m.m.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {openLocationBottomMenu, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29649b = openLocationBottomMenu;
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
                BaiduMap j3 = this.f29649b.f29645e.j3();
                if (j3 == null) {
                    boolean unused2 = OpenLocationBottomMenu.p = false;
                    if (OpenLocationBottomMenu.m) {
                        Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                    }
                } else if (OpenLocationBottomMenu.p) {
                    c.a.n0.m.l.a unused3 = OpenLocationBottomMenu.o = new c.a.n0.m.l.b(j3);
                    j3.setOnMarkerClickListener(OpenLocationBottomMenu.o);
                    OpenLocationBottomMenu.o.h(drivingRouteResult.getRouteLines().get(0));
                    OpenLocationBottomMenu.o.a();
                    OpenLocationBottomMenu.o.d();
                    if (OpenLocationBottomMenu.m) {
                        Log.e("OpenLocationBottomMenu", "showPath success");
                    }
                    this.f29649b.f29645e.r3(true);
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
        m = c.a.n0.a.a.a;
        n = Arrays.asList(BaiduMap.f26122e, "GaodeMap");
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = false;
        j(context);
    }

    private Map<OpenLocationMenuItem.MenuItemType, c> getMapApps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            ArrayList<String> arrayList = new ArrayList(n);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            c.a.n0.m.h.a aVar = this.f29645e;
            if (aVar != null) {
                List<String> i3 = aVar.i3();
                if (i3 != null) {
                    i3.remove(BaiduMap.f26122e);
                    arrayList.removeAll(i3);
                }
                for (String str : arrayList) {
                    char c2 = 65535;
                    int hashCode = str.hashCode();
                    if (hashCode != -1943115423) {
                        if (hashCode == -1647700090 && str.equals("GaodeMap")) {
                            c2 = 1;
                        }
                    } else if (str.equals(BaiduMap.f26122e)) {
                        c2 = 0;
                    }
                    if (c2 == 0) {
                        linkedHashMap.put(OpenLocationMenuItem.MenuItemType.OPENLOCATION_BAIDU_MAP, new c.a.n0.m.k.a(this.a));
                    } else if (c2 == 1) {
                        linkedHashMap.put(OpenLocationMenuItem.MenuItemType.OPENLOCATION_GAODE_MAP, new c.a.n0.m.k.b(this.a));
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
            if (m) {
                Log.e("OpenLocationBottomMenu", "resetItemClickFlag");
            }
            p = false;
            o = null;
        }
    }

    @Override // com.baidu.swan.map.item.OpenLocationMenuItem.b
    public void a(OpenLocationMenuItem openLocationMenuItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, openLocationMenuItem) == null) {
            c.a.n0.m.h.a aVar = this.f29645e;
            if (aVar != null) {
                aVar.f3();
            }
            OpenLocationMenuItem.MenuItemType type = openLocationMenuItem.getType();
            int i = b.a[type.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    k();
                    c cVar = this.l.get(type);
                    if (cVar != null) {
                        cVar.d(this.a, this.f29646f, this.f29648h, this.j, this.k);
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
                c.a.n0.m.h.a aVar2 = this.f29645e;
                if (aVar2 == null) {
                    return;
                }
                h(aVar2.j3(), o);
                this.f29645e.r3(true);
                if (m) {
                    Log.e("OpenLocationBottomMenu", "use a cache path");
                }
            }
        }
    }

    public final void g() {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (m) {
                Log.e("OpenLocationBottomMenu", "addMenuItem run");
            }
            if (!p) {
                string = this.a.getString(R.string.obfuscated_res_0x7f0f0cd4);
            } else {
                string = this.a.getString(R.string.obfuscated_res_0x7f0f0cd3);
            }
            OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.a, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
            this.f29642b = openLocationMenuItem;
            openLocationMenuItem.c(this);
            addView(this.f29642b.b());
            Map<OpenLocationMenuItem.MenuItemType, c> mapApps = getMapApps();
            this.l = mapApps;
            for (OpenLocationMenuItem.MenuItemType menuItemType : mapApps.keySet()) {
                c cVar = this.l.get(menuItemType);
                if (cVar.c(this.a) || cVar.b()) {
                    OpenLocationMenuItem openLocationMenuItem2 = new OpenLocationMenuItem(this.a, cVar.a(), menuItemType);
                    openLocationMenuItem2.c(this);
                    if (!this.i) {
                        ((LinearLayout.LayoutParams) openLocationMenuItem2.b().getLayoutParams()).topMargin = n0.g(7.0f);
                        this.i = true;
                    }
                    addView(openLocationMenuItem2.b());
                }
            }
            Context context = this.a;
            OpenLocationMenuItem openLocationMenuItem3 = new OpenLocationMenuItem(context, context.getString(R.string.obfuscated_res_0x7f0f0a7e), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
            this.f29643c = openLocationMenuItem3;
            openLocationMenuItem3.c(this);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f29643c.b().getLayoutParams();
            this.f29644d = layoutParams;
            layoutParams.topMargin = n0.g(7.0f);
            addView(this.f29643c.b());
        }
    }

    public final void h(BaiduMap baiduMap, c.a.n0.m.l.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, baiduMap, aVar) == null) || baiduMap == null || aVar == null) {
            return;
        }
        baiduMap.setOnMarkerClickListener(aVar);
        aVar.a();
        aVar.d();
    }

    public final void i() {
        c.a.n0.m.h.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (aVar = this.f29645e) != null && aVar.h3()) {
            c.a.n0.m.l.a aVar2 = o;
            if (aVar2 != null) {
                aVar2.c();
                if (m) {
                    Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan success");
                }
            }
            if (m) {
                Log.e("OpenLocationBottomMenu", "hideDrivingRootPlan clicked");
            }
        }
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            this.a = context;
            setOrientation(1);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f29645e == null) {
            return;
        }
        if (this.f29646f == null) {
            if (m) {
                Log.e("OpenLocationBottomMenu", "getStartPosi again");
            }
            BDLocation g3 = this.f29645e.g3();
            if (g3 == null) {
                return;
            }
            this.f29646f = new LatLng(g3.getLatitude(), g3.getLongitude());
            String addrStr = g3.getAddrStr();
            if (TextUtils.isEmpty(addrStr)) {
                addrStr = TextUtils.isEmpty(g3.getStreet()) ? "" : g3.getStreet();
            }
            this.j = addrStr;
        }
        if (this.f29648h == null) {
            Bundle p2 = this.f29645e.p();
            this.f29648h = new LatLng(p2.getDouble("latitude"), p2.getDouble("longitude"));
            String string = p2.getString("name");
            this.k = TextUtils.isEmpty(string) ? "" : string;
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.n0.m.h.a aVar = this.f29645e;
            if (aVar == null) {
                p = false;
                if (m) {
                    Log.e("OpenLocationBottomMenu", "getFragment null");
                    return;
                }
                return;
            }
            aVar.r3(false);
            c.a.n0.m.m.a b2 = c.a.n0.m.m.a.b();
            a aVar2 = new a(this, b2);
            this.f29647g = aVar2;
            LatLng latLng = this.f29646f;
            if (latLng == null) {
                p = false;
                if (m) {
                    Log.e("OpenLocationBottomMenu", "getStartPosition null");
                    return;
                }
                return;
            }
            b2.c(latLng, this.f29648h, aVar2);
        }
    }

    public void setFragment(c.a.n0.m.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f29645e = aVar;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.i = false;
        j(context);
    }
}
