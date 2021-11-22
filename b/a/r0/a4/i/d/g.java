package b.a.r0.a4.i.d;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.MonitorType;
import org.webrtc.EglBase10;
@TargetApi(18)
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public EGLDisplay f16005a;

    /* renamed from: b  reason: collision with root package name */
    public EGLContext f16006b;

    /* renamed from: c  reason: collision with root package name */
    public EGLSurface f16007c;

    /* renamed from: d  reason: collision with root package name */
    public Surface f16008d;

    public g(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {surface};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (surface != null) {
            this.f16008d = surface;
            b();
            return;
        }
        throw null;
    }

    public final void a(String str) {
        int eglGetError;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            boolean z = false;
            while (true) {
                if (EGL14.eglGetError() == 12288) {
                    break;
                }
                String str2 = str + ": EGL error: 0x" + Integer.toHexString(eglGetError);
                z = true;
            }
            if (z) {
                throw new RuntimeException("EGL error encountered (see log)");
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.f16005a = eglGetDisplay;
            if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                int[] iArr = new int[2];
                if (!EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                    this.f16005a = null;
                    throw new RuntimeException("unable to initialize EGL14");
                }
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                if (EGL14.eglChooseConfig(this.f16005a, new int[]{MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, 12322, 8, 12352, 4, 12610, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                    this.f16006b = EGL14.eglCreateContext(this.f16005a, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 2, 12344}, 0);
                    a("eglCreateContext");
                    if (this.f16006b != null) {
                        this.f16007c = EGL14.eglCreateWindowSurface(this.f16005a, eGLConfigArr[0], this.f16008d, new int[]{12344}, 0);
                        a("eglCreateWindowSurface");
                        if (this.f16007c == null) {
                            throw new RuntimeException("surface was null");
                        }
                        return;
                    }
                    throw new RuntimeException("null context");
                }
                throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
            }
            throw new RuntimeException("unable to get EGL14 display");
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            EGLDisplay eGLDisplay = this.f16005a;
            EGLSurface eGLSurface = this.f16007c;
            if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f16006b)) {
                throw new RuntimeException("eglMakeCurrent failed");
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (EGL14.eglGetCurrentContext().equals(this.f16006b)) {
                EGLDisplay eGLDisplay = this.f16005a;
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            }
            EGL14.eglDestroySurface(this.f16005a, this.f16007c);
            EGL14.eglDestroyContext(this.f16005a, this.f16006b);
            this.f16008d.release();
            this.f16005a = null;
            this.f16006b = null;
            this.f16007c = null;
            this.f16008d = null;
        }
    }

    public void e(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            EGLExt.eglPresentationTimeANDROID(this.f16005a, this.f16007c, j);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? EGL14.eglSwapBuffers(this.f16005a, this.f16007c) : invokeV.booleanValue;
    }
}
