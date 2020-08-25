package com.baidu.ar.arrender;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.opengl.Matrix;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import com.baidu.ar.DuMixInput;
import com.baidu.ar.DuMixOutput;
import com.baidu.ar.DuMixStateListener;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadListener;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.engine.pixel.PixelRotation;
import com.baidu.ar.arplay.core.filter.ARPFilter;
import com.baidu.ar.arplay.core.filter.OnRenderFinishedListener;
import com.baidu.ar.arplay.core.filter.OnRenderStartedListener;
import com.baidu.ar.bean.RotationType;
import com.baidu.ar.bean.Size;
import com.baidu.ar.g.p;
import com.baidu.ar.libloader.a;
import com.baidu.ar.statistic.StatisticApi;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public abstract class e implements SurfaceTexture.OnFrameAvailableListener, View.OnTouchListener, OnRenderFinishedListener, OnRenderStartedListener, IRenderer {
    private f C;
    DuMixInput W;
    private String aF;
    DuMixOutput aa;
    com.baidu.ar.lua.b f;
    private o gR;
    private boolean gS;
    private boolean gT;
    private long gU;
    private HashMap<DuMixOutput, o> gV;
    private com.baidu.ar.steploading.d gW;
    private com.baidu.ar.f.c gX;
    private com.baidu.ar.lua.a gY;
    ARPFilter gZ;
    ARPEngine ha;
    boolean hb;
    com.baidu.ar.arplay.core.engine.a hc;
    private WeakReference<View> hd;
    a he;
    com.baidu.ar.arplay.a.c hf;
    com.baidu.ar.arplay.d.b hg;
    boolean hh;
    private float[] hi;
    private float[] hj;
    boolean hk;
    private float[] hl;
    private String hm;
    private int hn;
    private Size ho;
    protected EGLContext hp;
    private DuMixStateListener hq;
    private boolean hr;
    protected boolean hs;
    private g ht;
    private j hu;
    private volatile boolean hv;
    private volatile boolean hw;
    protected boolean hx;
    String mCasePath;
    private Context mContext;
    private OnRenderFinishedListener mOnRenderFinishedListener;
    private OnRenderStartedListener mOnRenderStartedListener;

    public e(Context context, Looper looper, com.baidu.ar.lua.b bVar) {
        this(context, looper, bVar, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context, Looper looper, com.baidu.ar.lua.b bVar, EGLContext eGLContext) {
        this.gS = false;
        this.gT = false;
        this.gU = 0L;
        this.aF = "filter_pipeline = function()\n\n    fm = ae.FilterManager:get_instance();\n\n    global_copy_filter = fm:create_filter(\"Tex2DFilter\", \"globalTex2DFilter\", true);\n    gl_makeup_filer = fm:create_filter(\"BeautyMakeupFilter\",\"globalBeautyMakeupFilter\",true);\n\n    skin_filter = fm:create_filter(\"SkinFilter\", \"globalSkinFilter\", true);\n    engine_filter = fm:create_filter(\"EngineFilter\", \"globalEngineFilter\", true);\n    fm:update_property_int(engine_filter, \"is_enable\", 0);\n    face_filter = fm:create_filter(\"FaceFilter\", \"globalFaceFilter\", true);\n    lut_filter = fm:create_filter(\"LUTFilter\", \"globalLutFilter\", true);\n    tune_color_filter = fm:create_filter(\"TuneColorFilter\", \"globalTuneColorFilter\", true);\n    fm:reset_pipeline();\n\n    fm:connect_filters_by_id(skin_filter, gl_makeup_filer);\n    fm:connect_filters_by_id(skin_filter, global_copy_filter);\n    fm:connect_filters_by_id(global_copy_filter, gl_makeup_filer);\n    fm:connect_filters_by_id(gl_makeup_filer, face_filter);\n    fm:connect_filters_by_id(face_filter, tune_color_filter);\n    fm:connect_filters_by_id(tune_color_filter, engine_filter);\n    fm:connect_filters_by_id(engine_filter, lut_filter);\n\n    fm:connect_filter_to_camera(skin_filter);\n    fm:connect_filter_to_output(lut_filter);\n\nend\n\nfilter_pipeline()\n\n";
        this.hb = false;
        this.mCasePath = null;
        this.hi = new float[16];
        this.hk = false;
        this.hp = null;
        this.hr = false;
        this.hs = false;
        this.hv = false;
        this.hw = false;
        this.hx = false;
        com.baidu.ar.g.b.c("AbstractRenderer", "create start!!!");
        com.baidu.ar.libloader.b.as("EglCore2");
        this.mContext = context;
        this.f = bVar;
        this.hp = eGLContext;
        this.hc = new com.baidu.ar.arplay.core.engine.a(Looper.getMainLooper());
        this.hx = p.z(this.mContext);
        this.hc.setScreenOrientationLandscape(this.hx);
        this.hf = new com.baidu.ar.arplay.a.c(context);
        this.hg = com.baidu.ar.arplay.d.b.bp();
        this.gV = new HashMap<>();
        this.he = new a(context);
        this.gW = new com.baidu.ar.steploading.d(context);
        this.gW.b(this.f);
        this.gX = new com.baidu.ar.f.c(context);
        this.gX.b(this.f);
        this.gY = new com.baidu.ar.lua.a();
        this.gY.b(this.f);
        com.baidu.ar.statistic.p.b(this.f);
        Matrix.setIdentityM(this.hi, 0);
        this.ha = ARPEngine.getInstance();
        this.gZ = ARPFilter.getInstance();
        this.gZ.setContext(new SoftReference<>(context));
        this.gZ.setOnRenderStartedListener(this);
        this.gZ.setOnRenderFinishedListener(this);
        this.hu = new j(looper, bVar.fl(), this.gZ);
        com.baidu.ar.g.b.c("AbstractRenderer", "create end!!!");
    }

    private void J(String str) {
        if (this.hg != null) {
            this.hg.G(str);
            File file = new File(str, "res/webview");
            if (file.exists()) {
                File file2 = new File(this.mContext.getFilesDir(), "ar/res/webview");
                com.baidu.ar.g.i.b(file2);
                com.baidu.ar.g.i.a(file, file2, true);
            }
        }
    }

    private void a(final SurfaceTexture surfaceTexture, int i, int i2, int i3) {
        final int textureId = this.gZ.getTextureId(this.gZ.createTexture(i, i2, i3));
        surfaceTexture.setOnFrameAvailableListener(this);
        this.gZ.setInputTexture(i, textureId, i2, i3);
        try {
            surfaceTexture.detachFromGLContext();
        } catch (Exception e) {
            com.baidu.ar.g.b.l("AbstractRenderer", "attachInputSurface surfaceTexture.detachFromGLContext() fail!!!");
        }
        this.gZ.runSyncOnRenderContext(new Runnable() { // from class: com.baidu.ar.arrender.e.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    surfaceTexture.attachToGLContext(textureId);
                    e.this.hw = true;
                    surfaceTexture.updateTexImage();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
        surfaceTexture.setDefaultBufferSize(i2, i3);
        if (this.hq != null) {
            this.hq.onInputSurfaceTextureAttach(surfaceTexture);
        }
    }

    private void a(DuMixOutput duMixOutput) {
        if (duMixOutput.getOutputSurface() == null) {
            bM();
            this.gT = true;
        }
        Surface surface = null;
        if (duMixOutput.getOutputSurface() instanceof SurfaceHolder) {
            surface = ((SurfaceHolder) duMixOutput.getOutputSurface()).getSurface();
        } else if (duMixOutput.getOutputSurface() instanceof SurfaceTexture) {
            SurfaceTexture surfaceTexture = (SurfaceTexture) duMixOutput.getOutputSurface();
            surfaceTexture.setDefaultBufferSize(duMixOutput.getOutputWidth(), duMixOutput.getOutputHeight());
            surface = new Surface(surfaceTexture);
        } else if (duMixOutput.getOutputSurface() instanceof Surface) {
            surface = (Surface) duMixOutput.getOutputSurface();
        }
        if (surface == null) {
            com.baidu.ar.g.b.b("AbstractRenderer", "initOutputSurface outputSurface error!!!");
        }
        String addOutputSurface = this.gZ.addOutputSurface(surface, duMixOutput.getOutputWidth(), duMixOutput.getOutputHeight(), b.a(duMixOutput.getRotationType(), duMixOutput.getMirriorType()), b.a(duMixOutput.getScaleType()));
        this.gR = new o(duMixOutput);
        this.gR.setSurface(surface);
        this.gR.N(addOutputSurface);
        if (duMixOutput.isFitScreenAuto()) {
            bP();
        }
    }

    private void b(DuMixInput duMixInput) {
        if (duMixInput.getInputSurface() != null) {
            a(duMixInput.getInputSurface(), 36197, duMixInput.getInputWidth(), duMixInput.getInputHeight());
            return;
        }
        duMixInput.setInputSurface(c(36197, duMixInput.getInputWidth(), duMixInput.getInputHeight()));
        this.gS = true;
    }

    private void bL() {
        this.gZ.runLuaScriptStr(this.aF);
    }

    private void bM() {
        this.gZ.runSyncOnRenderContext(new Runnable() { // from class: com.baidu.ar.arrender.e.4
            @Override // java.lang.Runnable
            public void run() {
                int createTexture = (int) e.this.gZ.createTexture(3553, e.this.aa.getOutputWidth(), e.this.aa.getOutputHeight());
                com.baidu.ar.g.b.c("AbstractRenderer", "setup outputTextureId = " + createTexture);
                e.this.aa.setOutputSurface(new SurfaceTexture(createTexture));
            }
        });
    }

    private void bN() {
        if (this.gZ != null) {
            this.gZ.runSyncOnRenderContext(new Runnable() { // from class: com.baidu.ar.arrender.e.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (e.this.W == null || e.this.W.getInputSurface() == null) {
                            return;
                        }
                        e.this.hw = false;
                        e.this.W.getInputSurface().detachFromGLContext();
                    } catch (Exception e) {
                        com.baidu.ar.g.b.k("AbstractRenderer", "releaseInput() surfaceTexture.detachFromGLContext() fail!!!");
                    }
                }
            });
        }
        if (this.W != null && this.W.getInputSurface() != null) {
            this.W.getInputSurface().setOnFrameAvailableListener(null);
            if (this.gS) {
                this.W.getInputSurface().release();
            }
        }
        if (this.gZ == null || this.gU <= 0) {
            return;
        }
        this.gZ.destroyTexture(this.gU);
    }

    private void bO() {
        if (this.aa != null && this.aa.getOutputSurface() != null && this.gT) {
            ((SurfaceTexture) this.aa.getOutputSurface()).release();
        }
        if (this.gZ == null || this.gR == null) {
            return;
        }
        this.gZ.removeOutputTargetByAddr(this.gR.cb());
    }

    private void bP() {
        if (this.gZ == null || this.gR == null) {
            return;
        }
        if (p.z(this.mContext)) {
            this.gZ.updateOutputSurfaceRotation(this.gR.cb(), PixelRotation.RotateLeft);
        } else {
            this.gZ.updateOutputSurfaceRotation(this.gR.cb(), PixelRotation.NoRotation);
        }
    }

    private SurfaceTexture c(int i, int i2, int i3) {
        this.gU = this.gZ.createTexture(i, i2, i3);
        int textureId = this.gZ.getTextureId(this.gU);
        SurfaceTexture surfaceTexture = new SurfaceTexture(textureId);
        surfaceTexture.setDefaultBufferSize(i2, i3);
        surfaceTexture.setOnFrameAvailableListener(this);
        this.gZ.setInputTexture(i, textureId, i2, i3);
        this.hw = true;
        return surfaceTexture;
    }

    public void I(String str) {
        com.baidu.ar.g.b.c("AbstractRenderer", "createCase() casePath = " + str);
        if (this.he != null) {
            this.he.bt();
        }
        if (this.gW != null) {
            this.gW.switchCase(str);
        }
        if (this.gY != null) {
            this.gY.fk();
        }
        if (this.ha != null) {
            this.ha.loadCaseWithResPath(str);
            if (this.aa != null) {
                changeOutputSize(this.aa.getOutputWidth(), this.aa.getOutputHeight());
            }
        }
        this.mCasePath = str;
        J(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Size a(DuMixInput duMixInput) {
        if (duMixInput == null) {
            com.baidu.ar.g.b.b("AbstractRenderer", "getEngineInputSize duMixInput is null!!!");
            return null;
        } else if (this.ho == null || this.ho.getWidth() == 0 || this.ho.getHeight() == 0) {
            Size size = new Size(duMixInput.getInputHeight(), duMixInput.getInputWidth());
            if (duMixInput.isCameraInput()) {
                return size;
            }
            if (duMixInput.getRotationType() == RotationType.ROTATE_0 || duMixInput.getRotationType() == RotationType.ROTATE_180) {
                size.setWidth(duMixInput.getInputWidth());
                size.setHeight(duMixInput.getInputHeight());
                return size;
            }
            return size;
        } else {
            return this.ho;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Size a(Size size) {
        return p.z(this.mContext) ? b.b(size.getWidth(), size.getHeight(), this.aa.getOutputHeight(), this.aa.getOutputWidth()) : b.b(size.getWidth(), size.getHeight(), this.aa.getOutputWidth(), this.aa.getOutputHeight());
    }

    public void a(DuMixInput duMixInput, DuMixOutput duMixOutput) {
        com.baidu.ar.g.b.c("AbstractRenderer", "setup() start");
        if (duMixInput == null || duMixOutput == null || this.gZ == null) {
            return;
        }
        this.W = duMixInput;
        this.aa = duMixOutput;
        this.gZ.setUpEGLEnv(this.hp);
        this.gZ.setCameraFace(duMixInput.isFrontCamera());
        this.gZ.createInputSource(b.a(duMixInput.isFitCameraAuto(), duMixInput.getRotationType(), duMixInput.getMirriorType()), com.baidu.ar.arplay.core.engine.c.INTERNAL_OES_TEX);
        b(duMixInput);
        a(duMixOutput);
        this.gZ.connectCameraWithTarget();
        this.hk = duMixInput.isFrontCamera();
        if (this.aa.getOutputFPS() > 0) {
            this.ht = new g(this.aa.getOutputFPS());
        }
        if (this.hu != null) {
            this.hu.g(duMixOutput.getOutputWidth(), duMixOutput.getOutputHeight());
        }
        bJ();
        com.baidu.ar.g.b.c("AbstractRenderer", "setup() end");
    }

    public void a(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        if (this.gZ != null) {
            this.gZ.destroyPixelReaderByPreFilterID(pixelReadParams, pixelReadListener);
        }
    }

    public void a(PixelReadParams pixelReadParams, PixelRotation pixelRotation) {
        if (this.gZ != null) {
            b.a(this.mContext, this.hk, pixelReadParams);
            this.gZ.setPixelReaderRotation(pixelReadParams, pixelReadParams.getPixelRotate());
        }
    }

    public void a(JSONObject jSONObject) {
        if (this.ha == null || jSONObject == null) {
            return;
        }
        this.hm = jSONObject.toString();
        try {
            this.ha.setConfig("grading", this.hm);
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z) {
        if (this.C != null) {
            this.C.a(z);
        }
    }

    public void addOutputSurface(DuMixOutput duMixOutput) {
        if (duMixOutput == null || duMixOutput.getOutputSurface() == null || this.gZ == null || !(duMixOutput.getOutputSurface() instanceof Surface)) {
            com.baidu.ar.g.b.b("AbstractRenderer", "addOutputSurface duMixOutput is error!!!");
            return;
        }
        com.baidu.ar.g.b.c("AbstractRenderer", "addOutputSurface() surface = " + duMixOutput.getOutputSurface().hashCode() + " & width*height = " + duMixOutput.getOutputWidth() + "*" + duMixOutput.getOutputHeight() + " & rotation = " + duMixOutput.getRotationType() + " & mode = " + duMixOutput.getScaleType());
        String addOutputSurface = this.gZ.addOutputSurface((Surface) duMixOutput.getOutputSurface(), duMixOutput.getOutputWidth(), duMixOutput.getOutputHeight(), b.a(duMixOutput.getRotationType(), duMixOutput.getMirriorType()), b.a(duMixOutput.getScaleType()));
        o oVar = new o(duMixOutput);
        oVar.N(addOutputSurface);
        if (this.gV != null) {
            this.gV.put(duMixOutput, oVar);
        }
    }

    public void bD() {
        com.baidu.ar.g.b.c("AbstractRenderer", "destroyCase()");
        if (this.ha != null) {
            this.ha.unloadCase();
        }
        bL();
        this.gZ.purgeMemory();
        this.mCasePath = null;
        if (this.hg != null) {
            this.hg.G(null);
        }
        if (this.gX != null) {
            this.gX.reset();
        }
        if (this.hu != null) {
            this.hu.bV();
            this.hu.bW();
        }
    }

    public void bE() {
        com.baidu.ar.g.b.c("AbstractRenderer", "stopARPEngine()");
        if (this.ha != null && this.hb) {
            this.ha.destroyEngine();
            this.ha = null;
            this.hb = false;
        } else if (this.f != null) {
            this.f.handleMessage(7, 0, null);
        }
        this.he = null;
        if (this.hf != null) {
            this.hf.release();
        }
    }

    public void bF() {
        com.baidu.ar.g.b.c("AbstractRenderer", "startARPEngine()");
        if (this.ha == null) {
            this.ha = ARPEngine.getInstance();
        }
        if (this.hc != null) {
            this.hc.j(true);
        }
        if (this.ha != null && this.W != null && this.aa != null) {
            Size a = a(this.W);
            Size a2 = a(a);
            this.ha.createEngine(a.getWidth(), a.getHeight(), a2.getWidth(), a2.getHeight(), p.y(this.mContext));
        }
        if (this.ha != null && this.W != null && this.W.isCameraInput()) {
            this.ha.setIsFrontCamera(this.W.isFrontCamera());
        }
        if (this.ha != null) {
            this.ha.resume();
        }
        if (this.he != null) {
            this.he.bt();
        }
        try {
            if (this.hf != null) {
                this.hf.start();
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public boolean bG() {
        return this.hr;
    }

    public com.baidu.ar.steploading.d bH() {
        return this.gW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bJ() {
        this.hr = true;
        com.baidu.ar.libloader.b.as("AREngineCpp2");
        com.baidu.ar.libloader.b.a("AREngineCpp", new a.c() { // from class: com.baidu.ar.arrender.e.1
            @Override // com.baidu.ar.libloader.a.c
            public void onReady() {
                e.this.hr = false;
                if (e.this.hs) {
                    return;
                }
                e.this.bK();
            }
        });
    }

    protected void bK() {
        if (this.ha != null) {
            if (TextUtils.isEmpty(this.hm)) {
                try {
                    this.ha.setLocalDeviceGrade(this.hn);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else {
                try {
                    this.ha.setConfig("grading", this.hm);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
        bL();
        bF();
        a(this.hk);
    }

    public void cancelAysncRenderTask(Runnable runnable) {
        if (this.gZ == null || runnable == null) {
            return;
        }
        this.gZ.cancelAysncRenderTask(runnable);
    }

    public void changeInputSize(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.W == null || this.ha == null) {
            return;
        }
        bN();
        this.W.setInputWidth(i);
        this.W.setInputHeight(i2);
        if (surfaceTexture != null) {
            this.W.setInputSurface(surfaceTexture);
        }
        b(this.W);
        this.ha.setPreviewSize(i2, i);
        this.ha.setWindowSize(i2, i);
    }

    public void changeOutput(DuMixOutput duMixOutput) {
    }

    public void changeOutputSize(int i, int i2) {
        if (this.W == null || this.aa == null) {
            return;
        }
        if (this.aa.getOutputHeight() == i2 && this.aa.getOutputWidth() == i) {
            return;
        }
        com.baidu.ar.g.b.c("AbstractRenderer", "changeOutputSize() size = " + i + "x" + i2);
        Object outputSurface = this.aa.getOutputSurface();
        if (outputSurface instanceof SurfaceTexture) {
            ((SurfaceTexture) outputSurface).setDefaultBufferSize(i, i2);
        }
        this.aa.setOutputWidth(i);
        this.aa.setOutputHeight(i2);
        if (this.gZ != null && this.gR != null && !TextUtils.isEmpty(this.gR.cb())) {
            this.gZ.addOutputSurface(this.gR.getSurface(), i, i2);
        }
        if (this.ha != null) {
            Size a = a(a(this.W));
            this.ha.setWindowSize(a.getWidth(), a.getHeight());
        }
        if (this.hc != null) {
            this.hc.d(i, i2);
        }
        if (this.aa.isFitScreenAuto()) {
            bP();
        }
    }

    public void createPixelReader(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        if (this.gZ != null) {
            b.a(this.mContext, this.hk, pixelReadParams);
            this.gZ.createPixelReaderByPreFilterID(pixelReadParams, pixelReadListener);
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        if (this.gZ == null || this.hv) {
            return;
        }
        if (this.ht != null && !this.ht.bQ()) {
            this.gZ.runSyncOnRenderContext(new Runnable() { // from class: com.baidu.ar.arrender.e.2
                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.W == null || e.this.W.getInputSurface() == null) {
                        return;
                    }
                    e.this.W.getInputSurface().updateTexImage();
                }
            });
        } else if (this.hw) {
            StatisticApi.getPerformanceApi().onFrameIn();
            this.gZ.render(surfaceTexture.getTimestamp());
            StatisticApi.getPerformanceApi().onFrameOut();
        }
    }

    public void onRenderFinished(long j) {
        if (this.mOnRenderFinishedListener != null) {
            this.mOnRenderFinishedListener.onRenderFinished(j);
        }
    }

    public void onRenderStarted(long j) {
        if (this.mOnRenderStartedListener != null) {
            this.mOnRenderStartedListener.onRenderStarted(j);
        }
        if (this.W == null || this.W.getInputSurface() == null || !this.W.isCameraInput() || this.gZ == null) {
            return;
        }
        this.W.getInputSurface().updateTexImage();
        this.W.getInputSurface().getTransformMatrix(this.hi);
        if (this.hj == null) {
            this.hj = new float[16];
            System.arraycopy(this.hi, 0, this.hj, 0, this.hi.length);
        }
        if (!Arrays.equals(this.hi, this.hj)) {
            this.hk = !this.hk;
            System.arraycopy(this.hi, 0, this.hj, 0, this.hi.length);
        }
        if (this.hl == null) {
            this.hl = new float[16];
            b.a(this.mContext, this.hl, this.hk);
            this.gZ.setInputMatrix(this.hl);
        }
        if (this.W.isFrontCamera() != this.hk) {
            b.a(this.mContext, this.hl, this.hk);
            this.gZ.setInputMatrix(this.hl);
            a(this.hk);
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.hc == null || view == null) {
            return false;
        }
        if (this.hd == null || this.hd.get() == null || !view.equals(this.hd.get())) {
            this.hd = new WeakReference<>(view);
            this.hc.d(view.getWidth(), view.getHeight());
        }
        this.hc.onTouchEvent(motionEvent);
        return true;
    }

    public void pause() {
        com.baidu.ar.g.b.c("AbstractRenderer", "pause()");
        if (this.hf != null) {
            this.hf.release();
        }
        if (this.hc != null) {
            this.hc.onPause();
        }
        if (this.ha != null) {
            this.ha.pause();
        }
        if (this.gZ != null) {
            this.gZ.pause();
        }
    }

    public void q(boolean z) {
        this.hb = z;
    }

    public void r(boolean z) {
        if (z) {
            this.ho = b.a(this.aa.getOutputWidth(), this.aa.getOutputHeight(), this.W.getInputHeight(), this.W.getInputWidth());
            this.ha.setPreviewSize(this.ho.getWidth(), this.ho.getHeight());
            this.ha.setWindowSize(this.aa.getOutputWidth(), this.aa.getOutputHeight());
            return;
        }
        this.ho = null;
        Size a = a(this.W);
        Size a2 = a(a);
        this.ha.setPreviewSize(a.getWidth(), a.getHeight());
        this.ha.setWindowSize(a2.getWidth(), a2.getHeight());
    }

    public void release() {
        com.baidu.ar.g.b.c("AbstractRenderer", "release() start!!!");
        this.hv = true;
        pause();
        if (this.hg != null) {
            this.hg.release();
            this.hg = null;
        }
        if (this.hd != null) {
            this.hd.clear();
            this.hd = null;
        }
        this.hc = null;
        com.baidu.ar.statistic.p.c(this.f);
        bE();
        this.mOnRenderStartedListener = null;
        this.mOnRenderFinishedListener = null;
        this.C = null;
        this.hq = null;
        this.hi = null;
        this.hl = null;
        bN();
        this.W = null;
        bO();
        this.aa = null;
        this.gR = null;
        if (this.gZ != null) {
            this.gZ.destroy();
            this.gZ = null;
        }
        ARPFilter.releaseInstance();
        this.ht = null;
        if (this.hu != null) {
            this.hu.release();
            this.hu = null;
        }
        if (this.gV != null) {
            this.gV.clear();
            this.gV = null;
        }
        if (this.gW != null) {
            this.gW.release();
            this.gW = null;
        }
        if (this.gX != null) {
            this.gX.release();
            this.gX = null;
        }
        if (this.gY != null) {
            this.gY.release();
            this.gY = null;
        }
        this.mContext = null;
        this.hp = null;
        com.baidu.ar.g.b.c("AbstractRenderer", "release() end!!!");
    }

    public void removeOutputSurface(DuMixOutput duMixOutput) {
        if (duMixOutput == null || duMixOutput.getOutputSurface() == null || !(duMixOutput.getOutputSurface() instanceof Surface)) {
            com.baidu.ar.g.b.b("AbstractRenderer", "removeOutputSurface duMixOutput is error!!!");
        } else if (this.gV != null) {
            com.baidu.ar.g.b.c("AbstractRenderer", "removeOutputSurface() surface = " + duMixOutput.getOutputSurface().hashCode());
            o remove = this.gV.remove(duMixOutput);
            if (this.gZ == null || remove == null || TextUtils.isEmpty(remove.cb())) {
                return;
            }
            this.gZ.removeOutputTargetByAddr(remove.cb());
        }
    }

    public void resume() {
        com.baidu.ar.g.b.c("AbstractRenderer", "resume()");
        if (this.hc != null) {
            this.hc.onResume();
        }
        try {
            if (this.hf != null) {
                this.hf.start();
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        if (this.ha != null && !this.hh) {
            this.ha.resume();
        }
        if (this.gZ != null) {
            this.gZ.resume();
        }
    }

    public void runAsyncOnRenderContext(Runnable runnable) {
        if (this.gZ == null || runnable == null) {
            return;
        }
        this.gZ.runAsyncOnRenderContext(runnable);
    }

    public void runSyncOnRenderContext(Runnable runnable) {
        if (this.gZ == null || runnable == null) {
            return;
        }
        this.gZ.runSyncOnRenderContext(runnable);
    }

    public void s(boolean z) {
        this.hs = z;
    }

    public void setCameraSwitchListener(f fVar) {
        this.C = fVar;
    }

    public void setDefaultPipeLine(String str) {
        if (TextUtils.isEmpty(str)) {
            this.aF = "filter_pipeline = function()\n\n    fm = ae.FilterManager:get_instance();\n\n    global_copy_filter = fm:create_filter(\"Tex2DFilter\", \"globalTex2DFilter\", true);\n    gl_makeup_filer = fm:create_filter(\"BeautyMakeupFilter\",\"globalBeautyMakeupFilter\",true);\n\n    skin_filter = fm:create_filter(\"SkinFilter\", \"globalSkinFilter\", true);\n    engine_filter = fm:create_filter(\"EngineFilter\", \"globalEngineFilter\", true);\n    fm:update_property_int(engine_filter, \"is_enable\", 0);\n    face_filter = fm:create_filter(\"FaceFilter\", \"globalFaceFilter\", true);\n    lut_filter = fm:create_filter(\"LUTFilter\", \"globalLutFilter\", true);\n    tune_color_filter = fm:create_filter(\"TuneColorFilter\", \"globalTuneColorFilter\", true);\n    fm:reset_pipeline();\n\n    fm:connect_filters_by_id(skin_filter, gl_makeup_filer);\n    fm:connect_filters_by_id(skin_filter, global_copy_filter);\n    fm:connect_filters_by_id(global_copy_filter, gl_makeup_filer);\n    fm:connect_filters_by_id(gl_makeup_filer, face_filter);\n    fm:connect_filters_by_id(face_filter, tune_color_filter);\n    fm:connect_filters_by_id(tune_color_filter, engine_filter);\n    fm:connect_filters_by_id(engine_filter, lut_filter);\n\n    fm:connect_filter_to_camera(skin_filter);\n    fm:connect_filter_to_output(lut_filter);\n\nend\n\nfilter_pipeline()\n\n";
        } else {
            this.aF = str;
        }
    }

    public void setLocalDeviceGrade(int i) {
        this.hn = i;
        if (this.ha != null) {
            try {
                this.ha.setLocalDeviceGrade(i);
            } catch (Throwable th) {
            }
        }
    }

    public void setRenderFinishedListener(OnRenderFinishedListener onRenderFinishedListener) {
        this.mOnRenderFinishedListener = onRenderFinishedListener;
    }

    public void setRenderStartedListener(OnRenderStartedListener onRenderStartedListener) {
        this.mOnRenderStartedListener = onRenderStartedListener;
    }

    public void setStateListener(DuMixStateListener duMixStateListener) {
        this.hq = duMixStateListener;
    }
}
