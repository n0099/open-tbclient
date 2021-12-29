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
    public SurfaceTexture f37115b;

    /* renamed from: c  reason: collision with root package name */
    public a f37116c;

    /* renamed from: d  reason: collision with root package name */
    public EGL10 f37117d;

    /* renamed from: e  reason: collision with root package name */
    public EGLDisplay f37118e;

    /* renamed from: f  reason: collision with root package name */
    public EGLContext f37119f;

    /* renamed from: g  reason: collision with root package name */
    public EGLSurface f37120g;

    /* renamed from: h  reason: collision with root package name */
    public GL10 f37121h;

    /* renamed from: i  reason: collision with root package name */
    public int f37122i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f37123j;

    /* renamed from: k  reason: collision with root package name */
    public final ac f37124k;

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
        this.f37118e = EGL10.EGL_NO_DISPLAY;
        this.f37119f = EGL10.EGL_NO_CONTEXT;
        this.f37120g = EGL10.EGL_NO_SURFACE;
        this.f37122i = 1;
        this.f37123j = false;
        this.f37115b = surfaceTexture;
        this.f37116c = aVar;
        this.a = atomicBoolean;
        this.f37124k = acVar;
    }

    private boolean a(int i2, int i3, int i4, int i5, int i6, int i7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)})) == null) {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.f37117d = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.f37118e = eglGetDisplay;
            if (eglGetDisplay == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetdisplay failed : " + GLUtils.getEGLErrorString(this.f37117d.eglGetError()));
            } else if (!this.f37117d.eglInitialize(eglGetDisplay, new int[2])) {
                throw new RuntimeException("eglInitialize failed : " + GLUtils.getEGLErrorString(this.f37117d.eglGetError()));
            } else {
                EGLConfig[] eGLConfigArr = new EGLConfig[100];
                int[] iArr = new int[1];
                if (!this.f37117d.eglChooseConfig(this.f37118e, new int[]{12352, 4, MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, i2, MonitorType.MONITOR_TYPE_INIT_WEBKIT, i3, 12322, i4, 12321, i5, 12325, i6, 12326, i7, 12344}, eGLConfigArr, 100, iArr) || iArr[0] <= 0) {
                    return false;
                }
                this.f37119f = this.f37117d.eglCreateContext(this.f37118e, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
                EGLSurface eglCreateWindowSurface = this.f37117d.eglCreateWindowSurface(this.f37118e, eGLConfigArr[0], this.f37115b, null);
                this.f37120g = eglCreateWindowSurface;
                if (eglCreateWindowSurface == EGL10.EGL_NO_SURFACE || this.f37119f == EGL10.EGL_NO_CONTEXT) {
                    if (this.f37117d.eglGetError() == 12299) {
                        throw new RuntimeException("eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
                    }
                    GLUtils.getEGLErrorString(this.f37117d.eglGetError());
                }
                EGL10 egl102 = this.f37117d;
                EGLDisplay eGLDisplay = this.f37118e;
                EGLSurface eGLSurface = this.f37120g;
                if (egl102.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f37119f)) {
                    this.f37121h = (GL10) this.f37119f.getGL();
                    return true;
                }
                String eGLErrorString = GLUtils.getEGLErrorString(this.f37117d.eglGetError());
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
            if (this.f37124k.b() == null) {
                return;
            }
            MapRenderer.nativeInit(this.f37124k.b().f37085j);
            MapRenderer.nativeResize(this.f37124k.b().f37085j, ac.a, ac.f37052b);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            EGLSurface eGLSurface = this.f37120g;
            EGLSurface eGLSurface2 = EGL10.EGL_NO_SURFACE;
            if (eGLSurface != eGLSurface2) {
                this.f37117d.eglMakeCurrent(this.f37118e, eGLSurface2, eGLSurface2, EGL10.EGL_NO_CONTEXT);
                this.f37117d.eglDestroySurface(this.f37118e, this.f37120g);
                this.f37120g = EGL10.EGL_NO_SURFACE;
            }
            EGLContext eGLContext = this.f37119f;
            if (eGLContext != EGL10.EGL_NO_CONTEXT) {
                this.f37117d.eglDestroyContext(this.f37118e, eGLContext);
                this.f37119f = EGL10.EGL_NO_CONTEXT;
            }
            EGLDisplay eGLDisplay = this.f37118e;
            if (eGLDisplay != EGL10.EGL_NO_DISPLAY) {
                this.f37117d.eglTerminate(eGLDisplay);
                this.f37118e = EGL10.EGL_NO_DISPLAY;
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f37122i = 1;
            this.f37123j = false;
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
            this.f37122i = 0;
            synchronized (this) {
                this.f37123j = true;
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f37123j = true;
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
            while (this.f37116c != null) {
                if (this.f37122i != 1 || this.f37123j) {
                    try {
                        synchronized (this) {
                            wait();
                        }
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                } else if (this.f37124k.b() == null) {
                    break;
                } else {
                    synchronized (this.f37124k.b()) {
                        synchronized (this) {
                            if (!this.f37123j) {
                                this.f37122i = this.f37116c.a();
                            }
                        }
                        e b2 = this.f37124k.b();
                        if (b2 != null && b2.f37083h != null) {
                            for (l lVar : b2.f37083h) {
                                if (lVar != null) {
                                    ab J = b2.J();
                                    if (this.f37121h == null) {
                                        return;
                                    }
                                    if (lVar != null) {
                                        lVar.a(this.f37121h, J);
                                    }
                                }
                            }
                        }
                        this.f37117d.eglSwapBuffers(this.f37118e, this.f37120g);
                    }
                }
                if (this.f37123j) {
                    break;
                }
            }
            e();
        }
    }
}
