package com.baidu.searchbox.afx.recode;

import android.annotation.SuppressLint;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
import com.baidu.webkit.internal.monitor.MonitorType;
@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public class InputSurface {
    public static final int EGL_RECORDABLE_ANDROID = 12610;
    public static final String TAG = "InputSurface";
    public Surface mSurface;
    public EGLDisplay mEGLDisplay = EGL14.EGL_NO_DISPLAY;
    public EGLContext mEGLContext = EGL14.EGL_NO_CONTEXT;
    public EGLSurface mEGLSurface = EGL14.EGL_NO_SURFACE;

    @SuppressLint({"BDThrowableCheck"})
    public InputSurface(Surface surface) {
        if (surface != null) {
            this.mSurface = surface;
            eglSetup();
            return;
        }
        throw null;
    }

    @SuppressLint({"BDThrowableCheck"})
    private void checkEglError(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError == 12288) {
            return;
        }
        throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
    }

    public void setPresentationTime(long j) {
        EGLExt.eglPresentationTimeANDROID(this.mEGLDisplay, this.mEGLSurface, j);
    }

    @SuppressLint({"BDThrowableCheck, InlinedApi"})
    private void eglSetup() {
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.mEGLDisplay = eglGetDisplay;
        if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
            int[] iArr = new int[2];
            if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                if (EGL14.eglChooseConfig(this.mEGLDisplay, new int[]{MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, 12322, 8, 12352, 4, 12610, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                    this.mEGLContext = EGL14.eglCreateContext(this.mEGLDisplay, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
                    checkEglError("eglCreateContext");
                    if (this.mEGLContext != null) {
                        this.mEGLSurface = EGL14.eglCreateWindowSurface(this.mEGLDisplay, eGLConfigArr[0], this.mSurface, new int[]{12344}, 0);
                        checkEglError("eglCreateWindowSurface");
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

    @SuppressLint({"InlinedApi"})
    public int getHeight() {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.mEGLDisplay, this.mEGLSurface, 12374, iArr, 0);
        return iArr[0];
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    @SuppressLint({"InlinedApi"})
    public int getWidth() {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.mEGLDisplay, this.mEGLSurface, 12375, iArr, 0);
        return iArr[0];
    }

    @SuppressLint({"BDThrowableCheck"})
    public void makeCurrent() {
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        EGLSurface eGLSurface = this.mEGLSurface;
        if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.mEGLContext)) {
            return;
        }
        throw new RuntimeException("eglMakeCurrent failed");
    }

    @SuppressLint({"BDThrowableCheck"})
    public void makeUnCurrent() {
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT)) {
            return;
        }
        throw new RuntimeException("eglMakeCurrent failed");
    }

    public void release() {
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

    public boolean swapBuffers() {
        return EGL14.eglSwapBuffers(this.mEGLDisplay, this.mEGLSurface);
    }
}
