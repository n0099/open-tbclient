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
    private ArBridge aCF;
    private GLSurfaceView.Renderer aCG;
    private Object aCJ;
    private C0141a aCK;
    private boolean mDetached;
    private SurfaceHolder mSurfaceHolder;
    private long mCurrentGLThreadID = -1;
    private boolean aCH = false;
    private final c aCI = new c();

    static {
        V8SoLoader.load();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        Log.setMinLogLevel(6, false);
        this.aCF = new ArBridge();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public ArBridge getArBridge() {
        return this.aCF;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public Thread getGLThread() {
        return this.aCK;
    }

    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = (SurfaceHolder) new WeakReference(surfaceHolder).get();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderer(GLSurfaceView.Renderer renderer) {
        this.aCG = renderer;
        this.aCK = new C0141a(this);
        this.aCK.start();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderMode(int i) {
        if (this.aCK != null) {
            this.aCK.setRenderMode(i);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public int getRenderMode() {
        if (this.aCK != null) {
            return this.aCK.getRenderMode();
        }
        return 1;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRender() {
        if (this.aCK != null) {
            this.aCK.requestRender();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceCreated() {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceCreated.");
        this.aCK.surfaceCreated();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceDestroyed() {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceDestroyed.");
        this.aCK.surfaceDestroyed();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceChanged(int i, int i2) {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceChanged. width=" + i + ", height=" + i2);
        this.aCK.C(i, i2);
        this.aCF.setEglContextToRecorder(getEGLContext(), i, i2);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRenderAndWait() {
        if (this.aCK != null) {
            this.aCK.requestRenderAndWait();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameOnPause() {
        this.aCF.smallGameOnPause();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable) {
        if (this.aCK != null) {
            this.aCK.queueEvent(runnable);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable, long j) {
        if (this.aCK != null) {
            this.aCK.a(runnable, j);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onAttachedToWindow() {
        if (this.mDetached && this.aCG != null) {
            int renderMode = this.aCK != null ? this.aCK.getRenderMode() : 1;
            this.aCK = new C0141a(this);
            if (renderMode != 1) {
                this.aCK.setRenderMode(renderMode);
            }
            this.aCK.start();
        }
        this.mDetached = false;
        Log.w("EngineLogger", "[V8Dispose][AREngine] onAttachedToWindow");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onDetachedFromWindow() {
        if (!this.mDetached && this.aCK != null) {
            this.aCK.Ax();
        }
        this.mDetached = true;
        Log.w("EngineLogger", "[V8Dispose][AREngine] onDetachedFromWindow");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onPause() {
        if (this.aCK != null) {
            this.aCK.onPause();
        }
        if (this.aCF.getGameRecorder() != null) {
            this.aCF.getGameRecorder().yc();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onResume() {
        if (this.aCK != null) {
            this.aCK.onResume();
        }
        if (this.aCF.getGameRecorder() != null) {
            this.aCF.getGameRecorder().yd();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void pauseRecord() {
        if (this.aCF.getGameRecorder() != null) {
            this.aCF.getGameRecorder().pauseRecord();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void resumeRecord() {
        if (this.aCF.getGameRecorder() != null) {
            this.aCF.getGameRecorder().resumeRecord();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void stopRecord() {
        if (this.aCF.getGameRecorder() != null) {
            this.aCF.getGameRecorder().stopRecord();
            this.aCF.nativeUpdateRecordingStatus(false);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (this.aCF.getGameRecorder() != null) {
            this.aCF.nativeUpdateRecordingStatus(true);
            this.aCF.getGameRecorder().startRecord(z, i, str, z2);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setGameRecordCallback(com.baidu.mario.b.b bVar) {
        if (this.aCF.getGameRecorder() != null) {
            this.aCF.getGameRecorder().setGameRecordCallback(bVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public long getCurrentRecordProcess() {
        if (this.aCF.getGameRecorder() != null) {
            return this.aCF.getGameRecorder().yb();
        }
        return 0L;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameDestroy() {
        this.aCF.smallGameDestroy();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void exitGLThread() {
        if (this.aCK != null) {
            this.aCK.Ax();
        }
        Log.e("EngineLogger", "[V8Dispose][AREngine] exitGLThread.");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameUpdate() {
        this.aCF.smallGameUpdate();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setFirstFrameListener(ArBridge.FirstFrameListener firstFrameListener) {
        this.aCF.setFirstFrameListener(firstFrameListener);
    }

    public EGLContext getEGLContext() {
        if (this.aCK == null || this.aCK.aDg == null) {
            return null;
        }
        return this.aCK.aDg.mEglContext;
    }

    protected void finalize() throws Throwable {
        try {
            if (this.aCK != null) {
                this.aCK.Ax();
            }
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.smallgame.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0141a extends Thread {
        private c aCI;
        private boolean aCR;
        private boolean aCS;
        private boolean aCT;
        private boolean aCU;
        private boolean aCV;
        private boolean aCW;
        private boolean aCX;
        private boolean aCY;
        private boolean aDc;
        private b aDg;
        private a aDh;
        private boolean mPaused;
        private int aCL = 0;
        private long aCM = 0;
        private long aCN = 0;
        private long aCO = 0;
        private volatile boolean aCP = false;
        private volatile boolean aCQ = false;
        private LinkedList<Runnable> aDd = new LinkedList<>();
        private TreeSet<d> aDe = new TreeSet<>();
        private boolean aDf = true;
        private V8Engine mV8Engine = null;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean aDa = true;
        private int aCZ = 1;
        private boolean aDb = false;

        C0141a(a aVar) {
            this.aDh = aVar;
            this.aCI = aVar.aCI;
        }

        /* JADX WARN: Type inference failed for: r4v0, types: [com.baidu.smallgame.sdk.a, com.baidu.searchbox.v8engine.V8Engine, com.baidu.smallgame.sdk.a$b] */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("ARGLThread " + getId());
            try {
                At();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                this.aCI.b(this);
                this.aDg.reset();
                this.aDg = null;
                this.aDh = null;
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

        private void Ar() {
            if (this.aCW) {
                this.aCW = false;
                this.aDg.destroySurface();
            }
        }

        private void As() {
            if (this.aCV) {
                this.aDg.finish();
                this.aCV = false;
                this.aCI.c(this);
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
            if (r23.aDg.Az() == false) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:106:0x0250, code lost:
            r10 = r23.aCI;
         */
        /* JADX WARN: Code restructure failed: missing block: B:107:0x0254, code lost:
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:109:0x0256, code lost:
            r23.aCX = true;
            r23.aCI.notifyAll();
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
            r8 = r23.aDh;
         */
        /* JADX WARN: Code restructure failed: missing block: B:116:0x026e, code lost:
            if (r8 == null) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:117:0x0270, code lost:
            r8.aCG.onSurfaceCreated(null, null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:118:0x027c, code lost:
            r9 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:119:0x027e, code lost:
            if (r7 == false) goto L80;
         */
        /* JADX WARN: Code restructure failed: missing block: B:120:0x0280, code lost:
            r7 = r23.aDh;
         */
        /* JADX WARN: Code restructure failed: missing block: B:121:0x0284, code lost:
            if (r7 == null) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:122:0x0286, code lost:
            r7.aCG.onSurfaceChanged(null, r14, r13);
         */
        /* JADX WARN: Code restructure failed: missing block: B:123:0x028e, code lost:
            com.baidu.searchbox.v8engine.V8Engine.updateSurfaceViewSize(r14, r13);
            r8 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:124:0x0293, code lost:
            r7 = r23.aDh;
            r16 = java.lang.System.currentTimeMillis();
            r18 = r16 - r23.aCN;
         */
        /* JADX WARN: Code restructure failed: missing block: B:125:0x02a7, code lost:
            if (r7.aCH == false) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:127:0x02b4, code lost:
            if (((float) r18) < minFramesInterval()) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:128:0x02b6, code lost:
            r23.aCN = java.lang.System.currentTimeMillis();
            r7.aCG.onDrawFrame(null);
            Au();
         */
        /* JADX WARN: Code restructure failed: missing block: B:129:0x02d8, code lost:
            if ((r16 - r23.aCO) <= 33) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:130:0x02da, code lost:
            r7.aCF.notifyFrameUpdated();
            r23.aCO = r16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:132:0x02ef, code lost:
            if (r7.aCF.shouldSwapBuffer() == false) goto L78;
         */
        /* JADX WARN: Code restructure failed: missing block: B:133:0x02f1, code lost:
            r7 = r23.aDg.AA();
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
            r7 = r23.aCI;
         */
        /* JADX WARN: Code restructure failed: missing block: B:136:0x030d, code lost:
            monitor-enter(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:138:0x0310, code lost:
            r23.aCT = true;
            r23.aCI.notifyAll();
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
            r11 = r23.aCI;
         */
        /* JADX WARN: Code restructure failed: missing block: B:148:0x033c, code lost:
            monitor-enter(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:150:0x033f, code lost:
            r23.aCX = true;
            r23.aCT = true;
            r23.aCI.notifyAll();
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
            r7.aCH = true;
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
        private void At() throws InterruptedException {
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
            this.aDg = new b(this.aDh);
            this.aCV = false;
            this.aCW = false;
            this.aDb = false;
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
                    synchronized (this.aCI) {
                        z = z18;
                        z2 = z15;
                        boolean z19 = z13;
                        Runnable runnable2 = runnable;
                        boolean z20 = z17;
                        boolean z21 = z14;
                        boolean z22 = z12;
                        boolean z23 = z11;
                        while (!this.aCP) {
                            if (!Av() || (runnable2 = Ay()) == null) {
                                boolean z24 = false;
                                if (this.mPaused != this.aCR) {
                                    z24 = this.aCR;
                                    this.mPaused = this.aCR;
                                    this.aCI.notifyAll();
                                    Log.i("EngineLogger", "mPaused is now " + this.mPaused + " tid=" + getId());
                                }
                                if (this.aCY) {
                                    Ar();
                                    As();
                                    this.aCY = false;
                                    z = true;
                                }
                                if (z21) {
                                    Ar();
                                    As();
                                    z21 = false;
                                }
                                if (z24 && this.aCW) {
                                    Ar();
                                }
                                if (!z24 || this.aCV) {
                                }
                                if (!this.aCS && !this.aCU) {
                                    if (this.aCW) {
                                        Ar();
                                    }
                                    this.aCU = true;
                                    this.aCT = false;
                                    this.aCI.notifyAll();
                                }
                                if (this.aCS && this.aCU) {
                                    this.aCU = false;
                                    this.aCI.notifyAll();
                                }
                                if (z20) {
                                    this.aDb = false;
                                    z20 = false;
                                    this.aDc = true;
                                    this.aCI.notifyAll();
                                }
                                if (Aw()) {
                                    if (!this.aCV) {
                                        if (z) {
                                            z = false;
                                            z3 = z23;
                                            if (this.aCV && !this.aCW) {
                                                this.aCW = true;
                                                z22 = true;
                                                z19 = true;
                                                z2 = true;
                                            }
                                            if (this.aCW) {
                                                z23 = z3;
                                            } else {
                                                if (this.aDf) {
                                                    z2 = true;
                                                    i2 = this.mWidth;
                                                    i = this.mHeight;
                                                    this.aDb = true;
                                                    z4 = true;
                                                    this.aDf = false;
                                                } else {
                                                    i = i4;
                                                    i2 = i3;
                                                    z4 = z22;
                                                }
                                                this.aDa = false;
                                                this.aCI.notifyAll();
                                                if (this.aDb) {
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
                                                this.aDg.start();
                                                this.aDh.aCF.setEglContextToRecorder(this.aDh.getEGLContext(), 0, 0);
                                                this.aCV = true;
                                                z23 = true;
                                                this.aCI.notifyAll();
                                            } catch (RuntimeException e) {
                                                this.aCI.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    z3 = z23;
                                    if (this.aCV) {
                                        this.aCW = true;
                                        z22 = true;
                                        z19 = true;
                                        z2 = true;
                                    }
                                    if (this.aCW) {
                                    }
                                }
                                this.aCI.wait();
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
                    synchronized (this.aCI) {
                        if (this.aDh != null) {
                            this.aDh.aCF.smallGameDestroy();
                        }
                        Ar();
                        As();
                    }
                    return;
                } catch (Throwable th) {
                    synchronized (this.aCI) {
                        if (this.aDh != null) {
                            this.aDh.aCF.smallGameDestroy();
                        }
                        Ar();
                        As();
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

        private void Au() {
            float currentTimeMillis;
            this.aCL++;
            if (this.aCM != 0) {
                if (((float) (System.currentTimeMillis() - this.aCM)) / 1000.0f > 1.0f) {
                    short s = (short) (this.aCL / currentTimeMillis);
                    V8Engine v8Engine = getV8Engine();
                    if (v8Engine != null) {
                        Log.d("EngineLogger", "fps: " + ((int) s));
                        v8Engine.nativeInitPreferredFramesPerSecond(s <= 60 ? s : (short) 60);
                    }
                    this.aCL = 0;
                    this.aCM = System.currentTimeMillis();
                    return;
                }
                return;
            }
            this.aCM = System.currentTimeMillis();
        }

        public boolean Av() {
            return this.aCV && this.aCW && Aw();
        }

        private boolean Aw() {
            return !this.mPaused && this.aCS && !this.aCT && this.mWidth > 0 && this.mHeight > 0 && (this.aDa || this.aCZ == 1);
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (this.aCI) {
                this.aCZ = i;
                this.aCI.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (this.aCI) {
                i = this.aCZ;
            }
            return i;
        }

        public void requestRender() {
            synchronized (this.aCI) {
                this.aDa = true;
                this.aCI.notifyAll();
            }
        }

        public void requestRenderAndWait() {
            synchronized (this.aCI) {
                if (Thread.currentThread() != this) {
                    this.aDb = true;
                    this.aDa = true;
                    this.aDc = false;
                    this.aCI.notifyAll();
                    while (!this.aCQ && !this.mPaused && !this.aDc && Av()) {
                        try {
                            this.aCI.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void surfaceCreated() {
            synchronized (this.aCI) {
                this.aCS = true;
                this.aCX = false;
                this.aCI.notifyAll();
                while (this.aCU && !this.aCX && !this.aCQ) {
                    try {
                        this.aCI.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (this.aCI) {
                this.aCS = false;
                this.aCI.notifyAll();
                while (!this.aCU && !this.aCQ) {
                    try {
                        this.aCI.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (this.aCI) {
                Log.i("EngineLogger", "onPause tid=" + getId());
                this.aCR = true;
                this.aCI.notifyAll();
                while (!this.aCQ && !this.mPaused) {
                    Log.i("Main thread", "onPause waiting for mPaused.");
                    try {
                        this.aCI.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (this.aCI) {
                Log.i("EngineLogger", "onResume tid=" + getId());
                this.aCR = false;
                this.aDa = true;
                this.aDc = false;
                this.aCI.notifyAll();
                while (!this.aCQ && this.mPaused && !this.aDc) {
                    Log.i("Main thread", "onResume waiting for !mPaused.");
                    try {
                        this.aCI.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void C(int i, int i2) {
            synchronized (this.aCI) {
                this.mWidth = i;
                this.mHeight = i2;
                this.aDf = true;
                this.aDa = true;
                this.aDc = false;
                if (Thread.currentThread() != this) {
                    this.aCI.notifyAll();
                    while (!this.aCQ && !this.mPaused && !this.aDc && Av()) {
                        try {
                            this.aCI.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void Ax() {
            synchronized (this.aCI) {
                this.aCP = true;
                this.aCI.notifyAll();
                while (!this.aCQ) {
                    try {
                        this.aCI.wait();
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
            if (!this.aCP && !this.aCQ) {
                synchronized (this.aCI) {
                    this.aDd.add(runnable);
                    this.aCI.notifyAll();
                }
            }
        }

        public void a(Runnable runnable, long j) {
            if (runnable == null) {
                throw new IllegalArgumentException("r must not be null");
            }
            if (!this.aCP && !this.aCQ) {
                synchronized (this.aCI) {
                    TreeSet<d> treeSet = this.aDe;
                    if (j <= 0) {
                        j = 0;
                    }
                    treeSet.add(new d(runnable, j));
                    this.aCI.notifyAll();
                }
            }
        }

        private Runnable Ay() {
            Runnable pollFirst;
            synchronized (this.aCI) {
                pollFirst = (this.aDe.isEmpty() || !this.aDe.first().isTimeout()) ? this.aDd.pollFirst() : this.aDe.pollFirst();
            }
            return pollFirst;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class d implements Comparable<d>, Runnable {
        private final Runnable aDm;
        private final long mTimestamp;

        d(Runnable runnable, long j) {
            this.aDm = runnable;
            this.mTimestamp = System.currentTimeMillis() + j;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.aDm.run();
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
        private C0141a aDl;

        private c() {
        }

        public synchronized void b(C0141a c0141a) {
            c0141a.aCQ = true;
            if (this.aDl == c0141a) {
                this.aDl = null;
            }
            notifyAll();
        }

        public void c(C0141a c0141a) {
            if (this.aDl == c0141a) {
                this.aDl = null;
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {
        private a aDh;
        EGLDisplay aDi;
        EGLSurface aDj;
        EGLConfig aDk;
        EGLContext mEglContext;

        public b(a aVar) {
            this.aDh = aVar;
        }

        public void reset() {
            this.aDh = null;
        }

        public void start() {
            this.aDi = EGL14.eglGetDisplay(0);
            if (this.aDi == EGL14.EGL_NO_DISPLAY) {
                throw new RuntimeException("unable to get EGL14 display");
            }
            int[] iArr = new int[2];
            if (!EGL14.eglInitialize(this.aDi, iArr, 0, iArr, 1)) {
                this.aDi = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            a aVar = this.aDh;
            this.aDk = f(0, 0, false);
            this.mEglContext = EGL14.eglCreateContext(this.aDi, this.aDk, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
            this.aDh.mCurrentGLThreadID = Thread.currentThread().getId();
            if (this.mEglContext == null || this.mEglContext == EGL14.EGL_NO_CONTEXT) {
                this.mEglContext = null;
                dM("createContext");
            }
            this.aDj = null;
        }

        private EGLConfig f(int i, int i2, boolean z) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (EGL14.eglChooseConfig(this.aDi, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, z ? 16 : 0, 12326, 0, 12352, 4, 12344, 0, 12344}, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
                return eGLConfigArr[0];
            }
            Log.w("EngineLogger", "unable to find RGB8888 / " + i2 + " EGLConfig");
            return null;
        }

        public boolean Az() {
            if (this.aDi == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.aDk == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            destroySurface();
            Object obj = this.aDh.mSurfaceHolder;
            if (obj == null) {
                obj = this.aDh.aCJ;
            }
            if (obj != null) {
                this.aDj = EGL14.eglCreateWindowSurface(this.aDi, this.aDk, obj, new int[]{12344}, 0);
            } else {
                this.aDj = null;
            }
            if (this.aDj == null || this.aDj == EGL14.EGL_NO_SURFACE) {
                if (EGL14.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    return false;
                }
                return false;
            }
            return EGL14.eglMakeCurrent(this.aDi, this.aDj, this.aDj, this.mEglContext);
        }

        public int AA() {
            return !EGL14.eglSwapBuffers(this.aDi, this.aDj) ? EGL14.eglGetError() : CommandMessage.COMMAND_BASE;
        }

        public void destroySurface() {
            if (this.aDj != null && this.aDj != EGL14.EGL_NO_SURFACE) {
                EGL14.eglMakeCurrent(this.aDi, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
                EGL14.eglDestroySurface(this.aDi, this.aDj);
                this.aDj = null;
            }
        }

        public void finish() {
            if (this.mEglContext != null) {
                EGL14.eglDestroyContext(this.aDi, this.mEglContext);
                this.mEglContext = null;
            }
            if (this.aDi != null) {
                EGL14.eglTerminate(this.aDi);
                this.aDi = null;
            }
            this.aDh.mCurrentGLThreadID = -1L;
        }

        private void dM(String str) {
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
