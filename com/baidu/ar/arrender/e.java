package com.baidu.ar.arrender;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.opengl.Matrix;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import com.baidu.ar.DuMixInput;
import com.baidu.ar.DuMixOutput;
import com.baidu.ar.DuMixStateListener;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.arplay.core.renderer.OnRenderFinishedListener;
import com.baidu.ar.arplay.core.renderer.OnRenderStartedListener;
import com.baidu.ar.bean.RotationType;
import com.baidu.ar.bean.ScaleType;
import com.baidu.ar.bean.Size;
import com.baidu.ar.bean.StorageType;
import com.baidu.ar.bean.Watermark;
import com.baidu.ar.statistic.StatisticApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public abstract class e extends f implements View.OnTouchListener, OnRenderFinishedListener, OnRenderStartedListener, IRenderer {
    public g D;
    public com.baidu.ar.arplay.core.engine.a hd;
    public boolean he;
    public com.baidu.ar.f.c hf;
    public com.baidu.ar.steploading.d hg;
    public com.baidu.ar.lua.a hh;
    public ConcurrentHashMap<DuMixOutput, p> hi;
    public List<FrameRenderListener> hj;
    public h hk;
    public boolean hl;
    public k hm;
    public boolean hn;
    public float[] ho;
    public float[] hp;
    public float[] hq;

    /* renamed from: com.baidu.ar.arrender.e$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] hs;

        static {
            int[] iArr = new int[Watermark.CoordinateType.values().length];
            hs = iArr;
            try {
                iArr[Watermark.CoordinateType.LEFT_TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                hs[Watermark.CoordinateType.LEFT_BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                hs[Watermark.CoordinateType.RIGHT_TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                hs[Watermark.CoordinateType.RIGHT_BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public e(Context context, Looper looper, com.baidu.ar.lua.b bVar, EGLContext eGLContext, String str) {
        super(context, bVar, eGLContext, str);
        this.he = false;
        this.hj = Collections.synchronizedList(new ArrayList());
        this.hl = false;
        this.hn = false;
        this.ho = new float[16];
        this.hd = new com.baidu.ar.arplay.core.engine.a(Looper.getMainLooper());
        com.baidu.ar.f.c cVar = new com.baidu.ar.f.c(context);
        this.hf = cVar;
        cVar.b(this.f);
        com.baidu.ar.lua.a aVar = new com.baidu.ar.lua.a();
        this.hh = aVar;
        aVar.b(this.f);
        com.baidu.ar.steploading.d dVar = new com.baidu.ar.steploading.d(context);
        this.hg = dVar;
        dVar.b(this.f);
        this.hi = new ConcurrentHashMap<>();
        boolean A = com.baidu.ar.h.p.A(this.mContext);
        this.hl = A;
        this.hd.setScreenOrientationLandscape(A);
        this.hm = new k(looper, bVar.fk(), this.hx.getARPRenderer());
        Matrix.setIdentityM(this.ho, 0);
        this.hx.getARPRenderer().setOnRenderStartedListener(this);
        this.hx.getARPRenderer().setOnRenderFinishedListener(this);
    }

    private void a(Watermark watermark) {
        if (watermark.getBitmap() == null && !TextUtils.isEmpty(watermark.getFilePath())) {
            Bitmap bitmap = null;
            if (watermark.getStorageType() == StorageType.SDCARD) {
                bitmap = BitmapFactory.decodeFile(watermark.getFilePath());
            } else if (watermark.getStorageType() == StorageType.ASSETS) {
                bitmap = com.baidu.ar.h.e.f(this.mContext, watermark.getFilePath());
            }
            watermark.setBitmap(bitmap);
        }
        if (watermark.getBitmap() == null || watermark.getRotationType() == RotationType.ROTATE_0) {
            return;
        }
        watermark.setBitmap(com.baidu.ar.h.e.rotateBitmap(watermark.getBitmap(), watermark.getRotationType().getDegree()));
    }

    private void a(String str, DuMixInput duMixInput, DuMixOutput duMixOutput) {
        if (duMixOutput == null || duMixOutput.getWatermark() == null) {
            return;
        }
        a(duMixOutput.getWatermark());
        if (duMixOutput.getWatermark().getBitmap() == null) {
            com.baidu.ar.h.b.b("ARRendererBase", "setWatermark error!!! As no watermark image!!!");
            return;
        }
        b(duMixInput, duMixOutput);
        if (this.hx == null || duMixOutput.getWatermark().getRenderRect() == null || duMixOutput.getWatermark().getRenderRect().length != 4) {
            return;
        }
        this.hx.setWatermark(str, duMixOutput.getWatermark().getBitmap(), duMixOutput.getWatermark().getRenderRect());
    }

    private float[] a(Watermark watermark, float f, float f2, float f3, float f4) {
        float[] fArr = new float[4];
        Point startPoint = watermark.getStartPoint();
        float width = watermark.getBitmap().getWidth() * watermark.getScale();
        float height = watermark.getBitmap().getHeight() * watermark.getScale();
        int i = AnonymousClass2.hs[watermark.getCoordinateType().ordinal()];
        if (i == 1) {
            fArr[0] = (startPoint.x + f3) / f;
            fArr[1] = (startPoint.y + f4) / f2;
        } else if (i == 2) {
            fArr[0] = (startPoint.x + f3) / f;
            fArr[1] = (((f2 - f4) - startPoint.y) - height) / f2;
        } else if (i == 3) {
            fArr[0] = (((f - f3) - startPoint.x) - width) / f;
            fArr[1] = (startPoint.y + f4) / f2;
        } else if (i == 4) {
            fArr[0] = (((f - f3) - startPoint.x) - width) / f;
            fArr[1] = (((f2 - f4) - startPoint.y) - height) / f2;
        }
        fArr[2] = width / f;
        fArr[3] = height / f2;
        return fArr;
    }

    private void b(DuMixInput duMixInput, DuMixOutput duMixOutput) {
        int i;
        Watermark watermark = duMixOutput.getWatermark();
        if (watermark.getRenderRect() != null || watermark.getStartPoint() == null) {
            return;
        }
        int outputWidth = duMixOutput.getOutputWidth();
        int outputHeight = duMixOutput.getOutputHeight();
        if (duMixOutput.getRotationType() == RotationType.ROTATE_90 || duMixOutput.getRotationType() == RotationType.ROTATE_270) {
            outputHeight = outputWidth;
            outputWidth = outputHeight;
        }
        int i2 = 0;
        if (duMixOutput.getScaleType() == ScaleType.CENTER_CROP && duMixInput != null) {
            int inputWidth = duMixInput.getInputWidth();
            int inputHeight = duMixInput.getInputHeight();
            if (duMixInput.getRotationType() == RotationType.ROTATE_90 || duMixInput.getRotationType() == RotationType.ROTATE_270) {
                inputHeight = inputWidth;
                inputWidth = inputHeight;
            }
            new Size(outputWidth, outputHeight);
            Size b = b.b(inputWidth, inputHeight, outputWidth, outputHeight);
            if (b.getWidth() != inputWidth) {
                i2 = (outputWidth - b.getWidth()) / 2;
            } else if (b.getHeight() != inputHeight) {
                i = (outputHeight - b.getHeight()) / 2;
                watermark.setRenderRect(a(watermark, outputWidth, outputHeight, i2, i));
            }
        }
        i = 0;
        watermark.setRenderRect(a(watermark, outputWidth, outputHeight, i2, i));
    }

    private void bG() {
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine != null && aRPEngine.getARPRenderer() != null) {
            this.hx.getARPRenderer().setIsRender(false);
        }
        for (int i = 0; i < 5; i++) {
            ARPEngine aRPEngine2 = this.hx;
            if (aRPEngine2 != null && aRPEngine2.getARPRenderer() != null) {
                this.hx.getARPRenderer().render(System.currentTimeMillis());
            }
        }
        ARPEngine aRPEngine3 = this.hx;
        if (aRPEngine3 != null && aRPEngine3.getARPRenderer() != null) {
            this.hx.getARPRenderer().setIsRender(true);
        }
        ARPEngine aRPEngine4 = this.hx;
        if (aRPEngine4 == null || aRPEngine4.getARPRenderer() == null) {
            return;
        }
        this.hx.getARPRenderer().render(System.currentTimeMillis());
    }

    @Override // com.baidu.ar.arrender.f
    public void L(String str) {
        com.baidu.ar.h.b.c("ARRendererBase", "createCase() casePath = " + str);
        super.L(str);
        com.baidu.ar.lua.a aVar = this.hh;
        if (aVar != null) {
            aVar.fj();
        }
        com.baidu.ar.steploading.d dVar = this.hg;
        if (dVar != null) {
            dVar.switchCase(str);
        }
    }

    public void a(boolean z) {
        g gVar = this.D;
        if (gVar != null) {
            gVar.a(z);
        }
    }

    public void addFrameRenderListener(FrameRenderListener frameRenderListener) {
        List<FrameRenderListener> list;
        if (frameRenderListener == null || (list = this.hj) == null) {
            return;
        }
        list.add(frameRenderListener);
    }

    public void addOutputSurface(DuMixOutput duMixOutput) {
        ARPEngine aRPEngine;
        if (duMixOutput == null || duMixOutput.getOutputSurface() == null || (aRPEngine = this.hx) == null || aRPEngine.getARPRenderer() == null || !(duMixOutput.getOutputSurface() instanceof Surface)) {
            com.baidu.ar.h.b.b("ARRendererBase", "addOutputSurface duMixOutput is error!!!");
            return;
        }
        com.baidu.ar.h.b.c("ARRendererBase", "addOutputSurface() surface = " + duMixOutput.getOutputSurface().hashCode() + " & width*height = " + duMixOutput.getOutputWidth() + "*" + duMixOutput.getOutputHeight() + " & rotation = " + duMixOutput.getRotationType() + " & mode = " + duMixOutput.getScaleType());
        String addOutputSurface = this.hx.getARPRenderer().addOutputSurface((Surface) duMixOutput.getOutputSurface(), duMixOutput.getOutputWidth(), duMixOutput.getOutputHeight(), b.a(duMixOutput.getRotationType(), duMixOutput.getMirriorType()), b.a(duMixOutput.getScaleType()));
        a(addOutputSurface, this.V, duMixOutput);
        p pVar = new p(duMixOutput);
        pVar.Q(addOutputSurface);
        ConcurrentHashMap<DuMixOutput, p> concurrentHashMap = this.hi;
        if (concurrentHashMap != null) {
            concurrentHashMap.put(duMixOutput, pVar);
        }
    }

    @Override // com.baidu.ar.arrender.f
    public void b(Object obj, int i, int i2) {
        super.b(obj, i, i2);
        this.he = false;
    }

    public com.baidu.ar.steploading.d bA() {
        return this.hg;
    }

    @Override // com.baidu.ar.arrender.f
    public void bB() {
        com.baidu.ar.h.b.c("ARRendererBase", "destroyCase()");
        super.bB();
        k kVar = this.hm;
        if (kVar != null) {
            kVar.bU();
            this.hm.bV();
        }
        com.baidu.ar.f.c cVar = this.hf;
        if (cVar != null) {
            cVar.reset();
        }
    }

    @Override // com.baidu.ar.arrender.f
    public void bC() {
        com.baidu.ar.h.b.c("ARRendererBase", "startARPEngine()");
        super.bC();
        com.baidu.ar.arplay.core.engine.a aVar = this.hd;
        if (aVar != null) {
            aVar.h(true);
        }
        a(this.hn);
    }

    @Override // com.baidu.ar.arrender.f
    public void bF() {
        this.hn = this.V.isFrontCamera();
        if (this.W.getOutputFPS() > 0) {
            this.hk = new h(this.W.getOutputFPS());
        }
        k kVar = this.hm;
        if (kVar != null) {
            kVar.g(this.W.getOutputWidth(), this.W.getOutputHeight());
        }
    }

    public void cancelAysncRenderTask(Runnable runnable) {
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null || runnable == null) {
            return;
        }
        this.hx.getARPRenderer().cancelAysncRenderTask(runnable);
    }

    @Override // com.baidu.ar.arrender.f
    public void changeOutput(DuMixOutput duMixOutput) {
        super.changeOutput(duMixOutput);
        this.he = false;
    }

    @Override // com.baidu.ar.arrender.f
    public void changeOutputSize(int i, int i2) {
        super.changeOutputSize(i, i2);
        this.he = false;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null || this.hK) {
            return;
        }
        h hVar = this.hk;
        if (hVar != null && !hVar.bP()) {
            this.hx.getARPRenderer().runSyncOnRenderContext(new Runnable() { // from class: com.baidu.ar.arrender.e.1
                @Override // java.lang.Runnable
                public void run() {
                    DuMixInput duMixInput = e.this.V;
                    if (duMixInput == null || duMixInput.getInputSurface() == null) {
                        return;
                    }
                    e.this.V.getInputSurface().updateTexImage();
                }
            });
        } else if (this.hL) {
            StatisticApi.getPerformanceApi().onFrameIn();
            this.hx.getARPRenderer().render(surfaceTexture.getTimestamp());
            StatisticApi.getPerformanceApi().onFrameOut();
        }
    }

    public void onRenderFinished(long j) {
        List<FrameRenderListener> list = this.hj;
        if (list != null) {
            for (FrameRenderListener frameRenderListener : list) {
                frameRenderListener.onRenderFinished(j);
            }
        }
    }

    public void onRenderStarted(long j) {
        ARPEngine aRPEngine;
        List<FrameRenderListener> list = this.hj;
        if (list != null) {
            for (FrameRenderListener frameRenderListener : list) {
                frameRenderListener.onRenderStarted(j);
            }
        }
        DuMixInput duMixInput = this.V;
        if (duMixInput != null && duMixInput.getInputSurface() != null) {
            this.V.getInputSurface().updateTexImage();
            this.V.getInputSurface().getTransformMatrix(this.ho);
        }
        DuMixInput duMixInput2 = this.V;
        if (duMixInput2 == null || !duMixInput2.isCameraInput() || (aRPEngine = this.hx) == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        if (this.hp == null) {
            float[] fArr = new float[16];
            this.hp = fArr;
            float[] fArr2 = this.ho;
            System.arraycopy(fArr2, 0, fArr, 0, fArr2.length);
        }
        if (!Arrays.equals(this.ho, this.hp)) {
            this.hn = !this.hn;
            float[] fArr3 = this.ho;
            System.arraycopy(fArr3, 0, this.hp, 0, fArr3.length);
        }
        if (this.hq == null) {
            float[] fArr4 = new float[16];
            this.hq = fArr4;
            b.a(this.mContext, fArr4, this.hn);
            this.hx.getARPRenderer().setInputMatrix(this.hq);
        }
        boolean isFrontCamera = this.V.isFrontCamera();
        boolean z = this.hn;
        if (isFrontCamera != z) {
            b.a(this.mContext, this.hq, z);
            this.hx.getARPRenderer().setInputMatrix(this.hq);
            a(this.hn);
        }
    }

    public boolean onTouch(View view2, MotionEvent motionEvent) {
        com.baidu.ar.arplay.core.engine.a aVar = this.hd;
        if (aVar == null) {
            return false;
        }
        if (!this.he) {
            if (view2 != null) {
                aVar.d(view2.getWidth(), view2.getHeight());
            } else {
                DuMixOutput duMixOutput = this.W;
                if (duMixOutput != null) {
                    aVar.d(duMixOutput.getOutputWidth(), this.W.getOutputHeight());
                }
            }
            this.he = true;
        }
        this.hd.onTouchEvent(motionEvent);
        return true;
    }

    @Override // com.baidu.ar.arrender.f
    public void pause() {
        com.baidu.ar.h.b.c("ARRendererBase", "pause()");
        com.baidu.ar.arplay.core.engine.a aVar = this.hd;
        if (aVar != null) {
            aVar.onPause();
        }
        super.pause();
    }

    @Override // com.baidu.ar.arrender.f
    public void release() {
        com.baidu.ar.f.c cVar = this.hf;
        if (cVar != null) {
            cVar.release();
            this.hf = null;
        }
        ConcurrentHashMap<DuMixOutput, p> concurrentHashMap = this.hi;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
            this.hi = null;
        }
        List<FrameRenderListener> list = this.hj;
        if (list != null) {
            list.clear();
            this.hj = null;
        }
        com.baidu.ar.arplay.core.engine.a aVar = this.hd;
        if (aVar != null) {
            aVar.release();
            this.hd = null;
        }
        k kVar = this.hm;
        if (kVar != null) {
            kVar.release();
            this.hm = null;
        }
        com.baidu.ar.lua.a aVar2 = this.hh;
        if (aVar2 != null) {
            aVar2.release();
            this.hh = null;
        }
        com.baidu.ar.steploading.d dVar = this.hg;
        if (dVar != null) {
            dVar.release();
            this.hg = null;
        }
        this.hk = null;
        this.D = null;
        this.ho = null;
        this.hq = null;
        this.hp = null;
        super.release();
    }

    public void removeFrameRenderListener(FrameRenderListener frameRenderListener) {
        List<FrameRenderListener> list;
        if (frameRenderListener == null || (list = this.hj) == null) {
            return;
        }
        list.remove(frameRenderListener);
    }

    public void removeOutputSurface(DuMixOutput duMixOutput) {
        if (duMixOutput == null || duMixOutput.getOutputSurface() == null || !(duMixOutput.getOutputSurface() instanceof Surface)) {
            com.baidu.ar.h.b.b("ARRendererBase", "removeOutputSurface duMixOutput is error!!!");
        } else if (this.hi != null) {
            com.baidu.ar.h.b.c("ARRendererBase", "removeOutputSurface() surface = " + duMixOutput.getOutputSurface().hashCode());
            p remove = this.hi.remove(duMixOutput);
            ARPEngine aRPEngine = this.hx;
            if (aRPEngine == null || aRPEngine.getARPRenderer() == null || remove == null || TextUtils.isEmpty(remove.ca())) {
                return;
            }
            this.hx.getARPRenderer().removeOutputTargetByAddr(remove.ca());
        }
    }

    public void render() {
        DuMixInput duMixInput = this.V;
        if (duMixInput != null && duMixInput.isSingleFrame()) {
            bG();
        }
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.hx.getARPRenderer().render(System.currentTimeMillis());
    }

    @Override // com.baidu.ar.arrender.f
    public void resume() {
        com.baidu.ar.h.b.c("ARRendererBase", "resume()");
        super.resume();
        com.baidu.ar.arplay.core.engine.a aVar = this.hd;
        if (aVar != null) {
            aVar.onResume();
        }
    }

    public void runAsyncOnRenderContext(Runnable runnable) {
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null || runnable == null) {
            return;
        }
        this.hx.getARPRenderer().runAsyncOnRenderContext(runnable);
    }

    public void runSyncOnRenderContext(Runnable runnable) {
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null || runnable == null) {
            return;
        }
        this.hx.getARPRenderer().runSyncOnRenderContext(runnable);
    }

    public void setCameraSwitchListener(g gVar) {
        this.D = gVar;
    }

    public void setDefaultPipeLine(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "filter_pipeline = function()\n\n    fm = ae.FilterManager:get_instance();\n\n    global_copy_filter = fm:create_filter(\"Tex2DFilter\", \"globalTex2DFilter\", true);\n    gl_makeup_filer = fm:create_filter(\"BeautyMakeupFilter\",\"globalBeautyMakeupFilter\",true);\n\n    skin_filter = fm:create_filter(\"SkinFilter\", \"globalSkinFilter\", true);\n    engine_filter = fm:create_filter(\"EngineFilter\", \"globalEngineFilter\", true);\n    fm:update_property_int(engine_filter, \"is_enable\", 0);\n    face_filter = fm:create_filter(\"FaceFilter\", \"globalFaceFilter\", true);\n    lut_filter = fm:create_filter(\"LUTFilter\", \"globalLutFilter\", true);\n    tune_color_filter = fm:create_filter(\"TuneColorFilter\", \"globalTuneColorFilter\", true);\n    fm:reset_pipeline();\n\n    fm:connect_filters_by_id(skin_filter, gl_makeup_filer);\n    fm:connect_filters_by_id(skin_filter, global_copy_filter);\n    fm:connect_filters_by_id(global_copy_filter, gl_makeup_filer);\n    fm:connect_filters_by_id(gl_makeup_filer, face_filter);\n    fm:connect_filters_by_id(face_filter, tune_color_filter);\n    fm:connect_filters_by_id(tune_color_filter, engine_filter);\n    fm:connect_filters_by_id(engine_filter, lut_filter);\n\n    fm:connect_filter_to_camera(skin_filter);\n    fm:connect_filter_to_output(lut_filter);\n\nend\n\nfilter_pipeline()\n\n";
        }
        this.aG = str;
    }

    public void setInputMatrix(float[] fArr) {
        ARPEngine aRPEngine = this.hx;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.hx.getARPRenderer().setInputMatrix(fArr);
    }

    public void setStateListener(DuMixStateListener duMixStateListener) {
        this.hH = duMixStateListener;
    }
}
