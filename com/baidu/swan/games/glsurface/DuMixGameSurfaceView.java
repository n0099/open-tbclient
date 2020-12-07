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
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.smallgame.sdk.ArBridge;
import com.baidu.smallgame.sdk.MarioSDK;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.framework.c;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.f.c.e;
import com.baidu.swan.games.screenrecord.GameRecorderController;
import com.baidu.swan.games.utils.so.d;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes25.dex */
public class DuMixGameSurfaceView extends SurfaceView implements SurfaceHolder.Callback2, ArBridge.FirstFrameListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private AREngineDelegate eaS;
    private com.baidu.swan.games.f.a eaT;
    private com.baidu.swan.games.glsurface.a.a eaU;
    private volatile b eaV;
    private boolean eaW;
    private GameRecorderController eaX;
    private int mDrawHeight;
    private int mDrawWidth;

    /* loaded from: classes25.dex */
    public interface b {
        void a(int[] iArr, int i, int i2);
    }

    static {
        d.bal();
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
            Log.d("DuMixGameSurfaceView", OneKeyLoginSdkCall.l);
        }
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        MarioSDK.a aVar = new MarioSDK.a();
        aVar.c(holder);
        aVar.setFirstFrameListener(this);
        aVar.setRenderer(new a());
        aVar.setContext(AppRuntime.getAppContext());
        aVar.addDebugConsole(new com.baidu.swan.games.glsurface.a());
        i.rk("preload").f(new UbcFlowEvent("na_game_engine_start"));
        this.eaS = MarioSDK.createAREngine(aVar);
        this.eaS.setPermissionProxy(new e());
        this.eaS.setOnStuckScreenListener(new com.baidu.smallgame.sdk.b.a() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.1
            @Override // com.baidu.smallgame.sdk.b.a
            public void a(com.baidu.smallgame.sdk.b.b bVar) {
                com.baidu.swan.games.x.b.b(bVar);
            }

            @Override // com.baidu.smallgame.sdk.b.a
            public void ahO() {
                com.baidu.swan.games.glsurface.a.b.aYn();
            }
        });
        this.eaS.startEngine();
        i.rk("preload").f(new UbcFlowEvent("na_game_engine_end"));
        this.eaU = new com.baidu.swan.games.glsurface.a.a();
        this.eaX = new GameRecorderController(this.eaS);
        com.baidu.swan.games.screenrecord.d.aZk().g(this.eaX);
    }

    private void setRenderer(GLSurfaceView.Renderer renderer) {
        if (this.eaS != null) {
            this.eaS.setRenderer(renderer);
        }
    }

    public void setRenderMode(int i) {
        if (this.eaS != null) {
            this.eaS.setRenderMode(i);
        }
    }

    public int getFPS() {
        if (this.eaS == null) {
            return 0;
        }
        return this.eaS.getFPS();
    }

    public void aYh() {
        Pair<Integer, Integer> aCc = f.aCp().aCc();
        if (this.eaS != null) {
            this.eaS.updateSurfaceViewSize(((Integer) aCc.first).intValue(), ((Integer) aCc.second).intValue());
            this.eaS.initDisplayMetrics();
        }
        if (this.eaU != null) {
            this.eaU.aA(((Integer) aCc.first).intValue(), ((Integer) aCc.second).intValue());
        }
    }

    public void aYi() {
        surfaceChanged(getHolder(), 0, getWidth(), getHeight());
    }

    public com.baidu.swan.games.f.a getV8Engine() {
        return this.eaT;
    }

    public void setV8Engine(com.baidu.swan.games.f.a aVar) {
        this.eaT = aVar;
        this.eaU.setV8Engine(this.eaT);
    }

    public Thread getThread() {
        if (this.eaS != null) {
            return this.eaS.getGLThread();
        }
        return null;
    }

    public int getRenderMode() {
        if (this.eaS != null) {
            return this.eaS.getRenderMode();
        }
        return 1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceCreated");
        }
        if (this.eaS != null) {
            this.eaS.surfaceCreated();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceChanged width: " + i2 + ", height: " + i3);
        }
        if (this.eaS != null) {
            this.eaS.surfaceChanged(i2, i3);
        }
        if (this.eaU != null) {
            this.eaU.aB(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceDestroyed width");
        }
        aYj();
        if (this.eaS != null) {
            this.eaS.surfaceDestroyed();
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        if (this.eaS != null) {
            this.eaS.requestRenderAndWait();
        }
    }

    public void onPause() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_PAUSE);
        }
        queueEvent(new Runnable() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                if (DuMixGameSurfaceView.this.eaS != null) {
                    DuMixGameSurfaceView.this.eaS.smallGameOnPause();
                }
            }
        });
        if (this.eaS != null) {
            this.eaS.onPause();
        }
        com.baidu.swan.games.screenrecord.d.aZk().aZn();
    }

    public void onResume() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_RESUME);
        }
        if (this.eaS != null) {
            this.eaS.onResume();
        }
        com.baidu.swan.games.screenrecord.d.aZk().aZo();
    }

    public void onDestroy() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_DESTROY);
        }
        aYj();
        com.baidu.swan.games.screenrecord.d.aZk().h(this.eaX);
        if (this.eaS != null) {
            if (this.eaT != null) {
                this.eaT.finish();
            }
            this.eaS.setFirstFrameListener(null);
            this.eaS.setOnStuckScreenListener(null);
            this.eaS.smallGameDestroy();
        }
    }

    public void d(V8ExceptionInfo v8ExceptionInfo) {
        if (this.eaS != null && this.eaS.getStuckScreenHandler() != null) {
            this.eaS.getStuckScreenHandler().a(0, v8ExceptionInfo);
        }
    }

    public void runOnGLThread(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "runOnGLThread");
        }
        if (this.eaS != null) {
            this.eaS.runOnGLThread(runnable);
        }
    }

    public void queueEvent(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent");
        }
        if (this.eaS != null) {
            this.eaS.queueEvent(runnable);
        }
    }

    public void queueEvent(Runnable runnable, long j) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent delayed");
        }
        if (this.eaS != null) {
            this.eaS.queueEvent(runnable, j);
        }
    }

    public void clearOldEvents() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "executeQueueEvent");
        }
        if (this.eaS != null) {
            this.eaS.clearOldEvents();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.eaS != null) {
            this.eaS.onAttachedToWindow();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDetachedFromWindow");
        }
        if (this.eaS != null) {
            this.eaS.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.eaU.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void finalize() throws Throwable {
        if (this.eaS != null) {
            if (this.eaT != null) {
                this.eaT.finish();
            }
            this.eaS.setFirstFrameListener(null);
            this.eaS.setOnStuckScreenListener(null);
            this.eaS.exitGLThread();
            this.eaS = null;
        }
    }

    private void aYj() {
        this.mDrawHeight = 0;
        this.mDrawWidth = 0;
    }

    @Override // com.baidu.smallgame.sdk.ArBridge.FirstFrameListener
    public void onFirstFrameFinished() {
        aYk();
        SwanAppActivity aBZ = f.aCp().aBZ();
        if (aBZ != null) {
            c aif = aBZ.aif();
            if (aif instanceof com.baidu.swan.games.j.b) {
                ((com.baidu.swan.games.j.b) aif).onFirstFrameFinished();
            }
        }
    }

    public void aYk() {
        if (this.eaT != null) {
            com.baidu.swan.games.v.d.J(this.eaT.getPerformanceJson());
        }
        if (this.eaS != null) {
            com.baidu.swan.games.v.d.J(this.eaS.getPerformanceJson());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
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
            if (DuMixGameSurfaceView.this.eaS != null) {
                DuMixGameSurfaceView.this.eaS.smallGameUpdate();
                if (DuMixGameSurfaceView.this.eaV != null) {
                    if (DuMixGameSurfaceView.this.eaW) {
                        DuMixGameSurfaceView.this.eaV.a(DuMixGameSurfaceView.this.getScreenShot(), DuMixGameSurfaceView.this.mDrawWidth, DuMixGameSurfaceView.this.mDrawHeight);
                        DuMixGameSurfaceView.this.eaS.setScreenShotStatus(false);
                        DuMixGameSurfaceView.this.eaW = false;
                        DuMixGameSurfaceView.this.eaV = null;
                    }
                    if (DuMixGameSurfaceView.this.eaV != null) {
                        DuMixGameSurfaceView.this.eaS.setScreenShotStatus(true);
                        DuMixGameSurfaceView.this.eaW = true;
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
