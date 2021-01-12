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
/* loaded from: classes14.dex */
public final class a implements AREngineDelegate {
    public static PermissionProxy cxu = null;
    public static int cxv = 0;
    private GLSurfaceView.Renderer cxA;
    private Object cxD;
    private C0342a cxE;
    private ArBridge cxw;
    private Context mContext;
    private boolean mDetached;
    private SurfaceHolder mSurfaceHolder;
    private ArrayList<DebugConsole> mConsoles = null;
    private int cxx = 0;
    private long mCurrentGLThreadID = -1;
    private float cxy = 0.0f;
    private float cxz = 0.0f;
    private boolean cxB = false;
    private final c cxC = new c();

    public Context getContext() {
        return this.mContext;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        Log.setMinLogLevel(6, false);
        this.cxw = new ArBridge();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void startEngine() {
        if (this.cxA == null) {
            throw new NullPointerException("start render engine failed. because renderer is not set");
        }
        this.cxE = new C0342a(this);
        this.cxE.start();
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
    public void ah(int i, String str) {
        if (this.mConsoles != null) {
            for (DebugConsole debugConsole : new ArrayList(this.mConsoles)) {
                debugConsole.onReceiveInfo(i, str);
            }
        }
    }

    public ArBridge aeW() {
        return this.cxw;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public Thread getGLThread() {
        return this.cxE;
    }

    void fT(int i) {
        int i2 = i < 0 ? 0 : i;
        this.cxx = i2 <= 60 ? i2 : 60;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public int getFPS() {
        return this.cxx;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void updateSurfaceViewSize(float f, float f2) {
        Log.w("EngineLogger", "[ARDispose] updateSurfaceViewSize, width=" + f + ", height=" + f2);
        this.cxy = f;
        this.cxz = f2;
        this.cxw.setSize(f, f2);
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
        if (this.cxy != 0.0f) {
            f = this.cxy;
        }
        if (this.cxz != 0.0f) {
            f2 = this.cxz;
        }
        if (this.cxw != null) {
            this.cxw.setDisplayMetrics(f, f2, displayMetrics.xdpi, displayMetrics.ydpi, displayMetrics.density);
        } else {
            Log.e("EngineLogger", "[RenderError] error init render display, because arbridge is null");
        }
    }

    public void c(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = (SurfaceHolder) new WeakReference(surfaceHolder).get();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderer(GLSurfaceView.Renderer renderer) {
        this.cxA = renderer;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderMode(int i) {
        if (this.cxE != null) {
            this.cxE.setRenderMode(i);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public int getRenderMode() {
        if (this.cxE != null) {
            return this.cxE.getRenderMode();
        }
        return 1;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRender() {
        if (this.cxE != null) {
            this.cxE.requestRender();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceCreated() {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceCreated.");
        this.cxE.surfaceCreated();
        Context appContext = V8Engine.getAppContext();
        if (appContext != null) {
            cxv = ((WindowManager) appContext.getSystemService("window")).getDefaultDisplay().getRotation();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceDestroyed() {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceDestroyed.");
        this.cxE.surfaceDestroyed();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceChanged(int i, int i2) {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceChanged. width=" + i + ", height=" + i2);
        this.cxE.onWindowResize(i, i2);
        this.cxw.setEglContextToRecorder(getEGLContext(), i, i2);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRenderAndWait() {
        if (this.cxE != null) {
            this.cxE.requestRenderAndWait();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameOnPause() {
        this.cxw.smallGameOnPause();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void runOnGLThread(Runnable runnable) {
        if (this.cxE != null) {
            this.cxE.runOnGLThread(runnable);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable) {
        if (this.cxE != null) {
            this.cxE.queueEvent(runnable);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable, long j) {
        if (this.cxE != null) {
            this.cxE.b(runnable, j);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onAttachedToWindow() {
        if (this.mDetached && this.cxA != null) {
            int renderMode = this.cxE != null ? this.cxE.getRenderMode() : 1;
            this.cxE = new C0342a(this);
            if (renderMode != 1) {
                this.cxE.setRenderMode(renderMode);
            }
            this.cxE.start();
        }
        this.mDetached = false;
        Log.w("EngineLogger", "[V8Dispose][AREngine] onAttachedToWindow");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onDetachedFromWindow() {
        if (!this.mDetached && this.cxE != null) {
            this.cxE.requestExitAndWait();
        }
        this.mDetached = true;
        Log.w("EngineLogger", "[V8Dispose][AREngine] onDetachedFromWindow");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void clearOldEvents() {
        if (this.cxE != null) {
            this.cxE.clearOldEvents();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onPause() {
        if (this.cxE != null) {
            this.cxE.onPause();
        }
        if (this.cxw.getGameRecorder() != null) {
            this.cxw.getGameRecorder().YO();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onResume() {
        if (this.cxE != null) {
            this.cxE.onResume();
        }
        if (this.cxw.getGameRecorder() != null) {
            this.cxw.getGameRecorder().YP();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void pauseRecord() {
        if (this.cxw.getGameRecorder() != null) {
            this.cxw.getGameRecorder().pauseRecord();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void resumeRecord() {
        if (this.cxw.getGameRecorder() != null) {
            this.cxw.getGameRecorder().resumeRecord();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void stopRecord() {
        if (this.cxw.getGameRecorder() != null) {
            this.cxw.getGameRecorder().stopRecord();
            this.cxw.nativeUpdateRecordingStatus(false);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (this.cxw.getGameRecorder() != null) {
            this.cxw.nativeUpdateRecordingStatus(true);
            this.cxw.getGameRecorder().startRecord(z, i, str, z2);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setGameRecordCallback(com.baidu.mario.a.c cVar) {
        if (this.cxw.getGameRecorder() != null) {
            this.cxw.getGameRecorder().setGameRecordCallback(cVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setAudioEngineProxy(com.baidu.mario.a.a aVar) {
        if (this.cxw.getGameRecorder() != null) {
            this.cxw.getGameRecorder().setAudioEngineProxy(aVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public long getCurrentRecordProcess() {
        if (this.cxw.getGameRecorder() != null) {
            return this.cxw.getGameRecorder().YN();
        }
        return 0L;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setPermissionProxy(PermissionProxy permissionProxy) {
        cxu = permissionProxy;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setOnStuckScreenListener(com.baidu.smallgame.sdk.b.a aVar) {
        if (this.cxw != null) {
            this.cxw.setOnStuckScreenListener(aVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setStuckScreenLimitTime(long j) {
        if (this.cxw != null) {
            this.cxw.setStuckScreenLimitTime(j);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public com.baidu.smallgame.sdk.b.c getStuckScreenHandler() {
        if (this.cxw == null) {
            return null;
        }
        return this.cxw.getStuckScreenHandler();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameDestroy() {
        if (this.cxE == null) {
            Log.e("EngineLogger", "Destroy AREngine fail. Because GLThread is null");
        } else {
            this.cxE.runOnGLThread(new Runnable() { // from class: com.baidu.smallgame.sdk.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.cxE.mShouldExit = true;
                    a.this.cxw.smallGameDestroy();
                }
            });
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public boolean ableToDraw() {
        return this.cxE != null && this.cxE.ableToDraw();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void exitGLThread() {
        if (this.cxE != null) {
            this.cxE.requestExitAndWait();
        }
        Log.e("EngineLogger", "[V8Dispose][AREngine] exitGLThread.");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameUpdate() {
        this.cxw.smallGameUpdate();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setScreenShotStatus(boolean z) {
        this.cxw.setScreenShotStatus(z);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public JSONArray getPerformanceJson() {
        return this.cxw == null ? new JSONArray() : this.cxw.getPerformanceJson();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public PerformanceJsonBean getPerformanceJsonBean() {
        return this.cxw == null ? new PerformanceJsonBean() : this.cxw.getPerformanceJsonBean();
    }

    public void jp(String str) {
        if (this.cxw != null) {
            this.cxw.getPerformanceJsonBean().put(str);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setFirstFrameListener(ArBridge.FirstFrameListener firstFrameListener) {
        this.cxw.setFirstFrameListener(firstFrameListener);
    }

    public EGLContext getEGLContext() {
        if (this.cxE == null || this.cxE.cxS == null) {
            return null;
        }
        return this.cxE.cxS.mEglContext;
    }

    protected void finalize() throws Throwable {
        try {
            if (this.cxE != null) {
                this.cxE.requestExitAndWait();
            }
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.smallgame.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static class C0342a extends Thread {
        private c cxC;
        private boolean cxN;
        private b cxS;
        private a cxT;
        private boolean mHasSurface;
        private boolean mHaveEglContext;
        private boolean mHaveEglSurface;
        private boolean mPaused;
        private boolean mRenderComplete;
        private boolean mRequestPaused;
        private boolean mShouldReleaseEglContext;
        private boolean mSurfaceIsBad;
        private boolean mWaitingForSurface;
        private int cxG = 0;
        private long cxH = 0;
        private long cxI = 0;
        private long cxJ = 0;
        private long lastUpdateTime = 0;
        private boolean cxK = false;
        private boolean cxL = false;
        private boolean cxM = false;
        private volatile boolean mShouldExit = false;
        private volatile boolean mExited = false;
        private LinkedList<Runnable> cxP = new LinkedList<>();
        private LinkedList<Runnable> cxQ = new LinkedList<>();
        private TreeSet<d> cxR = new TreeSet<>();
        private boolean mSizeChanged = true;
        private V8Engine mV8Engine = null;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean mRequestRender = true;
        private int mRenderMode = 1;
        private boolean cxO = false;

        C0342a(a aVar) {
            this.cxT = aVar;
            this.cxC = aVar.cxC;
        }

        /* JADX WARN: Type inference failed for: r4v0, types: [com.baidu.smallgame.sdk.a, com.baidu.searchbox.v8engine.V8Engine, com.baidu.smallgame.sdk.a$b] */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("ARGLThread " + getId());
            if (this.cxT != null) {
                ArBridge aeW = this.cxT.aeW();
                if (aeW != null) {
                    aeW.setGLThreadID(getId());
                    aeW.smallGameOnInit();
                    this.cxT.initDisplayMetrics();
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
                this.cxC.b(this);
                this.cxS.reset();
                this.cxS = null;
                this.cxT = null;
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
                this.cxS.destroySurface();
            }
        }

        private void stopEglContextLocked() {
            if (this.mHaveEglContext) {
                this.cxS.finish();
                this.mHaveEglContext = false;
                this.cxC.c(this);
            }
        }

        public boolean aeX() {
            return this.cxT.cxw.mFirstFrameFinished && ((float) (System.currentTimeMillis() - this.cxJ)) > minFramesInterval();
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
            if (r24.cxS.createSurface() == false) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:137:0x02ff, code lost:
            r11 = r24.cxC;
         */
        /* JADX WARN: Code restructure failed: missing block: B:138:0x0303, code lost:
            monitor-enter(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:140:0x0305, code lost:
            r24.cxN = true;
            r24.cxC.notifyAll();
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
            r4 = r24.cxT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:147:0x031d, code lost:
            if (r4 == null) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:148:0x031f, code lost:
            r4.cxA.onSurfaceCreated(null, null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:149:0x0328, code lost:
            r10 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:150:0x032a, code lost:
            if (r8 == false) goto L91;
         */
        /* JADX WARN: Code restructure failed: missing block: B:151:0x032c, code lost:
            r4 = r24.cxT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:152:0x0330, code lost:
            if (r4 == null) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:153:0x0332, code lost:
            r4.cxA.onSurfaceChanged(null, r15, r14);
            r4.updateSurfaceViewSize(r15, r14);
         */
        /* JADX WARN: Code restructure failed: missing block: B:154:0x033f, code lost:
            r9 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:155:0x0341, code lost:
            r0 = r24.cxT;
            r18 = java.lang.System.currentTimeMillis();
            r20 = r18 - r24.cxI;
         */
        /* JADX WARN: Code restructure failed: missing block: B:156:0x0357, code lost:
            if (r0.cxB == false) goto L90;
         */
        /* JADX WARN: Code restructure failed: missing block: B:158:0x0362, code lost:
            if (((float) r20) < minFramesInterval()) goto L90;
         */
        /* JADX WARN: Code restructure failed: missing block: B:159:0x0364, code lost:
            r24.cxI = java.lang.System.currentTimeMillis();
         */
        /* JADX WARN: Code restructure failed: missing block: B:160:0x0372, code lost:
            if (r24.cxK != false) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:162:0x0378, code lost:
            if (r24.cxT == null) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:163:0x037a, code lost:
            r24.cxK = true;
            r24.cxT.jp("first_frame");
         */
        /* JADX WARN: Code restructure failed: missing block: B:164:0x0389, code lost:
            r0.cxA.onDrawFrame(null);
            aeY();
         */
        /* JADX WARN: Code restructure failed: missing block: B:165:0x03a0, code lost:
            if ((r18 - r24.lastUpdateTime) <= 33) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:166:0x03a2, code lost:
            r0.cxw.notifyFrameUpdated();
            r24.lastUpdateTime = r18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:168:0x03b3, code lost:
            if (r24.cxM == false) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:169:0x03b5, code lost:
            r24.cxT.cxw.smallGameOnResume();
            r24.cxM = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:170:0x03c5, code lost:
            r4 = r0.cxw.shouldSwapBuffer();
         */
        /* JADX WARN: Code restructure failed: missing block: B:171:0x03cd, code lost:
            if (r4 == false) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:172:0x03cf, code lost:
            r8 = r24.cxS.swap();
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
            r8 = r24.cxC;
         */
        /* JADX WARN: Code restructure failed: missing block: B:175:0x03eb, code lost:
            monitor-enter(r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:177:0x03ee, code lost:
            r24.mSurfaceIsBad = true;
            r24.cxC.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:178:0x03fd, code lost:
            monitor-exit(r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:179:0x03fe, code lost:
            r24.cxJ = java.lang.System.currentTimeMillis();
         */
        /* JADX WARN: Code restructure failed: missing block: B:180:0x0414, code lost:
            if (r24.cxT.cxw.isRenderCallbackQueueEmpty() != false) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:181:0x0416, code lost:
            if (r4 == false) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:182:0x0418, code lost:
            r8 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:184:0x0424, code lost:
            if ((r0.cxw.getStuckScreenHandler() instanceof com.baidu.smallgame.sdk.b) == false) goto L84;
         */
        /* JADX WARN: Code restructure failed: missing block: B:185:0x0426, code lost:
            ((com.baidu.smallgame.sdk.b) r0.cxw.getStuckScreenHandler()).l(r8, r24.cxJ);
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
            r12 = r24.cxC;
         */
        /* JADX WARN: Code restructure failed: missing block: B:193:0x0457, code lost:
            monitor-enter(r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:195:0x0459, code lost:
            r24.cxN = true;
            r24.mSurfaceIsBad = true;
            r24.cxC.notifyAll();
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
            r0.cxB = true;
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
            if (r24.cxL != false) goto L102;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00aa, code lost:
            if (r24.cxT == null) goto L102;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00ac, code lost:
            r24.cxL = true;
            r24.cxT.jp("first_event");
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00bf, code lost:
            if (com.baidu.searchbox.v8engine.V8Engine.isDebug() == false) goto L107;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00c5, code lost:
            if (r24.cxT == null) goto L107;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00c7, code lost:
            r24.cxT.ah(1, r13.toString());
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
            this.cxS = new b(this.cxT);
            this.mHaveEglContext = false;
            this.mHaveEglSurface = false;
            this.cxO = false;
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
                    synchronized (this.cxC) {
                        z = z11;
                        z2 = z13;
                        z3 = z14;
                        z4 = z15;
                        z5 = z9;
                        z6 = z8;
                        while (!this.mShouldExit) {
                            if (this.cxQ.isEmpty()) {
                                if (ableToDraw()) {
                                    if (aeX()) {
                                        z7 = z12;
                                    } else {
                                        runnable = aeZ();
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
                                        this.cxM = false;
                                        this.cxT.cxw.smallGameOnPauseOnGLThrad();
                                    } else {
                                        this.cxM = true;
                                    }
                                    this.cxC.notifyAll();
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
                                    this.cxC.notifyAll();
                                }
                                if (this.mHasSurface && this.mWaitingForSurface) {
                                    this.mWaitingForSurface = false;
                                    this.cxC.notifyAll();
                                }
                                if (z) {
                                    this.cxO = false;
                                    z = false;
                                    this.mRenderComplete = true;
                                    this.cxC.notifyAll();
                                }
                                if (readyToDraw()) {
                                    if (!this.mHaveEglContext) {
                                        if (z10) {
                                            z10 = false;
                                        } else {
                                            try {
                                                this.cxS.start();
                                                this.cxT.cxw.setEglContextToRecorder(this.cxT.getEGLContext(), 0, 0);
                                                this.mHaveEglContext = true;
                                                z6 = true;
                                                this.cxC.notifyAll();
                                            } catch (RuntimeException e) {
                                                this.cxC.c(this);
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
                                            this.cxO = true;
                                            z5 = true;
                                            this.mSizeChanged = false;
                                        }
                                        this.mRequestRender = false;
                                        this.cxC.notifyAll();
                                        if (this.cxO) {
                                            z7 = true;
                                        }
                                        z7 = z12;
                                    }
                                }
                                this.cxC.wait();
                            } else {
                                runnable = this.cxQ.pollFirst();
                                z7 = z12;
                            }
                        }
                    }
                    synchronized (this.cxC) {
                        if (this.cxT != null) {
                            this.cxT.cxw.smallGameDestroy();
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
                    synchronized (this.cxC) {
                        if (this.cxT != null) {
                            this.cxT.cxw.smallGameDestroy();
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
            if (V8Engine.isDebug() && this.cxT != null) {
                this.cxT.ah(2, runnable.toString());
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

        private void aeY() {
            this.cxG++;
            if (this.cxH != 0) {
                float currentTimeMillis = ((float) (System.currentTimeMillis() - this.cxH)) / 1000.0f;
                if (currentTimeMillis > 1.0f) {
                    this.cxT.fT((int) (this.cxG / currentTimeMillis));
                    this.cxG = 0;
                    this.cxH = System.currentTimeMillis();
                    return;
                }
                return;
            }
            this.cxH = System.currentTimeMillis();
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
            synchronized (this.cxC) {
                this.mRenderMode = i;
                this.cxC.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (this.cxC) {
                i = this.mRenderMode;
            }
            return i;
        }

        public void requestRender() {
            synchronized (this.cxC) {
                this.mRequestRender = true;
                this.cxC.notifyAll();
            }
        }

        public void requestRenderAndWait() {
            synchronized (this.cxC) {
                if (Thread.currentThread() != this) {
                    this.cxO = true;
                    this.mRequestRender = true;
                    this.mRenderComplete = false;
                    this.cxC.notifyAll();
                    while (!this.mExited && !this.mPaused && !this.mRenderComplete && ableToDraw()) {
                        try {
                            this.cxC.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void surfaceCreated() {
            synchronized (this.cxC) {
                this.mHasSurface = true;
                this.cxN = false;
                this.cxC.notifyAll();
                while (this.mWaitingForSurface && !this.cxN && !this.mExited) {
                    try {
                        this.cxC.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (this.cxC) {
                this.mHasSurface = false;
                this.cxC.notifyAll();
                while (!this.mWaitingForSurface && !this.mExited) {
                    try {
                        this.cxC.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (this.cxC) {
                Log.i("EngineLogger", "onPause tid=" + getId());
                this.mRequestPaused = true;
                if (this.cxT != null && (this.cxT.cxw.getStuckScreenHandler() instanceof com.baidu.smallgame.sdk.b)) {
                    ((com.baidu.smallgame.sdk.b) this.cxT.cxw.getStuckScreenHandler()).afd();
                }
                this.cxC.notifyAll();
                while (!this.mExited && !this.mPaused) {
                    Log.i("Main thread", "onPause waiting for mPaused.");
                    try {
                        this.cxC.wait(500L);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (this.cxC) {
                Log.i("EngineLogger", "onResume tid=" + getId());
                this.mRequestPaused = false;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                this.cxC.notifyAll();
                while (!this.mExited && this.mPaused && !this.mRenderComplete) {
                    Log.i("Main thread", "onResume waiting for !mPaused.");
                    try {
                        this.cxC.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onWindowResize(int i, int i2) {
            synchronized (this.cxC) {
                this.mWidth = i;
                this.mHeight = i2;
                this.mSizeChanged = true;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                if (Thread.currentThread() != this) {
                    this.cxC.notifyAll();
                    while (!this.mExited && !this.mPaused && !this.mRenderComplete && ableToDraw()) {
                        try {
                            this.cxC.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void requestExitAndWait() {
            synchronized (this.cxC) {
                this.mShouldExit = true;
                this.cxC.notifyAll();
                while (!this.mExited) {
                    try {
                        this.cxC.wait();
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
                synchronized (this.cxC) {
                    if (V8Engine.isDebug() && this.cxT != null) {
                        this.cxT.ah(0, runnable.toString());
                    }
                    if (z || ableToDraw()) {
                        this.cxP.add(runnable);
                    } else {
                        this.cxQ.add(runnable);
                    }
                    this.cxC.notifyAll();
                }
            }
        }

        public void b(Runnable runnable, long j) {
            if (runnable == null) {
                throw new IllegalArgumentException("r must not be null");
            }
            if (!this.mShouldExit && !this.mExited) {
                synchronized (this.cxC) {
                    TreeSet<d> treeSet = this.cxR;
                    if (j <= 0) {
                        j = 0;
                    }
                    treeSet.add(new d(runnable, j));
                    this.cxC.notifyAll();
                }
            }
        }

        public void clearOldEvents() {
            synchronized (this.cxC) {
                this.cxP.clear();
                this.cxQ.clear();
                this.cxR.clear();
            }
        }

        private Runnable aeZ() {
            Runnable pollFirst;
            synchronized (this.cxC) {
                pollFirst = (this.cxR.isEmpty() || !this.cxR.first().isTimeout()) ? this.cxP.pollFirst() : this.cxR.pollFirst();
            }
            return pollFirst;
        }
    }

    /* loaded from: classes14.dex */
    public static class d implements Comparable<d>, Runnable {
        private final Runnable cxY;
        private final long mTimestamp;

        d(Runnable runnable, long j) {
            this.cxY = runnable;
            this.mTimestamp = System.currentTimeMillis() + j;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.cxY.run();
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
    /* loaded from: classes14.dex */
    public static class c {
        private static String TAG = "GLThreadManager";
        private C0342a cxX;

        private c() {
        }

        public synchronized void b(C0342a c0342a) {
            c0342a.mExited = true;
            if (this.cxX == c0342a) {
                this.cxX = null;
            }
            notifyAll();
        }

        public void c(C0342a c0342a) {
            if (this.cxX == c0342a) {
                this.cxX = null;
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public static class b {
        private a cxT;
        EGLDisplay cxU;
        EGLSurface cxV;
        EGLConfig cxW;
        EGLContext mEglContext;

        public b(a aVar) {
            this.cxT = aVar;
        }

        public void reset() {
            this.cxT = null;
        }

        public void start() {
            this.cxU = EGL14.eglGetDisplay(0);
            if (this.cxU == EGL14.EGL_NO_DISPLAY) {
                throw new RuntimeException("unable to get EGL14 display");
            }
            int[] iArr = new int[2];
            if (!EGL14.eglInitialize(this.cxU, iArr, 0, iArr, 1)) {
                this.cxU = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            a aVar = this.cxT;
            this.cxW = h(0, 0, false);
            this.mEglContext = EGL14.eglCreateContext(this.cxU, this.cxW, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
            this.cxT.mCurrentGLThreadID = Thread.currentThread().getId();
            if (this.mEglContext == null || this.mEglContext == EGL14.EGL_NO_CONTEXT) {
                this.mEglContext = null;
                throwEglException("createContext");
            }
            this.cxV = null;
        }

        private EGLConfig h(int i, int i2, boolean z) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (EGL14.eglChooseConfig(this.cxU, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, z ? 16 : 0, 12326, 0, 12352, 4, 12344, 0, 12344}, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
                return eGLConfigArr[0];
            }
            Log.w("EngineLogger", "unable to find RGB8888 / " + i2 + " EGLConfig");
            return null;
        }

        public boolean createSurface() {
            if (this.cxU == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.cxW == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            destroySurface();
            Object obj = this.cxT.mSurfaceHolder;
            if (obj == null) {
                obj = this.cxT.cxD;
            }
            if (obj != null) {
                this.cxV = EGL14.eglCreateWindowSurface(this.cxU, this.cxW, obj, new int[]{12344}, 0);
            } else {
                this.cxV = null;
            }
            if (this.cxV == null || this.cxV == EGL14.EGL_NO_SURFACE) {
                if (EGL14.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    return false;
                }
                return false;
            }
            return EGL14.eglMakeCurrent(this.cxU, this.cxV, this.cxV, this.mEglContext);
        }

        public int swap() {
            return !EGL14.eglSwapBuffers(this.cxU, this.cxV) ? EGL14.eglGetError() : CommandMessage.COMMAND_BASE;
        }

        public void destroySurface() {
            if (this.cxV != null && this.cxV != EGL14.EGL_NO_SURFACE) {
                EGL14.eglMakeCurrent(this.cxU, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
                EGL14.eglDestroySurface(this.cxU, this.cxV);
                this.cxV = null;
            }
        }

        public void finish() {
            if (this.mEglContext != null) {
                EGL14.eglDestroyContext(this.cxU, this.mEglContext);
                this.mEglContext = null;
            }
            if (this.cxU != null) {
                EGL14.eglTerminate(this.cxU);
                this.cxU = null;
            }
            this.cxT.mCurrentGLThreadID = -1L;
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
        return this.cxw.isDestroyed();
    }
}
