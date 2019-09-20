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
    private com.baidu.swan.games.e.a bia;
    private AREngineDelegate bio;
    private com.baidu.swan.games.glsurface.a.a bip;
    private volatile b biq;
    private GameRecorderController bir;

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
        aVar.setFirstFrameListener(Sc());
        aVar.setRenderer(new a());
        f.fU("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_game_engine_start"));
        this.bio = MarioSDK.createAREngine(aVar);
        f.fU("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_game_engine_end"));
        this.bip = new com.baidu.swan.games.glsurface.a.a();
        this.bir = new GameRecorderController(this.bio);
        d.SX().b(this.bir);
    }

    private ArBridge.FirstFrameListener Sc() {
        if (getContext() instanceof SwanAppActivity) {
            com.baidu.swan.apps.o.d vI = ((SwanAppActivity) getContext()).vI();
            if (vI instanceof com.baidu.swan.games.g.a) {
                return ((com.baidu.swan.games.g.a) vI).Sc();
            }
        }
        return null;
    }

    private void setRenderer(GLSurfaceView.Renderer renderer) {
        if (this.bio != null) {
            this.bio.setRenderer(renderer);
        }
    }

    public void setRenderMode(int i) {
        if (this.bio != null) {
            this.bio.setRenderMode(i);
        }
    }

    public void Sj() {
        Pair<Integer, Integer> Gy = e.GJ().Gy();
        V8Engine.updateSurfaceViewSize(((Integer) Gy.first).intValue(), ((Integer) Gy.second).intValue());
        if (this.bip != null) {
            this.bip.J(((Integer) Gy.first).intValue(), ((Integer) Gy.second).intValue());
        }
    }

    public void Sk() {
        surfaceChanged(getHolder(), 0, getWidth(), getHeight());
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return this.bia;
    }

    public void setV8Engine(com.baidu.swan.games.e.a aVar) {
        this.bia = aVar;
        this.bip.setV8Engine(this.bia);
    }

    public Thread getThread() {
        if (this.bio != null) {
            return this.bio.getGLThread();
        }
        return null;
    }

    public int getRenderMode() {
        if (this.bio != null) {
            return this.bio.getRenderMode();
        }
        return 1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceCreated");
        }
        if (this.bio != null) {
            this.bio.surfaceCreated();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceChanged width: " + i2 + ", height: " + i3);
        }
        if (this.bio != null) {
            this.bio.surfaceChanged(i2, i3);
        }
        if (this.bip != null) {
            this.bip.K(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceDestroyed width");
        }
        Sl();
        if (this.bio != null) {
            this.bio.surfaceDestroyed();
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        if (this.bio != null) {
            this.bio.requestRenderAndWait();
        }
    }

    public void onPause() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onPause");
        }
        queueEvent(new Runnable() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DuMixGameSurfaceView.this.bio.getArBridge() != null) {
                    DuMixGameSurfaceView.this.bio.getArBridge().smallGameOnPause();
                }
            }
        });
        if (this.bio != null) {
            this.bio.onPause();
        }
        d.SX().Ta();
    }

    public void onResume() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onResume");
        }
        if (this.bio != null) {
            this.bio.onResume();
        }
        d.SX().Tb();
    }

    public void onDestroy() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDestroy");
        }
        Sl();
        d.SX().c(this.bir);
        if (this.bio.getArBridge() != null) {
            this.bio.getArBridge().smallGameDestroy();
        }
    }

    public void queueEvent(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent");
        }
        if (this.bio != null) {
            this.bio.queueEvent(runnable);
        }
    }

    public void queueEvent(Runnable runnable, long j) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent delayed");
        }
        if (this.bio != null) {
            this.bio.queueEvent(runnable, j);
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.bio != null) {
            this.bio.onAttachedToWindow();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDetachedFromWindow");
        }
        if (this.bio != null) {
            this.bio.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bip.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void finalize() throws Throwable {
        if (this.bio != null) {
            this.bio.exitGLThread();
            this.bio = null;
        }
    }

    private void Sl() {
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
            if (DuMixGameSurfaceView.this.bio.getArBridge() != null) {
                DuMixGameSurfaceView.this.bio.getArBridge().smallGameUpdate();
            }
            if (DuMixGameSurfaceView.this.biq != null) {
                synchronized (DuMixGameSurfaceView.this) {
                    if (DuMixGameSurfaceView.this.biq != null) {
                        DuMixGameSurfaceView.this.biq.b(DuMixGameSurfaceView.this.getScreenShot(), DuMixGameSurfaceView.this.LQ, DuMixGameSurfaceView.this.LR);
                        DuMixGameSurfaceView.this.biq = null;
                    }
                }
            }
        }
    }

    public synchronized void a(b bVar) {
        this.biq = bVar;
    }

    public synchronized void Sm() {
        this.biq = null;
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
