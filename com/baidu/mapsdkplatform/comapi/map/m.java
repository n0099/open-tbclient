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
/* loaded from: classes10.dex */
public class m extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AtomicBoolean a;

    /* renamed from: b  reason: collision with root package name */
    public SurfaceTexture f35922b;

    /* renamed from: c  reason: collision with root package name */
    public a f35923c;

    /* renamed from: d  reason: collision with root package name */
    public EGL10 f35924d;

    /* renamed from: e  reason: collision with root package name */
    public EGLDisplay f35925e;

    /* renamed from: f  reason: collision with root package name */
    public EGLContext f35926f;

    /* renamed from: g  reason: collision with root package name */
    public EGLSurface f35927g;

    /* renamed from: h  reason: collision with root package name */
    public GL10 f35928h;

    /* renamed from: i  reason: collision with root package name */
    public int f35929i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f35930j;
    public final ac k;

    /* loaded from: classes10.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35925e = EGL10.EGL_NO_DISPLAY;
        this.f35926f = EGL10.EGL_NO_CONTEXT;
        this.f35927g = EGL10.EGL_NO_SURFACE;
        this.f35929i = 1;
        this.f35930j = false;
        this.f35922b = surfaceTexture;
        this.f35923c = aVar;
        this.a = atomicBoolean;
        this.k = acVar;
    }

    private boolean a(int i2, int i3, int i4, int i5, int i6, int i7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)})) == null) {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.f35924d = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.f35925e = eglGetDisplay;
            if (eglGetDisplay == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetdisplay failed : " + GLUtils.getEGLErrorString(this.f35924d.eglGetError()));
            } else if (!this.f35924d.eglInitialize(eglGetDisplay, new int[2])) {
                throw new RuntimeException("eglInitialize failed : " + GLUtils.getEGLErrorString(this.f35924d.eglGetError()));
            } else {
                EGLConfig[] eGLConfigArr = new EGLConfig[100];
                int[] iArr = new int[1];
                if (!this.f35924d.eglChooseConfig(this.f35925e, new int[]{12352, 4, MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, i2, MonitorType.MONITOR_TYPE_INIT_WEBKIT, i3, 12322, i4, 12321, i5, 12325, i6, 12326, i7, 12344}, eGLConfigArr, 100, iArr) || iArr[0] <= 0) {
                    return false;
                }
                this.f35926f = this.f35924d.eglCreateContext(this.f35925e, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
                EGLSurface eglCreateWindowSurface = this.f35924d.eglCreateWindowSurface(this.f35925e, eGLConfigArr[0], this.f35922b, null);
                this.f35927g = eglCreateWindowSurface;
                if (eglCreateWindowSurface == EGL10.EGL_NO_SURFACE || this.f35926f == EGL10.EGL_NO_CONTEXT) {
                    if (this.f35924d.eglGetError() == 12299) {
                        throw new RuntimeException("eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
                    }
                    GLUtils.getEGLErrorString(this.f35924d.eglGetError());
                }
                EGL10 egl102 = this.f35924d;
                EGLDisplay eGLDisplay = this.f35925e;
                EGLSurface eGLSurface = this.f35927g;
                if (egl102.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f35926f)) {
                    this.f35928h = (GL10) this.f35926f.getGL();
                    return true;
                }
                String eGLErrorString = GLUtils.getEGLErrorString(this.f35924d.eglGetError());
                throw new RuntimeException("eglMakeCurrent failed : " + eGLErrorString);
            }
        }
        return invokeCommon.booleanValue;
    }

    public static boolean b(int i2, int i3, int i4, int i5, int i6, int i7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)})) == null) {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            egl10.eglInitialize(eglGetDisplay, new int[2]);
            int[] iArr = new int[1];
            return egl10.eglChooseConfig(eglGetDisplay, new int[]{MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, i2, MonitorType.MONITOR_TYPE_INIT_WEBKIT, i3, 12322, i4, 12321, i5, 12325, i6, 12326, i7, 12344}, new EGLConfig[100], 100, iArr) && iArr[0] > 0;
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
            MapRenderer.nativeInit(this.k.b().f35894j);
            MapRenderer.nativeResize(this.k.b().f35894j, ac.a, ac.f35862b);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            EGLSurface eGLSurface = this.f35927g;
            EGLSurface eGLSurface2 = EGL10.EGL_NO_SURFACE;
            if (eGLSurface != eGLSurface2) {
                this.f35924d.eglMakeCurrent(this.f35925e, eGLSurface2, eGLSurface2, EGL10.EGL_NO_CONTEXT);
                this.f35924d.eglDestroySurface(this.f35925e, this.f35927g);
                this.f35927g = EGL10.EGL_NO_SURFACE;
            }
            EGLContext eGLContext = this.f35926f;
            if (eGLContext != EGL10.EGL_NO_CONTEXT) {
                this.f35924d.eglDestroyContext(this.f35925e, eGLContext);
                this.f35926f = EGL10.EGL_NO_CONTEXT;
            }
            EGLDisplay eGLDisplay = this.f35925e;
            if (eGLDisplay != EGL10.EGL_NO_DISPLAY) {
                this.f35924d.eglTerminate(eGLDisplay);
                this.f35925e = EGL10.EGL_NO_DISPLAY;
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f35929i = 1;
            this.f35930j = false;
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
            this.f35929i = 0;
            synchronized (this) {
                this.f35930j = true;
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f35930j = true;
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
            while (this.f35923c != null) {
                if (this.f35929i != 1 || this.f35930j) {
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
                            if (!this.f35930j) {
                                this.f35929i = this.f35923c.a();
                            }
                        }
                        e b2 = this.k.b();
                        if (b2 != null && b2.f35892h != null) {
                            for (l lVar : b2.f35892h) {
                                if (lVar != null) {
                                    ab J = b2.J();
                                    if (this.f35928h == null) {
                                        return;
                                    }
                                    if (lVar != null) {
                                        lVar.a(this.f35928h, J);
                                    }
                                }
                            }
                        }
                        this.f35924d.eglSwapBuffers(this.f35925e, this.f35927g);
                    }
                }
                if (this.f35930j) {
                    break;
                }
            }
            e();
        }
    }
}
