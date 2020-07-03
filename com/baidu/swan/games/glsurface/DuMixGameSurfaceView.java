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
    private AREngineDelegate ddo;
    private com.baidu.swan.games.f.a ddp;
    private com.baidu.swan.games.glsurface.a.a ddq;
    private volatile b ddr;
    private boolean dds;
    private GameRecorderController ddt;
    private int mDrawHeight;
    private int mDrawWidth;

    /* loaded from: classes11.dex */
    public interface b {
        void b(int[] iArr, int i, int i2);
    }

    static {
        d.aDu();
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
        g.mx("preload").f(new UbcFlowEvent("na_game_engine_start"));
        this.ddo = MarioSDK.createAREngine(aVar);
        this.ddo.setPermissionProxy(new e());
        this.ddo.setOnStuckScreenListener(new com.baidu.smallgame.sdk.b.a() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.1
            @Override // com.baidu.smallgame.sdk.b.a
            public void a(com.baidu.smallgame.sdk.b.b bVar) {
                com.baidu.swan.games.x.b.b(bVar);
            }

            @Override // com.baidu.smallgame.sdk.b.a
            public void Rp() {
                com.baidu.swan.games.glsurface.a.b.aBG();
            }
        });
        this.ddo.startEngine();
        g.mx("preload").f(new UbcFlowEvent("na_game_engine_end"));
        this.ddq = new com.baidu.swan.games.glsurface.a.a();
        this.ddt = new GameRecorderController(this.ddo);
        com.baidu.swan.games.screenrecord.d.aCB().g(this.ddt);
    }

    private void setRenderer(GLSurfaceView.Renderer renderer) {
        if (this.ddo != null) {
            this.ddo.setRenderer(renderer);
        }
    }

    public void setRenderMode(int i) {
        if (this.ddo != null) {
            this.ddo.setRenderMode(i);
        }
    }

    public int getFPS() {
        if (this.ddo == null) {
            return 0;
        }
        return this.ddo.getFPS();
    }

    public void aBA() {
        Pair<Integer, Integer> aiO = f.ajb().aiO();
        if (this.ddo != null) {
            this.ddo.updateSurfaceViewSize(((Integer) aiO.first).intValue(), ((Integer) aiO.second).intValue());
            this.ddo.initDisplayMetrics();
        }
        if (this.ddq != null) {
            this.ddq.ar(((Integer) aiO.first).intValue(), ((Integer) aiO.second).intValue());
        }
    }

    public void aBB() {
        surfaceChanged(getHolder(), 0, getWidth(), getHeight());
    }

    public com.baidu.swan.games.f.a getV8Engine() {
        return this.ddp;
    }

    public void setV8Engine(com.baidu.swan.games.f.a aVar) {
        this.ddp = aVar;
        this.ddq.setV8Engine(this.ddp);
    }

    public Thread getThread() {
        if (this.ddo != null) {
            return this.ddo.getGLThread();
        }
        return null;
    }

    public int getRenderMode() {
        if (this.ddo != null) {
            return this.ddo.getRenderMode();
        }
        return 1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceCreated");
        }
        if (this.ddo != null) {
            this.ddo.surfaceCreated();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceChanged width: " + i2 + ", height: " + i3);
        }
        if (this.ddo != null) {
            this.ddo.surfaceChanged(i2, i3);
        }
        if (this.ddq != null) {
            this.ddq.as(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceDestroyed width");
        }
        aBC();
        if (this.ddo != null) {
            this.ddo.surfaceDestroyed();
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        if (this.ddo != null) {
            this.ddo.requestRenderAndWait();
        }
    }

    public void onPause() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_PAUSE);
        }
        queueEvent(new Runnable() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                if (DuMixGameSurfaceView.this.ddo != null) {
                    DuMixGameSurfaceView.this.ddo.smallGameOnPause();
                }
            }
        });
        if (this.ddo != null) {
            this.ddo.onPause();
        }
        com.baidu.swan.games.screenrecord.d.aCB().aCE();
    }

    public void onResume() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_RESUME);
        }
        if (this.ddo != null) {
            this.ddo.onResume();
        }
        com.baidu.swan.games.screenrecord.d.aCB().aCF();
    }

    public void onDestroy() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_DESTROY);
        }
        aBC();
        com.baidu.swan.games.screenrecord.d.aCB().h(this.ddt);
        if (this.ddo != null) {
            if (this.ddp != null) {
                this.ddp.finish();
            }
            this.ddo.setFirstFrameListener(null);
            this.ddo.setOnStuckScreenListener(null);
            this.ddo.smallGameDestroy();
        }
    }

    public void d(V8ExceptionInfo v8ExceptionInfo) {
        if (this.ddo != null && this.ddo.getStuckScreenHandler() != null) {
            this.ddo.getStuckScreenHandler().a(0, v8ExceptionInfo);
        }
    }

    public void runOnGLThread(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "runOnGLThread");
        }
        if (this.ddo != null) {
            this.ddo.runOnGLThread(runnable);
        }
    }

    public void queueEvent(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent");
        }
        if (this.ddo != null) {
            this.ddo.queueEvent(runnable);
        }
    }

    public void queueEvent(Runnable runnable, long j) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent delayed");
        }
        if (this.ddo != null) {
            this.ddo.queueEvent(runnable, j);
        }
    }

    public void clearOldEvents() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "executeQueueEvent");
        }
        if (this.ddo != null) {
            this.ddo.clearOldEvents();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.ddo != null) {
            this.ddo.onAttachedToWindow();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDetachedFromWindow");
        }
        if (this.ddo != null) {
            this.ddo.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.ddq.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void finalize() throws Throwable {
        if (this.ddo != null) {
            if (this.ddp != null) {
                this.ddp.finish();
            }
            this.ddo.setFirstFrameListener(null);
            this.ddo.setOnStuckScreenListener(null);
            this.ddo.exitGLThread();
            this.ddo = null;
        }
    }

    private void aBC() {
        this.mDrawHeight = 0;
        this.mDrawWidth = 0;
    }

    @Override // com.baidu.smallgame.sdk.ArBridge.FirstFrameListener
    public void onFirstFrameFinished() {
        aBD();
        SwanAppActivity aiL = f.ajb().aiL();
        if (aiL != null) {
            com.baidu.swan.apps.framework.c RG = aiL.RG();
            if (RG instanceof com.baidu.swan.games.j.b) {
                ((com.baidu.swan.games.j.b) RG).onFirstFrameFinished();
            }
        }
    }

    public void aBD() {
        if (this.ddp != null) {
            com.baidu.swan.games.v.d.F(this.ddp.getPerformanceJson());
        }
        if (this.ddo != null) {
            com.baidu.swan.games.v.d.F(this.ddo.getPerformanceJson());
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
            if (DuMixGameSurfaceView.this.ddo != null) {
                DuMixGameSurfaceView.this.ddo.smallGameUpdate();
                if (DuMixGameSurfaceView.this.ddr != null) {
                    if (DuMixGameSurfaceView.this.dds) {
                        DuMixGameSurfaceView.this.ddr.b(DuMixGameSurfaceView.this.getScreenShot(), DuMixGameSurfaceView.this.mDrawWidth, DuMixGameSurfaceView.this.mDrawHeight);
                        DuMixGameSurfaceView.this.ddo.setScreenShotStatus(false);
                        DuMixGameSurfaceView.this.dds = false;
                        DuMixGameSurfaceView.this.ddr = null;
                    }
                    if (DuMixGameSurfaceView.this.ddr != null) {
                        DuMixGameSurfaceView.this.ddo.setScreenShotStatus(true);
                        DuMixGameSurfaceView.this.dds = true;
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
