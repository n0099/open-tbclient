package c.i.b.a.d0.v;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import c.i.b.a.d0.b;
import c.i.b.a.d0.l;
import c.i.b.a.d0.v.a;
import c.i.b.a.h0.e;
import c.i.b.a.h0.n;
import c.i.b.a.h0.o;
import c.i.b.a.i0.v;
import c.i.b.a.k;
import c.i.b.a.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.Loader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: classes9.dex */
public final class c implements l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f29425e;

    /* renamed from: f  reason: collision with root package name */
    public final e.a f29426f;

    /* renamed from: g  reason: collision with root package name */
    public final a.InterfaceC1668a f29427g;

    /* renamed from: h  reason: collision with root package name */
    public final int f29428h;

    /* renamed from: i  reason: collision with root package name */
    public final long f29429i;

    /* renamed from: j  reason: collision with root package name */
    public final b.a f29430j;
    public final o.a<? extends c.i.b.a.d0.v.g.b> k;
    public final e l;
    public final Object m;
    public final SparseArray<c.i.b.a.d0.v.b> n;
    public final Runnable o;
    public final Runnable p;
    public l.a q;
    public c.i.b.a.h0.e r;
    public Loader s;
    public n t;
    public Uri u;
    public long v;
    public long w;
    public c.i.b.a.d0.v.g.b x;
    public Handler y;
    public long z;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f29431e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29431e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f29431e.v();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f29432e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29432e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f29432e.p(false);
            }
        }
    }

    /* renamed from: c.i.b.a.d0.v.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C1669c extends w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final long f29433b;

        /* renamed from: c  reason: collision with root package name */
        public final long f29434c;

        /* renamed from: d  reason: collision with root package name */
        public final int f29435d;

        /* renamed from: e  reason: collision with root package name */
        public final long f29436e;

        /* renamed from: f  reason: collision with root package name */
        public final long f29437f;

        /* renamed from: g  reason: collision with root package name */
        public final long f29438g;

        /* renamed from: h  reason: collision with root package name */
        public final c.i.b.a.d0.v.g.b f29439h;

        public C1669c(long j2, long j3, int i2, long j4, long j5, long j6, c.i.b.a.d0.v.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r4;
                Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29433b = j2;
            this.f29434c = j3;
            this.f29435d = i2;
            this.f29436e = j4;
            this.f29437f = j5;
            this.f29438g = j6;
            this.f29439h = bVar;
        }

        @Override // c.i.b.a.w
        public int b(Object obj) {
            InterceptResult invokeL;
            int intValue;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue()) >= (i2 = this.f29435d) && intValue < i2 + h()) {
                    return intValue - this.f29435d;
                }
                return -1;
            }
            return invokeL.intValue;
        }

        @Override // c.i.b.a.w
        public w.b g(int i2, w.b bVar, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), bVar, Boolean.valueOf(z)})) == null) {
                c.i.b.a.i0.a.c(i2, 0, this.f29439h.b());
                Integer num = null;
                String str = z ? this.f29439h.a(i2).a : null;
                if (z) {
                    int i3 = this.f29435d;
                    c.i.b.a.i0.a.c(i2, 0, this.f29439h.b());
                    num = Integer.valueOf(i3 + i2);
                }
                bVar.n(str, num, 0, this.f29439h.d(i2), c.i.b.a.b.a(this.f29439h.a(i2).f29481b - this.f29439h.a(0).f29481b) - this.f29436e);
                return bVar;
            }
            return (w.b) invokeCommon.objValue;
        }

        @Override // c.i.b.a.w
        public int h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f29439h.b() : invokeV.intValue;
        }

        @Override // c.i.b.a.w
        public w.c n(int i2, w.c cVar, boolean z, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), cVar, Boolean.valueOf(z), Long.valueOf(j2)})) == null) {
                c.i.b.a.i0.a.c(i2, 0, 1);
                long r = r(j2);
                long j3 = this.f29433b;
                long j4 = this.f29434c;
                c.i.b.a.d0.v.g.b bVar = this.f29439h;
                cVar.d(null, j3, j4, true, bVar.f29463c, r, this.f29437f, 0, bVar.b() - 1, this.f29436e);
                return cVar;
            }
            return (w.c) invokeCommon.objValue;
        }

        @Override // c.i.b.a.w
        public int o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 1;
            }
            return invokeV.intValue;
        }

        public final long r(long j2) {
            InterceptResult invokeJ;
            c.i.b.a.d0.v.d i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
                long j3 = this.f29438g;
                if (this.f29439h.f29463c) {
                    if (j2 > 0) {
                        j3 += j2;
                        if (j3 > this.f29437f) {
                            return -9223372036854775807L;
                        }
                    }
                    long j4 = this.f29436e + j3;
                    long d2 = this.f29439h.d(0);
                    int i3 = 0;
                    while (i3 < this.f29439h.b() - 1 && j4 >= d2) {
                        j4 -= d2;
                        i3++;
                        d2 = this.f29439h.d(i3);
                    }
                    c.i.b.a.d0.v.g.e a = this.f29439h.a(i3);
                    int a2 = a.a(2);
                    return (a2 == -1 || (i2 = a.f29482c.get(a2).f29459c.get(0).i()) == null || i2.c(d2) == 0) ? j3 : (j3 + i2.f(i2.b(j4, d2))) - j4;
                }
                return j3;
            }
            return invokeJ.longValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class d implements o.a<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.i.b.a.h0.o.a
        /* renamed from: b */
        public Long a(Uri uri, InputStream inputStream) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri, inputStream)) == null) {
                String readLine = new BufferedReader(new InputStreamReader(inputStream)).readLine();
                try {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                    return Long.valueOf(simpleDateFormat.parse(readLine).getTime());
                } catch (ParseException e2) {
                    throw new ParserException(e2);
                }
            }
            return (Long) invokeLL.objValue;
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* loaded from: classes9.dex */
    public final class e implements Loader.a<o<c.i.b.a.d0.v.g.b>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f29440e;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29440e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: a */
        public void l(o<c.i.b.a.d0.v.g.b> oVar, long j2, long j3, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{oVar, Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)}) == null) {
                this.f29440e.i(oVar, j2, j3);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: b */
        public void m(o<c.i.b.a.d0.v.g.b> oVar, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{oVar, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                this.f29440e.j(oVar, j2, j3);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: c */
        public int n(o<c.i.b.a.d0.v.g.b> oVar, long j2, long j3, IOException iOException) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{oVar, Long.valueOf(j2), Long.valueOf(j3), iOException})) == null) ? this.f29440e.k(oVar, j2, j3, iOException) : invokeCommon.intValue;
        }

        public /* synthetic */ e(c cVar, a aVar) {
            this(cVar);
        }
    }

    /* loaded from: classes9.dex */
    public static final class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final long f29441b;

        /* renamed from: c  reason: collision with root package name */
        public final long f29442c;

        public f(boolean z, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.f29441b = j2;
            this.f29442c = j3;
        }

        public static f a(c.i.b.a.d0.v.g.e eVar, long j2) {
            InterceptResult invokeLJ;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65537, null, eVar, j2)) == null) {
                int size = eVar.f29482c.size();
                int i3 = 0;
                long j3 = Long.MAX_VALUE;
                int i4 = 0;
                boolean z = false;
                boolean z2 = false;
                long j4 = 0;
                while (i4 < size) {
                    c.i.b.a.d0.v.d i5 = eVar.f29482c.get(i4).f29459c.get(i3).i();
                    if (i5 == null) {
                        return new f(true, 0L, j2);
                    }
                    z2 |= i5.g();
                    int c2 = i5.c(j2);
                    if (c2 == 0) {
                        i2 = i4;
                        z = true;
                        j4 = 0;
                        j3 = 0;
                    } else if (z) {
                        i2 = i4;
                    } else {
                        int d2 = i5.d();
                        i2 = i4;
                        j4 = Math.max(j4, i5.f(d2));
                        if (c2 != -1) {
                            int i6 = (d2 + c2) - 1;
                            j3 = Math.min(j3, i5.f(i6) + i5.a(i6, j2));
                        }
                    }
                    i4 = i2 + 1;
                    i3 = 0;
                }
                return new f(z2, j4, j3);
            }
            return (f) invokeLJ.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public final class g implements Loader.a<o<Long>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f29443e;

        public g(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29443e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: a */
        public void l(o<Long> oVar, long j2, long j3, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{oVar, Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)}) == null) {
                this.f29443e.i(oVar, j2, j3);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: b */
        public void m(o<Long> oVar, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{oVar, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                this.f29443e.l(oVar, j2, j3);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: c */
        public int n(o<Long> oVar, long j2, long j3, IOException iOException) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{oVar, Long.valueOf(j2), Long.valueOf(j3), iOException})) == null) ? this.f29443e.m(oVar, j2, j3, iOException) : invokeCommon.intValue;
        }

        public /* synthetic */ g(c cVar, a aVar) {
            this(cVar);
        }
    }

    /* loaded from: classes9.dex */
    public static final class h implements o.a<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.i.b.a.h0.o.a
        /* renamed from: b */
        public Long a(Uri uri, InputStream inputStream) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri, inputStream)) == null) ? Long.valueOf(v.D(new BufferedReader(new InputStreamReader(inputStream)).readLine())) : (Long) invokeLL.objValue;
        }

        public /* synthetic */ h(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2077428709, "Lc/i/b/a/d0/v/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2077428709, "Lc/i/b/a/d0/v/c;");
                return;
            }
        }
        k.a("goog.exo.dash");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(Uri uri, e.a aVar, a.InterfaceC1668a interfaceC1668a, Handler handler, c.i.b.a.d0.b bVar) {
        this(uri, aVar, interfaceC1668a, 3, -1L, handler, bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, aVar, interfaceC1668a, handler, bVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Uri) objArr2[0], (e.a) objArr2[1], (a.InterfaceC1668a) objArr2[2], ((Integer) objArr2[3]).intValue(), ((Long) objArr2[4]).longValue(), (Handler) objArr2[5], (c.i.b.a.d0.b) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    @Override // c.i.b.a.d0.l
    public void a(c.i.b.a.g gVar, boolean z, l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{gVar, Boolean.valueOf(z), aVar}) == null) {
            this.q = aVar;
            if (this.f29425e) {
                this.t = new n.a();
                p(false);
                return;
            }
            this.r = this.f29426f.a();
            Loader loader = new Loader("Loader:DashMediaSource");
            this.s = loader;
            this.t = loader;
            this.y = new Handler();
            v();
        }
    }

    @Override // c.i.b.a.d0.l
    public void b() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.t.a();
        }
    }

    @Override // c.i.b.a.d0.l
    public c.i.b.a.d0.k d(l.b bVar, c.i.b.a.h0.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bVar, bVar2)) == null) {
            int i2 = bVar.a;
            c.i.b.a.d0.v.b bVar3 = new c.i.b.a.d0.v.b(this.A + i2, this.x, i2, this.f29427g, this.f29428h, this.f29430j.d(this.x.a(i2).f29481b), this.z, this.t, bVar2);
            this.n.put(bVar3.f29414e, bVar3);
            return bVar3;
        }
        return (c.i.b.a.d0.k) invokeLL.objValue;
    }

    @Override // c.i.b.a.d0.l
    public void e(c.i.b.a.d0.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, kVar) == null) {
            c.i.b.a.d0.v.b bVar = (c.i.b.a.d0.v.b) kVar;
            bVar.v();
            this.n.remove(bVar.f29414e);
        }
    }

    @Override // c.i.b.a.d0.l
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.r = null;
            this.t = null;
            Loader loader = this.s;
            if (loader != null) {
                loader.i();
                this.s = null;
            }
            this.v = 0L;
            this.w = 0L;
            this.x = null;
            Handler handler = this.y;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.y = null;
            }
            this.z = 0L;
            this.n.clear();
        }
    }

    public final long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.z != 0) {
                return c.i.b.a.b.a(SystemClock.elapsedRealtime() + this.z);
            }
            return c.i.b.a.b.a(System.currentTimeMillis());
        }
        return invokeV.longValue;
    }

    public void i(o<?> oVar, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{oVar, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.f29430j.g(oVar.a, oVar.f29911b, j2, j3, oVar.b());
        }
    }

    public void j(o<c.i.b.a.d0.v.g.b> oVar, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{oVar, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.f29430j.i(oVar.a, oVar.f29911b, j2, j3, oVar.b());
            c.i.b.a.d0.v.g.b c2 = oVar.c();
            c.i.b.a.d0.v.g.b bVar = this.x;
            int i2 = 0;
            int b2 = bVar == null ? 0 : bVar.b();
            long j4 = c2.a(0).f29481b;
            while (i2 < b2 && this.x.a(i2).f29481b < j4) {
                i2++;
            }
            if (b2 - i2 > c2.b()) {
                t();
                return;
            }
            this.x = c2;
            this.v = j2 - j3;
            this.w = j2;
            if (c2.f29468h != null) {
                synchronized (this.m) {
                    if (oVar.a.a == this.u) {
                        this.u = this.x.f29468h;
                    }
                }
            }
            if (b2 == 0) {
                c.i.b.a.d0.v.g.k kVar = this.x.f29467g;
                if (kVar != null) {
                    q(kVar);
                    return;
                } else {
                    p(true);
                    return;
                }
            }
            this.A += i2;
            p(true);
        }
    }

    public int k(o<c.i.b.a.d0.v.g.b> oVar, long j2, long j3, IOException iOException) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{oVar, Long.valueOf(j2), Long.valueOf(j3), iOException})) == null) {
            boolean z = iOException instanceof ParserException;
            this.f29430j.k(oVar.a, oVar.f29911b, j2, j3, oVar.b(), iOException, z);
            return z ? 3 : 0;
        }
        return invokeCommon.intValue;
    }

    public void l(o<Long> oVar, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{oVar, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.f29430j.i(oVar.a, oVar.f29911b, j2, j3, oVar.b());
            o(oVar.c().longValue() - j2);
        }
    }

    public int m(o<Long> oVar, long j2, long j3, IOException iOException) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{oVar, Long.valueOf(j2), Long.valueOf(j3), iOException})) == null) {
            this.f29430j.k(oVar.a, oVar.f29911b, j2, j3, oVar.b(), iOException, true);
            n(iOException);
            return 2;
        }
        return invokeCommon.intValue;
    }

    public final void n(IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iOException) == null) {
            p(true);
        }
    }

    public final void o(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j2) == null) {
            this.z = j2;
            p(true);
        }
    }

    public final void p(boolean z) {
        long j2;
        boolean z2;
        long d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            for (int i2 = 0; i2 < this.n.size(); i2++) {
                int keyAt = this.n.keyAt(i2);
                if (keyAt >= this.A) {
                    this.n.valueAt(i2).x(this.x, keyAt - this.A);
                }
            }
            int b2 = this.x.b() - 1;
            f a2 = f.a(this.x.a(0), this.x.d(0));
            f a3 = f.a(this.x.a(b2), this.x.d(b2));
            long j3 = a2.f29441b;
            long j4 = a3.f29442c;
            long j5 = 0;
            if (!this.x.f29463c || a3.a) {
                j2 = j3;
                z2 = false;
            } else {
                j4 = Math.min((h() - c.i.b.a.b.a(this.x.a)) - c.i.b.a.b.a(this.x.a(b2).f29481b), j4);
                long j6 = this.x.f29465e;
                if (j6 != -9223372036854775807L) {
                    long a4 = j4 - c.i.b.a.b.a(j6);
                    while (a4 < 0 && b2 > 0) {
                        b2--;
                        a4 += this.x.d(b2);
                    }
                    if (b2 == 0) {
                        d2 = Math.max(j3, a4);
                    } else {
                        d2 = this.x.d(0);
                    }
                    j3 = d2;
                }
                j2 = j3;
                z2 = true;
            }
            long j7 = j4 - j2;
            for (int i3 = 0; i3 < this.x.b() - 1; i3++) {
                j7 += this.x.d(i3);
            }
            c.i.b.a.d0.v.g.b bVar = this.x;
            if (bVar.f29463c) {
                long j8 = this.f29429i;
                if (j8 == -1) {
                    long j9 = bVar.f29466f;
                    if (j9 == -9223372036854775807L) {
                        j9 = 30000;
                    }
                    j8 = j9;
                }
                j5 = j7 - c.i.b.a.b.a(j8);
                if (j5 < 5000000) {
                    j5 = Math.min(5000000L, j7 / 2);
                }
            }
            c.i.b.a.d0.v.g.b bVar2 = this.x;
            long b3 = bVar2.a + bVar2.a(0).f29481b + c.i.b.a.b.b(j2);
            c.i.b.a.d0.v.g.b bVar3 = this.x;
            this.q.c(this, new C1669c(bVar3.a, b3, this.A, j2, j7, j5, bVar3), this.x);
            if (this.f29425e) {
                return;
            }
            this.y.removeCallbacks(this.p);
            if (z2) {
                this.y.postDelayed(this.p, 5000L);
            }
            if (z) {
                t();
            }
        }
    }

    public final void q(c.i.b.a.d0.v.g.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, kVar) == null) {
            String str = kVar.a;
            if (!v.a(str, "urn:mpeg:dash:utc:direct:2014") && !v.a(str, "urn:mpeg:dash:utc:direct:2012")) {
                if (!v.a(str, "urn:mpeg:dash:utc:http-iso:2014") && !v.a(str, "urn:mpeg:dash:utc:http-iso:2012")) {
                    if (!v.a(str, "urn:mpeg:dash:utc:http-xsdate:2014") && !v.a(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
                        n(new IOException("Unsupported UTC timing scheme"));
                        return;
                    } else {
                        s(kVar, new h(null));
                        return;
                    }
                }
                s(kVar, new d(null));
                return;
            }
            r(kVar);
        }
    }

    public final void r(c.i.b.a.d0.v.g.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, kVar) == null) {
            try {
                o(v.D(kVar.f29508b) - this.w);
            } catch (ParserException e2) {
                n(e2);
            }
        }
    }

    public final void s(c.i.b.a.d0.v.g.k kVar, o.a<Long> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, kVar, aVar) == null) {
            u(new o(this.r, Uri.parse(kVar.f29508b), 5, aVar), new g(this, null), 1);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            c.i.b.a.d0.v.g.b bVar = this.x;
            if (bVar.f29463c) {
                long j2 = bVar.f29464d;
                if (j2 == 0) {
                    j2 = 5000;
                }
                this.y.postDelayed(this.o, Math.max(0L, (this.v + j2) - SystemClock.elapsedRealtime()));
            }
        }
    }

    public final <T> void u(o<T> oVar, Loader.a<o<T>> aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048594, this, oVar, aVar, i2) == null) {
            this.f29430j.m(oVar.a, oVar.f29911b, this.s.k(oVar, aVar, i2));
        }
    }

    public final void v() {
        Uri uri;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            synchronized (this.m) {
                uri = this.u;
            }
            u(new o(this.r, uri, 4, this.k), this.l, this.f29428h);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(Uri uri, e.a aVar, a.InterfaceC1668a interfaceC1668a, int i2, long j2, Handler handler, c.i.b.a.d0.b bVar) {
        this(uri, aVar, new c.i.b.a.d0.v.g.c(), interfaceC1668a, i2, j2, handler, bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, aVar, interfaceC1668a, Integer.valueOf(i2), Long.valueOf(j2), handler, bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Uri) objArr2[0], (e.a) objArr2[1], (o.a) objArr2[2], (a.InterfaceC1668a) objArr2[3], ((Integer) objArr2[4]).intValue(), ((Long) objArr2[5]).longValue(), (Handler) objArr2[6], (c.i.b.a.d0.b) objArr2[7]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(Uri uri, e.a aVar, o.a<? extends c.i.b.a.d0.v.g.b> aVar2, a.InterfaceC1668a interfaceC1668a, int i2, long j2, Handler handler, c.i.b.a.d0.b bVar) {
        this(null, uri, aVar, aVar2, interfaceC1668a, i2, j2, handler, bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {uri, aVar, aVar2, interfaceC1668a, Integer.valueOf(i2), Long.valueOf(j2), handler, bVar};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((c.i.b.a.d0.v.g.b) objArr2[0], (Uri) objArr2[1], (e.a) objArr2[2], (o.a) objArr2[3], (a.InterfaceC1668a) objArr2[4], ((Integer) objArr2[5]).intValue(), ((Long) objArr2[6]).longValue(), (Handler) objArr2[7], (c.i.b.a.d0.b) objArr2[8]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public c(c.i.b.a.d0.v.g.b bVar, Uri uri, e.a aVar, o.a<? extends c.i.b.a.d0.v.g.b> aVar2, a.InterfaceC1668a interfaceC1668a, int i2, long j2, Handler handler, c.i.b.a.d0.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, uri, aVar, aVar2, interfaceC1668a, Integer.valueOf(i2), Long.valueOf(j2), handler, bVar2};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.x = bVar;
        this.u = uri;
        this.f29426f = aVar;
        this.k = aVar2;
        this.f29427g = interfaceC1668a;
        this.f29428h = i2;
        this.f29429i = j2;
        this.f29425e = bVar != null;
        this.f29430j = new b.a(handler, bVar2);
        this.m = new Object();
        this.n = new SparseArray<>();
        if (this.f29425e) {
            c.i.b.a.i0.a.f(!bVar.f29463c);
            this.l = null;
            this.o = null;
            this.p = null;
            return;
        }
        this.l = new e(this, null);
        this.o = new a(this);
        this.p = new b(this);
    }
}
