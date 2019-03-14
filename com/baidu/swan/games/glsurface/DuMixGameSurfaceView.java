package com.baidu.swan.games.glsurface;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.smallgame.sdk.ArBridge;
import com.baidu.smallgame.sdk.MarioSDK;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.o.d;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.f;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes2.dex */
public class DuMixGameSurfaceView extends SurfaceView implements SurfaceHolder.Callback2 {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private int NV;
    private int NW;
    private com.baidu.swan.games.e.a bcI;
    private AREngineDelegate bcR;
    private com.baidu.swan.games.glsurface.a.a bcS;
    private volatile b bcT;

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
        aVar.setFirstFrameListener(On());
        aVar.setRenderer(new a());
        f.fy("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_game_engine_start"));
        this.bcR = MarioSDK.createAREngine(aVar);
        f.fy("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_game_engine_end"));
        this.bcS = new com.baidu.swan.games.glsurface.a.a();
        this.bcS.Ot();
    }

    private ArBridge.FirstFrameListener On() {
        if (getContext() instanceof SwanAppActivity) {
            d uu = ((SwanAppActivity) getContext()).uu();
            if (uu instanceof com.baidu.swan.games.g.a) {
                return ((com.baidu.swan.games.g.a) uu).On();
            }
        }
        return null;
    }

    private void setRenderer(GLSurfaceView.Renderer renderer) {
        if (this.bcR != null) {
            this.bcR.setRenderer(renderer);
        }
    }

    public void setRenderMode(int i) {
        if (this.bcR != null) {
            this.bcR.setRenderMode(i);
        }
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return this.bcI;
    }

    public void setV8Engine(com.baidu.swan.games.e.a aVar) {
        this.bcI = aVar;
        this.bcS.setV8Engine(this.bcI);
    }

    public Thread getThread() {
        if (this.bcR != null) {
            return this.bcR.getGLThread();
        }
        return null;
    }

    public int getRenderMode() {
        if (this.bcR != null) {
            return this.bcR.getRenderMode();
        }
        return 1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceCreated");
        }
        if (this.bcR != null) {
            this.bcR.surfaceCreated();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceChanged width: " + i2 + ", height: " + i3);
        }
        if (this.bcR != null) {
            this.bcR.surfaceChanged(i2, i3);
        }
        if (this.bcS != null) {
            this.bcS.J(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceDestroyed width");
        }
        Oq();
        if (this.bcR != null) {
            this.bcR.surfaceDestroyed();
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        if (this.bcR != null) {
            this.bcR.requestRenderAndWait();
        }
    }

    public void onPause() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onPause");
        }
        queueEvent(new Runnable() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DuMixGameSurfaceView.this.bcR.getArBridge() != null) {
                    DuMixGameSurfaceView.this.bcR.getArBridge().smallGameOnPause();
                }
            }
        });
        if (this.bcR != null) {
            this.bcR.onPause();
        }
    }

    public void onResume() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onResume");
        }
        if (this.bcR != null) {
            this.bcR.onResume();
        }
    }

    public void onDestroy() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDestroy");
        }
        Oq();
        if (this.bcR.getArBridge() != null) {
            this.bcR.getArBridge().smallGameDestroy();
        }
    }

    public void queueEvent(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent");
        }
        if (this.bcR != null) {
            this.bcR.queueEvent(runnable);
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.bcR != null) {
            this.bcR.onAttachedToWindow();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDetachedFromWindow");
        }
        if (this.bcR != null) {
            this.bcR.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bcS.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void finalize() throws Throwable {
        if (this.bcR != null) {
            this.bcR.exitGLThread();
            this.bcR = null;
        }
    }

    private void Oq() {
        this.NW = 0;
        this.NV = 0;
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
            DuMixGameSurfaceView.this.NV = i;
            DuMixGameSurfaceView.this.NW = i2;
            if (DuMixGameSurfaceView.DEBUG) {
                Log.d("DuMixGameSurfaceView", "AiWebRender onSurfaceChanged width * height = " + i + " * " + i2);
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (DuMixGameSurfaceView.DEBUG) {
                Log.d("DuMixGameSurfaceView", "AiWebRender onDrawFrame !!!");
            }
            if (DuMixGameSurfaceView.this.bcR.getArBridge() != null) {
                DuMixGameSurfaceView.this.bcR.getArBridge().smallGameUpdate();
            }
            if (DuMixGameSurfaceView.this.bcT != null) {
                synchronized (DuMixGameSurfaceView.this) {
                    if (DuMixGameSurfaceView.this.bcT != null) {
                        DuMixGameSurfaceView.this.bcT.b(DuMixGameSurfaceView.this.getScreenShot(), DuMixGameSurfaceView.this.NV, DuMixGameSurfaceView.this.NW);
                        DuMixGameSurfaceView.this.bcT = null;
                    }
                }
            }
        }
    }

    public synchronized void a(b bVar) {
        this.bcT = bVar;
    }

    public synchronized void Or() {
        this.bcT = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] getScreenShot() {
        if (this.NV <= 0 || this.NW <= 0) {
            return null;
        }
        int[] iArr = new int[this.NV * this.NW];
        IntBuffer wrap = IntBuffer.wrap(iArr);
        wrap.position(0);
        GLES20.glReadPixels(0, 0, this.NV, this.NW, 6408, 5121, wrap);
        return iArr;
    }
}
