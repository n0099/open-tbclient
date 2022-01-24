package c.i.b.a.d0.x;

import android.net.Uri;
import c.i.b.a.a0.q.j;
import c.i.b.a.a0.q.k;
import c.i.b.a.d0.u.h;
import c.i.b.a.d0.u.i;
import c.i.b.a.d0.u.l;
import c.i.b.a.d0.x.b;
import c.i.b.a.d0.x.e.a;
import c.i.b.a.f0.f;
import c.i.b.a.h0.e;
import c.i.b.a.h0.g;
import c.i.b.a.h0.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import java.io.IOException;
/* loaded from: classes9.dex */
public class a implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final n a;

    /* renamed from: b  reason: collision with root package name */
    public final int f29379b;

    /* renamed from: c  reason: collision with root package name */
    public final f f29380c;

    /* renamed from: d  reason: collision with root package name */
    public final c.i.b.a.d0.u.d[] f29381d;

    /* renamed from: e  reason: collision with root package name */
    public final e f29382e;

    /* renamed from: f  reason: collision with root package name */
    public c.i.b.a.d0.x.e.a f29383f;

    /* renamed from: g  reason: collision with root package name */
    public int f29384g;

    /* renamed from: h  reason: collision with root package name */
    public IOException f29385h;

    /* renamed from: c.i.b.a.d0.x.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C1661a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final e.a a;

        public C1661a(e.a aVar) {
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
            this.a = aVar;
        }

        @Override // c.i.b.a.d0.x.b.a
        public b a(n nVar, c.i.b.a.d0.x.e.a aVar, int i2, f fVar, k[] kVarArr) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{nVar, aVar, Integer.valueOf(i2), fVar, kVarArr})) == null) ? new a(nVar, aVar, i2, fVar, this.a.a(), kVarArr) : (b) invokeCommon.objValue;
        }
    }

    public a(n nVar, c.i.b.a.d0.x.e.a aVar, int i2, f fVar, e eVar, k[] kVarArr) {
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
        this.a = nVar;
        this.f29383f = aVar;
        this.f29379b = i2;
        this.f29380c = fVar;
        this.f29382e = eVar;
        a.b bVar = aVar.f29400c[i2];
        this.f29381d = new c.i.b.a.d0.u.d[fVar.length()];
        int i5 = 0;
        while (i5 < this.f29381d.length) {
            int b2 = fVar.b(i5);
            Format format = bVar.f29405c[b2];
            int i6 = i5;
            this.f29381d[i6] = new c.i.b.a.d0.u.d(new c.i.b.a.a0.q.e(3, null, new j(b2, bVar.a, bVar.f29404b, -9223372036854775807L, aVar.f29401d, format, 0, kVarArr, bVar.a == 2 ? 4 : 0, null, null), null), bVar.a, format);
            i5 = i6 + 1;
        }
    }

    public static l g(Format format, e eVar, Uri uri, String str, int i2, long j2, long j3, int i3, Object obj, c.i.b.a.d0.u.d dVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{format, eVar, uri, str, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3), obj, dVar})) == null) ? new i(eVar, new g(uri, 0L, -1L, str), format, i3, obj, j2, j3, i2, 1, j2, dVar) : (l) invokeCommon.objValue;
    }

    @Override // c.i.b.a.d0.u.g
    public void a() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            IOException iOException = this.f29385h;
            if (iOException == null) {
                this.a.a();
                return;
            }
            throw iOException;
        }
    }

    @Override // c.i.b.a.d0.x.b
    public void b(c.i.b.a.d0.x.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            a.b[] bVarArr = this.f29383f.f29400c;
            int i2 = this.f29379b;
            a.b bVar = bVarArr[i2];
            int i3 = bVar.f29406d;
            a.b bVar2 = aVar.f29400c[i2];
            if (i3 != 0 && bVar2.f29406d != 0) {
                int i4 = i3 - 1;
                long d2 = bVar.d(i4) + bVar.b(i4);
                long d3 = bVar2.d(0);
                if (d2 <= d3) {
                    this.f29384g += i3;
                } else {
                    this.f29384g += bVar.c(d3);
                }
            } else {
                this.f29384g += i3;
            }
            this.f29383f = aVar;
        }
    }

    @Override // c.i.b.a.d0.u.g
    public void c(c.i.b.a.d0.u.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
        }
    }

    @Override // c.i.b.a.d0.u.g
    public boolean d(c.i.b.a.d0.u.c cVar, boolean z, Exception exc) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{cVar, Boolean.valueOf(z), exc})) == null) {
            if (z) {
                f fVar = this.f29380c;
                if (h.a(fVar, fVar.k(cVar.f29176c), exc)) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // c.i.b.a.d0.u.g
    public final void f(l lVar, long j2, long j3, c.i.b.a.d0.u.e eVar) {
        int d2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{lVar, Long.valueOf(j2), Long.valueOf(j3), eVar}) == null) && this.f29385h == null) {
            c.i.b.a.d0.x.e.a aVar = this.f29383f;
            a.b bVar = aVar.f29400c[this.f29379b];
            if (bVar.f29406d == 0) {
                eVar.f29192b = !aVar.a;
                return;
            }
            if (lVar == null) {
                d2 = bVar.c(j3);
            } else {
                d2 = lVar.d() - this.f29384g;
                if (d2 < 0) {
                    this.f29385h = new BehindLiveWindowException();
                    return;
                }
            }
            int i2 = d2;
            if (i2 >= bVar.f29406d) {
                eVar.f29192b = !this.f29383f.a;
                return;
            }
            this.f29380c.i(j2, j3 - j2, h(j2));
            long d3 = bVar.d(i2);
            long b2 = d3 + bVar.b(i2);
            int i3 = i2 + this.f29384g;
            int a = this.f29380c.a();
            eVar.a = g(this.f29380c.f(), this.f29382e, bVar.a(this.f29380c.b(a), i2), null, i3, d3, b2, this.f29380c.l(), this.f29380c.j(), this.f29381d[a]);
        }
    }

    public final long h(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
            c.i.b.a.d0.x.e.a aVar = this.f29383f;
            if (aVar.a) {
                a.b bVar = aVar.f29400c[this.f29379b];
                int i2 = bVar.f29406d - 1;
                return (bVar.d(i2) + bVar.b(i2)) - j2;
            }
            return -9223372036854775807L;
        }
        return invokeJ.longValue;
    }
}
