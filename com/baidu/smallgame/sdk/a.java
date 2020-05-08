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
/* loaded from: classes11.dex */
public final class a implements AREngineDelegate {
    public static PermissionProxy bxa = null;
    public static int bxb = 0;
    private ArBridge bxc;
    private GLSurfaceView.Renderer bxf;
    private Object bxi;
    private C0241a bxj;
    private Context mContext;
    private boolean mDetached;
    private SurfaceHolder mSurfaceHolder;
    private ArrayList<DebugConsole> mConsoles = null;
    private int mFPS = 0;
    private long mCurrentGLThreadID = -1;
    private float bxd = 0.0f;
    private float bxe = 0.0f;
    private boolean bxg = false;
    private final c bxh = new c();

    public Context getContext() {
        return this.mContext;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        Log.setMinLogLevel(6, false);
        this.bxc = new ArBridge();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void startEngine() {
        if (this.bxf == null) {
            throw new NullPointerException("start render engine failed. because renderer is not set");
        }
        this.bxj = new C0241a(this);
        this.bxj.start();
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

    public ArBridge NO() {
        return this.bxc;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public Thread getGLThread() {
        return this.bxj;
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
        this.bxd = f;
        this.bxe = f2;
        this.bxc.setSize(f, f2);
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
        if (this.bxd != 0.0f) {
            f = this.bxd;
        }
        if (this.bxe != 0.0f) {
            f2 = this.bxe;
        }
        if (this.bxc != null) {
            this.bxc.setDisplayMetrics(f, f2, displayMetrics.xdpi, displayMetrics.ydpi, displayMetrics.density);
        } else {
            Log.e("EngineLogger", "[RenderError] error init render display, because arbridge is null");
        }
    }

    public void c(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = (SurfaceHolder) new WeakReference(surfaceHolder).get();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderer(GLSurfaceView.Renderer renderer) {
        this.bxf = renderer;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderMode(int i) {
        if (this.bxj != null) {
            this.bxj.setRenderMode(i);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public int getRenderMode() {
        if (this.bxj != null) {
            return this.bxj.getRenderMode();
        }
        return 1;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRender() {
        if (this.bxj != null) {
            this.bxj.requestRender();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceCreated() {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceCreated.");
        this.bxj.surfaceCreated();
        Context appContext = V8Engine.getAppContext();
        if (appContext != null) {
            bxb = ((WindowManager) appContext.getSystemService("window")).getDefaultDisplay().getRotation();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceDestroyed() {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceDestroyed.");
        this.bxj.surfaceDestroyed();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceChanged(int i, int i2) {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceChanged. width=" + i + ", height=" + i2);
        this.bxj.onWindowResize(i, i2);
        this.bxc.setEglContextToRecorder(getEGLContext(), i, i2);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRenderAndWait() {
        if (this.bxj != null) {
            this.bxj.requestRenderAndWait();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameOnPause() {
        this.bxc.smallGameOnPause();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void runOnGLThread(Runnable runnable) {
        if (this.bxj != null) {
            this.bxj.runOnGLThread(runnable);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable) {
        if (this.bxj != null) {
            this.bxj.queueEvent(runnable);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable, long j) {
        if (this.bxj != null) {
            this.bxj.b(runnable, j);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onAttachedToWindow() {
        if (this.mDetached && this.bxf != null) {
            int renderMode = this.bxj != null ? this.bxj.getRenderMode() : 1;
            this.bxj = new C0241a(this);
            if (renderMode != 1) {
                this.bxj.setRenderMode(renderMode);
            }
            this.bxj.start();
        }
        this.mDetached = false;
        Log.w("EngineLogger", "[V8Dispose][AREngine] onAttachedToWindow");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onDetachedFromWindow() {
        if (!this.mDetached && this.bxj != null) {
            this.bxj.requestExitAndWait();
        }
        this.mDetached = true;
        Log.w("EngineLogger", "[V8Dispose][AREngine] onDetachedFromWindow");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void clearOldEvents() {
        if (this.bxj != null) {
            this.bxj.clearOldEvents();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onPause() {
        if (this.bxj != null) {
            this.bxj.onPause();
        }
        if (this.bxc.getGameRecorder() != null) {
            this.bxc.getGameRecorder().IQ();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onResume() {
        if (this.bxj != null) {
            this.bxj.onResume();
        }
        if (this.bxc.getGameRecorder() != null) {
            this.bxc.getGameRecorder().IR();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void pauseRecord() {
        if (this.bxc.getGameRecorder() != null) {
            this.bxc.getGameRecorder().pauseRecord();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void resumeRecord() {
        if (this.bxc.getGameRecorder() != null) {
            this.bxc.getGameRecorder().resumeRecord();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void stopRecord() {
        if (this.bxc.getGameRecorder() != null) {
            this.bxc.getGameRecorder().stopRecord();
            this.bxc.nativeUpdateRecordingStatus(false);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (this.bxc.getGameRecorder() != null) {
            this.bxc.nativeUpdateRecordingStatus(true);
            this.bxc.getGameRecorder().startRecord(z, i, str, z2);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setGameRecordCallback(com.baidu.mario.a.c cVar) {
        if (this.bxc.getGameRecorder() != null) {
            this.bxc.getGameRecorder().setGameRecordCallback(cVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setAudioEngineProxy(com.baidu.mario.a.a aVar) {
        if (this.bxc.getGameRecorder() != null) {
            this.bxc.getGameRecorder().setAudioEngineProxy(aVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public long getCurrentRecordProcess() {
        if (this.bxc.getGameRecorder() != null) {
            return this.bxc.getGameRecorder().IP();
        }
        return 0L;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setPermissionProxy(PermissionProxy permissionProxy) {
        bxa = permissionProxy;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setOnStuckScreenListener(com.baidu.smallgame.sdk.b.a aVar) {
        if (this.bxc != null) {
            this.bxc.setOnStuckScreenListener(aVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setStuckScreenLimitTime(long j) {
        if (this.bxc != null) {
            this.bxc.setStuckScreenLimitTime(j);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public com.baidu.smallgame.sdk.b.c getStuckScreenHandler() {
        if (this.bxc == null) {
            return null;
        }
        return this.bxc.getStuckScreenHandler();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameDestroy() {
        if (this.bxj == null) {
            Log.e("EngineLogger", "Destroy AREngine fail. Because GLThread is null");
        } else {
            this.bxj.runOnGLThread(new Runnable() { // from class: com.baidu.smallgame.sdk.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.bxj.mShouldExit = true;
                    a.this.bxc.smallGameDestroy();
                }
            });
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public boolean ableToDraw() {
        return this.bxj != null && this.bxj.ableToDraw();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void exitGLThread() {
        if (this.bxj != null) {
            this.bxj.requestExitAndWait();
        }
        Log.e("EngineLogger", "[V8Dispose][AREngine] exitGLThread.");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameUpdate() {
        this.bxc.smallGameUpdate();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setScreenShotStatus(boolean z) {
        this.bxc.setScreenShotStatus(z);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public JSONArray getPerformanceJson() {
        return this.bxc == null ? new JSONArray() : this.bxc.getPerformanceJson();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public PerformanceJsonBean getPerformanceJsonBean() {
        return this.bxc == null ? new PerformanceJsonBean() : this.bxc.getPerformanceJsonBean();
    }

    public void gg(String str) {
        if (this.bxc != null) {
            this.bxc.getPerformanceJsonBean().put(str);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setFirstFrameListener(ArBridge.FirstFrameListener firstFrameListener) {
        this.bxc.setFirstFrameListener(firstFrameListener);
    }

    public EGLContext getEGLContext() {
        if (this.bxj == null || this.bxj.bxy == null) {
            return null;
        }
        return this.bxj.bxy.mEglContext;
    }

    protected void finalize() throws Throwable {
        try {
            if (this.bxj != null) {
                this.bxj.requestExitAndWait();
            }
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.smallgame.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0241a extends Thread {
        private c bxh;
        private boolean bxt;
        private b bxy;
        private a bxz;
        private boolean mHasSurface;
        private boolean mHaveEglContext;
        private boolean mHaveEglSurface;
        private boolean mPaused;
        private boolean mRenderComplete;
        private boolean mRequestPaused;
        private boolean mShouldReleaseEglContext;
        private boolean mSurfaceIsBad;
        private boolean mWaitingForSurface;
        private int bxl = 0;
        private long bxm = 0;
        private long bxn = 0;
        private long bxo = 0;
        private long bxp = 0;
        private boolean bxq = false;
        private boolean bxr = false;
        private boolean bxs = false;
        private volatile boolean mShouldExit = false;
        private volatile boolean mExited = false;
        private LinkedList<Runnable> bxv = new LinkedList<>();
        private LinkedList<Runnable> bxw = new LinkedList<>();
        private TreeSet<d> bxx = new TreeSet<>();
        private boolean mSizeChanged = true;
        private V8Engine mV8Engine = null;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean mRequestRender = true;
        private int mRenderMode = 1;
        private boolean bxu = false;

        C0241a(a aVar) {
            this.bxz = aVar;
            this.bxh = aVar.bxh;
        }

        /* JADX WARN: Type inference failed for: r4v0, types: [com.baidu.smallgame.sdk.a, com.baidu.searchbox.v8engine.V8Engine, com.baidu.smallgame.sdk.a$b] */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("ARGLThread " + getId());
            if (this.bxz != null) {
                ArBridge NO = this.bxz.NO();
                if (NO != null) {
                    NO.setGLThreadID(getId());
                    NO.smallGameOnInit();
                    this.bxz.initDisplayMetrics();
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
                this.bxh.b(this);
                this.bxy.reset();
                this.bxy = null;
                this.bxz = null;
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
                this.bxy.destroySurface();
            }
        }

        private void stopEglContextLocked() {
            if (this.mHaveEglContext) {
                this.bxy.finish();
                this.mHaveEglContext = false;
                this.bxh.c(this);
            }
        }

        public boolean NP() {
            return this.bxz.bxc.mFirstFrameFinished && ((float) (System.currentTimeMillis() - this.bxo)) > minFramesInterval();
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
            if (r26.bxy.createSurface() == false) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:128:0x02d8, code lost:
            r10 = r26.bxh;
         */
        /* JADX WARN: Code restructure failed: missing block: B:129:0x02dc, code lost:
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:131:0x02de, code lost:
            r26.bxt = true;
            r26.bxh.notifyAll();
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
            r8 = r26.bxz;
         */
        /* JADX WARN: Code restructure failed: missing block: B:138:0x02f6, code lost:
            if (r8 == null) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:139:0x02f8, code lost:
            r8.bxf.onSurfaceCreated(null, null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:140:0x0301, code lost:
            r10 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:141:0x0303, code lost:
            if (r7 == false) goto L95;
         */
        /* JADX WARN: Code restructure failed: missing block: B:142:0x0305, code lost:
            r7 = r26.bxz;
         */
        /* JADX WARN: Code restructure failed: missing block: B:143:0x0309, code lost:
            if (r7 == null) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:144:0x030b, code lost:
            r7.bxf.onSurfaceChanged(null, r15, r14);
            r7.updateSurfaceViewSize(r15, r14);
         */
        /* JADX WARN: Code restructure failed: missing block: B:145:0x0318, code lost:
            r9 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:146:0x031a, code lost:
            r0 = r26.bxz;
            r18 = java.lang.System.currentTimeMillis();
            r20 = r18 - r26.bxn;
         */
        /* JADX WARN: Code restructure failed: missing block: B:147:0x0330, code lost:
            if (r0.bxg == false) goto L93;
         */
        /* JADX WARN: Code restructure failed: missing block: B:149:0x033b, code lost:
            if (((float) r20) < minFramesInterval()) goto L93;
         */
        /* JADX WARN: Code restructure failed: missing block: B:150:0x033d, code lost:
            r26.bxn = java.lang.System.currentTimeMillis();
         */
        /* JADX WARN: Code restructure failed: missing block: B:151:0x034b, code lost:
            if (r26.bxq != false) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:153:0x0351, code lost:
            if (r26.bxz == null) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:154:0x0353, code lost:
            r26.bxq = true;
            r26.bxz.gg("first_frame");
         */
        /* JADX WARN: Code restructure failed: missing block: B:155:0x0362, code lost:
            r0.bxf.onDrawFrame(null);
            NQ();
         */
        /* JADX WARN: Code restructure failed: missing block: B:156:0x0379, code lost:
            if ((r18 - r26.bxp) <= 33) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:157:0x037b, code lost:
            r0.bxc.notifyFrameUpdated();
            r26.bxp = r18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:159:0x038c, code lost:
            if (r26.bxs == false) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:160:0x038e, code lost:
            r26.bxz.bxc.smallGameOnResume();
            r26.bxs = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:161:0x039e, code lost:
            r8 = r0.bxc.shouldSwapBuffer();
         */
        /* JADX WARN: Code restructure failed: missing block: B:162:0x03a6, code lost:
            if (r8 == false) goto L92;
         */
        /* JADX WARN: Code restructure failed: missing block: B:163:0x03a8, code lost:
            r7 = r26.bxy.swap();
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
            r7 = r26.bxh;
         */
        /* JADX WARN: Code restructure failed: missing block: B:166:0x03c4, code lost:
            monitor-enter(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:168:0x03c7, code lost:
            r26.mSurfaceIsBad = true;
            r26.bxh.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:169:0x03d6, code lost:
            monitor-exit(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:170:0x03d7, code lost:
            r7 = r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:171:0x03d8, code lost:
            r26.bxo = java.lang.System.currentTimeMillis();
         */
        /* JADX WARN: Code restructure failed: missing block: B:172:0x03ee, code lost:
            if (r26.bxz.bxc.isRenderCallbackQueueEmpty() != false) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:173:0x03f0, code lost:
            if (r8 == false) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:174:0x03f2, code lost:
            r8 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:176:0x03fe, code lost:
            if ((r0.bxc.getStuckScreenHandler() instanceof com.baidu.smallgame.sdk.b) == false) goto L84;
         */
        /* JADX WARN: Code restructure failed: missing block: B:177:0x0400, code lost:
            ((com.baidu.smallgame.sdk.b) r0.bxc.getStuckScreenHandler()).b(r8, r26.bxo);
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
            r11 = r26.bxh;
         */
        /* JADX WARN: Code restructure failed: missing block: B:185:0x0431, code lost:
            monitor-enter(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:187:0x0433, code lost:
            r26.bxt = true;
            r26.mSurfaceIsBad = true;
            r26.bxh.notifyAll();
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
            r0.bxg = true;
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
            if (r26.bxr != false) goto L106;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x008c, code lost:
            if (r26.bxz == null) goto L106;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x008e, code lost:
            r26.bxr = true;
            r26.bxz.gg("first_event");
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00a1, code lost:
            if (com.baidu.searchbox.v8engine.V8Engine.isDebug() == false) goto L111;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00a7, code lost:
            if (r26.bxz == null) goto L111;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00a9, code lost:
            r26.bxz.L(1, r13.toString());
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
            this.bxy = new b(this.bxz);
            this.mHaveEglContext = false;
            this.mHaveEglSurface = false;
            this.bxu = false;
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
                    synchronized (this.bxh) {
                        z = z19;
                        boolean z20 = z18;
                        boolean z21 = z16;
                        boolean z22 = z15;
                        boolean z23 = z14;
                        boolean z24 = z13;
                        runnable = runnable2;
                        while (!this.mShouldExit) {
                            if (this.bxw.isEmpty()) {
                                if (ableToDraw()) {
                                    if (NP()) {
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
                                        runnable = NR();
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
                                        this.bxs = false;
                                        this.bxz.bxc.smallGameOnPauseOnGLThrad();
                                    } else {
                                        this.bxs = true;
                                    }
                                    this.bxh.notifyAll();
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
                                    this.bxh.notifyAll();
                                }
                                if (this.mHasSurface && this.mWaitingForSurface) {
                                    this.mWaitingForSurface = false;
                                    this.bxh.notifyAll();
                                }
                                if (z20) {
                                    this.bxu = false;
                                    z9 = false;
                                    this.mRenderComplete = true;
                                    this.bxh.notifyAll();
                                } else {
                                    z9 = z20;
                                }
                                if (readyToDraw()) {
                                    if (!this.mHaveEglContext) {
                                        if (z) {
                                            z = false;
                                        } else {
                                            try {
                                                this.bxy.start();
                                                this.bxz.bxc.setEglContextToRecorder(this.bxz.getEGLContext(), 0, 0);
                                                this.mHaveEglContext = true;
                                                z12 = true;
                                                this.bxh.notifyAll();
                                            } catch (RuntimeException e) {
                                                this.bxh.c(this);
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
                                            this.bxu = true;
                                            z11 = true;
                                            this.mSizeChanged = false;
                                        } else {
                                            z11 = z24;
                                        }
                                        this.mRequestRender = false;
                                        this.bxh.notifyAll();
                                        if (this.bxu) {
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
                                this.bxh.wait();
                                z20 = z9;
                            } else {
                                runnable = this.bxw.pollFirst();
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
                    synchronized (this.bxh) {
                        if (this.bxz != null) {
                            this.bxz.bxc.smallGameDestroy();
                        }
                        stopEglSurfaceLocked();
                        stopEglContextLocked();
                    }
                    return;
                } catch (Throwable th) {
                    synchronized (this.bxh) {
                        if (this.bxz != null) {
                            this.bxz.bxc.smallGameDestroy();
                        }
                        stopEglSurfaceLocked();
                        stopEglContextLocked();
                        throw th;
                    }
                }
            }
            if (V8Engine.isDebug() && this.bxz != null) {
                this.bxz.L(2, runnable.toString());
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

        private void NQ() {
            this.bxl++;
            if (this.bxm != 0) {
                float currentTimeMillis = ((float) (System.currentTimeMillis() - this.bxm)) / 1000.0f;
                if (currentTimeMillis > 1.0f) {
                    this.bxz.dT((int) (this.bxl / currentTimeMillis));
                    this.bxl = 0;
                    this.bxm = System.currentTimeMillis();
                    return;
                }
                return;
            }
            this.bxm = System.currentTimeMillis();
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
            synchronized (this.bxh) {
                this.mRenderMode = i;
                this.bxh.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (this.bxh) {
                i = this.mRenderMode;
            }
            return i;
        }

        public void requestRender() {
            synchronized (this.bxh) {
                this.mRequestRender = true;
                this.bxh.notifyAll();
            }
        }

        public void requestRenderAndWait() {
            synchronized (this.bxh) {
                if (Thread.currentThread() != this) {
                    this.bxu = true;
                    this.mRequestRender = true;
                    this.mRenderComplete = false;
                    this.bxh.notifyAll();
                    while (!this.mExited && !this.mPaused && !this.mRenderComplete && ableToDraw()) {
                        try {
                            this.bxh.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void surfaceCreated() {
            synchronized (this.bxh) {
                this.mHasSurface = true;
                this.bxt = false;
                this.bxh.notifyAll();
                while (this.mWaitingForSurface && !this.bxt && !this.mExited) {
                    try {
                        this.bxh.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (this.bxh) {
                this.mHasSurface = false;
                this.bxh.notifyAll();
                while (!this.mWaitingForSurface && !this.mExited) {
                    try {
                        this.bxh.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (this.bxh) {
                Log.i("EngineLogger", "onPause tid=" + getId());
                this.mRequestPaused = true;
                if (this.bxz != null && (this.bxz.bxc.getStuckScreenHandler() instanceof com.baidu.smallgame.sdk.b)) {
                    ((com.baidu.smallgame.sdk.b) this.bxz.bxc.getStuckScreenHandler()).NV();
                }
                this.bxh.notifyAll();
                while (!this.mExited && !this.mPaused) {
                    Log.i("Main thread", "onPause waiting for mPaused.");
                    try {
                        this.bxh.wait(500L);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (this.bxh) {
                Log.i("EngineLogger", "onResume tid=" + getId());
                this.mRequestPaused = false;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                this.bxh.notifyAll();
                while (!this.mExited && this.mPaused && !this.mRenderComplete) {
                    Log.i("Main thread", "onResume waiting for !mPaused.");
                    try {
                        this.bxh.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onWindowResize(int i, int i2) {
            synchronized (this.bxh) {
                this.mWidth = i;
                this.mHeight = i2;
                this.mSizeChanged = true;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                if (Thread.currentThread() != this) {
                    this.bxh.notifyAll();
                    while (!this.mExited && !this.mPaused && !this.mRenderComplete && ableToDraw()) {
                        try {
                            this.bxh.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void requestExitAndWait() {
            synchronized (this.bxh) {
                this.mShouldExit = true;
                this.bxh.notifyAll();
                while (!this.mExited) {
                    try {
                        this.bxh.wait();
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
                synchronized (this.bxh) {
                    if (V8Engine.isDebug() && this.bxz != null) {
                        this.bxz.L(0, runnable.toString());
                    }
                    if (z || ableToDraw()) {
                        this.bxv.add(runnable);
                    } else {
                        this.bxw.add(runnable);
                    }
                    this.bxh.notifyAll();
                }
            }
        }

        public void b(Runnable runnable, long j) {
            if (runnable == null) {
                throw new IllegalArgumentException("r must not be null");
            }
            if (!this.mShouldExit && !this.mExited) {
                synchronized (this.bxh) {
                    TreeSet<d> treeSet = this.bxx;
                    if (j <= 0) {
                        j = 0;
                    }
                    treeSet.add(new d(runnable, j));
                    this.bxh.notifyAll();
                }
            }
        }

        public void clearOldEvents() {
            synchronized (this.bxh) {
                this.bxv.clear();
                this.bxw.clear();
                this.bxx.clear();
            }
        }

        private Runnable NR() {
            Runnable pollFirst;
            synchronized (this.bxh) {
                pollFirst = (this.bxx.isEmpty() || !this.bxx.first().isTimeout()) ? this.bxv.pollFirst() : this.bxx.pollFirst();
            }
            return pollFirst;
        }
    }

    /* loaded from: classes11.dex */
    public static class d implements Comparable<d>, Runnable {
        private final Runnable bxE;
        private final long mTimestamp;

        d(Runnable runnable, long j) {
            this.bxE = runnable;
            this.mTimestamp = System.currentTimeMillis() + j;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.bxE.run();
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
        private C0241a bxD;

        private c() {
        }

        public synchronized void b(C0241a c0241a) {
            c0241a.mExited = true;
            if (this.bxD == c0241a) {
                this.bxD = null;
            }
            notifyAll();
        }

        public void c(C0241a c0241a) {
            if (this.bxD == c0241a) {
                this.bxD = null;
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class b {
        EGLDisplay bxA;
        EGLSurface bxB;
        EGLConfig bxC;
        private a bxz;
        EGLContext mEglContext;

        public b(a aVar) {
            this.bxz = aVar;
        }

        public void reset() {
            this.bxz = null;
        }

        public void start() {
            this.bxA = EGL14.eglGetDisplay(0);
            if (this.bxA == EGL14.EGL_NO_DISPLAY) {
                throw new RuntimeException("unable to get EGL14 display");
            }
            int[] iArr = new int[2];
            if (!EGL14.eglInitialize(this.bxA, iArr, 0, iArr, 1)) {
                this.bxA = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            a aVar = this.bxz;
            this.bxC = g(0, 0, false);
            this.mEglContext = EGL14.eglCreateContext(this.bxA, this.bxC, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
            this.bxz.mCurrentGLThreadID = Thread.currentThread().getId();
            if (this.mEglContext == null || this.mEglContext == EGL14.EGL_NO_CONTEXT) {
                this.mEglContext = null;
                throwEglException("createContext");
            }
            this.bxB = null;
        }

        private EGLConfig g(int i, int i2, boolean z) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (EGL14.eglChooseConfig(this.bxA, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, z ? 16 : 0, 12326, 0, 12352, 4, 12344, 0, 12344}, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
                return eGLConfigArr[0];
            }
            Log.w("EngineLogger", "unable to find RGB8888 / " + i2 + " EGLConfig");
            return null;
        }

        public boolean createSurface() {
            if (this.bxA == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.bxC == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            destroySurface();
            Object obj = this.bxz.mSurfaceHolder;
            if (obj == null) {
                obj = this.bxz.bxi;
            }
            if (obj != null) {
                this.bxB = EGL14.eglCreateWindowSurface(this.bxA, this.bxC, obj, new int[]{12344}, 0);
            } else {
                this.bxB = null;
            }
            if (this.bxB == null || this.bxB == EGL14.EGL_NO_SURFACE) {
                if (EGL14.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    return false;
                }
                return false;
            }
            return EGL14.eglMakeCurrent(this.bxA, this.bxB, this.bxB, this.mEglContext);
        }

        public int swap() {
            return !EGL14.eglSwapBuffers(this.bxA, this.bxB) ? EGL14.eglGetError() : CommandMessage.COMMAND_BASE;
        }

        public void destroySurface() {
            if (this.bxB != null && this.bxB != EGL14.EGL_NO_SURFACE) {
                EGL14.eglMakeCurrent(this.bxA, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
                EGL14.eglDestroySurface(this.bxA, this.bxB);
                this.bxB = null;
            }
        }

        public void finish() {
            if (this.mEglContext != null) {
                EGL14.eglDestroyContext(this.bxA, this.mEglContext);
                this.mEglContext = null;
            }
            if (this.bxA != null) {
                EGL14.eglTerminate(this.bxA);
                this.bxA = null;
            }
            this.bxz.mCurrentGLThreadID = -1L;
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
