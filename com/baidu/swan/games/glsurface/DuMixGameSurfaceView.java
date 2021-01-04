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
    private AREngineDelegate ejP;
    private com.baidu.swan.games.f.a ejQ;
    private com.baidu.swan.games.glsurface.a.a ejR;
    private volatile b ejS;
    private boolean ejT;
    private GameRecorderController ejU;
    private int mDrawHeight;
    private int mDrawWidth;

    /* loaded from: classes9.dex */
    public interface b {
        void a(int[] iArr, int i, int i2);
    }

    static {
        d.bcF();
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
        i.rd("preload").f(new UbcFlowEvent("na_game_engine_start"));
        this.ejP = MarioSDK.createAREngine(aVar);
        this.ejP.setPermissionProxy(new e());
        this.ejP.setOnStuckScreenListener(new com.baidu.smallgame.sdk.b.a() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.1
            @Override // com.baidu.smallgame.sdk.b.a
            public void a(com.baidu.smallgame.sdk.b.b bVar) {
                com.baidu.swan.games.x.b.b(bVar);
            }

            @Override // com.baidu.smallgame.sdk.b.a
            public void aiX() {
                com.baidu.swan.games.glsurface.a.b.baH();
            }
        });
        this.ejP.startEngine();
        i.rd("preload").f(new UbcFlowEvent("na_game_engine_end"));
        this.ejR = new com.baidu.swan.games.glsurface.a.a();
        this.ejU = new GameRecorderController(this.ejP);
        com.baidu.swan.games.screenrecord.d.bbE().g(this.ejU);
    }

    private void setRenderer(GLSurfaceView.Renderer renderer) {
        if (this.ejP != null) {
            this.ejP.setRenderer(renderer);
        }
    }

    public void setRenderMode(int i) {
        if (this.ejP != null) {
            this.ejP.setRenderMode(i);
        }
    }

    public int getFPS() {
        if (this.ejP == null) {
            return 0;
        }
        return this.ejP.getFPS();
    }

    public void baB() {
        Pair<Integer, Integer> aDt = f.aDG().aDt();
        if (this.ejP != null) {
            this.ejP.updateSurfaceViewSize(((Integer) aDt.first).intValue(), ((Integer) aDt.second).intValue());
            this.ejP.initDisplayMetrics();
        }
        if (this.ejR != null) {
            this.ejR.ax(((Integer) aDt.first).intValue(), ((Integer) aDt.second).intValue());
        }
    }

    public void baC() {
        surfaceChanged(getHolder(), 0, getWidth(), getHeight());
    }

    public com.baidu.swan.games.f.a getV8Engine() {
        return this.ejQ;
    }

    public void setV8Engine(com.baidu.swan.games.f.a aVar) {
        this.ejQ = aVar;
        this.ejR.setV8Engine(this.ejQ);
    }

    public Thread getThread() {
        if (this.ejP != null) {
            return this.ejP.getGLThread();
        }
        return null;
    }

    public int getRenderMode() {
        if (this.ejP != null) {
            return this.ejP.getRenderMode();
        }
        return 1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceCreated");
        }
        if (this.ejP != null) {
            this.ejP.surfaceCreated();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceChanged width: " + i2 + ", height: " + i3);
        }
        if (this.ejP != null) {
            this.ejP.surfaceChanged(i2, i3);
        }
        if (this.ejR != null) {
            this.ejR.ay(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceDestroyed width");
        }
        baD();
        if (this.ejP != null) {
            this.ejP.surfaceDestroyed();
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        if (this.ejP != null) {
            this.ejP.requestRenderAndWait();
        }
    }

    public void onPause() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_PAUSE);
        }
        queueEvent(new Runnable() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                if (DuMixGameSurfaceView.this.ejP != null) {
                    DuMixGameSurfaceView.this.ejP.smallGameOnPause();
                }
            }
        });
        if (this.ejP != null) {
            this.ejP.onPause();
        }
        com.baidu.swan.games.screenrecord.d.bbE().bbH();
    }

    public void onResume() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_RESUME);
        }
        if (this.ejP != null) {
            this.ejP.onResume();
        }
        com.baidu.swan.games.screenrecord.d.bbE().bbI();
    }

    public void onDestroy() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_DESTROY);
        }
        baD();
        com.baidu.swan.games.screenrecord.d.bbE().h(this.ejU);
        if (this.ejP != null) {
            if (this.ejQ != null) {
                this.ejQ.finish();
            }
            this.ejP.setFirstFrameListener(null);
            this.ejP.setOnStuckScreenListener(null);
            this.ejP.smallGameDestroy();
        }
    }

    public void d(V8ExceptionInfo v8ExceptionInfo) {
        if (this.ejP != null && this.ejP.getStuckScreenHandler() != null) {
            this.ejP.getStuckScreenHandler().a(0, v8ExceptionInfo);
        }
    }

    public void runOnGLThread(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "runOnGLThread");
        }
        if (this.ejP != null) {
            this.ejP.runOnGLThread(runnable);
        }
    }

    public void queueEvent(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent");
        }
        if (this.ejP != null) {
            this.ejP.queueEvent(runnable);
        }
    }

    public void queueEvent(Runnable runnable, long j) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent delayed");
        }
        if (this.ejP != null) {
            this.ejP.queueEvent(runnable, j);
        }
    }

    public void clearOldEvents() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "executeQueueEvent");
        }
        if (this.ejP != null) {
            this.ejP.clearOldEvents();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.ejP != null) {
            this.ejP.onAttachedToWindow();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDetachedFromWindow");
        }
        if (this.ejP != null) {
            this.ejP.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.ejR.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void finalize() throws Throwable {
        if (this.ejP != null) {
            if (this.ejQ != null) {
                this.ejQ.finish();
            }
            this.ejP.setFirstFrameListener(null);
            this.ejP.setOnStuckScreenListener(null);
            this.ejP.exitGLThread();
            this.ejP = null;
        }
    }

    private void baD() {
        this.mDrawHeight = 0;
        this.mDrawWidth = 0;
    }

    @Override // com.baidu.smallgame.sdk.ArBridge.FirstFrameListener
    public void onFirstFrameFinished() {
        baE();
        SwanAppActivity aDq = f.aDG().aDq();
        if (aDq != null) {
            c ajl = aDq.ajl();
            if (ajl instanceof com.baidu.swan.games.j.b) {
                ((com.baidu.swan.games.j.b) ajl).onFirstFrameFinished();
            }
        }
    }

    public void baE() {
        if (this.ejQ != null) {
            com.baidu.swan.games.v.d.J(this.ejQ.getPerformanceJson());
        }
        if (this.ejP != null) {
            com.baidu.swan.games.v.d.J(this.ejP.getPerformanceJson());
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
            if (DuMixGameSurfaceView.this.ejP != null) {
                DuMixGameSurfaceView.this.ejP.smallGameUpdate();
                if (DuMixGameSurfaceView.this.ejS != null) {
                    if (DuMixGameSurfaceView.this.ejT) {
                        DuMixGameSurfaceView.this.ejS.a(DuMixGameSurfaceView.this.getScreenShot(), DuMixGameSurfaceView.this.mDrawWidth, DuMixGameSurfaceView.this.mDrawHeight);
                        DuMixGameSurfaceView.this.ejP.setScreenShotStatus(false);
                        DuMixGameSurfaceView.this.ejT = false;
                        DuMixGameSurfaceView.this.ejS = null;
                    }
                    if (DuMixGameSurfaceView.this.ejS != null) {
                        DuMixGameSurfaceView.this.ejP.setScreenShotStatus(true);
                        DuMixGameSurfaceView.this.ejT = true;
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
