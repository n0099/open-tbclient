package c.i.b.a.d0;

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
/* loaded from: classes4.dex */
public interface b {

    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Handler f33020a;

        /* renamed from: b  reason: collision with root package name */
        public final b f33021b;

        /* renamed from: c  reason: collision with root package name */
        public final long f33022c;

        /* renamed from: c.i.b.a.d0.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1484a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.i.b.a.h0.g f33023e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f33024f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f33025g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Format f33026h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ int f33027i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ Object f33028j;
            public final /* synthetic */ long k;
            public final /* synthetic */ long l;
            public final /* synthetic */ long m;
            public final /* synthetic */ a n;

            public RunnableC1484a(a aVar, c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r4;
                    Object[] objArr = {aVar, gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)};
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
                this.f33023e = gVar;
                this.f33024f = i2;
                this.f33025g = i3;
                this.f33026h = format;
                this.f33027i = i4;
                this.f33028j = obj;
                this.k = j2;
                this.l = j3;
                this.m = j4;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.n.f33021b.d(this.f33023e, this.f33024f, this.f33025g, this.f33026h, this.f33027i, this.f33028j, this.n.c(this.k), this.n.c(this.l), this.m);
                }
            }
        }

        /* renamed from: c.i.b.a.d0.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1485b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.i.b.a.h0.g f33029e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f33030f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f33031g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Format f33032h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ int f33033i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ Object f33034j;
            public final /* synthetic */ long k;
            public final /* synthetic */ long l;
            public final /* synthetic */ long m;
            public final /* synthetic */ long n;
            public final /* synthetic */ long o;
            public final /* synthetic */ a p;

            public RunnableC1485b(a aVar, c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6)};
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
                this.f33029e = gVar;
                this.f33030f = i2;
                this.f33031g = i3;
                this.f33032h = format;
                this.f33033i = i4;
                this.f33034j = obj;
                this.k = j2;
                this.l = j3;
                this.m = j4;
                this.n = j5;
                this.o = j6;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.p.f33021b.e(this.f33029e, this.f33030f, this.f33031g, this.f33032h, this.f33033i, this.f33034j, this.p.c(this.k), this.p.c(this.l), this.m, this.n, this.o);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.i.b.a.h0.g f33035e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f33036f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f33037g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Format f33038h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ int f33039i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ Object f33040j;
            public final /* synthetic */ long k;
            public final /* synthetic */ long l;
            public final /* synthetic */ long m;
            public final /* synthetic */ long n;
            public final /* synthetic */ long o;
            public final /* synthetic */ a p;

            public c(a aVar, c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6)};
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
                this.f33035e = gVar;
                this.f33036f = i2;
                this.f33037g = i3;
                this.f33038h = format;
                this.f33039i = i4;
                this.f33040j = obj;
                this.k = j2;
                this.l = j3;
                this.m = j4;
                this.n = j5;
                this.o = j6;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.p.f33021b.b(this.f33035e, this.f33036f, this.f33037g, this.f33038h, this.f33039i, this.f33040j, this.p.c(this.k), this.p.c(this.l), this.m, this.n, this.o);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class d implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.i.b.a.h0.g f33041e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f33042f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f33043g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Format f33044h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ int f33045i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ Object f33046j;
            public final /* synthetic */ long k;
            public final /* synthetic */ long l;
            public final /* synthetic */ long m;
            public final /* synthetic */ long n;
            public final /* synthetic */ long o;
            public final /* synthetic */ IOException p;
            public final /* synthetic */ boolean q;
            public final /* synthetic */ a r;

            public d(a aVar, c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6, IOException iOException, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), iOException, Boolean.valueOf(z)};
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
                this.f33041e = gVar;
                this.f33042f = i2;
                this.f33043g = i3;
                this.f33044h = format;
                this.f33045i = i4;
                this.f33046j = obj;
                this.k = j2;
                this.l = j3;
                this.m = j4;
                this.n = j5;
                this.o = j6;
                this.p = iOException;
                this.q = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.r.f33021b.c(this.f33041e, this.f33042f, this.f33043g, this.f33044h, this.f33045i, this.f33046j, this.r.c(this.k), this.r.c(this.l), this.m, this.n, this.o, this.p, this.q);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class e implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f33047e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Format f33048f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f33049g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Object f33050h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ long f33051i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ a f33052j;

            public e(a aVar, int i2, Format format, int i3, Object obj, long j2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i2), format, Integer.valueOf(i3), obj, Long.valueOf(j2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f33052j = aVar;
                this.f33047e = i2;
                this.f33048f = format;
                this.f33049g = i3;
                this.f33050h = obj;
                this.f33051i = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f33052j.f33021b.a(this.f33047e, this.f33048f, this.f33049g, this.f33050h, this.f33052j.c(this.f33051i));
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

        public final long c(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
                long b2 = c.i.b.a.b.b(j2);
                if (b2 == -9223372036854775807L) {
                    return -9223372036854775807L;
                }
                return this.f33022c + b2;
            }
            return invokeJ.longValue;
        }

        public a d(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) ? new a(this.f33020a, this.f33021b, j2) : (a) invokeJ.objValue;
        }

        public void e(int i2, Format format, int i3, Object obj, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), format, Integer.valueOf(i3), obj, Long.valueOf(j2)}) == null) || this.f33021b == null) {
                return;
            }
            this.f33020a.post(new e(this, i2, format, i3, obj, j2));
        }

        public void f(c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6)}) == null) || this.f33021b == null) {
                return;
            }
            this.f33020a.post(new c(this, gVar, i2, i3, format, i4, obj, j2, j3, j4, j5, j6));
        }

        public void g(c.i.b.a.h0.g gVar, int i2, long j2, long j3, long j4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{gVar, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
                f(gVar, i2, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j2, j3, j4);
            }
        }

        public void h(c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6)}) == null) || this.f33021b == null) {
                return;
            }
            this.f33020a.post(new RunnableC1485b(this, gVar, i2, i3, format, i4, obj, j2, j3, j4, j5, j6));
        }

        public void i(c.i.b.a.h0.g gVar, int i2, long j2, long j3, long j4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{gVar, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
                h(gVar, i2, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j2, j3, j4);
            }
        }

        public void j(c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6, IOException iOException, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), iOException, Boolean.valueOf(z)}) == null) || this.f33021b == null) {
                return;
            }
            this.f33020a.post(new d(this, gVar, i2, i3, format, i4, obj, j2, j3, j4, j5, j6, iOException, z));
        }

        public void k(c.i.b.a.h0.g gVar, int i2, long j2, long j3, long j4, IOException iOException, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{gVar, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), iOException, Boolean.valueOf(z)}) == null) {
                j(gVar, i2, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j2, j3, j4, iOException, z);
            }
        }

        public void l(c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) || this.f33021b == null) {
                return;
            }
            this.f33020a.post(new RunnableC1484a(this, gVar, i2, i3, format, i4, obj, j2, j3, j4));
        }

        public void m(c.i.b.a.h0.g gVar, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{gVar, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                l(gVar, i2, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j2);
            }
        }

        public a(Handler handler, b bVar, long j2) {
            Handler handler2;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {handler, bVar, Long.valueOf(j2)};
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
                c.i.b.a.i0.a.e(handler);
                handler2 = handler;
            } else {
                handler2 = null;
            }
            this.f33020a = handler2;
            this.f33021b = bVar;
            this.f33022c = j2;
        }
    }

    void a(int i2, Format format, int i3, Object obj, long j2);

    void b(c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6);

    void c(c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6, IOException iOException, boolean z);

    void d(c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4);

    void e(c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6);
}
