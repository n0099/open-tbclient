package b.h.b.a.d0.w;

import android.net.Uri;
import android.os.Handler;
import b.h.b.a.d0.b;
import b.h.b.a.d0.l;
import b.h.b.a.d0.r;
import b.h.b.a.d0.w.o.b;
import b.h.b.a.h0.e;
import b.h.b.a.h0.o;
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
/* loaded from: classes6.dex */
public final class j implements b.h.b.a.d0.l, HlsPlaylistTracker.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final f f33031e;

    /* renamed from: f  reason: collision with root package name */
    public final Uri f33032f;

    /* renamed from: g  reason: collision with root package name */
    public final e f33033g;

    /* renamed from: h  reason: collision with root package name */
    public final int f33034h;

    /* renamed from: i  reason: collision with root package name */
    public final b.a f33035i;
    public final o.a<b.h.b.a.d0.w.o.c> j;
    public HlsPlaylistTracker k;
    public l.a l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1003419793, "Lb/h/b/a/d0/w/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1003419793, "Lb/h/b/a/d0/w/j;");
                return;
            }
        }
        b.h.b.a.k.a("goog.exo.hls");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(Uri uri, e.a aVar, Handler handler, b.h.b.a.d0.b bVar) {
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
                this((Uri) objArr2[0], (e.a) objArr2[1], ((Integer) objArr2[2]).intValue(), (Handler) objArr2[3], (b.h.b.a.d0.b) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    @Override // b.h.b.a.d0.l
    public void a(b.h.b.a.g gVar, boolean z, l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{gVar, Boolean.valueOf(z), aVar}) == null) {
            b.h.b.a.i0.a.f(this.k == null);
            HlsPlaylistTracker hlsPlaylistTracker = new HlsPlaylistTracker(this.f33032f, this.f33033g, this.f33035i, this.f33034h, this, this.j);
            this.k = hlsPlaylistTracker;
            this.l = aVar;
            hlsPlaylistTracker.K();
        }
    }

    @Override // b.h.b.a.d0.l
    public void b() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.k.B();
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.d
    public void c(b.h.b.a.d0.w.o.b bVar) {
        r rVar;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            long j2 = bVar.m ? 0L : -9223372036854775807L;
            long b2 = bVar.m ? b.h.b.a.b.b(bVar.f33062e) : -9223372036854775807L;
            long j3 = bVar.f33061d;
            if (this.k.w()) {
                long j4 = bVar.l ? bVar.f33062e + bVar.q : -9223372036854775807L;
                List<b.a> list = bVar.p;
                if (j3 == -9223372036854775807L) {
                    j = list.isEmpty() ? 0L : list.get(Math.max(0, list.size() - 3)).f33070h;
                } else {
                    j = j3;
                }
                rVar = new r(j2, b2, j4, bVar.q, bVar.f33062e, j, true, !bVar.l);
            } else {
                long j5 = j3 == -9223372036854775807L ? 0L : j3;
                long j6 = bVar.f33062e;
                long j7 = bVar.q;
                rVar = new r(j2, b2, j6 + j7, j7, j6, j5, true, false);
            }
            this.l.c(this, rVar, new g(this.k.u(), bVar));
        }
    }

    @Override // b.h.b.a.d0.l
    public b.h.b.a.d0.k d(l.b bVar, b.h.b.a.h0.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, bVar, bVar2)) == null) {
            b.h.b.a.i0.a.a(bVar.f32816a == 0);
            return new i(this.f33031e, this.k, this.f33033g, this.f33034h, this.f33035i, bVar2);
        }
        return (b.h.b.a.d0.k) invokeLL.objValue;
    }

    @Override // b.h.b.a.d0.l
    public void e(b.h.b.a.d0.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, kVar) == null) {
            ((i) kVar).t();
        }
    }

    @Override // b.h.b.a.d0.l
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            HlsPlaylistTracker hlsPlaylistTracker = this.k;
            if (hlsPlaylistTracker != null) {
                hlsPlaylistTracker.I();
                this.k = null;
            }
            this.l = null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(Uri uri, e.a aVar, int i2, Handler handler, b.h.b.a.d0.b bVar) {
        this(uri, new b(aVar), f.f33025a, i2, handler, bVar, new b.h.b.a.d0.w.o.d());
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
                this((Uri) objArr2[0], (e) objArr2[1], (f) objArr2[2], ((Integer) objArr2[3]).intValue(), (Handler) objArr2[4], (b.h.b.a.d0.b) objArr2[5], (o.a) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public j(Uri uri, e eVar, f fVar, int i2, Handler handler, b.h.b.a.d0.b bVar, o.a<b.h.b.a.d0.w.o.c> aVar) {
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
        this.f33032f = uri;
        this.f33033g = eVar;
        this.f33031e = fVar;
        this.f33034h = i2;
        this.j = aVar;
        this.f33035i = new b.a(handler, bVar);
    }
}
