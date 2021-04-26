package com.baidu.searchbox.afx.gl;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
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
/* loaded from: classes2.dex */
public class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener, View.OnLayoutChangeListener {
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
    public static final GLThreadManager sGLThreadManager = new GLThreadManager();
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

    /* loaded from: classes2.dex */
    public abstract class BaseConfigChooser implements EGLConfigChooser {
        public int[] mConfigSpec;

        public BaseConfigChooser(int[] iArr) {
            this.mConfigSpec = filterConfigSpec(iArr);
        }

        private int[] filterConfigSpec(int[] iArr) {
            if (GLTextureView.this.mEGLContextClientVersion != 2) {
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

        @Override // com.baidu.searchbox.afx.gl.GLTextureView.EGLConfigChooser
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
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

        public abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);
    }

    /* loaded from: classes2.dex */
    public class ComponentSizeChooser extends BaseConfigChooser {
        public int mAlphaSize;
        public int mBlueSize;
        public int mDepthSize;
        public int mGreenSize;
        public int mRedSize;
        public int mStencilSize;
        public int[] mValue;

        public ComponentSizeChooser(int i2, int i3, int i4, int i5, int i6, int i7) {
            super(new int[]{12324, i2, 12323, i3, 12322, i4, 12321, i5, 12325, i6, 12326, i7, 12344});
            this.mValue = new int[1];
            this.mRedSize = i2;
            this.mGreenSize = i3;
            this.mBlueSize = i4;
            this.mAlphaSize = i5;
            this.mDepthSize = i6;
            this.mStencilSize = i7;
        }

        private int findConfigAttrib(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2, int i3) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, this.mValue) ? this.mValue[0] : i3;
        }

        @Override // com.baidu.searchbox.afx.gl.GLTextureView.BaseConfigChooser
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
    public class DefaultContextFactory implements EGLContextFactory {
        public int EGL_CONTEXT_CLIENT_VERSION;

        public DefaultContextFactory() {
            this.EGL_CONTEXT_CLIENT_VERSION = EglBase10.EGL_CONTEXT_CLIENT_VERSION;
        }

