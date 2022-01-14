package c.d.b.e0.g;

import c.d.b.b0;
import c.d.b.r;
import c.d.b.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final z a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final b0 f27679b;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long a;

        /* renamed from: b  reason: collision with root package name */
        public final z f27680b;

        /* renamed from: c  reason: collision with root package name */
        public final b0 f27681c;

        /* renamed from: d  reason: collision with root package name */
        public Date f27682d;

        /* renamed from: e  reason: collision with root package name */
        public String f27683e;

        /* renamed from: f  reason: collision with root package name */
        public Date f27684f;

        /* renamed from: g  reason: collision with root package name */
        public String f27685g;

        /* renamed from: h  reason: collision with root package name */
        public Date f27686h;

        /* renamed from: i  reason: collision with root package name */
        public long f27687i;

        /* renamed from: j  reason: collision with root package name */
        public long f27688j;
        public String k;
        public int l;

        public a(long j2, z zVar, b0 b0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2), zVar, b0Var};
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
            this.a = j2;
            this.f27680b = zVar;
            this.f27681c = b0Var;
            if (b0Var != null) {
                this.f27687i = b0Var.s();
                this.f27688j = b0Var.q();
                r j3 = b0Var.j();
                int g2 = j3.g();
                for (int i4 = 0; i4 < g2; i4++) {
                    String e2 = j3.e(i4);
                    String h2 = j3.h(i4);
                    if ("Date".equalsIgnoreCase(e2)) {
                        this.f27682d = c.d.b.e0.i.d.b(h2);
                        this.f27683e = h2;
                    } else if ("Expires".equalsIgnoreCase(e2)) {
                        this.f27686h = c.d.b.e0.i.d.b(h2);
                    } else if ("Last-Modified".equalsIgnoreCase(e2)) {
                        this.f27684f = c.d.b.e0.i.d.b(h2);
                        this.f27685g = h2;
                    } else if ("ETag".equalsIgnoreCase(e2)) {
                        this.k = h2;
                    } else if ("Age".equalsIgnoreCase(e2)) {
                        this.l = c.d.b.e0.i.e.d(h2, -1);
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
                Date date = this.f27682d;
                long max = date != null ? Math.max(0L, this.f27688j - date.getTime()) : 0L;
                int i2 = this.l;
                if (i2 != -1) {
                    max = Math.max(max, TimeUnit.SECONDS.toMillis(i2));
                }
                long j2 = this.f27688j;
                return max + (j2 - this.f27687i) + (this.a - j2);
            }
            return invokeV.longValue;
        }

        public final long b() {
            InterceptResult invokeV;
            long j2;
            long j3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                c.d.b.d c2 = this.f27681c.c();
                if (c2.d() != -1) {
                    return TimeUnit.SECONDS.toMillis(c2.d());
                }
                if (this.f27686h != null) {
                    Date date = this.f27682d;
                    if (date != null) {
                        j3 = date.getTime();
                    } else {
                        j3 = this.f27688j;
                    }
                    long time = this.f27686h.getTime() - j3;
                    if (time > 0) {
                        return time;
                    }
                    return 0L;
                } else if (this.f27684f == null || this.f27681c.r().h().query() != null) {
                    return 0L;
                } else {
                    Date date2 = this.f27682d;
                    if (date2 != null) {
                        j2 = date2.getTime();
                    } else {
                        j2 = this.f27687i;
                    }
                    long time2 = j2 - this.f27684f.getTime();
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
                return (d2.a == null || !this.f27680b.b().j()) ? d2 : new c(null, null);
            }
            return (c) invokeV.objValue;
        }

        public final c d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.f27681c == null) {
                    return new c(this.f27680b, null);
                }
                if (this.f27680b.e() && this.f27681c.f() == null) {
                    return new c(this.f27680b, null);
                }
                if (!c.a(this.f27681c, this.f27680b)) {
                    return new c(this.f27680b, null);
                }
                c.d.b.d b2 = this.f27680b.b();
                if (!b2.h() && !e(this.f27680b)) {
                    c.d.b.d c2 = this.f27681c.c();
                    long a = a();
                    long b3 = b();
                    if (b2.d() != -1) {
                        b3 = Math.min(b3, TimeUnit.SECONDS.toMillis(b2.d()));
                    }
                    long j2 = 0;
                    long millis = b2.f() != -1 ? TimeUnit.SECONDS.toMillis(b2.f()) : 0L;
                    if (!c2.g() && b2.e() != -1) {
                        j2 = TimeUnit.SECONDS.toMillis(b2.e());
                    }
                    if (!c2.h()) {
                        long j3 = millis + a;
                        if (j3 < j2 + b3) {
                            b0.a n = this.f27681c.n();
                            if (j3 >= b3) {
                                n.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                            }
                            if (a > 86400000 && f()) {
                                n.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                            }
                            return new c(null, n.c());
                        }
                    }
                    String str = this.k;
                    String str2 = "If-Modified-Since";
                    if (str != null) {
                        str2 = "If-None-Match";
                    } else if (this.f27684f != null) {
                        str = this.f27685g;
                    } else if (this.f27682d != null) {
                        str = this.f27683e;
                    } else {
                        return new c(this.f27680b, null);
                    }
                    r.a f2 = this.f27680b.d().f();
                    c.d.b.e0.a.a.b(f2, str2, str);
                    z.a g2 = this.f27680b.g();
                    g2.d(f2.d());
                    return new c(g2.b(), this.f27681c);
                }
                return new c(this.f27680b, null);
            }
            return (c) invokeV.objValue;
        }

        public final boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f27681c.c().d() == -1 && this.f27686h == null : invokeV.booleanValue;
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
        this.a = zVar;
        this.f27679b = b0Var;
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
