package com.baidu.ar.arrender;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.ar.DuMixInput;
import com.baidu.ar.DuMixOutput;
import com.baidu.ar.DuMixStateListener;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.arplay.core.engine.ARPEngineParams;
import com.baidu.ar.arplay.core.pixel.PixelReadListener;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelRotation;
import com.baidu.ar.bean.RotationType;
import com.baidu.ar.bean.Size;
import com.baidu.ar.libloader.ILibLoader;
import com.baidu.mobstat.Config;
import java.io.File;
import java.lang.ref.SoftReference;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public abstract class f implements SurfaceTexture.OnFrameAvailableListener {
    DuMixInput V;
    DuMixOutput W;
    String aL;
    com.baidu.ar.lua.b f;
    com.baidu.ar.arplay.a.c hA;
    com.baidu.ar.arplay.d.b hB;
    boolean hC;
    private String hD;
    private int hE;
    private Size hF;
    protected EGLContext hG;
    DuMixStateListener hH;
    private p ht;
    ARPEngine hx;
    a hz;
    Context mContext;
    private boolean hu = false;
    private boolean hv = false;
    private long hw = 0;
    String aG = "filter_pipeline = function()\n\n    fm = ae.FilterManager:get_instance();\n\n    global_copy_filter = fm:create_filter(\"Tex2DFilter\", \"globalTex2DFilter\", true);\n    gl_makeup_filer = fm:create_filter(\"BeautyMakeupFilter\",\"globalBeautyMakeupFilter\",true);\n\n    skin_filter = fm:create_filter(\"SkinFilter\", \"globalSkinFilter\", true);\n    engine_filter = fm:create_filter(\"EngineFilter\", \"globalEngineFilter\", true);\n    fm:update_property_int(engine_filter, \"is_enable\", 0);\n    face_filter = fm:create_filter(\"FaceFilter\", \"globalFaceFilter\", true);\n    lut_filter = fm:create_filter(\"LUTFilter\", \"globalLutFilter\", true);\n    tune_color_filter = fm:create_filter(\"TuneColorFilter\", \"globalTuneColorFilter\", true);\n    fm:reset_pipeline();\n\n    fm:connect_filters_by_id(skin_filter, gl_makeup_filer);\n    fm:connect_filters_by_id(skin_filter, global_copy_filter);\n    fm:connect_filters_by_id(global_copy_filter, gl_makeup_filer);\n    fm:connect_filters_by_id(gl_makeup_filer, face_filter);\n    fm:connect_filters_by_id(face_filter, tune_color_filter);\n    fm:connect_filters_by_id(tune_color_filter, engine_filter);\n    fm:connect_filters_by_id(engine_filter, lut_filter);\n\n    fm:connect_filter_to_camera(skin_filter);\n    fm:connect_filter_to_output(lut_filter);\n\nend\n\nfilter_pipeline()\n\n";
    volatile boolean hy = false;
    String mCasePath = null;
    private boolean hI = false;
    protected boolean hJ = false;
    volatile boolean hK = false;
    volatile boolean hL = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Context context, com.baidu.ar.lua.b bVar, EGLContext eGLContext, String str) {
        this.aL = null;
        this.hG = null;
        com.baidu.ar.h.b.c("AbstractRenderer", "create start!!!");
        com.baidu.ar.libloader.a.require("c++_shared");
        com.baidu.ar.libloader.a.require("opencv_java3");
        com.baidu.ar.libloader.a.require("EglCore2");
        this.mContext = context;
        this.f = bVar;
        this.hG = eGLContext;
        this.hA = new com.baidu.ar.arplay.a.c(context);
        this.hB = com.baidu.ar.arplay.d.b.bm();
        this.hz = new a(context);
        com.baidu.ar.statistic.p.b(this.f);
        this.aL = str;
        this.hx = ARPEngine.getInstance();
        this.hx.setContext(new SoftReference<>(context));
        com.baidu.ar.h.b.c("AbstractRenderer", "create end!!!");
    }

    private void M(String str) {
        if (this.hB != null) {
            this.hB.J(str);
            File file = new File(str, "res/webview");
            if (file.exists()) {
                File file2 = new File(this.mContext.getFilesDir(), "ar/res/webview");
                com.baidu.ar.h.i.b(file2);
                com.baidu.ar.h.i.a(file, file2, true);
            }
        }
    }

    private void a(final SurfaceTexture surfaceTexture, int i, int i2, int i3) {
        final int textureId = this.hx.getARPRenderer().getTextureId(this.hx.getARPRenderer().createTexture(i, i2, i3));
        surfaceTexture.setOnFrameAvailableListener(this);
        this.hx.getARPRenderer().setInputTexture(i, textureId, i2, i3);
        try {
            surfaceTexture.detachFromGLContext();
        } catch (Exception e) {
            com.baidu.ar.h.b.l("AbstractRenderer", "attachInputSurface surfaceTexture.detachFromGLContext() fail!!!");
        }
        this.hx.getARPRenderer().runSyncOnRenderContext(new Runnable() { // from class: com.baidu.ar.arrender.f.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    surfaceTexture.attachToGLContext(textureId);
                    f.this.hL = true;
                    surfaceTexture.updateTexImage();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
        surfaceTexture.setDefaultBufferSize(i2, i3);
        if (this.hH != null) {
            this.hH.onInputSurfaceTextureAttach(surfaceTexture);
        }
    }

    private Surface b(DuMixOutput duMixOutput, Object obj) {
        Object outputSurface = duMixOutput.getOutputSurface();
        if (obj != null) {
            outputSurface = obj;
        }
        if (outputSurface == null) {
            bH();
            this.hv = true;
        }
        Surface surface = null;
        if (outputSurface instanceof SurfaceHolder) {
            surface = ((SurfaceHolder) outputSurface).getSurface();
            duMixOutput.setOutputSurface((SurfaceHolder) outputSurface);
        } else if (outputSurface instanceof SurfaceTexture) {
            SurfaceTexture surfaceTexture = (SurfaceTexture) outputSurface;
            surfaceTexture.setDefaultBufferSize(duMixOutput.getOutputWidth(), duMixOutput.getOutputHeight());
            Surface surface2 = new Surface(surfaceTexture);
            duMixOutput.setOutputSurface((SurfaceTexture) outputSurface);
            surface = surface2;
        } else if (outputSurface instanceof Surface) {
            surface = (Surface) outputSurface;
            duMixOutput.setOutputSurface((Surface) outputSurface);
        }
        if (surface == null) {
            com.baidu.ar.h.b.b("AbstractRenderer", "initOutputSurface outputSurface error!!!");
        }
        return surface;
    }

    private void b(DuMixInput duMixInput) {
        this.hx.getARPRenderer().setUpEGLEnv(this.hG);
        this.hx.getARPRenderer().setCameraFace(duMixInput.isFrontCamera());
        PixelRotation a2 = b.a(duMixInput.isFitCameraAuto(), duMixInput.getRotationType(), duMixInput.getMirriorType());
        com.baidu.ar.arplay.core.engine.e eVar = com.baidu.ar.arplay.core.engine.e.INTERNAL_2D_TEX;
        if ((duMixInput.getInputTexture() != null && duMixInput.getInputTexture().getType() == 36197) || (duMixInput.getInputSurface() != null && duMixInput.isCameraInput())) {
            eVar = com.baidu.ar.arplay.core.engine.e.INTERNAL_OES_TEX;
        }
        if (duMixInput.isSyncInputContent()) {
            this.hx.getARPRenderer().createSyncInputSource(a2, eVar);
        } else {
            this.hx.getARPRenderer().createInputSource(a2, eVar);
        }
        Size a3 = a(this.V);
        this.hx.setPreviewSize(a3.getWidth(), a3.getHeight());
    }

    private void bH() {
        this.hx.getARPRenderer().runSyncOnRenderContext(new Runnable() { // from class: com.baidu.ar.arrender.f.2
            @Override // java.lang.Runnable
            public void run() {
                int createTexture = (int) f.this.hx.getARPRenderer().createTexture(3553, f.this.W.getOutputWidth(), f.this.W.getOutputHeight());
                com.baidu.ar.h.b.c("AbstractRenderer", "setup outputTextureId = " + createTexture);
                f.this.W.setOutputSurface(new SurfaceTexture(createTexture));
            }
        });
    }

    private void bK() {
        this.hx.getARPRenderer().connectCameraWithTarget();
    }

    private void bL() {
        this.hx.getARPRenderer().runLuaScriptStr(this.aG);
    }

    private void bM() {
        if (this.hx != null && this.hx.getARPRenderer() != null) {
            this.hx.getARPRenderer().runSyncOnRenderContext(new Runnable() { // from class: com.baidu.ar.arrender.f.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (f.this.V == null || f.this.V.getInputSurface() == null) {
                            return;
                        }
                        f.this.hL = false;
                        f.this.V.getInputSurface().detachFromGLContext();
                    } catch (Exception e) {
                        com.baidu.ar.h.b.k("AbstractRenderer", "releaseInput() surfaceTexture.detachFromGLContext() fail!!!");
                    }
                }
            });
        }
        if (this.V != null && this.V.getInputSurface() != null) {
            this.V.getInputSurface().setOnFrameAvailableListener(null);
            if (this.hu) {
                this.V.getInputSurface().release();
            }
        }
        if (this.hx == null || this.hx.getARPRenderer() == null || this.hw <= 0) {
            return;
        }
        this.hx.getARPRenderer().destroyTexture(this.hw);
    }

    private void bN() {
        if (this.W != null && this.W.getOutputSurface() != null && this.hv) {
            ((SurfaceTexture) this.W.getOutputSurface()).release();
        }
        if (this.hx == null || this.hx.getARPRenderer() == null || this.ht == null) {
            return;
        }
        this.hx.getARPRenderer().removeOutputTargetByAddr(this.ht.ca());
    }

    private void bO() {
        if (this.hx == null || this.hx.getARPRenderer() == null || this.ht == null) {
            return;
        }
        if (com.baidu.ar.h.p.A(this.mContext)) {
            this.hx.getARPRenderer().updateOutputSurfaceRotation(this.ht.ca(), PixelRotation.RotateLeft);
        } else {
            this.hx.getARPRenderer().updateOutputSurfaceRotation(this.ht.ca(), PixelRotation.NoRotation);
        }
    }

    private SurfaceTexture c(int i, int i2, int i3) {
        this.hw = this.hx.getARPRenderer().createTexture(i, i2, i3);
        int textureId = this.hx.getARPRenderer().getTextureId(this.hw);
        SurfaceTexture surfaceTexture = new SurfaceTexture(textureId);
        surfaceTexture.setDefaultBufferSize(i2, i3);
        surfaceTexture.setOnFrameAvailableListener(this);
        this.hx.getARPRenderer().setInputTexture(i, textureId, i2, i3);
        this.hL = true;
        return surfaceTexture;
    }

    public void L(String str) {
        com.baidu.ar.h.b.c("AbstractRenderer", "createCase() casePath = " + str);
        if (this.hz != null) {
            this.hz.bq();
        }
        if (this.hx != null) {
            this.hx.loadCaseWithResPath(str);
            if (this.W != null) {
                changeOutputSize(this.W.getOutputWidth(), this.W.getOutputHeight());
            }
        }
        this.mCasePath = str;
        M(str);
    }

    protected Size a(DuMixInput duMixInput) {
        if (duMixInput == null) {
            com.baidu.ar.h.b.b("AbstractRenderer", "getEngineInputSize duMixInput is null!!!");
            return null;
        } else if (this.hF == null || this.hF.getWidth() == 0 || this.hF.getHeight() == 0) {
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
            return this.hF;
        }
    }

    protected Size a(Size size, DuMixOutput duMixOutput) {
        return com.baidu.ar.h.p.A(this.mContext) ? b.b(size.getWidth(), size.getHeight(), duMixOutput.getOutputHeight(), duMixOutput.getOutputWidth()) : b.b(size.getWidth(), size.getHeight(), duMixOutput.getOutputWidth(), duMixOutput.getOutputHeight());
    }

    public void a(DuMixInput duMixInput, DuMixOutput duMixOutput) {
        com.baidu.ar.h.b.c("AbstractRenderer", "setup() start");
        if (duMixInput == null || duMixOutput == null || this.hx == null || this.hx.getARPRenderer() == null) {
            return;
        }
        this.V = duMixInput;
        this.W = duMixOutput;
        b(duMixInput);
        c(duMixInput);
        a(duMixOutput, (Object) null);
        bF();
        bK();
        bI();
        com.baidu.ar.h.b.c("AbstractRenderer", "setup() end");
    }

    void a(DuMixOutput duMixOutput, Object obj) {
        Surface b2;
        String addOutputSurface;
        if (duMixOutput.getOutputTexture() == null || duMixOutput.getOutputTexture().getId() == -1) {
            b2 = b(duMixOutput, obj);
            addOutputSurface = this.hx.getARPRenderer().addOutputSurface(b2, duMixOutput.getOutputWidth(), duMixOutput.getOutputHeight(), b.a(duMixOutput.getRotationType(), duMixOutput.getMirriorType()), b.a(duMixOutput.getScaleType()));
        } else {
            addOutputSurface = this.hx.getARPRenderer().addOutputTarget(duMixOutput.getOutputTexture().getType(), duMixOutput.getOutputTexture().getId(), duMixOutput.getOutputWidth(), duMixOutput.getOutputHeight(), b.a(this.W.getRotationType(), this.W.getMirriorType()));
            b2 = null;
        }
        this.ht = new p(duMixOutput);
        this.ht.setSurface(b2);
        this.ht.Q(addOutputSurface);
        if (duMixOutput.isFitScreenAuto()) {
            bO();
        }
        Size a2 = a(a(this.V), this.W);
        this.hx.setWindowSize(a2.getWidth(), a2.getHeight());
    }

    public void a(Object obj, int i, int i2) {
        if (this.V == null || this.hx == null) {
            return;
        }
        bM();
        this.V.setInputWidth(i);
        this.V.setInputHeight(i2);
        if (obj != null && (obj instanceof SurfaceTexture)) {
            this.V.setInputSurface((SurfaceTexture) obj);
        }
        c(this.V);
    }

    public void a(JSONObject jSONObject) {
        if (this.hx == null || jSONObject == null) {
            return;
        }
        this.hD = jSONObject.toString();
        try {
            this.hx.setConfig("grading", this.hD);
        } catch (Throwable th) {
        }
    }

    public void b(Object obj, int i, int i2) {
        if (obj == null || i <= 0 || i2 <= 0 || this.W == null || !this.hy) {
            com.baidu.ar.h.b.b("AbstractRenderer", "changeOutputSurface error!!!");
            return;
        }
        bN();
        if (obj instanceof SurfaceTexture) {
            this.W.setOutputSurface((SurfaceTexture) obj);
        } else if (obj instanceof SurfaceHolder) {
            this.W.setOutputSurface((SurfaceHolder) obj);
        } else if (!(obj instanceof Surface)) {
            com.baidu.ar.h.b.b("AbstractRenderer", "changeOutputSurface error!!! As outputSurface is not a surface!!!");
            return;
        } else {
            this.W.setOutputSurface((Surface) obj);
        }
        this.W.setOutputWidth(i);
        this.W.setOutputHeight(i2);
        a(this.W, obj);
    }

    public void bB() {
        com.baidu.ar.h.b.c("AbstractRenderer", "destroyCase()");
        if (this.hx != null) {
            this.hx.unloadCase();
        }
        bL();
        if (this.hx != null && this.hx.getARPRenderer() != null) {
            this.hx.getARPRenderer().purgeMemory();
        }
        this.mCasePath = null;
        if (this.hB != null) {
            this.hB.J(null);
        }
    }

    public void bC() {
        com.baidu.ar.h.b.c("AbstractRenderer", "startARPEngine()");
        if (this.hx == null) {
            this.hx = ARPEngine.getInstance();
        }
        if (this.hx != null && this.V != null && this.W != null) {
            Size a2 = a(this.V);
            Size a3 = a(a2, this.W);
            ARPEngineParams aRPEngineParams = new ARPEngineParams();
            aRPEngineParams.setInputWidth(a2.getWidth());
            aRPEngineParams.setInputHeight(a2.getHeight());
            aRPEngineParams.setOutputWidth(a3.getWidth());
            aRPEngineParams.setOutputHeight(a3.getHeight());
            aRPEngineParams.setDensity(com.baidu.ar.h.p.z(this.mContext));
            if (this.V.isCameraInput()) {
                aRPEngineParams.setIsFrontCamera(this.V.isFrontCamera());
            }
            aRPEngineParams.setShaderDBPath(this.aL);
            this.hx.createEngine(aRPEngineParams);
        }
        if (this.hx != null) {
            this.hx.resume();
        }
        if (this.hz != null) {
            this.hz.bq();
        }
        try {
            if (this.hA != null) {
                this.hA.start();
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public void bD() {
        com.baidu.ar.h.b.c("AbstractRenderer", "stopARPEngine()");
        if (this.hx != null && this.hy) {
            this.hx.destroyEngine();
            this.hy = false;
        } else if (this.f != null) {
            this.f.handleMessage(7, 0, null);
        }
        this.hz = null;
        if (this.hA != null) {
            this.hA.release();
        }
    }

    public boolean bE() {
        return this.hI;
    }

    abstract void bF();

    void bI() {
        this.hI = true;
        com.baidu.ar.libloader.a.require("AREngineCpp2");
        com.baidu.ar.libloader.a.setLibReadyListener("AREngineCpp", new ILibLoader.c() { // from class: com.baidu.ar.arrender.f.3
            @Override // com.baidu.ar.libloader.ILibLoader.c
            public void onReady() {
                f.this.hI = false;
                if (f.this.hJ) {
                    return;
                }
                f.this.bJ();
            }
        });
    }

    void bJ() {
        if (this.hx != null) {
            if (TextUtils.isEmpty(this.hD)) {
                try {
                    this.hx.setLocalDeviceGrade(this.hE);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else {
                try {
                    this.hx.setConfig("grading", this.hD);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
        bL();
        bC();
    }

    void c(DuMixInput duMixInput) {
        if (duMixInput.getInputTexture() != null) {
            if (duMixInput.getInputTexture().getId() == -1) {
                long createTexture = this.hx.getARPRenderer().createTexture(duMixInput.getInputTexture().getType(), duMixInput.getInputWidth(), duMixInput.getInputHeight());
                duMixInput.getInputTexture().setHandle(createTexture);
                duMixInput.getInputTexture().setId(this.hx.getARPRenderer().getTextureId(createTexture));
            }
            this.hx.getARPRenderer().setInputTexture(duMixInput.getInputTexture().getType(), duMixInput.getInputTexture().getId(), duMixInput.getInputWidth(), duMixInput.getInputHeight());
            return;
        }
        int i = duMixInput.isCameraInput() ? 36197 : 3553;
        if (duMixInput.getInputSurface() != null) {
            a(duMixInput.getInputSurface(), i, duMixInput.getInputWidth(), duMixInput.getInputHeight());
            return;
        }
        duMixInput.setInputSurface(c(i, duMixInput.getInputWidth(), duMixInput.getInputHeight()));
        this.hu = true;
    }

    public void changeOutput(DuMixOutput duMixOutput) {
        bN();
        this.W = duMixOutput;
        a(duMixOutput, (Object) null);
    }

    public void changeOutputSize(int i, int i2) {
        if (this.V == null || this.W == null) {
            return;
        }
        if (this.W.getOutputHeight() == i2 && this.W.getOutputWidth() == i) {
            return;
        }
        com.baidu.ar.h.b.c("AbstractRenderer", "changeOutputSize() size = " + i + Config.EVENT_HEAT_X + i2);
        Object outputSurface = this.W.getOutputSurface();
        if (outputSurface instanceof SurfaceTexture) {
            ((SurfaceTexture) outputSurface).setDefaultBufferSize(i, i2);
        }
        this.W.setOutputWidth(i);
        this.W.setOutputHeight(i2);
        if (this.hx != null && this.hx.getARPRenderer() != null && this.ht != null && !TextUtils.isEmpty(this.ht.ca())) {
            this.hx.getARPRenderer().addOutputSurface(this.ht.getSurface(), i, i2);
        }
        if (this.hx != null) {
            Size a2 = a(a(this.V), this.W);
            this.hx.setWindowSize(a2.getWidth(), a2.getHeight());
        }
        if (this.W.isFitScreenAuto()) {
            bO();
        }
    }

    public void createPixelReader(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        if (!this.hy || this.hx == null || this.hx.getARPRenderer() == null) {
            return;
        }
        b.a(this.mContext, this.V.isFrontCamera(), pixelReadParams);
        this.hx.getARPRenderer().createPixelReaderByPreFilterID(pixelReadParams, pixelReadListener);
    }

    public void destroyPixelReader(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        if (!this.hy || this.hx == null || this.hx.getARPRenderer() == null) {
            return;
        }
        this.hx.getARPRenderer().destroyPixelReaderByPreFilterID(pixelReadParams, pixelReadListener);
    }

    public void o(boolean z) {
        this.hy = z;
    }

    public void p(boolean z) {
        if (z) {
            this.hF = b.a(this.W.getOutputWidth(), this.W.getOutputHeight(), this.V.getInputHeight(), this.V.getInputWidth());
            this.hx.setPreviewSize(this.hF.getWidth(), this.hF.getHeight());
            this.hx.setWindowSize(this.W.getOutputWidth(), this.W.getOutputHeight());
            return;
        }
        this.hF = null;
        Size a2 = a(this.V);
        Size a3 = a(a2, this.W);
        this.hx.setPreviewSize(a2.getWidth(), a2.getHeight());
        this.hx.setWindowSize(a3.getWidth(), a3.getHeight());
    }

    public void pause() {
        com.baidu.ar.h.b.c("AbstractRenderer", "pause()");
        if (this.hA != null) {
            this.hA.release();
        }
        if (this.hx != null) {
            this.hx.pause();
        }
    }

    public void q(boolean z) {
        this.hJ = z;
    }

    public void release() {
        com.baidu.ar.h.b.c("AbstractRenderer", "release() start!!!");
        this.hK = true;
        pause();
        if (this.hB != null) {
            this.hB.release();
            this.hB = null;
        }
        com.baidu.ar.statistic.p.c(this.f);
        bD();
        this.hH = null;
        bM();
        this.V = null;
        bN();
        this.W = null;
        this.ht = null;
        if (this.hx != null) {
            this.hx.destroy();
            this.hx = null;
        }
        ARPEngine.releaseInstance();
        this.mContext = null;
        this.hG = null;
        com.baidu.ar.h.b.c("AbstractRenderer", "release() end!!!");
    }

    public void resume() {
        com.baidu.ar.h.b.c("AbstractRenderer", "resume()");
        try {
            this.hA.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.hx != null) {
            this.hx.resume();
        }
    }

    public void setLocalDeviceGrade(int i) {
        this.hE = i;
        if (this.hx != null) {
            try {
                this.hx.setLocalDeviceGrade(i);
            } catch (Throwable th) {
            }
        }
    }

    public void updatePixelReader(PixelReadParams pixelReadParams, PixelRotation pixelRotation) {
        if (!this.hy || this.hx == null || this.hx.getARPRenderer() == null) {
            return;
        }
        pixelReadParams.setPixelRotate(pixelRotation);
        b.a(this.mContext, this.V.isFrontCamera(), pixelReadParams);
        this.hx.getARPRenderer().setPixelReaderRotation(pixelReadParams, pixelReadParams.getPixelRotate());
    }
}
