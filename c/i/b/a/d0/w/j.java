package c.i.b.a.d0.w;

import android.net.Uri;
import android.os.Handler;
import c.i.b.a.d0.b;
import c.i.b.a.d0.l;
import c.i.b.a.d0.r;
import c.i.b.a.d0.w.o.b;
import c.i.b.a.h0.e;
import c.i.b.a.h0.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import java.io.IOException;
import java.util.List;
/* loaded from: classes7.dex */
public final class j implements c.i.b.a.d0.l, HlsPlaylistTracker.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final f f29791e;

    /* renamed from: f  reason: collision with root package name */
    public final Uri f29792f;

    /* renamed from: g  reason: collision with root package name */
    public final e f29793g;

    /* renamed from: h  reason: collision with root package name */
    public final int f29794h;

    /* renamed from: i  reason: collision with root package name */
    public final b.a f29795i;

    /* renamed from: j  reason: collision with root package name */
    public final o.a<c.i.b.a.d0.w.o.c> f29796j;

    /* renamed from: k  reason: collision with root package name */
    public HlsPlaylistTracker f29797k;
    public l.a l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2077398701, "Lc/i/b/a/d0/w/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2077398701, "Lc/i/b/a/d0/w/j;");
                return;
            }
        }
        c.i.b.a.k.a("goog.exo.hls");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(Uri uri, e.a aVar, Handler handler, c.i.b.a.d0.b bVar) {
        this(uri, aVar, 3, handler, bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, aVar, handler, bVar};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Uri) objArr2[0], (e.a) objArr2[1], ((Integer) objArr2[2]).intValue(), (Handler) objArr2[3], (c.i.b.a.d0.b) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    @Override // c.i.b.a.d0.l
    public void a(c.i.b.a.g gVar, boolean z, l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{gVar, Boolean.valueOf(z), aVar}) == null) {
            c.i.b.a.i0.a.f(this.f29797k == null);
            HlsPlaylistTracker hlsPlaylistTracker = new HlsPlaylistTracker(this.f29792f, this.f29793g, this.f29795i, this.f29794h, this, this.f29796j);
            this.f29797k = hlsPlaylistTracker;
            this.l = aVar;
            hlsPlaylistTracker.K();
        }
    }

    @Override // c.i.b.a.d0.l
    public void b() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f29797k.B();
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.d
    public void c(c.i.b.a.d0.w.o.b bVar) {
        r rVar;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            long j3 = bVar.m ? 0L : -9223372036854775807L;
            long b2 = bVar.m ? c.i.b.a.b.b(bVar.f29823e) : -9223372036854775807L;
            long j4 = bVar.f29822d;
            if (this.f29797k.w()) {
                long j5 = bVar.l ? bVar.f29823e + bVar.q : -9223372036854775807L;
                List<b.a> list = bVar.p;
                if (j4 == -9223372036854775807L) {
                    j2 = list.isEmpty() ? 0L : list.get(Math.max(0, list.size() - 3)).f29833h;
                } else {
                    j2 = j4;
                }
                rVar = new r(j3, b2, j5, bVar.q, bVar.f29823e, j2, true, !bVar.l);
            } else {
                long j6 = j4 == -9223372036854775807L ? 0L : j4;
                long j7 = bVar.f29823e;
                long j8 = bVar.q;
                rVar = new r(j3, b2, j7 + j8, j8, j7, j6, true, false);
            }
            this.l.c(this, rVar, new g(this.f29797k.u(), bVar));
        }
    }

    @Override // c.i.b.a.d0.l
    public c.i.b.a.d0.k d(l.b bVar, c.i.b.a.h0.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, bVar, bVar2)) == null) {
            c.i.b.a.i0.a.a(bVar.a == 0);
            return new i(this.f29791e, this.f29797k, this.f29793g, this.f29794h, this.f29795i, bVar2);
        }
        return (c.i.b.a.d0.k) invokeLL.objValue;
    }

    @Override // c.i.b.a.d0.l
    public void e(c.i.b.a.d0.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, kVar) == null) {
            ((i) kVar).t();
        }
    }

    @Override // c.i.b.a.d0.l
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            HlsPlaylistTracker hlsPlaylistTracker = this.f29797k;
            if (hlsPlaylistTracker != null) {
                hlsPlaylistTracker.I();
                this.f29797k = null;
            }
            this.l = null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(Uri uri, e.a aVar, int i2, Handler handler, c.i.b.a.d0.b bVar) {
        this(uri, new b(aVar), f.a, i2, handler, bVar, new c.i.b.a.d0.w.o.d());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, aVar, Integer.valueOf(i2), handler, bVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Uri) objArr2[0], (e) objArr2[1], (f) objArr2[2], ((Integer) objArr2[3]).intValue(), (Handler) objArr2[4], (c.i.b.a.d0.b) objArr2[5], (o.a) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public j(Uri uri, e eVar, f fVar, int i2, Handler handler, c.i.b.a.d0.b bVar, o.a<c.i.b.a.d0.w.o.c> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, eVar, fVar, Integer.valueOf(i2), handler, bVar, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f29792f = uri;
        this.f29793g = eVar;
        this.f29791e = fVar;
        this.f29794h = i2;
        this.f29796j = aVar;
        this.f29795i = new b.a(handler, bVar);
    }
}
