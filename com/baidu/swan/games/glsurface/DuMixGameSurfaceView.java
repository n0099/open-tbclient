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
    private AREngineDelegate eiL;
    private com.baidu.swan.games.f.a eiM;
    private com.baidu.swan.games.glsurface.a.a eiN;
    private volatile b eiO;
    private boolean eiP;
    private GameRecorderController eiQ;
    private int mDrawHeight;
    private int mDrawWidth;

    /* loaded from: classes8.dex */
    public interface b {
        void b(int[] iArr, int i, int i2);
    }

    static {
        d.aZb();
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
        i.qr("preload").f(new UbcFlowEvent("na_game_engine_start"));
        this.eiL = MarioSDK.createAREngine(aVar);
        this.eiL.setPermissionProxy(new e());
        this.eiL.setOnStuckScreenListener(new com.baidu.smallgame.sdk.b.a() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.1
            @Override // com.baidu.smallgame.sdk.b.a
            public void a(com.baidu.smallgame.sdk.b.b bVar) {
                com.baidu.swan.games.x.b.b(bVar);
            }

            @Override // com.baidu.smallgame.sdk.b.a
            public void afG() {
                com.baidu.swan.games.glsurface.a.b.aXd();
            }
        });
        this.eiL.startEngine();
        i.qr("preload").f(new UbcFlowEvent("na_game_engine_end"));
        this.eiN = new com.baidu.swan.games.glsurface.a.a();
        this.eiQ = new GameRecorderController(this.eiL);
        com.baidu.swan.games.screenrecord.d.aYa().g(this.eiQ);
    }

    private void setRenderer(GLSurfaceView.Renderer renderer) {
        if (this.eiL != null) {
            this.eiL.setRenderer(renderer);
        }
    }

    public void setRenderMode(int i) {
        if (this.eiL != null) {
            this.eiL.setRenderMode(i);
        }
    }

    public int getFPS() {
        if (this.eiL == null) {
            return 0;
        }
        return this.eiL.getFPS();
    }

    public void aWX() {
        Pair<Integer, Integer> aAb = f.aAo().aAb();
        if (this.eiL != null) {
            this.eiL.updateSurfaceViewSize(((Integer) aAb.first).intValue(), ((Integer) aAb.second).intValue());
            this.eiL.initDisplayMetrics();
        }
        if (this.eiN != null) {
            this.eiN.au(((Integer) aAb.first).intValue(), ((Integer) aAb.second).intValue());
        }
    }

    public void aWY() {
        surfaceChanged(getHolder(), 0, getWidth(), getHeight());
    }

    public com.baidu.swan.games.f.a getV8Engine() {
        return this.eiM;
    }

    public void setV8Engine(com.baidu.swan.games.f.a aVar) {
        this.eiM = aVar;
        this.eiN.setV8Engine(this.eiM);
    }

    public Thread getThread() {
        if (this.eiL != null) {
            return this.eiL.getGLThread();
        }
        return null;
    }

    public int getRenderMode() {
        if (this.eiL != null) {
            return this.eiL.getRenderMode();
        }
        return 1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceCreated");
        }
        if (this.eiL != null) {
            this.eiL.surfaceCreated();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceChanged width: " + i2 + ", height: " + i3);
        }
        if (this.eiL != null) {
            this.eiL.surfaceChanged(i2, i3);
        }
        if (this.eiN != null) {
            this.eiN.av(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceDestroyed width");
        }
        aWZ();
        if (this.eiL != null) {
            this.eiL.surfaceDestroyed();
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        if (this.eiL != null) {
            this.eiL.requestRenderAndWait();
        }
    }

    public void onPause() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_PAUSE);
        }
        queueEvent(new Runnable() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                if (DuMixGameSurfaceView.this.eiL != null) {
                    DuMixGameSurfaceView.this.eiL.smallGameOnPause();
                }
            }
        });
        if (this.eiL != null) {
            this.eiL.onPause();
        }
        com.baidu.swan.games.screenrecord.d.aYa().aYd();
    }

    public void onResume() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_RESUME);
        }
        if (this.eiL != null) {
            this.eiL.onResume();
        }
        com.baidu.swan.games.screenrecord.d.aYa().aYe();
    }

    public void onDestroy() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_DESTROY);
        }
        aWZ();
        com.baidu.swan.games.screenrecord.d.aYa().h(this.eiQ);
        if (this.eiL != null) {
            if (this.eiM != null) {
                this.eiM.finish();
            }
            this.eiL.setFirstFrameListener(null);
            this.eiL.setOnStuckScreenListener(null);
            this.eiL.smallGameDestroy();
        }
    }

    public void d(V8ExceptionInfo v8ExceptionInfo) {
        if (this.eiL != null && this.eiL.getStuckScreenHandler() != null) {
            this.eiL.getStuckScreenHandler().a(0, v8ExceptionInfo);
        }
    }

    public void runOnGLThread(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "runOnGLThread");
        }
        if (this.eiL != null) {
            this.eiL.runOnGLThread(runnable);
        }
    }

    public void queueEvent(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent");
        }
        if (this.eiL != null) {
            this.eiL.queueEvent(runnable);
        }
    }

    public void queueEvent(Runnable runnable, long j) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent delayed");
        }
        if (this.eiL != null) {
            this.eiL.queueEvent(runnable, j);
        }
    }

    public void clearOldEvents() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "executeQueueEvent");
        }
        if (this.eiL != null) {
            this.eiL.clearOldEvents();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.eiL != null) {
            this.eiL.onAttachedToWindow();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDetachedFromWindow");
        }
        if (this.eiL != null) {
            this.eiL.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.eiN.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void finalize() throws Throwable {
        if (this.eiL != null) {
            if (this.eiM != null) {
                this.eiM.finish();
            }
            this.eiL.setFirstFrameListener(null);
            this.eiL.setOnStuckScreenListener(null);
            this.eiL.exitGLThread();
            this.eiL = null;
        }
    }

    private void aWZ() {
        this.mDrawHeight = 0;
        this.mDrawWidth = 0;
    }

    @Override // com.baidu.smallgame.sdk.ArBridge.FirstFrameListener
    public void onFirstFrameFinished() {
        aXa();
        SwanAppActivity azY = f.aAo().azY();
        if (azY != null) {
            c afT = azY.afT();
            if (afT instanceof com.baidu.swan.games.j.b) {
                ((com.baidu.swan.games.j.b) afT).onFirstFrameFinished();
            }
        }
    }

    public void aXa() {
        if (this.eiM != null) {
            com.baidu.swan.games.v.d.I(this.eiM.getPerformanceJson());
        }
        if (this.eiL != null) {
            com.baidu.swan.games.v.d.I(this.eiL.getPerformanceJson());
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
            if (DuMixGameSurfaceView.this.eiL != null) {
                DuMixGameSurfaceView.this.eiL.smallGameUpdate();
                if (DuMixGameSurfaceView.this.eiO != null) {
                    if (DuMixGameSurfaceView.this.eiP) {
                        DuMixGameSurfaceView.this.eiO.b(DuMixGameSurfaceView.this.getScreenShot(), DuMixGameSurfaceView.this.mDrawWidth, DuMixGameSurfaceView.this.mDrawHeight);
                        DuMixGameSurfaceView.this.eiL.setScreenShotStatus(false);
                        DuMixGameSurfaceView.this.eiP = false;
                        DuMixGameSurfaceView.this.eiO = null;
                    }
                    if (DuMixGameSurfaceView.this.eiO != null) {
                        DuMixGameSurfaceView.this.eiL.setScreenShotStatus(true);
                        DuMixGameSurfaceView.this.eiP = true;
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
