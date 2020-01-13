package com.baidu.swan.games.glsurface;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.smallgame.sdk.ArBridge;
import com.baidu.smallgame.sdk.MarioSDK;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.framework.c;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.f;
import com.baidu.swan.games.e.c.e;
import com.baidu.swan.games.screenrecord.GameRecorderController;
import com.baidu.swan.games.utils.so.d;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes10.dex */
public class DuMixGameSurfaceView extends SurfaceView implements SurfaceHolder.Callback2, ArBridge.FirstFrameListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private AREngineDelegate ckq;
    private com.baidu.swan.games.e.a ckr;
    private com.baidu.swan.games.glsurface.a.a cks;
    private volatile b ckt;
    private boolean cku;
    private GameRecorderController ckv;
    private int mDrawHeight;
    private int mDrawWidth;

    /* loaded from: classes10.dex */
    public interface b {
        void b(int[] iArr, int i, int i2);
    }

    static {
        d.anR();
    }

    public DuMixGameSurfaceView(Context context) {
        super(context);
        init();
    }

    public DuMixGameSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "init");
        }
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        MarioSDK.a aVar = new MarioSDK.a();
        aVar.c(holder);
        aVar.setFirstFrameListener(this);
        aVar.setRenderer(new a());
        aVar.setContext(AppRuntime.getAppContext());
        aVar.addDebugConsole(new com.baidu.swan.games.glsurface.a());
        f.jA("preload").f(new UbcFlowEvent("na_game_engine_start"));
        this.ckq = MarioSDK.createAREngine(aVar);
        this.ckq.setPermissionProxy(new e());
        this.ckq.setOnStuckScreenListener(new com.baidu.smallgame.sdk.b.a() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.1
            @Override // com.baidu.smallgame.sdk.b.a
            public void a(com.baidu.smallgame.sdk.b.b bVar) {
                com.baidu.swan.games.w.b.b(bVar);
            }

            @Override // com.baidu.smallgame.sdk.b.a
            public void DO() {
                com.baidu.swan.games.glsurface.a.b.amg();
            }
        });
        this.ckq.startEngine();
        f.jA("preload").f(new UbcFlowEvent("na_game_engine_end"));
        this.cks = new com.baidu.swan.games.glsurface.a.a();
        this.ckv = new GameRecorderController(this.ckq);
        com.baidu.swan.games.screenrecord.d.amZ().g(this.ckv);
    }

    private void setRenderer(GLSurfaceView.Renderer renderer) {
        if (this.ckq != null) {
            this.ckq.setRenderer(renderer);
        }
    }

    public void setRenderMode(int i) {
        if (this.ckq != null) {
            this.ckq.setRenderMode(i);
        }
    }

    public int getFPS() {
        if (this.ckq == null) {
            return 0;
        }
        return this.ckq.getFPS();
    }

    public void ama() {
        Pair<Integer, Integer> Uq = com.baidu.swan.apps.y.f.UC().Uq();
        if (this.ckq != null) {
            this.ckq.updateSurfaceViewSize(((Integer) Uq.first).intValue(), ((Integer) Uq.second).intValue());
            this.ckq.initDisplayMetrics();
        }
        if (this.cks != null) {
            this.cks.am(((Integer) Uq.first).intValue(), ((Integer) Uq.second).intValue());
        }
    }

    public void amb() {
        surfaceChanged(getHolder(), 0, getWidth(), getHeight());
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return this.ckr;
    }

    public void setV8Engine(com.baidu.swan.games.e.a aVar) {
        this.ckr = aVar;
        this.cks.setV8Engine(this.ckr);
    }

    public Thread getThread() {
        if (this.ckq != null) {
            return this.ckq.getGLThread();
        }
        return null;
    }

    public int getRenderMode() {
        if (this.ckq != null) {
            return this.ckq.getRenderMode();
        }
        return 1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceCreated");
        }
        if (this.ckq != null) {
            this.ckq.surfaceCreated();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceChanged width: " + i2 + ", height: " + i3);
        }
        if (this.ckq != null) {
            this.ckq.surfaceChanged(i2, i3);
        }
        if (this.cks != null) {
            this.cks.an(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceDestroyed width");
        }
        amc();
        if (this.ckq != null) {
            this.ckq.surfaceDestroyed();
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        if (this.ckq != null) {
            this.ckq.requestRenderAndWait();
        }
    }

    public void onPause() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_PAUSE);
        }
        queueEvent(new Runnable() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                if (DuMixGameSurfaceView.this.ckq != null) {
                    DuMixGameSurfaceView.this.ckq.smallGameOnPause();
                }
            }
        });
        if (this.ckq != null) {
            this.ckq.onPause();
        }
        com.baidu.swan.games.screenrecord.d.amZ().anc();
    }

    public void onResume() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_RESUME);
        }
        if (this.ckq != null) {
            this.ckq.onResume();
        }
        com.baidu.swan.games.screenrecord.d.amZ().and();
    }

    public void onDestroy() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_DESTROY);
        }
        amc();
        com.baidu.swan.games.screenrecord.d.amZ().h(this.ckv);
        if (this.ckq != null) {
            this.ckq.setFirstFrameListener(null);
            this.ckq.setOnStuckScreenListener(null);
            this.ckq.smallGameDestroy();
        }
    }

    public void d(V8ExceptionInfo v8ExceptionInfo) {
        if (this.ckq != null && this.ckq.getStuckScreenHandler() != null) {
            this.ckq.getStuckScreenHandler().a(0, v8ExceptionInfo);
        }
    }

    public void runOnGLThread(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "runOnGLThread");
        }
        if (this.ckq != null) {
            this.ckq.runOnGLThread(runnable);
        }
    }

    public void queueEvent(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent");
        }
        if (this.ckq != null) {
            this.ckq.queueEvent(runnable);
        }
    }

    public void queueEvent(Runnable runnable, long j) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent delayed");
        }
        if (this.ckq != null) {
            this.ckq.queueEvent(runnable, j);
        }
    }

    public void clearOldEvents() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "executeQueueEvent");
        }
        if (this.ckq != null) {
            this.ckq.clearOldEvents();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.ckq != null) {
            this.ckq.onAttachedToWindow();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDetachedFromWindow");
        }
        if (this.ckq != null) {
            this.ckq.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cks.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void finalize() throws Throwable {
        if (this.ckq != null) {
            this.ckq.setFirstFrameListener(null);
            this.ckq.setOnStuckScreenListener(null);
            this.ckq.exitGLThread();
            this.ckq = null;
        }
    }

    private void amc() {
        this.mDrawHeight = 0;
        this.mDrawWidth = 0;
    }

    @Override // com.baidu.smallgame.sdk.ArBridge.FirstFrameListener
    public void onFirstFrameFinished() {
        amd();
        SwanAppActivity Un = com.baidu.swan.apps.y.f.UC().Un();
        if (Un != null) {
            c Ee = Un.Ee();
            if (Ee instanceof com.baidu.swan.games.i.b) {
                ((com.baidu.swan.games.i.b) Ee).onFirstFrameFinished();
            }
        }
    }

    public void amd() {
        if (this.ckr != null) {
            com.baidu.swan.games.u.d.F(this.ckr.getPerformanceJson());
        }
        if (this.ckq != null) {
            com.baidu.swan.games.u.d.F(this.ckq.getPerformanceJson());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a implements GLSurfaceView.Renderer {
        a() {
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            if (DuMixGameSurfaceView.DEBUG) {
                Log.d("DuMixGameSurfaceView", "AiWebRender onSurfaceCreated !!!");
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            DuMixGameSurfaceView.this.mDrawWidth = i;
            DuMixGameSurfaceView.this.mDrawHeight = i2;
            if (DuMixGameSurfaceView.DEBUG) {
                Log.d("DuMixGameSurfaceView", "AiWebRender onSurfaceChanged width * height = " + i + " * " + i2);
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (DuMixGameSurfaceView.DEBUG) {
                Log.d("DuMixGameSurfaceView", "AiWebRender onDrawFrame !!!");
            }
            if (DuMixGameSurfaceView.this.ckq != null) {
                DuMixGameSurfaceView.this.ckq.smallGameUpdate();
                if (DuMixGameSurfaceView.this.ckt != null) {
                    if (DuMixGameSurfaceView.this.cku) {
                        DuMixGameSurfaceView.this.ckt.b(DuMixGameSurfaceView.this.getScreenShot(), DuMixGameSurfaceView.this.mDrawWidth, DuMixGameSurfaceView.this.mDrawHeight);
                        DuMixGameSurfaceView.this.ckq.setScreenShotStatus(false);
                        DuMixGameSurfaceView.this.cku = false;
                        DuMixGameSurfaceView.this.ckt = null;
                    }
                    if (DuMixGameSurfaceView.this.ckt != null) {
                        DuMixGameSurfaceView.this.ckq.setScreenShotStatus(true);
                        DuMixGameSurfaceView.this.cku = true;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] getScreenShot() {
        if (this.mDrawWidth <= 0 || this.mDrawHeight <= 0) {
            return null;
        }
        try {
            int[] iArr = new int[this.mDrawWidth * this.mDrawHeight];
            IntBuffer wrap = IntBuffer.wrap(iArr);
            wrap.position(0);
            GLES20.glReadPixels(0, 0, this.mDrawWidth, this.mDrawHeight, 6408, 5121, wrap);
            return iArr;
        } catch (OutOfMemoryError e) {
            return null;
        }
    }
}
