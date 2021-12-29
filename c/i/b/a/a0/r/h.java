package c.i.b.a.a0.r;

import androidx.core.view.InputDeviceCompat;
import c.i.b.a.a0.l;
import c.i.b.a.a0.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import java.io.IOException;
/* loaded from: classes9.dex */
public abstract class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final d a;

    /* renamed from: b  reason: collision with root package name */
    public m f29681b;

    /* renamed from: c  reason: collision with root package name */
    public c.i.b.a.a0.g f29682c;

    /* renamed from: d  reason: collision with root package name */
    public f f29683d;

    /* renamed from: e  reason: collision with root package name */
    public long f29684e;

    /* renamed from: f  reason: collision with root package name */
    public long f29685f;

    /* renamed from: g  reason: collision with root package name */
    public long f29686g;

    /* renamed from: h  reason: collision with root package name */
    public int f29687h;

    /* renamed from: i  reason: collision with root package name */
    public int f29688i;

    /* renamed from: j  reason: collision with root package name */
    public b f29689j;

    /* renamed from: k  reason: collision with root package name */
    public long f29690k;
    public boolean l;
    public boolean m;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Format a;

        /* renamed from: b  reason: collision with root package name */
        public f f29691b;

        public b() {
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
    }

    /* loaded from: classes9.dex */
    public static final class c implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

        @Override // c.i.b.a.a0.r.f
        public long a(c.i.b.a.a0.f fVar) throws IOException, InterruptedException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                return -1L;
            }
            return invokeL.longValue;
        }

        @Override // c.i.b.a.a0.r.f
        public l d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new l.a(-9223372036854775807L) : (l) invokeV.objValue;
        }

        @Override // c.i.b.a.a0.r.f
        public long e(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
                return 0L;
            }
            return invokeJ.longValue;
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

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
                return;
            }
        }
        this.a = new d();
    }

    public long a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) ? (j2 * 1000000) / this.f29688i : invokeJ.longValue;
    }

    public long b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) ? (this.f29688i * j2) / 1000000 : invokeJ.longValue;
    }

    public void c(c.i.b.a.a0.g gVar, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, gVar, mVar) == null) {
            this.f29682c = gVar;
            this.f29681b = mVar;
            j(true);
        }
    }

    public void d(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            this.f29686g = j2;
        }
    }

    public abstract long e(c.i.b.a.i0.l lVar);

    public final int f(c.i.b.a.a0.f fVar, c.i.b.a.a0.k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, fVar, kVar)) == null) {
            int i2 = this.f29687h;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        return i(fVar, kVar);
                    }
                    throw new IllegalStateException();
                }
                fVar.h((int) this.f29685f);
                this.f29687h = 2;
                return 0;
            }
            return g(fVar);
        }
        return invokeLL.intValue;
    }

    public final int g(c.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, fVar)) == null) {
            boolean z = true;
            while (z) {
                if (!this.a.d(fVar)) {
                    this.f29687h = 3;
                    return -1;
                }
                this.f29690k = fVar.getPosition() - this.f29685f;
                z = h(this.a.c(), this.f29685f, this.f29689j);
                if (z) {
                    this.f29685f = fVar.getPosition();
                }
            }
            Format format = this.f29689j.a;
            this.f29688i = format.sampleRate;
            if (!this.m) {
                this.f29681b.b(format);
                this.m = true;
            }
            f fVar2 = this.f29689j.f29691b;
            if (fVar2 != null) {
                this.f29683d = fVar2;
            } else if (fVar.getLength() == -1) {
                this.f29683d = new c(null);
            } else {
                e b2 = this.a.b();
                this.f29683d = new c.i.b.a.a0.r.a(this.f29685f, fVar.getLength(), this, b2.f29677e + b2.f29678f, b2.f29675c);
            }
            this.f29689j = null;
            this.f29687h = 2;
            this.a.f();
            return 0;
        }
        return invokeL.intValue;
    }

    public abstract boolean h(c.i.b.a.i0.l lVar, long j2, b bVar) throws IOException, InterruptedException;

    public final int i(c.i.b.a.a0.f fVar, c.i.b.a.a0.k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar, kVar)) == null) {
            long a2 = this.f29683d.a(fVar);
            if (a2 >= 0) {
                kVar.a = a2;
                return 1;
            }
            if (a2 < -1) {
                d(-(a2 + 2));
            }
            if (!this.l) {
                this.f29682c.p(this.f29683d.d());
                this.l = true;
            }
            if (this.f29690k <= 0 && !this.a.d(fVar)) {
                this.f29687h = 3;
                return -1;
            }
            this.f29690k = 0L;
            c.i.b.a.i0.l c2 = this.a.c();
            long e2 = e(c2);
            if (e2 >= 0) {
                long j2 = this.f29686g;
                if (j2 + e2 >= this.f29684e) {
                    long a3 = a(j2);
                    this.f29681b.a(c2, c2.d());
                    this.f29681b.c(a3, 1, c2.d(), 0, null);
                    this.f29684e = -1L;
                }
            }
            this.f29686g += e2;
            return 0;
        }
        return invokeLL.intValue;
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (z) {
                this.f29689j = new b();
                this.f29685f = 0L;
                this.f29687h = 0;
            } else {
                this.f29687h = 1;
            }
            this.f29684e = -1L;
            this.f29686g = 0L;
        }
    }

    public final void k(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.a.e();
            if (j2 == 0) {
                j(!this.l);
            } else if (this.f29687h != 0) {
                this.f29684e = this.f29683d.e(j3);
                this.f29687h = 2;
            }
        }
    }
}
