package b.h.b.a.d0.v;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import b.h.b.a.d0.b;
import b.h.b.a.d0.l;
import b.h.b.a.d0.v.a;
import b.h.b.a.h0.e;
import b.h.b.a.h0.n;
import b.h.b.a.h0.o;
import b.h.b.a.i0.v;
import b.h.b.a.k;
import b.h.b.a.w;
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
/* loaded from: classes6.dex */
public final class c implements l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f32907e;

    /* renamed from: f  reason: collision with root package name */
    public final e.a f32908f;

    /* renamed from: g  reason: collision with root package name */
    public final a.InterfaceC1522a f32909g;

    /* renamed from: h  reason: collision with root package name */
    public final int f32910h;

    /* renamed from: i  reason: collision with root package name */
    public final long f32911i;
    public final b.a j;
    public final o.a<? extends b.h.b.a.d0.v.g.b> k;
    public final e l;
    public final Object m;
    public final SparseArray<b.h.b.a.d0.v.b> n;
    public final Runnable o;
    public final Runnable p;
    public l.a q;
    public b.h.b.a.h0.e r;
    public Loader s;
    public n t;
    public Uri u;
    public long v;
    public long w;
    public b.h.b.a.d0.v.g.b x;
    public Handler y;
    public long z;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f32912e;

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
            this.f32912e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f32912e.v();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f32913e;

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
            this.f32913e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f32913e.p(false);
            }
        }
    }

    /* renamed from: b.h.b.a.d0.v.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1523c extends w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final long f32914b;

        /* renamed from: c  reason: collision with root package name */
        public final long f32915c;

        /* renamed from: d  reason: collision with root package name */
        public final int f32916d;

        /* renamed from: e  reason: collision with root package name */
        public final long f32917e;

        /* renamed from: f  reason: collision with root package name */
        public final long f32918f;

        /* renamed from: g  reason: collision with root package name */
        public final long f32919g;

        /* renamed from: h  reason: collision with root package name */
        public final b.h.b.a.d0.v.g.b f32920h;

        public C1523c(long j, long j2, int i2, long j3, long j4, long j5, b.h.b.a.d0.v.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r4;
                Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32914b = j;
            this.f32915c = j2;
            this.f32916d = i2;
            this.f32917e = j3;
            this.f32918f = j4;
            this.f32919g = j5;
            this.f32920h = bVar;
        }

        @Override // b.h.b.a.w
        public int b(Object obj) {
            InterceptResult invokeL;
            int intValue;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue()) >= (i2 = this.f32916d) && intValue < i2 + h()) {
                    return intValue - this.f32916d;
                }
                return -1;
            }
            return invokeL.intValue;
        }

        @Override // b.h.b.a.w
        public w.b g(int i2, w.b bVar, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), bVar, Boolean.valueOf(z)})) == null) {
                b.h.b.a.i0.a.c(i2, 0, this.f32920h.b());
                Integer num = null;
                String str = z ? this.f32920h.a(i2).f32971a : null;
                if (z) {
                    int i3 = this.f32916d;
                    b.h.b.a.i0.a.c(i2, 0, this.f32920h.b());
                    num = Integer.valueOf(i3 + i2);
                }
                bVar.n(str, num, 0, this.f32920h.d(i2), b.h.b.a.b.a(this.f32920h.a(i2).f32972b - this.f32920h.a(0).f32972b) - this.f32917e);
                return bVar;
            }
            return (w.b) invokeCommon.objValue;
        }

        @Override // b.h.b.a.w
        public int h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32920h.b() : invokeV.intValue;
        }

        @Override // b.h.b.a.w
        public w.c n(int i2, w.c cVar, boolean z, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), cVar, Boolean.valueOf(z), Long.valueOf(j)})) == null) {
                b.h.b.a.i0.a.c(i2, 0, 1);
                long r = r(j);
                long j2 = this.f32914b;
                long j3 = this.f32915c;
                b.h.b.a.d0.v.g.b bVar = this.f32920h;
                cVar.d(null, j2, j3, true, bVar.f32950c, r, this.f32918f, 0, bVar.b() - 1, this.f32917e);
                return cVar;
            }
            return (w.c) invokeCommon.objValue;
        }

        @Override // b.h.b.a.w
        public int o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 1;
            }
            return invokeV.intValue;
        }

        public final long r(long j) {
            InterceptResult invokeJ;
            b.h.b.a.d0.v.d i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
                long j2 = this.f32919g;
                if (this.f32920h.f32950c) {
                    if (j > 0) {
                        j2 += j;
                        if (j2 > this.f32918f) {
                            return -9223372036854775807L;
                        }
                    }
                    long j3 = this.f32917e + j2;
                    long d2 = this.f32920h.d(0);
                    int i3 = 0;
                    while (i3 < this.f32920h.b() - 1 && j3 >= d2) {
                        j3 -= d2;
                        i3++;
                        d2 = this.f32920h.d(i3);
                    }
                    b.h.b.a.d0.v.g.e a2 = this.f32920h.a(i3);
                    int a3 = a2.a(2);
                    return (a3 == -1 || (i2 = a2.f32973c.get(a3).f32945c.get(0).i()) == null || i2.c(d2) == 0) ? j2 : (j2 + i2.f(i2.b(j3, d2))) - j3;
                }
                return j2;
            }
            return invokeJ.longValue;
        }
    }

    /* loaded from: classes6.dex */
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
        @Override // b.h.b.a.h0.o.a
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

    /* loaded from: classes6.dex */
    public final class e implements Loader.a<o<b.h.b.a.d0.v.g.b>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f32921e;

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
            this.f32921e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: a */
        public void l(o<b.h.b.a.d0.v.g.b> oVar, long j, long j2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
                this.f32921e.i(oVar, j, j2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: b */
        public void m(o<b.h.b.a.d0.v.g.b> oVar, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2)}) == null) {
                this.f32921e.j(oVar, j, j2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: c */
        public int n(o<b.h.b.a.d0.v.g.b> oVar, long j, long j2, IOException iOException) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2), iOException})) == null) ? this.f32921e.k(oVar, j, j2, iOException) : invokeCommon.intValue;
        }

        public /* synthetic */ e(c cVar, a aVar) {
            this(cVar);
        }
    }

    /* loaded from: classes6.dex */
    public static final class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final boolean f32922a;

        /* renamed from: b  reason: collision with root package name */
        public final long f32923b;

        /* renamed from: c  reason: collision with root package name */
        public final long f32924c;

        public f(boolean z, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32922a = z;
            this.f32923b = j;
            this.f32924c = j2;
        }

        public static f a(b.h.b.a.d0.v.g.e eVar, long j) {
            InterceptResult invokeLJ;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65537, null, eVar, j)) == null) {
                int size = eVar.f32973c.size();
                int i3 = 0;
                long j2 = Long.MAX_VALUE;
                int i4 = 0;
                boolean z = false;
                boolean z2 = false;
                long j3 = 0;
                while (i4 < size) {
                    b.h.b.a.d0.v.d i5 = eVar.f32973c.get(i4).f32945c.get(i3).i();
                    if (i5 == null) {
                        return new f(true, 0L, j);
                    }
                    z2 |= i5.g();
                    int c2 = i5.c(j);
                    if (c2 == 0) {
                        i2 = i4;
                        z = true;
                        j3 = 0;
                        j2 = 0;
                    } else if (z) {
                        i2 = i4;
                    } else {
                        int d2 = i5.d();
                        i2 = i4;
                        j3 = Math.max(j3, i5.f(d2));
                        if (c2 != -1) {
                            int i6 = (d2 + c2) - 1;
                            j2 = Math.min(j2, i5.f(i6) + i5.a(i6, j));
                        }
                    }
                    i4 = i2 + 1;
                    i3 = 0;
                }
                return new f(z2, j3, j2);
            }
            return (f) invokeLJ.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public final class g implements Loader.a<o<Long>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f32925e;

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
            this.f32925e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: a */
        public void l(o<Long> oVar, long j, long j2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
                this.f32925e.i(oVar, j, j2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: b */
        public void m(o<Long> oVar, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2)}) == null) {
                this.f32925e.l(oVar, j, j2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: c */
        public int n(o<Long> oVar, long j, long j2, IOException iOException) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2), iOException})) == null) ? this.f32925e.m(oVar, j, j2, iOException) : invokeCommon.intValue;
        }

        public /* synthetic */ g(c cVar, a aVar) {
            this(cVar);
        }
    }

    /* loaded from: classes6.dex */
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
        @Override // b.h.b.a.h0.o.a
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1003389785, "Lb/h/b/a/d0/v/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1003389785, "Lb/h/b/a/d0/v/c;");
                return;
            }
        }
        k.a("goog.exo.dash");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(Uri uri, e.a aVar, a.InterfaceC1522a interfaceC1522a, Handler handler, b.h.b.a.d0.b bVar) {
        this(uri, aVar, interfaceC1522a, 3, -1L, handler, bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, aVar, interfaceC1522a, handler, bVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Uri) objArr2[0], (e.a) objArr2[1], (a.InterfaceC1522a) objArr2[2], ((Integer) objArr2[3]).intValue(), ((Long) objArr2[4]).longValue(), (Handler) objArr2[5], (b.h.b.a.d0.b) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    @Override // b.h.b.a.d0.l
    public void a(b.h.b.a.g gVar, boolean z, l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{gVar, Boolean.valueOf(z), aVar}) == null) {
            this.q = aVar;
            if (this.f32907e) {
                this.t = new n.a();
                p(false);
                return;
            }
            this.r = this.f32908f.a();
            Loader loader = new Loader("Loader:DashMediaSource");
            this.s = loader;
            this.t = loader;
            this.y = new Handler();
            v();
        }
    }

    @Override // b.h.b.a.d0.l
    public void b() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.t.a();
        }
    }

    @Override // b.h.b.a.d0.l
    public b.h.b.a.d0.k d(l.b bVar, b.h.b.a.h0.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bVar, bVar2)) == null) {
            int i2 = bVar.f32816a;
            b.h.b.a.d0.v.b bVar3 = new b.h.b.a.d0.v.b(this.A + i2, this.x, i2, this.f32909g, this.f32910h, this.j.d(this.x.a(i2).f32972b), this.z, this.t, bVar2);
            this.n.put(bVar3.f32896e, bVar3);
            return bVar3;
        }
        return (b.h.b.a.d0.k) invokeLL.objValue;
    }

    @Override // b.h.b.a.d0.l
    public void e(b.h.b.a.d0.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, kVar) == null) {
            b.h.b.a.d0.v.b bVar = (b.h.b.a.d0.v.b) kVar;
            bVar.v();
            this.n.remove(bVar.f32896e);
        }
    }

    @Override // b.h.b.a.d0.l
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
                return b.h.b.a.b.a(SystemClock.elapsedRealtime() + this.z);
            }
            return b.h.b.a.b.a(System.currentTimeMillis());
        }
        return invokeV.longValue;
    }

    public void i(o<?> oVar, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.j.g(oVar.f33441a, oVar.f33442b, j, j2, oVar.c());
        }
    }

    public void j(o<b.h.b.a.d0.v.g.b> oVar, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.j.i(oVar.f33441a, oVar.f33442b, j, j2, oVar.c());
            b.h.b.a.d0.v.g.b d2 = oVar.d();
            b.h.b.a.d0.v.g.b bVar = this.x;
            int i2 = 0;
            int b2 = bVar == null ? 0 : bVar.b();
            long j3 = d2.a(0).f32972b;
            while (i2 < b2 && this.x.a(i2).f32972b < j3) {
                i2++;
            }
            if (b2 - i2 > d2.b()) {
                t();
                return;
            }
            this.x = d2;
            this.v = j - j2;
            this.w = j;
            if (d2.f32955h != null) {
                synchronized (this.m) {
                    if (oVar.f33441a.f33387a == this.u) {
                        this.u = this.x.f32955h;
                    }
                }
            }
            if (b2 == 0) {
                b.h.b.a.d0.v.g.k kVar = this.x.f32954g;
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

    public int k(o<b.h.b.a.d0.v.g.b> oVar, long j, long j2, IOException iOException) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2), iOException})) == null) {
            boolean z = iOException instanceof ParserException;
            this.j.k(oVar.f33441a, oVar.f33442b, j, j2, oVar.c(), iOException, z);
            return z ? 3 : 0;
        }
        return invokeCommon.intValue;
    }

    public void l(o<Long> oVar, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.j.i(oVar.f33441a, oVar.f33442b, j, j2, oVar.c());
            o(oVar.d().longValue() - j);
        }
    }

    public int m(o<Long> oVar, long j, long j2, IOException iOException) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2), iOException})) == null) {
            this.j.k(oVar.f33441a, oVar.f33442b, j, j2, oVar.c(), iOException, true);
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

    public final void o(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
            this.z = j;
            p(true);
        }
    }

    public final void p(boolean z) {
        long j;
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
            long j2 = a2.f32923b;
            long j3 = a3.f32924c;
            long j4 = 0;
            if (!this.x.f32950c || a3.f32922a) {
                j = j2;
                z2 = false;
            } else {
                j3 = Math.min((h() - b.h.b.a.b.a(this.x.f32948a)) - b.h.b.a.b.a(this.x.a(b2).f32972b), j3);
                long j5 = this.x.f32952e;
                if (j5 != -9223372036854775807L) {
                    long a4 = j3 - b.h.b.a.b.a(j5);
                    while (a4 < 0 && b2 > 0) {
                        b2--;
                        a4 += this.x.d(b2);
                    }
                    if (b2 == 0) {
                        d2 = Math.max(j2, a4);
                    } else {
                        d2 = this.x.d(0);
                    }
                    j2 = d2;
                }
                j = j2;
                z2 = true;
            }
            long j6 = j3 - j;
            for (int i3 = 0; i3 < this.x.b() - 1; i3++) {
                j6 += this.x.d(i3);
            }
            b.h.b.a.d0.v.g.b bVar = this.x;
            if (bVar.f32950c) {
                long j7 = this.f32911i;
                if (j7 == -1) {
                    long j8 = bVar.f32953f;
                    if (j8 == -9223372036854775807L) {
                        j8 = 30000;
                    }
                    j7 = j8;
                }
                j4 = j6 - b.h.b.a.b.a(j7);
                if (j4 < 5000000) {
                    j4 = Math.min(5000000L, j6 / 2);
                }
            }
            b.h.b.a.d0.v.g.b bVar2 = this.x;
            long b3 = bVar2.f32948a + bVar2.a(0).f32972b + b.h.b.a.b.b(j);
            b.h.b.a.d0.v.g.b bVar3 = this.x;
            this.q.c(this, new C1523c(bVar3.f32948a, b3, this.A, j, j6, j4, bVar3), this.x);
            if (this.f32907e) {
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

    public final void q(b.h.b.a.d0.v.g.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, kVar) == null) {
            String str = kVar.f33005a;
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

    public final void r(b.h.b.a.d0.v.g.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, kVar) == null) {
            try {
                o(v.D(kVar.f33006b) - this.w);
            } catch (ParserException e2) {
                n(e2);
            }
        }
    }

    public final void s(b.h.b.a.d0.v.g.k kVar, o.a<Long> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, kVar, aVar) == null) {
            u(new o(this.r, Uri.parse(kVar.f33006b), 5, aVar), new g(this, null), 1);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            b.h.b.a.d0.v.g.b bVar = this.x;
            if (bVar.f32950c) {
                long j = bVar.f32951d;
                if (j == 0) {
                    j = 5000;
                }
                this.y.postDelayed(this.o, Math.max(0L, (this.v + j) - SystemClock.elapsedRealtime()));
            }
        }
    }

    public final <T> void u(o<T> oVar, Loader.a<o<T>> aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048594, this, oVar, aVar, i2) == null) {
            this.j.m(oVar.f33441a, oVar.f33442b, this.s.k(oVar, aVar, i2));
        }
    }

    public final void v() {
        Uri uri;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            synchronized (this.m) {
                uri = this.u;
            }
            u(new o(this.r, uri, 4, this.k), this.l, this.f32910h);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(Uri uri, e.a aVar, a.InterfaceC1522a interfaceC1522a, int i2, long j, Handler handler, b.h.b.a.d0.b bVar) {
        this(uri, aVar, new b.h.b.a.d0.v.g.c(), interfaceC1522a, i2, j, handler, bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, aVar, interfaceC1522a, Integer.valueOf(i2), Long.valueOf(j), handler, bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Uri) objArr2[0], (e.a) objArr2[1], (o.a) objArr2[2], (a.InterfaceC1522a) objArr2[3], ((Integer) objArr2[4]).intValue(), ((Long) objArr2[5]).longValue(), (Handler) objArr2[6], (b.h.b.a.d0.b) objArr2[7]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(Uri uri, e.a aVar, o.a<? extends b.h.b.a.d0.v.g.b> aVar2, a.InterfaceC1522a interfaceC1522a, int i2, long j, Handler handler, b.h.b.a.d0.b bVar) {
        this(null, uri, aVar, aVar2, interfaceC1522a, i2, j, handler, bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {uri, aVar, aVar2, interfaceC1522a, Integer.valueOf(i2), Long.valueOf(j), handler, bVar};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((b.h.b.a.d0.v.g.b) objArr2[0], (Uri) objArr2[1], (e.a) objArr2[2], (o.a) objArr2[3], (a.InterfaceC1522a) objArr2[4], ((Integer) objArr2[5]).intValue(), ((Long) objArr2[6]).longValue(), (Handler) objArr2[7], (b.h.b.a.d0.b) objArr2[8]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public c(b.h.b.a.d0.v.g.b bVar, Uri uri, e.a aVar, o.a<? extends b.h.b.a.d0.v.g.b> aVar2, a.InterfaceC1522a interfaceC1522a, int i2, long j, Handler handler, b.h.b.a.d0.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, uri, aVar, aVar2, interfaceC1522a, Integer.valueOf(i2), Long.valueOf(j), handler, bVar2};
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
        this.f32908f = aVar;
        this.k = aVar2;
        this.f32909g = interfaceC1522a;
        this.f32910h = i2;
        this.f32911i = j;
        this.f32907e = bVar != null;
        this.j = new b.a(handler, bVar2);
        this.m = new Object();
        this.n = new SparseArray<>();
        if (this.f32907e) {
            b.h.b.a.i0.a.f(!bVar.f32950c);
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
