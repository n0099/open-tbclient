package c.a.r0.m.n;

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
import c.a.r0.a.h0.g.g;
import c.a.r0.a.k;
import c.a.r0.m.g;
import c.a.r0.m.h;
import c.a.r0.m.i;
import c.a.r0.m.s.c;
import c.a.r0.n.n;
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
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends c.a.r0.a.h0.g.d implements BaiduMap.OnMapLoadedCallback, BaiduMap.OnMarkerClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextureMapView J0;
    public BaiduMap K0;
    public String L0;
    public Marker M0;
    public String N0;
    public String O0;
    public ImageView P0;
    public TextView Q0;
    public TextView R0;
    public GeoCoder S0;
    public PopupWindow T0;
    public OpenLocationBottomMenu U0;
    public View V0;
    public ImageView W0;
    public c.a.r0.m.s.c X0;
    public BDLocation Y0;
    public boolean Z0;
    public ArrayList<String> a1;
    public float b1;

    /* renamed from: c.a.r0.m.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC0786a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11371e;

        public View$OnClickListenerC0786a(a aVar) {
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
            this.f11371e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f11371e.o3();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements OnGetGeoCoderResultListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11372e;

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
            this.f11372e = aVar;
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
                    this.f11372e.Q0.setText(h.unknown_location_info);
                    return;
                }
                if (this.f11372e.R0 != null && TextUtils.isEmpty(this.f11372e.O0)) {
                    String address = reverseGeoCodeResult.getAddress();
                    a aVar = this.f11372e;
                    if (address == null) {
                        address = aVar.getResources().getString(h.unknown_location_info);
                    }
                    aVar.O0 = address;
                    this.f11372e.R0.setText(this.f11372e.O0);
                }
                if (this.f11372e.Q0 != null && TextUtils.isEmpty(this.f11372e.N0)) {
                    String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                    a aVar2 = this.f11372e;
                    if (sematicDescription == null) {
                        sematicDescription = aVar2.getResources().getString(h.unknown_location_info);
                    }
                    aVar2.N0 = sematicDescription;
                    this.f11372e.Q0.setText(this.f11372e.N0);
                }
                c.a.r0.a.e0.d.i("map", "mAddress +" + this.f11372e.O0 + " mName" + this.f11372e.N0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11373e;

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
            this.f11373e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f11373e.b3();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements PopupWindow.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // com.baidu.swan.menu.PopupWindow.b
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.a;
                aVar.a3(aVar.V0, 1.0f);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11374e;

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
            this.f11374e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f11374e.X0 == null || this.f11374e.X0.i() == null) {
                return;
            }
            BDLocation i2 = this.f11374e.X0.i();
            this.f11374e.K0.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(i2.getLatitude(), i2.getLongitude())));
        }
    }

    /* loaded from: classes6.dex */
    public class f implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // c.a.r0.m.s.c.b
        public void a(BDLocation bDLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bDLocation) == null) {
                this.a.Y0 = bDLocation;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-335266264, "Lc/a/r0/m/n/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-335266264, "Lc/a/r0/m/n/a;");
                return;
            }
        }
        boolean z = k.a;
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
        this.L0 = "";
        this.b1 = 0.5f;
    }

    public static a l3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bundle)) == null) {
            a aVar = new a();
            if (bundle != null) {
                aVar.d1(bundle);
            }
            c.a.r0.m.a.a();
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    @Override // c.a.r0.a.h0.g.d
    public void G2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.L0);
            c.a.r0.a.g1.f.U().u(new c.a.r0.a.o0.d.c("sharebtn", hashMap));
        }
    }

    @Override // c.a.r0.a.h0.g.d
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.a.h0.g.d
    public boolean W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.a.h0.g.d
    public boolean Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void a3(View view, float f2) {
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

    public void b3() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (popupWindow = this.T0) != null && popupWindow.x()) {
            this.T0.r();
        }
    }

    public BDLocation c3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.Y0 : (BDLocation) invokeV.objValue;
    }

    @Override // c.a.r0.a.h0.g.d
    public void d2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            j3();
            this.q0.w(c.a.r0.a.c1.a.M().a(), B1());
        }
    }

    public boolean d3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.Z0 : invokeV.booleanValue;
    }

    public List<String> e3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a1 : (List) invokeV.objValue;
    }

    public BaiduMap f3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.K0 : (BaiduMap) invokeV.objValue;
    }

    public final void g3(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view) == null) {
            this.V0 = view;
            ImageView imageView = (ImageView) view.findViewById(c.a.r0.m.f.location_icon_path);
            this.P0 = imageView;
            imageView.setOnClickListener(new View$OnClickListenerC0786a(this));
            this.Q0 = (TextView) view.findViewById(c.a.r0.m.f.location_text_position);
            this.R0 = (TextView) view.findViewById(c.a.r0.m.f.location_text_address);
        }
    }

    public final void h3(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view) == null) {
            ImageView imageView = (ImageView) view.findViewById(c.a.r0.m.f.goMyPoint);
            this.W0 = imageView;
            imageView.setOnClickListener(new e(this));
        }
    }

    public final void i3(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            TextureMapView textureMapView = (TextureMapView) view.findViewById(c.a.r0.m.f.bdMapView);
            this.J0 = textureMapView;
            BaiduMap map = textureMapView.getMap();
            this.K0 = map;
            map.getUiSettings().setRotateGesturesEnabled(false);
            this.J0.showZoomControls(false);
            this.K0.getUiSettings().setOverlookingGesturesEnabled(false);
            this.K0.setOnMapLoadedCallback(this);
        }
    }

    @Override // c.a.r0.a.h0.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public void j3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.q0 == null) {
            this.q0 = new n(getContext(), this.k0, 12, c.a.r0.a.c1.a.K(), new c.a.r0.a.a3.h.b());
            new c.a.r0.a.k1.a(this.q0, this).z();
        }
    }

    public final void k3(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, latLng) == null) {
            this.S0 = GeoCoder.newInstance();
            this.S0.setOnGetGeoCodeResultListener(new b(this));
            this.S0.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
        }
    }

    public final void m3() {
        Bundle t;
        TextView textView;
        TextView textView2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (t = t()) == null || t.size() <= 0) {
            return;
        }
        this.L0 = t.getString("slaveId");
        double d2 = t.getDouble("latitude");
        double d3 = t.getDouble("longitude");
        double d4 = t.getDouble(AnimationProperty.SCALE);
        this.N0 = t.getString("name");
        this.O0 = t.getString("address");
        LatLng latLng = new LatLng(d2, d3);
        if (TextUtils.isEmpty(this.N0)) {
            if (TextUtils.isEmpty(this.O0)) {
                k3(latLng);
            } else {
                this.N0 = getResources().getString(h.unknown_location_default_name);
            }
        }
        this.K0.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
        this.K0.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d4));
        this.M0 = (Marker) this.K0.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(c.a.r0.m.e.aiapps_location_ding)).title(TextUtils.isEmpty(this.N0) ? "" : this.N0).anchor(0.5f, 0.5f));
        c.a.r0.a.e0.d.i("map", "show marker");
        if (!TextUtils.isEmpty(this.N0) && (textView2 = this.Q0) != null) {
            textView2.setText(this.N0);
        }
        if (!TextUtils.isEmpty(this.O0) && (textView = this.R0) != null) {
            textView.setText(this.O0);
        }
        this.a1 = t.getStringArrayList("ignoredApps");
    }

    public void n3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.Z0 = z;
        }
    }

    public final void o3() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (activity = getActivity()) == null) {
            return;
        }
        PopupWindow popupWindow = this.T0;
        if (popupWindow == null || !popupWindow.x()) {
            View inflate = View.inflate(activity, g.aiapps_openlocation_pop_menu, null);
            inflate.setOnClickListener(new c(this));
            OpenLocationBottomMenu openLocationBottomMenu = (OpenLocationBottomMenu) inflate.findViewById(c.a.r0.m.f.openlocation_popmenu);
            this.U0 = openLocationBottomMenu;
            openLocationBottomMenu.setFragment(this);
            PopupWindow popupWindow2 = new PopupWindow(activity);
            this.T0 = popupWindow2;
            popupWindow2.E(inflate);
            this.T0.L(-1);
            this.T0.G(-2);
            this.T0.F(true);
            this.T0.J(true);
            this.T0.B(i.OpenLocationBottomMenuPopupStyle);
            this.T0.N(this.V0, 80, 0, 0);
            this.T0.I(new d(this));
            a3(this.V0, this.b1);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        TextureMapView textureMapView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onDestroy();
            GeoCoder geoCoder = this.S0;
            if (geoCoder != null) {
                geoCoder.destroy();
            }
            OpenLocationBottomMenu.resetItemClickFlag();
            c.a.r0.m.s.c cVar = this.X0;
            if (cVar != null) {
                cVar.n(false);
            }
            if (Build.VERSION.SDK_INT <= 19 || (textureMapView = this.J0) == null) {
                return;
            }
            textureMapView.onDestroy();
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            c.a.r0.a.e0.d.i("map", "onMapLoaded");
            m3();
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, marker)) == null) {
            if (marker == this.M0 && !TextUtils.isEmpty(this.N0)) {
                LinearLayout linearLayout = new LinearLayout(AppRuntime.getAppContext());
                linearLayout.setOrientation(1);
                TextView textView = new TextView(AppRuntime.getAppContext());
                textView.setText(this.N0);
                textView.setTextSize(18.0f);
                TextView textView2 = new TextView(AppRuntime.getAppContext());
                textView2.setText(this.O0);
                textView2.setTextSize(15.0f);
                linearLayout.addView(textView);
                linearLayout.addView(textView2);
                this.K0.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void p3() {
        c.a.r0.a.h0.g.g V;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (V = c.a.r0.a.g1.f.U().V()) == null) {
            return;
        }
        g.b i2 = V.i("navigateTo");
        i2.n(c.a.r0.a.h0.g.g.f6399g, c.a.r0.a.h0.g.g.f6401i);
        i2.j(this);
        i2.b();
    }

    public final void q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            c.a.r0.m.s.c cVar = new c.a.r0.m.s.c(c.a.r0.a.g1.f.U().getActivity(), this.K0);
            this.X0 = cVar;
            cVar.n(true);
            this.X0.k(new f(this));
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View w0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048601, this, layoutInflater, viewGroup, bundle)) == null) {
            c.a.r0.a.e0.d.i("map", "start MapLocationFragment");
            View inflate = layoutInflater.inflate(c.a.r0.m.g.ai_apps_map_show_location_fragment, viewGroup, false);
            O1(inflate);
            r2(T1());
            D2(false);
            i3(inflate);
            g3(inflate);
            q3();
            h3(inflate);
            p2(AppRuntime.getAppContext().getResources().getString(h.aiapps_map_open_location_title));
            if (N1()) {
                inflate = Q1(inflate);
            }
            return x1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }
}
