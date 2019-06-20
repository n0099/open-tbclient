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
    private ArBridge aiD;
    private Object aiG;
    private C0103a aiH;
    private boolean mDetached;
    private GLSurfaceView.Renderer mRenderer;
    private SurfaceHolder mSurfaceHolder;
    private long mCurrentGLThreadID = -1;
    private boolean aiE = false;
    private final c aiF = new c();

    static {
        V8SoLoader.load();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        Log.setMinLogLevel(6, false);
        this.aiD = new ArBridge();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public ArBridge getArBridge() {
        return this.aiD;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public Thread getGLThread() {
        return this.aiH;
    }

    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = (SurfaceHolder) new WeakReference(surfaceHolder).get();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderer(GLSurfaceView.Renderer renderer) {
        this.mRenderer = renderer;
        this.aiH = new C0103a(this);
        this.aiH.start();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderMode(int i) {
        if (this.aiH != null) {
            this.aiH.setRenderMode(i);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public int getRenderMode() {
        if (this.aiH != null) {
            return this.aiH.getRenderMode();
        }
        return 1;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRender() {
        if (this.aiH != null) {
            this.aiH.requestRender();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceCreated() {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceCreated.");
        this.aiH.surfaceCreated();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceDestroyed() {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceDestroyed.");
        this.aiH.surfaceDestroyed();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceChanged(int i, int i2) {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceChanged. width=" + i + ", height=" + i2);
        this.aiH.v(i, i2);
        this.aiD.setEglContextToRecorder(getEGLContext(), i, i2);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRenderAndWait() {
        if (this.aiH != null) {
            this.aiH.requestRenderAndWait();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameOnPause() {
        this.aiD.smallGameOnPause();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable) {
        if (this.aiH != null) {
            this.aiH.queueEvent(runnable);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable, long j) {
        if (this.aiH != null) {
            this.aiH.a(runnable, j);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onAttachedToWindow() {
        if (this.mDetached && this.mRenderer != null) {
            int renderMode = this.aiH != null ? this.aiH.getRenderMode() : 1;
            this.aiH = new C0103a(this);
            if (renderMode != 1) {
                this.aiH.setRenderMode(renderMode);
            }
            this.aiH.start();
        }
        this.mDetached = false;
        Log.w("EngineLogger", "[V8Dispose][AREngine] onAttachedToWindow");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onDetachedFromWindow() {
        if (!this.mDetached && this.aiH != null) {
            this.aiH.uX();
        }
        this.mDetached = true;
        Log.w("EngineLogger", "[V8Dispose][AREngine] onDetachedFromWindow");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onPause() {
        if (this.aiH != null) {
            this.aiH.onPause();
        }
        if (this.aiD.getGameRecorder() != null) {
            this.aiD.getGameRecorder().sI();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onResume() {
        if (this.aiH != null) {
            this.aiH.onResume();
        }
        if (this.aiD.getGameRecorder() != null) {
            this.aiD.getGameRecorder().sJ();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void pauseRecord() {
        if (this.aiD.getGameRecorder() != null) {
            this.aiD.getGameRecorder().pauseRecord();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void resumeRecord() {
        if (this.aiD.getGameRecorder() != null) {
            this.aiD.getGameRecorder().resumeRecord();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void stopRecord() {
        if (this.aiD.getGameRecorder() != null) {
            this.aiD.getGameRecorder().stopRecord();
            this.aiD.nativeUpdateRecordingStatus(false);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (this.aiD.getGameRecorder() != null) {
            this.aiD.nativeUpdateRecordingStatus(true);
            this.aiD.getGameRecorder().startRecord(z, i, str, z2);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setGameRecordCallback(com.baidu.mario.b.b bVar) {
        if (this.aiD.getGameRecorder() != null) {
            this.aiD.getGameRecorder().setGameRecordCallback(bVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public long getCurrentRecordProcess() {
        if (this.aiD.getGameRecorder() != null) {
            return this.aiD.getGameRecorder().sH();
        }
        return 0L;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameDestroy() {
        this.aiD.smallGameDestroy();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void exitGLThread() {
        if (this.aiH != null) {
            this.aiH.uX();
        }
        Log.e("EngineLogger", "[V8Dispose][AREngine] exitGLThread.");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameUpdate() {
        this.aiD.smallGameUpdate();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setFirstFrameListener(ArBridge.FirstFrameListener firstFrameListener) {
        this.aiD.setFirstFrameListener(firstFrameListener);
    }

    public EGLContext getEGLContext() {
        if (this.aiH == null || this.aiH.ajc == null) {
            return null;
        }
        return this.aiH.ajc.mEglContext;
    }

    protected void finalize() throws Throwable {
        try {
            if (this.aiH != null) {
                this.aiH.uX();
            }
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.smallgame.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0103a extends Thread {
        private c aiF;
        private boolean aiN;
        private boolean aiO;
        private boolean aiP;
        private boolean aiQ;
        private boolean aiR;
        private boolean aiS;
        private boolean aiT;
        private boolean aiU;
        private boolean aiY;
        private b ajc;
        private a ajd;
        private boolean mPaused;
        private int aiI = 0;
        private long aiJ = 0;
        private long aiK = 0;
        private long lastUpdateTime = 0;
        private volatile boolean aiL = false;
        private volatile boolean aiM = false;
        private LinkedList<Runnable> aiZ = new LinkedList<>();
        private TreeSet<d> aja = new TreeSet<>();
        private boolean ajb = true;
        private V8Engine mV8Engine = null;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean aiW = true;
        private int aiV = 1;
        private boolean aiX = false;

        C0103a(a aVar) {
            this.ajd = aVar;
            this.aiF = aVar.aiF;
        }

        /* JADX WARN: Type inference failed for: r4v0, types: [com.baidu.smallgame.sdk.a, com.baidu.searchbox.v8engine.V8Engine, com.baidu.smallgame.sdk.a$b] */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("ARGLThread " + getId());
            try {
                uT();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                this.aiF.b(this);
                this.ajc.reset();
                this.ajc = null;
                this.ajd = null;
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

        private void uR() {
            if (this.aiS) {
                this.aiS = false;
                this.ajc.destroySurface();
            }
        }

        private void uS() {
            if (this.aiR) {
                this.ajc.finish();
                this.aiR = false;
                this.aiF.c(this);
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
            if (r23.ajc.uZ() == false) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:106:0x0250, code lost:
            r10 = r23.aiF;
         */
        /* JADX WARN: Code restructure failed: missing block: B:107:0x0254, code lost:
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:109:0x0256, code lost:
            r23.aiT = true;
            r23.aiF.notifyAll();
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
            r8 = r23.ajd;
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
            r7 = r23.ajd;
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
            r7 = r23.ajd;
            r16 = java.lang.System.currentTimeMillis();
            r18 = r16 - r23.aiK;
         */
        /* JADX WARN: Code restructure failed: missing block: B:125:0x02a7, code lost:
            if (r7.aiE == false) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:127:0x02b4, code lost:
            if (((float) r18) < minFramesInterval()) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:128:0x02b6, code lost:
            r23.aiK = java.lang.System.currentTimeMillis();
            r7.mRenderer.onDrawFrame(null);
            uU();
         */
        /* JADX WARN: Code restructure failed: missing block: B:129:0x02d8, code lost:
            if ((r16 - r23.lastUpdateTime) <= 33) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:130:0x02da, code lost:
            r7.aiD.notifyFrameUpdated();
            r23.lastUpdateTime = r16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:132:0x02ef, code lost:
            if (r7.aiD.shouldSwapBuffer() == false) goto L78;
         */
        /* JADX WARN: Code restructure failed: missing block: B:133:0x02f1, code lost:
            r7 = r23.ajc.va();
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
            r7 = r23.aiF;
         */
        /* JADX WARN: Code restructure failed: missing block: B:136:0x030d, code lost:
            monitor-enter(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:138:0x0310, code lost:
            r23.aiP = true;
            r23.aiF.notifyAll();
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
            r11 = r23.aiF;
         */
        /* JADX WARN: Code restructure failed: missing block: B:148:0x033c, code lost:
            monitor-enter(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:150:0x033f, code lost:
            r23.aiT = true;
            r23.aiP = true;
            r23.aiF.notifyAll();
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
            r7.aiE = true;
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
        private void uT() throws InterruptedException {
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
            this.ajc = new b(this.ajd);
            this.aiR = false;
            this.aiS = false;
            this.aiX = false;
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
                    synchronized (this.aiF) {
                        z = z18;
                        z2 = z15;
                        boolean z19 = z13;
                        Runnable runnable2 = runnable;
                        boolean z20 = z17;
                        boolean z21 = z14;
                        boolean z22 = z12;
                        boolean z23 = z11;
                        while (!this.aiL) {
                            if (!uV() || (runnable2 = uY()) == null) {
                                boolean z24 = false;
                                if (this.mPaused != this.aiN) {
                                    z24 = this.aiN;
                                    this.mPaused = this.aiN;
                                    this.aiF.notifyAll();
                                    Log.i("EngineLogger", "mPaused is now " + this.mPaused + " tid=" + getId());
                                }
                                if (this.aiU) {
                                    uR();
                                    uS();
                                    this.aiU = false;
                                    z = true;
                                }
                                if (z21) {
                                    uR();
                                    uS();
                                    z21 = false;
                                }
                                if (z24 && this.aiS) {
                                    uR();
                                }
                                if (!z24 || this.aiR) {
                                }
                                if (!this.aiO && !this.aiQ) {
                                    if (this.aiS) {
                                        uR();
                                    }
                                    this.aiQ = true;
                                    this.aiP = false;
                                    this.aiF.notifyAll();
                                }
                                if (this.aiO && this.aiQ) {
                                    this.aiQ = false;
                                    this.aiF.notifyAll();
                                }
                                if (z20) {
                                    this.aiX = false;
                                    z20 = false;
                                    this.aiY = true;
                                    this.aiF.notifyAll();
                                }
                                if (uW()) {
                                    if (!this.aiR) {
                                        if (z) {
                                            z = false;
                                            z3 = z23;
                                            if (this.aiR && !this.aiS) {
                                                this.aiS = true;
                                                z22 = true;
                                                z19 = true;
                                                z2 = true;
                                            }
                                            if (this.aiS) {
                                                z23 = z3;
                                            } else {
                                                if (this.ajb) {
                                                    z2 = true;
                                                    i2 = this.mWidth;
                                                    i = this.mHeight;
                                                    this.aiX = true;
                                                    z4 = true;
                                                    this.ajb = false;
                                                } else {
                                                    i = i4;
                                                    i2 = i3;
                                                    z4 = z22;
                                                }
                                                this.aiW = false;
                                                this.aiF.notifyAll();
                                                if (this.aiX) {
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
                                                this.ajc.start();
                                                this.ajd.aiD.setEglContextToRecorder(this.ajd.getEGLContext(), 0, 0);
                                                this.aiR = true;
                                                z23 = true;
                                                this.aiF.notifyAll();
                                            } catch (RuntimeException e) {
                                                this.aiF.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    z3 = z23;
                                    if (this.aiR) {
                                        this.aiS = true;
                                        z22 = true;
                                        z19 = true;
                                        z2 = true;
                                    }
                                    if (this.aiS) {
                                    }
                                }
                                this.aiF.wait();
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
                    synchronized (this.aiF) {
                        if (this.ajd != null) {
                            this.ajd.aiD.smallGameDestroy();
                        }
                        uR();
                        uS();
                    }
                    return;
                } catch (Throwable th) {
                    synchronized (this.aiF) {
                        if (this.ajd != null) {
                            this.ajd.aiD.smallGameDestroy();
                        }
                        uR();
                        uS();
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

        private void uU() {
            float currentTimeMillis;
            this.aiI++;
            if (this.aiJ != 0) {
                if (((float) (System.currentTimeMillis() - this.aiJ)) / 1000.0f > 1.0f) {
                    short s = (short) (this.aiI / currentTimeMillis);
                    V8Engine v8Engine = getV8Engine();
                    if (v8Engine != null) {
                        Log.d("EngineLogger", "fps: " + ((int) s));
                        v8Engine.nativeInitPreferredFramesPerSecond(s <= 60 ? s : (short) 60);
                    }
                    this.aiI = 0;
                    this.aiJ = System.currentTimeMillis();
                    return;
                }
                return;
            }
            this.aiJ = System.currentTimeMillis();
        }

        public boolean uV() {
            return this.aiR && this.aiS && uW();
        }

        private boolean uW() {
            return !this.mPaused && this.aiO && !this.aiP && this.mWidth > 0 && this.mHeight > 0 && (this.aiW || this.aiV == 1);
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (this.aiF) {
                this.aiV = i;
                this.aiF.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (this.aiF) {
                i = this.aiV;
            }
            return i;
        }

        public void requestRender() {
            synchronized (this.aiF) {
                this.aiW = true;
                this.aiF.notifyAll();
            }
        }

        public void requestRenderAndWait() {
            synchronized (this.aiF) {
                if (Thread.currentThread() != this) {
                    this.aiX = true;
                    this.aiW = true;
                    this.aiY = false;
                    this.aiF.notifyAll();
                    while (!this.aiM && !this.mPaused && !this.aiY && uV()) {
                        try {
                            this.aiF.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void surfaceCreated() {
            synchronized (this.aiF) {
                this.aiO = true;
                this.aiT = false;
                this.aiF.notifyAll();
                while (this.aiQ && !this.aiT && !this.aiM) {
                    try {
                        this.aiF.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (this.aiF) {
                this.aiO = false;
                this.aiF.notifyAll();
                while (!this.aiQ && !this.aiM) {
                    try {
                        this.aiF.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (this.aiF) {
                Log.i("EngineLogger", "onPause tid=" + getId());
                this.aiN = true;
                this.aiF.notifyAll();
                while (!this.aiM && !this.mPaused) {
                    Log.i("Main thread", "onPause waiting for mPaused.");
                    try {
                        this.aiF.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (this.aiF) {
                Log.i("EngineLogger", "onResume tid=" + getId());
                this.aiN = false;
                this.aiW = true;
                this.aiY = false;
                this.aiF.notifyAll();
                while (!this.aiM && this.mPaused && !this.aiY) {
                    Log.i("Main thread", "onResume waiting for !mPaused.");
                    try {
                        this.aiF.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void v(int i, int i2) {
            synchronized (this.aiF) {
                this.mWidth = i;
                this.mHeight = i2;
                this.ajb = true;
                this.aiW = true;
                this.aiY = false;
                if (Thread.currentThread() != this) {
                    this.aiF.notifyAll();
                    while (!this.aiM && !this.mPaused && !this.aiY && uV()) {
                        try {
                            this.aiF.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void uX() {
            synchronized (this.aiF) {
                this.aiL = true;
                this.aiF.notifyAll();
                while (!this.aiM) {
                    try {
                        this.aiF.wait();
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
            if (!this.aiL && !this.aiM) {
                synchronized (this.aiF) {
                    this.aiZ.add(runnable);
                    this.aiF.notifyAll();
                }
            }
        }

        public void a(Runnable runnable, long j) {
            if (runnable == null) {
                throw new IllegalArgumentException("r must not be null");
            }
            if (!this.aiL && !this.aiM) {
                synchronized (this.aiF) {
                    TreeSet<d> treeSet = this.aja;
                    if (j <= 0) {
                        j = 0;
                    }
                    treeSet.add(new d(runnable, j));
                    this.aiF.notifyAll();
                }
            }
        }

        private Runnable uY() {
            Runnable pollFirst;
            synchronized (this.aiF) {
                pollFirst = (this.aja.isEmpty() || !this.aja.first().isTimeout()) ? this.aiZ.pollFirst() : this.aja.pollFirst();
            }
            return pollFirst;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class d implements Comparable<d>, Runnable {
        private final Runnable aji;
        private final long mTimestamp;

        d(Runnable runnable, long j) {
            this.aji = runnable;
            this.mTimestamp = System.currentTimeMillis() + j;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.aji.run();
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
        private C0103a ajh;

        private c() {
        }

        public synchronized void b(C0103a c0103a) {
            c0103a.aiM = true;
            if (this.ajh == c0103a) {
                this.ajh = null;
            }
            notifyAll();
        }

        public void c(C0103a c0103a) {
            if (this.ajh == c0103a) {
                this.ajh = null;
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {
        private a ajd;
        EGLDisplay aje;
        EGLSurface ajf;
        EGLConfig ajg;
        EGLContext mEglContext;

        public b(a aVar) {
            this.ajd = aVar;
        }

        public void reset() {
            this.ajd = null;
        }

        public void start() {
            this.aje = EGL14.eglGetDisplay(0);
            if (this.aje == EGL14.EGL_NO_DISPLAY) {
                throw new RuntimeException("unable to get EGL14 display");
            }
            int[] iArr = new int[2];
            if (!EGL14.eglInitialize(this.aje, iArr, 0, iArr, 1)) {
                this.aje = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            a aVar = this.ajd;
            this.ajg = e(0, 0, false);
            this.mEglContext = EGL14.eglCreateContext(this.aje, this.ajg, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
            this.ajd.mCurrentGLThreadID = Thread.currentThread().getId();
            if (this.mEglContext == null || this.mEglContext == EGL14.EGL_NO_CONTEXT) {
                this.mEglContext = null;
                cV("createContext");
            }
            this.ajf = null;
        }

        private EGLConfig e(int i, int i2, boolean z) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (EGL14.eglChooseConfig(this.aje, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, z ? 16 : 0, 12326, 0, 12352, 4, 12344, 0, 12344}, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
                return eGLConfigArr[0];
            }
            Log.w("EngineLogger", "unable to find RGB8888 / " + i2 + " EGLConfig");
            return null;
        }

        public boolean uZ() {
            if (this.aje == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.ajg == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            destroySurface();
            Object obj = this.ajd.mSurfaceHolder;
            if (obj == null) {
                obj = this.ajd.aiG;
            }
            if (obj != null) {
                this.ajf = EGL14.eglCreateWindowSurface(this.aje, this.ajg, obj, new int[]{12344}, 0);
            } else {
                this.ajf = null;
            }
            if (this.ajf == null || this.ajf == EGL14.EGL_NO_SURFACE) {
                if (EGL14.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    return false;
                }
                return false;
            }
            return EGL14.eglMakeCurrent(this.aje, this.ajf, this.ajf, this.mEglContext);
        }

        public int va() {
            return !EGL14.eglSwapBuffers(this.aje, this.ajf) ? EGL14.eglGetError() : CommandMessage.COMMAND_BASE;
        }

        public void destroySurface() {
            if (this.ajf != null && this.ajf != EGL14.EGL_NO_SURFACE) {
                EGL14.eglMakeCurrent(this.aje, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
                EGL14.eglDestroySurface(this.aje, this.ajf);
                this.ajf = null;
            }
        }

        public void finish() {
            if (this.mEglContext != null) {
                EGL14.eglDestroyContext(this.aje, this.mEglContext);
                this.mEglContext = null;
            }
            if (this.aje != null) {
                EGL14.eglTerminate(this.aje);
                this.aje = null;
            }
            this.ajd.mCurrentGLThreadID = -1L;
        }

        private void cV(String str) {
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
