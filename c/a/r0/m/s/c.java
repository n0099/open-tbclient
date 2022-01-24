package c.a.r0.m.s;

import android.content.Context;
import c.a.r0.m.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public BaiduMap f11563b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f11564c;

    /* renamed from: d  reason: collision with root package name */
    public BitmapDescriptor f11565d;

    /* renamed from: e  reason: collision with root package name */
    public b f11566e;

    /* renamed from: f  reason: collision with root package name */
    public LocationClient f11567f;

    /* renamed from: g  reason: collision with root package name */
    public BDLocation f11568g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f11569h;

    /* loaded from: classes6.dex */
    public class a extends BDAbstractLocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bDLocation) == null) {
                if (bDLocation == null) {
                    this.a.m();
                    return;
                }
                this.a.f11563b.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
                if (this.a.f11564c != null) {
                    this.a.f11564c.remove();
                    this.a.f11564c = null;
                }
                MarkerOptions anchor = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(this.a.f11565d).anchor(0.5f, 0.5f);
                c cVar = this.a;
                cVar.f11564c = (Marker) cVar.f11563b.addOverlay(anchor);
                if (this.a.f11568g == null) {
                    MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
                    if (this.a.f11566e != null) {
                        this.a.f11566e.a(bDLocation);
                    }
                }
                this.a.f11568g = bDLocation;
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(BDLocation bDLocation);
    }

    public c(Context context, BaiduMap baiduMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, baiduMap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11569h = false;
        this.a = context;
        this.f11563b = baiduMap;
    }

    public BDLocation i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11568g : (BDLocation) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f11567f == null) {
            LocationClient locationClient = new LocationClient(this.a.getApplicationContext());
            this.f11567f = locationClient;
            locationClient.registerLocationListener(new a(this));
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.f11567f.setLocOption(locationClientOption);
            this.f11565d = BitmapDescriptorFactory.fromResource(e.aiapps_location_ding);
        }
    }

    public void k(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f11566e = bVar;
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f11569h) {
            return;
        }
        j();
        LocationClient locationClient = this.f11567f;
        if (locationClient == null || locationClient.isStarted()) {
            return;
        }
        this.f11567f.start();
        this.f11569h = true;
    }

    public final void m() {
        LocationClient locationClient;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f11569h && (locationClient = this.f11567f) != null && locationClient.isStarted()) {
            this.f11567f.stop();
            this.f11569h = false;
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                l();
            } else {
                m();
            }
        }
    }
}
