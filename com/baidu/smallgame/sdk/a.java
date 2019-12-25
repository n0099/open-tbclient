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
/* loaded from: classes9.dex */
public final class a implements AREngineDelegate {
    public static PermissionProxy aSP = null;
    public static int aSQ = 0;
    private ArBridge aSR;
    private GLSurfaceView.Renderer aSU;
    private Object aSX;
    private C0178a aSY;
    private Context mContext;
    private boolean mDetached;
    private SurfaceHolder mSurfaceHolder;
    private ArrayList<DebugConsole> mConsoles = null;
    private int mFPS = 0;
    private long mCurrentGLThreadID = -1;
    private float aSS = 0.0f;
    private float aST = 0.0f;
    private boolean aSV = false;
    private final c aSW = new c();

    public Context getContext() {
        return this.mContext;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        Log.setMinLogLevel(6, false);
        this.aSR = new ArBridge();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void startEngine() {
        if (this.aSU == null) {
            throw new NullPointerException("start render engine failed. because renderer is not set");
        }
        this.aSY = new C0178a(this);
        this.aSY.start();
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
    public void p(int i, String str) {
        if (this.mConsoles != null) {
            for (DebugConsole debugConsole : new ArrayList(this.mConsoles)) {
                debugConsole.onReceiveInfo(i, str);
            }
        }
    }

    public ArBridge Dd() {
        return this.aSR;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public Thread getGLThread() {
        return this.aSY;
    }

    void dt(int i) {
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
        this.aSS = f;
        this.aST = f2;
        this.aSR.setSize(f, f2);
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
        if (this.aSS != 0.0f) {
            f = this.aSS;
        }
        if (this.aST != 0.0f) {
            f2 = this.aST;
        }
        if (this.aSR != null) {
            this.aSR.setDisplayMetrics(f, f2, displayMetrics.xdpi, displayMetrics.ydpi, displayMetrics.density);
        } else {
            Log.e("EngineLogger", "[RenderError] error init render display, because arbridge is null");
        }
    }

    public void c(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = (SurfaceHolder) new WeakReference(surfaceHolder).get();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderer(GLSurfaceView.Renderer renderer) {
        this.aSU = renderer;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderMode(int i) {
        if (this.aSY != null) {
            this.aSY.setRenderMode(i);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public int getRenderMode() {
        if (this.aSY != null) {
            return this.aSY.getRenderMode();
        }
        return 1;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRender() {
        if (this.aSY != null) {
            this.aSY.requestRender();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceCreated() {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceCreated.");
        this.aSY.surfaceCreated();
        Context appContext = V8Engine.getAppContext();
        if (appContext != null) {
            aSQ = ((WindowManager) appContext.getSystemService("window")).getDefaultDisplay().getRotation();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceDestroyed() {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceDestroyed.");
        this.aSY.surfaceDestroyed();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceChanged(int i, int i2) {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceChanged. width=" + i + ", height=" + i2);
        this.aSY.N(i, i2);
        this.aSR.setEglContextToRecorder(getEGLContext(), i, i2);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRenderAndWait() {
        if (this.aSY != null) {
            this.aSY.requestRenderAndWait();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameOnPause() {
        this.aSR.smallGameOnPause();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void runOnGLThread(Runnable runnable) {
        if (this.aSY != null) {
            this.aSY.runOnGLThread(runnable);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable) {
        if (this.aSY != null) {
            this.aSY.queueEvent(runnable);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable, long j) {
        if (this.aSY != null) {
            this.aSY.a(runnable, j);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onAttachedToWindow() {
        if (this.mDetached && this.aSU != null) {
            int renderMode = this.aSY != null ? this.aSY.getRenderMode() : 1;
            this.aSY = new C0178a(this);
            if (renderMode != 1) {
                this.aSY.setRenderMode(renderMode);
            }
            this.aSY.start();
        }
        this.mDetached = false;
        Log.w("EngineLogger", "[V8Dispose][AREngine] onAttachedToWindow");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onDetachedFromWindow() {
        if (!this.mDetached && this.aSY != null) {
            this.aSY.Dk();
        }
        this.mDetached = true;
        Log.w("EngineLogger", "[V8Dispose][AREngine] onDetachedFromWindow");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void clearOldEvents() {
        if (this.aSY != null) {
            this.aSY.clearOldEvents();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onPause() {
        if (this.aSY != null) {
            this.aSY.onPause();
        }
        if (this.aSR.getGameRecorder() != null) {
            this.aSR.getGameRecorder().zR();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onResume() {
        if (this.aSY != null) {
            this.aSY.onResume();
        }
        if (this.aSR.getGameRecorder() != null) {
            this.aSR.getGameRecorder().zS();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void pauseRecord() {
        if (this.aSR.getGameRecorder() != null) {
            this.aSR.getGameRecorder().pauseRecord();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void resumeRecord() {
        if (this.aSR.getGameRecorder() != null) {
            this.aSR.getGameRecorder().resumeRecord();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void stopRecord() {
        if (this.aSR.getGameRecorder() != null) {
            this.aSR.getGameRecorder().stopRecord();
            this.aSR.nativeUpdateRecordingStatus(false);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (this.aSR.getGameRecorder() != null) {
            this.aSR.nativeUpdateRecordingStatus(true);
            this.aSR.getGameRecorder().startRecord(z, i, str, z2);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setGameRecordCallback(com.baidu.mario.a.c cVar) {
        if (this.aSR.getGameRecorder() != null) {
            this.aSR.getGameRecorder().setGameRecordCallback(cVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setAudioEngineProxy(com.baidu.mario.a.a aVar) {
        if (this.aSR.getGameRecorder() != null) {
            this.aSR.getGameRecorder().setAudioEngineProxy(aVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public long getCurrentRecordProcess() {
        if (this.aSR.getGameRecorder() != null) {
            return this.aSR.getGameRecorder().zQ();
        }
        return 0L;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setPermissionProxy(PermissionProxy permissionProxy) {
        aSP = permissionProxy;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setOnStuckScreenListener(com.baidu.smallgame.sdk.b.a aVar) {
        if (this.aSR != null) {
            this.aSR.setOnStuckScreenListener(aVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setStuckScreenLimitTime(long j) {
        if (this.aSR != null) {
            this.aSR.setStuckScreenLimitTime(j);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public com.baidu.smallgame.sdk.b.c getStuckScreenHandler() {
        if (this.aSR == null) {
            return null;
        }
        return this.aSR.getStuckScreenHandler();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameDestroy() {
        if (this.aSY == null) {
            Log.e("EngineLogger", "Destroy AREngine fail. Because GLThread is null");
        } else {
            this.aSY.runOnGLThread(new Runnable() { // from class: com.baidu.smallgame.sdk.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.aSY.aTi = true;
                    a.this.aSR.smallGameDestroy();
                }
            });
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public boolean ableToDraw() {
        return this.aSY != null && this.aSY.ableToDraw();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void exitGLThread() {
        if (this.aSY != null) {
            this.aSY.Dk();
        }
        Log.e("EngineLogger", "[V8Dispose][AREngine] exitGLThread.");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameUpdate() {
        this.aSR.smallGameUpdate();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setScreenShotStatus(boolean z) {
        this.aSR.setScreenShotStatus(z);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public JSONArray getPerformanceJson() {
        return this.aSR == null ? new JSONArray() : this.aSR.getPerformanceJson();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public PerformanceJsonBean getPerformanceJsonBean() {
        return this.aSR == null ? new PerformanceJsonBean() : this.aSR.getPerformanceJsonBean();
    }

    public void eD(String str) {
        if (this.aSR != null) {
            this.aSR.getPerformanceJsonBean().put(str);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setFirstFrameListener(ArBridge.FirstFrameListener firstFrameListener) {
        this.aSR.setFirstFrameListener(firstFrameListener);
    }

    public EGLContext getEGLContext() {
        if (this.aSY == null || this.aSY.aTA == null) {
            return null;
        }
        return this.aSY.aTA.mEglContext;
    }

    protected void finalize() throws Throwable {
        try {
            if (this.aSY != null) {
                this.aSY.Dk();
            }
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.smallgame.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0178a extends Thread {
        private c aSW;
        private b aTA;
        private a aTB;
        private boolean aTk;
        private boolean aTl;
        private boolean aTm;
        private boolean aTn;
        private boolean aTo;
        private boolean aTp;
        private boolean aTq;
        private boolean aTr;
        private boolean aTv;
        private boolean mPaused;
        private int aTa = 0;
        private long aTb = 0;
        private long aTc = 0;
        private long aTd = 0;
        private long aTe = 0;
        private boolean aTf = false;
        private boolean aTg = false;
        private boolean aTh = false;
        private volatile boolean aTi = false;
        private volatile boolean aTj = false;
        private LinkedList<Runnable> aTw = new LinkedList<>();
        private LinkedList<Runnable> aTx = new LinkedList<>();
        private TreeSet<d> aTy = new TreeSet<>();
        private boolean aTz = true;
        private V8Engine mV8Engine = null;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean aTt = true;
        private int aTs = 1;
        private boolean aTu = false;

        C0178a(a aVar) {
            this.aTB = aVar;
            this.aSW = aVar.aSW;
        }

        /* JADX WARN: Type inference failed for: r4v0, types: [com.baidu.smallgame.sdk.a, com.baidu.searchbox.v8engine.V8Engine, com.baidu.smallgame.sdk.a$b] */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("ARGLThread " + getId());
            if (this.aTB != null) {
                ArBridge Dd = this.aTB.Dd();
                if (Dd != null) {
                    Dd.setGLThreadID(getId());
                    Dd.smallGameOnInit();
                    this.aTB.initDisplayMetrics();
                } else {
                    Log.e("EngineLogger", "Render Engine Init Failed. ArBridge is null");
                }
            } else {
                Log.e("EngineLogger", "Render Engine Init Failed. AREngine is null");
            }
            try {
                Dh();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                this.aSW.b(this);
                this.aTA.reset();
                this.aTA = null;
                this.aTB = null;
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

        private void De() {
            if (this.aTp) {
                this.aTp = false;
                this.aTA.destroySurface();
            }
        }

        private void Df() {
            if (this.aTo) {
                this.aTA.finish();
                this.aTo = false;
                this.aSW.c(this);
            }
        }

        public boolean Dg() {
            return this.aTB.aSR.mFirstFrameFinished && ((float) (System.currentTimeMillis() - this.aTd)) > minFramesInterval();
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
            if (r26.aTA.Dm() == false) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:128:0x02d8, code lost:
            r10 = r26.aSW;
         */
        /* JADX WARN: Code restructure failed: missing block: B:129:0x02dc, code lost:
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:131:0x02de, code lost:
            r26.aTq = true;
            r26.aSW.notifyAll();
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
            r8 = r26.aTB;
         */
        /* JADX WARN: Code restructure failed: missing block: B:138:0x02f6, code lost:
            if (r8 == null) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:139:0x02f8, code lost:
            r8.aSU.onSurfaceCreated(null, null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:140:0x0301, code lost:
            r10 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:141:0x0303, code lost:
            if (r7 == false) goto L95;
         */
        /* JADX WARN: Code restructure failed: missing block: B:142:0x0305, code lost:
            r7 = r26.aTB;
         */
        /* JADX WARN: Code restructure failed: missing block: B:143:0x0309, code lost:
            if (r7 == null) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:144:0x030b, code lost:
            r7.aSU.onSurfaceChanged(null, r15, r14);
            r7.updateSurfaceViewSize(r15, r14);
         */
        /* JADX WARN: Code restructure failed: missing block: B:145:0x0318, code lost:
            r9 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:146:0x031a, code lost:
            r0 = r26.aTB;
            r18 = java.lang.System.currentTimeMillis();
            r20 = r18 - r26.aTc;
         */
        /* JADX WARN: Code restructure failed: missing block: B:147:0x0330, code lost:
            if (r0.aSV == false) goto L93;
         */
        /* JADX WARN: Code restructure failed: missing block: B:149:0x033b, code lost:
            if (((float) r20) < minFramesInterval()) goto L93;
         */
        /* JADX WARN: Code restructure failed: missing block: B:150:0x033d, code lost:
            r26.aTc = java.lang.System.currentTimeMillis();
         */
        /* JADX WARN: Code restructure failed: missing block: B:151:0x034b, code lost:
            if (r26.aTf != false) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:153:0x0351, code lost:
            if (r26.aTB == null) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:154:0x0353, code lost:
            r26.aTf = true;
            r26.aTB.eD("first_frame");
         */
        /* JADX WARN: Code restructure failed: missing block: B:155:0x0362, code lost:
            r0.aSU.onDrawFrame(null);
            Di();
         */
        /* JADX WARN: Code restructure failed: missing block: B:156:0x0379, code lost:
            if ((r18 - r26.aTe) <= 33) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:157:0x037b, code lost:
            r0.aSR.notifyFrameUpdated();
            r26.aTe = r18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:159:0x038c, code lost:
            if (r26.aTh == false) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:160:0x038e, code lost:
            r26.aTB.aSR.smallGameOnResume();
            r26.aTh = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:161:0x039e, code lost:
            r8 = r0.aSR.shouldSwapBuffer();
         */
        /* JADX WARN: Code restructure failed: missing block: B:162:0x03a6, code lost:
            if (r8 == false) goto L92;
         */
        /* JADX WARN: Code restructure failed: missing block: B:163:0x03a8, code lost:
            r7 = r26.aTA.Dn();
         */
        /* JADX WARN: Code restructure failed: missing block: B:164:0x03b0, code lost:
            switch(r7) {
                case 12288: goto L90;
                case 12302: goto L91;
                default: goto L71;
            };
         */
        /* JADX WARN: Code restructure failed: missing block: B:165:0x03b3, code lost:
            com.baidu.smallgame.sdk.a.b.b("EngineLogger", "eglSwapBuffers", r7);
            r7 = r26.aSW;
         */
        /* JADX WARN: Code restructure failed: missing block: B:166:0x03c4, code lost:
            monitor-enter(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:168:0x03c7, code lost:
            r26.aTm = true;
            r26.aSW.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:169:0x03d6, code lost:
            monitor-exit(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:170:0x03d7, code lost:
            r7 = r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:171:0x03d8, code lost:
            r26.aTd = java.lang.System.currentTimeMillis();
         */
        /* JADX WARN: Code restructure failed: missing block: B:172:0x03ee, code lost:
            if (r26.aTB.aSR.isRenderCallbackQueueEmpty() != false) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:173:0x03f0, code lost:
            if (r8 == false) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:174:0x03f2, code lost:
            r8 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:176:0x03fe, code lost:
            if ((r0.aSR.getStuckScreenHandler() instanceof com.baidu.smallgame.sdk.b) == false) goto L84;
         */
        /* JADX WARN: Code restructure failed: missing block: B:177:0x0400, code lost:
            ((com.baidu.smallgame.sdk.b) r0.aSR.getStuckScreenHandler()).b(r8, r26.aTd);
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
            r11 = r26.aSW;
         */
        /* JADX WARN: Code restructure failed: missing block: B:185:0x0431, code lost:
            monitor-enter(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:187:0x0433, code lost:
            r26.aTq = true;
            r26.aTm = true;
            r26.aSW.notifyAll();
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
            r0.aSV = true;
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
            if (r26.aTg != false) goto L106;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x008c, code lost:
            if (r26.aTB == null) goto L106;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x008e, code lost:
            r26.aTg = true;
            r26.aTB.eD("first_event");
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00a1, code lost:
            if (com.baidu.searchbox.v8engine.V8Engine.isDebug() == false) goto L111;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00a7, code lost:
            if (r26.aTB == null) goto L111;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00a9, code lost:
            r26.aTB.p(1, r13.toString());
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00b7, code lost:
            r13.run();
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void Dh() throws InterruptedException {
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
            this.aTA = new b(this.aTB);
            this.aTo = false;
            this.aTp = false;
            this.aTu = false;
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
                    synchronized (this.aSW) {
                        z = z19;
                        boolean z20 = z18;
                        boolean z21 = z16;
                        boolean z22 = z15;
                        boolean z23 = z14;
                        boolean z24 = z13;
                        runnable = runnable2;
                        while (!this.aTi) {
                            if (this.aTx.isEmpty()) {
                                if (ableToDraw()) {
                                    if (Dg()) {
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
                                        runnable = Dl();
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
                                if (this.mPaused != this.aTk) {
                                    z25 = this.aTk;
                                    this.mPaused = this.aTk;
                                    if (this.aTk) {
                                        this.aTh = false;
                                        this.aTB.aSR.smallGameOnPauseOnGLThrad();
                                    } else {
                                        this.aTh = true;
                                    }
                                    this.aSW.notifyAll();
                                    Log.i("EngineLogger", "mPaused is now " + this.mPaused + " tid=" + getId());
                                }
                                if (this.aTr) {
                                    De();
                                    Df();
                                    this.aTr = false;
                                    z = true;
                                }
                                if (z22) {
                                    De();
                                    Df();
                                    z22 = false;
                                }
                                if (z25 && this.aTp) {
                                    De();
                                }
                                if (!z25 || this.aTo) {
                                }
                                if (!this.aTl && !this.aTn) {
                                    if (this.aTp) {
                                        De();
                                    }
                                    this.aTn = true;
                                    this.aTm = false;
                                    this.aSW.notifyAll();
                                }
                                if (this.aTl && this.aTn) {
                                    this.aTn = false;
                                    this.aSW.notifyAll();
                                }
                                if (z20) {
                                    this.aTu = false;
                                    z9 = false;
                                    this.aTv = true;
                                    this.aSW.notifyAll();
                                } else {
                                    z9 = z20;
                                }
                                if (Dj()) {
                                    if (!this.aTo) {
                                        if (z) {
                                            z = false;
                                        } else {
                                            try {
                                                this.aTA.start();
                                                this.aTB.aSR.setEglContextToRecorder(this.aTB.getEGLContext(), 0, 0);
                                                this.aTo = true;
                                                z12 = true;
                                                this.aSW.notifyAll();
                                            } catch (RuntimeException e) {
                                                this.aSW.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.aTo || this.aTp) {
                                        z6 = z21;
                                        z10 = z23;
                                    } else {
                                        this.aTp = true;
                                        z24 = true;
                                        z6 = true;
                                        z10 = true;
                                    }
                                    if (this.aTp) {
                                        if (this.aTz) {
                                            z6 = true;
                                            i3 = this.mWidth;
                                            i4 = this.mHeight;
                                            this.aTu = true;
                                            z11 = true;
                                            this.aTz = false;
                                        } else {
                                            z11 = z24;
                                        }
                                        this.aTt = false;
                                        this.aSW.notifyAll();
                                        if (this.aTu) {
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
                                this.aSW.wait();
                                z20 = z9;
                            } else {
                                runnable = this.aTx.pollFirst();
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
                    synchronized (this.aSW) {
                        if (this.aTB != null) {
                            this.aTB.aSR.smallGameDestroy();
                        }
                        De();
                        Df();
                    }
                    return;
                } catch (Throwable th) {
                    synchronized (this.aSW) {
                        if (this.aTB != null) {
                            this.aTB.aSR.smallGameDestroy();
                        }
                        De();
                        Df();
                        throw th;
                    }
                }
            }
            if (V8Engine.isDebug() && this.aTB != null) {
                this.aTB.p(2, runnable.toString());
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

        private void Di() {
            this.aTa++;
            if (this.aTb != 0) {
                float currentTimeMillis = ((float) (System.currentTimeMillis() - this.aTb)) / 1000.0f;
                if (currentTimeMillis > 1.0f) {
                    this.aTB.dt((int) (this.aTa / currentTimeMillis));
                    this.aTa = 0;
                    this.aTb = System.currentTimeMillis();
                    return;
                }
                return;
            }
            this.aTb = System.currentTimeMillis();
        }

        public boolean ableToDraw() {
            return this.aTo && this.aTp && Dj();
        }

        private boolean Dj() {
            return !this.mPaused && this.aTl && !this.aTm && this.mWidth > 0 && this.mHeight > 0 && (this.aTt || this.aTs == 1);
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (this.aSW) {
                this.aTs = i;
                this.aSW.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (this.aSW) {
                i = this.aTs;
            }
            return i;
        }

        public void requestRender() {
            synchronized (this.aSW) {
                this.aTt = true;
                this.aSW.notifyAll();
            }
        }

        public void requestRenderAndWait() {
            synchronized (this.aSW) {
                if (Thread.currentThread() != this) {
                    this.aTu = true;
                    this.aTt = true;
                    this.aTv = false;
                    this.aSW.notifyAll();
                    while (!this.aTj && !this.mPaused && !this.aTv && ableToDraw()) {
                        try {
                            this.aSW.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void surfaceCreated() {
            synchronized (this.aSW) {
                this.aTl = true;
                this.aTq = false;
                this.aSW.notifyAll();
                while (this.aTn && !this.aTq && !this.aTj) {
                    try {
                        this.aSW.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (this.aSW) {
                this.aTl = false;
                this.aSW.notifyAll();
                while (!this.aTn && !this.aTj) {
                    try {
                        this.aSW.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (this.aSW) {
                Log.i("EngineLogger", "onPause tid=" + getId());
                this.aTk = true;
                if (this.aTB != null && (this.aTB.aSR.getStuckScreenHandler() instanceof com.baidu.smallgame.sdk.b)) {
                    ((com.baidu.smallgame.sdk.b) this.aTB.aSR.getStuckScreenHandler()).Dr();
                }
                this.aSW.notifyAll();
                while (!this.aTj && !this.mPaused) {
                    Log.i("Main thread", "onPause waiting for mPaused.");
                    try {
                        this.aSW.wait(500L);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (this.aSW) {
                Log.i("EngineLogger", "onResume tid=" + getId());
                this.aTk = false;
                this.aTt = true;
                this.aTv = false;
                this.aSW.notifyAll();
                while (!this.aTj && this.mPaused && !this.aTv) {
                    Log.i("Main thread", "onResume waiting for !mPaused.");
                    try {
                        this.aSW.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void N(int i, int i2) {
            synchronized (this.aSW) {
                this.mWidth = i;
                this.mHeight = i2;
                this.aTz = true;
                this.aTt = true;
                this.aTv = false;
                if (Thread.currentThread() != this) {
                    this.aSW.notifyAll();
                    while (!this.aTj && !this.mPaused && !this.aTv && ableToDraw()) {
                        try {
                            this.aSW.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void Dk() {
            synchronized (this.aSW) {
                this.aTi = true;
                this.aSW.notifyAll();
                while (!this.aTj) {
                    try {
                        this.aSW.wait();
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
            if (!this.aTi && !this.aTj) {
                synchronized (this.aSW) {
                    if (V8Engine.isDebug() && this.aTB != null) {
                        this.aTB.p(0, runnable.toString());
                    }
                    if (z || ableToDraw()) {
                        this.aTw.add(runnable);
                    } else {
                        this.aTx.add(runnable);
                    }
                    this.aSW.notifyAll();
                }
            }
        }

        public void a(Runnable runnable, long j) {
            if (runnable == null) {
                throw new IllegalArgumentException("r must not be null");
            }
            if (!this.aTi && !this.aTj) {
                synchronized (this.aSW) {
                    TreeSet<d> treeSet = this.aTy;
                    if (j <= 0) {
                        j = 0;
                    }
                    treeSet.add(new d(runnable, j));
                    this.aSW.notifyAll();
                }
            }
        }

        public void clearOldEvents() {
            synchronized (this.aSW) {
                this.aTw.clear();
                this.aTx.clear();
                this.aTy.clear();
            }
        }

        private Runnable Dl() {
            Runnable pollFirst;
            synchronized (this.aSW) {
                pollFirst = (this.aTy.isEmpty() || !this.aTy.first().isTimeout()) ? this.aTw.pollFirst() : this.aTy.pollFirst();
            }
            return pollFirst;
        }
    }

    /* loaded from: classes9.dex */
    public static class d implements Comparable<d>, Runnable {
        private final Runnable aTG;
        private final long mTimestamp;

        d(Runnable runnable, long j) {
            this.aTG = runnable;
            this.mTimestamp = System.currentTimeMillis() + j;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.aTG.run();
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
    /* loaded from: classes9.dex */
    public static class c {
        private static String TAG = "GLThreadManager";
        private C0178a aTF;

        private c() {
        }

        public synchronized void b(C0178a c0178a) {
            c0178a.aTj = true;
            if (this.aTF == c0178a) {
                this.aTF = null;
            }
            notifyAll();
        }

        public void c(C0178a c0178a) {
            if (this.aTF == c0178a) {
                this.aTF = null;
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class b {
        private a aTB;
        EGLDisplay aTC;
        EGLSurface aTD;
        EGLConfig aTE;
        EGLContext mEglContext;

        public b(a aVar) {
            this.aTB = aVar;
        }

        public void reset() {
            this.aTB = null;
        }

        public void start() {
            this.aTC = EGL14.eglGetDisplay(0);
            if (this.aTC == EGL14.EGL_NO_DISPLAY) {
                throw new RuntimeException("unable to get EGL14 display");
            }
            int[] iArr = new int[2];
            if (!EGL14.eglInitialize(this.aTC, iArr, 0, iArr, 1)) {
                this.aTC = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            a aVar = this.aTB;
            this.aTE = f(0, 0, false);
            this.mEglContext = EGL14.eglCreateContext(this.aTC, this.aTE, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
            this.aTB.mCurrentGLThreadID = Thread.currentThread().getId();
            if (this.mEglContext == null || this.mEglContext == EGL14.EGL_NO_CONTEXT) {
                this.mEglContext = null;
                eE("createContext");
            }
            this.aTD = null;
        }

        private EGLConfig f(int i, int i2, boolean z) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (EGL14.eglChooseConfig(this.aTC, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, z ? 16 : 0, 12326, 0, 12352, 4, 12344, 0, 12344}, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
                return eGLConfigArr[0];
            }
            Log.w("EngineLogger", "unable to find RGB8888 / " + i2 + " EGLConfig");
            return null;
        }

        public boolean Dm() {
            if (this.aTC == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.aTE == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            destroySurface();
            Object obj = this.aTB.mSurfaceHolder;
            if (obj == null) {
                obj = this.aTB.aSX;
            }
            if (obj != null) {
                this.aTD = EGL14.eglCreateWindowSurface(this.aTC, this.aTE, obj, new int[]{12344}, 0);
            } else {
                this.aTD = null;
            }
            if (this.aTD == null || this.aTD == EGL14.EGL_NO_SURFACE) {
                if (EGL14.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    return false;
                }
                return false;
            }
            return EGL14.eglMakeCurrent(this.aTC, this.aTD, this.aTD, this.mEglContext);
        }

        public int Dn() {
            return !EGL14.eglSwapBuffers(this.aTC, this.aTD) ? EGL14.eglGetError() : CommandMessage.COMMAND_BASE;
        }

        public void destroySurface() {
            if (this.aTD != null && this.aTD != EGL14.EGL_NO_SURFACE) {
                EGL14.eglMakeCurrent(this.aTC, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
                EGL14.eglDestroySurface(this.aTC, this.aTD);
                this.aTD = null;
            }
        }

        public void finish() {
            if (this.mEglContext != null) {
                EGL14.eglDestroyContext(this.aTC, this.mEglContext);
                this.mEglContext = null;
            }
            if (this.aTC != null) {
                EGL14.eglTerminate(this.aTC);
                this.aTC = null;
            }
            this.aTB.mCurrentGLThreadID = -1L;
        }

        private void eE(String str) {
            u(str, EGL14.eglGetError());
        }

        public static void u(String str, int i) {
            throw new RuntimeException(v(str, i));
        }

        public static void b(String str, String str2, int i) {
            Log.w(str, v(str2, i));
        }

        public static String v(String str, int i) {
            return str + " failed: " + i;
        }
    }
}
