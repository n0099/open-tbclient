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
    public static PermissionProxy aYv = null;
    public static int aYw = 0;
    private GLSurfaceView.Renderer aYA;
    private Object aYD;
    private C0190a aYE;
    private ArBridge aYx;
    private Context mContext;
    private boolean mDetached;
    private SurfaceHolder mSurfaceHolder;
    private ArrayList<DebugConsole> mConsoles = null;
    private int mFPS = 0;
    private long mCurrentGLThreadID = -1;
    private float aYy = 0.0f;
    private float aYz = 0.0f;
    private boolean aYB = false;
    private final c aYC = new c();

    public Context getContext() {
        return this.mContext;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        Log.setMinLogLevel(6, false);
        this.aYx = new ArBridge();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void startEngine() {
        if (this.aYA == null) {
            throw new NullPointerException("start render engine failed. because renderer is not set");
        }
        this.aYE = new C0190a(this);
        this.aYE.start();
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
    public void u(int i, String str) {
        if (this.mConsoles != null) {
            for (DebugConsole debugConsole : new ArrayList(this.mConsoles)) {
                debugConsole.onReceiveInfo(i, str);
            }
        }
    }

    public ArBridge Gc() {
        return this.aYx;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public Thread getGLThread() {
        return this.aYE;
    }

    void dK(int i) {
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
        this.aYy = f;
        this.aYz = f2;
        this.aYx.setSize(f, f2);
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
        if (this.aYy != 0.0f) {
            f = this.aYy;
        }
        if (this.aYz != 0.0f) {
            f2 = this.aYz;
        }
        if (this.aYx != null) {
            this.aYx.setDisplayMetrics(f, f2, displayMetrics.xdpi, displayMetrics.ydpi, displayMetrics.density);
        } else {
            Log.e("EngineLogger", "[RenderError] error init render display, because arbridge is null");
        }
    }

    public void c(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = (SurfaceHolder) new WeakReference(surfaceHolder).get();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderer(GLSurfaceView.Renderer renderer) {
        this.aYA = renderer;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderMode(int i) {
        if (this.aYE != null) {
            this.aYE.setRenderMode(i);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public int getRenderMode() {
        if (this.aYE != null) {
            return this.aYE.getRenderMode();
        }
        return 1;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRender() {
        if (this.aYE != null) {
            this.aYE.requestRender();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceCreated() {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceCreated.");
        this.aYE.surfaceCreated();
        Context appContext = V8Engine.getAppContext();
        if (appContext != null) {
            aYw = ((WindowManager) appContext.getSystemService("window")).getDefaultDisplay().getRotation();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceDestroyed() {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceDestroyed.");
        this.aYE.surfaceDestroyed();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceChanged(int i, int i2) {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceChanged. width=" + i + ", height=" + i2);
        this.aYE.onWindowResize(i, i2);
        this.aYx.setEglContextToRecorder(getEGLContext(), i, i2);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRenderAndWait() {
        if (this.aYE != null) {
            this.aYE.requestRenderAndWait();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameOnPause() {
        this.aYx.smallGameOnPause();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void runOnGLThread(Runnable runnable) {
        if (this.aYE != null) {
            this.aYE.runOnGLThread(runnable);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable) {
        if (this.aYE != null) {
            this.aYE.queueEvent(runnable);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable, long j) {
        if (this.aYE != null) {
            this.aYE.a(runnable, j);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onAttachedToWindow() {
        if (this.mDetached && this.aYA != null) {
            int renderMode = this.aYE != null ? this.aYE.getRenderMode() : 1;
            this.aYE = new C0190a(this);
            if (renderMode != 1) {
                this.aYE.setRenderMode(renderMode);
            }
            this.aYE.start();
        }
        this.mDetached = false;
        Log.w("EngineLogger", "[V8Dispose][AREngine] onAttachedToWindow");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onDetachedFromWindow() {
        if (!this.mDetached && this.aYE != null) {
            this.aYE.requestExitAndWait();
        }
        this.mDetached = true;
        Log.w("EngineLogger", "[V8Dispose][AREngine] onDetachedFromWindow");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void clearOldEvents() {
        if (this.aYE != null) {
            this.aYE.clearOldEvents();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onPause() {
        if (this.aYE != null) {
            this.aYE.onPause();
        }
        if (this.aYx.getGameRecorder() != null) {
            this.aYx.getGameRecorder().CM();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onResume() {
        if (this.aYE != null) {
            this.aYE.onResume();
        }
        if (this.aYx.getGameRecorder() != null) {
            this.aYx.getGameRecorder().CN();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void pauseRecord() {
        if (this.aYx.getGameRecorder() != null) {
            this.aYx.getGameRecorder().pauseRecord();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void resumeRecord() {
        if (this.aYx.getGameRecorder() != null) {
            this.aYx.getGameRecorder().resumeRecord();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void stopRecord() {
        if (this.aYx.getGameRecorder() != null) {
            this.aYx.getGameRecorder().stopRecord();
            this.aYx.nativeUpdateRecordingStatus(false);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (this.aYx.getGameRecorder() != null) {
            this.aYx.nativeUpdateRecordingStatus(true);
            this.aYx.getGameRecorder().startRecord(z, i, str, z2);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setGameRecordCallback(com.baidu.mario.a.c cVar) {
        if (this.aYx.getGameRecorder() != null) {
            this.aYx.getGameRecorder().setGameRecordCallback(cVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setAudioEngineProxy(com.baidu.mario.a.a aVar) {
        if (this.aYx.getGameRecorder() != null) {
            this.aYx.getGameRecorder().setAudioEngineProxy(aVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public long getCurrentRecordProcess() {
        if (this.aYx.getGameRecorder() != null) {
            return this.aYx.getGameRecorder().CL();
        }
        return 0L;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setPermissionProxy(PermissionProxy permissionProxy) {
        aYv = permissionProxy;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setOnStuckScreenListener(com.baidu.smallgame.sdk.b.a aVar) {
        if (this.aYx != null) {
            this.aYx.setOnStuckScreenListener(aVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setStuckScreenLimitTime(long j) {
        if (this.aYx != null) {
            this.aYx.setStuckScreenLimitTime(j);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public com.baidu.smallgame.sdk.b.c getStuckScreenHandler() {
        if (this.aYx == null) {
            return null;
        }
        return this.aYx.getStuckScreenHandler();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameDestroy() {
        if (this.aYE == null) {
            Log.e("EngineLogger", "Destroy AREngine fail. Because GLThread is null");
        } else {
            this.aYE.runOnGLThread(new Runnable() { // from class: com.baidu.smallgame.sdk.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.aYE.mShouldExit = true;
                    a.this.aYx.smallGameDestroy();
                }
            });
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public boolean ableToDraw() {
        return this.aYE != null && this.aYE.ableToDraw();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void exitGLThread() {
        if (this.aYE != null) {
            this.aYE.requestExitAndWait();
        }
        Log.e("EngineLogger", "[V8Dispose][AREngine] exitGLThread.");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameUpdate() {
        this.aYx.smallGameUpdate();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setScreenShotStatus(boolean z) {
        this.aYx.setScreenShotStatus(z);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public JSONArray getPerformanceJson() {
        return this.aYx == null ? new JSONArray() : this.aYx.getPerformanceJson();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public PerformanceJsonBean getPerformanceJsonBean() {
        return this.aYx == null ? new PerformanceJsonBean() : this.aYx.getPerformanceJsonBean();
    }

    public void eV(String str) {
        if (this.aYx != null) {
            this.aYx.getPerformanceJsonBean().put(str);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setFirstFrameListener(ArBridge.FirstFrameListener firstFrameListener) {
        this.aYx.setFirstFrameListener(firstFrameListener);
    }

    public EGLContext getEGLContext() {
        if (this.aYE == null || this.aYE.aYT == null) {
            return null;
        }
        return this.aYE.aYT.mEglContext;
    }

    protected void finalize() throws Throwable {
        try {
            if (this.aYE != null) {
                this.aYE.requestExitAndWait();
            }
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.smallgame.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0190a extends Thread {
        private c aYC;
        private boolean aYO;
        private b aYT;
        private a aYU;
        private boolean mHasSurface;
        private boolean mHaveEglContext;
        private boolean mHaveEglSurface;
        private boolean mPaused;
        private boolean mRenderComplete;
        private boolean mRequestPaused;
        private boolean mShouldReleaseEglContext;
        private boolean mSurfaceIsBad;
        private boolean mWaitingForSurface;
        private int aYG = 0;
        private long aYH = 0;
        private long aYI = 0;
        private long aYJ = 0;
        private long aYK = 0;
        private boolean aYL = false;
        private boolean aYM = false;
        private boolean aYN = false;
        private volatile boolean mShouldExit = false;
        private volatile boolean mExited = false;
        private LinkedList<Runnable> aYQ = new LinkedList<>();
        private LinkedList<Runnable> aYR = new LinkedList<>();
        private TreeSet<d> aYS = new TreeSet<>();
        private boolean mSizeChanged = true;
        private V8Engine mV8Engine = null;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean mRequestRender = true;
        private int mRenderMode = 1;
        private boolean aYP = false;

        C0190a(a aVar) {
            this.aYU = aVar;
            this.aYC = aVar.aYC;
        }

        /* JADX WARN: Type inference failed for: r4v0, types: [com.baidu.smallgame.sdk.a, com.baidu.searchbox.v8engine.V8Engine, com.baidu.smallgame.sdk.a$b] */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("ARGLThread " + getId());
            if (this.aYU != null) {
                ArBridge Gc = this.aYU.Gc();
                if (Gc != null) {
                    Gc.setGLThreadID(getId());
                    Gc.smallGameOnInit();
                    this.aYU.initDisplayMetrics();
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
                this.aYC.b(this);
                this.aYT.reset();
                this.aYT = null;
                this.aYU = null;
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
                this.aYT.destroySurface();
            }
        }

        private void stopEglContextLocked() {
            if (this.mHaveEglContext) {
                this.aYT.finish();
                this.mHaveEglContext = false;
                this.aYC.c(this);
            }
        }

        public boolean Gd() {
            return this.aYU.aYx.mFirstFrameFinished && ((float) (System.currentTimeMillis() - this.aYJ)) > minFramesInterval();
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
            if (r26.aYT.createSurface() == false) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:128:0x02d8, code lost:
            r10 = r26.aYC;
         */
        /* JADX WARN: Code restructure failed: missing block: B:129:0x02dc, code lost:
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:131:0x02de, code lost:
            r26.aYO = true;
            r26.aYC.notifyAll();
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
            r8 = r26.aYU;
         */
        /* JADX WARN: Code restructure failed: missing block: B:138:0x02f6, code lost:
            if (r8 == null) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:139:0x02f8, code lost:
            r8.aYA.onSurfaceCreated(null, null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:140:0x0301, code lost:
            r10 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:141:0x0303, code lost:
            if (r7 == false) goto L95;
         */
        /* JADX WARN: Code restructure failed: missing block: B:142:0x0305, code lost:
            r7 = r26.aYU;
         */
        /* JADX WARN: Code restructure failed: missing block: B:143:0x0309, code lost:
            if (r7 == null) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:144:0x030b, code lost:
            r7.aYA.onSurfaceChanged(null, r15, r14);
            r7.updateSurfaceViewSize(r15, r14);
         */
        /* JADX WARN: Code restructure failed: missing block: B:145:0x0318, code lost:
            r9 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:146:0x031a, code lost:
            r0 = r26.aYU;
            r18 = java.lang.System.currentTimeMillis();
            r20 = r18 - r26.aYI;
         */
        /* JADX WARN: Code restructure failed: missing block: B:147:0x0330, code lost:
            if (r0.aYB == false) goto L93;
         */
        /* JADX WARN: Code restructure failed: missing block: B:149:0x033b, code lost:
            if (((float) r20) < minFramesInterval()) goto L93;
         */
        /* JADX WARN: Code restructure failed: missing block: B:150:0x033d, code lost:
            r26.aYI = java.lang.System.currentTimeMillis();
         */
        /* JADX WARN: Code restructure failed: missing block: B:151:0x034b, code lost:
            if (r26.aYL != false) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:153:0x0351, code lost:
            if (r26.aYU == null) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:154:0x0353, code lost:
            r26.aYL = true;
            r26.aYU.eV("first_frame");
         */
        /* JADX WARN: Code restructure failed: missing block: B:155:0x0362, code lost:
            r0.aYA.onDrawFrame(null);
            Ge();
         */
        /* JADX WARN: Code restructure failed: missing block: B:156:0x0379, code lost:
            if ((r18 - r26.aYK) <= 33) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:157:0x037b, code lost:
            r0.aYx.notifyFrameUpdated();
            r26.aYK = r18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:159:0x038c, code lost:
            if (r26.aYN == false) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:160:0x038e, code lost:
            r26.aYU.aYx.smallGameOnResume();
            r26.aYN = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:161:0x039e, code lost:
            r8 = r0.aYx.shouldSwapBuffer();
         */
        /* JADX WARN: Code restructure failed: missing block: B:162:0x03a6, code lost:
            if (r8 == false) goto L92;
         */
        /* JADX WARN: Code restructure failed: missing block: B:163:0x03a8, code lost:
            r7 = r26.aYT.swap();
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
            r7 = r26.aYC;
         */
        /* JADX WARN: Code restructure failed: missing block: B:166:0x03c4, code lost:
            monitor-enter(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:168:0x03c7, code lost:
            r26.mSurfaceIsBad = true;
            r26.aYC.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:169:0x03d6, code lost:
            monitor-exit(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:170:0x03d7, code lost:
            r7 = r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:171:0x03d8, code lost:
            r26.aYJ = java.lang.System.currentTimeMillis();
         */
        /* JADX WARN: Code restructure failed: missing block: B:172:0x03ee, code lost:
            if (r26.aYU.aYx.isRenderCallbackQueueEmpty() != false) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:173:0x03f0, code lost:
            if (r8 == false) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:174:0x03f2, code lost:
            r8 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:176:0x03fe, code lost:
            if ((r0.aYx.getStuckScreenHandler() instanceof com.baidu.smallgame.sdk.b) == false) goto L84;
         */
        /* JADX WARN: Code restructure failed: missing block: B:177:0x0400, code lost:
            ((com.baidu.smallgame.sdk.b) r0.aYx.getStuckScreenHandler()).b(r8, r26.aYJ);
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
            r11 = r26.aYC;
         */
        /* JADX WARN: Code restructure failed: missing block: B:185:0x0431, code lost:
            monitor-enter(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:187:0x0433, code lost:
            r26.aYO = true;
            r26.mSurfaceIsBad = true;
            r26.aYC.notifyAll();
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
            r0.aYB = true;
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
            if (r26.aYM != false) goto L106;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x008c, code lost:
            if (r26.aYU == null) goto L106;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x008e, code lost:
            r26.aYM = true;
            r26.aYU.eV("first_event");
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00a1, code lost:
            if (com.baidu.searchbox.v8engine.V8Engine.isDebug() == false) goto L111;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00a7, code lost:
            if (r26.aYU == null) goto L111;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00a9, code lost:
            r26.aYU.u(1, r13.toString());
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
            this.aYT = new b(this.aYU);
            this.mHaveEglContext = false;
            this.mHaveEglSurface = false;
            this.aYP = false;
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
                    synchronized (this.aYC) {
                        z = z19;
                        boolean z20 = z18;
                        boolean z21 = z16;
                        boolean z22 = z15;
                        boolean z23 = z14;
                        boolean z24 = z13;
                        runnable = runnable2;
                        while (!this.mShouldExit) {
                            if (this.aYR.isEmpty()) {
                                if (ableToDraw()) {
                                    if (Gd()) {
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
                                        runnable = Gf();
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
                                        this.aYN = false;
                                        this.aYU.aYx.smallGameOnPauseOnGLThrad();
                                    } else {
                                        this.aYN = true;
                                    }
                                    this.aYC.notifyAll();
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
                                    this.aYC.notifyAll();
                                }
                                if (this.mHasSurface && this.mWaitingForSurface) {
                                    this.mWaitingForSurface = false;
                                    this.aYC.notifyAll();
                                }
                                if (z20) {
                                    this.aYP = false;
                                    z9 = false;
                                    this.mRenderComplete = true;
                                    this.aYC.notifyAll();
                                } else {
                                    z9 = z20;
                                }
                                if (readyToDraw()) {
                                    if (!this.mHaveEglContext) {
                                        if (z) {
                                            z = false;
                                        } else {
                                            try {
                                                this.aYT.start();
                                                this.aYU.aYx.setEglContextToRecorder(this.aYU.getEGLContext(), 0, 0);
                                                this.mHaveEglContext = true;
                                                z12 = true;
                                                this.aYC.notifyAll();
                                            } catch (RuntimeException e) {
                                                this.aYC.c(this);
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
                                            this.aYP = true;
                                            z11 = true;
                                            this.mSizeChanged = false;
                                        } else {
                                            z11 = z24;
                                        }
                                        this.mRequestRender = false;
                                        this.aYC.notifyAll();
                                        if (this.aYP) {
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
                                this.aYC.wait();
                                z20 = z9;
                            } else {
                                runnable = this.aYR.pollFirst();
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
                    synchronized (this.aYC) {
                        if (this.aYU != null) {
                            this.aYU.aYx.smallGameDestroy();
                        }
                        stopEglSurfaceLocked();
                        stopEglContextLocked();
                    }
                    return;
                } catch (Throwable th) {
                    synchronized (this.aYC) {
                        if (this.aYU != null) {
                            this.aYU.aYx.smallGameDestroy();
                        }
                        stopEglSurfaceLocked();
                        stopEglContextLocked();
                        throw th;
                    }
                }
            }
            if (V8Engine.isDebug() && this.aYU != null) {
                this.aYU.u(2, runnable.toString());
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

        private void Ge() {
            this.aYG++;
            if (this.aYH != 0) {
                float currentTimeMillis = ((float) (System.currentTimeMillis() - this.aYH)) / 1000.0f;
                if (currentTimeMillis > 1.0f) {
                    this.aYU.dK((int) (this.aYG / currentTimeMillis));
                    this.aYG = 0;
                    this.aYH = System.currentTimeMillis();
                    return;
                }
                return;
            }
            this.aYH = System.currentTimeMillis();
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
            synchronized (this.aYC) {
                this.mRenderMode = i;
                this.aYC.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (this.aYC) {
                i = this.mRenderMode;
            }
            return i;
        }

        public void requestRender() {
            synchronized (this.aYC) {
                this.mRequestRender = true;
                this.aYC.notifyAll();
            }
        }

        public void requestRenderAndWait() {
            synchronized (this.aYC) {
                if (Thread.currentThread() != this) {
                    this.aYP = true;
                    this.mRequestRender = true;
                    this.mRenderComplete = false;
                    this.aYC.notifyAll();
                    while (!this.mExited && !this.mPaused && !this.mRenderComplete && ableToDraw()) {
                        try {
                            this.aYC.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void surfaceCreated() {
            synchronized (this.aYC) {
                this.mHasSurface = true;
                this.aYO = false;
                this.aYC.notifyAll();
                while (this.mWaitingForSurface && !this.aYO && !this.mExited) {
                    try {
                        this.aYC.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (this.aYC) {
                this.mHasSurface = false;
                this.aYC.notifyAll();
                while (!this.mWaitingForSurface && !this.mExited) {
                    try {
                        this.aYC.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (this.aYC) {
                Log.i("EngineLogger", "onPause tid=" + getId());
                this.mRequestPaused = true;
                if (this.aYU != null && (this.aYU.aYx.getStuckScreenHandler() instanceof com.baidu.smallgame.sdk.b)) {
                    ((com.baidu.smallgame.sdk.b) this.aYU.aYx.getStuckScreenHandler()).Gj();
                }
                this.aYC.notifyAll();
                while (!this.mExited && !this.mPaused) {
                    Log.i("Main thread", "onPause waiting for mPaused.");
                    try {
                        this.aYC.wait(500L);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (this.aYC) {
                Log.i("EngineLogger", "onResume tid=" + getId());
                this.mRequestPaused = false;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                this.aYC.notifyAll();
                while (!this.mExited && this.mPaused && !this.mRenderComplete) {
                    Log.i("Main thread", "onResume waiting for !mPaused.");
                    try {
                        this.aYC.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onWindowResize(int i, int i2) {
            synchronized (this.aYC) {
                this.mWidth = i;
                this.mHeight = i2;
                this.mSizeChanged = true;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                if (Thread.currentThread() != this) {
                    this.aYC.notifyAll();
                    while (!this.mExited && !this.mPaused && !this.mRenderComplete && ableToDraw()) {
                        try {
                            this.aYC.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void requestExitAndWait() {
            synchronized (this.aYC) {
                this.mShouldExit = true;
                this.aYC.notifyAll();
                while (!this.mExited) {
                    try {
                        this.aYC.wait();
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
                synchronized (this.aYC) {
                    if (V8Engine.isDebug() && this.aYU != null) {
                        this.aYU.u(0, runnable.toString());
                    }
                    if (z || ableToDraw()) {
                        this.aYQ.add(runnable);
                    } else {
                        this.aYR.add(runnable);
                    }
                    this.aYC.notifyAll();
                }
            }
        }

        public void a(Runnable runnable, long j) {
            if (runnable == null) {
                throw new IllegalArgumentException("r must not be null");
            }
            if (!this.mShouldExit && !this.mExited) {
                synchronized (this.aYC) {
                    TreeSet<d> treeSet = this.aYS;
                    if (j <= 0) {
                        j = 0;
                    }
                    treeSet.add(new d(runnable, j));
                    this.aYC.notifyAll();
                }
            }
        }

        public void clearOldEvents() {
            synchronized (this.aYC) {
                this.aYQ.clear();
                this.aYR.clear();
                this.aYS.clear();
            }
        }

        private Runnable Gf() {
            Runnable pollFirst;
            synchronized (this.aYC) {
                pollFirst = (this.aYS.isEmpty() || !this.aYS.first().isTimeout()) ? this.aYQ.pollFirst() : this.aYS.pollFirst();
            }
            return pollFirst;
        }
    }

    /* loaded from: classes11.dex */
    public static class d implements Comparable<d>, Runnable {
        private final Runnable aYZ;
        private final long mTimestamp;

        d(Runnable runnable, long j) {
            this.aYZ = runnable;
            this.mTimestamp = System.currentTimeMillis() + j;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.aYZ.run();
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
        private C0190a aYY;

        private c() {
        }

        public synchronized void b(C0190a c0190a) {
            c0190a.mExited = true;
            if (this.aYY == c0190a) {
                this.aYY = null;
            }
            notifyAll();
        }

        public void c(C0190a c0190a) {
            if (this.aYY == c0190a) {
                this.aYY = null;
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class b {
        private a aYU;
        EGLDisplay aYV;
        EGLSurface aYW;
        EGLConfig aYX;
        EGLContext mEglContext;

        public b(a aVar) {
            this.aYU = aVar;
        }

        public void reset() {
            this.aYU = null;
        }

        public void start() {
            this.aYV = EGL14.eglGetDisplay(0);
            if (this.aYV == EGL14.EGL_NO_DISPLAY) {
                throw new RuntimeException("unable to get EGL14 display");
            }
            int[] iArr = new int[2];
            if (!EGL14.eglInitialize(this.aYV, iArr, 0, iArr, 1)) {
                this.aYV = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            a aVar = this.aYU;
            this.aYX = g(0, 0, false);
            this.mEglContext = EGL14.eglCreateContext(this.aYV, this.aYX, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
            this.aYU.mCurrentGLThreadID = Thread.currentThread().getId();
            if (this.mEglContext == null || this.mEglContext == EGL14.EGL_NO_CONTEXT) {
                this.mEglContext = null;
                throwEglException("createContext");
            }
            this.aYW = null;
        }

        private EGLConfig g(int i, int i2, boolean z) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (EGL14.eglChooseConfig(this.aYV, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, z ? 16 : 0, 12326, 0, 12352, 4, 12344, 0, 12344}, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
                return eGLConfigArr[0];
            }
            Log.w("EngineLogger", "unable to find RGB8888 / " + i2 + " EGLConfig");
            return null;
        }

        public boolean createSurface() {
            if (this.aYV == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.aYX == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            destroySurface();
            Object obj = this.aYU.mSurfaceHolder;
            if (obj == null) {
                obj = this.aYU.aYD;
            }
            if (obj != null) {
                this.aYW = EGL14.eglCreateWindowSurface(this.aYV, this.aYX, obj, new int[]{12344}, 0);
            } else {
                this.aYW = null;
            }
            if (this.aYW == null || this.aYW == EGL14.EGL_NO_SURFACE) {
                if (EGL14.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    return false;
                }
                return false;
            }
            return EGL14.eglMakeCurrent(this.aYV, this.aYW, this.aYW, this.mEglContext);
        }

        public int swap() {
            return !EGL14.eglSwapBuffers(this.aYV, this.aYW) ? EGL14.eglGetError() : CommandMessage.COMMAND_BASE;
        }

        public void destroySurface() {
            if (this.aYW != null && this.aYW != EGL14.EGL_NO_SURFACE) {
                EGL14.eglMakeCurrent(this.aYV, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
                EGL14.eglDestroySurface(this.aYV, this.aYW);
                this.aYW = null;
            }
        }

        public void finish() {
            if (this.mEglContext != null) {
                EGL14.eglDestroyContext(this.aYV, this.mEglContext);
                this.mEglContext = null;
            }
            if (this.aYV != null) {
                EGL14.eglTerminate(this.aYV);
                this.aYV = null;
            }
            this.aYU.mCurrentGLThreadID = -1L;
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
