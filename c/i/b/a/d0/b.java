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
/* loaded from: classes9.dex */
public interface b {

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Handler a;

        /* renamed from: b  reason: collision with root package name */
        public final b f29037b;

        /* renamed from: c  reason: collision with root package name */
        public final long f29038c;

        /* renamed from: c.i.b.a.d0.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC1656a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.i.b.a.h0.g f29039e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f29040f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f29041g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Format f29042h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ int f29043i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ Object f29044j;
            public final /* synthetic */ long k;
            public final /* synthetic */ long l;
            public final /* synthetic */ long m;
            public final /* synthetic */ a n;

            public RunnableC1656a(a aVar, c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4) {
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
                this.f29039e = gVar;
                this.f29040f = i2;
                this.f29041g = i3;
                this.f29042h = format;
                this.f29043i = i4;
                this.f29044j = obj;
                this.k = j2;
                this.l = j3;
                this.m = j4;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.n.f29037b.d(this.f29039e, this.f29040f, this.f29041g, this.f29042h, this.f29043i, this.f29044j, this.n.c(this.k), this.n.c(this.l), this.m);
                }
            }
        }

        /* renamed from: c.i.b.a.d0.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC1657b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.i.b.a.h0.g f29045e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f29046f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f29047g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Format f29048h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ int f29049i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ Object f29050j;
            public final /* synthetic */ long k;
            public final /* synthetic */ long l;
            public final /* synthetic */ long m;
            public final /* synthetic */ long n;
            public final /* synthetic */ long o;
            public final /* synthetic */ a p;

            public RunnableC1657b(a aVar, c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6) {
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
                this.f29045e = gVar;
                this.f29046f = i2;
                this.f29047g = i3;
                this.f29048h = format;
                this.f29049i = i4;
                this.f29050j = obj;
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
                    this.p.f29037b.e(this.f29045e, this.f29046f, this.f29047g, this.f29048h, this.f29049i, this.f29050j, this.p.c(this.k), this.p.c(this.l), this.m, this.n, this.o);
                }
            }
        }

        /* loaded from: classes9.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.i.b.a.h0.g f29051e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f29052f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f29053g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Format f29054h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ int f29055i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ Object f29056j;
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
                this.f29051e = gVar;
                this.f29052f = i2;
                this.f29053g = i3;
                this.f29054h = format;
                this.f29055i = i4;
                this.f29056j = obj;
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
                    this.p.f29037b.b(this.f29051e, this.f29052f, this.f29053g, this.f29054h, this.f29055i, this.f29056j, this.p.c(this.k), this.p.c(this.l), this.m, this.n, this.o);
                }
            }
        }

        /* loaded from: classes9.dex */
        public class d implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.i.b.a.h0.g f29057e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f29058f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f29059g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Format f29060h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ int f29061i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ Object f29062j;
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
                this.f29057e = gVar;
                this.f29058f = i2;
                this.f29059g = i3;
                this.f29060h = format;
                this.f29061i = i4;
                this.f29062j = obj;
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
                    this.r.f29037b.c(this.f29057e, this.f29058f, this.f29059g, this.f29060h, this.f29061i, this.f29062j, this.r.c(this.k), this.r.c(this.l), this.m, this.n, this.o, this.p, this.q);
                }
            }
        }

        /* loaded from: classes9.dex */
        public class e implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f29063e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Format f29064f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f29065g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Object f29066h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ long f29067i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ a f29068j;

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
                this.f29068j = aVar;
                this.f29063e = i2;
                this.f29064f = format;
                this.f29065g = i3;
                this.f29066h = obj;
                this.f29067i = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f29068j.f29037b.a(this.f29063e, this.f29064f, this.f29065g, this.f29066h, this.f29068j.c(this.f29067i));
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
                return this.f29038c + b2;
            }
            return invokeJ.longValue;
        }

        public a d(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) ? new a(this.a, this.f29037b, j2) : (a) invokeJ.objValue;
        }

        public void e(int i2, Format format, int i3, Object obj, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), format, Integer.valueOf(i3), obj, Long.valueOf(j2)}) == null) || this.f29037b == null) {
                return;
            }
            this.a.post(new e(this, i2, format, i3, obj, j2));
        }

        public void f(c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6)}) == null) || this.f29037b == null) {
                return;
            }
            this.a.post(new c(this, gVar, i2, i3, format, i4, obj, j2, j3, j4, j5, j6));
        }

        public void g(c.i.b.a.h0.g gVar, int i2, long j2, long j3, long j4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{gVar, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
                f(gVar, i2, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j2, j3, j4);
            }
        }

        public void h(c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6)}) == null) || this.f29037b == null) {
                return;
            }
            this.a.post(new RunnableC1657b(this, gVar, i2, i3, format, i4, obj, j2, j3, j4, j5, j6));
        }

        public void i(c.i.b.a.h0.g gVar, int i2, long j2, long j3, long j4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{gVar, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
                h(gVar, i2, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j2, j3, j4);
            }
        }

        public void j(c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6, IOException iOException, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), iOException, Boolean.valueOf(z)}) == null) || this.f29037b == null) {
                return;
            }
            this.a.post(new d(this, gVar, i2, i3, format, i4, obj, j2, j3, j4, j5, j6, iOException, z));
        }

        public void k(c.i.b.a.h0.g gVar, int i2, long j2, long j3, long j4, IOException iOException, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{gVar, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), iOException, Boolean.valueOf(z)}) == null) {
                j(gVar, i2, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j2, j3, j4, iOException, z);
            }
        }

        public void l(c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) || this.f29037b == null) {
                return;
            }
            this.a.post(new RunnableC1656a(this, gVar, i2, i3, format, i4, obj, j2, j3, j4));
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
            this.a = handler2;
            this.f29037b = bVar;
            this.f29038c = j2;
        }
    }

    void a(int i2, Format format, int i3, Object obj, long j2);

    void b(c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6);

    void c(c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6, IOException iOException, boolean z);

    void d(c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4);

    void e(c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6);
}