        @Override // com.baidu.searchbox.afx.gl.GLTextureView.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, GLTextureView.this.mEGLContextClientVersion, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLTextureView.this.mEGLContextClientVersion == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.searchbox.afx.gl.GLTextureView.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
            EglHelper.throwEglException("eglDestroyContex", egl10.eglGetError());
        }
    }

    /* loaded from: classes2.dex */
    public static class DefaultWindowSurfaceFactory implements EGLWindowSurfaceFactory {
        public DefaultWindowSurfaceFactory() {
        }

        @Override // com.baidu.searchbox.afx.gl.GLTextureView.EGLWindowSurfaceFactory
        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e2) {
                Log.e(GLTextureView.TAG, "eglCreateWindowSurface", e2);
                return null;
            }
        }

        @Override // com.baidu.searchbox.afx.gl.GLTextureView.EGLWindowSurfaceFactory
        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* loaded from: classes2.dex */
    public interface EGLConfigChooser {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* loaded from: classes2.dex */
    public interface EGLContextFactory {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* loaded from: classes2.dex */
    public interface EGLWindowSurfaceFactory {
        EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* loaded from: classes2.dex */
    public static class EglHelper {
        public EGL10 mEgl;
        public EGLConfig mEglConfig;
        public EGLContext mEglContext;
        public EGLDisplay mEglDisplay;
        public EGLSurface mEglSurface;
        public WeakReference<GLTextureView> mGLSurfaceViewWeakRef;

        public EglHelper(WeakReference<GLTextureView> weakReference) {
            this.mGLSurfaceViewWeakRef = weakReference;
        }

        private void destroySurfaceImp() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.mEglSurface;
            if (eGLSurface2 == null || eGLSurface2 == (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                return;
            }
            this.mEgl.eglMakeCurrent(this.mEglDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            GLTextureView gLTextureView = this.mGLSurfaceViewWeakRef.get();
            if (gLTextureView != null) {
                gLTextureView.mEGLWindowSurfaceFactory.destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
            }
            this.mEglSurface = null;
        }

        public static String formatEglError(String str, int i2) {
            return str + " failed: " + i2;
        }

        public static void logEglErrorAsWarning(String str, String str2, int i2) {
            Log.w(str, formatEglError(str2, i2));
        }

        private void throwEglException(String str) {
            throwEglException(str, this.mEgl.eglGetError());
        }

        public GL createGL() {
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

        public boolean createSurface() {
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
                        if (this.mEgl.eglGetError() == 12299) {
                            Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                        }
                        return false;
                    }
                    throw new RuntimeException("mEglConfig not initialized");
                }
                throw new RuntimeException("eglDisplay not initialized");
            }
            throw new RuntimeException("egl not initialized");
        }

        public void destroySurface() {
            destroySurfaceImp();
        }

        public void finish() {
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

        public void start() {
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

        public int swap() {
            return !this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface) ? this.mEgl.eglGetError() : CommandMessage.COMMAND_BASE;
        }

        public static void throwEglException(String str, int i2) {
            throw new RuntimeException(formatEglError(str, i2));
        }
    }

    /* loaded from: classes2.dex */
    public static class GLThread extends Thread {
        public EglHelper mEglHelper;
        public boolean mExited;
        public WeakReference<GLTextureView> mGLSurfaceViewWeakRef;
        public boolean mHasSurface;
        public boolean mHaveEglContext;
        public boolean mHaveEglSurface;
        public boolean mPaused;
        public boolean mRenderComplete;
        public boolean mRequestPaused;
        public boolean mShouldExit;
        public boolean mShouldReleaseEglContext;
        public boolean mSurfaceIsBad;
        public boolean mWaitingForSurface;
        public ArrayList<Runnable> mEventQueue = new ArrayList<>();
        public boolean mSizeChanged = true;
        public int mWidth = 0;
        public int mHeight = 0;
        public boolean mRequestRender = true;
        public int mRenderMode = 1;

        public GLThread(WeakReference<GLTextureView> weakReference) {
            this.mGLSurfaceViewWeakRef = weakReference;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void guardedRun() throws InterruptedException {
            boolean z;
            boolean z2;
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
            return !this.mPaused && this.mHasSurface && !this.mSurfaceIsBad && this.mWidth > 0 && this.mHeight > 0 && (this.mRequestRender || this.mRenderMode == 1);
        }

        private void stopEglContextLocked() {
            if (this.mHaveEglContext) {
                this.mEglHelper.finish();
                this.mHaveEglContext = false;
                GLTextureView.sGLThreadManager.releaseEglContextLocked(this);
            }
        }

        private void stopEglSurfaceLocked() {
            if (this.mHaveEglSurface) {
                this.mHaveEglSurface = false;
                this.mEglHelper.destroySurface();
            }
        }

        public boolean ableToDraw() {
            return this.mHaveEglContext && this.mHaveEglSurface && readyToDraw();
        }

        public int getRenderMode() {
            int i2;
            synchronized (GLTextureView.sGLThreadManager) {
                i2 = this.mRenderMode;
            }
            return i2;
        }

        public void onPause() {
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

        public void onResume() {
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

        public void onWindowResize(int i2, int i3) {
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

        public void queueEvent(Runnable runnable) {
            if (runnable != null) {
                synchronized (GLTextureView.sGLThreadManager) {
                    this.mEventQueue.add(runnable);
                    GLTextureView.sGLThreadManager.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }

        public void requestExitAndWait() {
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

        public void requestReleaseEglContextLocked() {
            this.mShouldReleaseEglContext = true;
            GLTextureView.sGLThreadManager.notifyAll();
        }

        public void requestRender() {
            synchronized (GLTextureView.sGLThreadManager) {
                this.mRequestRender = true;
                GLTextureView.sGLThreadManager.notifyAll();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
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

        public void setRenderMode(int i2) {
            if (i2 >= 0 && i2 <= 1) {
                synchronized (GLTextureView.sGLThreadManager) {
                    this.mRenderMode = i2;
                    GLTextureView.sGLThreadManager.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public void surfaceCreated() {
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

        public void surfaceDestroyed() {
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

    /* loaded from: classes2.dex */
    public static class GLThreadManager {
        public static String TAG = "GLThreadManager";
        public static final int kGLES_20 = 131072;
        public static final String kMSM7K_RENDERER_PREFIX = "Q3Dimension MSM7500 ";
        public GLThread mEglOwner;
        public boolean mGLESDriverCheckComplete;
        public int mGLESVersion;
        public boolean mGLESVersionCheckComplete;
        public boolean mLimitedGLESContexts;
        public boolean mMultipleGLESContextsAllowed;

        public GLThreadManager() {
        }

        private void checkGLESVersion() {
            if (this.mGLESVersionCheckComplete) {
                return;
            }
            this.mGLESVersionCheckComplete = true;
        }

        public synchronized void checkGLDriver(GL10 gl10) {
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

        public void releaseEglContextLocked(GLThread gLThread) {
            if (this.mEglOwner == gLThread) {
                this.mEglOwner = null;
            }
            notifyAll();
        }

        public synchronized boolean shouldReleaseEGLContextWhenPausing() {
            return this.mLimitedGLESContexts;
        }

        public synchronized boolean shouldTerminateEGLWhenPausing() {
            checkGLESVersion();
            return !this.mMultipleGLESContextsAllowed;
        }

        public synchronized void threadExiting(GLThread gLThread) {
            gLThread.mExited = true;
            if (this.mEglOwner == gLThread) {
                this.mEglOwner = null;
            }
            notifyAll();
        }

        public boolean tryAcquireEglContextLocked(GLThread gLThread) {
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
    }

    /* loaded from: classes2.dex */
    public interface GLWrapper {
        GL wrap(GL gl);
    }

    /* loaded from: classes2.dex */
    public static class LogWriter extends Writer {
        public StringBuilder mBuilder = new StringBuilder();

        private void flushBuilder() {
            if (this.mBuilder.length() > 0) {
                Log.v(GLTextureView.TAG, this.mBuilder.toString());
                StringBuilder sb = this.mBuilder;
                sb.delete(0, sb.length());
            }
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            flushBuilder();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            flushBuilder();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i2, int i3) {
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

    /* loaded from: classes2.dex */
    public interface Renderer {
        void onDrawFrame(GL10 gl10);

        void onSurfaceChanged(GL10 gl10, int i2, int i3);

        void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig);
    }

    /* loaded from: classes2.dex */
    public class SimpleEGLConfigChooser extends ComponentSizeChooser {
        public SimpleEGLConfigChooser(boolean z) {
            super(8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    public GLTextureView(Context context) {
        super(context);
        this.mThisWeakRef = new WeakReference<>(this);
        init();
    }

    private void checkRenderThreadState() {
        if (this.mGLThread != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void finalize() throws Throwable {
        try {
            if (this.mGLThread != null) {
                this.mGLThread.requestExitAndWait();
            }
        } finally {
            super.finalize();
        }
    }

    public int getDebugFlags() {
        return this.mDebugFlags;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.mPreserveEGLContextOnPause;
    }

    public int getRenderMode() {
        return this.mGLThread.getRenderMode();
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        surfaceChanged(getSurfaceTexture(), 0, i4 - i2, i5 - i3);
    }

    public void onPause() {
        this.mGLThread.onPause();
    }

    public void onResume() {
        this.mGLThread.onResume();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        surfaceCreated(surfaceTexture);
        surfaceChanged(surfaceTexture, 0, i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        surfaceDestroyed(surfaceTexture);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        surfaceChanged(surfaceTexture, 0, i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void queueEvent(Runnable runnable) {
        this.mGLThread.queueEvent(runnable);
    }

    public void requestRender() {
        this.mGLThread.requestRender();
    }

    public void setDebugFlags(int i2) {
        this.mDebugFlags = i2;
    }

    public void setEGLConfigChooser(EGLConfigChooser eGLConfigChooser) {
        checkRenderThreadState();
        this.mEGLConfigChooser = eGLConfigChooser;
    }

    public void setEGLContextClientVersion(int i2) {
        checkRenderThreadState();
        this.mEGLContextClientVersion = i2;
    }

    public void setEGLContextFactory(EGLContextFactory eGLContextFactory) {
        checkRenderThreadState();
        this.mEGLContextFactory = eGLContextFactory;
    }

    public void setEGLWindowSurfaceFactory(EGLWindowSurfaceFactory eGLWindowSurfaceFactory) {
        checkRenderThreadState();
        this.mEGLWindowSurfaceFactory = eGLWindowSurfaceFactory;
    }

    public void setGLWrapper(GLWrapper gLWrapper) {
        this.mGLWrapper = gLWrapper;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.mPreserveEGLContextOnPause = z;
    }

    public void setRenderMode(int i2) {
        this.mGLThread.setRenderMode(i2);
    }

    public void setRenderer(Renderer renderer) {
        checkRenderThreadState();
        if (this.mEGLConfigChooser == null) {
            this.mEGLConfigChooser = new SimpleEGLConfigChooser(true);
        }
        if (this.mEGLContextFactory == null) {
            this.mEGLContextFactory = new DefaultContextFactory();
        }
        if (this.mEGLWindowSurfaceFactory == null) {
            this.mEGLWindowSurfaceFactory = new DefaultWindowSurfaceFactory();
        }
        this.mRenderer = renderer;
        GLThread gLThread = new GLThread(this.mThisWeakRef);
        this.mGLThread = gLThread;
        gLThread.start();
    }

    public void surfaceChanged(SurfaceTexture surfaceTexture, int i2, int i3, int i4) {
        this.mGLThread.onWindowResize(i3, i4);
    }

    public void surfaceCreated(SurfaceTexture surfaceTexture) {
        this.mGLThread.surfaceCreated();
    }

    public void surfaceDestroyed(SurfaceTexture surfaceTexture) {
        this.mGLThread.surfaceDestroyed();
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new SimpleEGLConfigChooser(z));
    }

    public GLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mThisWeakRef = new WeakReference<>(this);
        init();
    }

    public void setEGLConfigChooser(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser(new ComponentSizeChooser(i2, i3, i4, i5, i6, i7));
    }
}
