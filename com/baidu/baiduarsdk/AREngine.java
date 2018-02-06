package com.baidu.baiduarsdk;

import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes3.dex */
public final class AREngine {
    private static final boolean LOG_PAUSE_RESUME = false;
    private static final boolean LOG_RENDERER = false;
    private static final boolean LOG_RENDERER_DRAW_FRAME = false;
    private static final boolean LOG_SURFACE = false;
    private static final boolean LOG_THREADS = false;
    public static final int RENDERMODE_CONTINUOUSLY = 1;
    public static final int RENDERMODE_WHEN_DIRTY = 0;
    private static final String TAG = "GLSurfaceView";
    private static final GLThreadManager sGLThreadManager = new GLThreadManager();
    private AREGLConfigChooser mEGLConfigChooser;
    private AREGLContextFactory mEGLContextFactory;
    private AREGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
    private ARGLThread mGLThread;
    private GLSurfaceView.Renderer mRenderer;
    private Object mSurface;
    private long mCurrentGLThreadID = -1;
    private boolean mHasInitialled = false;
    private final WeakReference<AREngine> mThisWeakRef = new WeakReference<>(this);

    /* loaded from: classes3.dex */
    private static class ARComponentSizeChooser implements AREGLConfigChooser {
        protected int mAlphaSize;
        protected int mBlueSize;
        protected int[] mConfigSpec;
        protected int mDepthSize;
        protected int mGreenSize;
        protected int mRedSize;
        protected int mStencilSize;
        private int[] mValue = new int[1];

        public ARComponentSizeChooser(int i, int i2, int i3, int i4, int i5, int i6) {
            this.mRedSize = i;
            this.mGreenSize = i2;
            this.mBlueSize = i3;
            this.mAlphaSize = i4;
            this.mDepthSize = i5;
            this.mStencilSize = i6;
            this.mConfigSpec = new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12352, 4, 12344};
        }

