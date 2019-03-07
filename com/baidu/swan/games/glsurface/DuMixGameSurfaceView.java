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
import com.baidu.swan.apps.c;
import com.baidu.swan.apps.o.d;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.f;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes2.dex */
public class DuMixGameSurfaceView extends SurfaceView implements SurfaceHolder.Callback2 {
    private static final boolean DEBUG = c.DEBUG;
    private int NU;
    private int NV;
    private com.baidu.swan.games.e.a bcH;
    private AREngineDelegate bcQ;
    private com.baidu.swan.games.glsurface.a.a bcR;
    private volatile b bcS;

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
        this.bcQ = MarioSDK.createAREngine(aVar);
        f.fy("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_game_engine_end"));
        this.bcR = new com.baidu.swan.games.glsurface.a.a();
        this.bcR.Ot();
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
        if (this.bcQ != null) {
            this.bcQ.setRenderer(renderer);
        }
    }

    public void setRenderMode(int i) {
        if (this.bcQ != null) {
            this.bcQ.setRenderMode(i);
        }
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return this.bcH;
    }

    public void setV8Engine(com.baidu.swan.games.e.a aVar) {
        this.bcH = aVar;
        this.bcR.setV8Engine(this.bcH);
    }

    public Thread getThread() {
        if (this.bcQ != null) {
            return this.bcQ.getGLThread();
        }
        return null;
    }

    public int getRenderMode() {
        if (this.bcQ != null) {
            return this.bcQ.getRenderMode();
        }
        return 1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceCreated");
        }
        if (this.bcQ != null) {
            this.bcQ.surfaceCreated();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceChanged width: " + i2 + ", height: " + i3);
        }
        if (this.bcQ != null) {
            this.bcQ.surfaceChanged(i2, i3);
        }
        if (this.bcR != null) {
            this.bcR.J(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceDestroyed width");
        }
        Oq();
        if (this.bcQ != null) {
            this.bcQ.surfaceDestroyed();
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        if (this.bcQ != null) {
            this.bcQ.requestRenderAndWait();
        }
    }

    public void onPause() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onPause");
        }
        queueEvent(new Runnable() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DuMixGameSurfaceView.this.bcQ.getArBridge() != null) {
                    DuMixGameSurfaceView.this.bcQ.getArBridge().smallGameOnPause();
                }
            }
        });
        if (this.bcQ != null) {
            this.bcQ.onPause();
        }
    }

    public void onResume() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onResume");
        }
        if (this.bcQ != null) {
            this.bcQ.onResume();
        }
    }

    public void onDestroy() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDestroy");
        }
        Oq();
        if (this.bcQ.getArBridge() != null) {
            this.bcQ.getArBridge().smallGameDestroy();
        }
    }

    public void queueEvent(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent");
        }
        if (this.bcQ != null) {
            this.bcQ.queueEvent(runnable);
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.bcQ != null) {
            this.bcQ.onAttachedToWindow();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDetachedFromWindow");
        }
        if (this.bcQ != null) {
            this.bcQ.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bcR.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void finalize() throws Throwable {
        if (this.bcQ != null) {
            this.bcQ.exitGLThread();
            this.bcQ = null;
        }
    }

    private void Oq() {
        this.NV = 0;
        this.NU = 0;
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
            DuMixGameSurfaceView.this.NU = i;
            DuMixGameSurfaceView.this.NV = i2;
            if (DuMixGameSurfaceView.DEBUG) {
                Log.d("DuMixGameSurfaceView", "AiWebRender onSurfaceChanged width * height = " + i + " * " + i2);
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (DuMixGameSurfaceView.DEBUG) {
                Log.d("DuMixGameSurfaceView", "AiWebRender onDrawFrame !!!");
            }
            if (DuMixGameSurfaceView.this.bcQ.getArBridge() != null) {
                DuMixGameSurfaceView.this.bcQ.getArBridge().smallGameUpdate();
            }
            if (DuMixGameSurfaceView.this.bcS != null) {
                synchronized (DuMixGameSurfaceView.this) {
                    if (DuMixGameSurfaceView.this.bcS != null) {
                        DuMixGameSurfaceView.this.bcS.b(DuMixGameSurfaceView.this.getScreenShot(), DuMixGameSurfaceView.this.NU, DuMixGameSurfaceView.this.NV);
                        DuMixGameSurfaceView.this.bcS = null;
                    }
                }
            }
        }
    }

    public synchronized void a(b bVar) {
        this.bcS = bVar;
    }

    public synchronized void Or() {
        this.bcS = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] getScreenShot() {
        if (this.NU <= 0 || this.NV <= 0) {
            return null;
        }
        int[] iArr = new int[this.NU * this.NV];
        IntBuffer wrap = IntBuffer.wrap(iArr);
        wrap.position(0);
        GLES20.glReadPixels(0, 0, this.NU, this.NV, 6408, 5121, wrap);
        return iArr;
    }
}
