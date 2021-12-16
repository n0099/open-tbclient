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
    public SurfaceTexture f36959b;

    /* renamed from: c  reason: collision with root package name */
    public a f36960c;

    /* renamed from: d  reason: collision with root package name */
    public EGL10 f36961d;

    /* renamed from: e  reason: collision with root package name */
    public EGLDisplay f36962e;

    /* renamed from: f  reason: collision with root package name */
    public EGLContext f36963f;

    /* renamed from: g  reason: collision with root package name */
    public EGLSurface f36964g;

    /* renamed from: h  reason: collision with root package name */
    public GL10 f36965h;

    /* renamed from: i  reason: collision with root package name */
    public int f36966i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f36967j;

    /* renamed from: k  reason: collision with root package name */
    public final ac f36968k;

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
        this.f36962e = EGL10.EGL_NO_DISPLAY;
        this.f36963f = EGL10.EGL_NO_CONTEXT;
        this.f36964g = EGL10.EGL_NO_SURFACE;
        this.f36966i = 1;
        this.f36967j = false;
        this.f36959b = surfaceTexture;
        this.f36960c = aVar;
        this.a = atomicBoolean;
        this.f36968k = acVar;
    }

    private boolean a(int i2, int i3, int i4, int i5, int i6, int i7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)})) == null) {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.f36961d = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.f36962e = eglGetDisplay;
            if (eglGetDisplay == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetdisplay failed : " + GLUtils.getEGLErrorString(this.f36961d.eglGetError()));
            } else if (!this.f36961d.eglInitialize(eglGetDisplay, new int[2])) {
                throw new RuntimeException("eglInitialize failed : " + GLUtils.getEGLErrorString(this.f36961d.eglGetError()));
            } else {
                EGLConfig[] eGLConfigArr = new EGLConfig[100];
                int[] iArr = new int[1];
                if (!this.f36961d.eglChooseConfig(this.f36962e, new int[]{12352, 4, MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, i2, MonitorType.MONITOR_TYPE_INIT_WEBKIT, i3, 12322, i4, 12321, i5, 12325, i6, 12326, i7, 12344}, eGLConfigArr, 100, iArr) || iArr[0] <= 0) {
                    return false;
                }
                this.f36963f = this.f36961d.eglCreateContext(this.f36962e, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
                EGLSurface eglCreateWindowSurface = this.f36961d.eglCreateWindowSurface(this.f36962e, eGLConfigArr[0], this.f36959b, null);
                this.f36964g = eglCreateWindowSurface;
                if (eglCreateWindowSurface == EGL10.EGL_NO_SURFACE || this.f36963f == EGL10.EGL_NO_CONTEXT) {
                    if (this.f36961d.eglGetError() == 12299) {
                        throw new RuntimeException("eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
                    }
                    GLUtils.getEGLErrorString(this.f36961d.eglGetError());
                }
                EGL10 egl102 = this.f36961d;
                EGLDisplay eGLDisplay = this.f36962e;
                EGLSurface eGLSurface = this.f36964g;
                if (egl102.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f36963f)) {
                    this.f36965h = (GL10) this.f36963f.getGL();
                    return true;
                }
                String eGLErrorString = GLUtils.getEGLErrorString(this.f36961d.eglGetError());
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
            if (this.f36968k.b() == null) {
                return;
            }
            MapRenderer.nativeInit(this.f36968k.b().f36929j);
            MapRenderer.nativeResize(this.f36968k.b().f36929j, ac.a, ac.f36896b);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            EGLSurface eGLSurface = this.f36964g;
            EGLSurface eGLSurface2 = EGL10.EGL_NO_SURFACE;
            if (eGLSurface != eGLSurface2) {
                this.f36961d.eglMakeCurrent(this.f36962e, eGLSurface2, eGLSurface2, EGL10.EGL_NO_CONTEXT);
                this.f36961d.eglDestroySurface(this.f36962e, this.f36964g);
                this.f36964g = EGL10.EGL_NO_SURFACE;
            }
            EGLContext eGLContext = this.f36963f;
            if (eGLContext != EGL10.EGL_NO_CONTEXT) {
                this.f36961d.eglDestroyContext(this.f36962e, eGLContext);
                this.f36963f = EGL10.EGL_NO_CONTEXT;
            }
            EGLDisplay eGLDisplay = this.f36962e;
            if (eGLDisplay != EGL10.EGL_NO_DISPLAY) {
                this.f36961d.eglTerminate(eGLDisplay);
                this.f36962e = EGL10.EGL_NO_DISPLAY;
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f36966i = 1;
            this.f36967j = false;
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
            this.f36966i = 0;
            synchronized (this) {
                this.f36967j = true;
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f36967j = true;
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
            while (this.f36960c != null) {
                if (this.f36966i != 1 || this.f36967j) {
                    try {
                        synchronized (this) {
                            wait();
                        }
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                } else if (this.f36968k.b() == null) {
                    break;
                } else {
                    synchronized (this.f36968k.b()) {
                        synchronized (this) {
                            if (!this.f36967j) {
                                this.f36966i = this.f36960c.a();
                            }
                        }
                        e b2 = this.f36968k.b();
                        if (b2 != null && b2.f36927h != null) {
                            for (l lVar : b2.f36927h) {
                                if (lVar != null) {
                                    ab J = b2.J();
                                    if (this.f36965h == null) {
                                        return;
                                    }
                                    if (lVar != null) {
                                        lVar.a(this.f36965h, J);
                                    }
                                }
                            }
                        }
                        this.f36961d.eglSwapBuffers(this.f36962e, this.f36964g);
                    }
                }
                if (this.f36967j) {
                    break;
                }
            }
            e();
        }
    }
}
