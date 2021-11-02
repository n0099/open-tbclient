package b.a.e.e.n.j;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.n.o.j;
import com.android.internal.http.multipart.Part;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f1934a;

    /* renamed from: b  reason: collision with root package name */
    public StringBuffer f1935b;

    /* renamed from: c  reason: collision with root package name */
    public StringBuffer f1936c;

    /* renamed from: d  reason: collision with root package name */
    public StringBuffer f1937d;

    /* renamed from: e  reason: collision with root package name */
    public int f1938e;

    /* renamed from: f  reason: collision with root package name */
    public int f1939f;

    /* renamed from: g  reason: collision with root package name */
    public int f1940g;

    /* renamed from: h  reason: collision with root package name */
    public long f1941h;

    /* renamed from: i  reason: collision with root package name */
    public long f1942i;
    public long j;
    public long k;
    public long l;
    public long m;
    public long n;
    public String o;
    public boolean p;
    public boolean q;
    public String r;
    public boolean s;
    public boolean t;
    public boolean u;
    public j v;

    public a(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1935b = new StringBuffer();
        this.f1936c = new StringBuffer();
        this.f1937d = new StringBuffer();
        this.f1938e = 0;
        this.f1939f = 0;
        this.f1940g = 0;
        this.f1941h = 0L;
        this.f1942i = 0L;
        this.j = 0L;
        this.k = 0L;
        this.l = 0L;
        this.m = 0L;
        this.n = 0L;
        this.p = false;
        this.q = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = jVar;
    }

    public static String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? ("net".equals(str) || "op".equals(str) || "crash".equals(str) || "msg".equals(str)) ? "error" : str : (String) invokeL.objValue;
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.s : invokeV.booleanValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.u : invokeV.booleanValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.t : invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public void F(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.n = j;
        }
    }

    public void G(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.l = j;
        }
    }

    public void H(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.m = j;
        }
    }

    public void I(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f1934a = str;
    }

    public void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.u = z;
        }
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.t = z;
        }
    }

    public void L(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            this.k = j;
        }
    }

    public synchronized void a(b.a.e.e.n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            synchronized (this) {
                if (aVar != null) {
                    try {
                        this.f1935b.append(aVar.toString());
                        this.f1935b.append(Part.CRLF);
                        this.f1938e++;
                    } catch (Exception e2) {
                        BdLog.e(e2);
                    } catch (OutOfMemoryError e3) {
                        e3.printStackTrace();
                    }
                }
                if (this.v != null) {
                    this.v.a(this);
                }
                this.f1941h = System.currentTimeMillis();
            }
        }
    }

    public synchronized void b(b.a.e.e.n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            synchronized (this) {
                if (aVar != null) {
                    try {
                        this.f1936c.append(aVar.toString());
                        this.f1936c.append(Part.CRLF);
                        this.f1939f++;
                    } catch (Exception e2) {
                        BdLog.e(e2);
                    } catch (OutOfMemoryError e3) {
                        e3.printStackTrace();
                    }
                }
                if (this.v != null) {
                    this.v.a(this);
                }
                this.f1942i = System.currentTimeMillis();
            }
        }
    }

    public synchronized void c(b.a.e.e.n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
            synchronized (this) {
                if (aVar != null) {
                    try {
                        if (aVar.f() != null) {
                            this.f1937d.append(aVar.f().c().toString());
                            this.f1937d.append(Part.CRLF);
                            this.f1940g++;
                        }
                    } catch (Exception e2) {
                        BdLog.e(e2);
                    } catch (OutOfMemoryError e3) {
                        e3.printStackTrace();
                    }
                }
                if (this.v != null) {
                    this.v.a(this);
                }
                this.j = System.currentTimeMillis();
            }
        }
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            synchronized (this) {
                this.f1935b = new StringBuffer();
                this.f1938e = 0;
                this.l = 0L;
            }
        }
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            synchronized (this) {
                this.f1936c = new StringBuffer();
                this.f1939f = 0;
                this.m = 0L;
            }
        }
    }

    public synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            synchronized (this) {
                this.f1937d = new StringBuffer();
                this.f1940g = 0;
                this.n = 0L;
            }
        }
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.o : (String) invokeV.objValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f1941h : invokeV.longValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f1942i : invokeV.longValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.j : invokeV.longValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f1940g : invokeV.intValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f1938e : invokeV.intValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f1939f : invokeV.intValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f1934a : (String) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? "omp" : (String) invokeV.objValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? ARPScriptEnvironment.KEY_DATA_PIP_TRACK : (String) invokeV.objValue;
    }

    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            StringBuilder sb = new StringBuilder(40);
            sb.append(this.o);
            sb.append(System.currentTimeMillis());
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Uploading");
            sb.append(".log");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (TextUtils.isEmpty(this.r)) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.o);
                sb.append(BdStatisticsManager.getInstance().getProcessName());
                sb.append("Writing");
                sb.append(".log");
                this.r = sb.toString();
            }
            return this.r;
        }
        return (String) invokeV.objValue;
    }

    public long t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.l : invokeV.longValue;
    }

    public long u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.m : invokeV.longValue;
    }

    public long v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.n : invokeV.longValue;
    }

    public long w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.k : invokeV.longValue;
    }

    public StringBuffer x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f1935b : (StringBuffer) invokeV.objValue;
    }

    public StringBuffer y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.f1936c : (StringBuffer) invokeV.objValue;
    }

    public StringBuffer z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f1937d : (StringBuffer) invokeV.objValue;
    }
}
