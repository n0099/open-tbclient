package com.baidu.platform.comapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLException;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.afx.gl.GLTextureView;
import com.baidu.tbadk.core.data.SmallTailInfo;
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
import java.lang.reflect.Method;
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
public class h extends TextureView implements TextureView.SurfaceTextureListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEBUG_CHECK_GL_ERROR = 1;
    public static final int DEBUG_LOG_GL_CALLS = 2;
    public static final int RENDERMODE_CONTINUOUSLY = 1;
    public static final int RENDERMODE_WHEN_DIRTY = 0;
    public static final g c;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public final View.OnLayoutChangeListener b;
    public final WeakReference<h> d;
    public f e;
    public aq f;
    public boolean g;
    public GLSurfaceView.EGLConfigChooser h;
    public GLSurfaceView.EGLContextFactory i;
    public GLSurfaceView.EGLWindowSurfaceFactory j;
    public GLSurfaceView.GLWrapper k;
    public int l;
    public int m;
    public boolean n;

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, surfaceTexture) == null) {
        }
    }

    /* loaded from: classes2.dex */
    public abstract class a implements GLSurfaceView.EGLConfigChooser {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int[] a;
        public final /* synthetic */ h b;

        public abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(h hVar, int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, iArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hVar;
            this.a = a(iArr);
        }

        private int[] a(int[] iArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, iArr)) == null) {
                if (this.b.m != 2) {
                    return iArr;
                }
                int length = iArr.length;
                int[] iArr2 = new int[length + 2];
                int i = length - 1;
                System.arraycopy(iArr, 0, iArr2, 0, i);
                iArr2[i] = 12352;
                iArr2[length] = 4;
                iArr2[length + 1] = 12344;
                return iArr2;
            }
            return (int[]) invokeL.objValue;
        }

        @Override // android.opengl.GLSurfaceView.EGLConfigChooser
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, egl10, eGLDisplay)) == null) {
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
        public final /* synthetic */ h i;
        public int[] j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(h hVar, int i, int i2, int i3, int i4, int i5, int i6) {
            super(hVar, new int[]{MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, i, MonitorType.MONITOR_TYPE_INIT_WEBKIT, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i7 = newInitContext.flag;
                if ((i7 & 1) != 0) {
                    int i8 = i7 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((h) objArr2[0], (int[]) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = hVar;
            this.j = new int[1];
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
            this.g = i5;
            this.h = i6;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{egl10, eGLDisplay, eGLConfig, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
                if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.j)) {
                    return this.j[0];
                }
                return i2;
            }
            return invokeCommon.intValue;
        }

        @Override // com.baidu.platform.comapi.map.h.a
        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, egl10, eGLDisplay, eGLConfigArr)) == null) {
                for (EGLConfig eGLConfig : eGLConfigArr) {
                    int a = a(egl10, eGLDisplay, eGLConfig, 12325, 0);
                    int a2 = a(egl10, eGLDisplay, eGLConfig, 12326, 0);
                    if (a >= this.g && a2 >= this.h) {
                        int a3 = a(egl10, eGLDisplay, eGLConfig, MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 0);
                        int a4 = a(egl10, eGLDisplay, eGLConfig, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 0);
                        int a5 = a(egl10, eGLDisplay, eGLConfig, 12322, 0);
                        int a6 = a(egl10, eGLDisplay, eGLConfig, 12321, 0);
                        if (a3 == this.c && a4 == this.d && a5 == this.e && a6 == this.f) {
                            return eGLConfig;
                        }
                    }
                }
                return null;
            }
            return (EGLConfig) invokeLLL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class c implements GLSurfaceView.EGLContextFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;
        public int b;

        public c(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
            this.b = EglBase10.EGL_CONTEXT_CLIENT_VERSION;
        }

        public /* synthetic */ c(h hVar, com.baidu.platform.comapi.map.i iVar) {
            this(hVar);
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
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

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, egl10, eGLDisplay, eGLContext) == null) && !egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.i("DefaultContextFactory", "tid=" + Thread.currentThread().getId());
                e.a("eglDestroyContex", egl10.eglGetError());
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements GLSurfaceView.EGLWindowSurfaceFactory {
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

        public /* synthetic */ d(com.baidu.platform.comapi.map.i iVar) {
            this();
        }

        @Override // android.opengl.GLSurfaceView.EGLWindowSurfaceFactory
        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, egl10, eGLDisplay, eGLConfig, obj)) == null) {
                try {
                    return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
                } catch (IllegalArgumentException e) {
                    Log.e(GLTextureView.TAG, "eglCreateWindowSurface", e);
                    return null;
                }
            }
            return (EGLSurface) invokeLLLL.objValue;
        }

        @Override // android.opengl.GLSurfaceView.EGLWindowSurfaceFactory
        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, egl10, eGLDisplay, eGLSurface) == null) {
                egl10.eglDestroySurface(eGLDisplay, eGLSurface);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public EGL10 a;
        public EGLDisplay b;
        public EGLSurface c;
        public EGLConfig d;
        public EGLContext e;
        public WeakReference<h> f;

        public static void a(String str, String str2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(65539, null, str, str2, i) == null) {
            }
        }

        public e(WeakReference<h> weakReference) {
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
            if (interceptable == null || interceptable.invokeL(65537, this, str) == null) {
                a(str, this.a.eglGetError());
            }
        }

        public static void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(65538, null, str, i) == null) {
                String b = b(str, i);
                Log.e("EglHelper", "throwEglException tid=" + Thread.currentThread().getId() + " " + b);
                throw new RuntimeException(b);
            }
        }

        public static String b(String str, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i)) == null) {
                return str + " EGL failed code: " + i;
            }
            return (String) invokeLI.objValue;
        }

        private void g() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(65541, this) == null) && (eGLSurface = this.c) != null && eGLSurface != (eGLSurface2 = EGL10.EGL_NO_SURFACE)) {
                this.a.eglMakeCurrent(this.b, eGLSurface2, eGLSurface2, EGL10.EGL_NO_CONTEXT);
                h hVar = this.f.get();
                if (hVar != null) {
                    hVar.j.destroySurface(this.a, this.b, this.c);
                }
                this.c = null;
            }
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Log.w("EglHelper", "start() tid=" + Thread.currentThread().getId());
                EGL10 egl10 = (EGL10) EGLContext.getEGL();
                this.a = egl10;
                EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
                this.b = eglGetDisplay;
                if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                    if (this.a.eglInitialize(eglGetDisplay, new int[2])) {
                        h hVar = this.f.get();
                        if (hVar == null) {
                            this.d = null;
                            this.e = null;
                        } else {
                            this.d = hVar.h.chooseConfig(this.a, this.b);
                            this.e = hVar.i.createContext(this.a, this.b, this.d);
                        }
                        EGLContext eGLContext = this.e;
                        if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                            this.e = null;
                            a("createContext");
                        }
                        Log.w("EglHelper", "createContext " + this.e + " tid=" + Thread.currentThread().getId());
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
                Log.w("EglHelper", "createSurface()  tid=" + Thread.currentThread().getId());
                if (this.a != null) {
                    if (this.b != null) {
                        if (this.d != null) {
                            g();
                            h hVar = this.f.get();
                            if (hVar != null) {
                                this.c = hVar.j.createWindowSurface(this.a, this.b, this.d, hVar.getSurfaceTexture());
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
                h hVar = this.f.get();
                if (hVar != null) {
                    if (hVar.k != null) {
                        gl = hVar.k.wrap(gl);
                    }
                    if ((hVar.l & 3) != 0) {
                        int i = 0;
                        C0143h c0143h = null;
                        if ((hVar.l & 1) != 0) {
                            i = 1;
                        }
                        if ((hVar.l & 2) != 0) {
                            c0143h = new C0143h();
                        }
                        return GLDebugHelper.wrap(gl, i, c0143h);
                    }
                    return gl;
                }
                return gl;
            }
            return (GL) invokeV.objValue;
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                Log.w("EglHelper", "finish() tid=" + Thread.currentThread().getId());
                if (this.e != null) {
                    h hVar = this.f.get();
                    if (hVar != null) {
                        hVar.i.destroyContext(this.a, this.b, this.e);
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
                Log.w("EglHelper", "destroySurface()  tid=" + Thread.currentThread().getId());
                g();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class f extends Thread {
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
        public int k;
        public int l;
        public int m;
        public boolean n;
        public boolean o;
        public ArrayList<Runnable> p;
        public boolean q;
        public e r;
        public WeakReference<h> s;

        public f(WeakReference<h> weakReference) {
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
            this.p = new ArrayList<>();
            this.q = true;
            this.k = 0;
            this.l = 0;
            this.n = true;
            this.m = 1;
            this.s = weakReference;
        }

        private void j() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.i) {
                this.i = false;
                this.r.e();
            }
        }

        private void k() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.h) {
                this.r.f();
                this.h = false;
                h.c.c(this);
            }
        }

        private boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
                if (!this.d && this.e && !this.f && this.k > 0 && this.l > 0 && (this.n || this.m == 1)) {
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
                if (this.h && this.i && m()) {
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
                synchronized (h.c) {
                    i = this.m;
                }
                return i;
            }
            return invokeV.intValue;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                synchronized (h.c) {
                    this.n = true;
                    h.c.notifyAll();
                }
            }
        }

        public void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                this.j = true;
                h.c.notifyAll();
            }
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX WARN: Removed duplicated region for block: B:146:0x0377  */
        /* JADX WARN: Removed duplicated region for block: B:162:0x03a8  */
        /* JADX WARN: Removed duplicated region for block: B:191:0x0228 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void l() throws InterruptedException {
            GL10 gl10;
            GL10 gl102;
            boolean z;
            int i;
            boolean z2;
            GL10 gl103;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
                this.r = new e(this.s);
                this.h = false;
                this.i = false;
                GL10 gl104 = null;
                boolean z7 = false;
                boolean z8 = false;
                boolean z9 = false;
                boolean z10 = false;
                boolean z11 = false;
                boolean z12 = false;
                boolean z13 = false;
                boolean z14 = false;
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    Runnable runnable = null;
                    while (true) {
                        try {
                            synchronized (h.c) {
                                while (!this.a) {
                                    if (!this.p.isEmpty()) {
                                        runnable = this.p.remove(0);
                                        gl10 = gl104;
                                    } else {
                                        if (this.d != this.c) {
                                            boolean z15 = this.c;
                                            this.d = this.c;
                                            h.c.notifyAll();
                                            z4 = z15;
                                            StringBuilder sb = new StringBuilder();
                                            gl10 = gl104;
                                            sb.append("mPaused is now ");
                                            sb.append(this.d);
                                            sb.append(" tid=");
                                            z3 = z7;
                                            sb.append(getId());
                                            Log.i("GLThread", sb.toString());
                                        } else {
                                            gl10 = gl104;
                                            z3 = z7;
                                            z4 = false;
                                        }
                                        if (this.j) {
                                            Log.i("GLThread", "releasing EGL context because asked to tid=" + getId());
                                            j();
                                            k();
                                            this.j = false;
                                            z14 = true;
                                        }
                                        if (z10) {
                                            j();
                                            k();
                                            z10 = false;
                                        }
                                        if (z4 && this.i) {
                                            Log.i("GLThread", "releasing EGL surface because paused tid=" + getId());
                                            j();
                                        }
                                        if (z4 && this.h) {
                                            h hVar = this.s.get();
                                            if (hVar != null && hVar.n) {
                                                z6 = true;
                                            } else {
                                                z6 = false;
                                            }
                                            if (!z6 || h.c.a()) {
                                                k();
                                                Log.i("GLThread", "releasing EGL context because paused tid=" + getId());
                                            }
                                        }
                                        if (z4 && h.c.b()) {
                                            this.r.f();
                                            Log.i("GLThread", "terminating EGL because paused tid=" + getId());
                                        }
                                        if (!this.e && !this.g) {
                                            Log.i("GLThread", "noticed surfaceView surface lost tid=" + getId());
                                            if (this.i) {
                                                j();
                                            }
                                            this.g = true;
                                            this.f = false;
                                            h.c.notifyAll();
                                        }
                                        if (this.e && this.g) {
                                            Log.i("GLThread", "noticed surfaceView surface acquired tid=" + getId());
                                            this.g = false;
                                            h.c.notifyAll();
                                        }
                                        if (z13) {
                                            Log.i("GLThread", "sending render notification tid=" + getId());
                                            this.o = true;
                                            h.c.notifyAll();
                                            z12 = false;
                                            z13 = false;
                                        }
                                        if (m()) {
                                            if (!this.h) {
                                                if (z14) {
                                                    z7 = z3;
                                                    z14 = false;
                                                } else if (h.c.b(this)) {
                                                    try {
                                                        this.r.a();
                                                        this.h = true;
                                                        h.c.notifyAll();
                                                        z7 = true;
                                                    } catch (RuntimeException e) {
                                                        h.c.c(this);
                                                        throw e;
                                                    }
                                                }
                                                if (this.h && !this.i) {
                                                    this.i = true;
                                                    z8 = true;
                                                    z9 = true;
                                                    z11 = true;
                                                }
                                                if (!this.i) {
                                                    if (this.q) {
                                                        int i4 = this.k;
                                                        int i5 = this.l;
                                                        Log.i("GLThread", "noticing that we want render notification tid=" + getId());
                                                        this.q = false;
                                                        i2 = i4;
                                                        i3 = i5;
                                                        z5 = false;
                                                        z8 = true;
                                                        z11 = true;
                                                        z12 = true;
                                                    } else {
                                                        z5 = false;
                                                    }
                                                    this.n = z5;
                                                    h.c.notifyAll();
                                                }
                                            }
                                            z7 = z3;
                                            if (this.h) {
                                                this.i = true;
                                                z8 = true;
                                                z9 = true;
                                                z11 = true;
                                            }
                                            if (!this.i) {
                                            }
                                        } else {
                                            z7 = z3;
                                        }
                                        Log.i("GLThread", "waiting tid=" + getId() + " mHaveEglContext: " + this.h + " mHaveEglSurface: " + this.i + " mPaused: " + this.d + " mHasSurface: " + this.e + " mSurfaceIsBad: " + this.f + " mWaitingForSurface: " + this.g + " mWidth: " + this.k + " mHeight: " + this.l + " mRequestRender: " + this.n + " mRenderMode: " + this.m);
                                        h.c.wait();
                                        z7 = z7;
                                        z8 = z8;
                                        gl104 = gl10;
                                    }
                                }
                                synchronized (h.c) {
                                    j();
                                    k();
                                }
                                return;
                            }
                            if (runnable != null) {
                                break;
                            }
                            if (z8) {
                                Log.w("GLThread", "egl createSurface");
                                if (!this.r.b()) {
                                    synchronized (h.c) {
                                        this.f = true;
                                        h.c.notifyAll();
                                    }
                                    gl104 = gl10;
                                } else {
                                    z8 = false;
                                }
                            }
                            if (z9) {
                                gl102 = (GL10) this.r.c();
                                h.c.a(gl102);
                                z9 = false;
                            } else {
                                gl102 = gl10;
                            }
                            if (z7) {
                                Log.w("GLThread", "onSurfaceCreated");
                                h hVar2 = this.s.get();
                                if (hVar2 != null) {
                                    z = z8;
                                    hVar2.f.a(null, hVar2.getWidth(), hVar2.getHeight(), 0);
                                } else {
                                    z = z8;
                                }
                                z7 = false;
                            } else {
                                z = z8;
                            }
                            if (z11) {
                                Log.w("GLThread", "onSurfaceChanged(" + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + SmallTailInfo.EMOTION_SUFFIX);
                                h hVar3 = this.s.get();
                                if (hVar3 != null) {
                                    hVar3.f.a(i2, i3);
                                }
                                z11 = false;
                            }
                            long currentTimeMillis = System.currentTimeMillis();
                            h hVar4 = this.s.get();
                            if (hVar4 != null) {
                                hVar4.f.a(gl102);
                                i = hVar4.getFPS();
                            } else {
                                i = 60;
                            }
                            int d = this.r.d();
                            if (d != 12288) {
                                if (d != 12302) {
                                    e.a("GLThread", "eglSwapBuffers", d);
                                    synchronized (h.c) {
                                        this.f = true;
                                        h.c.notifyAll();
                                    }
                                } else {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("egl context lost tid=");
                                    z2 = z9;
                                    sb2.append(getId());
                                    Log.i("GLThread", sb2.toString());
                                    z10 = true;
                                    if (z12) {
                                        z13 = true;
                                    }
                                    long currentTimeMillis2 = System.currentTimeMillis();
                                    if (i >= 60 && i > 0) {
                                        int i6 = 1000 / i;
                                        gl103 = gl102;
                                        long j = i6 - (currentTimeMillis2 - currentTimeMillis);
                                        if (j > 1) {
                                            synchronized (h.c) {
                                                h.c.wait(j);
                                            }
                                        }
                                    } else {
                                        gl103 = gl102;
                                    }
                                    gl104 = gl103;
                                    z9 = z2;
                                    z8 = z;
                                }
                            }
                            z2 = z9;
                            if (z12) {
                            }
                            long currentTimeMillis22 = System.currentTimeMillis();
                            if (i >= 60) {
                            }
                            gl103 = gl102;
                            gl104 = gl103;
                            z9 = z2;
                            z8 = z;
                        } catch (Throwable th) {
                            synchronized (h.c) {
                                j();
                                k();
                                throw th;
                            }
                        }
                    }
                    runnable.run();
                    gl104 = gl10;
                }
            }
        }

        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i >= 0 && i <= 1) {
                    synchronized (h.c) {
                        this.m = i;
                        h.c.notifyAll();
                    }
                    return;
                }
                throw new IllegalArgumentException("renderMode");
            }
        }

        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
                synchronized (h.c) {
                    this.k = i;
                    this.l = i2;
                    this.q = true;
                    this.n = true;
                    this.o = false;
                    h.c.notifyAll();
                    while (!this.b && !this.d && !this.o && a()) {
                        Log.i("Main thread", "onWindowResize waiting for render complete from tid=" + getId());
                        try {
                            h.c.wait();
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
                if (runnable != null) {
                    synchronized (h.c) {
                        this.p.add(runnable);
                        h.c.notifyAll();
                    }
                    return;
                }
                throw new IllegalArgumentException("r must not be null");
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                synchronized (h.c) {
                    Log.i("GLThread", "surfaceCreated tid=" + getId());
                    this.e = true;
                    h.c.notifyAll();
                    while (this.g && !this.b) {
                        try {
                            h.c.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                synchronized (h.c) {
                    Log.i("GLThread", "surfaceDestroyed tid=" + getId());
                    this.e = false;
                    h.c.notifyAll();
                    while (!this.g && !this.b) {
                        try {
                            h.c.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                synchronized (h.c) {
                    Log.i("GLThread", "onPause tid=" + getId());
                    this.c = true;
                    h.c.notifyAll();
                    while (!this.b && !this.d) {
                        Log.i("Main thread", "onPause waiting for mPaused.");
                        try {
                            h.c.wait();
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
                Log.i("GLThread", "starting tid=" + getId());
                try {
                    l();
                } catch (InterruptedException unused) {
                } catch (Throwable th) {
                    h.c.a(this);
                    throw th;
                }
                h.c.a(this);
            }
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                synchronized (h.c) {
                    Log.i("GLThread", "onResume tid=" + getId());
                    this.c = false;
                    this.n = true;
                    this.o = false;
                    h.c.notifyAll();
                    while (!this.b && this.d && !this.o) {
                        Log.i("Main thread", "onResume waiting for !mPaused.");
                        try {
                            h.c.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                synchronized (h.c) {
                    this.a = true;
                    h.c.notifyAll();
                    while (!this.b) {
                        try {
                            h.c.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic = null;
        public static String a = "GLThreadManager";
        public static final Class b;
        public static final Method c;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean d;
        public int e;
        public boolean f;
        public boolean g;
        public boolean h;
        public f i;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2068611851, "Lcom/baidu/platform/comapi/map/h$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2068611851, "Lcom/baidu/platform/comapi/map/h$g;");
                    return;
                }
            }
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                b = cls;
                Method declaredMethod = cls.getDeclaredMethod("getInt", String.class, Integer.TYPE);
                c = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        private void c() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(65539, this) == null) && !this.d) {
                try {
                    this.e = ((Integer) c.invoke(null, "ro.opengles.version", 0)).intValue();
                } catch (Exception unused) {
                    this.e = 65536;
                }
                if (this.e >= 131072) {
                    this.g = true;
                }
                String str = a;
                Log.w(str, "checkGLESVersion mGLESVersion = " + this.e + " mMultipleGLESContextsAllowed = " + this.g);
                this.d = true;
            }
        }

        public g() {
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

        public synchronized boolean a() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                synchronized (this) {
                    z = this.h;
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        public synchronized boolean b() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                synchronized (this) {
                    c();
                    z = !this.g;
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        public /* synthetic */ g(com.baidu.platform.comapi.map.i iVar) {
            this();
        }

        public boolean b(f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fVar)) == null) {
                f fVar2 = this.i;
                if (fVar2 != fVar && fVar2 != null) {
                    c();
                    if (this.g) {
                        return true;
                    }
                    f fVar3 = this.i;
                    if (fVar3 != null) {
                        fVar3.i();
                        return false;
                    }
                    return false;
                }
                this.i = fVar;
                notifyAll();
                return true;
            }
            return invokeL.booleanValue;
        }

        public void c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
                if (this.i == fVar) {
                    this.i = null;
                }
                notifyAll();
            }
        }

        public synchronized void a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                synchronized (this) {
                    Log.i("GLThread", "exiting tid=" + fVar.getId());
                    fVar.b = true;
                    if (this.i == fVar) {
                        this.i = null;
                    }
                    notifyAll();
                }
            }
        }

        public synchronized void a(GL10 gl10) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gl10) == null) {
                synchronized (this) {
                    if (!this.f) {
                        c();
                        String glGetString = gl10.glGetString(7937);
                        boolean z2 = false;
                        if (this.e < 131072) {
                            if (!glGetString.startsWith(GLTextureView.GLThreadManager.kMSM7K_RENDERER_PREFIX)) {
                                z = true;
                            } else {
                                z = false;
                            }
                            this.g = z;
                            notifyAll();
                        }
                        if (!this.g) {
                            z2 = true;
                        }
                        this.h = z2;
                        String str = a;
                        Log.w(str, "checkGLDriver renderer = \"" + glGetString + "\" multipleContextsAllowed = " + this.g + " mLimitedGLESContexts = " + this.h);
                        this.f = true;
                    }
                }
            }
        }
    }

    /* renamed from: com.baidu.platform.comapi.map.h$h  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0143h extends Writer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public StringBuilder a;

        public C0143h() {
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
    public class i extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h j;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public i(h hVar, boolean z) {
            super(hVar, 8, 8, 8, 0, r6, 0);
            int i;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((h) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), ((Integer) objArr2[5]).intValue(), ((Integer) objArr2[6]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = hVar;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(533995566, "Lcom/baidu/platform/comapi/map/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(533995566, "Lcom/baidu/platform/comapi/map/h;");
                return;
            }
        }
        c = new g(null);
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            setSurfaceTextureListener(this);
            addOnLayoutChangeListener(this.b);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65546, this) != null) || this.e == null) {
            return;
        }
        throw new IllegalStateException("setRenderer has already been called for this instance.");
    }

    public void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                if (this.e != null) {
                    this.e.h();
                }
            } finally {
                super.finalize();
            }
        }
    }

    public int getDebugFlags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    public int getFPS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public boolean getPreserveEGLContextOnPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.n;
        }
        return invokeV.booleanValue;
    }

    public int getRenderMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.e.b();
        }
        return invokeV.intValue;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Log.d(GLTextureView.TAG, "onDetachedFromWindow");
            f fVar = this.e;
            if (fVar != null) {
                fVar.h();
            }
            this.g = true;
            super.onDetachedFromWindow();
        }
    }

    public void onPause() {
        f fVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (fVar = this.e) != null) {
            fVar.f();
        }
    }

    public void onResume() {
        f fVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (fVar = this.e) != null) {
            fVar.g();
        }
    }

    public void requestRender() {
        f fVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (fVar = this.e) != null) {
            fVar.c();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 60;
        this.b = new com.baidu.platform.comapi.map.i(this);
        this.d = new WeakReference<>(this);
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 60;
        this.b = new com.baidu.platform.comapi.map.i(this);
        this.d = new WeakReference<>(this);
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = 60;
        this.b = new com.baidu.platform.comapi.map.i(this);
        this.d = new WeakReference<>(this);
        b();
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, surfaceTexture)) == null) {
            surfaceDestroyed(surfaceTexture);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void queueEvent(Runnable runnable) {
        f fVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, runnable) == null) && (fVar = this.e) != null) {
            fVar.a(runnable);
        }
    }

    public void setDebugFlags(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.l = i2;
        }
    }

    public void setEGLConfigChooser(GLSurfaceView.EGLConfigChooser eGLConfigChooser) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, eGLConfigChooser) == null) {
            c();
            this.h = eGLConfigChooser;
        }
    }

    public void setEGLContextClientVersion(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            c();
            this.m = i2;
        }
    }

    public void setEGLContextFactory(GLSurfaceView.EGLContextFactory eGLContextFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, eGLContextFactory) == null) {
            c();
            this.i = eGLContextFactory;
        }
    }

    public void setEGLWindowSurfaceFactory(GLSurfaceView.EGLWindowSurfaceFactory eGLWindowSurfaceFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, eGLWindowSurfaceFactory) == null) {
            c();
            this.j = eGLWindowSurfaceFactory;
        }
    }

    public void setFPS(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.a = i2;
        }
    }

    public void setGLWrapper(GLSurfaceView.GLWrapper gLWrapper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, gLWrapper) == null) {
            this.k = gLWrapper;
        }
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.n = z;
        }
    }

    public void setRenderMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.e.a(i2);
        }
    }

    public void surfaceCreated(SurfaceTexture surfaceTexture) {
        f fVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, surfaceTexture) == null) && (fVar = this.e) != null) {
            fVar.d();
        }
    }

    public void surfaceDestroyed(SurfaceTexture surfaceTexture) {
        f fVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, surfaceTexture) == null) && (fVar = this.e) != null) {
            fVar.e();
        }
    }

    private Bitmap a(int i2, int i3, int i4, int i5, GL10 gl10, Bitmap.Config config) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), gl10, config})) == null) {
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

    public Bitmap captureImageFromSurface(int i2, int i3, int i4, int i5, Object obj, Bitmap.Config config) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), obj, config})) == null) {
            return a(i2, i3, i4, i5, (GL10) obj, config);
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public void setEGLConfigChooser(int i2, int i3, int i4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            setEGLConfigChooser(new b(this, i2, i3, i4, i5, i6, i7));
        }
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onAttachedToWindow();
            Log.d(GLTextureView.TAG, "onAttachedToWindow reattach =" + this.g);
            if (this.g && this.f != null) {
                f fVar = this.e;
                if (fVar != null) {
                    i2 = fVar.b();
                } else {
                    i2 = 1;
                }
                f fVar2 = new f(this.d);
                this.e = fVar2;
                if (i2 != 1) {
                    fVar2.a(i2);
                }
                this.e.start();
            }
            this.g = false;
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048586, this, surfaceTexture, i2, i3) == null) {
            surfaceCreated(surfaceTexture);
            surfaceChanged(surfaceTexture, 0, i2, i3);
        }
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048588, this, surfaceTexture, i2, i3) == null) {
            surfaceChanged(surfaceTexture, 0, i2, i3);
        }
    }

    public void setEGLConfigChooser(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            setEGLConfigChooser(new i(this, z));
        }
    }

    public void setRenderer(aq aqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, aqVar) == null) {
            c();
            if (this.h == null) {
                try {
                    if (com.baidu.platform.comapi.util.h.a(8, 8, 8, 0, 24, 8)) {
                        setEGLConfigChooser(8, 8, 8, 0, 24, 8);
                    } else {
                        setEGLConfigChooser(true);
                    }
                } catch (IllegalArgumentException unused) {
                    setEGLConfigChooser(true);
                }
            }
            if (this.i == null) {
                this.i = new c(this, null);
            }
            if (this.j == null) {
                this.j = new d(null);
            }
            this.f = aqVar;
            f fVar = new f(this.d);
            this.e = fVar;
            fVar.start();
        }
    }

    public void surfaceChanged(SurfaceTexture surfaceTexture, int i2, int i3, int i4) {
        f fVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIII(1048604, this, surfaceTexture, i2, i3, i4) == null) && (fVar = this.e) != null) {
            fVar.a(i3, i4);
        }
    }
}
