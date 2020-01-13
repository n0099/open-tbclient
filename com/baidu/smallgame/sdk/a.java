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
/* loaded from: classes10.dex */
public final class a implements AREngineDelegate {
    public static PermissionProxy aTH = null;
    public static int aTI = 0;
    private ArBridge aTJ;
    private GLSurfaceView.Renderer aTM;
    private Object aTP;
    private C0180a aTQ;
    private Context mContext;
    private boolean mDetached;
    private SurfaceHolder mSurfaceHolder;
    private ArrayList<DebugConsole> mConsoles = null;
    private int mFPS = 0;
    private long mCurrentGLThreadID = -1;
    private float aTK = 0.0f;
    private float aTL = 0.0f;
    private boolean aTN = false;
    private final c aTO = new c();

    public Context getContext() {
        return this.mContext;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        Log.setMinLogLevel(6, false);
        this.aTJ = new ArBridge();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void startEngine() {
        if (this.aTM == null) {
            throw new NullPointerException("start render engine failed. because renderer is not set");
        }
        this.aTQ = new C0180a(this);
        this.aTQ.start();
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
    public void s(int i, String str) {
        if (this.mConsoles != null) {
            for (DebugConsole debugConsole : new ArrayList(this.mConsoles)) {
                debugConsole.onReceiveInfo(i, str);
            }
        }
    }

    public ArBridge Dz() {
        return this.aTJ;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public Thread getGLThread() {
        return this.aTQ;
    }

    void du(int i) {
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
        this.aTK = f;
        this.aTL = f2;
        this.aTJ.setSize(f, f2);
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
        if (this.aTK != 0.0f) {
            f = this.aTK;
        }
        if (this.aTL != 0.0f) {
            f2 = this.aTL;
        }
        if (this.aTJ != null) {
            this.aTJ.setDisplayMetrics(f, f2, displayMetrics.xdpi, displayMetrics.ydpi, displayMetrics.density);
        } else {
            Log.e("EngineLogger", "[RenderError] error init render display, because arbridge is null");
        }
    }

    public void c(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = (SurfaceHolder) new WeakReference(surfaceHolder).get();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderer(GLSurfaceView.Renderer renderer) {
        this.aTM = renderer;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderMode(int i) {
        if (this.aTQ != null) {
            this.aTQ.setRenderMode(i);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public int getRenderMode() {
        if (this.aTQ != null) {
            return this.aTQ.getRenderMode();
        }
        return 1;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRender() {
        if (this.aTQ != null) {
            this.aTQ.requestRender();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceCreated() {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceCreated.");
        this.aTQ.surfaceCreated();
        Context appContext = V8Engine.getAppContext();
        if (appContext != null) {
            aTI = ((WindowManager) appContext.getSystemService("window")).getDefaultDisplay().getRotation();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceDestroyed() {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceDestroyed.");
        this.aTQ.surfaceDestroyed();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceChanged(int i, int i2) {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceChanged. width=" + i + ", height=" + i2);
        this.aTQ.R(i, i2);
        this.aTJ.setEglContextToRecorder(getEGLContext(), i, i2);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRenderAndWait() {
        if (this.aTQ != null) {
            this.aTQ.requestRenderAndWait();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameOnPause() {
        this.aTJ.smallGameOnPause();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void runOnGLThread(Runnable runnable) {
        if (this.aTQ != null) {
            this.aTQ.runOnGLThread(runnable);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable) {
        if (this.aTQ != null) {
            this.aTQ.queueEvent(runnable);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable, long j) {
        if (this.aTQ != null) {
            this.aTQ.a(runnable, j);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onAttachedToWindow() {
        if (this.mDetached && this.aTM != null) {
            int renderMode = this.aTQ != null ? this.aTQ.getRenderMode() : 1;
            this.aTQ = new C0180a(this);
            if (renderMode != 1) {
                this.aTQ.setRenderMode(renderMode);
            }
            this.aTQ.start();
        }
        this.mDetached = false;
        Log.w("EngineLogger", "[V8Dispose][AREngine] onAttachedToWindow");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onDetachedFromWindow() {
        if (!this.mDetached && this.aTQ != null) {
            this.aTQ.DG();
        }
        this.mDetached = true;
        Log.w("EngineLogger", "[V8Dispose][AREngine] onDetachedFromWindow");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void clearOldEvents() {
        if (this.aTQ != null) {
            this.aTQ.clearOldEvents();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onPause() {
        if (this.aTQ != null) {
            this.aTQ.onPause();
        }
        if (this.aTJ.getGameRecorder() != null) {
            this.aTJ.getGameRecorder().An();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onResume() {
        if (this.aTQ != null) {
            this.aTQ.onResume();
        }
        if (this.aTJ.getGameRecorder() != null) {
            this.aTJ.getGameRecorder().Ao();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void pauseRecord() {
        if (this.aTJ.getGameRecorder() != null) {
            this.aTJ.getGameRecorder().pauseRecord();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void resumeRecord() {
        if (this.aTJ.getGameRecorder() != null) {
            this.aTJ.getGameRecorder().resumeRecord();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void stopRecord() {
        if (this.aTJ.getGameRecorder() != null) {
            this.aTJ.getGameRecorder().stopRecord();
            this.aTJ.nativeUpdateRecordingStatus(false);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (this.aTJ.getGameRecorder() != null) {
            this.aTJ.nativeUpdateRecordingStatus(true);
            this.aTJ.getGameRecorder().startRecord(z, i, str, z2);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setGameRecordCallback(com.baidu.mario.a.c cVar) {
        if (this.aTJ.getGameRecorder() != null) {
            this.aTJ.getGameRecorder().setGameRecordCallback(cVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setAudioEngineProxy(com.baidu.mario.a.a aVar) {
        if (this.aTJ.getGameRecorder() != null) {
            this.aTJ.getGameRecorder().setAudioEngineProxy(aVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public long getCurrentRecordProcess() {
        if (this.aTJ.getGameRecorder() != null) {
            return this.aTJ.getGameRecorder().Am();
        }
        return 0L;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setPermissionProxy(PermissionProxy permissionProxy) {
        aTH = permissionProxy;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setOnStuckScreenListener(com.baidu.smallgame.sdk.b.a aVar) {
        if (this.aTJ != null) {
            this.aTJ.setOnStuckScreenListener(aVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setStuckScreenLimitTime(long j) {
        if (this.aTJ != null) {
            this.aTJ.setStuckScreenLimitTime(j);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public com.baidu.smallgame.sdk.b.c getStuckScreenHandler() {
        if (this.aTJ == null) {
            return null;
        }
        return this.aTJ.getStuckScreenHandler();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameDestroy() {
        if (this.aTQ == null) {
            Log.e("EngineLogger", "Destroy AREngine fail. Because GLThread is null");
        } else {
            this.aTQ.runOnGLThread(new Runnable() { // from class: com.baidu.smallgame.sdk.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.aTQ.aUa = true;
                    a.this.aTJ.smallGameDestroy();
                }
            });
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public boolean ableToDraw() {
        return this.aTQ != null && this.aTQ.ableToDraw();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void exitGLThread() {
        if (this.aTQ != null) {
            this.aTQ.DG();
        }
        Log.e("EngineLogger", "[V8Dispose][AREngine] exitGLThread.");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameUpdate() {
        this.aTJ.smallGameUpdate();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setScreenShotStatus(boolean z) {
        this.aTJ.setScreenShotStatus(z);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public JSONArray getPerformanceJson() {
        return this.aTJ == null ? new JSONArray() : this.aTJ.getPerformanceJson();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public PerformanceJsonBean getPerformanceJsonBean() {
        return this.aTJ == null ? new PerformanceJsonBean() : this.aTJ.getPerformanceJsonBean();
    }

    public void eG(String str) {
        if (this.aTJ != null) {
            this.aTJ.getPerformanceJsonBean().put(str);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setFirstFrameListener(ArBridge.FirstFrameListener firstFrameListener) {
        this.aTJ.setFirstFrameListener(firstFrameListener);
    }

    public EGLContext getEGLContext() {
        if (this.aTQ == null || this.aTQ.aUs == null) {
            return null;
        }
        return this.aTQ.aUs.mEglContext;
    }

    protected void finalize() throws Throwable {
        try {
            if (this.aTQ != null) {
                this.aTQ.DG();
            }
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.smallgame.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0180a extends Thread {
        private c aTO;
        private boolean aUc;
        private boolean aUd;
        private boolean aUe;
        private boolean aUf;
        private boolean aUg;
        private boolean aUh;
        private boolean aUi;
        private boolean aUj;
        private boolean aUn;
        private b aUs;
        private a aUt;
        private boolean mPaused;
        private int aTS = 0;
        private long aTT = 0;
        private long aTU = 0;
        private long aTV = 0;
        private long aTW = 0;
        private boolean aTX = false;
        private boolean aTY = false;
        private boolean aTZ = false;
        private volatile boolean aUa = false;
        private volatile boolean aUb = false;
        private LinkedList<Runnable> aUo = new LinkedList<>();
        private LinkedList<Runnable> aUp = new LinkedList<>();
        private TreeSet<d> aUq = new TreeSet<>();
        private boolean aUr = true;
        private V8Engine mV8Engine = null;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean aUl = true;
        private int aUk = 1;
        private boolean aUm = false;

        C0180a(a aVar) {
            this.aUt = aVar;
            this.aTO = aVar.aTO;
        }

        /* JADX WARN: Type inference failed for: r4v0, types: [com.baidu.smallgame.sdk.a, com.baidu.searchbox.v8engine.V8Engine, com.baidu.smallgame.sdk.a$b] */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("ARGLThread " + getId());
            if (this.aUt != null) {
                ArBridge Dz = this.aUt.Dz();
                if (Dz != null) {
                    Dz.setGLThreadID(getId());
                    Dz.smallGameOnInit();
                    this.aUt.initDisplayMetrics();
                } else {
                    Log.e("EngineLogger", "Render Engine Init Failed. ArBridge is null");
                }
            } else {
                Log.e("EngineLogger", "Render Engine Init Failed. AREngine is null");
            }
            try {
                DD();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                this.aTO.b(this);
                this.aUs.reset();
                this.aUs = null;
                this.aUt = null;
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

        private void DA() {
            if (this.aUh) {
                this.aUh = false;
                this.aUs.destroySurface();
            }
        }

        private void DB() {
            if (this.aUg) {
                this.aUs.finish();
                this.aUg = false;
                this.aTO.c(this);
            }
        }

        public boolean DC() {
            return this.aUt.aTJ.mFirstFrameFinished && ((float) (System.currentTimeMillis() - this.aTV)) > minFramesInterval();
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
            if (r26.aUs.DI() == false) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:128:0x02d8, code lost:
            r10 = r26.aTO;
         */
        /* JADX WARN: Code restructure failed: missing block: B:129:0x02dc, code lost:
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:131:0x02de, code lost:
            r26.aUi = true;
            r26.aTO.notifyAll();
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
            r8 = r26.aUt;
         */
        /* JADX WARN: Code restructure failed: missing block: B:138:0x02f6, code lost:
            if (r8 == null) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:139:0x02f8, code lost:
            r8.aTM.onSurfaceCreated(null, null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:140:0x0301, code lost:
            r10 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:141:0x0303, code lost:
            if (r7 == false) goto L95;
         */
        /* JADX WARN: Code restructure failed: missing block: B:142:0x0305, code lost:
            r7 = r26.aUt;
         */
        /* JADX WARN: Code restructure failed: missing block: B:143:0x0309, code lost:
            if (r7 == null) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:144:0x030b, code lost:
            r7.aTM.onSurfaceChanged(null, r15, r14);
            r7.updateSurfaceViewSize(r15, r14);
         */
        /* JADX WARN: Code restructure failed: missing block: B:145:0x0318, code lost:
            r9 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:146:0x031a, code lost:
            r0 = r26.aUt;
            r18 = java.lang.System.currentTimeMillis();
            r20 = r18 - r26.aTU;
         */
        /* JADX WARN: Code restructure failed: missing block: B:147:0x0330, code lost:
            if (r0.aTN == false) goto L93;
         */
        /* JADX WARN: Code restructure failed: missing block: B:149:0x033b, code lost:
            if (((float) r20) < minFramesInterval()) goto L93;
         */
        /* JADX WARN: Code restructure failed: missing block: B:150:0x033d, code lost:
            r26.aTU = java.lang.System.currentTimeMillis();
         */
        /* JADX WARN: Code restructure failed: missing block: B:151:0x034b, code lost:
            if (r26.aTX != false) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:153:0x0351, code lost:
            if (r26.aUt == null) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:154:0x0353, code lost:
            r26.aTX = true;
            r26.aUt.eG("first_frame");
         */
        /* JADX WARN: Code restructure failed: missing block: B:155:0x0362, code lost:
            r0.aTM.onDrawFrame(null);
            DE();
         */
        /* JADX WARN: Code restructure failed: missing block: B:156:0x0379, code lost:
            if ((r18 - r26.aTW) <= 33) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:157:0x037b, code lost:
            r0.aTJ.notifyFrameUpdated();
            r26.aTW = r18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:159:0x038c, code lost:
            if (r26.aTZ == false) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:160:0x038e, code lost:
            r26.aUt.aTJ.smallGameOnResume();
            r26.aTZ = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:161:0x039e, code lost:
            r8 = r0.aTJ.shouldSwapBuffer();
         */
        /* JADX WARN: Code restructure failed: missing block: B:162:0x03a6, code lost:
            if (r8 == false) goto L92;
         */
        /* JADX WARN: Code restructure failed: missing block: B:163:0x03a8, code lost:
            r7 = r26.aUs.DJ();
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
            r7 = r26.aTO;
         */
        /* JADX WARN: Code restructure failed: missing block: B:166:0x03c4, code lost:
            monitor-enter(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:168:0x03c7, code lost:
            r26.aUe = true;
            r26.aTO.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:169:0x03d6, code lost:
            monitor-exit(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:170:0x03d7, code lost:
            r7 = r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:171:0x03d8, code lost:
            r26.aTV = java.lang.System.currentTimeMillis();
         */
        /* JADX WARN: Code restructure failed: missing block: B:172:0x03ee, code lost:
            if (r26.aUt.aTJ.isRenderCallbackQueueEmpty() != false) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:173:0x03f0, code lost:
            if (r8 == false) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:174:0x03f2, code lost:
            r8 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:176:0x03fe, code lost:
            if ((r0.aTJ.getStuckScreenHandler() instanceof com.baidu.smallgame.sdk.b) == false) goto L84;
         */
        /* JADX WARN: Code restructure failed: missing block: B:177:0x0400, code lost:
            ((com.baidu.smallgame.sdk.b) r0.aTJ.getStuckScreenHandler()).b(r8, r26.aTV);
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
            r11 = r26.aTO;
         */
        /* JADX WARN: Code restructure failed: missing block: B:185:0x0431, code lost:
            monitor-enter(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:187:0x0433, code lost:
            r26.aUi = true;
            r26.aUe = true;
            r26.aTO.notifyAll();
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
            r0.aTN = true;
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
            if (r26.aTY != false) goto L106;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x008c, code lost:
            if (r26.aUt == null) goto L106;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x008e, code lost:
            r26.aTY = true;
            r26.aUt.eG("first_event");
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00a1, code lost:
            if (com.baidu.searchbox.v8engine.V8Engine.isDebug() == false) goto L111;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00a7, code lost:
            if (r26.aUt == null) goto L111;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00a9, code lost:
            r26.aUt.s(1, r13.toString());
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00b7, code lost:
            r13.run();
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void DD() throws InterruptedException {
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
            this.aUs = new b(this.aUt);
            this.aUg = false;
            this.aUh = false;
            this.aUm = false;
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
                    synchronized (this.aTO) {
                        z = z19;
                        boolean z20 = z18;
                        boolean z21 = z16;
                        boolean z22 = z15;
                        boolean z23 = z14;
                        boolean z24 = z13;
                        runnable = runnable2;
                        while (!this.aUa) {
                            if (this.aUp.isEmpty()) {
                                if (ableToDraw()) {
                                    if (DC()) {
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
                                        runnable = DH();
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
                                if (this.mPaused != this.aUc) {
                                    z25 = this.aUc;
                                    this.mPaused = this.aUc;
                                    if (this.aUc) {
                                        this.aTZ = false;
                                        this.aUt.aTJ.smallGameOnPauseOnGLThrad();
                                    } else {
                                        this.aTZ = true;
                                    }
                                    this.aTO.notifyAll();
                                    Log.i("EngineLogger", "mPaused is now " + this.mPaused + " tid=" + getId());
                                }
                                if (this.aUj) {
                                    DA();
                                    DB();
                                    this.aUj = false;
                                    z = true;
                                }
                                if (z22) {
                                    DA();
                                    DB();
                                    z22 = false;
                                }
                                if (z25 && this.aUh) {
                                    DA();
                                }
                                if (!z25 || this.aUg) {
                                }
                                if (!this.aUd && !this.aUf) {
                                    if (this.aUh) {
                                        DA();
                                    }
                                    this.aUf = true;
                                    this.aUe = false;
                                    this.aTO.notifyAll();
                                }
                                if (this.aUd && this.aUf) {
                                    this.aUf = false;
                                    this.aTO.notifyAll();
                                }
                                if (z20) {
                                    this.aUm = false;
                                    z9 = false;
                                    this.aUn = true;
                                    this.aTO.notifyAll();
                                } else {
                                    z9 = z20;
                                }
                                if (DF()) {
                                    if (!this.aUg) {
                                        if (z) {
                                            z = false;
                                        } else {
                                            try {
                                                this.aUs.start();
                                                this.aUt.aTJ.setEglContextToRecorder(this.aUt.getEGLContext(), 0, 0);
                                                this.aUg = true;
                                                z12 = true;
                                                this.aTO.notifyAll();
                                            } catch (RuntimeException e) {
                                                this.aTO.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (!this.aUg || this.aUh) {
                                        z6 = z21;
                                        z10 = z23;
                                    } else {
                                        this.aUh = true;
                                        z24 = true;
                                        z6 = true;
                                        z10 = true;
                                    }
                                    if (this.aUh) {
                                        if (this.aUr) {
                                            z6 = true;
                                            i3 = this.mWidth;
                                            i4 = this.mHeight;
                                            this.aUm = true;
                                            z11 = true;
                                            this.aUr = false;
                                        } else {
                                            z11 = z24;
                                        }
                                        this.aUl = false;
                                        this.aTO.notifyAll();
                                        if (this.aUm) {
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
                                this.aTO.wait();
                                z20 = z9;
                            } else {
                                runnable = this.aUp.pollFirst();
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
                    synchronized (this.aTO) {
                        if (this.aUt != null) {
                            this.aUt.aTJ.smallGameDestroy();
                        }
                        DA();
                        DB();
                    }
                    return;
                } catch (Throwable th) {
                    synchronized (this.aTO) {
                        if (this.aUt != null) {
                            this.aUt.aTJ.smallGameDestroy();
                        }
                        DA();
                        DB();
                        throw th;
                    }
                }
            }
            if (V8Engine.isDebug() && this.aUt != null) {
                this.aUt.s(2, runnable.toString());
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

        private void DE() {
            this.aTS++;
            if (this.aTT != 0) {
                float currentTimeMillis = ((float) (System.currentTimeMillis() - this.aTT)) / 1000.0f;
                if (currentTimeMillis > 1.0f) {
                    this.aUt.du((int) (this.aTS / currentTimeMillis));
                    this.aTS = 0;
                    this.aTT = System.currentTimeMillis();
                    return;
                }
                return;
            }
            this.aTT = System.currentTimeMillis();
        }

        public boolean ableToDraw() {
            return this.aUg && this.aUh && DF();
        }

        private boolean DF() {
            return !this.mPaused && this.aUd && !this.aUe && this.mWidth > 0 && this.mHeight > 0 && (this.aUl || this.aUk == 1);
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (this.aTO) {
                this.aUk = i;
                this.aTO.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (this.aTO) {
                i = this.aUk;
            }
            return i;
        }

        public void requestRender() {
            synchronized (this.aTO) {
                this.aUl = true;
                this.aTO.notifyAll();
            }
        }

        public void requestRenderAndWait() {
            synchronized (this.aTO) {
                if (Thread.currentThread() != this) {
                    this.aUm = true;
                    this.aUl = true;
                    this.aUn = false;
                    this.aTO.notifyAll();
                    while (!this.aUb && !this.mPaused && !this.aUn && ableToDraw()) {
                        try {
                            this.aTO.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void surfaceCreated() {
            synchronized (this.aTO) {
                this.aUd = true;
                this.aUi = false;
                this.aTO.notifyAll();
                while (this.aUf && !this.aUi && !this.aUb) {
                    try {
                        this.aTO.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (this.aTO) {
                this.aUd = false;
                this.aTO.notifyAll();
                while (!this.aUf && !this.aUb) {
                    try {
                        this.aTO.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (this.aTO) {
                Log.i("EngineLogger", "onPause tid=" + getId());
                this.aUc = true;
                if (this.aUt != null && (this.aUt.aTJ.getStuckScreenHandler() instanceof com.baidu.smallgame.sdk.b)) {
                    ((com.baidu.smallgame.sdk.b) this.aUt.aTJ.getStuckScreenHandler()).DN();
                }
                this.aTO.notifyAll();
                while (!this.aUb && !this.mPaused) {
                    Log.i("Main thread", "onPause waiting for mPaused.");
                    try {
                        this.aTO.wait(500L);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (this.aTO) {
                Log.i("EngineLogger", "onResume tid=" + getId());
                this.aUc = false;
                this.aUl = true;
                this.aUn = false;
                this.aTO.notifyAll();
                while (!this.aUb && this.mPaused && !this.aUn) {
                    Log.i("Main thread", "onResume waiting for !mPaused.");
                    try {
                        this.aTO.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void R(int i, int i2) {
            synchronized (this.aTO) {
                this.mWidth = i;
                this.mHeight = i2;
                this.aUr = true;
                this.aUl = true;
                this.aUn = false;
                if (Thread.currentThread() != this) {
                    this.aTO.notifyAll();
                    while (!this.aUb && !this.mPaused && !this.aUn && ableToDraw()) {
                        try {
                            this.aTO.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void DG() {
            synchronized (this.aTO) {
                this.aUa = true;
                this.aTO.notifyAll();
                while (!this.aUb) {
                    try {
                        this.aTO.wait();
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
            if (!this.aUa && !this.aUb) {
                synchronized (this.aTO) {
                    if (V8Engine.isDebug() && this.aUt != null) {
                        this.aUt.s(0, runnable.toString());
                    }
                    if (z || ableToDraw()) {
                        this.aUo.add(runnable);
                    } else {
                        this.aUp.add(runnable);
                    }
                    this.aTO.notifyAll();
                }
            }
        }

        public void a(Runnable runnable, long j) {
            if (runnable == null) {
                throw new IllegalArgumentException("r must not be null");
            }
            if (!this.aUa && !this.aUb) {
                synchronized (this.aTO) {
                    TreeSet<d> treeSet = this.aUq;
                    if (j <= 0) {
                        j = 0;
                    }
                    treeSet.add(new d(runnable, j));
                    this.aTO.notifyAll();
                }
            }
        }

        public void clearOldEvents() {
            synchronized (this.aTO) {
                this.aUo.clear();
                this.aUp.clear();
                this.aUq.clear();
            }
        }

        private Runnable DH() {
            Runnable pollFirst;
            synchronized (this.aTO) {
                pollFirst = (this.aUq.isEmpty() || !this.aUq.first().isTimeout()) ? this.aUo.pollFirst() : this.aUq.pollFirst();
            }
            return pollFirst;
        }
    }

    /* loaded from: classes10.dex */
    public static class d implements Comparable<d>, Runnable {
        private final Runnable aUy;
        private final long mTimestamp;

        d(Runnable runnable, long j) {
            this.aUy = runnable;
            this.mTimestamp = System.currentTimeMillis() + j;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.aUy.run();
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
        private C0180a aUx;

        private c() {
        }

        public synchronized void b(C0180a c0180a) {
            c0180a.aUb = true;
            if (this.aUx == c0180a) {
                this.aUx = null;
            }
            notifyAll();
        }

        public void c(C0180a c0180a) {
            if (this.aUx == c0180a) {
                this.aUx = null;
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class b {
        private a aUt;
        EGLDisplay aUu;
        EGLSurface aUv;
        EGLConfig aUw;
        EGLContext mEglContext;

        public b(a aVar) {
            this.aUt = aVar;
        }

        public void reset() {
            this.aUt = null;
        }

        public void start() {
            this.aUu = EGL14.eglGetDisplay(0);
            if (this.aUu == EGL14.EGL_NO_DISPLAY) {
                throw new RuntimeException("unable to get EGL14 display");
            }
            int[] iArr = new int[2];
            if (!EGL14.eglInitialize(this.aUu, iArr, 0, iArr, 1)) {
                this.aUu = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            a aVar = this.aUt;
            this.aUw = f(0, 0, false);
            this.mEglContext = EGL14.eglCreateContext(this.aUu, this.aUw, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
            this.aUt.mCurrentGLThreadID = Thread.currentThread().getId();
            if (this.mEglContext == null || this.mEglContext == EGL14.EGL_NO_CONTEXT) {
                this.mEglContext = null;
                eH("createContext");
            }
            this.aUv = null;
        }

        private EGLConfig f(int i, int i2, boolean z) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (EGL14.eglChooseConfig(this.aUu, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, z ? 16 : 0, 12326, 0, 12352, 4, 12344, 0, 12344}, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
                return eGLConfigArr[0];
            }
            Log.w("EngineLogger", "unable to find RGB8888 / " + i2 + " EGLConfig");
            return null;
        }

        public boolean DI() {
            if (this.aUu == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.aUw == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            destroySurface();
            Object obj = this.aUt.mSurfaceHolder;
            if (obj == null) {
                obj = this.aUt.aTP;
            }
            if (obj != null) {
                this.aUv = EGL14.eglCreateWindowSurface(this.aUu, this.aUw, obj, new int[]{12344}, 0);
            } else {
                this.aUv = null;
            }
            if (this.aUv == null || this.aUv == EGL14.EGL_NO_SURFACE) {
                if (EGL14.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    return false;
                }
                return false;
            }
            return EGL14.eglMakeCurrent(this.aUu, this.aUv, this.aUv, this.mEglContext);
        }

        public int DJ() {
            return !EGL14.eglSwapBuffers(this.aUu, this.aUv) ? EGL14.eglGetError() : CommandMessage.COMMAND_BASE;
        }

        public void destroySurface() {
            if (this.aUv != null && this.aUv != EGL14.EGL_NO_SURFACE) {
                EGL14.eglMakeCurrent(this.aUu, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
                EGL14.eglDestroySurface(this.aUu, this.aUv);
                this.aUv = null;
            }
        }

        public void finish() {
            if (this.mEglContext != null) {
                EGL14.eglDestroyContext(this.aUu, this.mEglContext);
                this.mEglContext = null;
            }
            if (this.aUu != null) {
                EGL14.eglTerminate(this.aUu);
                this.aUu = null;
            }
            this.aUt.mCurrentGLThreadID = -1L;
        }

        private void eH(String str) {
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
