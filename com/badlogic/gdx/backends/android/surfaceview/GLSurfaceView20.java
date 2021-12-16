package com.badlogic.gdx.backends.android.surfaceview;

import android.annotation.TargetApi;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.core.view.InputDeviceCompat;
import c.b.b.l.a.b0.c;
import c.b.b.l.a.z;
import com.badlogic.gdx.Input;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes9.dex */
public class GLSurfaceView20 extends GLSurfaceView {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: f  reason: collision with root package name */
    public static String f31926f = "GL2JNIView";

    /* renamed from: g  reason: collision with root package name */
    public static int f31927g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final c.b.b.l.a.b0.c f31928e;
    public Input.OnscreenKeyboardType onscreenKeyboardType;

    /* loaded from: classes9.dex */
    public class a extends BaseInputConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GLSurfaceView20 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(GLSurfaceView20 gLSurfaceView20, View view, boolean z) {
            super(view, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gLSurfaceView20, view, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public final void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                super.sendKeyEvent(new KeyEvent(uptimeMillis, uptimeMillis, 0, i2, 0, 0, -1, 0, 6));
                super.sendKeyEvent(new KeyEvent(SystemClock.uptimeMillis(), uptimeMillis, 1, i2, 0, 0, -1, 0, 6));
            }
        }

        @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
                if (Build.VERSION.SDK_INT >= 16 && i2 == 1 && i3 == 0) {
                    a(67);
                    return true;
                }
                return super.deleteSurroundingText(i2, i3);
            }
            return invokeII.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class b implements GLSurfaceView.EGLConfigChooser {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: h  reason: collision with root package name */
        public static int[] f31929h;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f31930b;

        /* renamed from: c  reason: collision with root package name */
        public int f31931c;

        /* renamed from: d  reason: collision with root package name */
        public int f31932d;

        /* renamed from: e  reason: collision with root package name */
        public int f31933e;

        /* renamed from: f  reason: collision with root package name */
        public int f31934f;

        /* renamed from: g  reason: collision with root package name */
        public int[] f31935g;

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
            f31929h = new int[]{MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 4, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 4, 12322, 4, 12352, 4, 12344};
        }

        public b(int i2, int i3, int i4, int i5, int i6, int i7) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i8 = newInitContext.flag;
                if ((i8 & 1) != 0) {
                    int i9 = i8 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f31935g = new int[1];
            this.a = i2;
            this.f31930b = i3;
            this.f31931c = i4;
            this.f31932d = i5;
            this.f31933e = i6;
            this.f31934f = i7;
        }

        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, egl10, eGLDisplay, eGLConfigArr)) == null) {
                for (EGLConfig eGLConfig : eGLConfigArr) {
                    int b2 = b(egl10, eGLDisplay, eGLConfig, 12325, 0);
                    int b3 = b(egl10, eGLDisplay, eGLConfig, 12326, 0);
                    if (b2 >= this.f31933e && b3 >= this.f31934f) {
                        int b4 = b(egl10, eGLDisplay, eGLConfig, MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 0);
                        int b5 = b(egl10, eGLDisplay, eGLConfig, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 0);
                        int b6 = b(egl10, eGLDisplay, eGLConfig, 12322, 0);
                        int b7 = b(egl10, eGLDisplay, eGLConfig, 12321, 0);
                        if (b4 == this.a && b5 == this.f31930b && b6 == this.f31931c && b7 == this.f31932d) {
                            return eGLConfig;
                        }
                    }
                }
                return null;
            }
            return (EGLConfig) invokeLLL.objValue;
        }

        public final int b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2, int i3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{egl10, eGLDisplay, eGLConfig, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) ? egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, this.f31935g) ? this.f31935g[0] : i3 : invokeCommon.intValue;
        }

        @Override // android.opengl.GLSurfaceView.EGLConfigChooser
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, egl10, eGLDisplay)) == null) {
                int[] iArr = new int[1];
                egl10.eglChooseConfig(eGLDisplay, f31929h, null, 0, iArr);
                int i2 = iArr[0];
                if (i2 > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i2];
                    egl10.eglChooseConfig(eGLDisplay, f31929h, eGLConfigArr, i2, iArr);
                    return a(egl10, eGLDisplay, eGLConfigArr);
                }
                throw new IllegalArgumentException("No configs match configSpec");
            }
            return (EGLConfig) invokeLL.objValue;
        }
    }

    /* loaded from: classes9.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                String str = GLSurfaceView20.f31926f;
                String str2 = "creating OpenGL ES " + GLSurfaceView20.f31927g + ".0 context";
                GLSurfaceView20.a("Before eglCreateContext " + GLSurfaceView20.f31927g, egl10);
                EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{a, GLSurfaceView20.f31927g, 12344});
                if ((!GLSurfaceView20.a("After eglCreateContext " + GLSurfaceView20.f31927g, egl10) || eglCreateContext == null) && GLSurfaceView20.f31927g > 2) {
                    String str3 = GLSurfaceView20.f31926f;
                    GLSurfaceView20.f31927g = 2;
                    return createContext(egl10, eGLDisplay, eGLConfig);
                }
                String str4 = GLSurfaceView20.f31926f;
                String str5 = "Returning a GLES " + GLSurfaceView20.f31927g + " context";
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GLSurfaceView20(Context context, c.b.b.l.a.b0.c cVar, int i2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.onscreenKeyboardType = Input.OnscreenKeyboardType.Default;
        f31927g = i2;
        this.f31928e = cVar;
        b(false, 16, 0);
    }

    public static boolean a(String str, EGL10 egl10) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, egl10)) != null) {
            return invokeLL.booleanValue;
        }
        boolean z = true;
        while (true) {
            int eglGetError = egl10.eglGetError();
            if (eglGetError == 12288) {
                return z;
            }
            String.format("%s: EGL error: 0x%x", str, Integer.valueOf(eglGetError));
            z = false;
        }
    }

    public final void b(boolean z, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            if (z) {
                getHolder().setFormat(-3);
            }
            setEGLContextFactory(new c());
            setEGLConfigChooser(z ? new b(8, 8, 8, 8, i2, i3) : new b(8, 8, 8, 0, i2, i3));
        }
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editorInfo)) == null) {
            if (editorInfo != null) {
                editorInfo.imeOptions |= 268435456;
                editorInfo.inputType = z.d(this.onscreenKeyboardType);
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
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            c.a a2 = this.f31928e.a(i2, i3);
            setMeasuredDimension(a2.a, a2.f27791b);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GLSurfaceView20(Context context, c.b.b.l.a.b0.c cVar) {
        this(context, cVar, 2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (c.b.b.l.a.b0.c) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GLSurfaceView20(Context context, boolean z, int i2, int i3, c.b.b.l.a.b0.c cVar) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), cVar};
            interceptable.invokeUnInit(65539, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.onscreenKeyboardType = Input.OnscreenKeyboardType.Default;
        this.f31928e = cVar;
        b(z, i2, i3);
    }
}
