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
    private ArBridge aCX;
    private GLSurfaceView.Renderer aCY;
    private Object aDb;
    private C0146a aDc;
    private boolean mDetached;
    private SurfaceHolder mSurfaceHolder;
    private long mCurrentGLThreadID = -1;
    private boolean aCZ = false;
    private final c aDa = new c();

    static {
        V8SoLoader.load();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        Log.setMinLogLevel(6, false);
        this.aCX = new ArBridge();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public ArBridge getArBridge() {
        return this.aCX;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public Thread getGLThread() {
        return this.aDc;
    }

    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = (SurfaceHolder) new WeakReference(surfaceHolder).get();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderer(GLSurfaceView.Renderer renderer) {
        this.aCY = renderer;
        this.aDc = new C0146a(this);
        this.aDc.start();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderMode(int i) {
        if (this.aDc != null) {
            this.aDc.setRenderMode(i);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public int getRenderMode() {
        if (this.aDc != null) {
            return this.aDc.getRenderMode();
        }
        return 1;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRender() {
        if (this.aDc != null) {
            this.aDc.requestRender();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceCreated() {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceCreated.");
        this.aDc.surfaceCreated();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceDestroyed() {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceDestroyed.");
        this.aDc.surfaceDestroyed();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceChanged(int i, int i2) {
        Log.w("EngineLogger", "[V8Dispose][AREngine] surfaceChanged. width=" + i + ", height=" + i2);
        this.aDc.E(i, i2);
        this.aCX.setEglContextToRecorder(getEGLContext(), i, i2);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRenderAndWait() {
        if (this.aDc != null) {
            this.aDc.requestRenderAndWait();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameOnPause() {
        this.aCX.smallGameOnPause();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable) {
        if (this.aDc != null) {
            this.aDc.queueEvent(runnable);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable, long j) {
        if (this.aDc != null) {
            this.aDc.a(runnable, j);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onAttachedToWindow() {
        if (this.mDetached && this.aCY != null) {
            int renderMode = this.aDc != null ? this.aDc.getRenderMode() : 1;
            this.aDc = new C0146a(this);
            if (renderMode != 1) {
                this.aDc.setRenderMode(renderMode);
            }
            this.aDc.start();
        }
        this.mDetached = false;
        Log.w("EngineLogger", "[V8Dispose][AREngine] onAttachedToWindow");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onDetachedFromWindow() {
        if (!this.mDetached && this.aDc != null) {
            this.aDc.Aw();
        }
        this.mDetached = true;
        Log.w("EngineLogger", "[V8Dispose][AREngine] onDetachedFromWindow");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onPause() {
        if (this.aDc != null) {
            this.aDc.onPause();
        }
        if (this.aCX.getGameRecorder() != null) {
            this.aCX.getGameRecorder().yb();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onResume() {
        if (this.aDc != null) {
            this.aDc.onResume();
        }
        if (this.aCX.getGameRecorder() != null) {
            this.aCX.getGameRecorder().yc();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void pauseRecord() {
        if (this.aCX.getGameRecorder() != null) {
            this.aCX.getGameRecorder().pauseRecord();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void resumeRecord() {
        if (this.aCX.getGameRecorder() != null) {
            this.aCX.getGameRecorder().resumeRecord();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void stopRecord() {
        if (this.aCX.getGameRecorder() != null) {
            this.aCX.getGameRecorder().stopRecord();
            this.aCX.nativeUpdateRecordingStatus(false);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (this.aCX.getGameRecorder() != null) {
            this.aCX.nativeUpdateRecordingStatus(true);
            this.aCX.getGameRecorder().startRecord(z, i, str, z2);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setGameRecordCallback(com.baidu.mario.b.b bVar) {
        if (this.aCX.getGameRecorder() != null) {
            this.aCX.getGameRecorder().setGameRecordCallback(bVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public long getCurrentRecordProcess() {
        if (this.aCX.getGameRecorder() != null) {
            return this.aCX.getGameRecorder().ya();
        }
        return 0L;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameDestroy() {
        this.aCX.smallGameDestroy();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void exitGLThread() {
        if (this.aDc != null) {
            this.aDc.Aw();
        }
        Log.e("EngineLogger", "[V8Dispose][AREngine] exitGLThread.");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameUpdate() {
        this.aCX.smallGameUpdate();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setFirstFrameListener(ArBridge.FirstFrameListener firstFrameListener) {
        this.aCX.setFirstFrameListener(firstFrameListener);
    }

    public EGLContext getEGLContext() {
        if (this.aDc == null || this.aDc.aDy == null) {
            return null;
        }
        return this.aDc.aDy.mEglContext;
    }

    protected void finalize() throws Throwable {
        try {
            if (this.aDc != null) {
                this.aDc.Aw();
            }
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.smallgame.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0146a extends Thread {
        private c aDa;
        private boolean aDj;
        private boolean aDk;
        private boolean aDl;
        private boolean aDm;
        private boolean aDn;
        private boolean aDo;
        private boolean aDp;
        private boolean aDq;
        private boolean aDu;
        private b aDy;
        private a aDz;
        private boolean mPaused;
        private int aDd = 0;
        private long aDe = 0;
        private long aDf = 0;
        private long aDg = 0;
        private volatile boolean aDh = false;
        private volatile boolean aDi = false;
        private LinkedList<Runnable> aDv = new LinkedList<>();
        private TreeSet<d> aDw = new TreeSet<>();
        private boolean aDx = true;
        private V8Engine mV8Engine = null;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean aDs = true;
        private int aDr = 1;
        private boolean aDt = false;

        C0146a(a aVar) {
            this.aDz = aVar;
            this.aDa = aVar.aDa;
        }

        /* JADX WARN: Type inference failed for: r4v0, types: [com.baidu.smallgame.sdk.a, com.baidu.searchbox.v8engine.V8Engine, com.baidu.smallgame.sdk.a$b] */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("ARGLThread " + getId());
            try {
                As();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                this.aDa.b(this);
                this.aDy.reset();
                this.aDy = null;
                this.aDz = null;
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

        private void Aq() {
            if (this.aDo) {
                this.aDo = false;
                this.aDy.destroySurface();
            }
        }

        private void Ar() {
            if (this.aDn) {
                this.aDy.finish();
                this.aDn = false;
                this.aDa.c(this);
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
            if (r23.aDy.Ay() == false) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:106:0x0250, code lost:
            r10 = r23.aDa;
         */
        /* JADX WARN: Code restructure failed: missing block: B:107:0x0254, code lost:
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:109:0x0256, code lost:
            r23.aDp = true;
            r23.aDa.notifyAll();
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
            r8 = r23.aDz;
         */
        /* JADX WARN: Code restructure failed: missing block: B:116:0x026e, code lost:
            if (r8 == null) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:117:0x0270, code lost:
            r8.aCY.onSurfaceCreated(null, null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:118:0x027c, code lost:
            r9 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:119:0x027e, code lost:
            if (r7 == false) goto L80;
         */
        /* JADX WARN: Code restructure failed: missing block: B:120:0x0280, code lost:
            r7 = r23.aDz;
         */
        /* JADX WARN: Code restructure failed: missing block: B:121:0x0284, code lost:
            if (r7 == null) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:122:0x0286, code lost:
            r7.aCY.onSurfaceChanged(null, r14, r13);
         */
        /* JADX WARN: Code restructure failed: missing block: B:123:0x028e, code lost:
            com.baidu.searchbox.v8engine.V8Engine.updateSurfaceViewSize(r14, r13);
            r8 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:124:0x0293, code lost:
            r7 = r23.aDz;
            r16 = java.lang.System.currentTimeMillis();
            r18 = r16 - r23.aDf;
         */
        /* JADX WARN: Code restructure failed: missing block: B:125:0x02a7, code lost:
            if (r7.aCZ == false) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:127:0x02b4, code lost:
            if (((float) r18) < minFramesInterval()) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:128:0x02b6, code lost:
            r23.aDf = java.lang.System.currentTimeMillis();
            r7.aCY.onDrawFrame(null);
            At();
         */
        /* JADX WARN: Code restructure failed: missing block: B:129:0x02d8, code lost:
            if ((r16 - r23.aDg) <= 33) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:130:0x02da, code lost:
            r7.aCX.notifyFrameUpdated();
            r23.aDg = r16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:132:0x02ef, code lost:
            if (r7.aCX.shouldSwapBuffer() == false) goto L78;
         */
        /* JADX WARN: Code restructure failed: missing block: B:133:0x02f1, code lost:
            r7 = r23.aDy.Az();
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
            r7 = r23.aDa;
         */
        /* JADX WARN: Code restructure failed: missing block: B:136:0x030d, code lost:
            monitor-enter(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:138:0x0310, code lost:
            r23.aDl = true;
            r23.aDa.notifyAll();
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
            r11 = r23.aDa;
         */
        /* JADX WARN: Code restructure failed: missing block: B:148:0x033c, code lost:
            monitor-enter(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:150:0x033f, code lost:
            r23.aDp = true;
            r23.aDl = true;
            r23.aDa.notifyAll();
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
            r7.aCZ = true;
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
        private void As() throws InterruptedException {
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
            this.aDy = new b(this.aDz);
            this.aDn = false;
            this.aDo = false;
            this.aDt = false;
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
                    synchronized (this.aDa) {
                        z = z18;
                        z2 = z15;
                        boolean z19 = z13;
                        Runnable runnable2 = runnable;
                        boolean z20 = z17;
                        boolean z21 = z14;
                        boolean z22 = z12;
                        boolean z23 = z11;
                        while (!this.aDh) {
                            if (!Au() || (runnable2 = Ax()) == null) {
                                boolean z24 = false;
                                if (this.mPaused != this.aDj) {
                                    z24 = this.aDj;
                                    this.mPaused = this.aDj;
                                    this.aDa.notifyAll();
                                    Log.i("EngineLogger", "mPaused is now " + this.mPaused + " tid=" + getId());
                                }
                                if (this.aDq) {
                                    Aq();
                                    Ar();
                                    this.aDq = false;
                                    z = true;
                                }
                                if (z21) {
                                    Aq();
                                    Ar();
                                    z21 = false;
                                }
                                if (z24 && this.aDo) {
                                    Aq();
                                }
                                if (!z24 || this.aDn) {
                                }
                                if (!this.aDk && !this.aDm) {
                                    if (this.aDo) {
                                        Aq();
                                    }
                                    this.aDm = true;
                                    this.aDl = false;
                                    this.aDa.notifyAll();
                                }
                                if (this.aDk && this.aDm) {
                                    this.aDm = false;
                                    this.aDa.notifyAll();
                                }
                                if (z20) {
                                    this.aDt = false;
                                    z20 = false;
                                    this.aDu = true;
                                    this.aDa.notifyAll();
                                }
                                if (Av()) {
                                    if (!this.aDn) {
                                        if (z) {
                                            z = false;
                                            z3 = z23;
                                            if (this.aDn && !this.aDo) {
                                                this.aDo = true;
                                                z22 = true;
                                                z19 = true;
                                                z2 = true;
                                            }
                                            if (this.aDo) {
                                                z23 = z3;
                                            } else {
                                                if (this.aDx) {
                                                    z2 = true;
                                                    i2 = this.mWidth;
                                                    i = this.mHeight;
                                                    this.aDt = true;
                                                    z4 = true;
                                                    this.aDx = false;
                                                } else {
                                                    i = i4;
                                                    i2 = i3;
                                                    z4 = z22;
                                                }
                                                this.aDs = false;
                                                this.aDa.notifyAll();
                                                if (this.aDt) {
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
                                                this.aDy.start();
                                                this.aDz.aCX.setEglContextToRecorder(this.aDz.getEGLContext(), 0, 0);
                                                this.aDn = true;
                                                z23 = true;
                                                this.aDa.notifyAll();
                                            } catch (RuntimeException e) {
                                                this.aDa.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    z3 = z23;
                                    if (this.aDn) {
                                        this.aDo = true;
                                        z22 = true;
                                        z19 = true;
                                        z2 = true;
                                    }
                                    if (this.aDo) {
                                    }
                                }
                                this.aDa.wait();
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
                    synchronized (this.aDa) {
                        if (this.aDz != null) {
                            this.aDz.aCX.smallGameDestroy();
                        }
                        Aq();
                        Ar();
                    }
                    return;
                } catch (Throwable th) {
                    synchronized (this.aDa) {
                        if (this.aDz != null) {
                            this.aDz.aCX.smallGameDestroy();
                        }
                        Aq();
                        Ar();
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

        private void At() {
            float currentTimeMillis;
            this.aDd++;
            if (this.aDe != 0) {
                if (((float) (System.currentTimeMillis() - this.aDe)) / 1000.0f > 1.0f) {
                    short s = (short) (this.aDd / currentTimeMillis);
                    V8Engine v8Engine = getV8Engine();
                    if (v8Engine != null) {
                        Log.d("EngineLogger", "fps: " + ((int) s));
                        v8Engine.nativeInitPreferredFramesPerSecond(s <= 60 ? s : (short) 60);
                    }
                    this.aDd = 0;
                    this.aDe = System.currentTimeMillis();
                    return;
                }
                return;
            }
            this.aDe = System.currentTimeMillis();
        }

        public boolean Au() {
            return this.aDn && this.aDo && Av();
        }

        private boolean Av() {
            return !this.mPaused && this.aDk && !this.aDl && this.mWidth > 0 && this.mHeight > 0 && (this.aDs || this.aDr == 1);
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (this.aDa) {
                this.aDr = i;
                this.aDa.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (this.aDa) {
                i = this.aDr;
            }
            return i;
        }

        public void requestRender() {
            synchronized (this.aDa) {
                this.aDs = true;
                this.aDa.notifyAll();
            }
        }

        public void requestRenderAndWait() {
            synchronized (this.aDa) {
                if (Thread.currentThread() != this) {
                    this.aDt = true;
                    this.aDs = true;
                    this.aDu = false;
                    this.aDa.notifyAll();
                    while (!this.aDi && !this.mPaused && !this.aDu && Au()) {
                        try {
                            this.aDa.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void surfaceCreated() {
            synchronized (this.aDa) {
                this.aDk = true;
                this.aDp = false;
                this.aDa.notifyAll();
                while (this.aDm && !this.aDp && !this.aDi) {
                    try {
                        this.aDa.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (this.aDa) {
                this.aDk = false;
                this.aDa.notifyAll();
                while (!this.aDm && !this.aDi) {
                    try {
                        this.aDa.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (this.aDa) {
                Log.i("EngineLogger", "onPause tid=" + getId());
                this.aDj = true;
                this.aDa.notifyAll();
                while (!this.aDi && !this.mPaused) {
                    Log.i("Main thread", "onPause waiting for mPaused.");
                    try {
                        this.aDa.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (this.aDa) {
                Log.i("EngineLogger", "onResume tid=" + getId());
                this.aDj = false;
                this.aDs = true;
                this.aDu = false;
                this.aDa.notifyAll();
                while (!this.aDi && this.mPaused && !this.aDu) {
                    Log.i("Main thread", "onResume waiting for !mPaused.");
                    try {
                        this.aDa.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void E(int i, int i2) {
            synchronized (this.aDa) {
                this.mWidth = i;
                this.mHeight = i2;
                this.aDx = true;
                this.aDs = true;
                this.aDu = false;
                if (Thread.currentThread() != this) {
                    this.aDa.notifyAll();
                    while (!this.aDi && !this.mPaused && !this.aDu && Au()) {
                        try {
                            this.aDa.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void Aw() {
            synchronized (this.aDa) {
                this.aDh = true;
                this.aDa.notifyAll();
                while (!this.aDi) {
                    try {
                        this.aDa.wait();
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
            if (!this.aDh && !this.aDi) {
                synchronized (this.aDa) {
                    this.aDv.add(runnable);
                    this.aDa.notifyAll();
                }
            }
        }

        public void a(Runnable runnable, long j) {
            if (runnable == null) {
                throw new IllegalArgumentException("r must not be null");
            }
            if (!this.aDh && !this.aDi) {
                synchronized (this.aDa) {
                    TreeSet<d> treeSet = this.aDw;
                    if (j <= 0) {
                        j = 0;
                    }
                    treeSet.add(new d(runnable, j));
                    this.aDa.notifyAll();
                }
            }
        }

        private Runnable Ax() {
            Runnable pollFirst;
            synchronized (this.aDa) {
                pollFirst = (this.aDw.isEmpty() || !this.aDw.first().isTimeout()) ? this.aDv.pollFirst() : this.aDw.pollFirst();
            }
            return pollFirst;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class d implements Comparable<d>, Runnable {
        private final Runnable aDE;
        private final long mTimestamp;

        d(Runnable runnable, long j) {
            this.aDE = runnable;
            this.mTimestamp = System.currentTimeMillis() + j;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.aDE.run();
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
        private C0146a aDD;

        private c() {
        }

        public synchronized void b(C0146a c0146a) {
            c0146a.aDi = true;
            if (this.aDD == c0146a) {
                this.aDD = null;
            }
            notifyAll();
        }

        public void c(C0146a c0146a) {
            if (this.aDD == c0146a) {
                this.aDD = null;
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {
        EGLDisplay aDA;
        EGLSurface aDB;
        EGLConfig aDC;
        private a aDz;
        EGLContext mEglContext;

        public b(a aVar) {
            this.aDz = aVar;
        }

        public void reset() {
            this.aDz = null;
        }

        public void start() {
            this.aDA = EGL14.eglGetDisplay(0);
            if (this.aDA == EGL14.EGL_NO_DISPLAY) {
                throw new RuntimeException("unable to get EGL14 display");
            }
            int[] iArr = new int[2];
            if (!EGL14.eglInitialize(this.aDA, iArr, 0, iArr, 1)) {
                this.aDA = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            a aVar = this.aDz;
            this.aDC = f(0, 0, false);
            this.mEglContext = EGL14.eglCreateContext(this.aDA, this.aDC, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
            this.aDz.mCurrentGLThreadID = Thread.currentThread().getId();
            if (this.mEglContext == null || this.mEglContext == EGL14.EGL_NO_CONTEXT) {
                this.mEglContext = null;
                dM("createContext");
            }
            this.aDB = null;
        }

        private EGLConfig f(int i, int i2, boolean z) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (EGL14.eglChooseConfig(this.aDA, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, z ? 16 : 0, 12326, 0, 12352, 4, 12344, 0, 12344}, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
                return eGLConfigArr[0];
            }
            Log.w("EngineLogger", "unable to find RGB8888 / " + i2 + " EGLConfig");
            return null;
        }

        public boolean Ay() {
            if (this.aDA == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.aDC == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            destroySurface();
            Object obj = this.aDz.mSurfaceHolder;
            if (obj == null) {
                obj = this.aDz.aDb;
            }
            if (obj != null) {
                this.aDB = EGL14.eglCreateWindowSurface(this.aDA, this.aDC, obj, new int[]{12344}, 0);
            } else {
                this.aDB = null;
            }
            if (this.aDB == null || this.aDB == EGL14.EGL_NO_SURFACE) {
                if (EGL14.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    return false;
                }
                return false;
            }
            return EGL14.eglMakeCurrent(this.aDA, this.aDB, this.aDB, this.mEglContext);
        }

        public int Az() {
            return !EGL14.eglSwapBuffers(this.aDA, this.aDB) ? EGL14.eglGetError() : CommandMessage.COMMAND_BASE;
        }

        public void destroySurface() {
            if (this.aDB != null && this.aDB != EGL14.EGL_NO_SURFACE) {
                EGL14.eglMakeCurrent(this.aDA, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
                EGL14.eglDestroySurface(this.aDA, this.aDB);
                this.aDB = null;
            }
        }

        public void finish() {
            if (this.mEglContext != null) {
                EGL14.eglDestroyContext(this.aDA, this.mEglContext);
                this.mEglContext = null;
            }
            if (this.aDA != null) {
                EGL14.eglTerminate(this.aDA);
                this.aDA = null;
            }
            this.aDz.mCurrentGLThreadID = -1L;
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
