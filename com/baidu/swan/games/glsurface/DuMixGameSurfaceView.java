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
/* loaded from: classes7.dex */
public class DuMixGameSurfaceView extends SurfaceView implements SurfaceHolder.Callback2, ArBridge.FirstFrameListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private AREngineDelegate dTU;
    private com.baidu.swan.games.f.a dTV;
    private com.baidu.swan.games.glsurface.a.a dTW;
    private volatile b dTX;
    private boolean dTY;
    private GameRecorderController dTZ;
    private int mDrawHeight;
    private int mDrawWidth;

    /* loaded from: classes7.dex */
    public interface b {
        void a(int[] iArr, int i, int i2);
    }

    static {
        d.aXg();
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
        i.qD("preload").f(new UbcFlowEvent("na_game_engine_start"));
        this.dTU = MarioSDK.createAREngine(aVar);
        this.dTU.setPermissionProxy(new e());
        this.dTU.setOnStuckScreenListener(new com.baidu.smallgame.sdk.b.a() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.1
            @Override // com.baidu.smallgame.sdk.b.a
            public void a(com.baidu.smallgame.sdk.b.b bVar) {
                com.baidu.swan.games.x.b.b(bVar);
            }

            @Override // com.baidu.smallgame.sdk.b.a
            public void aeG() {
                com.baidu.swan.games.glsurface.a.b.aVi();
            }
        });
        this.dTU.startEngine();
        i.qD("preload").f(new UbcFlowEvent("na_game_engine_end"));
        this.dTW = new com.baidu.swan.games.glsurface.a.a();
        this.dTZ = new GameRecorderController(this.dTU);
        com.baidu.swan.games.screenrecord.d.aWf().g(this.dTZ);
    }

    private void setRenderer(GLSurfaceView.Renderer renderer) {
        if (this.dTU != null) {
            this.dTU.setRenderer(renderer);
        }
    }

    public void setRenderMode(int i) {
        if (this.dTU != null) {
            this.dTU.setRenderMode(i);
        }
    }

    public int getFPS() {
        if (this.dTU == null) {
            return 0;
        }
        return this.dTU.getFPS();
    }

    public void aVc() {
        Pair<Integer, Integer> ayT = f.azg().ayT();
        if (this.dTU != null) {
            this.dTU.updateSurfaceViewSize(((Integer) ayT.first).intValue(), ((Integer) ayT.second).intValue());
            this.dTU.initDisplayMetrics();
        }
        if (this.dTW != null) {
            this.dTW.ay(((Integer) ayT.first).intValue(), ((Integer) ayT.second).intValue());
        }
    }

    public void aVd() {
        surfaceChanged(getHolder(), 0, getWidth(), getHeight());
    }

    public com.baidu.swan.games.f.a getV8Engine() {
        return this.dTV;
    }

    public void setV8Engine(com.baidu.swan.games.f.a aVar) {
        this.dTV = aVar;
        this.dTW.setV8Engine(this.dTV);
    }

    public Thread getThread() {
        if (this.dTU != null) {
            return this.dTU.getGLThread();
        }
        return null;
    }

    public int getRenderMode() {
        if (this.dTU != null) {
            return this.dTU.getRenderMode();
        }
        return 1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceCreated");
        }
        if (this.dTU != null) {
            this.dTU.surfaceCreated();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceChanged width: " + i2 + ", height: " + i3);
        }
        if (this.dTU != null) {
            this.dTU.surfaceChanged(i2, i3);
        }
        if (this.dTW != null) {
            this.dTW.az(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceDestroyed width");
        }
        aVe();
        if (this.dTU != null) {
            this.dTU.surfaceDestroyed();
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        if (this.dTU != null) {
            this.dTU.requestRenderAndWait();
        }
    }

    public void onPause() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_PAUSE);
        }
        queueEvent(new Runnable() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                if (DuMixGameSurfaceView.this.dTU != null) {
                    DuMixGameSurfaceView.this.dTU.smallGameOnPause();
                }
            }
        });
        if (this.dTU != null) {
            this.dTU.onPause();
        }
        com.baidu.swan.games.screenrecord.d.aWf().aWi();
    }

    public void onResume() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_RESUME);
        }
        if (this.dTU != null) {
            this.dTU.onResume();
        }
        com.baidu.swan.games.screenrecord.d.aWf().aWj();
    }

    public void onDestroy() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_DESTROY);
        }
        aVe();
        com.baidu.swan.games.screenrecord.d.aWf().h(this.dTZ);
        if (this.dTU != null) {
            if (this.dTV != null) {
                this.dTV.finish();
            }
            this.dTU.setFirstFrameListener(null);
            this.dTU.setOnStuckScreenListener(null);
            this.dTU.smallGameDestroy();
        }
    }

    public void d(V8ExceptionInfo v8ExceptionInfo) {
        if (this.dTU != null && this.dTU.getStuckScreenHandler() != null) {
            this.dTU.getStuckScreenHandler().a(0, v8ExceptionInfo);
        }
    }

    public void runOnGLThread(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "runOnGLThread");
        }
        if (this.dTU != null) {
            this.dTU.runOnGLThread(runnable);
        }
    }

    public void queueEvent(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent");
        }
        if (this.dTU != null) {
            this.dTU.queueEvent(runnable);
        }
    }

    public void queueEvent(Runnable runnable, long j) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent delayed");
        }
        if (this.dTU != null) {
            this.dTU.queueEvent(runnable, j);
        }
    }

    public void clearOldEvents() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "executeQueueEvent");
        }
        if (this.dTU != null) {
            this.dTU.clearOldEvents();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.dTU != null) {
            this.dTU.onAttachedToWindow();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDetachedFromWindow");
        }
        if (this.dTU != null) {
            this.dTU.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.dTW.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void finalize() throws Throwable {
        if (this.dTU != null) {
            if (this.dTV != null) {
                this.dTV.finish();
            }
            this.dTU.setFirstFrameListener(null);
            this.dTU.setOnStuckScreenListener(null);
            this.dTU.exitGLThread();
            this.dTU = null;
        }
    }

    private void aVe() {
        this.mDrawHeight = 0;
        this.mDrawWidth = 0;
    }

    @Override // com.baidu.smallgame.sdk.ArBridge.FirstFrameListener
    public void onFirstFrameFinished() {
        aVf();
        SwanAppActivity ayQ = f.azg().ayQ();
        if (ayQ != null) {
            c aeX = ayQ.aeX();
            if (aeX instanceof com.baidu.swan.games.j.b) {
                ((com.baidu.swan.games.j.b) aeX).onFirstFrameFinished();
            }
        }
    }

    public void aVf() {
        if (this.dTV != null) {
            com.baidu.swan.games.v.d.I(this.dTV.getPerformanceJson());
        }
        if (this.dTU != null) {
            com.baidu.swan.games.v.d.I(this.dTU.getPerformanceJson());
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
            if (DuMixGameSurfaceView.this.dTU != null) {
                DuMixGameSurfaceView.this.dTU.smallGameUpdate();
                if (DuMixGameSurfaceView.this.dTX != null) {
                    if (DuMixGameSurfaceView.this.dTY) {
                        DuMixGameSurfaceView.this.dTX.a(DuMixGameSurfaceView.this.getScreenShot(), DuMixGameSurfaceView.this.mDrawWidth, DuMixGameSurfaceView.this.mDrawHeight);
                        DuMixGameSurfaceView.this.dTU.setScreenShotStatus(false);
                        DuMixGameSurfaceView.this.dTY = false;
                        DuMixGameSurfaceView.this.dTX = null;
                    }
                    if (DuMixGameSurfaceView.this.dTX != null) {
                        DuMixGameSurfaceView.this.dTU.setScreenShotStatus(true);
                        DuMixGameSurfaceView.this.dTY = true;
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
