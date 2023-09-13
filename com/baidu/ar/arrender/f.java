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
import com.baidu.ar.arplay.core.renderer.IARPRenderer;
import com.baidu.ar.bean.RotationType;
import com.baidu.ar.bean.Size;
import com.baidu.ar.libloader.ILibLoader;
import com.baidu.cyberplayer.sdk.CyberRender;
import com.baidu.storage.swankv.SwanKV;
import java.io.File;
import java.lang.ref.SoftReference;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class f implements SurfaceTexture.OnFrameAvailableListener {
    public DuMixInput V;
    public DuMixOutput W;
    public String aL;
    public com.baidu.ar.lua.b f;
    public com.baidu.ar.arplay.a.c hA;
    public com.baidu.ar.arplay.d.b hB;
    public boolean hC;
    public String hD;
    public int hE;
    public Size hF;
    public EGLContext hG;
    public DuMixStateListener hH;
    public p ht;
    public ARPEngine hx;
    public a hz;
    public Context mContext;
    public boolean hu = false;
    public boolean hv = false;
    public long hw = 0;
    public String aG = "filter_pipeline = function()\n\n    fm = ae.FilterManager:get_instance();\n\n    global_copy_filter = fm:create_filter(\"Tex2DFilter\", \"globalTex2DFilter\", true);\n    gl_makeup_filer = fm:create_filter(\"BeautyMakeupFilter\",\"globalBeautyMakeupFilter\",true);\n\n    skin_filter = fm:create_filter(\"SkinFilter\", \"globalSkinFilter\", true);\n    engine_filter = fm:create_filter(\"EngineFilter\", \"globalEngineFilter\", true);\n    fm:update_property_int(engine_filter, \"is_enable\", 0);\n    face_filter = fm:create_filter(\"FaceFilter\", \"globalFaceFilter\", true);\n    lut_filter = fm:create_filter(\"LUTFilter\", \"globalLutFilter\", true);\n    tune_color_filter = fm:create_filter(\"TuneColorFilter\", \"globalTuneColorFilter\", true);\n    fm:reset_pipeline();\n\n    fm:connect_filters_by_id(skin_filter, gl_makeup_filer);\n    fm:connect_filters_by_id(skin_filter, global_copy_filter);\n    fm:connect_filters_by_id(global_copy_filter, gl_makeup_filer);\n    fm:connect_filters_by_id(gl_makeup_filer, face_filter);\n    fm:connect_filters_by_id(face_filter, tune_color_filter);\n    fm:connect_filters_by_id(tune_color_filter, engine_filter);\n    fm:connect_filters_by_id(engine_filter, lut_filter);\n\n    fm:connect_filter_to_camera(skin_filter);\n    fm:connect_filter_to_output(lut_filter);\n\nend\n\nfilter_pipeline()\n\n";
    public volatile boolean hy = false;
    public String mCasePath = null;
    public boolean hI = false;
    public boolean hJ = false;
    public volatile boolean hK = false;
    public volatile boolean hL = false;

    public f(Context context, com.baidu.ar.lua.b bVar, EGLContext eGLContext, String str) {
        this.aL = null;
        this.hG = null;
        com.baidu.ar.h.b.c("AbstractRenderer", "create start!!!");
        com.baidu.ar.libloader.a.require(SwanKV.LIB_CPP_SHARED);
        com.baidu.ar.libloader.a.require("opencv_java3");
        com.baidu.ar.libloader.a.require("EglCore");
        this.mContext = context;
        this.f = bVar;
        this.hG = eGLContext;
        this.hA = new com.baidu.ar.arplay.a.c(context);
        this.hB = com.baidu.ar.arplay.d.b.bm();
        this.hz = new a(context);
        com.baidu.ar.statistic.p.b(this.f);
        this.aL = str;
        ARPEngine aRPEngine = ARPEngine.getInstance();
        this.hx = aRPEngine;
        aRPEngine.setContext(new SoftReference<>(context));
        com.baidu.ar.h.b.c("AbstractRenderer", "create end!!!");
    }

    private void M(String str) {
        com.baidu.ar.arplay.d.b bVar = this.hB;
        if (bVar != null) {
            bVar.J(str);
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
        } catch (Exception unused) {
            com.baidu.ar.h.b.l("AbstractRenderer", "attachInputSurface surfaceTexture.detachFromGLContext() fail!!!");
        }
        this.hx.getARPRenderer().runSyncOnRenderContext(new Runnable() { // from class: com.baidu.ar.arrender.f.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    surfaceTexture.attachToGLContext(textureId);
                    f.this.hL = true;
                    surfaceTexture.updateTexImage();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        surfaceTexture.setDefaultBufferSize(i2, i3);
        DuMixStateListener duMixStateListener = this.hH;
        if (duMixStateListener != null) {
            duMixStateListener.onInputSurfaceTextureAttach(surfaceTexture);
        }
    }

    private Surface b(DuMixOutput duMixOutput, Object obj) {
        Object outputSurface = duMixOutput.getOutputSurface();
        if (obj == null) {
            obj = outputSurface;
        }
        if (obj == null) {
            bH();
            this.hv = true;
        }
        Surface surface = null;
        if (obj instanceof SurfaceHolder) {
            SurfaceHolder surfaceHolder = (SurfaceHolder) obj;
            surface = surfaceHolder.getSurface();
            duMixOutput.setOutputSurface(surfaceHolder);
        } else if (obj instanceof SurfaceTexture) {
            SurfaceTexture surfaceTexture = (SurfaceTexture) obj;
            surfaceTexture.setDefaultBufferSize(duMixOutput.getOutputWidth(), duMixOutput.getOutputHeight());
            surface = new Surface(surfaceTexture);
            duMixOutput.setOutputSurface(surfaceTexture);
        } else if (obj instanceof Surface) {
            surface = (Surface) obj;
            duMixOutput.setOutputSurface(surface);
        }
        if (surface == null) {
            com.baidu.ar.h.b.b("AbstractRenderer", "initOutputSurface outputSurface error!!!");
        }
        return surface;
    }

    private void b(DuMixInput duMixInput) {
        this.hx.getARPRenderer().setUpEGLEnv(this.hG);
        this.hx.getARPRenderer().setCameraFace(duMixInput.isFrontCamera());
        PixelRotation a = b.a(duMixInput.isFitCameraAuto(), duMixInput.getRotationType(), duMixInput.getMirriorType());
        com.baidu.ar.arplay.core.engine.e eVar = com.baidu.ar.arplay.core.engine.e.INTERNAL_2D_TEX;
        if ((duMixInput.getInputTexture() != null && duMixInput.getInputTexture().getType() == 36197) || (duMixInput.getInputSurface() != null && duMixInput.isCameraInput())) {
            eVar = com.baidu.ar.arplay.core.engine.e.INTERNAL_OES_TEX;
        }
        if (duMixInput.isSyncInputContent()) {
            this.hx.getARPRenderer().createSyncInputSource(a, eVar);
        } else {
            this.hx.getARPRenderer().createInputSource(a, eVar);
        }
        Size a2 = a(this.V);
        this.hx.setPreviewSize(a2.getWidth(), a2.getHeight());
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
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine != null && aRPEngine.getARPRenderer() != null) {
            this.hx.getARPRenderer().runSyncOnRenderContext(new Runnable() { // from class: com.baidu.ar.arrender.f.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (f.this.V == null || f.this.V.getInputSurface() == null) {
                            return;
                        }
                        f.this.hL = false;
                        f.this.V.getInputSurface().detachFromGLContext();
                    } catch (Exception unused) {
                        com.baidu.ar.h.b.k("AbstractRenderer", "releaseInput() surfaceTexture.detachFromGLContext() fail!!!");
                    }
                }
            });
        }
        DuMixInput duMixInput = this.V;
        if (duMixInput != null && duMixInput.getInputSurface() != null) {
            this.V.getInputSurface().setOnFrameAvailableListener(null);
            if (this.hu) {
                this.V.getInputSurface().release();
            }
        }
        ARPEngine aRPEngine2 = this.hx;
        if (aRPEngine2 == null || aRPEngine2.getARPRenderer() == null || this.hw <= 0) {
            return;
        }
        this.hx.getARPRenderer().destroyTexture(this.hw);
    }

    private void bN() {
        DuMixOutput duMixOutput = this.W;
        if (duMixOutput != null && duMixOutput.getOutputSurface() != null && this.hv) {
            ((SurfaceTexture) this.W.getOutputSurface()).release();
        }
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null || this.ht == null) {
            return;
        }
        this.hx.getARPRenderer().removeOutputTargetByAddr(this.ht.ca());
    }

    private void bO() {
        IARPRenderer aRPRenderer;
        String ca;
        PixelRotation pixelRotation;
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null || this.ht == null) {
            return;
        }
        if (com.baidu.ar.h.p.A(this.mContext)) {
            aRPRenderer = this.hx.getARPRenderer();
            ca = this.ht.ca();
            pixelRotation = PixelRotation.RotateLeft;
        } else {
            aRPRenderer = this.hx.getARPRenderer();
            ca = this.ht.ca();
            pixelRotation = PixelRotation.NoRotation;
        }
        aRPRenderer.updateOutputSurfaceRotation(ca, pixelRotation);
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
        a aVar = this.hz;
        if (aVar != null) {
            aVar.bq();
        }
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine != null) {
            aRPEngine.loadCaseWithResPath(str);
            DuMixOutput duMixOutput = this.W;
            if (duMixOutput != null) {
                changeOutputSize(duMixOutput.getOutputWidth(), this.W.getOutputHeight());
            }
        }
        this.mCasePath = str;
        M(str);
    }

    public Size a(DuMixInput duMixInput) {
        if (duMixInput == null) {
            com.baidu.ar.h.b.b("AbstractRenderer", "getEngineInputSize duMixInput is null!!!");
            return null;
        }
        Size size = this.hF;
        if (size == null || size.getWidth() == 0 || this.hF.getHeight() == 0) {
            Size size2 = new Size(duMixInput.getInputHeight(), duMixInput.getInputWidth());
            if (!duMixInput.isCameraInput() && (duMixInput.getRotationType() == RotationType.ROTATE_0 || duMixInput.getRotationType() == RotationType.ROTATE_180)) {
                size2.setWidth(duMixInput.getInputWidth());
                size2.setHeight(duMixInput.getInputHeight());
            }
            return size2;
        }
        return this.hF;
    }

    public Size a(Size size, DuMixOutput duMixOutput) {
        int width;
        int height;
        int outputWidth;
        int outputHeight;
        if (com.baidu.ar.h.p.A(this.mContext)) {
            width = size.getWidth();
            height = size.getHeight();
            outputWidth = duMixOutput.getOutputHeight();
            outputHeight = duMixOutput.getOutputWidth();
        } else {
            width = size.getWidth();
            height = size.getHeight();
            outputWidth = duMixOutput.getOutputWidth();
            outputHeight = duMixOutput.getOutputHeight();
        }
        return b.b(width, height, outputWidth, outputHeight);
    }

    public void a(DuMixInput duMixInput, DuMixOutput duMixOutput) {
        ARPEngine aRPEngine;
        com.baidu.ar.h.b.c("AbstractRenderer", "setup() start");
        if (duMixInput == null || duMixOutput == null || (aRPEngine = this.hx) == null || aRPEngine.getARPRenderer() == null) {
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

    public void a(DuMixOutput duMixOutput, Object obj) {
        Surface b;
        String addOutputSurface;
        if (duMixOutput.getOutputTexture() == null || duMixOutput.getOutputTexture().getId() == -1) {
            b = b(duMixOutput, obj);
            addOutputSurface = this.hx.getARPRenderer().addOutputSurface(b, duMixOutput.getOutputWidth(), duMixOutput.getOutputHeight(), b.a(duMixOutput.getRotationType(), duMixOutput.getMirriorType()), b.a(duMixOutput.getScaleType()));
        } else {
            addOutputSurface = this.hx.getARPRenderer().addOutputTarget(duMixOutput.getOutputTexture().getType(), duMixOutput.getOutputTexture().getId(), duMixOutput.getOutputWidth(), duMixOutput.getOutputHeight(), b.a(this.W.getRotationType(), this.W.getMirriorType()));
            b = null;
        }
        p pVar = new p(duMixOutput);
        this.ht = pVar;
        pVar.setSurface(b);
        this.ht.Q(addOutputSurface);
        if (duMixOutput.isFitScreenAuto()) {
            bO();
        }
        Size a = a(a(this.V), this.W);
        this.hx.setWindowSize(a.getWidth(), a.getHeight());
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
        String jSONObject2 = jSONObject.toString();
        this.hD = jSONObject2;
        try {
            this.hx.setConfig("grading", jSONObject2);
        } catch (Throwable unused) {
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
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine != null) {
            aRPEngine.unloadCase();
        }
        bL();
        ARPEngine aRPEngine2 = this.hx;
        if (aRPEngine2 != null && aRPEngine2.getARPRenderer() != null) {
            this.hx.getARPRenderer().purgeMemory();
        }
        this.mCasePath = null;
        com.baidu.ar.arplay.d.b bVar = this.hB;
        if (bVar != null) {
            bVar.J(null);
        }
    }

    public void bC() {
        DuMixInput duMixInput;
        com.baidu.ar.h.b.c("AbstractRenderer", "startARPEngine()");
        if (this.hx == null) {
            this.hx = ARPEngine.getInstance();
        }
        if (this.hx != null && (duMixInput = this.V) != null && this.W != null) {
            Size a = a(duMixInput);
            Size a2 = a(a, this.W);
            ARPEngineParams aRPEngineParams = new ARPEngineParams();
            aRPEngineParams.setInputWidth(a.getWidth());
            aRPEngineParams.setInputHeight(a.getHeight());
            aRPEngineParams.setOutputWidth(a2.getWidth());
            aRPEngineParams.setOutputHeight(a2.getHeight());
            aRPEngineParams.setDensity(com.baidu.ar.h.p.z(this.mContext));
            if (this.V.isCameraInput()) {
                aRPEngineParams.setIsFrontCamera(this.V.isFrontCamera());
            }
            aRPEngineParams.setShaderDBPath(this.aL);
            this.hx.createEngine(aRPEngineParams);
        }
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine != null) {
            aRPEngine.resume();
        }
        a aVar = this.hz;
        if (aVar != null) {
            aVar.bq();
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
        if (this.hx == null || !this.hy) {
            com.baidu.ar.lua.b bVar = this.f;
            if (bVar != null) {
                bVar.handleMessage(7, 0, null);
            }
        } else {
            this.hx.destroyEngine();
            this.hy = false;
        }
        this.hz = null;
        com.baidu.ar.arplay.a.c cVar = this.hA;
        if (cVar != null) {
            cVar.release();
        }
    }

    public boolean bE() {
        return this.hI;
    }

    public abstract void bF();

    public void bI() {
        this.hI = true;
        com.baidu.ar.libloader.a.require("AREngineCpp");
        com.baidu.ar.libloader.a.setLibReadyListener("AREngineCpp", new ILibLoader.c() { // from class: com.baidu.ar.arrender.f.3
            @Override // com.baidu.ar.libloader.ILibLoader.c
            public void onReady() {
                f.this.hI = false;
                f fVar = f.this;
                if (fVar.hJ) {
                    return;
                }
                fVar.bJ();
            }
        });
    }

    public void bJ() {
        if (this.hx != null) {
            try {
                if (TextUtils.isEmpty(this.hD)) {
                    this.hx.setLocalDeviceGrade(this.hE);
                } else {
                    this.hx.setConfig("grading", this.hD);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        bL();
        bC();
    }

    public void c(DuMixInput duMixInput) {
        if (duMixInput.getInputTexture() != null) {
            if (duMixInput.getInputTexture().getId() == -1) {
                long createTexture = this.hx.getARPRenderer().createTexture(duMixInput.getInputTexture().getType(), duMixInput.getInputWidth(), duMixInput.getInputHeight());
                duMixInput.getInputTexture().setHandle(createTexture);
                duMixInput.getInputTexture().setId(this.hx.getARPRenderer().getTextureId(createTexture));
            }
            this.hx.getARPRenderer().setInputTexture(duMixInput.getInputTexture().getType(), duMixInput.getInputTexture().getId(), duMixInput.getInputWidth(), duMixInput.getInputHeight());
            return;
        }
        int i = duMixInput.isCameraInput() ? CyberRender.GL_TEXTURE_EXTERNAL_OES : 3553;
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
        DuMixOutput duMixOutput;
        p pVar;
        if (this.V == null || (duMixOutput = this.W) == null) {
            return;
        }
        if (duMixOutput.getOutputHeight() == i2 && this.W.getOutputWidth() == i) {
            return;
        }
        com.baidu.ar.h.b.c("AbstractRenderer", "changeOutputSize() size = " + i + "x" + i2);
        Object outputSurface = this.W.getOutputSurface();
        if (outputSurface instanceof SurfaceTexture) {
            ((SurfaceTexture) outputSurface).setDefaultBufferSize(i, i2);
        }
        this.W.setOutputWidth(i);
        this.W.setOutputHeight(i2);
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine != null && aRPEngine.getARPRenderer() != null && (pVar = this.ht) != null && !TextUtils.isEmpty(pVar.ca())) {
            this.hx.getARPRenderer().addOutputSurface(this.ht.getSurface(), i, i2);
        }
        if (this.hx != null) {
            Size a = a(a(this.V), this.W);
            this.hx.setWindowSize(a.getWidth(), a.getHeight());
        }
        if (this.W.isFitScreenAuto()) {
            bO();
        }
    }

    public void createPixelReader(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        ARPEngine aRPEngine;
        if (!this.hy || (aRPEngine = this.hx) == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        b.a(this.mContext, this.V.isFrontCamera(), pixelReadParams);
        this.hx.getARPRenderer().createPixelReaderByPreFilterID(pixelReadParams, pixelReadListener);
    }

    public void destroyPixelReader(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        ARPEngine aRPEngine;
        if (!this.hy || (aRPEngine = this.hx) == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.hx.getARPRenderer().destroyPixelReaderByPreFilterID(pixelReadParams, pixelReadListener);
    }

    public void o(boolean z) {
        this.hy = z;
    }

    public void p(boolean z) {
        if (z) {
            Size a = b.a(this.W.getOutputWidth(), this.W.getOutputHeight(), this.V.getInputHeight(), this.V.getInputWidth());
            this.hF = a;
            this.hx.setPreviewSize(a.getWidth(), this.hF.getHeight());
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
        com.baidu.ar.arplay.a.c cVar = this.hA;
        if (cVar != null) {
            cVar.release();
        }
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine != null) {
            aRPEngine.pause();
        }
    }

    public void q(boolean z) {
        this.hJ = z;
    }

    public void release() {
        com.baidu.ar.h.b.c("AbstractRenderer", "release() start!!!");
        this.hK = true;
        pause();
        com.baidu.ar.arplay.d.b bVar = this.hB;
        if (bVar != null) {
            bVar.release();
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
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine != null) {
            aRPEngine.destroy();
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
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine != null) {
            aRPEngine.resume();
        }
    }

    public void setLocalDeviceGrade(int i) {
        this.hE = i;
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine != null) {
            try {
                aRPEngine.setLocalDeviceGrade(i);
            } catch (Throwable unused) {
            }
        }
    }

    public void updatePixelReader(PixelReadParams pixelReadParams, PixelRotation pixelRotation) {
        ARPEngine aRPEngine;
        if (!this.hy || (aRPEngine = this.hx) == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        pixelReadParams.setPixelRotate(pixelRotation);
        b.a(this.mContext, this.V.isFrontCamera(), pixelReadParams);
        this.hx.getARPRenderer().setPixelReaderRotation(pixelReadParams, pixelReadParams.getPixelRotate());
    }
}
