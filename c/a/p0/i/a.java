package c.a.p0.i;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.c1.d.d;
import c.a.p0.a.k;
import c.a.p0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
@Singleton
@Service
/* loaded from: classes3.dex */
public class a implements d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f11682c;

    /* renamed from: d  reason: collision with root package name */
    public static final long f11683d;

    /* renamed from: e  reason: collision with root package name */
    public static final b f11684e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LocationClient f11685a;

    /* renamed from: b  reason: collision with root package name */
    public LocationClientOption f11686b;

    /* renamed from: c.a.p0.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0610a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11687e;

        public RunnableC0610a(a aVar) {
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
            this.f11687e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11687e.f11685a.requestLocation();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends BDAbstractLocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public LocationClient f11690a;

        /* renamed from: b  reason: collision with root package name */
        public d.a f11691b;

        /* renamed from: c  reason: collision with root package name */
        public String f11692c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f11693d;

        public c(LocationClient locationClient, d.a aVar, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {locationClient, aVar, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11690a = locationClient;
            this.f11691b = aVar;
            this.f11692c = str;
            this.f11693d = z;
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bDLocation) == null) {
                this.f11690a.unRegisterLocationListener(this);
                int locType = bDLocation.getLocType();
                if (a.p(locType)) {
                    a.f11684e.e(bDLocation);
                    if (this.f11693d) {
                        return;
                    }
                    this.f11691b.a(a.n(bDLocation, this.f11692c));
                } else if (this.f11693d) {
                } else {
                    this.f11691b.onFailed(locType);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1884855337, "Lc/a/p0/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1884855337, "Lc/a/p0/i/a;");
                return;
            }
        }
        f11682c = k.f7077a;
        f11683d = TimeUnit.MINUTES.toMillis(3L);
        f11684e = new b(null);
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

    public static BDLocation l(double d2, double d3, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3), str})) == null) {
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLongitude(d3);
            bDLocation.setLatitude(d2);
            if (TextUtils.equals(str, "gcj02")) {
                return bDLocation;
            }
            if (TextUtils.equals(str, BDLocation.BDLOCATION_GCJ02_TO_BD09)) {
                return LocationClient.getBDLocationInCoorType(bDLocation, BDLocation.BDLOCATION_GCJ02_TO_BD09);
            }
            if (TextUtils.equals(str, "bd09ll")) {
                return LocationClient.getBDLocationInCoorType(bDLocation, "bd09ll");
            }
            return TextUtils.equals(str, CoordinateType.WGS84) ? LocationClient.getBDLocationInCoorType(bDLocation, "gcj2wgs") : bDLocation;
        }
        return (BDLocation) invokeCommon.objValue;
    }

    public static c.a.p0.a.c2.f.k0.b n(BDLocation bDLocation, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, bDLocation, str)) == null) {
            double longitude = bDLocation.getLongitude();
            double latitude = bDLocation.getLatitude();
            if (!TextUtils.equals(str, bDLocation.getCoorType())) {
                BDLocation l = l(latitude, longitude, str);
                longitude = l.getLongitude();
                latitude = l.getLatitude();
            }
            return new c.a.p0.a.c2.f.k0.b(str, longitude, latitude, bDLocation.getSpeed(), bDLocation.getRadius(), bDLocation.getAltitude(), bDLocation.getCountry(), bDLocation.getCountryCode(), bDLocation.getCity(), bDLocation.getCityCode(), bDLocation.getProvince(), bDLocation.getDistrict(), bDLocation.getStreet(), bDLocation.getStreetNumber());
        }
        return (c.a.p0.a.c2.f.k0.b) invokeLL.objValue;
    }

    public static boolean p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i2)) == null) ? i2 == 65 || i2 == 61 || i2 == 161 || i2 == 66 || i2 == 68 : invokeI.booleanValue;
    }

    @Override // c.a.p0.a.c1.d.d
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // c.a.p0.a.c1.d.d
    public void b(String str, boolean z, boolean z2, d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), aVar}) == null) {
            BDLocation c2 = f11684e.c(o());
            boolean z3 = c2 != null;
            if (z3) {
                aVar.a(n(c2, str));
            }
            if (this.f11685a == null) {
                this.f11685a = new LocationClient(AppRuntime.getAppContext());
                LocationClientOption locationClientOption = new LocationClientOption();
                locationClientOption.setCoorType("gcj02");
                locationClientOption.setScanSpan(0);
                locationClientOption.setIgnoreKillProcess(true);
                locationClientOption.setIsNeedAddress(true);
                this.f11685a.setLocOption(locationClientOption);
                this.f11686b = locationClientOption;
                this.f11685a.start();
            }
            this.f11685a.registerLocationListener(new c(this.f11685a, aVar, str, z3));
            this.f11686b.setIsNeedAltitude(z2);
            this.f11685a.setLocOption(this.f11686b);
            q0.X(new RunnableC0610a(this));
        }
    }

    @Override // c.a.p0.a.c1.d.d
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // c.a.p0.a.c1.d.d
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // c.a.p0.a.c1.d.d
    public void e(d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
        }
    }

    @Override // c.a.p0.a.c1.d.d
    public double[] f(@NonNull c.a.p0.a.c2.f.k0.b bVar, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, str)) == null) ? m(bVar.f4950b, bVar.f4951c, bVar.f4949a, str) : (double[]) invokeLL.objValue;
    }

    @Override // c.a.p0.a.c1.d.d
    public c.a.p0.a.c2.f.k0.b g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            BDLocation bDLocation = f11684e.f11689b;
            if (bDLocation == null) {
                return null;
            }
            return n(bDLocation, bDLocation.getCoorType());
        }
        return (c.a.p0.a.c2.f.k0.b) invokeV.objValue;
    }

    public final double[] m(double d2, double d3, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3), str, str2})) == null) {
            double[] dArr = new double[2];
            if (TextUtils.equals(str2, "gcj02")) {
                return dArr;
            }
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLongitude(d2);
            bDLocation.setLatitude(d3);
            if (TextUtils.equals(str2, BDLocation.BDLOCATION_GCJ02_TO_BD09)) {
                bDLocation = LocationClient.getBDLocationInCoorType(bDLocation, BDLocation.BDLOCATION_GCJ02_TO_BD09);
            } else if (TextUtils.equals(str2, "bd09ll")) {
                bDLocation = LocationClient.getBDLocationInCoorType(bDLocation, "bd09ll");
            } else if (TextUtils.equals(str2, CoordinateType.WGS84)) {
                bDLocation = LocationClient.getBDLocationInCoorType(bDLocation, "gcj2wgs");
            }
            dArr[0] = bDLocation.getLongitude();
            dArr[1] = bDLocation.getLatitude();
            return dArr;
        }
        return (double[]) invokeCommon.objValue;
    }

    public final long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? f11683d : invokeV.longValue;
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f11688a;

        /* renamed from: b  reason: collision with root package name */
        public BDLocation f11689b;

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
            this.f11688a = 0L;
        }

        public synchronized BDLocation c(long j2) {
            InterceptResult invokeJ;
            BDLocation bDLocation;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
                synchronized (this) {
                    bDLocation = d(j2) ? this.f11689b : null;
                }
                return bDLocation;
            }
            return (BDLocation) invokeJ.objValue;
        }

        public synchronized boolean d(long j2) {
            InterceptResult invokeJ;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                synchronized (this) {
                    long currentTimeMillis = System.currentTimeMillis() - this.f11688a;
                    boolean z2 = this.f11689b != null;
                    boolean z3 = currentTimeMillis < j2;
                    z = z2 && z3;
                    if (a.f11682c) {
                        String.format("hitCache[%b] hasInfo[%b] isAgeOk[%b] cacheAge[%d] timeout[%d]", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Long.valueOf(currentTimeMillis), Long.valueOf(j2));
                    }
                }
                return z;
            }
            return invokeJ.booleanValue;
        }

        public final synchronized void e(BDLocation bDLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bDLocation) == null) {
                synchronized (this) {
                    this.f11689b = bDLocation;
                    this.f11688a = System.currentTimeMillis();
                }
            }
        }

        public /* synthetic */ b(RunnableC0610a runnableC0610a) {
            this();
        }
    }
}
