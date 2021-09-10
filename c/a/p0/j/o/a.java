package c.a.p0.j.o;

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
import c.a.p0.a.g1.f;
import c.a.p0.a.h0.g.g;
import c.a.p0.a.v2.n0;
import c.a.p0.j.g;
import c.a.p0.j.o.e;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends c.a.p0.a.h0.g.d implements OnGetGeoCoderResultListener, BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapStatusChangeListener, View.OnClickListener, c.a.p0.j.o.b, e.b {
    public static /* synthetic */ Interceptable $ic;
    public static final int a1;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerView C0;
    public FrameLayout D0;
    public ImageView E0;
    public FrameLayout F0;
    public FrameLayout G0;
    public View H0;
    public View I0;
    public TextView J0;
    public ImageView K0;
    public View L0;
    public GeoCoder M0;
    public BaiduMap N0;
    public TextureMapView O0;
    public Marker P0;
    public BitmapDescriptor Q0;
    public c R0;
    public List<c> S0;
    public e T0;
    public LocationDetailAdapter U0;
    public d V0;
    public boolean W0;
    public boolean X0;
    public b Y0;
    public SelectedLocationInfo Z0;

    /* renamed from: c.a.p0.j.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0615a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ReverseGeoCodeResult f11761e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f11762f;

        public RunnableC0615a(a aVar, ReverseGeoCodeResult reverseGeoCodeResult) {
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
            this.f11762f = aVar;
            this.f11761e = reverseGeoCodeResult;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11762f.W2(this.f11761e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(SelectedLocationInfo selectedLocationInfo);

        void onCancel();

        void onError();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1101182296, "Lc/a/p0/j/o/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1101182296, "Lc/a/p0/j/o/a;");
                return;
            }
        }
        a1 = n0.g(20.0f);
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

    public static a M2(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bundle)) == null) {
            a aVar = new a();
            if (bundle != null) {
                aVar.h1(bundle);
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public final void G2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.K0, "translationY", 0.0f, -a1, 0.0f);
            ofFloat.setInterpolator(new AccelerateInterpolator());
            ofFloat.setDuration(500L);
            ofFloat.start();
        }
    }

    public final void H2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Activity activity = this.k0;
            if (activity != null) {
                activity.onBackPressed();
            }
            this.Y0 = null;
        }
    }

    public final void I2(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, latLng) == null) {
            this.M0.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
        }
    }

    @Override // c.a.p0.a.h0.g.d
    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            P2(17);
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void J0(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i2, strArr, iArr) == null) {
            super.J0(i2, strArr, iArr);
            if (i2 == 3001) {
                if (iArr.length > 0 && iArr[0] == -1) {
                    c.a.p0.a.z1.b.f.e.f(f.V().getActivity(), g.aiapps_location_permission_fail).F();
                } else if (iArr.length <= 0 || iArr[0] != 0) {
                } else {
                    U2();
                }
            }
        }
    }

    public final void J2(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            SDKInitializer.setCoordType(CoordType.GCJ02);
            this.S0 = new ArrayList(11);
            this.C0 = (RecyclerView) view.findViewById(c.a.p0.j.e.location_list);
            this.E0 = (ImageView) view.findViewById(c.a.p0.j.e.float_btn);
            this.D0 = (FrameLayout) view.findViewById(c.a.p0.j.e.float_container);
            this.H0 = view.findViewById(c.a.p0.j.e.cancel);
            this.I0 = view.findViewById(c.a.p0.j.e.search);
            this.J0 = (TextView) view.findViewById(c.a.p0.j.e.finish);
            this.K0 = (ImageView) view.findViewById(c.a.p0.j.e.center_ding);
            this.F0 = (FrameLayout) view.findViewById(c.a.p0.j.e.list_container);
            this.G0 = (FrameLayout) view.findViewById(c.a.p0.j.e.map_container);
            this.L0 = view.findViewById(c.a.p0.j.e.loading_progress);
            this.O0 = (TextureMapView) view.findViewById(c.a.p0.j.e.bdMapView);
            this.E0.setOnClickListener(this);
            this.J0.setOnClickListener(this);
            this.I0.setOnClickListener(this);
            this.H0.setOnClickListener(this);
            this.M0 = GeoCoder.newInstance();
            this.N0 = this.O0.getMap();
            this.M0.setOnGetGeoCodeResultListener(this);
            this.N0.setOnMapLoadedCallback(this);
            this.N0.setOnMapStatusChangeListener(this);
            this.C0.setLayoutManager(new LinearLayoutManager(f.V().getActivity()));
            LocationDetailAdapter locationDetailAdapter = new LocationDetailAdapter(f.V().getActivity(), this.C0, this, false);
            this.U0 = locationDetailAdapter;
            this.C0.setAdapter(locationDetailAdapter);
            this.C0.addItemDecoration(new LocationItemDecoration(f.V().getActivity(), true));
            d dVar = new d(this.F0, this.G0, this.D0);
            this.V0 = dVar;
            ((FlipperFrameLayout) this.F0).setViewFlipper(dVar);
        }
    }

    public final void K2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.N0.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
            this.N0.getUiSettings().setRotateGesturesEnabled(false);
            this.O0.showZoomControls(false);
            this.O0.setLogoPosition(LogoPosition.logoPostionRightBottom);
            if (L2()) {
                return;
            }
            U2();
        }
    }

    public final boolean L2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                ArrayList arrayList = new ArrayList();
                if (f.V().getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
                    arrayList.add("android.permission.ACCESS_FINE_LOCATION");
                }
                if (arrayList.size() > 0) {
                    f1((String[]) arrayList.toArray(new String[arrayList.size()]), 0);
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void N2(LatLng latLng, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{latLng, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            S2(true);
            I2(latLng);
            O2();
            if (z) {
                G2();
                if (this.V0.d()) {
                    this.V0.e(false);
                }
            }
            if (z2) {
                this.C0.smoothScrollToPosition(0);
            }
        }
    }

    @Override // c.a.p0.a.h0.g.d
    public void O1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
        }
    }

    public final void O2() {
        Marker marker;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (marker = this.P0) == null) {
            return;
        }
        marker.remove();
        this.P0 = null;
    }

    public final void P2(int i2) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (bVar = this.Y0) == null) {
            return;
        }
        switch (i2) {
            case 16:
                c cVar = this.R0;
                if (cVar != null) {
                    PoiInfo poiInfo = cVar.f11763a;
                    if (TextUtils.equals(poiInfo.name, "[位置]")) {
                        poiInfo.name = "";
                    }
                    this.Y0.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
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

    public final void Q2(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || this.E0 == null) {
            return;
        }
        this.E0.setImageResource(z ? c.a.p0.j.d.aiapps_location_go_my_point_selected : c.a.p0.j.d.aiapps_location_go_my_point);
    }

    public void R2(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.Y0 = bVar;
        }
    }

    public final void S2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (z) {
                this.S0.clear();
                this.U0.setData(this.S0);
            }
            this.L0.setVisibility(z ? 0 : 8);
        }
    }

    public void T2() {
        c.a.p0.a.h0.g.g W;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (W = f.V().W()) == null) {
            return;
        }
        g.b i2 = W.i("navigateTo");
        i2.n(c.a.p0.a.h0.g.g.f5928g, c.a.p0.a.h0.g.g.f5930i);
        i2.j(this);
        i2.b();
    }

    public final void U2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            e eVar = new e(f.V().getActivity(), this.N0);
            this.T0 = eVar;
            eVar.n(true);
            this.T0.k(this);
            S2(true);
        }
    }

    @Override // c.a.p0.a.h0.g.d
    public boolean V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void V2(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, cVar) == null) || cVar == null || cVar.f11763a == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("city", cVar.f11763a.city);
        c.a.p0.j.o.g.a N2 = c.a.p0.j.o.g.a.N2(bundle);
        N2.j1(this, 1);
        N2.T2();
    }

    public final void W2(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, reverseGeoCodeResult) == null) {
            PoiInfo poiInfo = new PoiInfo();
            SelectedLocationInfo selectedLocationInfo = this.Z0;
            if (selectedLocationInfo != null) {
                poiInfo.name = selectedLocationInfo.mName;
                SelectedLocationInfo selectedLocationInfo2 = this.Z0;
                poiInfo.location = new LatLng(selectedLocationInfo2.mLatitude, selectedLocationInfo2.mLongitude);
                poiInfo.address = this.Z0.mAddress;
                this.Z0 = null;
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
            this.S0.clear();
            this.S0.add(cVar);
            this.S0.addAll(c.a(reverseGeoCodeResult.getPoiList()));
            this.U0.setData(this.S0);
            this.R0 = cVar;
            if (this.S0.size() > 0) {
                S2(false);
            }
        }
    }

    @Override // c.a.p0.a.h0.g.d
    public boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.j.o.e.b
    public void a(BDLocation bDLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bDLocation) == null) {
            I2(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
        }
    }

    @Override // c.a.p0.j.o.b
    public void c(c cVar) {
        PoiInfo poiInfo;
        LatLng latLng;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, cVar) == null) || cVar == null || (poiInfo = cVar.f11763a) == null || (latLng = poiInfo.location) == null) {
            return;
        }
        this.R0 = cVar;
        this.N0.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
        O2();
        if (this.Q0 == null) {
            this.Q0 = BitmapDescriptorFactory.fromResource(c.a.p0.j.d.aiapps_location_selected);
        }
        if (!cVar.f11765c) {
            this.P0 = (Marker) this.N0.addOverlay(new MarkerOptions().position(cVar.f11763a.location).zIndex(88).icon(this.Q0));
        }
        if (cVar.f11765c) {
            return;
        }
        Q2(false);
    }

    @Override // c.a.p0.a.h0.g.d
    public void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
        }
    }

    @Override // c.a.p0.a.h0.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, view) == null) {
            if (view.getId() == c.a.p0.j.e.float_btn) {
                e eVar = this.T0;
                if (eVar == null || eVar.i() == null) {
                    return;
                }
                BDLocation i2 = this.T0.i();
                LatLng latLng = new LatLng(i2.getLatitude(), i2.getLongitude());
                this.N0.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                O2();
                if (this.X0) {
                    N2(latLng, true, true);
                    this.X0 = false;
                }
                Q2(true);
            } else if (view.getId() == c.a.p0.j.e.finish) {
                P2(16);
                H2();
            } else if (view.getId() == c.a.p0.j.e.search) {
                V2(this.R0);
            } else if (view.getId() == c.a.p0.j.e.cancel) {
                P2(17);
                H2();
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onDestroy();
            if (Build.VERSION.SDK_INT > 19) {
                this.O0.onDestroy();
            }
            this.M0.destroy();
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, geoCodeResult) == null) {
        }
    }

    @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
    public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, reverseGeoCodeResult) == null) && reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
            this.C0.postDelayed(new RunnableC0615a(this, reverseGeoCodeResult), 150L);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            I2(this.N0.getMapStatus().target);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChange(MapStatus mapStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, mapStatus) == null) {
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, mapStatus) == null) && this.W0) {
            N2(mapStatus.target, true, true);
            Q2(false);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, mapStatus) == null) {
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048609, this, mapStatus, i2) == null) {
            boolean z = false;
            boolean z2 = i2 == 1;
            this.W0 = z2;
            this.X0 = (z2 || this.X0) ? true : true;
        }
    }

    @Override // c.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.onPause();
            this.O0.onPause();
            e eVar = this.T0;
            if (eVar != null) {
                eVar.n(false);
            }
        }
    }

    @Override // c.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onResume();
            this.O0.onResume();
            e eVar = this.T0;
            if (eVar != null) {
                eVar.n(true);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void t0(int i2, int i3, Intent intent) {
        SelectedLocationInfo selectedLocationInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048612, this, i2, i3, intent) == null) {
            super.t0(i2, i3, intent);
            if (intent == null || i2 != 1 || (selectedLocationInfo = (SelectedLocationInfo) intent.getParcelableExtra(SelectedLocationInfo.LOCATION_KEY)) == null) {
                return;
            }
            double d2 = selectedLocationInfo.mLatitude;
            double d3 = selectedLocationInfo.mLongitude;
            if (Double.isNaN(d2) || Double.isNaN(d3)) {
                return;
            }
            this.Z0 = selectedLocationInfo;
            LatLng latLng = new LatLng(d2, d3);
            this.N0.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.X0 = true;
            N2(latLng, false, true);
            Q2(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048613, this, layoutInflater, viewGroup, bundle)) == null) {
            c.a.p0.j.a.a();
            View inflate = layoutInflater.inflate(c.a.p0.j.f.ai_apps_location_choose, viewGroup, false);
            J2(inflate);
            K2();
            if (N1()) {
                inflate = Q1(inflate);
                s1(-1);
            }
            return y1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }
}
