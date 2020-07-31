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
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.f.c.e;
import com.baidu.swan.games.screenrecord.GameRecorderController;
import com.baidu.swan.games.utils.so.d;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes7.dex */
public class DuMixGameSurfaceView extends SurfaceView implements SurfaceHolder.Callback2, ArBridge.FirstFrameListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private AREngineDelegate diZ;
    private com.baidu.swan.games.f.a dja;
    private com.baidu.swan.games.glsurface.a.a djb;
    private volatile b djc;
    private boolean djd;
    private GameRecorderController dje;
    private int mDrawHeight;
    private int mDrawWidth;

    /* loaded from: classes7.dex */
    public interface b {
        void b(int[] iArr, int i, int i2);
    }

    static {
        d.aHi();
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
        i.mX("preload").f(new UbcFlowEvent("na_game_engine_start"));
        this.diZ = MarioSDK.createAREngine(aVar);
        this.diZ.setPermissionProxy(new e());
        this.diZ.setOnStuckScreenListener(new com.baidu.smallgame.sdk.b.a() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.1
            @Override // com.baidu.smallgame.sdk.b.a
            public void a(com.baidu.smallgame.sdk.b.b bVar) {
                com.baidu.swan.games.x.b.b(bVar);
            }

            @Override // com.baidu.smallgame.sdk.b.a
            public void RE() {
                com.baidu.swan.games.glsurface.a.b.aFn();
            }
        });
        this.diZ.startEngine();
        i.mX("preload").f(new UbcFlowEvent("na_game_engine_end"));
        this.djb = new com.baidu.swan.games.glsurface.a.a();
        this.dje = new GameRecorderController(this.diZ);
        com.baidu.swan.games.screenrecord.d.aGi().g(this.dje);
    }

    private void setRenderer(GLSurfaceView.Renderer renderer) {
        if (this.diZ != null) {
            this.diZ.setRenderer(renderer);
        }
    }

    public void setRenderMode(int i) {
        if (this.diZ != null) {
            this.diZ.setRenderMode(i);
        }
    }

    public int getFPS() {
        if (this.diZ == null) {
            return 0;
        }
        return this.diZ.getFPS();
    }

    public void aFh() {
        Pair<Integer, Integer> ake = f.akr().ake();
        if (this.diZ != null) {
            this.diZ.updateSurfaceViewSize(((Integer) ake.first).intValue(), ((Integer) ake.second).intValue());
            this.diZ.initDisplayMetrics();
        }
        if (this.djb != null) {
            this.djb.ar(((Integer) ake.first).intValue(), ((Integer) ake.second).intValue());
        }
    }

    public void aFi() {
        surfaceChanged(getHolder(), 0, getWidth(), getHeight());
    }

    public com.baidu.swan.games.f.a getV8Engine() {
        return this.dja;
    }

    public void setV8Engine(com.baidu.swan.games.f.a aVar) {
        this.dja = aVar;
        this.djb.setV8Engine(this.dja);
    }

    public Thread getThread() {
        if (this.diZ != null) {
            return this.diZ.getGLThread();
        }
        return null;
    }

    public int getRenderMode() {
        if (this.diZ != null) {
            return this.diZ.getRenderMode();
        }
        return 1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceCreated");
        }
        if (this.diZ != null) {
            this.diZ.surfaceCreated();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceChanged width: " + i2 + ", height: " + i3);
        }
        if (this.diZ != null) {
            this.diZ.surfaceChanged(i2, i3);
        }
        if (this.djb != null) {
            this.djb.as(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceDestroyed width");
        }
        aFj();
        if (this.diZ != null) {
            this.diZ.surfaceDestroyed();
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        if (this.diZ != null) {
            this.diZ.requestRenderAndWait();
        }
    }

    public void onPause() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_PAUSE);
        }
        queueEvent(new Runnable() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                if (DuMixGameSurfaceView.this.diZ != null) {
                    DuMixGameSurfaceView.this.diZ.smallGameOnPause();
                }
            }
        });
        if (this.diZ != null) {
            this.diZ.onPause();
        }
        com.baidu.swan.games.screenrecord.d.aGi().aGl();
    }

    public void onResume() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_RESUME);
        }
        if (this.diZ != null) {
            this.diZ.onResume();
        }
        com.baidu.swan.games.screenrecord.d.aGi().aGm();
    }

    public void onDestroy() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_DESTROY);
        }
        aFj();
        com.baidu.swan.games.screenrecord.d.aGi().h(this.dje);
        if (this.diZ != null) {
            if (this.dja != null) {
                this.dja.finish();
            }
            this.diZ.setFirstFrameListener(null);
            this.diZ.setOnStuckScreenListener(null);
            this.diZ.smallGameDestroy();
        }
    }

    public void d(V8ExceptionInfo v8ExceptionInfo) {
        if (this.diZ != null && this.diZ.getStuckScreenHandler() != null) {
            this.diZ.getStuckScreenHandler().a(0, v8ExceptionInfo);
        }
    }

    public void runOnGLThread(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "runOnGLThread");
        }
        if (this.diZ != null) {
            this.diZ.runOnGLThread(runnable);
        }
    }

    public void queueEvent(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent");
        }
        if (this.diZ != null) {
            this.diZ.queueEvent(runnable);
        }
    }

    public void queueEvent(Runnable runnable, long j) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent delayed");
        }
        if (this.diZ != null) {
            this.diZ.queueEvent(runnable, j);
        }
    }

    public void clearOldEvents() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "executeQueueEvent");
        }
        if (this.diZ != null) {
            this.diZ.clearOldEvents();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.diZ != null) {
            this.diZ.onAttachedToWindow();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDetachedFromWindow");
        }
        if (this.diZ != null) {
            this.diZ.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.djb.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void finalize() throws Throwable {
        if (this.diZ != null) {
            if (this.dja != null) {
                this.dja.finish();
            }
            this.diZ.setFirstFrameListener(null);
            this.diZ.setOnStuckScreenListener(null);
            this.diZ.exitGLThread();
            this.diZ = null;
        }
    }

    private void aFj() {
        this.mDrawHeight = 0;
        this.mDrawWidth = 0;
    }

    @Override // com.baidu.smallgame.sdk.ArBridge.FirstFrameListener
    public void onFirstFrameFinished() {
        aFk();
        SwanAppActivity akb = f.akr().akb();
        if (akb != null) {
            com.baidu.swan.apps.framework.c RV = akb.RV();
            if (RV instanceof com.baidu.swan.games.j.b) {
                ((com.baidu.swan.games.j.b) RV).onFirstFrameFinished();
            }
        }
    }

    public void aFk() {
        if (this.dja != null) {
            com.baidu.swan.games.v.d.G(this.dja.getPerformanceJson());
        }
        if (this.diZ != null) {
            com.baidu.swan.games.v.d.G(this.diZ.getPerformanceJson());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
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
            if (DuMixGameSurfaceView.this.diZ != null) {
                DuMixGameSurfaceView.this.diZ.smallGameUpdate();
                if (DuMixGameSurfaceView.this.djc != null) {
                    if (DuMixGameSurfaceView.this.djd) {
                        DuMixGameSurfaceView.this.djc.b(DuMixGameSurfaceView.this.getScreenShot(), DuMixGameSurfaceView.this.mDrawWidth, DuMixGameSurfaceView.this.mDrawHeight);
                        DuMixGameSurfaceView.this.diZ.setScreenShotStatus(false);
                        DuMixGameSurfaceView.this.djd = false;
                        DuMixGameSurfaceView.this.djc = null;
                    }
                    if (DuMixGameSurfaceView.this.djc != null) {
                        DuMixGameSurfaceView.this.diZ.setScreenShotStatus(true);
                        DuMixGameSurfaceView.this.djd = true;
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
