package c.i.b.a.d0;

import c.i.b.a.d0.l;
import c.i.b.a.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public final class d implements l, l.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final l f29053e;

    /* renamed from: f  reason: collision with root package name */
    public final long f29054f;

    /* renamed from: g  reason: collision with root package name */
    public final long f29055g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f29056h;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList<c> f29057i;

    /* renamed from: j  reason: collision with root package name */
    public l.a f29058j;

    /* loaded from: classes9.dex */
    public static final class a extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final long f29059c;

        /* renamed from: d  reason: collision with root package name */
        public final long f29060d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(w wVar, long j2, long j3) {
            super(wVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar, Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((w) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            c.i.b.a.i0.a.a(wVar.o() == 1);
            c.i.b.a.i0.a.a(wVar.h() == 1);
            w.c m = wVar.m(0, new w.c(), false);
            c.i.b.a.i0.a.a(!m.f29853e);
            j3 = j3 == Long.MIN_VALUE ? m.f29857i : j3;
            long j4 = m.f29857i;
            if (j4 != -9223372036854775807L) {
                j3 = j3 > j4 ? j4 : j3;
                c.i.b.a.i0.a.a(j2 == 0 || m.f29852d);
                c.i.b.a.i0.a.a(j2 <= j3);
            }
            c.i.b.a.i0.a.a(wVar.f(0, new w.b()).k() == 0);
            this.f29059c = j2;
            this.f29060d = j3;
        }

        @Override // c.i.b.a.w
        public w.b g(int i2, w.b bVar, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), bVar, Boolean.valueOf(z)})) == null) {
                w.b g2 = this.f29103b.g(0, bVar, z);
                long j2 = this.f29060d;
                g2.f29843d = j2 != -9223372036854775807L ? j2 - this.f29059c : -9223372036854775807L;
                return g2;
            }
            return (w.b) invokeCommon.objValue;
        }

        @Override // c.i.b.a.w
        public w.c n(int i2, w.c cVar, boolean z, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), cVar, Boolean.valueOf(z), Long.valueOf(j2)})) == null) {
                w.c n = this.f29103b.n(0, cVar, z, j2);
                long j3 = this.f29060d;
                n.f29857i = j3 != -9223372036854775807L ? j3 - this.f29059c : -9223372036854775807L;
                long j4 = n.f29856h;
                if (j4 != -9223372036854775807L) {
                    long max = Math.max(j4, this.f29059c);
                    n.f29856h = max;
                    long j5 = this.f29060d;
                    if (j5 != -9223372036854775807L) {
                        max = Math.min(max, j5);
                    }
                    n.f29856h = max;
                    n.f29856h = max - this.f29059c;
                }
                long b2 = c.i.b.a.b.b(this.f29059c);
                long j6 = n.f29850b;
                if (j6 != -9223372036854775807L) {
                    n.f29850b = j6 + b2;
                }
                long j7 = n.f29851c;
                if (j7 != -9223372036854775807L) {
                    n.f29851c = j7 + b2;
                }
                return n;
            }
            return (w.c) invokeCommon.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(l lVar, long j2, long j3) {
        this(lVar, j2, j3, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r9;
            Object[] objArr = {lVar, Long.valueOf(j2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((l) objArr2[0], ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.i.b.a.d0.l
    public void a(c.i.b.a.g gVar, boolean z, l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{gVar, Boolean.valueOf(z), aVar}) == null) {
            this.f29058j = aVar;
            this.f29053e.a(gVar, false, this);
        }
    }

    @Override // c.i.b.a.d0.l
    public void b() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f29053e.b();
        }
    }

    @Override // c.i.b.a.d0.l.a
    public void c(l lVar, w wVar, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, lVar, wVar, obj) == null) {
            this.f29058j.c(this, new a(wVar, this.f29054f, this.f29055g), obj);
            int size = this.f29057i.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f29057i.get(i2).f(this.f29054f, this.f29055g);
            }
        }
    }

    @Override // c.i.b.a.d0.l
    public k d(l.b bVar, c.i.b.a.h0.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, bVar, bVar2)) == null) {
            c cVar = new c(this.f29053e.d(bVar, bVar2), this.f29056h);
            this.f29057i.add(cVar);
            cVar.f(this.f29054f, this.f29055g);
            return cVar;
        }
        return (k) invokeLL.objValue;
    }

    @Override // c.i.b.a.d0.l
    public void e(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, kVar) == null) {
            c.i.b.a.i0.a.f(this.f29057i.remove(kVar));
            this.f29053e.e(((c) kVar).f29041e);
        }
    }

    @Override // c.i.b.a.d0.l
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f29053e.f();
        }
    }

    public d(l lVar, long j2, long j3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar, Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        c.i.b.a.i0.a.a(j2 >= 0);
        c.i.b.a.i0.a.e(lVar);
        this.f29053e = lVar;
        this.f29054f = j2;
        this.f29055g = j3;
        this.f29056h = z;
        this.f29057i = new ArrayList<>();
    }
}
