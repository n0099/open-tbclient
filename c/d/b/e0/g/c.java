package c.d.b.e0.g;

import c.d.b.b0;
import c.d.b.e0.i.e;
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
/* loaded from: classes4.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final z f31561a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final b0 f31562b;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final long f31563a;

        /* renamed from: b  reason: collision with root package name */
        public final z f31564b;

        /* renamed from: c  reason: collision with root package name */
        public final b0 f31565c;

        /* renamed from: d  reason: collision with root package name */
        public Date f31566d;

        /* renamed from: e  reason: collision with root package name */
        public String f31567e;

        /* renamed from: f  reason: collision with root package name */
        public Date f31568f;

        /* renamed from: g  reason: collision with root package name */
        public String f31569g;

        /* renamed from: h  reason: collision with root package name */
        public Date f31570h;

        /* renamed from: i  reason: collision with root package name */
        public long f31571i;

        /* renamed from: j  reason: collision with root package name */
        public long f31572j;
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
            this.f31563a = j2;
            this.f31564b = zVar;
            this.f31565c = b0Var;
            if (b0Var != null) {
                this.f31571i = b0Var.E();
                this.f31572j = b0Var.C();
                r v = b0Var.v();
                int g2 = v.g();
                for (int i4 = 0; i4 < g2; i4++) {
                    String e2 = v.e(i4);
                    String h2 = v.h(i4);
                    if ("Date".equalsIgnoreCase(e2)) {
                        this.f31566d = c.d.b.e0.i.d.b(h2);
                        this.f31567e = h2;
                    } else if ("Expires".equalsIgnoreCase(e2)) {
                        this.f31570h = c.d.b.e0.i.d.b(h2);
                    } else if ("Last-Modified".equalsIgnoreCase(e2)) {
                        this.f31568f = c.d.b.e0.i.d.b(h2);
                        this.f31569g = h2;
                    } else if ("ETag".equalsIgnoreCase(e2)) {
                        this.k = h2;
                    } else if ("Age".equalsIgnoreCase(e2)) {
                        this.l = e.d(h2, -1);
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
                Date date = this.f31566d;
                long max = date != null ? Math.max(0L, this.f31572j - date.getTime()) : 0L;
                int i2 = this.l;
                if (i2 != -1) {
                    max = Math.max(max, TimeUnit.SECONDS.toMillis(i2));
                }
                long j2 = this.f31572j;
                return max + (j2 - this.f31571i) + (this.f31563a - j2);
            }
            return invokeV.longValue;
        }

        public final long b() {
            InterceptResult invokeV;
            long j2;
            long j3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                c.d.b.d n = this.f31565c.n();
                if (n.d() != -1) {
                    return TimeUnit.SECONDS.toMillis(n.d());
                }
                if (this.f31570h != null) {
                    Date date = this.f31566d;
                    if (date != null) {
                        j3 = date.getTime();
                    } else {
                        j3 = this.f31572j;
                    }
                    long time = this.f31570h.getTime() - j3;
                    if (time > 0) {
                        return time;
                    }
                    return 0L;
                } else if (this.f31568f == null || this.f31565c.D().h().x() != null) {
                    return 0L;
                } else {
                    Date date2 = this.f31566d;
                    if (date2 != null) {
                        j2 = date2.getTime();
                    } else {
                        j2 = this.f31571i;
                    }
                    long time2 = j2 - this.f31568f.getTime();
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
                return (d2.f31561a == null || !this.f31564b.b().j()) ? d2 : new c(null, null);
            }
            return (c) invokeV.objValue;
        }

        public final c d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.f31565c == null) {
                    return new c(this.f31564b, null);
                }
                if (this.f31564b.e() && this.f31565c.r() == null) {
                    return new c(this.f31564b, null);
                }
                if (!c.a(this.f31565c, this.f31564b)) {
                    return new c(this.f31564b, null);
                }
                c.d.b.d b2 = this.f31564b.b();
                if (!b2.h() && !e(this.f31564b)) {
                    c.d.b.d n = this.f31565c.n();
                    long a2 = a();
                    long b3 = b();
                    if (b2.d() != -1) {
                        b3 = Math.min(b3, TimeUnit.SECONDS.toMillis(b2.d()));
                    }
                    long j2 = 0;
                    long millis = b2.f() != -1 ? TimeUnit.SECONDS.toMillis(b2.f()) : 0L;
                    if (!n.g() && b2.e() != -1) {
                        j2 = TimeUnit.SECONDS.toMillis(b2.e());
                    }
                    if (!n.h()) {
                        long j3 = millis + a2;
                        if (j3 < j2 + b3) {
                            b0.a z = this.f31565c.z();
                            if (j3 >= b3) {
                                z.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                            }
                            if (a2 > 86400000 && f()) {
                                z.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                            }
                            return new c(null, z.c());
                        }
                    }
                    String str = this.k;
                    String str2 = "If-Modified-Since";
                    if (str != null) {
                        str2 = "If-None-Match";
                    } else if (this.f31568f != null) {
                        str = this.f31569g;
                    } else if (this.f31566d != null) {
                        str = this.f31567e;
                    } else {
                        return new c(this.f31564b, null);
                    }
                    r.a f2 = this.f31564b.d().f();
                    c.d.b.e0.a.f31543a.b(f2, str2, str);
                    z.a g2 = this.f31564b.g();
                    g2.d(f2.d());
                    return new c(g2.b(), this.f31565c);
                }
                return new c(this.f31564b, null);
            }
            return (c) invokeV.objValue;
        }

        public final boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f31565c.n().d() == -1 && this.f31570h == null : invokeV.booleanValue;
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
        this.f31561a = zVar;
        this.f31562b = b0Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x005a, code lost:
        if (r4.n().b() == false) goto L24;
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
                if (b0Var.s("Expires") == null) {
                    if (b0Var.n().d() == -1) {
                        if (!b0Var.n().c()) {
                        }
                    }
                }
            }
            return (b0Var.n().i() || zVar.b().i()) ? false : true;
        }
        return invokeLL.booleanValue;
    }
}
