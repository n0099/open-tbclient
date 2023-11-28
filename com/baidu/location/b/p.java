package com.baidu.location.b;

import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Poi;
import com.baidu.location.PoiRegion;
import com.baidu.location.b.m;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class p extends m {
    public static /* synthetic */ Interceptable $ic = null;
    public static String f = "0";
    public static boolean h;
    public static p i;
    public transient /* synthetic */ FieldHolder $fh;
    public PoiRegion A;
    public double B;
    public double C;
    public boolean D;
    public long E;
    public long F;
    public a G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public b M;
    public boolean N;
    public int O;
    public long P;
    public boolean Q;
    public String R;
    public boolean S;

    /* renamed from: T  reason: collision with root package name */
    public boolean f1040T;
    public boolean U;
    public boolean V;
    public m.b e;
    public final Handler g;
    public boolean j;
    public String k;
    public BDLocation l;
    public BDLocation m;
    public com.baidu.location.c.j n;
    public com.baidu.location.c.a o;
    public com.baidu.location.c.j p;
    public com.baidu.location.c.a q;
    public boolean r;
    public volatile boolean s;
    public boolean t;
    public long u;
    public long v;
    public Address w;
    public long x;
    public String y;
    public List<Poi> z;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p a;

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.H) {
                this.a.H = false;
                boolean unused = this.a.I;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p a;

        public b(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pVar;
        }

        public /* synthetic */ b(p pVar, q qVar) {
            this(pVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.N) {
                    this.a.N = false;
                }
                if (this.a.t) {
                    this.a.t = false;
                    this.a.h(null);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1037723748, "Lcom/baidu/location/b/p;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1037723748, "Lcom/baidu/location/b/p;");
        }
    }

    public p() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = true;
        this.e = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = true;
        this.s = false;
        this.t = false;
        this.u = 0L;
        this.v = 0L;
        this.w = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.D = false;
        this.E = 0L;
        this.F = 0L;
        this.G = null;
        this.H = false;
        this.I = false;
        this.J = true;
        this.g = new m.a(this);
        this.K = false;
        this.L = false;
        this.M = null;
        this.N = false;
        this.O = 0;
        this.P = 0L;
        this.Q = false;
        this.R = null;
        this.S = false;
        this.f1040T = false;
        this.U = false;
        this.V = true;
        this.e = new m.b(this);
    }

    private boolean a(com.baidu.location.c.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, aVar)) == null) {
            com.baidu.location.c.a f2 = com.baidu.location.c.b.a().f();
            this.b = f2;
            if (f2 == aVar) {
                return false;
            }
            if (f2 == null || aVar == null) {
                return true;
            }
            return !aVar.a(f2);
        }
        return invokeL.booleanValue;
    }

    private boolean a(com.baidu.location.c.j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, jVar)) == null) {
            com.baidu.location.c.j o = com.baidu.location.c.k.a().o();
            this.a = o;
            if (jVar == o) {
                return false;
            }
            if (o == null || jVar == null) {
                return true;
            }
            return !jVar.c(o);
        }
        return invokeL.booleanValue;
    }

    private void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, str) == null) {
            this.f1040T = str != null && "subway".equals(str.toLowerCase());
        }
    }

    public static synchronized p c() {
        InterceptResult invokeV;
        p pVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            synchronized (p.class) {
                if (i == null) {
                    i = new p();
                }
                pVar = i;
            }
            return pVar;
        }
        return (p) invokeV.objValue;
    }

    private void c(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, message) == null) {
            if (!com.baidu.location.e.k.c(com.baidu.location.f.getServiceContext())) {
                BDLocation bDLocation = new BDLocation();
                bDLocation.setLocType(62);
                com.baidu.location.b.b.a().a(bDLocation);
                return;
            }
            if (com.baidu.location.e.k.b()) {
                Log.d("baidu_location_service", "isInforbiddenTime on request location ...");
            }
            if (message.getData().getBoolean("isWaitingLocTag", false)) {
                h = true;
            }
            int d = com.baidu.location.b.b.a().d(message);
            if (d == 1) {
                d(message);
            } else if (d == 2) {
                if (com.baidu.location.c.e.a().j()) {
                    e(message);
                }
            } else if (d != 3 && d != 4) {
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(d)));
            } else {
                g(message);
            }
        }
    }

    private void d(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, message) == null) {
            if (com.baidu.location.c.e.a().j()) {
                e(message);
                t.a().c();
                return;
            }
            g(message);
            t.a().b();
        }
    }

    private void d(BDLocation bDLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, bDLocation) == null) {
            if (com.baidu.location.e.k.l || bDLocation.getMockGpsStrategy() <= 0) {
                com.baidu.location.b.b.a().a(bDLocation);
            } else {
                com.baidu.location.b.b.a().c(bDLocation);
            }
        }
    }

    private void e(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, this, message) == null) {
            BDLocation bDLocation = new BDLocation(com.baidu.location.c.e.a().f());
            Location g = com.baidu.location.c.e.a().g();
            if (g != null && BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU.equals(g.getProvider())) {
                bDLocation.setGnssProvider(BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU);
            }
            if (g != null) {
                bDLocation.setExtrainfo(g.getExtras());
            }
            if (com.baidu.location.e.k.e.equals("all") || com.baidu.location.e.k.g || com.baidu.location.e.k.i) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.C, this.B, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    Address address = this.w;
                    if (address != null) {
                        bDLocation.setAddr(address);
                    }
                    String str = this.y;
                    if (str != null) {
                        bDLocation.setLocationDescribe(str);
                    }
                    List<Poi> list = this.z;
                    if (list != null) {
                        bDLocation.setPoiList(list);
                    }
                    PoiRegion poiRegion = this.A;
                    if (poiRegion != null) {
                        bDLocation.setPoiRegion(poiRegion);
                    }
                } else {
                    this.D = true;
                    g(null);
                }
            }
            this.l = bDLocation;
            this.m = null;
            d(bDLocation);
        }
    }

    private void e(BDLocation bDLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, bDLocation) == null) {
            this.U = bDLocation != null && bDLocation.isInIndoorPark();
        }
    }

    private void f(Message message) {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, message) == null) {
            if (!com.baidu.location.c.k.a().f()) {
                h(message);
                return;
            }
            this.t = true;
            if (this.M == null) {
                this.M = new b(this, null);
            }
            if (this.N && (bVar = this.M) != null) {
                this.g.removeCallbacks(bVar);
            }
            this.g.postDelayed(this.M, 3500L);
            this.N = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, this, message) == null) {
            this.O = 0;
            if (!this.r) {
                f(message);
                this.F = SystemClock.uptimeMillis();
                return;
            }
            this.O = 1;
            this.F = SystemClock.uptimeMillis();
            if (com.baidu.location.c.k.a().j()) {
                f(message);
            } else {
                h(message);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a2, code lost:
        if (r6 <= 0) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h(Message message) {
        String str;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, this, message) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.u;
            if (!this.s || currentTimeMillis > 12000) {
                if (System.currentTimeMillis() - this.u > 0 && System.currentTimeMillis() - this.u < 1000) {
                    if (this.l != null) {
                        com.baidu.location.b.b.a().a(this.l);
                    }
                    m();
                    return;
                }
                this.s = true;
                this.j = a(this.o);
                if (!a(this.n) && !this.j && this.l != null && !this.D) {
                    if (this.m != null && System.currentTimeMillis() - this.v > 30000) {
                        this.l = this.m;
                        this.m = null;
                    }
                    if (t.a().d()) {
                        this.l.setDirection(t.a().e());
                    }
                    if (this.l.getLocType() == 62) {
                        j = System.currentTimeMillis() - this.P;
                    }
                    j = 0;
                    if (this.l.getLocType() == 61 || this.l.getLocType() == 161 || (this.l.getLocType() == 62 && j < 15000)) {
                        com.baidu.location.b.b.a().a(this.l);
                        m();
                        return;
                    }
                }
                this.u = System.currentTimeMillis();
                String a2 = a((String) null);
                this.L = false;
                if (a2 == null) {
                    this.L = true;
                    this.P = System.currentTimeMillis();
                    String[] strArr = new String[2];
                    try {
                        strArr = l();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (currentTimeMillis2 - this.E > 60000) {
                        this.E = currentTimeMillis2;
                    }
                    String l = com.baidu.location.c.k.a().l();
                    if (l != null) {
                        str = l + b() + strArr[0];
                    } else {
                        str = "" + b() + strArr[0];
                    }
                    com.baidu.location.c.a aVar = this.b;
                    if (aVar != null && aVar.h() != null) {
                        str = this.b.h() + str;
                    }
                    String a3 = com.baidu.location.e.b.a().a(true);
                    if (a3 != null) {
                        str = str + a3;
                    }
                } else {
                    str = a2 + com.baidu.location.e.k.d(com.baidu.location.f.getServiceContext());
                }
                if (this.k != null) {
                    str = str + this.k;
                    this.k = null;
                }
                String str2 = str + c.a().c();
                com.baidu.location.c.j jVar = this.a;
                this.e.a(str2, jVar != null ? jVar.f() : 0L);
                this.o = this.b;
                this.n = this.a;
                if (this.r) {
                    this.r = false;
                    if (com.baidu.location.c.k.a().i() && message != null) {
                        com.baidu.location.b.b.a().e(message);
                    }
                }
                int i2 = this.O;
                if (i2 > 0) {
                    if (i2 == 2) {
                        com.baidu.location.c.k.a().f();
                    }
                    this.O = 0;
                }
            }
        }
    }

    private String[] l() {
        InterceptResult invokeV;
        boolean z;
        d a2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, this)) == null) {
            String[] strArr = {"", "Location failed beacuse we can not get any loc information!"};
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("&apl=");
            int a3 = com.baidu.location.e.k.a(com.baidu.location.f.getServiceContext());
            String str = "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!";
            if (a3 == 1) {
                strArr[1] = "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!";
            }
            stringBuffer.append(a3);
            String d = com.baidu.location.e.k.d(com.baidu.location.f.getServiceContext());
            if (d.contains("0|0|")) {
                strArr[1] = "Location failed beacuse we can not get any loc information without any location permission!";
            }
            stringBuffer.append(d);
            if (Build.VERSION.SDK_INT >= 23) {
                stringBuffer.append("&loc=");
                int b2 = com.baidu.location.e.k.b(com.baidu.location.f.getServiceContext());
                if (b2 == 0) {
                    strArr[1] = "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!";
                    z = true;
                } else {
                    z = false;
                }
                stringBuffer.append(b2);
            } else {
                z = false;
            }
            if (Build.VERSION.SDK_INT >= 19) {
                stringBuffer.append("&lmd=");
                int b3 = com.baidu.location.e.k.b(com.baidu.location.f.getServiceContext());
                if (b3 >= 0) {
                    stringBuffer.append(b3);
                }
            }
            String g = com.baidu.location.c.b.a().g();
            String g2 = com.baidu.location.c.k.a().g();
            stringBuffer.append(g2);
            stringBuffer.append(g);
            stringBuffer.append(com.baidu.location.e.k.e(com.baidu.location.f.getServiceContext()));
            if (a3 != 1) {
                if (d.contains("0|0|")) {
                    d.a().a(62, 4, "Location failed beacuse we can not get any loc information without any location permission!");
                } else if (z) {
                    d.a().a(62, 5, "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!");
                } else if (g == null || g2 == null || !g.equals("&sim=1") || g2.equals("&wifio=1")) {
                    d.a().a(62, 9, "Location failed beacuse we can not get any loc information!");
                } else {
                    a2 = d.a();
                    i2 = 6;
                    str = "Location failed beacuse we can not get any loc information , you can insert a sim card or open wifi and try again!";
                }
                strArr[0] = stringBuffer.toString();
                return strArr;
            }
            a2 = d.a();
            i2 = 7;
            a2.a(62, i2, str);
            strArr[0] = stringBuffer.toString();
            return strArr;
        }
        return (String[]) invokeV.objValue;
    }

    private void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            this.s = false;
            this.I = false;
            this.J = false;
            this.D = false;
            n();
            if (this.V) {
                this.V = false;
            }
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65561, this) == null) && this.l != null && com.baidu.location.c.k.a().i()) {
            z.a().d();
        }
    }

    public Address a(BDLocation bDLocation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bDLocation)) == null) {
            if (com.baidu.location.e.k.e.equals("all") || com.baidu.location.e.k.g || com.baidu.location.e.k.i) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.C, this.B, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                if (fArr[0] < 100.0d) {
                    Address address = this.w;
                    if (address != null) {
                        return address;
                    }
                } else {
                    this.y = null;
                    this.z = null;
                    this.A = null;
                    this.D = true;
                    this.g.post(new q(this));
                }
            }
            return null;
        }
        return (Address) invokeL.objValue;
    }

    @Override // com.baidu.location.b.m
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a aVar = this.G;
            if (aVar != null && this.H) {
                this.H = false;
                this.g.removeCallbacks(aVar);
            }
            if (com.baidu.location.c.e.a().j()) {
                BDLocation bDLocation = new BDLocation(com.baidu.location.c.e.a().f());
                Location g = com.baidu.location.c.e.a().g();
                if (g != null && BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU.equals(g.getProvider())) {
                    bDLocation.setGnssProvider(BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU);
                }
                if (g != null) {
                    bDLocation.setExtrainfo(g.getExtras());
                }
                if (com.baidu.location.e.k.e.equals("all") || com.baidu.location.e.k.g || com.baidu.location.e.k.i) {
                    float[] fArr = new float[2];
                    Location.distanceBetween(this.C, this.B, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                    if (fArr[0] < 100.0f) {
                        Address address = this.w;
                        if (address != null) {
                            bDLocation.setAddr(address);
                        }
                        String str = this.y;
                        if (str != null) {
                            bDLocation.setLocationDescribe(str);
                        }
                        List<Poi> list = this.z;
                        if (list != null) {
                            bDLocation.setPoiList(list);
                        }
                        PoiRegion poiRegion = this.A;
                        if (poiRegion != null) {
                            bDLocation.setPoiRegion(poiRegion);
                        }
                    }
                }
                com.baidu.location.b.b.a().a(bDLocation);
            } else if (this.I) {
                m();
                return;
            } else {
                if (this.j || this.l == null) {
                    BDLocation bDLocation2 = new BDLocation();
                    bDLocation2.setLocType(63);
                    this.l = null;
                    com.baidu.location.b.b.a().a(bDLocation2);
                } else {
                    com.baidu.location.b.b.a().a(this.l);
                }
                this.m = null;
            }
            m();
        }
    }

    @Override // com.baidu.location.b.m
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
            a aVar = this.G;
            if (aVar != null && this.H) {
                this.H = false;
                this.g.removeCallbacks(aVar);
            }
            BDLocation bDLocation = (BDLocation) message.obj;
            int i2 = message.arg1;
            if (bDLocation != null && bDLocation.getLocType() == 161) {
                b(bDLocation.getTraffic());
                e(bDLocation);
                if (i2 == 1) {
                    c.a().a(bDLocation, "gcj02", null);
                }
            }
            if (bDLocation != null && bDLocation.getLocType() == 167 && this.L) {
                bDLocation.setLocType(62);
            }
            b(bDLocation);
        }
    }

    public void b(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, message) == null) && this.K) {
            c(message);
        }
    }

    public void b(BDLocation bDLocation) {
        String g;
        int b2;
        com.baidu.location.c.j jVar;
        BDLocation bDLocation2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bDLocation) == null) {
            new BDLocation(bDLocation);
            if (bDLocation.hasAddr()) {
                Address address = bDLocation.getAddress();
                this.w = address;
                if (address != null && (str = address.cityCode) != null) {
                    f = str;
                    this.x = System.currentTimeMillis();
                }
                this.B = bDLocation.getLongitude();
                this.C = bDLocation.getLatitude();
            }
            if (bDLocation.getLocationDescribe() != null) {
                this.y = bDLocation.getLocationDescribe();
                this.B = bDLocation.getLongitude();
                this.C = bDLocation.getLatitude();
            }
            if (bDLocation.getPoiList() != null) {
                this.z = bDLocation.getPoiList();
                this.B = bDLocation.getLongitude();
                this.C = bDLocation.getLatitude();
            }
            if (bDLocation.getPoiRegion() != null) {
                this.A = bDLocation.getPoiRegion();
                this.B = bDLocation.getLongitude();
                this.C = bDLocation.getLatitude();
            }
            boolean z = false;
            if (com.baidu.location.c.e.a().j()) {
                BDLocation bDLocation3 = new BDLocation(com.baidu.location.c.e.a().f());
                Location g2 = com.baidu.location.c.e.a().g();
                if (g2 != null && BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU.equals(g2.getProvider())) {
                    bDLocation3.setGnssProvider(BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU);
                }
                if (g2 != null) {
                    bDLocation3.setExtrainfo(g2.getExtras());
                }
                if (com.baidu.location.e.k.e.equals("all") || com.baidu.location.e.k.g || com.baidu.location.e.k.i) {
                    float[] fArr = new float[2];
                    Location.distanceBetween(this.C, this.B, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                    if (fArr[0] < 100.0f) {
                        Address address2 = this.w;
                        if (address2 != null) {
                            bDLocation3.setAddr(address2);
                        }
                        String str2 = this.y;
                        if (str2 != null) {
                            bDLocation3.setLocationDescribe(str2);
                        }
                        List<Poi> list = this.z;
                        if (list != null) {
                            bDLocation3.setPoiList(list);
                        }
                        PoiRegion poiRegion = this.A;
                        if (poiRegion != null) {
                            bDLocation3.setPoiRegion(poiRegion);
                        }
                    }
                }
                d(bDLocation3);
                m();
            } else if (this.I) {
                float[] fArr2 = new float[2];
                BDLocation bDLocation4 = this.l;
                if (bDLocation4 != null) {
                    Location.distanceBetween(bDLocation4.getLatitude(), this.l.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
                }
                if (fArr2[0] <= 10.0f) {
                    if (bDLocation.getUserIndoorState() > -1) {
                        this.l = bDLocation;
                        com.baidu.location.b.b.a().a(bDLocation);
                    }
                    m();
                }
                this.l = bDLocation;
                if (!this.J) {
                    this.J = false;
                    com.baidu.location.b.b.a().a(bDLocation);
                }
                m();
            } else {
                if (bDLocation.getLocType() == 167) {
                    d.a().a(167, 8, "NetWork location failed because baidu location service can not caculate the location!");
                } else if (bDLocation.getLocType() == 161) {
                    if (Build.VERSION.SDK_INT >= 19 && ((b2 = com.baidu.location.e.k.b(com.baidu.location.f.getServiceContext())) == 0 || b2 == 2)) {
                        d.a().a(161, 1, "NetWork location successful, open gps will be better!");
                    } else if (bDLocation.getRadius() >= 100.0f && bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("cl") && (g = com.baidu.location.c.k.a().g()) != null && !g.equals("&wifio=1")) {
                        d.a().a(161, 2, "NetWork location successful, open wifi will be better!");
                    }
                }
                this.m = null;
                if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && (bDLocation2 = this.l) != null && bDLocation2.getLocType() == 161 && "wf".equals(this.l.getNetworkLocationType()) && System.currentTimeMillis() - this.v < 30000) {
                    this.m = bDLocation;
                    z = true;
                }
                com.baidu.location.b.b a2 = com.baidu.location.b.b.a();
                if (z) {
                    a2.a(this.l);
                } else {
                    a2.a(bDLocation);
                    this.v = System.currentTimeMillis();
                }
                if (!com.baidu.location.e.k.a(bDLocation)) {
                    this.l = null;
                } else if (!z) {
                    this.l = bDLocation;
                }
                int a3 = com.baidu.location.e.k.a(m.c, "ssid\":\"", "\"");
                if (a3 == Integer.MIN_VALUE || (jVar = this.n) == null) {
                    this.k = null;
                } else {
                    this.k = jVar.b(a3);
                }
                com.baidu.location.c.k.a().i();
                m();
            }
        }
    }

    public void c(BDLocation bDLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bDLocation) == null) {
            this.l = new BDLocation(bDLocation);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.r = true;
            this.s = false;
            this.K = true;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.s = false;
            this.t = false;
            this.I = false;
            this.J = true;
            k();
            this.K = false;
        }
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.y : (String) invokeV.objValue;
    }

    public List<Poi> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.z : (List) invokeV.objValue;
    }

    public PoiRegion h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.A : (PoiRegion) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.t) {
            h(null);
            this.t = false;
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.U : invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.l = null;
        }
    }
}
