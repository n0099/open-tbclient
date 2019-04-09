package com.baidu.smallgame.sdk;

import android.opengl.GLSurfaceView;
import android.view.SurfaceHolder;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.V8SoLoader;
import com.baidu.smallgame.sdk.ArBridge;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.coloros.mcssdk.mode.CommandMessage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes2.dex */
public final class a implements AREngineDelegate {
    private ArBridge aim;
    private Object aip;
    private g aiq;
    private d air;
    private e ais;
    private f ait;
    private boolean mDetached;
    private GLSurfaceView.Renderer mRenderer;
    private SurfaceHolder mSurfaceHolder;
    private long mCurrentGLThreadID = -1;
    private boolean ain = false;
    private final i aio = new i();

    /* loaded from: classes2.dex */
    public interface d {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* loaded from: classes2.dex */
    public interface e {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* loaded from: classes2.dex */
    public interface f {
        EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    static {
        V8SoLoader.load();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        Log.setMinLogLevel(6, false);
        this.aim = new ArBridge();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public ArBridge getArBridge() {
        return this.aim;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public Thread getGLThread() {
        return this.aiq;
    }

    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = (SurfaceHolder) new WeakReference(surfaceHolder).get();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderer(GLSurfaceView.Renderer renderer) {
        if (this.air == null) {
            this.air = new C0102a(8, 8, 8, 8, 16, 8);
        }
        if (this.ais == null) {
            this.ais = new b();
        }
        if (this.ait == null) {
            this.ait = new c();
        }
        this.mRenderer = renderer;
        this.aiq = new g(this);
        this.aiq.start();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderMode(int i2) {
        if (this.aiq != null) {
            this.aiq.setRenderMode(i2);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public int getRenderMode() {
        if (this.aiq != null) {
            return this.aiq.getRenderMode();
        }
        return 1;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRender() {
        if (this.aiq != null) {
            this.aiq.requestRender();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceCreated() {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceCreated.");
        this.aiq.surfaceCreated();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceDestroyed() {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceDestroyed.");
        this.aiq.surfaceDestroyed();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceChanged(int i2, int i3) {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceChanged. width=" + i2 + ", height=" + i3);
        this.aiq.x(i2, i3);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRenderAndWait() {
        if (this.aiq != null) {
            this.aiq.requestRenderAndWait();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameOnPause() {
        this.aim.smallGameOnPause();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable) {
        if (this.aiq != null) {
            this.aiq.queueEvent(runnable);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onAttachedToWindow() {
        if (this.mDetached && this.mRenderer != null) {
            int renderMode = this.aiq != null ? this.aiq.getRenderMode() : 1;
            this.aiq = new g(this);
            if (renderMode != 1) {
                this.aiq.setRenderMode(renderMode);
            }
            this.aiq.start();
        }
        this.mDetached = false;
        Log.w("EngineLogger", "[V8Dispose][AREngine] onAttachedToWindow");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onDetachedFromWindow() {
        if (!this.mDetached && this.aiq != null) {
            this.aiq.um();
        }
        this.mDetached = true;
        Log.w("EngineLogger", "[V8Dispose][AREngine] onDetachedFromWindow");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onPause() {
        if (this.aiq != null) {
            this.aiq.onPause();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onResume() {
        if (this.aiq != null) {
            this.aiq.onResume();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameDestroy() {
        this.aim.smallGameDestroy();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void exitGLThread() {
        if (this.aiq != null) {
            this.aiq.um();
        }
        Log.e("EngineLogger", "[V8Dispose][AREngine] exitGLThread.");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameUpdate() {
        this.aim.smallGameUpdate();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setFirstFrameListener(ArBridge.FirstFrameListener firstFrameListener) {
        this.aim.setFirstFrameListener(firstFrameListener);
    }

    protected void finalize() throws Throwable {
        try {
            if (this.aiq != null) {
                this.aiq.um();
            }
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class g extends Thread {
        private boolean aiA;
        private boolean aiB;
        private boolean aiC;
        private boolean aiD;
        private boolean aiE;
        private boolean aiF;
        private boolean aiG;
        private boolean aiH;
        private boolean aiL;
        private h aiN;
        private a aiO;
        private i aio;
        private boolean mPaused;
        private int aiv = 0;
        private long aiw = 0;
        private long aix = 0;
        private volatile boolean aiy = false;
        private volatile boolean aiz = false;
        private ArrayList<Runnable> mEventQueue = new ArrayList<>();
        private boolean aiM = true;
        private V8Engine mV8Engine = null;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean aiJ = true;
        private int aiI = 1;
        private boolean aiK = false;

        g(a aVar) {
            this.aiO = aVar;
            this.aio = aVar.aio;
        }

        /* JADX WARN: Type inference failed for: r4v0, types: [com.baidu.smallgame.sdk.a$h, com.baidu.smallgame.sdk.a, com.baidu.searchbox.v8engine.V8Engine] */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("ARGLThread " + getId());
            try {
                ui();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                this.aio.a(this);
                this.aiN.reset();
                this.aiN = null;
                this.aiO = null;
                this.mV8Engine = null;
            }
        }

        private V8Engine getV8Engine() {
            if (this.mV8Engine == null) {
                this.mV8Engine = V8Engine.getInstance();
            }
            return this.mV8Engine;
        }

        private float minFramesInterval() {
            V8Engine v8Engine = getV8Engine();
            if (v8Engine != null) {
                return v8Engine.minFramesInterval();
            }
            return 0.0f;
        }

        private void ug() {
            if (this.aiF) {
                this.aiF = false;
                this.aiN.destroySurface();
            }
        }

        private void uh() {
            if (this.aiE) {
                this.aiN.finish();
                this.aiE = false;
                this.aio.b(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [658=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX WARN: Code restructure failed: missing block: B:100:0x0201, code lost:
            if (r4 == false) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:102:0x020b, code lost:
            if (r23.aiN.un() == false) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:103:0x020d, code lost:
            r8 = r23.aio;
         */
        /* JADX WARN: Code restructure failed: missing block: B:104:0x0211, code lost:
            monitor-enter(r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:106:0x0213, code lost:
            r23.aiG = true;
            r23.aio.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:107:0x021e, code lost:
            monitor-exit(r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:108:0x021f, code lost:
            r8 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:109:0x0221, code lost:
            if (r14 == false) goto L76;
         */
        /* JADX WARN: Code restructure failed: missing block: B:110:0x0223, code lost:
            r16 = false;
            r17 = (javax.microedition.khronos.opengles.GL10) r23.aiN.uo();
         */
        /* JADX WARN: Code restructure failed: missing block: B:111:0x0231, code lost:
            if (r15 == false) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:112:0x0233, code lost:
            r4 = r23.aiO;
         */
        /* JADX WARN: Code restructure failed: missing block: B:113:0x0237, code lost:
            if (r4 == null) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:114:0x0239, code lost:
            r4.mRenderer.onSurfaceCreated(r17, r23.aiN.aiS);
         */
        /* JADX WARN: Code restructure failed: missing block: B:115:0x0248, code lost:
            r15 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:116:0x0249, code lost:
            if (r13 == false) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:117:0x024b, code lost:
            r4 = r23.aiO;
         */
        /* JADX WARN: Code restructure failed: missing block: B:118:0x024f, code lost:
            if (r4 == null) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:119:0x0251, code lost:
            r4.mRenderer.onSurfaceChanged(r17, r11, r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:120:0x025a, code lost:
            com.baidu.searchbox.v8engine.V8Engine.updateSurfaceViewSize(r11, r10);
            r13 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:121:0x025e, code lost:
            r4 = r23.aiO;
            r18 = java.lang.System.currentTimeMillis() - r23.aix;
         */
        /* JADX WARN: Code restructure failed: missing block: B:122:0x0272, code lost:
            if (r4.ain == false) goto L74;
         */
        /* JADX WARN: Code restructure failed: missing block: B:124:0x027d, code lost:
            if (((float) r18) < minFramesInterval()) goto L74;
         */
        /* JADX WARN: Code restructure failed: missing block: B:125:0x027f, code lost:
            r23.aix = java.lang.System.currentTimeMillis();
            r4.mRenderer.onDrawFrame(r17);
            uj();
            r4 = r23.aiN.up();
         */
        /* JADX WARN: Code restructure failed: missing block: B:126:0x029d, code lost:
            switch(r4) {
                case 12288: goto L72;
                case 12302: goto L73;
                default: goto L60;
            };
         */
        /* JADX WARN: Code restructure failed: missing block: B:127:0x02a0, code lost:
            com.baidu.smallgame.sdk.a.h.b("EngineLogger", "eglSwapBuffers", r4);
            r14 = r23.aio;
         */
        /* JADX WARN: Code restructure failed: missing block: B:128:0x02af, code lost:
            monitor-enter(r14);
         */
        /* JADX WARN: Code restructure failed: missing block: B:130:0x02b1, code lost:
            r23.aiC = true;
            r23.aio.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:131:0x02bc, code lost:
            monitor-exit(r14);
         */
        /* JADX WARN: Code restructure failed: missing block: B:132:0x02bd, code lost:
            r4 = r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:133:0x02be, code lost:
            r14 = r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:134:0x02bf, code lost:
            if (r7 == false) goto L71;
         */
        /* JADX WARN: Code restructure failed: missing block: B:135:0x02c1, code lost:
            r4 = true;
            r5 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:136:0x02c3, code lost:
            r6 = r11;
            r7 = r12;
            r11 = r14;
            r12 = r16;
            r14 = r15;
            r16 = r17;
            r22 = r13;
            r13 = r8;
            r8 = r4;
            r4 = r9;
            r9 = r5;
            r5 = r10;
            r10 = r22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:140:0x02d9, code lost:
            r8 = r23.aio;
         */
        /* JADX WARN: Code restructure failed: missing block: B:141:0x02dd, code lost:
            monitor-enter(r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:143:0x02e0, code lost:
            r23.aiG = true;
            r23.aiC = true;
            r23.aio.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:144:0x02f7, code lost:
            monitor-exit(r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:145:0x02f8, code lost:
            r8 = r6;
            r6 = r11;
            r11 = r5;
            r5 = r10;
            r10 = r13;
            r13 = r4;
            r4 = r9;
            r9 = r7;
            r7 = r12;
            r12 = r14;
            r14 = r15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:149:0x0308, code lost:
            r4 = r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:150:0x030a, code lost:
            r4 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:154:0x030f, code lost:
            r4.ain = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:155:0x0313, code lost:
            r14 = r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:159:0x0318, code lost:
            r17 = r16;
            r16 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:160:0x031e, code lost:
            r8 = r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:162:0x032e, code lost:
            r4 = r6;
            r5 = r7;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x008b, code lost:
            if (r9 == null) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x008d, code lost:
            r9.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x01fb, code lost:
            r8 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:99:0x01fc, code lost:
            r8.printStackTrace();
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void ui() throws InterruptedException {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            Runnable runnable;
            boolean z5;
            boolean z6;
            int i;
            boolean z7;
            int i2;
            boolean z8;
            this.aiN = new h(this.aiO);
            this.aiE = false;
            this.aiF = false;
            this.aiK = false;
            GL10 gl10 = null;
            boolean z9 = false;
            int i3 = 0;
            boolean z10 = false;
            int i4 = 0;
            boolean z11 = false;
            boolean z12 = false;
            Runnable runnable2 = null;
            boolean z13 = false;
            boolean z14 = false;
            boolean z15 = false;
            boolean z16 = false;
            while (true) {
                try {
                    synchronized (this.aio) {
                        while (!this.aiy) {
                            if (!this.aiE || this.mEventQueue.isEmpty()) {
                                boolean z17 = false;
                                if (this.mPaused != this.aiA) {
                                    z17 = this.aiA;
                                    this.mPaused = this.aiA;
                                    this.aio.notifyAll();
                                }
                                if (this.aiH) {
                                    ug();
                                    uh();
                                    this.aiH = false;
                                    z14 = true;
                                }
                                if (z10) {
                                    ug();
                                    uh();
                                    z10 = false;
                                }
                                if (z17 && this.aiF) {
                                    ug();
                                }
                                if (!z17 || this.aiE) {
                                }
                                if (!this.aiB && !this.aiD) {
                                    if (this.aiF) {
                                        ug();
                                    }
                                    this.aiD = true;
                                    this.aiC = false;
                                    this.aio.notifyAll();
                                }
                                if (this.aiB && this.aiD) {
                                    this.aiD = false;
                                    this.aio.notifyAll();
                                }
                                if (z9) {
                                    this.aiK = false;
                                    z9 = false;
                                    this.aiL = true;
                                    this.aio.notifyAll();
                                }
                                if (ul()) {
                                    if (!this.aiE) {
                                        if (z14) {
                                            z14 = false;
                                        } else {
                                            try {
                                                this.aiN.start();
                                                this.aiE = true;
                                                z16 = true;
                                                this.aio.notifyAll();
                                            } catch (RuntimeException e) {
                                                this.aio.b(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (this.aiE && !this.aiF) {
                                        this.aiF = true;
                                        z12 = true;
                                        z15 = true;
                                        z11 = true;
                                    }
                                    if (this.aiF) {
                                        if (this.aiM) {
                                            z11 = true;
                                            i3 = this.mWidth;
                                            i4 = this.mHeight;
                                            this.aiK = true;
                                            z12 = true;
                                            this.aiM = false;
                                        }
                                        this.aiJ = false;
                                        this.aio.notifyAll();
                                        if (this.aiK) {
                                            z = z16;
                                            z2 = z15;
                                            z3 = z14;
                                            z4 = true;
                                            runnable = runnable2;
                                            z5 = z12;
                                            z6 = z11;
                                            i = i4;
                                            z7 = z10;
                                            i2 = i3;
                                            z8 = z9;
                                        } else {
                                            z = z16;
                                            z2 = z15;
                                            z3 = z14;
                                            z4 = z13;
                                            runnable = runnable2;
                                            z5 = z12;
                                            z6 = z11;
                                            i = i4;
                                            z7 = z10;
                                            i2 = i3;
                                            z8 = z9;
                                        }
                                    }
                                }
                                this.aio.wait();
                            } else {
                                z = z16;
                                z2 = z15;
                                z3 = z14;
                                z4 = z13;
                                runnable = this.mEventQueue.remove(0);
                                z5 = z12;
                                z6 = z11;
                                i = i4;
                                z7 = z10;
                                i2 = i3;
                                z8 = z9;
                            }
                        }
                    }
                    synchronized (this.aio) {
                        if (this.aiO != null) {
                            this.aiO.aim.smallGameDestroy();
                        }
                        ug();
                        uh();
                    }
                    return;
                } catch (Throwable th) {
                    synchronized (this.aio) {
                        if (this.aiO != null) {
                            this.aiO.aim.smallGameDestroy();
                        }
                        ug();
                        uh();
                        throw th;
                    }
                }
            }
            z9 = z8;
            i3 = i2;
            z10 = z7;
            i4 = i;
            z11 = z6;
            z12 = z5;
            runnable2 = null;
            z13 = z4;
            z14 = z3;
            z15 = z2;
            z16 = z;
        }

        private void uj() {
            float currentTimeMillis;
            this.aiv++;
            if (this.aiw != 0) {
                if (((float) (System.currentTimeMillis() - this.aiw)) / 1000.0f > 1.0f) {
                    short s = (short) (this.aiv / currentTimeMillis);
                    V8Engine v8Engine = getV8Engine();
                    if (v8Engine != null) {
                        Log.d("EngineLogger", "fps: " + ((int) s));
                        v8Engine.nativeInitPreferredFramesPerSecond(s <= 60 ? s : (short) 60);
                    }
                    this.aiv = 0;
                    this.aiw = System.currentTimeMillis();
                    return;
                }
                return;
            }
            this.aiw = System.currentTimeMillis();
        }

        public boolean uk() {
            return this.aiE && this.aiF && ul();
        }

        private boolean ul() {
            return !this.mPaused && this.aiB && !this.aiC && this.mWidth > 0 && this.mHeight > 0 && (this.aiJ || this.aiI == 1);
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (this.aio) {
                this.aiI = i;
                this.aio.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (this.aio) {
                i = this.aiI;
            }
            return i;
        }

        public void requestRender() {
            synchronized (this.aio) {
                this.aiJ = true;
                this.aio.notifyAll();
            }
        }

        public void requestRenderAndWait() {
            synchronized (this.aio) {
                if (Thread.currentThread() != this) {
                    this.aiK = true;
                    this.aiJ = true;
                    this.aiL = false;
                    this.aio.notifyAll();
                    while (!this.aiz && !this.mPaused && !this.aiL && uk()) {
                        try {
                            this.aio.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void surfaceCreated() {
            synchronized (this.aio) {
                this.aiB = true;
                this.aiG = false;
                this.aio.notifyAll();
                while (this.aiD && !this.aiG && !this.aiz) {
                    try {
                        this.aio.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (this.aio) {
                this.aiB = false;
                this.aio.notifyAll();
                while (!this.aiD && !this.aiz) {
                    try {
                        this.aio.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (this.aio) {
                this.aiA = true;
                this.aio.notifyAll();
                while (!this.aiz && !this.mPaused) {
                    try {
                        this.aio.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (this.aio) {
                this.aiA = false;
                this.aiJ = true;
                this.aiL = false;
                this.aio.notifyAll();
                while (!this.aiz && this.mPaused && !this.aiL) {
                    try {
                        this.aio.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void x(int i, int i2) {
            synchronized (this.aio) {
                this.mWidth = i;
                this.mHeight = i2;
                this.aiM = true;
                this.aiJ = true;
                this.aiL = false;
                if (Thread.currentThread() != this) {
                    this.aio.notifyAll();
                    while (!this.aiz && !this.mPaused && !this.aiL && uk()) {
                        try {
                            this.aio.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void um() {
            synchronized (this.aio) {
                this.aiy = true;
                this.aio.notifyAll();
                while (!this.aiz) {
                    try {
                        this.aio.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void queueEvent(Runnable runnable) {
            if (runnable == null) {
                throw new IllegalArgumentException("r must not be null");
            }
            if (!this.aiy && !this.aiz) {
                synchronized (this.aio) {
                    this.mEventQueue.add(runnable);
                    this.aio.notifyAll();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class i {
        private static String TAG = "GLThreadManager";
        private g aiU;

        private i() {
        }

        public synchronized void a(g gVar) {
            gVar.aiz = true;
            if (this.aiU == gVar) {
                this.aiU = null;
            }
            notifyAll();
        }

        public void b(g gVar) {
            if (this.aiU == gVar) {
                this.aiU = null;
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class h {
        private a aiO;
        EGL10 aiP;
        EGLDisplay aiQ;
        EGLSurface aiR;
        EGLConfig aiS;
        EGLContext aiT;

        public h(a aVar) {
            this.aiO = aVar;
        }

        public void reset() {
            this.aiO = null;
        }

        public void start() {
            this.aiP = (EGL10) EGLContext.getEGL();
            this.aiQ = this.aiP.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.aiQ == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.aiP.eglInitialize(this.aiQ, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            a aVar = this.aiO;
            if (aVar != null) {
                this.aiS = aVar.air.chooseConfig(this.aiP, this.aiQ);
                this.aiT = aVar.ais.createContext(this.aiP, this.aiQ, this.aiS);
                aVar.mCurrentGLThreadID = Thread.currentThread().getId();
            } else {
                this.aiS = null;
                this.aiT = null;
            }
            if (this.aiT == null || this.aiT == EGL10.EGL_NO_CONTEXT) {
                this.aiT = null;
                dj("createContext");
            }
            this.aiR = null;
        }

        public boolean un() {
            if (this.aiP == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.aiQ == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.aiS == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            uq();
            a aVar = this.aiO;
            if (aVar != null && aVar.mSurfaceHolder != null) {
                this.aiR = aVar.ait.createWindowSurface(this.aiP, this.aiQ, this.aiS, aVar.mSurfaceHolder);
            } else if (aVar != null && aVar.aip != null) {
                this.aiR = aVar.ait.createWindowSurface(this.aiP, this.aiQ, this.aiS, aVar.aip);
            } else {
                this.aiR = null;
            }
            if (this.aiR == null || this.aiR == EGL10.EGL_NO_SURFACE) {
                if (this.aiP.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    return false;
                }
                return false;
            } else if (!this.aiP.eglMakeCurrent(this.aiQ, this.aiR, this.aiR, this.aiT)) {
                b("EGLHelper", "eglMakeCurrent", this.aiP.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL uo() {
            return this.aiT.getGL();
        }

        public int up() {
            return !this.aiP.eglSwapBuffers(this.aiQ, this.aiR) ? this.aiP.eglGetError() : CommandMessage.COMMAND_BASE;
        }

        public void destroySurface() {
            uq();
        }

        private void uq() {
            if (this.aiR != null && this.aiR != EGL10.EGL_NO_SURFACE) {
                this.aiP.eglMakeCurrent(this.aiQ, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                a aVar = this.aiO;
                if (aVar != null) {
                    aVar.ait.destroySurface(this.aiP, this.aiQ, this.aiR);
                }
                this.aiR = null;
            }
        }

        public void finish() {
            if (this.aiT != null) {
                a aVar = this.aiO;
                if (aVar != null) {
                    aVar.ais.destroyContext(this.aiP, this.aiQ, this.aiT);
                    aVar.mCurrentGLThreadID = -1L;
                }
                this.aiT = null;
            }
            if (this.aiQ != null) {
                this.aiP.eglTerminate(this.aiQ);
                this.aiQ = null;
            }
        }

        private void dj(String str) {
            w(str, this.aiP.eglGetError());
        }

        public static void w(String str, int i) {
            throw new RuntimeException(x(str, i));
        }

        public static void b(String str, String str2, int i) {
            Log.w(str, x(str2, i));
        }

        public static String x(String str, int i) {
            return str + " failed: " + i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.smallgame.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0102a implements d {
        protected int[] aiu;
        protected int mAlphaSize;
        protected int mBlueSize;
        protected int mDepthSize;
        protected int mGreenSize;
        protected int mRedSize;
        protected int mStencilSize;
        private int[] mValue = new int[1];

        public C0102a(int i, int i2, int i3, int i4, int i5, int i6) {
            this.mRedSize = i;
            this.mGreenSize = i2;
            this.mBlueSize = i3;
            this.mAlphaSize = i4;
            this.mDepthSize = i5;
            this.mStencilSize = i6;
            this.aiu = new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12352, 4, 12344};
        }

        @Override // com.baidu.smallgame.sdk.a.d
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.aiu, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.aiu, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (chooseConfig == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return chooseConfig;
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int findConfigAttrib = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int findConfigAttrib2 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (findConfigAttrib >= this.mDepthSize && findConfigAttrib2 >= this.mStencilSize) {
                    int findConfigAttrib3 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int findConfigAttrib4 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int findConfigAttrib5 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int findConfigAttrib6 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (findConfigAttrib3 == this.mRedSize && findConfigAttrib4 == this.mGreenSize && findConfigAttrib5 == this.mBlueSize && findConfigAttrib6 == this.mAlphaSize) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int findConfigAttrib(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.mValue)) {
                return this.mValue[0];
            }
            return i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements e {
        private b() {
        }

        @Override // com.baidu.smallgame.sdk.a.e
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
        }

        @Override // com.baidu.smallgame.sdk.a.e
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c implements f {
        private c() {
        }

        @Override // com.baidu.smallgame.sdk.a.f
        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                Log.e("EngineLogger", "eglCreateWindowSurface", e);
                return null;
            }
        }

        @Override // com.baidu.smallgame.sdk.a.f
        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }
}
