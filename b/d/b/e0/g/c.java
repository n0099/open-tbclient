package b.d.b.e0.g;

import b.d.b.b0;
import b.d.b.r;
import b.d.b.z;
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
    public final z f30205a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final b0 f30206b;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final long f30207a;

        /* renamed from: b  reason: collision with root package name */
        public final z f30208b;

        /* renamed from: c  reason: collision with root package name */
        public final b0 f30209c;

        /* renamed from: d  reason: collision with root package name */
        public Date f30210d;

        /* renamed from: e  reason: collision with root package name */
        public String f30211e;

        /* renamed from: f  reason: collision with root package name */
        public Date f30212f;

        /* renamed from: g  reason: collision with root package name */
        public String f30213g;

        /* renamed from: h  reason: collision with root package name */
        public Date f30214h;

        /* renamed from: i  reason: collision with root package name */
        public long f30215i;
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
            this.f30207a = j;
            this.f30208b = zVar;
            this.f30209c = b0Var;
            if (b0Var != null) {
                this.f30215i = b0Var.s();
                this.j = b0Var.q();
                r j2 = b0Var.j();
                int g2 = j2.g();
                for (int i4 = 0; i4 < g2; i4++) {
                    String e2 = j2.e(i4);
                    String h2 = j2.h(i4);
                    if ("Date".equalsIgnoreCase(e2)) {
                        this.f30210d = b.d.b.e0.i.d.b(h2);
                        this.f30211e = h2;
                    } else if ("Expires".equalsIgnoreCase(e2)) {
                        this.f30214h = b.d.b.e0.i.d.b(h2);
                    } else if ("Last-Modified".equalsIgnoreCase(e2)) {
                        this.f30212f = b.d.b.e0.i.d.b(h2);
                        this.f30213g = h2;
                    } else if ("ETag".equalsIgnoreCase(e2)) {
                        this.k = h2;
                    } else if ("Age".equalsIgnoreCase(e2)) {
                        this.l = b.d.b.e0.i.e.d(h2, -1);
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
                Date date = this.f30210d;
                long max = date != null ? Math.max(0L, this.j - date.getTime()) : 0L;
                int i2 = this.l;
                if (i2 != -1) {
                    max = Math.max(max, TimeUnit.SECONDS.toMillis(i2));
                }
                long j = this.j;
                return max + (j - this.f30215i) + (this.f30207a - j);
            }
            return invokeV.longValue;
        }

        public final long b() {
            InterceptResult invokeV;
            long j;
            long j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                b.d.b.d c2 = this.f30209c.c();
                if (c2.d() != -1) {
                    return TimeUnit.SECONDS.toMillis(c2.d());
                }
                if (this.f30214h != null) {
                    Date date = this.f30210d;
                    if (date != null) {
                        j2 = date.getTime();
                    } else {
                        j2 = this.j;
                    }
                    long time = this.f30214h.getTime() - j2;
                    if (time > 0) {
                        return time;
                    }
                    return 0L;
                } else if (this.f30212f == null || this.f30209c.r().h().query() != null) {
                    return 0L;
                } else {
                    Date date2 = this.f30210d;
                    if (date2 != null) {
                        j = date2.getTime();
                    } else {
                        j = this.f30215i;
                    }
                    long time2 = j - this.f30212f.getTime();
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
                return (d2.f30205a == null || !this.f30208b.b().j()) ? d2 : new c(null, null);
            }
            return (c) invokeV.objValue;
        }

        public final c d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.f30209c == null) {
                    return new c(this.f30208b, null);
                }
                if (this.f30208b.e() && this.f30209c.f() == null) {
                    return new c(this.f30208b, null);
                }
                if (!c.a(this.f30209c, this.f30208b)) {
                    return new c(this.f30208b, null);
                }
                b.d.b.d b2 = this.f30208b.b();
                if (!b2.h() && !e(this.f30208b)) {
                    b.d.b.d c2 = this.f30209c.c();
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
                            b0.a n = this.f30209c.n();
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
                    } else if (this.f30212f != null) {
                        str = this.f30213g;
                    } else if (this.f30210d != null) {
                        str = this.f30211e;
                    } else {
                        return new c(this.f30208b, null);
                    }
                    r.a f2 = this.f30208b.d().f();
                    b.d.b.e0.a.f30186a.b(f2, str2, str);
                    z.a g2 = this.f30208b.g();
                    g2.d(f2.d());
                    return new c(g2.b(), this.f30209c);
                }
                return new c(this.f30208b, null);
            }
            return (c) invokeV.objValue;
        }

        public final boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f30209c.c().d() == -1 && this.f30214h == null : invokeV.booleanValue;
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
        this.f30205a = zVar;
        this.f30206b = b0Var;
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
