package c.a.q0.m;

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
/* loaded from: classes6.dex */
public class b implements SensorEventListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.q0.m.o.c> f10867e;

    /* renamed from: f  reason: collision with root package name */
    public SensorManager f10868f;

    /* renamed from: g  reason: collision with root package name */
    public double f10869g;

    /* renamed from: h  reason: collision with root package name */
    public LocationClient f10870h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f10871i;

    /* renamed from: j  reason: collision with root package name */
    public BDLocation f10872j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f10873k;

    /* loaded from: classes6.dex */
    public class a implements BDLocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

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
            this.a = bVar;
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bDLocation) == null) {
                if (bDLocation == null || this.a.f10867e.size() <= 0) {
                    this.a.n();
                    return;
                }
                this.a.f10872j = bDLocation;
                for (c.a.q0.m.o.c cVar : this.a.f10867e) {
                    if (cVar.f10915k) {
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
        this.f10871i = false;
        this.f10873k = false;
        this.f10867e = new ArrayList(1);
        l();
    }

    public c.a.q0.m.o.c d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            for (c.a.q0.m.o.c cVar : this.f10867e) {
                if (cVar != null && TextUtils.equals(cVar.f10914j, str)) {
                    return cVar;
                }
            }
            return null;
        }
        return (c.a.q0.m.o.c) invokeL.objValue;
    }

    public BDLocation e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f10872j : (BDLocation) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f10870h == null) {
            LocationClient locationClient = new LocationClient(AppRuntime.getAppContext());
            this.f10870h = locationClient;
            locationClient.registerLocationListener(new a(this));
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.f10870h.setLocOption(locationClientOption);
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            LocationClient locationClient = this.f10870h;
            return locationClient != null && locationClient.isStarted();
        }
        return invokeV.booleanValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            n();
            for (c.a.q0.m.o.c cVar : this.f10867e) {
                cVar.l.onPause();
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            n();
            this.f10873k = false;
            if (Build.VERSION.SDK_INT > 19) {
                for (c.a.q0.m.o.c cVar : this.f10867e) {
                    cVar.l.onDestroy();
                }
            }
            this.f10867e.clear();
        }
    }

    public boolean insert(c.a.q0.m.o.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, cVar)) == null) {
            if (cVar == null) {
                return false;
            }
            this.f10867e.add(cVar);
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            c.a.q0.m.o.c d2 = d(str);
            if (d2 != null) {
                this.f10867e.remove(d2);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            l();
            for (c.a.q0.m.o.c cVar : this.f10867e) {
                cVar.l.onResume();
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.f10873k) {
            f();
            LocationClient locationClient = this.f10870h;
            if (locationClient == null || locationClient.isStarted()) {
                return;
            }
            this.f10870h.start();
            m();
            c.a.q0.a.e0.d.o("map", "start location");
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f10871i) {
            return;
        }
        SensorManager sensorManager = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
        this.f10868f = sensorManager;
        if (sensorManager != null) {
            sensorManager.registerListener(this, sensorManager.getDefaultSensor(3), 2);
            this.f10871i = true;
        }
    }

    public final void n() {
        LocationClient locationClient;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.f10873k && (locationClient = this.f10870h) != null && locationClient.isStarted()) {
            this.f10870h.stop();
            o();
            c.a.q0.a.e0.d.o("map", "stop location");
        }
    }

    public final void o() {
        SensorManager sensorManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (sensorManager = this.f10868f) != null && this.f10871i) {
            sensorManager.unregisterListener(this);
            this.f10871i = false;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, sensor, i2) == null) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, sensorEvent) == null) {
            double d2 = sensorEvent.values[0];
            if (Math.abs(d2 - this.f10869g) > 1.0d) {
                for (c.a.q0.m.o.c cVar : this.f10867e) {
                    MyLocationData locationData = cVar.l.getMap().getLocationData();
                    if (locationData != null && cVar.f10915k) {
                        cVar.l.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d2).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).satellitesNum(locationData.satellitesNum).build());
                        f();
                    }
                }
            }
            this.f10869g = d2;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            if (z) {
                this.f10873k = true;
                l();
                return;
            }
            n();
            this.f10873k = false;
        }
    }
}
