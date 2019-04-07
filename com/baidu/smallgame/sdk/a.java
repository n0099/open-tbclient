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
    private ArBridge ail;
    private Object aio;
    private g aip;
    private d aiq;
    private e air;
    private f ais;
    private boolean mDetached;
    private GLSurfaceView.Renderer mRenderer;
    private SurfaceHolder mSurfaceHolder;
    private long mCurrentGLThreadID = -1;
    private boolean aim = false;
    private final i ain = new i();

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
        this.ail = new ArBridge();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public ArBridge getArBridge() {
        return this.ail;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public Thread getGLThread() {
        return this.aip;
    }

    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = (SurfaceHolder) new WeakReference(surfaceHolder).get();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderer(GLSurfaceView.Renderer renderer) {
        if (this.aiq == null) {
            this.aiq = new C0102a(8, 8, 8, 8, 16, 8);
        }
        if (this.air == null) {
            this.air = new b();
        }
        if (this.ais == null) {
            this.ais = new c();
        }
        this.mRenderer = renderer;
        this.aip = new g(this);
        this.aip.start();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderMode(int i2) {
        if (this.aip != null) {
            this.aip.setRenderMode(i2);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public int getRenderMode() {
        if (this.aip != null) {
            return this.aip.getRenderMode();
        }
        return 1;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRender() {
        if (this.aip != null) {
            this.aip.requestRender();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceCreated() {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceCreated.");
        this.aip.surfaceCreated();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceDestroyed() {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceDestroyed.");
        this.aip.surfaceDestroyed();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceChanged(int i2, int i3) {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceChanged. width=" + i2 + ", height=" + i3);
        this.aip.x(i2, i3);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRenderAndWait() {
        if (this.aip != null) {
            this.aip.requestRenderAndWait();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameOnPause() {
        this.ail.smallGameOnPause();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable) {
        if (this.aip != null) {
            this.aip.queueEvent(runnable);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onAttachedToWindow() {
        if (this.mDetached && this.mRenderer != null) {
            int renderMode = this.aip != null ? this.aip.getRenderMode() : 1;
            this.aip = new g(this);
            if (renderMode != 1) {
                this.aip.setRenderMode(renderMode);
            }
            this.aip.start();
        }
        this.mDetached = false;
        Log.w("EngineLogger", "[V8Dispose][AREngine] onAttachedToWindow");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onDetachedFromWindow() {
        if (!this.mDetached && this.aip != null) {
            this.aip.um();
        }
        this.mDetached = true;
        Log.w("EngineLogger", "[V8Dispose][AREngine] onDetachedFromWindow");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onPause() {
        if (this.aip != null) {
            this.aip.onPause();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onResume() {
        if (this.aip != null) {
            this.aip.onResume();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameDestroy() {
        this.ail.smallGameDestroy();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void exitGLThread() {
        if (this.aip != null) {
            this.aip.um();
        }
        Log.e("EngineLogger", "[V8Dispose][AREngine] exitGLThread.");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameUpdate() {
        this.ail.smallGameUpdate();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setFirstFrameListener(ArBridge.FirstFrameListener firstFrameListener) {
        this.ail.setFirstFrameListener(firstFrameListener);
    }

    protected void finalize() throws Throwable {
        try {
            if (this.aip != null) {
                this.aip.um();
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
        private boolean aiK;
        private h aiM;
        private a aiN;
        private i ain;
        private boolean aiz;
        private boolean mPaused;
        private int aiu = 0;
        private long aiv = 0;
        private long aiw = 0;
        private volatile boolean aix = false;
        private volatile boolean aiy = false;
        private ArrayList<Runnable> mEventQueue = new ArrayList<>();
        private boolean aiL = true;
        private V8Engine mV8Engine = null;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean aiI = true;
        private int aiH = 1;
        private boolean aiJ = false;

        g(a aVar) {
            this.aiN = aVar;
            this.ain = aVar.ain;
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
                this.ain.a(this);
                this.aiM.reset();
                this.aiM = null;
                this.aiN = null;
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
            if (this.aiE) {
                this.aiE = false;
                this.aiM.destroySurface();
            }
        }

        private void uh() {
            if (this.aiD) {
                this.aiM.finish();
                this.aiD = false;
                this.ain.b(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [658=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX WARN: Code restructure failed: missing block: B:100:0x0201, code lost:
            if (r4 == false) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:102:0x020b, code lost:
            if (r23.aiM.un() == false) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:103:0x020d, code lost:
            r8 = r23.ain;
         */
        /* JADX WARN: Code restructure failed: missing block: B:104:0x0211, code lost:
            monitor-enter(r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:106:0x0213, code lost:
            r23.aiF = true;
            r23.ain.notifyAll();
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
            r17 = (javax.microedition.khronos.opengles.GL10) r23.aiM.uo();
         */
        /* JADX WARN: Code restructure failed: missing block: B:111:0x0231, code lost:
            if (r15 == false) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:112:0x0233, code lost:
            r4 = r23.aiN;
         */
        /* JADX WARN: Code restructure failed: missing block: B:113:0x0237, code lost:
            if (r4 == null) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:114:0x0239, code lost:
            r4.mRenderer.onSurfaceCreated(r17, r23.aiM.aiR);
         */
        /* JADX WARN: Code restructure failed: missing block: B:115:0x0248, code lost:
            r15 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:116:0x0249, code lost:
            if (r13 == false) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:117:0x024b, code lost:
            r4 = r23.aiN;
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
            r4 = r23.aiN;
            r18 = java.lang.System.currentTimeMillis() - r23.aiw;
         */
        /* JADX WARN: Code restructure failed: missing block: B:122:0x0272, code lost:
            if (r4.aim == false) goto L74;
         */
        /* JADX WARN: Code restructure failed: missing block: B:124:0x027d, code lost:
            if (((float) r18) < minFramesInterval()) goto L74;
         */
        /* JADX WARN: Code restructure failed: missing block: B:125:0x027f, code lost:
            r23.aiw = java.lang.System.currentTimeMillis();
            r4.mRenderer.onDrawFrame(r17);
            uj();
            r4 = r23.aiM.up();
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
            r14 = r23.ain;
         */
        /* JADX WARN: Code restructure failed: missing block: B:128:0x02af, code lost:
            monitor-enter(r14);
         */
        /* JADX WARN: Code restructure failed: missing block: B:130:0x02b1, code lost:
            r23.aiB = true;
            r23.ain.notifyAll();
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
            r8 = r23.ain;
         */
        /* JADX WARN: Code restructure failed: missing block: B:141:0x02dd, code lost:
            monitor-enter(r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:143:0x02e0, code lost:
            r23.aiF = true;
            r23.aiB = true;
            r23.ain.notifyAll();
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
            r4.aim = true;
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
            this.aiM = new h(this.aiN);
            this.aiD = false;
            this.aiE = false;
            this.aiJ = false;
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
                    synchronized (this.ain) {
                        while (!this.aix) {
                            if (!this.aiD || this.mEventQueue.isEmpty()) {
                                boolean z17 = false;
                                if (this.mPaused != this.aiz) {
                                    z17 = this.aiz;
                                    this.mPaused = this.aiz;
                                    this.ain.notifyAll();
                                }
                                if (this.aiG) {
                                    ug();
                                    uh();
                                    this.aiG = false;
                                    z14 = true;
                                }
                                if (z10) {
                                    ug();
                                    uh();
                                    z10 = false;
                                }
                                if (z17 && this.aiE) {
                                    ug();
                                }
                                if (!z17 || this.aiD) {
                                }
                                if (!this.aiA && !this.aiC) {
                                    if (this.aiE) {
                                        ug();
                                    }
                                    this.aiC = true;
                                    this.aiB = false;
                                    this.ain.notifyAll();
                                }
                                if (this.aiA && this.aiC) {
                                    this.aiC = false;
                                    this.ain.notifyAll();
                                }
                                if (z9) {
                                    this.aiJ = false;
                                    z9 = false;
                                    this.aiK = true;
                                    this.ain.notifyAll();
                                }
                                if (ul()) {
                                    if (!this.aiD) {
                                        if (z14) {
                                            z14 = false;
                                        } else {
                                            try {
                                                this.aiM.start();
                                                this.aiD = true;
                                                z16 = true;
                                                this.ain.notifyAll();
                                            } catch (RuntimeException e) {
                                                this.ain.b(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (this.aiD && !this.aiE) {
                                        this.aiE = true;
                                        z12 = true;
                                        z15 = true;
                                        z11 = true;
                                    }
                                    if (this.aiE) {
                                        if (this.aiL) {
                                            z11 = true;
                                            i3 = this.mWidth;
                                            i4 = this.mHeight;
                                            this.aiJ = true;
                                            z12 = true;
                                            this.aiL = false;
                                        }
                                        this.aiI = false;
                                        this.ain.notifyAll();
                                        if (this.aiJ) {
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
                                this.ain.wait();
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
                    synchronized (this.ain) {
                        if (this.aiN != null) {
                            this.aiN.ail.smallGameDestroy();
                        }
                        ug();
                        uh();
                    }
                    return;
                } catch (Throwable th) {
                    synchronized (this.ain) {
                        if (this.aiN != null) {
                            this.aiN.ail.smallGameDestroy();
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
            this.aiu++;
            if (this.aiv != 0) {
                if (((float) (System.currentTimeMillis() - this.aiv)) / 1000.0f > 1.0f) {
                    short s = (short) (this.aiu / currentTimeMillis);
                    V8Engine v8Engine = getV8Engine();
                    if (v8Engine != null) {
                        Log.d("EngineLogger", "fps: " + ((int) s));
                        v8Engine.nativeInitPreferredFramesPerSecond(s <= 60 ? s : (short) 60);
                    }
                    this.aiu = 0;
                    this.aiv = System.currentTimeMillis();
                    return;
                }
                return;
            }
            this.aiv = System.currentTimeMillis();
        }

        public boolean uk() {
            return this.aiD && this.aiE && ul();
        }

        private boolean ul() {
            return !this.mPaused && this.aiA && !this.aiB && this.mWidth > 0 && this.mHeight > 0 && (this.aiI || this.aiH == 1);
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (this.ain) {
                this.aiH = i;
                this.ain.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (this.ain) {
                i = this.aiH;
            }
            return i;
        }

        public void requestRender() {
            synchronized (this.ain) {
                this.aiI = true;
                this.ain.notifyAll();
            }
        }

        public void requestRenderAndWait() {
            synchronized (this.ain) {
                if (Thread.currentThread() != this) {
                    this.aiJ = true;
                    this.aiI = true;
                    this.aiK = false;
                    this.ain.notifyAll();
                    while (!this.aiy && !this.mPaused && !this.aiK && uk()) {
                        try {
                            this.ain.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void surfaceCreated() {
            synchronized (this.ain) {
                this.aiA = true;
                this.aiF = false;
                this.ain.notifyAll();
                while (this.aiC && !this.aiF && !this.aiy) {
                    try {
                        this.ain.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (this.ain) {
                this.aiA = false;
                this.ain.notifyAll();
                while (!this.aiC && !this.aiy) {
                    try {
                        this.ain.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (this.ain) {
                this.aiz = true;
                this.ain.notifyAll();
                while (!this.aiy && !this.mPaused) {
                    try {
                        this.ain.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (this.ain) {
                this.aiz = false;
                this.aiI = true;
                this.aiK = false;
                this.ain.notifyAll();
                while (!this.aiy && this.mPaused && !this.aiK) {
                    try {
                        this.ain.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void x(int i, int i2) {
            synchronized (this.ain) {
                this.mWidth = i;
                this.mHeight = i2;
                this.aiL = true;
                this.aiI = true;
                this.aiK = false;
                if (Thread.currentThread() != this) {
                    this.ain.notifyAll();
                    while (!this.aiy && !this.mPaused && !this.aiK && uk()) {
                        try {
                            this.ain.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void um() {
            synchronized (this.ain) {
                this.aix = true;
                this.ain.notifyAll();
                while (!this.aiy) {
                    try {
                        this.ain.wait();
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
            if (!this.aix && !this.aiy) {
                synchronized (this.ain) {
                    this.mEventQueue.add(runnable);
                    this.ain.notifyAll();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class i {
        private static String TAG = "GLThreadManager";
        private g aiT;

        private i() {
        }

        public synchronized void a(g gVar) {
            gVar.aiy = true;
            if (this.aiT == gVar) {
                this.aiT = null;
            }
            notifyAll();
        }

        public void b(g gVar) {
            if (this.aiT == gVar) {
                this.aiT = null;
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class h {
        private a aiN;
        EGL10 aiO;
        EGLDisplay aiP;
        EGLSurface aiQ;
        EGLConfig aiR;
        EGLContext aiS;

        public h(a aVar) {
            this.aiN = aVar;
        }

        public void reset() {
            this.aiN = null;
        }

        public void start() {
            this.aiO = (EGL10) EGLContext.getEGL();
            this.aiP = this.aiO.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.aiP == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.aiO.eglInitialize(this.aiP, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            a aVar = this.aiN;
            if (aVar != null) {
                this.aiR = aVar.aiq.chooseConfig(this.aiO, this.aiP);
                this.aiS = aVar.air.createContext(this.aiO, this.aiP, this.aiR);
                aVar.mCurrentGLThreadID = Thread.currentThread().getId();
            } else {
                this.aiR = null;
                this.aiS = null;
            }
            if (this.aiS == null || this.aiS == EGL10.EGL_NO_CONTEXT) {
                this.aiS = null;
                dj("createContext");
            }
            this.aiQ = null;
        }

        public boolean un() {
            if (this.aiO == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.aiP == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.aiR == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            uq();
            a aVar = this.aiN;
            if (aVar != null && aVar.mSurfaceHolder != null) {
                this.aiQ = aVar.ais.createWindowSurface(this.aiO, this.aiP, this.aiR, aVar.mSurfaceHolder);
            } else if (aVar != null && aVar.aio != null) {
                this.aiQ = aVar.ais.createWindowSurface(this.aiO, this.aiP, this.aiR, aVar.aio);
            } else {
                this.aiQ = null;
            }
            if (this.aiQ == null || this.aiQ == EGL10.EGL_NO_SURFACE) {
                if (this.aiO.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    return false;
                }
                return false;
            } else if (!this.aiO.eglMakeCurrent(this.aiP, this.aiQ, this.aiQ, this.aiS)) {
                b("EGLHelper", "eglMakeCurrent", this.aiO.eglGetError());
                return false;
            } else {
                return true;
            }
        }

        GL uo() {
            return this.aiS.getGL();
        }

        public int up() {
            return !this.aiO.eglSwapBuffers(this.aiP, this.aiQ) ? this.aiO.eglGetError() : CommandMessage.COMMAND_BASE;
        }

        public void destroySurface() {
            uq();
        }

        private void uq() {
            if (this.aiQ != null && this.aiQ != EGL10.EGL_NO_SURFACE) {
                this.aiO.eglMakeCurrent(this.aiP, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                a aVar = this.aiN;
                if (aVar != null) {
                    aVar.ais.destroySurface(this.aiO, this.aiP, this.aiQ);
                }
                this.aiQ = null;
            }
        }

        public void finish() {
            if (this.aiS != null) {
                a aVar = this.aiN;
                if (aVar != null) {
                    aVar.air.destroyContext(this.aiO, this.aiP, this.aiS);
                    aVar.mCurrentGLThreadID = -1L;
                }
                this.aiS = null;
            }
            if (this.aiP != null) {
                this.aiO.eglTerminate(this.aiP);
                this.aiP = null;
            }
        }

        private void dj(String str) {
            w(str, this.aiO.eglGetError());
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
        protected int[] ait;
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
            this.ait = new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12352, 4, 12344};
        }

        @Override // com.baidu.smallgame.sdk.a.d
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.ait, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.ait, eGLConfigArr, i, iArr)) {
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
