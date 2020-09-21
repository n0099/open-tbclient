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
/* loaded from: classes3.dex */
public class DuMixGameSurfaceView extends SurfaceView implements SurfaceHolder.Callback2, ArBridge.FirstFrameListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private AREngineDelegate dvm;
    private com.baidu.swan.games.f.a dvn;
    private com.baidu.swan.games.glsurface.a.a dvo;
    private volatile b dvp;
    private boolean dvq;
    private GameRecorderController dvr;
    private int mDrawHeight;
    private int mDrawWidth;

    /* loaded from: classes3.dex */
    public interface b {
        void a(int[] iArr, int i, int i2);
    }

    static {
        d.aQL();
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
        i.pq("preload").f(new UbcFlowEvent("na_game_engine_start"));
        this.dvm = MarioSDK.createAREngine(aVar);
        this.dvm.setPermissionProxy(new e());
        this.dvm.setOnStuckScreenListener(new com.baidu.smallgame.sdk.b.a() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.1
            @Override // com.baidu.smallgame.sdk.b.a
            public void a(com.baidu.smallgame.sdk.b.b bVar) {
                com.baidu.swan.games.x.b.b(bVar);
            }

            @Override // com.baidu.smallgame.sdk.b.a
            public void Yi() {
                com.baidu.swan.games.glsurface.a.b.aON();
            }
        });
        this.dvm.startEngine();
        i.pq("preload").f(new UbcFlowEvent("na_game_engine_end"));
        this.dvo = new com.baidu.swan.games.glsurface.a.a();
        this.dvr = new GameRecorderController(this.dvm);
        com.baidu.swan.games.screenrecord.d.aPK().g(this.dvr);
    }

    private void setRenderer(GLSurfaceView.Renderer renderer) {
        if (this.dvm != null) {
            this.dvm.setRenderer(renderer);
        }
    }

    public void setRenderMode(int i) {
        if (this.dvm != null) {
            this.dvm.setRenderMode(i);
        }
    }

    public int getFPS() {
        if (this.dvm == null) {
            return 0;
        }
        return this.dvm.getFPS();
    }

    public void aOH() {
        Pair<Integer, Integer> asw = f.asJ().asw();
        if (this.dvm != null) {
            this.dvm.updateSurfaceViewSize(((Integer) asw.first).intValue(), ((Integer) asw.second).intValue());
            this.dvm.initDisplayMetrics();
        }
        if (this.dvo != null) {
            this.dvo.ay(((Integer) asw.first).intValue(), ((Integer) asw.second).intValue());
        }
    }

    public void aOI() {
        surfaceChanged(getHolder(), 0, getWidth(), getHeight());
    }

    public com.baidu.swan.games.f.a getV8Engine() {
        return this.dvn;
    }

    public void setV8Engine(com.baidu.swan.games.f.a aVar) {
        this.dvn = aVar;
        this.dvo.setV8Engine(this.dvn);
    }

    public Thread getThread() {
        if (this.dvm != null) {
            return this.dvm.getGLThread();
        }
        return null;
    }

    public int getRenderMode() {
        if (this.dvm != null) {
            return this.dvm.getRenderMode();
        }
        return 1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceCreated");
        }
        if (this.dvm != null) {
            this.dvm.surfaceCreated();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceChanged width: " + i2 + ", height: " + i3);
        }
        if (this.dvm != null) {
            this.dvm.surfaceChanged(i2, i3);
        }
        if (this.dvo != null) {
            this.dvo.az(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceDestroyed width");
        }
        aOJ();
        if (this.dvm != null) {
            this.dvm.surfaceDestroyed();
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        if (this.dvm != null) {
            this.dvm.requestRenderAndWait();
        }
    }

    public void onPause() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_PAUSE);
        }
        queueEvent(new Runnable() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                if (DuMixGameSurfaceView.this.dvm != null) {
                    DuMixGameSurfaceView.this.dvm.smallGameOnPause();
                }
            }
        });
        if (this.dvm != null) {
            this.dvm.onPause();
        }
        com.baidu.swan.games.screenrecord.d.aPK().aPN();
    }

    public void onResume() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_RESUME);
        }
        if (this.dvm != null) {
            this.dvm.onResume();
        }
        com.baidu.swan.games.screenrecord.d.aPK().aPO();
    }

    public void onDestroy() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_DESTROY);
        }
        aOJ();
        com.baidu.swan.games.screenrecord.d.aPK().h(this.dvr);
        if (this.dvm != null) {
            if (this.dvn != null) {
                this.dvn.finish();
            }
            this.dvm.setFirstFrameListener(null);
            this.dvm.setOnStuckScreenListener(null);
            this.dvm.smallGameDestroy();
        }
    }

    public void d(V8ExceptionInfo v8ExceptionInfo) {
        if (this.dvm != null && this.dvm.getStuckScreenHandler() != null) {
            this.dvm.getStuckScreenHandler().a(0, v8ExceptionInfo);
        }
    }

    public void runOnGLThread(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "runOnGLThread");
        }
        if (this.dvm != null) {
            this.dvm.runOnGLThread(runnable);
        }
    }

    public void queueEvent(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent");
        }
        if (this.dvm != null) {
            this.dvm.queueEvent(runnable);
        }
    }

    public void queueEvent(Runnable runnable, long j) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent delayed");
        }
        if (this.dvm != null) {
            this.dvm.queueEvent(runnable, j);
        }
    }

    public void clearOldEvents() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "executeQueueEvent");
        }
        if (this.dvm != null) {
            this.dvm.clearOldEvents();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.dvm != null) {
            this.dvm.onAttachedToWindow();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDetachedFromWindow");
        }
        if (this.dvm != null) {
            this.dvm.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.dvo.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void finalize() throws Throwable {
        if (this.dvm != null) {
            if (this.dvn != null) {
                this.dvn.finish();
            }
            this.dvm.setFirstFrameListener(null);
            this.dvm.setOnStuckScreenListener(null);
            this.dvm.exitGLThread();
            this.dvm = null;
        }
    }

    private void aOJ() {
        this.mDrawHeight = 0;
        this.mDrawWidth = 0;
    }

    @Override // com.baidu.smallgame.sdk.ArBridge.FirstFrameListener
    public void onFirstFrameFinished() {
        aOK();
        SwanAppActivity ast = f.asJ().ast();
        if (ast != null) {
            c Yz = ast.Yz();
            if (Yz instanceof com.baidu.swan.games.j.b) {
                ((com.baidu.swan.games.j.b) Yz).onFirstFrameFinished();
            }
        }
    }

    public void aOK() {
        if (this.dvn != null) {
            com.baidu.swan.games.v.d.I(this.dvn.getPerformanceJson());
        }
        if (this.dvm != null) {
            com.baidu.swan.games.v.d.I(this.dvm.getPerformanceJson());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
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
            if (DuMixGameSurfaceView.this.dvm != null) {
                DuMixGameSurfaceView.this.dvm.smallGameUpdate();
                if (DuMixGameSurfaceView.this.dvp != null) {
                    if (DuMixGameSurfaceView.this.dvq) {
                        DuMixGameSurfaceView.this.dvp.a(DuMixGameSurfaceView.this.getScreenShot(), DuMixGameSurfaceView.this.mDrawWidth, DuMixGameSurfaceView.this.mDrawHeight);
                        DuMixGameSurfaceView.this.dvm.setScreenShotStatus(false);
                        DuMixGameSurfaceView.this.dvq = false;
                        DuMixGameSurfaceView.this.dvp = null;
                    }
                    if (DuMixGameSurfaceView.this.dvp != null) {
                        DuMixGameSurfaceView.this.dvm.setScreenShotStatus(true);
                        DuMixGameSurfaceView.this.dvq = true;
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
