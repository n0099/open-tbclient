package b.a.p0.m.s;

import android.content.Context;
import b.a.p0.m.e;
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
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f11685a;

    /* renamed from: b  reason: collision with root package name */
    public BaiduMap f11686b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f11687c;

    /* renamed from: d  reason: collision with root package name */
    public BitmapDescriptor f11688d;

    /* renamed from: e  reason: collision with root package name */
    public b f11689e;

    /* renamed from: f  reason: collision with root package name */
    public LocationClient f11690f;

    /* renamed from: g  reason: collision with root package name */
    public BDLocation f11691g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f11692h;

    /* loaded from: classes4.dex */
    public class a extends BDAbstractLocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f11693a;

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
            this.f11693a = cVar;
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bDLocation) == null) {
                if (bDLocation == null) {
                    this.f11693a.m();
                    return;
                }
                this.f11693a.f11686b.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
                if (this.f11693a.f11687c != null) {
                    this.f11693a.f11687c.remove();
                    this.f11693a.f11687c = null;
                }
                MarkerOptions anchor = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(this.f11693a.f11688d).anchor(0.5f, 0.5f);
                c cVar = this.f11693a;
                cVar.f11687c = (Marker) cVar.f11686b.addOverlay(anchor);
                if (this.f11693a.f11691g == null) {
                    MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
                    if (this.f11693a.f11689e != null) {
                        this.f11693a.f11689e.a(bDLocation);
                    }
                }
                this.f11693a.f11691g = bDLocation;
            }
        }
    }

    /* loaded from: classes4.dex */
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
        this.f11692h = false;
        this.f11685a = context;
        this.f11686b = baiduMap;
    }

    public BDLocation i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11691g : (BDLocation) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f11690f == null) {
            LocationClient locationClient = new LocationClient(this.f11685a.getApplicationContext());
            this.f11690f = locationClient;
            locationClient.registerLocationListener(new a(this));
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.f11690f.setLocOption(locationClientOption);
            this.f11688d = BitmapDescriptorFactory.fromResource(e.aiapps_location_ding);
        }
    }

    public void k(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f11689e = bVar;
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f11692h) {
            return;
        }
        j();
        LocationClient locationClient = this.f11690f;
        if (locationClient == null || locationClient.isStarted()) {
            return;
        }
        this.f11690f.start();
        this.f11692h = true;
    }

    public final void m() {
        LocationClient locationClient;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f11692h && (locationClient = this.f11690f) != null && locationClient.isStarted()) {
            this.f11690f.stop();
            this.f11692h = false;
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
