package b.a.p0.m.p;

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
import b.a.p0.a.g1.f;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.z2.n0;
import b.a.p0.m.h;
import b.a.p0.m.p.e;
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
/* loaded from: classes4.dex */
public class a extends b.a.p0.a.h0.g.d implements OnGetGeoCoderResultListener, BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapStatusChangeListener, View.OnClickListener, b.a.p0.m.p.b, e.b {
    public static /* synthetic */ Interceptable $ic;
    public static final int g1;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerView I0;
    public FrameLayout J0;
    public ImageView K0;
    public FrameLayout L0;
    public FrameLayout M0;
    public View N0;
    public View O0;
    public TextView P0;
    public ImageView Q0;
    public View R0;
    public GeoCoder S0;
    public BaiduMap T0;
    public TextureMapView U0;
    public Marker V0;
    public BitmapDescriptor W0;
    public c X0;
    public List<c> Y0;
    public e Z0;
    public LocationDetailAdapter a1;
    public d b1;
    public boolean c1;
    public boolean d1;
    public b e1;
    public SelectedLocationInfo f1;

    /* renamed from: b.a.p0.m.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC0639a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ReverseGeoCodeResult f11645e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f11646f;

        public RunnableC0639a(a aVar, ReverseGeoCodeResult reverseGeoCodeResult) {
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
            this.f11646f = aVar;
            this.f11645e = reverseGeoCodeResult;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11646f.i3(this.f11645e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(SelectedLocationInfo selectedLocationInfo);

        void onCancel();

        void onError();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-721862045, "Lb/a/p0/m/p/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-721862045, "Lb/a/p0/m/p/a;");
                return;
            }
        }
        g1 = n0.g(20.0f);
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

    public static a Y2(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bundle)) == null) {
            a aVar = new a();
            if (bundle != null) {
                aVar.g1(bundle);
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void J0(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i2, strArr, iArr) == null) {
            super.J0(i2, strArr, iArr);
            if (i2 == 3001) {
                if (iArr.length > 0 && iArr[0] == -1) {
                    b.a.p0.a.c2.b.f.e.f(f.U().getActivity(), h.aiapps_location_permission_fail).G();
                } else if (iArr.length <= 0 || iArr[0] != 0) {
                } else {
                    g3();
                }
            }
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b3(17);
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public void R1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
        }
    }

    public final void S2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.Q0, "translationY", 0.0f, -g1, 0.0f);
            ofFloat.setInterpolator(new AccelerateInterpolator());
            ofFloat.setDuration(500L);
            ofFloat.start();
        }
    }

    public final void T2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Activity activity = this.l0;
            if (activity != null) {
                activity.onBackPressed();
            }
            this.e1 = null;
        }
    }

    public final void U2(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, latLng) == null) {
            this.S0.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1));
        }
    }

    public final void V2(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            SDKInitializer.setCoordType(CoordType.GCJ02);
            this.Y0 = new ArrayList(11);
            this.I0 = (RecyclerView) view.findViewById(b.a.p0.m.f.location_list);
            this.K0 = (ImageView) view.findViewById(b.a.p0.m.f.float_btn);
            this.J0 = (FrameLayout) view.findViewById(b.a.p0.m.f.float_container);
            this.N0 = view.findViewById(b.a.p0.m.f.cancel);
            this.O0 = view.findViewById(b.a.p0.m.f.search);
            this.P0 = (TextView) view.findViewById(b.a.p0.m.f.finish);
            this.Q0 = (ImageView) view.findViewById(b.a.p0.m.f.center_ding);
            this.L0 = (FrameLayout) view.findViewById(b.a.p0.m.f.list_container);
            this.M0 = (FrameLayout) view.findViewById(b.a.p0.m.f.map_container);
            this.R0 = view.findViewById(b.a.p0.m.f.loading_progress);
            this.U0 = (TextureMapView) view.findViewById(b.a.p0.m.f.bdMapView);
            this.K0.setOnClickListener(this);
            this.P0.setOnClickListener(this);
            this.O0.setOnClickListener(this);
            this.N0.setOnClickListener(this);
            this.S0 = GeoCoder.newInstance();
            this.T0 = this.U0.getMap();
            this.S0.setOnGetGeoCodeResultListener(this);
            this.T0.setOnMapLoadedCallback(this);
            this.T0.setOnMapStatusChangeListener(this);
            this.I0.setLayoutManager(new LinearLayoutManager(f.U().getActivity()));
            LocationDetailAdapter locationDetailAdapter = new LocationDetailAdapter(f.U().getActivity(), this.I0, this, false);
            this.a1 = locationDetailAdapter;
            this.I0.setAdapter(locationDetailAdapter);
            this.I0.addItemDecoration(new LocationItemDecoration(f.U().getActivity(), true));
            d dVar = new d(this.L0, this.M0, this.J0);
            this.b1 = dVar;
            ((FlipperFrameLayout) this.L0).setViewFlipper(dVar);
        }
    }

    public final void W2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.T0.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0f));
            this.T0.getUiSettings().setRotateGesturesEnabled(false);
            this.U0.showZoomControls(false);
            this.U0.setLogoPosition(LogoPosition.logoPostionRightBottom);
            if (X2()) {
                return;
            }
            g3();
        }
    }

    public final boolean X2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                ArrayList arrayList = new ArrayList();
                if (f.U().getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
                    arrayList.add("android.permission.ACCESS_FINE_LOCATION");
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

    @Override // b.a.p0.a.h0.g.d
    public boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void Z2(LatLng latLng, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{latLng, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            e3(true);
            U2(latLng);
            a3();
            if (z) {
                S2();
                if (this.b1.d()) {
                    this.b1.e(false);
                }
            }
            if (z2) {
                this.I0.smoothScrollToPosition(0);
            }
        }
    }

    @Override // b.a.p0.m.p.e.b
    public void a(BDLocation bDLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bDLocation) == null) {
            U2(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
        }
    }

    public final void a3() {
        Marker marker;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (marker = this.V0) == null) {
            return;
        }
        marker.remove();
        this.V0 = null;
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void b3(int i2) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || (bVar = this.e1) == null) {
            return;
        }
        switch (i2) {
            case 16:
                c cVar = this.X0;
                if (cVar != null) {
                    PoiInfo poiInfo = cVar.f11647a;
                    if (TextUtils.equals(poiInfo.name, "[位置]")) {
                        poiInfo.name = "";
                    }
                    this.e1.a(new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
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

    @Override // b.a.p0.m.p.b
    public void c(c cVar) {
        PoiInfo poiInfo;
        LatLng latLng;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, cVar) == null) || cVar == null || (poiInfo = cVar.f11647a) == null || (latLng = poiInfo.location) == null) {
            return;
        }
        this.X0 = cVar;
        this.T0.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
        a3();
        if (this.W0 == null) {
            this.W0 = BitmapDescriptorFactory.fromResource(b.a.p0.m.e.aiapps_location_selected);
        }
        if (!cVar.f11649c) {
            this.V0 = (Marker) this.T0.addOverlay(new MarkerOptions().position(cVar.f11647a.location).zIndex(88).icon(this.W0));
        }
        if (cVar.f11649c) {
            return;
        }
        c3(false);
    }

    public final void c3(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || this.K0 == null) {
            return;
        }
        this.K0.setImageResource(z ? b.a.p0.m.e.aiapps_location_go_my_point_selected : b.a.p0.m.e.aiapps_location_go_my_point);
    }

    public void d3(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
            this.e1 = bVar;
        }
    }

    public final void e3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            if (z) {
                this.Y0.clear();
                this.a1.setData(this.Y0);
            }
            this.R0.setVisibility(z ? 0 : 8);
        }
    }

    public void f3() {
        g V;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (V = f.U().V()) == null) {
            return;
        }
        g.b i2 = V.i("navigateTo");
        i2.n(g.f5478g, g.f5480i);
        i2.j(this);
        i2.b();
    }

    @Override // b.a.p0.a.h0.g.d
    public void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    public final void g3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            e eVar = new e(f.U().getActivity(), this.T0);
            this.Z0 = eVar;
            eVar.n(true);
            this.Z0.k(this);
            e3(true);
        }
    }

    public final void h3(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, cVar) == null) || cVar == null || cVar.f11647a == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("city", cVar.f11647a.city);
        b.a.p0.m.p.g.a Z2 = b.a.p0.m.p.g.a.Z2(bundle);
        Z2.i1(this, 1);
        Z2.f3();
    }

    public final void i3(ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, reverseGeoCodeResult) == null) {
            PoiInfo poiInfo = new PoiInfo();
            SelectedLocationInfo selectedLocationInfo = this.f1;
            if (selectedLocationInfo != null) {
                poiInfo.name = selectedLocationInfo.mName;
                SelectedLocationInfo selectedLocationInfo2 = this.f1;
                poiInfo.location = new LatLng(selectedLocationInfo2.mLatitude, selectedLocationInfo2.mLongitude);
                poiInfo.address = this.f1.mAddress;
                this.f1 = null;
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
            this.Y0.clear();
            this.Y0.add(cVar);
            this.Y0.addAll(c.a(reverseGeoCodeResult.getPoiList()));
            this.a1.setData(this.Y0);
            this.X0 = cVar;
            if (this.Y0.size() > 0) {
                e3(false);
            }
        }
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.searchbox.widget.SlideInterceptor
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
            if (view.getId() == b.a.p0.m.f.float_btn) {
                e eVar = this.Z0;
                if (eVar == null || eVar.i() == null) {
                    return;
                }
                BDLocation i2 = this.Z0.i();
                LatLng latLng = new LatLng(i2.getLatitude(), i2.getLongitude());
                this.T0.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
                a3();
                if (this.d1) {
                    Z2(latLng, true, true);
                    this.d1 = false;
                }
                c3(true);
            } else if (view.getId() == b.a.p0.m.f.finish) {
                b3(16);
                T2();
            } else if (view.getId() == b.a.p0.m.f.search) {
                h3(this.X0);
            } else if (view.getId() == b.a.p0.m.f.cancel) {
                b3(17);
                T2();
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onDestroy();
            if (Build.VERSION.SDK_INT > 19) {
                this.U0.onDestroy();
            }
            this.S0.destroy();
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
            this.I0.postDelayed(new RunnableC0639a(this, reverseGeoCodeResult), 150L);
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            U2(this.T0.getMapStatus().target);
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
        if ((interceptable == null || interceptable.invokeL(1048607, this, mapStatus) == null) && this.c1) {
            Z2(mapStatus.target, true, true);
            c3(false);
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
            this.c1 = z2;
            this.d1 = (z2 || this.d1) ? true : true;
        }
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.onPause();
            this.U0.onPause();
            e eVar = this.Z0;
            if (eVar != null) {
                eVar.n(false);
            }
        }
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onResume();
            this.U0.onResume();
            e eVar = this.Z0;
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
            this.f1 = selectedLocationInfo;
            LatLng latLng = new LatLng(d2, d3);
            this.T0.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
            this.d1 = true;
            Z2(latLng, false, true);
            c3(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048613, this, layoutInflater, viewGroup, bundle)) == null) {
            b.a.p0.m.a.a();
            View inflate = layoutInflater.inflate(b.a.p0.m.g.ai_apps_location_choose, viewGroup, false);
            V2(inflate);
            W2();
            if (Q1()) {
                inflate = T1(inflate);
                t1(-1);
            }
            return A1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }
}
