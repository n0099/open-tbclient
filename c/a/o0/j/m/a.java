package c.a.o0.j.m;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.h0.g.g;
import c.a.o0.a.k;
import c.a.o0.j.g;
import c.a.o0.j.h;
import c.a.o0.j.r.c;
import c.a.o0.k.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.map.view.OpenLocationBottomMenu;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends c.a.o0.a.h0.g.d implements BaiduMap.OnMapLoadedCallback, BaiduMap.OnMarkerClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextureMapView C0;
    public BaiduMap D0;
    public String E0;
    public Marker F0;
    public String G0;
    public String H0;
    public ImageView I0;
    public TextView J0;
    public TextView K0;
    public GeoCoder L0;
    public PopupWindow M0;
    public OpenLocationBottomMenu N0;
    public View O0;
    public ImageView P0;
    public c.a.o0.j.r.c Q0;
    public BDLocation R0;
    public boolean S0;
    public ArrayList<String> T0;

    /* renamed from: c.a.o0.j.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0611a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11711e;

        public View$OnClickListenerC0611a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11711e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f11711e.e3();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements OnGetGeoCoderResultListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11712e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11712e = aVar;
        }

        @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
        public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, geoCodeResult) == null) {
            }
        }

        @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
        public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, reverseGeoCodeResult) == null) {
                if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    this.f11712e.J0.setText(g.unknown_location_info);
                    return;
                }
                if (this.f11712e.K0 != null && TextUtils.isEmpty(this.f11712e.H0)) {
                    String address = reverseGeoCodeResult.getAddress();
                    a aVar = this.f11712e;
                    if (address == null) {
                        address = aVar.z().getString(g.unknown_location_info);
                    }
                    aVar.H0 = address;
                    this.f11712e.K0.setText(this.f11712e.H0);
                }
                if (this.f11712e.J0 != null && TextUtils.isEmpty(this.f11712e.G0)) {
                    String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                    a aVar2 = this.f11712e;
                    if (sematicDescription == null) {
                        sematicDescription = aVar2.z().getString(g.unknown_location_info);
                    }
                    aVar2.G0 = sematicDescription;
                    this.f11712e.J0.setText(this.f11712e.G0);
                }
                c.a.o0.a.e0.d.g("map", "mAddress +" + this.f11712e.H0 + " mName" + this.f11712e.G0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11713e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11713e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f11713e.Q2();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements PopupWindow.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f11714a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11714a = aVar;
        }

        @Override // com.baidu.swan.menu.PopupWindow.b
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11714a.d3(1.0f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11715e;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11715e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f11715e.Q0 == null || this.f11715e.Q0.i() == null) {
                return;
            }
            BDLocation i2 = this.f11715e.Q0.i();
            this.f11715e.D0.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(i2.getLatitude(), i2.getLongitude())));
        }
    }

    /* loaded from: classes3.dex */
    public class f implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f11716a;

        public f(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11716a = aVar;
        }

        @Override // c.a.o0.j.r.c.b
        public void a(BDLocation bDLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bDLocation) == null) {
                this.f11716a.R0 = bDLocation;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(706212585, "Lc/a/o0/j/m/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(706212585, "Lc/a/o0/j/m/a;");
                return;
            }
        }
        boolean z = k.f7049a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.E0 = "";
    }

    public static a a3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, bundle)) == null) {
            a aVar = new a();
            if (bundle != null) {
                aVar.h1(bundle);
            }
            c.a.o0.j.a.a();
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    @Override // c.a.o0.a.h0.g.d
    public void A2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.E0);
            c.a.o0.a.g1.f.V().v(new c.a.o0.a.o0.d.b("sharebtn", hashMap));
        }
    }

    @Override // c.a.o0.a.h0.g.d
    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void Q2() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (popupWindow = this.M0) != null && popupWindow.x()) {
            this.M0.r();
        }
    }

    public BDLocation R2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.R0 : (BDLocation) invokeV.objValue;
    }

    public boolean S2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.S0 : invokeV.booleanValue;
    }

    public List<String> T2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.T0 : (List) invokeV.objValue;
    }

    public BaiduMap U2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.D0 : (BaiduMap) invokeV.objValue;
    }

    @Override // c.a.o0.a.h0.g.d
    public boolean V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void V2(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            this.O0 = view;
            ImageView imageView = (ImageView) view.findViewById(c.a.o0.j.e.location_icon_path);
            this.I0 = imageView;
            imageView.setOnClickListener(new View$OnClickListenerC0611a(this));
            this.J0 = (TextView) view.findViewById(c.a.o0.j.e.location_text_position);
            this.K0 = (TextView) view.findViewById(c.a.o0.j.e.location_text_address);
        }
    }

    public final void W2(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            ImageView imageView = (ImageView) view.findViewById(c.a.o0.j.e.goMyPoint);
            this.P0 = imageView;
            imageView.setOnClickListener(new e(this));
        }
    }

    @Override // c.a.o0.a.h0.g.d
    public boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void X2(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view) == null) {
            TextureMapView textureMapView = (TextureMapView) view.findViewById(c.a.o0.j.e.bdMapView);
            this.C0 = textureMapView;
            BaiduMap map = textureMapView.getMap();
            this.D0 = map;
            map.getUiSettings().setRotateGesturesEnabled(false);
            this.C0.showZoomControls(false);
            this.D0.getUiSettings().setOverlookingGesturesEnabled(false);
            this.D0.setOnMapLoadedCallback(this);
        }
    }

    public void Y2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.o0 == null) {
            this.o0 = new n(q(), this.n0, 12, c.a.o0.a.c1.a.G(), new c.a.o0.a.w2.h.b());
            new c.a.o0.a.j1.a(this.o0, this).z();
        }
    }

    public final void Z2(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, latLng) == null) {
            this.L0 = GeoCoder.newInstance();
            this.L0.setOnGetGeoCodeResultListener(new b(this));
            this.L0.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
        }
    }

    public final void b3() {
        Bundle o;
        TextView textView;
        TextView textView2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (o = o()) == null || o.size() <= 0) {
            return;
        }
        this.E0 = o.getString("slaveId");
        double d2 = o.getDouble("latitude");
        double d3 = o.getDouble("longitude");
        double d4 = o.getDouble("scale");
        this.G0 = o.getString("name");
        this.H0 = o.getString("address");
        LatLng latLng = new LatLng(d2, d3);
        Z2(latLng);
        this.D0.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
        this.D0.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d4));
        this.F0 = (Marker) this.D0.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(c.a.o0.j.d.aiapps_location_ding)).title(TextUtils.isEmpty(this.G0) ? "" : this.G0).anchor(0.5f, 0.5f));
        c.a.o0.a.e0.d.g("map", "show marker");
        if (!TextUtils.isEmpty(this.G0) && (textView2 = this.J0) != null) {
            textView2.setText(this.G0);
        }
        if (!TextUtils.isEmpty(this.H0) && (textView = this.K0) != null) {
            textView.setText(this.H0);
        }
        this.T0 = o.getStringArrayList("ignoredApps");
    }

    @Override // c.a.o0.a.h0.g.d
    public void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            Y2();
            this.o0.q(c.a.o0.a.c1.a.H().a(), C1());
        }
    }

    public void c3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.S0 = z;
        }
    }

    public final void d3(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048593, this, f2) == null) || h() == null) {
            return;
        }
        Window window = h().getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = f2;
        window.setAttributes(attributes);
    }

    public final void e3() {
        FragmentActivity h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (h2 = h()) == null) {
            return;
        }
        PopupWindow popupWindow = this.M0;
        if (popupWindow == null || !popupWindow.x()) {
            View inflate = View.inflate(h2, c.a.o0.j.f.aiapps_openlocation_pop_menu, null);
            inflate.setOnClickListener(new c(this));
            OpenLocationBottomMenu openLocationBottomMenu = (OpenLocationBottomMenu) inflate.findViewById(c.a.o0.j.e.openlocation_popmenu);
            this.N0 = openLocationBottomMenu;
            openLocationBottomMenu.setFragment(this);
            PopupWindow popupWindow2 = new PopupWindow(h2);
            this.M0 = popupWindow2;
            popupWindow2.K(inflate);
            this.M0.S(-1);
            this.M0.N(-2);
            this.M0.D(new BitmapDrawable());
            this.M0.L(true);
            this.M0.Q(true);
            this.M0.B(h.OpenLocationBottomMenuPopupStyle);
            this.M0.U(this.O0, 80, 0, 0);
            this.M0.P(new d(this));
            d3(0.3f);
        }
    }

    public void f3() {
        c.a.o0.a.h0.g.g W;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (W = c.a.o0.a.g1.f.V().W()) == null) {
            return;
        }
        g.b i2 = W.i("navigateTo");
        i2.n(c.a.o0.a.h0.g.g.f5900g, c.a.o0.a.h0.g.g.f5902i);
        i2.j(this);
        i2.b();
    }

    public final void g3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            c.a.o0.j.r.c cVar = new c.a.o0.j.r.c(c.a.o0.a.g1.f.V().getActivity(), this.D0);
            this.Q0 = cVar;
            cVar.n(true);
            this.Q0.k(new f(this));
        }
    }

    @Override // c.a.o0.a.h0.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onDestroy();
            GeoCoder geoCoder = this.L0;
            if (geoCoder != null) {
                geoCoder.destroy();
            }
            OpenLocationBottomMenu.resetItemClickFlag();
            c.a.o0.j.r.c cVar = this.Q0;
            if (cVar != null) {
                cVar.n(false);
            }
            if (Build.VERSION.SDK_INT > 19) {
                this.C0.onDestroy();
            }
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            c.a.o0.a.e0.d.g("map", "onMapLoaded");
            b3();
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, marker)) == null) {
            if (marker == this.F0 && !TextUtils.isEmpty(this.G0)) {
                LinearLayout linearLayout = new LinearLayout(AppRuntime.getAppContext());
                linearLayout.setOrientation(1);
                TextView textView = new TextView(AppRuntime.getAppContext());
                textView.setText(this.G0);
                textView.setTextSize(18.0f);
                TextView textView2 = new TextView(AppRuntime.getAppContext());
                textView2.setText(this.H0);
                textView2.setTextSize(15.0f);
                linearLayout.addView(textView);
                linearLayout.addView(textView2);
                this.D0.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048601, this, layoutInflater, viewGroup, bundle)) == null) {
            c.a.o0.a.e0.d.g("map", "start MapLocationFragment");
            View inflate = layoutInflater.inflate(c.a.o0.j.f.ai_apps_map_show_location_fragment, viewGroup, false);
            O1(inflate);
            n2(T1());
            x2(false);
            X2(inflate);
            V2(inflate);
            g3();
            W2(inflate);
            l2(AppRuntime.getAppContext().getResources().getString(c.a.o0.j.g.aiapps_map_open_location_title));
            if (N1()) {
                inflate = Q1(inflate);
            }
            return y1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }
}
