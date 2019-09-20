package com.baidu.smallgame.sdk;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLSurfaceView;
import android.view.SurfaceHolder;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.V8SoLoader;
import com.baidu.smallgame.sdk.ArBridge;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.coloros.mcssdk.mode.CommandMessage;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.TreeSet;
/* loaded from: classes2.dex */
public final class a implements AREngineDelegate {
    private ArBridge ajC;
    private Object ajF;
    private C0114a ajG;
    private boolean mDetached;
    private GLSurfaceView.Renderer mRenderer;
    private SurfaceHolder mSurfaceHolder;
    private long mCurrentGLThreadID = -1;
    private boolean ajD = false;
    private final c ajE = new c();

    static {
        V8SoLoader.load();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        Log.setMinLogLevel(6, false);
        this.ajC = new ArBridge();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public ArBridge getArBridge() {
        return this.ajC;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public Thread getGLThread() {
        return this.ajG;
    }

    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = (SurfaceHolder) new WeakReference(surfaceHolder).get();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderer(GLSurfaceView.Renderer renderer) {
        this.mRenderer = renderer;
        this.ajG = new C0114a(this);
        this.ajG.start();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderMode(int i) {
        if (this.ajG != null) {
            this.ajG.setRenderMode(i);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public int getRenderMode() {
        if (this.ajG != null) {
            return this.ajG.getRenderMode();
        }
        return 1;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRender() {
        if (this.ajG != null) {
            this.ajG.requestRender();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceCreated() {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceCreated.");
        this.ajG.surfaceCreated();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceDestroyed() {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceDestroyed.");
        this.ajG.surfaceDestroyed();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceChanged(int i, int i2) {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceChanged. width=" + i + ", height=" + i2);
        this.ajG.y(i, i2);
        this.ajC.setEglContextToRecorder(getEGLContext(), i, i2);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRenderAndWait() {
        if (this.ajG != null) {
            this.ajG.requestRenderAndWait();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameOnPause() {
        this.ajC.smallGameOnPause();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable) {
        if (this.ajG != null) {
            this.ajG.queueEvent(runnable);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable, long j) {
        if (this.ajG != null) {
            this.ajG.a(runnable, j);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onAttachedToWindow() {
        if (this.mDetached && this.mRenderer != null) {
            int renderMode = this.ajG != null ? this.ajG.getRenderMode() : 1;
            this.ajG = new C0114a(this);
            if (renderMode != 1) {
                this.ajG.setRenderMode(renderMode);
            }
            this.ajG.start();
        }
        this.mDetached = false;
        Log.w("EngineLogger", "[V8Dispose][AREngine] onAttachedToWindow");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onDetachedFromWindow() {
        if (!this.mDetached && this.ajG != null) {
            this.ajG.vC();
        }
        this.mDetached = true;
        Log.w("EngineLogger", "[V8Dispose][AREngine] onDetachedFromWindow");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onPause() {
        if (this.ajG != null) {
            this.ajG.onPause();
        }
        if (this.ajC.getGameRecorder() != null) {
            this.ajC.getGameRecorder().tg();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onResume() {
        if (this.ajG != null) {
            this.ajG.onResume();
        }
        if (this.ajC.getGameRecorder() != null) {
            this.ajC.getGameRecorder().th();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void pauseRecord() {
        if (this.ajC.getGameRecorder() != null) {
            this.ajC.getGameRecorder().pauseRecord();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void resumeRecord() {
        if (this.ajC.getGameRecorder() != null) {
            this.ajC.getGameRecorder().resumeRecord();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void stopRecord() {
        if (this.ajC.getGameRecorder() != null) {
            this.ajC.getGameRecorder().stopRecord();
            this.ajC.nativeUpdateRecordingStatus(false);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (this.ajC.getGameRecorder() != null) {
            this.ajC.nativeUpdateRecordingStatus(true);
            this.ajC.getGameRecorder().startRecord(z, i, str, z2);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setGameRecordCallback(com.baidu.mario.b.b bVar) {
        if (this.ajC.getGameRecorder() != null) {
            this.ajC.getGameRecorder().setGameRecordCallback(bVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public long getCurrentRecordProcess() {
        if (this.ajC.getGameRecorder() != null) {
            return this.ajC.getGameRecorder().tf();
        }
        return 0L;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameDestroy() {
        this.ajC.smallGameDestroy();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void exitGLThread() {
        if (this.ajG != null) {
            this.ajG.vC();
        }
        Log.e("EngineLogger", "[V8Dispose][AREngine] exitGLThread.");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameUpdate() {
        this.ajC.smallGameUpdate();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setFirstFrameListener(ArBridge.FirstFrameListener firstFrameListener) {
        this.ajC.setFirstFrameListener(firstFrameListener);
    }

    public EGLContext getEGLContext() {
        if (this.ajG == null || this.ajG.akc == null) {
            return null;
        }
        return this.ajG.akc.mEglContext;
    }

    protected void finalize() throws Throwable {
        try {
            if (this.ajG != null) {
                this.ajG.vC();
            }
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.smallgame.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0114a extends Thread {
        private c ajE;
        private boolean ajN;
        private boolean ajO;
        private boolean ajP;
        private boolean ajQ;
        private boolean ajR;
        private boolean ajS;
        private boolean ajT;
        private boolean ajU;
        private boolean ajY;
        private b akc;
        private a akd;
        private boolean mPaused;
        private int ajH = 0;
        private long ajI = 0;
        private long ajJ = 0;
        private long ajK = 0;
        private volatile boolean ajL = false;
        private volatile boolean ajM = false;
        private LinkedList<Runnable> ajZ = new LinkedList<>();
        private TreeSet<d> aka = new TreeSet<>();
        private boolean akb = true;
        private V8Engine mV8Engine = null;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean ajW = true;
        private int ajV = 1;
        private boolean ajX = false;

        C0114a(a aVar) {
            this.akd = aVar;
            this.ajE = aVar.ajE;
        }

        /* JADX WARN: Type inference failed for: r4v0, types: [com.baidu.smallgame.sdk.a, com.baidu.searchbox.v8engine.V8Engine, com.baidu.smallgame.sdk.a$b] */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("ARGLThread " + getId());
            try {
                vy();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                this.ajE.b(this);
                this.akc.reset();
                this.akc = null;
                this.akd = null;
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

        private void vw() {
            if (this.ajS) {
                this.ajS = false;
                this.akc.destroySurface();
            }
        }

        private void vx() {
            if (this.ajR) {
                this.akc.finish();
                this.ajR = false;
                this.ajE.c(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [722=4] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX WARN: Code restructure failed: missing block: B:101:0x023e, code lost:
            r11 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:102:0x023f, code lost:
            r11.printStackTrace();
         */
        /* JADX WARN: Code restructure failed: missing block: B:103:0x0244, code lost:
            if (r10 == false) goto L83;
         */
        /* JADX WARN: Code restructure failed: missing block: B:105:0x024e, code lost:
            if (r23.akc.vE() == false) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:106:0x0250, code lost:
            r10 = r23.ajE;
         */
        /* JADX WARN: Code restructure failed: missing block: B:107:0x0254, code lost:
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:109:0x0256, code lost:
            r23.ajT = true;
            r23.ajE.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:110:0x0261, code lost:
            monitor-exit(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:111:0x0262, code lost:
            r11 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:112:0x0264, code lost:
            if (r9 == false) goto L82;
         */
        /* JADX WARN: Code restructure failed: missing block: B:113:0x0266, code lost:
            r10 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:114:0x0268, code lost:
            if (r8 == false) goto L81;
         */
        /* JADX WARN: Code restructure failed: missing block: B:115:0x026a, code lost:
            r8 = r23.akd;
         */
        /* JADX WARN: Code restructure failed: missing block: B:116:0x026e, code lost:
            if (r8 == null) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:117:0x0270, code lost:
            r8.mRenderer.onSurfaceCreated(null, null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:118:0x027c, code lost:
            r9 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:119:0x027e, code lost:
            if (r7 == false) goto L80;
         */
        /* JADX WARN: Code restructure failed: missing block: B:120:0x0280, code lost:
            r7 = r23.akd;
         */
        /* JADX WARN: Code restructure failed: missing block: B:121:0x0284, code lost:
            if (r7 == null) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:122:0x0286, code lost:
            r7.mRenderer.onSurfaceChanged(null, r14, r13);
         */
        /* JADX WARN: Code restructure failed: missing block: B:123:0x028e, code lost:
            com.baidu.searchbox.v8engine.V8Engine.updateSurfaceViewSize(r14, r13);
            r8 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:124:0x0293, code lost:
            r7 = r23.akd;
            r16 = java.lang.System.currentTimeMillis();
            r18 = r16 - r23.ajJ;
         */
        /* JADX WARN: Code restructure failed: missing block: B:125:0x02a7, code lost:
            if (r7.ajD == false) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:127:0x02b4, code lost:
            if (((float) r18) < minFramesInterval()) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:128:0x02b6, code lost:
            r23.ajJ = java.lang.System.currentTimeMillis();
            r7.mRenderer.onDrawFrame(null);
            vz();
         */
        /* JADX WARN: Code restructure failed: missing block: B:129:0x02d8, code lost:
            if ((r16 - r23.ajK) <= 33) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:130:0x02da, code lost:
            r7.ajC.notifyFrameUpdated();
            r23.ajK = r16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:132:0x02ef, code lost:
            if (r7.ajC.shouldSwapBuffer() == false) goto L78;
         */
        /* JADX WARN: Code restructure failed: missing block: B:133:0x02f1, code lost:
            r7 = r23.akc.vF();
         */
        /* JADX WARN: Code restructure failed: missing block: B:134:0x02f9, code lost:
            switch(r7) {
                case 12288: goto L71;
                case 12302: goto L77;
                default: goto L66;
            };
         */
        /* JADX WARN: Code restructure failed: missing block: B:135:0x02fc, code lost:
            com.baidu.smallgame.sdk.a.b.b("EngineLogger", "eglSwapBuffers", r7);
            r7 = r23.ajE;
         */
        /* JADX WARN: Code restructure failed: missing block: B:136:0x030d, code lost:
            monitor-enter(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:138:0x0310, code lost:
            r23.ajP = true;
            r23.ajE.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:139:0x031f, code lost:
            monitor-exit(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:140:0x0320, code lost:
            r7 = r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:141:0x0321, code lost:
            if (r6 == false) goto L76;
         */
        /* JADX WARN: Code restructure failed: missing block: B:142:0x0323, code lost:
            r4 = true;
            r5 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:143:0x0325, code lost:
            r6 = r14;
            r14 = r9;
            r9 = r5;
            r5 = r13;
            r13 = r11;
            r11 = r7;
            r7 = r15;
            r22 = r12;
            r12 = r10;
            r10 = r8;
            r8 = r4;
            r4 = r22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:147:0x0338, code lost:
            r11 = r23.ajE;
         */
        /* JADX WARN: Code restructure failed: missing block: B:148:0x033c, code lost:
            monitor-enter(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:150:0x033f, code lost:
            r23.ajT = true;
            r23.ajP = true;
            r23.ajE.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:151:0x0356, code lost:
            monitor-exit(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:152:0x0357, code lost:
            r11 = r4;
            r4 = r12;
            r12 = r9;
            r9 = r6;
            r6 = r14;
            r14 = r8;
            r8 = r5;
            r5 = r13;
            r13 = r10;
            r10 = r7;
            r7 = r15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:156:0x0367, code lost:
            r4 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:160:0x036c, code lost:
            r7.ajD = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:161:0x0373, code lost:
            r7 = r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:165:0x0378, code lost:
            r4 = r5;
            r5 = r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:166:0x037b, code lost:
            r8 = r7;
         */
        /* JADX WARN: Code restructure failed: missing block: B:167:0x037e, code lost:
            r9 = r8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:168:0x0381, code lost:
            r10 = r9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:169:0x0384, code lost:
            r11 = r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0076, code lost:
            if (r12 == null) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0078, code lost:
            r12.run();
         */
        /* JADX WARN: Removed duplicated region for block: B:190:0x019d A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:98:0x0233  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void vy() throws InterruptedException {
            boolean z;
            boolean z2;
            boolean z3;
            int i;
            int i2;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            boolean z8;
            boolean z9;
            boolean z10;
            this.akc = new b(this.akd);
            this.ajR = false;
            this.ajS = false;
            this.ajX = false;
            boolean z11 = false;
            boolean z12 = false;
            boolean z13 = false;
            boolean z14 = false;
            boolean z15 = false;
            boolean z16 = false;
            boolean z17 = false;
            boolean z18 = false;
            int i3 = 0;
            int i4 = 0;
            Runnable runnable = null;
            while (true) {
                try {
                    synchronized (this.ajE) {
                        z = z18;
                        z2 = z15;
                        boolean z19 = z13;
                        Runnable runnable2 = runnable;
                        boolean z20 = z17;
                        boolean z21 = z14;
                        boolean z22 = z12;
                        boolean z23 = z11;
                        while (!this.ajL) {
                            if (!vA() || (runnable2 = vD()) == null) {
                                boolean z24 = false;
                                if (this.mPaused != this.ajN) {
                                    z24 = this.ajN;
                                    this.mPaused = this.ajN;
                                    this.ajE.notifyAll();
                                    Log.i("EngineLogger", "mPaused is now " + this.mPaused + " tid=" + getId());
                                }
                                if (this.ajU) {
                                    vw();
                                    vx();
                                    this.ajU = false;
                                    z = true;
                                }
                                if (z21) {
                                    vw();
                                    vx();
                                    z21 = false;
                                }
                                if (z24 && this.ajS) {
                                    vw();
                                }
                                if (!z24 || this.ajR) {
                                }
                                if (!this.ajO && !this.ajQ) {
                                    if (this.ajS) {
                                        vw();
                                    }
                                    this.ajQ = true;
                                    this.ajP = false;
                                    this.ajE.notifyAll();
                                }
                                if (this.ajO && this.ajQ) {
                                    this.ajQ = false;
                                    this.ajE.notifyAll();
                                }
                                if (z20) {
                                    this.ajX = false;
                                    z20 = false;
                                    this.ajY = true;
                                    this.ajE.notifyAll();
                                }
                                if (vB()) {
                                    if (!this.ajR) {
                                        if (z) {
                                            z = false;
                                            z3 = z23;
                                            if (this.ajR && !this.ajS) {
                                                this.ajS = true;
                                                z22 = true;
                                                z19 = true;
                                                z2 = true;
                                            }
                                            if (this.ajS) {
                                                z23 = z3;
                                            } else {
                                                if (this.akb) {
                                                    z2 = true;
                                                    i2 = this.mWidth;
                                                    i = this.mHeight;
                                                    this.ajX = true;
                                                    z4 = true;
                                                    this.akb = false;
                                                } else {
                                                    i = i4;
                                                    i2 = i3;
                                                    z4 = z22;
                                                }
                                                this.ajW = false;
                                                this.ajE.notifyAll();
                                                if (this.ajX) {
                                                    z5 = true;
                                                    z6 = z19;
                                                    z7 = z4;
                                                    z8 = z20;
                                                    z9 = z21;
                                                    z10 = z3;
                                                } else {
                                                    z5 = z16;
                                                    z6 = z19;
                                                    z7 = z4;
                                                    z8 = z20;
                                                    z9 = z21;
                                                    z10 = z3;
                                                }
                                            }
                                        } else {
                                            try {
                                                this.akc.start();
                                                this.akd.ajC.setEglContextToRecorder(this.akd.getEGLContext(), 0, 0);
                                                this.ajR = true;
                                                z23 = true;
                                                this.ajE.notifyAll();
                                            } catch (RuntimeException e) {
                                                this.ajE.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    z3 = z23;
                                    if (this.ajR) {
                                        this.ajS = true;
                                        z22 = true;
                                        z19 = true;
                                        z2 = true;
                                    }
                                    if (this.ajS) {
                                    }
                                }
                                this.ajE.wait();
                            } else {
                                i2 = i3;
                                z5 = z16;
                                z6 = z19;
                                z7 = z22;
                                boolean z25 = z21;
                                z10 = z23;
                                i = i4;
                                z8 = z20;
                                z9 = z25;
                            }
                        }
                    }
                    synchronized (this.ajE) {
                        if (this.akd != null) {
                            this.akd.ajC.smallGameDestroy();
                        }
                        vw();
                        vx();
                    }
                    return;
                } catch (Throwable th) {
                    synchronized (this.ajE) {
                        if (this.akd != null) {
                            this.akd.ajC.smallGameDestroy();
                        }
                        vw();
                        vx();
                        throw th;
                    }
                }
            }
            z13 = z6;
            z16 = z5;
            i3 = i2;
            z11 = z10;
            z17 = z8;
            i4 = i;
            z12 = z7;
            z15 = z2;
            z18 = z;
            boolean z26 = z9;
            runnable = null;
            z14 = z26;
        }

        private void vz() {
            float currentTimeMillis;
            this.ajH++;
            if (this.ajI != 0) {
                if (((float) (System.currentTimeMillis() - this.ajI)) / 1000.0f > 1.0f) {
                    short s = (short) (this.ajH / currentTimeMillis);
                    V8Engine v8Engine = getV8Engine();
                    if (v8Engine != null) {
                        Log.d("EngineLogger", "fps: " + ((int) s));
                        v8Engine.nativeInitPreferredFramesPerSecond(s <= 60 ? s : (short) 60);
                    }
                    this.ajH = 0;
                    this.ajI = System.currentTimeMillis();
                    return;
                }
                return;
            }
            this.ajI = System.currentTimeMillis();
        }

        public boolean vA() {
            return this.ajR && this.ajS && vB();
        }

        private boolean vB() {
            return !this.mPaused && this.ajO && !this.ajP && this.mWidth > 0 && this.mHeight > 0 && (this.ajW || this.ajV == 1);
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (this.ajE) {
                this.ajV = i;
                this.ajE.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (this.ajE) {
                i = this.ajV;
            }
            return i;
        }

        public void requestRender() {
            synchronized (this.ajE) {
                this.ajW = true;
                this.ajE.notifyAll();
            }
        }

        public void requestRenderAndWait() {
            synchronized (this.ajE) {
                if (Thread.currentThread() != this) {
                    this.ajX = true;
                    this.ajW = true;
                    this.ajY = false;
                    this.ajE.notifyAll();
                    while (!this.ajM && !this.mPaused && !this.ajY && vA()) {
                        try {
                            this.ajE.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void surfaceCreated() {
            synchronized (this.ajE) {
                this.ajO = true;
                this.ajT = false;
                this.ajE.notifyAll();
                while (this.ajQ && !this.ajT && !this.ajM) {
                    try {
                        this.ajE.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (this.ajE) {
                this.ajO = false;
                this.ajE.notifyAll();
                while (!this.ajQ && !this.ajM) {
                    try {
                        this.ajE.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (this.ajE) {
                Log.i("EngineLogger", "onPause tid=" + getId());
                this.ajN = true;
                this.ajE.notifyAll();
                while (!this.ajM && !this.mPaused) {
                    Log.i("Main thread", "onPause waiting for mPaused.");
                    try {
                        this.ajE.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (this.ajE) {
                Log.i("EngineLogger", "onResume tid=" + getId());
                this.ajN = false;
                this.ajW = true;
                this.ajY = false;
                this.ajE.notifyAll();
                while (!this.ajM && this.mPaused && !this.ajY) {
                    Log.i("Main thread", "onResume waiting for !mPaused.");
                    try {
                        this.ajE.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void y(int i, int i2) {
            synchronized (this.ajE) {
                this.mWidth = i;
                this.mHeight = i2;
                this.akb = true;
                this.ajW = true;
                this.ajY = false;
                if (Thread.currentThread() != this) {
                    this.ajE.notifyAll();
                    while (!this.ajM && !this.mPaused && !this.ajY && vA()) {
                        try {
                            this.ajE.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void vC() {
            synchronized (this.ajE) {
                this.ajL = true;
                this.ajE.notifyAll();
                while (!this.ajM) {
                    try {
                        this.ajE.wait();
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
            if (!this.ajL && !this.ajM) {
                synchronized (this.ajE) {
                    this.ajZ.add(runnable);
                    this.ajE.notifyAll();
                }
            }
        }

        public void a(Runnable runnable, long j) {
            if (runnable == null) {
                throw new IllegalArgumentException("r must not be null");
            }
            if (!this.ajL && !this.ajM) {
                synchronized (this.ajE) {
                    TreeSet<d> treeSet = this.aka;
                    if (j <= 0) {
                        j = 0;
                    }
                    treeSet.add(new d(runnable, j));
                    this.ajE.notifyAll();
                }
            }
        }

        private Runnable vD() {
            Runnable pollFirst;
            synchronized (this.ajE) {
                pollFirst = (this.aka.isEmpty() || !this.aka.first().isTimeout()) ? this.ajZ.pollFirst() : this.aka.pollFirst();
            }
            return pollFirst;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class d implements Comparable<d>, Runnable {
        private final Runnable aki;
        private final long mTimestamp;

        d(Runnable runnable, long j) {
            this.aki = runnable;
            this.mTimestamp = System.currentTimeMillis() + j;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.aki.run();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(d dVar) {
            return (int) (this.mTimestamp - dVar.mTimestamp);
        }

        public boolean isTimeout() {
            return System.currentTimeMillis() >= this.mTimestamp;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c {
        private static String TAG = "GLThreadManager";
        private C0114a akh;

        private c() {
        }

        public synchronized void b(C0114a c0114a) {
            c0114a.ajM = true;
            if (this.akh == c0114a) {
                this.akh = null;
            }
            notifyAll();
        }

        public void c(C0114a c0114a) {
            if (this.akh == c0114a) {
                this.akh = null;
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {
        private a akd;
        EGLDisplay ake;
        EGLSurface akf;
        EGLConfig akg;
        EGLContext mEglContext;

        public b(a aVar) {
            this.akd = aVar;
        }

        public void reset() {
            this.akd = null;
        }

        public void start() {
            this.ake = EGL14.eglGetDisplay(0);
            if (this.ake == EGL14.EGL_NO_DISPLAY) {
                throw new RuntimeException("unable to get EGL14 display");
            }
            int[] iArr = new int[2];
            if (!EGL14.eglInitialize(this.ake, iArr, 0, iArr, 1)) {
                this.ake = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            a aVar = this.akd;
            this.akg = e(0, 0, false);
            this.mEglContext = EGL14.eglCreateContext(this.ake, this.akg, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
            this.akd.mCurrentGLThreadID = Thread.currentThread().getId();
            if (this.mEglContext == null || this.mEglContext == EGL14.EGL_NO_CONTEXT) {
                this.mEglContext = null;
                dc("createContext");
            }
            this.akf = null;
        }

        private EGLConfig e(int i, int i2, boolean z) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (EGL14.eglChooseConfig(this.ake, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, z ? 16 : 0, 12326, 0, 12352, 4, 12344, 0, 12344}, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
                return eGLConfigArr[0];
            }
            Log.w("EngineLogger", "unable to find RGB8888 / " + i2 + " EGLConfig");
            return null;
        }

        public boolean vE() {
            if (this.ake == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.akg == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            destroySurface();
            Object obj = this.akd.mSurfaceHolder;
            if (obj == null) {
                obj = this.akd.ajF;
            }
            if (obj != null) {
                this.akf = EGL14.eglCreateWindowSurface(this.ake, this.akg, obj, new int[]{12344}, 0);
            } else {
                this.akf = null;
            }
            if (this.akf == null || this.akf == EGL14.EGL_NO_SURFACE) {
                if (EGL14.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    return false;
                }
                return false;
            }
            return EGL14.eglMakeCurrent(this.ake, this.akf, this.akf, this.mEglContext);
        }

        public int vF() {
            return !EGL14.eglSwapBuffers(this.ake, this.akf) ? EGL14.eglGetError() : CommandMessage.COMMAND_BASE;
        }

        public void destroySurface() {
            if (this.akf != null && this.akf != EGL14.EGL_NO_SURFACE) {
                EGL14.eglMakeCurrent(this.ake, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
                EGL14.eglDestroySurface(this.ake, this.akf);
                this.akf = null;
            }
        }

        public void finish() {
            if (this.mEglContext != null) {
                EGL14.eglDestroyContext(this.ake, this.mEglContext);
                this.mEglContext = null;
            }
            if (this.ake != null) {
                EGL14.eglTerminate(this.ake);
                this.ake = null;
            }
            this.akd.mCurrentGLThreadID = -1L;
        }

        private void dc(String str) {
            q(str, EGL14.eglGetError());
        }

        public static void q(String str, int i) {
            throw new RuntimeException(r(str, i));
        }

        public static void b(String str, String str2, int i) {
            Log.w(str, r(str2, i));
        }

        public static String r(String str, int i) {
            return str + " failed: " + i;
        }
    }
}
