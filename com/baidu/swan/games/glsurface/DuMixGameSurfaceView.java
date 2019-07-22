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
    private int LQ;
    private int LR;
    private com.baidu.swan.games.e.a bhC;
    private AREngineDelegate bhO;
    private com.baidu.swan.games.glsurface.a.a bhP;
    private volatile b bhQ;
    private GameRecorderController bhR;

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
        aVar.setFirstFrameListener(RY());
        aVar.setRenderer(new a());
        f.fS("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_game_engine_start"));
        this.bhO = MarioSDK.createAREngine(aVar);
        f.fS("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_game_engine_end"));
        this.bhP = new com.baidu.swan.games.glsurface.a.a();
        this.bhR = new GameRecorderController(this.bhO);
        d.ST().b(this.bhR);
    }

    private ArBridge.FirstFrameListener RY() {
        if (getContext() instanceof SwanAppActivity) {
            com.baidu.swan.apps.o.d vE = ((SwanAppActivity) getContext()).vE();
            if (vE instanceof com.baidu.swan.games.g.a) {
                return ((com.baidu.swan.games.g.a) vE).RY();
            }
        }
        return null;
    }

    private void setRenderer(GLSurfaceView.Renderer renderer) {
        if (this.bhO != null) {
            this.bhO.setRenderer(renderer);
        }
    }

    public void setRenderMode(int i) {
        if (this.bhO != null) {
            this.bhO.setRenderMode(i);
        }
    }

    public void Sf() {
        Pair<Integer, Integer> Gu = e.GF().Gu();
        V8Engine.updateSurfaceViewSize(((Integer) Gu.first).intValue(), ((Integer) Gu.second).intValue());
        if (this.bhP != null) {
            this.bhP.J(((Integer) Gu.first).intValue(), ((Integer) Gu.second).intValue());
        }
    }

    public void Sg() {
        surfaceChanged(getHolder(), 0, getWidth(), getHeight());
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return this.bhC;
    }

    public void setV8Engine(com.baidu.swan.games.e.a aVar) {
        this.bhC = aVar;
        this.bhP.setV8Engine(this.bhC);
    }

    public Thread getThread() {
        if (this.bhO != null) {
            return this.bhO.getGLThread();
        }
        return null;
    }

    public int getRenderMode() {
        if (this.bhO != null) {
            return this.bhO.getRenderMode();
        }
        return 1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceCreated");
        }
        if (this.bhO != null) {
            this.bhO.surfaceCreated();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceChanged width: " + i2 + ", height: " + i3);
        }
        if (this.bhO != null) {
            this.bhO.surfaceChanged(i2, i3);
        }
        if (this.bhP != null) {
            this.bhP.K(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceDestroyed width");
        }
        Sh();
        if (this.bhO != null) {
            this.bhO.surfaceDestroyed();
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        if (this.bhO != null) {
            this.bhO.requestRenderAndWait();
        }
    }

    public void onPause() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onPause");
        }
        queueEvent(new Runnable() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DuMixGameSurfaceView.this.bhO.getArBridge() != null) {
                    DuMixGameSurfaceView.this.bhO.getArBridge().smallGameOnPause();
                }
            }
        });
        if (this.bhO != null) {
            this.bhO.onPause();
        }
        d.ST().SW();
    }

    public void onResume() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onResume");
        }
        if (this.bhO != null) {
            this.bhO.onResume();
        }
        d.ST().SX();
    }

    public void onDestroy() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDestroy");
        }
        Sh();
        d.ST().c(this.bhR);
        if (this.bhO.getArBridge() != null) {
            this.bhO.getArBridge().smallGameDestroy();
        }
    }

    public void queueEvent(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent");
        }
        if (this.bhO != null) {
            this.bhO.queueEvent(runnable);
        }
    }

    public void queueEvent(Runnable runnable, long j) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent delayed");
        }
        if (this.bhO != null) {
            this.bhO.queueEvent(runnable, j);
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.bhO != null) {
            this.bhO.onAttachedToWindow();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDetachedFromWindow");
        }
        if (this.bhO != null) {
            this.bhO.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bhP.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void finalize() throws Throwable {
        if (this.bhO != null) {
            this.bhO.exitGLThread();
            this.bhO = null;
        }
    }

    private void Sh() {
        this.LR = 0;
        this.LQ = 0;
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
            DuMixGameSurfaceView.this.LQ = i;
            DuMixGameSurfaceView.this.LR = i2;
            if (DuMixGameSurfaceView.DEBUG) {
                Log.d("DuMixGameSurfaceView", "AiWebRender onSurfaceChanged width * height = " + i + " * " + i2);
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (DuMixGameSurfaceView.DEBUG) {
                Log.d("DuMixGameSurfaceView", "AiWebRender onDrawFrame !!!");
            }
            if (DuMixGameSurfaceView.this.bhO.getArBridge() != null) {
                DuMixGameSurfaceView.this.bhO.getArBridge().smallGameUpdate();
            }
            if (DuMixGameSurfaceView.this.bhQ != null) {
                synchronized (DuMixGameSurfaceView.this) {
                    if (DuMixGameSurfaceView.this.bhQ != null) {
                        DuMixGameSurfaceView.this.bhQ.b(DuMixGameSurfaceView.this.getScreenShot(), DuMixGameSurfaceView.this.LQ, DuMixGameSurfaceView.this.LR);
                        DuMixGameSurfaceView.this.bhQ = null;
                    }
                }
            }
        }
    }

    public synchronized void a(b bVar) {
        this.bhQ = bVar;
    }

    public synchronized void Si() {
        this.bhQ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] getScreenShot() {
        if (this.LQ <= 0 || this.LR <= 0) {
            return null;
        }
        int[] iArr = new int[this.LQ * this.LR];
        IntBuffer wrap = IntBuffer.wrap(iArr);
        wrap.position(0);
        GLES20.glReadPixels(0, 0, this.LQ, this.LR, 6408, 5121, wrap);
        return iArr;
    }
}
