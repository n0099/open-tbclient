package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.opengl.GLDebugHelper;
import android.opengl.GLException;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.ai;
import com.baidu.searchbox.logsystem.basic.eventhandler.OOMDeviceEventSceneSceneHandler;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.MonitorType;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
import com.faceunity.gles.GeneratedTexture;
import com.heytap.mcssdk.mode.CommandMessage;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.nio.IntBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;
import org.webrtc.EglBase10;
/* loaded from: classes2.dex */
public class f implements ah {
    public static /* synthetic */ Interceptable $ic;
    public static final j c;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<SurfaceView> a;
    public int b;
    public final WeakReference<f> d;
    public i e;
    public aq f;
    public boolean g;
    public e h;
    public InterfaceC0128f i;
    public g j;
    public k k;
    public int l;
    public int m;
    public boolean n;

    /* loaded from: classes2.dex */
    public interface e {
        EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* renamed from: com.baidu.platform.comapi.map.f$f  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0128f {
        EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* loaded from: classes2.dex */
    public interface g {
        EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* loaded from: classes2.dex */
    public interface k {
        GL a(GL gl);
    }

    @Override // android.view.SurfaceHolder.Callback2
    @Deprecated
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, surfaceHolder) == null) {
        }
    }

    /* loaded from: classes2.dex */
    public abstract class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int[] a;
        public final /* synthetic */ f b;

        public abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(f fVar, int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, iArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fVar;
            this.a = a(iArr);
        }

