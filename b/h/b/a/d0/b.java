package b.h.b.a.d0;

import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import java.io.IOException;
/* loaded from: classes6.dex */
public interface b {

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Handler f32730a;

        /* renamed from: b  reason: collision with root package name */
        public final b f32731b;

        /* renamed from: c  reason: collision with root package name */
        public final long f32732c;

        /* renamed from: b.h.b.a.d0.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC1520a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.h.b.a.h0.g f32733e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f32734f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f32735g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Format f32736h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ int f32737i;
            public final /* synthetic */ Object j;
            public final /* synthetic */ long k;
            public final /* synthetic */ long l;
            public final /* synthetic */ long m;
            public final /* synthetic */ a n;

            public RunnableC1520a(a aVar, b.h.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r4;
                    Object[] objArr = {aVar, gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i5 = newInitContext.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.n = aVar;
                this.f32733e = gVar;
                this.f32734f = i2;
                this.f32735g = i3;
                this.f32736h = format;
                this.f32737i = i4;
                this.j = obj;
                this.k = j;
                this.l = j2;
                this.m = j3;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.n.f32731b.d(this.f32733e, this.f32734f, this.f32735g, this.f32736h, this.f32737i, this.j, this.n.c(this.k), this.n.c(this.l), this.m);
                }
            }
        }

        /* renamed from: b.h.b.a.d0.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC1521b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.h.b.a.h0.g f32738e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f32739f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f32740g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Format f32741h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ int f32742i;
            public final /* synthetic */ Object j;
            public final /* synthetic */ long k;
            public final /* synthetic */ long l;
            public final /* synthetic */ long m;
            public final /* synthetic */ long n;
            public final /* synthetic */ long o;
            public final /* synthetic */ a p;

            public RunnableC1521b(a aVar, b.h.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3, long j4, long j5) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i5 = newInitContext.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.p = aVar;
                this.f32738e = gVar;
                this.f32739f = i2;
                this.f32740g = i3;
                this.f32741h = format;
                this.f32742i = i4;
                this.j = obj;
                this.k = j;
                this.l = j2;
                this.m = j3;
                this.n = j4;
                this.o = j5;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.p.f32731b.e(this.f32738e, this.f32739f, this.f32740g, this.f32741h, this.f32742i, this.j, this.p.c(this.k), this.p.c(this.l), this.m, this.n, this.o);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.h.b.a.h0.g f32743e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f32744f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f32745g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Format f32746h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ int f32747i;
            public final /* synthetic */ Object j;
            public final /* synthetic */ long k;
            public final /* synthetic */ long l;
            public final /* synthetic */ long m;
            public final /* synthetic */ long n;
            public final /* synthetic */ long o;
            public final /* synthetic */ a p;

            public c(a aVar, b.h.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3, long j4, long j5) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i5 = newInitContext.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.p = aVar;
                this.f32743e = gVar;
                this.f32744f = i2;
                this.f32745g = i3;
                this.f32746h = format;
                this.f32747i = i4;
                this.j = obj;
                this.k = j;
                this.l = j2;
                this.m = j3;
                this.n = j4;
                this.o = j5;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.p.f32731b.b(this.f32743e, this.f32744f, this.f32745g, this.f32746h, this.f32747i, this.j, this.p.c(this.k), this.p.c(this.l), this.m, this.n, this.o);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class d implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.h.b.a.h0.g f32748e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f32749f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f32750g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Format f32751h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ int f32752i;
            public final /* synthetic */ Object j;
            public final /* synthetic */ long k;
            public final /* synthetic */ long l;
            public final /* synthetic */ long m;
            public final /* synthetic */ long n;
            public final /* synthetic */ long o;
            public final /* synthetic */ IOException p;
            public final /* synthetic */ boolean q;
            public final /* synthetic */ a r;

            public d(a aVar, b.h.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), iOException, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i5 = newInitContext.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.r = aVar;
                this.f32748e = gVar;
                this.f32749f = i2;
                this.f32750g = i3;
                this.f32751h = format;
                this.f32752i = i4;
                this.j = obj;
                this.k = j;
                this.l = j2;
                this.m = j3;
                this.n = j4;
                this.o = j5;
                this.p = iOException;
                this.q = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.r.f32731b.c(this.f32748e, this.f32749f, this.f32750g, this.f32751h, this.f32752i, this.j, this.r.c(this.k), this.r.c(this.l), this.m, this.n, this.o, this.p, this.q);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class e implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f32753e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Format f32754f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f32755g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Object f32756h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ long f32757i;
            public final /* synthetic */ a j;

            public e(a aVar, int i2, Format format, int i3, Object obj, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i2), format, Integer.valueOf(i3), obj, Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.j = aVar;
                this.f32753e = i2;
                this.f32754f = format;
                this.f32755g = i3;
                this.f32756h = obj;
                this.f32757i = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.j.f32731b.a(this.f32753e, this.f32754f, this.f32755g, this.f32756h, this.j.c(this.f32757i));
                }
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(Handler handler, b bVar) {
            this(handler, bVar, 0L);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {handler, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((Handler) objArr2[0], (b) objArr2[1], ((Long) objArr2[2]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public final long c(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                long b2 = b.h.b.a.b.b(j);
                if (b2 == -9223372036854775807L) {
                    return -9223372036854775807L;
                }
                return this.f32732c + b2;
            }
            return invokeJ.longValue;
        }

        public a d(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? new a(this.f32730a, this.f32731b, j) : (a) invokeJ.objValue;
        }

        public void e(int i2, Format format, int i3, Object obj, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), format, Integer.valueOf(i3), obj, Long.valueOf(j)}) == null) || this.f32731b == null) {
                return;
            }
            this.f32730a.post(new e(this, i2, format, i3, obj, j));
        }

        public void f(b.h.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3, long j4, long j5) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)}) == null) || this.f32731b == null) {
                return;
            }
            this.f32730a.post(new c(this, gVar, i2, i3, format, i4, obj, j, j2, j3, j4, j5));
        }

        public void g(b.h.b.a.h0.g gVar, int i2, long j, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{gVar, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                f(gVar, i2, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
            }
        }

        public void h(b.h.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3, long j4, long j5) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)}) == null) || this.f32731b == null) {
                return;
            }
            this.f32730a.post(new RunnableC1521b(this, gVar, i2, i3, format, i4, obj, j, j2, j3, j4, j5));
        }

        public void i(b.h.b.a.h0.g gVar, int i2, long j, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{gVar, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                h(gVar, i2, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
            }
        }

        public void j(b.h.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), iOException, Boolean.valueOf(z)}) == null) || this.f32731b == null) {
                return;
            }
            this.f32730a.post(new d(this, gVar, i2, i3, format, i4, obj, j, j2, j3, j4, j5, iOException, z));
        }

        public void k(b.h.b.a.h0.g gVar, int i2, long j, long j2, long j3, IOException iOException, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{gVar, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), iOException, Boolean.valueOf(z)}) == null) {
                j(gVar, i2, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3, iOException, z);
            }
        }

        public void l(b.h.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) || this.f32731b == null) {
                return;
            }
            this.f32730a.post(new RunnableC1520a(this, gVar, i2, i3, format, i4, obj, j, j2, j3));
        }

        public void m(b.h.b.a.h0.g gVar, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{gVar, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                l(gVar, i2, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j);
            }
        }

        public a(Handler handler, b bVar, long j) {
            Handler handler2;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {handler, bVar, Long.valueOf(j)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (bVar != null) {
                b.h.b.a.i0.a.e(handler);
                handler2 = handler;
            } else {
                handler2 = null;
            }
            this.f32730a = handler2;
            this.f32731b = bVar;
            this.f32732c = j;
        }
    }

    void a(int i2, Format format, int i3, Object obj, long j);

    void b(b.h.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3, long j4, long j5);

    void c(b.h.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z);

    void d(b.h.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3);

    void e(b.h.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3, long j4, long j5);
}
