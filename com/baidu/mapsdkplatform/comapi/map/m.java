package com.baidu.mapsdkplatform.comapi.map;

import android.annotation.SuppressLint;
import android.graphics.SurfaceTexture;
import android.opengl.GLUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.ZeusMonitorType;
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
/* loaded from: classes3.dex */
public class m extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f7731a;

    /* renamed from: b  reason: collision with root package name */
    public SurfaceTexture f7732b;

    /* renamed from: c  reason: collision with root package name */
    public a f7733c;

    /* renamed from: d  reason: collision with root package name */
    public EGL10 f7734d;

    /* renamed from: e  reason: collision with root package name */
    public EGLDisplay f7735e;

    /* renamed from: f  reason: collision with root package name */
    public EGLContext f7736f;

    /* renamed from: g  reason: collision with root package name */
    public EGLSurface f7737g;

    /* renamed from: h  reason: collision with root package name */
    public GL10 f7738h;

    /* renamed from: i  reason: collision with root package name */
    public int f7739i;
    public boolean j;
    public final ac k;

    /* loaded from: classes3.dex */
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
        this.f7735e = EGL10.EGL_NO_DISPLAY;
        this.f7736f = EGL10.EGL_NO_CONTEXT;
        this.f7737g = EGL10.EGL_NO_SURFACE;
        this.f7739i = 1;
        this.j = false;
        this.f7732b = surfaceTexture;
        this.f7733c = aVar;
        this.f7731a = atomicBoolean;
        this.k = acVar;
    }

    private boolean a(int i2, int i3, int i4, int i5, int i6, int i7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)})) == null) {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.f7734d = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.f7735e = eglGetDisplay;
            if (eglGetDisplay == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetdisplay failed : " + GLUtils.getEGLErrorString(this.f7734d.eglGetError()));
            } else if (!this.f7734d.eglInitialize(eglGetDisplay, new int[2])) {
                throw new RuntimeException("eglInitialize failed : " + GLUtils.getEGLErrorString(this.f7734d.eglGetError()));
            } else {
                EGLConfig[] eGLConfigArr = new EGLConfig[100];
                int[] iArr = new int[1];
                if (!this.f7734d.eglChooseConfig(this.f7735e, new int[]{12352, 4, ZeusMonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, i2, ZeusMonitorType.MONITOR_TYPE_INIT_WEBKIT, i3, ZeusMonitorType.MONITOR_TYPE_BACK_FORWARD_HIJACK, i4, ZeusMonitorType.MONITOR_TYPE_MAGICFILTER_ABORT_RESOURCE_COUNT, i5, ZeusMonitorType.MONITOR_TYPE_SUB_RESOURCE_SAFE, i6, ZeusMonitorType.MONITOR_TYPE_NET_INJECT, i7, ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, eGLConfigArr, 100, iArr) || iArr[0] <= 0) {
                    return false;
                }
                this.f7736f = this.f7734d.eglCreateContext(this.f7735e, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 2, ZeusMonitorType.MONITOR_TYPE_AD_FILTER});
                EGLSurface eglCreateWindowSurface = this.f7734d.eglCreateWindowSurface(this.f7735e, eGLConfigArr[0], this.f7732b, null);
                this.f7737g = eglCreateWindowSurface;
                if (eglCreateWindowSurface == EGL10.EGL_NO_SURFACE || this.f7736f == EGL10.EGL_NO_CONTEXT) {
                    if (this.f7734d.eglGetError() == 12299) {
                        throw new RuntimeException("eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
                    }
                    GLUtils.getEGLErrorString(this.f7734d.eglGetError());
                }
                EGL10 egl102 = this.f7734d;
                EGLDisplay eGLDisplay = this.f7735e;
                EGLSurface eGLSurface = this.f7737g;
                if (egl102.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f7736f)) {
                    this.f7738h = (GL10) this.f7736f.getGL();
                    return true;
                }
                String eGLErrorString = GLUtils.getEGLErrorString(this.f7734d.eglGetError());
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
            return egl10.eglChooseConfig(eglGetDisplay, new int[]{ZeusMonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, i2, ZeusMonitorType.MONITOR_TYPE_INIT_WEBKIT, i3, ZeusMonitorType.MONITOR_TYPE_BACK_FORWARD_HIJACK, i4, ZeusMonitorType.MONITOR_TYPE_MAGICFILTER_ABORT_RESOURCE_COUNT, i5, ZeusMonitorType.MONITOR_TYPE_SUB_RESOURCE_SAFE, i6, ZeusMonitorType.MONITOR_TYPE_NET_INJECT, i7, ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, new EGLConfig[100], 100, iArr) && iArr[0] > 0;
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
            MapRenderer.nativeResize(this.k.b().j, ac.f7662a, ac.f7663b);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            EGLSurface eGLSurface = this.f7737g;
            EGLSurface eGLSurface2 = EGL10.EGL_NO_SURFACE;
            if (eGLSurface != eGLSurface2) {
                this.f7734d.eglMakeCurrent(this.f7735e, eGLSurface2, eGLSurface2, EGL10.EGL_NO_CONTEXT);
                this.f7734d.eglDestroySurface(this.f7735e, this.f7737g);
                this.f7737g = EGL10.EGL_NO_SURFACE;
            }
            EGLContext eGLContext = this.f7736f;
            if (eGLContext != EGL10.EGL_NO_CONTEXT) {
                this.f7734d.eglDestroyContext(this.f7735e, eGLContext);
                this.f7736f = EGL10.EGL_NO_CONTEXT;
            }
            EGLDisplay eGLDisplay = this.f7735e;
            if (eGLDisplay != EGL10.EGL_NO_DISPLAY) {
                this.f7734d.eglTerminate(eGLDisplay);
                this.f7735e = EGL10.EGL_NO_DISPLAY;
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f7739i = 1;
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
            this.f7739i = 0;
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
            while (this.f7733c != null) {
                if (this.f7739i != 1 || this.j) {
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
                                this.f7739i = this.f7733c.a();
                            }
                        }
                        e b2 = this.k.b();
                        if (b2 != null && b2.f7697h != null) {
                            for (l lVar : b2.f7697h) {
                                if (lVar != null) {
                                    ab J = b2.J();
                                    if (this.f7738h == null) {
                                        return;
                                    }
                                    if (lVar != null) {
                                        lVar.a(this.f7738h, J);
                                    }
                                }
                            }
                        }
                        this.f7734d.eglSwapBuffers(this.f7735e, this.f7737g);
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
