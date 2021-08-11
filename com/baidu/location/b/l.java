package com.baidu.location.b;

import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Poi;
import com.baidu.location.b.i;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class l extends i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f40889g;

    /* renamed from: h  reason: collision with root package name */
    public static l f40890h;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public long B;
    public long C;
    public a D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public b J;
    public boolean K;
    public int L;
    public long M;
    public boolean N;
    public boolean O;

    /* renamed from: e  reason: collision with root package name */
    public i.b f40891e;

    /* renamed from: f  reason: collision with root package name */
    public final Handler f40892f;

    /* renamed from: i  reason: collision with root package name */
    public boolean f40893i;

    /* renamed from: j  reason: collision with root package name */
    public String f40894j;
    public BDLocation k;
    public BDLocation l;
    public com.baidu.location.c.h m;
    public com.baidu.location.c.a n;
    public com.baidu.location.c.h o;
    public com.baidu.location.c.a p;
    public boolean q;
    public volatile boolean r;
    public boolean s;
    public long t;
    public long u;
    public Address v;
    public String w;
    public List<Poi> x;
    public double y;
    public double z;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f40895a;

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f40895a.E) {
                this.f40895a.E = false;
                boolean unused = this.f40895a.F;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f40896a;

        public b(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40896a = lVar;
        }

        public /* synthetic */ b(l lVar, m mVar) {
            this(lVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f40896a.K) {
                    this.f40896a.K = false;
                }
                if (this.f40896a.s) {
                    this.f40896a.s = false;
                    this.f40896a.h(null);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1037723624, "Lcom/baidu/location/b/l;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1037723624, "Lcom/baidu/location/b/l;");
        }
    }

    public l() {
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
        this.f40893i = true;
        this.f40891e = null;
        this.f40894j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = true;
        this.r = false;
        this.s = false;
        this.t = 0L;
        this.u = 0L;
        this.v = null;
        this.w = null;
        this.x = null;
        this.A = false;
        this.B = 0L;
        this.C = 0L;
        this.D = null;
        this.E = false;
        this.F = false;
        this.G = true;
        this.f40892f = new i.a(this);
        this.H = false;
        this.I = false;
        this.J = null;
        this.K = false;
        this.L = 0;
        this.M = 0L;
        this.N = false;
        this.O = true;
        this.f40891e = new i.b(this);
    }

    private boolean a(com.baidu.location.c.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, aVar)) == null) {
            com.baidu.location.c.a f2 = com.baidu.location.c.b.a().f();
            this.f40851b = f2;
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

    private boolean a(com.baidu.location.c.h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, hVar)) == null) {
            com.baidu.location.c.h o = com.baidu.location.c.i.a().o();
            this.f40850a = o;
            if (hVar == o) {
                return false;
            }
            if (o == null || hVar == null) {
                return true;
            }
            return !hVar.c(o);
        }
        return invokeL.booleanValue;
    }

    public static synchronized l c() {
        InterceptResult invokeV;
        l lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            synchronized (l.class) {
                if (f40890h == null) {
                    f40890h = new l();
                }
                lVar = f40890h;
            }
            return lVar;
        }
        return (l) invokeV.objValue;
    }

    private void c(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, message) == null) {
            if (com.baidu.location.e.k.b()) {
                String str = com.baidu.location.e.a.f41019a;
            }
            if (message.getData().getBoolean("isWaitingLocTag", false)) {
                f40889g = true;
            }
            int d2 = com.baidu.location.b.a.a().d(message);
            if (d2 == 1) {
                d(message);
            } else if (d2 == 2) {
                g(message);
            } else if (d2 != 3) {
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(d2)));
            } else {
                if (com.baidu.location.c.e.a().i()) {
                    e(message);
                }
            }
        }
    }

    private void d(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, message) == null) {
            if (com.baidu.location.c.e.a().i()) {
                e(message);
                n.a().c();
                return;
            }
            g(message);
            n.a().b();
        }
    }

    private void e(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, message) == null) {
            BDLocation bDLocation = new BDLocation(com.baidu.location.c.e.a().f());
            if (com.baidu.location.e.k.f41080g.equals("all") || com.baidu.location.e.k.f41081h || com.baidu.location.e.k.f41083j) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.z, this.y, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    Address address = this.v;
                    if (address != null) {
                        bDLocation.setAddr(address);
                    }
                    String str = this.w;
                    if (str != null) {
                        bDLocation.setLocationDescribe(str);
                    }
                    List<Poi> list = this.x;
                    if (list != null) {
                        bDLocation.setPoiList(list);
                    }
                } else {
                    this.A = true;
                    g(null);
                }
            }
            this.k = bDLocation;
            this.l = null;
            com.baidu.location.b.a.a().a(bDLocation);
        }
    }

    private void f(Message message) {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, message) == null) {
            if (!com.baidu.location.c.i.a().f()) {
                h(message);
                return;
            }
            this.s = true;
            if (this.J == null) {
                this.J = new b(this, null);
            }
            if (this.K && (bVar = this.J) != null) {
                this.f40892f.removeCallbacks(bVar);
            }
            this.f40892f.postDelayed(this.J, 3500L);
            this.K = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, this, message) == null) {
            this.L = 0;
            if (!this.q) {
                f(message);
                this.C = SystemClock.uptimeMillis();
                return;
            }
            this.L = 1;
            this.C = SystemClock.uptimeMillis();
            if (com.baidu.location.c.i.a().j()) {
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
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, message) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.t;
            if (!this.r || currentTimeMillis > 12000) {
                if (System.currentTimeMillis() - this.t > 0 && System.currentTimeMillis() - this.t < 1000) {
                    if (this.k != null) {
                        com.baidu.location.b.a.a().a(this.k);
                    }
                    k();
                    return;
                }
                this.r = true;
                this.f40893i = a(this.n);
                if (!a(this.m) && !this.f40893i && this.k != null && !this.A) {
                    if (this.l != null && System.currentTimeMillis() - this.u > 30000) {
                        this.k = this.l;
                        this.l = null;
                    }
                    if (n.a().d()) {
                        this.k.setDirection(n.a().e());
                    }
                    if (this.k.getLocType() == 62) {
                        j2 = System.currentTimeMillis() - this.M;
                    }
                    j2 = 0;
                    if (this.k.getLocType() == 61 || this.k.getLocType() == 161 || (this.k.getLocType() == 62 && j2 < 15000)) {
                        com.baidu.location.b.a.a().a(this.k);
                        k();
                        return;
                    }
                }
                this.t = System.currentTimeMillis();
                String a2 = a((String) null);
                this.I = false;
                if (a2 == null) {
                    this.I = true;
                    this.M = System.currentTimeMillis();
                    String[] j3 = j();
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (currentTimeMillis2 - this.B > 60000) {
                        this.B = currentTimeMillis2;
                    }
                    String l = com.baidu.location.c.i.a().l();
                    if (l != null) {
                        a2 = l + b() + j3[0];
                    } else {
                        a2 = "" + b() + j3[0];
                    }
                    com.baidu.location.c.a aVar = this.f40851b;
                    if (aVar != null && aVar.g() != null) {
                        a2 = this.f40851b.g() + a2;
                    }
                    String a3 = com.baidu.location.e.b.a().a(true);
                    if (a3 != null) {
                        a2 = a2 + a3;
                    }
                }
                if (this.f40894j != null) {
                    a2 = a2 + this.f40894j;
                    this.f40894j = null;
                }
                com.baidu.location.c.h hVar = this.f40850a;
                this.f40891e.a(a2, hVar != null ? hVar.f() : 0L);
                this.n = this.f40851b;
                this.m = this.f40850a;
                if (this.q) {
                    this.q = false;
                    if (com.baidu.location.c.i.i() && message != null) {
                        com.baidu.location.b.a.a().e(message);
                    }
                }
                int i2 = this.L;
                if (i2 > 0) {
                    if (i2 == 2) {
                        com.baidu.location.c.i.a().f();
                    }
                    this.L = 0;
                }
            }
        }
    }

    private String[] j() {
        InterceptResult invokeV;
        boolean z;
        com.baidu.location.b.b a2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) {
            String[] strArr = {"", "Location failed beacuse we can not get any loc information!"};
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("&apl=");
            int a3 = com.baidu.location.e.k.a(com.baidu.location.f.getServiceContext());
            String str = "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!";
            if (a3 == 1) {
                strArr[1] = "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!";
            }
            stringBuffer.append(a3);
            String c2 = com.baidu.location.e.k.c(com.baidu.location.f.getServiceContext());
            if (c2.contains("0|0|")) {
                strArr[1] = "Location failed beacuse we can not get any loc information without any location permission!";
            }
            stringBuffer.append(c2);
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
            String g2 = com.baidu.location.c.b.a().g();
            String g3 = com.baidu.location.c.i.a().g();
            stringBuffer.append(g3);
            stringBuffer.append(g2);
            stringBuffer.append(com.baidu.location.e.k.d(com.baidu.location.f.getServiceContext()));
            if (a3 != 1) {
                if (c2.contains("0|0|")) {
                    com.baidu.location.b.b.a().a(62, 4, "Location failed beacuse we can not get any loc information without any location permission!");
                } else if (z) {
                    com.baidu.location.b.b.a().a(62, 5, "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!");
                } else if (g2 == null || g3 == null || !g2.equals("&sim=1") || g3.equals("&wifio=1")) {
                    com.baidu.location.b.b.a().a(62, 9, "Location failed beacuse we can not get any loc information!");
                } else {
                    a2 = com.baidu.location.b.b.a();
                    i2 = 6;
                    str = "Location failed beacuse we can not get any loc information , you can insert a sim card or open wifi and try again!";
                }
                strArr[0] = stringBuffer.toString();
                return strArr;
            }
            a2 = com.baidu.location.b.b.a();
            i2 = 7;
            a2.a(62, i2, str);
            strArr[0] = stringBuffer.toString();
            return strArr;
        }
        return (String[]) invokeV.objValue;
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            this.r = false;
            this.F = false;
            this.G = false;
            this.A = false;
            l();
            if (this.O) {
                this.O = false;
            }
        }
    }

    private void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65558, this) == null) && this.k != null && com.baidu.location.c.i.i()) {
            x.a().d();
        }
    }

    public Address a(BDLocation bDLocation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bDLocation)) == null) {
            if (com.baidu.location.e.k.f41080g.equals("all") || com.baidu.location.e.k.f41081h || com.baidu.location.e.k.f41083j) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.z, this.y, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    Address address = this.v;
                    if (address != null) {
                        return address;
                    }
                } else {
                    this.w = null;
                    this.x = null;
                    this.A = true;
                    this.f40892f.post(new m(this));
                }
            }
            return null;
        }
        return (Address) invokeL.objValue;
    }

    @Override // com.baidu.location.b.i
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a aVar = this.D;
            if (aVar != null && this.E) {
                this.E = false;
                this.f40892f.removeCallbacks(aVar);
            }
            if (com.baidu.location.c.e.a().i()) {
                BDLocation bDLocation = new BDLocation(com.baidu.location.c.e.a().f());
                if (com.baidu.location.e.k.f41080g.equals("all") || com.baidu.location.e.k.f41081h || com.baidu.location.e.k.f41083j) {
                    float[] fArr = new float[2];
                    Location.distanceBetween(this.z, this.y, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                    if (fArr[0] < 100.0f) {
                        Address address = this.v;
                        if (address != null) {
                            bDLocation.setAddr(address);
                        }
                        String str = this.w;
                        if (str != null) {
                            bDLocation.setLocationDescribe(str);
                        }
                        List<Poi> list = this.x;
                        if (list != null) {
                            bDLocation.setPoiList(list);
                        }
                    }
                }
                com.baidu.location.b.a.a().a(bDLocation);
            } else if (this.F) {
                k();
                return;
            } else {
                if (this.f40893i || this.k == null) {
                    BDLocation bDLocation2 = new BDLocation();
                    bDLocation2.setLocType(63);
                    this.k = null;
                    com.baidu.location.b.a.a().a(bDLocation2);
                } else {
                    com.baidu.location.b.a.a().a(this.k);
                }
                this.l = null;
            }
            k();
        }
    }

    @Override // com.baidu.location.b.i
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
            a aVar = this.D;
            if (aVar != null && this.E) {
                this.E = false;
                this.f40892f.removeCallbacks(aVar);
            }
            BDLocation bDLocation = (BDLocation) message.obj;
            if (bDLocation != null && bDLocation.getLocType() == 167 && this.I) {
                bDLocation.setLocType(62);
            }
            b(bDLocation);
        }
    }

    public void b(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, message) == null) && this.H) {
            c(message);
        }
    }

    public void b(BDLocation bDLocation) {
        String g2;
        int b2;
        com.baidu.location.c.h hVar;
        BDLocation bDLocation2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bDLocation) == null) {
            new BDLocation(bDLocation);
            if (bDLocation.hasAddr()) {
                this.v = bDLocation.getAddress();
                this.y = bDLocation.getLongitude();
                this.z = bDLocation.getLatitude();
            }
            if (bDLocation.getLocationDescribe() != null) {
                this.w = bDLocation.getLocationDescribe();
                this.y = bDLocation.getLongitude();
                this.z = bDLocation.getLatitude();
            }
            if (bDLocation.getPoiList() != null) {
                this.x = bDLocation.getPoiList();
                this.y = bDLocation.getLongitude();
                this.z = bDLocation.getLatitude();
            }
            boolean z = false;
            if (com.baidu.location.c.e.a().i()) {
                BDLocation bDLocation3 = new BDLocation(com.baidu.location.c.e.a().f());
                if (com.baidu.location.e.k.f41080g.equals("all") || com.baidu.location.e.k.f41081h || com.baidu.location.e.k.f41083j) {
                    float[] fArr = new float[2];
                    Location.distanceBetween(this.z, this.y, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                    if (fArr[0] < 100.0f) {
                        Address address = this.v;
                        if (address != null) {
                            bDLocation3.setAddr(address);
                        }
                        String str = this.w;
                        if (str != null) {
                            bDLocation3.setLocationDescribe(str);
                        }
                        List<Poi> list = this.x;
                        if (list != null) {
                            bDLocation3.setPoiList(list);
                        }
                    }
                }
                com.baidu.location.b.a.a().a(bDLocation3);
                k();
            } else if (this.F) {
                float[] fArr2 = new float[2];
                BDLocation bDLocation4 = this.k;
                if (bDLocation4 != null) {
                    Location.distanceBetween(bDLocation4.getLatitude(), this.k.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
                }
                if (fArr2[0] <= 10.0f) {
                    if (bDLocation.getUserIndoorState() > -1) {
                        this.k = bDLocation;
                        com.baidu.location.b.a.a().a(bDLocation);
                    }
                    k();
                }
                this.k = bDLocation;
                if (!this.G) {
                    this.G = false;
                    com.baidu.location.b.a.a().a(bDLocation);
                }
                k();
            } else {
                if (bDLocation.getLocType() == 167) {
                    com.baidu.location.b.b.a().a(167, 8, "NetWork location failed because baidu location service can not caculate the location!");
                } else if (bDLocation.getLocType() == 161) {
                    if (Build.VERSION.SDK_INT >= 19 && ((b2 = com.baidu.location.e.k.b(com.baidu.location.f.getServiceContext())) == 0 || b2 == 2)) {
                        com.baidu.location.b.b.a().a(161, 1, "NetWork location successful, open gps will be better!");
                    } else if (bDLocation.getRadius() >= 100.0f && bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("cl") && (g2 = com.baidu.location.c.i.a().g()) != null && !g2.equals("&wifio=1")) {
                        com.baidu.location.b.b.a().a(161, 2, "NetWork location successful, open wifi will be better!");
                    }
                }
                this.l = null;
                if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && (bDLocation2 = this.k) != null && bDLocation2.getLocType() == 161 && "wf".equals(this.k.getNetworkLocationType()) && System.currentTimeMillis() - this.u < 30000) {
                    this.l = bDLocation;
                    z = true;
                }
                com.baidu.location.b.a a2 = com.baidu.location.b.a.a();
                if (z) {
                    a2.a(this.k);
                } else {
                    a2.a(bDLocation);
                    this.u = System.currentTimeMillis();
                }
                if (!com.baidu.location.e.k.a(bDLocation)) {
                    this.k = null;
                } else if (!z) {
                    this.k = bDLocation;
                }
                int a3 = com.baidu.location.e.k.a(i.f40849c, "ssid\":\"", "\"");
                if (a3 == Integer.MIN_VALUE || (hVar = this.m) == null) {
                    this.f40894j = null;
                } else {
                    this.f40894j = hVar.b(a3);
                }
                com.baidu.location.c.i.i();
                k();
            }
        }
    }

    public void c(BDLocation bDLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bDLocation) == null) {
            this.k = new BDLocation(bDLocation);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.q = true;
            this.r = false;
            this.H = true;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.r = false;
            this.s = false;
            this.F = false;
            this.G = true;
            i();
            this.H = false;
        }
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.w : (String) invokeV.objValue;
    }

    public List<Poi> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.x : (List) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.s) {
            h(null);
            this.s = false;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.k = null;
        }
    }
}
