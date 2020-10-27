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
    private AREngineDelegate dPK;
    private com.baidu.swan.games.f.a dPL;
    private com.baidu.swan.games.glsurface.a.a dPM;
    private volatile b dPN;
    private boolean dPO;
    private GameRecorderController dPP;
    private int mDrawHeight;
    private int mDrawWidth;

    /* loaded from: classes10.dex */
    public interface b {
        void a(int[] iArr, int i, int i2);
    }

    static {
        d.aVo();
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
        i.qv("preload").f(new UbcFlowEvent("na_game_engine_start"));
        this.dPK = MarioSDK.createAREngine(aVar);
        this.dPK.setPermissionProxy(new e());
        this.dPK.setOnStuckScreenListener(new com.baidu.smallgame.sdk.b.a() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.1
            @Override // com.baidu.smallgame.sdk.b.a
            public void a(com.baidu.smallgame.sdk.b.b bVar) {
                com.baidu.swan.games.x.b.b(bVar);
            }

            @Override // com.baidu.smallgame.sdk.b.a
            public void acO() {
                com.baidu.swan.games.glsurface.a.b.aTq();
            }
        });
        this.dPK.startEngine();
        i.qv("preload").f(new UbcFlowEvent("na_game_engine_end"));
        this.dPM = new com.baidu.swan.games.glsurface.a.a();
        this.dPP = new GameRecorderController(this.dPK);
        com.baidu.swan.games.screenrecord.d.aUn().g(this.dPP);
    }

    private void setRenderer(GLSurfaceView.Renderer renderer) {
        if (this.dPK != null) {
            this.dPK.setRenderer(renderer);
        }
    }

    public void setRenderMode(int i) {
        if (this.dPK != null) {
            this.dPK.setRenderMode(i);
        }
    }

    public int getFPS() {
        if (this.dPK == null) {
            return 0;
        }
        return this.dPK.getFPS();
    }

    public void aTk() {
        Pair<Integer, Integer> axb = f.axo().axb();
        if (this.dPK != null) {
            this.dPK.updateSurfaceViewSize(((Integer) axb.first).intValue(), ((Integer) axb.second).intValue());
            this.dPK.initDisplayMetrics();
        }
        if (this.dPM != null) {
            this.dPM.ay(((Integer) axb.first).intValue(), ((Integer) axb.second).intValue());
        }
    }

    public void aTl() {
        surfaceChanged(getHolder(), 0, getWidth(), getHeight());
    }

    public com.baidu.swan.games.f.a getV8Engine() {
        return this.dPL;
    }

    public void setV8Engine(com.baidu.swan.games.f.a aVar) {
        this.dPL = aVar;
        this.dPM.setV8Engine(this.dPL);
    }

    public Thread getThread() {
        if (this.dPK != null) {
            return this.dPK.getGLThread();
        }
        return null;
    }

    public int getRenderMode() {
        if (this.dPK != null) {
            return this.dPK.getRenderMode();
        }
        return 1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceCreated");
        }
        if (this.dPK != null) {
            this.dPK.surfaceCreated();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceChanged width: " + i2 + ", height: " + i3);
        }
        if (this.dPK != null) {
            this.dPK.surfaceChanged(i2, i3);
        }
        if (this.dPM != null) {
            this.dPM.az(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceDestroyed width");
        }
        aTm();
        if (this.dPK != null) {
            this.dPK.surfaceDestroyed();
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        if (this.dPK != null) {
            this.dPK.requestRenderAndWait();
        }
    }

    public void onPause() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_PAUSE);
        }
        queueEvent(new Runnable() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                if (DuMixGameSurfaceView.this.dPK != null) {
                    DuMixGameSurfaceView.this.dPK.smallGameOnPause();
                }
            }
        });
        if (this.dPK != null) {
            this.dPK.onPause();
        }
        com.baidu.swan.games.screenrecord.d.aUn().aUq();
    }

    public void onResume() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_RESUME);
        }
        if (this.dPK != null) {
            this.dPK.onResume();
        }
        com.baidu.swan.games.screenrecord.d.aUn().aUr();
    }

    public void onDestroy() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_DESTROY);
        }
        aTm();
        com.baidu.swan.games.screenrecord.d.aUn().h(this.dPP);
        if (this.dPK != null) {
            if (this.dPL != null) {
                this.dPL.finish();
            }
            this.dPK.setFirstFrameListener(null);
            this.dPK.setOnStuckScreenListener(null);
            this.dPK.smallGameDestroy();
        }
    }

    public void d(V8ExceptionInfo v8ExceptionInfo) {
        if (this.dPK != null && this.dPK.getStuckScreenHandler() != null) {
            this.dPK.getStuckScreenHandler().a(0, v8ExceptionInfo);
        }
    }

    public void runOnGLThread(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "runOnGLThread");
        }
        if (this.dPK != null) {
            this.dPK.runOnGLThread(runnable);
        }
    }

    public void queueEvent(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent");
        }
        if (this.dPK != null) {
            this.dPK.queueEvent(runnable);
        }
    }

    public void queueEvent(Runnable runnable, long j) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent delayed");
        }
        if (this.dPK != null) {
            this.dPK.queueEvent(runnable, j);
        }
    }

    public void clearOldEvents() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "executeQueueEvent");
        }
        if (this.dPK != null) {
            this.dPK.clearOldEvents();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.dPK != null) {
            this.dPK.onAttachedToWindow();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDetachedFromWindow");
        }
        if (this.dPK != null) {
            this.dPK.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.dPM.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void finalize() throws Throwable {
        if (this.dPK != null) {
            if (this.dPL != null) {
                this.dPL.finish();
            }
            this.dPK.setFirstFrameListener(null);
            this.dPK.setOnStuckScreenListener(null);
            this.dPK.exitGLThread();
            this.dPK = null;
        }
    }

    private void aTm() {
        this.mDrawHeight = 0;
        this.mDrawWidth = 0;
    }

    @Override // com.baidu.smallgame.sdk.ArBridge.FirstFrameListener
    public void onFirstFrameFinished() {
        aTn();
        SwanAppActivity awY = f.axo().awY();
        if (awY != null) {
            c adf = awY.adf();
            if (adf instanceof com.baidu.swan.games.j.b) {
                ((com.baidu.swan.games.j.b) adf).onFirstFrameFinished();
            }
        }
    }

    public void aTn() {
        if (this.dPL != null) {
            com.baidu.swan.games.v.d.I(this.dPL.getPerformanceJson());
        }
        if (this.dPK != null) {
            com.baidu.swan.games.v.d.I(this.dPK.getPerformanceJson());
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
            if (DuMixGameSurfaceView.this.dPK != null) {
                DuMixGameSurfaceView.this.dPK.smallGameUpdate();
                if (DuMixGameSurfaceView.this.dPN != null) {
                    if (DuMixGameSurfaceView.this.dPO) {
                        DuMixGameSurfaceView.this.dPN.a(DuMixGameSurfaceView.this.getScreenShot(), DuMixGameSurfaceView.this.mDrawWidth, DuMixGameSurfaceView.this.mDrawHeight);
                        DuMixGameSurfaceView.this.dPK.setScreenShotStatus(false);
                        DuMixGameSurfaceView.this.dPO = false;
                        DuMixGameSurfaceView.this.dPN = null;
                    }
                    if (DuMixGameSurfaceView.this.dPN != null) {
                        DuMixGameSurfaceView.this.dPK.setScreenShotStatus(true);
                        DuMixGameSurfaceView.this.dPO = true;
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
