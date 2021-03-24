package com.baidu.android.glview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes2.dex */
public class GL2RenderJNIView extends GLSurfaceView {
    public static final boolean DEBUG = false;
    public static final int DISPLAY_AR_16_9 = 1;
    public static final int DISPLAY_AR_4_3 = 2;
    public static final int DISPLAY_AR_ORIGIN = 0;
    public static final int DISPLAY_SCALE_KEEP_ORIGIN = 0;
    public static final int DISPLAY_SCALE_TO_FIT = 2;
    public static final int DISPLAY_SCALE_TO_FIT_WITH_CROPPING = 1;
    public static String TAG = "GL2JNIView";
    public int mActionState;
    public int mAspectRatio;
    public Renderer mRender;
    public int mScaleMode;
    public Surface mSurface;
    public int mSurfaceTexID;
    public SurfaceTexture mSurfaceTexture;
    public boolean mfixed;
    public boolean mloaded;

    /* loaded from: classes2.dex */
    public static class ConfigChooser implements GLSurfaceView.EGLConfigChooser {
        public static int EGL_OPENGL_ES2_BIT = 4;
        public static int[] s_configAttribs2 = {12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344};
        public int mAlphaSize;
        public int mBlueSize;
        public int mDepthSize;
        public int mGreenSize;
        public int mRedSize;
        public int mStencilSize;
        public int[] mValue = new int[1];

        public ConfigChooser(int i, int i2, int i3, int i4, int i5, int i6) {
            this.mRedSize = i;
            this.mGreenSize = i2;
            this.mBlueSize = i3;
            this.mAlphaSize = i4;
            this.mDepthSize = i5;
            this.mStencilSize = i6;
        }

        private int findConfigAttrib(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.mValue) ? this.mValue[0] : i2;
        }

