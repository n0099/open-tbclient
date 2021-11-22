package b.c.b.e0.g;

import b.c.b.b0;
import b.c.b.r;
import b.c.b.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final z f31063a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final b0 f31064b;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final long f31065a;

        /* renamed from: b  reason: collision with root package name */
        public final z f31066b;

        /* renamed from: c  reason: collision with root package name */
        public final b0 f31067c;

        /* renamed from: d  reason: collision with root package name */
        public Date f31068d;

        /* renamed from: e  reason: collision with root package name */
        public String f31069e;

        /* renamed from: f  reason: collision with root package name */
        public Date f31070f;

        /* renamed from: g  reason: collision with root package name */
        public String f31071g;

        /* renamed from: h  reason: collision with root package name */
        public Date f31072h;

        /* renamed from: i  reason: collision with root package name */
        public long f31073i;
        public long j;
        public String k;
        public int l;

        public a(long j, z zVar, b0 b0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), zVar, b0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = -1;
            this.f31065a = j;
            this.f31066b = zVar;
            this.f31067c = b0Var;
            if (b0Var != null) {
                this.f31073i = b0Var.s();
                this.j = b0Var.q();
                r j2 = b0Var.j();
                int g2 = j2.g();
                for (int i4 = 0; i4 < g2; i4++) {
                    String e2 = j2.e(i4);
                    String h2 = j2.h(i4);
                    if ("Date".equalsIgnoreCase(e2)) {
                        this.f31068d = b.c.b.e0.i.d.b(h2);
                        this.f31069e = h2;
                    } else if ("Expires".equalsIgnoreCase(e2)) {
                        this.f31072h = b.c.b.e0.i.d.b(h2);
                    } else if ("Last-Modified".equalsIgnoreCase(e2)) {
                        this.f31070f = b.c.b.e0.i.d.b(h2);
                        this.f31071g = h2;
                    } else if ("ETag".equalsIgnoreCase(e2)) {
                        this.k = h2;
                    } else if ("Age".equalsIgnoreCase(e2)) {
                        this.l = b.c.b.e0.i.e.d(h2, -1);
                    }
                }
            }
        }

        public static boolean e(z zVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, zVar)) == null) ? (zVar.c("If-Modified-Since") == null && zVar.c("If-None-Match") == null) ? false : true : invokeL.booleanValue;
        }

        public final long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Date date = this.f31068d;
                long max = date != null ? Math.max(0L, this.j - date.getTime()) : 0L;
                int i2 = this.l;
                if (i2 != -1) {
                    max = Math.max(max, TimeUnit.SECONDS.toMillis(i2));
                }
                long j = this.j;
                return max + (j - this.f31073i) + (this.f31065a - j);
            }
            return invokeV.longValue;
        }

        public final long b() {
            InterceptResult invokeV;
            long j;
            long j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                b.c.b.d c2 = this.f31067c.c();
                if (c2.d() != -1) {
                    return TimeUnit.SECONDS.toMillis(c2.d());
                }
                if (this.f31072h != null) {
                    Date date = this.f31068d;
                    if (date != null) {
                        j2 = date.getTime();
                    } else {
                        j2 = this.j;
                    }
                    long time = this.f31072h.getTime() - j2;
                    if (time > 0) {
                        return time;
                    }
                    return 0L;
                } else if (this.f31070f == null || this.f31067c.r().h().query() != null) {
                    return 0L;
                } else {
                    Date date2 = this.f31068d;
                    if (date2 != null) {
                        j = date2.getTime();
                    } else {
                        j = this.f31073i;
                    }
                    long time2 = j - this.f31070f.getTime();
                    if (time2 > 0) {
                        return time2 / 10;
                    }
                    return 0L;
                }
            }
            return invokeV.longValue;
        }

        public c c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                c d2 = d();
                return (d2.f31063a == null || !this.f31066b.b().j()) ? d2 : new c(null, null);
            }
            return (c) invokeV.objValue;
        }

        public final c d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.f31067c == null) {
                    return new c(this.f31066b, null);
                }
                if (this.f31066b.e() && this.f31067c.f() == null) {
                    return new c(this.f31066b, null);
                }
                if (!c.a(this.f31067c, this.f31066b)) {
                    return new c(this.f31066b, null);
                }
                b.c.b.d b2 = this.f31066b.b();
                if (!b2.h() && !e(this.f31066b)) {
                    b.c.b.d c2 = this.f31067c.c();
                    long a2 = a();
                    long b3 = b();
                    if (b2.d() != -1) {
                        b3 = Math.min(b3, TimeUnit.SECONDS.toMillis(b2.d()));
                    }
                    long j = 0;
                    long millis = b2.f() != -1 ? TimeUnit.SECONDS.toMillis(b2.f()) : 0L;
                    if (!c2.g() && b2.e() != -1) {
                        j = TimeUnit.SECONDS.toMillis(b2.e());
                    }
                    if (!c2.h()) {
                        long j2 = millis + a2;
                        if (j2 < j + b3) {
                            b0.a n = this.f31067c.n();
                            if (j2 >= b3) {
                                n.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                            }
                            if (a2 > 86400000 && f()) {
                                n.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                            }
                            return new c(null, n.c());
                        }
                    }
                    String str = this.k;
                    String str2 = "If-Modified-Since";
                    if (str != null) {
                        str2 = "If-None-Match";
                    } else if (this.f31070f != null) {
                        str = this.f31071g;
                    } else if (this.f31068d != null) {
                        str = this.f31069e;
                    } else {
                        return new c(this.f31066b, null);
                    }
                    r.a f2 = this.f31066b.d().f();
                    b.c.b.e0.a.f31044a.b(f2, str2, str);
                    z.a g2 = this.f31066b.g();
                    g2.d(f2.d());
                    return new c(g2.b(), this.f31067c);
                }
                return new c(this.f31066b, null);
            }
            return (c) invokeV.objValue;
        }

        public final boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f31067c.c().d() == -1 && this.f31072h == null : invokeV.booleanValue;
        }
    }

    public c(z zVar, b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zVar, b0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31063a = zVar;
        this.f31064b = b0Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x005a, code lost:
        if (r4.c().b() == false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(b0 b0Var, z zVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, b0Var, zVar)) == null) {
            int code = b0Var.code();
            if (code != 200 && code != 410 && code != 414 && code != 501 && code != 203 && code != 204) {
                if (code != 307) {
                    if (code != 308 && code != 404 && code != 405) {
                        switch (code) {
                            case 300:
                            case 301:
                                break;
                            case 302:
                                break;
                            default:
                                return false;
                        }
                    }
                }
                if (b0Var.g("Expires") == null) {
                    if (b0Var.c().d() == -1) {
                        if (!b0Var.c().c()) {
                        }
                    }
                }
            }
            return (b0Var.c().i() || zVar.b().i()) ? false : true;
        }
        return invokeLL.booleanValue;
    }
}
