package b.a.e.e.l;

import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.j;
import b.a.e.e.p.l;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static b f1853a;

    /* renamed from: b  reason: collision with root package name */
    public static final Object f1854b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.e.e.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0031a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1082490072, "Lb/a/e/e/l/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1082490072, "Lb/a/e/e/l/a;");
                return;
            }
        }
        f1853a = new b(null);
        f1854b = new Object();
    }

    public static f a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (j.H()) {
                return f1853a.f1858d;
            }
            if (j.v()) {
                return f1853a.f1857c;
            }
            if (j.u()) {
                return f1853a.f1856b;
            }
            return f1853a.f1855a;
        }
        return (f) invokeV.objValue;
    }

    public static String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? 1 == i2 ? "2G" : 2 == i2 ? "3G" : 3 == i2 ? "4G" : 4 == i2 ? "5G" : 5 == i2 ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : "N" : (String) invokeI.objValue;
    }

    public static void c(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            synchronized (f1854b) {
                f a2 = a();
                if (z) {
                    a2.l++;
                    a2.m += j;
                }
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            f a2 = a();
            if (z) {
                a2.t++;
            }
            if (z2) {
                a2.u++;
            }
            if (z3) {
                a2.v++;
            }
        }
    }

    public static void e(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            f a2 = a();
            if (z) {
                a2.r++;
                a2.s += j;
            }
        }
    }

    public static void f(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            synchronized (f1854b) {
                f a2 = a();
                a2.f1877d++;
                if (z) {
                    a2.f1878e++;
                    a2.f1879f += j;
                }
            }
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, null) == null) || f1853a.a() <= 10) {
            return;
        }
        if (f1853a.e()) {
            h(f1853a.f1858d, 5);
        }
        if (f1853a.b()) {
            h(f1853a.f1857c, 3);
        }
        if (f1853a.c()) {
            h(f1853a.f1856b, 2);
        }
        if (f1853a.d()) {
            h(f1853a.f1855a, 1);
        }
        f1853a.f();
    }

    public static void h(f fVar, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65544, null, fVar, i2) == null) && fVar != null && BdBaseApplication.getInst().isSmallFlow()) {
            b.a.e.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
            statsItem.b("action", "imgStat");
            statsItem.b("memoryCount", String.valueOf(fVar.f1874a));
            statsItem.b("memorySucCount", String.valueOf(fVar.f1875b));
            statsItem.b("memoryTime", String.valueOf(fVar.f1876c));
            statsItem.b("localCount", String.valueOf(fVar.f1877d));
            statsItem.b("localSucCount", String.valueOf(fVar.f1878e));
            statsItem.b("localTime", String.valueOf(fVar.f1879f));
            statsItem.b("netCount", String.valueOf(fVar.f1880g));
            statsItem.b("netSucCount", String.valueOf(fVar.f1881h));
            statsItem.b("netTime", String.valueOf(fVar.f1882i));
            statsItem.b("taskCount", String.valueOf(fVar.j));
            statsItem.b("taskTime", String.valueOf(fVar.k));
            statsItem.b("decodeCount", String.valueOf(fVar.l));
            statsItem.b("decodeTime", String.valueOf(fVar.m));
            statsItem.b("saveMemoryCount", String.valueOf(fVar.n));
            statsItem.b("saveMemoryTime", String.valueOf(fVar.o));
            statsItem.b("saveLocalCount", String.valueOf(fVar.p));
            statsItem.b("saveLocalTime", String.valueOf(fVar.q));
            statsItem.b("memoryHitCount", String.valueOf(fVar.t));
            statsItem.b("localHitCount", String.valueOf(fVar.u));
            statsItem.b("netHitCount", String.valueOf(fVar.v));
            statsItem.b("totalHitCount", String.valueOf(fVar.t + fVar.u + fVar.v));
            statsItem.b("totalCount", String.valueOf(fVar.r));
            statsItem.b("totalTime", String.valueOf(fVar.s));
            statsItem.b("cdnCount", String.valueOf(fVar.w));
            statsItem.b("ipCount", String.valueOf(fVar.x));
            statsItem.b("cdnAndIpCount", String.valueOf(fVar.y));
            statsItem.b("imgSize", String.valueOf(fVar.z));
            statsItem.b("nettype", b(i2));
            BdStatisticsManager.getInstance().performance("image", statsItem);
        }
    }

    public static void i(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            f a2 = a();
            a2.f1874a++;
            if (z) {
                a2.f1875b++;
                a2.f1876c += j;
            }
        }
    }

    public static void j(boolean z, String str, b.a.e.e.j.a.d dVar, long j, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{Boolean.valueOf(z), str, dVar, Long.valueOf(j), Long.valueOf(j2)}) == null) && l.D()) {
            synchronized (f1854b) {
                boolean n = n(str);
                boolean z2 = false;
                if (dVar != null && !StringUtils.isNull(dVar.k)) {
                    z2 = true;
                }
                f a2 = a();
                if (n) {
                    a2.w++;
                }
                if (z2) {
                    a2.x++;
                }
                if (n && z2) {
                    a2.y++;
                }
                a2.f1880g++;
                if (z) {
                    a2.f1881h++;
                    a2.f1882i += j;
                    a2.z += j2;
                }
                if (f1853a.a() > 100) {
                    g();
                }
            }
        }
    }

    public static void k(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            synchronized (f1854b) {
                f a2 = a();
                if (z) {
                    a2.p++;
                    a2.q += j;
                }
            }
        }
    }

    public static void l(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            f a2 = a();
            if (z) {
                a2.n++;
                a2.o += j;
            }
        }
    }

    public static void m(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            synchronized (f1854b) {
                f a2 = a();
                if (z) {
                    a2.j++;
                    a2.k += j;
                }
            }
        }
    }

    public static boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            if (str == null) {
                return false;
            }
            int indexOf = str.indexOf("hiphotos");
            if (indexOf <= 0 || indexOf >= 20) {
                int indexOf2 = str.indexOf("tiebapic");
                return indexOf2 > 0 && indexOf2 < 20;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public f f1855a;

        /* renamed from: b  reason: collision with root package name */
        public f f1856b;

        /* renamed from: c  reason: collision with root package name */
        public f f1857c;

        /* renamed from: d  reason: collision with root package name */
        public f f1858d;

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
            this.f1855a = new f();
            this.f1856b = new f();
            this.f1857c = new f();
            this.f1858d = new f();
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f1855a.f1880g + this.f1856b.f1880g + this.f1857c.f1880g + this.f1858d.f1880g : invokeV.intValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1857c.f1880g > 0 : invokeV.booleanValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f1856b.f1880g > 0 : invokeV.booleanValue;
        }

        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f1855a.f1880g > 0 : invokeV.booleanValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f1858d.f1880g > 0 : invokeV.booleanValue;
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f1855a.a();
                this.f1856b.a();
                this.f1857c.a();
                this.f1858d.a();
            }
        }

        public /* synthetic */ b(C0031a c0031a) {
            this();
        }
    }
}
