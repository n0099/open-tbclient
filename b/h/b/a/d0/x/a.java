package b.h.b.a.d0.x;

import android.net.Uri;
import b.h.b.a.a0.q.j;
import b.h.b.a.a0.q.k;
import b.h.b.a.d0.u.h;
import b.h.b.a.d0.u.i;
import b.h.b.a.d0.u.l;
import b.h.b.a.d0.x.b;
import b.h.b.a.d0.x.e.a;
import b.h.b.a.f0.f;
import b.h.b.a.h0.e;
import b.h.b.a.h0.g;
import b.h.b.a.h0.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import java.io.IOException;
/* loaded from: classes6.dex */
public class a implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final n f33086a;

    /* renamed from: b  reason: collision with root package name */
    public final int f33087b;

    /* renamed from: c  reason: collision with root package name */
    public final f f33088c;

    /* renamed from: d  reason: collision with root package name */
    public final b.h.b.a.d0.u.d[] f33089d;

    /* renamed from: e  reason: collision with root package name */
    public final e f33090e;

    /* renamed from: f  reason: collision with root package name */
    public b.h.b.a.d0.x.e.a f33091f;

    /* renamed from: g  reason: collision with root package name */
    public int f33092g;

    /* renamed from: h  reason: collision with root package name */
    public IOException f33093h;

    /* renamed from: b.h.b.a.d0.x.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1525a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final e.a f33094a;

        public C1525a(e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33094a = aVar;
        }

        @Override // b.h.b.a.d0.x.b.a
        public b a(n nVar, b.h.b.a.d0.x.e.a aVar, int i2, f fVar, k[] kVarArr) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{nVar, aVar, Integer.valueOf(i2), fVar, kVarArr})) == null) ? new a(nVar, aVar, i2, fVar, this.f33094a.a(), kVarArr) : (b) invokeCommon.objValue;
        }
    }

    public a(n nVar, b.h.b.a.d0.x.e.a aVar, int i2, f fVar, e eVar, k[] kVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {nVar, aVar, Integer.valueOf(i2), fVar, eVar, kVarArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33086a = nVar;
        this.f33091f = aVar;
        this.f33087b = i2;
        this.f33088c = fVar;
        this.f33090e = eVar;
        a.b bVar = aVar.f33108c[i2];
        this.f33089d = new b.h.b.a.d0.u.d[fVar.length()];
        int i5 = 0;
        while (i5 < this.f33089d.length) {
            int b2 = fVar.b(i5);
            Format format = bVar.f33115c[b2];
            int i6 = i5;
            this.f33089d[i6] = new b.h.b.a.d0.u.d(new b.h.b.a.a0.q.e(3, null, new j(b2, bVar.f33113a, bVar.f33114b, -9223372036854775807L, aVar.f33109d, format, 0, kVarArr, bVar.f33113a == 2 ? 4 : 0, null, null), null), bVar.f33113a, format);
            i5 = i6 + 1;
        }
    }

    public static l g(Format format, e eVar, Uri uri, String str, int i2, long j, long j2, int i3, Object obj, b.h.b.a.d0.u.d dVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{format, eVar, uri, str, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i3), obj, dVar})) == null) ? new i(eVar, new g(uri, 0L, -1L, str), format, i3, obj, j, j2, i2, 1, j, dVar) : (l) invokeCommon.objValue;
    }

    @Override // b.h.b.a.d0.u.g
    public void a() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            IOException iOException = this.f33093h;
            if (iOException == null) {
                this.f33086a.a();
                return;
            }
            throw iOException;
        }
    }

    @Override // b.h.b.a.d0.x.b
    public void b(b.h.b.a.d0.x.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            a.b[] bVarArr = this.f33091f.f33108c;
            int i2 = this.f33087b;
            a.b bVar = bVarArr[i2];
            int i3 = bVar.f33116d;
            a.b bVar2 = aVar.f33108c[i2];
            if (i3 != 0 && bVar2.f33116d != 0) {
                int i4 = i3 - 1;
                long d2 = bVar.d(i4) + bVar.b(i4);
                long d3 = bVar2.d(0);
                if (d2 <= d3) {
                    this.f33092g += i3;
                } else {
                    this.f33092g += bVar.c(d3);
                }
            } else {
                this.f33092g += i3;
            }
            this.f33091f = aVar;
        }
    }

    @Override // b.h.b.a.d0.u.g
    public void c(b.h.b.a.d0.u.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
        }
    }

    @Override // b.h.b.a.d0.u.g
    public boolean d(b.h.b.a.d0.u.c cVar, boolean z, Exception exc) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{cVar, Boolean.valueOf(z), exc})) == null) {
            if (z) {
                f fVar = this.f33088c;
                if (h.a(fVar, fVar.k(cVar.f32866c), exc)) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // b.h.b.a.d0.u.g
    public final void f(l lVar, long j, long j2, b.h.b.a.d0.u.e eVar) {
        int e2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{lVar, Long.valueOf(j), Long.valueOf(j2), eVar}) == null) && this.f33093h == null) {
            b.h.b.a.d0.x.e.a aVar = this.f33091f;
            a.b bVar = aVar.f33108c[this.f33087b];
            if (bVar.f33116d == 0) {
                eVar.f32883b = !aVar.f33106a;
                return;
            }
            if (lVar == null) {
                e2 = bVar.c(j2);
            } else {
                e2 = lVar.e() - this.f33092g;
                if (e2 < 0) {
                    this.f33093h = new BehindLiveWindowException();
                    return;
                }
            }
            int i2 = e2;
            if (i2 >= bVar.f33116d) {
                eVar.f32883b = !this.f33091f.f33106a;
                return;
            }
            this.f33088c.i(j, j2 - j, h(j));
            long d2 = bVar.d(i2);
            long b2 = d2 + bVar.b(i2);
            int i3 = i2 + this.f33092g;
            int a2 = this.f33088c.a();
            eVar.f32882a = g(this.f33088c.f(), this.f33090e, bVar.a(this.f33088c.b(a2), i2), null, i3, d2, b2, this.f33088c.l(), this.f33088c.j(), this.f33089d[a2]);
        }
    }

    public final long h(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
            b.h.b.a.d0.x.e.a aVar = this.f33091f;
            if (aVar.f33106a) {
                a.b bVar = aVar.f33108c[this.f33087b];
                int i2 = bVar.f33116d - 1;
                return (bVar.d(i2) + bVar.b(i2)) - j;
            }
            return -9223372036854775807L;
        }
        return invokeJ.longValue;
    }
}
