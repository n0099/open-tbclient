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
        public final Handler f32884a;

        /* renamed from: b  reason: collision with root package name */
        public final b f32885b;

        /* renamed from: c  reason: collision with root package name */
        public final long f32886c;

        /* renamed from: c.i.b.a.d0.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1483a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.i.b.a.h0.g f32887e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f32888f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f32889g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Format f32890h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ int f32891i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ Object f32892j;
            public final /* synthetic */ long k;
            public final /* synthetic */ long l;
            public final /* synthetic */ long m;
            public final /* synthetic */ a n;

            public RunnableC1483a(a aVar, c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4) {
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
                this.f32887e = gVar;
                this.f32888f = i2;
                this.f32889g = i3;
                this.f32890h = format;
                this.f32891i = i4;
                this.f32892j = obj;
                this.k = j2;
                this.l = j3;
                this.m = j4;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.n.f32885b.d(this.f32887e, this.f32888f, this.f32889g, this.f32890h, this.f32891i, this.f32892j, this.n.c(this.k), this.n.c(this.l), this.m);
                }
            }
        }

        /* renamed from: c.i.b.a.d0.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1484b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.i.b.a.h0.g f32893e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f32894f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f32895g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Format f32896h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ int f32897i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ Object f32898j;
            public final /* synthetic */ long k;
            public final /* synthetic */ long l;
            public final /* synthetic */ long m;
            public final /* synthetic */ long n;
            public final /* synthetic */ long o;
            public final /* synthetic */ a p;

            public RunnableC1484b(a aVar, c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6) {
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
                this.f32893e = gVar;
                this.f32894f = i2;
                this.f32895g = i3;
                this.f32896h = format;
                this.f32897i = i4;
                this.f32898j = obj;
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
                    this.p.f32885b.e(this.f32893e, this.f32894f, this.f32895g, this.f32896h, this.f32897i, this.f32898j, this.p.c(this.k), this.p.c(this.l), this.m, this.n, this.o);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.i.b.a.h0.g f32899e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f32900f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f32901g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Format f32902h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ int f32903i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ Object f32904j;
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
                this.f32899e = gVar;
                this.f32900f = i2;
                this.f32901g = i3;
                this.f32902h = format;
                this.f32903i = i4;
                this.f32904j = obj;
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
                    this.p.f32885b.b(this.f32899e, this.f32900f, this.f32901g, this.f32902h, this.f32903i, this.f32904j, this.p.c(this.k), this.p.c(this.l), this.m, this.n, this.o);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class d implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.i.b.a.h0.g f32905e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f32906f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f32907g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Format f32908h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ int f32909i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ Object f32910j;
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
                this.f32905e = gVar;
                this.f32906f = i2;
                this.f32907g = i3;
                this.f32908h = format;
                this.f32909i = i4;
                this.f32910j = obj;
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
                    this.r.f32885b.c(this.f32905e, this.f32906f, this.f32907g, this.f32908h, this.f32909i, this.f32910j, this.r.c(this.k), this.r.c(this.l), this.m, this.n, this.o, this.p, this.q);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class e implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f32911e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Format f32912f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f32913g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Object f32914h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ long f32915i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ a f32916j;

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
                this.f32916j = aVar;
                this.f32911e = i2;
                this.f32912f = format;
                this.f32913g = i3;
                this.f32914h = obj;
                this.f32915i = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f32916j.f32885b.a(this.f32911e, this.f32912f, this.f32913g, this.f32914h, this.f32916j.c(this.f32915i));
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
                return this.f32886c + b2;
            }
            return invokeJ.longValue;
        }

        public a d(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) ? new a(this.f32884a, this.f32885b, j2) : (a) invokeJ.objValue;
        }

        public void e(int i2, Format format, int i3, Object obj, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), format, Integer.valueOf(i3), obj, Long.valueOf(j2)}) == null) || this.f32885b == null) {
                return;
            }
            this.f32884a.post(new e(this, i2, format, i3, obj, j2));
        }

        public void f(c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6)}) == null) || this.f32885b == null) {
                return;
            }
            this.f32884a.post(new c(this, gVar, i2, i3, format, i4, obj, j2, j3, j4, j5, j6));
        }

        public void g(c.i.b.a.h0.g gVar, int i2, long j2, long j3, long j4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{gVar, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
                f(gVar, i2, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j2, j3, j4);
            }
        }

        public void h(c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6)}) == null) || this.f32885b == null) {
                return;
            }
            this.f32884a.post(new RunnableC1484b(this, gVar, i2, i3, format, i4, obj, j2, j3, j4, j5, j6));
        }

        public void i(c.i.b.a.h0.g gVar, int i2, long j2, long j3, long j4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{gVar, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
                h(gVar, i2, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j2, j3, j4);
            }
        }

        public void j(c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6, IOException iOException, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), iOException, Boolean.valueOf(z)}) == null) || this.f32885b == null) {
                return;
            }
            this.f32884a.post(new d(this, gVar, i2, i3, format, i4, obj, j2, j3, j4, j5, j6, iOException, z));
        }

        public void k(c.i.b.a.h0.g gVar, int i2, long j2, long j3, long j4, IOException iOException, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{gVar, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), iOException, Boolean.valueOf(z)}) == null) {
                j(gVar, i2, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j2, j3, j4, iOException, z);
            }
        }

        public void l(c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) || this.f32885b == null) {
                return;
            }
            this.f32884a.post(new RunnableC1483a(this, gVar, i2, i3, format, i4, obj, j2, j3, j4));
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
            this.f32884a = handler2;
            this.f32885b = bVar;
            this.f32886c = j2;
        }
    }

    void a(int i2, Format format, int i3, Object obj, long j2);

    void b(c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6);

    void c(c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6, IOException iOException, boolean z);

    void d(c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4);

    void e(c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6);
}
