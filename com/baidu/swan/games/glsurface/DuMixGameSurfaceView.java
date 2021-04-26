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
import d.a.h0.a.j1.i;
import d.a.h0.a.k;
import d.a.h0.a.z0.f;
import d.a.h0.g.a0.g;
import d.a.h0.g.i.m.e;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes3.dex */
public class DuMixGameSurfaceView extends SurfaceView implements SurfaceHolder.Callback2, ArBridge.FirstFrameListener {
    public static final boolean m = k.f43101a;

    /* renamed from: e  reason: collision with root package name */
    public AREngineDelegate f12393e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.h0.g.i.a f12394f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.h0.g.o.c.a f12395g;

    /* renamed from: h  reason: collision with root package name */
    public int f12396h;

    /* renamed from: i  reason: collision with root package name */
    public int f12397i;
    public volatile d j;
    public boolean k;
    public GameRecorderController l;

    /* loaded from: classes3.dex */
    public class a implements d.a.e0.a.d.a {
        public a() {
        }

        @Override // d.a.e0.a.d.a
        public void a() {
            d.a.h0.g.o.c.b.k();
        }

        @Override // d.a.e0.a.d.a
        public void b(d.a.e0.a.d.b bVar) {
            d.a.h0.g.e0.b.c(bVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (DuMixGameSurfaceView.this.f12393e != null) {
                DuMixGameSurfaceView.this.f12393e.smallGameOnPause();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements GLSurfaceView.Renderer {
        public c() {
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (DuMixGameSurfaceView.m) {
                Log.d("DuMixGameSurfaceView", "AiWebRender onDrawFrame !!!");
            }
            if (DuMixGameSurfaceView.this.f12393e == null) {
                return;
            }
            DuMixGameSurfaceView.this.f12393e.smallGameUpdate();
            if (DuMixGameSurfaceView.this.j != null) {
                if (DuMixGameSurfaceView.this.k) {
                    DuMixGameSurfaceView.this.j.a(DuMixGameSurfaceView.this.getScreenShot(), DuMixGameSurfaceView.this.f12396h, DuMixGameSurfaceView.this.f12397i);
                    DuMixGameSurfaceView.this.f12393e.setScreenShotStatus(false);
                    DuMixGameSurfaceView.this.k = false;
                    DuMixGameSurfaceView.this.j = null;
                }
                if (DuMixGameSurfaceView.this.j != null) {
                    DuMixGameSurfaceView.this.f12393e.setScreenShotStatus(true);
                    DuMixGameSurfaceView.this.k = true;
                }
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
            DuMixGameSurfaceView.this.f12396h = i2;
            DuMixGameSurfaceView.this.f12397i = i3;
            if (DuMixGameSurfaceView.m) {
                Log.d("DuMixGameSurfaceView", "AiWebRender onSurfaceChanged width * height = " + i2 + " * " + i3);
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            if (DuMixGameSurfaceView.m) {
                Log.d("DuMixGameSurfaceView", "AiWebRender onSurfaceCreated !!!");
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(int[] iArr, int i2, int i3);
    }

    static {
        d.a.h0.g.i0.f.d.i();
    }

    public DuMixGameSurfaceView(Context context) {
        super(context);
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] getScreenShot() {
        int i2;
        int i3 = this.f12396h;
        if (i3 > 0 && (i2 = this.f12397i) > 0) {
            try {
                int[] iArr = new int[i3 * i2];
                IntBuffer wrap = IntBuffer.wrap(iArr);
                wrap.position(0);
                GLES20.glReadPixels(0, 0, this.f12396h, this.f12397i, 6408, 5121, wrap);
                return iArr;
            } catch (OutOfMemoryError unused) {
            }
        }
        return null;
    }

    private void setRenderer(GLSurfaceView.Renderer renderer) {
        AREngineDelegate aREngineDelegate = this.f12393e;
        if (aREngineDelegate != null) {
            aREngineDelegate.setRenderer(renderer);
        }
    }

    public void finalize() throws Throwable {
        if (this.f12393e != null) {
            d.a.h0.g.i.a aVar = this.f12394f;
            if (aVar != null) {
                aVar.h0();
            }
            this.f12393e.setFirstFrameListener(null);
            this.f12393e.setOnStuckScreenListener(null);
            this.f12393e.exitGLThread();
            this.f12393e = null;
        }
    }

    public int getFPS() {
        AREngineDelegate aREngineDelegate = this.f12393e;
        if (aREngineDelegate == null) {
            return 0;
        }
        return aREngineDelegate.getFPS();
    }

    public int getRenderMode() {
        AREngineDelegate aREngineDelegate = this.f12393e;
        if (aREngineDelegate != null) {
            return aREngineDelegate.getRenderMode();
        }
        return 1;
    }

    public Thread getThread() {
        AREngineDelegate aREngineDelegate = this.f12393e;
        if (aREngineDelegate != null) {
            return aREngineDelegate.getGLThread();
        }
        return null;
    }

    public d.a.h0.g.i.a getV8Engine() {
        return this.f12394f;
    }

    public void l() {
        if (m) {
            Log.d("DuMixGameSurfaceView", "executeQueueEvent");
        }
        AREngineDelegate aREngineDelegate = this.f12393e;
        if (aREngineDelegate != null) {
            aREngineDelegate.clearOldEvents();
        }
    }

    public void m() {
        d.a.h0.g.i.a aVar = this.f12394f;
        if (aVar != null) {
            d.a.h0.g.c0.d.b(aVar.k0());
        }
        AREngineDelegate aREngineDelegate = this.f12393e;
        if (aREngineDelegate != null) {
            d.a.h0.g.c0.d.b(aREngineDelegate.getPerformanceJson());
        }
    }

    public final void n() {
        if (m) {
            Log.d("DuMixGameSurfaceView", "init");
        }
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        MarioSDK.a aVar = new MarioSDK.a();
        aVar.k(holder);
        aVar.i(this);
        aVar.j(new c());
        aVar.h(AppRuntime.getAppContext());
        aVar.f(new d.a.h0.g.o.a());
        i.o("preload").A(new UbcFlowEvent("na_game_engine_start"));
        AREngineDelegate createAREngine = MarioSDK.createAREngine(aVar);
        this.f12393e = createAREngine;
        createAREngine.setPermissionProxy(new e());
        this.f12393e.setOnStuckScreenListener(new a());
        this.f12393e.startEngine();
        i.o("preload").A(new UbcFlowEvent("na_game_engine_end"));
        this.f12395g = new d.a.h0.g.o.c.a();
        this.l = new GameRecorderController(this.f12393e);
        g.a().g(this.l);
    }

    public void o() {
        surfaceChanged(getHolder(), 0, getWidth(), getHeight());
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AREngineDelegate aREngineDelegate = this.f12393e;
        if (aREngineDelegate != null) {
            aREngineDelegate.onAttachedToWindow();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        if (m) {
            Log.d("DuMixGameSurfaceView", "onDetachedFromWindow");
        }
        AREngineDelegate aREngineDelegate = this.f12393e;
        if (aREngineDelegate != null) {
            aREngineDelegate.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    @Override // com.baidu.smallgame.sdk.ArBridge.FirstFrameListener
    public void onFirstFrameFinished() {
        m();
        SwanAppActivity activity = f.V().getActivity();
        if (activity != null) {
            d.a.h0.a.o0.c frame = activity.getFrame();
            if (frame instanceof d.a.h0.g.m.b) {
                ((d.a.h0.g.m.b) frame).Y0();
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f12395g.a(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void p() {
        if (m) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_DESTROY);
        }
        v();
        g.a().f(this.l);
        if (this.f12393e != null) {
            d.a.h0.g.i.a aVar = this.f12394f;
            if (aVar != null) {
                aVar.h0();
            }
            this.f12393e.setFirstFrameListener(null);
            this.f12393e.setOnStuckScreenListener(null);
            this.f12393e.smallGameDestroy();
        }
    }

    public void q(V8ExceptionInfo v8ExceptionInfo) {
        AREngineDelegate aREngineDelegate = this.f12393e;
        if (aREngineDelegate == null || aREngineDelegate.getStuckScreenHandler() == null) {
            return;
        }
        this.f12393e.getStuckScreenHandler().a(0, v8ExceptionInfo);
    }

    public void r() {
        if (m) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_PAUSE);
        }
        t(new b());
        AREngineDelegate aREngineDelegate = this.f12393e;
        if (aREngineDelegate != null) {
            aREngineDelegate.onPause();
        }
        g.a().d();
    }

    public void s() {
        if (m) {
            Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_RESUME);
        }
        AREngineDelegate aREngineDelegate = this.f12393e;
        if (aREngineDelegate != null) {
            aREngineDelegate.onResume();
        }
        g.a().e();
    }

    public void setRenderMode(int i2) {
        AREngineDelegate aREngineDelegate = this.f12393e;
        if (aREngineDelegate != null) {
            aREngineDelegate.setRenderMode(i2);
        }
    }

    public void setV8Engine(d.a.h0.g.i.a aVar) {
        this.f12394f = aVar;
        this.f12395g.c(aVar);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        if (m) {
            Log.d("DuMixGameSurfaceView", "surfaceChanged width: " + i3 + ", height: " + i4);
        }
        AREngineDelegate aREngineDelegate = this.f12393e;
        if (aREngineDelegate != null) {
            aREngineDelegate.surfaceChanged(i3, i4);
        }
        d.a.h0.g.o.c.a aVar = this.f12395g;
        if (aVar != null) {
            aVar.b(i3, i4);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (m) {
            Log.d("DuMixGameSurfaceView", "surfaceCreated");
        }
        AREngineDelegate aREngineDelegate = this.f12393e;
        if (aREngineDelegate != null) {
            aREngineDelegate.surfaceCreated();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (m) {
            Log.d("DuMixGameSurfaceView", "surfaceDestroyed width");
        }
        v();
        AREngineDelegate aREngineDelegate = this.f12393e;
        if (aREngineDelegate != null) {
            aREngineDelegate.surfaceDestroyed();
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        AREngineDelegate aREngineDelegate = this.f12393e;
        if (aREngineDelegate != null) {
            aREngineDelegate.requestRenderAndWait();
        }
    }

    public void t(Runnable runnable) {
        if (m) {
            Log.d("DuMixGameSurfaceView", "queueEvent");
        }
        AREngineDelegate aREngineDelegate = this.f12393e;
        if (aREngineDelegate != null) {
            aREngineDelegate.queueEvent(runnable);
        }
    }

    public void u(Runnable runnable, long j) {
        if (m) {
            Log.d("DuMixGameSurfaceView", "queueEvent delayed");
        }
        AREngineDelegate aREngineDelegate = this.f12393e;
        if (aREngineDelegate != null) {
            aREngineDelegate.queueEvent(runnable, j);
        }
    }

    public final void v() {
        this.f12397i = 0;
        this.f12396h = 0;
    }

    public void w(Runnable runnable) {
        if (m) {
            Log.d("DuMixGameSurfaceView", "runOnGLThread");
        }
        AREngineDelegate aREngineDelegate = this.f12393e;
        if (aREngineDelegate != null) {
            aREngineDelegate.runOnGLThread(runnable);
        }
    }

    public void x() {
        Pair<Integer, Integer> y = f.V().y();
        AREngineDelegate aREngineDelegate = this.f12393e;
        if (aREngineDelegate != null) {
            aREngineDelegate.updateSurfaceViewSize(((Integer) y.first).intValue(), ((Integer) y.second).intValue());
            this.f12393e.initDisplayMetrics();
        }
        d.a.h0.g.o.c.a aVar = this.f12395g;
        if (aVar != null) {
            aVar.d(((Integer) y.first).intValue(), ((Integer) y.second).intValue());
        }
    }

    public DuMixGameSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        n();
    }
}
