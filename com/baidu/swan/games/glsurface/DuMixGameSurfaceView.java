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
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.smallgame.sdk.ArBridge;
import com.baidu.smallgame.sdk.MarioSDK;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.games.screenrecord.GameRecorderController;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.d74;
import com.baidu.tieba.fj2;
import com.baidu.tieba.h24;
import com.baidu.tieba.h64;
import com.baidu.tieba.ie2;
import com.baidu.tieba.lz2;
import com.baidu.tieba.n24;
import com.baidu.tieba.od2;
import com.baidu.tieba.p24;
import com.baidu.tieba.pj1;
import com.baidu.tieba.q24;
import com.baidu.tieba.qj1;
import com.baidu.tieba.rm1;
import com.baidu.tieba.s74;
import com.baidu.tieba.tr2;
import com.baidu.tieba.zb3;
import com.faceunity.gles.GeneratedTexture;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes4.dex */
public class DuMixGameSurfaceView extends SurfaceView implements SurfaceHolder.Callback2, ArBridge.FirstFrameListener {
    public static final boolean i = rm1.a;
    public AREngineDelegate a;
    public od2 b;
    public p24 c;
    public int d;
    public int e;
    public volatile d f;
    public boolean g;
    public GameRecorderController h;

    /* loaded from: classes4.dex */
    public interface d {
        void a(int[] iArr, int i, int i2);
    }

    /* loaded from: classes4.dex */
    public class a implements pj1 {
        public a() {
        }

        @Override // com.baidu.tieba.pj1
        public void b(qj1 qj1Var) {
            s74.c(qj1Var);
        }

