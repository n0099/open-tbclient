package com.baidu.mapsdkplatform.comapi.map;

import android.annotation.SuppressLint;
import android.graphics.SurfaceTexture;
import android.opengl.GLUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.MonitorType;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;
import org.webrtc.EglBase10;
@SuppressLint({"NewApi"})
/* loaded from: classes4.dex */
public class m extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AtomicBoolean a;

    /* renamed from: b  reason: collision with root package name */
    public SurfaceTexture f26731b;

    /* renamed from: c  reason: collision with root package name */
    public a f26732c;

    /* renamed from: d  reason: collision with root package name */
    public EGL10 f26733d;

    /* renamed from: e  reason: collision with root package name */
    public EGLDisplay f26734e;

    /* renamed from: f  reason: collision with root package name */
    public EGLContext f26735f;

    /* renamed from: g  reason: collision with root package name */
    public EGLSurface f26736g;

    /* renamed from: h  reason: collision with root package name */
    public GL10 f26737h;
    public int i;
    public boolean j;
    public final ac k;

    /* loaded from: classes4.dex */
    public interface a {
        int a();
    }

    public m(SurfaceTexture surfaceTexture, a aVar, AtomicBoolean atomicBoolean, ac acVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {surfaceTexture, aVar, atomicBoolean, acVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26734e = EGL10.EGL_NO_DISPLAY;
        this.f26735f = EGL10.EGL_NO_CONTEXT;
        this.f26736g = EGL10.EGL_NO_SURFACE;
        this.i = 1;
        this.j = false;
        this.f26731b = surfaceTexture;
        this.f26732c = aVar;
        this.a = atomicBoolean;
        this.k = acVar;
    }

    private boolean a(int i, int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.f26733d = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.f26734e = eglGetDisplay;
            if (eglGetDisplay == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetdisplay failed : " + GLUtils.getEGLErrorString(this.f26733d.eglGetError()));
            } else if (!this.f26733d.eglInitialize(eglGetDisplay, new int[2])) {
                throw new RuntimeException("eglInitialize failed : " + GLUtils.getEGLErrorString(this.f26733d.eglGetError()));
            } else {
                EGLConfig[] eGLConfigArr = new EGLConfig[100];
                int[] iArr = new int[1];
                if (!this.f26733d.eglChooseConfig(this.f26734e, new int[]{12352, 4, MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, i, MonitorType.MONITOR_TYPE_INIT_WEBKIT, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344}, eGLConfigArr, 100, iArr) || iArr[0] <= 0) {
                    return false;
                }
                this.f26735f = this.f26733d.eglCreateContext(this.f26734e, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
                EGLSurface eglCreateWindowSurface = this.f26733d.eglCreateWindowSurface(this.f26734e, eGLConfigArr[0], this.f26731b, null);
                this.f26736g = eglCreateWindowSurface;
                if (eglCreateWindowSurface == EGL10.EGL_NO_SURFACE || this.f26735f == EGL10.EGL_NO_CONTEXT) {
                    if (this.f26733d.eglGetError() == 12299) {
                        throw new RuntimeException("eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
                    }
                    GLUtils.getEGLErrorString(this.f26733d.eglGetError());
                }
                EGL10 egl102 = this.f26733d;
                EGLDisplay eGLDisplay = this.f26734e;
                EGLSurface eGLSurface = this.f26736g;
                if (egl102.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f26735f)) {
                    this.f26737h = (GL10) this.f26735f.getGL();
                    return true;
                }
                String eGLErrorString = GLUtils.getEGLErrorString(this.f26733d.eglGetError());
                throw new RuntimeException("eglMakeCurrent failed : " + eGLErrorString);
            }
        }
        return invokeCommon.booleanValue;
    }

    public static boolean b(int i, int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            egl10.eglInitialize(eglGetDisplay, new int[2]);
            int[] iArr = new int[1];
            return egl10.eglChooseConfig(eglGetDisplay, new int[]{MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, i, MonitorType.MONITOR_TYPE_INIT_WEBKIT, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344}, new EGLConfig[100], 100, iArr) && iArr[0] > 0;
        }
        return invokeCommon.booleanValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            try {
                if (b(5, 6, 5, 0, 24, 0)) {
                    a(8, 8, 8, 0, 24, 0);
                } else {
                    a(8, 8, 8, 0, 24, 0);
                }
            } catch (IllegalArgumentException unused) {
                a(8, 8, 8, 0, 24, 0);
            }
            if (this.k.b() == null) {
                return;
            }
            MapRenderer.nativeInit(this.k.b().j);
            MapRenderer.nativeResize(this.k.b().j, ac.a, ac.f26678b);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            EGLSurface eGLSurface = this.f26736g;
            EGLSurface eGLSurface2 = EGL10.EGL_NO_SURFACE;
            if (eGLSurface != eGLSurface2) {
                this.f26733d.eglMakeCurrent(this.f26734e, eGLSurface2, eGLSurface2, EGL10.EGL_NO_CONTEXT);
                this.f26733d.eglDestroySurface(this.f26734e, this.f26736g);
                this.f26736g = EGL10.EGL_NO_SURFACE;
            }
            EGLContext eGLContext = this.f26735f;
            if (eGLContext != EGL10.EGL_NO_CONTEXT) {
                this.f26733d.eglDestroyContext(this.f26734e, eGLContext);
                this.f26735f = EGL10.EGL_NO_CONTEXT;
            }
            EGLDisplay eGLDisplay = this.f26734e;
            if (eGLDisplay != EGL10.EGL_NO_DISPLAY) {
                this.f26733d.eglTerminate(eGLDisplay);
                this.f26734e = EGL10.EGL_NO_DISPLAY;
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.i = 1;
            this.j = false;
            synchronized (this) {
                if (getState() == Thread.State.WAITING) {
                    notify();
                }
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.i = 0;
            synchronized (this) {
                this.j = true;
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.j = true;
            synchronized (this) {
                if (getState() == Thread.State.WAITING) {
                    notify();
                }
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d();
            while (this.f26732c != null) {
                if (this.i != 1 || this.j) {
                    try {
                        synchronized (this) {
                            wait();
                        }
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                } else if (this.k.b() == null) {
                    break;
                } else {
                    synchronized (this.k.b()) {
                        synchronized (this) {
                            if (!this.j) {
                                this.i = this.f26732c.a();
                            }
                        }
                        e b2 = this.k.b();
                        if (b2 != null && b2.f26705h != null) {
                            for (l lVar : b2.f26705h) {
                                if (lVar != null) {
                                    ab J = b2.J();
                                    if (this.f26737h == null) {
                                        return;
                                    }
                                    if (lVar != null) {
                                        lVar.a(this.f26737h, J);
                                    }
                                }
                            }
                        }
                        this.f26733d.eglSwapBuffers(this.f26734e, this.f26736g);
                    }
                }
                if (this.j) {
                    break;
                }
            }
            e();
        }
    }
}
