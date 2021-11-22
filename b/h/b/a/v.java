package b.h.b.a;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.core.view.InputDeviceCompat;
import b.h.b.a.g;
import b.h.b.a.q;
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
/* loaded from: classes6.dex */
public class v implements g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final r[] f33625a;

    /* renamed from: b  reason: collision with root package name */
    public final g f33626b;

    /* renamed from: c  reason: collision with root package name */
    public final b f33627c;

    /* renamed from: d  reason: collision with root package name */
    public final CopyOnWriteArraySet<c> f33628d;

    /* renamed from: e  reason: collision with root package name */
    public final CopyOnWriteArraySet<b.h.b.a.e0.j> f33629e;

    /* renamed from: f  reason: collision with root package name */
    public final CopyOnWriteArraySet<b.h.b.a.c0.d> f33630f;

    /* renamed from: g  reason: collision with root package name */
    public final int f33631g;

    /* renamed from: h  reason: collision with root package name */
    public final int f33632h;

    /* renamed from: i  reason: collision with root package name */
    public Format f33633i;
    public Format j;
    public Surface k;
    public boolean l;
    public SurfaceHolder m;
    public TextureView n;
    public b.h.b.a.x.d o;
    public b.h.b.a.j0.e p;
    public b.h.b.a.y.d q;
    public b.h.b.a.y.d r;
    public int s;
    public float t;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public final class b implements b.h.b.a.j0.e, b.h.b.a.x.d, b.h.b.a.e0.j, b.h.b.a.c0.d, SurfaceHolder.Callback, TextureView.SurfaceTextureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v f33634e;

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
            this.f33634e = vVar;
        }

        @Override // b.h.b.a.x.d
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f33634e.s = i2;
                if (this.f33634e.o != null) {
                    this.f33634e.o.a(i2);
                }
            }
        }

        @Override // b.h.b.a.x.d
        public void b(String str, long j, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)}) == null) || this.f33634e.o == null) {
                return;
            }
            this.f33634e.o.b(str, j, j2);
        }

        @Override // b.h.b.a.j0.e
        public void c(int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f33634e.p == null) {
                return;
            }
            this.f33634e.p.c(i2, j);
        }

        @Override // b.h.b.a.x.d
        public void d(b.h.b.a.y.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
                this.f33634e.r = dVar;
                if (this.f33634e.o != null) {
                    this.f33634e.o.d(dVar);
                }
            }
        }

        @Override // b.h.b.a.j0.e
        public void e(String str, long j, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)}) == null) || this.f33634e.p == null) {
                return;
            }
            this.f33634e.p.e(str, j, j2);
        }

        @Override // b.h.b.a.j0.e
        public void f(Surface surface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, surface) == null) {
                if (this.f33634e.k == surface) {
                    Iterator it = this.f33634e.f33628d.iterator();
                    while (it.hasNext()) {
                        ((c) it.next()).h();
                    }
                }
                if (this.f33634e.p != null) {
                    this.f33634e.p.f(surface);
                }
            }
        }

        @Override // b.h.b.a.c0.d
        public void g(Metadata metadata) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, metadata) == null) {
                Iterator it = this.f33634e.f33630f.iterator();
                while (it.hasNext()) {
                    ((b.h.b.a.c0.d) it.next()).g(metadata);
                }
            }
        }

        @Override // b.h.b.a.j0.e
        public void h(Format format) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, format) == null) {
                this.f33634e.f33633i = format;
                if (this.f33634e.p != null) {
                    this.f33634e.p.h(format);
                }
            }
        }

        @Override // b.h.b.a.x.d
        public void i(int i2, long j, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)}) == null) || this.f33634e.o == null) {
                return;
            }
            this.f33634e.o.i(i2, j, j2);
        }

        @Override // b.h.b.a.j0.e
        public void j(b.h.b.a.y.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, dVar) == null) {
                if (this.f33634e.p != null) {
                    this.f33634e.p.j(dVar);
                }
                this.f33634e.f33633i = null;
                this.f33634e.q = null;
            }
        }

        @Override // b.h.b.a.x.d
        public void k(b.h.b.a.y.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
                if (this.f33634e.o != null) {
                    this.f33634e.o.k(dVar);
                }
                this.f33634e.j = null;
                this.f33634e.r = null;
                this.f33634e.s = 0;
            }
        }

        @Override // b.h.b.a.j0.e
        public void l(b.h.b.a.y.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
                this.f33634e.q = dVar;
                if (this.f33634e.p != null) {
                    this.f33634e.p.l(dVar);
                }
            }
        }

        @Override // b.h.b.a.x.d
        public void m(Format format) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, format) == null) {
                this.f33634e.j = format;
                if (this.f33634e.o != null) {
                    this.f33634e.o.m(format);
                }
            }
        }

        @Override // b.h.b.a.e0.j
        public void onCues(List<b.h.b.a.e0.b> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
                Iterator it = this.f33634e.f33629e.iterator();
                while (it.hasNext()) {
                    ((b.h.b.a.e0.j) it.next()).onCues(list);
                }
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048590, this, surfaceTexture, i2, i3) == null) {
                this.f33634e.U(new Surface(surfaceTexture), true);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, surfaceTexture)) == null) {
                this.f33634e.U(null, true);
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

        @Override // b.h.b.a.j0.e
        public void onVideoSizeChanged(int i2, int i3, int i4, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2)}) == null) {
                Iterator it = this.f33634e.f33628d.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).onVideoSizeChanged(i2, i3, i4, f2);
                }
                if (this.f33634e.p != null) {
                    this.f33634e.p.onVideoSizeChanged(i2, i3, i4, f2);
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
                this.f33634e.U(surfaceHolder.getSurface(), false);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, surfaceHolder) == null) {
                this.f33634e.U(null, false);
            }
        }

        public /* synthetic */ b(v vVar, a aVar) {
            this(vVar);
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void h();

        void onVideoSizeChanged(int i2, int i3, int i4, float f2);
    }

    public v(u uVar, b.h.b.a.f0.h hVar, m mVar) {
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
        this.f33627c = new b(this, null);
        this.f33628d = new CopyOnWriteArraySet<>();
        this.f33629e = new CopyOnWriteArraySet<>();
        this.f33630f = new CopyOnWriteArraySet<>();
        Handler handler = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        b bVar = this.f33627c;
        r[] a2 = uVar.a(handler, bVar, bVar, bVar, bVar);
        this.f33625a = a2;
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
        this.f33631g = i4;
        this.f33632h = i5;
        this.t = 1.0f;
        b.h.b.a.x.b bVar2 = b.h.b.a.x.b.f33665e;
        this.f33626b = N(this.f33625a, hVar, mVar);
    }

    public void I(b.h.b.a.e0.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            this.f33629e.add(jVar);
        }
    }

    public void J(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f33628d.add(cVar);
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

    public g N(r[] rVarArr, b.h.b.a.f0.h hVar, m mVar) {
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
                if (textureView.getSurfaceTextureListener() == this.f33627c) {
                    this.n.setSurfaceTextureListener(null);
                }
                this.n = null;
            }
            SurfaceHolder surfaceHolder = this.m;
            if (surfaceHolder != null) {
                surfaceHolder.removeCallback(this.f33627c);
                this.m = null;
            }
        }
    }

    public void Q(b.h.b.a.e0.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jVar) == null) {
            this.f33629e.remove(jVar);
        }
    }

    public void R(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.f33628d.remove(cVar);
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
            surfaceHolder.addCallback(this.f33627c);
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
            g.b[] bVarArr = new g.b[this.f33631g];
            int i2 = 0;
            for (r rVar : this.f33625a) {
                if (rVar.e() == 2) {
                    bVarArr[i2] = new g.b(rVar, 1, surface);
                    i2++;
                }
            }
            Surface surface2 = this.k;
            if (surface2 != null && surface2 != surface) {
                this.f33626b.a(bVarArr);
                if (this.l) {
                    this.k.release();
                }
            } else {
                this.f33626b.s(bVarArr);
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
            textureView.setSurfaceTextureListener(this.f33627c);
            SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
            U(surfaceTexture != null ? new Surface(surfaceTexture) : null, true);
        }
    }

    public void X(float f2) {
        r[] rVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048591, this, f2) == null) {
            this.t = f2;
            g.b[] bVarArr = new g.b[this.f33632h];
            int i2 = 0;
            for (r rVar : this.f33625a) {
                if (rVar.e() == 1) {
                    bVarArr[i2] = new g.b(rVar, 2, Float.valueOf(f2));
                    i2++;
                }
            }
            this.f33626b.s(bVarArr);
        }
    }

    @Override // b.h.b.a.g
    public void a(g.b... bVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bVarArr) == null) {
            this.f33626b.a(bVarArr);
        }
    }

    @Override // b.h.b.a.g
    public void b(b.h.b.a.d0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, lVar) == null) {
            this.f33626b.b(lVar);
        }
    }

    @Override // b.h.b.a.q
    public void c(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, pVar) == null) {
            this.f33626b.c(pVar);
        }
    }

    @Override // b.h.b.a.q
    public p d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f33626b.d() : (p) invokeV.objValue;
    }

    @Override // b.h.b.a.q
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f33626b.e() : invokeV.booleanValue;
    }

    @Override // b.h.b.a.q
    public void f(q.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bVar) == null) {
            this.f33626b.f(bVar);
        }
    }

    @Override // b.h.b.a.q
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f33626b.g() : invokeV.booleanValue;
    }

    @Override // b.h.b.a.q
    public long getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f33626b.getCurrentPosition() : invokeV.longValue;
    }

    @Override // b.h.b.a.q
    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f33626b.getDuration() : invokeV.longValue;
    }

    @Override // b.h.b.a.q
    public int getPlaybackState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f33626b.getPlaybackState() : invokeV.intValue;
    }

    @Override // b.h.b.a.q
    public int getRepeatMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f33626b.getRepeatMode() : invokeV.intValue;
    }

    @Override // b.h.b.a.q
    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.f33626b.h(z);
        }
    }

    @Override // b.h.b.a.q
    public void i(q.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bVar) == null) {
            this.f33626b.i(bVar);
        }
    }

    @Override // b.h.b.a.q
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f33626b.j() : invokeV.intValue;
    }

    @Override // b.h.b.a.q
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f33626b.k() : invokeV.intValue;
    }

    @Override // b.h.b.a.q
    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.f33626b.l(z);
        }
    }

    @Override // b.h.b.a.q
    public w m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f33626b.m() : (w) invokeV.objValue;
    }

    @Override // b.h.b.a.q
    public b.h.b.a.f0.g n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f33626b.n() : (b.h.b.a.f0.g) invokeV.objValue;
    }

    @Override // b.h.b.a.q
    public int o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i2)) == null) ? this.f33626b.o(i2) : invokeI.intValue;
    }

    @Override // b.h.b.a.q
    public void p(int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            this.f33626b.p(i2, j);
        }
    }

    @Override // b.h.b.a.q
    public long q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f33626b.q() : invokeV.longValue;
    }

    @Override // b.h.b.a.q
    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.f33626b.r() : invokeV.intValue;
    }

    @Override // b.h.b.a.q
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.f33626b.release();
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

    @Override // b.h.b.a.g
    public void s(g.b... bVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, bVarArr) == null) {
            this.f33626b.s(bVarArr);
        }
    }

    @Override // b.h.b.a.q
    public void setRepeatMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            this.f33626b.setRepeatMode(i2);
        }
    }

    @Override // b.h.b.a.q
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.f33626b.stop();
        }
    }

    @Override // b.h.b.a.q
    public long t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.f33626b.t() : invokeV.longValue;
    }

    @Override // b.h.b.a.q
    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.f33626b.u() : invokeV.intValue;
    }

    @Override // b.h.b.a.q
    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.f33626b.v() : invokeV.booleanValue;
    }
}
