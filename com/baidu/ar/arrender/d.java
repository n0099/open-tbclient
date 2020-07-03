package com.baidu.ar.arrender;

import android.content.Context;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import com.baidu.ar.DuMixInput;
import com.baidu.ar.DuMixInput2;
import com.baidu.ar.DuMixOutput;
import com.baidu.ar.DuMixOutput2;
import com.baidu.ar.arplay.core.engine.pixel.PixelRotation;
import com.baidu.ar.bean.Size;
/* loaded from: classes3.dex */
public class d extends c implements IGLRenderer {
    private DuMixOutput2 hA;
    private String hB;
    private String hC;
    private String hD;
    private String hE;
    private String hF;
    private String hy;
    private DuMixInput2 hz;

    public d(Context context, com.baidu.ar.lua.b bVar, EGLContext eGLContext) {
        super(context, bVar, eGLContext);
        this.hB = "";
        this.hC = "";
        this.hD = "qcom";
        this.hE = "msm8953";
        this.hF = "sdm632";
        this.hB = Build.HARDWARE.toLowerCase();
        this.hC = Build.BOARD.toLowerCase();
    }

    private void a(int i, int i2, int i3, int i4, PixelRotation pixelRotation) {
        com.baidu.ar.f.b.c("ARRenderer2", "addOutputTarget() textureId = " + i2 + " & width*height = " + i3 + "*" + i4);
        if (this.hO != null) {
            this.hy = this.hO.addOutputTarget(i, i2, i3, i4, pixelRotation);
        }
    }

    private void bz() {
        if (this.hO != null) {
            String str = this.hy;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.hO.removeOutputTargetByAddr(str);
        }
    }

    @Override // com.baidu.ar.arrender.c, com.baidu.ar.arrender.e
    public void a(DuMixInput duMixInput, DuMixOutput duMixOutput) {
        com.baidu.ar.f.b.c("ARRenderer2", "setup()");
        if (!(duMixInput instanceof DuMixInput2) || !(duMixOutput instanceof DuMixOutput2)) {
            com.baidu.ar.f.b.b("ARRenderer2", "please setup with DuMixInput2 && DuMixOutput2");
            return;
        }
        this.hz = (DuMixInput2) duMixInput;
        this.hA = (DuMixOutput2) duMixOutput;
        this.W = duMixInput;
        this.aa = duMixOutput;
        this.hO.setUpEGLEnv(this.ic);
        this.hO.setCameraFace(duMixInput.isFrontCamera());
        PixelRotation a = b.a(duMixInput.isCameraInput(), duMixInput.getInputDegree());
        com.baidu.ar.arplay.core.engine.b bVar = com.baidu.ar.arplay.core.engine.b.INTERNAL_2D_TEX;
        if (((DuMixInput2) duMixInput).isSyncInputContent()) {
            this.hO.createSyncInputSource(a, bVar);
        } else {
            this.hO.createInputSource(a, bVar);
        }
        if (((DuMixInput2) duMixInput).getInputTexture() != null) {
            setInputTexture(((DuMixInput2) duMixInput).getInputTexture().getType(), ((DuMixInput2) duMixInput).getInputTexture().getId(), duMixInput.getInputWidth(), duMixInput.getInputHeight());
        }
        if (((DuMixOutput2) duMixOutput).getOutputTexture() != null) {
            a(((DuMixOutput2) duMixOutput).getOutputTexture().getType(), ((DuMixOutput2) duMixOutput).getOutputTexture().getId(), duMixOutput.getOutputWidth(), duMixOutput.getOutputHeight(), b.a(duMixOutput.getRotationType(), duMixOutput.getMirriorType()));
        }
        this.hO.setOnRenderStartedListener(this);
        this.hO.setOnRenderFinishedListener(this);
        bA();
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void bindTargetSurface(Surface surface) {
        if (this.hO != null) {
            this.hO.bindTargetSurface(surface);
        }
    }

    @Override // com.baidu.ar.arrender.c, com.baidu.ar.arrender.e
    public void changeOutput(DuMixOutput duMixOutput) {
        if (duMixOutput instanceof DuMixOutput2) {
            bz();
            this.hA = (DuMixOutput2) duMixOutput;
            a(this.hA.getOutputTexture().getType(), this.hA.getOutputTexture().getId(), this.hA.getOutputWidth(), this.hA.getOutputHeight(), b.a(this.hA.getRotationType(), this.hA.getMirriorType()));
            if (this.hP != null) {
                Size a = a(a(this.hz));
                this.hP.setWindowSize(a.getWidth(), a.getHeight());
            }
        }
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public Texture createTexture(int i, int i2, int i3) {
        if (this.hO != null) {
            Texture texture = new Texture();
            long createTexture = this.hO.createTexture(i, i2, i3);
            texture.setHandle(createTexture);
            texture.setId(this.hO.getTextureId(createTexture));
            texture.setType(i);
            return texture;
        }
        return null;
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void destroyTexture(Texture texture) {
        if (texture == null || this.hO == null) {
            return;
        }
        this.hO.destroyTexture(texture.getHandle());
    }

    @Override // com.baidu.ar.arrender.c, com.baidu.ar.arrender.e, com.baidu.ar.arplay.core.filter.OnRenderFinishedListener
    public void onRenderFinished() {
        super.onRenderFinished();
        if (TextUtils.isEmpty(this.hB) || !this.hB.contains(this.hD) || TextUtils.isEmpty(this.hC)) {
            return;
        }
        if (this.hC.contains(this.hE) || this.hC.contains(this.hF)) {
            GLES20.glFinish();
        }
    }

    @Override // com.baidu.ar.arrender.c, com.baidu.ar.arrender.e
    public void release() {
        super.release();
        this.hy = null;
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void render() {
        if (this.hO != null) {
            this.hO.render();
        }
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void runSyncOnIOContext(Runnable runnable) {
        if (this.hO == null || runnable == null) {
            return;
        }
        this.hO.runSyncOnIOContext(runnable);
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void setInputMatrix(float[] fArr) {
        if (this.hO != null) {
            this.hO.setInputMatrix(fArr);
        }
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void setInputTexture(int i, int i2, int i3, int i4) {
        if (this.hO != null) {
            this.hO.setInputTexture(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void swapBuffer() {
        if (this.hO != null) {
            this.hO.swapBuffer();
        }
    }
}
