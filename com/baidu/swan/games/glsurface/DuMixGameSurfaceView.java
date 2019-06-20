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
    private int LB;
    private int LC;
    private com.baidu.swan.games.e.a bgP;
    private AREngineDelegate bhb;
    private com.baidu.swan.games.glsurface.a.a bhc;
    private volatile b bhd;
    private GameRecorderController bhe;

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
        aVar.setFirstFrameListener(Rf());
        aVar.setRenderer(new a());
        f.fN("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_game_engine_start"));
        this.bhb = MarioSDK.createAREngine(aVar);
        f.fN("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_game_engine_end"));
        this.bhc = new com.baidu.swan.games.glsurface.a.a();
        this.bhe = new GameRecorderController(this.bhb);
        d.Sa().b(this.bhe);
    }

    private ArBridge.FirstFrameListener Rf() {
        if (getContext() instanceof SwanAppActivity) {
            com.baidu.swan.apps.o.d vd = ((SwanAppActivity) getContext()).vd();
            if (vd instanceof com.baidu.swan.games.g.a) {
                return ((com.baidu.swan.games.g.a) vd).Rf();
            }
        }
        return null;
    }

    private void setRenderer(GLSurfaceView.Renderer renderer) {
        if (this.bhb != null) {
            this.bhb.setRenderer(renderer);
        }
    }

    public void setRenderMode(int i) {
        if (this.bhb != null) {
            this.bhb.setRenderMode(i);
        }
    }

    public void Rm() {
        Pair<Integer, Integer> FK = e.FV().FK();
        V8Engine.updateSurfaceViewSize(((Integer) FK.first).intValue(), ((Integer) FK.second).intValue());
        if (this.bhc != null) {
            this.bhc.G(((Integer) FK.first).intValue(), ((Integer) FK.second).intValue());
        }
    }

    public void Rn() {
        surfaceChanged(getHolder(), 0, getWidth(), getHeight());
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return this.bgP;
    }

    public void setV8Engine(com.baidu.swan.games.e.a aVar) {
        this.bgP = aVar;
        this.bhc.setV8Engine(this.bgP);
    }

    public Thread getThread() {
        if (this.bhb != null) {
            return this.bhb.getGLThread();
        }
        return null;
    }

    public int getRenderMode() {
        if (this.bhb != null) {
            return this.bhb.getRenderMode();
        }
        return 1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceCreated");
        }
        if (this.bhb != null) {
            this.bhb.surfaceCreated();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceChanged width: " + i2 + ", height: " + i3);
        }
        if (this.bhb != null) {
            this.bhb.surfaceChanged(i2, i3);
        }
        if (this.bhc != null) {
            this.bhc.H(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceDestroyed width");
        }
        Ro();
        if (this.bhb != null) {
            this.bhb.surfaceDestroyed();
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        if (this.bhb != null) {
            this.bhb.requestRenderAndWait();
        }
    }

    public void onPause() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onPause");
        }
        queueEvent(new Runnable() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DuMixGameSurfaceView.this.bhb.getArBridge() != null) {
                    DuMixGameSurfaceView.this.bhb.getArBridge().smallGameOnPause();
                }
            }
        });
        if (this.bhb != null) {
            this.bhb.onPause();
        }
        d.Sa().Sd();
    }

    public void onResume() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onResume");
        }
        if (this.bhb != null) {
            this.bhb.onResume();
        }
        d.Sa().Se();
    }

    public void onDestroy() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDestroy");
        }
        Ro();
        d.Sa().c(this.bhe);
        if (this.bhb.getArBridge() != null) {
            this.bhb.getArBridge().smallGameDestroy();
        }
    }

    public void queueEvent(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent");
        }
        if (this.bhb != null) {
            this.bhb.queueEvent(runnable);
        }
    }

    public void queueEvent(Runnable runnable, long j) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent delayed");
        }
        if (this.bhb != null) {
            this.bhb.queueEvent(runnable, j);
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.bhb != null) {
            this.bhb.onAttachedToWindow();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDetachedFromWindow");
        }
        if (this.bhb != null) {
            this.bhb.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bhc.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void finalize() throws Throwable {
        if (this.bhb != null) {
            this.bhb.exitGLThread();
            this.bhb = null;
        }
    }

    private void Ro() {
        this.LC = 0;
        this.LB = 0;
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
            DuMixGameSurfaceView.this.LB = i;
            DuMixGameSurfaceView.this.LC = i2;
            if (DuMixGameSurfaceView.DEBUG) {
                Log.d("DuMixGameSurfaceView", "AiWebRender onSurfaceChanged width * height = " + i + " * " + i2);
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (DuMixGameSurfaceView.DEBUG) {
                Log.d("DuMixGameSurfaceView", "AiWebRender onDrawFrame !!!");
            }
            if (DuMixGameSurfaceView.this.bhb.getArBridge() != null) {
                DuMixGameSurfaceView.this.bhb.getArBridge().smallGameUpdate();
            }
            if (DuMixGameSurfaceView.this.bhd != null) {
                synchronized (DuMixGameSurfaceView.this) {
                    if (DuMixGameSurfaceView.this.bhd != null) {
                        DuMixGameSurfaceView.this.bhd.b(DuMixGameSurfaceView.this.getScreenShot(), DuMixGameSurfaceView.this.LB, DuMixGameSurfaceView.this.LC);
                        DuMixGameSurfaceView.this.bhd = null;
                    }
                }
            }
        }
    }

    public synchronized void a(b bVar) {
        this.bhd = bVar;
    }

    public synchronized void Rp() {
        this.bhd = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] getScreenShot() {
        if (this.LB <= 0 || this.LC <= 0) {
            return null;
        }
        int[] iArr = new int[this.LB * this.LC];
        IntBuffer wrap = IntBuffer.wrap(iArr);
        wrap.position(0);
        GLES20.glReadPixels(0, 0, this.LB, this.LC, 6408, 5121, wrap);
        return iArr;
    }
}
