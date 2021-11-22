package com.baidu.searchbox.afx.gl;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.MonitorType;
import com.heytap.mcssdk.mode.CommandMessage;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;
import org.webrtc.EglBase10;
/* loaded from: classes7.dex */
public class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener, View.OnLayoutChangeListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int DEBUG_CHECK_GL_ERROR = 1;
    public static final int DEBUG_LOG_GL_CALLS = 2;
    public static final boolean LOG_ATTACH_DETACH = false;
    public static final boolean LOG_EGL = false;
    public static final boolean LOG_PAUSE_RESUME = false;
    public static final boolean LOG_RENDERER = false;
    public static final boolean LOG_RENDERER_DRAW_FRAME = false;
    public static final boolean LOG_SURFACE = false;
    public static final boolean LOG_THREADS = false;
    public static final int RENDERMODE_CONTINUOUSLY = 1;
    public static final int RENDERMODE_WHEN_DIRTY = 0;
    public static final String TAG = "GLTextureView";
    public static final GLThreadManager sGLThreadManager;
    public transient /* synthetic */ FieldHolder $fh;
    public int mDebugFlags;
    public boolean mDetached;
    public EGLConfigChooser mEGLConfigChooser;
    public int mEGLContextClientVersion;
    public EGLContextFactory mEGLContextFactory;
    public EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
    public GLThread mGLThread;
    public GLWrapper mGLWrapper;
    public boolean mPreserveEGLContextOnPause;
    public Renderer mRenderer;
    public final WeakReference<GLTextureView> mThisWeakRef;

    /* renamed from: com.baidu.searchbox.afx.gl.GLTextureView$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public abstract class BaseConfigChooser implements EGLConfigChooser {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int[] mConfigSpec;
        public final /* synthetic */ GLTextureView this$0;

        public BaseConfigChooser(GLTextureView gLTextureView, int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gLTextureView, iArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = gLTextureView;
            this.mConfigSpec = filterConfigSpec(iArr);
        }

        private int[] filterConfigSpec(int[] iArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, iArr)) == null) {
                if (this.this$0.mEGLContextClientVersion != 2) {
                    return iArr;
                }
                int length = iArr.length;
                int[] iArr2 = new int[length + 2];
                int i2 = length - 1;
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                iArr2[i2] = 12352;
                iArr2[length] = 4;
                iArr2[length + 1] = 12344;
                return iArr2;
            }
            return (int[]) invokeL.objValue;
        }

        @Override // com.baidu.searchbox.afx.gl.GLTextureView.EGLConfigChooser
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, egl10, eGLDisplay)) == null) {
                int[] iArr = new int[1];
                if (egl10.eglChooseConfig(eGLDisplay, this.mConfigSpec, null, 0, iArr)) {
                    int i2 = iArr[0];
                    if (i2 > 0) {
                        EGLConfig[] eGLConfigArr = new EGLConfig[i2];
                        if (egl10.eglChooseConfig(eGLDisplay, this.mConfigSpec, eGLConfigArr, i2, iArr)) {
                            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
                            if (chooseConfig != null) {
                                return chooseConfig;
                            }
                            throw new IllegalArgumentException("No config chosen");
                        }
                        throw new IllegalArgumentException("eglChooseConfig#2 failed");
                    }
                    throw new IllegalArgumentException("No configs match configSpec");
                }
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            return (EGLConfig) invokeLL.objValue;
        }

        public abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);
    }

    /* loaded from: classes7.dex */
    public class ComponentSizeChooser extends BaseConfigChooser {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mAlphaSize;
        public int mBlueSize;
        public int mDepthSize;
        public int mGreenSize;
        public int mRedSize;
        public int mStencilSize;
        public int[] mValue;
        public final /* synthetic */ GLTextureView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ComponentSizeChooser(GLTextureView gLTextureView, int i2, int i3, int i4, int i5, int i6, int i7) {
            super(gLTextureView, new int[]{MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, i2, MonitorType.MONITOR_TYPE_INIT_WEBKIT, i3, 12322, i4, 12321, i5, 12325, i6, 12326, i7, 12344});
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gLTextureView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i8 = newInitContext.flag;
                if ((i8 & 1) != 0) {
                    int i9 = i8 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((GLTextureView) objArr2[0], (int[]) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = gLTextureView;
            this.mValue = new int[1];
            this.mRedSize = i2;
            this.mGreenSize = i3;
            this.mBlueSize = i4;
            this.mAlphaSize = i5;
            this.mDepthSize = i6;
            this.mStencilSize = i7;
        }

        private int findConfigAttrib(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2, int i3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{egl10, eGLDisplay, eGLConfig, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) ? egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, this.mValue) ? this.mValue[0] : i3 : invokeCommon.intValue;
        }

        @Override // com.baidu.searchbox.afx.gl.GLTextureView.BaseConfigChooser
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, egl10, eGLDisplay, eGLConfigArr)) == null) {
                for (EGLConfig eGLConfig : eGLConfigArr) {
                    int findConfigAttrib = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12325, 0);
                    int findConfigAttrib2 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12326, 0);
                    if (findConfigAttrib >= this.mDepthSize && findConfigAttrib2 >= this.mStencilSize) {
                        int findConfigAttrib3 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 0);
                        int findConfigAttrib4 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 0);
                        int findConfigAttrib5 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12322, 0);
                        int findConfigAttrib6 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12321, 0);
                        if (findConfigAttrib3 == this.mRedSize && findConfigAttrib4 == this.mGreenSize && findConfigAttrib5 == this.mBlueSize && findConfigAttrib6 == this.mAlphaSize) {
                            return eGLConfig;
                        }
                    }
                }
                return null;
            }
            return (EGLConfig) invokeLLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class DefaultWindowSurfaceFactory implements EGLWindowSurfaceFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public DefaultWindowSurfaceFactory() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.searchbox.afx.gl.GLTextureView.EGLWindowSurfaceFactory
        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, egl10, eGLDisplay, eGLConfig, obj)) == null) {
                try {
                    return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
                } catch (IllegalArgumentException unused) {
                    return null;
                }
            }
            return (EGLSurface) invokeLLLL.objValue;
        }

        @Override // com.baidu.searchbox.afx.gl.GLTextureView.EGLWindowSurfaceFactory
        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, egl10, eGLDisplay, eGLSurface) == null) {
                egl10.eglDestroySurface(eGLDisplay, eGLSurface);
            }
        }

        public /* synthetic */ DefaultWindowSurfaceFactory(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public interface EGLConfigChooser {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* loaded from: classes7.dex */
    public interface EGLContextFactory {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* loaded from: classes7.dex */
    public interface EGLWindowSurfaceFactory {
        EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* loaded from: classes7.dex */
    public static class EglHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public EGL10 mEgl;
        public EGLConfig mEglConfig;
        public EGLContext mEglContext;
        public EGLDisplay mEglDisplay;
        public EGLSurface mEglSurface;
        public WeakReference<GLTextureView> mGLSurfaceViewWeakRef;

        public EglHelper(WeakReference<GLTextureView> weakReference) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {weakReference};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mGLSurfaceViewWeakRef = weakReference;
        }

        private void destroySurfaceImp() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (eGLSurface = this.mEglSurface) == null || eGLSurface == (eGLSurface2 = EGL10.EGL_NO_SURFACE)) {
                return;
            }
            this.mEgl.eglMakeCurrent(this.mEglDisplay, eGLSurface2, eGLSurface2, EGL10.EGL_NO_CONTEXT);
            GLTextureView gLTextureView = this.mGLSurfaceViewWeakRef.get();
            if (gLTextureView != null) {
                gLTextureView.mEGLWindowSurfaceFactory.destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
            }
            this.mEglSurface = null;
        }

        public static String formatEglError(String str, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i2)) == null) {
                return str + " failed: " + i2;
            }
            return (String) invokeLI.objValue;
        }

        public static void logEglErrorAsWarning(String str, String str2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(65539, null, str, str2, i2) == null) {
                formatEglError(str2, i2);
            }
        }

        private void throwEglException(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
                throwEglException(str, this.mEgl.eglGetError());
            }
        }

        public GL createGL() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                GL gl = this.mEglContext.getGL();
                GLTextureView gLTextureView = this.mGLSurfaceViewWeakRef.get();
                if (gLTextureView != null) {
                    if (gLTextureView.mGLWrapper != null) {
                        gl = gLTextureView.mGLWrapper.wrap(gl);
                    }
                    if ((gLTextureView.mDebugFlags & 3) != 0) {
                        return GLDebugHelper.wrap(gl, (gLTextureView.mDebugFlags & 1) != 0 ? 1 : 0, (gLTextureView.mDebugFlags & 2) != 0 ? new LogWriter() : null);
                    }
                    return gl;
                }
                return gl;
            }
            return (GL) invokeV.objValue;
        }

        public boolean createSurface() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.mEgl != null) {
                    if (this.mEglDisplay != null) {
                        if (this.mEglConfig != null) {
                            destroySurfaceImp();
                            GLTextureView gLTextureView = this.mGLSurfaceViewWeakRef.get();
                            if (gLTextureView != null) {
                                this.mEglSurface = gLTextureView.mEGLWindowSurfaceFactory.createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, gLTextureView.getSurfaceTexture());
                            } else {
                                this.mEglSurface = null;
                            }
                            EGLSurface eGLSurface = this.mEglSurface;
                            if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
                                if (this.mEgl.eglMakeCurrent(this.mEglDisplay, eGLSurface, eGLSurface, this.mEglContext)) {
                                    return true;
                                }
                                logEglErrorAsWarning("EGLHelper", "eglMakeCurrent", this.mEgl.eglGetError());
                                return false;
                            }
                            this.mEgl.eglGetError();
                            return false;
                        }
                        throw new RuntimeException("mEglConfig not initialized");
                    }
                    throw new RuntimeException("eglDisplay not initialized");
                }
                throw new RuntimeException("egl not initialized");
            }
            return invokeV.booleanValue;
        }

        public void destroySurface() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                destroySurfaceImp();
            }
        }

        public void finish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.mEglContext != null) {
                    GLTextureView gLTextureView = this.mGLSurfaceViewWeakRef.get();
                    if (gLTextureView != null) {
                        gLTextureView.mEGLContextFactory.destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
                    }
                    this.mEglContext = null;
                }
                EGLDisplay eGLDisplay = this.mEglDisplay;
                if (eGLDisplay != null) {
                    this.mEgl.eglTerminate(eGLDisplay);
                    this.mEglDisplay = null;
                }
            }
        }

        public void start() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                EGL10 egl10 = (EGL10) EGLContext.getEGL();
                this.mEgl = egl10;
                EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
                this.mEglDisplay = eglGetDisplay;
                if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                    if (this.mEgl.eglInitialize(eglGetDisplay, new int[2])) {
                        GLTextureView gLTextureView = this.mGLSurfaceViewWeakRef.get();
                        if (gLTextureView != null) {
                            this.mEglConfig = gLTextureView.mEGLConfigChooser.chooseConfig(this.mEgl, this.mEglDisplay);
                            this.mEglContext = gLTextureView.mEGLContextFactory.createContext(this.mEgl, this.mEglDisplay, this.mEglConfig);
                        } else {
                            this.mEglConfig = null;
                            this.mEglContext = null;
                        }
                        EGLContext eGLContext = this.mEglContext;
                        if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                            this.mEglContext = null;
                            throwEglException("createContext");
                        }
                        this.mEglSurface = null;
                        return;
                    }
                    throw new RuntimeException("eglInitialize failed");
                }
                throw new RuntimeException("eglGetDisplay failed");
            }
        }

        public int swap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? !this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface) ? this.mEgl.eglGetError() : CommandMessage.COMMAND_BASE : invokeV.intValue;
        }

        public static void throwEglException(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, str, i2) == null) {
                throw new RuntimeException(formatEglError(str, i2));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class GLThread extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public EglHelper mEglHelper;
        public ArrayList<Runnable> mEventQueue;
        public boolean mExited;
        public WeakReference<GLTextureView> mGLSurfaceViewWeakRef;
        public boolean mHasSurface;
        public boolean mHaveEglContext;
        public boolean mHaveEglSurface;
        public int mHeight;
        public boolean mPaused;
        public boolean mRenderComplete;
        public int mRenderMode;
        public boolean mRequestPaused;
        public boolean mRequestRender;
        public boolean mShouldExit;
        public boolean mShouldReleaseEglContext;
        public boolean mSizeChanged;
        public boolean mSurfaceIsBad;
        public boolean mWaitingForSurface;
        public int mWidth;

        public GLThread(WeakReference<GLTextureView> weakReference) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {weakReference};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mEventQueue = new ArrayList<>();
            this.mSizeChanged = true;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mRequestRender = true;
            this.mRenderMode = 1;
            this.mGLSurfaceViewWeakRef = weakReference;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void guardedRun() throws InterruptedException {
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(65538, this) != null) {
                return;
            }
            this.mEglHelper = new EglHelper(this.mGLSurfaceViewWeakRef);
            this.mHaveEglContext = false;
            this.mHaveEglSurface = false;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            GL10 gl10 = null;
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            boolean z9 = false;
            int i2 = 0;
            int i3 = 0;
            boolean z10 = false;
            while (true) {
                Runnable runnable = null;
                while (true) {
                    try {
                        synchronized (GLTextureView.sGLThreadManager) {
                            while (!this.mShouldExit) {
                                if (!this.mEventQueue.isEmpty()) {
                                    runnable = this.mEventQueue.remove(0);
                                } else {
                                    if (this.mPaused != this.mRequestPaused) {
                                        z = this.mRequestPaused;
                                        this.mPaused = this.mRequestPaused;
                                        GLTextureView.sGLThreadManager.notifyAll();
                                    } else {
                                        z = false;
                                    }
                                    if (this.mShouldReleaseEglContext) {
                                        stopEglSurfaceLocked();
                                        stopEglContextLocked();
                                        this.mShouldReleaseEglContext = false;
                                        z5 = true;
                                    }
                                    if (z3) {
                                        stopEglSurfaceLocked();
                                        stopEglContextLocked();
                                        z3 = false;
                                    }
                                    if (z && this.mHaveEglSurface) {
                                        stopEglSurfaceLocked();
                                    }
                                    if (z && this.mHaveEglContext) {
                                        GLTextureView gLTextureView = this.mGLSurfaceViewWeakRef.get();
                                        if (!(gLTextureView == null ? false : gLTextureView.mPreserveEGLContextOnPause) || GLTextureView.sGLThreadManager.shouldReleaseEGLContextWhenPausing()) {
                                            stopEglContextLocked();
                                        }
                                    }
                                    if (z && GLTextureView.sGLThreadManager.shouldTerminateEGLWhenPausing()) {
                                        this.mEglHelper.finish();
                                    }
                                    if (!this.mHasSurface && !this.mWaitingForSurface) {
                                        if (this.mHaveEglSurface) {
                                            stopEglSurfaceLocked();
                                        }
                                        this.mWaitingForSurface = true;
                                        this.mSurfaceIsBad = false;
                                        GLTextureView.sGLThreadManager.notifyAll();
                                    }
                                    if (this.mHasSurface && this.mWaitingForSurface) {
                                        this.mWaitingForSurface = false;
                                        GLTextureView.sGLThreadManager.notifyAll();
                                    }
                                    if (z4) {
                                        this.mRenderComplete = true;
                                        GLTextureView.sGLThreadManager.notifyAll();
                                        z4 = false;
                                        z10 = false;
                                    }
                                    if (readyToDraw()) {
                                        if (!this.mHaveEglContext) {
                                            if (z5) {
                                                z5 = false;
                                            } else if (GLTextureView.sGLThreadManager.tryAcquireEglContextLocked(this)) {
                                                try {
                                                    this.mEglHelper.start();
                                                    this.mHaveEglContext = true;
                                                    GLTextureView.sGLThreadManager.notifyAll();
                                                    z6 = true;
                                                } catch (RuntimeException e2) {
                                                    GLTextureView.sGLThreadManager.releaseEglContextLocked(this);
                                                    throw e2;
                                                }
                                            }
                                        }
                                        if (this.mHaveEglContext && !this.mHaveEglSurface) {
                                            this.mHaveEglSurface = true;
                                            z7 = true;
                                            z8 = true;
                                            z9 = true;
                                        }
                                        if (this.mHaveEglSurface) {
                                            if (this.mSizeChanged) {
                                                int i4 = this.mWidth;
                                                int i5 = this.mHeight;
                                                this.mSizeChanged = false;
                                                i2 = i4;
                                                i3 = i5;
                                                z2 = false;
                                                z7 = true;
                                                z9 = true;
                                                z10 = true;
                                            } else {
                                                z2 = false;
                                            }
                                            this.mRequestRender = z2;
                                            GLTextureView.sGLThreadManager.notifyAll();
                                        }
                                    }
                                    GLTextureView.sGLThreadManager.wait();
                                }
                            }
                            synchronized (GLTextureView.sGLThreadManager) {
                                stopEglSurfaceLocked();
                                stopEglContextLocked();
                            }
                            return;
                        }
                        if (runnable != null) {
                            break;
                        }
                        if (z7) {
                            if (this.mEglHelper.createSurface()) {
                                z7 = false;
                            } else {
                                synchronized (GLTextureView.sGLThreadManager) {
                                    this.mSurfaceIsBad = true;
                                    GLTextureView.sGLThreadManager.notifyAll();
                                }
                            }
                        }
                        if (z8) {
                            gl10 = (GL10) this.mEglHelper.createGL();
                            GLTextureView.sGLThreadManager.checkGLDriver(gl10);
                            z8 = false;
                        }
                        if (z6) {
                            GLTextureView gLTextureView2 = this.mGLSurfaceViewWeakRef.get();
                            if (gLTextureView2 != null) {
                                gLTextureView2.mRenderer.onSurfaceCreated(gl10, this.mEglHelper.mEglConfig);
                            }
                            z6 = false;
                        }
                        if (z9) {
                            GLTextureView gLTextureView3 = this.mGLSurfaceViewWeakRef.get();
                            if (gLTextureView3 != null) {
                                gLTextureView3.mRenderer.onSurfaceChanged(gl10, i2, i3);
                            }
                            z9 = false;
                        }
                        GLTextureView gLTextureView4 = this.mGLSurfaceViewWeakRef.get();
                        if (gLTextureView4 != null) {
                            gLTextureView4.mRenderer.onDrawFrame(gl10);
                        }
                        int swap = this.mEglHelper.swap();
                        if (swap != 12288) {
                            if (swap != 12302) {
                                EglHelper.logEglErrorAsWarning("GLThread", "eglSwapBuffers", swap);
                                synchronized (GLTextureView.sGLThreadManager) {
                                    this.mSurfaceIsBad = true;
                                    GLTextureView.sGLThreadManager.notifyAll();
                                }
                            } else {
                                z3 = true;
                            }
                        }
                        if (z10) {
                            z4 = true;
                        }
                    } catch (Throwable th) {
                        synchronized (GLTextureView.sGLThreadManager) {
                            stopEglSurfaceLocked();
                            stopEglContextLocked();
                            throw th;
                        }
                    }
                }
                runnable.run();
            }
        }

        private boolean readyToDraw() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? !this.mPaused && this.mHasSurface && !this.mSurfaceIsBad && this.mWidth > 0 && this.mHeight > 0 && (this.mRequestRender || this.mRenderMode == 1) : invokeV.booleanValue;
        }

        private void stopEglContextLocked() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && this.mHaveEglContext) {
                this.mEglHelper.finish();
                this.mHaveEglContext = false;
                GLTextureView.sGLThreadManager.releaseEglContextLocked(this);
            }
        }

        private void stopEglSurfaceLocked() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) && this.mHaveEglSurface) {
                this.mHaveEglSurface = false;
                this.mEglHelper.destroySurface();
            }
        }

        public boolean ableToDraw() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mHaveEglContext && this.mHaveEglSurface && readyToDraw() : invokeV.booleanValue;
        }

        public int getRenderMode() {
            InterceptResult invokeV;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                synchronized (GLTextureView.sGLThreadManager) {
                    i2 = this.mRenderMode;
                }
                return i2;
            }
            return invokeV.intValue;
        }

        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (GLTextureView.sGLThreadManager) {
                    this.mRequestPaused = true;
                    GLTextureView.sGLThreadManager.notifyAll();
                    while (!this.mExited && !this.mPaused) {
                        try {
                            GLTextureView.sGLThreadManager.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                synchronized (GLTextureView.sGLThreadManager) {
                    this.mRequestPaused = false;
                    this.mRequestRender = true;
                    this.mRenderComplete = false;
                    GLTextureView.sGLThreadManager.notifyAll();
                    while (!this.mExited && this.mPaused && !this.mRenderComplete) {
                        try {
                            GLTextureView.sGLThreadManager.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void onWindowResize(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
                synchronized (GLTextureView.sGLThreadManager) {
                    this.mWidth = i2;
                    this.mHeight = i3;
                    this.mSizeChanged = true;
                    this.mRequestRender = true;
                    this.mRenderComplete = false;
                    GLTextureView.sGLThreadManager.notifyAll();
                    while (!this.mExited && !this.mPaused && !this.mRenderComplete && ableToDraw()) {
                        try {
                            GLTextureView.sGLThreadManager.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void queueEvent(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, runnable) == null) {
                if (runnable != null) {
                    synchronized (GLTextureView.sGLThreadManager) {
                        this.mEventQueue.add(runnable);
                        GLTextureView.sGLThreadManager.notifyAll();
                    }
                    return;
                }
                throw new IllegalArgumentException("r must not be null");
            }
        }

        public void requestExitAndWait() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                synchronized (GLTextureView.sGLThreadManager) {
                    this.mShouldExit = true;
                    GLTextureView.sGLThreadManager.notifyAll();
                    while (!this.mExited) {
                        try {
                            GLTextureView.sGLThreadManager.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void requestReleaseEglContextLocked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.mShouldReleaseEglContext = true;
                GLTextureView.sGLThreadManager.notifyAll();
            }
        }

        public void requestRender() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                synchronized (GLTextureView.sGLThreadManager) {
                    this.mRequestRender = true;
                    GLTextureView.sGLThreadManager.notifyAll();
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                setName("GLThread " + getId());
                try {
                    try {
                        guardedRun();
                    } catch (InterruptedException unused) {
                    } catch (RuntimeException e2) {
                        e2.printStackTrace();
                    }
                } finally {
                    GLTextureView.sGLThreadManager.threadExiting(this);
                }
            }
        }

        public void setRenderMode(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
                if (i2 >= 0 && i2 <= 1) {
                    synchronized (GLTextureView.sGLThreadManager) {
                        this.mRenderMode = i2;
                        GLTextureView.sGLThreadManager.notifyAll();
                    }
                    return;
                }
                throw new IllegalArgumentException("renderMode");
            }
        }

        public void surfaceCreated() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                synchronized (GLTextureView.sGLThreadManager) {
                    this.mHasSurface = true;
                    GLTextureView.sGLThreadManager.notifyAll();
                    while (this.mWaitingForSurface && !this.mExited) {
                        try {
                            GLTextureView.sGLThreadManager.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
                synchronized (GLTextureView.sGLThreadManager) {
                    this.mHasSurface = false;
                    GLTextureView.sGLThreadManager.notifyAll();
                    while (!this.mWaitingForSurface && !this.mExited) {
                        try {
                            GLTextureView.sGLThreadManager.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class GLThreadManager {
        public static /* synthetic */ Interceptable $ic = null;
        public static String TAG = "GLThreadManager";
        public static final int kGLES_20 = 131072;
        public static final String kMSM7K_RENDERER_PREFIX = "Q3Dimension MSM7500 ";
        public transient /* synthetic */ FieldHolder $fh;
        public GLThread mEglOwner;
        public boolean mGLESDriverCheckComplete;
        public int mGLESVersion;
        public boolean mGLESVersionCheckComplete;
        public boolean mLimitedGLESContexts;
        public boolean mMultipleGLESContextsAllowed;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(883248506, "Lcom/baidu/searchbox/afx/gl/GLTextureView$GLThreadManager;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(883248506, "Lcom/baidu/searchbox/afx/gl/GLTextureView$GLThreadManager;");
            }
        }

        public GLThreadManager() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        private void checkGLESVersion() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.mGLESVersionCheckComplete) {
                return;
            }
            this.mGLESVersionCheckComplete = true;
        }

        public synchronized void checkGLDriver(GL10 gl10) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gl10) == null) {
                synchronized (this) {
                    if (!this.mGLESDriverCheckComplete) {
                        checkGLESVersion();
                        String glGetString = gl10.glGetString(7937);
                        if (this.mGLESVersion < 131072) {
                            this.mMultipleGLESContextsAllowed = !glGetString.startsWith(kMSM7K_RENDERER_PREFIX);
                            notifyAll();
                        }
                        this.mLimitedGLESContexts = this.mMultipleGLESContextsAllowed ? false : true;
                        this.mGLESDriverCheckComplete = true;
                    }
                }
            }
        }

        public void releaseEglContextLocked(GLThread gLThread) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gLThread) == null) {
                if (this.mEglOwner == gLThread) {
                    this.mEglOwner = null;
                }
                notifyAll();
            }
        }

        public synchronized boolean shouldReleaseEGLContextWhenPausing() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                synchronized (this) {
                    z = this.mLimitedGLESContexts;
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        public synchronized boolean shouldTerminateEGLWhenPausing() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                synchronized (this) {
                    checkGLESVersion();
                    z = !this.mMultipleGLESContextsAllowed;
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        public synchronized void threadExiting(GLThread gLThread) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, gLThread) == null) {
                synchronized (this) {
                    gLThread.mExited = true;
                    if (this.mEglOwner == gLThread) {
                        this.mEglOwner = null;
                    }
                    notifyAll();
                }
            }
        }

        public boolean tryAcquireEglContextLocked(GLThread gLThread) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, gLThread)) == null) {
                GLThread gLThread2 = this.mEglOwner;
                if (gLThread2 != gLThread && gLThread2 != null) {
                    checkGLESVersion();
                    if (this.mMultipleGLESContextsAllowed) {
                        return true;
                    }
                    GLThread gLThread3 = this.mEglOwner;
                    if (gLThread3 != null) {
                        gLThread3.requestReleaseEglContextLocked();
                        return false;
                    }
                    return false;
                }
                this.mEglOwner = gLThread;
                notifyAll();
                return true;
            }
            return invokeL.booleanValue;
        }

        public /* synthetic */ GLThreadManager(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public interface GLWrapper {
        GL wrap(GL gl);
    }

    /* loaded from: classes7.dex */
    public static class LogWriter extends Writer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public StringBuilder mBuilder;

        public LogWriter() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mBuilder = new StringBuilder();
        }

        private void flushBuilder() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || this.mBuilder.length() <= 0) {
                return;
            }
            this.mBuilder.toString();
            StringBuilder sb = this.mBuilder;
            sb.delete(0, sb.length());
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                flushBuilder();
            }
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                flushBuilder();
            }
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, cArr, i2, i3) == null) {
                for (int i4 = 0; i4 < i3; i4++) {
                    char c2 = cArr[i2 + i4];
                    if (c2 == '\n') {
                        flushBuilder();
                    } else {
                        this.mBuilder.append(c2);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface Renderer {
        void onDrawFrame(GL10 gl10);

        void onSurfaceChanged(GL10 gl10, int i2, int i3);

        void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig);
    }

    /* loaded from: classes7.dex */
    public class SimpleEGLConfigChooser extends ComponentSizeChooser {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GLTextureView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SimpleEGLConfigChooser(GLTextureView gLTextureView, boolean z) {
            super(gLTextureView, 8, 8, 8, 0, z ? 16 : 0, 0);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gLTextureView, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((GLTextureView) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), ((Integer) objArr2[5]).intValue(), ((Integer) objArr2[6]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = gLTextureView;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1820387084, "Lcom/baidu/searchbox/afx/gl/GLTextureView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1820387084, "Lcom/baidu/searchbox/afx/gl/GLTextureView;");
                return;
            }
        }
        sGLThreadManager = new GLThreadManager(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GLTextureView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mThisWeakRef = new WeakReference<>(this);
        init();
    }

    private void checkRenderThreadState() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65548, this) == null) && this.mGLThread != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            setSurfaceTextureListener(this);
        }
    }

    public void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.mGLThread != null) {
                    this.mGLThread.requestExitAndWait();
                }
            } finally {
                super.finalize();
            }
        }
    }

    public int getDebugFlags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mDebugFlags : invokeV.intValue;
    }

    public boolean getPreserveEGLContextOnPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mPreserveEGLContextOnPause : invokeV.booleanValue;
    }

    public int getRenderMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mGLThread.getRenderMode() : invokeV.intValue;
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onAttachedToWindow();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)}) == null) {
            surfaceChanged(getSurfaceTexture(), 0, i4 - i2, i5 - i3);
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.mGLThread.onPause();
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.mGLThread.onResume();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048585, this, surfaceTexture, i2, i3) == null) {
            surfaceCreated(surfaceTexture);
            surfaceChanged(surfaceTexture, 0, i2, i3);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, surfaceTexture)) == null) {
            surfaceDestroyed(surfaceTexture);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048587, this, surfaceTexture, i2, i3) == null) {
            surfaceChanged(surfaceTexture, 0, i2, i3);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, surfaceTexture) == null) {
        }
    }

    public void queueEvent(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, runnable) == null) {
            this.mGLThread.queueEvent(runnable);
        }
    }

    public void requestRender() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.mGLThread.requestRender();
        }
    }

    public void setDebugFlags(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.mDebugFlags = i2;
        }
    }

    public void setEGLConfigChooser(EGLConfigChooser eGLConfigChooser) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, eGLConfigChooser) == null) {
            checkRenderThreadState();
            this.mEGLConfigChooser = eGLConfigChooser;
        }
    }

    public void setEGLContextClientVersion(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            checkRenderThreadState();
            this.mEGLContextClientVersion = i2;
        }
    }

    public void setEGLContextFactory(EGLContextFactory eGLContextFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, eGLContextFactory) == null) {
            checkRenderThreadState();
            this.mEGLContextFactory = eGLContextFactory;
        }
    }

    public void setEGLWindowSurfaceFactory(EGLWindowSurfaceFactory eGLWindowSurfaceFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, eGLWindowSurfaceFactory) == null) {
            checkRenderThreadState();
            this.mEGLWindowSurfaceFactory = eGLWindowSurfaceFactory;
        }
    }

    public void setGLWrapper(GLWrapper gLWrapper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, gLWrapper) == null) {
            this.mGLWrapper = gLWrapper;
        }
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.mPreserveEGLContextOnPause = z;
        }
    }

    public void setRenderMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.mGLThread.setRenderMode(i2);
        }
    }

    public void setRenderer(Renderer renderer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, renderer) == null) {
            checkRenderThreadState();
            if (this.mEGLConfigChooser == null) {
                this.mEGLConfigChooser = new SimpleEGLConfigChooser(this, true);
            }
            if (this.mEGLContextFactory == null) {
                this.mEGLContextFactory = new DefaultContextFactory(this, null);
            }
            if (this.mEGLWindowSurfaceFactory == null) {
                this.mEGLWindowSurfaceFactory = new DefaultWindowSurfaceFactory(null);
            }
            this.mRenderer = renderer;
            GLThread gLThread = new GLThread(this.mThisWeakRef);
            this.mGLThread = gLThread;
            gLThread.start();
        }
    }

    public void surfaceChanged(SurfaceTexture surfaceTexture, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048602, this, surfaceTexture, i2, i3, i4) == null) {
            this.mGLThread.onWindowResize(i3, i4);
        }
    }

    public void surfaceCreated(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, surfaceTexture) == null) {
            this.mGLThread.surfaceCreated();
        }
    }

    public void surfaceDestroyed(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, surfaceTexture) == null) {
            this.mGLThread.surfaceDestroyed();
        }
    }

    /* loaded from: classes7.dex */
    public class DefaultContextFactory implements EGLContextFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int EGL_CONTEXT_CLIENT_VERSION;
        public final /* synthetic */ GLTextureView this$0;

        public DefaultContextFactory(GLTextureView gLTextureView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gLTextureView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = gLTextureView;
            this.EGL_CONTEXT_CLIENT_VERSION = EglBase10.EGL_CONTEXT_CLIENT_VERSION;
        }

        @Override // com.baidu.searchbox.afx.gl.GLTextureView.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, egl10, eGLDisplay, eGLConfig)) == null) {
                int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, this.this$0.mEGLContextClientVersion, 12344};
                EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
                if (this.this$0.mEGLContextClientVersion == 0) {
                    iArr = null;
                }
                return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
            }
            return (EGLContext) invokeLLL.objValue;
        }

        @Override // com.baidu.searchbox.afx.gl.GLTextureView.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, egl10, eGLDisplay, eGLContext) == null) || egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            String str = "display:" + eGLDisplay + " context: " + eGLContext;
            EglHelper.throwEglException("eglDestroyContex", egl10.eglGetError());
        }

        public /* synthetic */ DefaultContextFactory(GLTextureView gLTextureView, AnonymousClass1 anonymousClass1) {
            this(gLTextureView);
        }
    }

    public void setEGLConfigChooser(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            setEGLConfigChooser(new SimpleEGLConfigChooser(this, z));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mThisWeakRef = new WeakReference<>(this);
        init();
    }

    public void setEGLConfigChooser(int i2, int i3, int i4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            setEGLConfigChooser(new ComponentSizeChooser(this, i2, i3, i4, i5, i6, i7));
        }
    }
}
