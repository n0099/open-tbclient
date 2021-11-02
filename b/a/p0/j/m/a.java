package b.a.p0.j.m;

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
import b.a.p0.a.h0.g.g;
import b.a.p0.a.k;
import b.a.p0.j.g;
import b.a.p0.j.h;
import b.a.p0.j.r.c;
import b.a.p0.k.n;
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
/* loaded from: classes4.dex */
public class a extends b.a.p0.a.h0.g.d implements BaiduMap.OnMapLoadedCallback, BaiduMap.OnMarkerClickListener {
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
    public b.a.p0.j.r.c Q0;
    public BDLocation R0;
    public boolean S0;
    public ArrayList<String> T0;

    /* renamed from: b.a.p0.j.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC0608a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10936e;

        public View$OnClickListenerC0608a(a aVar) {
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
            this.f10936e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f10936e.a3();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements OnGetGeoCoderResultListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10937e;

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
            this.f10937e = aVar;
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
                    this.f10937e.J0.setText(g.unknown_location_info);
                    return;
                }
                if (this.f10937e.K0 != null && TextUtils.isEmpty(this.f10937e.H0)) {
                    String address = reverseGeoCodeResult.getAddress();
                    a aVar = this.f10937e;
                    if (address == null) {
                        address = aVar.getResources().getString(g.unknown_location_info);
                    }
                    aVar.H0 = address;
                    this.f10937e.K0.setText(this.f10937e.H0);
                }
                if (this.f10937e.J0 != null && TextUtils.isEmpty(this.f10937e.G0)) {
                    String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                    a aVar2 = this.f10937e;
                    if (sematicDescription == null) {
                        sematicDescription = aVar2.getResources().getString(g.unknown_location_info);
                    }
                    aVar2.G0 = sematicDescription;
                    this.f10937e.J0.setText(this.f10937e.G0);
                }
                b.a.p0.a.e0.d.g("map", "mAddress +" + this.f10937e.H0 + " mName" + this.f10937e.G0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10938e;

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
            this.f10938e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f10938e.M2();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements PopupWindow.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f10939a;

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
            this.f10939a = aVar;
        }

        @Override // com.baidu.swan.menu.PopupWindow.b
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10939a.Z2(1.0f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10940e;

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
            this.f10940e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f10940e.Q0 == null || this.f10940e.Q0.i() == null) {
                return;
            }
            BDLocation i2 = this.f10940e.Q0.i();
            this.f10940e.D0.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(i2.getLatitude(), i2.getLongitude())));
        }
    }

    /* loaded from: classes4.dex */
    public class f implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f10941a;

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
            this.f10941a = aVar;
        }

        @Override // b.a.p0.j.r.c.b
        public void a(BDLocation bDLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bDLocation) == null) {
                this.f10941a.R0 = bDLocation;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-807838871, "Lb/a/p0/j/m/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-807838871, "Lb/a/p0/j/m/a;");
                return;
            }
        }
        boolean z = k.f6397a;
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

    public static a W2(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, bundle)) == null) {
            a aVar = new a();
            if (bundle != null) {
                aVar.d1(bundle);
            }
            b.a.p0.j.a.a();
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void M2() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (popupWindow = this.M0) != null && popupWindow.x()) {
            this.M0.r();
        }
    }

    public BDLocation N2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.R0 : (BDLocation) invokeV.objValue;
    }

    public boolean O2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.S0 : invokeV.booleanValue;
    }

    public List<String> P2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.T0 : (List) invokeV.objValue;
    }

    public BaiduMap Q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.D0 : (BaiduMap) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void R2(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            this.O0 = view;
            ImageView imageView = (ImageView) view.findViewById(b.a.p0.j.e.location_icon_path);
            this.I0 = imageView;
            imageView.setOnClickListener(new View$OnClickListenerC0608a(this));
            this.J0 = (TextView) view.findViewById(b.a.p0.j.e.location_text_position);
            this.K0 = (TextView) view.findViewById(b.a.p0.j.e.location_text_address);
        }
    }

    public final void S2(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            ImageView imageView = (ImageView) view.findViewById(b.a.p0.j.e.goMyPoint);
            this.P0 = imageView;
            imageView.setOnClickListener(new e(this));
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void T2(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
            TextureMapView textureMapView = (TextureMapView) view.findViewById(b.a.p0.j.e.bdMapView);
            this.C0 = textureMapView;
            BaiduMap map = textureMapView.getMap();
            this.D0 = map;
            map.getUiSettings().setRotateGesturesEnabled(false);
            this.C0.showZoomControls(false);
            this.D0.getUiSettings().setOverlookingGesturesEnabled(false);
            this.D0.setOnMapLoadedCallback(this);
        }
    }

    public void U2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.o0 == null) {
            this.o0 = new n(getContext(), this.n0, 12, b.a.p0.a.c1.a.G(), new b.a.p0.a.w2.h.b());
            new b.a.p0.a.j1.a(this.o0, this).z();
        }
    }

    public final void V2(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, latLng) == null) {
            this.L0 = GeoCoder.newInstance();
            this.L0.setOnGetGeoCodeResultListener(new b(this));
            this.L0.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
        }
    }

    public final void X2() {
        Bundle n;
        TextView textView;
        TextView textView2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (n = n()) == null || n.size() <= 0) {
            return;
        }
        this.E0 = n.getString("slaveId");
        double d2 = n.getDouble("latitude");
        double d3 = n.getDouble("longitude");
        double d4 = n.getDouble("scale");
        this.G0 = n.getString("name");
        this.H0 = n.getString("address");
        LatLng latLng = new LatLng(d2, d3);
        V2(latLng);
        this.D0.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
        this.D0.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d4));
        this.F0 = (Marker) this.D0.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(b.a.p0.j.d.aiapps_location_ding)).title(TextUtils.isEmpty(this.G0) ? "" : this.G0).anchor(0.5f, 0.5f));
        b.a.p0.a.e0.d.g("map", "show marker");
        if (!TextUtils.isEmpty(this.G0) && (textView2 = this.J0) != null) {
            textView2.setText(this.G0);
        }
        if (!TextUtils.isEmpty(this.H0) && (textView = this.K0) != null) {
            textView.setText(this.H0);
        }
        this.T0 = n.getStringArrayList("ignoredApps");
    }

    @Override // b.a.p0.a.h0.g.d
    public void Y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            U2();
            this.o0.q(b.a.p0.a.c1.a.H().a(), y1());
        }
    }

    public void Y2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.S0 = z;
        }
    }

    public final void Z2(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048592, this, f2) == null) || getActivity() == null) {
            return;
        }
        Window window = getActivity().getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = f2;
        window.setAttributes(attributes);
    }

    public final void a3() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (activity = getActivity()) == null) {
            return;
        }
        PopupWindow popupWindow = this.M0;
        if (popupWindow == null || !popupWindow.x()) {
            View inflate = View.inflate(activity, b.a.p0.j.f.aiapps_openlocation_pop_menu, null);
            inflate.setOnClickListener(new c(this));
            OpenLocationBottomMenu openLocationBottomMenu = (OpenLocationBottomMenu) inflate.findViewById(b.a.p0.j.e.openlocation_popmenu);
            this.N0 = openLocationBottomMenu;
            openLocationBottomMenu.setFragment(this);
            PopupWindow popupWindow2 = new PopupWindow(activity);
            this.M0 = popupWindow2;
            popupWindow2.J(inflate);
            this.M0.S(-1);
            this.M0.M(-2);
            this.M0.D(new BitmapDrawable());
            this.M0.K(true);
            this.M0.Q(true);
            this.M0.B(h.OpenLocationBottomMenuPopupStyle);
            this.M0.U(this.O0, 80, 0, 0);
            this.M0.P(new d(this));
            Z2(0.3f);
        }
    }

    public void b3() {
        b.a.p0.a.h0.g.g U;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (U = b.a.p0.a.g1.f.T().U()) == null) {
            return;
        }
        g.b i2 = U.i("navigateTo");
        i2.n(b.a.p0.a.h0.g.g.f5280g, b.a.p0.a.h0.g.g.f5282i);
        i2.j(this);
        i2.b();
    }

    public final void c3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            b.a.p0.j.r.c cVar = new b.a.p0.j.r.c(b.a.p0.a.g1.f.T().getActivity(), this.D0);
            this.Q0 = cVar;
            cVar.n(true);
            this.Q0.k(new f(this));
        }
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onDestroy();
            GeoCoder geoCoder = this.L0;
            if (geoCoder != null) {
                geoCoder.destroy();
            }
            OpenLocationBottomMenu.resetItemClickFlag();
            b.a.p0.j.r.c cVar = this.Q0;
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
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            b.a.p0.a.e0.d.g("map", "onMapLoaded");
            X2();
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, marker)) == null) {
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
    public View w0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048600, this, layoutInflater, viewGroup, bundle)) == null) {
            b.a.p0.a.e0.d.g("map", "start MapLocationFragment");
            View inflate = layoutInflater.inflate(b.a.p0.j.f.ai_apps_map_show_location_fragment, viewGroup, false);
            K1(inflate);
            j2(P1());
            t2(false);
            T2(inflate);
            R2(inflate);
            c3();
            S2(inflate);
            h2(AppRuntime.getAppContext().getResources().getString(b.a.p0.j.g.aiapps_map_open_location_title));
            if (J1()) {
                inflate = M1(inflate);
            }
            return u1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public void w2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.E0);
            b.a.p0.a.g1.f.T().u(new b.a.p0.a.o0.d.b("sharebtn", hashMap));
        }
    }
}