        private void printConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {12320, 12321, 12322, 12323, 12324, 12325, 12326, 12327, 12328, 12329, 12330, 12331, 12332, 12333, 12334, 12335, 12336, 12337, 12338, 12339, 12340, 12343, 12342, 12341, 12345, 12346, 12347, 12348, 12349, 12350, 12351, 12352, 12354};
            String[] strArr = {"EGL_BUFFER_SIZE", "EGL_ALPHA_SIZE", "EGL_BLUE_SIZE", "EGL_GREEN_SIZE", "EGL_RED_SIZE", "EGL_DEPTH_SIZE", "EGL_STENCIL_SIZE", "EGL_CONFIG_CAVEAT", "EGL_CONFIG_ID", "EGL_LEVEL", "EGL_MAX_PBUFFER_HEIGHT", "EGL_MAX_PBUFFER_PIXELS", "EGL_MAX_PBUFFER_WIDTH", "EGL_NATIVE_RENDERABLE", "EGL_NATIVE_VISUAL_ID", "EGL_NATIVE_VISUAL_TYPE", "EGL_PRESERVED_RESOURCES", "EGL_SAMPLES", "EGL_SAMPLE_BUFFERS", "EGL_SURFACE_TYPE", "EGL_TRANSPARENT_TYPE", "EGL_TRANSPARENT_RED_VALUE", "EGL_TRANSPARENT_GREEN_VALUE", "EGL_TRANSPARENT_BLUE_VALUE", "EGL_BIND_TO_TEXTURE_RGB", "EGL_BIND_TO_TEXTURE_RGBA", "EGL_MIN_SWAP_INTERVAL", "EGL_MAX_SWAP_INTERVAL", "EGL_LUMINANCE_SIZE", "EGL_ALPHA_MASK_SIZE", "EGL_COLOR_BUFFER_TYPE", "EGL_RENDERABLE_TYPE", "EGL_CONFORMANT"};
            int[] iArr2 = new int[1];
            for (int i = 0; i < 33; i++) {
                int i2 = iArr[i];
                String str = strArr[i];
                if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, iArr2)) {
                    Log.w(GL2RenderJNIView.TAG, String.format("  %s: %d\n", str, Integer.valueOf(iArr2[0])));
                } else {
                    do {
                    } while (egl10.eglGetError() != 12288);
                }
            }
        }

        private void printConfigs(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            int length = eGLConfigArr.length;
            Log.w(GL2RenderJNIView.TAG, String.format("%d configurations", Integer.valueOf(length)));
            for (int i = 0; i < length; i++) {
                Log.w(GL2RenderJNIView.TAG, String.format("Configuration %d:\n", Integer.valueOf(i)));
                printConfig(egl10, eGLDisplay, eGLConfigArr[i]);
            }
        }

        @Override // android.opengl.GLSurfaceView.EGLConfigChooser
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            egl10.eglChooseConfig(eGLDisplay, s_configAttribs2, null, 0, iArr);
            int i = iArr[0];
            if (i > 0) {
                EGLConfig[] eGLConfigArr = new EGLConfig[i];
                egl10.eglChooseConfig(eGLDisplay, s_configAttribs2, eGLConfigArr, i, iArr);
                return chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            }
            throw new IllegalArgumentException("No configs match configSpec");
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int findConfigAttrib = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int findConfigAttrib2 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (findConfigAttrib >= this.mDepthSize && findConfigAttrib2 >= this.mStencilSize) {
                    int findConfigAttrib3 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int findConfigAttrib4 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int findConfigAttrib5 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int findConfigAttrib6 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (findConfigAttrib3 == this.mRedSize && findConfigAttrib4 == this.mGreenSize && findConfigAttrib5 == this.mBlueSize && findConfigAttrib6 == this.mAlphaSize) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public static class ContextFactory implements GLSurfaceView.EGLContextFactory {
        public static int EGL_CONTEXT_CLIENT_VERSION = 12440;

        public ContextFactory() {
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            Log.w(GL2RenderJNIView.TAG, "creating OpenGL ES 2.0 context");
            GL2RenderJNIView.checkEglError("Before eglCreateContext", egl10);
            EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
            GL2RenderJNIView.checkEglError("After eglCreateContext", egl10);
            return eglCreateContext;
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
        }
    }

    /* loaded from: classes2.dex */
    public class Renderer implements GLSurfaceView.Renderer, SurfaceTexture.OnFrameAvailableListener {
        public boolean mAllocSurfaceTex;
        public GL2RenderJNIView m_SurfaceView;
        public boolean mUpdateSurfaceTex = false;
        public float[] mSTMatrix = new float[16];
        public int m_hRender = GL2JNILib.create();

        public Renderer(GL2RenderJNIView gL2RenderJNIView) {
            this.mAllocSurfaceTex = false;
            this.m_SurfaceView = gL2RenderJNIView;
            this.mAllocSurfaceTex = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            GL2RenderJNIView gL2RenderJNIView = GL2RenderJNIView.this;
            if (gL2RenderJNIView.mSurfaceTexID > 0 && this.mUpdateSurfaceTex) {
                gL2RenderJNIView.mSurfaceTexture.updateTexImage();
                GL2RenderJNIView.this.mSurfaceTexture.getTransformMatrix(this.mSTMatrix);
                GLES20.glUniformMatrix4fv(GL2JNILib.getSTMatrixHandle(this.m_hRender), 1, false, this.mSTMatrix, 0);
                Log.w(GL2RenderJNIView.TAG, String.format("%s%d\n", "start ondraw frame", Integer.valueOf(GL2RenderJNIView.this.mSurfaceTexID)));
            }
            GL2JNILib.render(this.m_hRender);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            Log.i(GL2RenderJNIView.TAG, String.format("onFrameAvailable:=======\n", new Object[0]));
            this.mUpdateSurfaceTex = true;
            this.m_SurfaceView.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            GL2JNILib.setviewport(this.m_hRender, i, i2);
            GL2JNILib.ratio(this.m_hRender, GL2RenderJNIView.this.mAspectRatio);
            GL2JNILib.stretch(this.m_hRender, GL2RenderJNIView.this.mScaleMode);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            GL2JNILib.init(this.m_hRender, this.m_SurfaceView);
            GL2RenderJNIView.this.mloaded = true;
        }

        public void setSurfaceTexture(Surface surface, int i) {
            GL2JNILib.setSurfaceTex(this.m_hRender, surface, i);
        }
    }

    public GL2RenderJNIView(Context context) {
        super(context);
        this.mAspectRatio = 0;
        this.mScaleMode = 1;
        this.mfixed = false;
        this.mloaded = false;
        init(false, 0, 0);
    }

    public GL2RenderJNIView(Context context, boolean z, int i, int i2) {
        super(context);
        this.mAspectRatio = 0;
        this.mScaleMode = 1;
        this.mfixed = false;
        this.mloaded = false;
        init(z, i, i2);
    }

    public static void checkEglError(String str, EGL10 egl10) {
        while (true) {
            int eglGetError = egl10.eglGetError();
            if (eglGetError == 12288) {
                return;
            }
            Log.e(TAG, String.format("%s: EGL error: 0x%x", str, Integer.valueOf(eglGetError)));
        }
    }

    private void init(boolean z, int i, int i2) {
        if (z) {
            getHolder().setFormat(-3);
        }
        setEGLContextFactory(new ContextFactory());
        setEGLConfigChooser(!z ? new ConfigChooser(8, 8, 8, 8, i, i2) : new ConfigChooser(5, 6, 5, 0, i, i2));
        Renderer renderer = new Renderer(this);
        this.mRender = renderer;
        setRenderer(renderer);
        setRenderMode(0);
        this.mSurface = null;
        this.mSurfaceTexture = null;
    }

    public int GetRenderHandle() {
        return this.mRender.m_hRender;
    }

    public void close() {
        this.mloaded = false;
        GL2JNILib.close(this.mRender.m_hRender);
    }

    public Boolean getFixed() {
        return Boolean.valueOf(this.mfixed);
    }

    public int getRatio() {
        return this.mAspectRatio;
    }

    public int getStretch() {
        return this.mScaleMode;
    }

    public void initSurfaceTex(int i) {
        this.mSurfaceTexID = i;
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.mSurfaceTexID);
        this.mSurfaceTexture = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this.mRender);
        Surface surface = new Surface(this.mSurfaceTexture);
        this.mSurface = surface;
        this.mRender.setSurfaceTexture(surface, this.mSurfaceTexID);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f2;
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

    public void releaseSurfaceTex() {
        this.mSurfaceTexture.release();
        this.mSurface.release();
        this.mSurfaceTexture = null;
        this.mSurface = null;
    }

    public void setFixed(Boolean bool) {
        this.mfixed = bool.booleanValue();
    }

    public void setRatio(int i) {
        if (this.mAspectRatio != i) {
            this.mAspectRatio = i;
            if (this.mloaded) {
                GL2JNILib.ratio(this.mRender.m_hRender, i);
            }
        }
    }

    public void setStretch(int i) {
        if (this.mScaleMode != i) {
            this.mScaleMode = i;
            if (this.mloaded) {
                GL2JNILib.stretch(this.mRender.m_hRender, i);
            }
        }
    }
}
