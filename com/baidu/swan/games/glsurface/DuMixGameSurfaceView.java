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
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.smallgame.sdk.ArBridge;
import com.baidu.smallgame.sdk.MarioSDK;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.f;
import com.baidu.swan.apps.w.e;
import com.baidu.swan.games.screenrecord.GameRecorderController;
import com.baidu.swan.games.screenrecord.d;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes2.dex */
public class DuMixGameSurfaceView extends SurfaceView implements SurfaceHolder.Callback2 {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.e.a bAQ;
    private AREngineDelegate bBc;
    private com.baidu.swan.games.glsurface.a.a bBd;
    private volatile b bBe;
    private GameRecorderController bBf;
    private int mDrawHeight;
    private int mDrawWidth;

    /* loaded from: classes2.dex */
    public interface b {
        void b(int[] iArr, int i, int i2);
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
            Log.d("DuMixGameSurfaceView", "init");
        }
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        MarioSDK.a aVar = new MarioSDK.a();
        aVar.setSurfaceHolder(holder);
        aVar.setFirstFrameListener(WT());
        aVar.setRenderer(new a());
        f.gz("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_game_engine_start"));
        this.bBc = MarioSDK.createAREngine(aVar);
        f.gz("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_game_engine_end"));
        this.bBd = new com.baidu.swan.games.glsurface.a.a();
        this.bBf = new GameRecorderController(this.bBc);
        d.XO().b(this.bBf);
    }

    private ArBridge.FirstFrameListener WT() {
        if (getContext() instanceof SwanAppActivity) {
            com.baidu.swan.apps.o.d AC = ((SwanAppActivity) getContext()).AC();
            if (AC instanceof com.baidu.swan.games.g.a) {
                return ((com.baidu.swan.games.g.a) AC).WT();
            }
        }
        return null;
    }

    private void setRenderer(GLSurfaceView.Renderer renderer) {
        if (this.bBc != null) {
            this.bBc.setRenderer(renderer);
        }
    }

    public void setRenderMode(int i) {
        if (this.bBc != null) {
            this.bBc.setRenderMode(i);
        }
    }

    public void Xa() {
        Pair<Integer, Integer> Ls = e.LD().Ls();
        V8Engine.updateSurfaceViewSize(((Integer) Ls.first).intValue(), ((Integer) Ls.second).intValue());
        if (this.bBd != null) {
            this.bBd.P(((Integer) Ls.first).intValue(), ((Integer) Ls.second).intValue());
        }
    }

    public void Xb() {
        surfaceChanged(getHolder(), 0, getWidth(), getHeight());
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return this.bAQ;
    }

    public void setV8Engine(com.baidu.swan.games.e.a aVar) {
        this.bAQ = aVar;
        this.bBd.setV8Engine(this.bAQ);
    }

    public Thread getThread() {
        if (this.bBc != null) {
            return this.bBc.getGLThread();
        }
        return null;
    }

    public int getRenderMode() {
        if (this.bBc != null) {
            return this.bBc.getRenderMode();
        }
        return 1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceCreated");
        }
        if (this.bBc != null) {
            this.bBc.surfaceCreated();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceChanged width: " + i2 + ", height: " + i3);
        }
        if (this.bBc != null) {
            this.bBc.surfaceChanged(i2, i3);
        }
        if (this.bBd != null) {
            this.bBd.Q(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceDestroyed width");
        }
        Xc();
        if (this.bBc != null) {
            this.bBc.surfaceDestroyed();
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        if (this.bBc != null) {
            this.bBc.requestRenderAndWait();
        }
    }

    public void onPause() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onPause");
        }
        queueEvent(new Runnable() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DuMixGameSurfaceView.this.bBc.getArBridge() != null) {
                    DuMixGameSurfaceView.this.bBc.getArBridge().smallGameOnPause();
                }
            }
        });
        if (this.bBc != null) {
            this.bBc.onPause();
        }
        d.XO().XR();
    }

    public void onResume() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onResume");
        }
        if (this.bBc != null) {
            this.bBc.onResume();
        }
        d.XO().XS();
    }

    public void onDestroy() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDestroy");
        }
        Xc();
        d.XO().c(this.bBf);
        if (this.bBc.getArBridge() != null) {
            this.bBc.getArBridge().smallGameDestroy();
        }
    }

    public void queueEvent(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent");
        }
        if (this.bBc != null) {
            this.bBc.queueEvent(runnable);
        }
    }

    public void queueEvent(Runnable runnable, long j) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent delayed");
        }
        if (this.bBc != null) {
            this.bBc.queueEvent(runnable, j);
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.bBc != null) {
            this.bBc.onAttachedToWindow();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDetachedFromWindow");
        }
        if (this.bBc != null) {
            this.bBc.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bBd.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void finalize() throws Throwable {
        if (this.bBc != null) {
            this.bBc.exitGLThread();
            this.bBc = null;
        }
    }

    private void Xc() {
        this.mDrawHeight = 0;
        this.mDrawWidth = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
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
            if (DuMixGameSurfaceView.this.bBc.getArBridge() != null) {
                DuMixGameSurfaceView.this.bBc.getArBridge().smallGameUpdate();
            }
            if (DuMixGameSurfaceView.this.bBe != null) {
                synchronized (DuMixGameSurfaceView.this) {
                    if (DuMixGameSurfaceView.this.bBe != null) {
                        DuMixGameSurfaceView.this.bBe.b(DuMixGameSurfaceView.this.getScreenShot(), DuMixGameSurfaceView.this.mDrawWidth, DuMixGameSurfaceView.this.mDrawHeight);
                        DuMixGameSurfaceView.this.bBe = null;
                    }
                }
            }
        }
    }

    public synchronized void a(b bVar) {
        this.bBe = bVar;
    }

    public synchronized void Xd() {
        this.bBe = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] getScreenShot() {
        if (this.mDrawWidth <= 0 || this.mDrawHeight <= 0) {
            return null;
        }
        int[] iArr = new int[this.mDrawWidth * this.mDrawHeight];
        IntBuffer wrap = IntBuffer.wrap(iArr);
        wrap.position(0);
        GLES20.glReadPixels(0, 0, this.mDrawWidth, this.mDrawHeight, 6408, 5121, wrap);
        return iArr;
    }
}
