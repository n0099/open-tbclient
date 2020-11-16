package com.baidu.ar.arrender;

import android.content.Context;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import com.baidu.ar.DuMixInput;
import com.baidu.ar.DuMixOutput;
import com.baidu.ar.arplay.core.engine.pixel.PixelRotation;
import com.baidu.ar.bean.MirriorType;
import com.baidu.ar.bean.Size;
/* loaded from: classes12.dex */
public class d extends c implements IGLRenderer {
    private String gO;
    private String gP;
    private String gQ;

    public d(Context context, Looper looper, com.baidu.ar.lua.b bVar, EGLContext eGLContext) {
        super(context, looper, bVar, eGLContext);
        this.gO = "";
        this.gP = "";
        this.gO = Build.HARDWARE.toLowerCase();
        this.gP = Build.BOARD.toLowerCase();
    }

    private void a(int i, int i2, int i3, int i4, PixelRotation pixelRotation) {
        com.baidu.ar.g.b.c("ARRenderer2", "addOutputTarget() textureId = " + i2 + " & width*height = " + i3 + "*" + i4);
        if (this.gZ != null) {
            this.gQ = this.gZ.addOutputTarget(i, i2, i3, i4, pixelRotation);
        }
    }

    private void bI() {
        if (this.gZ != null) {
            String str = this.gQ;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.gZ.removeOutputTargetByAddr(str);
        }
    }

    @Override // com.baidu.ar.arrender.c, com.baidu.ar.arrender.e
    public void a(DuMixInput duMixInput, DuMixOutput duMixOutput) {
        com.baidu.ar.g.b.c("ARRenderer2", "setup()");
        if (duMixInput == null || duMixOutput == null || this.gZ == null) {
            return;
        }
        this.W = duMixInput;
        this.aa = duMixOutput;
        this.gZ.setUpEGLEnv(this.hp);
        this.gZ.setCameraFace(duMixInput.isFrontCamera());
        PixelRotation a2 = b.a(duMixInput.isCameraInput() && duMixInput.isFitCameraAuto(), duMixInput.getRotationType(), MirriorType.VERTICAL_MIRRIOR);
        com.baidu.ar.arplay.core.engine.c cVar = com.baidu.ar.arplay.core.engine.c.INTERNAL_2D_TEX;
        if (duMixInput.isSyncInputContent()) {
            this.gZ.createSyncInputSource(a2, cVar);
        } else {
            this.gZ.createInputSource(a2, cVar);
        }
        if (duMixInput.getInputTexture() != null) {
            setInputTexture(duMixInput.getInputTexture().getType(), duMixInput.getInputTexture().getId(), duMixInput.getInputWidth(), duMixInput.getInputHeight());
        }
        if (duMixOutput.getOutputTexture() != null) {
            a(duMixOutput.getOutputTexture().getType(), duMixOutput.getOutputTexture().getId(), duMixOutput.getOutputWidth(), duMixOutput.getOutputHeight(), b.a(duMixOutput.getRotationType(), duMixOutput.getMirriorType()));
        }
        this.gZ.setOnRenderStartedListener(this);
        this.gZ.setOnRenderFinishedListener(this);
        bJ();
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void bindTargetSurface(Surface surface) {
        if (this.gZ != null) {
            this.gZ.bindTargetSurface(surface);
        }
    }

    @Override // com.baidu.ar.arrender.c, com.baidu.ar.arrender.e
    public void changeOutput(DuMixOutput duMixOutput) {
        bI();
        this.aa = duMixOutput;
        a(this.aa.getOutputTexture().getType(), this.aa.getOutputTexture().getId(), this.aa.getOutputWidth(), this.aa.getOutputHeight(), b.a(this.aa.getRotationType(), this.aa.getMirriorType()));
        if (this.ha != null) {
            Size a2 = a(a(this.W));
            this.ha.setWindowSize(a2.getWidth(), a2.getHeight());
        }
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public Texture createTexture(int i, int i2, int i3) {
        if (this.gZ != null) {
            Texture texture = new Texture();
            long createTexture = this.gZ.createTexture(i, i2, i3);
            texture.setHandle(createTexture);
            texture.setId(this.gZ.getTextureId(createTexture));
            texture.setType(i);
            return texture;
        }
        return null;
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void destroyTexture(Texture texture) {
        if (texture == null || this.gZ == null) {
            return;
        }
        this.gZ.destroyTexture(texture.getHandle());
    }

    @Override // com.baidu.ar.arrender.c, com.baidu.ar.arrender.e, com.baidu.ar.arplay.core.filter.OnRenderFinishedListener
    public void onRenderFinished(long j) {
        super.onRenderFinished(j);
        if (TextUtils.isEmpty(this.gO) || !this.gO.contains("qcom") || TextUtils.isEmpty(this.gP)) {
            return;
        }
        if (this.gP.contains("msm8953") || this.gP.contains("sdm632")) {
            GLES20.glFinish();
        }
    }

    @Override // com.baidu.ar.arrender.c, com.baidu.ar.arrender.e
    public void release() {
        super.release();
        this.gQ = null;
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void render() {
        if (this.W != null && this.W.isSingleFrame()) {
            if (this.gZ != null) {
                this.gZ.setIsRender(false);
            }
            for (int i = 0; i < 5; i++) {
                if (this.gZ != null) {
                    this.gZ.render(System.currentTimeMillis());
                }
            }
            if (this.gZ != null) {
                this.gZ.setIsRender(true);
            }
            if (this.gZ != null) {
                this.gZ.render(System.currentTimeMillis());
            }
        }
        if (this.gZ != null) {
            this.gZ.render(System.currentTimeMillis());
        }
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void runSyncOnIOContext(Runnable runnable) {
        if (this.gZ == null || runnable == null) {
            return;
        }
        this.gZ.runSyncOnIOContext(runnable);
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void setInputMatrix(float[] fArr) {
        if (this.gZ != null) {
            this.gZ.setInputMatrix(fArr);
        }
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void setInputTexture(int i, int i2, int i3, int i4) {
        if (this.gZ != null) {
            this.gZ.setInputTexture(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void swapBuffer() {
        if (this.gZ != null) {
            this.gZ.swapBuffer();
        }
    }
}
