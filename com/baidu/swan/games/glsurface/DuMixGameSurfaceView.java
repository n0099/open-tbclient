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
    private AREngineDelegate bAl;
    private com.baidu.swan.games.glsurface.a.a bAm;
    private volatile b bAn;
    private GameRecorderController bAo;
    private com.baidu.swan.games.e.a bzZ;
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
        aVar.setFirstFrameListener(WR());
        aVar.setRenderer(new a());
        f.gz("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_game_engine_start"));
        this.bAl = MarioSDK.createAREngine(aVar);
        f.gz("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_game_engine_end"));
        this.bAm = new com.baidu.swan.games.glsurface.a.a();
        this.bAo = new GameRecorderController(this.bAl);
        d.XM().b(this.bAo);
    }

    private ArBridge.FirstFrameListener WR() {
        if (getContext() instanceof SwanAppActivity) {
            com.baidu.swan.apps.o.d AD = ((SwanAppActivity) getContext()).AD();
            if (AD instanceof com.baidu.swan.games.g.a) {
                return ((com.baidu.swan.games.g.a) AD).WR();
            }
        }
        return null;
    }

    private void setRenderer(GLSurfaceView.Renderer renderer) {
        if (this.bAl != null) {
            this.bAl.setRenderer(renderer);
        }
    }

    public void setRenderMode(int i) {
        if (this.bAl != null) {
            this.bAl.setRenderMode(i);
        }
    }

    public void WY() {
        Pair<Integer, Integer> Lt = e.LE().Lt();
        V8Engine.updateSurfaceViewSize(((Integer) Lt.first).intValue(), ((Integer) Lt.second).intValue());
        if (this.bAm != null) {
            this.bAm.N(((Integer) Lt.first).intValue(), ((Integer) Lt.second).intValue());
        }
    }

    public void WZ() {
        surfaceChanged(getHolder(), 0, getWidth(), getHeight());
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return this.bzZ;
    }

    public void setV8Engine(com.baidu.swan.games.e.a aVar) {
        this.bzZ = aVar;
        this.bAm.setV8Engine(this.bzZ);
    }

    public Thread getThread() {
        if (this.bAl != null) {
            return this.bAl.getGLThread();
        }
        return null;
    }

    public int getRenderMode() {
        if (this.bAl != null) {
            return this.bAl.getRenderMode();
        }
        return 1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceCreated");
        }
        if (this.bAl != null) {
            this.bAl.surfaceCreated();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceChanged width: " + i2 + ", height: " + i3);
        }
        if (this.bAl != null) {
            this.bAl.surfaceChanged(i2, i3);
        }
        if (this.bAm != null) {
            this.bAm.O(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "surfaceDestroyed width");
        }
        Xa();
        if (this.bAl != null) {
            this.bAl.surfaceDestroyed();
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        if (this.bAl != null) {
            this.bAl.requestRenderAndWait();
        }
    }

    public void onPause() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onPause");
        }
        queueEvent(new Runnable() { // from class: com.baidu.swan.games.glsurface.DuMixGameSurfaceView.1
            @Override // java.lang.Runnable
            public void run() {
                if (DuMixGameSurfaceView.this.bAl.getArBridge() != null) {
                    DuMixGameSurfaceView.this.bAl.getArBridge().smallGameOnPause();
                }
            }
        });
        if (this.bAl != null) {
            this.bAl.onPause();
        }
        d.XM().XP();
    }

    public void onResume() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onResume");
        }
        if (this.bAl != null) {
            this.bAl.onResume();
        }
        d.XM().XQ();
    }

    public void onDestroy() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDestroy");
        }
        Xa();
        d.XM().c(this.bAo);
        if (this.bAl.getArBridge() != null) {
            this.bAl.getArBridge().smallGameDestroy();
        }
    }

    public void queueEvent(Runnable runnable) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent");
        }
        if (this.bAl != null) {
            this.bAl.queueEvent(runnable);
        }
    }

    public void queueEvent(Runnable runnable, long j) {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "queueEvent delayed");
        }
        if (this.bAl != null) {
            this.bAl.queueEvent(runnable, j);
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.bAl != null) {
            this.bAl.onAttachedToWindow();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (DEBUG) {
            Log.d("DuMixGameSurfaceView", "onDetachedFromWindow");
        }
        if (this.bAl != null) {
            this.bAl.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bAm.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void finalize() throws Throwable {
        if (this.bAl != null) {
            this.bAl.exitGLThread();
            this.bAl = null;
        }
    }

    private void Xa() {
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
            if (DuMixGameSurfaceView.this.bAl.getArBridge() != null) {
                DuMixGameSurfaceView.this.bAl.getArBridge().smallGameUpdate();
            }
            if (DuMixGameSurfaceView.this.bAn != null) {
                synchronized (DuMixGameSurfaceView.this) {
                    if (DuMixGameSurfaceView.this.bAn != null) {
                        DuMixGameSurfaceView.this.bAn.b(DuMixGameSurfaceView.this.getScreenShot(), DuMixGameSurfaceView.this.mDrawWidth, DuMixGameSurfaceView.this.mDrawHeight);
                        DuMixGameSurfaceView.this.bAn = null;
                    }
                }
            }
        }
    }

    public synchronized void a(b bVar) {
        this.bAn = bVar;
    }

    public synchronized void Xb() {
        this.bAn = null;
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
