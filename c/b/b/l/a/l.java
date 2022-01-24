package c.b.b.l.a;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.SurfaceHolder;
import com.badlogic.gdx.backends.android.AndroidLiveWallpaperService;
import com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes9.dex */
public final class l extends k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public class a extends GLSurfaceView20 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ l f27069h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l lVar, Context context, c.b.b.l.a.b0.c cVar) {
            super(context, cVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, context, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (c.b.b.l.a.b0.c) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27069h = lVar;
        }

        @Override // android.view.SurfaceView
        public SurfaceHolder getHolder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f27069h.y() : (SurfaceHolder) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(n nVar, b bVar, c.b.b.l.a.b0.c cVar) {
        super(nVar, bVar, cVar, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nVar, bVar, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.b.b.l.a.a) objArr2[0], (b) objArr2[1], (c.b.b.l.a.b0.c) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.b.b.l.a.k
    public GLSurfaceView20 i(c.b.b.l.a.a aVar, c.b.b.l.a.b0.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, cVar)) == null) {
            if (g()) {
                GLSurfaceView.EGLConfigChooser l = l();
                a aVar2 = new a(this, aVar.getContext(), cVar);
                if (l != null) {
                    aVar2.setEGLConfigChooser(l);
                } else {
                    b bVar = this.w;
                    aVar2.setEGLConfigChooser(bVar.a, bVar.f27040b, bVar.f27041c, bVar.f27042d, bVar.f27043e, bVar.f27044f);
                }
                aVar2.setRenderer(this);
                return aVar2;
            }
            throw new GdxRuntimeException("Libgdx requires OpenGL ES 2.0");
        }
        return (GLSurfaceView20) invokeLL.objValue;
    }

    @Override // c.b.b.l.a.k
    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && AndroidLiveWallpaperService.DEBUG) {
            super.o();
        }
    }

    @Override // c.b.b.l.a.k, android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gl10) == null) {
            long nanoTime = System.nanoTime();
            if (!this.u) {
                this.n = ((float) (nanoTime - this.m)) / 1.0E9f;
            } else {
                this.n = 0.0f;
            }
            this.m = nanoTime;
            synchronized (this.z) {
                z = this.s;
                z2 = this.t;
                z3 = this.v;
                z4 = this.u;
                if (this.u) {
                    this.u = false;
                    this.z.notifyAll();
                }
                if (this.t) {
                    this.t = false;
                    this.z.notifyAll();
                }
                if (this.v) {
                    this.v = false;
                    this.z.notifyAll();
                }
            }
            if (z4) {
                this.f27065h.getApplicationListener().resume();
                c.b.b.f.a.log("AndroidGraphics", "resumed");
            }
            if (z) {
                synchronized (this.f27065h.getRunnables()) {
                    this.f27065h.getExecutedRunnables().clear();
                    this.f27065h.getExecutedRunnables().b(this.f27065h.getRunnables());
                    this.f27065h.getRunnables().clear();
                    for (int i2 = 0; i2 < this.f27065h.getExecutedRunnables().f27389f; i2++) {
                        this.f27065h.getExecutedRunnables().get(i2).run();
                    }
                }
                this.f27065h.getInput().m();
                this.p++;
                this.f27065h.getApplicationListener().render();
            }
            if (z2) {
                this.f27065h.getApplicationListener().pause();
                c.b.b.f.a.log("AndroidGraphics", "paused");
            }
            if (z3) {
                this.f27065h.getApplicationListener().dispose();
                c.b.b.f.a.log("AndroidGraphics", "destroyed");
            }
            if (nanoTime - this.o > 1000000000) {
                this.q = 0;
                this.o = nanoTime;
            }
            this.q++;
        }
    }

    @Override // c.b.b.l.a.k
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this.z) {
                this.s = true;
                this.u = true;
                while (this.u) {
                    try {
                        c();
                        this.z.wait();
                    } catch (InterruptedException unused) {
                        c.b.b.f.a.log("AndroidGraphics", "waiting for resume synchronization failed!");
                    }
                }
            }
        }
    }

    public SurfaceHolder y() {
        InterceptResult invokeV;
        SurfaceHolder surfaceHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (((n) this.f27065h).f27070e.sync) {
                surfaceHolder = ((n) this.f27065h).f27070e.getSurfaceHolder();
            }
            return surfaceHolder;
        }
        return (SurfaceHolder) invokeV.objValue;
    }

    public void z() {
        GLSurfaceView20 gLSurfaceView20;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (gLSurfaceView20 = this.f27062e) == null) {
            return;
        }
        try {
            gLSurfaceView20.onDetachedFromWindow();
            boolean z = AndroidLiveWallpaperService.DEBUG;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
