package b.i.b.a.d0.x;

import android.net.Uri;
import b.i.b.a.a0.q.j;
import b.i.b.a.a0.q.k;
import b.i.b.a.d0.u.h;
import b.i.b.a.d0.u.i;
import b.i.b.a.d0.u.l;
import b.i.b.a.d0.x.b;
import b.i.b.a.d0.x.e.a;
import b.i.b.a.f0.f;
import b.i.b.a.h0.e;
import b.i.b.a.h0.g;
import b.i.b.a.h0.n;
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
    public final n f32228a;

    /* renamed from: b  reason: collision with root package name */
    public final int f32229b;

    /* renamed from: c  reason: collision with root package name */
    public final f f32230c;

    /* renamed from: d  reason: collision with root package name */
    public final b.i.b.a.d0.u.d[] f32231d;

    /* renamed from: e  reason: collision with root package name */
    public final e f32232e;

    /* renamed from: f  reason: collision with root package name */
    public b.i.b.a.d0.x.e.a f32233f;

    /* renamed from: g  reason: collision with root package name */
    public int f32234g;

    /* renamed from: h  reason: collision with root package name */
    public IOException f32235h;

    /* renamed from: b.i.b.a.d0.x.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1483a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final e.a f32236a;

        public C1483a(e.a aVar) {
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
            this.f32236a = aVar;
        }

        @Override // b.i.b.a.d0.x.b.a
        public b a(n nVar, b.i.b.a.d0.x.e.a aVar, int i2, f fVar, k[] kVarArr) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{nVar, aVar, Integer.valueOf(i2), fVar, kVarArr})) == null) ? new a(nVar, aVar, i2, fVar, this.f32236a.a(), kVarArr) : (b) invokeCommon.objValue;
        }
    }

    public a(n nVar, b.i.b.a.d0.x.e.a aVar, int i2, f fVar, e eVar, k[] kVarArr) {
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
        this.f32228a = nVar;
        this.f32233f = aVar;
        this.f32229b = i2;
        this.f32230c = fVar;
        this.f32232e = eVar;
        a.b bVar = aVar.f32250c[i2];
        this.f32231d = new b.i.b.a.d0.u.d[fVar.length()];
        int i5 = 0;
        while (i5 < this.f32231d.length) {
            int b2 = fVar.b(i5);
            Format format = bVar.f32257c[b2];
            int i6 = i5;
            this.f32231d[i6] = new b.i.b.a.d0.u.d(new b.i.b.a.a0.q.e(3, null, new j(b2, bVar.f32255a, bVar.f32256b, -9223372036854775807L, aVar.f32251d, format, 0, kVarArr, bVar.f32255a == 2 ? 4 : 0, null, null), null), bVar.f32255a, format);
            i5 = i6 + 1;
        }
    }

    public static l g(Format format, e eVar, Uri uri, String str, int i2, long j, long j2, int i3, Object obj, b.i.b.a.d0.u.d dVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{format, eVar, uri, str, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i3), obj, dVar})) == null) ? new i(eVar, new g(uri, 0L, -1L, str), format, i3, obj, j, j2, i2, 1, j, dVar) : (l) invokeCommon.objValue;
    }

    @Override // b.i.b.a.d0.u.g
    public void a() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            IOException iOException = this.f32235h;
            if (iOException == null) {
                this.f32228a.a();
                return;
            }
            throw iOException;
        }
    }

    @Override // b.i.b.a.d0.x.b
    public void b(b.i.b.a.d0.x.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            a.b[] bVarArr = this.f32233f.f32250c;
            int i2 = this.f32229b;
            a.b bVar = bVarArr[i2];
            int i3 = bVar.f32258d;
            a.b bVar2 = aVar.f32250c[i2];
            if (i3 != 0 && bVar2.f32258d != 0) {
                int i4 = i3 - 1;
                long d2 = bVar.d(i4) + bVar.b(i4);
                long d3 = bVar2.d(0);
                if (d2 <= d3) {
                    this.f32234g += i3;
                } else {
                    this.f32234g += bVar.c(d3);
                }
            } else {
                this.f32234g += i3;
            }
            this.f32233f = aVar;
        }
    }

    @Override // b.i.b.a.d0.u.g
    public void c(b.i.b.a.d0.u.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
        }
    }

    @Override // b.i.b.a.d0.u.g
    public boolean d(b.i.b.a.d0.u.c cVar, boolean z, Exception exc) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{cVar, Boolean.valueOf(z), exc})) == null) {
            if (z) {
                f fVar = this.f32230c;
                if (h.a(fVar, fVar.k(cVar.f32008c), exc)) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // b.i.b.a.d0.u.g
    public final void f(l lVar, long j, long j2, b.i.b.a.d0.u.e eVar) {
        int e2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{lVar, Long.valueOf(j), Long.valueOf(j2), eVar}) == null) && this.f32235h == null) {
            b.i.b.a.d0.x.e.a aVar = this.f32233f;
            a.b bVar = aVar.f32250c[this.f32229b];
            if (bVar.f32258d == 0) {
                eVar.f32025b = !aVar.f32248a;
                return;
            }
            if (lVar == null) {
                e2 = bVar.c(j2);
            } else {
                e2 = lVar.e() - this.f32234g;
                if (e2 < 0) {
                    this.f32235h = new BehindLiveWindowException();
                    return;
                }
            }
            int i2 = e2;
            if (i2 >= bVar.f32258d) {
                eVar.f32025b = !this.f32233f.f32248a;
                return;
            }
            this.f32230c.i(j, j2 - j, h(j));
            long d2 = bVar.d(i2);
            long b2 = d2 + bVar.b(i2);
            int i3 = i2 + this.f32234g;
            int a2 = this.f32230c.a();
            eVar.f32024a = g(this.f32230c.f(), this.f32232e, bVar.a(this.f32230c.b(a2), i2), null, i3, d2, b2, this.f32230c.l(), this.f32230c.j(), this.f32231d[a2]);
        }
    }

    public final long h(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
            b.i.b.a.d0.x.e.a aVar = this.f32233f;
            if (aVar.f32248a) {
                a.b bVar = aVar.f32250c[this.f32229b];
                int i2 = bVar.f32258d - 1;
                return (bVar.d(i2) + bVar.b(i2)) - j;
            }
            return -9223372036854775807L;
        }
        return invokeJ.longValue;
    }
}
