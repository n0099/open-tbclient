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
    private boolean coA;
    private GameRecorderController coB;
    private AREngineDelegate cow;
    private com.baidu.swan.games.e.a cox;
    private com.baidu.swan.games.glsurface.a.a coy;
    private volatile b coz;
    private int mDrawHeight;
    private int mDrawWidth;

    /* loaded from: classes11.dex */
    public interface b {
        void b(int[] iArr, int i, int i2);
    }

    static {
        d.aqh();
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
        this.cow = MarioSDK.createAREngine(aVar);
        this.cow.setPermissionProxy(new e());
        this.cow.setOnStuckScreenListener(new com.baidu.smallgame.sdk.b.a() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.1
            @Override // com.baidu.smallgame.sdk.b.a
            public void a(com.baidu.smallgame.sdk.b.b bVar) {
                com.baidu.swan.games.w.b.b(bVar);
            }

            @Override // com.baidu.smallgame.sdk.b.a
            public void Gf() {
                com.baidu.swan.games.glsurface.a.b.aov();
            }
        });
        this.cow.startEngine();
        f.jP("preload").f(new UbcFlowEvent("na_game_engine_end"));
        this.coy = new com.baidu.swan.games.glsurface.a.a();
        this.coB = new GameRecorderController(this.cow);
        com.baidu.swan.games.screenrecord.d.app().g(this.coB);
    }

    private void setRenderer(GLSurfaceView.Renderer renderer) {
        if (this.cow != null) {
            this.cow.setRenderer(renderer);
        }
    }

    public void setRenderMode(int i) {
        if (this.cow != null) {
            this.cow.setRenderMode(i);
        }
    }

    public int getFPS() {
        if (this.cow == null) {
            return 0;
        }
        return this.cow.getFPS();
    }

    public void aop() {
        Pair<Integer, Integer> WG = com.baidu.swan.apps.y.f.WS().WG();
        if (this.cow != null) {
            this.cow.updateSurfaceViewSize(((Integer) WG.first).intValue(), ((Integer) WG.second).intValue());
            this.cow.initDisplayMetrics();
        }
        if (this.coy != null) {
            this.coy.am(((Integer) WG.first).intValue(), ((Integer) WG.second).intValue());
        }
    }

    public void aoq() {
        surfaceChanged(getHolder(), 0, getWidth(), getHeight());
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return this.cox;
    }

    public void setV8Engine(com.baidu.swan.games.e.a aVar) {
        this.cox = aVar;
        this.coy.setV8Engine(this.cox);
    }

    public Thread getThread() {
        if (this.cow != null) {
            return this.cow.getGLThread();
        }
        return null;
    }

    public int getRenderMode() {
        if (this.cow != null) {
            return this.cow.getRenderMode();
        }
        return 1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceCreated");
        }
        if (this.cow != null) {
            this.cow.surfaceCreated();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceChanged width: " + i2 + ", height: " + i3);
        }
        if (this.cow != null) {
            this.cow.surfaceChanged(i2, i3);
        }
        if (this.coy != null) {
            this.coy.an(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceDestroyed width");
        }
        aor();
        if (this.cow != null) {
            this.cow.surfaceDestroyed();
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        if (this.cow != null) {
            this.cow.requestRenderAndWait();
        }
    }

    public void onPause() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_PAUSE);
        }
        queueEvent(new Runnable() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                if (DuMixGameSurfaceView.this.cow != null) {
                    DuMixGameSurfaceView.this.cow.smallGameOnPause();
                }
            }
        });
        if (this.cow != null) {
            this.cow.onPause();
        }
        com.baidu.swan.games.screenrecord.d.app().aps();
    }

    public void onResume() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_RESUME);
        }
        if (this.cow != null) {
            this.cow.onResume();
        }
        com.baidu.swan.games.screenrecord.d.app().apt();
    }

    public void onDestroy() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_DESTROY);
        }
        aor();
        com.baidu.swan.games.screenrecord.d.app().h(this.coB);
        if (this.cow != null) {
            this.cow.setFirstFrameListener(null);
            this.cow.setOnStuckScreenListener(null);
            this.cow.smallGameDestroy();
        }
    }

    public void d(V8ExceptionInfo v8ExceptionInfo) {
        if (this.cow != null && this.cow.getStuckScreenHandler() != null) {
            this.cow.getStuckScreenHandler().a(0, v8ExceptionInfo);
        }
    }

    public void runOnGLThread(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "runOnGLThread");
        }
        if (this.cow != null) {
            this.cow.runOnGLThread(runnable);
        }
    }

    public void queueEvent(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent");
        }
        if (this.cow != null) {
            this.cow.queueEvent(runnable);
        }
    }

    public void queueEvent(Runnable runnable, long j) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent delayed");
        }
        if (this.cow != null) {
            this.cow.queueEvent(runnable, j);
        }
    }

    public void clearOldEvents() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "executeQueueEvent");
        }
        if (this.cow != null) {
            this.cow.clearOldEvents();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.cow != null) {
            this.cow.onAttachedToWindow();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDetachedFromWindow");
        }
        if (this.cow != null) {
            this.cow.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.coy.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void finalize() throws Throwable {
        if (this.cow != null) {
            this.cow.setFirstFrameListener(null);
            this.cow.setOnStuckScreenListener(null);
            this.cow.exitGLThread();
            this.cow = null;
        }
    }

    private void aor() {
        this.mDrawHeight = 0;
        this.mDrawWidth = 0;
    }

    @Override // com.baidu.smallgame.sdk.ArBridge.FirstFrameListener
    public void onFirstFrameFinished() {
        aos();
        SwanAppActivity WD = com.baidu.swan.apps.y.f.WS().WD();
        if (WD != null) {
            c Gv = WD.Gv();
            if (Gv instanceof com.baidu.swan.games.i.b) {
                ((com.baidu.swan.games.i.b) Gv).onFirstFrameFinished();
            }
        }
    }

    public void aos() {
        if (this.cox != null) {
            com.baidu.swan.games.u.d.F(this.cox.getPerformanceJson());
        }
        if (this.cow != null) {
            com.baidu.swan.games.u.d.F(this.cow.getPerformanceJson());
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
            if (DuMixGameSurfaceView.this.cow != null) {
                DuMixGameSurfaceView.this.cow.smallGameUpdate();
                if (DuMixGameSurfaceView.this.coz != null) {
                    if (DuMixGameSurfaceView.this.coA) {
                        DuMixGameSurfaceView.this.coz.b(DuMixGameSurfaceView.this.getScreenShot(), DuMixGameSurfaceView.this.mDrawWidth, DuMixGameSurfaceView.this.mDrawHeight);
                        DuMixGameSurfaceView.this.cow.setScreenShotStatus(false);
                        DuMixGameSurfaceView.this.coA = false;
                        DuMixGameSurfaceView.this.coz = null;
                    }
                    if (DuMixGameSurfaceView.this.coz != null) {
                        DuMixGameSurfaceView.this.cow.setScreenShotStatus(true);
                        DuMixGameSurfaceView.this.coA = true;
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
