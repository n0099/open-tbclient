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
/* loaded from: classes5.dex */
public class m extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f42331a;

    /* renamed from: b  reason: collision with root package name */
    public SurfaceTexture f42332b;

    /* renamed from: c  reason: collision with root package name */
    public a f42333c;

    /* renamed from: d  reason: collision with root package name */
    public EGL10 f42334d;

    /* renamed from: e  reason: collision with root package name */
    public EGLDisplay f42335e;

    /* renamed from: f  reason: collision with root package name */
    public EGLContext f42336f;

    /* renamed from: g  reason: collision with root package name */
    public EGLSurface f42337g;

    /* renamed from: h  reason: collision with root package name */
    public GL10 f42338h;

    /* renamed from: i  reason: collision with root package name */
    public int f42339i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f42340j;
    public final ac k;

    /* loaded from: classes5.dex */
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
        this.f42335e = EGL10.EGL_NO_DISPLAY;
        this.f42336f = EGL10.EGL_NO_CONTEXT;
        this.f42337g = EGL10.EGL_NO_SURFACE;
        this.f42339i = 1;
        this.f42340j = false;
        this.f42332b = surfaceTexture;
        this.f42333c = aVar;
        this.f42331a = atomicBoolean;
        this.k = acVar;
    }

    private boolean a(int i2, int i3, int i4, int i5, int i6, int i7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)})) == null) {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.f42334d = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.f42335e = eglGetDisplay;
            if (eglGetDisplay == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetdisplay failed : " + GLUtils.getEGLErrorString(this.f42334d.eglGetError()));
            } else if (!this.f42334d.eglInitialize(eglGetDisplay, new int[2])) {
                throw new RuntimeException("eglInitialize failed : " + GLUtils.getEGLErrorString(this.f42334d.eglGetError()));
            } else {
                EGLConfig[] eGLConfigArr = new EGLConfig[100];
                int[] iArr = new int[1];
                if (!this.f42334d.eglChooseConfig(this.f42335e, new int[]{12352, 4, ZeusMonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, i2, ZeusMonitorType.MONITOR_TYPE_INIT_WEBKIT, i3, ZeusMonitorType.MONITOR_TYPE_BACK_FORWARD_HIJACK, i4, ZeusMonitorType.MONITOR_TYPE_MAGICFILTER_ABORT_RESOURCE_COUNT, i5, ZeusMonitorType.MONITOR_TYPE_SUB_RESOURCE_SAFE, i6, ZeusMonitorType.MONITOR_TYPE_NET_INJECT, i7, ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, eGLConfigArr, 100, iArr) || iArr[0] <= 0) {
                    return false;
                }
                this.f42336f = this.f42334d.eglCreateContext(this.f42335e, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 2, ZeusMonitorType.MONITOR_TYPE_AD_FILTER});
                EGLSurface eglCreateWindowSurface = this.f42334d.eglCreateWindowSurface(this.f42335e, eGLConfigArr[0], this.f42332b, null);
                this.f42337g = eglCreateWindowSurface;
                if (eglCreateWindowSurface == EGL10.EGL_NO_SURFACE || this.f42336f == EGL10.EGL_NO_CONTEXT) {
                    if (this.f42334d.eglGetError() == 12299) {
                        throw new RuntimeException("eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
                    }
                    GLUtils.getEGLErrorString(this.f42334d.eglGetError());
                }
                EGL10 egl102 = this.f42334d;
                EGLDisplay eGLDisplay = this.f42335e;
                EGLSurface eGLSurface = this.f42337g;
                if (egl102.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f42336f)) {
                    this.f42338h = (GL10) this.f42336f.getGL();
                    return true;
                }
                String eGLErrorString = GLUtils.getEGLErrorString(this.f42334d.eglGetError());
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
            MapRenderer.nativeInit(this.k.b().f42297j);
            MapRenderer.nativeResize(this.k.b().f42297j, ac.f42259a, ac.f42260b);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            EGLSurface eGLSurface = this.f42337g;
            EGLSurface eGLSurface2 = EGL10.EGL_NO_SURFACE;
            if (eGLSurface != eGLSurface2) {
                this.f42334d.eglMakeCurrent(this.f42335e, eGLSurface2, eGLSurface2, EGL10.EGL_NO_CONTEXT);
                this.f42334d.eglDestroySurface(this.f42335e, this.f42337g);
                this.f42337g = EGL10.EGL_NO_SURFACE;
            }
            EGLContext eGLContext = this.f42336f;
            if (eGLContext != EGL10.EGL_NO_CONTEXT) {
                this.f42334d.eglDestroyContext(this.f42335e, eGLContext);
                this.f42336f = EGL10.EGL_NO_CONTEXT;
            }
            EGLDisplay eGLDisplay = this.f42335e;
            if (eGLDisplay != EGL10.EGL_NO_DISPLAY) {
                this.f42334d.eglTerminate(eGLDisplay);
                this.f42335e = EGL10.EGL_NO_DISPLAY;
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f42339i = 1;
            this.f42340j = false;
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
            this.f42339i = 0;
            synchronized (this) {
                this.f42340j = true;
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f42340j = true;
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
            while (this.f42333c != null) {
                if (this.f42339i != 1 || this.f42340j) {
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
                            if (!this.f42340j) {
                                this.f42339i = this.f42333c.a();
                            }
                        }
                        e b2 = this.k.b();
                        if (b2 != null && b2.f42295h != null) {
                            for (l lVar : b2.f42295h) {
                                if (lVar != null) {
                                    ab J = b2.J();
                                    if (this.f42338h == null) {
                                        return;
                                    }
                                    if (lVar != null) {
                                        lVar.a(this.f42338h, J);
                                    }
                                }
                            }
                        }
                        this.f42334d.eglSwapBuffers(this.f42335e, this.f42337g);
                    }
                }
                if (this.f42340j) {
                    break;
                }
            }
            e();
        }
    }
}
