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
import com.baidu.sapi2.outsdk.c;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.smallgame.sdk.ArBridge;
import com.baidu.smallgame.sdk.MarioSDK;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.g;
import com.baidu.swan.apps.w.f;
import com.baidu.swan.games.f.c.e;
import com.baidu.swan.games.screenrecord.GameRecorderController;
import com.baidu.swan.games.utils.so.d;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes11.dex */
public class DuMixGameSurfaceView extends SurfaceView implements SurfaceHolder.Callback2, ArBridge.FirstFrameListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private AREngineDelegate cYB;
    private com.baidu.swan.games.f.a cYC;
    private com.baidu.swan.games.glsurface.a.a cYD;
    private volatile b cYE;
    private boolean cYF;
    private GameRecorderController cYG;
    private int mDrawHeight;
    private int mDrawWidth;

    /* loaded from: classes11.dex */
    public interface b {
        void b(int[] iArr, int i, int i2);
    }

    static {
        d.aCo();
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
            Log.d("DuMixGameSurfaceView", c.l);
        }
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        MarioSDK.a aVar = new MarioSDK.a();
        aVar.c(holder);
        aVar.setFirstFrameListener(this);
        aVar.setRenderer(new a());
        aVar.setContext(AppRuntime.getAppContext());
        aVar.addDebugConsole(new com.baidu.swan.games.glsurface.a());
        g.mp("preload").f(new UbcFlowEvent("na_game_engine_start"));
        this.cYB = MarioSDK.createAREngine(aVar);
        this.cYB.setPermissionProxy(new e());
        this.cYB.setOnStuckScreenListener(new com.baidu.smallgame.sdk.b.a() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.1
            @Override // com.baidu.smallgame.sdk.b.a
            public void a(com.baidu.smallgame.sdk.b.b bVar) {
                com.baidu.swan.games.x.b.b(bVar);
            }

            @Override // com.baidu.smallgame.sdk.b.a
            public void Qj() {
                com.baidu.swan.games.glsurface.a.b.aAA();
            }
        });
        this.cYB.startEngine();
        g.mp("preload").f(new UbcFlowEvent("na_game_engine_end"));
        this.cYD = new com.baidu.swan.games.glsurface.a.a();
        this.cYG = new GameRecorderController(this.cYB);
        com.baidu.swan.games.screenrecord.d.aBv().g(this.cYG);
    }

    private void setRenderer(GLSurfaceView.Renderer renderer) {
        if (this.cYB != null) {
            this.cYB.setRenderer(renderer);
        }
    }

    public void setRenderMode(int i) {
        if (this.cYB != null) {
            this.cYB.setRenderMode(i);
        }
    }

    public int getFPS() {
        if (this.cYB == null) {
            return 0;
        }
        return this.cYB.getFPS();
    }

    public void aAu() {
        Pair<Integer, Integer> ahI = f.ahV().ahI();
        if (this.cYB != null) {
            this.cYB.updateSurfaceViewSize(((Integer) ahI.first).intValue(), ((Integer) ahI.second).intValue());
            this.cYB.initDisplayMetrics();
        }
        if (this.cYD != null) {
            this.cYD.ap(((Integer) ahI.first).intValue(), ((Integer) ahI.second).intValue());
        }
    }

    public void aAv() {
        surfaceChanged(getHolder(), 0, getWidth(), getHeight());
    }

    public com.baidu.swan.games.f.a getV8Engine() {
        return this.cYC;
    }

    public void setV8Engine(com.baidu.swan.games.f.a aVar) {
        this.cYC = aVar;
        this.cYD.setV8Engine(this.cYC);
    }

    public Thread getThread() {
        if (this.cYB != null) {
            return this.cYB.getGLThread();
        }
        return null;
    }

    public int getRenderMode() {
        if (this.cYB != null) {
            return this.cYB.getRenderMode();
        }
        return 1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceCreated");
        }
        if (this.cYB != null) {
            this.cYB.surfaceCreated();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceChanged width: " + i2 + ", height: " + i3);
        }
        if (this.cYB != null) {
            this.cYB.surfaceChanged(i2, i3);
        }
        if (this.cYD != null) {
            this.cYD.aq(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceDestroyed width");
        }
        aAw();
        if (this.cYB != null) {
            this.cYB.surfaceDestroyed();
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        if (this.cYB != null) {
            this.cYB.requestRenderAndWait();
        }
    }

    public void onPause() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_PAUSE);
        }
        queueEvent(new Runnable() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                if (DuMixGameSurfaceView.this.cYB != null) {
                    DuMixGameSurfaceView.this.cYB.smallGameOnPause();
                }
            }
        });
        if (this.cYB != null) {
            this.cYB.onPause();
        }
        com.baidu.swan.games.screenrecord.d.aBv().aBy();
    }

    public void onResume() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_RESUME);
        }
        if (this.cYB != null) {
            this.cYB.onResume();
        }
        com.baidu.swan.games.screenrecord.d.aBv().aBz();
    }

    public void onDestroy() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_DESTROY);
        }
        aAw();
        com.baidu.swan.games.screenrecord.d.aBv().h(this.cYG);
        if (this.cYB != null) {
            if (this.cYC != null) {
                this.cYC.finish();
            }
            this.cYB.setFirstFrameListener(null);
            this.cYB.setOnStuckScreenListener(null);
            this.cYB.smallGameDestroy();
        }
    }

    public void d(V8ExceptionInfo v8ExceptionInfo) {
        if (this.cYB != null && this.cYB.getStuckScreenHandler() != null) {
            this.cYB.getStuckScreenHandler().a(0, v8ExceptionInfo);
        }
    }

    public void runOnGLThread(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "runOnGLThread");
        }
        if (this.cYB != null) {
            this.cYB.runOnGLThread(runnable);
        }
    }

    public void queueEvent(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent");
        }
        if (this.cYB != null) {
            this.cYB.queueEvent(runnable);
        }
    }

    public void queueEvent(Runnable runnable, long j) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent delayed");
        }
        if (this.cYB != null) {
            this.cYB.queueEvent(runnable, j);
        }
    }

    public void clearOldEvents() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "executeQueueEvent");
        }
        if (this.cYB != null) {
            this.cYB.clearOldEvents();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.cYB != null) {
            this.cYB.onAttachedToWindow();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDetachedFromWindow");
        }
        if (this.cYB != null) {
            this.cYB.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cYD.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void finalize() throws Throwable {
        if (this.cYB != null) {
            if (this.cYC != null) {
                this.cYC.finish();
            }
            this.cYB.setFirstFrameListener(null);
            this.cYB.setOnStuckScreenListener(null);
            this.cYB.exitGLThread();
            this.cYB = null;
        }
    }

    private void aAw() {
        this.mDrawHeight = 0;
        this.mDrawWidth = 0;
    }

    @Override // com.baidu.smallgame.sdk.ArBridge.FirstFrameListener
    public void onFirstFrameFinished() {
        aAx();
        SwanAppActivity ahF = f.ahV().ahF();
        if (ahF != null) {
            com.baidu.swan.apps.framework.c QA = ahF.QA();
            if (QA instanceof com.baidu.swan.games.j.b) {
                ((com.baidu.swan.games.j.b) QA).onFirstFrameFinished();
            }
        }
    }

    public void aAx() {
        if (this.cYC != null) {
            com.baidu.swan.games.v.d.F(this.cYC.getPerformanceJson());
        }
        if (this.cYB != null) {
            com.baidu.swan.games.v.d.F(this.cYB.getPerformanceJson());
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
            if (DuMixGameSurfaceView.this.cYB != null) {
                DuMixGameSurfaceView.this.cYB.smallGameUpdate();
                if (DuMixGameSurfaceView.this.cYE != null) {
                    if (DuMixGameSurfaceView.this.cYF) {
                        DuMixGameSurfaceView.this.cYE.b(DuMixGameSurfaceView.this.getScreenShot(), DuMixGameSurfaceView.this.mDrawWidth, DuMixGameSurfaceView.this.mDrawHeight);
                        DuMixGameSurfaceView.this.cYB.setScreenShotStatus(false);
                        DuMixGameSurfaceView.this.cYF = false;
                        DuMixGameSurfaceView.this.cYE = null;
                    }
                    if (DuMixGameSurfaceView.this.cYE != null) {
                        DuMixGameSurfaceView.this.cYB.setScreenShotStatus(true);
                        DuMixGameSurfaceView.this.cYF = true;
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
