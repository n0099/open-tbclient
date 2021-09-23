package c.i.b.a;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.core.view.InputDeviceCompat;
import c.i.b.a.g;
import c.i.b.a.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
@TargetApi(16)
/* loaded from: classes4.dex */
public class v implements g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final r[] f33971a;

    /* renamed from: b  reason: collision with root package name */
    public final g f33972b;

    /* renamed from: c  reason: collision with root package name */
    public final b f33973c;

    /* renamed from: d  reason: collision with root package name */
    public final CopyOnWriteArraySet<c> f33974d;

    /* renamed from: e  reason: collision with root package name */
    public final CopyOnWriteArraySet<c.i.b.a.e0.j> f33975e;

    /* renamed from: f  reason: collision with root package name */
    public final CopyOnWriteArraySet<c.i.b.a.c0.d> f33976f;

    /* renamed from: g  reason: collision with root package name */
    public final int f33977g;

    /* renamed from: h  reason: collision with root package name */
    public final int f33978h;

    /* renamed from: i  reason: collision with root package name */
    public Format f33979i;

    /* renamed from: j  reason: collision with root package name */
    public Format f33980j;
    public Surface k;
    public boolean l;
    public SurfaceHolder m;
    public TextureView n;
    public c.i.b.a.x.d o;
    public c.i.b.a.j0.e p;
    public c.i.b.a.y.d q;
    public c.i.b.a.y.d r;
    public int s;
    public float t;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public final class b implements c.i.b.a.j0.e, c.i.b.a.x.d, c.i.b.a.e0.j, c.i.b.a.c0.d, SurfaceHolder.Callback, TextureView.SurfaceTextureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v f33981e;

        public b(v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33981e = vVar;
        }

        @Override // c.i.b.a.x.d
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f33981e.s = i2;
                if (this.f33981e.o != null) {
                    this.f33981e.o.a(i2);
                }
            }
        }

        @Override // c.i.b.a.x.d
        public void b(String str, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3)}) == null) || this.f33981e.o == null) {
                return;
            }
            this.f33981e.o.b(str, j2, j3);
        }

        @Override // c.i.b.a.j0.e
        public void c(int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f33981e.p == null) {
                return;
            }
            this.f33981e.p.c(i2, j2);
        }

        @Override // c.i.b.a.x.d
        public void d(c.i.b.a.y.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
                this.f33981e.r = dVar;
                if (this.f33981e.o != null) {
                    this.f33981e.o.d(dVar);
                }
            }
        }

        @Override // c.i.b.a.j0.e
        public void e(String str, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3)}) == null) || this.f33981e.p == null) {
                return;
            }
            this.f33981e.p.e(str, j2, j3);
        }

        @Override // c.i.b.a.j0.e
        public void f(Surface surface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, surface) == null) {
                if (this.f33981e.k == surface) {
                    Iterator it = this.f33981e.f33974d.iterator();
                    while (it.hasNext()) {
                        ((c) it.next()).h();
                    }
                }
                if (this.f33981e.p != null) {
                    this.f33981e.p.f(surface);
                }
            }
        }

        @Override // c.i.b.a.c0.d
        public void g(Metadata metadata) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, metadata) == null) {
                Iterator it = this.f33981e.f33976f.iterator();
                while (it.hasNext()) {
                    ((c.i.b.a.c0.d) it.next()).g(metadata);
                }
            }
        }

        @Override // c.i.b.a.j0.e
        public void h(Format format) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, format) == null) {
                this.f33981e.f33979i = format;
                if (this.f33981e.p != null) {
                    this.f33981e.p.h(format);
                }
            }
        }

        @Override // c.i.b.a.x.d
        public void i(int i2, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3)}) == null) || this.f33981e.o == null) {
                return;
            }
            this.f33981e.o.i(i2, j2, j3);
        }

        @Override // c.i.b.a.j0.e
        public void j(c.i.b.a.y.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, dVar) == null) {
                if (this.f33981e.p != null) {
                    this.f33981e.p.j(dVar);
                }
                this.f33981e.f33979i = null;
                this.f33981e.q = null;
            }
        }

        @Override // c.i.b.a.x.d
        public void k(c.i.b.a.y.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
                if (this.f33981e.o != null) {
                    this.f33981e.o.k(dVar);
                }
                this.f33981e.f33980j = null;
                this.f33981e.r = null;
                this.f33981e.s = 0;
            }
        }

        @Override // c.i.b.a.j0.e
        public void l(c.i.b.a.y.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
                this.f33981e.q = dVar;
                if (this.f33981e.p != null) {
                    this.f33981e.p.l(dVar);
                }
            }
        }

        @Override // c.i.b.a.x.d
        public void m(Format format) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, format) == null) {
                this.f33981e.f33980j = format;
                if (this.f33981e.o != null) {
                    this.f33981e.o.m(format);
                }
            }
        }

        @Override // c.i.b.a.e0.j
        public void onCues(List<c.i.b.a.e0.b> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
                Iterator it = this.f33981e.f33975e.iterator();
                while (it.hasNext()) {
                    ((c.i.b.a.e0.j) it.next()).onCues(list);
                }
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048590, this, surfaceTexture, i2, i3) == null) {
                this.f33981e.U(new Surface(surfaceTexture), true);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, surfaceTexture)) == null) {
                this.f33981e.U(null, true);
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048592, this, surfaceTexture, i2, i3) == null) {
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, surfaceTexture) == null) {
            }
        }

        @Override // c.i.b.a.j0.e
        public void onVideoSizeChanged(int i2, int i3, int i4, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2)}) == null) {
                Iterator it = this.f33981e.f33974d.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).onVideoSizeChanged(i2, i3, i4, f2);
                }
                if (this.f33981e.p != null) {
                    this.f33981e.p.onVideoSizeChanged(i2, i3, i4, f2);
                }
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048595, this, surfaceHolder, i2, i3, i4) == null) {
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, surfaceHolder) == null) {
                this.f33981e.U(surfaceHolder.getSurface(), false);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, surfaceHolder) == null) {
                this.f33981e.U(null, false);
            }
        }

        public /* synthetic */ b(v vVar, a aVar) {
            this(vVar);
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void h();

        void onVideoSizeChanged(int i2, int i3, int i4, float f2);
    }

    public v(u uVar, c.i.b.a.f0.h hVar, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uVar, hVar, mVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33973c = new b(this, null);
        this.f33974d = new CopyOnWriteArraySet<>();
        this.f33975e = new CopyOnWriteArraySet<>();
        this.f33976f = new CopyOnWriteArraySet<>();
        Handler handler = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        b bVar = this.f33973c;
        r[] a2 = uVar.a(handler, bVar, bVar, bVar, bVar);
        this.f33971a = a2;
        int i4 = 0;
        int i5 = 0;
        for (r rVar : a2) {
            int e2 = rVar.e();
            if (e2 == 1) {
                i5++;
            } else if (e2 == 2) {
                i4++;
            }
        }
        this.f33977g = i4;
        this.f33978h = i5;
        this.t = 1.0f;
        c.i.b.a.x.b bVar2 = c.i.b.a.x.b.f34014e;
        this.f33972b = N(this.f33971a, hVar, mVar);
    }

    public void I(c.i.b.a.e0.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            this.f33975e.add(jVar);
        }
    }

    public void J(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f33974d.add(cVar);
        }
    }

    public void K(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, surfaceHolder) == null) && surfaceHolder != null && surfaceHolder == this.m) {
            T(null);
        }
    }

    public void L(SurfaceView surfaceView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, surfaceView) == null) {
            K(surfaceView == null ? null : surfaceView.getHolder());
        }
    }

    public void M(TextureView textureView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, textureView) == null) && textureView != null && textureView == this.n) {
            W(null);
        }
    }

    public g N(r[] rVarArr, c.i.b.a.f0.h hVar, m mVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, rVarArr, hVar, mVar)) == null) ? new i(rVarArr, hVar, mVar) : (g) invokeLLL.objValue;
    }

    public float O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.t : invokeV.floatValue;
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            TextureView textureView = this.n;
            if (textureView != null) {
                if (textureView.getSurfaceTextureListener() == this.f33973c) {
                    this.n.setSurfaceTextureListener(null);
                }
                this.n = null;
            }
            SurfaceHolder surfaceHolder = this.m;
            if (surfaceHolder != null) {
                surfaceHolder.removeCallback(this.f33973c);
                this.m = null;
            }
        }
    }

    public void Q(c.i.b.a.e0.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jVar) == null) {
            this.f33975e.remove(jVar);
        }
    }

    public void R(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.f33974d.remove(cVar);
        }
    }

    public void S(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, surface) == null) {
            P();
            U(surface, false);
        }
    }

    public void T(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, surfaceHolder) == null) {
            P();
            this.m = surfaceHolder;
            Surface surface = null;
            if (surfaceHolder == null) {
                U(null, false);
                return;
            }
            surfaceHolder.addCallback(this.f33973c);
            Surface surface2 = surfaceHolder.getSurface();
            if (surface2 != null && surface2.isValid()) {
                surface = surface2;
            }
            U(surface, false);
        }
    }

    public final void U(Surface surface, boolean z) {
        r[] rVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, surface, z) == null) {
            g.b[] bVarArr = new g.b[this.f33977g];
            int i2 = 0;
            for (r rVar : this.f33971a) {
                if (rVar.e() == 2) {
                    bVarArr[i2] = new g.b(rVar, 1, surface);
                    i2++;
                }
            }
            Surface surface2 = this.k;
            if (surface2 != null && surface2 != surface) {
                this.f33972b.a(bVarArr);
                if (this.l) {
                    this.k.release();
                }
            } else {
                this.f33972b.s(bVarArr);
            }
            this.k = surface;
            this.l = z;
        }
    }

    public void V(SurfaceView surfaceView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, surfaceView) == null) {
            T(surfaceView == null ? null : surfaceView.getHolder());
        }
    }

    public void W(TextureView textureView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, textureView) == null) {
            P();
            this.n = textureView;
            if (textureView == null) {
                U(null, true);
                return;
            }
            textureView.getSurfaceTextureListener();
            textureView.setSurfaceTextureListener(this.f33973c);
            SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
            U(surfaceTexture != null ? new Surface(surfaceTexture) : null, true);
        }
    }

    public void X(float f2) {
        r[] rVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048591, this, f2) == null) {
            this.t = f2;
            g.b[] bVarArr = new g.b[this.f33978h];
            int i2 = 0;
            for (r rVar : this.f33971a) {
                if (rVar.e() == 1) {
                    bVarArr[i2] = new g.b(rVar, 2, Float.valueOf(f2));
                    i2++;
                }
            }
            this.f33972b.s(bVarArr);
        }
    }

    @Override // c.i.b.a.g
    public void a(g.b... bVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bVarArr) == null) {
            this.f33972b.a(bVarArr);
        }
    }

    @Override // c.i.b.a.g
    public void b(c.i.b.a.d0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, lVar) == null) {
            this.f33972b.b(lVar);
        }
    }

    @Override // c.i.b.a.q
    public void c(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, pVar) == null) {
            this.f33972b.c(pVar);
        }
    }

    @Override // c.i.b.a.q
    public p d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f33972b.d() : (p) invokeV.objValue;
    }

    @Override // c.i.b.a.q
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f33972b.e() : invokeV.booleanValue;
    }

    @Override // c.i.b.a.q
    public void f(q.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bVar) == null) {
            this.f33972b.f(bVar);
        }
    }

    @Override // c.i.b.a.q
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f33972b.g() : invokeV.booleanValue;
    }

    @Override // c.i.b.a.q
    public long getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f33972b.getCurrentPosition() : invokeV.longValue;
    }

    @Override // c.i.b.a.q
    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f33972b.getDuration() : invokeV.longValue;
    }

    @Override // c.i.b.a.q
    public int getPlaybackState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f33972b.getPlaybackState() : invokeV.intValue;
    }

    @Override // c.i.b.a.q
    public int getRepeatMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f33972b.getRepeatMode() : invokeV.intValue;
    }

    @Override // c.i.b.a.q
    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.f33972b.h(z);
        }
    }

    @Override // c.i.b.a.q
    public void i(q.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bVar) == null) {
            this.f33972b.i(bVar);
        }
    }

    @Override // c.i.b.a.q
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f33972b.j() : invokeV.intValue;
    }

    @Override // c.i.b.a.q
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f33972b.k() : invokeV.intValue;
    }

    @Override // c.i.b.a.q
    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.f33972b.l(z);
        }
    }

    @Override // c.i.b.a.q
    public w m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f33972b.m() : (w) invokeV.objValue;
    }

    @Override // c.i.b.a.q
    public c.i.b.a.f0.g n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f33972b.n() : (c.i.b.a.f0.g) invokeV.objValue;
    }

    @Override // c.i.b.a.q
    public int o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i2)) == null) ? this.f33972b.o(i2) : invokeI.intValue;
    }

    @Override // c.i.b.a.q
    public void p(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            this.f33972b.p(i2, j2);
        }
    }

    @Override // c.i.b.a.q
    public long q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f33972b.q() : invokeV.longValue;
    }

    @Override // c.i.b.a.q
    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.f33972b.r() : invokeV.intValue;
    }

    @Override // c.i.b.a.q
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.f33972b.release();
            P();
            Surface surface = this.k;
            if (surface != null) {
                if (this.l) {
                    surface.release();
                }
                this.k = null;
            }
        }
    }

    @Override // c.i.b.a.g
    public void s(g.b... bVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, bVarArr) == null) {
            this.f33972b.s(bVarArr);
        }
    }

    @Override // c.i.b.a.q
    public void setRepeatMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            this.f33972b.setRepeatMode(i2);
        }
    }

    @Override // c.i.b.a.q
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.f33972b.stop();
        }
    }

    @Override // c.i.b.a.q
    public long t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.f33972b.t() : invokeV.longValue;
    }

    @Override // c.i.b.a.q
    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.f33972b.u() : invokeV.intValue;
    }

    @Override // c.i.b.a.q
    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.f33972b.v() : invokeV.booleanValue;
    }
}
