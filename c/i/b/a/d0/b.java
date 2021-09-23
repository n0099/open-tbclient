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
        public final Handler f33016a;

        /* renamed from: b  reason: collision with root package name */
        public final b f33017b;

        /* renamed from: c  reason: collision with root package name */
        public final long f33018c;

        /* renamed from: c.i.b.a.d0.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1482a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.i.b.a.h0.g f33019e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f33020f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f33021g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Format f33022h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ int f33023i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ Object f33024j;
            public final /* synthetic */ long k;
            public final /* synthetic */ long l;
            public final /* synthetic */ long m;
            public final /* synthetic */ a n;

            public RunnableC1482a(a aVar, c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4) {
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
                this.f33019e = gVar;
                this.f33020f = i2;
                this.f33021g = i3;
                this.f33022h = format;
                this.f33023i = i4;
                this.f33024j = obj;
                this.k = j2;
                this.l = j3;
                this.m = j4;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.n.f33017b.d(this.f33019e, this.f33020f, this.f33021g, this.f33022h, this.f33023i, this.f33024j, this.n.c(this.k), this.n.c(this.l), this.m);
                }
            }
        }

        /* renamed from: c.i.b.a.d0.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1483b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.i.b.a.h0.g f33025e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f33026f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f33027g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Format f33028h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ int f33029i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ Object f33030j;
            public final /* synthetic */ long k;
            public final /* synthetic */ long l;
            public final /* synthetic */ long m;
            public final /* synthetic */ long n;
            public final /* synthetic */ long o;
            public final /* synthetic */ a p;

            public RunnableC1483b(a aVar, c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6) {
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
                this.f33025e = gVar;
                this.f33026f = i2;
                this.f33027g = i3;
                this.f33028h = format;
                this.f33029i = i4;
                this.f33030j = obj;
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
                    this.p.f33017b.e(this.f33025e, this.f33026f, this.f33027g, this.f33028h, this.f33029i, this.f33030j, this.p.c(this.k), this.p.c(this.l), this.m, this.n, this.o);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.i.b.a.h0.g f33031e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f33032f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f33033g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Format f33034h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ int f33035i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ Object f33036j;
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
                this.f33031e = gVar;
                this.f33032f = i2;
                this.f33033g = i3;
                this.f33034h = format;
                this.f33035i = i4;
                this.f33036j = obj;
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
                    this.p.f33017b.b(this.f33031e, this.f33032f, this.f33033g, this.f33034h, this.f33035i, this.f33036j, this.p.c(this.k), this.p.c(this.l), this.m, this.n, this.o);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class d implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.i.b.a.h0.g f33037e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f33038f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f33039g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Format f33040h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ int f33041i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ Object f33042j;
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
                this.f33037e = gVar;
                this.f33038f = i2;
                this.f33039g = i3;
                this.f33040h = format;
                this.f33041i = i4;
                this.f33042j = obj;
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
                    this.r.f33017b.c(this.f33037e, this.f33038f, this.f33039g, this.f33040h, this.f33041i, this.f33042j, this.r.c(this.k), this.r.c(this.l), this.m, this.n, this.o, this.p, this.q);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class e implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f33043e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Format f33044f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f33045g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Object f33046h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ long f33047i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ a f33048j;

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
                this.f33048j = aVar;
                this.f33043e = i2;
                this.f33044f = format;
                this.f33045g = i3;
                this.f33046h = obj;
                this.f33047i = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f33048j.f33017b.a(this.f33043e, this.f33044f, this.f33045g, this.f33046h, this.f33048j.c(this.f33047i));
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
                return this.f33018c + b2;
            }
            return invokeJ.longValue;
        }

        public a d(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) ? new a(this.f33016a, this.f33017b, j2) : (a) invokeJ.objValue;
        }

        public void e(int i2, Format format, int i3, Object obj, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), format, Integer.valueOf(i3), obj, Long.valueOf(j2)}) == null) || this.f33017b == null) {
                return;
            }
            this.f33016a.post(new e(this, i2, format, i3, obj, j2));
        }

        public void f(c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6)}) == null) || this.f33017b == null) {
                return;
            }
            this.f33016a.post(new c(this, gVar, i2, i3, format, i4, obj, j2, j3, j4, j5, j6));
        }

        public void g(c.i.b.a.h0.g gVar, int i2, long j2, long j3, long j4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{gVar, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
                f(gVar, i2, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j2, j3, j4);
            }
        }

        public void h(c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6)}) == null) || this.f33017b == null) {
                return;
            }
            this.f33016a.post(new RunnableC1483b(this, gVar, i2, i3, format, i4, obj, j2, j3, j4, j5, j6));
        }

        public void i(c.i.b.a.h0.g gVar, int i2, long j2, long j3, long j4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{gVar, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
                h(gVar, i2, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j2, j3, j4);
            }
        }

        public void j(c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6, IOException iOException, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), iOException, Boolean.valueOf(z)}) == null) || this.f33017b == null) {
                return;
            }
            this.f33016a.post(new d(this, gVar, i2, i3, format, i4, obj, j2, j3, j4, j5, j6, iOException, z));
        }

        public void k(c.i.b.a.h0.g gVar, int i2, long j2, long j3, long j4, IOException iOException, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{gVar, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), iOException, Boolean.valueOf(z)}) == null) {
                j(gVar, i2, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j2, j3, j4, iOException, z);
            }
        }

        public void l(c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{gVar, Integer.valueOf(i2), Integer.valueOf(i3), format, Integer.valueOf(i4), obj, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) || this.f33017b == null) {
                return;
            }
            this.f33016a.post(new RunnableC1482a(this, gVar, i2, i3, format, i4, obj, j2, j3, j4));
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
            this.f33016a = handler2;
            this.f33017b = bVar;
            this.f33018c = j2;
        }
    }

    void a(int i2, Format format, int i3, Object obj, long j2);

    void b(c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6);

    void c(c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6, IOException iOException, boolean z);

    void d(c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4);

    void e(c.i.b.a.h0.g gVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6);
}
