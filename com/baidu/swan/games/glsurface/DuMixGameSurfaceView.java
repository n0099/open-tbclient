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
/* loaded from: classes11.dex */
public class DuMixGameSurfaceView extends SurfaceView implements SurfaceHolder.Callback2, ArBridge.FirstFrameListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private AREngineDelegate cNE;
    private com.baidu.swan.games.e.a cNF;
    private com.baidu.swan.games.glsurface.a.a cNG;
    private volatile b cNH;
    private boolean cNI;
    private GameRecorderController cNJ;
    private int mDrawHeight;
    private int mDrawWidth;

    /* loaded from: classes11.dex */
    public interface b {
        void b(int[] iArr, int i, int i2);
    }

    static {
        d.ayw();
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
        f.lb("preload").f(new UbcFlowEvent("na_game_engine_start"));
        this.cNE = MarioSDK.createAREngine(aVar);
        this.cNE.setPermissionProxy(new e());
        this.cNE.setOnStuckScreenListener(new com.baidu.smallgame.sdk.b.a() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.1
            @Override // com.baidu.smallgame.sdk.b.a
            public void a(com.baidu.smallgame.sdk.b.b bVar) {
                com.baidu.swan.games.w.b.b(bVar);
            }

            @Override // com.baidu.smallgame.sdk.b.a
            public void NX() {
                com.baidu.swan.games.glsurface.a.b.awL();
            }
        });
        this.cNE.startEngine();
        f.lb("preload").f(new UbcFlowEvent("na_game_engine_end"));
        this.cNG = new com.baidu.swan.games.glsurface.a.a();
        this.cNJ = new GameRecorderController(this.cNE);
        com.baidu.swan.games.screenrecord.d.axE().g(this.cNJ);
    }

    private void setRenderer(GLSurfaceView.Renderer renderer) {
        if (this.cNE != null) {
            this.cNE.setRenderer(renderer);
        }
    }

    public void setRenderMode(int i) {
        if (this.cNE != null) {
            this.cNE.setRenderMode(i);
        }
    }

    public int getFPS() {
        if (this.cNE == null) {
            return 0;
        }
        return this.cNE.getFPS();
    }

    public void awF() {
        Pair<Integer, Integer> aey = com.baidu.swan.apps.y.f.aeK().aey();
        if (this.cNE != null) {
            this.cNE.updateSurfaceViewSize(((Integer) aey.first).intValue(), ((Integer) aey.second).intValue());
            this.cNE.initDisplayMetrics();
        }
        if (this.cNG != null) {
            this.cNG.ap(((Integer) aey.first).intValue(), ((Integer) aey.second).intValue());
        }
    }

    public void awG() {
        surfaceChanged(getHolder(), 0, getWidth(), getHeight());
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return this.cNF;
    }

    public void setV8Engine(com.baidu.swan.games.e.a aVar) {
        this.cNF = aVar;
        this.cNG.setV8Engine(this.cNF);
    }

    public Thread getThread() {
        if (this.cNE != null) {
            return this.cNE.getGLThread();
        }
        return null;
    }

    public int getRenderMode() {
        if (this.cNE != null) {
            return this.cNE.getRenderMode();
        }
        return 1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceCreated");
        }
        if (this.cNE != null) {
            this.cNE.surfaceCreated();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceChanged width: " + i2 + ", height: " + i3);
        }
        if (this.cNE != null) {
            this.cNE.surfaceChanged(i2, i3);
        }
        if (this.cNG != null) {
            this.cNG.aq(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceDestroyed width");
        }
        awH();
        if (this.cNE != null) {
            this.cNE.surfaceDestroyed();
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        if (this.cNE != null) {
            this.cNE.requestRenderAndWait();
        }
    }

    public void onPause() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_PAUSE);
        }
        queueEvent(new Runnable() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                if (DuMixGameSurfaceView.this.cNE != null) {
                    DuMixGameSurfaceView.this.cNE.smallGameOnPause();
                }
            }
        });
        if (this.cNE != null) {
            this.cNE.onPause();
        }
        com.baidu.swan.games.screenrecord.d.axE().axH();
    }

    public void onResume() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_RESUME);
        }
        if (this.cNE != null) {
            this.cNE.onResume();
        }
        com.baidu.swan.games.screenrecord.d.axE().axI();
    }

    public void onDestroy() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_DESTROY);
        }
        awH();
        com.baidu.swan.games.screenrecord.d.axE().h(this.cNJ);
        if (this.cNE != null) {
            this.cNE.setFirstFrameListener(null);
            this.cNE.setOnStuckScreenListener(null);
            this.cNE.smallGameDestroy();
        }
    }

    public void d(V8ExceptionInfo v8ExceptionInfo) {
        if (this.cNE != null && this.cNE.getStuckScreenHandler() != null) {
            this.cNE.getStuckScreenHandler().a(0, v8ExceptionInfo);
        }
    }

    public void runOnGLThread(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "runOnGLThread");
        }
        if (this.cNE != null) {
            this.cNE.runOnGLThread(runnable);
        }
    }

    public void queueEvent(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent");
        }
        if (this.cNE != null) {
            this.cNE.queueEvent(runnable);
        }
    }

    public void queueEvent(Runnable runnable, long j) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent delayed");
        }
        if (this.cNE != null) {
            this.cNE.queueEvent(runnable, j);
        }
    }

    public void clearOldEvents() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "executeQueueEvent");
        }
        if (this.cNE != null) {
            this.cNE.clearOldEvents();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.cNE != null) {
            this.cNE.onAttachedToWindow();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDetachedFromWindow");
        }
        if (this.cNE != null) {
            this.cNE.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cNG.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void finalize() throws Throwable {
        if (this.cNE != null) {
            this.cNE.setFirstFrameListener(null);
            this.cNE.setOnStuckScreenListener(null);
            this.cNE.exitGLThread();
            this.cNE = null;
        }
    }

    private void awH() {
        this.mDrawHeight = 0;
        this.mDrawWidth = 0;
    }

    @Override // com.baidu.smallgame.sdk.ArBridge.FirstFrameListener
    public void onFirstFrameFinished() {
        awI();
        SwanAppActivity aev = com.baidu.swan.apps.y.f.aeK().aev();
        if (aev != null) {
            c On = aev.On();
            if (On instanceof com.baidu.swan.games.i.b) {
                ((com.baidu.swan.games.i.b) On).onFirstFrameFinished();
            }
        }
    }

    public void awI() {
        if (this.cNF != null) {
            com.baidu.swan.games.u.d.G(this.cNF.getPerformanceJson());
        }
        if (this.cNE != null) {
            com.baidu.swan.games.u.d.G(this.cNE.getPerformanceJson());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
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
            if (DuMixGameSurfaceView.this.cNE != null) {
                DuMixGameSurfaceView.this.cNE.smallGameUpdate();
                if (DuMixGameSurfaceView.this.cNH != null) {
                    if (DuMixGameSurfaceView.this.cNI) {
                        DuMixGameSurfaceView.this.cNH.b(DuMixGameSurfaceView.this.getScreenShot(), DuMixGameSurfaceView.this.mDrawWidth, DuMixGameSurfaceView.this.mDrawHeight);
                        DuMixGameSurfaceView.this.cNE.setScreenShotStatus(false);
                        DuMixGameSurfaceView.this.cNI = false;
                        DuMixGameSurfaceView.this.cNH = null;
                    }
                    if (DuMixGameSurfaceView.this.cNH != null) {
                        DuMixGameSurfaceView.this.cNE.setScreenShotStatus(true);
                        DuMixGameSurfaceView.this.cNI = true;
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
