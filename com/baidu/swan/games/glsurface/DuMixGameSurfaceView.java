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
/* loaded from: classes9.dex */
public class DuMixGameSurfaceView extends SurfaceView implements SurfaceHolder.Callback2, ArBridge.FirstFrameListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private AREngineDelegate ckd;
    private com.baidu.swan.games.e.a cke;
    private com.baidu.swan.games.glsurface.a.a ckf;
    private volatile b ckg;
    private boolean ckh;
    private GameRecorderController cki;
    private int mDrawHeight;
    private int mDrawWidth;

    /* loaded from: classes9.dex */
    public interface b {
        void b(int[] iArr, int i, int i2);
    }

    static {
        d.any();
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
        f.jx("preload").f(new UbcFlowEvent("na_game_engine_start"));
        this.ckd = MarioSDK.createAREngine(aVar);
        this.ckd.setPermissionProxy(new e());
        this.ckd.setOnStuckScreenListener(new com.baidu.smallgame.sdk.b.a() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.1
            @Override // com.baidu.smallgame.sdk.b.a
            public void a(com.baidu.smallgame.sdk.b.b bVar) {
                com.baidu.swan.games.w.b.b(bVar);
            }

            @Override // com.baidu.smallgame.sdk.b.a
            public void Ds() {
                com.baidu.swan.games.glsurface.a.b.alN();
            }
        });
        this.ckd.startEngine();
        f.jx("preload").f(new UbcFlowEvent("na_game_engine_end"));
        this.ckf = new com.baidu.swan.games.glsurface.a.a();
        this.cki = new GameRecorderController(this.ckd);
        com.baidu.swan.games.screenrecord.d.amG().g(this.cki);
    }

    private void setRenderer(GLSurfaceView.Renderer renderer) {
        if (this.ckd != null) {
            this.ckd.setRenderer(renderer);
        }
    }

    public void setRenderMode(int i) {
        if (this.ckd != null) {
            this.ckd.setRenderMode(i);
        }
    }

    public int getFPS() {
        if (this.ckd == null) {
            return 0;
        }
        return this.ckd.getFPS();
    }

    public void alH() {
        Pair<Integer, Integer> TT = com.baidu.swan.apps.y.f.Uf().TT();
        if (this.ckd != null) {
            this.ckd.updateSurfaceViewSize(((Integer) TT.first).intValue(), ((Integer) TT.second).intValue());
            this.ckd.initDisplayMetrics();
        }
        if (this.ckf != null) {
            this.ckf.ai(((Integer) TT.first).intValue(), ((Integer) TT.second).intValue());
        }
    }

    public void alI() {
        surfaceChanged(getHolder(), 0, getWidth(), getHeight());
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return this.cke;
    }

    public void setV8Engine(com.baidu.swan.games.e.a aVar) {
        this.cke = aVar;
        this.ckf.setV8Engine(this.cke);
    }

    public Thread getThread() {
        if (this.ckd != null) {
            return this.ckd.getGLThread();
        }
        return null;
    }

    public int getRenderMode() {
        if (this.ckd != null) {
            return this.ckd.getRenderMode();
        }
        return 1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceCreated");
        }
        if (this.ckd != null) {
            this.ckd.surfaceCreated();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceChanged width: " + i2 + ", height: " + i3);
        }
        if (this.ckd != null) {
            this.ckd.surfaceChanged(i2, i3);
        }
        if (this.ckf != null) {
            this.ckf.aj(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceDestroyed width");
        }
        alJ();
        if (this.ckd != null) {
            this.ckd.surfaceDestroyed();
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        if (this.ckd != null) {
            this.ckd.requestRenderAndWait();
        }
    }

    public void onPause() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_PAUSE);
        }
        queueEvent(new Runnable() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                if (DuMixGameSurfaceView.this.ckd != null) {
                    DuMixGameSurfaceView.this.ckd.smallGameOnPause();
                }
            }
        });
        if (this.ckd != null) {
            this.ckd.onPause();
        }
        com.baidu.swan.games.screenrecord.d.amG().amJ();
    }

    public void onResume() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_RESUME);
        }
        if (this.ckd != null) {
            this.ckd.onResume();
        }
        com.baidu.swan.games.screenrecord.d.amG().amK();
    }

    public void onDestroy() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_DESTROY);
        }
        alJ();
        com.baidu.swan.games.screenrecord.d.amG().h(this.cki);
        if (this.ckd != null) {
            this.ckd.setFirstFrameListener(null);
            this.ckd.setOnStuckScreenListener(null);
            this.ckd.smallGameDestroy();
        }
    }

    public void d(V8ExceptionInfo v8ExceptionInfo) {
        if (this.ckd != null && this.ckd.getStuckScreenHandler() != null) {
            this.ckd.getStuckScreenHandler().a(0, v8ExceptionInfo);
        }
    }

    public void runOnGLThread(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "runOnGLThread");
        }
        if (this.ckd != null) {
            this.ckd.runOnGLThread(runnable);
        }
    }

    public void queueEvent(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent");
        }
        if (this.ckd != null) {
            this.ckd.queueEvent(runnable);
        }
    }

    public void queueEvent(Runnable runnable, long j) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent delayed");
        }
        if (this.ckd != null) {
            this.ckd.queueEvent(runnable, j);
        }
    }

    public void clearOldEvents() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "executeQueueEvent");
        }
        if (this.ckd != null) {
            this.ckd.clearOldEvents();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.ckd != null) {
            this.ckd.onAttachedToWindow();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDetachedFromWindow");
        }
        if (this.ckd != null) {
            this.ckd.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.ckf.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void finalize() throws Throwable {
        if (this.ckd != null) {
            this.ckd.setFirstFrameListener(null);
            this.ckd.setOnStuckScreenListener(null);
            this.ckd.exitGLThread();
            this.ckd = null;
        }
    }

    private void alJ() {
        this.mDrawHeight = 0;
        this.mDrawWidth = 0;
    }

    @Override // com.baidu.smallgame.sdk.ArBridge.FirstFrameListener
    public void onFirstFrameFinished() {
        alK();
        SwanAppActivity TQ = com.baidu.swan.apps.y.f.Uf().TQ();
        if (TQ != null) {
            c DI = TQ.DI();
            if (DI instanceof com.baidu.swan.games.i.b) {
                ((com.baidu.swan.games.i.b) DI).onFirstFrameFinished();
            }
        }
    }

    public void alK() {
        if (this.cke != null) {
            com.baidu.swan.games.u.d.E(this.cke.getPerformanceJson());
        }
        if (this.ckd != null) {
            com.baidu.swan.games.u.d.E(this.ckd.getPerformanceJson());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
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
            if (DuMixGameSurfaceView.this.ckd != null) {
                DuMixGameSurfaceView.this.ckd.smallGameUpdate();
                if (DuMixGameSurfaceView.this.ckg != null) {
                    if (DuMixGameSurfaceView.this.ckh) {
                        DuMixGameSurfaceView.this.ckg.b(DuMixGameSurfaceView.this.getScreenShot(), DuMixGameSurfaceView.this.mDrawWidth, DuMixGameSurfaceView.this.mDrawHeight);
                        DuMixGameSurfaceView.this.ckd.setScreenShotStatus(false);
                        DuMixGameSurfaceView.this.ckh = false;
                        DuMixGameSurfaceView.this.ckg = null;
                    }
                    if (DuMixGameSurfaceView.this.ckg != null) {
                        DuMixGameSurfaceView.this.ckd.setScreenShotStatus(true);
                        DuMixGameSurfaceView.this.ckh = true;
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
