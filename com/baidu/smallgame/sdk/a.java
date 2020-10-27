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
    public static PermissionProxy cme = null;
    public static int cmf = 0;
    private ArBridge cmg;
    private GLSurfaceView.Renderer cmj;
    private Object cmm;
    private C0344a cmn;
    private Context mContext;
    private boolean mDetached;
    private SurfaceHolder mSurfaceHolder;
    private ArrayList<DebugConsole> mConsoles = null;
    private int mFPS = 0;
    private long mCurrentGLThreadID = -1;
    private float cmh = 0.0f;
    private float cmi = 0.0f;
    private boolean cmk = false;
    private final c cml = new c();

    public Context getContext() {
        return this.mContext;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        Log.setMinLogLevel(6, false);
        this.cmg = new ArBridge();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void startEngine() {
        if (this.cmj == null) {
            throw new NullPointerException("start render engine failed. because renderer is not set");
        }
        this.cmn = new C0344a(this);
        this.cmn.start();
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
    public void aa(int i, String str) {
        if (this.mConsoles != null) {
            for (DebugConsole debugConsole : new ArrayList(this.mConsoles)) {
                debugConsole.onReceiveInfo(i, str);
            }
        }
    }

    public ArBridge acG() {
        return this.cmg;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public Thread getGLThread() {
        return this.cmn;
    }

    void hb(int i) {
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
        this.cmh = f;
        this.cmi = f2;
        this.cmg.setSize(f, f2);
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
        if (this.cmh != 0.0f) {
            f = this.cmh;
        }
        if (this.cmi != 0.0f) {
            f2 = this.cmi;
        }
        if (this.cmg != null) {
            this.cmg.setDisplayMetrics(f, f2, displayMetrics.xdpi, displayMetrics.ydpi, displayMetrics.density);
        } else {
            Log.e("EngineLogger", "[RenderError] error init render display, because arbridge is null");
        }
    }

    public void c(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = (SurfaceHolder) new WeakReference(surfaceHolder).get();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderer(GLSurfaceView.Renderer renderer) {
        this.cmj = renderer;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderMode(int i) {
        if (this.cmn != null) {
            this.cmn.setRenderMode(i);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public int getRenderMode() {
        if (this.cmn != null) {
            return this.cmn.getRenderMode();
        }
        return 1;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRender() {
        if (this.cmn != null) {
            this.cmn.requestRender();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceCreated() {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceCreated.");
        this.cmn.surfaceCreated();
        Context appContext = V8Engine.getAppContext();
        if (appContext != null) {
            cmf = ((WindowManager) appContext.getSystemService("window")).getDefaultDisplay().getRotation();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceDestroyed() {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceDestroyed.");
        this.cmn.surfaceDestroyed();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceChanged(int i, int i2) {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceChanged. width=" + i + ", height=" + i2);
        this.cmn.onWindowResize(i, i2);
        this.cmg.setEglContextToRecorder(getEGLContext(), i, i2);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRenderAndWait() {
        if (this.cmn != null) {
            this.cmn.requestRenderAndWait();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameOnPause() {
        this.cmg.smallGameOnPause();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void runOnGLThread(Runnable runnable) {
        if (this.cmn != null) {
            this.cmn.runOnGLThread(runnable);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable) {
        if (this.cmn != null) {
            this.cmn.queueEvent(runnable);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable, long j) {
        if (this.cmn != null) {
            this.cmn.b(runnable, j);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onAttachedToWindow() {
        if (this.mDetached && this.cmj != null) {
            int renderMode = this.cmn != null ? this.cmn.getRenderMode() : 1;
            this.cmn = new C0344a(this);
            if (renderMode != 1) {
                this.cmn.setRenderMode(renderMode);
            }
            this.cmn.start();
        }
        this.mDetached = false;
        Log.w("EngineLogger", "[V8Dispose][AREngine] onAttachedToWindow");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onDetachedFromWindow() {
        if (!this.mDetached && this.cmn != null) {
            this.cmn.requestExitAndWait();
        }
        this.mDetached = true;
        Log.w("EngineLogger", "[V8Dispose][AREngine] onDetachedFromWindow");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void clearOldEvents() {
        if (this.cmn != null) {
            this.cmn.clearOldEvents();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onPause() {
        if (this.cmn != null) {
            this.cmn.onPause();
        }
        if (this.cmg.getGameRecorder() != null) {
            this.cmg.getGameRecorder().WC();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onResume() {
        if (this.cmn != null) {
            this.cmn.onResume();
        }
        if (this.cmg.getGameRecorder() != null) {
            this.cmg.getGameRecorder().WD();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void pauseRecord() {
        if (this.cmg.getGameRecorder() != null) {
            this.cmg.getGameRecorder().pauseRecord();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void resumeRecord() {
        if (this.cmg.getGameRecorder() != null) {
            this.cmg.getGameRecorder().resumeRecord();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void stopRecord() {
        if (this.cmg.getGameRecorder() != null) {
            this.cmg.getGameRecorder().stopRecord();
            this.cmg.nativeUpdateRecordingStatus(false);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (this.cmg.getGameRecorder() != null) {
            this.cmg.nativeUpdateRecordingStatus(true);
            this.cmg.getGameRecorder().startRecord(z, i, str, z2);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setGameRecordCallback(com.baidu.mario.a.c cVar) {
        if (this.cmg.getGameRecorder() != null) {
            this.cmg.getGameRecorder().setGameRecordCallback(cVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setAudioEngineProxy(com.baidu.mario.a.a aVar) {
        if (this.cmg.getGameRecorder() != null) {
            this.cmg.getGameRecorder().setAudioEngineProxy(aVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public long getCurrentRecordProcess() {
        if (this.cmg.getGameRecorder() != null) {
            return this.cmg.getGameRecorder().WB();
        }
        return 0L;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setPermissionProxy(PermissionProxy permissionProxy) {
        cme = permissionProxy;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setOnStuckScreenListener(com.baidu.smallgame.sdk.b.a aVar) {
        if (this.cmg != null) {
            this.cmg.setOnStuckScreenListener(aVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setStuckScreenLimitTime(long j) {
        if (this.cmg != null) {
            this.cmg.setStuckScreenLimitTime(j);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public com.baidu.smallgame.sdk.b.c getStuckScreenHandler() {
        if (this.cmg == null) {
            return null;
        }
        return this.cmg.getStuckScreenHandler();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameDestroy() {
        if (this.cmn == null) {
            Log.e("EngineLogger", "Destroy AREngine fail. Because GLThread is null");
        } else {
            this.cmn.runOnGLThread(new Runnable() { // from class: com.baidu.smallgame.sdk.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.cmn.mShouldExit = true;
                    a.this.cmg.smallGameDestroy();
                }
            });
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public boolean ableToDraw() {
        return this.cmn != null && this.cmn.ableToDraw();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void exitGLThread() {
        if (this.cmn != null) {
            this.cmn.requestExitAndWait();
        }
        Log.e("EngineLogger", "[V8Dispose][AREngine] exitGLThread.");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameUpdate() {
        this.cmg.smallGameUpdate();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setScreenShotStatus(boolean z) {
        this.cmg.setScreenShotStatus(z);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public JSONArray getPerformanceJson() {
        return this.cmg == null ? new JSONArray() : this.cmg.getPerformanceJson();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public PerformanceJsonBean getPerformanceJsonBean() {
        return this.cmg == null ? new PerformanceJsonBean() : this.cmg.getPerformanceJsonBean();
    }

    public void jR(String str) {
        if (this.cmg != null) {
            this.cmg.getPerformanceJsonBean().put(str);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setFirstFrameListener(ArBridge.FirstFrameListener firstFrameListener) {
        this.cmg.setFirstFrameListener(firstFrameListener);
    }

    public EGLContext getEGLContext() {
        if (this.cmn == null || this.cmn.cmC == null) {
            return null;
        }
        return this.cmn.cmC.mEglContext;
    }

    protected void finalize() throws Throwable {
        try {
            if (this.cmn != null) {
                this.cmn.requestExitAndWait();
            }
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.smallgame.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0344a extends Thread {
        private b cmC;
        private a cmD;
        private c cml;
        private boolean cmx;
        private boolean mHasSurface;
        private boolean mHaveEglContext;
        private boolean mHaveEglSurface;
        private boolean mPaused;
        private boolean mRenderComplete;
        private boolean mRequestPaused;
        private boolean mShouldReleaseEglContext;
        private boolean mSurfaceIsBad;
        private boolean mWaitingForSurface;
        private int cmp = 0;
        private long cmq = 0;
        private long cmr = 0;
        private long cms = 0;
        private long cmt = 0;
        private boolean cmu = false;
        private boolean cmv = false;
        private boolean cmw = false;
        private volatile boolean mShouldExit = false;
        private volatile boolean mExited = false;
        private LinkedList<Runnable> cmz = new LinkedList<>();
        private LinkedList<Runnable> cmA = new LinkedList<>();
        private TreeSet<d> cmB = new TreeSet<>();
        private boolean mSizeChanged = true;
        private V8Engine mV8Engine = null;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean mRequestRender = true;
        private int mRenderMode = 1;
        private boolean cmy = false;

        C0344a(a aVar) {
            this.cmD = aVar;
            this.cml = aVar.cml;
        }

        /* JADX WARN: Type inference failed for: r4v0, types: [com.baidu.smallgame.sdk.a, com.baidu.searchbox.v8engine.V8Engine, com.baidu.smallgame.sdk.a$b] */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("ARGLThread " + getId());
            if (this.cmD != null) {
                ArBridge acG = this.cmD.acG();
                if (acG != null) {
                    acG.setGLThreadID(getId());
                    acG.smallGameOnInit();
                    this.cmD.initDisplayMetrics();
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
                this.cml.b(this);
                this.cmC.reset();
                this.cmC = null;
                this.cmD = null;
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
                this.cmC.destroySurface();
            }
        }

        private void stopEglContextLocked() {
            if (this.mHaveEglContext) {
                this.cmC.finish();
                this.mHaveEglContext = false;
                this.cml.c(this);
            }
        }

        public boolean acH() {
            return this.cmD.cmg.mFirstFrameFinished && ((float) (System.currentTimeMillis() - this.cms)) > minFramesInterval();
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
            if (r26.cmC.createSurface() == false) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:138:0x0302, code lost:
            r10 = r26.cml;
         */
        /* JADX WARN: Code restructure failed: missing block: B:139:0x0306, code lost:
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:141:0x0308, code lost:
            r26.cmx = true;
            r26.cml.notifyAll();
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
            r8 = r26.cmD;
         */
        /* JADX WARN: Code restructure failed: missing block: B:148:0x0320, code lost:
            if (r8 == null) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:149:0x0322, code lost:
            r8.cmj.onSurfaceCreated(null, null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:150:0x032b, code lost:
            r10 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:151:0x032d, code lost:
            if (r7 == false) goto L95;
         */
        /* JADX WARN: Code restructure failed: missing block: B:152:0x032f, code lost:
            r7 = r26.cmD;
         */
        /* JADX WARN: Code restructure failed: missing block: B:153:0x0333, code lost:
            if (r7 == null) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:154:0x0335, code lost:
            r7.cmj.onSurfaceChanged(null, r15, r14);
            r7.updateSurfaceViewSize(r15, r14);
         */
        /* JADX WARN: Code restructure failed: missing block: B:155:0x0342, code lost:
            r9 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:156:0x0344, code lost:
            r0 = r26.cmD;
            r18 = java.lang.System.currentTimeMillis();
            r20 = r18 - r26.cmr;
         */
        /* JADX WARN: Code restructure failed: missing block: B:157:0x035a, code lost:
            if (r0.cmk == false) goto L93;
         */
        /* JADX WARN: Code restructure failed: missing block: B:159:0x0365, code lost:
            if (((float) r20) < minFramesInterval()) goto L93;
         */
        /* JADX WARN: Code restructure failed: missing block: B:160:0x0367, code lost:
            r26.cmr = java.lang.System.currentTimeMillis();
         */
        /* JADX WARN: Code restructure failed: missing block: B:161:0x0375, code lost:
            if (r26.cmu != false) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:163:0x037b, code lost:
            if (r26.cmD == null) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:164:0x037d, code lost:
            r26.cmu = true;
            r26.cmD.jR("first_frame");
         */
        /* JADX WARN: Code restructure failed: missing block: B:165:0x038c, code lost:
            r0.cmj.onDrawFrame(null);
            acI();
         */
        /* JADX WARN: Code restructure failed: missing block: B:166:0x03a3, code lost:
            if ((r18 - r26.cmt) <= 33) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:167:0x03a5, code lost:
            r0.cmg.notifyFrameUpdated();
            r26.cmt = r18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:169:0x03b6, code lost:
            if (r26.cmw == false) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:170:0x03b8, code lost:
            r26.cmD.cmg.smallGameOnResume();
            r26.cmw = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:171:0x03c8, code lost:
            r8 = r0.cmg.shouldSwapBuffer();
         */
        /* JADX WARN: Code restructure failed: missing block: B:172:0x03d0, code lost:
            if (r8 == false) goto L92;
         */
        /* JADX WARN: Code restructure failed: missing block: B:173:0x03d2, code lost:
            r7 = r26.cmC.swap();
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
            r7 = r26.cml;
         */
        /* JADX WARN: Code restructure failed: missing block: B:176:0x03ee, code lost:
            monitor-enter(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:178:0x03f1, code lost:
            r26.mSurfaceIsBad = true;
            r26.cml.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:179:0x0400, code lost:
            monitor-exit(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:180:0x0401, code lost:
            r7 = r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:181:0x0402, code lost:
            r26.cms = java.lang.System.currentTimeMillis();
         */
        /* JADX WARN: Code restructure failed: missing block: B:182:0x0418, code lost:
            if (r26.cmD.cmg.isRenderCallbackQueueEmpty() != false) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:183:0x041a, code lost:
            if (r8 == false) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:184:0x041c, code lost:
            r8 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:186:0x0428, code lost:
            if ((r0.cmg.getStuckScreenHandler() instanceof com.baidu.smallgame.sdk.b) == false) goto L84;
         */
        /* JADX WARN: Code restructure failed: missing block: B:187:0x042a, code lost:
            ((com.baidu.smallgame.sdk.b) r0.cmg.getStuckScreenHandler()).e(r8, r26.cms);
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
            r11 = r26.cml;
         */
        /* JADX WARN: Code restructure failed: missing block: B:195:0x045b, code lost:
            monitor-enter(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:197:0x045d, code lost:
            r26.cmx = true;
            r26.mSurfaceIsBad = true;
            r26.cml.notifyAll();
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
            r0.cmk = true;
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
            if (r26.cmv != false) goto L106;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00a1, code lost:
            if (r26.cmD == null) goto L106;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00a3, code lost:
            r26.cmv = true;
            r26.cmD.jR("first_event");
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00b6, code lost:
            if (com.baidu.searchbox.v8engine.V8Engine.isDebug() == false) goto L111;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00bc, code lost:
            if (r26.cmD == null) goto L111;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00be, code lost:
            r26.cmD.aa(1, r13.toString());
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
            this.cmC = new b(this.cmD);
            this.mHaveEglContext = false;
            this.mHaveEglSurface = false;
            this.cmy = false;
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
                    synchronized (this.cml) {
                        z = z19;
                        boolean z20 = z18;
                        boolean z21 = z16;
                        boolean z22 = z15;
                        boolean z23 = z14;
                        boolean z24 = z13;
                        runnable = runnable2;
                        while (!this.mShouldExit) {
                            if (this.cmA.isEmpty()) {
                                if (ableToDraw()) {
                                    if (acH()) {
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
                                        runnable = acJ();
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
                                        this.cmw = false;
                                        this.cmD.cmg.smallGameOnPauseOnGLThrad();
                                    } else {
                                        this.cmw = true;
                                    }
                                    this.cml.notifyAll();
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
                                    this.cml.notifyAll();
                                }
                                if (this.mHasSurface && this.mWaitingForSurface) {
                                    this.mWaitingForSurface = false;
                                    this.cml.notifyAll();
                                }
                                if (z20) {
                                    this.cmy = false;
                                    z9 = false;
                                    this.mRenderComplete = true;
                                    this.cml.notifyAll();
                                } else {
                                    z9 = z20;
                                }
                                if (readyToDraw()) {
                                    if (!this.mHaveEglContext) {
                                        if (z) {
                                            z = false;
                                        } else {
                                            try {
                                                this.cmC.start();
                                                this.cmD.cmg.setEglContextToRecorder(this.cmD.getEGLContext(), 0, 0);
                                                this.mHaveEglContext = true;
                                                z12 = true;
                                                this.cml.notifyAll();
                                            } catch (RuntimeException e) {
                                                this.cml.c(this);
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
                                            this.cmy = true;
                                            z11 = true;
                                            this.mSizeChanged = false;
                                        } else {
                                            z11 = z24;
                                        }
                                        this.mRequestRender = false;
                                        this.cml.notifyAll();
                                        if (this.cmy) {
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
                                this.cml.wait();
                                z20 = z9;
                            } else {
                                runnable = this.cmA.pollFirst();
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
                    synchronized (this.cml) {
                        if (this.cmD != null) {
                            this.cmD.cmg.smallGameDestroy();
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
                    synchronized (this.cml) {
                        if (this.cmD != null) {
                            this.cmD.cmg.smallGameDestroy();
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
            if (V8Engine.isDebug() && this.cmD != null) {
                this.cmD.aa(2, runnable.toString());
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

        private void acI() {
            this.cmp++;
            if (this.cmq != 0) {
                float currentTimeMillis = ((float) (System.currentTimeMillis() - this.cmq)) / 1000.0f;
                if (currentTimeMillis > 1.0f) {
                    this.cmD.hb((int) (this.cmp / currentTimeMillis));
                    this.cmp = 0;
                    this.cmq = System.currentTimeMillis();
                    return;
                }
                return;
            }
            this.cmq = System.currentTimeMillis();
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
            synchronized (this.cml) {
                this.mRenderMode = i;
                this.cml.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (this.cml) {
                i = this.mRenderMode;
            }
            return i;
        }

        public void requestRender() {
            synchronized (this.cml) {
                this.mRequestRender = true;
                this.cml.notifyAll();
            }
        }

        public void requestRenderAndWait() {
            synchronized (this.cml) {
                if (Thread.currentThread() != this) {
                    this.cmy = true;
                    this.mRequestRender = true;
                    this.mRenderComplete = false;
                    this.cml.notifyAll();
                    while (!this.mExited && !this.mPaused && !this.mRenderComplete && ableToDraw()) {
                        try {
                            this.cml.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void surfaceCreated() {
            synchronized (this.cml) {
                this.mHasSurface = true;
                this.cmx = false;
                this.cml.notifyAll();
                while (this.mWaitingForSurface && !this.cmx && !this.mExited) {
                    try {
                        this.cml.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (this.cml) {
                this.mHasSurface = false;
                this.cml.notifyAll();
                while (!this.mWaitingForSurface && !this.mExited) {
                    try {
                        this.cml.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (this.cml) {
                Log.i("EngineLogger", "onPause tid=" + getId());
                this.mRequestPaused = true;
                if (this.cmD != null && (this.cmD.cmg.getStuckScreenHandler() instanceof com.baidu.smallgame.sdk.b)) {
                    ((com.baidu.smallgame.sdk.b) this.cmD.cmg.getStuckScreenHandler()).acN();
                }
                this.cml.notifyAll();
                while (!this.mExited && !this.mPaused) {
                    Log.i("Main thread", "onPause waiting for mPaused.");
                    try {
                        this.cml.wait(500L);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (this.cml) {
                Log.i("EngineLogger", "onResume tid=" + getId());
                this.mRequestPaused = false;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                this.cml.notifyAll();
                while (!this.mExited && this.mPaused && !this.mRenderComplete) {
                    Log.i("Main thread", "onResume waiting for !mPaused.");
                    try {
                        this.cml.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onWindowResize(int i, int i2) {
            synchronized (this.cml) {
                this.mWidth = i;
                this.mHeight = i2;
                this.mSizeChanged = true;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                if (Thread.currentThread() != this) {
                    this.cml.notifyAll();
                    while (!this.mExited && !this.mPaused && !this.mRenderComplete && ableToDraw()) {
                        try {
                            this.cml.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void requestExitAndWait() {
            synchronized (this.cml) {
                this.mShouldExit = true;
                this.cml.notifyAll();
                while (!this.mExited) {
                    try {
                        this.cml.wait();
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
                synchronized (this.cml) {
                    if (V8Engine.isDebug() && this.cmD != null) {
                        this.cmD.aa(0, runnable.toString());
                    }
                    if (z || ableToDraw()) {
                        this.cmz.add(runnable);
                    } else {
                        this.cmA.add(runnable);
                    }
                    this.cml.notifyAll();
                }
            }
        }

        public void b(Runnable runnable, long j) {
            if (runnable == null) {
                throw new IllegalArgumentException("r must not be null");
            }
            if (!this.mShouldExit && !this.mExited) {
                synchronized (this.cml) {
                    TreeSet<d> treeSet = this.cmB;
                    if (j <= 0) {
                        j = 0;
                    }
                    treeSet.add(new d(runnable, j));
                    this.cml.notifyAll();
                }
            }
        }

        public void clearOldEvents() {
            synchronized (this.cml) {
                this.cmz.clear();
                this.cmA.clear();
                this.cmB.clear();
            }
        }

        private Runnable acJ() {
            Runnable pollFirst;
            synchronized (this.cml) {
                pollFirst = (this.cmB.isEmpty() || !this.cmB.first().isTimeout()) ? this.cmz.pollFirst() : this.cmB.pollFirst();
            }
            return pollFirst;
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements Comparable<d>, Runnable {
        private final Runnable cmI;
        private final long mTimestamp;

        d(Runnable runnable, long j) {
            this.cmI = runnable;
            this.mTimestamp = System.currentTimeMillis() + j;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.cmI.run();
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
        private C0344a cmH;

        private c() {
        }

        public synchronized void b(C0344a c0344a) {
            c0344a.mExited = true;
            if (this.cmH == c0344a) {
                this.cmH = null;
            }
            notifyAll();
        }

        public void c(C0344a c0344a) {
            if (this.cmH == c0344a) {
                this.cmH = null;
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b {
        private a cmD;
        EGLDisplay cmE;
        EGLSurface cmF;
        EGLConfig cmG;
        EGLContext mEglContext;

        public b(a aVar) {
            this.cmD = aVar;
        }

        public void reset() {
            this.cmD = null;
        }

        public void start() {
            this.cmE = EGL14.eglGetDisplay(0);
            if (this.cmE == EGL14.EGL_NO_DISPLAY) {
                throw new RuntimeException("unable to get EGL14 display");
            }
            int[] iArr = new int[2];
            if (!EGL14.eglInitialize(this.cmE, iArr, 0, iArr, 1)) {
                this.cmE = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            a aVar = this.cmD;
            this.cmG = h(0, 0, false);
            this.mEglContext = EGL14.eglCreateContext(this.cmE, this.cmG, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
            this.cmD.mCurrentGLThreadID = Thread.currentThread().getId();
            if (this.mEglContext == null || this.mEglContext == EGL14.EGL_NO_CONTEXT) {
                this.mEglContext = null;
                throwEglException("createContext");
            }
            this.cmF = null;
        }

        private EGLConfig h(int i, int i2, boolean z) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (EGL14.eglChooseConfig(this.cmE, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, z ? 16 : 0, 12326, 0, 12352, 4, 12344, 0, 12344}, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
                return eGLConfigArr[0];
            }
            Log.w("EngineLogger", "unable to find RGB8888 / " + i2 + " EGLConfig");
            return null;
        }

        public boolean createSurface() {
            if (this.cmE == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.cmG == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            destroySurface();
            Object obj = this.cmD.mSurfaceHolder;
            if (obj == null) {
                obj = this.cmD.cmm;
            }
            if (obj != null) {
                this.cmF = EGL14.eglCreateWindowSurface(this.cmE, this.cmG, obj, new int[]{12344}, 0);
            } else {
                this.cmF = null;
            }
            if (this.cmF == null || this.cmF == EGL14.EGL_NO_SURFACE) {
                if (EGL14.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    return false;
                }
                return false;
            }
            return EGL14.eglMakeCurrent(this.cmE, this.cmF, this.cmF, this.mEglContext);
        }

        public int swap() {
            return !EGL14.eglSwapBuffers(this.cmE, this.cmF) ? EGL14.eglGetError() : CommandMessage.COMMAND_BASE;
        }

        public void destroySurface() {
            if (this.cmF != null && this.cmF != EGL14.EGL_NO_SURFACE) {
                EGL14.eglMakeCurrent(this.cmE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
                EGL14.eglDestroySurface(this.cmE, this.cmF);
                this.cmF = null;
            }
        }

        public void finish() {
            if (this.mEglContext != null) {
                EGL14.eglDestroyContext(this.cmE, this.mEglContext);
                this.mEglContext = null;
            }
            if (this.cmE != null) {
                EGL14.eglTerminate(this.cmE);
                this.cmE = null;
            }
            this.cmD.mCurrentGLThreadID = -1L;
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
        return this.cmg.isDestroyed();
    }
}
