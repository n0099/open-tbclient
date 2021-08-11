package c.a.w.b.d;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.ZeusMonitorType;
import org.webrtc.EglBase10;
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public EGLDisplay f30618a;

    /* renamed from: b  reason: collision with root package name */
    public EGLContext f30619b;

    /* renamed from: c  reason: collision with root package name */
    public EGLConfig f30620c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1863705328, "Lc/a/w/b/d/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1863705328, "Lc/a/w/b/d/a;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(EGLContext eGLContext, int i2) {
        this(eGLContext, i2, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eGLContext, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((EGLContext) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void a(String str) {
        int eglGetError;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (eglGetError = EGL14.eglGetError()) == 12288) {
            return;
        }
        throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
    }

    public EGLSurface b(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (!(obj instanceof Surface) && !(obj instanceof SurfaceTexture)) {
                throw new RuntimeException("invalid surface: " + obj);
            }
            EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.f30618a, this.f30620c, obj, new int[]{ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, 0);
            a("eglCreateWindowSurface");
            if (eglCreateWindowSurface != null) {
                return eglCreateWindowSurface;
            }
            throw new RuntimeException("surface was null");
        }
        return (EGLSurface) invokeL.objValue;
    }

    public final EGLConfig c(int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            int[] iArr = {ZeusMonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, ZeusMonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, ZeusMonitorType.MONITOR_TYPE_BACK_FORWARD_HIJACK, 8, ZeusMonitorType.MONITOR_TYPE_MAGICFILTER_ABORT_RESOURCE_COUNT, 8, ZeusMonitorType.MONITOR_TYPE_SUB_RESOURCE_SAFE, z ? 16 : 0, ZeusMonitorType.MONITOR_TYPE_NET_INJECT, 0, 12352, i3 >= 3 ? 68 : 4, ZeusMonitorType.MONITOR_TYPE_AD_FILTER, 0, ZeusMonitorType.MONITOR_TYPE_AD_FILTER};
            if ((i2 & 1) != 0) {
                iArr[14] = 12610;
                iArr[15] = 1;
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (!EGL14.eglChooseConfig(this.f30618a, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                String str = "unable to find RGB8888 / " + i3 + " EGLConfig";
                return null;
            }
            return eGLConfigArr[0];
        }
        return (EGLConfig) invokeCommon.objValue;
    }

    public boolean d(EGLSurface eGLSurface) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, eGLSurface)) == null) ? this.f30619b.equals(EGL14.eglGetCurrentContext()) && eGLSurface.equals(EGL14.eglGetCurrentSurface(12377)) : invokeL.booleanValue;
    }

    public void e(EGLSurface eGLSurface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eGLSurface) == null) {
            EGLDisplay eGLDisplay = this.f30618a;
            EGLDisplay eGLDisplay2 = EGL14.EGL_NO_DISPLAY;
            if (!EGL14.eglMakeCurrent(this.f30618a, eGLSurface, eGLSurface, this.f30619b)) {
                throw new RuntimeException("eglMakeCurrent failed");
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            EGLDisplay eGLDisplay = this.f30618a;
            if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
                EGL14.eglDestroyContext(this.f30618a, this.f30619b);
                EGL14.eglReleaseThread();
                EGL14.eglTerminate(this.f30618a);
            }
            this.f30618a = EGL14.EGL_NO_DISPLAY;
            this.f30619b = EGL14.EGL_NO_CONTEXT;
            this.f30620c = null;
        }
    }

    public void finalize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            try {
                if (this.f30618a != EGL14.EGL_NO_DISPLAY) {
                    f();
                }
            } finally {
                super.finalize();
            }
        }
    }

    public void g(EGLSurface eGLSurface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eGLSurface) == null) {
            EGL14.eglDestroySurface(this.f30618a, eGLSurface);
        }
    }

    public void h(EGLSurface eGLSurface, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, eGLSurface, j2) == null) {
            EGLExt.eglPresentationTimeANDROID(this.f30618a, eGLSurface, j2);
        }
    }

    public boolean i(EGLSurface eGLSurface) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, eGLSurface)) == null) ? EGL14.eglSwapBuffers(this.f30618a, eGLSurface) : invokeL.booleanValue;
    }

    public a(EGLContext eGLContext, int i2, boolean z) {
        int[] iArr;
        EGLConfig c2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eGLContext, Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        EGLDisplay eGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.f30618a = eGLDisplay;
        this.f30619b = EGL14.EGL_NO_CONTEXT;
        this.f30620c = null;
        if (eGLDisplay == EGL14.EGL_NO_DISPLAY) {
            eGLContext = eGLContext == null ? EGL14.EGL_NO_CONTEXT : eGLContext;
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.f30618a = eglGetDisplay;
            if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                int[] iArr2 = new int[2];
                if (EGL14.eglInitialize(eglGetDisplay, iArr2, 0, iArr2, 1)) {
                    if ((i2 & 2) != 0 && (c2 = c(i2, 3, z)) != null) {
                        EGLContext eglCreateContext = EGL14.eglCreateContext(this.f30618a, c2, eGLContext, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 3, ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, 0);
                        if (EGL14.eglGetError() == 12288) {
                            this.f30620c = c2;
                            this.f30619b = eglCreateContext;
                        }
                    }
                    if (this.f30619b == EGL14.EGL_NO_CONTEXT) {
                        EGLConfig c3 = c(i2, 2, z);
                        if (c3 != null) {
                            EGLContext eglCreateContext2 = EGL14.eglCreateContext(this.f30618a, c3, eGLContext, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 2, ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, 0);
                            a("eglCreateContext");
                            this.f30620c = c3;
                            this.f30619b = eglCreateContext2;
                        } else {
                            throw new RuntimeException("Unable to find a suitable EGLConfig");
                        }
                    }
                    EGL14.eglQueryContext(this.f30618a, this.f30619b, EglBase10.EGL_CONTEXT_CLIENT_VERSION, new int[1], 0);
                    String str = "EGLContext created, client version " + iArr[0];
                    return;
                }
                this.f30618a = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            throw new RuntimeException("unable to get EGL14 display");
        }
        throw new RuntimeException("EGL already set up");
    }
}