        private int findConfigAttrib(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.mValue) ? this.mValue[0] : i2;
        }

        @Override // com.baidu.baiduarsdk.AREngine.AREGLConfigChooser
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.mConfigSpec, null, 0, iArr)) {
                int i = iArr[0];
                if (i <= 0) {
                    throw new IllegalArgumentException("No configs match configSpec");
                }
                EGLConfig[] eGLConfigArr = new EGLConfig[i];
                if (egl10.eglChooseConfig(eGLDisplay, this.mConfigSpec, eGLConfigArr, i, iArr)) {
                    EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
                    if (chooseConfig == null) {
                        throw new IllegalArgumentException("No config chosen");
                    }
                    return chooseConfig;
                }
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
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

    /* loaded from: classes3.dex */
    private static class ARContextFactory implements AREGLContextFactory {
        private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;

        private ARContextFactory() {
        }

        @Override // com.baidu.baiduarsdk.AREngine.AREGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
        }

        @Override // com.baidu.baiduarsdk.AREngine.AREGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
        }
    }

    /* loaded from: classes3.dex */
    private static class ARDefaultWindowSurfaceFactory implements AREGLWindowSurfaceFactory {
        private ARDefaultWindowSurfaceFactory() {
        }

        @Override // com.baidu.baiduarsdk.AREngine.AREGLWindowSurfaceFactory
        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                Log.e(AREngine.TAG, "eglCreateWindowSurface", e);
                return null;
            }
        }

        @Override // com.baidu.baiduarsdk.AREngine.AREGLWindowSurfaceFactory
        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* loaded from: classes3.dex */
    public interface AREGLConfigChooser {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* loaded from: classes3.dex */
    public interface AREGLContextFactory {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* loaded from: classes3.dex */
    public interface AREGLWindowSurfaceFactory {
        EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class ARGLThread extends Thread {
        private WeakReference<AREngine> mAREngineWeakRef;
        private EglHelper mEglHelper;
        private boolean mExited;
        private boolean mFinishedCreatingEglSurface;
        private boolean mHasSurface;
        private boolean mHaveEglContext;
        private boolean mHaveEglSurface;
        private boolean mPaused;
        private boolean mRenderComplete;
        private boolean mRequestPaused;
        private boolean mShouldExit;
        private boolean mShouldReleaseEglContext;
        private boolean mSurfaceIsBad;
        private boolean mWaitingForSurface;
        private ArrayList<Runnable> mEventQueue = new ArrayList<>();
        private boolean mSizeChanged = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean mRequestRender = true;
        private int mRenderMode = 1;
        private boolean mWantRenderNotification = false;

        ARGLThread(WeakReference<AREngine> weakReference) {
            this.mAREngineWeakRef = weakReference;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX WARN: Removed duplicated region for block: B:129:0x0271  */
        /* JADX WARN: Removed duplicated region for block: B:156:0x02d2  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void guardedRun() {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            Runnable runnable;
            boolean z5;
            boolean z6;
            int i;
            boolean z7;
            int i2;
            boolean z8;
            boolean z9;
            GL10 gl10;
            boolean z10;
            boolean z11;
            boolean z12;
            boolean z13;
            boolean z14;
            this.mEglHelper = new EglHelper(this.mAREngineWeakRef);
            this.mHaveEglContext = false;
            this.mHaveEglSurface = false;
            this.mWantRenderNotification = false;
            GL10 gl102 = null;
            boolean z15 = false;
            int i3 = 0;
            boolean z16 = false;
            int i4 = 0;
            boolean z17 = false;
            boolean z18 = false;
            Runnable runnable2 = null;
            boolean z19 = false;
            boolean z20 = false;
            boolean z21 = false;
            boolean z22 = false;
            while (true) {
                try {
                    synchronized (AREngine.sGLThreadManager) {
                        while (!this.mShouldExit) {
                            if (this.mHaveEglContext && this.mHaveEglSurface && !this.mEventQueue.isEmpty()) {
                                z = z22;
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                runnable = this.mEventQueue.remove(0);
                                z5 = z18;
                                z6 = z17;
                                i = i4;
                                z7 = z16;
                                i2 = i3;
                                z8 = z15;
                            } else {
                                boolean z23 = false;
                                if (this.mPaused != this.mRequestPaused) {
                                    z23 = this.mRequestPaused;
                                    this.mPaused = this.mRequestPaused;
                                    AREngine.sGLThreadManager.notifyAll();
                                }
                                if (this.mShouldReleaseEglContext) {
                                    stopEglSurfaceLocked();
                                    stopEglContextLocked();
                                    this.mShouldReleaseEglContext = false;
                                    z20 = true;
                                }
                                if (z16) {
                                    stopEglSurfaceLocked();
                                    stopEglContextLocked();
                                    z16 = false;
                                }
                                if (z23 && this.mHaveEglSurface) {
                                    stopEglSurfaceLocked();
                                }
                                if (!z23 || this.mHaveEglContext) {
                                }
                                if (!this.mHasSurface && !this.mWaitingForSurface) {
                                    if (this.mHaveEglSurface) {
                                        stopEglSurfaceLocked();
                                    }
                                    this.mWaitingForSurface = true;
                                    this.mSurfaceIsBad = false;
                                    AREngine.sGLThreadManager.notifyAll();
                                }
                                if (this.mHasSurface && this.mWaitingForSurface) {
                                    this.mWaitingForSurface = false;
                                    AREngine.sGLThreadManager.notifyAll();
                                }
                                if (z15) {
                                    this.mWantRenderNotification = false;
                                    z15 = false;
                                    this.mRenderComplete = true;
                                    AREngine.sGLThreadManager.notifyAll();
                                }
                                if (readyToDraw()) {
                                    if (!this.mHaveEglContext) {
                                        if (z20) {
                                            z20 = false;
                                        } else {
                                            try {
                                                this.mEglHelper.start();
                                                this.mHaveEglContext = true;
                                                z22 = true;
                                                AREngine.sGLThreadManager.notifyAll();
                                            } catch (RuntimeException e) {
                                                AREngine.sGLThreadManager.releaseEglContextLocked(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (this.mHaveEglContext && !this.mHaveEglSurface) {
                                        this.mHaveEglSurface = true;
                                        z18 = true;
                                        z21 = true;
                                        z17 = true;
                                    }
                                    if (this.mHaveEglSurface) {
                                        if (this.mSizeChanged) {
                                            z17 = true;
                                            i3 = this.mWidth;
                                            i4 = this.mHeight;
                                            this.mWantRenderNotification = true;
                                            z18 = true;
                                            this.mSizeChanged = false;
                                        }
                                        this.mRequestRender = false;
                                        AREngine.sGLThreadManager.notifyAll();
                                        if (this.mWantRenderNotification) {
                                            z = z22;
                                            z2 = z21;
                                            z3 = z20;
                                            z4 = true;
                                            runnable = runnable2;
                                            z5 = z18;
                                            z6 = z17;
                                            i = i4;
                                            z7 = z16;
                                            i2 = i3;
                                            z8 = z15;
                                        } else {
                                            z = z22;
                                            z2 = z21;
                                            z3 = z20;
                                            z4 = z19;
                                            runnable = runnable2;
                                            z5 = z18;
                                            z6 = z17;
                                            i = i4;
                                            z7 = z16;
                                            i2 = i3;
                                            z8 = z15;
                                        }
                                    }
                                }
                                AREngine.sGLThreadManager.wait();
                            }
                        }
                        synchronized (AREngine.sGLThreadManager) {
                            stopEglSurfaceLocked();
                            stopEglContextLocked();
                        }
                        return;
                    }
                    if (runnable != null) {
                        runnable.run();
                        z15 = z8;
                        i3 = i2;
                        z16 = z7;
                        i4 = i;
                        z17 = z6;
                        z18 = z5;
                        runnable2 = null;
                        z19 = z4;
                        z20 = z3;
                        z21 = z2;
                        z22 = z;
                    } else {
                        if (!z5) {
                            z9 = z5;
                        } else if (this.mEglHelper.createSurface()) {
                            synchronized (AREngine.sGLThreadManager) {
                                this.mFinishedCreatingEglSurface = true;
                                AREngine.sGLThreadManager.notifyAll();
                            }
                            z9 = false;
                        } else {
                            synchronized (AREngine.sGLThreadManager) {
                                this.mFinishedCreatingEglSurface = true;
                                this.mSurfaceIsBad = true;
                                AREngine.sGLThreadManager.notifyAll();
                            }
                            z15 = z8;
                            i3 = i2;
                            z16 = z7;
                            i4 = i;
                            z17 = z6;
                            z18 = z5;
                            runnable2 = runnable;
                            z19 = z4;
                            z20 = z3;
                            z21 = z2;
                            z22 = z;
                        }
                        if (z2) {
                            z10 = false;
                            gl10 = (GL10) this.mEglHelper.createGL();
                        } else {
                            gl10 = gl102;
                            z10 = z2;
                        }
                        if (z) {
                            AREngine aREngine = this.mAREngineWeakRef.get();
                            if (aREngine != null) {
                                aREngine.mRenderer.onSurfaceCreated(gl10, this.mEglHelper.mEglConfig);
                            }
                            z = false;
                        }
                        if (z6) {
                            AREngine aREngine2 = this.mAREngineWeakRef.get();
                            if (aREngine2 != null) {
                                aREngine2.mRenderer.onSurfaceChanged(gl10, i2, i);
                            }
                            z6 = false;
                        }
                        AREngine aREngine3 = this.mAREngineWeakRef.get();
                        if (aREngine3 != null) {
                            if (aREngine3.mHasInitialled) {
                                aREngine3.mRenderer.onDrawFrame(gl10);
                                int swap = this.mEglHelper.swap();
                                switch (swap) {
                                    case 12288:
                                        z14 = z7;
                                        break;
                                    case 12302:
                                        z14 = true;
                                        break;
                                    default:
                                        EglHelper.logEglErrorAsWarning("GLThread", "eglSwapBuffers", swap);
                                        synchronized (AREngine.sGLThreadManager) {
                                            this.mSurfaceIsBad = true;
                                            AREngine.sGLThreadManager.notifyAll();
                                        }
                                        z14 = z7;
                                        break;
                                }
                                z11 = z14;
                                if (z4) {
                                    z12 = z8;
                                    z13 = z4;
                                } else {
                                    z12 = true;
                                    z13 = false;
                                }
                                i3 = i2;
                                z20 = z3;
                                z16 = z11;
                                z21 = z10;
                                z22 = z;
                                gl102 = gl10;
                                boolean z24 = z6;
                                z18 = z9;
                                z15 = z12;
                                runnable2 = runnable;
                                z19 = z13;
                                i4 = i;
                                z17 = z24;
                            } else {
                                aREngine3.mHasInitialled = true;
                            }
                        }
                        z11 = z7;
                        if (z4) {
                        }
                        i3 = i2;
                        z20 = z3;
                        z16 = z11;
                        z21 = z10;
                        z22 = z;
                        gl102 = gl10;
                        boolean z242 = z6;
                        z18 = z9;
                        z15 = z12;
                        runnable2 = runnable;
                        z19 = z13;
                        i4 = i;
                        z17 = z242;
                    }
                } catch (Throwable th) {
                    synchronized (AREngine.sGLThreadManager) {
                        stopEglSurfaceLocked();
                        stopEglContextLocked();
                        throw th;
                    }
                }
            }
        }

        private boolean readyToDraw() {
            return !this.mPaused && this.mHasSurface && !this.mSurfaceIsBad && this.mWidth > 0 && this.mHeight > 0 && (this.mRequestRender || this.mRenderMode == 1);
        }

        private void stopEglContextLocked() {
            if (this.mHaveEglContext) {
                this.mEglHelper.finish();
                this.mHaveEglContext = false;
                AREngine.sGLThreadManager.releaseEglContextLocked(this);
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
            int i;
            synchronized (AREngine.sGLThreadManager) {
                i = this.mRenderMode;
            }
            return i;
        }

        public void onPause() {
            synchronized (AREngine.sGLThreadManager) {
                this.mRequestPaused = true;
                AREngine.sGLThreadManager.notifyAll();
                while (!this.mExited && !this.mPaused) {
                    try {
                        AREngine.sGLThreadManager.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (AREngine.sGLThreadManager) {
                this.mRequestPaused = false;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                AREngine.sGLThreadManager.notifyAll();
                while (!this.mExited && this.mPaused && !this.mRenderComplete) {
                    try {
                        AREngine.sGLThreadManager.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onWindowResize(int i, int i2) {
            synchronized (AREngine.sGLThreadManager) {
                this.mWidth = i;
                this.mHeight = i2;
                this.mSizeChanged = true;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                if (Thread.currentThread() == this) {
                    return;
                }
                AREngine.sGLThreadManager.notifyAll();
                while (!this.mExited && !this.mPaused && !this.mRenderComplete && ableToDraw()) {
                    try {
                        AREngine.sGLThreadManager.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void queueEvent(Runnable runnable) {
            if (runnable == null) {
                throw new IllegalArgumentException("r must not be null");
            }
            synchronized (AREngine.sGLThreadManager) {
                this.mEventQueue.add(runnable);
                AREngine.sGLThreadManager.notifyAll();
            }
        }

        public void requestExitAndWait() {
            synchronized (AREngine.sGLThreadManager) {
                this.mShouldExit = true;
                AREngine.sGLThreadManager.notifyAll();
                while (!this.mExited) {
                    try {
                        AREngine.sGLThreadManager.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void requestReleaseEglContextLocked() {
            this.mShouldReleaseEglContext = true;
            AREngine.sGLThreadManager.notifyAll();
        }

        public void requestRender() {
            synchronized (AREngine.sGLThreadManager) {
                this.mRequestRender = true;
                AREngine.sGLThreadManager.notifyAll();
            }
        }

        public void requestRenderAndWait() {
            synchronized (AREngine.sGLThreadManager) {
                if (Thread.currentThread() == this) {
                    return;
                }
                this.mWantRenderNotification = true;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                AREngine.sGLThreadManager.notifyAll();
                while (!this.mExited && !this.mPaused && !this.mRenderComplete && ableToDraw()) {
                    try {
                        AREngine.sGLThreadManager.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("ARGLThread " + getId());
            try {
                guardedRun();
            } catch (InterruptedException e) {
            } finally {
                AREngine.sGLThreadManager.threadExiting(this);
            }
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (AREngine.sGLThreadManager) {
                this.mRenderMode = i;
                AREngine.sGLThreadManager.notifyAll();
            }
        }

        public void surfaceCreated() {
            synchronized (AREngine.sGLThreadManager) {
                this.mHasSurface = true;
                this.mFinishedCreatingEglSurface = false;
                AREngine.sGLThreadManager.notifyAll();
                while (this.mWaitingForSurface && !this.mFinishedCreatingEglSurface && !this.mExited) {
                    try {
                        AREngine.sGLThreadManager.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (AREngine.sGLThreadManager) {
                this.mHasSurface = false;
                AREngine.sGLThreadManager.notifyAll();
                while (!this.mWaitingForSurface && !this.mExited) {
                    try {
                        AREngine.sGLThreadManager.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class EglHelper {
        private WeakReference<AREngine> mAREngineWeakRef;
        EGL10 mEgl;
        EGLConfig mEglConfig;
        EGLContext mEglContext;
        EGLDisplay mEglDisplay;
        EGLSurface mEglSurface;

        public EglHelper(WeakReference<AREngine> weakReference) {
            this.mAREngineWeakRef = weakReference;
        }

        private void destroySurfaceImp() {
            if (this.mEglSurface == null || this.mEglSurface == EGL10.EGL_NO_SURFACE) {
                return;
            }
            this.mEgl.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            AREngine aREngine = this.mAREngineWeakRef.get();
            if (aREngine != null) {
                aREngine.mEGLWindowSurfaceFactory.destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
            }
            this.mEglSurface = null;
        }

        public static String formatEglError(String str, int i) {
            return str + " failed: " + i;
        }

        public static void logEglErrorAsWarning(String str, String str2, int i) {
            Log.w(str, formatEglError(str2, i));
        }

        private void throwEglException(String str) {
            throwEglException(str, this.mEgl.eglGetError());
        }

        public static void throwEglException(String str, int i) {
            throw new RuntimeException(formatEglError(str, i));
        }

        GL createGL() {
            return this.mEglContext.getGL();
        }

        public boolean createSurface() {
            if (this.mEgl == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.mEglDisplay == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.mEglConfig == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            destroySurfaceImp();
            AREngine aREngine = this.mAREngineWeakRef.get();
            if (aREngine == null || aREngine.mSurface == null) {
                this.mEglSurface = null;
            } else {
                this.mEglSurface = aREngine.mEGLWindowSurfaceFactory.createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, aREngine.mSurface);
            }
            if (this.mEglSurface == null || this.mEglSurface == EGL10.EGL_NO_SURFACE) {
                if (this.mEgl.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (this.mEgl.eglMakeCurrent(this.mEglDisplay, this.mEglSurface, this.mEglSurface, this.mEglContext)) {
                return true;
            } else {
                logEglErrorAsWarning("EGLHelper", "eglMakeCurrent", this.mEgl.eglGetError());
                return false;
            }
        }

        public void destroySurface() {
            destroySurfaceImp();
        }

        public void finish() {
            if (this.mEglContext != null) {
                AREngine aREngine = this.mAREngineWeakRef.get();
                if (aREngine != null) {
                    aREngine.mEGLContextFactory.destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
                    aREngine.mCurrentGLThreadID = -1L;
                }
                this.mEglContext = null;
            }
            if (this.mEglDisplay != null) {
                this.mEgl.eglTerminate(this.mEglDisplay);
                this.mEglDisplay = null;
            }
        }

        public void start() {
            this.mEgl = (EGL10) EGLContext.getEGL();
            this.mEglDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.mEglDisplay == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.mEgl.eglInitialize(this.mEglDisplay, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            AREngine aREngine = this.mAREngineWeakRef.get();
            if (aREngine == null) {
                this.mEglConfig = null;
                this.mEglContext = null;
            } else {
                this.mEglConfig = aREngine.mEGLConfigChooser.chooseConfig(this.mEgl, this.mEglDisplay);
                this.mEglContext = aREngine.mEGLContextFactory.createContext(this.mEgl, this.mEglDisplay, this.mEglConfig);
                aREngine.mCurrentGLThreadID = Thread.currentThread().getId();
            }
            if (this.mEglContext == null || this.mEglContext == EGL10.EGL_NO_CONTEXT) {
                this.mEglContext = null;
                throwEglException("createContext");
            }
            this.mEglSurface = null;
        }

        public int swap() {
            if (this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface)) {
                return 12288;
            }
            return this.mEgl.eglGetError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class GLThreadManager {
        private static String TAG = "GLThreadManager";
        private static final int kGLES_20 = 131072;
        private ARGLThread mEglOwner;
        private int mGLESVersion;
        private boolean mGLESVersionCheckComplete;
        private boolean mMultipleGLESContextsAllowed;

        private GLThreadManager() {
        }

        private void checkGLESVersion() {
            if (this.mGLESVersionCheckComplete) {
                return;
            }
            this.mGLESVersion = 131072;
            if (this.mGLESVersion >= 131072) {
                this.mMultipleGLESContextsAllowed = true;
            }
            this.mGLESVersionCheckComplete = true;
        }

        public void releaseEglContextLocked(ARGLThread aRGLThread) {
            if (this.mEglOwner == aRGLThread) {
                this.mEglOwner = null;
            }
            notifyAll();
        }

        public synchronized void threadExiting(ARGLThread aRGLThread) {
            aRGLThread.mExited = true;
            if (this.mEglOwner == aRGLThread) {
                this.mEglOwner = null;
            }
            notifyAll();
        }

        public boolean tryAcquireEglContextLocked(ARGLThread aRGLThread) {
            if (this.mEglOwner == aRGLThread || this.mEglOwner == null) {
                this.mEglOwner = aRGLThread;
                notifyAll();
                return true;
            }
            checkGLESVersion();
            if (this.mMultipleGLESContextsAllowed) {
                return true;
            }
            if (this.mEglOwner != null) {
                this.mEglOwner.requestReleaseEglContextLocked();
            }
            return false;
        }
    }

    private static void checkEglError(String str, EGL10 egl10) {
        while (true) {
            int eglGetError = egl10.eglGetError();
            if (eglGetError == 12288) {
                return;
            }
            Log.e(TAG, String.format("%s: EGL error: 0x%x", str, Integer.valueOf(eglGetError)));
        }
    }

    public void exitGLThread() {
        if (this.mGLThread != null) {
            this.mGLThread.requestExitAndWait();
        }
    }

    protected void finalize() {
        try {
            if (this.mGLThread != null) {
                this.mGLThread.requestExitAndWait();
            }
        } finally {
            super.finalize();
        }
    }

    public long getCurrentGLThreadID() {
        return this.mCurrentGLThreadID;
    }

    public int getRenderMode() {
        return this.mGLThread.getRenderMode();
    }

    public void onPause() {
        this.mGLThread.onPause();
    }

    public void onResume() {
        this.mGLThread.onResume();
    }

    public void queueEvent(Runnable runnable) {
        this.mGLThread.queueEvent(runnable);
    }

    public void requestRender() {
        this.mGLThread.requestRender();
    }

    public void requestRenderAndWait() {
        this.mGLThread.requestRenderAndWait();
    }

    public void setRenderMode(int i) {
        this.mGLThread.setRenderMode(i);
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        if (this.mEGLConfigChooser == null) {
            this.mEGLConfigChooser = new ARComponentSizeChooser(8, 8, 8, 8, 16, 0);
        }
        if (this.mEGLContextFactory == null) {
            this.mEGLContextFactory = new ARContextFactory();
        }
        if (this.mEGLWindowSurfaceFactory == null) {
            this.mEGLWindowSurfaceFactory = new ARDefaultWindowSurfaceFactory();
        }
        this.mRenderer = renderer;
        this.mGLThread = new ARGLThread(this.mThisWeakRef);
        this.mGLThread.start();
    }

    public void setSurface(Object obj, int i, int i2) {
        this.mSurface = obj;
        if (Build.VERSION.SDK_INT >= 15 && this.mSurface != null && (this.mSurface instanceof SurfaceTexture)) {
            ((SurfaceTexture) this.mSurface).setDefaultBufferSize(i, i2);
        }
        if (this.mGLThread != null) {
            if (this.mSurface == null) {
                this.mGLThread.surfaceDestroyed();
                return;
            }
            this.mGLThread.surfaceCreated();
            this.mGLThread.onWindowResize(i, i2);
        }
    }
}
