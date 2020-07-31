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
import com.baidu.ar.bean.Size;
import com.baidu.ar.f.o;
import com.baidu.ar.libloader.a;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.p;
import com.baidu.mobstat.Config;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public abstract class e implements SurfaceTexture.OnFrameAvailableListener, View.OnTouchListener, OnRenderFinishedListener, OnRenderStartedListener, IRenderer {
    private f C;
    DuMixInput W;
    DuMixOutput aa;
    com.baidu.ar.lua.b f;
    private n hG;
    private boolean hH;
    private boolean hI;
    private long hJ;
    private HashMap<DuMixOutput, n> hK;
    private com.baidu.ar.steploading.d hL;
    private com.baidu.ar.e.c hM;
    private com.baidu.ar.lua.a hN;
    ARPFilter hO;
    ARPEngine hP;
    boolean hQ;
    com.baidu.ar.arplay.core.engine.a hR;
    private WeakReference<View> hS;
    a hT;
    com.baidu.ar.arplay.a.c hU;
    com.baidu.ar.arplay.d.b hV;
    boolean hW;
    private float[] hX;
    boolean hY;
    private String hZ;
    private int ia;
    private Size ib;
    protected EGLContext ic;
    private DuMixStateListener ie;

    /* renamed from: if  reason: not valid java name */
    private g f2if;
    String mCasePath;
    private Context mContext;
    private OnRenderFinishedListener mOnRenderFinishedListener;
    private OnRenderStartedListener mOnRenderStartedListener;

    public e(Context context, com.baidu.ar.lua.b bVar) {
        this(context, bVar, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context, com.baidu.ar.lua.b bVar, EGLContext eGLContext) {
        this.hH = false;
        this.hI = false;
        this.hJ = 0L;
        this.hQ = false;
        this.mCasePath = null;
        this.hX = new float[16];
        this.hY = false;
        this.ic = null;
        com.baidu.ar.f.b.c("AbstractRenderer", "create start!!!");
        com.baidu.ar.libloader.b.ao("EglCore2");
        this.mContext = context;
        this.f = bVar;
        this.ic = eGLContext;
        this.hR = new com.baidu.ar.arplay.core.engine.a(Looper.getMainLooper());
        this.hR.setScreenOrientationLandscape(com.baidu.ar.f.n.y(context));
        this.hU = new com.baidu.ar.arplay.a.c(context);
        this.hV = com.baidu.ar.arplay.d.b.bh();
        this.hK = new HashMap<>();
        this.hT = new a(context);
        this.hL = new com.baidu.ar.steploading.d(context);
        this.hL.b(this.f);
        this.hM = new com.baidu.ar.e.c(context);
        this.hM.b(this.f);
        this.hN = new com.baidu.ar.lua.a();
        this.hN.b(this.f);
        p.b(this.f);
        Matrix.setIdentityM(this.hX, 0);
        this.hP = ARPEngine.getInstance();
        this.hO = ARPFilter.getInstance();
        this.hO.setContext(new SoftReference<>(context));
        com.baidu.ar.f.b.c("AbstractRenderer", "create end!!!");
    }

    private void J(String str) {
        if (this.hV != null) {
            this.hV.G(str);
            File file = new File(str, "res/webview");
            if (file.exists()) {
                File file2 = new File(this.mContext.getFilesDir(), "ar/res/webview");
                com.baidu.ar.f.g.b(file2);
                com.baidu.ar.f.g.a(file, file2, true);
            }
        }
    }

    private void a(final SurfaceTexture surfaceTexture, int i, int i2, int i3) {
        final int textureId = this.hO.getTextureId(this.hO.createTexture(i, i2, i3));
        this.hO.setInputTexture(i, textureId, i2, i3);
        try {
            surfaceTexture.detachFromGLContext();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.hO.runSyncOnRenderContext(new Runnable() { // from class: com.baidu.ar.arrender.e.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    surfaceTexture.attachToGLContext(textureId);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
        surfaceTexture.setDefaultBufferSize(i2, i3);
        if (this.ie != null) {
            this.ie.onInputSurfaceTextureAttach(surfaceTexture);
        }
    }

    private void a(boolean z, PixelReadParams pixelReadParams) {
        if (o.fw()) {
            if (pixelReadParams.getIsPortrait()) {
                if (z) {
                    pixelReadParams.setPixelRotate(PixelRotation.RotateRightFlipVertical);
                } else {
                    pixelReadParams.setPixelRotate(PixelRotation.RotateRight);
                }
            } else if (z) {
                pixelReadParams.setPixelRotate(PixelRotation.Rotate180);
            } else {
                pixelReadParams.setPixelRotate(PixelRotation.NoRotation);
            }
        } else if (o.fx()) {
            if (pixelReadParams.getIsPortrait()) {
                if (z) {
                    pixelReadParams.setPixelRotate(PixelRotation.RotateRightFlipHorizontal);
                } else {
                    pixelReadParams.setPixelRotate(PixelRotation.RotateLeft);
                }
            } else if (z) {
                pixelReadParams.setPixelRotate(PixelRotation.NoRotation);
            } else {
                pixelReadParams.setPixelRotate(PixelRotation.Rotate180);
            }
        }
    }

    private void bC() {
        this.hO.runLuaScriptStr("filter_pipeline = function()\n\n    fm = ae.FilterManager:get_instance();\n\n    global_copy_filter = fm:create_filter(\"Tex2DFilter\", \"globalTex2DFilter\", true);\n    gl_makeup_filer = fm:create_filter(\"BeautyMakeupFilter\",\"globalBeautyMakeupFilter\",true);\n\n    skin_filter = fm:create_filter(\"SkinFilter\", \"globalSkinFilter\", true);\n    engine_filter = fm:create_filter(\"EngineFilter\", \"globalEngineFilter\", true);\n    fm:update_property_int(engine_filter, \"is_enable\", 0);\n    face_filter = fm:create_filter(\"FaceFilter\", \"globalFaceFilter\", true);\n    lut_filter = fm:create_filter(\"LUTFilter\", \"globalLutFilter\", true);\n    tune_color_filter = fm:create_filter(\"TuneColorFilter\", \"globalTuneColorFilter\", true);\n    fm:reset_pipeline();\n\n    fm:connect_filters_by_id(skin_filter, gl_makeup_filer);\n    fm:connect_filters_by_id(skin_filter, global_copy_filter);\n    fm:connect_filters_by_id(global_copy_filter, gl_makeup_filer);\n    fm:connect_filters_by_id(gl_makeup_filer, face_filter);\n    fm:connect_filters_by_id(face_filter, tune_color_filter);\n    fm:connect_filters_by_id(tune_color_filter, engine_filter);\n    fm:connect_filters_by_id(engine_filter, lut_filter);\n\n    fm:connect_filter_to_camera(skin_filter);\n    fm:connect_filter_to_output(lut_filter);\n\nend\n\nfilter_pipeline()\n\n");
    }

    private void bD() {
        this.hO.runSyncOnRenderContext(new Runnable() { // from class: com.baidu.ar.arrender.e.4
            @Override // java.lang.Runnable
            public void run() {
                int createTexture = (int) e.this.hO.createTexture(3553, e.this.aa.getOutputWidth(), e.this.aa.getOutputHeight());
                com.baidu.ar.f.b.c("AbstractRenderer", "setup outputTextureId = " + createTexture);
                e.this.aa.setOutputSurface(new SurfaceTexture(createTexture));
            }
        });
    }

    private void bE() {
        if (this.W != null && this.W.getInputSurface() != null) {
            this.W.getInputSurface().setOnFrameAvailableListener(null);
            if (this.hH) {
                this.W.getInputSurface().release();
            }
        }
        if (this.hO != null && this.hJ > 0) {
            this.hO.destroyTexture(this.hJ);
        }
        this.W = null;
        if (this.aa != null && this.aa.getOutputSurface() != null && this.hI) {
            ((SurfaceTexture) this.aa.getOutputSurface()).release();
        }
        this.aa = null;
        this.hG = null;
    }

    private SurfaceTexture c(int i, int i2, int i3) {
        this.hJ = this.hO.createTexture(i, i2, i3);
        int textureId = this.hO.getTextureId(this.hJ);
        SurfaceTexture surfaceTexture = new SurfaceTexture(textureId);
        surfaceTexture.setDefaultBufferSize(i2, i3);
        this.hO.setInputTexture(i, textureId, i2, i3);
        return surfaceTexture;
    }

    private void r(boolean z) {
        if (z) {
            return;
        }
        float[] fArr = new float[16];
        Matrix.setIdentityM(fArr, 0);
        this.hO.setInputMatrix(fArr);
    }

    public void I(String str) {
        com.baidu.ar.f.b.c("AbstractRenderer", "createCase() casePath = " + str);
        if (this.hT != null) {
            this.hT.bl();
        }
        if (this.hL != null) {
            this.hL.switchCase(str);
        }
        if (this.hN != null) {
            this.hN.dY();
        }
        if (this.hP != null) {
            this.hP.loadCaseWithResPath(str);
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
            com.baidu.ar.f.b.b("AbstractRenderer", "getEngineInputSize duMixInput is null!!!");
            return null;
        } else if (this.ib == null || this.ib.getWidth() == 0 || this.ib.getHeight() == 0) {
            Size size = new Size(duMixInput.getInputHeight(), duMixInput.getInputWidth());
            if (duMixInput.isCameraInput()) {
                return size;
            }
            if (duMixInput.getInputDegree() == 0 || duMixInput.getInputDegree() == 180) {
                size.setWidth(duMixInput.getInputWidth());
                size.setHeight(duMixInput.getInputHeight());
                return size;
            }
            return size;
        } else {
            return this.ib;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Size a(Size size) {
        return b.b(size.getWidth(), size.getHeight(), this.aa.getOutputWidth(), this.aa.getOutputHeight());
    }

    public void a(DuMixInput duMixInput, DuMixOutput duMixOutput) {
        com.baidu.ar.f.b.c("AbstractRenderer", "setup() start");
        if (duMixInput == null || duMixOutput == null || this.hO == null) {
            return;
        }
        this.W = duMixInput;
        this.aa = duMixOutput;
        this.hO.setUpEGLEnv(this.ic);
        this.hO.setCameraFace(duMixInput.isFrontCamera());
        this.hO.createInputSource(b.a(duMixInput.isCameraInput(), duMixInput.getInputDegree()), com.baidu.ar.arplay.core.engine.b.INTERNAL_OES_TEX);
        a(duMixInput);
        r(duMixInput.isCameraInput());
        if (duMixInput.getInputSurface() == null) {
            duMixInput.setInputSurface(c(36197, duMixInput.getInputWidth(), duMixInput.getInputHeight()));
            this.hH = true;
        } else {
            a(duMixInput.getInputSurface(), 36197, duMixInput.getInputWidth(), duMixInput.getInputHeight());
        }
        duMixInput.getInputSurface().setOnFrameAvailableListener(this);
        if (duMixOutput.getOutputSurface() == null) {
            bD();
            this.hI = true;
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
        if (surface != null) {
            String addOutputSurface = this.hO.addOutputSurface(surface, duMixOutput.getOutputWidth(), duMixOutput.getOutputHeight());
            this.hG = new n(duMixOutput);
            this.hG.setSurface(surface);
            this.hG.N(addOutputSurface);
            this.hO.setOnRenderStartedListener(this);
            this.hO.setOnRenderFinishedListener(this);
            this.hO.connectCameraWithTarget();
            this.hY = duMixInput.isFrontCamera();
            if (this.aa.getOutputFPS() > 0) {
                this.f2if = new g(this.aa.getOutputFPS());
            }
            bA();
            com.baidu.ar.f.b.c("AbstractRenderer", "setup() end");
        }
    }

    public void a(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        if (this.hO != null) {
            this.hO.destroyPixelReaderByPreFilterID(pixelReadParams, pixelReadListener);
        }
    }

    public void a(PixelReadParams pixelReadParams, PixelRotation pixelRotation) {
        if (this.hO != null) {
            a(this.hY, pixelReadParams);
            this.hO.setPixelReaderRotation(pixelReadParams, pixelReadParams.getPixelRotate());
        }
    }

    public void a(JSONObject jSONObject) {
        if (this.hP == null || jSONObject == null) {
            return;
        }
        this.hZ = jSONObject.toString();
        try {
            this.hP.setConfig("grading", this.hZ);
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
        if (duMixOutput == null || duMixOutput.getOutputSurface() == null || this.hO == null || !(duMixOutput.getOutputSurface() instanceof Surface)) {
            com.baidu.ar.f.b.b("AbstractRenderer", "addOutputSurface duMixOutput is error!!!");
            return;
        }
        com.baidu.ar.f.b.c("AbstractRenderer", "addOutputSurface() surface = " + duMixOutput.getOutputSurface().hashCode() + " & width*height = " + duMixOutput.getOutputWidth() + "*" + duMixOutput.getOutputHeight() + " & rotation = " + duMixOutput.getRotationType() + " & mode = " + duMixOutput.getScaleType());
        String addOutputSurface = this.hO.addOutputSurface((Surface) duMixOutput.getOutputSurface(), duMixOutput.getOutputWidth(), duMixOutput.getOutputHeight(), b.a(duMixOutput.getRotationType(), duMixOutput.getMirriorType()), b.a(duMixOutput.getScaleType()));
        n nVar = new n(duMixOutput);
        nVar.N(addOutputSurface);
        if (this.hK != null) {
            this.hK.put(duMixOutput, nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bA() {
        com.baidu.ar.libloader.b.ao("AREngineCpp2");
        com.baidu.ar.libloader.b.a("AREngineCpp", new a.c() { // from class: com.baidu.ar.arrender.e.1
            @Override // com.baidu.ar.libloader.a.c
            public void onReady() {
                e.this.bB();
            }
        });
    }

    protected void bB() {
        if (this.hP != null) {
            if (TextUtils.isEmpty(this.hZ)) {
                try {
                    this.hP.setLocalDeviceGrade(this.ia);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else {
                try {
                    this.hP.setConfig("grading", this.hZ);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
        bC();
        bx();
        a(this.hY);
    }

    public void bv() {
        com.baidu.ar.f.b.c("AbstractRenderer", "destroyCase()");
        if (this.hP != null) {
            this.hP.unloadCase();
        }
        bC();
        this.hO.purgeMemory();
        this.mCasePath = null;
        if (this.hV != null) {
            this.hV.G(null);
        }
        if (this.hM != null) {
            this.hM.reset();
        }
    }

    public void bw() {
        com.baidu.ar.f.b.c("AbstractRenderer", "stopARPEngine()");
        if (this.hP != null && this.hQ) {
            this.hP.pause();
            this.hP.destroyEngine();
            this.hP = null;
            this.hQ = false;
        }
        this.hT = null;
        if (this.hU != null) {
            this.hU.release();
        }
    }

    public void bx() {
        com.baidu.ar.f.b.c("AbstractRenderer", "startARPEngine()");
        if (this.hP == null) {
            this.hP = ARPEngine.getInstance();
        }
        if (this.hR != null) {
            this.hR.i(true);
        }
        if (this.hP != null && this.W != null && this.aa != null) {
            Size a = a(this.W);
            Size a2 = a(a);
            this.hP.createEngine(a.getWidth(), a.getHeight(), a2.getWidth(), a2.getHeight(), com.baidu.ar.f.n.x(this.mContext));
        }
        if (this.hP != null && this.W != null && this.W.isCameraInput()) {
            this.hP.setIsFrontCamera(this.W.isFrontCamera());
        }
        if (this.hP != null) {
            this.hP.resume();
        }
        if (this.hT != null) {
            this.hT.bl();
        }
        try {
            if (this.hU != null) {
                this.hU.start();
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public com.baidu.ar.steploading.d by() {
        return this.hL;
    }

    public void cancelAysncRenderTask(Runnable runnable) {
        if (this.hO == null || runnable == null) {
            return;
        }
        this.hO.cancelAysncRenderTask(runnable);
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
        com.baidu.ar.f.b.c("AbstractRenderer", "changeOutputSize() size = " + i + Config.EVENT_HEAT_X + i2);
        Object outputSurface = this.aa.getOutputSurface();
        if (outputSurface instanceof SurfaceTexture) {
            ((SurfaceTexture) outputSurface).setDefaultBufferSize(i, i2);
        }
        this.aa.setOutputWidth(i);
        this.aa.setOutputHeight(i2);
        if (this.hO != null && this.hG != null && !TextUtils.isEmpty(this.hG.bN())) {
            this.hO.addOutputSurface(this.hG.getSurface(), i, i2);
        }
        if (this.hP != null) {
            Size a = a(a(this.W));
            this.hP.setWindowSize(a.getWidth(), a.getHeight());
            if (this.hR != null) {
                this.hR.d(i, i2);
            }
        }
    }

    public void createPixelReader(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        if (this.hO != null) {
            a(this.hY, pixelReadParams);
            this.hO.createPixelReaderByPreFilterID(pixelReadParams, pixelReadListener);
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        if (this.hO == null) {
            return;
        }
        if (this.f2if != null && !this.f2if.bF()) {
            this.hO.runSyncOnRenderContext(new Runnable() { // from class: com.baidu.ar.arrender.e.2
                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.W == null || e.this.W.getInputSurface() == null) {
                        return;
                    }
                    e.this.W.getInputSurface().updateTexImage();
                }
            });
            return;
        }
        StatisticApi.getPerformanceApi().onFrameIn();
        this.hO.render();
        StatisticApi.getPerformanceApi().onFrameOut();
    }

    public void onRenderFinished() {
        if (this.mOnRenderFinishedListener != null) {
            this.mOnRenderFinishedListener.onRenderFinished();
        }
    }

    public void onRenderStarted() {
        if (this.mOnRenderStartedListener != null) {
            this.mOnRenderStartedListener.onRenderStarted();
        }
        if (this.W == null || this.W.getInputSurface() == null || !this.W.isCameraInput() || this.hO == null) {
            return;
        }
        this.W.getInputSurface().updateTexImage();
        this.W.getInputSurface().getTransformMatrix(this.hX);
        this.hO.setInputMatrix(this.hX);
        if (this.W == null || !this.W.isCameraInput()) {
            return;
        }
        this.hY = this.hX[1] * this.hX[4] < 0.0f;
        if (this.W.isFrontCamera() != this.hY) {
            a(this.hY);
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.hR == null || view == null) {
            return false;
        }
        if (this.hS == null || this.hS.get() == null || !view.equals(this.hS.get())) {
            this.hS = new WeakReference<>(view);
            this.hR.d(view.getWidth(), view.getHeight());
        }
        this.hR.onTouchEvent(motionEvent);
        return true;
    }

    public void p(boolean z) {
        this.hQ = z;
    }

    public void pause() {
        com.baidu.ar.f.b.c("AbstractRenderer", "pause()");
        if (this.hU != null) {
            this.hU.release();
        }
        if (this.hR != null) {
            this.hR.onPause();
        }
        if (this.hP != null) {
            this.hP.pause();
        }
    }

    public void q(boolean z) {
        if (z) {
            this.ib = b.a(this.aa.getOutputHeight(), this.aa.getOutputWidth(), this.W.getInputHeight(), this.W.getInputWidth());
            this.hP.setPreviewSize(this.ib.getWidth(), this.ib.getHeight());
            this.hP.setWindowSize(this.aa.getOutputWidth(), this.aa.getOutputHeight());
            return;
        }
        this.ib = null;
        Size a = a(this.W);
        Size a2 = a(a);
        this.hP.setPreviewSize(a.getWidth(), a.getHeight());
        this.hP.setWindowSize(a2.getWidth(), a2.getHeight());
    }

    public void release() {
        com.baidu.ar.f.b.c("AbstractRenderer", "release() start!!!");
        if (this.hV != null) {
            this.hV.release();
            this.hV = null;
        }
        if (this.hS != null) {
            this.hS.clear();
            this.hS = null;
        }
        this.hR = null;
        p.c(this.f);
        bw();
        this.mOnRenderStartedListener = null;
        this.mOnRenderFinishedListener = null;
        this.C = null;
        this.ie = null;
        this.hX = null;
        bE();
        if (this.hO != null) {
            this.hO.removeAllOutputTarget();
            this.hO.destroy();
            this.hO = null;
        }
        ARPFilter.releaseInstance();
        if (this.hK != null) {
            this.hK.clear();
            this.hK = null;
        }
        if (this.hL != null) {
            this.hL.release();
            this.hL = null;
        }
        if (this.hM != null) {
            this.hM.release();
            this.hM = null;
        }
        if (this.hN != null) {
            this.hN.release();
            this.hN = null;
        }
        this.mContext = null;
        this.ic = null;
        com.baidu.ar.f.b.c("AbstractRenderer", "release() end!!!");
    }

    public void removeOutputSurface(DuMixOutput duMixOutput) {
        if (duMixOutput == null || duMixOutput.getOutputSurface() == null || !(duMixOutput.getOutputSurface() instanceof Surface)) {
            com.baidu.ar.f.b.b("AbstractRenderer", "removeOutputSurface duMixOutput is error!!!");
        } else if (this.hK != null) {
            com.baidu.ar.f.b.c("AbstractRenderer", "removeOutputSurface() surface = " + duMixOutput.getOutputSurface().hashCode());
            n remove = this.hK.remove(duMixOutput);
            if (this.hO == null || remove == null || TextUtils.isEmpty(remove.bN())) {
                return;
            }
            this.hO.removeOutputTargetByAddr(remove.bN());
        }
    }

    public void resume() {
        com.baidu.ar.f.b.c("AbstractRenderer", "resume()");
        if (this.hR != null) {
            this.hR.onResume();
        }
        try {
            if (this.hU != null) {
                this.hU.start();
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        if (this.hP == null || this.hW) {
            return;
        }
        this.hP.resume();
    }

    public void runAsyncOnRenderContext(Runnable runnable) {
        if (this.hO == null || runnable == null) {
            return;
        }
        this.hO.runAsyncOnRenderContext(runnable);
    }

    public void runSyncOnRenderContext(Runnable runnable) {
        if (this.hO == null || runnable == null) {
            return;
        }
        this.hO.runSyncOnRenderContext(runnable);
    }

    public void setCameraSwitchListener(f fVar) {
        this.C = fVar;
    }

    public void setLocalDeviceGrade(int i) {
        this.ia = i;
        if (this.hP != null) {
            try {
                this.hP.setLocalDeviceGrade(i);
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
        this.ie = duMixStateListener;
    }
}
