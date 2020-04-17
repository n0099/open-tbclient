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
import com.coloros.mcssdk.mode.CommandMessage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public final class a implements AREngineDelegate {
    public static PermissionProxy bwV = null;
    public static int bwW = 0;
    private ArBridge bwX;
    private GLSurfaceView.Renderer bxa;
    private Object bxd;
    private C0220a bxe;
    private Context mContext;
    private boolean mDetached;
    private SurfaceHolder mSurfaceHolder;
    private ArrayList<DebugConsole> mConsoles = null;
    private int mFPS = 0;
    private long mCurrentGLThreadID = -1;
    private float bwY = 0.0f;
    private float bwZ = 0.0f;
    private boolean bxb = false;
    private final c bxc = new c();

    public Context getContext() {
        return this.mContext;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        Log.setMinLogLevel(6, false);
        this.bwX = new ArBridge();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void startEngine() {
        if (this.bxa == null) {
            throw new NullPointerException("start render engine failed. because renderer is not set");
        }
        this.bxe = new C0220a(this);
        this.bxe.start();
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
    public void L(int i, String str) {
        if (this.mConsoles != null) {
            for (DebugConsole debugConsole : new ArrayList(this.mConsoles)) {
                debugConsole.onReceiveInfo(i, str);
            }
        }
    }

    public ArBridge NP() {
        return this.bwX;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public Thread getGLThread() {
        return this.bxe;
    }

    void dT(int i) {
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
        this.bwY = f;
        this.bwZ = f2;
        this.bwX.setSize(f, f2);
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
        if (this.bwY != 0.0f) {
            f = this.bwY;
        }
        if (this.bwZ != 0.0f) {
            f2 = this.bwZ;
        }
        if (this.bwX != null) {
            this.bwX.setDisplayMetrics(f, f2, displayMetrics.xdpi, displayMetrics.ydpi, displayMetrics.density);
        } else {
            Log.e("EngineLogger", "[RenderError] error init render display, because arbridge is null");
        }
    }

    public void c(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = (SurfaceHolder) new WeakReference(surfaceHolder).get();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderer(GLSurfaceView.Renderer renderer) {
        this.bxa = renderer;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderMode(int i) {
        if (this.bxe != null) {
            this.bxe.setRenderMode(i);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public int getRenderMode() {
        if (this.bxe != null) {
            return this.bxe.getRenderMode();
        }
        return 1;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRender() {
        if (this.bxe != null) {
            this.bxe.requestRender();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceCreated() {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceCreated.");
        this.bxe.surfaceCreated();
        Context appContext = V8Engine.getAppContext();
        if (appContext != null) {
            bwW = ((WindowManager) appContext.getSystemService("window")).getDefaultDisplay().getRotation();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceDestroyed() {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceDestroyed.");
        this.bxe.surfaceDestroyed();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceChanged(int i, int i2) {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceChanged. width=" + i + ", height=" + i2);
        this.bxe.onWindowResize(i, i2);
        this.bwX.setEglContextToRecorder(getEGLContext(), i, i2);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRenderAndWait() {
        if (this.bxe != null) {
            this.bxe.requestRenderAndWait();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameOnPause() {
        this.bwX.smallGameOnPause();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void runOnGLThread(Runnable runnable) {
        if (this.bxe != null) {
            this.bxe.runOnGLThread(runnable);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable) {
        if (this.bxe != null) {
            this.bxe.queueEvent(runnable);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable, long j) {
        if (this.bxe != null) {
            this.bxe.b(runnable, j);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onAttachedToWindow() {
        if (this.mDetached && this.bxa != null) {
            int renderMode = this.bxe != null ? this.bxe.getRenderMode() : 1;
            this.bxe = new C0220a(this);
            if (renderMode != 1) {
                this.bxe.setRenderMode(renderMode);
            }
            this.bxe.start();
        }
        this.mDetached = false;
        Log.w("EngineLogger", "[V8Dispose][AREngine] onAttachedToWindow");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onDetachedFromWindow() {
        if (!this.mDetached && this.bxe != null) {
            this.bxe.requestExitAndWait();
        }
        this.mDetached = true;
        Log.w("EngineLogger", "[V8Dispose][AREngine] onDetachedFromWindow");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void clearOldEvents() {
        if (this.bxe != null) {
            this.bxe.clearOldEvents();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onPause() {
        if (this.bxe != null) {
            this.bxe.onPause();
        }
        if (this.bwX.getGameRecorder() != null) {
            this.bwX.getGameRecorder().IR();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onResume() {
        if (this.bxe != null) {
            this.bxe.onResume();
        }
        if (this.bwX.getGameRecorder() != null) {
            this.bwX.getGameRecorder().IS();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void pauseRecord() {
        if (this.bwX.getGameRecorder() != null) {
            this.bwX.getGameRecorder().pauseRecord();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void resumeRecord() {
        if (this.bwX.getGameRecorder() != null) {
            this.bwX.getGameRecorder().resumeRecord();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void stopRecord() {
        if (this.bwX.getGameRecorder() != null) {
            this.bwX.getGameRecorder().stopRecord();
            this.bwX.nativeUpdateRecordingStatus(false);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (this.bwX.getGameRecorder() != null) {
            this.bwX.nativeUpdateRecordingStatus(true);
            this.bwX.getGameRecorder().startRecord(z, i, str, z2);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setGameRecordCallback(com.baidu.mario.a.c cVar) {
        if (this.bwX.getGameRecorder() != null) {
            this.bwX.getGameRecorder().setGameRecordCallback(cVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setAudioEngineProxy(com.baidu.mario.a.a aVar) {
        if (this.bwX.getGameRecorder() != null) {
            this.bwX.getGameRecorder().setAudioEngineProxy(aVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public long getCurrentRecordProcess() {
        if (this.bwX.getGameRecorder() != null) {
            return this.bwX.getGameRecorder().IQ();
        }
        return 0L;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setPermissionProxy(PermissionProxy permissionProxy) {
        bwV = permissionProxy;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setOnStuckScreenListener(com.baidu.smallgame.sdk.b.a aVar) {
        if (this.bwX != null) {
            this.bwX.setOnStuckScreenListener(aVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setStuckScreenLimitTime(long j) {
        if (this.bwX != null) {
            this.bwX.setStuckScreenLimitTime(j);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public com.baidu.smallgame.sdk.b.c getStuckScreenHandler() {
        if (this.bwX == null) {
            return null;
        }
        return this.bwX.getStuckScreenHandler();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameDestroy() {
        if (this.bxe == null) {
            Log.e("EngineLogger", "Destroy AREngine fail. Because GLThread is null");
        } else {
            this.bxe.runOnGLThread(new Runnable() { // from class: com.baidu.smallgame.sdk.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.bxe.mShouldExit = true;
                    a.this.bwX.smallGameDestroy();
                }
            });
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public boolean ableToDraw() {
        return this.bxe != null && this.bxe.ableToDraw();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void exitGLThread() {
        if (this.bxe != null) {
            this.bxe.requestExitAndWait();
        }
        Log.e("EngineLogger", "[V8Dispose][AREngine] exitGLThread.");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameUpdate() {
        this.bwX.smallGameUpdate();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setScreenShotStatus(boolean z) {
        this.bwX.setScreenShotStatus(z);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public JSONArray getPerformanceJson() {
        return this.bwX == null ? new JSONArray() : this.bwX.getPerformanceJson();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public PerformanceJsonBean getPerformanceJsonBean() {
        return this.bwX == null ? new PerformanceJsonBean() : this.bwX.getPerformanceJsonBean();
    }

    public void gg(String str) {
        if (this.bwX != null) {
            this.bwX.getPerformanceJsonBean().put(str);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setFirstFrameListener(ArBridge.FirstFrameListener firstFrameListener) {
        this.bwX.setFirstFrameListener(firstFrameListener);
    }

    public EGLContext getEGLContext() {
        if (this.bxe == null || this.bxe.bxt == null) {
            return null;
        }
        return this.bxe.bxt.mEglContext;
    }

    protected void finalize() throws Throwable {
        try {
            if (this.bxe != null) {
                this.bxe.requestExitAndWait();
            }
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.smallgame.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0220a extends Thread {
        private c bxc;
        private boolean bxo;
        private b bxt;
        private a bxu;
        private boolean mHasSurface;
        private boolean mHaveEglContext;
        private boolean mHaveEglSurface;
        private boolean mPaused;
        private boolean mRenderComplete;
        private boolean mRequestPaused;
        private boolean mShouldReleaseEglContext;
        private boolean mSurfaceIsBad;
        private boolean mWaitingForSurface;
        private int bxg = 0;
        private long bxh = 0;
        private long bxi = 0;
        private long bxj = 0;
        private long bxk = 0;
        private boolean bxl = false;
        private boolean bxm = false;
        private boolean bxn = false;
        private volatile boolean mShouldExit = false;
        private volatile boolean mExited = false;
        private LinkedList<Runnable> bxq = new LinkedList<>();
        private LinkedList<Runnable> bxr = new LinkedList<>();
        private TreeSet<d> bxs = new TreeSet<>();
        private boolean mSizeChanged = true;
        private V8Engine mV8Engine = null;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean mRequestRender = true;
        private int mRenderMode = 1;
        private boolean bxp = false;

        C0220a(a aVar) {
            this.bxu = aVar;
            this.bxc = aVar.bxc;
        }

        /* JADX WARN: Type inference failed for: r4v0, types: [com.baidu.smallgame.sdk.a, com.baidu.searchbox.v8engine.V8Engine, com.baidu.smallgame.sdk.a$b] */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("ARGLThread " + getId());
            if (this.bxu != null) {
                ArBridge NP = this.bxu.NP();
                if (NP != null) {
                    NP.setGLThreadID(getId());
                    NP.smallGameOnInit();
                    this.bxu.initDisplayMetrics();
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
                this.bxc.b(this);
                this.bxt.reset();
                this.bxt = null;
                this.bxu = null;
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
                this.bxt.destroySurface();
            }
        }

        private void stopEglContextLocked() {
            if (this.mHaveEglContext) {
                this.bxt.finish();
                this.mHaveEglContext = false;
                this.bxc.c(this);
            }
        }

        public boolean NQ() {
            return this.bxu.bwX.mFirstFrameFinished && ((float) (System.currentTimeMillis() - this.bxj)) > minFramesInterval();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1082=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX WARN: Code restructure failed: missing block: B:123:0x02c6, code lost:
            r11 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:124:0x02c7, code lost:
            r11.printStackTrace();
         */
        /* JADX WARN: Code restructure failed: missing block: B:125:0x02cc, code lost:
            if (r10 == false) goto L98;
         */
        /* JADX WARN: Code restructure failed: missing block: B:127:0x02d6, code lost:
            if (r26.bxt.createSurface() == false) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:128:0x02d8, code lost:
            r10 = r26.bxc;
         */
        /* JADX WARN: Code restructure failed: missing block: B:129:0x02dc, code lost:
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:131:0x02de, code lost:
            r26.bxo = true;
            r26.bxc.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:132:0x02e9, code lost:
            monitor-exit(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:133:0x02ea, code lost:
            r12 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:134:0x02ec, code lost:
            if (r9 == false) goto L97;
         */
        /* JADX WARN: Code restructure failed: missing block: B:135:0x02ee, code lost:
            r11 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:136:0x02f0, code lost:
            if (r8 == false) goto L96;
         */
        /* JADX WARN: Code restructure failed: missing block: B:137:0x02f2, code lost:
            r8 = r26.bxu;
         */
        /* JADX WARN: Code restructure failed: missing block: B:138:0x02f6, code lost:
            if (r8 == null) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:139:0x02f8, code lost:
            r8.bxa.onSurfaceCreated(null, null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:140:0x0301, code lost:
            r10 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:141:0x0303, code lost:
            if (r7 == false) goto L95;
         */
        /* JADX WARN: Code restructure failed: missing block: B:142:0x0305, code lost:
            r7 = r26.bxu;
         */
        /* JADX WARN: Code restructure failed: missing block: B:143:0x0309, code lost:
            if (r7 == null) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:144:0x030b, code lost:
            r7.bxa.onSurfaceChanged(null, r15, r14);
            r7.updateSurfaceViewSize(r15, r14);
         */
        /* JADX WARN: Code restructure failed: missing block: B:145:0x0318, code lost:
            r9 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:146:0x031a, code lost:
            r0 = r26.bxu;
            r18 = java.lang.System.currentTimeMillis();
            r20 = r18 - r26.bxi;
         */
        /* JADX WARN: Code restructure failed: missing block: B:147:0x0330, code lost:
            if (r0.bxb == false) goto L93;
         */
        /* JADX WARN: Code restructure failed: missing block: B:149:0x033b, code lost:
            if (((float) r20) < minFramesInterval()) goto L93;
         */
        /* JADX WARN: Code restructure failed: missing block: B:150:0x033d, code lost:
            r26.bxi = java.lang.System.currentTimeMillis();
         */
        /* JADX WARN: Code restructure failed: missing block: B:151:0x034b, code lost:
            if (r26.bxl != false) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:153:0x0351, code lost:
            if (r26.bxu == null) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:154:0x0353, code lost:
            r26.bxl = true;
            r26.bxu.gg("first_frame");
         */
        /* JADX WARN: Code restructure failed: missing block: B:155:0x0362, code lost:
            r0.bxa.onDrawFrame(null);
            NR();
         */
        /* JADX WARN: Code restructure failed: missing block: B:156:0x0379, code lost:
            if ((r18 - r26.bxk) <= 33) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:157:0x037b, code lost:
            r0.bwX.notifyFrameUpdated();
            r26.bxk = r18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:159:0x038c, code lost:
            if (r26.bxn == false) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:160:0x038e, code lost:
            r26.bxu.bwX.smallGameOnResume();
            r26.bxn = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:161:0x039e, code lost:
            r8 = r0.bwX.shouldSwapBuffer();
         */
        /* JADX WARN: Code restructure failed: missing block: B:162:0x03a6, code lost:
            if (r8 == false) goto L92;
         */
        /* JADX WARN: Code restructure failed: missing block: B:163:0x03a8, code lost:
            r7 = r26.bxt.swap();
         */
        /* JADX WARN: Code restructure failed: missing block: B:164:0x03b0, code lost:
            switch(r7) {
                case 12288: goto L90;
                case 12302: goto L91;
                default: goto L71;
            };
         */
        /* JADX WARN: Code restructure failed: missing block: B:165:0x03b3, code lost:
            com.baidu.smallgame.sdk.a.b.logEglErrorAsWarning("EngineLogger", "eglSwapBuffers", r7);
            r7 = r26.bxc;
         */
        /* JADX WARN: Code restructure failed: missing block: B:166:0x03c4, code lost:
            monitor-enter(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:168:0x03c7, code lost:
            r26.mSurfaceIsBad = true;
            r26.bxc.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:169:0x03d6, code lost:
            monitor-exit(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:170:0x03d7, code lost:
            r7 = r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:171:0x03d8, code lost:
            r26.bxj = java.lang.System.currentTimeMillis();
         */
        /* JADX WARN: Code restructure failed: missing block: B:172:0x03ee, code lost:
            if (r26.bxu.bwX.isRenderCallbackQueueEmpty() != false) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:173:0x03f0, code lost:
            if (r8 == false) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:174:0x03f2, code lost:
            r8 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:176:0x03fe, code lost:
            if ((r0.bwX.getStuckScreenHandler() instanceof com.baidu.smallgame.sdk.b) == false) goto L84;
         */
        /* JADX WARN: Code restructure failed: missing block: B:177:0x0400, code lost:
            ((com.baidu.smallgame.sdk.b) r0.bwX.getStuckScreenHandler()).b(r8, r26.bxj);
         */
        /* JADX WARN: Code restructure failed: missing block: B:178:0x0415, code lost:
            if (r6 == false) goto L88;
         */
        /* JADX WARN: Code restructure failed: missing block: B:179:0x0417, code lost:
            r4 = true;
            r5 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:180:0x0419, code lost:
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
        /* JADX WARN: Code restructure failed: missing block: B:184:0x042d, code lost:
            r11 = r26.bxc;
         */
        /* JADX WARN: Code restructure failed: missing block: B:185:0x0431, code lost:
            monitor-enter(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:187:0x0433, code lost:
            r26.bxo = true;
            r26.mSurfaceIsBad = true;
            r26.bxc.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:188:0x0443, code lost:
            monitor-exit(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:189:0x0444, code lost:
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
        /* JADX WARN: Code restructure failed: missing block: B:193:0x0458, code lost:
            r7 = r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:194:0x045b, code lost:
            r7 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:198:0x0462, code lost:
            r8 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:199:0x0465, code lost:
            r0.bxb = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:200:0x046b, code lost:
            r7 = r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:204:0x0470, code lost:
            r4 = r5;
            r5 = r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:205:0x0473, code lost:
            r7 = r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:206:0x0476, code lost:
            r9 = r7;
         */
        /* JADX WARN: Code restructure failed: missing block: B:207:0x0479, code lost:
            r10 = r8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:208:0x047c, code lost:
            r11 = r9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:209:0x047f, code lost:
            r12 = r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0080, code lost:
            if (r13 == null) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0086, code lost:
            if (r26.bxm != false) goto L106;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x008c, code lost:
            if (r26.bxu == null) goto L106;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x008e, code lost:
            r26.bxm = true;
            r26.bxu.gg("first_event");
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00a1, code lost:
            if (com.baidu.searchbox.v8engine.V8Engine.isDebug() == false) goto L111;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00a7, code lost:
            if (r26.bxu == null) goto L111;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00a9, code lost:
            r26.bxu.L(1, r13.toString());
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00b7, code lost:
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
            this.bxt = new b(this.bxu);
            this.mHaveEglContext = false;
            this.mHaveEglSurface = false;
            this.bxp = false;
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
                    synchronized (this.bxc) {
                        z = z19;
                        boolean z20 = z18;
                        boolean z21 = z16;
                        boolean z22 = z15;
                        boolean z23 = z14;
                        boolean z24 = z13;
                        runnable = runnable2;
                        while (!this.mShouldExit) {
                            if (this.bxr.isEmpty()) {
                                if (ableToDraw()) {
                                    if (NQ()) {
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
                                        runnable = NS();
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
                                        this.bxn = false;
                                        this.bxu.bwX.smallGameOnPauseOnGLThrad();
                                    } else {
                                        this.bxn = true;
                                    }
                                    this.bxc.notifyAll();
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
                                    this.bxc.notifyAll();
                                }
                                if (this.mHasSurface && this.mWaitingForSurface) {
                                    this.mWaitingForSurface = false;
                                    this.bxc.notifyAll();
                                }
                                if (z20) {
                                    this.bxp = false;
                                    z9 = false;
                                    this.mRenderComplete = true;
                                    this.bxc.notifyAll();
                                } else {
                                    z9 = z20;
                                }
                                if (readyToDraw()) {
                                    if (!this.mHaveEglContext) {
                                        if (z) {
                                            z = false;
                                        } else {
                                            try {
                                                this.bxt.start();
                                                this.bxu.bwX.setEglContextToRecorder(this.bxu.getEGLContext(), 0, 0);
                                                this.mHaveEglContext = true;
                                                z12 = true;
                                                this.bxc.notifyAll();
                                            } catch (RuntimeException e) {
                                                this.bxc.c(this);
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
                                            this.bxp = true;
                                            z11 = true;
                                            this.mSizeChanged = false;
                                        } else {
                                            z11 = z24;
                                        }
                                        this.mRequestRender = false;
                                        this.bxc.notifyAll();
                                        if (this.bxp) {
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
                                this.bxc.wait();
                                z20 = z9;
                            } else {
                                runnable = this.bxr.pollFirst();
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
                    synchronized (this.bxc) {
                        if (this.bxu != null) {
                            this.bxu.bwX.smallGameDestroy();
                        }
                        stopEglSurfaceLocked();
                        stopEglContextLocked();
                    }
                    return;
                } catch (Throwable th) {
                    synchronized (this.bxc) {
                        if (this.bxu != null) {
                            this.bxu.bwX.smallGameDestroy();
                        }
                        stopEglSurfaceLocked();
                        stopEglContextLocked();
                        throw th;
                    }
                }
            }
            if (V8Engine.isDebug() && this.bxu != null) {
                this.bxu.L(2, runnable.toString());
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

        private void NR() {
            this.bxg++;
            if (this.bxh != 0) {
                float currentTimeMillis = ((float) (System.currentTimeMillis() - this.bxh)) / 1000.0f;
                if (currentTimeMillis > 1.0f) {
                    this.bxu.dT((int) (this.bxg / currentTimeMillis));
                    this.bxg = 0;
                    this.bxh = System.currentTimeMillis();
                    return;
                }
                return;
            }
            this.bxh = System.currentTimeMillis();
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
            synchronized (this.bxc) {
                this.mRenderMode = i;
                this.bxc.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (this.bxc) {
                i = this.mRenderMode;
            }
            return i;
        }

        public void requestRender() {
            synchronized (this.bxc) {
                this.mRequestRender = true;
                this.bxc.notifyAll();
            }
        }

        public void requestRenderAndWait() {
            synchronized (this.bxc) {
                if (Thread.currentThread() != this) {
                    this.bxp = true;
                    this.mRequestRender = true;
                    this.mRenderComplete = false;
                    this.bxc.notifyAll();
                    while (!this.mExited && !this.mPaused && !this.mRenderComplete && ableToDraw()) {
                        try {
                            this.bxc.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void surfaceCreated() {
            synchronized (this.bxc) {
                this.mHasSurface = true;
                this.bxo = false;
                this.bxc.notifyAll();
                while (this.mWaitingForSurface && !this.bxo && !this.mExited) {
                    try {
                        this.bxc.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (this.bxc) {
                this.mHasSurface = false;
                this.bxc.notifyAll();
                while (!this.mWaitingForSurface && !this.mExited) {
                    try {
                        this.bxc.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (this.bxc) {
                Log.i("EngineLogger", "onPause tid=" + getId());
                this.mRequestPaused = true;
                if (this.bxu != null && (this.bxu.bwX.getStuckScreenHandler() instanceof com.baidu.smallgame.sdk.b)) {
                    ((com.baidu.smallgame.sdk.b) this.bxu.bwX.getStuckScreenHandler()).NW();
                }
                this.bxc.notifyAll();
                while (!this.mExited && !this.mPaused) {
                    Log.i("Main thread", "onPause waiting for mPaused.");
                    try {
                        this.bxc.wait(500L);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (this.bxc) {
                Log.i("EngineLogger", "onResume tid=" + getId());
                this.mRequestPaused = false;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                this.bxc.notifyAll();
                while (!this.mExited && this.mPaused && !this.mRenderComplete) {
                    Log.i("Main thread", "onResume waiting for !mPaused.");
                    try {
                        this.bxc.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onWindowResize(int i, int i2) {
            synchronized (this.bxc) {
                this.mWidth = i;
                this.mHeight = i2;
                this.mSizeChanged = true;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                if (Thread.currentThread() != this) {
                    this.bxc.notifyAll();
                    while (!this.mExited && !this.mPaused && !this.mRenderComplete && ableToDraw()) {
                        try {
                            this.bxc.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void requestExitAndWait() {
            synchronized (this.bxc) {
                this.mShouldExit = true;
                this.bxc.notifyAll();
                while (!this.mExited) {
                    try {
                        this.bxc.wait();
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
                synchronized (this.bxc) {
                    if (V8Engine.isDebug() && this.bxu != null) {
                        this.bxu.L(0, runnable.toString());
                    }
                    if (z || ableToDraw()) {
                        this.bxq.add(runnable);
                    } else {
                        this.bxr.add(runnable);
                    }
                    this.bxc.notifyAll();
                }
            }
        }

        public void b(Runnable runnable, long j) {
            if (runnable == null) {
                throw new IllegalArgumentException("r must not be null");
            }
            if (!this.mShouldExit && !this.mExited) {
                synchronized (this.bxc) {
                    TreeSet<d> treeSet = this.bxs;
                    if (j <= 0) {
                        j = 0;
                    }
                    treeSet.add(new d(runnable, j));
                    this.bxc.notifyAll();
                }
            }
        }

        public void clearOldEvents() {
            synchronized (this.bxc) {
                this.bxq.clear();
                this.bxr.clear();
                this.bxs.clear();
            }
        }

        private Runnable NS() {
            Runnable pollFirst;
            synchronized (this.bxc) {
                pollFirst = (this.bxs.isEmpty() || !this.bxs.first().isTimeout()) ? this.bxq.pollFirst() : this.bxs.pollFirst();
            }
            return pollFirst;
        }
    }

    /* loaded from: classes11.dex */
    public static class d implements Comparable<d>, Runnable {
        private final Runnable bxz;
        private final long mTimestamp;

        d(Runnable runnable, long j) {
            this.bxz = runnable;
            this.mTimestamp = System.currentTimeMillis() + j;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.bxz.run();
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
    /* loaded from: classes11.dex */
    public static class c {
        private static String TAG = "GLThreadManager";
        private C0220a bxy;

        private c() {
        }

        public synchronized void b(C0220a c0220a) {
            c0220a.mExited = true;
            if (this.bxy == c0220a) {
                this.bxy = null;
            }
            notifyAll();
        }

        public void c(C0220a c0220a) {
            if (this.bxy == c0220a) {
                this.bxy = null;
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class b {
        private a bxu;
        EGLDisplay bxv;
        EGLSurface bxw;
        EGLConfig bxx;
        EGLContext mEglContext;

        public b(a aVar) {
            this.bxu = aVar;
        }

        public void reset() {
            this.bxu = null;
        }

        public void start() {
            this.bxv = EGL14.eglGetDisplay(0);
            if (this.bxv == EGL14.EGL_NO_DISPLAY) {
                throw new RuntimeException("unable to get EGL14 display");
            }
            int[] iArr = new int[2];
            if (!EGL14.eglInitialize(this.bxv, iArr, 0, iArr, 1)) {
                this.bxv = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            a aVar = this.bxu;
            this.bxx = g(0, 0, false);
            this.mEglContext = EGL14.eglCreateContext(this.bxv, this.bxx, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
            this.bxu.mCurrentGLThreadID = Thread.currentThread().getId();
            if (this.mEglContext == null || this.mEglContext == EGL14.EGL_NO_CONTEXT) {
                this.mEglContext = null;
                throwEglException("createContext");
            }
            this.bxw = null;
        }

        private EGLConfig g(int i, int i2, boolean z) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (EGL14.eglChooseConfig(this.bxv, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, z ? 16 : 0, 12326, 0, 12352, 4, 12344, 0, 12344}, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
                return eGLConfigArr[0];
            }
            Log.w("EngineLogger", "unable to find RGB8888 / " + i2 + " EGLConfig");
            return null;
        }

        public boolean createSurface() {
            if (this.bxv == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.bxx == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            destroySurface();
            Object obj = this.bxu.mSurfaceHolder;
            if (obj == null) {
                obj = this.bxu.bxd;
            }
            if (obj != null) {
                this.bxw = EGL14.eglCreateWindowSurface(this.bxv, this.bxx, obj, new int[]{12344}, 0);
            } else {
                this.bxw = null;
            }
            if (this.bxw == null || this.bxw == EGL14.EGL_NO_SURFACE) {
                if (EGL14.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    return false;
                }
                return false;
            }
            return EGL14.eglMakeCurrent(this.bxv, this.bxw, this.bxw, this.mEglContext);
        }

        public int swap() {
            return !EGL14.eglSwapBuffers(this.bxv, this.bxw) ? EGL14.eglGetError() : CommandMessage.COMMAND_BASE;
        }

        public void destroySurface() {
            if (this.bxw != null && this.bxw != EGL14.EGL_NO_SURFACE) {
                EGL14.eglMakeCurrent(this.bxv, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
                EGL14.eglDestroySurface(this.bxv, this.bxw);
                this.bxw = null;
            }
        }

        public void finish() {
            if (this.mEglContext != null) {
                EGL14.eglDestroyContext(this.bxv, this.mEglContext);
                this.mEglContext = null;
            }
            if (this.bxv != null) {
                EGL14.eglTerminate(this.bxv);
                this.bxv = null;
            }
            this.bxu.mCurrentGLThreadID = -1L;
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
}