        private int[] a(int[] iArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, iArr)) == null) {
                if (this.b.m != 2 && this.b.m != 3) {
                    return iArr;
                }
                int length = iArr.length;
                int[] iArr2 = new int[length + 2];
                int i = length - 1;
                System.arraycopy(iArr, 0, iArr2, 0, i);
                iArr2[i] = 12352;
                if (this.b.m == 2) {
                    iArr2[length] = 4;
                } else {
                    iArr2[length] = 64;
                }
                iArr2[length + 1] = 12344;
                return iArr2;
            }
            return (int[]) invokeL.objValue;
        }

        @Override // com.baidu.platform.comapi.map.f.e
        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, egl10, eGLDisplay)) == null) {
                int[] iArr = new int[1];
                if (egl10.eglChooseConfig(eGLDisplay, this.a, null, 0, iArr)) {
                    int i = iArr[0];
                    if (i > 0) {
                        EGLConfig[] eGLConfigArr = new EGLConfig[i];
                        if (egl10.eglChooseConfig(eGLDisplay, this.a, eGLConfigArr, i, iArr)) {
                            EGLConfig a = a(egl10, eGLDisplay, eGLConfigArr);
                            if (a != null) {
                                return a;
                            }
                            throw new IllegalArgumentException("No config chosen");
                        }
                        throw new IllegalArgumentException("eglChooseConfig#2 failed");
                    }
                    throw new IllegalArgumentException("No configs match configSpec");
                }
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            return (EGLConfig) invokeLL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public final /* synthetic */ f k;
        public int[] l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(f fVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            super(fVar, new int[]{MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, i, MonitorType.MONITOR_TYPE_INIT_WEBKIT, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12338, i7, 12337, i8, 12344});
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {fVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i9 = newInitContext.flag;
                if ((i9 & 1) != 0) {
                    int i10 = i9 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((f) objArr2[0], (int[]) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = fVar;
            this.l = new int[1];
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
            this.g = i5;
            this.h = i6;
            this.i = i7;
            this.j = i8;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{egl10, eGLDisplay, eGLConfig, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
                if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.l)) {
                    return this.l[0];
                }
                return i2;
            }
            return invokeCommon.intValue;
        }

        @Override // com.baidu.platform.comapi.map.f.a
        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, egl10, eGLDisplay, eGLConfigArr)) == null) {
                EGLConfig eGLConfig = null;
                for (EGLConfig eGLConfig2 : eGLConfigArr) {
                    int a = a(egl10, eGLDisplay, eGLConfig2, 12325, 0);
                    int a2 = a(egl10, eGLDisplay, eGLConfig2, 12326, 0);
                    if (a >= this.g && a2 >= this.h) {
                        int a3 = a(egl10, eGLDisplay, eGLConfig2, MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 0);
                        int a4 = a(egl10, eGLDisplay, eGLConfig2, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 0);
                        int a5 = a(egl10, eGLDisplay, eGLConfig2, 12322, 0);
                        int a6 = a(egl10, eGLDisplay, eGLConfig2, 12321, 0);
                        if (a3 == this.c && a4 == this.d && a5 == this.e && a6 == this.f) {
                            if (eGLConfig == null) {
                                eGLConfig = eGLConfig2;
                            }
                            if (a(egl10, eGLDisplay, eGLConfig2, 12337, 0) == this.j) {
                                return eGLConfig2;
                            }
                        }
                    }
                }
                return eGLConfig;
            }
            return (EGLConfig) invokeLLL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class c implements InterfaceC0128f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;
        public int b;

        public c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
            this.b = EglBase10.EGL_CONTEXT_CLIENT_VERSION;
        }

        public /* synthetic */ c(f fVar, com.baidu.platform.comapi.map.g gVar) {
            this(fVar);
        }

        @Override // com.baidu.platform.comapi.map.f.InterfaceC0128f
        public EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, egl10, eGLDisplay, eGLConfig)) == null) {
                int[] iArr = {this.b, this.a.m, 12344};
                EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
                if (this.a.m == 0) {
                    iArr = null;
                }
                return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
            }
            return (EGLContext) invokeLLL.objValue;
        }

        @Override // com.baidu.platform.comapi.map.f.InterfaceC0128f
        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, egl10, eGLDisplay, eGLContext) == null) && !egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                h.a("eglDestroyContex", egl10.eglGetError());
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ d(com.baidu.platform.comapi.map.g gVar) {
            this();
        }

        @Override // com.baidu.platform.comapi.map.f.g
        public EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, egl10, eGLDisplay, eGLConfig, obj)) == null) {
                try {
                    return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
                } catch (IllegalArgumentException e) {
                    Log.e("GLRenderControl", "eglCreateWindowSurface", e);
                    return null;
                }
            }
            return (EGLSurface) invokeLLLL.objValue;
        }

        @Override // com.baidu.platform.comapi.map.f.g
        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, egl10, eGLDisplay, eGLSurface) == null) {
                egl10.eglDestroySurface(eGLDisplay, eGLSurface);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public EGL10 a;
        public EGLDisplay b;
        public EGLSurface c;
        public EGLConfig d;
        public EGLContext e;
        public WeakReference<f> f;

        public h(WeakReference<f> weakReference) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {weakReference};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = weakReference;
        }

        private void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, this, str) == null) {
                a(str, this.a.eglGetError());
            }
        }

        public static String b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
                return "0x" + Integer.toHexString(i);
            }
            return (String) invokeI.objValue;
        }

        public static String a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
                switch (i) {
                    case CommandMessage.COMMAND_BASE /* 12288 */:
                        return "EGL_SUCCESS";
                    case 12289:
                        return "EGL_NOT_INITIALIZED";
                    case CommandMessage.COMMAND_UNREGISTER /* 12290 */:
                        return "EGL_BAD_ACCESS";
                    case CommandMessage.COMMAND_STATISTIC /* 12291 */:
                        return OOMDeviceEventSceneSceneHandler.EGL_BAD_ALLOC;
                    case CommandMessage.COMMAND_SET_ALIAS /* 12292 */:
                        return "EGL_BAD_ATTRIBUTE";
                    case CommandMessage.COMMAND_GET_ALIAS /* 12293 */:
                        return "EGL_BAD_CONFIG";
                    case CommandMessage.COMMAND_UNSET_ALIAS /* 12294 */:
                        return "EGL_BAD_CONTEXT";
                    case CommandMessage.COMMAND_SET_TAGS /* 12295 */:
                        return "EGL_BAD_CURRENT_SURFACE";
                    case CommandMessage.COMMAND_GET_TAGS /* 12296 */:
                        return "EGL_BAD_DISPLAY";
                    case CommandMessage.COMMAND_UNSET_TAGS /* 12297 */:
                        return "EGL_BAD_MATCH";
                    case CommandMessage.COMMAND_SET_PUSH_TIME /* 12298 */:
                        return "EGL_BAD_NATIVE_PIXMAP";
                    case CommandMessage.COMMAND_PAUSE_PUSH /* 12299 */:
                        return "EGL_BAD_NATIVE_WINDOW";
                    case 12300:
                        return "EGL_BAD_PARAMETER";
                    case CommandMessage.COMMAND_SET_ACCOUNTS /* 12301 */:
                        return "EGL_BAD_SURFACE";
                    case 12302:
                        return "EGL_CONTEXT_LOST";
                    default:
                        return b(i);
                }
            }
            return (String) invokeI.objValue;
        }

        public static void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(65539, null, str, i) == null) {
                throw new RuntimeException(b(str, i));
            }
        }

        public static String b(String str, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
                return str + " failed: " + a(i);
            }
            return (String) invokeLI.objValue;
        }

        public static void a(String str, String str2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, i) == null) {
                Log.w(str, b(str2, i));
            }
        }

        private void g() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(65543, this) == null) && (eGLSurface = this.c) != null && eGLSurface != (eGLSurface2 = EGL10.EGL_NO_SURFACE)) {
                this.a.eglMakeCurrent(this.b, eGLSurface2, eGLSurface2, EGL10.EGL_NO_CONTEXT);
                f fVar = this.f.get();
                if (fVar != null) {
                    fVar.j.a(this.a, this.b, this.c);
                }
                this.c = null;
            }
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (this.e != null) {
                    f fVar = this.f.get();
                    if (fVar != null) {
                        fVar.i.a(this.a, this.b, this.e);
                    }
                    this.e = null;
                }
                EGLDisplay eGLDisplay = this.b;
                if (eGLDisplay != null) {
                    this.a.eglTerminate(eGLDisplay);
                    this.b = null;
                }
            }
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                EGL10 egl10 = (EGL10) EGLContext.getEGL();
                this.a = egl10;
                EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
                this.b = eglGetDisplay;
                if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                    if (this.a.eglInitialize(eglGetDisplay, new int[2])) {
                        f fVar = this.f.get();
                        if (fVar == null) {
                            this.d = null;
                            this.e = null;
                        } else {
                            this.d = fVar.h.a(this.a, this.b);
                            this.e = fVar.i.a(this.a, this.b, this.d);
                        }
                        EGLContext eGLContext = this.e;
                        if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                            this.e = null;
                            a("createContext");
                        }
                        this.c = null;
                        return;
                    }
                    throw new RuntimeException("eglInitialize failed");
                }
                throw new RuntimeException("eglGetDisplay failed");
            }
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a != null) {
                    if (this.b != null) {
                        if (this.d != null) {
                            g();
                            f fVar = this.f.get();
                            if (fVar != null) {
                                this.c = fVar.j.a(this.a, this.b, this.d, fVar.a());
                            } else {
                                this.c = null;
                            }
                            EGLSurface eGLSurface = this.c;
                            if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
                                if (!this.a.eglMakeCurrent(this.b, eGLSurface, eGLSurface, this.e)) {
                                    a("EGLHelper", "eglMakeCurrent", this.a.eglGetError());
                                    return false;
                                }
                                return true;
                            }
                            if (this.a.eglGetError() == 12299) {
                                Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                            }
                            return false;
                        }
                        throw new RuntimeException("mEglConfig not initialized");
                    }
                    throw new RuntimeException("eglDisplay not initialized");
                }
                throw new RuntimeException("egl not initialized");
            }
            return invokeV.booleanValue;
        }

        public GL c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                GL gl = this.e.getGL();
                f fVar = this.f.get();
                if (fVar != null) {
                    if (fVar.k != null) {
                        gl = fVar.k.a(gl);
                    }
                    if ((fVar.l & 3) != 0) {
                        int i = 0;
                        l lVar = null;
                        if ((fVar.l & 1) != 0) {
                            i = 1;
                        }
                        if ((fVar.l & 2) != 0) {
                            lVar = new l();
                        }
                        return GLDebugHelper.wrap(gl, i, lVar);
                    }
                    return gl;
                }
                return gl;
            }
            return (GL) invokeV.objValue;
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (!this.a.eglSwapBuffers(this.b, this.c)) {
                    return this.a.eglGetError();
                }
                return CommandMessage.COMMAND_BASE;
            }
            return invokeV.intValue;
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                g();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class i extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public boolean b;
        public boolean c;
        public boolean d;
        public boolean e;
        public boolean f;
        public boolean g;
        public boolean h;
        public boolean i;
        public boolean j;
        public boolean k;
        public int l;
        public int m;
        public int n;
        public boolean o;
        public boolean p;
        public boolean q;
        public ArrayList<Runnable> r;
        public boolean s;
        public Runnable t;
        public h u;
        public WeakReference<f> v;

        public i(WeakReference<f> weakReference) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {weakReference};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.r = new ArrayList<>();
            this.s = true;
            this.t = null;
            this.l = 0;
            this.m = 0;
            this.o = true;
            this.n = 1;
            this.p = false;
            this.v = weakReference;
            setPriority(10);
        }

        private void i() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.i) {
                this.i = false;
                this.u.e();
            }
        }

        private void j() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.h) {
                this.u.f();
                this.h = false;
                f.c.b(this);
            }
        }

        private boolean l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
                if (!this.d && this.e && !this.f && this.l > 0 && this.m > 0 && (this.o || this.n == 1)) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.h && this.i && l()) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public int b() {
            InterceptResult invokeV;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                synchronized (f.c) {
                    i = this.n;
                }
                return i;
            }
            return invokeV.intValue;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                synchronized (f.c) {
                    this.o = true;
                    f.c.notifyAll();
                }
            }
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void k() throws InterruptedException {
            boolean z;
            boolean z2;
            int i;
            boolean z3;
            boolean z4;
            boolean z5;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
                i iVar = this;
                iVar.u = new h(iVar.v);
                iVar.h = false;
                iVar.i = false;
                iVar.p = false;
                boolean z6 = false;
                boolean z7 = false;
                boolean z8 = false;
                Runnable runnable = null;
                GL10 gl10 = null;
                boolean z9 = false;
                boolean z10 = false;
                boolean z11 = false;
                boolean z12 = false;
                boolean z13 = false;
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    Runnable runnable2 = null;
                    while (true) {
                        try {
                            synchronized (f.c) {
                                while (!iVar.a) {
                                    if (!iVar.r.isEmpty()) {
                                        runnable2 = iVar.r.remove(0);
                                    } else {
                                        if (iVar.d != iVar.c) {
                                            z3 = iVar.c;
                                            iVar.d = iVar.c;
                                            f.c.notifyAll();
                                        } else {
                                            z3 = false;
                                        }
                                        if (iVar.k) {
                                            i();
                                            j();
                                            iVar.k = false;
                                            z8 = true;
                                        }
                                        if (z6) {
                                            i();
                                            j();
                                            z6 = false;
                                        }
                                        if (z3 && iVar.i) {
                                            i();
                                        }
                                        if (z3 && iVar.h) {
                                            f fVar = iVar.v.get();
                                            if (fVar != null) {
                                                z5 = fVar.n;
                                            } else {
                                                z5 = false;
                                            }
                                            if (!z5) {
                                                j();
                                            }
                                        }
                                        if (!iVar.e && !iVar.g) {
                                            if (iVar.i) {
                                                i();
                                            }
                                            iVar.g = true;
                                            iVar.f = false;
                                            f.c.notifyAll();
                                        }
                                        if (iVar.e && iVar.g) {
                                            iVar.g = false;
                                            f.c.notifyAll();
                                        }
                                        if (z7) {
                                            iVar.p = false;
                                            iVar.q = true;
                                            f.c.notifyAll();
                                            z7 = false;
                                        }
                                        if (iVar.t != null) {
                                            runnable = iVar.t;
                                            iVar.t = null;
                                        }
                                        if (l()) {
                                            if (!iVar.h) {
                                                if (z8) {
                                                    z8 = false;
                                                } else {
                                                    try {
                                                        iVar.u.a();
                                                        iVar.h = true;
                                                        f.c.notifyAll();
                                                        z9 = true;
                                                    } catch (RuntimeException e) {
                                                        f.c.b(iVar);
                                                        throw e;
                                                    }
                                                }
                                            }
                                            if (iVar.h && !iVar.i) {
                                                iVar.i = true;
                                                z10 = true;
                                                z11 = true;
                                                z12 = true;
                                            }
                                            if (iVar.i) {
                                                if (iVar.s) {
                                                    i2 = iVar.l;
                                                    i3 = iVar.m;
                                                    iVar.p = true;
                                                    iVar.s = false;
                                                    z4 = false;
                                                    z10 = true;
                                                    z12 = true;
                                                } else {
                                                    z4 = false;
                                                }
                                                iVar.o = z4;
                                                f.c.notifyAll();
                                                if (iVar.p) {
                                                    z13 = true;
                                                }
                                            }
                                        } else if (runnable != null) {
                                            Log.w("GLRenderControl", "Warning, !readyToDraw() but waiting for draw finished! Early reporting draw finished.");
                                            runnable.run();
                                            runnable = null;
                                        }
                                        f.c.wait();
                                        iVar = this;
                                    }
                                }
                                synchronized (f.c) {
                                    i();
                                    j();
                                }
                                return;
                            }
                            if (runnable2 != null) {
                                break;
                            }
                            if (z10) {
                                if (iVar.u.b()) {
                                    synchronized (f.c) {
                                        iVar.j = true;
                                        f.c.notifyAll();
                                    }
                                    z10 = false;
                                } else {
                                    synchronized (f.c) {
                                        iVar.j = true;
                                        iVar.f = true;
                                        f.c.notifyAll();
                                    }
                                }
                            }
                            if (z11) {
                                gl10 = (GL10) iVar.u.c();
                                z11 = false;
                            }
                            if (z9) {
                                f fVar2 = iVar.v.get();
                                if (fVar2 != null) {
                                    z = z6;
                                    z2 = z7;
                                    fVar2.f.a(null, fVar2.c(), fVar2.d(), 0);
                                    Log.d("GLRenderControl", "mRenderer.onSurfaceCreated");
                                } else {
                                    z = z6;
                                    z2 = z7;
                                }
                                z9 = false;
                            } else {
                                z = z6;
                                z2 = z7;
                            }
                            if (z12) {
                                f fVar3 = iVar.v.get();
                                if (fVar3 != null) {
                                    fVar3.f.a(i2, i3);
                                    Log.d("GLRenderControl", "mRenderer.onSurfaceChanged");
                                }
                                z12 = false;
                            }
                            long currentTimeMillis = System.currentTimeMillis();
                            f fVar4 = iVar.v.get();
                            if (fVar4 != null) {
                                fVar4.f.a(gl10);
                                if (runnable != null) {
                                    runnable.run();
                                    runnable = null;
                                }
                                i = fVar4.e();
                            } else {
                                i = 60;
                            }
                            int d = iVar.u.d();
                            if (d != 12288) {
                                if (d != 12302) {
                                    h.a("GLThread", "eglSwapBuffers", d);
                                    synchronized (f.c) {
                                        iVar.f = true;
                                        f.c.notifyAll();
                                    }
                                } else {
                                    z = true;
                                }
                            }
                            if (z13) {
                                z7 = true;
                                z13 = false;
                            } else {
                                z7 = z2;
                            }
                            long currentTimeMillis2 = System.currentTimeMillis();
                            if (i < 60 && i > 0) {
                                long j = (1000 / i) - (currentTimeMillis2 - currentTimeMillis);
                                if (j > 1) {
                                    synchronized (f.c) {
                                        f.c.wait(j);
                                    }
                                }
                            }
                            iVar = this;
                            z6 = z;
                        } catch (Throwable th) {
                            synchronized (f.c) {
                                i();
                                j();
                                throw th;
                            }
                        }
                    }
                    runnable2.run();
                }
            }
        }

        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i >= 0 && i <= 1) {
                    synchronized (f.c) {
                        this.n = i;
                        f.c.notifyAll();
                    }
                    return;
                }
                throw new IllegalArgumentException("renderMode");
            }
        }

        public void b(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, runnable) == null) {
                if (runnable != null) {
                    synchronized (f.c) {
                        this.r.add(runnable);
                        f.c.notifyAll();
                    }
                    return;
                }
                throw new IllegalArgumentException("r must not be null");
            }
        }

        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
                synchronized (f.c) {
                    this.l = i;
                    this.m = i2;
                    this.s = true;
                    this.o = true;
                    this.q = false;
                    if (Thread.currentThread() == this) {
                        return;
                    }
                    f.c.notifyAll();
                    while (!this.b && !this.d && !this.q && a()) {
                        try {
                            f.c.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void a(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) {
                synchronized (f.c) {
                    if (Thread.currentThread() == this) {
                        return;
                    }
                    this.p = true;
                    this.o = true;
                    this.q = false;
                    this.t = runnable;
                    f.c.notifyAll();
                }
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                synchronized (f.c) {
                    this.e = true;
                    this.j = false;
                    f.c.notifyAll();
                    while (this.g && !this.j && !this.b) {
                        try {
                            f.c.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                synchronized (f.c) {
                    this.e = false;
                    f.c.notifyAll();
                    while (!this.g && !this.b) {
                        try {
                            f.c.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                synchronized (f.c) {
                    this.c = true;
                    f.c.notifyAll();
                    while (!this.b && !this.d) {
                        try {
                            f.c.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                synchronized (f.c) {
                    this.c = false;
                    this.o = true;
                    this.q = false;
                    f.c.notifyAll();
                    while (!this.b && this.d && !this.q) {
                        try {
                            f.c.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                synchronized (f.c) {
                    this.a = true;
                    f.c.notifyAll();
                    while (!this.b) {
                        try {
                            f.c.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
                setName("GLThread " + getId());
                try {
                    k();
                } catch (InterruptedException unused) {
                } catch (Throwable th) {
                    f.c.a(this);
                    throw th;
                }
                f.c.a(this);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class j {
        public static /* synthetic */ Interceptable $ic = null;
        public static String a = "GLThreadManager";
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2068552362, "Lcom/baidu/platform/comapi/map/f$j;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2068552362, "Lcom/baidu/platform/comapi/map/f$j;");
            }
        }

        public j() {
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

        public /* synthetic */ j(com.baidu.platform.comapi.map.g gVar) {
            this();
        }

        public synchronized void a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                synchronized (this) {
                    iVar.b = true;
                    notifyAll();
                }
            }
        }

        public void b(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iVar) == null) {
                notifyAll();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class l extends Writer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public StringBuilder a;

        public l() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new StringBuilder();
        }

        private void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(65537, this) == null) && this.a.length() > 0) {
                Log.v("GLSurfaceView26", this.a.toString());
                StringBuilder sb = this.a;
                sb.delete(0, sb.length());
            }
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a();
            }
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                a();
            }
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, cArr, i, i2) == null) {
                for (int i3 = 0; i3 < i2; i3++) {
                    char c = cArr[i + i3];
                    if (c == '\n') {
                        a();
                    } else {
                        this.a.append(c);
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class m extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f l;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public m(f fVar, boolean z) {
            super(fVar, 8, 8, 8, 0, r8, 0, 1, 4);
            int i;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r4;
                Object[] objArr = {fVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((f) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), ((Integer) objArr2[5]).intValue(), ((Integer) objArr2[6]).intValue(), ((Integer) objArr2[7]).intValue(), ((Integer) objArr2[8]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = fVar;
            if (z) {
                i = 16;
            } else {
                i = 0;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(533995504, "Lcom/baidu/platform/comapi/map/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(533995504, "Lcom/baidu/platform/comapi/map/f;");
                return;
            }
        }
        c = new j(null);
    }

    private void n() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65548, this) != null) || this.e == null) {
            return;
        }
        throw new IllegalStateException("setRenderer has already been called for this instance.");
    }

    public SurfaceHolder a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            SurfaceView surfaceView = this.a.get();
            if (surfaceView != null) {
                return surfaceView.getHolder();
            }
            return null;
        }
        return (SurfaceHolder) invokeV.objValue;
    }

    @Override // com.baidu.platform.comapi.map.ah
    public ai.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return ai.a.a;
        }
        return (ai.a) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            SurfaceView surfaceView = this.a.get();
            if (surfaceView != null) {
                return surfaceView.getWidth();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            SurfaceView surfaceView = this.a.get();
            if (surfaceView != null) {
                return surfaceView.getHeight();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.platform.comapi.map.ah
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.platform.comapi.map.ah
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    public void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            try {
                if (this.e != null) {
                    this.e.h();
                }
            } finally {
                super.finalize();
            }
        }
    }

    @Override // com.baidu.platform.comapi.map.ah
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.e.b();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.platform.comapi.map.ah
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.e.c();
        }
    }

    @Override // com.baidu.platform.comapi.map.ah
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.e.f();
        }
    }

    @Override // com.baidu.platform.comapi.map.ah
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.e.g();
        }
    }

    @Override // com.baidu.platform.comapi.map.ah
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            i iVar = this.e;
            if (iVar != null) {
                iVar.h();
            }
            this.g = true;
        }
    }

    public f(SurfaceView surfaceView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {surfaceView};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = 60;
        this.d = new WeakReference<>(this);
        this.a = new WeakReference<>(surfaceView);
    }

    @Override // com.baidu.platform.comapi.map.ah
    public void a(aq aqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aqVar) == null) {
            n();
            if (this.h == null) {
                this.h = new m(this, true);
            }
            if (this.i == null) {
                this.i = new c(this, null);
            }
            if (this.j == null) {
                this.j = new d(null);
            }
            this.f = aqVar;
            i iVar = new i(this.d);
            this.e = iVar;
            iVar.start();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, surfaceHolder) == null) {
            this.e.d();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, surfaceHolder) == null) {
            this.e.e();
        }
    }

    private Bitmap a(int i2, int i3, int i4, int i5, GL10 gl10, Bitmap.Config config) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), gl10, config})) == null) {
            int i6 = i4 * i5;
            int[] iArr = new int[i6];
            int[] iArr2 = new int[i6];
            IntBuffer wrap = IntBuffer.wrap(iArr);
            wrap.position(0);
            try {
                gl10.glReadPixels(i2, i3, i4, i5, GeneratedTexture.FORMAT, 5121, wrap);
                for (int i7 = 0; i7 < i5; i7++) {
                    int i8 = i7 * i4;
                    int i9 = ((i5 - i7) - 1) * i4;
                    for (int i10 = 0; i10 < i4; i10++) {
                        int i11 = iArr[i8 + i10];
                        iArr2[i9 + i10] = (i11 & DebugControllerOverlayDrawable.TEXT_COLOR_IMAGE_OK) | ((i11 << 16) & 16711680) | ((i11 >> 16) & 255);
                    }
                }
                if (config == null) {
                    return Bitmap.createBitmap(iArr2, i4, i5, Bitmap.Config.ARGB_8888);
                }
                return Bitmap.createBitmap(iArr2, i4, i5, config);
            } catch (GLException unused) {
                return null;
            } catch (OutOfMemoryError e2) {
                Log.e("OutOfMemoryError", " createBitmap cause OutOfMemoryError : " + e2.getMessage());
                return null;
            }
        }
        return (Bitmap) invokeCommon.objValue;
    }

    @Override // com.baidu.platform.comapi.map.ah
    public Bitmap a(int i2, int i3, int i4, int i5, Object obj, Bitmap.Config config) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), obj, config})) == null) {
            return a(i2, i3, i4, i5, (GL10) obj, config);
        }
        return (Bitmap) invokeCommon.objValue;
    }

    @Override // com.baidu.platform.comapi.map.ah
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) != null) || i2 <= 0) {
            return;
        }
        if (i2 > 60) {
            i2 = 60;
        }
        this.b = i2;
    }

    @Override // com.baidu.platform.comapi.map.ah
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.l = i2;
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            n();
            this.m = i2;
        }
    }

    @Override // com.baidu.platform.comapi.map.ah
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.e.a(i2);
        }
    }

    public void a(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)}) == null) {
            a(new b(this, i2, i3, i4, i5, i6, i7, i8, i9));
        }
    }

    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
            n();
            this.h = eVar;
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            a(new m(this, z));
        }
    }

    public void a(InterfaceC0128f interfaceC0128f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0128f) == null) {
            n();
            this.i = interfaceC0128f;
        }
    }

    @Override // com.baidu.platform.comapi.map.ah
    public void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, runnable) == null) {
            this.e.b(runnable);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.n = z;
        }
    }

    @Override // com.baidu.platform.comapi.map.ah
    public void k() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (this.g && this.f != null) {
                i iVar = this.e;
                if (iVar != null) {
                    i2 = iVar.b();
                } else {
                    i2 = 1;
                }
                i iVar2 = new i(this.d);
                this.e = iVar2;
                if (i2 != 1) {
                    iVar2.a(i2);
                }
                this.e.start();
            }
            this.g = false;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048601, this, surfaceHolder, i2, i3, i4) == null) {
            this.e.a(i3, i4);
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeededAsync(SurfaceHolder surfaceHolder, Runnable runnable) {
        i iVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048605, this, surfaceHolder, runnable) == null) && (iVar = this.e) != null) {
            iVar.a(runnable);
        }
    }
}
