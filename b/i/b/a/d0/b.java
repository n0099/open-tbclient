package b.i.b.a.d0;

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
        public final Handler f31872a;

        /* renamed from: b  reason: collision with root package name */
        public final b f31873b;

        /* renamed from: c  reason: collision with root package name */
        public final long f31874c;

        /* renamed from: b.i.b.a.d0.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC1478a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.i.b.a.h0.g f31875e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f31876f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f31877g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Format f31878h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ int f31879i;
            public final /* synthetic */ Object j;
            public final /* synthetic */ long k;
            public final /* synthetic */ long l;
            public final /* synthetic */ long m;
            public final /* synthetic */ a n;

            public RunnableC1478a(a aVar, b.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3) {
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
                this.f31875e = gVar;
                this.f31876f = i2;
                this.f31877g = i3;
                this.f31878h = format;
                this.f31879i = i4;
                this.j = obj;
                this.k = j;
                this.l = j2;
                this.m = j3;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.n.f31873b.d(this.f31875e, this.f31876f, this.f31877g, this.f31878h, this.f31879i, this.j, this.n.c(this.k), this.n.c(this.l), this.m);
                }
            }
        }

        /* renamed from: b.i.b.a.d0.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC1479b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.i.b.a.h0.g f31880e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f31881f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f31882g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Format f31883h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ int f31884i;
            public final /* synthetic */ Object j;
            public final /* synthetic */ long k;
            public final /* synthetic */ long l;
            public final /* synthetic */ long m;
            public final /* synthetic */ long n;
            public final /* synthetic */ long o;
            public final /* synthetic */ a p;

            public RunnableC1479b(a aVar, b.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3, long j4, long j5) {
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
                this.f31880e = gVar;
                this.f31881f = i2;
                this.f31882g = i3;
                this.f31883h = format;
                this.f31884i = i4;
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
                    this.p.f31873b.e(this.f31880e, this.f31881f, this.f31882g, this.f31883h, this.f31884i, this.j, this.p.c(this.k), this.p.c(this.l), this.m, this.n, this.o);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.i.b.a.h0.g f31885e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f31886f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f31887g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Format f31888h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ int f31889i;
            public final /* synthetic */ Object j;
            public final /* synthetic */ long k;
            public final /* synthetic */ long l;
            public final /* synthetic */ long m;
            public final /* synthetic */ long n;
            public final /* synthetic */ long o;
            public final /* synthetic */ a p;

            public c(a aVar, b.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3, long j4, long j5) {
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
                this.f31885e = gVar;
                this.f31886f = i2;
                this.f31887g = i3;
                this.f31888h = format;
                this.f31889i = i4;
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
                    this.p.f31873b.b(this.f31885e, this.f31886f, this.f31887g, this.f31888h, this.f31889i, this.j, this.p.c(this.k), this.p.c(this.l), this.m, this.n, this.o);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class d implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.i.b.a.h0.g f31890e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f31891f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f31892g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Format f31893h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ int f31894i;
            public final /* synthetic */ Object j;
            public final /* synthetic */ long k;
            public final /* synthetic */ long l;
            public final /* synthetic */ long m;
            public final /* synthetic */ long n;
            public final /* synthetic */ long o;
            public final /* synthetic */ IOException p;
            public final /* synthetic */ boolean q;
            public final /* synthetic */ a r;

            public d(a aVar, b.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
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
                this.f31890e = gVar;
                this.f31891f = i2;
                this.f31892g = i3;
                this.f31893h = format;
                this.f31894i = i4;
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
                    this.r.f31873b.c(this.f31890e, this.f31891f, this.f31892g, this.f31893h, this.f31894i, this.j, this.r.c(this.k), this.r.c(this.l), this.m, this.n, this.o, this.p, this.q);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class e implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f31895e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Format f31896f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f31897g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Object f31898h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ long f31899i;
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
                this.f31895e = i2;
                this.f31896f = format;
                this.f31897g = i3;
                this.f31898h = obj;
                this.f31899i = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.j.f31873b.a(this.f31895e, this.f31896f, this.f31897g, this.f31898h, this.j.c(this.f31899i));
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
                long b2 = b.i.b.a.b.b(j);
                if (b2 == -9223372036854775807L) {
                    return -9223372036854775807L;
                }
                return this.f31874c + b2;
            }
            return invokeJ.longValue;
        }

        public a d(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? new a(this.f31872a, this.f31873b, j) : (a) invokeJ.objValue;
        }

        public void e(int i2, Format format, int i3, Object obj, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), format, Integer.valueOf(i3), obj, Long.valueOf(j)}) == null) || this.f31873b == null) {
                return;
            }
            this.f31872a.post(new e(this, i2, format, i3, obj, j));
        }

        public void f(b.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3, long j4, long j5) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)}) == null) || this.f31873b == null) {
                return;
            }
            this.f31872a.post(new c(this, gVar, i2, i3, format, i4, obj, j, j2, j3, j4, j5));
        }

        public void g(b.i.b.a.h0.g gVar, int i2, long j, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{gVar, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                f(gVar, i2, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
            }
        }

        public void h(b.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3, long j4, long j5) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)}) == null) || this.f31873b == null) {
                return;
            }
            this.f31872a.post(new RunnableC1479b(this, gVar, i2, i3, format, i4, obj, j, j2, j3, j4, j5));
        }

        public void i(b.i.b.a.h0.g gVar, int i2, long j, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{gVar, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                h(gVar, i2, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
            }
        }

        public void j(b.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), iOException, Boolean.valueOf(z)}) == null) || this.f31873b == null) {
                return;
            }
            this.f31872a.post(new d(this, gVar, i2, i3, format, i4, obj, j, j2, j3, j4, j5, iOException, z));
        }

        public void k(b.i.b.a.h0.g gVar, int i2, long j, long j2, long j3, IOException iOException, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{gVar, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), iOException, Boolean.valueOf(z)}) == null) {
                j(gVar, i2, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3, iOException, z);
            }
        }

        public void l(b.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) || this.f31873b == null) {
                return;
            }
            this.f31872a.post(new RunnableC1478a(this, gVar, i2, i3, format, i4, obj, j, j2, j3));
        }

        public void m(b.i.b.a.h0.g gVar, int i2, long j) {
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
                b.i.b.a.i0.a.e(handler);
                handler2 = handler;
            } else {
                handler2 = null;
            }
            this.f31872a = handler2;
            this.f31873b = bVar;
            this.f31874c = j;
        }
    }

    void a(int i2, Format format, int i3, Object obj, long j);

    void b(b.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3, long j4, long j5);

    void c(b.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z);

    void d(b.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3);

    void e(b.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3, long j4, long j5);
}
