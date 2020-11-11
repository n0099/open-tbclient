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
/* loaded from: classes10.dex */
public class DuMixGameSurfaceView extends SurfaceView implements SurfaceHolder.Callback2, ArBridge.FirstFrameListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private AREngineDelegate dVC;
    private com.baidu.swan.games.f.a dVD;
    private com.baidu.swan.games.glsurface.a.a dVE;
    private volatile b dVF;
    private boolean dVG;
    private GameRecorderController dVH;
    private int mDrawHeight;
    private int mDrawWidth;

    /* loaded from: classes10.dex */
    public interface b {
        void a(int[] iArr, int i, int i2);
    }

    static {
        d.aXO();
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
        i.qJ("preload").f(new UbcFlowEvent("na_game_engine_start"));
        this.dVC = MarioSDK.createAREngine(aVar);
        this.dVC.setPermissionProxy(new e());
        this.dVC.setOnStuckScreenListener(new com.baidu.smallgame.sdk.b.a() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.1
            @Override // com.baidu.smallgame.sdk.b.a
            public void a(com.baidu.smallgame.sdk.b.b bVar) {
                com.baidu.swan.games.x.b.b(bVar);
            }

            @Override // com.baidu.smallgame.sdk.b.a
            public void afo() {
                com.baidu.swan.games.glsurface.a.b.aVQ();
            }
        });
        this.dVC.startEngine();
        i.qJ("preload").f(new UbcFlowEvent("na_game_engine_end"));
        this.dVE = new com.baidu.swan.games.glsurface.a.a();
        this.dVH = new GameRecorderController(this.dVC);
        com.baidu.swan.games.screenrecord.d.aWN().g(this.dVH);
    }

    private void setRenderer(GLSurfaceView.Renderer renderer) {
        if (this.dVC != null) {
            this.dVC.setRenderer(renderer);
        }
    }

    public void setRenderMode(int i) {
        if (this.dVC != null) {
            this.dVC.setRenderMode(i);
        }
    }

    public int getFPS() {
        if (this.dVC == null) {
            return 0;
        }
        return this.dVC.getFPS();
    }

    public void aVK() {
        Pair<Integer, Integer> azB = f.azO().azB();
        if (this.dVC != null) {
            this.dVC.updateSurfaceViewSize(((Integer) azB.first).intValue(), ((Integer) azB.second).intValue());
            this.dVC.initDisplayMetrics();
        }
        if (this.dVE != null) {
            this.dVE.ay(((Integer) azB.first).intValue(), ((Integer) azB.second).intValue());
        }
    }

    public void aVL() {
        surfaceChanged(getHolder(), 0, getWidth(), getHeight());
    }

    public com.baidu.swan.games.f.a getV8Engine() {
        return this.dVD;
    }

    public void setV8Engine(com.baidu.swan.games.f.a aVar) {
        this.dVD = aVar;
        this.dVE.setV8Engine(this.dVD);
    }

    public Thread getThread() {
        if (this.dVC != null) {
            return this.dVC.getGLThread();
        }
        return null;
    }

    public int getRenderMode() {
        if (this.dVC != null) {
            return this.dVC.getRenderMode();
        }
        return 1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceCreated");
        }
        if (this.dVC != null) {
            this.dVC.surfaceCreated();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceChanged width: " + i2 + ", height: " + i3);
        }
        if (this.dVC != null) {
            this.dVC.surfaceChanged(i2, i3);
        }
        if (this.dVE != null) {
            this.dVE.az(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceDestroyed width");
        }
        aVM();
        if (this.dVC != null) {
            this.dVC.surfaceDestroyed();
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        if (this.dVC != null) {
            this.dVC.requestRenderAndWait();
        }
    }

    public void onPause() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_PAUSE);
        }
        queueEvent(new Runnable() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                if (DuMixGameSurfaceView.this.dVC != null) {
                    DuMixGameSurfaceView.this.dVC.smallGameOnPause();
                }
            }
        });
        if (this.dVC != null) {
            this.dVC.onPause();
        }
        com.baidu.swan.games.screenrecord.d.aWN().aWQ();
    }

    public void onResume() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_RESUME);
        }
        if (this.dVC != null) {
            this.dVC.onResume();
        }
        com.baidu.swan.games.screenrecord.d.aWN().aWR();
    }

    public void onDestroy() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_DESTROY);
        }
        aVM();
        com.baidu.swan.games.screenrecord.d.aWN().h(this.dVH);
        if (this.dVC != null) {
            if (this.dVD != null) {
                this.dVD.finish();
            }
            this.dVC.setFirstFrameListener(null);
            this.dVC.setOnStuckScreenListener(null);
            this.dVC.smallGameDestroy();
        }
    }

    public void d(V8ExceptionInfo v8ExceptionInfo) {
        if (this.dVC != null && this.dVC.getStuckScreenHandler() != null) {
            this.dVC.getStuckScreenHandler().a(0, v8ExceptionInfo);
        }
    }

    public void runOnGLThread(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "runOnGLThread");
        }
        if (this.dVC != null) {
            this.dVC.runOnGLThread(runnable);
        }
    }

    public void queueEvent(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent");
        }
        if (this.dVC != null) {
            this.dVC.queueEvent(runnable);
        }
    }

    public void queueEvent(Runnable runnable, long j) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent delayed");
        }
        if (this.dVC != null) {
            this.dVC.queueEvent(runnable, j);
        }
    }

    public void clearOldEvents() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "executeQueueEvent");
        }
        if (this.dVC != null) {
            this.dVC.clearOldEvents();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.dVC != null) {
            this.dVC.onAttachedToWindow();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDetachedFromWindow");
        }
        if (this.dVC != null) {
            this.dVC.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.dVE.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void finalize() throws Throwable {
        if (this.dVC != null) {
            if (this.dVD != null) {
                this.dVD.finish();
            }
            this.dVC.setFirstFrameListener(null);
            this.dVC.setOnStuckScreenListener(null);
            this.dVC.exitGLThread();
            this.dVC = null;
        }
    }

    private void aVM() {
        this.mDrawHeight = 0;
        this.mDrawWidth = 0;
    }

    @Override // com.baidu.smallgame.sdk.ArBridge.FirstFrameListener
    public void onFirstFrameFinished() {
        aVN();
        SwanAppActivity azy = f.azO().azy();
        if (azy != null) {
            c afF = azy.afF();
            if (afF instanceof com.baidu.swan.games.j.b) {
                ((com.baidu.swan.games.j.b) afF).onFirstFrameFinished();
            }
        }
    }

    public void aVN() {
        if (this.dVD != null) {
            com.baidu.swan.games.v.d.I(this.dVD.getPerformanceJson());
        }
        if (this.dVC != null) {
            com.baidu.swan.games.v.d.I(this.dVC.getPerformanceJson());
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
            if (DuMixGameSurfaceView.this.dVC != null) {
                DuMixGameSurfaceView.this.dVC.smallGameUpdate();
                if (DuMixGameSurfaceView.this.dVF != null) {
                    if (DuMixGameSurfaceView.this.dVG) {
                        DuMixGameSurfaceView.this.dVF.a(DuMixGameSurfaceView.this.getScreenShot(), DuMixGameSurfaceView.this.mDrawWidth, DuMixGameSurfaceView.this.mDrawHeight);
                        DuMixGameSurfaceView.this.dVC.setScreenShotStatus(false);
                        DuMixGameSurfaceView.this.dVG = false;
                        DuMixGameSurfaceView.this.dVF = null;
                    }
                    if (DuMixGameSurfaceView.this.dVF != null) {
                        DuMixGameSurfaceView.this.dVC.setScreenShotStatus(true);
                        DuMixGameSurfaceView.this.dVG = true;
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
