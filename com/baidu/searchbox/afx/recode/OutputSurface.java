package com.baidu.searchbox.afx.recode;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.MonitorType;
import org.webrtc.EglBase10;
/* loaded from: classes2.dex */
public class OutputSurface implements SurfaceTexture.OnFrameAvailableListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "OutputSurface";
    public static final boolean VERBOSE = false;
    public transient /* synthetic */ FieldHolder $fh;
    public EGLContext mEGLContext;
    public EGLDisplay mEGLDisplay;
    public EGLSurface mEGLSurface;
    public boolean mFrameAvailable;
    public Object mFrameSyncObject;
    public Surface mSurface;
    public SurfaceTexture mSurfaceTexture;
    public TextureRender mTextureRender;

    public OutputSurface() {
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
        this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.mEGLContext = EGL14.EGL_NO_CONTEXT;
        this.mEGLSurface = EGL14.EGL_NO_SURFACE;
        this.mFrameSyncObject = new Object();
        setup();
    }

    private void setup() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            TextureRender textureRender = new TextureRender();
            this.mTextureRender = textureRender;
            textureRender.surfaceCreated();
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.mTextureRender.getTextureId());
            this.mSurfaceTexture = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(this);
            this.mSurface = new Surface(this.mSurfaceTexture);
        }
    }

    public void awaitNewImage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this.mFrameSyncObject) {
                while (!this.mFrameAvailable) {
                    try {
                        this.mFrameSyncObject.wait(500L);
                        if (!this.mFrameAvailable) {
                            throw new RuntimeException("Surface frame wait timed out");
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                this.mFrameAvailable = false;
            }
            this.mTextureRender.checkGlError("before updateTexImage");
            this.mSurfaceTexture.updateTexImage();
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
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
            this.mTextureRender = null;
            this.mSurface = null;
            this.mSurfaceTexture = null;
        }
    }

    public OutputSurface(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.mEGLContext = EGL14.EGL_NO_CONTEXT;
        this.mEGLSurface = EGL14.EGL_NO_SURFACE;
        this.mFrameSyncObject = new Object();
        if (i > 0 && i2 > 0) {
            eglSetup(i, i2);
            makeCurrent();
            setup();
            return;
        }
        throw new IllegalArgumentException();
    }

    private void checkEglError(String str) {
        int eglGetError;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, this, str) != null) || (eglGetError = EGL14.eglGetError()) == 12288) {
            return;
        }
        throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
    }

    public boolean checkForNewImage(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            synchronized (this.mFrameSyncObject) {
                do {
                    if (!this.mFrameAvailable) {
                        try {
                            this.mFrameSyncObject.wait(i);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        this.mFrameAvailable = false;
                        this.mTextureRender.checkGlError("before updateTexImage");
                        this.mSurfaceTexture.updateTexImage();
                        return true;
                    }
                } while (this.mFrameAvailable);
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    private void eglSetup(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65539, this, i, i2) == null) {
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.mEGLDisplay = eglGetDisplay;
            if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                int[] iArr = new int[2];
                if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[1];
                    if (EGL14.eglChooseConfig(this.mEGLDisplay, new int[]{MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, 12322, 8, 12352, 4, 12339, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                        this.mEGLContext = EGL14.eglCreateContext(this.mEGLDisplay, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 2, 12344}, 0);
                        checkEglError("eglCreateContext");
                        if (this.mEGLContext != null) {
                            this.mEGLSurface = EGL14.eglCreatePbufferSurface(this.mEGLDisplay, eGLConfigArr[0], new int[]{12375, i, 12374, i2, 12344}, 0);
                            checkEglError("eglCreatePbufferSurface");
                            if (this.mEGLSurface != null) {
                                return;
                            }
                            throw new RuntimeException("surface was null");
                        }
                        throw new RuntimeException("null context");
                    }
                    throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
                }
                this.mEGLDisplay = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            throw new RuntimeException("unable to get EGL14 display");
        }
    }

    public void changeFragmentShader(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.mTextureRender.changeFragmentShader(str);
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, surfaceTexture) == null) {
            synchronized (this.mFrameSyncObject) {
                if (!this.mFrameAvailable) {
                    this.mFrameAvailable = true;
                    this.mFrameSyncObject.notifyAll();
                } else {
                    throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
                }
            }
        }
    }

    public void drawImage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mTextureRender.drawFrame(this.mSurfaceTexture);
        }
    }

    public Surface getSurface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mSurface;
        }
        return (Surface) invokeV.objValue;
    }

    public void makeCurrent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            EGLDisplay eGLDisplay = this.mEGLDisplay;
            EGLSurface eGLSurface = this.mEGLSurface;
            if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.mEGLContext)) {
                return;
            }
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }
}
