package c.a.p0.j;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements SensorEventListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.p0.j.n.c> f11695e;

    /* renamed from: f  reason: collision with root package name */
    public SensorManager f11696f;

    /* renamed from: g  reason: collision with root package name */
    public double f11697g;

    /* renamed from: h  reason: collision with root package name */
    public LocationClient f11698h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f11699i;

    /* renamed from: j  reason: collision with root package name */
    public BDLocation f11700j;
    public boolean k;

    /* loaded from: classes3.dex */
    public class a implements BDLocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f11701a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11701a = bVar;
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bDLocation) == null) {
                if (bDLocation == null || this.f11701a.f11695e.size() <= 0) {
                    this.f11701a.o();
                    return;
                }
                this.f11701a.f11700j = bDLocation;
                for (c.a.p0.j.n.c cVar : this.f11701a.f11695e) {
                    if (cVar.k) {
                        MyLocationData build = new MyLocationData.Builder().direction(bDLocation.getDirection()).accuracy(bDLocation.getGpsAccuracyStatus()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).satellitesNum(bDLocation.getSatelliteNumber()).build();
                        BaiduMap map = cVar.l.getMap();
                        map.setMyLocationEnabled(true);
                        map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                        map.setMyLocationData(build);
                    }
                }
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11699i = false;
        this.k = false;
        this.f11695e = new ArrayList(1);
        m();
    }

    public c.a.p0.j.n.c d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            for (c.a.p0.j.n.c cVar : this.f11695e) {
                if (cVar != null && TextUtils.equals(cVar.f11760j, str)) {
                    return cVar;
                }
            }
            return null;
        }
        return (c.a.p0.j.n.c) invokeL.objValue;
    }

    public BDLocation e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11700j : (BDLocation) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f11698h == null) {
            LocationClient locationClient = new LocationClient(AppRuntime.getAppContext());
            this.f11698h = locationClient;
            locationClient.registerLocationListener(new a(this));
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.f11698h.setLocOption(locationClientOption);
        }
    }

    public boolean g(c.a.p0.j.n.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cVar)) == null) {
            if (cVar == null) {
                return false;
            }
            this.f11695e.add(cVar);
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            LocationClient locationClient = this.f11698h;
            return locationClient != null && locationClient.isStarted();
        }
        return invokeV.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            o();
            for (c.a.p0.j.n.c cVar : this.f11695e) {
                cVar.l.onPause();
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            o();
            this.k = false;
            if (Build.VERSION.SDK_INT > 19) {
                for (c.a.p0.j.n.c cVar : this.f11695e) {
                    cVar.l.onDestroy();
                }
            }
            this.f11695e.clear();
        }
    }

    public boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            c.a.p0.j.n.c d2 = d(str);
            if (d2 != null) {
                this.f11695e.remove(d2);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            m();
            for (c.a.p0.j.n.c cVar : this.f11695e) {
                cVar.l.onResume();
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.k) {
            f();
            LocationClient locationClient = this.f11698h;
            if (locationClient == null || locationClient.isStarted()) {
                return;
            }
            this.f11698h.start();
            n();
            c.a.p0.a.e0.d.l("map", "start location");
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f11699i) {
            return;
        }
        SensorManager sensorManager = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
        this.f11696f = sensorManager;
        if (sensorManager != null) {
            sensorManager.registerListener(this, sensorManager.getDefaultSensor(3), 2);
            this.f11699i = true;
        }
    }

    public final void o() {
        LocationClient locationClient;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.k && (locationClient = this.f11698h) != null && locationClient.isStarted()) {
            this.f11698h.stop();
            p();
            c.a.p0.a.e0.d.l("map", "stop location");
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, sensor, i2) == null) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, sensorEvent) == null) {
            double d2 = sensorEvent.values[0];
            if (Math.abs(d2 - this.f11697g) > 1.0d) {
                for (c.a.p0.j.n.c cVar : this.f11695e) {
                    MyLocationData locationData = cVar.l.getMap().getLocationData();
                    if (locationData != null && cVar.k) {
                        cVar.l.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d2).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).satellitesNum(locationData.satellitesNum).build());
                        f();
                    }
                }
            }
            this.f11697g = d2;
        }
    }

    public final void p() {
        SensorManager sensorManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (sensorManager = this.f11696f) != null && this.f11699i) {
            sensorManager.unregisterListener(this);
            this.f11699i = false;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            if (z) {
                this.k = true;
                m();
                return;
            }
            o();
            this.k = false;
        }
    }
}
