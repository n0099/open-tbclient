package com.baidu.smallgame.sdk;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLSurfaceView;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.bean.PerformanceJsonBean;
import com.baidu.searchbox.v8engine.console.DebugConsole;
import com.baidu.smallgame.sdk.ArBridge;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.heytap.mcssdk.mode.CommandMessage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public final class a implements AREngineDelegate {
    public static PermissionProxy bJQ = null;
    public static int bJR = 0;
    private ArBridge bJS;
    private GLSurfaceView.Renderer bJV;
    private Object bJY;
    private C0283a bJZ;
    private Context mContext;
    private boolean mDetached;
    private SurfaceHolder mSurfaceHolder;
    private ArrayList<DebugConsole> mConsoles = null;
    private int mFPS = 0;
    private long mCurrentGLThreadID = -1;
    private float bJT = 0.0f;
    private float bJU = 0.0f;
    private boolean bJW = false;
    private final c bJX = new c();

    public Context getContext() {
        return this.mContext;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        Log.setMinLogLevel(6, false);
        this.bJS = new ArBridge();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void startEngine() {
        if (this.bJV == null) {
            throw new NullPointerException("start render engine failed. because renderer is not set");
        }
        this.bJZ = new C0283a(this);
        this.bJZ.start();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public synchronized void addDebugConsole(DebugConsole debugConsole) {
        if (this.mConsoles == null) {
            this.mConsoles = new ArrayList<>(1);
        }
        this.mConsoles.add(debugConsole);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public synchronized void removeDebugConsole(DebugConsole debugConsole) {
        if (this.mConsoles != null) {
            this.mConsoles.remove(debugConsole);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(int i, String str) {
        if (this.mConsoles != null) {
            for (DebugConsole debugConsole : new ArrayList(this.mConsoles)) {
                debugConsole.onReceiveInfo(i, str);
            }
        }
    }

    public ArBridge Rw() {
        return this.bJS;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public Thread getGLThread() {
        return this.bJZ;
    }

    void em(int i) {
        int i2 = i < 0 ? 0 : i;
        this.mFPS = i2 <= 60 ? i2 : 60;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public int getFPS() {
        return this.mFPS;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void updateSurfaceViewSize(float f, float f2) {
        Log.w("EngineLogger", "[ARDispose] updateSurfaceViewSize, width=" + f + ", height=" + f2);
        this.bJT = f;
        this.bJU = f2;
        this.bJS.setSize(f, f2);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void initDisplayMetrics() {
        Context context = getContext();
        if (context == null) {
            throw new NullPointerException("[RenderError] initDisplayMetrics Error. because AppContext is null");
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        float f = displayMetrics.widthPixels;
        float f2 = displayMetrics.heightPixels;
        if (this.bJT != 0.0f) {
            f = this.bJT;
        }
        if (this.bJU != 0.0f) {
            f2 = this.bJU;
        }
        if (this.bJS != null) {
            this.bJS.setDisplayMetrics(f, f2, displayMetrics.xdpi, displayMetrics.ydpi, displayMetrics.density);
        } else {
            Log.e("EngineLogger", "[RenderError] error init render display, because arbridge is null");
        }
    }

    public void c(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = (SurfaceHolder) new WeakReference(surfaceHolder).get();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderer(GLSurfaceView.Renderer renderer) {
        this.bJV = renderer;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderMode(int i) {
        if (this.bJZ != null) {
            this.bJZ.setRenderMode(i);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public int getRenderMode() {
        if (this.bJZ != null) {
            return this.bJZ.getRenderMode();
        }
        return 1;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRender() {
        if (this.bJZ != null) {
            this.bJZ.requestRender();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceCreated() {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceCreated.");
        this.bJZ.surfaceCreated();
        Context appContext = V8Engine.getAppContext();
        if (appContext != null) {
            bJR = ((WindowManager) appContext.getSystemService("window")).getDefaultDisplay().getRotation();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceDestroyed() {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceDestroyed.");
        this.bJZ.surfaceDestroyed();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceChanged(int i, int i2) {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceChanged. width=" + i + ", height=" + i2);
        this.bJZ.onWindowResize(i, i2);
        this.bJS.setEglContextToRecorder(getEGLContext(), i, i2);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRenderAndWait() {
        if (this.bJZ != null) {
            this.bJZ.requestRenderAndWait();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameOnPause() {
        this.bJS.smallGameOnPause();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void runOnGLThread(Runnable runnable) {
        if (this.bJZ != null) {
            this.bJZ.runOnGLThread(runnable);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable) {
        if (this.bJZ != null) {
            this.bJZ.queueEvent(runnable);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable, long j) {
        if (this.bJZ != null) {
            this.bJZ.b(runnable, j);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onAttachedToWindow() {
        if (this.mDetached && this.bJV != null) {
            int renderMode = this.bJZ != null ? this.bJZ.getRenderMode() : 1;
            this.bJZ = new C0283a(this);
            if (renderMode != 1) {
                this.bJZ.setRenderMode(renderMode);
            }
            this.bJZ.start();
        }
        this.mDetached = false;
        Log.w("EngineLogger", "[V8Dispose][AREngine] onAttachedToWindow");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onDetachedFromWindow() {
        if (!this.mDetached && this.bJZ != null) {
            this.bJZ.requestExitAndWait();
        }
        this.mDetached = true;
        Log.w("EngineLogger", "[V8Dispose][AREngine] onDetachedFromWindow");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void clearOldEvents() {
        if (this.bJZ != null) {
            this.bJZ.clearOldEvents();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onPause() {
        if (this.bJZ != null) {
            this.bJZ.onPause();
        }
        if (this.bJS.getGameRecorder() != null) {
            this.bJS.getGameRecorder().LZ();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onResume() {
        if (this.bJZ != null) {
            this.bJZ.onResume();
        }
        if (this.bJS.getGameRecorder() != null) {
            this.bJS.getGameRecorder().Ma();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void pauseRecord() {
        if (this.bJS.getGameRecorder() != null) {
            this.bJS.getGameRecorder().pauseRecord();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void resumeRecord() {
        if (this.bJS.getGameRecorder() != null) {
            this.bJS.getGameRecorder().resumeRecord();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void stopRecord() {
        if (this.bJS.getGameRecorder() != null) {
            this.bJS.getGameRecorder().stopRecord();
            this.bJS.nativeUpdateRecordingStatus(false);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (this.bJS.getGameRecorder() != null) {
            this.bJS.nativeUpdateRecordingStatus(true);
            this.bJS.getGameRecorder().startRecord(z, i, str, z2);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setGameRecordCallback(com.baidu.mario.a.c cVar) {
        if (this.bJS.getGameRecorder() != null) {
            this.bJS.getGameRecorder().setGameRecordCallback(cVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setAudioEngineProxy(com.baidu.mario.a.a aVar) {
        if (this.bJS.getGameRecorder() != null) {
            this.bJS.getGameRecorder().setAudioEngineProxy(aVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public long getCurrentRecordProcess() {
        if (this.bJS.getGameRecorder() != null) {
            return this.bJS.getGameRecorder().LY();
        }
        return 0L;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setPermissionProxy(PermissionProxy permissionProxy) {
        bJQ = permissionProxy;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setOnStuckScreenListener(com.baidu.smallgame.sdk.b.a aVar) {
        if (this.bJS != null) {
            this.bJS.setOnStuckScreenListener(aVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setStuckScreenLimitTime(long j) {
        if (this.bJS != null) {
            this.bJS.setStuckScreenLimitTime(j);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public com.baidu.smallgame.sdk.b.c getStuckScreenHandler() {
        if (this.bJS == null) {
            return null;
        }
        return this.bJS.getStuckScreenHandler();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameDestroy() {
        if (this.bJZ == null) {
            Log.e("EngineLogger", "Destroy AREngine fail. Because GLThread is null");
        } else {
            this.bJZ.runOnGLThread(new Runnable() { // from class: com.baidu.smallgame.sdk.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.bJZ.mShouldExit = true;
                    a.this.bJS.smallGameDestroy();
                }
            });
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public boolean ableToDraw() {
        return this.bJZ != null && this.bJZ.ableToDraw();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void exitGLThread() {
        if (this.bJZ != null) {
            this.bJZ.requestExitAndWait();
        }
        Log.e("EngineLogger", "[V8Dispose][AREngine] exitGLThread.");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameUpdate() {
        this.bJS.smallGameUpdate();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setScreenShotStatus(boolean z) {
        this.bJS.setScreenShotStatus(z);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public JSONArray getPerformanceJson() {
        return this.bJS == null ? new JSONArray() : this.bJS.getPerformanceJson();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public PerformanceJsonBean getPerformanceJsonBean() {
        return this.bJS == null ? new PerformanceJsonBean() : this.bJS.getPerformanceJsonBean();
    }

    public void gY(String str) {
        if (this.bJS != null) {
            this.bJS.getPerformanceJsonBean().put(str);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setFirstFrameListener(ArBridge.FirstFrameListener firstFrameListener) {
        this.bJS.setFirstFrameListener(firstFrameListener);
    }

    public EGLContext getEGLContext() {
        if (this.bJZ == null || this.bJZ.bKo == null) {
            return null;
        }
        return this.bJZ.bKo.mEglContext;
    }

    protected void finalize() throws Throwable {
        try {
            if (this.bJZ != null) {
                this.bJZ.requestExitAndWait();
            }
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.smallgame.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0283a extends Thread {
        private c bJX;
        private boolean bKj;
        private b bKo;
        private a bKp;
        private boolean mHasSurface;
        private boolean mHaveEglContext;
        private boolean mHaveEglSurface;
        private boolean mPaused;
        private boolean mRenderComplete;
        private boolean mRequestPaused;
        private boolean mShouldReleaseEglContext;
        private boolean mSurfaceIsBad;
        private boolean mWaitingForSurface;
        private int bKb = 0;
        private long bKc = 0;
        private long bKd = 0;
        private long bKe = 0;
        private long bKf = 0;
        private boolean bKg = false;
        private boolean bKh = false;
        private boolean bKi = false;
        private volatile boolean mShouldExit = false;
        private volatile boolean mExited = false;
        private LinkedList<Runnable> bKl = new LinkedList<>();
        private LinkedList<Runnable> bKm = new LinkedList<>();
        private TreeSet<d> bKn = new TreeSet<>();
        private boolean mSizeChanged = true;
        private V8Engine mV8Engine = null;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean mRequestRender = true;
        private int mRenderMode = 1;
        private boolean bKk = false;

        C0283a(a aVar) {
            this.bKp = aVar;
            this.bJX = aVar.bJX;
        }

        /* JADX WARN: Type inference failed for: r4v0, types: [com.baidu.smallgame.sdk.a, com.baidu.searchbox.v8engine.V8Engine, com.baidu.smallgame.sdk.a$b] */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("ARGLThread " + getId());
            if (this.bKp != null) {
                ArBridge Rw = this.bKp.Rw();
                if (Rw != null) {
                    Rw.setGLThreadID(getId());
                    Rw.smallGameOnInit();
                    this.bKp.initDisplayMetrics();
                } else {
                    Log.e("EngineLogger", "Render Engine Init Failed. ArBridge is null");
                }
            } else {
                Log.e("EngineLogger", "Render Engine Init Failed. AREngine is null");
            }
            try {
                guardedRun();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                this.bJX.b(this);
                this.bKo.reset();
                this.bKo = null;
                this.bKp = null;
                this.mV8Engine = null;
            }
        }

        private V8Engine getV8Engine() {
            if (this.mV8Engine == null) {
                this.mV8Engine = V8Engine.getInstance();
            }
            return this.mV8Engine;
        }

        private float minFramesInterval() {
            V8Engine v8Engine = getV8Engine();
            if (v8Engine != null) {
                return v8Engine.minFramesInterval();
            }
            return 16.666666f;
        }

        private void stopEglSurfaceLocked() {
            if (this.mHaveEglSurface) {
                this.mHaveEglSurface = false;
                this.bKo.destroySurface();
            }
        }

        private void stopEglContextLocked() {
            if (this.mHaveEglContext) {
                this.bKo.finish();
                this.mHaveEglContext = false;
                this.bJX.c(this);
            }
        }

        public boolean Rx() {
            return this.bKp.bJS.mFirstFrameFinished && ((float) (System.currentTimeMillis() - this.bKe)) > minFramesInterval();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1087=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX WARN: Code restructure failed: missing block: B:133:0x02f0, code lost:
            r11 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:134:0x02f1, code lost:
            r11.printStackTrace();
         */
        /* JADX WARN: Code restructure failed: missing block: B:135:0x02f6, code lost:
            if (r10 == false) goto L98;
         */
        /* JADX WARN: Code restructure failed: missing block: B:137:0x0300, code lost:
            if (r26.bKo.createSurface() == false) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:138:0x0302, code lost:
            r10 = r26.bJX;
         */
        /* JADX WARN: Code restructure failed: missing block: B:139:0x0306, code lost:
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:141:0x0308, code lost:
            r26.bKj = true;
            r26.bJX.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:142:0x0313, code lost:
            monitor-exit(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:143:0x0314, code lost:
            r12 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:144:0x0316, code lost:
            if (r9 == false) goto L97;
         */
        /* JADX WARN: Code restructure failed: missing block: B:145:0x0318, code lost:
            r11 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:146:0x031a, code lost:
            if (r8 == false) goto L96;
         */
        /* JADX WARN: Code restructure failed: missing block: B:147:0x031c, code lost:
            r8 = r26.bKp;
         */
        /* JADX WARN: Code restructure failed: missing block: B:148:0x0320, code lost:
            if (r8 == null) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:149:0x0322, code lost:
            r8.bJV.onSurfaceCreated(null, null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:150:0x032b, code lost:
            r10 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:151:0x032d, code lost:
            if (r7 == false) goto L95;
         */
        /* JADX WARN: Code restructure failed: missing block: B:152:0x032f, code lost:
            r7 = r26.bKp;
         */
        /* JADX WARN: Code restructure failed: missing block: B:153:0x0333, code lost:
            if (r7 == null) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:154:0x0335, code lost:
            r7.bJV.onSurfaceChanged(null, r15, r14);
            r7.updateSurfaceViewSize(r15, r14);
         */
        /* JADX WARN: Code restructure failed: missing block: B:155:0x0342, code lost:
            r9 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:156:0x0344, code lost:
            r0 = r26.bKp;
            r18 = java.lang.System.currentTimeMillis();
            r20 = r18 - r26.bKd;
         */
        /* JADX WARN: Code restructure failed: missing block: B:157:0x035a, code lost:
            if (r0.bJW == false) goto L93;
         */
        /* JADX WARN: Code restructure failed: missing block: B:159:0x0365, code lost:
            if (((float) r20) < minFramesInterval()) goto L93;
         */
        /* JADX WARN: Code restructure failed: missing block: B:160:0x0367, code lost:
            r26.bKd = java.lang.System.currentTimeMillis();
         */
        /* JADX WARN: Code restructure failed: missing block: B:161:0x0375, code lost:
            if (r26.bKg != false) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:163:0x037b, code lost:
            if (r26.bKp == null) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:164:0x037d, code lost:
            r26.bKg = true;
            r26.bKp.gY("first_frame");
         */
        /* JADX WARN: Code restructure failed: missing block: B:165:0x038c, code lost:
            r0.bJV.onDrawFrame(null);
            Ry();
         */
        /* JADX WARN: Code restructure failed: missing block: B:166:0x03a3, code lost:
            if ((r18 - r26.bKf) <= 33) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:167:0x03a5, code lost:
            r0.bJS.notifyFrameUpdated();
            r26.bKf = r18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:169:0x03b6, code lost:
            if (r26.bKi == false) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:170:0x03b8, code lost:
            r26.bKp.bJS.smallGameOnResume();
            r26.bKi = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:171:0x03c8, code lost:
            r8 = r0.bJS.shouldSwapBuffer();
         */
        /* JADX WARN: Code restructure failed: missing block: B:172:0x03d0, code lost:
            if (r8 == false) goto L92;
         */
        /* JADX WARN: Code restructure failed: missing block: B:173:0x03d2, code lost:
            r7 = r26.bKo.swap();
         */
        /* JADX WARN: Code restructure failed: missing block: B:174:0x03da, code lost:
            switch(r7) {
                case 12288: goto L90;
                case 12302: goto L91;
                default: goto L71;
            };
         */
        /* JADX WARN: Code restructure failed: missing block: B:175:0x03dd, code lost:
            com.baidu.smallgame.sdk.a.b.logEglErrorAsWarning("EngineLogger", "eglSwapBuffers", r7);
            r7 = r26.bJX;
         */
        /* JADX WARN: Code restructure failed: missing block: B:176:0x03ee, code lost:
            monitor-enter(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:178:0x03f1, code lost:
            r26.mSurfaceIsBad = true;
            r26.bJX.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:179:0x0400, code lost:
            monitor-exit(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:180:0x0401, code lost:
            r7 = r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:181:0x0402, code lost:
            r26.bKe = java.lang.System.currentTimeMillis();
         */
        /* JADX WARN: Code restructure failed: missing block: B:182:0x0418, code lost:
            if (r26.bKp.bJS.isRenderCallbackQueueEmpty() != false) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:183:0x041a, code lost:
            if (r8 == false) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:184:0x041c, code lost:
            r8 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:186:0x0428, code lost:
            if ((r0.bJS.getStuckScreenHandler() instanceof com.baidu.smallgame.sdk.b) == false) goto L84;
         */
        /* JADX WARN: Code restructure failed: missing block: B:187:0x042a, code lost:
            ((com.baidu.smallgame.sdk.b) r0.bJS.getStuckScreenHandler()).b(r8, r26.bKe);
         */
        /* JADX WARN: Code restructure failed: missing block: B:188:0x043f, code lost:
            if (r6 == false) goto L88;
         */
        /* JADX WARN: Code restructure failed: missing block: B:189:0x0441, code lost:
            r4 = true;
            r5 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:190:0x0443, code lost:
            r6 = r15;
            r8 = r4;
            r4 = r13;
            r13 = r12;
            r12 = r11;
            r11 = r7;
            r7 = r16;
            r24 = r5;
            r5 = r14;
            r14 = r10;
            r10 = r9;
            r9 = r24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:194:0x0457, code lost:
            r11 = r26.bJX;
         */
        /* JADX WARN: Code restructure failed: missing block: B:195:0x045b, code lost:
            monitor-enter(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:197:0x045d, code lost:
            r26.bKj = true;
            r26.mSurfaceIsBad = true;
            r26.bJX.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:198:0x046d, code lost:
            monitor-exit(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:199:0x046e, code lost:
            r11 = r4;
            r12 = r9;
            r9 = r6;
            r4 = r13;
            r6 = r15;
            r13 = r10;
            r10 = r7;
            r7 = r16;
            r24 = r14;
            r14 = r8;
            r8 = r5;
            r5 = r24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:203:0x0482, code lost:
            r7 = r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:204:0x0485, code lost:
            r7 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:208:0x048c, code lost:
            r8 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:209:0x048f, code lost:
            r0.bJW = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:210:0x0495, code lost:
            r7 = r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:214:0x049a, code lost:
            r4 = r5;
            r5 = r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:215:0x049d, code lost:
            r7 = r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:216:0x04a0, code lost:
            r9 = r7;
         */
        /* JADX WARN: Code restructure failed: missing block: B:217:0x04a3, code lost:
            r10 = r8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:218:0x04a6, code lost:
            r11 = r9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:219:0x04a9, code lost:
            r12 = r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0095, code lost:
            if (r13 == null) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x009b, code lost:
            if (r26.bKh != false) goto L106;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00a1, code lost:
            if (r26.bKp == null) goto L106;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00a3, code lost:
            r26.bKh = true;
            r26.bKp.gY("first_event");
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00b6, code lost:
            if (com.baidu.searchbox.v8engine.V8Engine.isDebug() == false) goto L111;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00bc, code lost:
            if (r26.bKp == null) goto L111;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00be, code lost:
            r26.bKp.N(1, r13.toString());
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00cc, code lost:
            r13.run();
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void guardedRun() throws InterruptedException {
            boolean z;
            Runnable runnable;
            int i;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            int i2;
            boolean z8;
            boolean z9;
            boolean z10;
            boolean z11;
            this.bKo = new b(this.bKp);
            this.mHaveEglContext = false;
            this.mHaveEglSurface = false;
            this.bKk = false;
            boolean z12 = false;
            boolean z13 = false;
            boolean z14 = false;
            boolean z15 = false;
            boolean z16 = false;
            boolean z17 = false;
            boolean z18 = false;
            boolean z19 = false;
            int i3 = 0;
            int i4 = 0;
            Runnable runnable2 = null;
            while (true) {
                try {
                    synchronized (this.bJX) {
                        z = z19;
                        boolean z20 = z18;
                        boolean z21 = z16;
                        boolean z22 = z15;
                        boolean z23 = z14;
                        boolean z24 = z13;
                        runnable = runnable2;
                        while (!this.mShouldExit) {
                            if (this.bKm.isEmpty()) {
                                if (ableToDraw()) {
                                    if (Rx()) {
                                        i = i3;
                                        z3 = z22;
                                        z2 = z17;
                                        z5 = z24;
                                        z4 = z23;
                                        int i5 = i4;
                                        z8 = z20;
                                        z6 = z21;
                                        z7 = z12;
                                        i2 = i5;
                                    } else {
                                        runnable = Rz();
                                        if (runnable != null) {
                                            i = i3;
                                            z3 = z22;
                                            z2 = z17;
                                            z5 = z24;
                                            z4 = z23;
                                            int i6 = i4;
                                            z8 = z20;
                                            z6 = z21;
                                            z7 = z12;
                                            i2 = i6;
                                        }
                                    }
                                }
                                boolean z25 = false;
                                if (this.mPaused != this.mRequestPaused) {
                                    z25 = this.mRequestPaused;
                                    this.mPaused = this.mRequestPaused;
                                    if (this.mRequestPaused) {
                                        this.bKi = false;
                                        this.bKp.bJS.smallGameOnPauseOnGLThrad();
                                    } else {
                                        this.bKi = true;
                                    }
                                    this.bJX.notifyAll();
                                    Log.i("EngineLogger", "mPaused is now " + this.mPaused + " tid=" + getId());
                                }
                                if (this.mShouldReleaseEglContext) {
                                    stopEglSurfaceLocked();
                                    stopEglContextLocked();
                                    this.mShouldReleaseEglContext = false;
                                    z = true;
                                }
                                if (z22) {
                                    stopEglSurfaceLocked();
                                    stopEglContextLocked();
                                    z22 = false;
                                }
                                if (z25 && this.mHaveEglSurface) {
                                    stopEglSurfaceLocked();
                                }
                                if (!z25 || this.mHaveEglContext) {
                                }
                                if (!this.mHasSurface && !this.mWaitingForSurface) {
                                    if (this.mHaveEglSurface) {
                                        stopEglSurfaceLocked();
                                    }
                                    this.mWaitingForSurface = true;
                                    this.mSurfaceIsBad = false;
                                    this.bJX.notifyAll();
                                }
                                if (this.mHasSurface && this.mWaitingForSurface) {
                                    this.mWaitingForSurface = false;
                                    this.bJX.notifyAll();
                                }
                                if (z20) {
                                    this.bKk = false;
                                    z9 = false;
                                    this.mRenderComplete = true;
                                    this.bJX.notifyAll();
                                } else {
                                    z9 = z20;
                                }
                                if (readyToDraw()) {
                                    if (!this.mHaveEglContext) {
                                        if (z) {
                                            z = false;
                                        } else {
                                            try {
                                                this.bKo.start();
                                                this.bKp.bJS.setEglContextToRecorder(this.bKp.getEGLContext(), 0, 0);
                                                this.mHaveEglContext = true;
                                                z12 = true;
                                                this.bJX.notifyAll();
                                            } catch (RuntimeException e) {
                                                this.bJX.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.mHaveEglContext || this.mHaveEglSurface) {
                                        z6 = z21;
                                        z10 = z23;
                                    } else {
                                        this.mHaveEglSurface = true;
                                        z24 = true;
                                        z6 = true;
                                        z10 = true;
                                    }
                                    if (this.mHaveEglSurface) {
                                        if (this.mSizeChanged) {
                                            z6 = true;
                                            i3 = this.mWidth;
                                            i4 = this.mHeight;
                                            this.bKk = true;
                                            z11 = true;
                                            this.mSizeChanged = false;
                                        } else {
                                            z11 = z24;
                                        }
                                        this.mRequestRender = false;
                                        this.bJX.notifyAll();
                                        if (this.bKk) {
                                            i = i3;
                                            z2 = true;
                                            z4 = z10;
                                            z7 = z12;
                                            i2 = i4;
                                            z8 = z9;
                                            z3 = z22;
                                            z5 = z11;
                                        } else {
                                            i = i3;
                                            z2 = z17;
                                            z4 = z10;
                                            z7 = z12;
                                            i2 = i4;
                                            z8 = z9;
                                            z3 = z22;
                                            z5 = z11;
                                        }
                                    } else {
                                        z23 = z10;
                                        z21 = z6;
                                    }
                                }
                                this.bJX.wait();
                                z20 = z9;
                            } else {
                                runnable = this.bKm.pollFirst();
                                i = i3;
                                z2 = z17;
                                z3 = z22;
                                z4 = z23;
                                z5 = z24;
                                boolean z26 = z20;
                                z6 = z21;
                                z7 = z12;
                                i2 = i4;
                                z8 = z26;
                            }
                        }
                    }
                    synchronized (this.bJX) {
                        if (this.bKp != null) {
                            this.bKp.bJS.smallGameDestroy();
                        }
                        V8Engine v8Engine = V8Engine.getInstance();
                        if (v8Engine != null && !v8Engine.isDestroyed()) {
                            Log.e("EngineLogger", "v8engine is not destroyed. Please check that you have called the destroyEngine method");
                        }
                        stopEglSurfaceLocked();
                        stopEglContextLocked();
                    }
                    return;
                } catch (Throwable th) {
                    synchronized (this.bJX) {
                        if (this.bKp != null) {
                            this.bKp.bJS.smallGameDestroy();
                        }
                        V8Engine v8Engine2 = V8Engine.getInstance();
                        if (v8Engine2 != null && !v8Engine2.isDestroyed()) {
                            Log.e("EngineLogger", "v8engine is not destroyed. Please check that you have called the destroyEngine method");
                        }
                        stopEglSurfaceLocked();
                        stopEglContextLocked();
                        throw th;
                    }
                }
            }
            if (V8Engine.isDebug() && this.bKp != null) {
                this.bKp.N(2, runnable.toString());
            }
            z14 = z4;
            z13 = z5;
            z17 = z2;
            z16 = z6;
            i3 = i;
            z19 = z;
            boolean z27 = z8;
            i4 = i2;
            z12 = z7;
            z18 = z27;
            z15 = z3;
            runnable2 = null;
        }

        private void Ry() {
            this.bKb++;
            if (this.bKc != 0) {
                float currentTimeMillis = ((float) (System.currentTimeMillis() - this.bKc)) / 1000.0f;
                if (currentTimeMillis > 1.0f) {
                    this.bKp.em((int) (this.bKb / currentTimeMillis));
                    this.bKb = 0;
                    this.bKc = System.currentTimeMillis();
                    return;
                }
                return;
            }
            this.bKc = System.currentTimeMillis();
        }

        public boolean ableToDraw() {
            return this.mHaveEglContext && this.mHaveEglSurface && readyToDraw();
        }

        private boolean readyToDraw() {
            return !this.mPaused && this.mHasSurface && !this.mSurfaceIsBad && this.mWidth > 0 && this.mHeight > 0 && (this.mRequestRender || this.mRenderMode == 1);
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (this.bJX) {
                this.mRenderMode = i;
                this.bJX.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (this.bJX) {
                i = this.mRenderMode;
            }
            return i;
        }

        public void requestRender() {
            synchronized (this.bJX) {
                this.mRequestRender = true;
                this.bJX.notifyAll();
            }
        }

        public void requestRenderAndWait() {
            synchronized (this.bJX) {
                if (Thread.currentThread() != this) {
                    this.bKk = true;
                    this.mRequestRender = true;
                    this.mRenderComplete = false;
                    this.bJX.notifyAll();
                    while (!this.mExited && !this.mPaused && !this.mRenderComplete && ableToDraw()) {
                        try {
                            this.bJX.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void surfaceCreated() {
            synchronized (this.bJX) {
                this.mHasSurface = true;
                this.bKj = false;
                this.bJX.notifyAll();
                while (this.mWaitingForSurface && !this.bKj && !this.mExited) {
                    try {
                        this.bJX.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (this.bJX) {
                this.mHasSurface = false;
                this.bJX.notifyAll();
                while (!this.mWaitingForSurface && !this.mExited) {
                    try {
                        this.bJX.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (this.bJX) {
                Log.i("EngineLogger", "onPause tid=" + getId());
                this.mRequestPaused = true;
                if (this.bKp != null && (this.bKp.bJS.getStuckScreenHandler() instanceof com.baidu.smallgame.sdk.b)) {
                    ((com.baidu.smallgame.sdk.b) this.bKp.bJS.getStuckScreenHandler()).RD();
                }
                this.bJX.notifyAll();
                while (!this.mExited && !this.mPaused) {
                    Log.i("Main thread", "onPause waiting for mPaused.");
                    try {
                        this.bJX.wait(500L);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (this.bJX) {
                Log.i("EngineLogger", "onResume tid=" + getId());
                this.mRequestPaused = false;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                this.bJX.notifyAll();
                while (!this.mExited && this.mPaused && !this.mRenderComplete) {
                    Log.i("Main thread", "onResume waiting for !mPaused.");
                    try {
                        this.bJX.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onWindowResize(int i, int i2) {
            synchronized (this.bJX) {
                this.mWidth = i;
                this.mHeight = i2;
                this.mSizeChanged = true;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                if (Thread.currentThread() != this) {
                    this.bJX.notifyAll();
                    while (!this.mExited && !this.mPaused && !this.mRenderComplete && ableToDraw()) {
                        try {
                            this.bJX.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void requestExitAndWait() {
            synchronized (this.bJX) {
                this.mShouldExit = true;
                this.bJX.notifyAll();
                while (!this.mExited) {
                    try {
                        this.bJX.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void runOnGLThread(Runnable runnable) {
            a(runnable, false);
        }

        public void queueEvent(Runnable runnable) {
            a(runnable, true);
        }

        private void a(Runnable runnable, boolean z) {
            if (runnable == null) {
                throw new IllegalArgumentException("r must not be null");
            }
            if (!this.mShouldExit && !this.mExited) {
                synchronized (this.bJX) {
                    if (V8Engine.isDebug() && this.bKp != null) {
                        this.bKp.N(0, runnable.toString());
                    }
                    if (z || ableToDraw()) {
                        this.bKl.add(runnable);
                    } else {
                        this.bKm.add(runnable);
                    }
                    this.bJX.notifyAll();
                }
            }
        }

        public void b(Runnable runnable, long j) {
            if (runnable == null) {
                throw new IllegalArgumentException("r must not be null");
            }
            if (!this.mShouldExit && !this.mExited) {
                synchronized (this.bJX) {
                    TreeSet<d> treeSet = this.bKn;
                    if (j <= 0) {
                        j = 0;
                    }
                    treeSet.add(new d(runnable, j));
                    this.bJX.notifyAll();
                }
            }
        }

        public void clearOldEvents() {
            synchronized (this.bJX) {
                this.bKl.clear();
                this.bKm.clear();
                this.bKn.clear();
            }
        }

        private Runnable Rz() {
            Runnable pollFirst;
            synchronized (this.bJX) {
                pollFirst = (this.bKn.isEmpty() || !this.bKn.first().isTimeout()) ? this.bKl.pollFirst() : this.bKn.pollFirst();
            }
            return pollFirst;
        }
    }

    /* loaded from: classes10.dex */
    public static class d implements Comparable<d>, Runnable {
        private final Runnable bKu;
        private final long mTimestamp;

        d(Runnable runnable, long j) {
            this.bKu = runnable;
            this.mTimestamp = System.currentTimeMillis() + j;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.bKu.run();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(d dVar) {
            return (int) (this.mTimestamp - dVar.mTimestamp);
        }

        public boolean isTimeout() {
            return System.currentTimeMillis() >= this.mTimestamp;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class c {
        private static String TAG = "GLThreadManager";
        private C0283a bKt;

        private c() {
        }

        public synchronized void b(C0283a c0283a) {
            c0283a.mExited = true;
            if (this.bKt == c0283a) {
                this.bKt = null;
            }
            notifyAll();
        }

        public void c(C0283a c0283a) {
            if (this.bKt == c0283a) {
                this.bKt = null;
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class b {
        private a bKp;
        EGLDisplay bKq;
        EGLSurface bKr;
        EGLConfig bKs;
        EGLContext mEglContext;

        public b(a aVar) {
            this.bKp = aVar;
        }

        public void reset() {
            this.bKp = null;
        }

        public void start() {
            this.bKq = EGL14.eglGetDisplay(0);
            if (this.bKq == EGL14.EGL_NO_DISPLAY) {
                throw new RuntimeException("unable to get EGL14 display");
            }
            int[] iArr = new int[2];
            if (!EGL14.eglInitialize(this.bKq, iArr, 0, iArr, 1)) {
                this.bKq = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            a aVar = this.bKp;
            this.bKs = g(0, 0, false);
            this.mEglContext = EGL14.eglCreateContext(this.bKq, this.bKs, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
            this.bKp.mCurrentGLThreadID = Thread.currentThread().getId();
            if (this.mEglContext == null || this.mEglContext == EGL14.EGL_NO_CONTEXT) {
                this.mEglContext = null;
                throwEglException("createContext");
            }
            this.bKr = null;
        }

        private EGLConfig g(int i, int i2, boolean z) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (EGL14.eglChooseConfig(this.bKq, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, z ? 16 : 0, 12326, 0, 12352, 4, 12344, 0, 12344}, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
                return eGLConfigArr[0];
            }
            Log.w("EngineLogger", "unable to find RGB8888 / " + i2 + " EGLConfig");
            return null;
        }

        public boolean createSurface() {
            if (this.bKq == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.bKs == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            destroySurface();
            Object obj = this.bKp.mSurfaceHolder;
            if (obj == null) {
                obj = this.bKp.bJY;
            }
            if (obj != null) {
                this.bKr = EGL14.eglCreateWindowSurface(this.bKq, this.bKs, obj, new int[]{12344}, 0);
            } else {
                this.bKr = null;
            }
            if (this.bKr == null || this.bKr == EGL14.EGL_NO_SURFACE) {
                if (EGL14.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    return false;
                }
                return false;
            }
            return EGL14.eglMakeCurrent(this.bKq, this.bKr, this.bKr, this.mEglContext);
        }

        public int swap() {
            return !EGL14.eglSwapBuffers(this.bKq, this.bKr) ? EGL14.eglGetError() : CommandMessage.COMMAND_BASE;
        }

        public void destroySurface() {
            if (this.bKr != null && this.bKr != EGL14.EGL_NO_SURFACE) {
                EGL14.eglMakeCurrent(this.bKq, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
                EGL14.eglDestroySurface(this.bKq, this.bKr);
                this.bKr = null;
            }
        }

        public void finish() {
            if (this.mEglContext != null) {
                EGL14.eglDestroyContext(this.bKq, this.mEglContext);
                this.mEglContext = null;
            }
            if (this.bKq != null) {
                EGL14.eglTerminate(this.bKq);
                this.bKq = null;
            }
            this.bKp.mCurrentGLThreadID = -1L;
        }

        private void throwEglException(String str) {
            throwEglException(str, EGL14.eglGetError());
        }

        public static void throwEglException(String str, int i) {
            throw new RuntimeException(formatEglError(str, i));
        }

        public static void logEglErrorAsWarning(String str, String str2, int i) {
            Log.w(str, formatEglError(str2, i));
        }

        public static String formatEglError(String str, int i) {
            return str + " failed: " + i;
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public boolean isDestroyed() {
        return this.bJS.isDestroyed();
    }
}
