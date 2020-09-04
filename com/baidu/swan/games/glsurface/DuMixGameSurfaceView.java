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
    private AREngineDelegate dtk;
    private com.baidu.swan.games.f.a dtl;
    private com.baidu.swan.games.glsurface.a.a dtm;
    private volatile b dtn;
    private boolean dto;
    private GameRecorderController dtp;
    private int mDrawHeight;
    private int mDrawWidth;

    /* loaded from: classes8.dex */
    public interface b {
        void a(int[] iArr, int i, int i2);
    }

    static {
        d.aQa();
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
        i.oX("preload").f(new UbcFlowEvent("na_game_engine_start"));
        this.dtk = MarioSDK.createAREngine(aVar);
        this.dtk.setPermissionProxy(new e());
        this.dtk.setOnStuckScreenListener(new com.baidu.smallgame.sdk.b.a() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.1
            @Override // com.baidu.smallgame.sdk.b.a
            public void a(com.baidu.smallgame.sdk.b.b bVar) {
                com.baidu.swan.games.x.b.b(bVar);
            }

            @Override // com.baidu.smallgame.sdk.b.a
            public void Xz() {
                com.baidu.swan.games.glsurface.a.b.aOc();
            }
        });
        this.dtk.startEngine();
        i.oX("preload").f(new UbcFlowEvent("na_game_engine_end"));
        this.dtm = new com.baidu.swan.games.glsurface.a.a();
        this.dtp = new GameRecorderController(this.dtk);
        com.baidu.swan.games.screenrecord.d.aOZ().g(this.dtp);
    }

    private void setRenderer(GLSurfaceView.Renderer renderer) {
        if (this.dtk != null) {
            this.dtk.setRenderer(renderer);
        }
    }

    public void setRenderMode(int i) {
        if (this.dtk != null) {
            this.dtk.setRenderMode(i);
        }
    }

    public int getFPS() {
        if (this.dtk == null) {
            return 0;
        }
        return this.dtk.getFPS();
    }

    public void aNW() {
        Pair<Integer, Integer> arL = f.arY().arL();
        if (this.dtk != null) {
            this.dtk.updateSurfaceViewSize(((Integer) arL.first).intValue(), ((Integer) arL.second).intValue());
            this.dtk.initDisplayMetrics();
        }
        if (this.dtm != null) {
            this.dtm.ay(((Integer) arL.first).intValue(), ((Integer) arL.second).intValue());
        }
    }

    public void aNX() {
        surfaceChanged(getHolder(), 0, getWidth(), getHeight());
    }

    public com.baidu.swan.games.f.a getV8Engine() {
        return this.dtl;
    }

    public void setV8Engine(com.baidu.swan.games.f.a aVar) {
        this.dtl = aVar;
        this.dtm.setV8Engine(this.dtl);
    }

    public Thread getThread() {
        if (this.dtk != null) {
            return this.dtk.getGLThread();
        }
        return null;
    }

    public int getRenderMode() {
        if (this.dtk != null) {
            return this.dtk.getRenderMode();
        }
        return 1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceCreated");
        }
        if (this.dtk != null) {
            this.dtk.surfaceCreated();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceChanged width: " + i2 + ", height: " + i3);
        }
        if (this.dtk != null) {
            this.dtk.surfaceChanged(i2, i3);
        }
        if (this.dtm != null) {
            this.dtm.az(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceDestroyed width");
        }
        aNY();
        if (this.dtk != null) {
            this.dtk.surfaceDestroyed();
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        if (this.dtk != null) {
            this.dtk.requestRenderAndWait();
        }
    }

    public void onPause() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_PAUSE);
        }
        queueEvent(new Runnable() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                if (DuMixGameSurfaceView.this.dtk != null) {
                    DuMixGameSurfaceView.this.dtk.smallGameOnPause();
                }
            }
        });
        if (this.dtk != null) {
            this.dtk.onPause();
        }
        com.baidu.swan.games.screenrecord.d.aOZ().aPc();
    }

    public void onResume() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_RESUME);
        }
        if (this.dtk != null) {
            this.dtk.onResume();
        }
        com.baidu.swan.games.screenrecord.d.aOZ().aPd();
    }

    public void onDestroy() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_DESTROY);
        }
        aNY();
        com.baidu.swan.games.screenrecord.d.aOZ().h(this.dtp);
        if (this.dtk != null) {
            if (this.dtl != null) {
                this.dtl.finish();
            }
            this.dtk.setFirstFrameListener(null);
            this.dtk.setOnStuckScreenListener(null);
            this.dtk.smallGameDestroy();
        }
    }

    public void d(V8ExceptionInfo v8ExceptionInfo) {
        if (this.dtk != null && this.dtk.getStuckScreenHandler() != null) {
            this.dtk.getStuckScreenHandler().a(0, v8ExceptionInfo);
        }
    }

    public void runOnGLThread(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "runOnGLThread");
        }
        if (this.dtk != null) {
            this.dtk.runOnGLThread(runnable);
        }
    }

    public void queueEvent(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent");
        }
        if (this.dtk != null) {
            this.dtk.queueEvent(runnable);
        }
    }

    public void queueEvent(Runnable runnable, long j) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent delayed");
        }
        if (this.dtk != null) {
            this.dtk.queueEvent(runnable, j);
        }
    }

    public void clearOldEvents() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "executeQueueEvent");
        }
        if (this.dtk != null) {
            this.dtk.clearOldEvents();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.dtk != null) {
            this.dtk.onAttachedToWindow();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDetachedFromWindow");
        }
        if (this.dtk != null) {
            this.dtk.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.dtm.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void finalize() throws Throwable {
        if (this.dtk != null) {
            if (this.dtl != null) {
                this.dtl.finish();
            }
            this.dtk.setFirstFrameListener(null);
            this.dtk.setOnStuckScreenListener(null);
            this.dtk.exitGLThread();
            this.dtk = null;
        }
    }

    private void aNY() {
        this.mDrawHeight = 0;
        this.mDrawWidth = 0;
    }

    @Override // com.baidu.smallgame.sdk.ArBridge.FirstFrameListener
    public void onFirstFrameFinished() {
        aNZ();
        SwanAppActivity arI = f.arY().arI();
        if (arI != null) {
            c XQ = arI.XQ();
            if (XQ instanceof com.baidu.swan.games.j.b) {
                ((com.baidu.swan.games.j.b) XQ).onFirstFrameFinished();
            }
        }
    }

    public void aNZ() {
        if (this.dtl != null) {
            com.baidu.swan.games.v.d.I(this.dtl.getPerformanceJson());
        }
        if (this.dtk != null) {
            com.baidu.swan.games.v.d.I(this.dtk.getPerformanceJson());
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
            if (DuMixGameSurfaceView.this.dtk != null) {
                DuMixGameSurfaceView.this.dtk.smallGameUpdate();
                if (DuMixGameSurfaceView.this.dtn != null) {
                    if (DuMixGameSurfaceView.this.dto) {
                        DuMixGameSurfaceView.this.dtn.a(DuMixGameSurfaceView.this.getScreenShot(), DuMixGameSurfaceView.this.mDrawWidth, DuMixGameSurfaceView.this.mDrawHeight);
                        DuMixGameSurfaceView.this.dtk.setScreenShotStatus(false);
                        DuMixGameSurfaceView.this.dto = false;
                        DuMixGameSurfaceView.this.dtn = null;
                    }
                    if (DuMixGameSurfaceView.this.dtn != null) {
                        DuMixGameSurfaceView.this.dtk.setScreenShotStatus(true);
                        DuMixGameSurfaceView.this.dto = true;
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
