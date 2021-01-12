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
/* loaded from: classes8.dex */
public class DuMixGameSurfaceView extends SurfaceView implements SurfaceHolder.Callback2, ArBridge.FirstFrameListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private AREngineDelegate efc;
    private com.baidu.swan.games.f.a efd;
    private com.baidu.swan.games.glsurface.a.a efe;
    private volatile b eff;
    private boolean efg;
    private GameRecorderController efh;
    private int mDrawHeight;
    private int mDrawWidth;

    /* loaded from: classes8.dex */
    public interface b {
        void b(int[] iArr, int i, int i2);
    }

    static {
        d.aYM();
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
        i.pS("preload").f(new UbcFlowEvent("na_game_engine_start"));
        this.efc = MarioSDK.createAREngine(aVar);
        this.efc.setPermissionProxy(new e());
        this.efc.setOnStuckScreenListener(new com.baidu.smallgame.sdk.b.a() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.1
            @Override // com.baidu.smallgame.sdk.b.a
            public void a(com.baidu.smallgame.sdk.b.b bVar) {
                com.baidu.swan.games.x.b.b(bVar);
            }

            @Override // com.baidu.smallgame.sdk.b.a
            public void afe() {
                com.baidu.swan.games.glsurface.a.b.aWO();
            }
        });
        this.efc.startEngine();
        i.pS("preload").f(new UbcFlowEvent("na_game_engine_end"));
        this.efe = new com.baidu.swan.games.glsurface.a.a();
        this.efh = new GameRecorderController(this.efc);
        com.baidu.swan.games.screenrecord.d.aXL().g(this.efh);
    }

    private void setRenderer(GLSurfaceView.Renderer renderer) {
        if (this.efc != null) {
            this.efc.setRenderer(renderer);
        }
    }

    public void setRenderMode(int i) {
        if (this.efc != null) {
            this.efc.setRenderMode(i);
        }
    }

    public int getFPS() {
        if (this.efc == null) {
            return 0;
        }
        return this.efc.getFPS();
    }

    public void aWI() {
        Pair<Integer, Integer> azA = f.azN().azA();
        if (this.efc != null) {
            this.efc.updateSurfaceViewSize(((Integer) azA.first).intValue(), ((Integer) azA.second).intValue());
            this.efc.initDisplayMetrics();
        }
        if (this.efe != null) {
            this.efe.ax(((Integer) azA.first).intValue(), ((Integer) azA.second).intValue());
        }
    }

    public void aWJ() {
        surfaceChanged(getHolder(), 0, getWidth(), getHeight());
    }

    public com.baidu.swan.games.f.a getV8Engine() {
        return this.efd;
    }

    public void setV8Engine(com.baidu.swan.games.f.a aVar) {
        this.efd = aVar;
        this.efe.setV8Engine(this.efd);
    }

    public Thread getThread() {
        if (this.efc != null) {
            return this.efc.getGLThread();
        }
        return null;
    }

    public int getRenderMode() {
        if (this.efc != null) {
            return this.efc.getRenderMode();
        }
        return 1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceCreated");
        }
        if (this.efc != null) {
            this.efc.surfaceCreated();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceChanged width: " + i2 + ", height: " + i3);
        }
        if (this.efc != null) {
            this.efc.surfaceChanged(i2, i3);
        }
        if (this.efe != null) {
            this.efe.ay(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceDestroyed width");
        }
        aWK();
        if (this.efc != null) {
            this.efc.surfaceDestroyed();
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        if (this.efc != null) {
            this.efc.requestRenderAndWait();
        }
    }

    public void onPause() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_PAUSE);
        }
        queueEvent(new Runnable() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                if (DuMixGameSurfaceView.this.efc != null) {
                    DuMixGameSurfaceView.this.efc.smallGameOnPause();
                }
            }
        });
        if (this.efc != null) {
            this.efc.onPause();
        }
        com.baidu.swan.games.screenrecord.d.aXL().aXO();
    }

    public void onResume() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_RESUME);
        }
        if (this.efc != null) {
            this.efc.onResume();
        }
        com.baidu.swan.games.screenrecord.d.aXL().aXP();
    }

    public void onDestroy() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_DESTROY);
        }
        aWK();
        com.baidu.swan.games.screenrecord.d.aXL().h(this.efh);
        if (this.efc != null) {
            if (this.efd != null) {
                this.efd.finish();
            }
            this.efc.setFirstFrameListener(null);
            this.efc.setOnStuckScreenListener(null);
            this.efc.smallGameDestroy();
        }
    }

    public void d(V8ExceptionInfo v8ExceptionInfo) {
        if (this.efc != null && this.efc.getStuckScreenHandler() != null) {
            this.efc.getStuckScreenHandler().a(0, v8ExceptionInfo);
        }
    }

    public void runOnGLThread(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "runOnGLThread");
        }
        if (this.efc != null) {
            this.efc.runOnGLThread(runnable);
        }
    }

    public void queueEvent(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent");
        }
        if (this.efc != null) {
            this.efc.queueEvent(runnable);
        }
    }

    public void queueEvent(Runnable runnable, long j) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent delayed");
        }
        if (this.efc != null) {
            this.efc.queueEvent(runnable, j);
        }
    }

    public void clearOldEvents() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "executeQueueEvent");
        }
        if (this.efc != null) {
            this.efc.clearOldEvents();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.efc != null) {
            this.efc.onAttachedToWindow();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDetachedFromWindow");
        }
        if (this.efc != null) {
            this.efc.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.efe.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void finalize() throws Throwable {
        if (this.efc != null) {
            if (this.efd != null) {
                this.efd.finish();
            }
            this.efc.setFirstFrameListener(null);
            this.efc.setOnStuckScreenListener(null);
            this.efc.exitGLThread();
            this.efc = null;
        }
    }

    private void aWK() {
        this.mDrawHeight = 0;
        this.mDrawWidth = 0;
    }

    @Override // com.baidu.smallgame.sdk.ArBridge.FirstFrameListener
    public void onFirstFrameFinished() {
        aWL();
        SwanAppActivity azx = f.azN().azx();
        if (azx != null) {
            c afs = azx.afs();
            if (afs instanceof com.baidu.swan.games.j.b) {
                ((com.baidu.swan.games.j.b) afs).onFirstFrameFinished();
            }
        }
    }

    public void aWL() {
        if (this.efd != null) {
            com.baidu.swan.games.v.d.J(this.efd.getPerformanceJson());
        }
        if (this.efc != null) {
            com.baidu.swan.games.v.d.J(this.efc.getPerformanceJson());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
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
            if (DuMixGameSurfaceView.this.efc != null) {
                DuMixGameSurfaceView.this.efc.smallGameUpdate();
                if (DuMixGameSurfaceView.this.eff != null) {
                    if (DuMixGameSurfaceView.this.efg) {
                        DuMixGameSurfaceView.this.eff.b(DuMixGameSurfaceView.this.getScreenShot(), DuMixGameSurfaceView.this.mDrawWidth, DuMixGameSurfaceView.this.mDrawHeight);
                        DuMixGameSurfaceView.this.efc.setScreenShotStatus(false);
                        DuMixGameSurfaceView.this.efg = false;
                        DuMixGameSurfaceView.this.eff = null;
                    }
                    if (DuMixGameSurfaceView.this.eff != null) {
                        DuMixGameSurfaceView.this.efc.setScreenShotStatus(true);
                        DuMixGameSurfaceView.this.efg = true;
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
