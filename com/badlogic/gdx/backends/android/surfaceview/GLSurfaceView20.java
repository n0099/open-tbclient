package com.badlogic.gdx.backends.android.surfaceview;

import android.annotation.TargetApi;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.badlogic.gdx.Input;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.s2;
import com.baidu.tieba.w2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.MonitorType;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
/* loaded from: classes.dex */
public class GLSurfaceView20 extends GLSurfaceView {
    public static /* synthetic */ Interceptable $ic = null;
    public static String c = "GL2JNIView";
    public static int d;
    public transient /* synthetic */ FieldHolder $fh;
    public final w2 a;
    public Input.OnscreenKeyboardType b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(843055469, "Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceView20;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(843055469, "Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceView20;");
        }
    }

    /* loaded from: classes.dex */
    public class a extends BaseInputConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GLSurfaceView20 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(GLSurfaceView20 gLSurfaceView20, View view2, boolean z) {
            super(view2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gLSurfaceView20, view2, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((View) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gLSurfaceView20;
        }

        @TargetApi(16)
        public final void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                super.sendKeyEvent(new KeyEvent(uptimeMillis, uptimeMillis, 0, i, 0, 0, -1, 0, 6));
                super.sendKeyEvent(new KeyEvent(SystemClock.uptimeMillis(), uptimeMillis, 1, i, 0, 0, -1, 0, 6));
            }
        }

        @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2)) == null) {
                if (Build.VERSION.SDK_INT >= 16 && i == 1 && i2 == 0) {
                    a(67);
                    return true;
                }
                return super.deleteSurroundingText(i, i2);
            }
            return invokeII.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static class b implements GLSurfaceView.EGLConfigChooser {
        public static /* synthetic */ Interceptable $ic;
        public static int[] h;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int[] g;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1572532241, "Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceView20$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1572532241, "Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceView20$b;");
                    return;
                }
            }
            h = new int[]{MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 4, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 4, 12322, 4, 12352, 4, 12344};
        }

        public b(int i, int i2, int i3, int i4, int i5, int i6) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i7 = newInitContext.flag;
                if ((i7 & 1) != 0) {
                    int i8 = i7 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.g = new int[1];
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
        }

        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, egl10, eGLDisplay, eGLConfigArr)) == null) {
                for (EGLConfig eGLConfig : eGLConfigArr) {
                    int b = b(egl10, eGLDisplay, eGLConfig, 12325, 0);
                    int b2 = b(egl10, eGLDisplay, eGLConfig, 12326, 0);
                    if (b >= this.e && b2 >= this.f) {
                        int b3 = b(egl10, eGLDisplay, eGLConfig, MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 0);
                        int b4 = b(egl10, eGLDisplay, eGLConfig, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 0);
                        int b5 = b(egl10, eGLDisplay, eGLConfig, 12322, 0);
                        int b6 = b(egl10, eGLDisplay, eGLConfig, 12321, 0);
                        if (b3 == this.a && b4 == this.b && b5 == this.c && b6 == this.d) {
                            return eGLConfig;
                        }
                    }
                }
                return null;
            }
            return (EGLConfig) invokeLLL.objValue;
        }

        public final int b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{egl10, eGLDisplay, eGLConfig, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
                if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.g)) {
                    return this.g[0];
                }
                return i2;
            }
            return invokeCommon.intValue;
        }

        @Override // android.opengl.GLSurfaceView.EGLConfigChooser
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, egl10, eGLDisplay)) == null) {
                int[] iArr = new int[1];
                egl10.eglChooseConfig(eGLDisplay, h, null, 0, iArr);
                int i = iArr[0];
                if (i > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i];
                    egl10.eglChooseConfig(eGLDisplay, h, eGLConfigArr, i, iArr);
                    return a(egl10, eGLDisplay, eGLConfigArr);
                }
                throw new IllegalArgumentException("No configs match configSpec");
            }
            return (EGLConfig) invokeLL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class c implements GLSurfaceView.EGLContextFactory {
        public static /* synthetic */ Interceptable $ic = null;
        public static int a = 12440;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1572532210, "Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceView20$c;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1572532210, "Lcom/badlogic/gdx/backends/android/surfaceview/GLSurfaceView20$c;");
            }
        }

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, egl10, eGLDisplay, eGLConfig)) == null) {
                String str = GLSurfaceView20.c;
                Log.w(str, "creating OpenGL ES " + GLSurfaceView20.d + ".0 context");
                StringBuilder sb = new StringBuilder();
                sb.append("Before eglCreateContext ");
                sb.append(GLSurfaceView20.d);
                GLSurfaceView20.a(sb.toString(), egl10);
                EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{a, GLSurfaceView20.d, 12344});
                if ((!GLSurfaceView20.a("After eglCreateContext " + GLSurfaceView20.d, egl10) || eglCreateContext == null) && GLSurfaceView20.d > 2) {
                    Log.w(GLSurfaceView20.c, "Falling back to GLES 2");
                    GLSurfaceView20.d = 2;
                    return createContext(egl10, eGLDisplay, eGLConfig);
                }
                String str2 = GLSurfaceView20.c;
                Log.w(str2, "Returning a GLES " + GLSurfaceView20.d + " context");
                return eglCreateContext;
            }
            return (EGLContext) invokeLLL.objValue;
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, egl10, eGLDisplay, eGLContext) == null) {
                egl10.eglDestroyContext(eGLDisplay, eGLContext);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GLSurfaceView20(Context context, w2 w2Var) {
        this(context, w2Var, 2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, w2Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (w2) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GLSurfaceView20(Context context, w2 w2Var, int i) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, w2Var, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.b = Input.OnscreenKeyboardType.Default;
        d = i;
        this.a = w2Var;
        b(false, 16, 0);
    }

    public static boolean a(String str, EGL10 egl10) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, egl10)) == null) {
            boolean z = true;
            while (true) {
                int eglGetError = egl10.eglGetError();
                if (eglGetError != 12288) {
                    Log.e(c, String.format("%s: EGL error: 0x%x", str, Integer.valueOf(eglGetError)));
                    z = false;
                } else {
                    return z;
                }
            }
        } else {
            return invokeLL.booleanValue;
        }
    }

    public final void b(boolean z, int i, int i2) {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            if (z) {
                getHolder().setFormat(-3);
            }
            setEGLContextFactory(new c());
            if (z) {
                bVar = new b(8, 8, 8, 8, i, i2);
            } else {
                bVar = new b(8, 8, 8, 0, i, i2);
            }
            setEGLConfigChooser(bVar);
        }
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editorInfo)) == null) {
            if (editorInfo != null) {
                editorInfo.imeOptions |= LaunchTaskConstants.OTHER_PROCESS;
                editorInfo.inputType = s2.c(this.b);
            }
            return new a(this, this, false);
        }
        return (InputConnection) invokeL.objValue;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDetachedFromWindow();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            w2.a a2 = this.a.a(i, i2);
            setMeasuredDimension(a2.a, a2.b);
        }
    }
}
