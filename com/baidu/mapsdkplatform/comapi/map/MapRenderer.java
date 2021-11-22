package com.baidu.mapsdkplatform.comapi.map;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes7.dex */
public class MapRenderer implements GLSurfaceView.Renderer {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final String f40888d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f40889a;

    /* renamed from: b  reason: collision with root package name */
    public int f40890b;

    /* renamed from: c  reason: collision with root package name */
    public int f40891c;

    /* renamed from: e  reason: collision with root package name */
    public long f40892e;

    /* renamed from: f  reason: collision with root package name */
    public a f40893f;

    /* renamed from: g  reason: collision with root package name */
    public final j f40894g;

    /* loaded from: classes7.dex */
    public interface a {
        void f();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1762040437, "Lcom/baidu/mapsdkplatform/comapi/map/MapRenderer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1762040437, "Lcom/baidu/mapsdkplatform/comapi/map/MapRenderer;");
                return;
            }
        }
        f40888d = MapRenderer.class.getSimpleName();
    }

    public MapRenderer(j jVar, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f40893f = aVar;
        this.f40894g = jVar;
    }

    private void a(GL10 gl10) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, gl10) == null) {
            GLES20.glClear(16640);
            GLES20.glClearColor(0.85f, 0.8f, 0.8f, 0.0f);
        }
    }

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? this.f40892e != 0 : invokeV.booleanValue;
    }

    public static native void nativeInit(long j);

    public static native int nativeRender(long j);

    public static native void nativeResize(long j, int i2, int i3);

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            this.f40892e = j;
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gl10) == null) {
            if (!a()) {
                a(gl10);
                return;
            }
            if (this.f40891c <= 1) {
                nativeResize(this.f40892e, this.f40889a, this.f40890b);
                this.f40891c++;
            }
            this.f40893f.f();
            int nativeRender = nativeRender(this.f40892e);
            if (this.f40894g.a() == null) {
                return;
            }
            if (this.f40894g.a().f40952h != null) {
                for (l lVar : this.f40894g.a().f40952h) {
                    if (this.f40894g.a() == null) {
                        return;
                    }
                    ab J = this.f40894g.a().J();
                    if (lVar != null) {
                        lVar.a(gl10, J);
                    }
                }
            }
            j jVar = this.f40894g;
            if (nativeRender == 1) {
                jVar.requestRender();
            } else if (jVar.a().b()) {
                if (jVar.getRenderMode() != 1) {
                    jVar.setRenderMode(1);
                }
            } else if (jVar.getRenderMode() != 0) {
                jVar.setRenderMode(0);
            }
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, gl10, i2, i3) == null) {
            long j = this.f40892e;
            if (j != 0) {
                nativeResize(j, i2, i3);
            }
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, gl10, eGLConfig) == null) {
            nativeInit(this.f40892e);
            if (a()) {
                this.f40893f.f();
            }
        }
    }
}
