package com.baidu.ala.recorder.video.gles;

import android.annotation.SuppressLint;
import android.util.Log;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;
@SuppressLint({"InlinedApi"})
/* loaded from: classes9.dex */
public class GLContext {
    public static final int EGL_RECORDABLE_ANDROID = 12610;
    public static final String LOG_TAG = "Grafika";
    private EGLConfig mConfig;
    private EGLContext mContext;
    private EGLDisplay mDisplay;
    private EGL10 mEgl;
    private GL10 mGl;
    private EGLSurface mSurface;
    private static int mBitsR = 8;
    private static int mBitsG = 8;
    private static int mBitsB = 8;
    private static int mBitsA = 8;

    public static void setContextColorBits(int i, int i2, int i3, int i4) {
        mBitsR = i;
        mBitsG = i2;
        mBitsB = i3;
        mBitsA = i4;
    }

    public static GLContext create() {
        return create(EGL10.EGL_NO_CONTEXT, 64, 64, 1, null);
    }

    public static GLContext create(int i, int i2) {
        return create(EGL10.EGL_NO_CONTEXT, i, i2, 1, null);
    }

    public static GLContext create(EGLContext eGLContext, int i, int i2) {
        return create(eGLContext, i, i2, 1, null);
    }

    public static GLContext create(EGLContext eGLContext, int i, int i2, int i3, Object obj) {
        GLContext gLContext = new GLContext();
        if (!gLContext.initEGL(eGLContext, i, i2, i3, obj)) {
            gLContext.release();
            return null;
        }
        return gLContext;
    }

    public EGLContext getContext() {
        return this.mContext;
    }

    public EGLDisplay getDisplay() {
        return this.mDisplay;
    }

    public EGLSurface getSurface() {
        return this.mSurface;
    }

    public EGL10 getEGL() {
        return this.mEgl;
    }

    public GL10 getGL() {
        return this.mGl;
    }

    GLContext() {
    }

    public void release() {
        Log.i("Grafika", "#### CGESharedGLContext Destroying context... ####");
        if (this.mDisplay != EGL10.EGL_NO_DISPLAY) {
            this.mEgl.eglMakeCurrent(this.mDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            this.mEgl.eglDestroyContext(this.mDisplay, this.mContext);
            this.mEgl.eglDestroySurface(this.mDisplay, this.mSurface);
            this.mEgl.eglTerminate(this.mDisplay);
        }
        this.mDisplay = EGL10.EGL_NO_DISPLAY;
        this.mSurface = EGL10.EGL_NO_SURFACE;
        this.mContext = EGL10.EGL_NO_CONTEXT;
    }

    public void makeCurrent() {
        if (!this.mEgl.eglMakeCurrent(this.mDisplay, this.mSurface, this.mSurface, this.mContext)) {
            Log.e("Grafika", "eglMakeCurrent failed:" + this.mEgl.eglGetError());
        }
    }

    public boolean swapBuffers() {
        return this.mEgl.eglSwapBuffers(this.mDisplay, this.mSurface);
    }

    private boolean initEGL(EGLContext eGLContext, int i, int i2, int i3, Object obj) {
        int[] iArr = {12440, 2, 12344};
        int[] iArr2 = {12339, i3, 12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344};
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr3 = new int[1];
        int[] iArr4 = new int[2];
        int[] iArr5 = {12375, i, 12374, i2, 12344};
        this.mEgl = (EGL10) EGLContext.getEGL();
        EGLDisplay eglGetDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.mDisplay = eglGetDisplay;
        if (eglGetDisplay == EGL10.EGL_NO_DISPLAY) {
            Log.e("Grafika", String.format("eglGetDisplay() returned error 0x%x", Integer.valueOf(this.mEgl.eglGetError())));
            return false;
        } else if (!this.mEgl.eglInitialize(this.mDisplay, iArr4)) {
            Log.e("Grafika", String.format("eglInitialize() returned error 0x%x", Integer.valueOf(this.mEgl.eglGetError())));
            return false;
        } else {
            Log.i("Grafika", String.format("eglInitialize - major: %d, minor: %d", Integer.valueOf(iArr4[0]), Integer.valueOf(iArr4[1])));
            if (!this.mEgl.eglChooseConfig(this.mDisplay, iArr2, eGLConfigArr, 1, iArr3)) {
                Log.e("Grafika", String.format("eglChooseConfig() returned error 0x%x", Integer.valueOf(this.mEgl.eglGetError())));
                return false;
            }
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(iArr3[0]);
            objArr[1] = eGLContext == EGL10.EGL_NO_CONTEXT ? "NO" : "YES";
            Log.i("Grafika", String.format("Config num: %d, has sharedContext: %s", objArr));
            this.mConfig = eGLConfigArr[0];
            this.mContext = this.mEgl.eglCreateContext(this.mDisplay, this.mConfig, eGLContext, iArr);
            if (this.mContext == EGL10.EGL_NO_CONTEXT) {
                Log.e("Grafika", "eglCreateContext Failed!");
                return false;
            }
            switch (i3) {
                case 1:
                case 12610:
                    this.mSurface = this.mEgl.eglCreatePbufferSurface(this.mDisplay, this.mConfig, iArr5);
                    break;
                case 2:
                    this.mSurface = this.mEgl.eglCreatePixmapSurface(this.mDisplay, this.mConfig, obj, iArr5);
                    break;
                case 4:
                    this.mSurface = this.mEgl.eglCreateWindowSurface(this.mDisplay, this.mConfig, obj, iArr5);
                    break;
            }
            if (this.mSurface == EGL10.EGL_NO_SURFACE) {
                Log.e("Grafika", "eglCreatePbufferSurface Failed!");
                return false;
            } else if (!this.mEgl.eglMakeCurrent(this.mDisplay, this.mSurface, this.mSurface, this.mContext)) {
                Log.e("Grafika", "eglMakeCurrent failed:" + this.mEgl.eglGetError());
                return false;
            } else {
                int[] iArr6 = new int[1];
                this.mEgl.eglQueryContext(this.mDisplay, this.mContext, 12440, iArr6);
                Log.i("Grafika", "EGLContext created, client version " + iArr6[0]);
                this.mGl = (GL10) this.mContext.getGL();
                return true;
            }
        }
    }
}
