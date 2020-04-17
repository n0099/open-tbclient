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
/* loaded from: classes3.dex */
public abstract class e implements SurfaceTexture.OnFrameAvailableListener, View.OnTouchListener, OnRenderFinishedListener, OnRenderStartedListener, IRenderer {
    private f B;
    String aB;
    DuMixInput aa;
    DuMixOutput ab;
    com.baidu.ar.lua.b e;
    ARPFilter hA;
    ARPEngine hB;
    boolean hC;
    com.baidu.ar.arplay.core.engine.a hD;
    private WeakReference<View> hE;
    a hF;
    com.baidu.ar.arplay.a.c hG;
    com.baidu.ar.arplay.d.b hH;
    boolean hI;
    private float[] hJ;
    boolean hK;
    private String hL;
    private int hM;
    private Size hN;
    private EGLContext hO;
    private g hP;
    private n hs;
    private boolean ht;
    private boolean hu;
    private long hv;
    private HashMap<DuMixOutput, n> hw;
    private com.baidu.ar.steploading.d hx;
    private com.baidu.ar.e.c hy;
    private com.baidu.ar.lua.a hz;
    private Context mContext;
    private OnRenderFinishedListener mOnRenderFinishedListener;
    private OnRenderStartedListener mOnRenderStartedListener;

