package com.baidu.android.glview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
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
import com.baidu.webkit.internal.monitor.MonitorType;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes9.dex */
public class GL2RenderJNIView extends GLSurfaceView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int DISPLAY_AR_16_9 = 1;
    public static final int DISPLAY_AR_4_3 = 2;
    public static final int DISPLAY_AR_ORIGIN = 0;
    public static final int DISPLAY_SCALE_KEEP_ORIGIN = 0;
    public static final int DISPLAY_SCALE_TO_FIT = 2;
    public static final int DISPLAY_SCALE_TO_FIT_WITH_CROPPING = 1;
    public static String TAG = "GL2JNIView";
    public transient /* synthetic */ FieldHolder $fh;
    public int mActionState;
    public int mAspectRatio;
    public Renderer mRender;
    public int mScaleMode;
    public Surface mSurface;
    public int mSurfaceTexID;
    public SurfaceTexture mSurfaceTexture;
    public boolean mfixed;
    public boolean mloaded;

    /* renamed from: com.baidu.android.glview.GL2RenderJNIView$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static class ConfigChooser implements GLSurfaceView.EGLConfigChooser {
        public static /* synthetic */ Interceptable $ic = null;
        public static int EGL_OPENGL_ES2_BIT = 4;
        public static int[] s_configAttribs2;
        public transient /* synthetic */ FieldHolder $fh;
        public int mAlphaSize;
        public int mBlueSize;
        public int mDepthSize;
        public int mGreenSize;
        public int mRedSize;
        public int mStencilSize;
        public int[] mValue;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(951477448, "Lcom/baidu/android/glview/GL2RenderJNIView$ConfigChooser;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(951477448, "Lcom/baidu/android/glview/GL2RenderJNIView$ConfigChooser;");
                    return;
                }
            }
            s_configAttribs2 = new int[]{MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 4, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 4, 12322, 4, 12352, 4, 12344};
        }

        public ConfigChooser(int i2, int i3, int i4, int i5, int i6, int i7) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i8 = newInitContext.flag;
                if ((i8 & 1) != 0) {
                    int i9 = i8 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
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
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{egl10, eGLDisplay, eGLConfig, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) ? egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, this.mValue) ? this.mValue[0] : i3 : invokeCommon.intValue;
        }

        private void printConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65539, this, egl10, eGLDisplay, eGLConfig) == null) {
                int[] iArr = {MonitorType.MONITOR_TYPE_ADD_JAVA_SCRIPT, 12321, 12322, MonitorType.MONITOR_TYPE_INIT_WEBKIT, MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 12325, 12326, 12327, 12328, 12329, 12330, 12331, 12332, 12333, 12334, MonitorType.MONITOR_TYPE_SEARCH_FPS, 12336, 12337, 12338, 12339, 12340, 12343, 12342, 12341, 12345, 12346, 12347, 12348, 12349, 12350, 12351, 12352, 12354};
                String[] strArr = {"EGL_BUFFER_SIZE", "EGL_ALPHA_SIZE", "EGL_BLUE_SIZE", "EGL_GREEN_SIZE", "EGL_RED_SIZE", "EGL_DEPTH_SIZE", "EGL_STENCIL_SIZE", "EGL_CONFIG_CAVEAT", "EGL_CONFIG_ID", "EGL_LEVEL", "EGL_MAX_PBUFFER_HEIGHT", "EGL_MAX_PBUFFER_PIXELS", "EGL_MAX_PBUFFER_WIDTH", "EGL_NATIVE_RENDERABLE", "EGL_NATIVE_VISUAL_ID", "EGL_NATIVE_VISUAL_TYPE", "EGL_PRESERVED_RESOURCES", "EGL_SAMPLES", "EGL_SAMPLE_BUFFERS", "EGL_SURFACE_TYPE", "EGL_TRANSPARENT_TYPE", "EGL_TRANSPARENT_RED_VALUE", "EGL_TRANSPARENT_GREEN_VALUE", "EGL_TRANSPARENT_BLUE_VALUE", "EGL_BIND_TO_TEXTURE_RGB", "EGL_BIND_TO_TEXTURE_RGBA", "EGL_MIN_SWAP_INTERVAL", "EGL_MAX_SWAP_INTERVAL", "EGL_LUMINANCE_SIZE", "EGL_ALPHA_MASK_SIZE", "EGL_COLOR_BUFFER_TYPE", "EGL_RENDERABLE_TYPE", "EGL_CONFORMANT"};
                int[] iArr2 = new int[1];
                for (int i2 = 0; i2 < 33; i2++) {
                    int i3 = iArr[i2];
                    String str = strArr[i2];
                    if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i3, iArr2)) {
                        String unused = GL2RenderJNIView.TAG;
                        String.format("  %s: %d\n", str, Integer.valueOf(iArr2[0]));
                    } else {
                        do {
                        } while (egl10.eglGetError() != 12288);
                    }
                }
            }
        }

        private void printConfigs(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, egl10, eGLDisplay, eGLConfigArr) == null) {
                int length = eGLConfigArr.length;
                String unused = GL2RenderJNIView.TAG;
                String.format("%d configurations", Integer.valueOf(length));
                for (int i2 = 0; i2 < length; i2++) {
                    String unused2 = GL2RenderJNIView.TAG;
                    String.format("Configuration %d:\n", Integer.valueOf(i2));
                    printConfig(egl10, eGLDisplay, eGLConfigArr[i2]);
                }
            }
        }

        @Override // android.opengl.GLSurfaceView.EGLConfigChooser
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, egl10, eGLDisplay)) == null) {
                int[] iArr = new int[1];
                egl10.eglChooseConfig(eGLDisplay, s_configAttribs2, null, 0, iArr);
                int i2 = iArr[0];
                if (i2 > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i2];
                    egl10.eglChooseConfig(eGLDisplay, s_configAttribs2, eGLConfigArr, i2, iArr);
                    return chooseConfig(egl10, eGLDisplay, eGLConfigArr);
                }
                throw new IllegalArgumentException("No configs match configSpec");
            }
            return (EGLConfig) invokeLL.objValue;
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, egl10, eGLDisplay, eGLConfigArr)) == null) {
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

    /* loaded from: classes9.dex */
    public static class ContextFactory implements GLSurfaceView.EGLContextFactory {
        public static /* synthetic */ Interceptable $ic = null;
        public static int EGL_CONTEXT_CLIENT_VERSION = 12440;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-884111622, "Lcom/baidu/android/glview/GL2RenderJNIView$ContextFactory;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-884111622, "Lcom/baidu/android/glview/GL2RenderJNIView$ContextFactory;");
            }
        }

        public ContextFactory() {
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

        public /* synthetic */ ContextFactory(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, egl10, eGLDisplay, eGLConfig)) == null) {
                String unused = GL2RenderJNIView.TAG;
                GL2RenderJNIView.checkEglError("Before eglCreateContext", egl10);
                EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
                GL2RenderJNIView.checkEglError("After eglCreateContext", egl10);
                return eglCreateContext;
            }
            return (EGLContext) invokeLLL.objValue;
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, egl10, eGLDisplay, eGLContext) == null) {
                egl10.eglDestroyContext(eGLDisplay, eGLContext);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class Renderer implements GLSurfaceView.Renderer, SurfaceTexture.OnFrameAvailableListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mAllocSurfaceTex;
        public float[] mSTMatrix;
        public boolean mUpdateSurfaceTex;
        public GL2RenderJNIView m_SurfaceView;
        public int m_hRender;
        public final /* synthetic */ GL2RenderJNIView this$0;

        public Renderer(GL2RenderJNIView gL2RenderJNIView, GL2RenderJNIView gL2RenderJNIView2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gL2RenderJNIView, gL2RenderJNIView2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = gL2RenderJNIView;
            this.mAllocSurfaceTex = false;
            this.mUpdateSurfaceTex = false;
            this.mSTMatrix = new float[16];
            this.m_SurfaceView = gL2RenderJNIView2;
            this.m_hRender = GL2JNILib.create();
            this.mAllocSurfaceTex = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gl10) == null) {
                GL2RenderJNIView gL2RenderJNIView = this.this$0;
                if (gL2RenderJNIView.mSurfaceTexID > 0 && this.mUpdateSurfaceTex) {
                    gL2RenderJNIView.mSurfaceTexture.updateTexImage();
                    this.this$0.mSurfaceTexture.getTransformMatrix(this.mSTMatrix);
                    GLES20.glUniformMatrix4fv(GL2JNILib.getSTMatrixHandle(this.m_hRender), 1, false, this.mSTMatrix, 0);
                    String unused = GL2RenderJNIView.TAG;
                    String.format("%s%d\n", "start ondraw frame", Integer.valueOf(this.this$0.mSurfaceTexID));
                }
                GL2JNILib.render(this.m_hRender);
            }
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, surfaceTexture) == null) {
                String unused = GL2RenderJNIView.TAG;
                String.format("onFrameAvailable:=======\n", new Object[0]);
                this.mUpdateSurfaceTex = true;
                this.m_SurfaceView.requestRender();
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, gl10, i2, i3) == null) {
                GL2JNILib.setviewport(this.m_hRender, i2, i3);
                GL2JNILib.ratio(this.m_hRender, this.this$0.mAspectRatio);
                GL2JNILib.stretch(this.m_hRender, this.this$0.mScaleMode);
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, gl10, eGLConfig) == null) {
                GL2JNILib.init(this.m_hRender, this.m_SurfaceView);
                this.this$0.mloaded = true;
            }
        }

        public void setSurfaceTexture(Surface surface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048580, this, surface, i2) == null) {
                GL2JNILib.setSurfaceTex(this.m_hRender, surface, i2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1954063229, "Lcom/baidu/android/glview/GL2RenderJNIView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1954063229, "Lcom/baidu/android/glview/GL2RenderJNIView;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GL2RenderJNIView(Context context) {
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
        this.mAspectRatio = 0;
        this.mScaleMode = 1;
        this.mfixed = false;
        this.mloaded = false;
        init(false, 0, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GL2RenderJNIView(Context context, boolean z, int i2, int i3) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mAspectRatio = 0;
        this.mScaleMode = 1;
        this.mfixed = false;
        this.mloaded = false;
        init(z, i2, i3);
    }

    public static void checkEglError(String str, EGL10 egl10) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65544, null, str, egl10) != null) {
            return;
        }
        while (true) {
            int eglGetError = egl10.eglGetError();
            if (eglGetError == 12288) {
                return;
            }
            String.format("%s: EGL error: 0x%x", str, Integer.valueOf(eglGetError));
        }
    }

    private void init(boolean z, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            if (z) {
                getHolder().setFormat(-3);
            }
            setEGLContextFactory(new ContextFactory(null));
            setEGLConfigChooser(!z ? new ConfigChooser(8, 8, 8, 8, i2, i3) : new ConfigChooser(5, 6, 5, 0, i2, i3));
            Renderer renderer = new Renderer(this, this);
            this.mRender = renderer;
            setRenderer(renderer);
            setRenderMode(0);
            this.mSurface = null;
            this.mSurfaceTexture = null;
        }
    }

    public int GetRenderHandle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mRender.m_hRender : invokeV.intValue;
    }

    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mloaded = false;
            GL2JNILib.close(this.mRender.m_hRender);
        }
    }

    public Boolean getFixed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Boolean.valueOf(this.mfixed) : (Boolean) invokeV.objValue;
    }

    public int getRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mAspectRatio : invokeV.intValue;
    }

    public int getStretch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mScaleMode : invokeV.intValue;
    }

    public void initSurfaceTex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.mSurfaceTexID = i2;
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.mSurfaceTexID);
            this.mSurfaceTexture = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(this.mRender);
            Surface surface = new Surface(this.mSurfaceTexture);
            this.mSurface = surface;
            this.mRender.setSurfaceTexture(surface, this.mSurfaceTexID);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            if (!this.mfixed) {
                float f3 = 0.0f;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int action = motionEvent.getAction() & 255;
                if (action == 5 || action == 6) {
                    this.mActionState = action;
                }
                if (this.mActionState == 5 || action == 6) {
                    float x2 = motionEvent.getX(1);
                    f3 = motionEvent.getY(1);
                    f2 = x2;
                } else {
                    f2 = 0.0f;
                }
                if (this.mActionState == 6) {
                    this.mActionState = 0;
                }
                GL2JNILib.transform(this.mRender.m_hRender, x, f2, y, f3, motionEvent.getAction() & 255);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void releaseSurfaceTex() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.mSurfaceTexture.release();
            this.mSurface.release();
            this.mSurfaceTexture = null;
            this.mSurface = null;
        }
    }

    public void setFixed(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bool) == null) {
            this.mfixed = bool.booleanValue();
        }
    }

    public void setRatio(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || this.mAspectRatio == i2) {
            return;
        }
        this.mAspectRatio = i2;
        if (this.mloaded) {
            GL2JNILib.ratio(this.mRender.m_hRender, i2);
        }
    }

    public void setStretch(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || this.mScaleMode == i2) {
            return;
        }
        this.mScaleMode = i2;
        if (this.mloaded) {
            GL2JNILib.stretch(this.mRender.m_hRender, i2);
        }
    }
}
