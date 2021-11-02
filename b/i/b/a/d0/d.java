package b.i.b.a.d0;

import b.i.b.a.d0.l;
import b.i.b.a.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public final class d implements l, l.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final l f31910e;

    /* renamed from: f  reason: collision with root package name */
    public final long f31911f;

    /* renamed from: g  reason: collision with root package name */
    public final long f31912g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f31913h;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList<c> f31914i;
    public l.a j;

    /* loaded from: classes6.dex */
    public static final class a extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final long f31915c;

        /* renamed from: d  reason: collision with root package name */
        public final long f31916d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(w wVar, long j, long j2) {
            super(wVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar, Long.valueOf(j), Long.valueOf(j2)};
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
            b.i.b.a.i0.a.a(wVar.o() == 1);
            b.i.b.a.i0.a.a(wVar.h() == 1);
            w.c m = wVar.m(0, new w.c(), false);
            b.i.b.a.i0.a.a(!m.f32791e);
            j2 = j2 == Long.MIN_VALUE ? m.f32795i : j2;
            long j3 = m.f32795i;
            if (j3 != -9223372036854775807L) {
                j2 = j2 > j3 ? j3 : j2;
                b.i.b.a.i0.a.a(j == 0 || m.f32790d);
                b.i.b.a.i0.a.a(j <= j2);
            }
            b.i.b.a.i0.a.a(wVar.f(0, new w.b()).k() == 0);
            this.f31915c = j;
            this.f31916d = j2;
        }

        @Override // b.i.b.a.w
        public w.b g(int i2, w.b bVar, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), bVar, Boolean.valueOf(z)})) == null) {
                w.b g2 = this.f31957b.g(0, bVar, z);
                long j = this.f31916d;
                g2.f32781d = j != -9223372036854775807L ? j - this.f31915c : -9223372036854775807L;
                return g2;
            }
            return (w.b) invokeCommon.objValue;
        }

        @Override // b.i.b.a.w
        public w.c n(int i2, w.c cVar, boolean z, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), cVar, Boolean.valueOf(z), Long.valueOf(j)})) == null) {
                w.c n = this.f31957b.n(0, cVar, z, j);
                long j2 = this.f31916d;
                n.f32795i = j2 != -9223372036854775807L ? j2 - this.f31915c : -9223372036854775807L;
                long j3 = n.f32794h;
                if (j3 != -9223372036854775807L) {
                    long max = Math.max(j3, this.f31915c);
                    n.f32794h = max;
                    long j4 = this.f31916d;
                    if (j4 != -9223372036854775807L) {
                        max = Math.min(max, j4);
                    }
                    n.f32794h = max;
                    n.f32794h = max - this.f31915c;
                }
                long b2 = b.i.b.a.b.b(this.f31915c);
                long j5 = n.f32788b;
                if (j5 != -9223372036854775807L) {
                    n.f32788b = j5 + b2;
                }
                long j6 = n.f32789c;
                if (j6 != -9223372036854775807L) {
                    n.f32789c = j6 + b2;
                }
                return n;
            }
            return (w.c) invokeCommon.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(l lVar, long j, long j2) {
        this(lVar, j, j2, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r9;
            Object[] objArr = {lVar, Long.valueOf(j), Long.valueOf(j2)};
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

    @Override // b.i.b.a.d0.l
    public void a(b.i.b.a.g gVar, boolean z, l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{gVar, Boolean.valueOf(z), aVar}) == null) {
            this.j = aVar;
            this.f31910e.a(gVar, false, this);
        }
    }

    @Override // b.i.b.a.d0.l
    public void b() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f31910e.b();
        }
    }

    @Override // b.i.b.a.d0.l.a
    public void c(l lVar, w wVar, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, lVar, wVar, obj) == null) {
            this.j.c(this, new a(wVar, this.f31911f, this.f31912g), obj);
            int size = this.f31914i.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f31914i.get(i2).f(this.f31911f, this.f31912g);
            }
        }
    }

    @Override // b.i.b.a.d0.l
    public k d(l.b bVar, b.i.b.a.h0.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, bVar, bVar2)) == null) {
            c cVar = new c(this.f31910e.d(bVar, bVar2), this.f31913h);
            this.f31914i.add(cVar);
            cVar.f(this.f31911f, this.f31912g);
            return cVar;
        }
        return (k) invokeLL.objValue;
    }

    @Override // b.i.b.a.d0.l
    public void e(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, kVar) == null) {
            b.i.b.a.i0.a.f(this.f31914i.remove(kVar));
            this.f31910e.e(((c) kVar).f31900e);
        }
    }

    @Override // b.i.b.a.d0.l
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f31910e.f();
        }
    }

    public d(l lVar, long j, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        b.i.b.a.i0.a.a(j >= 0);
        b.i.b.a.i0.a.e(lVar);
        this.f31910e = lVar;
        this.f31911f = j;
        this.f31912g = j2;
        this.f31913h = z;
        this.f31914i = new ArrayList<>();
    }
}
