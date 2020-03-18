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
    private AREngineDelegate coH;
    private com.baidu.swan.games.e.a coI;
    private com.baidu.swan.games.glsurface.a.a coJ;
    private volatile b coK;
    private boolean coL;
    private GameRecorderController coM;
    private int mDrawHeight;
    private int mDrawWidth;

    /* loaded from: classes11.dex */
    public interface b {
        void b(int[] iArr, int i, int i2);
    }

    static {
        d.aqk();
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
        f.jO("preload").f(new UbcFlowEvent("na_game_engine_start"));
        this.coH = MarioSDK.createAREngine(aVar);
        this.coH.setPermissionProxy(new e());
        this.coH.setOnStuckScreenListener(new com.baidu.smallgame.sdk.b.a() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.1
            @Override // com.baidu.smallgame.sdk.b.a
            public void a(com.baidu.smallgame.sdk.b.b bVar) {
                com.baidu.swan.games.w.b.b(bVar);
            }

            @Override // com.baidu.smallgame.sdk.b.a
            public void Gk() {
                com.baidu.swan.games.glsurface.a.b.aoy();
            }
        });
        this.coH.startEngine();
        f.jO("preload").f(new UbcFlowEvent("na_game_engine_end"));
        this.coJ = new com.baidu.swan.games.glsurface.a.a();
        this.coM = new GameRecorderController(this.coH);
        com.baidu.swan.games.screenrecord.d.aps().g(this.coM);
    }

    private void setRenderer(GLSurfaceView.Renderer renderer) {
        if (this.coH != null) {
            this.coH.setRenderer(renderer);
        }
    }

    public void setRenderMode(int i) {
        if (this.coH != null) {
            this.coH.setRenderMode(i);
        }
    }

    public int getFPS() {
        if (this.coH == null) {
            return 0;
        }
        return this.coH.getFPS();
    }

    public void aos() {
        Pair<Integer, Integer> WJ = com.baidu.swan.apps.y.f.WV().WJ();
        if (this.coH != null) {
            this.coH.updateSurfaceViewSize(((Integer) WJ.first).intValue(), ((Integer) WJ.second).intValue());
            this.coH.initDisplayMetrics();
        }
        if (this.coJ != null) {
            this.coJ.am(((Integer) WJ.first).intValue(), ((Integer) WJ.second).intValue());
        }
    }

    public void aot() {
        surfaceChanged(getHolder(), 0, getWidth(), getHeight());
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return this.coI;
    }

    public void setV8Engine(com.baidu.swan.games.e.a aVar) {
        this.coI = aVar;
        this.coJ.setV8Engine(this.coI);
    }

    public Thread getThread() {
        if (this.coH != null) {
            return this.coH.getGLThread();
        }
        return null;
    }

    public int getRenderMode() {
        if (this.coH != null) {
            return this.coH.getRenderMode();
        }
        return 1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceCreated");
        }
        if (this.coH != null) {
            this.coH.surfaceCreated();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceChanged width: " + i2 + ", height: " + i3);
        }
        if (this.coH != null) {
            this.coH.surfaceChanged(i2, i3);
        }
        if (this.coJ != null) {
            this.coJ.an(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceDestroyed width");
        }
        aou();
        if (this.coH != null) {
            this.coH.surfaceDestroyed();
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        if (this.coH != null) {
            this.coH.requestRenderAndWait();
        }
    }

    public void onPause() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_PAUSE);
        }
        queueEvent(new Runnable() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                if (DuMixGameSurfaceView.this.coH != null) {
                    DuMixGameSurfaceView.this.coH.smallGameOnPause();
                }
            }
        });
        if (this.coH != null) {
            this.coH.onPause();
        }
        com.baidu.swan.games.screenrecord.d.aps().apv();
    }

    public void onResume() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_RESUME);
        }
        if (this.coH != null) {
            this.coH.onResume();
        }
        com.baidu.swan.games.screenrecord.d.aps().apw();
    }

    public void onDestroy() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_DESTROY);
        }
        aou();
        com.baidu.swan.games.screenrecord.d.aps().h(this.coM);
        if (this.coH != null) {
            this.coH.setFirstFrameListener(null);
            this.coH.setOnStuckScreenListener(null);
            this.coH.smallGameDestroy();
        }
    }

    public void d(V8ExceptionInfo v8ExceptionInfo) {
        if (this.coH != null && this.coH.getStuckScreenHandler() != null) {
            this.coH.getStuckScreenHandler().a(0, v8ExceptionInfo);
        }
    }

    public void runOnGLThread(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "runOnGLThread");
        }
        if (this.coH != null) {
            this.coH.runOnGLThread(runnable);
        }
    }

    public void queueEvent(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent");
        }
        if (this.coH != null) {
            this.coH.queueEvent(runnable);
        }
    }

    public void queueEvent(Runnable runnable, long j) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent delayed");
        }
        if (this.coH != null) {
            this.coH.queueEvent(runnable, j);
        }
    }

    public void clearOldEvents() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "executeQueueEvent");
        }
        if (this.coH != null) {
            this.coH.clearOldEvents();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.coH != null) {
            this.coH.onAttachedToWindow();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDetachedFromWindow");
        }
        if (this.coH != null) {
            this.coH.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.coJ.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void finalize() throws Throwable {
        if (this.coH != null) {
            this.coH.setFirstFrameListener(null);
            this.coH.setOnStuckScreenListener(null);
            this.coH.exitGLThread();
            this.coH = null;
        }
    }

    private void aou() {
        this.mDrawHeight = 0;
        this.mDrawWidth = 0;
    }

    @Override // com.baidu.smallgame.sdk.ArBridge.FirstFrameListener
    public void onFirstFrameFinished() {
        aov();
        SwanAppActivity WG = com.baidu.swan.apps.y.f.WV().WG();
        if (WG != null) {
            c GA = WG.GA();
            if (GA instanceof com.baidu.swan.games.i.b) {
                ((com.baidu.swan.games.i.b) GA).onFirstFrameFinished();
            }
        }
    }

    public void aov() {
        if (this.coI != null) {
            com.baidu.swan.games.u.d.F(this.coI.getPerformanceJson());
        }
        if (this.coH != null) {
            com.baidu.swan.games.u.d.F(this.coH.getPerformanceJson());
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
            if (DuMixGameSurfaceView.this.coH != null) {
                DuMixGameSurfaceView.this.coH.smallGameUpdate();
                if (DuMixGameSurfaceView.this.coK != null) {
                    if (DuMixGameSurfaceView.this.coL) {
                        DuMixGameSurfaceView.this.coK.b(DuMixGameSurfaceView.this.getScreenShot(), DuMixGameSurfaceView.this.mDrawWidth, DuMixGameSurfaceView.this.mDrawHeight);
                        DuMixGameSurfaceView.this.coH.setScreenShotStatus(false);
                        DuMixGameSurfaceView.this.coL = false;
                        DuMixGameSurfaceView.this.coK = null;
                    }
                    if (DuMixGameSurfaceView.this.coK != null) {
                        DuMixGameSurfaceView.this.coH.setScreenShotStatus(true);
                        DuMixGameSurfaceView.this.coL = true;
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
