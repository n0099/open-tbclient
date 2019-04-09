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
    private com.baidu.swan.games.e.a bcM;
    private AREngineDelegate bcV;
    private com.baidu.swan.games.glsurface.a.a bcW;
    private volatile b bcX;

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
        aVar.setFirstFrameListener(Ol());
        aVar.setRenderer(new a());
        f.fz("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_game_engine_start"));
        this.bcV = MarioSDK.createAREngine(aVar);
        f.fz("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_game_engine_end"));
        this.bcW = new com.baidu.swan.games.glsurface.a.a();
        this.bcW.Or();
    }

    private ArBridge.FirstFrameListener Ol() {
        if (getContext() instanceof SwanAppActivity) {
            d ut = ((SwanAppActivity) getContext()).ut();
            if (ut instanceof com.baidu.swan.games.g.a) {
                return ((com.baidu.swan.games.g.a) ut).Ol();
            }
        }
        return null;
    }

    private void setRenderer(GLSurfaceView.Renderer renderer) {
        if (this.bcV != null) {
            this.bcV.setRenderer(renderer);
        }
    }

    public void setRenderMode(int i) {
        if (this.bcV != null) {
            this.bcV.setRenderMode(i);
        }
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return this.bcM;
    }

    public void setV8Engine(com.baidu.swan.games.e.a aVar) {
        this.bcM = aVar;
        this.bcW.setV8Engine(this.bcM);
    }

    public Thread getThread() {
        if (this.bcV != null) {
            return this.bcV.getGLThread();
        }
        return null;
    }

    public int getRenderMode() {
        if (this.bcV != null) {
            return this.bcV.getRenderMode();
        }
        return 1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceCreated");
        }
        if (this.bcV != null) {
            this.bcV.surfaceCreated();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceChanged width: " + i2 + ", height: " + i3);
        }
        if (this.bcV != null) {
            this.bcV.surfaceChanged(i2, i3);
        }
        if (this.bcW != null) {
            this.bcW.J(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceDestroyed width");
        }
        Oo();
        if (this.bcV != null) {
            this.bcV.surfaceDestroyed();
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        if (this.bcV != null) {
            this.bcV.requestRenderAndWait();
        }
    }

    public void onPause() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onPause");
        }
        queueEvent(new Runnable() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DuMixGameSurfaceView.this.bcV.getArBridge() != null) {
                    DuMixGameSurfaceView.this.bcV.getArBridge().smallGameOnPause();
                }
            }
        });
        if (this.bcV != null) {
            this.bcV.onPause();
        }
    }

    public void onResume() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onResume");
        }
        if (this.bcV != null) {
            this.bcV.onResume();
        }
    }

    public void onDestroy() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDestroy");
        }
        Oo();
        if (this.bcV.getArBridge() != null) {
            this.bcV.getArBridge().smallGameDestroy();
        }
    }

    public void queueEvent(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent");
        }
        if (this.bcV != null) {
            this.bcV.queueEvent(runnable);
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.bcV != null) {
            this.bcV.onAttachedToWindow();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDetachedFromWindow");
        }
        if (this.bcV != null) {
            this.bcV.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bcW.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void finalize() throws Throwable {
        if (this.bcV != null) {
            this.bcV.exitGLThread();
            this.bcV = null;
        }
    }

    private void Oo() {
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
            if (DuMixGameSurfaceView.this.bcV.getArBridge() != null) {
                DuMixGameSurfaceView.this.bcV.getArBridge().smallGameUpdate();
            }
            if (DuMixGameSurfaceView.this.bcX != null) {
                synchronized (DuMixGameSurfaceView.this) {
                    if (DuMixGameSurfaceView.this.bcX != null) {
                        DuMixGameSurfaceView.this.bcX.b(DuMixGameSurfaceView.this.getScreenShot(), DuMixGameSurfaceView.this.NV, DuMixGameSurfaceView.this.NW);
                        DuMixGameSurfaceView.this.bcX = null;
                    }
                }
            }
        }
    }

    public synchronized void a(b bVar) {
        this.bcX = bVar;
    }

    public synchronized void Op() {
        this.bcX = null;
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
