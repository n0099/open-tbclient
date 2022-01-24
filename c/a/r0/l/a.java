package c.a.r0.l;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.c1.d.e;
import c.a.r0.a.k;
import c.a.r0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
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
/* loaded from: classes6.dex */
public class a implements e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f11475c;

    /* renamed from: d  reason: collision with root package name */
    public static final long f11476d;

    /* renamed from: e  reason: collision with root package name */
    public static final c f11477e;
    public transient /* synthetic */ FieldHolder $fh;
    public LocationClient a;

    /* renamed from: b  reason: collision with root package name */
    public LocationClientOption f11478b;

    /* renamed from: c.a.r0.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC0792a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11479e;

        public RunnableC0792a(a aVar) {
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
            this.f11479e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11479e.a.requestLocation();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // c.a.r0.a.c1.d.e.a
        public void a(c.a.r0.a.f2.f.j0.b bVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) && a.f11475c) {
                String str = "onWarmUpSuccess::= result=" + bVar;
            }
        }

        @Override // c.a.r0.a.c1.d.e.a
        public void onFailed(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && a.f11475c) {
                String str = "onWarmUpFailed:: errCode=" + i2;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends BDAbstractLocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LocationClient a;

        /* renamed from: b  reason: collision with root package name */
        public e.a f11481b;

        /* renamed from: c  reason: collision with root package name */
        public String f11482c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f11483d;

        public d(LocationClient locationClient, e.a aVar, String str, boolean z) {
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
            this.a = locationClient;
            this.f11481b = aVar;
            this.f11482c = str;
            this.f11483d = z;
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bDLocation) == null) {
                this.a.unRegisterLocationListener(this);
                int locType = bDLocation.getLocType();
                if (a.q(locType)) {
                    a.f11477e.update(bDLocation);
                    if (this.f11483d) {
                        return;
                    }
                    this.f11481b.a(a.o(bDLocation, this.f11482c));
                } else if (this.f11483d) {
                } else {
                    this.f11481b.onFailed(locType);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-635015224, "Lc/a/r0/l/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-635015224, "Lc/a/r0/l/a;");
                return;
            }
        }
        f11475c = k.a;
        f11476d = TimeUnit.MINUTES.toMillis(3L);
        f11477e = new c(null);
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

    public static BDLocation m(double d2, double d3, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3), str})) == null) {
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

    public static c.a.r0.a.f2.f.j0.b o(BDLocation bDLocation, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, bDLocation, str)) == null) {
            double longitude = bDLocation.getLongitude();
            double latitude = bDLocation.getLatitude();
            if (!TextUtils.equals(str, bDLocation.getCoorType())) {
                BDLocation m = m(latitude, longitude, str);
                longitude = m.getLongitude();
                latitude = m.getLatitude();
            }
            return new c.a.r0.a.f2.f.j0.b(str, longitude, latitude, bDLocation.getSpeed(), bDLocation.getRadius(), bDLocation.getAltitude(), bDLocation.getCountry(), bDLocation.getCountryCode(), bDLocation.getCity(), bDLocation.getCityCode(), bDLocation.getProvince(), bDLocation.getDistrict(), bDLocation.getStreet(), bDLocation.getStreetNumber());
        }
        return (c.a.r0.a.f2.f.j0.b) invokeLL.objValue;
    }

    public static boolean q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i2)) == null) ? i2 == 65 || i2 == 61 || i2 == 161 || i2 == 66 || i2 == 68 : invokeI.booleanValue;
    }

    @Override // c.a.r0.a.c1.d.e
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // c.a.r0.a.c1.d.e
    public void b(String str, boolean z, boolean z2, e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), aVar}) == null) {
            BDLocation c2 = f11477e.c(p());
            boolean z3 = c2 != null;
            if (z3) {
                aVar.a(o(c2, str));
            }
            if (this.a == null) {
                this.a = new LocationClient(AppRuntime.getAppContext());
                LocationClientOption locationClientOption = new LocationClientOption();
                locationClientOption.setCoorType("gcj02");
                locationClientOption.setScanSpan(0);
                locationClientOption.setIgnoreKillProcess(true);
                locationClientOption.setIsNeedAddress(true);
                this.a.setLocOption(locationClientOption);
                this.f11478b = locationClientOption;
                this.a.start();
            }
            this.a.registerLocationListener(new d(this.a, aVar, str, z3));
            this.f11478b.setIsNeedAltitude(z2);
            this.a.setLocOption(this.f11478b);
            q0.a0(new RunnableC0792a(this));
        }
    }

    @Override // c.a.r0.a.c1.d.e
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // c.a.r0.a.c1.d.e
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            long p = p();
            if (f11477e.f11480b == null || (p > 0 && !f11477e.d(p))) {
                boolean z = f11475c;
                b("gcj02", false, true, new b(this));
            }
        }
    }

    @Override // c.a.r0.a.c1.d.e
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // c.a.r0.a.c1.d.e
    public void f(e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
        }
    }

    @Override // c.a.r0.a.c1.d.e
    public double[] g(@NonNull c.a.r0.a.f2.f.j0.b bVar, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bVar, str)) == null) ? n(bVar.f6178b, bVar.f6179c, bVar.a, str) : (double[]) invokeLL.objValue;
    }

    @Override // c.a.r0.a.c1.d.e
    public c.a.r0.a.f2.f.j0.b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            BDLocation bDLocation = f11477e.f11480b;
            if (bDLocation == null) {
                return null;
            }
            return o(bDLocation, bDLocation.getCoorType());
        }
        return (c.a.r0.a.f2.f.j0.b) invokeV.objValue;
    }

    public final double[] n(double d2, double d3, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3), str, str2})) == null) {
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

    public final long p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? f11476d : invokeV.longValue;
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public BDLocation f11480b;

        public c() {
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
            this.a = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void update(BDLocation bDLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, bDLocation) == null) {
                synchronized (this) {
                    this.f11480b = bDLocation;
                    this.a = System.currentTimeMillis();
                }
            }
        }

        public synchronized BDLocation c(long j2) {
            InterceptResult invokeJ;
            BDLocation bDLocation;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
                synchronized (this) {
                    bDLocation = d(j2) ? this.f11480b : null;
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
                    long currentTimeMillis = System.currentTimeMillis() - this.a;
                    boolean z2 = this.f11480b != null;
                    boolean z3 = currentTimeMillis < j2;
                    z = z2 && z3;
                    if (a.f11475c) {
                        String.format("hitCache[%b] hasInfo[%b] isAgeOk[%b] cacheAge[%d] timeout[%d]", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Long.valueOf(currentTimeMillis), Long.valueOf(j2));
                    }
                }
                return z;
            }
            return invokeJ.booleanValue;
        }

        public /* synthetic */ c(RunnableC0792a runnableC0792a) {
            this();
        }
    }
}
