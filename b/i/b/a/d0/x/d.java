package b.i.b.a.d0.x;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import b.i.b.a.d0.b;
import b.i.b.a.d0.l;
import b.i.b.a.d0.r;
import b.i.b.a.d0.x.b;
import b.i.b.a.d0.x.e.a;
import b.i.b.a.g;
import b.i.b.a.h0.e;
import b.i.b.a.h0.n;
import b.i.b.a.h0.o;
import b.i.b.a.i0.v;
import b.i.b.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.exoplayer2.upstream.Loader;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public final class d implements l, Loader.a<o<b.i.b.a.d0.x.e.a>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Uri f32242e;

    /* renamed from: f  reason: collision with root package name */
    public final e.a f32243f;

    /* renamed from: g  reason: collision with root package name */
    public final b.a f32244g;

    /* renamed from: h  reason: collision with root package name */
    public final int f32245h;

    /* renamed from: i  reason: collision with root package name */
    public final long f32246i;
    public final b.a j;
    public final o.a<? extends b.i.b.a.d0.x.e.a> k;
    public final ArrayList<c> l;
    public l.a m;
    public e n;
    public Loader o;
    public n p;
    public long q;
    public b.i.b.a.d0.x.e.a r;
    public Handler s;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f32247e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32247e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f32247e.o();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(710046391, "Lb/i/b/a/d0/x/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(710046391, "Lb/i/b/a/d0/x/d;");
                return;
            }
        }
        k.a("goog.exo.smoothstreaming");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(Uri uri, e.a aVar, b.a aVar2, Handler handler, b.i.b.a.d0.b bVar) {
        this(uri, aVar, aVar2, 3, 30000L, handler, bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, aVar, aVar2, handler, bVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Uri) objArr2[0], (e.a) objArr2[1], (b.a) objArr2[2], ((Integer) objArr2[3]).intValue(), ((Long) objArr2[4]).longValue(), (Handler) objArr2[5], (b.i.b.a.d0.b) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    @Override // b.i.b.a.d0.l
    public void a(g gVar, boolean z, l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{gVar, Boolean.valueOf(z), aVar}) == null) {
            this.m = aVar;
            if (this.r != null) {
                this.p = new n.a();
                j();
                return;
            }
            this.n = this.f32243f.a();
            Loader loader = new Loader("Loader:Manifest");
            this.o = loader;
            this.p = loader;
            this.s = new Handler();
            o();
        }
    }

    @Override // b.i.b.a.d0.l
    public void b() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.p.a();
        }
    }

    @Override // b.i.b.a.d0.l
    public b.i.b.a.d0.k d(l.b bVar, b.i.b.a.h0.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bVar, bVar2)) == null) {
            b.i.b.a.i0.a.a(bVar.f31958a == 0);
            c cVar = new c(this.r, this.f32244g, this.f32245h, this.j, this.p, bVar2);
            this.l.add(cVar);
            return cVar;
        }
        return (b.i.b.a.d0.k) invokeLL.objValue;
    }

    @Override // b.i.b.a.d0.l
    public void e(b.i.b.a.d0.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, kVar) == null) {
            ((c) kVar).s();
            this.l.remove(kVar);
        }
    }

    @Override // b.i.b.a.d0.l
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.m = null;
            this.r = null;
            this.n = null;
            this.q = 0L;
            Loader loader = this.o;
            if (loader != null) {
                loader.i();
                this.o = null;
            }
            Handler handler = this.s;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.s = null;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: g */
    public void l(o<b.i.b.a.d0.x.e.a> oVar, long j, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            this.j.i(oVar.f32583a, oVar.f32584b, j, j2, oVar.c());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: h */
    public void m(o<b.i.b.a.d0.x.e.a> oVar, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.j.i(oVar.f32583a, oVar.f32584b, j, j2, oVar.c());
            this.r = oVar.d();
            this.q = j - j2;
            j();
            k();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: i */
    public int n(o<b.i.b.a.d0.x.e.a> oVar, long j, long j2, IOException iOException) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2), iOException})) == null) {
            boolean z = iOException instanceof ParserException;
            this.j.k(oVar.f32583a, oVar.f32584b, j, j2, oVar.c(), iOException, z);
            return z ? 3 : 0;
        }
        return invokeCommon.intValue;
    }

    public final void j() {
        a.b[] bVarArr;
        r rVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            for (int i2 = 0; i2 < this.l.size(); i2++) {
                this.l.get(i2).u(this.r);
            }
            long j = Long.MIN_VALUE;
            long j2 = Long.MAX_VALUE;
            for (a.b bVar : this.r.f32250c) {
                if (bVar.f32258d > 0) {
                    j2 = Math.min(j2, bVar.d(0));
                    j = Math.max(j, bVar.d(bVar.f32258d - 1) + bVar.b(bVar.f32258d - 1));
                }
            }
            if (j2 == Long.MAX_VALUE) {
                rVar = new r(this.r.f32248a ? -9223372036854775807L : 0L, 0L, 0L, 0L, true, this.r.f32248a);
            } else {
                b.i.b.a.d0.x.e.a aVar = this.r;
                if (aVar.f32248a) {
                    long j3 = aVar.f32252e;
                    if (j3 != -9223372036854775807L && j3 > 0) {
                        j2 = Math.max(j2, j - j3);
                    }
                    long j4 = j2;
                    long j5 = j - j4;
                    long a2 = j5 - b.i.b.a.b.a(this.f32246i);
                    if (a2 < 5000000) {
                        a2 = Math.min(5000000L, j5 / 2);
                    }
                    rVar = new r(-9223372036854775807L, j5, j4, a2, true, true);
                } else {
                    long j6 = aVar.f32251d;
                    long j7 = j6 != -9223372036854775807L ? j6 : j - j2;
                    rVar = new r(j2 + j7, j7, j2, 0L, true, false);
                }
            }
            this.m.c(this, rVar, this.r);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.r.f32248a) {
            this.s.postDelayed(new a(this), Math.max(0L, (this.q + 5000) - SystemClock.elapsedRealtime()));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            o oVar = new o(this.n, this.f32242e, 4, this.k);
            this.j.m(oVar.f32583a, oVar.f32584b, this.o.k(oVar, this, this.f32245h));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(Uri uri, e.a aVar, b.a aVar2, int i2, long j, Handler handler, b.i.b.a.d0.b bVar) {
        this(uri, aVar, new SsManifestParser(), aVar2, i2, j, handler, bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, aVar, aVar2, Integer.valueOf(i2), Long.valueOf(j), handler, bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Uri) objArr2[0], (e.a) objArr2[1], (o.a) objArr2[2], (b.a) objArr2[3], ((Integer) objArr2[4]).intValue(), ((Long) objArr2[5]).longValue(), (Handler) objArr2[6], (b.i.b.a.d0.b) objArr2[7]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(Uri uri, e.a aVar, o.a<? extends b.i.b.a.d0.x.e.a> aVar2, b.a aVar3, int i2, long j, Handler handler, b.i.b.a.d0.b bVar) {
        this(null, uri, aVar, aVar2, aVar3, i2, j, handler, bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {uri, aVar, aVar2, aVar3, Integer.valueOf(i2), Long.valueOf(j), handler, bVar};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((b.i.b.a.d0.x.e.a) objArr2[0], (Uri) objArr2[1], (e.a) objArr2[2], (o.a) objArr2[3], (b.a) objArr2[4], ((Integer) objArr2[5]).intValue(), ((Long) objArr2[6]).longValue(), (Handler) objArr2[7], (b.i.b.a.d0.b) objArr2[8]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public d(b.i.b.a.d0.x.e.a aVar, Uri uri, e.a aVar2, o.a<? extends b.i.b.a.d0.x.e.a> aVar3, b.a aVar4, int i2, long j, Handler handler, b.i.b.a.d0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, uri, aVar2, aVar3, aVar4, Integer.valueOf(i2), Long.valueOf(j), handler, bVar};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        b.i.b.a.i0.a.f(aVar == null || !aVar.f32248a);
        this.r = aVar;
        if (uri == null) {
            uri = null;
        } else if (!v.J(uri.getLastPathSegment()).matches("manifest(\\(.+\\))?")) {
            uri = Uri.withAppendedPath(uri, "Manifest");
        }
        this.f32242e = uri;
        this.f32243f = aVar2;
        this.k = aVar3;
        this.f32244g = aVar4;
        this.f32245h = i2;
        this.f32246i = j;
        this.j = new b.a(handler, bVar);
        this.l = new ArrayList<>();
    }
}
