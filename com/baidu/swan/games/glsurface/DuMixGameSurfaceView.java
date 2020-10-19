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
    private AREngineDelegate dHn;
    private com.baidu.swan.games.f.a dHo;
    private com.baidu.swan.games.glsurface.a.a dHp;
    private volatile b dHq;
    private boolean dHr;
    private GameRecorderController dHs;
    private int mDrawHeight;
    private int mDrawWidth;

    /* loaded from: classes10.dex */
    public interface b {
        void a(int[] iArr, int i, int i2);
    }

    static {
        d.aTu();
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
        i.qc("preload").f(new UbcFlowEvent("na_game_engine_start"));
        this.dHn = MarioSDK.createAREngine(aVar);
        this.dHn.setPermissionProxy(new e());
        this.dHn.setOnStuckScreenListener(new com.baidu.smallgame.sdk.b.a() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.1
            @Override // com.baidu.smallgame.sdk.b.a
            public void a(com.baidu.smallgame.sdk.b.b bVar) {
                com.baidu.swan.games.x.b.b(bVar);
            }

            @Override // com.baidu.smallgame.sdk.b.a
            public void aaU() {
                com.baidu.swan.games.glsurface.a.b.aRw();
            }
        });
        this.dHn.startEngine();
        i.qc("preload").f(new UbcFlowEvent("na_game_engine_end"));
        this.dHp = new com.baidu.swan.games.glsurface.a.a();
        this.dHs = new GameRecorderController(this.dHn);
        com.baidu.swan.games.screenrecord.d.aSt().g(this.dHs);
    }

    private void setRenderer(GLSurfaceView.Renderer renderer) {
        if (this.dHn != null) {
            this.dHn.setRenderer(renderer);
        }
    }

    public void setRenderMode(int i) {
        if (this.dHn != null) {
            this.dHn.setRenderMode(i);
        }
    }

    public int getFPS() {
        if (this.dHn == null) {
            return 0;
        }
        return this.dHn.getFPS();
    }

    public void aRq() {
        Pair<Integer, Integer> avh = f.avu().avh();
        if (this.dHn != null) {
            this.dHn.updateSurfaceViewSize(((Integer) avh.first).intValue(), ((Integer) avh.second).intValue());
            this.dHn.initDisplayMetrics();
        }
        if (this.dHp != null) {
            this.dHp.ax(((Integer) avh.first).intValue(), ((Integer) avh.second).intValue());
        }
    }

    public void aRr() {
        surfaceChanged(getHolder(), 0, getWidth(), getHeight());
    }

    public com.baidu.swan.games.f.a getV8Engine() {
        return this.dHo;
    }

    public void setV8Engine(com.baidu.swan.games.f.a aVar) {
        this.dHo = aVar;
        this.dHp.setV8Engine(this.dHo);
    }

    public Thread getThread() {
        if (this.dHn != null) {
            return this.dHn.getGLThread();
        }
        return null;
    }

    public int getRenderMode() {
        if (this.dHn != null) {
            return this.dHn.getRenderMode();
        }
        return 1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceCreated");
        }
        if (this.dHn != null) {
            this.dHn.surfaceCreated();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceChanged width: " + i2 + ", height: " + i3);
        }
        if (this.dHn != null) {
            this.dHn.surfaceChanged(i2, i3);
        }
        if (this.dHp != null) {
            this.dHp.ay(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceDestroyed width");
        }
        aRs();
        if (this.dHn != null) {
            this.dHn.surfaceDestroyed();
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        if (this.dHn != null) {
            this.dHn.requestRenderAndWait();
        }
    }

    public void onPause() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_PAUSE);
        }
        queueEvent(new Runnable() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                if (DuMixGameSurfaceView.this.dHn != null) {
                    DuMixGameSurfaceView.this.dHn.smallGameOnPause();
                }
            }
        });
        if (this.dHn != null) {
            this.dHn.onPause();
        }
        com.baidu.swan.games.screenrecord.d.aSt().aSw();
    }

    public void onResume() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_RESUME);
        }
        if (this.dHn != null) {
            this.dHn.onResume();
        }
        com.baidu.swan.games.screenrecord.d.aSt().aSx();
    }

    public void onDestroy() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_DESTROY);
        }
        aRs();
        com.baidu.swan.games.screenrecord.d.aSt().h(this.dHs);
        if (this.dHn != null) {
            if (this.dHo != null) {
                this.dHo.finish();
            }
            this.dHn.setFirstFrameListener(null);
            this.dHn.setOnStuckScreenListener(null);
            this.dHn.smallGameDestroy();
        }
    }

    public void d(V8ExceptionInfo v8ExceptionInfo) {
        if (this.dHn != null && this.dHn.getStuckScreenHandler() != null) {
            this.dHn.getStuckScreenHandler().a(0, v8ExceptionInfo);
        }
    }

    public void runOnGLThread(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "runOnGLThread");
        }
        if (this.dHn != null) {
            this.dHn.runOnGLThread(runnable);
        }
    }

    public void queueEvent(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent");
        }
        if (this.dHn != null) {
            this.dHn.queueEvent(runnable);
        }
    }

    public void queueEvent(Runnable runnable, long j) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent delayed");
        }
        if (this.dHn != null) {
            this.dHn.queueEvent(runnable, j);
        }
    }

    public void clearOldEvents() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "executeQueueEvent");
        }
        if (this.dHn != null) {
            this.dHn.clearOldEvents();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.dHn != null) {
            this.dHn.onAttachedToWindow();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDetachedFromWindow");
        }
        if (this.dHn != null) {
            this.dHn.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.dHp.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void finalize() throws Throwable {
        if (this.dHn != null) {
            if (this.dHo != null) {
                this.dHo.finish();
            }
            this.dHn.setFirstFrameListener(null);
            this.dHn.setOnStuckScreenListener(null);
            this.dHn.exitGLThread();
            this.dHn = null;
        }
    }

    private void aRs() {
        this.mDrawHeight = 0;
        this.mDrawWidth = 0;
    }

    @Override // com.baidu.smallgame.sdk.ArBridge.FirstFrameListener
    public void onFirstFrameFinished() {
        aRt();
        SwanAppActivity ave = f.avu().ave();
        if (ave != null) {
            c abl = ave.abl();
            if (abl instanceof com.baidu.swan.games.j.b) {
                ((com.baidu.swan.games.j.b) abl).onFirstFrameFinished();
            }
        }
    }

    public void aRt() {
        if (this.dHo != null) {
            com.baidu.swan.games.v.d.I(this.dHo.getPerformanceJson());
        }
        if (this.dHn != null) {
            com.baidu.swan.games.v.d.I(this.dHn.getPerformanceJson());
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
            if (DuMixGameSurfaceView.this.dHn != null) {
                DuMixGameSurfaceView.this.dHn.smallGameUpdate();
                if (DuMixGameSurfaceView.this.dHq != null) {
                    if (DuMixGameSurfaceView.this.dHr) {
                        DuMixGameSurfaceView.this.dHq.a(DuMixGameSurfaceView.this.getScreenShot(), DuMixGameSurfaceView.this.mDrawWidth, DuMixGameSurfaceView.this.mDrawHeight);
                        DuMixGameSurfaceView.this.dHn.setScreenShotStatus(false);
                        DuMixGameSurfaceView.this.dHr = false;
                        DuMixGameSurfaceView.this.dHq = null;
                    }
                    if (DuMixGameSurfaceView.this.dHq != null) {
                        DuMixGameSurfaceView.this.dHn.setScreenShotStatus(true);
                        DuMixGameSurfaceView.this.dHr = true;
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
