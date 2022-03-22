package c.a.n0.m.h;

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
import c.a.n0.a.x.g.g;
import c.a.n0.m.m.c;
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
import com.baidu.tieba.R;
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
/* loaded from: classes2.dex */
public class a extends c.a.n0.a.x.g.d implements BaiduMap.OnMapLoadedCallback, BaiduMap.OnMarkerClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextureMapView F0;
    public BaiduMap G0;
    public String H0;
    public Marker I0;
    public String J0;
    public String K0;
    public ImageView L0;
    public TextView M0;
    public TextView N0;
    public GeoCoder O0;
    public PopupWindow P0;
    public OpenLocationBottomMenu Q0;
    public View R0;
    public ImageView S0;
    public c.a.n0.m.m.c T0;
    public BDLocation U0;
    public boolean V0;
    public ArrayList<String> W0;
    public float X0;

    /* renamed from: c.a.n0.m.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC0746a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public View$OnClickListenerC0746a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.s3();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements OnGetGeoCoderResultListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
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
                    this.a.M0.setText(R.string.obfuscated_res_0x7f0f147e);
                    return;
                }
                if (this.a.N0 != null && TextUtils.isEmpty(this.a.K0)) {
                    String address = reverseGeoCodeResult.getAddress();
                    a aVar = this.a;
                    if (address == null) {
                        address = aVar.getResources().getString(R.string.obfuscated_res_0x7f0f147e);
                    }
                    aVar.K0 = address;
                    this.a.N0.setText(this.a.K0);
                }
                if (this.a.M0 != null && TextUtils.isEmpty(this.a.J0)) {
                    String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                    a aVar2 = this.a;
                    if (sematicDescription == null) {
                        sematicDescription = aVar2.getResources().getString(R.string.obfuscated_res_0x7f0f147e);
                    }
                    aVar2.J0 = sematicDescription;
                    this.a.M0.setText(this.a.J0);
                }
                c.a.n0.a.u.d.i("map", "mAddress +" + this.a.K0 + " mName" + this.a.J0);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.f3();
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                aVar.e3(aVar.R0, 1.0f);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.T0 == null || this.a.T0.i() == null) {
                return;
            }
            BDLocation i = this.a.T0.i();
            this.a.G0.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(i.getLatitude(), i.getLongitude())));
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.n0.m.m.c.b
        public void a(BDLocation bDLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bDLocation) == null) {
                this.a.U0 = bDLocation;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1695561750, "Lc/a/n0/m/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1695561750, "Lc/a/n0/m/h/a;");
                return;
            }
        }
        boolean z = c.a.n0.a.a.a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.H0 = "";
        this.X0 = 0.5f;
    }

    public static a p3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bundle)) == null) {
            a aVar = new a();
            if (bundle != null) {
                aVar.h1(bundle);
            }
            c.a.n0.m.a.a();
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    @Override // c.a.n0.a.x.g.d
    public void K2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.H0);
            c.a.n0.a.w0.f.U().u(new c.a.n0.a.e0.d.c("sharebtn", hashMap));
        }
    }

    @Override // c.a.n0.a.x.g.d
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.a.x.g.d
    public boolean a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.a.x.g.d
    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void e3(View view, float f2) {
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

    public void f3() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (popupWindow = this.P0) != null && popupWindow.x()) {
            this.P0.r();
        }
    }

    public BDLocation g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.U0 : (BDLocation) invokeV.objValue;
    }

    @Override // c.a.n0.a.x.g.d
    public void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            n3();
            this.m0.t(c.a.n0.a.s0.a.M().a(), F1());
        }
    }

    public boolean h3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.V0 : invokeV.booleanValue;
    }

    public List<String> i3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.W0 : (List) invokeV.objValue;
    }

    @Override // c.a.n0.a.x.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public BaiduMap j3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.G0 : (BaiduMap) invokeV.objValue;
    }

    public final void k3(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view) == null) {
            this.R0 = view;
            ImageView imageView = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f091329);
            this.L0 = imageView;
            imageView.setOnClickListener(new View$OnClickListenerC0746a(this));
            this.M0 = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09132f);
            this.N0 = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09132e);
        }
    }

    public final void l3(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090cbe);
            this.S0 = imageView;
            imageView.setOnClickListener(new e(this));
        }
    }

    public final void m3(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view) == null) {
            TextureMapView textureMapView = (TextureMapView) view.findViewById(R.id.obfuscated_res_0x7f090339);
            this.F0 = textureMapView;
            BaiduMap map = textureMapView.getMap();
            this.G0 = map;
            map.getUiSettings().setRotateGesturesEnabled(false);
            this.F0.showZoomControls(false);
            this.G0.getUiSettings().setOverlookingGesturesEnabled(false);
            this.G0.setOnMapLoadedCallback(this);
        }
    }

    public void n3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.m0 == null) {
            this.m0 = new c.a.n0.n.f(getContext(), this.l0, 12, c.a.n0.a.s0.a.K(), new c.a.n0.a.q2.h.b());
            new c.a.n0.a.a1.a(this.m0, this).z();
        }
    }

    public final void o3(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, latLng) == null) {
            this.O0 = GeoCoder.newInstance();
            this.O0.setOnGetGeoCodeResultListener(new b(this));
            this.O0.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            c.a.n0.a.u.d.i("map", "onMapLoaded");
            q3();
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, marker)) == null) {
            if (marker == this.I0 && !TextUtils.isEmpty(this.J0)) {
                LinearLayout linearLayout = new LinearLayout(AppRuntime.getAppContext());
                linearLayout.setOrientation(1);
                TextView textView = new TextView(AppRuntime.getAppContext());
                textView.setText(this.J0);
                textView.setTextSize(18.0f);
                TextView textView2 = new TextView(AppRuntime.getAppContext());
                textView2.setText(this.K0);
                textView2.setTextSize(15.0f);
                linearLayout.addView(textView);
                linearLayout.addView(textView2);
                this.G0.showInfoWindow(new InfoWindow(BitmapDescriptorFactory.fromView(linearLayout), marker.getPosition(), -60, null));
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void q3() {
        Bundle p;
        TextView textView;
        TextView textView2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (p = p()) == null || p.size() <= 0) {
            return;
        }
        this.H0 = p.getString("slaveId");
        double d2 = p.getDouble("latitude");
        double d3 = p.getDouble("longitude");
        double d4 = p.getDouble(AnimationProperty.SCALE);
        this.J0 = p.getString("name");
        this.K0 = p.getString("address");
        LatLng latLng = new LatLng(d2, d3);
        if (TextUtils.isEmpty(this.J0)) {
            if (TextUtils.isEmpty(this.K0)) {
                o3(latLng);
            } else {
                this.J0 = getResources().getString(R.string.obfuscated_res_0x7f0f147d);
            }
        }
        this.G0.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
        this.G0.setMapStatus(MapStatusUpdateFactory.zoomTo((float) d4));
        this.I0 = (Marker) this.G0.addOverlay(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.obfuscated_res_0x7f08018c)).title(TextUtils.isEmpty(this.J0) ? "" : this.J0).anchor(0.5f, 0.5f));
        c.a.n0.a.u.d.i("map", "show marker");
        if (!TextUtils.isEmpty(this.J0) && (textView2 = this.M0) != null) {
            textView2.setText(this.J0);
        }
        if (!TextUtils.isEmpty(this.K0) && (textView = this.N0) != null) {
            textView.setText(this.K0);
        }
        this.W0 = p.getStringArrayList("ignoredApps");
    }

    public void r3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.V0 = z;
        }
    }

    public final void s3() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (activity = getActivity()) == null) {
            return;
        }
        PopupWindow popupWindow = this.P0;
        if (popupWindow == null || !popupWindow.x()) {
            View inflate = View.inflate(activity, R.layout.obfuscated_res_0x7f0d00c4, null);
            inflate.setOnClickListener(new c(this));
            OpenLocationBottomMenu openLocationBottomMenu = (OpenLocationBottomMenu) inflate.findViewById(R.id.obfuscated_res_0x7f09160a);
            this.Q0 = openLocationBottomMenu;
            openLocationBottomMenu.setFragment(this);
            PopupWindow popupWindow2 = new PopupWindow(activity);
            this.P0 = popupWindow2;
            popupWindow2.E(inflate);
            this.P0.L(-1);
            this.P0.G(-2);
            this.P0.F(true);
            this.P0.J(true);
            this.P0.B(R.style.obfuscated_res_0x7f10013b);
            this.P0.N(this.R0, 80, 0, 0);
            this.P0.I(new d(this));
            e3(this.R0, this.X0);
        }
    }

    public void t3() {
        g V;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (V = c.a.n0.a.w0.f.U().V()) == null) {
            return;
        }
        g.b i = V.i("navigateTo");
        i.n(g.f7048g, g.i);
        i.j(this);
        i.b();
    }

    public final void u3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            c.a.n0.m.m.c cVar = new c.a.n0.m.m.c(c.a.n0.a.w0.f.U().getActivity(), this.G0);
            this.T0 = cVar;
            cVar.n(true);
            this.T0.k(new f(this));
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View x0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048600, this, layoutInflater, viewGroup, bundle)) == null) {
            c.a.n0.a.u.d.i("map", "start MapLocationFragment");
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d008c, viewGroup, false);
            S1(inflate);
            v2(X1());
            H2(false);
            m3(inflate);
            k3(inflate);
            u3();
            l3(inflate);
            t2(AppRuntime.getAppContext().getResources().getString(R.string.obfuscated_res_0x7f0f0194));
            if (R1()) {
                inflate = U1(inflate);
            }
            return B1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void y0() {
        TextureMapView textureMapView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.y0();
            GeoCoder geoCoder = this.O0;
            if (geoCoder != null) {
                geoCoder.destroy();
            }
            OpenLocationBottomMenu.l();
            c.a.n0.m.m.c cVar = this.T0;
            if (cVar != null) {
                cVar.n(false);
            }
            if (Build.VERSION.SDK_INT <= 19 || (textureMapView = this.F0) == null) {
                return;
            }
            textureMapView.onDestroy();
        }
    }
}
