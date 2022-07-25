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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a64;
import com.repackage.b64;
import com.repackage.c64;
import com.repackage.d64;
import com.repackage.f64;
import com.repackage.o54;
import com.repackage.sg1;
import com.repackage.z54;
import com.repackage.zd3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class OpenLocationBottomMenu extends LinearLayout implements OpenLocationMenuItem.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public static final List<String> n;
    public static c64 o;
    public static boolean p;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public OpenLocationMenuItem b;
    public OpenLocationMenuItem c;
    public LinearLayout.LayoutParams d;
    public o54 e;
    public LatLng f;
    public OnGetRoutePlanResultListener g;
    public LatLng h;
    public boolean i;
    public String j;
    public String k;
    public Map<OpenLocationMenuItem.MenuItemType, b64> l;

    /* loaded from: classes2.dex */
    public class a implements OnGetRoutePlanResultListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f64 a;
        public final /* synthetic */ OpenLocationBottomMenu b;

        public a(OpenLocationBottomMenu openLocationBottomMenu, f64 f64Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {openLocationBottomMenu, f64Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = openLocationBottomMenu;
            this.a = f64Var;
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
                BaiduMap l3 = this.b.e.l3();
                if (l3 == null) {
                    boolean unused2 = OpenLocationBottomMenu.p = false;
                    if (OpenLocationBottomMenu.m) {
                        Log.e("OpenLocationBottomMenu", "getBaiduMap null");
                    }
                } else if (OpenLocationBottomMenu.p) {
                    c64 unused3 = OpenLocationBottomMenu.o = new d64(l3);
                    l3.setOnMarkerClickListener(OpenLocationBottomMenu.o);
                    OpenLocationBottomMenu.o.h(drivingRouteResult.getRouteLines().get(0));
                    OpenLocationBottomMenu.o.a();
                    OpenLocationBottomMenu.o.d();
                    if (OpenLocationBottomMenu.m) {
                        Log.e("OpenLocationBottomMenu", "showPath success");
                    }
                    this.b.e.t3(true);
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

    /* loaded from: classes2.dex */
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
        m = sg1.a;
        n = Arrays.asList(BaiduMap.e, "GaodeMap");
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

    private Map<OpenLocationMenuItem.MenuItemType, b64> getMapApps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            ArrayList<String> arrayList = new ArrayList(n);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            o54 o54Var = this.e;
            if (o54Var != null) {
                List<String> k3 = o54Var.k3();
                if (k3 != null) {
                    k3.remove(BaiduMap.e);
                    arrayList.removeAll(k3);
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
                    if (c == 0) {
                        linkedHashMap.put(OpenLocationMenuItem.MenuItemType.OPENLOCATION_BAIDU_MAP, new z54(this.a));
                    } else if (c == 1) {
                        linkedHashMap.put(OpenLocationMenuItem.MenuItemType.OPENLOCATION_GAODE_MAP, new a64(this.a));
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
            o54 o54Var = this.e;
            if (o54Var != null) {
                o54Var.h3();
            }
            OpenLocationMenuItem.MenuItemType type = openLocationMenuItem.getType();
            int i = b.a[type.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    k();
                    b64 b64Var = this.l.get(type);
                    if (b64Var != null) {
                        b64Var.d(this.a, this.f, this.h, this.j, this.k);
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
                o54 o54Var2 = this.e;
                if (o54Var2 == null) {
                    return;
                }
                h(o54Var2.l3(), o);
                this.e.t3(true);
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
                string = this.a.getString(R.string.obfuscated_res_0x7f0f0cd9);
            } else {
                string = this.a.getString(R.string.obfuscated_res_0x7f0f0cd8);
            }
            OpenLocationMenuItem openLocationMenuItem = new OpenLocationMenuItem(this.a, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
            this.b = openLocationMenuItem;
            openLocationMenuItem.c(this);
            addView(this.b.b());
            Map<OpenLocationMenuItem.MenuItemType, b64> mapApps = getMapApps();
            this.l = mapApps;
            for (OpenLocationMenuItem.MenuItemType menuItemType : mapApps.keySet()) {
                b64 b64Var = this.l.get(menuItemType);
                if (b64Var.c(this.a) || b64Var.b()) {
                    OpenLocationMenuItem openLocationMenuItem2 = new OpenLocationMenuItem(this.a, b64Var.a(), menuItemType);
                    openLocationMenuItem2.c(this);
                    if (!this.i) {
                        ((LinearLayout.LayoutParams) openLocationMenuItem2.b().getLayoutParams()).topMargin = zd3.g(7.0f);
                        this.i = true;
                    }
                    addView(openLocationMenuItem2.b());
                }
            }
            Context context = this.a;
            OpenLocationMenuItem openLocationMenuItem3 = new OpenLocationMenuItem(context, context.getString(R.string.obfuscated_res_0x7f0f0a6b), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
            this.c = openLocationMenuItem3;
            openLocationMenuItem3.c(this);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.c.b().getLayoutParams();
            this.d = layoutParams;
            layoutParams.topMargin = zd3.g(7.0f);
            addView(this.c.b());
        }
    }

    public final void h(BaiduMap baiduMap, c64 c64Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, baiduMap, c64Var) == null) || baiduMap == null || c64Var == null) {
            return;
        }
        baiduMap.setOnMarkerClickListener(c64Var);
        c64Var.a();
        c64Var.d();
    }

    public final void i() {
        o54 o54Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (o54Var = this.e) != null && o54Var.j3()) {
            c64 c64Var = o;
            if (c64Var != null) {
                c64Var.c();
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.e == null) {
            return;
        }
        if (this.f == null) {
            if (m) {
                Log.e("OpenLocationBottomMenu", "getStartPosi again");
            }
            BDLocation i3 = this.e.i3();
            if (i3 == null) {
                return;
            }
            this.f = new LatLng(i3.getLatitude(), i3.getLongitude());
            String addrStr = i3.getAddrStr();
            if (TextUtils.isEmpty(addrStr)) {
                addrStr = TextUtils.isEmpty(i3.getStreet()) ? "" : i3.getStreet();
            }
            this.j = addrStr;
        }
        if (this.h == null) {
            Bundle p2 = this.e.p();
            this.h = new LatLng(p2.getDouble("latitude"), p2.getDouble("longitude"));
            String string = p2.getString("name");
            this.k = TextUtils.isEmpty(string) ? "" : string;
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            o54 o54Var = this.e;
            if (o54Var == null) {
                p = false;
                if (m) {
                    Log.e("OpenLocationBottomMenu", "getFragment null");
                    return;
                }
                return;
            }
            o54Var.t3(false);
            f64 b2 = f64.b();
            a aVar = new a(this, b2);
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

    public void setFragment(o54 o54Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, o54Var) == null) {
            this.e = o54Var;
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
