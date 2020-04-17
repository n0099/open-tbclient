package com.baidu.ar.arrender;

import android.content.Context;
import android.opengl.EGLContext;
import android.opengl.GLES20;
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
    private String ho;
    private DuMixInput2 hp;
    private DuMixOutput2 hq;
    private String hr;

    public d(Context context, com.baidu.ar.lua.b bVar, EGLContext eGLContext) {
        super(context, bVar, eGLContext);
        this.hr = "";
    }

    private void a(int i, int i2, int i3, int i4, PixelRotation pixelRotation) {
        com.baidu.ar.f.b.c("ARRenderer2", "addOutputTarget() textureId = " + i2 + " & width*height = " + i3 + "*" + i4);
        if (this.hA != null) {
            this.ho = this.hA.addOutputTarget(i, i2, i3, i4, pixelRotation);
        }
    }

    private void bk() {
        if (this.hA != null) {
            String str = this.ho;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.hA.removeOutputTargetByAddr(str);
        }
    }

    @Override // com.baidu.ar.arrender.c, com.baidu.ar.arrender.e
    public void a(DuMixInput duMixInput, DuMixOutput duMixOutput) {
        com.baidu.ar.f.b.c("ARRenderer2", "setup()");
        if (!(duMixInput instanceof DuMixInput2) || !(duMixOutput instanceof DuMixOutput2)) {
            com.baidu.ar.f.b.b("ARRenderer2", "please setup with DuMixInput2 && DuMixOutput2");
            return;
        }
        this.hp = (DuMixInput2) duMixInput;
        this.hq = (DuMixOutput2) duMixOutput;
        this.aa = duMixInput;
        this.ab = duMixOutput;
        this.hA.setCameraFace(duMixInput.isFrontCamera());
        PixelRotation a = b.a(duMixInput.isCameraInput(), duMixInput.getInputDegree());
        com.baidu.ar.arplay.core.engine.b bVar = com.baidu.ar.arplay.core.engine.b.INTERNAL_2D_TEX;
        if (((DuMixInput2) duMixInput).isSyncInputContent()) {
            this.hA.createSyncInputSource(a, bVar);
        } else {
            this.hA.createInputSource(a, bVar);
        }
        if (((DuMixInput2) duMixInput).getInputTexture() != null) {
            setInputTexture(((DuMixInput2) duMixInput).getInputTexture().getType(), ((DuMixInput2) duMixInput).getInputTexture().getId(), duMixInput.getInputWidth(), duMixInput.getInputHeight());
        }
        if (((DuMixOutput2) duMixOutput).getOutputTexture() != null) {
            a(((DuMixOutput2) duMixOutput).getOutputTexture().getType(), ((DuMixOutput2) duMixOutput).getOutputTexture().getId(), duMixOutput.getOutputWidth(), duMixOutput.getOutputHeight(), b.a(duMixOutput.getRotationType(), duMixOutput.getMirriorType()));
        }
        this.hA.setOnRenderStartedListener(this);
        this.hA.setOnRenderFinishedListener(this);
        bl();
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void bindTargetSurface(Surface surface) {
        if (this.hA != null) {
            this.hA.bindTargetSurface(surface);
        }
    }

    @Override // com.baidu.ar.arrender.c, com.baidu.ar.arrender.e
    public void changeOutput(DuMixOutput duMixOutput) {
        if (duMixOutput instanceof DuMixOutput2) {
            bk();
            this.hq = (DuMixOutput2) duMixOutput;
            a(this.hq.getOutputTexture().getType(), this.hq.getOutputTexture().getId(), this.hq.getOutputWidth(), this.hq.getOutputHeight(), b.a(this.hq.getRotationType(), this.hq.getMirriorType()));
            if (this.hB != null) {
                Size a = a(a(this.hp));
                this.hB.setWindowSize(a.getWidth(), a.getHeight());
            }
        }
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public Texture createTexture(int i, int i2, int i3) {
        if (this.hA != null) {
            Texture texture = new Texture();
            long createTexture = this.hA.createTexture(i, i2, i3);
            texture.setHandle(createTexture);
            texture.setId(this.hA.getTextureId(createTexture));
            texture.setType(i);
            return texture;
        }
        return null;
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void destroyTexture(Texture texture) {
        if (texture == null || this.hA == null) {
            return;
        }
        this.hA.destroyTexture(texture.getHandle());
    }

    @Override // com.baidu.ar.arrender.c, com.baidu.ar.arrender.e, com.baidu.ar.arplay.core.filter.OnRenderFinishedListener
    public void onRenderFinished() {
        super.onRenderFinished();
        if (TextUtils.isEmpty(this.hr)) {
            this.hr = GLES20.glGetString(7937);
        }
        if ("Adreno (TM) 506".equals(this.hr)) {
            GLES20.glFinish();
        }
    }

    @Override // com.baidu.ar.arrender.c, com.baidu.ar.arrender.e
    public void release() {
        super.release();
        this.ho = null;
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void render() {
        if (this.hA != null) {
            this.hA.render();
        }
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void runSyncOnIOContext(Runnable runnable) {
        if (this.hA == null || runnable == null) {
            return;
        }
        this.hA.runSyncOnIOContext(runnable);
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void setInputMatrix(float[] fArr) {
        if (this.hA != null) {
            this.hA.setInputMatrix(fArr);
        }
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void setInputTexture(int i, int i2, int i3, int i4) {
        if (this.hA != null) {
            this.hA.setInputTexture(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.ar.arrender.IGLRenderer
    public void swapBuffer() {
        if (this.hA != null) {
            this.hA.swapBuffer();
        }
    }
}
