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
    private AREngineDelegate cNJ;
    private com.baidu.swan.games.e.a cNK;
    private com.baidu.swan.games.glsurface.a.a cNL;
    private volatile b cNM;
    private boolean cNN;
    private GameRecorderController cNO;
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
        f.lb("preload").f(new UbcFlowEvent("na_game_engine_start"));
        this.cNJ = MarioSDK.createAREngine(aVar);
        this.cNJ.setPermissionProxy(new e());
        this.cNJ.setOnStuckScreenListener(new com.baidu.smallgame.sdk.b.a() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.1
            @Override // com.baidu.smallgame.sdk.b.a
            public void a(com.baidu.smallgame.sdk.b.b bVar) {
                com.baidu.swan.games.w.b.b(bVar);
            }

            @Override // com.baidu.smallgame.sdk.b.a
            public void NW() {
                com.baidu.swan.games.glsurface.a.b.awL();
            }
        });
        this.cNJ.startEngine();
        f.lb("preload").f(new UbcFlowEvent("na_game_engine_end"));
        this.cNL = new com.baidu.swan.games.glsurface.a.a();
        this.cNO = new GameRecorderController(this.cNJ);
        com.baidu.swan.games.screenrecord.d.axE().g(this.cNO);
    }

    private void setRenderer(GLSurfaceView.Renderer renderer) {
        if (this.cNJ != null) {
            this.cNJ.setRenderer(renderer);
        }
    }

    public void setRenderMode(int i) {
        if (this.cNJ != null) {
            this.cNJ.setRenderMode(i);
        }
    }

    public int getFPS() {
        if (this.cNJ == null) {
            return 0;
        }
        return this.cNJ.getFPS();
    }

    public void awF() {
        Pair<Integer, Integer> aex = com.baidu.swan.apps.y.f.aeJ().aex();
        if (this.cNJ != null) {
            this.cNJ.updateSurfaceViewSize(((Integer) aex.first).intValue(), ((Integer) aex.second).intValue());
            this.cNJ.initDisplayMetrics();
        }
        if (this.cNL != null) {
            this.cNL.ap(((Integer) aex.first).intValue(), ((Integer) aex.second).intValue());
        }
    }

    public void awG() {
        surfaceChanged(getHolder(), 0, getWidth(), getHeight());
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return this.cNK;
    }

    public void setV8Engine(com.baidu.swan.games.e.a aVar) {
        this.cNK = aVar;
        this.cNL.setV8Engine(this.cNK);
    }

    public Thread getThread() {
        if (this.cNJ != null) {
            return this.cNJ.getGLThread();
        }
        return null;
    }

    public int getRenderMode() {
        if (this.cNJ != null) {
            return this.cNJ.getRenderMode();
        }
        return 1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceCreated");
        }
        if (this.cNJ != null) {
            this.cNJ.surfaceCreated();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceChanged width: " + i2 + ", height: " + i3);
        }
        if (this.cNJ != null) {
            this.cNJ.surfaceChanged(i2, i3);
        }
        if (this.cNL != null) {
            this.cNL.aq(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceDestroyed width");
        }
        awH();
        if (this.cNJ != null) {
            this.cNJ.surfaceDestroyed();
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        if (this.cNJ != null) {
            this.cNJ.requestRenderAndWait();
        }
    }

    public void onPause() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_PAUSE);
        }
        queueEvent(new Runnable() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                if (DuMixGameSurfaceView.this.cNJ != null) {
                    DuMixGameSurfaceView.this.cNJ.smallGameOnPause();
                }
            }
        });
        if (this.cNJ != null) {
            this.cNJ.onPause();
        }
        com.baidu.swan.games.screenrecord.d.axE().axH();
    }

    public void onResume() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_RESUME);
        }
        if (this.cNJ != null) {
            this.cNJ.onResume();
        }
        com.baidu.swan.games.screenrecord.d.axE().axI();
    }

    public void onDestroy() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_DESTROY);
        }
        awH();
        com.baidu.swan.games.screenrecord.d.axE().h(this.cNO);
        if (this.cNJ != null) {
            this.cNJ.setFirstFrameListener(null);
            this.cNJ.setOnStuckScreenListener(null);
            this.cNJ.smallGameDestroy();
        }
    }

    public void d(V8ExceptionInfo v8ExceptionInfo) {
        if (this.cNJ != null && this.cNJ.getStuckScreenHandler() != null) {
            this.cNJ.getStuckScreenHandler().a(0, v8ExceptionInfo);
        }
    }

    public void runOnGLThread(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "runOnGLThread");
        }
        if (this.cNJ != null) {
            this.cNJ.runOnGLThread(runnable);
        }
    }

    public void queueEvent(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent");
        }
        if (this.cNJ != null) {
            this.cNJ.queueEvent(runnable);
        }
    }

    public void queueEvent(Runnable runnable, long j) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent delayed");
        }
        if (this.cNJ != null) {
            this.cNJ.queueEvent(runnable, j);
        }
    }

    public void clearOldEvents() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "executeQueueEvent");
        }
        if (this.cNJ != null) {
            this.cNJ.clearOldEvents();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.cNJ != null) {
            this.cNJ.onAttachedToWindow();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDetachedFromWindow");
        }
        if (this.cNJ != null) {
            this.cNJ.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cNL.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void finalize() throws Throwable {
        if (this.cNJ != null) {
            this.cNJ.setFirstFrameListener(null);
            this.cNJ.setOnStuckScreenListener(null);
            this.cNJ.exitGLThread();
            this.cNJ = null;
        }
    }

    private void awH() {
        this.mDrawHeight = 0;
        this.mDrawWidth = 0;
    }

    @Override // com.baidu.smallgame.sdk.ArBridge.FirstFrameListener
    public void onFirstFrameFinished() {
        awI();
        SwanAppActivity aeu = com.baidu.swan.apps.y.f.aeJ().aeu();
        if (aeu != null) {
            com.baidu.swan.apps.framework.c Om = aeu.Om();
            if (Om instanceof com.baidu.swan.games.i.b) {
                ((com.baidu.swan.games.i.b) Om).onFirstFrameFinished();
            }
        }
    }

    public void awI() {
        if (this.cNK != null) {
            com.baidu.swan.games.u.d.G(this.cNK.getPerformanceJson());
        }
        if (this.cNJ != null) {
            com.baidu.swan.games.u.d.G(this.cNJ.getPerformanceJson());
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
            if (DuMixGameSurfaceView.this.cNJ != null) {
                DuMixGameSurfaceView.this.cNJ.smallGameUpdate();
                if (DuMixGameSurfaceView.this.cNM != null) {
                    if (DuMixGameSurfaceView.this.cNN) {
                        DuMixGameSurfaceView.this.cNM.b(DuMixGameSurfaceView.this.getScreenShot(), DuMixGameSurfaceView.this.mDrawWidth, DuMixGameSurfaceView.this.mDrawHeight);
                        DuMixGameSurfaceView.this.cNJ.setScreenShotStatus(false);
                        DuMixGameSurfaceView.this.cNN = false;
                        DuMixGameSurfaceView.this.cNM = null;
                    }
                    if (DuMixGameSurfaceView.this.cNM != null) {
                        DuMixGameSurfaceView.this.cNJ.setScreenShotStatus(true);
                        DuMixGameSurfaceView.this.cNN = true;
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
