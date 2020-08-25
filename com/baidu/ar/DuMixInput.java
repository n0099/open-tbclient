package com.baidu.ar;

import android.graphics.SurfaceTexture;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.ar.arrender.Texture;
import com.baidu.ar.bean.MirriorType;
import com.baidu.ar.bean.RotationType;
/* loaded from: classes11.dex */
public class DuMixInput {
    private int R;
    private int S;
    private SurfaceTexture be;
    private Texture bf;
    private boolean bg;
    private boolean bh;
    private RotationType bi;
    private MirriorType bj;
    private boolean bk;
    private boolean bl;
    private boolean mFrontCamera;

    public DuMixInput() {
        this.R = 0;
        this.S = 0;
        this.bg = true;
        this.mFrontCamera = true;
        this.bh = true;
        this.bi = RotationType.ROTATE_90;
        this.bj = MirriorType.NO_MIRRIOR;
        this.bk = false;
        this.bl = false;
    }

    public DuMixInput(int i, int i2) {
        this.R = 0;
        this.S = 0;
        this.bg = true;
        this.mFrontCamera = true;
        this.bh = true;
        this.bi = RotationType.ROTATE_90;
        this.bj = MirriorType.NO_MIRRIOR;
        this.bk = false;
        this.bl = false;
        this.R = i;
        this.S = i2;
    }

    public DuMixInput(SurfaceTexture surfaceTexture, int i, int i2) {
        this.R = 0;
        this.S = 0;
        this.bg = true;
        this.mFrontCamera = true;
        this.bh = true;
        this.bi = RotationType.ROTATE_90;
        this.bj = MirriorType.NO_MIRRIOR;
        this.bk = false;
        this.bl = false;
        this.be = surfaceTexture;
        this.R = i;
        this.S = i2;
    }

    public DuMixInput(Texture texture, int i, int i2) {
        this.R = 0;
        this.S = 0;
        this.bg = true;
        this.mFrontCamera = true;
        this.bh = true;
        this.bi = RotationType.ROTATE_90;
        this.bj = MirriorType.NO_MIRRIOR;
        this.bk = false;
        this.bl = false;
        this.bf = texture;
        this.R = i;
        this.S = i2;
    }

    public int getInputDegree() {
        return this.bi.getDegree();
    }

    public int getInputHeight() {
        return this.S;
    }

    public SurfaceTexture getInputSurface() {
        return this.be;
    }

    public Texture getInputTexture() {
        return this.bf;
    }

    public int getInputWidth() {
        return this.R;
    }

    public MirriorType getMirriorType() {
        return this.bj;
    }

    public RotationType getRotationType() {
        return this.bi;
    }

    public boolean isCameraInput() {
        return this.bg;
    }

    public boolean isFitCameraAuto() {
        return this.bh;
    }

    public boolean isFrontCamera() {
        return this.mFrontCamera;
    }

    public boolean isSingleFrame() {
        return this.bl;
    }

    public boolean isSyncInputContent() {
        return this.bk;
    }

    public void setCameraInput(boolean z) {
        this.bg = z;
    }

    public void setFitCameraAuto(boolean z) {
        this.bh = z;
    }

    public void setFrontCamera(boolean z) {
        this.mFrontCamera = z;
    }

    public void setInputDegree(int i) {
        int i2 = ((i % EncoderTextureDrawer.X264_WIDTH) + EncoderTextureDrawer.X264_WIDTH) % EncoderTextureDrawer.X264_WIDTH;
        switch (i) {
            case 0:
                this.bi = RotationType.ROTATE_0;
                return;
            case 90:
                this.bi = RotationType.ROTATE_90;
                return;
            case 180:
                this.bi = RotationType.ROTATE_180;
                return;
            case 270:
                this.bi = RotationType.ROTATE_270;
                return;
            default:
                return;
        }
    }

    public void setInputHeight(int i) {
        this.S = i;
    }

    public void setInputSurface(SurfaceTexture surfaceTexture) {
        this.be = surfaceTexture;
    }

    public void setInputTexture(Texture texture) {
        this.bf = texture;
    }

    public void setInputWidth(int i) {
        this.R = i;
    }

    public void setMirriorType(MirriorType mirriorType) {
        this.bj = mirriorType;
    }

    public void setRotationType(RotationType rotationType) {
        this.bi = rotationType;
    }

    public void setSingleFrame(boolean z) {
        this.bl = z;
        if (z) {
            this.bk = true;
            this.bg = false;
            this.mFrontCamera = false;
        }
    }

    public void setSyncInputContent(boolean z) {
        this.bk = z;
    }
}
