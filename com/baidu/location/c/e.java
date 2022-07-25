package com.baidu.location.c;

import android.annotation.TargetApi;
import android.content.Context;
import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.OnNmeaMessageListener;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.b.t;
import com.baidu.location.b.w;
import com.baidu.location.b.x;
import com.baidu.location.e.k;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;
    public static String C = null;
    public static double G = 100.0d;
    public static String a = "";
    public static String b = "";
    public static e c;
    public static int p;
    public static int q;
    public static int r;
    public static long s;
    public transient /* synthetic */ FieldHolder $fh;
    public double A;
    public double B;
    public Handler D;
    public int E;
    public int F;
    public long H;
    public long I;
    public ArrayList<ArrayList<Float>> J;
    public ArrayList<ArrayList<Float>> K;
    public Context d;
    public LocationManager e;
    public Location f;
    public c g;
    public C0104e h;
    public GpsStatus i;
    public a j;
    public boolean k;
    public b l;
    public boolean m;
    public d n;
    public OnNmeaMessageListener o;
    public long t;
    public boolean u;
    public boolean v;
    public String w;
    public boolean x;
    public long y;
    public double z;

    @TargetApi(24)
    /* loaded from: classes2.dex */
    public class a extends GnssStatus.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        public /* synthetic */ a(e eVar, f fVar) {
            this(eVar);
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gnssStatus) == null) || this.a.e == null) {
                return;
            }
            this.a.I = System.currentTimeMillis();
            int satelliteCount = gnssStatus.getSatelliteCount();
            this.a.J.clear();
            this.a.K.clear();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < satelliteCount; i4++) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                i3++;
                if (gnssStatus.usedInFix(i4)) {
                    i++;
                    gnssStatus.getConstellationType(i4);
                    i2++;
                    arrayList.add(Float.valueOf(gnssStatus.getCn0DbHz(i4)));
                    arrayList.add(Float.valueOf(0.0f));
                    arrayList.add(Float.valueOf(gnssStatus.getAzimuthDegrees(i4)));
                    arrayList.add(Float.valueOf(gnssStatus.getElevationDegrees(i4)));
                    arrayList.add(Float.valueOf(1.0f));
                    arrayList.add(Float.valueOf(gnssStatus.getSvid(i4)));
                    this.a.J.add(arrayList);
                    this.a.K.add(arrayList);
                } else {
                    gnssStatus.getConstellationType(i4);
                    arrayList2.add(Float.valueOf(gnssStatus.getCn0DbHz(i4)));
                    arrayList2.add(Float.valueOf(0.0f));
                    arrayList2.add(Float.valueOf(gnssStatus.getAzimuthDegrees(i4)));
                    arrayList2.add(Float.valueOf(gnssStatus.getElevationDegrees(i4)));
                    arrayList2.add(Float.valueOf(0.0f));
                    arrayList2.add(Float.valueOf(gnssStatus.getSvid(i4)));
                    this.a.K.add(arrayList2);
                }
            }
            e.a = this.a.l();
            e.b = this.a.m();
            int unused = e.p = i;
            int unused2 = e.q = i2;
            int unused3 = e.r = i3;
            long unused4 = e.s = System.currentTimeMillis();
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.a.d((Location) null);
                this.a.b(false);
                int unused = e.p = 0;
                int unused2 = e.q = 0;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements GpsStatus.Listener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;
        public long b;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
            this.b = 0L;
        }

        public /* synthetic */ b(e eVar, f fVar) {
            this(eVar);
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int i) {
            long currentTimeMillis;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.e == null) {
                return;
            }
            int i2 = 0;
            if (i == 2) {
                this.a.d((Location) null);
                this.a.b(false);
                int unused = e.p = 0;
                int unused2 = e.q = 0;
            } else if (i == 4 && this.a.v) {
                try {
                    if (this.a.i == null) {
                        this.a.i = this.a.e.getGpsStatus(null);
                    } else {
                        this.a.e.getGpsStatus(this.a.i);
                    }
                    this.a.E = 0;
                    this.a.F = 0;
                    double d = 0.0d;
                    this.a.J.clear();
                    this.a.K.clear();
                    this.a.I = System.currentTimeMillis();
                    int i3 = 0;
                    for (GpsSatellite gpsSatellite : this.a.i.getSatellites()) {
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        if (gpsSatellite.usedInFix()) {
                            i3++;
                            gpsSatellite.getPrn();
                            i2++;
                            d += gpsSatellite.getSnr();
                            arrayList.add(Float.valueOf(0.0f));
                            arrayList.add(Float.valueOf(gpsSatellite.getSnr()));
                            arrayList.add(Float.valueOf(gpsSatellite.getAzimuth()));
                            arrayList.add(Float.valueOf(gpsSatellite.getElevation()));
                            arrayList.add(Float.valueOf(1.0f));
                            arrayList.add(Float.valueOf(gpsSatellite.getPrn()));
                            this.a.J.add(arrayList);
                            this.a.K.add(arrayList);
                        } else {
                            gpsSatellite.getPrn();
                            arrayList2.add(Float.valueOf(0.0f));
                            arrayList2.add(Float.valueOf(gpsSatellite.getSnr()));
                            arrayList2.add(Float.valueOf(gpsSatellite.getAzimuth()));
                            arrayList2.add(Float.valueOf(gpsSatellite.getElevation()));
                            arrayList2.add(Float.valueOf(0.0f));
                            arrayList2.add(Float.valueOf(gpsSatellite.getPrn()));
                            this.a.K.add(arrayList2);
                        }
                        if (gpsSatellite.getSnr() >= k.H) {
                            e.j(this.a);
                        }
                    }
                    e.a = this.a.l();
                    e.b = this.a.m();
                    if (i2 > 0) {
                        int unused3 = e.q = i2;
                        double unused4 = e.G = d / i2;
                    }
                    if (i3 <= 0) {
                        if (System.currentTimeMillis() - this.b > 100) {
                            currentTimeMillis = System.currentTimeMillis();
                        }
                        long unused5 = e.s = System.currentTimeMillis();
                    }
                    currentTimeMillis = System.currentTimeMillis();
                    this.b = currentTimeMillis;
                    int unused6 = e.p = i3;
                    long unused52 = e.s = System.currentTimeMillis();
                } catch (Exception unused7) {
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements LocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        public /* synthetic */ c(e eVar, f fVar) {
            this(eVar);
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, location) == null) || location == null || Math.abs(location.getLatitude()) > 360.0d || Math.abs(location.getLongitude()) > 360.0d) {
                return;
            }
            int i = e.p;
            if (i == 0) {
                try {
                    i = location.getExtras().getInt("satellites");
                } catch (Exception unused) {
                }
            }
            if (i == 0) {
                System.currentTimeMillis();
                long unused2 = this.a.I;
                if (location.getAccuracy() > 50.0f && !k.m) {
                    return;
                }
            }
            this.a.b(true);
            this.a.d(location);
            this.a.u = false;
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.d((Location) null);
                this.a.b(false);
            }
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            }
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i, bundle) == null) {
                if (i == 0) {
                    this.a.d((Location) null);
                } else if (i != 1) {
                    if (i != 2) {
                        return;
                    }
                    this.a.u = false;
                    return;
                } else {
                    this.a.t = System.currentTimeMillis();
                    this.a.u = true;
                }
                this.a.b(false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements GpsStatus.NmeaListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public d(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        public /* synthetic */ d(e eVar, f fVar) {
            this(eVar);
        }

        @Override // android.location.GpsStatus.NmeaListener
        public void onNmeaReceived(long j, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJL(1048576, this, j, str) == null) && this.a.b(str)) {
                this.a.a(str);
            }
        }
    }

    /* renamed from: com.baidu.location.c.e$e  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0104e implements LocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;
        public long b;

        public C0104e(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
            this.b = 0L;
        }

        public /* synthetic */ C0104e(e eVar, f fVar) {
            this(eVar);
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, location) == null) || this.a.v || location == null || location.getProvider() != "gps" || System.currentTimeMillis() - this.b < 10000 || Math.abs(location.getLatitude()) > 360.0d || Math.abs(location.getLongitude()) > 360.0d || !w.a(location, false)) {
                return;
            }
            this.b = System.currentTimeMillis();
            this.a.D.sendMessage(this.a.D.obtainMessage(4, location));
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            }
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i, bundle) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1037753198, "Lcom/baidu/location/c/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1037753198, "Lcom/baidu/location/c/e;");
        }
    }

    public e() {
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
        this.e = null;
        this.g = null;
        this.h = null;
        this.k = false;
        this.l = null;
        this.m = false;
        this.n = null;
        this.o = null;
        this.t = 0L;
        this.u = false;
        this.v = false;
        this.w = null;
        this.x = false;
        this.y = 0L;
        this.z = -1.0d;
        this.A = 0.0d;
        this.B = 0.0d;
        this.D = null;
        this.H = 0L;
        this.I = 0L;
        this.J = new ArrayList<>();
        this.K = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                Class.forName("android.location.GnssStatus");
                this.k = true;
            } catch (ClassNotFoundException unused) {
                this.k = false;
            }
        }
        this.m = false;
    }

    public static int a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            char charAt = str2.charAt(0);
            int i = 0;
            for (int i2 = 0; i2 < str.length(); i2++) {
                if (Character.valueOf(charAt).equals(Character.valueOf(str.charAt(i2)))) {
                    i++;
                }
            }
            return i;
        }
        return invokeLL.intValue;
    }

    public static synchronized e a() {
        InterceptResult invokeV;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            synchronized (e.class) {
                if (c == null) {
                    c = new e();
                }
                eVar = c;
            }
            return eVar;
        }
        return (e) invokeV.objValue;
    }

    public static String a(Location location) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, location)) == null) {
            if (location == null) {
                return null;
            }
            float speed = (float) (location.getSpeed() * 3.6d);
            if (!location.hasSpeed()) {
                speed = -1.0f;
            }
            return String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d&ll_sn=%d|%d&ll_snr=%.1f", Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Float.valueOf(speed), Float.valueOf(location.hasBearing() ? location.getBearing() : -1.0f), Integer.valueOf((int) (location.hasAccuracy() ? location.getAccuracy() : -1.0f)), Integer.valueOf(p), Double.valueOf(location.hasAltitude() ? location.getAltitude() : 555.0d), Long.valueOf(location.getTime() / 1000), Integer.valueOf(p), Integer.valueOf(q), Double.valueOf(G));
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Location location) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65550, this, str, location) == null) || location == null) {
            return;
        }
        String str2 = str + com.baidu.location.b.a.a().c();
        boolean e = i.a().e();
        t.a(new com.baidu.location.c.a(com.baidu.location.c.b.a().f()));
        t.a(System.currentTimeMillis());
        t.a(new Location(location));
        t.a(str2);
        if (e) {
            return;
        }
        w.a(t.c(), null, t.d(), str2);
    }

    public static boolean a(Location location, Location location2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65551, null, location, location2, z)) == null) {
            if (location == location2) {
                return false;
            }
            if (location == null || location2 == null) {
                return true;
            }
            float speed = location2.getSpeed();
            if (!z || ((k.v != 3 && com.baidu.location.e.d.a().a(location2.getLongitude(), location2.getLatitude())) || speed >= 5.0f)) {
                float distanceTo = location2.distanceTo(location);
                return speed > k.L ? distanceTo > k.N : speed > k.K ? distanceTo > k.M : distanceTo > 5.0f;
            }
            return true;
        }
        return invokeLLZ.booleanValue;
    }

    public static String b(Location location) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, location)) == null) {
            String a2 = a(location);
            if (a2 != null) {
                return a2 + "&g_tp=0";
            }
            return a2;
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65560, this, z) == null) {
            this.x = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, this, str)) == null) {
            if (str.indexOf("*") != -1 && str.indexOf("$") != -1 && str.indexOf("$") <= str.indexOf("*") && str.length() >= str.indexOf("*")) {
                byte[] bytes = str.substring(0, str.indexOf("*")).getBytes();
                int i2 = bytes[1];
                for (int i3 = 2; i3 < bytes.length; i3++) {
                    i2 ^= bytes[i3];
                }
                String format = String.format("%02x", Integer.valueOf(i2));
                int indexOf = str.indexOf("*");
                if (indexOf != -1 && str.length() >= (i = indexOf + 3) && format.equalsIgnoreCase(str.substring(indexOf + 1, i))) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String c(Location location) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, location)) == null) {
            String a2 = a(location);
            if (a2 != null) {
                return a2 + C;
            }
            return a2;
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Location location) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65567, this, location) == null) {
            this.D.sendMessage(this.D.obtainMessage(1, location));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Location location) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65569, this, location) == null) {
            String str = null;
            if (location == null) {
                this.f = null;
                return;
            }
            int i = p;
            if (i == 0) {
                try {
                    i = location.getExtras().getInt("satellites");
                } catch (Exception unused) {
                }
            }
            if (i != 0 || Math.abs(System.currentTimeMillis() - this.I) <= 5000 || k.m) {
                if (this.m && location.getSpeed() == 0.0d && this.A != 0.0d && System.currentTimeMillis() - this.B < 2000.0d) {
                    location.setSpeed((float) this.A);
                }
                this.y = System.currentTimeMillis();
                System.currentTimeMillis();
                this.f = location;
                Location location2 = new Location(this.f);
                int i2 = p;
                if (this.f != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.f.setTime(currentTimeMillis);
                    float speed = (float) (this.f.getSpeed() * 3.6d);
                    if (!this.f.hasSpeed()) {
                        speed = -1.0f;
                    }
                    if (i2 == 0) {
                        try {
                            i2 = this.f.getExtras().getInt("satellites");
                        } catch (Exception unused2) {
                        }
                    }
                    str = String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_n=%d&ll_t=%d", Double.valueOf(this.f.getLongitude()), Double.valueOf(this.f.getLatitude()), Float.valueOf(speed), Float.valueOf(this.f.getBearing()), Integer.valueOf(i2), Long.valueOf(currentTimeMillis));
                }
                this.w = str;
                if (this.f != null) {
                    com.baidu.location.b.a.a().a(f());
                    if (p > 2 && w.a(this.f, true)) {
                        boolean e = i.a().e();
                        t.a(new com.baidu.location.c.a(com.baidu.location.c.b.a().f()));
                        t.a(System.currentTimeMillis());
                        t.a(new Location(this.f));
                        t.a(com.baidu.location.b.a.a().c());
                        if (!e) {
                            x.a().b();
                        }
                    }
                }
                x.a().a(location2, p);
            }
        }
    }

    public static /* synthetic */ int j(e eVar) {
        int i = eVar.F;
        eVar.F = i + 1;
        return i;
    }

    public static String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) {
            long currentTimeMillis = System.currentTimeMillis() - s;
            if (currentTimeMillis < 0 || currentTimeMillis >= 3000) {
                return null;
            }
            return String.format(Locale.US, "&gsvn=%d&gsfn=%d", Integer.valueOf(r), Integer.valueOf(p));
        }
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65577, this)) == null) {
            StringBuilder sb = new StringBuilder();
            if (this.J.size() > 32 || this.J.size() == 0) {
                return sb.toString();
            }
            Iterator<ArrayList<Float>> it = this.J.iterator();
            boolean z = true;
            while (it.hasNext()) {
                ArrayList<Float> next = it.next();
                if (next.size() == 6) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append("|");
                    }
                    sb.append(String.format("%.1f;", next.get(0)));
                    sb.append(String.format("%.1f;", next.get(1)));
                    sb.append(String.format("%.0f;", next.get(2)));
                    sb.append(String.format("%.0f;", next.get(3)));
                    sb.append(String.format("%.0f", next.get(4)));
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65578, this)) == null) {
            StringBuilder sb = new StringBuilder();
            if (this.K.size() == 0) {
                return sb.toString();
            }
            Iterator<ArrayList<Float>> it = this.K.iterator();
            boolean z = true;
            while (it.hasNext()) {
                ArrayList<Float> next = it.next();
                if (next.size() == 6) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append("|");
                    }
                    sb.append(String.format("%.1f;", next.get(0)));
                    sb.append(String.format("%.1f;", next.get(1)));
                    sb.append(String.format("%.0f;", next.get(2)));
                    sb.append(String.format("%.0f;", next.get(3)));
                    sb.append(String.format("%.0f", next.get(4)));
                    sb.append(String.format("%.0f", next.get(5)));
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && str.length() != 0 && b(str)) {
            if (str.startsWith("$GPPWR,") || str.startsWith("$GNGST,") || str.startsWith("$GPGST,") || str.startsWith("$GLGSV,") || str.startsWith("$GNGSV,") || str.startsWith("$BDGSV,") || str.startsWith("$GPZDA,") || str.startsWith("$GPGSA,") || str.startsWith("$GNVTG,") || str.startsWith("$GPVTG,") || str.startsWith("$GNGSA,") || str.startsWith("$GPNTR,") || str.startsWith("$GNGGA,") || str.startsWith("$GPGGA,") || str.startsWith("$GPRMC,") || str.startsWith("$GPGSV,") || str.startsWith("$BDGSA,")) {
                String[] split = str.split(",");
                a(str, ",");
                if (split != null && split.length > 0) {
                    if ((split[0].equalsIgnoreCase("$GPRMC") || split[0].equalsIgnoreCase("$GNRMC") || split[0].equalsIgnoreCase("$GLRMC") || split[0].equalsIgnoreCase("$BDRMC")) && split.length > 7 && split[7].trim().length() > 0) {
                        this.A = ((Double.valueOf(split[7]).doubleValue() * 1.852d) / 3600.0d) * 1000.0d;
                        this.B = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                c();
            } else {
                d();
            }
        }
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (com.baidu.location.f.isServing) {
                    Context serviceContext = com.baidu.location.f.getServiceContext();
                    this.d = serviceContext;
                    try {
                        this.e = (LocationManager) serviceContext.getSystemService("location");
                        if (this.k) {
                            a aVar = new a(this, null);
                            this.j = aVar;
                            this.e.registerGnssStatusCallback(aVar);
                        } else {
                            b bVar = new b(this, null);
                            this.l = bVar;
                            this.e.addGpsStatusListener(bVar);
                        }
                        if (this.m) {
                            if (Build.VERSION.SDK_INT >= 24) {
                                f fVar = new f(this);
                                this.o = fVar;
                                this.e.addNmeaListener(fVar);
                            } else {
                                d dVar = new d(this, null);
                                this.n = dVar;
                                this.e.addNmeaListener(dVar);
                            }
                        }
                        C0104e c0104e = new C0104e(this, null);
                        this.h = c0104e;
                        this.e.requestLocationUpdates("passive", 9000L, 0.0f, c0104e);
                    } catch (Exception unused) {
                    }
                    this.D = new g(this);
                }
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Log.d(com.baidu.location.e.a.a, "start gps...");
            if (this.v) {
                return;
            }
            try {
                this.g = new c(this, null);
                try {
                    this.e.sendExtraCommand("gps", "force_xtra_injection", new Bundle());
                } catch (Exception unused) {
                }
                this.e.requestLocationUpdates("gps", 1000L, 0.0f, this.g);
                this.H = System.currentTimeMillis();
                this.v = true;
            } catch (Exception unused2) {
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.v) {
            LocationManager locationManager = this.e;
            if (locationManager != null) {
                try {
                    if (this.g != null) {
                        locationManager.removeUpdates(this.g);
                    }
                } catch (Exception unused) {
                }
            }
            k.d = 0;
            k.v = 0;
            this.g = null;
            this.v = false;
            b(false);
        }
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                d();
                if (this.e == null) {
                    return;
                }
                try {
                    if (this.l != null) {
                        this.e.removeGpsStatusListener(this.l);
                    }
                    if (this.k && this.j != null) {
                        this.e.unregisterGnssStatusCallback(this.j);
                    }
                    if (this.m && this.n != null) {
                        this.e.removeNmeaListener(this.n);
                    }
                    this.e.removeUpdates(this.h);
                } catch (Exception unused) {
                }
                this.l = null;
                this.e = null;
            }
        }
    }

    public String f() {
        InterceptResult invokeV;
        double[] coorEncrypt;
        boolean z;
        StringBuilder sb;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f != null) {
                String str2 = "{\"result\":{\"time\":\"" + k.a() + "\",\"error\":\"61\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%d\",\"d\":\"%f\",\"s\":\"%f\",\"n\":\"%d\"";
                int accuracy = (int) (this.f.hasAccuracy() ? this.f.getAccuracy() : 10.0f);
                float speed = (float) (this.f.getSpeed() * 3.6d);
                if (!this.f.hasSpeed()) {
                    speed = -1.0f;
                }
                if (com.baidu.location.e.d.a().a(this.f.getLongitude(), this.f.getLatitude())) {
                    coorEncrypt = Jni.coorEncrypt(this.f.getLongitude(), this.f.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
                    if (coorEncrypt[0] <= 0.0d && coorEncrypt[1] <= 0.0d) {
                        coorEncrypt[0] = this.f.getLongitude();
                        coorEncrypt[1] = this.f.getLatitude();
                    }
                    z = true;
                } else {
                    this.f.getLongitude();
                    this.f.getLatitude();
                    coorEncrypt = Jni.coorEncrypt(this.f.getLongitude(), this.f.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
                    if (coorEncrypt[0] <= 0.0d && coorEncrypt[1] <= 0.0d) {
                        coorEncrypt[0] = this.f.getLongitude();
                        coorEncrypt[1] = this.f.getLatitude();
                    }
                    z = false;
                }
                String format = String.format(Locale.CHINA, str2, Double.valueOf(coorEncrypt[0]), Double.valueOf(coorEncrypt[1]), Integer.valueOf(accuracy), Float.valueOf(this.f.getBearing()), Float.valueOf(speed), Integer.valueOf(p));
                if (!z) {
                    format = format + ",\"in_cn\":\"0\"";
                }
                if (this.f.hasAltitude()) {
                    sb = new StringBuilder();
                    sb.append(format);
                    str = String.format(Locale.CHINA, ",\"h\":%.2f}}", Double.valueOf(this.f.getAltitude()));
                } else {
                    sb = new StringBuilder();
                    sb.append(format);
                    str = "}}";
                }
                sb.append(str);
                return sb.toString();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public Location g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f != null && Math.abs(System.currentTimeMillis() - this.f.getTime()) <= 60000) {
                return this.f;
            }
            return null;
        }
        return (Location) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            try {
                long currentTimeMillis = System.currentTimeMillis() - this.I;
                int i = p;
                if (i == 0) {
                    try {
                        i = this.f.getExtras().getInt("satellites");
                    } catch (Exception unused) {
                    }
                }
                if (this.f != null && this.f.getLatitude() != 0.0d && this.f.getLongitude() != 0.0d) {
                    if (i <= 2 && Math.abs(currentTimeMillis) >= 5000) {
                        if (k.m) {
                        }
                    }
                    return true;
                }
                return false;
            } catch (Exception unused2) {
                Location location = this.f;
                return (location == null || location.getLatitude() == 0.0d || this.f.getLongitude() == 0.0d) ? false : true;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (h() && System.currentTimeMillis() - this.y <= 10000) {
                long currentTimeMillis = System.currentTimeMillis();
                if (!this.u || currentTimeMillis - this.t >= 3000) {
                    return this.x;
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
