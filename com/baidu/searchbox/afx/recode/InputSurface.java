package com.baidu.searchbox.afx.recode;

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
/* loaded from: classes10.dex */
public class InputSurface {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int EGL_RECORDABLE_ANDROID = 12610;
    public static final String TAG = "InputSurface";
    public transient /* synthetic */ FieldHolder $fh;
    public EGLContext mEGLContext;
    public EGLDisplay mEGLDisplay;
    public EGLSurface mEGLSurface;
    public Surface mSurface;

    public InputSurface(Surface surface) {
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
        this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.mEGLContext = EGL14.EGL_NO_CONTEXT;
        this.mEGLSurface = EGL14.EGL_NO_SURFACE;
        if (surface != null) {
            this.mSurface = surface;
            eglSetup();
            return;
        }
        throw null;
    }

    private void checkEglError(String str) {
        int eglGetError;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, str) == null) || (eglGetError = EGL14.eglGetError()) == 12288) {
            return;
        }
        throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
    }

    private void eglSetup() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.mEGLDisplay = eglGetDisplay;
            if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                int[] iArr = new int[2];
                if (!EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                    this.mEGLDisplay = null;
                    throw new RuntimeException("unable to initialize EGL14");
                }
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                if (EGL14.eglChooseConfig(this.mEGLDisplay, new int[]{MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, 12322, 8, 12352, 4, 12610, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                    this.mEGLContext = EGL14.eglCreateContext(this.mEGLDisplay, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 2, 12344}, 0);
                    checkEglError("eglCreateContext");
                    if (this.mEGLContext != null) {
                        this.mEGLSurface = EGL14.eglCreateWindowSurface(this.mEGLDisplay, eGLConfigArr[0], this.mSurface, new int[]{12344}, 0);
                        checkEglError("eglCreateWindowSurface");
                        if (this.mEGLSurface == null) {
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

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int[] iArr = new int[1];
            EGL14.eglQuerySurface(this.mEGLDisplay, this.mEGLSurface, 12374, iArr, 0);
            return iArr[0];
        }
        return invokeV.intValue;
    }

    public Surface getSurface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mSurface : (Surface) invokeV.objValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int[] iArr = new int[1];
            EGL14.eglQuerySurface(this.mEGLDisplay, this.mEGLSurface, 12375, iArr, 0);
            return iArr[0];
        }
        return invokeV.intValue;
    }

    public void makeCurrent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            EGLDisplay eGLDisplay = this.mEGLDisplay;
            EGLSurface eGLSurface = this.mEGLSurface;
            if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.mEGLContext)) {
                throw new RuntimeException("eglMakeCurrent failed");
            }
        }
    }

    public void makeUnCurrent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            EGLDisplay eGLDisplay = this.mEGLDisplay;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT)) {
                throw new RuntimeException("eglMakeCurrent failed");
            }
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            EGLDisplay eGLDisplay = this.mEGLDisplay;
            if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
                EGL14.eglDestroySurface(eGLDisplay, this.mEGLSurface);
                EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
                EGL14.eglReleaseThread();
                EGL14.eglTerminate(this.mEGLDisplay);
            }
            this.mSurface.release();
            this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
            this.mEGLContext = EGL14.EGL_NO_CONTEXT;
            this.mEGLSurface = EGL14.EGL_NO_SURFACE;
            this.mSurface = null;
        }
    }

    public void setPresentationTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            EGLExt.eglPresentationTimeANDROID(this.mEGLDisplay, this.mEGLSurface, j2);
        }
    }

    public boolean swapBuffers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? EGL14.eglSwapBuffers(this.mEGLDisplay, this.mEGLSurface) : invokeV.booleanValue;
    }
}