    public e(Context context, com.baidu.ar.lua.b bVar) {
        this(context, bVar, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context, com.baidu.ar.lua.b bVar, EGLContext eGLContext) {
        this.ht = false;
        this.hu = false;
        this.hv = 0L;
        this.hC = false;
        this.aB = null;
        this.hJ = new float[16];
        this.hK = false;
        this.hO = null;
        com.baidu.ar.libloader.b.an("EglCore2");
        this.hO = eGLContext;
        this.mContext = context;
        this.e = bVar;
        this.hD = new com.baidu.ar.arplay.core.engine.a(Looper.getMainLooper());
        this.hD.setScreenOrientationLandscape(com.baidu.ar.f.n.w(context));
        this.hG = new com.baidu.ar.arplay.a.c(context);
        this.hH = com.baidu.ar.arplay.d.b.aT();
        this.hw = new HashMap<>();
        this.hF = new a(context);
        this.hx = new com.baidu.ar.steploading.d(this.mContext);
        this.hx.b(this.e);
        this.hy = new com.baidu.ar.e.c(this.mContext);
        this.hy.b(this.e);
        this.hz = new com.baidu.ar.lua.a();
        this.hz.b(this.e);
        p.b(this.e);
        Matrix.setIdentityM(this.hJ, 0);
        if (this.hB == null) {
            this.hB = ARPEngine.getInstance();
        }
        if (this.hA == null) {
            this.hA = ARPFilter.getInstance();
            this.hA.setContext(new SoftReference<>(this.mContext));
        }
        this.hA.setUpEGLEnv(this.hO);
    }

    private void J(String str) {
        if (this.hH != null) {
            this.hH.G(str);
            File file = new File(str, "res/webview");
            if (file.exists()) {
                File file2 = new File(this.mContext.getFilesDir(), "ar/res/webview");
                com.baidu.ar.f.g.b(file2);
                com.baidu.ar.f.g.a(file, file2, true);
            }
        }
    }

    private void a(final SurfaceTexture surfaceTexture, int i, int i2, int i3) {
        final int textureId = this.hA.getTextureId(this.hA.createTexture(i, i2, i3));
        this.hA.setInputTexture(i, textureId, i2, i3);
        try {
            surfaceTexture.detachFromGLContext();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.hA.runSyncOnRenderContext(new Runnable() { // from class: com.baidu.ar.arrender.e.3
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
    }

    private void a(boolean z, PixelReadParams pixelReadParams) {
        if (o.fg()) {
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
        } else if (o.fh()) {
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

    private void bn() {
        this.hA.runLuaScriptStr("filter_pipeline = function()\n\n    fm = ae.FilterManager:get_instance();\n\n    global_copy_filter = fm:create_filter(\"Tex2DFilter\", \"globalTex2DFilter\", true);\n    gl_makeup_filer = fm:create_filter(\"BeautyMakeupFilter\",\"globalBeautyMakeupFilter\",true);\n\n    skin_filter = fm:create_filter(\"SkinFilter\", \"globalSkinFilter\", true);\n    engine_filter = fm:create_filter(\"EngineFilter\", \"globalEngineFilter\", true);\n    fm:update_property_int(engine_filter, \"is_enable\", 0);\n    face_filter = fm:create_filter(\"FaceFilter\", \"globalFaceFilter\", true);\n    lut_filter = fm:create_filter(\"LUTFilter\", \"globalLutFilter\", true);\n    tune_color_filter = fm:create_filter(\"TuneColorFilter\", \"globalTuneColorFilter\", true);\n    fm:reset_pipeline();\n\n    fm:connect_filters_by_id(skin_filter, gl_makeup_filer);\n    fm:connect_filters_by_id(skin_filter, global_copy_filter);\n    fm:connect_filters_by_id(global_copy_filter, gl_makeup_filer);\n    fm:connect_filters_by_id(gl_makeup_filer, face_filter);\n    fm:connect_filters_by_id(face_filter, tune_color_filter);\n    fm:connect_filters_by_id(tune_color_filter, engine_filter);\n    fm:connect_filters_by_id(engine_filter, lut_filter);\n\n    fm:connect_filter_to_camera(skin_filter);\n    fm:connect_filter_to_output(lut_filter);\n\nend\n\nfilter_pipeline()\n\n");
    }

    private void bo() {
        this.hA.runSyncOnRenderContext(new Runnable() { // from class: com.baidu.ar.arrender.e.4
            @Override // java.lang.Runnable
            public void run() {
                int createTexture = (int) e.this.hA.createTexture(3553, e.this.ab.getOutputWidth(), e.this.ab.getOutputHeight());
                com.baidu.ar.f.b.c("AbstractRenderer", "setup outputTextureId = " + createTexture);
                e.this.ab.setOutputSurface(new SurfaceTexture(createTexture));
            }
        });
    }

    private void bp() {
        if (this.aa != null && this.aa.getInputSurface() != null) {
            this.aa.getInputSurface().setOnFrameAvailableListener(null);
            if (this.ht) {
                this.aa.getInputSurface().release();
            }
        }
        if (this.hA != null && this.hv > 0) {
            this.hA.destroyTexture(this.hv);
        }
        this.aa = null;
        if (this.ab != null && this.ab.getOutputSurface() != null && this.hu) {
            ((SurfaceTexture) this.ab.getOutputSurface()).release();
        }
        this.ab = null;
        this.hs = null;
    }

    private SurfaceTexture c(int i, int i2, int i3) {
        this.hv = this.hA.createTexture(i, i2, i3);
        int textureId = this.hA.getTextureId(this.hv);
        SurfaceTexture surfaceTexture = new SurfaceTexture(textureId);
        surfaceTexture.setDefaultBufferSize(i2, i3);
        this.hA.setInputTexture(i, textureId, i2, i3);
        return surfaceTexture;
    }

    private void s(boolean z) {
        if (z) {
            return;
        }
        float[] fArr = new float[16];
        Matrix.setIdentityM(fArr, 0);
        this.hA.setInputMatrix(fArr);
    }

    public void F() {
        com.baidu.ar.f.b.c("AbstractRenderer", "destroyCase()");
        if (this.hB != null) {
            this.hB.unloadCase();
        }
        bn();
        this.hA.purgeMemory();
        this.aB = null;
        if (this.hH != null) {
            this.hH.G(null);
        }
        if (this.hy != null) {
            this.hy.reset();
        }
    }

    public void I(String str) {
        com.baidu.ar.f.b.c("AbstractRenderer", "createCase() casePath = " + str);
        if (this.hF != null) {
            this.hF.aX();
        }
        if (this.hx != null) {
            this.hx.switchCase(str);
        }
        if (this.hz != null) {
            this.hz.dI();
        }
        if (this.hB != null) {
            this.hB.loadCaseWithResPath(str);
            if (this.ab != null) {
                changeOutputSize(this.ab.getOutputWidth(), this.ab.getOutputHeight());
            }
        }
        this.aB = str;
        J(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Size a(DuMixInput duMixInput) {
        if (duMixInput == null) {
            com.baidu.ar.f.b.b("AbstractRenderer", "getEngineInputSize duMixInput is null!!!");
            return null;
        } else if (this.hN == null || this.hN.getWidth() == 0 || this.hN.getHeight() == 0) {
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
            return this.hN;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Size a(Size size) {
        return b.b(size.getWidth(), size.getHeight(), this.ab.getOutputWidth(), this.ab.getOutputHeight());
    }

    public void a(DuMixInput duMixInput, DuMixOutput duMixOutput) {
        com.baidu.ar.f.b.c("AbstractRenderer", "setup()");
        if (duMixInput == null || duMixOutput == null || this.hA == null) {
            return;
        }
        this.aa = duMixInput;
        this.ab = duMixOutput;
        this.hA.setCameraFace(duMixInput.isFrontCamera());
        this.hA.createInputSource(b.a(duMixInput.isCameraInput(), duMixInput.getInputDegree()), com.baidu.ar.arplay.core.engine.b.INTERNAL_OES_TEX);
        a(duMixInput);
        s(duMixInput.isCameraInput());
        if (duMixInput.getInputSurface() == null) {
            duMixInput.setInputSurface(c(36197, duMixInput.getInputWidth(), duMixInput.getInputHeight()));
            this.ht = true;
        } else {
            a(duMixInput.getInputSurface(), 36197, duMixInput.getInputWidth(), duMixInput.getInputHeight());
        }
        duMixInput.getInputSurface().setOnFrameAvailableListener(this);
        if (duMixOutput.getOutputSurface() == null) {
            bo();
            this.hu = true;
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
            String addOutputSurface = this.hA.addOutputSurface(surface, duMixOutput.getOutputWidth(), duMixOutput.getOutputHeight());
            this.hs = new n(duMixOutput);
            this.hs.setSurface(surface);
            this.hs.N(addOutputSurface);
            this.hA.setOnRenderStartedListener(this);
            this.hA.setOnRenderFinishedListener(this);
            this.hA.connectCameraWithTarget();
            this.hK = duMixInput.isFrontCamera();
            if (this.ab.getOutputFPS() > 0) {
                this.hP = new g(this.ab.getOutputFPS());
            }
            bl();
        }
    }

    public void a(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        if (this.hA != null) {
            this.hA.destroyPixelReaderByPreFilterID(pixelReadParams, pixelReadListener);
        }
    }

    public void a(PixelReadParams pixelReadParams, PixelRotation pixelRotation) {
        if (this.hA != null) {
            a(this.hK, pixelReadParams);
            this.hA.setPixelReaderRotation(pixelReadParams, pixelReadParams.getPixelRotate());
        }
    }

    public void a(JSONObject jSONObject) {
        if (this.hB == null || jSONObject == null) {
            return;
        }
        this.hL = jSONObject.toString();
        try {
            this.hB.setConfig("grading", this.hL);
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z) {
        if (this.B != null) {
            this.B.a(z);
        }
    }

    public void addOutputSurface(DuMixOutput duMixOutput) {
        if (duMixOutput == null || duMixOutput.getOutputSurface() == null || this.hA == null || !(duMixOutput.getOutputSurface() instanceof Surface)) {
            com.baidu.ar.f.b.b("AbstractRenderer", "addOutputSurface duMixOutput is error!!!");
            return;
        }
        com.baidu.ar.f.b.c("AbstractRenderer", "addOutputSurface() surface = " + duMixOutput.getOutputSurface().hashCode() + " & width*height = " + duMixOutput.getOutputWidth() + "*" + duMixOutput.getOutputHeight() + " & rotation = " + duMixOutput.getRotationType() + " & mode = " + duMixOutput.getScaleType());
        String addOutputSurface = this.hA.addOutputSurface((Surface) duMixOutput.getOutputSurface(), duMixOutput.getOutputWidth(), duMixOutput.getOutputHeight(), b.a(duMixOutput.getRotationType(), duMixOutput.getMirriorType()), b.a(duMixOutput.getScaleType()));
        n nVar = new n(duMixOutput);
        nVar.N(addOutputSurface);
        if (this.hw != null) {
            this.hw.put(duMixOutput, nVar);
        }
    }

    public void bh() {
        com.baidu.ar.f.b.c("AbstractRenderer", "stopARPEngine()");
        if (this.hB != null && this.hC) {
            this.hB.setFaceCallBack(null);
            this.hB.pause();
            this.hB.destroyEngine();
            this.hB = null;
            this.hC = false;
        }
        this.hF = null;
        if (this.hG != null) {
            this.hG.release();
        }
    }

    public void bi() {
        com.baidu.ar.f.b.c("AbstractRenderer", "startARPEngine()");
        if (this.hB == null) {
            this.hB = ARPEngine.getInstance();
        }
        if (this.hD != null) {
            this.hD.j(true);
        }
        if (this.hB != null && this.aa != null && this.ab != null) {
            Size a = a(this.aa);
            Size a2 = a(a);
            this.hB.createEngine(a.getWidth(), a.getHeight(), a2.getWidth(), a2.getHeight(), com.baidu.ar.f.n.v(this.mContext));
        }
        if (this.hB != null && this.aa != null && this.aa.isCameraInput()) {
            this.hB.setIsFrontCamera(this.aa.isFrontCamera());
        }
        if (this.hB != null) {
            this.hB.resume();
        }
        if (this.hF != null) {
            this.hF.aX();
        }
        try {
            if (this.hG != null) {
                this.hG.start();
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public com.baidu.ar.steploading.d bj() {
        return this.hx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bl() {
        com.baidu.ar.libloader.b.an("AREngineCpp2");
        com.baidu.ar.libloader.b.a("AREngineCpp2", new a.c() { // from class: com.baidu.ar.arrender.e.1
            @Override // com.baidu.ar.libloader.a.c
            public void onReady() {
                e.this.bm();
            }
        });
    }

    protected void bm() {
        if (this.hB != null) {
            if (TextUtils.isEmpty(this.hL)) {
                try {
                    this.hB.setLocalDeviceGrade(this.hM);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else {
                try {
                    this.hB.setConfig("grading", this.hL);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
        bn();
        bi();
        a(this.hK);
    }

    public void cancelAysncRenderTask(Runnable runnable) {
        if (this.hA == null || runnable == null) {
            return;
        }
        this.hA.cancelAysncRenderTask(runnable);
    }

    public void changeOutput(DuMixOutput duMixOutput) {
    }

    public void changeOutputSize(int i, int i2) {
        if (this.aa == null || this.ab == null) {
            return;
        }
        if (this.ab.getOutputHeight() == i2 && this.ab.getOutputWidth() == i) {
            return;
        }
        com.baidu.ar.f.b.c("AbstractRenderer", "changeOutputSize() size = " + i + Config.EVENT_HEAT_X + i2);
        Object outputSurface = this.ab.getOutputSurface();
        if (outputSurface instanceof SurfaceTexture) {
            ((SurfaceTexture) outputSurface).setDefaultBufferSize(i, i2);
        }
        this.ab.setOutputWidth(i);
        this.ab.setOutputHeight(i2);
        if (this.hA != null && this.hs != null && !TextUtils.isEmpty(this.hs.bz())) {
            this.hA.addOutputSurface(this.hs.getSurface(), i, i2);
        }
        if (this.hB != null) {
            Size a = a(a(this.aa));
            this.hB.setWindowSize(a.getWidth(), a.getHeight());
            if (this.hD != null) {
                this.hD.d(i, i2);
            }
        }
    }

    public void createPixelReader(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        if (this.hA != null) {
            a(this.hK, pixelReadParams);
            this.hA.createPixelReaderByPreFilterID(pixelReadParams, pixelReadListener);
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        if (this.hA == null) {
            return;
        }
        if (this.hP != null && !this.hP.bq()) {
            this.hA.runSyncOnRenderContext(new Runnable() { // from class: com.baidu.ar.arrender.e.2
                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.aa == null || e.this.aa.getInputSurface() == null) {
                        return;
                    }
                    e.this.aa.getInputSurface().updateTexImage();
                }
            });
            return;
        }
        StatisticApi.getPerformanceApi().onFrameIn();
        this.hA.render();
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
        if (this.aa == null || this.aa.getInputSurface() == null || !this.aa.isCameraInput() || this.hA == null) {
            return;
        }
        this.aa.getInputSurface().updateTexImage();
        this.aa.getInputSurface().getTransformMatrix(this.hJ);
        this.hA.setInputMatrix(this.hJ);
        if (this.aa == null || !this.aa.isCameraInput()) {
            return;
        }
        this.hK = this.hJ[1] * this.hJ[4] < 0.0f;
        if (this.aa.isFrontCamera() != this.hK) {
            a(this.hK);
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.hD == null || view == null) {
            return false;
        }
        if (this.hE == null || this.hE.get() == null || !view.equals(this.hE.get())) {
            this.hE = new WeakReference<>(view);
            this.hD.d(view.getWidth(), view.getHeight());
        }
        this.hD.onTouchEvent(motionEvent);
        return true;
    }

    public void pause() {
        com.baidu.ar.f.b.c("AbstractRenderer", "pause()");
        if (this.hG != null) {
            this.hG.release();
        }
        if (this.hD != null) {
            this.hD.onPause();
        }
        if (this.hB != null) {
            this.hB.pause();
        }
    }

    public void q(boolean z) {
        this.hC = z;
    }

    public void r(boolean z) {
        if (z) {
            this.hN = b.a(this.ab.getOutputHeight(), this.ab.getOutputWidth(), this.aa.getInputHeight(), this.aa.getInputWidth());
            this.hB.setPreviewSize(this.hN.getWidth(), this.hN.getHeight());
            this.hB.setWindowSize(this.ab.getOutputWidth(), this.ab.getOutputHeight());
            return;
        }
        this.hN = null;
        Size a = a(this.aa);
        Size a2 = a(a);
        this.hB.setPreviewSize(a.getWidth(), a.getHeight());
        this.hB.setWindowSize(a2.getWidth(), a2.getHeight());
    }

    public void release() {
        com.baidu.ar.f.b.c("AbstractRenderer", "release()");
        if (this.hH != null) {
            this.hH.release();
            this.hH = null;
        }
        if (this.hE != null) {
            this.hE.clear();
            this.hE = null;
        }
        this.hD = null;
        p.c(this.e);
        bh();
        this.mOnRenderStartedListener = null;
        this.mOnRenderFinishedListener = null;
        this.B = null;
        this.hJ = null;
        bp();
        if (this.hA != null) {
            this.hA.removeAllOutputTarget();
            this.hA.destroy();
            this.hA = null;
        }
        ARPFilter.releaseInstance();
        this.hP = null;
        if (this.hw != null) {
            this.hw.clear();
            this.hw = null;
        }
        if (this.hx != null) {
            this.hx.release();
            this.hx = null;
        }
        if (this.hy != null) {
            this.hy.release();
            this.hy = null;
        }
        if (this.hz != null) {
            this.hz.release();
            this.hz = null;
        }
        this.mContext = null;
        this.hO = null;
    }

    public void removeOutputSurface(DuMixOutput duMixOutput) {
        if (duMixOutput == null || duMixOutput.getOutputSurface() == null || !(duMixOutput.getOutputSurface() instanceof Surface)) {
            com.baidu.ar.f.b.b("AbstractRenderer", "removeOutputSurface duMixOutput is error!!!");
        } else if (this.hw != null) {
            com.baidu.ar.f.b.c("AbstractRenderer", "removeOutputSurface() surface = " + duMixOutput.getOutputSurface().hashCode());
            n remove = this.hw.remove(duMixOutput);
            if (this.hA == null || remove == null || TextUtils.isEmpty(remove.bz())) {
                return;
            }
            this.hA.removeOutputTargetByAddr(remove.bz());
        }
    }

    public void resume() {
        com.baidu.ar.f.b.c("AbstractRenderer", "resume()");
        if (this.hD != null) {
            this.hD.onResume();
        }
        try {
            if (this.hG != null) {
                this.hG.start();
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        if (this.hB == null || this.hI) {
            return;
        }
        this.hB.resume();
    }

    public void runAsyncOnRenderContext(Runnable runnable) {
        if (this.hA == null || runnable == null) {
            return;
        }
        this.hA.runAsyncOnRenderContext(runnable);
    }

    public void runSyncOnRenderContext(Runnable runnable) {
        if (this.hA == null || runnable == null) {
            return;
        }
        this.hA.runSyncOnRenderContext(runnable);
    }

    public void setCameraSwitchListener(f fVar) {
        this.B = fVar;
    }

    public void setLocalDeviceGrade(int i) {
        this.hM = i;
        if (this.hB != null) {
            try {
                this.hB.setLocalDeviceGrade(i);
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
}
