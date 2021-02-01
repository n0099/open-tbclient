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
/* loaded from: classes9.dex */
public class DuMixGameSurfaceView extends SurfaceView implements SurfaceHolder.Callback2, ArBridge.FirstFrameListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private AREngineDelegate ehk;
    private com.baidu.swan.games.f.a ehl;
    private com.baidu.swan.games.glsurface.a.a ehm;
    private volatile b ehn;
    private boolean eho;
    private GameRecorderController ehp;
    private int mDrawHeight;
    private int mDrawWidth;

    /* loaded from: classes9.dex */
    public interface b {
        void b(int[] iArr, int i, int i2);
    }

    static {
        d.aYY();
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
        i.qk("preload").f(new UbcFlowEvent("na_game_engine_start"));
        this.ehk = MarioSDK.createAREngine(aVar);
        this.ehk.setPermissionProxy(new e());
        this.ehk.setOnStuckScreenListener(new com.baidu.smallgame.sdk.b.a() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.1
            @Override // com.baidu.smallgame.sdk.b.a
            public void a(com.baidu.smallgame.sdk.b.b bVar) {
                com.baidu.swan.games.x.b.b(bVar);
            }

            @Override // com.baidu.smallgame.sdk.b.a
            public void afD() {
                com.baidu.swan.games.glsurface.a.b.aXa();
            }
        });
        this.ehk.startEngine();
        i.qk("preload").f(new UbcFlowEvent("na_game_engine_end"));
        this.ehm = new com.baidu.swan.games.glsurface.a.a();
        this.ehp = new GameRecorderController(this.ehk);
        com.baidu.swan.games.screenrecord.d.aXX().g(this.ehp);
    }

    private void setRenderer(GLSurfaceView.Renderer renderer) {
        if (this.ehk != null) {
            this.ehk.setRenderer(renderer);
        }
    }

    public void setRenderMode(int i) {
        if (this.ehk != null) {
            this.ehk.setRenderMode(i);
        }
    }

    public int getFPS() {
        if (this.ehk == null) {
            return 0;
        }
        return this.ehk.getFPS();
    }

    public void aWU() {
        Pair<Integer, Integer> azY = f.aAl().azY();
        if (this.ehk != null) {
            this.ehk.updateSurfaceViewSize(((Integer) azY.first).intValue(), ((Integer) azY.second).intValue());
            this.ehk.initDisplayMetrics();
        }
        if (this.ehm != null) {
            this.ehm.au(((Integer) azY.first).intValue(), ((Integer) azY.second).intValue());
        }
    }

    public void aWV() {
        surfaceChanged(getHolder(), 0, getWidth(), getHeight());
    }

    public com.baidu.swan.games.f.a getV8Engine() {
        return this.ehl;
    }

    public void setV8Engine(com.baidu.swan.games.f.a aVar) {
        this.ehl = aVar;
        this.ehm.setV8Engine(this.ehl);
    }

    public Thread getThread() {
        if (this.ehk != null) {
            return this.ehk.getGLThread();
        }
        return null;
    }

    public int getRenderMode() {
        if (this.ehk != null) {
            return this.ehk.getRenderMode();
        }
        return 1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceCreated");
        }
        if (this.ehk != null) {
            this.ehk.surfaceCreated();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceChanged width: " + i2 + ", height: " + i3);
        }
        if (this.ehk != null) {
            this.ehk.surfaceChanged(i2, i3);
        }
        if (this.ehm != null) {
            this.ehm.av(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceDestroyed width");
        }
        aWW();
        if (this.ehk != null) {
            this.ehk.surfaceDestroyed();
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        if (this.ehk != null) {
            this.ehk.requestRenderAndWait();
        }
    }

    public void onPause() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_PAUSE);
        }
        queueEvent(new Runnable() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                if (DuMixGameSurfaceView.this.ehk != null) {
                    DuMixGameSurfaceView.this.ehk.smallGameOnPause();
                }
            }
        });
        if (this.ehk != null) {
            this.ehk.onPause();
        }
        com.baidu.swan.games.screenrecord.d.aXX().aYa();
    }

    public void onResume() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_RESUME);
        }
        if (this.ehk != null) {
            this.ehk.onResume();
        }
        com.baidu.swan.games.screenrecord.d.aXX().aYb();
    }

    public void onDestroy() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_DESTROY);
        }
        aWW();
        com.baidu.swan.games.screenrecord.d.aXX().h(this.ehp);
        if (this.ehk != null) {
            if (this.ehl != null) {
                this.ehl.finish();
            }
            this.ehk.setFirstFrameListener(null);
            this.ehk.setOnStuckScreenListener(null);
            this.ehk.smallGameDestroy();
        }
    }

    public void d(V8ExceptionInfo v8ExceptionInfo) {
        if (this.ehk != null && this.ehk.getStuckScreenHandler() != null) {
            this.ehk.getStuckScreenHandler().a(0, v8ExceptionInfo);
        }
    }

    public void runOnGLThread(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "runOnGLThread");
        }
        if (this.ehk != null) {
            this.ehk.runOnGLThread(runnable);
        }
    }

    public void queueEvent(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent");
        }
        if (this.ehk != null) {
            this.ehk.queueEvent(runnable);
        }
    }

    public void queueEvent(Runnable runnable, long j) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent delayed");
        }
        if (this.ehk != null) {
            this.ehk.queueEvent(runnable, j);
        }
    }

    public void clearOldEvents() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "executeQueueEvent");
        }
        if (this.ehk != null) {
            this.ehk.clearOldEvents();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.ehk != null) {
            this.ehk.onAttachedToWindow();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDetachedFromWindow");
        }
        if (this.ehk != null) {
            this.ehk.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.ehm.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void finalize() throws Throwable {
        if (this.ehk != null) {
            if (this.ehl != null) {
                this.ehl.finish();
            }
            this.ehk.setFirstFrameListener(null);
            this.ehk.setOnStuckScreenListener(null);
            this.ehk.exitGLThread();
            this.ehk = null;
        }
    }

    private void aWW() {
        this.mDrawHeight = 0;
        this.mDrawWidth = 0;
    }

    @Override // com.baidu.smallgame.sdk.ArBridge.FirstFrameListener
    public void onFirstFrameFinished() {
        aWX();
        SwanAppActivity azV = f.aAl().azV();
        if (azV != null) {
            c afQ = azV.afQ();
            if (afQ instanceof com.baidu.swan.games.j.b) {
                ((com.baidu.swan.games.j.b) afQ).onFirstFrameFinished();
            }
        }
    }

    public void aWX() {
        if (this.ehl != null) {
            com.baidu.swan.games.v.d.I(this.ehl.getPerformanceJson());
        }
        if (this.ehk != null) {
            com.baidu.swan.games.v.d.I(this.ehk.getPerformanceJson());
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
            if (DuMixGameSurfaceView.this.ehk != null) {
                DuMixGameSurfaceView.this.ehk.smallGameUpdate();
                if (DuMixGameSurfaceView.this.ehn != null) {
                    if (DuMixGameSurfaceView.this.eho) {
                        DuMixGameSurfaceView.this.ehn.b(DuMixGameSurfaceView.this.getScreenShot(), DuMixGameSurfaceView.this.mDrawWidth, DuMixGameSurfaceView.this.mDrawHeight);
                        DuMixGameSurfaceView.this.ehk.setScreenShotStatus(false);
                        DuMixGameSurfaceView.this.eho = false;
                        DuMixGameSurfaceView.this.ehn = null;
                    }
                    if (DuMixGameSurfaceView.this.ehn != null) {
                        DuMixGameSurfaceView.this.ehk.setScreenShotStatus(true);
                        DuMixGameSurfaceView.this.eho = true;
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
