package c.a.q0.m.p;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.q0.a.g1.f;
import c.a.q0.a.h0.g.g;
import c.a.q0.a.z2.n0;
import c.a.q0.m.g;
import c.a.q0.m.h;
import c.a.q0.m.p.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.LogoPosition;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.swan.map.location.FlipperFrameLayout;
import com.baidu.swan.map.location.LocationDetailAdapter;
import com.baidu.swan.map.location.LocationItemDecoration;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.s;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends c.a.q0.a.h0.g.d implements OnGetGeoCoderResultListener, BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapStatusChangeListener, View.OnClickListener, c.a.q0.m.p.b, e.b {
    public static /* synthetic */ Interceptable $ic;
    public static final int h1;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerView J0;
    public FrameLayout K0;
    public ImageView L0;
    public FrameLayout M0;
    public FrameLayout N0;
    public View O0;
    public View P0;
    public TextView Q0;
    public ImageView R0;
    public View S0;
    public GeoCoder T0;
    public BaiduMap U0;
    public TextureMapView V0;
    public Marker W0;
    public BitmapDescriptor X0;
    public c Y0;
    public List<c> Z0;
    public e a1;
    public LocationDetailAdapter b1;
    public d c1;
    public boolean d1;
    public boolean e1;
    public b f1;
    public SelectedLocationInfo g1;

    /* renamed from: c.a.q0.m.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC0729a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ReverseGeoCodeResult f10916e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f10917f;

        public RunnableC0729a(a aVar, ReverseGeoCodeResult reverseGeoCodeResult) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, reverseGeoCodeResult};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10917f = aVar;
            this.f10916e = reverseGeoCodeResult;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10917f.m3(this.f10916e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(SelectedLocationInfo selectedLocationInfo);

        void onCancel();

        void onError();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1472247781, "Lc/a/q0/m/p/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1472247781, "Lc/a/q0/m/p/a;");
                return;
            }
        }
        h1 = n0.g(20.0f);
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
            }
        }
    }

    public static a c3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bundle)) == null) {
            a aVar = new a();
            if (bundle != null) {
                aVar.k1(bundle);
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View D0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            c.a.q0.m.a.a();
            View inflate = layoutInflater.inflate(g.ai_apps_location_choose, viewGroup, false);
            Z2(inflate);
            a3();
            if (U1()) {
                inflate = X1(inflate);
                x1(-1);
            }
            return E1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // c.a.q0.a.h0.g.d
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            f3(17);
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void N0(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, strArr, iArr) == null) {
            super.N0(i2, strArr, iArr);
            if (i2 == 3001) {
                if (iArr.length > 0 && iArr[0] == -1) {
                    c.a.q0.a.c2.b.f.e.f(f.U().getActivity(), h.aiapps_location_permission_fail).G();
                } else if (iArr.length <= 0 || iArr[0] != 0) {
                } else {
                    k3();
                }
            }
        }
    }

    @Override // c.a.q0.a.h0.g.d
    public void V1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    public final void W2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.R0, AnimationProperty.TRANSLATE_Y, 0.0f, -h1, 0.0f);
            ofFloat.setInterpolator(new AccelerateInterpolator());
            ofFloat.setDuration(500L);
            ofFloat.start();
        }
    }

    public final void X2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Activity activity = this.g0;
            if (activity != null) {
                activity.onBackPressed();
            }
            this.f1 = null;
        }
    }

    public final void Y2(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, latLng) == null) {
            this.T0.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
        }
    }

    public final void Z2(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            SDKInitializer.setCoordType(CoordType.GCJ02);
            this.Z0 = new ArrayList(11);
            this.J0 = (RecyclerView) view.findViewById(c.a.q0.m.f.location_list);
            this.L0 = (ImageView) view.findViewById(c.a.q0.m.f.float_btn);
            this.K0 = (FrameLayout) view.findViewById(c.a.q0.m.f.float_container);
            this.O0 = view.findViewById(c.a.q0.m.f.cancel);
            this.P0 = view.findViewById(c.a.q0.m.f.search);
            this.Q0 = (TextView) view.findViewById(c.a.q0.m.f.finish);
            this.R0 = (ImageView) view.findViewById(c.a.q0.m.f.center_ding);
            this.M0 = (FrameLayout) view.findViewById(c.a.q0.m.f.list_container);
            this.N0 = (FrameLayout) view.findViewById(c.a.q0.m.f.map_container);
            this.S0 = view.findViewById(c.a.q0.m.f.loading_progress);
            this.V0 = (TextureMapView) view.findViewById(c.a.q0.m.f.bdMapView);
            this.L0.setOnClickListener(this);
            this.Q0.setOnClickListener(this);
            this.P0.setOnClickListener(this);
            this.O0.setOnClickListener(this);
            this.T0 = GeoCoder.newInstance();
            this.U0 = this.V0.getMap();
            this.T0.setOnGetGeoCodeResultListener(this);
            this.U0.setOnMapLoadedCallback(this);
            this.U0.setOnMapStatusChangeListener(this);
            this.J0.setLayoutManager(new LinearLayoutManager(f.U().getActivity()));
            LocationDetailAdapter locationDetailAdapter = new LocationDetailAdapter(f.U().getActivity(), this.J0, this, false);
            this.b1 = locationDetailAdapter;
            this.J0.setAdapter(locationDetailAdapter);
            this.J0.addItemDecoration(new LocationItemDecoration(f.U().getActivity(), true));
            d dVar = new d(this.M0, this.N0, this.K0);
            this.c1 = dVar;
            ((FlipperFrameLayout) this.M0).setViewFlipper(dVar);
        }
    }

    @Override // c.a.q0.m.p.e.b
    public void a(BDLocation bDLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bDLocation) == null) {
            Y2(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
        }
    }

    public final void a3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.U0.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
            this.U0.getUiSettings().setRotateGesturesEnabled(false);
            this.V0.showZoomControls(false);
            this.V0.setLogoPosition(LogoPosition.logoPostionRightBottom);
            if (b3()) {
                return;
            }
            k3();
        }
    }

    public final boolean b3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                ArrayList arrayList = new ArrayList();
                if (f.U().getActivity().checkSelfPermission(s.f57423g) != 0) {
                    arrayList.add(s.f57423g);
                }
                if (arrayList.size() > 0) {
                    requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), 0);
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.q0.m.p.b
    public void d(c cVar) {
        PoiInfo poiInfo;
        LatLng latLng;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) || cVar == null || (poiInfo = cVar.a) == null || (latLng = poiInfo.location) == null) {
            return;
        }
        this.Y0 = cVar;
        this.U0.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
        e3();
        if (this.X0 == null) {
            this.X0 = BitmapDescriptorFactory.fromResource(c.a.q0.m.e.aiapps_location_selected);
        }
        if (!cVar.f10919c) {
            this.W0 = (Marker) this.U0.addOverlay(new MarkerOptions().position(cVar.a.location).zIndex(88).icon(this.X0));
        }
        if (cVar.f10919c) {
            return;
        }
        g3(false);
    }

    @Override // c.a.q0.a.h0.g.d
    public boolean d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void d3(LatLng latLng, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{latLng, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            i3(true);
            Y2(latLng);
            e3();
            if (z) {
                W2();
                if (this.c1.d()) {
                    this.c1.e(false);
                }
            }
            if (z2) {
                this.J0.smoothScrollToPosition(0);
            }
        }
    }

    public final void e3() {
        Marker marker;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (marker = this.W0) == null) {
            return;
        }
        marker.remove();
        this.W0 = null;
    }

    @Override // c.a.q0.a.h0.g.d
    public boolean f2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void f3(int i2) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i2) == null) || (bVar = this.f1) == null) {
            return;
        }
        switch (i2) {
            case 16:
                c cVar = this.Y0;
                if (cVar != null) {
                    PoiInfo poiInfo = cVar.a;
                    if (TextUtils.equals(poiInfo.name, "[位置]")) {
                        poiInfo.name = "";
                    }
                    this.f1.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
                    return;
                }
                return;
            case 17:
                bVar.onCancel();
                return;
            case 18:
                bVar.onError();
                return;
            default:
                return;
        }
    }

    public final void g3(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || this.L0 == null) {
            return;
        }
        this.L0.setImageResource(z ? c.a.q0.m.e.aiapps_location_go_my_point_selected : c.a.q0.m.e.aiapps_location_go_my_point);
    }

    public void h3(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            this.f1 = bVar;
        }
    }

    public final void i3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            if (z) {
                this.Z0.clear();
                this.b1.setData(this.Z0);
            }
            this.S0.setVisibility(z ? 0 : 8);
        }
    }

    @Override // c.a.q0.a.h0.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public void j3() {
        c.a.q0.a.h0.g.g V;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (V = f.U().V()) == null) {
            return;
        }
        g.b i2 = V.i("navigateTo");
        i2.n(c.a.q0.a.h0.g.g.f5805g, c.a.q0.a.h0.g.g.f5807i);
        i2.j(this);
        i2.b();
    }

    @Override // c.a.q0.a.h0.g.d
    public void k2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
        }
    }

    public final void k3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            e eVar = new e(f.U().getActivity(), this.U0);
            this.a1 = eVar;
            eVar.n(true);
            this.a1.k(this);
            i3(true);
        }
    }

    public final void l3(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, cVar) == null) || cVar == null || cVar.a == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("city", cVar.a.city);
        c.a.q0.m.p.g.a d3 = c.a.q0.m.p.g.a.d3(bundle);
        d3.m1(this, 1);
        d3.j3();
    }

    public final void m3(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, reverseGeoCodeResult) == null) {
            PoiInfo poiInfo = new PoiInfo();
            SelectedLocationInfo selectedLocationInfo = this.g1;
            if (selectedLocationInfo != null) {
                poiInfo.name = selectedLocationInfo.mName;
                SelectedLocationInfo selectedLocationInfo2 = this.g1;
                poiInfo.location = new LatLng(selectedLocationInfo2.mLatitude, selectedLocationInfo2.mLongitude);
                poiInfo.address = this.g1.mAddress;
                this.g1 = null;
                z = false;
            } else {
                String address = reverseGeoCodeResult.getAddress();
                String sematicDescription = reverseGeoCodeResult.getSematicDescription();
                if (TextUtils.isEmpty(address)) {
                    address = "[位置]";
                }
                poiInfo.name = address;
                poiInfo.location = reverseGeoCodeResult.getLocation();
                poiInfo.address = sematicDescription;
                ReverseGeoCodeResult.AddressComponent addressDetail = reverseGeoCodeResult.getAddressDetail();
                if (addressDetail != null) {
                    poiInfo.city = addressDetail.city;
                }
                z = true;
            }
            c cVar = new c(poiInfo, true, z);
            this.Z0.clear();
            this.Z0.add(cVar);
            this.Z0.addAll(c.a(reverseGeoCodeResult.getPoiList()));
            this.b1.setData(this.Z0);
            this.Y0 = cVar;
            if (this.Z0.size() > 0) {
                i3(false);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, view) == null) {
            if (view.getId() == c.a.q0.m.f.float_btn) {
                e eVar = this.a1;
                if (eVar == null || eVar.i() == null) {
                    return;
                }
                BDLocation i2 = this.a1.i();
                LatLng latLng = new LatLng(i2.getLatitude(), i2.getLongitude());
                this.U0.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                e3();
                if (this.e1) {
                    d3(latLng, true, true);
                    this.e1 = false;
                }
                g3(true);
            } else if (view.getId() == c.a.q0.m.f.finish) {
                f3(16);
                X2();
            } else if (view.getId() == c.a.q0.m.f.search) {
                l3(this.Y0);
            } else if (view.getId() == c.a.q0.m.f.cancel) {
                f3(17);
                X2();
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onDestroy();
            if (Build.VERSION.SDK_INT > 19) {
                this.V0.onDestroy();
            }
            this.T0.destroy();
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, geoCodeResult) == null) {
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, reverseGeoCodeResult) == null) && reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.J0.postDelayed(new RunnableC0729a(this, reverseGeoCodeResult), 150L);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            Y2(this.U0.getMapStatus().target);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChange(MapStatus mapStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, mapStatus) == null) {
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, mapStatus) == null) && this.d1) {
            d3(mapStatus.target, true, true);
            g3(false);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, mapStatus) == null) {
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048610, this, mapStatus, i2) == null) {
            boolean z = false;
            boolean z2 = i2 == 1;
            this.d1 = z2;
            this.e1 = (z2 || this.e1) ? true : true;
        }
    }

    @Override // c.a.q0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onPause();
            this.V0.onPause();
            e eVar = this.a1;
            if (eVar != null) {
                eVar.n(false);
            }
        }
    }

    @Override // c.a.q0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            super.onResume();
            this.V0.onResume();
            e eVar = this.a1;
            if (eVar != null) {
                eVar.n(true);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void x0(int i2, int i3, Intent intent) {
        SelectedLocationInfo selectedLocationInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048613, this, i2, i3, intent) == null) {
            super.x0(i2, i3, intent);
            if (intent == null || i2 != 1 || (selectedLocationInfo = (SelectedLocationInfo) intent.getParcelableExtra(SelectedLocationInfo.LOCATION_KEY)) == null) {
                return;
            }
            double d2 = selectedLocationInfo.mLatitude;
            double d3 = selectedLocationInfo.mLongitude;
            if (Double.isNaN(d2) || Double.isNaN(d3)) {
                return;
            }
            this.g1 = selectedLocationInfo;
            LatLng latLng = new LatLng(d2, d3);
            this.U0.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.e1 = true;
            d3(latLng, false, true);
            g3(false);
        }
    }
}
