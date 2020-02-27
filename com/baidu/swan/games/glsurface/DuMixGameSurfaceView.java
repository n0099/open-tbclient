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
    private AREngineDelegate cou;
    private com.baidu.swan.games.e.a cov;
    private com.baidu.swan.games.glsurface.a.a cow;
    private volatile b cox;
    private boolean coy;
    private GameRecorderController coz;
    private int mDrawHeight;
    private int mDrawWidth;

    /* loaded from: classes11.dex */
    public interface b {
        void b(int[] iArr, int i, int i2);
    }

    static {
        d.aqf();
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
        f.jP("preload").f(new UbcFlowEvent("na_game_engine_start"));
        this.cou = MarioSDK.createAREngine(aVar);
        this.cou.setPermissionProxy(new e());
        this.cou.setOnStuckScreenListener(new com.baidu.smallgame.sdk.b.a() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.1
            @Override // com.baidu.smallgame.sdk.b.a
            public void a(com.baidu.smallgame.sdk.b.b bVar) {
                com.baidu.swan.games.w.b.b(bVar);
            }

            @Override // com.baidu.smallgame.sdk.b.a
            public void Gd() {
                com.baidu.swan.games.glsurface.a.b.aot();
            }
        });
        this.cou.startEngine();
        f.jP("preload").f(new UbcFlowEvent("na_game_engine_end"));
        this.cow = new com.baidu.swan.games.glsurface.a.a();
        this.coz = new GameRecorderController(this.cou);
        com.baidu.swan.games.screenrecord.d.apn().g(this.coz);
    }

    private void setRenderer(GLSurfaceView.Renderer renderer) {
        if (this.cou != null) {
            this.cou.setRenderer(renderer);
        }
    }

    public void setRenderMode(int i) {
        if (this.cou != null) {
            this.cou.setRenderMode(i);
        }
    }

    public int getFPS() {
        if (this.cou == null) {
            return 0;
        }
        return this.cou.getFPS();
    }

    public void aon() {
        Pair<Integer, Integer> WE = com.baidu.swan.apps.y.f.WQ().WE();
        if (this.cou != null) {
            this.cou.updateSurfaceViewSize(((Integer) WE.first).intValue(), ((Integer) WE.second).intValue());
            this.cou.initDisplayMetrics();
        }
        if (this.cow != null) {
            this.cow.am(((Integer) WE.first).intValue(), ((Integer) WE.second).intValue());
        }
    }

    public void aoo() {
        surfaceChanged(getHolder(), 0, getWidth(), getHeight());
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return this.cov;
    }

    public void setV8Engine(com.baidu.swan.games.e.a aVar) {
        this.cov = aVar;
        this.cow.setV8Engine(this.cov);
    }

    public Thread getThread() {
        if (this.cou != null) {
            return this.cou.getGLThread();
        }
        return null;
    }

    public int getRenderMode() {
        if (this.cou != null) {
            return this.cou.getRenderMode();
        }
        return 1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceCreated");
        }
        if (this.cou != null) {
            this.cou.surfaceCreated();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceChanged width: " + i2 + ", height: " + i3);
        }
        if (this.cou != null) {
            this.cou.surfaceChanged(i2, i3);
        }
        if (this.cow != null) {
            this.cow.an(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceDestroyed width");
        }
        aop();
        if (this.cou != null) {
            this.cou.surfaceDestroyed();
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        if (this.cou != null) {
            this.cou.requestRenderAndWait();
        }
    }

    public void onPause() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_PAUSE);
        }
        queueEvent(new Runnable() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                if (DuMixGameSurfaceView.this.cou != null) {
                    DuMixGameSurfaceView.this.cou.smallGameOnPause();
                }
            }
        });
        if (this.cou != null) {
            this.cou.onPause();
        }
        com.baidu.swan.games.screenrecord.d.apn().apq();
    }

    public void onResume() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_RESUME);
        }
        if (this.cou != null) {
            this.cou.onResume();
        }
        com.baidu.swan.games.screenrecord.d.apn().apr();
    }

    public void onDestroy() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_DESTROY);
        }
        aop();
        com.baidu.swan.games.screenrecord.d.apn().h(this.coz);
        if (this.cou != null) {
            this.cou.setFirstFrameListener(null);
            this.cou.setOnStuckScreenListener(null);
            this.cou.smallGameDestroy();
        }
    }

    public void d(V8ExceptionInfo v8ExceptionInfo) {
        if (this.cou != null && this.cou.getStuckScreenHandler() != null) {
            this.cou.getStuckScreenHandler().a(0, v8ExceptionInfo);
        }
    }

    public void runOnGLThread(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "runOnGLThread");
        }
        if (this.cou != null) {
            this.cou.runOnGLThread(runnable);
        }
    }

    public void queueEvent(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent");
        }
        if (this.cou != null) {
            this.cou.queueEvent(runnable);
        }
    }

    public void queueEvent(Runnable runnable, long j) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent delayed");
        }
        if (this.cou != null) {
            this.cou.queueEvent(runnable, j);
        }
    }

    public void clearOldEvents() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "executeQueueEvent");
        }
        if (this.cou != null) {
            this.cou.clearOldEvents();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.cou != null) {
            this.cou.onAttachedToWindow();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDetachedFromWindow");
        }
        if (this.cou != null) {
            this.cou.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cow.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void finalize() throws Throwable {
        if (this.cou != null) {
            this.cou.setFirstFrameListener(null);
            this.cou.setOnStuckScreenListener(null);
            this.cou.exitGLThread();
            this.cou = null;
        }
    }

    private void aop() {
        this.mDrawHeight = 0;
        this.mDrawWidth = 0;
    }

    @Override // com.baidu.smallgame.sdk.ArBridge.FirstFrameListener
    public void onFirstFrameFinished() {
        aoq();
        SwanAppActivity WB = com.baidu.swan.apps.y.f.WQ().WB();
        if (WB != null) {
            c Gt = WB.Gt();
            if (Gt instanceof com.baidu.swan.games.i.b) {
                ((com.baidu.swan.games.i.b) Gt).onFirstFrameFinished();
            }
        }
    }

    public void aoq() {
        if (this.cov != null) {
            com.baidu.swan.games.u.d.F(this.cov.getPerformanceJson());
        }
        if (this.cou != null) {
            com.baidu.swan.games.u.d.F(this.cou.getPerformanceJson());
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
            if (DuMixGameSurfaceView.this.cou != null) {
                DuMixGameSurfaceView.this.cou.smallGameUpdate();
                if (DuMixGameSurfaceView.this.cox != null) {
                    if (DuMixGameSurfaceView.this.coy) {
                        DuMixGameSurfaceView.this.cox.b(DuMixGameSurfaceView.this.getScreenShot(), DuMixGameSurfaceView.this.mDrawWidth, DuMixGameSurfaceView.this.mDrawHeight);
                        DuMixGameSurfaceView.this.cou.setScreenShotStatus(false);
                        DuMixGameSurfaceView.this.coy = false;
                        DuMixGameSurfaceView.this.cox = null;
                    }
                    if (DuMixGameSurfaceView.this.cox != null) {
                        DuMixGameSurfaceView.this.cou.setScreenShotStatus(true);
                        DuMixGameSurfaceView.this.coy = true;
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
