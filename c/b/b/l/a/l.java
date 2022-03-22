package c.b.b.l.a;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.Log;
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
import com.google.android.exoplayer2.C;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes3.dex */
public final class l extends k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a extends GLSurfaceView20 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f22431e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l lVar, Context context, c.b.b.l.a.b0.c cVar) {
            super(context, cVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, context, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (c.b.b.l.a.b0.c) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22431e = lVar;
        }

        @Override // android.view.SurfaceView
        public SurfaceHolder getHolder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f22431e.y() : (SurfaceHolder) invokeV.objValue;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                    b bVar = this.s;
                    aVar2.setEGLConfigChooser(bVar.a, bVar.f22405b, bVar.f22406c, bVar.f22407d, bVar.f22408e, bVar.f22409f);
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
            if (!this.q) {
                this.j = ((float) (nanoTime - this.i)) / 1.0E9f;
            } else {
                this.j = 0.0f;
            }
            this.i = nanoTime;
            synchronized (this.v) {
                z = this.o;
                z2 = this.p;
                z3 = this.r;
                z4 = this.q;
                if (this.q) {
                    this.q = false;
                    this.v.notifyAll();
                }
                if (this.p) {
                    this.p = false;
                    this.v.notifyAll();
                }
                if (this.r) {
                    this.r = false;
                    this.v.notifyAll();
                }
            }
            if (z4) {
                this.f22426d.getApplicationListener().resume();
                c.b.b.f.a.log("AndroidGraphics", "resumed");
            }
            if (z) {
                synchronized (this.f22426d.getRunnables()) {
                    this.f22426d.getExecutedRunnables().clear();
                    this.f22426d.getExecutedRunnables().b(this.f22426d.getRunnables());
                    this.f22426d.getRunnables().clear();
                    for (int i = 0; i < this.f22426d.getExecutedRunnables().f22717b; i++) {
                        this.f22426d.getExecutedRunnables().get(i).run();
                    }
                }
                this.f22426d.getInput().g0();
                this.l++;
                this.f22426d.getApplicationListener().render();
            }
            if (z2) {
                this.f22426d.getApplicationListener().pause();
                c.b.b.f.a.log("AndroidGraphics", "paused");
            }
            if (z3) {
                this.f22426d.getApplicationListener().dispose();
                c.b.b.f.a.log("AndroidGraphics", "destroyed");
            }
            if (nanoTime - this.k > C.NANOS_PER_SECOND) {
                this.m = 0;
                this.k = nanoTime;
            }
            this.m++;
        }
    }

    @Override // c.b.b.l.a.k
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this.v) {
                this.o = true;
                this.q = true;
                while (this.q) {
                    try {
                        c();
                        this.v.wait();
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
            synchronized (((n) this.f22426d).a.sync) {
                surfaceHolder = ((n) this.f22426d).a.getSurfaceHolder();
            }
            return surfaceHolder;
        }
        return (SurfaceHolder) invokeV.objValue;
    }

    public void z() {
        GLSurfaceView20 gLSurfaceView20;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (gLSurfaceView20 = this.a) == null) {
            return;
        }
        try {
            gLSurfaceView20.onDetachedFromWindow();
            if (AndroidLiveWallpaperService.DEBUG) {
                Log.d(AndroidLiveWallpaperService.TAG, " > AndroidLiveWallpaper - onDestroy() stopped GLThread managed by GLSurfaceView");
            }
        } catch (Throwable th) {
            Log.e(AndroidLiveWallpaperService.TAG, "failed to destroy GLSurfaceView's thread! GLSurfaceView.onDetachedFromWindow impl changed since API lvl 16!");
            th.printStackTrace();
        }
    }
}
