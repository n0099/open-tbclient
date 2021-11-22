package b.a.p0.m.n;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.k;
import b.a.p0.m.g;
import b.a.p0.m.h;
import b.a.p0.m.i;
import b.a.p0.m.s.c;
import b.a.p0.n.n;
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
    public TextureMapView I0;
    public BaiduMap J0;
    public String K0;
    public Marker L0;
    public String M0;
    public String N0;
    public ImageView O0;
    public TextView P0;
    public TextView Q0;
    public GeoCoder R0;
    public PopupWindow S0;
    public OpenLocationBottomMenu T0;
    public View U0;
    public ImageView V0;
    public b.a.p0.m.s.c W0;
    public BDLocation X0;
    public boolean Y0;
    public ArrayList<String> Z0;
    public float a1;

    /* renamed from: b.a.p0.m.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC0637a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11624e;

        public View$OnClickListenerC0637a(a aVar) {
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
            this.f11624e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f11624e.r3();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements OnGetGeoCoderResultListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11625e;

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
            this.f11625e = aVar;
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
                    this.f11625e.P0.setText(h.unknown_location_info);
                    return;
                }
                if (this.f11625e.Q0 != null && TextUtils.isEmpty(this.f11625e.N0)) {
                    String address = reverseGeoCodeResult.getAddress();
                    a aVar = this.f11625e;
                    if (address == null) {
                        address = aVar.getResources().getString(h.unknown_location_info);
                    }
                    aVar.N0 = address;
                    this.f11625e.Q0.setText(this.f11625e.N0);
                }
                if (this.f11625e.P0 != null && TextUtils.isEmpty(this.f11625e.M0)) {
                    String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                    a aVar2 = this.f11625e;
                    if (sematicDescription == null) {
                        sematicDescription = aVar2.getResources().getString(h.unknown_location_info);
                    }
                    aVar2.M0 = sematicDescription;
                    this.f11625e.P0.setText(this.f11625e.M0);
                }
                b.a.p0.a.e0.d.i("map", "mAddress +" + this.f11625e.N0 + " mName" + this.f11625e.M0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11626e;

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
            this.f11626e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f11626e.e3();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements PopupWindow.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f11627a;

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
            this.f11627a = aVar;
        }

        @Override // com.baidu.swan.menu.PopupWindow.b
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.f11627a;
                aVar.d3(aVar.U0, 1.0f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11628e;

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
            this.f11628e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f11628e.W0 == null || this.f11628e.W0.i() == null) {
                return;
            }
            BDLocation i2 = this.f11628e.W0.i();
            this.f11628e.J0.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(i2.getLatitude(), i2.getLongitude())));
        }
    }

    /* loaded from: classes4.dex */
    public class f implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f11629a;

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
            this.f11629a = aVar;
        }

        @Override // b.a.p0.m.s.c.b
        public void a(BDLocation bDLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bDLocation) == null) {
                this.f11629a.X0 = bDLocation;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-721921627, "Lb/a/p0/m/n/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-721921627, "Lb/a/p0/m/n/a;");
                return;
            }
        }
        boolean z = k.f6863a;
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
        this.K0 = "";
        this.a1 = 0.5f;
    }

    public static a o3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bundle)) == null) {
            a aVar = new a();
            if (bundle != null) {
                aVar.g1(bundle);
            }
            b.a.p0.m.a.a();
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public void J2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.K0);
            b.a.p0.a.g1.f.U().u(new b.a.p0.a.o0.d.c("sharebtn", hashMap));
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void d3(View view, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(1048580, this, view, f2) == null) || view == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view.getRootView();
        ViewGroupOverlay overlay = viewGroup.getOverlay();
        if (Float.valueOf(f2).equals(Float.valueOf(1.0f))) {
            overlay.clear();
            return;
        }
        ColorDrawable colorDrawable = new ColorDrawable(-16777216);
        colorDrawable.setBounds(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
        colorDrawable.setAlpha((int) (f2 * 255.0f));
        overlay.add(colorDrawable);
    }

    public void e3() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (popupWindow = this.S0) != null && popupWindow.x()) {
            this.S0.r();
        }
    }

    public BDLocation f3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.X0 : (BDLocation) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            m3();
            this.p0.s(b.a.p0.a.c1.a.M().a(), E1());
        }
    }

    public boolean g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.Y0 : invokeV.booleanValue;
    }

    public List<String> h3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.Z0 : (List) invokeV.objValue;
    }

    public BaiduMap i3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.J0 : (BaiduMap) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j3(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view) == null) {
            this.U0 = view;
            ImageView imageView = (ImageView) view.findViewById(b.a.p0.m.f.location_icon_path);
            this.O0 = imageView;
            imageView.setOnClickListener(new View$OnClickListenerC0637a(this));
            this.P0 = (TextView) view.findViewById(b.a.p0.m.f.location_text_position);
            this.Q0 = (TextView) view.findViewById(b.a.p0.m.f.location_text_address);
        }
    }

    public final void k3(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            ImageView imageView = (ImageView) view.findViewById(b.a.p0.m.f.goMyPoint);
            this.V0 = imageView;
            imageView.setOnClickListener(new e(this));
        }
    }

    public final void l3(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view) == null) {
            TextureMapView textureMapView = (TextureMapView) view.findViewById(b.a.p0.m.f.bdMapView);
            this.I0 = textureMapView;
            BaiduMap map = textureMapView.getMap();
            this.J0 = map;
            map.getUiSettings().setRotateGesturesEnabled(false);
            this.I0.showZoomControls(false);
            this.J0.getUiSettings().setOverlookingGesturesEnabled(false);
            this.J0.setOnMapLoadedCallback(this);
        }
    }

    public void m3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.p0 == null) {
            this.p0 = new n(getContext(), this.o0, 12, b.a.p0.a.c1.a.K(), new b.a.p0.a.a3.h.b());
            new b.a.p0.a.k1.a(this.p0, this).z();
        }
    }

    public final void n3(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, latLng) == null) {
            this.R0 = GeoCoder.newInstance();
            this.R0.setOnGetGeoCodeResultListener(new b(this));
            this.R0.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        TextureMapView textureMapView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onDestroy();
            GeoCoder geoCoder = this.R0;
            if (geoCoder != null) {
                geoCoder.destroy();
            }
            OpenLocationBottomMenu.resetItemClickFlag();
            b.a.p0.m.s.c cVar = this.W0;
            if (cVar != null) {
                cVar.n(false);
            }
            if (Build.VERSION.SDK_INT <= 19 || (textureMapView = this.I0) == null) {
                return;
            }
            textureMapView.onDestroy();
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            b.a.p0.a.e0.d.i("map", "onMapLoaded");
            p3();
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, marker)) == null) {
            if (marker == this.L0 && !TextUtils.isEmpty(this.M0)) {
                LinearLayout linearLayout = new LinearLayout(AppRuntime.getAppContext());
                linearLayout.setOrientation(1);
                TextView textView = new TextView(AppRuntime.getAppContext());
                textView.setText(this.M0);
                textView.setTextSize(18.0f);
                TextView textView2 = new TextView(AppRuntime.getAppContext());
                textView2.setText(this.N0);
                textView2.setTextSize(15.0f);
                linearLayout.addView(textView);
                linearLayout.addView(textView2);
                this.J0.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void p3() {
        Bundle o;
        TextView textView;
        TextView textView2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (o = o()) == null || o.size() <= 0) {
            return;
        }
        this.K0 = o.getString("slaveId");
        double d2 = o.getDouble("latitude");
        double d3 = o.getDouble("longitude");
        double d4 = o.getDouble("scale");
        this.M0 = o.getString("name");
        this.N0 = o.getString("address");
        LatLng latLng = new LatLng(d2, d3);
        if (TextUtils.isEmpty(this.M0)) {
            if (TextUtils.isEmpty(this.N0)) {
                n3(latLng);
            } else {
                this.M0 = getResources().getString(h.unknown_location_default_name);
            }
        }
        this.J0.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
        this.J0.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d4));
        this.L0 = (Marker) this.J0.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(b.a.p0.m.e.aiapps_location_ding)).title(TextUtils.isEmpty(this.M0) ? "" : this.M0).anchor(0.5f, 0.5f));
        b.a.p0.a.e0.d.i("map", "show marker");
        if (!TextUtils.isEmpty(this.M0) && (textView2 = this.P0) != null) {
            textView2.setText(this.M0);
        }
        if (!TextUtils.isEmpty(this.N0) && (textView = this.Q0) != null) {
            textView.setText(this.N0);
        }
        this.Z0 = o.getStringArrayList("ignoredApps");
    }

    public void q3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.Y0 = z;
        }
    }

    public final void r3() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (activity = getActivity()) == null) {
            return;
        }
        PopupWindow popupWindow = this.S0;
        if (popupWindow == null || !popupWindow.x()) {
            View inflate = View.inflate(activity, g.aiapps_openlocation_pop_menu, null);
            inflate.setOnClickListener(new c(this));
            OpenLocationBottomMenu openLocationBottomMenu = (OpenLocationBottomMenu) inflate.findViewById(b.a.p0.m.f.openlocation_popmenu);
            this.T0 = openLocationBottomMenu;
            openLocationBottomMenu.setFragment(this);
            PopupWindow popupWindow2 = new PopupWindow(activity);
            this.S0 = popupWindow2;
            popupWindow2.L(inflate);
            this.S0.S(-1);
            this.S0.N(-2);
            this.S0.M(true);
            this.S0.Q(true);
            this.S0.B(i.OpenLocationBottomMenuPopupStyle);
            this.S0.U(this.U0, 80, 0, 0);
            this.S0.P(new d(this));
            d3(this.U0, this.a1);
        }
    }

    public void s3() {
        b.a.p0.a.h0.g.g V;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (V = b.a.p0.a.g1.f.U().V()) == null) {
            return;
        }
        g.b i2 = V.i("navigateTo");
        i2.n(b.a.p0.a.h0.g.g.f5478g, b.a.p0.a.h0.g.g.f5480i);
        i2.j(this);
        i2.b();
    }

    public final void t3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            b.a.p0.m.s.c cVar = new b.a.p0.m.s.c(b.a.p0.a.g1.f.U().getActivity(), this.J0);
            this.W0 = cVar;
            cVar.n(true);
            this.W0.k(new f(this));
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048601, this, layoutInflater, viewGroup, bundle)) == null) {
            b.a.p0.a.e0.d.i("map", "start MapLocationFragment");
            View inflate = layoutInflater.inflate(b.a.p0.m.g.ai_apps_map_show_location_fragment, viewGroup, false);
            R1(inflate);
            u2(W1());
            G2(false);
            l3(inflate);
            j3(inflate);
            t3();
            k3(inflate);
            s2(AppRuntime.getAppContext().getResources().getString(h.aiapps_map_open_location_title));
            if (Q1()) {
                inflate = T1(inflate);
            }
            return A1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }
}