        @Override // com.baidu.tieba.pj1
        public void a() {
            q24.k();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (DuMixGameSurfaceView.this.a != null) {
                DuMixGameSurfaceView.this.a.smallGameOnPause();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements GLSurfaceView.Renderer {
        public c() {
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (DuMixGameSurfaceView.i) {
                Log.d("DuMixGameSurfaceView", "AiWebRender onDrawFrame !!!");
            }
            if (DuMixGameSurfaceView.this.a == null) {
                return;
            }
            DuMixGameSurfaceView.this.a.smallGameUpdate();
            if (DuMixGameSurfaceView.this.f != null) {
                if (DuMixGameSurfaceView.this.g) {
                    DuMixGameSurfaceView.this.f.a(DuMixGameSurfaceView.this.getScreenShot(), DuMixGameSurfaceView.this.d, DuMixGameSurfaceView.this.e);
                    DuMixGameSurfaceView.this.a.setScreenShotStatus(false);
                    DuMixGameSurfaceView.this.g = false;
                    DuMixGameSurfaceView.this.f = null;
                }
                if (DuMixGameSurfaceView.this.f != null) {
                    DuMixGameSurfaceView.this.a.setScreenShotStatus(true);
                    DuMixGameSurfaceView.this.g = true;
                }
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            DuMixGameSurfaceView.this.d = i;
            DuMixGameSurfaceView.this.e = i2;
            if (DuMixGameSurfaceView.i) {
                Log.d("DuMixGameSurfaceView", "AiWebRender onSurfaceChanged width * height = " + i + " * " + i2);
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            if (DuMixGameSurfaceView.i) {
                Log.d("DuMixGameSurfaceView", "AiWebRender onSurfaceCreated !!!");
            }
        }
    }

    static {
        zb3.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] getScreenShot() {
        int i2;
        int i3 = this.d;
        if (i3 > 0 && (i2 = this.e) > 0) {
            try {
                int[] iArr = new int[i3 * i2];
                IntBuffer wrap = IntBuffer.wrap(iArr);
                wrap.position(0);
                GLES20.glReadPixels(0, 0, this.d, this.e, GeneratedTexture.FORMAT, 5121, wrap);
                return iArr;
            } catch (OutOfMemoryError unused) {
            }
        }
        return null;
    }

    public int getFPS() {
        AREngineDelegate aREngineDelegate = this.a;
        if (aREngineDelegate == null) {
            return 0;
        }
        return aREngineDelegate.getFPS();
    }

    public int getRenderMode() {
        AREngineDelegate aREngineDelegate = this.a;
        if (aREngineDelegate != null) {
            return aREngineDelegate.getRenderMode();
        }
        return 1;
    }

    public Thread getThread() {
        AREngineDelegate aREngineDelegate = this.a;
        if (aREngineDelegate != null) {
            return aREngineDelegate.getGLThread();
        }
        return null;
    }

    public od2 getV8Engine() {
        return this.b;
    }

    public void m() {
        if (i) {
            Log.d("DuMixGameSurfaceView", "executeQueueEvent");
        }
        AREngineDelegate aREngineDelegate = this.a;
        if (aREngineDelegate != null) {
            aREngineDelegate.clearOldEvents();
        }
    }

    public void n() {
        od2 od2Var = this.b;
        if (od2Var != null) {
            d74.b(od2Var.m0());
        }
        AREngineDelegate aREngineDelegate = this.a;
        if (aREngineDelegate != null) {
            d74.b(aREngineDelegate.getPerformanceJson());
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AREngineDelegate aREngineDelegate = this.a;
        if (aREngineDelegate != null) {
            aREngineDelegate.onAttachedToWindow();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        if (i) {
            Log.d("DuMixGameSurfaceView", "onDetachedFromWindow");
        }
        AREngineDelegate aREngineDelegate = this.a;
        if (aREngineDelegate != null) {
            aREngineDelegate.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    @Override // com.baidu.smallgame.sdk.ArBridge.FirstFrameListener
    public void onFirstFrameFinished() {
        n();
        SwanAppActivity activity = tr2.V().getActivity();
        if (activity != null) {
            fj2 R = activity.R();
            if (R instanceof h24) {
                ((h24) R).l1();
            }
        }
    }

    public void p() {
        surfaceChanged(getHolder(), 0, getWidth(), getHeight());
    }

    public void s() {
        if (i) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_PAUSE);
        }
        u(new b());
        AREngineDelegate aREngineDelegate = this.a;
        if (aREngineDelegate != null) {
            aREngineDelegate.onPause();
        }
        h64.a().d();
    }

    public void t() {
        if (i) {
            Log.d("DuMixGameSurfaceView", "onResume");
        }
        AREngineDelegate aREngineDelegate = this.a;
        if (aREngineDelegate != null) {
            aREngineDelegate.onResume();
        }
        h64.a().e();
    }

    public final void w() {
        this.e = 0;
        this.d = 0;
    }

    public DuMixGameSurfaceView(Context context) {
        super(context);
        o();
    }

    private void setRenderer(GLSurfaceView.Renderer renderer) {
        AREngineDelegate aREngineDelegate = this.a;
        if (aREngineDelegate != null) {
            aREngineDelegate.setRenderer(renderer);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.c.a(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void r(V8ExceptionInfo v8ExceptionInfo) {
        AREngineDelegate aREngineDelegate = this.a;
        if (aREngineDelegate != null && aREngineDelegate.getStuckScreenHandler() != null) {
            this.a.getStuckScreenHandler().a(0, v8ExceptionInfo);
        }
    }

    public void setRenderMode(int i2) {
        AREngineDelegate aREngineDelegate = this.a;
        if (aREngineDelegate != null) {
            aREngineDelegate.setRenderMode(i2);
        }
    }

    public void setV8Engine(od2 od2Var) {
        this.b = od2Var;
        this.c.c(od2Var);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (i) {
            Log.d("DuMixGameSurfaceView", "surfaceCreated");
        }
        AREngineDelegate aREngineDelegate = this.a;
        if (aREngineDelegate != null) {
            aREngineDelegate.surfaceCreated();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (i) {
            Log.d("DuMixGameSurfaceView", "surfaceDestroyed width");
        }
        w();
        AREngineDelegate aREngineDelegate = this.a;
        if (aREngineDelegate != null) {
            aREngineDelegate.surfaceDestroyed();
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        AREngineDelegate aREngineDelegate = this.a;
        if (aREngineDelegate != null) {
            aREngineDelegate.requestRenderAndWait();
        }
    }

    public void u(Runnable runnable) {
        if (i) {
            Log.d("DuMixGameSurfaceView", "queueEvent");
        }
        AREngineDelegate aREngineDelegate = this.a;
        if (aREngineDelegate != null) {
            aREngineDelegate.queueEvent(runnable);
        }
    }

    public void x(Runnable runnable) {
        if (i) {
            Log.d("DuMixGameSurfaceView", "runOnGLThread");
        }
        AREngineDelegate aREngineDelegate = this.a;
        if (aREngineDelegate != null) {
            aREngineDelegate.runOnGLThread(runnable);
        }
    }

    public DuMixGameSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        o();
    }

    public void v(Runnable runnable, long j) {
        if (i) {
            Log.d("DuMixGameSurfaceView", "queueEvent delayed");
        }
        AREngineDelegate aREngineDelegate = this.a;
        if (aREngineDelegate != null) {
            aREngineDelegate.queueEvent(runnable, j);
        }
    }

    public final void o() {
        if (i) {
            Log.d("DuMixGameSurfaceView", "init");
        }
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        MarioSDK.a aVar = new MarioSDK.a();
        aVar.k(holder);
        aVar.i(this);
        aVar.j(new c());
        aVar.h(AppRuntime.getAppContext());
        aVar.f(new n24());
        lz2.p("preload").F(new UbcFlowEvent("na_game_engine_start"));
        AREngineDelegate createAREngine = MarioSDK.createAREngine(aVar);
        this.a = createAREngine;
        createAREngine.setPermissionProxy(new ie2());
        this.a.setOnStuckScreenListener(new a());
        this.a.startEngine();
        lz2.p("preload").F(new UbcFlowEvent("na_game_engine_end"));
        this.c = new p24();
        this.h = new GameRecorderController(this.a);
        h64.a().g(this.h);
    }

    public void q() {
        if (i) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_DESTROY);
        }
        w();
        h64.a().f(this.h);
        if (this.a != null) {
            od2 od2Var = this.b;
            if (od2Var != null) {
                od2Var.i0();
            }
            this.a.setFirstFrameListener(null);
            this.a.setOnStuckScreenListener(null);
            this.a.smallGameDestroy();
            this.a.exitGLThread();
            this.a = null;
        }
    }

    public void y() {
        Pair<Integer, Integer> y = tr2.V().y();
        AREngineDelegate aREngineDelegate = this.a;
        if (aREngineDelegate != null) {
            aREngineDelegate.updateSurfaceViewSize(((Integer) y.first).intValue(), ((Integer) y.second).intValue());
            this.a.initDisplayMetrics();
        }
        p24 p24Var = this.c;
        if (p24Var != null) {
            p24Var.d(((Integer) y.first).intValue(), ((Integer) y.second).intValue());
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        if (i) {
            Log.d("DuMixGameSurfaceView", "surfaceChanged width: " + i3 + ", height: " + i4);
        }
        AREngineDelegate aREngineDelegate = this.a;
        if (aREngineDelegate != null) {
            aREngineDelegate.surfaceChanged(i3, i4);
        }
        p24 p24Var = this.c;
        if (p24Var != null) {
            p24Var.b(i3, i4);
        }
    }
}
