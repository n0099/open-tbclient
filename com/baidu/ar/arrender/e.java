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
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public abstract class e extends f implements View.OnTouchListener, OnRenderFinishedListener, OnRenderStartedListener, IRenderer {
    private g D;
    com.baidu.ar.arplay.core.engine.a hd;
    private boolean he;
    private com.baidu.ar.f.c hf;
    private com.baidu.ar.steploading.d hg;
    private com.baidu.ar.lua.a hh;
    private ConcurrentHashMap<DuMixOutput, p> hi;
    private List<FrameRenderListener> hj;
    private h hk;
    protected boolean hl;
    private k hm;
    boolean hn;
    float[] ho;
    private float[] hp;
    private float[] hq;

    public e(Context context, Looper looper, com.baidu.ar.lua.b bVar, EGLContext eGLContext, String str) {
        super(context, bVar, eGLContext, str);
        this.he = false;
        this.hj = Collections.synchronizedList(new ArrayList());
        this.hl = false;
        this.hn = false;
        this.ho = new float[16];
        this.hd = new com.baidu.ar.arplay.core.engine.a(Looper.getMainLooper());
        this.hf = new com.baidu.ar.f.c(context);
        this.hf.b(this.f);
        this.hh = new com.baidu.ar.lua.a();
        this.hh.b(this.f);
        this.hg = new com.baidu.ar.steploading.d(context);
        this.hg.b(this.f);
        this.hi = new ConcurrentHashMap<>();
        this.hl = com.baidu.ar.h.p.A(this.mContext);
        this.hd.setScreenOrientationLandscape(this.hl);
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
        switch (watermark.getCoordinateType()) {
            case LEFT_TOP:
                fArr[0] = (startPoint.x + f3) / f;
                fArr[1] = (startPoint.y + f4) / f2;
                break;
            case LEFT_BOTTOM:
                fArr[0] = (startPoint.x + f3) / f;
                fArr[1] = (((f2 - f4) - startPoint.y) - height) / f2;
                break;
            case RIGHT_TOP:
                fArr[0] = (((f - f3) - startPoint.x) - width) / f;
                fArr[1] = (startPoint.y + f4) / f2;
                break;
            case RIGHT_BOTTOM:
                fArr[0] = (((f - f3) - startPoint.x) - width) / f;
                fArr[1] = (((f2 - f4) - startPoint.y) - height) / f2;
                break;
        }
        fArr[2] = width / f;
        fArr[3] = height / f2;
        return fArr;
    }

    private void b(DuMixInput duMixInput, DuMixOutput duMixOutput) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Watermark watermark = duMixOutput.getWatermark();
        if (watermark.getRenderRect() != null || watermark.getStartPoint() == null) {
            return;
        }
        int outputWidth = duMixOutput.getOutputWidth();
        int outputHeight = duMixOutput.getOutputHeight();
        if (duMixOutput.getRotationType() == RotationType.ROTATE_90 || duMixOutput.getRotationType() == RotationType.ROTATE_270) {
            i = outputWidth;
            i2 = outputHeight;
        } else {
            i = outputHeight;
            i2 = outputWidth;
        }
        if (duMixOutput.getScaleType() == ScaleType.CENTER_CROP && duMixInput != null) {
            int inputWidth = duMixInput.getInputWidth();
            int inputHeight = duMixInput.getInputHeight();
            if (duMixInput.getRotationType() == RotationType.ROTATE_90 || duMixInput.getRotationType() == RotationType.ROTATE_270) {
                i5 = inputWidth;
                i6 = inputHeight;
            } else {
                i5 = inputHeight;
                i6 = inputWidth;
            }
            new Size(i2, i);
            Size b2 = b.b(i6, i5, i2, i);
            if (b2.getWidth() != i6) {
                i3 = 0;
                i4 = (i2 - b2.getWidth()) / 2;
            } else if (b2.getHeight() != i5) {
                i3 = (i - b2.getHeight()) / 2;
                i4 = 0;
            }
            watermark.setRenderRect(a(watermark, i2, i, i4, i3));
        }
        i3 = 0;
        i4 = 0;
        watermark.setRenderRect(a(watermark, i2, i, i4, i3));
    }

    private void bG() {
        if (this.hx != null && this.hx.getARPRenderer() != null) {
            this.hx.getARPRenderer().setIsRender(false);
        }
        for (int i = 0; i < 5; i++) {
            if (this.hx != null && this.hx.getARPRenderer() != null) {
                this.hx.getARPRenderer().render(System.currentTimeMillis());
            }
        }
        if (this.hx != null && this.hx.getARPRenderer() != null) {
            this.hx.getARPRenderer().setIsRender(true);
        }
        if (this.hx == null || this.hx.getARPRenderer() == null) {
            return;
        }
        this.hx.getARPRenderer().render(System.currentTimeMillis());
    }

    @Override // com.baidu.ar.arrender.f
    public void L(String str) {
        com.baidu.ar.h.b.c("ARRendererBase", "createCase() casePath = " + str);
        super.L(str);
        if (this.hh != null) {
            this.hh.fj();
        }
        if (this.hg != null) {
            this.hg.switchCase(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z) {
        if (this.D != null) {
            this.D.a(z);
        }
    }

    public void addFrameRenderListener(FrameRenderListener frameRenderListener) {
        if (frameRenderListener == null || this.hj == null) {
            return;
        }
        this.hj.add(frameRenderListener);
    }

    public void addOutputSurface(DuMixOutput duMixOutput) {
        if (duMixOutput == null || duMixOutput.getOutputSurface() == null || this.hx == null || this.hx.getARPRenderer() == null || !(duMixOutput.getOutputSurface() instanceof Surface)) {
            com.baidu.ar.h.b.b("ARRendererBase", "addOutputSurface duMixOutput is error!!!");
            return;
        }
        com.baidu.ar.h.b.c("ARRendererBase", "addOutputSurface() surface = " + duMixOutput.getOutputSurface().hashCode() + " & width*height = " + duMixOutput.getOutputWidth() + "*" + duMixOutput.getOutputHeight() + " & rotation = " + duMixOutput.getRotationType() + " & mode = " + duMixOutput.getScaleType());
        String addOutputSurface = this.hx.getARPRenderer().addOutputSurface((Surface) duMixOutput.getOutputSurface(), duMixOutput.getOutputWidth(), duMixOutput.getOutputHeight(), b.a(duMixOutput.getRotationType(), duMixOutput.getMirriorType()), b.a(duMixOutput.getScaleType()));
        a(addOutputSurface, this.V, duMixOutput);
        p pVar = new p(duMixOutput);
        pVar.Q(addOutputSurface);
        if (this.hi != null) {
            this.hi.put(duMixOutput, pVar);
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
        if (this.hm != null) {
            this.hm.bU();
            this.hm.bV();
        }
        if (this.hf != null) {
            this.hf.reset();
        }
    }

    @Override // com.baidu.ar.arrender.f
    public void bC() {
        com.baidu.ar.h.b.c("ARRendererBase", "startARPEngine()");
        super.bC();
        if (this.hd != null) {
            this.hd.h(true);
        }
        a(this.hn);
    }

    @Override // com.baidu.ar.arrender.f
    void bF() {
        this.hn = this.V.isFrontCamera();
        if (this.W.getOutputFPS() > 0) {
            this.hk = new h(this.W.getOutputFPS());
        }
        if (this.hm != null) {
            this.hm.g(this.W.getOutputWidth(), this.W.getOutputHeight());
        }
    }

    public void cancelAysncRenderTask(Runnable runnable) {
        if (this.hx == null || this.hx.getARPRenderer() == null || runnable == null) {
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
        if (this.hx == null || this.hx.getARPRenderer() == null || this.hK) {
            return;
        }
        if (this.hk != null && !this.hk.bP()) {
            this.hx.getARPRenderer().runSyncOnRenderContext(new Runnable() { // from class: com.baidu.ar.arrender.e.1
                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.V == null || e.this.V.getInputSurface() == null) {
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
        if (this.hj != null) {
            for (FrameRenderListener frameRenderListener : this.hj) {
                frameRenderListener.onRenderFinished(j);
            }
        }
    }

    public void onRenderStarted(long j) {
        if (this.hj != null) {
            for (FrameRenderListener frameRenderListener : this.hj) {
                frameRenderListener.onRenderStarted(j);
            }
        }
        if (this.V != null && this.V.getInputSurface() != null) {
            this.V.getInputSurface().updateTexImage();
            this.V.getInputSurface().getTransformMatrix(this.ho);
        }
        if (this.V == null || !this.V.isCameraInput() || this.hx == null || this.hx.getARPRenderer() == null) {
            return;
        }
        if (this.hp == null) {
            this.hp = new float[16];
            System.arraycopy(this.ho, 0, this.hp, 0, this.ho.length);
        }
        if (!Arrays.equals(this.ho, this.hp)) {
            this.hn = !this.hn;
            System.arraycopy(this.ho, 0, this.hp, 0, this.ho.length);
        }
        if (this.hq == null) {
            this.hq = new float[16];
            b.a(this.mContext, this.hq, this.hn);
            this.hx.getARPRenderer().setInputMatrix(this.hq);
        }
        if (this.V.isFrontCamera() != this.hn) {
            b.a(this.mContext, this.hq, this.hn);
            this.hx.getARPRenderer().setInputMatrix(this.hq);
            a(this.hn);
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.hd == null) {
            return false;
        }
        if (!this.he) {
            if (view != null) {
                this.hd.d(view.getWidth(), view.getHeight());
            } else if (this.W != null) {
                this.hd.d(this.W.getOutputWidth(), this.W.getOutputHeight());
            }
            this.he = true;
        }
        this.hd.onTouchEvent(motionEvent);
        return true;
    }

    @Override // com.baidu.ar.arrender.f
    public void pause() {
        com.baidu.ar.h.b.c("ARRendererBase", "pause()");
        if (this.hd != null) {
            this.hd.onPause();
        }
        super.pause();
    }

    @Override // com.baidu.ar.arrender.f
    public void release() {
        if (this.hf != null) {
            this.hf.release();
            this.hf = null;
        }
        if (this.hi != null) {
            this.hi.clear();
            this.hi = null;
        }
        if (this.hj != null) {
            this.hj.clear();
            this.hj = null;
        }
        if (this.hd != null) {
            this.hd.release();
            this.hd = null;
        }
        if (this.hm != null) {
            this.hm.release();
            this.hm = null;
        }
        if (this.hh != null) {
            this.hh.release();
            this.hh = null;
        }
        if (this.hg != null) {
            this.hg.release();
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
        if (frameRenderListener == null || this.hj == null) {
            return;
        }
        this.hj.remove(frameRenderListener);
    }

    public void removeOutputSurface(DuMixOutput duMixOutput) {
        if (duMixOutput == null || duMixOutput.getOutputSurface() == null || !(duMixOutput.getOutputSurface() instanceof Surface)) {
            com.baidu.ar.h.b.b("ARRendererBase", "removeOutputSurface duMixOutput is error!!!");
        } else if (this.hi != null) {
            com.baidu.ar.h.b.c("ARRendererBase", "removeOutputSurface() surface = " + duMixOutput.getOutputSurface().hashCode());
            p remove = this.hi.remove(duMixOutput);
            if (this.hx == null || this.hx.getARPRenderer() == null || remove == null || TextUtils.isEmpty(remove.ca())) {
                return;
            }
            this.hx.getARPRenderer().removeOutputTargetByAddr(remove.ca());
        }
    }

    public void render() {
        if (this.V != null && this.V.isSingleFrame()) {
            bG();
        }
        if (this.hx == null || this.hx.getARPRenderer() == null) {
            return;
        }
        this.hx.getARPRenderer().render(System.currentTimeMillis());
    }

    @Override // com.baidu.ar.arrender.f
    public void resume() {
        com.baidu.ar.h.b.c("ARRendererBase", "resume()");
        super.resume();
        if (this.hd != null) {
            this.hd.onResume();
        }
    }

    public void runAsyncOnRenderContext(Runnable runnable) {
        if (this.hx == null || this.hx.getARPRenderer() == null || runnable == null) {
            return;
        }
        this.hx.getARPRenderer().runAsyncOnRenderContext(runnable);
    }

    public void runSyncOnRenderContext(Runnable runnable) {
        if (this.hx == null || this.hx.getARPRenderer() == null || runnable == null) {
            return;
        }
        this.hx.getARPRenderer().runSyncOnRenderContext(runnable);
    }

    public void setCameraSwitchListener(g gVar) {
        this.D = gVar;
    }

    public void setDefaultPipeLine(String str) {
        if (TextUtils.isEmpty(str)) {
            this.aG = "filter_pipeline = function()\n\n    fm = ae.FilterManager:get_instance();\n\n    global_copy_filter = fm:create_filter(\"Tex2DFilter\", \"globalTex2DFilter\", true);\n    gl_makeup_filer = fm:create_filter(\"BeautyMakeupFilter\",\"globalBeautyMakeupFilter\",true);\n\n    skin_filter = fm:create_filter(\"SkinFilter\", \"globalSkinFilter\", true);\n    engine_filter = fm:create_filter(\"EngineFilter\", \"globalEngineFilter\", true);\n    fm:update_property_int(engine_filter, \"is_enable\", 0);\n    face_filter = fm:create_filter(\"FaceFilter\", \"globalFaceFilter\", true);\n    lut_filter = fm:create_filter(\"LUTFilter\", \"globalLutFilter\", true);\n    tune_color_filter = fm:create_filter(\"TuneColorFilter\", \"globalTuneColorFilter\", true);\n    fm:reset_pipeline();\n\n    fm:connect_filters_by_id(skin_filter, gl_makeup_filer);\n    fm:connect_filters_by_id(skin_filter, global_copy_filter);\n    fm:connect_filters_by_id(global_copy_filter, gl_makeup_filer);\n    fm:connect_filters_by_id(gl_makeup_filer, face_filter);\n    fm:connect_filters_by_id(face_filter, tune_color_filter);\n    fm:connect_filters_by_id(tune_color_filter, engine_filter);\n    fm:connect_filters_by_id(engine_filter, lut_filter);\n\n    fm:connect_filter_to_camera(skin_filter);\n    fm:connect_filter_to_output(lut_filter);\n\nend\n\nfilter_pipeline()\n\n";
        } else {
            this.aG = str;
        }
    }

    public void setInputMatrix(float[] fArr) {
        if (this.hx == null || this.hx.getARPRenderer() == null) {
            return;
        }
        this.hx.getARPRenderer().setInputMatrix(fArr);
    }

    public void setStateListener(DuMixStateListener duMixStateListener) {
        this.hH = duMixStateListener;
    }
}
