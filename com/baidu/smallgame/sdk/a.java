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
/* loaded from: classes5.dex */
public final class a implements AREngineDelegate {
    public static PermissionProxy cCg = null;
    public static int cCh = 0;
    private ArBridge cCi;
    private GLSurfaceView.Renderer cCm;
    private Object cCp;
    private C0359a cCq;
    private Context mContext;
    private boolean mDetached;
    private SurfaceHolder mSurfaceHolder;
    private ArrayList<DebugConsole> mConsoles = null;
    private int cCj = 0;
    private long mCurrentGLThreadID = -1;
    private float cCk = 0.0f;
    private float cCl = 0.0f;
    private boolean cCn = false;
    private final c cCo = new c();

    public Context getContext() {
        return this.mContext;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        Log.setMinLogLevel(6, false);
        this.cCi = new ArBridge();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void startEngine() {
        if (this.cCm == null) {
            throw new NullPointerException("start render engine failed. because renderer is not set");
        }
        this.cCq = new C0359a(this);
        this.cCq.start();
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
    public void ag(int i, String str) {
        if (this.mConsoles != null) {
            for (DebugConsole debugConsole : new ArrayList(this.mConsoles)) {
                debugConsole.onReceiveInfo(i, str);
            }
        }
    }

    public ArBridge aiP() {
        return this.cCi;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public Thread getGLThread() {
        return this.cCq;
    }

    void hA(int i) {
        int i2 = i < 0 ? 0 : i;
        this.cCj = i2 <= 60 ? i2 : 60;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public int getFPS() {
        return this.cCj;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void updateSurfaceViewSize(float f, float f2) {
        Log.w("EngineLogger", "[ARDispose] updateSurfaceViewSize, width=" + f + ", height=" + f2);
        this.cCk = f;
        this.cCl = f2;
        this.cCi.setSize(f, f2);
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
        if (this.cCk != 0.0f) {
            f = this.cCk;
        }
        if (this.cCl != 0.0f) {
            f2 = this.cCl;
        }
        if (this.cCi != null) {
            this.cCi.setDisplayMetrics(f, f2, displayMetrics.xdpi, displayMetrics.ydpi, displayMetrics.density);
        } else {
            Log.e("EngineLogger", "[RenderError] error init render display, because arbridge is null");
        }
    }

    public void c(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = (SurfaceHolder) new WeakReference(surfaceHolder).get();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderer(GLSurfaceView.Renderer renderer) {
        this.cCm = renderer;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderMode(int i) {
        if (this.cCq != null) {
            this.cCq.setRenderMode(i);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public int getRenderMode() {
        if (this.cCq != null) {
            return this.cCq.getRenderMode();
        }
        return 1;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRender() {
        if (this.cCq != null) {
            this.cCq.requestRender();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceCreated() {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceCreated.");
        this.cCq.surfaceCreated();
        Context appContext = V8Engine.getAppContext();
        if (appContext != null) {
            cCh = ((WindowManager) appContext.getSystemService("window")).getDefaultDisplay().getRotation();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceDestroyed() {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceDestroyed.");
        this.cCq.surfaceDestroyed();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceChanged(int i, int i2) {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceChanged. width=" + i + ", height=" + i2);
        this.cCq.onWindowResize(i, i2);
        this.cCi.setEglContextToRecorder(getEGLContext(), i, i2);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRenderAndWait() {
        if (this.cCq != null) {
            this.cCq.requestRenderAndWait();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameOnPause() {
        this.cCi.smallGameOnPause();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void runOnGLThread(Runnable runnable) {
        if (this.cCq != null) {
            this.cCq.runOnGLThread(runnable);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable) {
        if (this.cCq != null) {
            this.cCq.queueEvent(runnable);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable, long j) {
        if (this.cCq != null) {
            this.cCq.b(runnable, j);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onAttachedToWindow() {
        if (this.mDetached && this.cCm != null) {
            int renderMode = this.cCq != null ? this.cCq.getRenderMode() : 1;
            this.cCq = new C0359a(this);
            if (renderMode != 1) {
                this.cCq.setRenderMode(renderMode);
            }
            this.cCq.start();
        }
        this.mDetached = false;
        Log.w("EngineLogger", "[V8Dispose][AREngine] onAttachedToWindow");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onDetachedFromWindow() {
        if (!this.mDetached && this.cCq != null) {
            this.cCq.requestExitAndWait();
        }
        this.mDetached = true;
        Log.w("EngineLogger", "[V8Dispose][AREngine] onDetachedFromWindow");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void clearOldEvents() {
        if (this.cCq != null) {
            this.cCq.clearOldEvents();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onPause() {
        if (this.cCq != null) {
            this.cCq.onPause();
        }
        if (this.cCi.getGameRecorder() != null) {
            this.cCi.getGameRecorder().acG();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onResume() {
        if (this.cCq != null) {
            this.cCq.onResume();
        }
        if (this.cCi.getGameRecorder() != null) {
            this.cCi.getGameRecorder().acH();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void pauseRecord() {
        if (this.cCi.getGameRecorder() != null) {
            this.cCi.getGameRecorder().pauseRecord();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void resumeRecord() {
        if (this.cCi.getGameRecorder() != null) {
            this.cCi.getGameRecorder().resumeRecord();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void stopRecord() {
        if (this.cCi.getGameRecorder() != null) {
            this.cCi.getGameRecorder().stopRecord();
            this.cCi.nativeUpdateRecordingStatus(false);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (this.cCi.getGameRecorder() != null) {
            this.cCi.nativeUpdateRecordingStatus(true);
            this.cCi.getGameRecorder().startRecord(z, i, str, z2);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setGameRecordCallback(com.baidu.mario.a.c cVar) {
        if (this.cCi.getGameRecorder() != null) {
            this.cCi.getGameRecorder().setGameRecordCallback(cVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setAudioEngineProxy(com.baidu.mario.a.a aVar) {
        if (this.cCi.getGameRecorder() != null) {
            this.cCi.getGameRecorder().setAudioEngineProxy(aVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public long getCurrentRecordProcess() {
        if (this.cCi.getGameRecorder() != null) {
            return this.cCi.getGameRecorder().acF();
        }
        return 0L;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setPermissionProxy(PermissionProxy permissionProxy) {
        cCg = permissionProxy;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setOnStuckScreenListener(com.baidu.smallgame.sdk.b.a aVar) {
        if (this.cCi != null) {
            this.cCi.setOnStuckScreenListener(aVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setStuckScreenLimitTime(long j) {
        if (this.cCi != null) {
            this.cCi.setStuckScreenLimitTime(j);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public com.baidu.smallgame.sdk.b.c getStuckScreenHandler() {
        if (this.cCi == null) {
            return null;
        }
        return this.cCi.getStuckScreenHandler();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameDestroy() {
        if (this.cCq == null) {
            Log.e("EngineLogger", "Destroy AREngine fail. Because GLThread is null");
        } else {
            this.cCq.runOnGLThread(new Runnable() { // from class: com.baidu.smallgame.sdk.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.cCq.mShouldExit = true;
                    a.this.cCi.smallGameDestroy();
                }
            });
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public boolean ableToDraw() {
        return this.cCq != null && this.cCq.ableToDraw();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void exitGLThread() {
        if (this.cCq != null) {
            this.cCq.requestExitAndWait();
        }
        Log.e("EngineLogger", "[V8Dispose][AREngine] exitGLThread.");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameUpdate() {
        this.cCi.smallGameUpdate();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setScreenShotStatus(boolean z) {
        this.cCi.setScreenShotStatus(z);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public JSONArray getPerformanceJson() {
        return this.cCi == null ? new JSONArray() : this.cCi.getPerformanceJson();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public PerformanceJsonBean getPerformanceJsonBean() {
        return this.cCi == null ? new PerformanceJsonBean() : this.cCi.getPerformanceJsonBean();
    }

    public void kA(String str) {
        if (this.cCi != null) {
            this.cCi.getPerformanceJsonBean().put(str);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setFirstFrameListener(ArBridge.FirstFrameListener firstFrameListener) {
        this.cCi.setFirstFrameListener(firstFrameListener);
    }

    public EGLContext getEGLContext() {
        if (this.cCq == null || this.cCq.cCE == null) {
            return null;
        }
        return this.cCq.cCE.mEglContext;
    }

    protected void finalize() throws Throwable {
        try {
            if (this.cCq != null) {
                this.cCq.requestExitAndWait();
            }
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.smallgame.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0359a extends Thread {
        private b cCE;
        private a cCF;
        private c cCo;
        private boolean cCz;
        private boolean mHasSurface;
        private boolean mHaveEglContext;
        private boolean mHaveEglSurface;
        private boolean mPaused;
        private boolean mRenderComplete;
        private boolean mRequestPaused;
        private boolean mShouldReleaseEglContext;
        private boolean mSurfaceIsBad;
        private boolean mWaitingForSurface;
        private int cCs = 0;
        private long cCt = 0;
        private long cCu = 0;
        private long cCv = 0;
        private long lastUpdateTime = 0;
        private boolean cCw = false;
        private boolean cCx = false;
        private boolean cCy = false;
        private volatile boolean mShouldExit = false;
        private volatile boolean mExited = false;
        private LinkedList<Runnable> cCB = new LinkedList<>();
        private LinkedList<Runnable> cCC = new LinkedList<>();
        private TreeSet<d> cCD = new TreeSet<>();
        private boolean mSizeChanged = true;
        private V8Engine mV8Engine = null;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean mRequestRender = true;
        private int mRenderMode = 1;
        private boolean cCA = false;

        C0359a(a aVar) {
            this.cCF = aVar;
            this.cCo = aVar.cCo;
        }

        /* JADX WARN: Type inference failed for: r4v0, types: [com.baidu.smallgame.sdk.a, com.baidu.searchbox.v8engine.V8Engine, com.baidu.smallgame.sdk.a$b] */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("ARGLThread " + getId());
            if (this.cCF != null) {
                ArBridge aiP = this.cCF.aiP();
                if (aiP != null) {
                    aiP.setGLThreadID(getId());
                    aiP.smallGameOnInit();
                    this.cCF.initDisplayMetrics();
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
                this.cCo.b(this);
                this.cCE.reset();
                this.cCE = null;
                this.cCF = null;
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
                this.cCE.destroySurface();
            }
        }

        private void stopEglContextLocked() {
            if (this.mHaveEglContext) {
                this.cCE.finish();
                this.mHaveEglContext = false;
                this.cCo.c(this);
            }
        }

        public boolean aiQ() {
            return this.cCF.cCi.mFirstFrameFinished && ((float) (System.currentTimeMillis() - this.cCv)) > minFramesInterval();
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
            if (r24.cCE.createSurface() == false) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:137:0x02ff, code lost:
            r11 = r24.cCo;
         */
        /* JADX WARN: Code restructure failed: missing block: B:138:0x0303, code lost:
            monitor-enter(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:140:0x0305, code lost:
            r24.cCz = true;
            r24.cCo.notifyAll();
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
            r4 = r24.cCF;
         */
        /* JADX WARN: Code restructure failed: missing block: B:147:0x031d, code lost:
            if (r4 == null) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:148:0x031f, code lost:
            r4.cCm.onSurfaceCreated(null, null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:149:0x0328, code lost:
            r10 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:150:0x032a, code lost:
            if (r8 == false) goto L91;
         */
        /* JADX WARN: Code restructure failed: missing block: B:151:0x032c, code lost:
            r4 = r24.cCF;
         */
        /* JADX WARN: Code restructure failed: missing block: B:152:0x0330, code lost:
            if (r4 == null) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:153:0x0332, code lost:
            r4.cCm.onSurfaceChanged(null, r15, r14);
            r4.updateSurfaceViewSize(r15, r14);
         */
        /* JADX WARN: Code restructure failed: missing block: B:154:0x033f, code lost:
            r9 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:155:0x0341, code lost:
            r0 = r24.cCF;
            r18 = java.lang.System.currentTimeMillis();
            r20 = r18 - r24.cCu;
         */
        /* JADX WARN: Code restructure failed: missing block: B:156:0x0357, code lost:
            if (r0.cCn == false) goto L90;
         */
        /* JADX WARN: Code restructure failed: missing block: B:158:0x0362, code lost:
            if (((float) r20) < minFramesInterval()) goto L90;
         */
        /* JADX WARN: Code restructure failed: missing block: B:159:0x0364, code lost:
            r24.cCu = java.lang.System.currentTimeMillis();
         */
        /* JADX WARN: Code restructure failed: missing block: B:160:0x0372, code lost:
            if (r24.cCw != false) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:162:0x0378, code lost:
            if (r24.cCF == null) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:163:0x037a, code lost:
            r24.cCw = true;
            r24.cCF.kA("first_frame");
         */
        /* JADX WARN: Code restructure failed: missing block: B:164:0x0389, code lost:
            r0.cCm.onDrawFrame(null);
            aiR();
         */
        /* JADX WARN: Code restructure failed: missing block: B:165:0x03a0, code lost:
            if ((r18 - r24.lastUpdateTime) <= 33) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:166:0x03a2, code lost:
            r0.cCi.notifyFrameUpdated();
            r24.lastUpdateTime = r18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:168:0x03b3, code lost:
            if (r24.cCy == false) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:169:0x03b5, code lost:
            r24.cCF.cCi.smallGameOnResume();
            r24.cCy = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:170:0x03c5, code lost:
            r4 = r0.cCi.shouldSwapBuffer();
         */
        /* JADX WARN: Code restructure failed: missing block: B:171:0x03cd, code lost:
            if (r4 == false) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:172:0x03cf, code lost:
            r8 = r24.cCE.swap();
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
            r8 = r24.cCo;
         */
        /* JADX WARN: Code restructure failed: missing block: B:175:0x03eb, code lost:
            monitor-enter(r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:177:0x03ee, code lost:
            r24.mSurfaceIsBad = true;
            r24.cCo.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:178:0x03fd, code lost:
            monitor-exit(r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:179:0x03fe, code lost:
            r24.cCv = java.lang.System.currentTimeMillis();
         */
        /* JADX WARN: Code restructure failed: missing block: B:180:0x0414, code lost:
            if (r24.cCF.cCi.isRenderCallbackQueueEmpty() != false) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:181:0x0416, code lost:
            if (r4 == false) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:182:0x0418, code lost:
            r8 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:184:0x0424, code lost:
            if ((r0.cCi.getStuckScreenHandler() instanceof com.baidu.smallgame.sdk.b) == false) goto L84;
         */
        /* JADX WARN: Code restructure failed: missing block: B:185:0x0426, code lost:
            ((com.baidu.smallgame.sdk.b) r0.cCi.getStuckScreenHandler()).l(r8, r24.cCv);
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
            r12 = r24.cCo;
         */
        /* JADX WARN: Code restructure failed: missing block: B:193:0x0457, code lost:
            monitor-enter(r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:195:0x0459, code lost:
            r24.cCz = true;
            r24.mSurfaceIsBad = true;
            r24.cCo.notifyAll();
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
            r0.cCn = true;
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
            if (r24.cCx != false) goto L102;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00aa, code lost:
            if (r24.cCF == null) goto L102;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00ac, code lost:
            r24.cCx = true;
            r24.cCF.kA("first_event");
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00bf, code lost:
            if (com.baidu.searchbox.v8engine.V8Engine.isDebug() == false) goto L107;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00c5, code lost:
            if (r24.cCF == null) goto L107;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00c7, code lost:
            r24.cCF.ag(1, r13.toString());
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
            this.cCE = new b(this.cCF);
            this.mHaveEglContext = false;
            this.mHaveEglSurface = false;
            this.cCA = false;
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
                    synchronized (this.cCo) {
                        z = z11;
                        z2 = z13;
                        z3 = z14;
                        z4 = z15;
                        z5 = z9;
                        z6 = z8;
                        while (!this.mShouldExit) {
                            if (this.cCC.isEmpty()) {
                                if (ableToDraw()) {
                                    if (aiQ()) {
                                        z7 = z12;
                                    } else {
                                        runnable = aiS();
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
                                        this.cCy = false;
                                        this.cCF.cCi.smallGameOnPauseOnGLThrad();
                                    } else {
                                        this.cCy = true;
                                    }
                                    this.cCo.notifyAll();
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
                                    this.cCo.notifyAll();
                                }
                                if (this.mHasSurface && this.mWaitingForSurface) {
                                    this.mWaitingForSurface = false;
                                    this.cCo.notifyAll();
                                }
                                if (z) {
                                    this.cCA = false;
                                    z = false;
                                    this.mRenderComplete = true;
                                    this.cCo.notifyAll();
                                }
                                if (readyToDraw()) {
                                    if (!this.mHaveEglContext) {
                                        if (z10) {
                                            z10 = false;
                                        } else {
                                            try {
                                                this.cCE.start();
                                                this.cCF.cCi.setEglContextToRecorder(this.cCF.getEGLContext(), 0, 0);
                                                this.mHaveEglContext = true;
                                                z6 = true;
                                                this.cCo.notifyAll();
                                            } catch (RuntimeException e) {
                                                this.cCo.c(this);
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
                                            this.cCA = true;
                                            z5 = true;
                                            this.mSizeChanged = false;
                                        }
                                        this.mRequestRender = false;
                                        this.cCo.notifyAll();
                                        if (this.cCA) {
                                            z7 = true;
                                        }
                                        z7 = z12;
                                    }
                                }
                                this.cCo.wait();
                            } else {
                                runnable = this.cCC.pollFirst();
                                z7 = z12;
                            }
                        }
                    }
                    synchronized (this.cCo) {
                        if (this.cCF != null) {
                            this.cCF.cCi.smallGameDestroy();
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
                    synchronized (this.cCo) {
                        if (this.cCF != null) {
                            this.cCF.cCi.smallGameDestroy();
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
            if (V8Engine.isDebug() && this.cCF != null) {
                this.cCF.ag(2, runnable.toString());
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

        private void aiR() {
            this.cCs++;
            if (this.cCt != 0) {
                float currentTimeMillis = ((float) (System.currentTimeMillis() - this.cCt)) / 1000.0f;
                if (currentTimeMillis > 1.0f) {
                    this.cCF.hA((int) (this.cCs / currentTimeMillis));
                    this.cCs = 0;
                    this.cCt = System.currentTimeMillis();
                    return;
                }
                return;
            }
            this.cCt = System.currentTimeMillis();
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
            synchronized (this.cCo) {
                this.mRenderMode = i;
                this.cCo.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (this.cCo) {
                i = this.mRenderMode;
            }
            return i;
        }

        public void requestRender() {
            synchronized (this.cCo) {
                this.mRequestRender = true;
                this.cCo.notifyAll();
            }
        }

        public void requestRenderAndWait() {
            synchronized (this.cCo) {
                if (Thread.currentThread() != this) {
                    this.cCA = true;
                    this.mRequestRender = true;
                    this.mRenderComplete = false;
                    this.cCo.notifyAll();
                    while (!this.mExited && !this.mPaused && !this.mRenderComplete && ableToDraw()) {
                        try {
                            this.cCo.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void surfaceCreated() {
            synchronized (this.cCo) {
                this.mHasSurface = true;
                this.cCz = false;
                this.cCo.notifyAll();
                while (this.mWaitingForSurface && !this.cCz && !this.mExited) {
                    try {
                        this.cCo.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (this.cCo) {
                this.mHasSurface = false;
                this.cCo.notifyAll();
                while (!this.mWaitingForSurface && !this.mExited) {
                    try {
                        this.cCo.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (this.cCo) {
                Log.i("EngineLogger", "onPause tid=" + getId());
                this.mRequestPaused = true;
                if (this.cCF != null && (this.cCF.cCi.getStuckScreenHandler() instanceof com.baidu.smallgame.sdk.b)) {
                    ((com.baidu.smallgame.sdk.b) this.cCF.cCi.getStuckScreenHandler()).aiW();
                }
                this.cCo.notifyAll();
                while (!this.mExited && !this.mPaused) {
                    Log.i("Main thread", "onPause waiting for mPaused.");
                    try {
                        this.cCo.wait(500L);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (this.cCo) {
                Log.i("EngineLogger", "onResume tid=" + getId());
                this.mRequestPaused = false;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                this.cCo.notifyAll();
                while (!this.mExited && this.mPaused && !this.mRenderComplete) {
                    Log.i("Main thread", "onResume waiting for !mPaused.");
                    try {
                        this.cCo.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onWindowResize(int i, int i2) {
            synchronized (this.cCo) {
                this.mWidth = i;
                this.mHeight = i2;
                this.mSizeChanged = true;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                if (Thread.currentThread() != this) {
                    this.cCo.notifyAll();
                    while (!this.mExited && !this.mPaused && !this.mRenderComplete && ableToDraw()) {
                        try {
                            this.cCo.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void requestExitAndWait() {
            synchronized (this.cCo) {
                this.mShouldExit = true;
                this.cCo.notifyAll();
                while (!this.mExited) {
                    try {
                        this.cCo.wait();
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
                synchronized (this.cCo) {
                    if (V8Engine.isDebug() && this.cCF != null) {
                        this.cCF.ag(0, runnable.toString());
                    }
                    if (z || ableToDraw()) {
                        this.cCB.add(runnable);
                    } else {
                        this.cCC.add(runnable);
                    }
                    this.cCo.notifyAll();
                }
            }
        }

        public void b(Runnable runnable, long j) {
            if (runnable == null) {
                throw new IllegalArgumentException("r must not be null");
            }
            if (!this.mShouldExit && !this.mExited) {
                synchronized (this.cCo) {
                    TreeSet<d> treeSet = this.cCD;
                    if (j <= 0) {
                        j = 0;
                    }
                    treeSet.add(new d(runnable, j));
                    this.cCo.notifyAll();
                }
            }
        }

        public void clearOldEvents() {
            synchronized (this.cCo) {
                this.cCB.clear();
                this.cCC.clear();
                this.cCD.clear();
            }
        }

        private Runnable aiS() {
            Runnable pollFirst;
            synchronized (this.cCo) {
                pollFirst = (this.cCD.isEmpty() || !this.cCD.first().isTimeout()) ? this.cCB.pollFirst() : this.cCD.pollFirst();
            }
            return pollFirst;
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements Comparable<d>, Runnable {
        private final Runnable cCK;
        private final long mTimestamp;

        d(Runnable runnable, long j) {
            this.cCK = runnable;
            this.mTimestamp = System.currentTimeMillis() + j;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.cCK.run();
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
    /* loaded from: classes5.dex */
    public static class c {
        private static String TAG = "GLThreadManager";
        private C0359a cCJ;

        private c() {
        }

        public synchronized void b(C0359a c0359a) {
            c0359a.mExited = true;
            if (this.cCJ == c0359a) {
                this.cCJ = null;
            }
            notifyAll();
        }

        public void c(C0359a c0359a) {
            if (this.cCJ == c0359a) {
                this.cCJ = null;
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b {
        private a cCF;
        EGLDisplay cCG;
        EGLSurface cCH;
        EGLConfig cCI;
        EGLContext mEglContext;

        public b(a aVar) {
            this.cCF = aVar;
        }

        public void reset() {
            this.cCF = null;
        }

        public void start() {
            this.cCG = EGL14.eglGetDisplay(0);
            if (this.cCG == EGL14.EGL_NO_DISPLAY) {
                throw new RuntimeException("unable to get EGL14 display");
            }
            int[] iArr = new int[2];
            if (!EGL14.eglInitialize(this.cCG, iArr, 0, iArr, 1)) {
                this.cCG = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            a aVar = this.cCF;
            this.cCI = h(0, 0, false);
            this.mEglContext = EGL14.eglCreateContext(this.cCG, this.cCI, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
            this.cCF.mCurrentGLThreadID = Thread.currentThread().getId();
            if (this.mEglContext == null || this.mEglContext == EGL14.EGL_NO_CONTEXT) {
                this.mEglContext = null;
                throwEglException("createContext");
            }
            this.cCH = null;
        }

        private EGLConfig h(int i, int i2, boolean z) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (EGL14.eglChooseConfig(this.cCG, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, z ? 16 : 0, 12326, 0, 12352, 4, 12344, 0, 12344}, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
                return eGLConfigArr[0];
            }
            Log.w("EngineLogger", "unable to find RGB8888 / " + i2 + " EGLConfig");
            return null;
        }

        public boolean createSurface() {
            if (this.cCG == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.cCI == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            destroySurface();
            Object obj = this.cCF.mSurfaceHolder;
            if (obj == null) {
                obj = this.cCF.cCp;
            }
            if (obj != null) {
                this.cCH = EGL14.eglCreateWindowSurface(this.cCG, this.cCI, obj, new int[]{12344}, 0);
            } else {
                this.cCH = null;
            }
            if (this.cCH == null || this.cCH == EGL14.EGL_NO_SURFACE) {
                if (EGL14.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    return false;
                }
                return false;
            }
            return EGL14.eglMakeCurrent(this.cCG, this.cCH, this.cCH, this.mEglContext);
        }

        public int swap() {
            return !EGL14.eglSwapBuffers(this.cCG, this.cCH) ? EGL14.eglGetError() : CommandMessage.COMMAND_BASE;
        }

        public void destroySurface() {
            if (this.cCH != null && this.cCH != EGL14.EGL_NO_SURFACE) {
                EGL14.eglMakeCurrent(this.cCG, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
                EGL14.eglDestroySurface(this.cCG, this.cCH);
                this.cCH = null;
            }
        }

        public void finish() {
            if (this.mEglContext != null) {
                EGL14.eglDestroyContext(this.cCG, this.mEglContext);
                this.mEglContext = null;
            }
            if (this.cCG != null) {
                EGL14.eglTerminate(this.cCG);
                this.cCG = null;
            }
            this.cCF.mCurrentGLThreadID = -1L;
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
        return this.cCi.isDestroyed();
    }
}
