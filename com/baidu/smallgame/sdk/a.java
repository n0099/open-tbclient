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
/* loaded from: classes15.dex */
public final class a implements AREngineDelegate {
    public static PermissionProxy czS = null;
    public static int czT = 0;
    private Object cAb;
    private C0339a cAc;
    private ArBridge czU;
    private GLSurfaceView.Renderer czY;
    private Context mContext;
    private boolean mDetached;
    private SurfaceHolder mSurfaceHolder;
    private ArrayList<DebugConsole> mConsoles = null;
    private int czV = 0;
    private long mCurrentGLThreadID = -1;
    private float czW = 0.0f;
    private float czX = 0.0f;
    private boolean czZ = false;
    private final c cAa = new c();

    public Context getContext() {
        return this.mContext;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        Log.setMinLogLevel(6, false);
        this.czU = new ArBridge();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void startEngine() {
        if (this.czY == null) {
            throw new NullPointerException("start render engine failed. because renderer is not set");
        }
        this.cAc = new C0339a(this);
        this.cAc.start();
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
    public void al(int i, String str) {
        if (this.mConsoles != null) {
            for (DebugConsole debugConsole : new ArrayList(this.mConsoles)) {
                debugConsole.onReceiveInfo(i, str);
            }
        }
    }

    public ArBridge afv() {
        return this.czU;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public Thread getGLThread() {
        return this.cAc;
    }

    void fW(int i) {
        int i2 = i < 0 ? 0 : i;
        this.czV = i2 <= 60 ? i2 : 60;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public int getFPS() {
        return this.czV;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void updateSurfaceViewSize(float f, float f2) {
        Log.w("EngineLogger", "[ARDispose] updateSurfaceViewSize, width=" + f + ", height=" + f2);
        this.czW = f;
        this.czX = f2;
        this.czU.setSize(f, f2);
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
        if (this.czW != 0.0f) {
            f = this.czW;
        }
        if (this.czX != 0.0f) {
            f2 = this.czX;
        }
        if (this.czU != null) {
            this.czU.setDisplayMetrics(f, f2, displayMetrics.xdpi, displayMetrics.ydpi, displayMetrics.density);
        } else {
            Log.e("EngineLogger", "[RenderError] error init render display, because arbridge is null");
        }
    }

    public void c(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = (SurfaceHolder) new WeakReference(surfaceHolder).get();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderer(GLSurfaceView.Renderer renderer) {
        this.czY = renderer;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderMode(int i) {
        if (this.cAc != null) {
            this.cAc.setRenderMode(i);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public int getRenderMode() {
        if (this.cAc != null) {
            return this.cAc.getRenderMode();
        }
        return 1;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRender() {
        if (this.cAc != null) {
            this.cAc.requestRender();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceCreated() {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceCreated.");
        this.cAc.surfaceCreated();
        Context appContext = V8Engine.getAppContext();
        if (appContext != null) {
            czT = ((WindowManager) appContext.getSystemService("window")).getDefaultDisplay().getRotation();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceDestroyed() {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceDestroyed.");
        this.cAc.surfaceDestroyed();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceChanged(int i, int i2) {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceChanged. width=" + i + ", height=" + i2);
        this.cAc.onWindowResize(i, i2);
        this.czU.setEglContextToRecorder(getEGLContext(), i, i2);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRenderAndWait() {
        if (this.cAc != null) {
            this.cAc.requestRenderAndWait();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameOnPause() {
        this.czU.smallGameOnPause();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void runOnGLThread(Runnable runnable) {
        if (this.cAc != null) {
            this.cAc.runOnGLThread(runnable);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable) {
        if (this.cAc != null) {
            this.cAc.queueEvent(runnable);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable, long j) {
        if (this.cAc != null) {
            this.cAc.b(runnable, j);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onAttachedToWindow() {
        if (this.mDetached && this.czY != null) {
            int renderMode = this.cAc != null ? this.cAc.getRenderMode() : 1;
            this.cAc = new C0339a(this);
            if (renderMode != 1) {
                this.cAc.setRenderMode(renderMode);
            }
            this.cAc.start();
        }
        this.mDetached = false;
        Log.w("EngineLogger", "[V8Dispose][AREngine] onAttachedToWindow");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onDetachedFromWindow() {
        if (!this.mDetached && this.cAc != null) {
            this.cAc.requestExitAndWait();
        }
        this.mDetached = true;
        Log.w("EngineLogger", "[V8Dispose][AREngine] onDetachedFromWindow");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void clearOldEvents() {
        if (this.cAc != null) {
            this.cAc.clearOldEvents();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onPause() {
        if (this.cAc != null) {
            this.cAc.onPause();
        }
        if (this.czU.getGameRecorder() != null) {
            this.czU.getGameRecorder().aaH();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onResume() {
        if (this.cAc != null) {
            this.cAc.onResume();
        }
        if (this.czU.getGameRecorder() != null) {
            this.czU.getGameRecorder().aaI();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void pauseRecord() {
        if (this.czU.getGameRecorder() != null) {
            this.czU.getGameRecorder().pauseRecord();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void resumeRecord() {
        if (this.czU.getGameRecorder() != null) {
            this.czU.getGameRecorder().resumeRecord();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void stopRecord() {
        if (this.czU.getGameRecorder() != null) {
            this.czU.getGameRecorder().stopRecord();
            this.czU.nativeUpdateRecordingStatus(false);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (this.czU.getGameRecorder() != null) {
            this.czU.nativeUpdateRecordingStatus(true);
            this.czU.getGameRecorder().startRecord(z, i, str, z2);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setGameRecordCallback(com.baidu.mario.a.c cVar) {
        if (this.czU.getGameRecorder() != null) {
            this.czU.getGameRecorder().setGameRecordCallback(cVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setAudioEngineProxy(com.baidu.mario.a.a aVar) {
        if (this.czU.getGameRecorder() != null) {
            this.czU.getGameRecorder().setAudioEngineProxy(aVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public long getCurrentRecordProcess() {
        if (this.czU.getGameRecorder() != null) {
            return this.czU.getGameRecorder().aaG();
        }
        return 0L;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setPermissionProxy(PermissionProxy permissionProxy) {
        czS = permissionProxy;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setOnStuckScreenListener(com.baidu.smallgame.sdk.b.a aVar) {
        if (this.czU != null) {
            this.czU.setOnStuckScreenListener(aVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setStuckScreenLimitTime(long j) {
        if (this.czU != null) {
            this.czU.setStuckScreenLimitTime(j);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public com.baidu.smallgame.sdk.b.c getStuckScreenHandler() {
        if (this.czU == null) {
            return null;
        }
        return this.czU.getStuckScreenHandler();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameDestroy() {
        if (this.cAc == null) {
            Log.e("EngineLogger", "Destroy AREngine fail. Because GLThread is null");
        } else {
            this.cAc.runOnGLThread(new Runnable() { // from class: com.baidu.smallgame.sdk.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.cAc.mShouldExit = true;
                    a.this.czU.smallGameDestroy();
                }
            });
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public boolean ableToDraw() {
        return this.cAc != null && this.cAc.ableToDraw();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void exitGLThread() {
        if (this.cAc != null) {
            this.cAc.requestExitAndWait();
        }
        Log.e("EngineLogger", "[V8Dispose][AREngine] exitGLThread.");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameUpdate() {
        this.czU.smallGameUpdate();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setScreenShotStatus(boolean z) {
        this.czU.setScreenShotStatus(z);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public JSONArray getPerformanceJson() {
        return this.czU == null ? new JSONArray() : this.czU.getPerformanceJson();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public PerformanceJsonBean getPerformanceJsonBean() {
        return this.czU == null ? new PerformanceJsonBean() : this.czU.getPerformanceJsonBean();
    }

    public void jH(String str) {
        if (this.czU != null) {
            this.czU.getPerformanceJsonBean().put(str);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setFirstFrameListener(ArBridge.FirstFrameListener firstFrameListener) {
        this.czU.setFirstFrameListener(firstFrameListener);
    }

    public EGLContext getEGLContext() {
        if (this.cAc == null || this.cAc.cAo == null) {
            return null;
        }
        return this.cAc.cAo.mEglContext;
    }

    protected void finalize() throws Throwable {
        try {
            if (this.cAc != null) {
                this.cAc.requestExitAndWait();
            }
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.smallgame.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C0339a extends Thread {
        private c cAa;
        private b cAo;
        private a cAp;
        private boolean mFinishedCreatingEglSurface;
        private boolean mHasSurface;
        private boolean mHaveEglContext;
        private boolean mHaveEglSurface;
        private boolean mPaused;
        private boolean mRenderComplete;
        private boolean mRequestPaused;
        private boolean mShouldReleaseEglContext;
        private boolean mSurfaceIsBad;
        private boolean mWaitingForSurface;
        private int cAe = 0;
        private long cAf = 0;
        private long cAg = 0;
        private long cAh = 0;
        private long lastUpdateTime = 0;
        private boolean cAi = false;
        private boolean cAj = false;
        private boolean cAk = false;
        private volatile boolean mShouldExit = false;
        private volatile boolean mExited = false;
        private LinkedList<Runnable> cAl = new LinkedList<>();
        private LinkedList<Runnable> cAm = new LinkedList<>();
        private TreeSet<d> cAn = new TreeSet<>();
        private boolean mSizeChanged = true;
        private V8Engine mV8Engine = null;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean mRequestRender = true;
        private int mRenderMode = 1;
        private boolean mWantRenderNotification = false;

        C0339a(a aVar) {
            this.cAp = aVar;
            this.cAa = aVar.cAa;
        }

        /* JADX WARN: Type inference failed for: r4v0, types: [com.baidu.smallgame.sdk.a, com.baidu.searchbox.v8engine.V8Engine, com.baidu.smallgame.sdk.a$b] */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("ARGLThread " + getId());
            if (this.cAp != null) {
                ArBridge afv = this.cAp.afv();
                if (afv != null) {
                    afv.setGLThreadID(getId());
                    afv.smallGameOnInit();
                    this.cAp.initDisplayMetrics();
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
                this.cAa.b(this);
                this.cAo.reset();
                this.cAo = null;
                this.cAp = null;
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
                this.cAo.destroySurface();
            }
        }

        private void stopEglContextLocked() {
            if (this.mHaveEglContext) {
                this.cAo.finish();
                this.mHaveEglContext = false;
                this.cAa.c(this);
            }
        }

        public boolean afw() {
            return this.cAp.czU.mFirstFrameFinished && ((float) (System.currentTimeMillis() - this.cAh)) > minFramesInterval();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1087=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX WARN: Code restructure failed: missing block: B:132:0x02ed, code lost:
            r4 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:133:0x02ee, code lost:
            r4.printStackTrace();
         */
        /* JADX WARN: Code restructure failed: missing block: B:134:0x02f3, code lost:
            if (r11 == false) goto L94;
         */
        /* JADX WARN: Code restructure failed: missing block: B:136:0x02fd, code lost:
            if (r24.cAo.createSurface() == false) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:137:0x02ff, code lost:
            r11 = r24.cAa;
         */
        /* JADX WARN: Code restructure failed: missing block: B:138:0x0303, code lost:
            monitor-enter(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:140:0x0305, code lost:
            r24.mFinishedCreatingEglSurface = true;
            r24.cAa.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:141:0x0310, code lost:
            monitor-exit(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:142:0x0311, code lost:
            r12 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:143:0x0313, code lost:
            if (r10 == false) goto L93;
         */
        /* JADX WARN: Code restructure failed: missing block: B:144:0x0315, code lost:
            r11 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:145:0x0317, code lost:
            if (r9 == false) goto L92;
         */
        /* JADX WARN: Code restructure failed: missing block: B:146:0x0319, code lost:
            r4 = r24.cAp;
         */
        /* JADX WARN: Code restructure failed: missing block: B:147:0x031d, code lost:
            if (r4 == null) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:148:0x031f, code lost:
            r4.czY.onSurfaceCreated(null, null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:149:0x0328, code lost:
            r10 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:150:0x032a, code lost:
            if (r8 == false) goto L91;
         */
        /* JADX WARN: Code restructure failed: missing block: B:151:0x032c, code lost:
            r4 = r24.cAp;
         */
        /* JADX WARN: Code restructure failed: missing block: B:152:0x0330, code lost:
            if (r4 == null) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:153:0x0332, code lost:
            r4.czY.onSurfaceChanged(null, r15, r14);
            r4.updateSurfaceViewSize(r15, r14);
         */
        /* JADX WARN: Code restructure failed: missing block: B:154:0x033f, code lost:
            r9 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:155:0x0341, code lost:
            r0 = r24.cAp;
            r18 = java.lang.System.currentTimeMillis();
            r20 = r18 - r24.cAg;
         */
        /* JADX WARN: Code restructure failed: missing block: B:156:0x0357, code lost:
            if (r0.czZ == false) goto L90;
         */
        /* JADX WARN: Code restructure failed: missing block: B:158:0x0362, code lost:
            if (((float) r20) < minFramesInterval()) goto L90;
         */
        /* JADX WARN: Code restructure failed: missing block: B:159:0x0364, code lost:
            r24.cAg = java.lang.System.currentTimeMillis();
         */
        /* JADX WARN: Code restructure failed: missing block: B:160:0x0372, code lost:
            if (r24.cAi != false) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:162:0x0378, code lost:
            if (r24.cAp == null) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:163:0x037a, code lost:
            r24.cAi = true;
            r24.cAp.jH("first_frame");
         */
        /* JADX WARN: Code restructure failed: missing block: B:164:0x0389, code lost:
            r0.czY.onDrawFrame(null);
            afx();
         */
        /* JADX WARN: Code restructure failed: missing block: B:165:0x03a0, code lost:
            if ((r18 - r24.lastUpdateTime) <= 33) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:166:0x03a2, code lost:
            r0.czU.notifyFrameUpdated();
            r24.lastUpdateTime = r18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:168:0x03b3, code lost:
            if (r24.cAk == false) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:169:0x03b5, code lost:
            r24.cAp.czU.smallGameOnResume();
            r24.cAk = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:170:0x03c5, code lost:
            r4 = r0.czU.shouldSwapBuffer();
         */
        /* JADX WARN: Code restructure failed: missing block: B:171:0x03cd, code lost:
            if (r4 == false) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:172:0x03cf, code lost:
            r8 = r24.cAo.swap();
         */
        /* JADX WARN: Code restructure failed: missing block: B:173:0x03d7, code lost:
            switch(r8) {
                case 12288: goto L77;
                case 12302: goto L76;
                default: goto L71;
            };
         */
        /* JADX WARN: Code restructure failed: missing block: B:174:0x03da, code lost:
            com.baidu.smallgame.sdk.a.b.logEglErrorAsWarning("EngineLogger", "eglSwapBuffers", r8);
            r8 = r24.cAa;
         */
        /* JADX WARN: Code restructure failed: missing block: B:175:0x03eb, code lost:
            monitor-enter(r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:177:0x03ee, code lost:
            r24.mSurfaceIsBad = true;
            r24.cAa.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:178:0x03fd, code lost:
            monitor-exit(r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:179:0x03fe, code lost:
            r24.cAh = java.lang.System.currentTimeMillis();
         */
        /* JADX WARN: Code restructure failed: missing block: B:180:0x0414, code lost:
            if (r24.cAp.czU.isRenderCallbackQueueEmpty() != false) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:181:0x0416, code lost:
            if (r4 == false) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:182:0x0418, code lost:
            r8 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:184:0x0424, code lost:
            if ((r0.czU.getStuckScreenHandler() instanceof com.baidu.smallgame.sdk.b) == false) goto L84;
         */
        /* JADX WARN: Code restructure failed: missing block: B:185:0x0426, code lost:
            ((com.baidu.smallgame.sdk.b) r0.czU.getStuckScreenHandler()).l(r8, r24.cAh);
         */
        /* JADX WARN: Code restructure failed: missing block: B:186:0x043b, code lost:
            if (r6 == false) goto L88;
         */
        /* JADX WARN: Code restructure failed: missing block: B:187:0x043d, code lost:
            r4 = true;
            r6 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:188:0x0440, code lost:
            r17 = r4;
            r18 = r6;
            r19 = r9;
            r20 = r7;
            r21 = r11;
            r22 = r12;
            r23 = r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:192:0x0453, code lost:
            r12 = r24.cAa;
         */
        /* JADX WARN: Code restructure failed: missing block: B:193:0x0457, code lost:
            monitor-enter(r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:195:0x0459, code lost:
            r24.mFinishedCreatingEglSurface = true;
            r24.mSurfaceIsBad = true;
            r24.cAa.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:196:0x0469, code lost:
            monitor-exit(r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:197:0x046a, code lost:
            r17 = r5;
            r18 = r6;
            r19 = r8;
            r20 = r7;
            r21 = r10;
            r22 = r11;
            r23 = r9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:201:0x047d, code lost:
            r7 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:205:0x0482, code lost:
            r8 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:206:0x0485, code lost:
            r0.czZ = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:211:0x048f, code lost:
            r4 = r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:212:0x0491, code lost:
            r9 = r8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:213:0x0494, code lost:
            r10 = r9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:214:0x0497, code lost:
            r11 = r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:215:0x049a, code lost:
            r12 = r11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x009e, code lost:
            if (r13 == null) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00a4, code lost:
            if (r24.cAj != false) goto L102;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00aa, code lost:
            if (r24.cAp == null) goto L102;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00ac, code lost:
            r24.cAj = true;
            r24.cAp.jH("first_event");
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00bf, code lost:
            if (com.baidu.searchbox.v8engine.V8Engine.isDebug() == false) goto L107;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00c5, code lost:
            if (r24.cAp == null) goto L107;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00c7, code lost:
            r24.cAp.al(1, r13.toString());
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00d5, code lost:
            r13.run();
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void guardedRun() throws InterruptedException {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            this.cAo = new b(this.cAp);
            this.mHaveEglContext = false;
            this.mHaveEglSurface = false;
            this.mWantRenderNotification = false;
            boolean z8 = false;
            boolean z9 = false;
            Runnable runnable = null;
            int i = 0;
            int i2 = 0;
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            boolean z13 = false;
            boolean z14 = false;
            boolean z15 = false;
            while (true) {
                try {
                    synchronized (this.cAa) {
                        z = z11;
                        z2 = z13;
                        z3 = z14;
                        z4 = z15;
                        z5 = z9;
                        z6 = z8;
                        while (!this.mShouldExit) {
                            if (this.cAm.isEmpty()) {
                                if (ableToDraw()) {
                                    if (afw()) {
                                        z7 = z12;
                                    } else {
                                        runnable = afy();
                                        if (runnable != null) {
                                            z7 = z12;
                                        }
                                    }
                                }
                                boolean z16 = false;
                                if (this.mPaused != this.mRequestPaused) {
                                    z16 = this.mRequestPaused;
                                    this.mPaused = this.mRequestPaused;
                                    if (this.mRequestPaused) {
                                        this.cAk = false;
                                        this.cAp.czU.smallGameOnPauseOnGLThrad();
                                    } else {
                                        this.cAk = true;
                                    }
                                    this.cAa.notifyAll();
                                    Log.i("EngineLogger", "mPaused is now " + this.mPaused + " tid=" + getId());
                                }
                                if (this.mShouldReleaseEglContext) {
                                    stopEglSurfaceLocked();
                                    stopEglContextLocked();
                                    this.mShouldReleaseEglContext = false;
                                    z10 = true;
                                }
                                if (z3) {
                                    stopEglSurfaceLocked();
                                    stopEglContextLocked();
                                    z3 = false;
                                }
                                if (z16 && this.mHaveEglSurface) {
                                    stopEglSurfaceLocked();
                                }
                                if (!z16 || this.mHaveEglContext) {
                                }
                                if (!this.mHasSurface && !this.mWaitingForSurface) {
                                    if (this.mHaveEglSurface) {
                                        stopEglSurfaceLocked();
                                    }
                                    this.mWaitingForSurface = true;
                                    this.mSurfaceIsBad = false;
                                    this.cAa.notifyAll();
                                }
                                if (this.mHasSurface && this.mWaitingForSurface) {
                                    this.mWaitingForSurface = false;
                                    this.cAa.notifyAll();
                                }
                                if (z) {
                                    this.mWantRenderNotification = false;
                                    z = false;
                                    this.mRenderComplete = true;
                                    this.cAa.notifyAll();
                                }
                                if (readyToDraw()) {
                                    if (!this.mHaveEglContext) {
                                        if (z10) {
                                            z10 = false;
                                        } else {
                                            try {
                                                this.cAo.start();
                                                this.cAp.czU.setEglContextToRecorder(this.cAp.getEGLContext(), 0, 0);
                                                this.mHaveEglContext = true;
                                                z6 = true;
                                                this.cAa.notifyAll();
                                            } catch (RuntimeException e) {
                                                this.cAa.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (this.mHaveEglContext && !this.mHaveEglSurface) {
                                        this.mHaveEglSurface = true;
                                        z5 = true;
                                        z4 = true;
                                        z2 = true;
                                    }
                                    if (this.mHaveEglSurface) {
                                        if (this.mSizeChanged) {
                                            z2 = true;
                                            i2 = this.mWidth;
                                            i = this.mHeight;
                                            this.mWantRenderNotification = true;
                                            z5 = true;
                                            this.mSizeChanged = false;
                                        }
                                        this.mRequestRender = false;
                                        this.cAa.notifyAll();
                                        if (this.mWantRenderNotification) {
                                            z7 = true;
                                        }
                                        z7 = z12;
                                    }
                                }
                                this.cAa.wait();
                            } else {
                                runnable = this.cAm.pollFirst();
                                z7 = z12;
                            }
                        }
                    }
                    synchronized (this.cAa) {
                        if (this.cAp != null) {
                            this.cAp.czU.smallGameDestroy();
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
                    synchronized (this.cAa) {
                        if (this.cAp != null) {
                            this.cAp.czU.smallGameDestroy();
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
            if (V8Engine.isDebug() && this.cAp != null) {
                this.cAp.al(2, runnable.toString());
            }
            runnable = null;
            z11 = z;
            z12 = z7;
            z13 = z2;
            z14 = z3;
            z15 = z4;
            z9 = z5;
            z8 = z6;
        }

        private void afx() {
            this.cAe++;
            if (this.cAf != 0) {
                float currentTimeMillis = ((float) (System.currentTimeMillis() - this.cAf)) / 1000.0f;
                if (currentTimeMillis > 1.0f) {
                    this.cAp.fW((int) (this.cAe / currentTimeMillis));
                    this.cAe = 0;
                    this.cAf = System.currentTimeMillis();
                    return;
                }
                return;
            }
            this.cAf = System.currentTimeMillis();
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
            synchronized (this.cAa) {
                this.mRenderMode = i;
                this.cAa.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (this.cAa) {
                i = this.mRenderMode;
            }
            return i;
        }

        public void requestRender() {
            synchronized (this.cAa) {
                this.mRequestRender = true;
                this.cAa.notifyAll();
            }
        }

        public void requestRenderAndWait() {
            synchronized (this.cAa) {
                if (Thread.currentThread() != this) {
                    this.mWantRenderNotification = true;
                    this.mRequestRender = true;
                    this.mRenderComplete = false;
                    this.cAa.notifyAll();
                    while (!this.mExited && !this.mPaused && !this.mRenderComplete && ableToDraw()) {
                        try {
                            this.cAa.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void surfaceCreated() {
            synchronized (this.cAa) {
                this.mHasSurface = true;
                this.mFinishedCreatingEglSurface = false;
                this.cAa.notifyAll();
                while (this.mWaitingForSurface && !this.mFinishedCreatingEglSurface && !this.mExited) {
                    try {
                        this.cAa.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (this.cAa) {
                this.mHasSurface = false;
                this.cAa.notifyAll();
                while (!this.mWaitingForSurface && !this.mExited) {
                    try {
                        this.cAa.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (this.cAa) {
                Log.i("EngineLogger", "onPause tid=" + getId());
                this.mRequestPaused = true;
                if (this.cAp != null && (this.cAp.czU.getStuckScreenHandler() instanceof com.baidu.smallgame.sdk.b)) {
                    ((com.baidu.smallgame.sdk.b) this.cAp.czU.getStuckScreenHandler()).afC();
                }
                this.cAa.notifyAll();
                while (!this.mExited && !this.mPaused) {
                    Log.i("Main thread", "onPause waiting for mPaused.");
                    try {
                        this.cAa.wait(500L);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (this.cAa) {
                Log.i("EngineLogger", "onResume tid=" + getId());
                this.mRequestPaused = false;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                this.cAa.notifyAll();
                while (!this.mExited && this.mPaused && !this.mRenderComplete) {
                    Log.i("Main thread", "onResume waiting for !mPaused.");
                    try {
                        this.cAa.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onWindowResize(int i, int i2) {
            synchronized (this.cAa) {
                this.mWidth = i;
                this.mHeight = i2;
                this.mSizeChanged = true;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                if (Thread.currentThread() != this) {
                    this.cAa.notifyAll();
                    while (!this.mExited && !this.mPaused && !this.mRenderComplete && ableToDraw()) {
                        try {
                            this.cAa.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void requestExitAndWait() {
            synchronized (this.cAa) {
                this.mShouldExit = true;
                this.cAa.notifyAll();
                while (!this.mExited) {
                    try {
                        this.cAa.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void runOnGLThread(Runnable runnable) {
            b(runnable, false);
        }

        public void queueEvent(Runnable runnable) {
            b(runnable, true);
        }

        private void b(Runnable runnable, boolean z) {
            if (runnable == null) {
                throw new IllegalArgumentException("r must not be null");
            }
            if (!this.mShouldExit && !this.mExited) {
                synchronized (this.cAa) {
                    if (V8Engine.isDebug() && this.cAp != null) {
                        this.cAp.al(0, runnable.toString());
                    }
                    if (z || ableToDraw()) {
                        this.cAl.add(runnable);
                    } else {
                        this.cAm.add(runnable);
                    }
                    this.cAa.notifyAll();
                }
            }
        }

        public void b(Runnable runnable, long j) {
            if (runnable == null) {
                throw new IllegalArgumentException("r must not be null");
            }
            if (!this.mShouldExit && !this.mExited) {
                synchronized (this.cAa) {
                    TreeSet<d> treeSet = this.cAn;
                    if (j <= 0) {
                        j = 0;
                    }
                    treeSet.add(new d(runnable, j));
                    this.cAa.notifyAll();
                }
            }
        }

        public void clearOldEvents() {
            synchronized (this.cAa) {
                this.cAl.clear();
                this.cAm.clear();
                this.cAn.clear();
            }
        }

        private Runnable afy() {
            Runnable pollFirst;
            synchronized (this.cAa) {
                pollFirst = (this.cAn.isEmpty() || !this.cAn.first().isTimeout()) ? this.cAl.pollFirst() : this.cAn.pollFirst();
            }
            return pollFirst;
        }
    }

    /* loaded from: classes15.dex */
    public static class d implements Comparable<d>, Runnable {
        private final Runnable cAu;
        private final long mTimestamp;

        d(Runnable runnable, long j) {
            this.cAu = runnable;
            this.mTimestamp = System.currentTimeMillis() + j;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.cAu.run();
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
    /* loaded from: classes15.dex */
    public static class c {
        private static String TAG = "GLThreadManager";
        private C0339a cAt;

        private c() {
        }

        public synchronized void b(C0339a c0339a) {
            c0339a.mExited = true;
            if (this.cAt == c0339a) {
                this.cAt = null;
            }
            notifyAll();
        }

        public void c(C0339a c0339a) {
            if (this.cAt == c0339a) {
                this.cAt = null;
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class b {
        private a cAp;
        EGLDisplay cAq;
        EGLSurface cAr;
        EGLConfig cAs;
        EGLContext mEglContext;

        public b(a aVar) {
            this.cAp = aVar;
        }

        public void reset() {
            this.cAp = null;
        }

        public void start() {
            this.cAq = EGL14.eglGetDisplay(0);
            if (this.cAq == EGL14.EGL_NO_DISPLAY) {
                throw new RuntimeException("unable to get EGL14 display");
            }
            int[] iArr = new int[2];
            if (!EGL14.eglInitialize(this.cAq, iArr, 0, iArr, 1)) {
                this.cAq = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            a aVar = this.cAp;
            this.cAs = h(0, 0, false);
            this.mEglContext = EGL14.eglCreateContext(this.cAq, this.cAs, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
            this.cAp.mCurrentGLThreadID = Thread.currentThread().getId();
            if (this.mEglContext == null || this.mEglContext == EGL14.EGL_NO_CONTEXT) {
                this.mEglContext = null;
                throwEglException("createContext");
            }
            this.cAr = null;
        }

        private EGLConfig h(int i, int i2, boolean z) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (EGL14.eglChooseConfig(this.cAq, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, z ? 16 : 0, 12326, 0, 12352, 4, 12344, 0, 12344}, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
                return eGLConfigArr[0];
            }
            Log.w("EngineLogger", "unable to find RGB8888 / " + i2 + " EGLConfig");
            return null;
        }

        public boolean createSurface() {
            if (this.cAq == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.cAs == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            destroySurface();
            Object obj = this.cAp.mSurfaceHolder;
            if (obj == null) {
                obj = this.cAp.cAb;
            }
            if (obj != null) {
                this.cAr = EGL14.eglCreateWindowSurface(this.cAq, this.cAs, obj, new int[]{12344}, 0);
            } else {
                this.cAr = null;
            }
            if (this.cAr == null || this.cAr == EGL14.EGL_NO_SURFACE) {
                if (EGL14.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    return false;
                }
                return false;
            }
            return EGL14.eglMakeCurrent(this.cAq, this.cAr, this.cAr, this.mEglContext);
        }

        public int swap() {
            return !EGL14.eglSwapBuffers(this.cAq, this.cAr) ? EGL14.eglGetError() : CommandMessage.COMMAND_BASE;
        }

        public void destroySurface() {
            if (this.cAr != null && this.cAr != EGL14.EGL_NO_SURFACE) {
                EGL14.eglMakeCurrent(this.cAq, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
                EGL14.eglDestroySurface(this.cAq, this.cAr);
                this.cAr = null;
            }
        }

        public void finish() {
            if (this.mEglContext != null) {
                EGL14.eglDestroyContext(this.cAq, this.mEglContext);
                this.mEglContext = null;
            }
            if (this.cAq != null) {
                EGL14.eglTerminate(this.cAq);
                this.cAq = null;
            }
            this.cAp.mCurrentGLThreadID = -1L;
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
        return this.czU.isDestroyed();
    }
}
