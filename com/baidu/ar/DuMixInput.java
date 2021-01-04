package com.baidu.ar;

import android.graphics.SurfaceTexture;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.ar.arrender.Texture;
import com.baidu.ar.bean.MirriorType;
import com.baidu.ar.bean.RotationType;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
/* loaded from: classes6.dex */
public class DuMixInput {
    private SurfaceTexture bh;
    private Texture bi;
    private boolean bj;
    private boolean bk;
    private MirriorType bl;
    private boolean bm;
    private boolean bn;
    private boolean mFrontCamera;
    private int mInputHeight;
    private int mInputWidth;
    private RotationType mRotationType;

    public DuMixInput() {
        this.mInputWidth = 0;
        this.mInputHeight = 0;
        this.bj = true;
        this.mFrontCamera = true;
        this.bk = true;
        this.mRotationType = RotationType.ROTATE_90;
        this.bl = MirriorType.NO_MIRRIOR;
        this.bm = false;
        this.bn = false;
    }

    public DuMixInput(int i, int i2) {
        this.mInputWidth = 0;
        this.mInputHeight = 0;
        this.bj = true;
        this.mFrontCamera = true;
        this.bk = true;
        this.mRotationType = RotationType.ROTATE_90;
        this.bl = MirriorType.NO_MIRRIOR;
        this.bm = false;
        this.bn = false;
        this.mInputWidth = i;
        this.mInputHeight = i2;
    }

    public DuMixInput(SurfaceTexture surfaceTexture, int i, int i2) {
        this.mInputWidth = 0;
        this.mInputHeight = 0;
        this.bj = true;
        this.mFrontCamera = true;
        this.bk = true;
        this.mRotationType = RotationType.ROTATE_90;
        this.bl = MirriorType.NO_MIRRIOR;
        this.bm = false;
        this.bn = false;
        this.bh = surfaceTexture;
        this.mInputWidth = i;
        this.mInputHeight = i2;
    }

    public DuMixInput(Texture texture, int i, int i2) {
        this.mInputWidth = 0;
        this.mInputHeight = 0;
        this.bj = true;
        this.mFrontCamera = true;
        this.bk = true;
        this.mRotationType = RotationType.ROTATE_90;
        this.bl = MirriorType.NO_MIRRIOR;
        this.bm = false;
        this.bn = false;
        this.bi = texture;
        this.mInputWidth = i;
        this.mInputHeight = i2;
    }

    public int getInputDegree() {
        return this.mRotationType.getDegree();
    }

    public int getInputHeight() {
        return this.mInputHeight;
    }

    public SurfaceTexture getInputSurface() {
        return this.bh;
    }

    public Texture getInputTexture() {
        return this.bi;
    }

    public int getInputWidth() {
        return this.mInputWidth;
    }

    public MirriorType getMirriorType() {
        return this.bl;
    }

    public RotationType getRotationType() {
        return this.mRotationType;
    }

    public boolean isCameraInput() {
        return this.bj;
    }

    public boolean isFitCameraAuto() {
        return this.bk;
    }

    public boolean isFrontCamera() {
        return this.mFrontCamera;
    }

    public boolean isSingleFrame() {
        return this.bn;
    }

    public boolean isSyncInputContent() {
        return this.bm;
    }

    public void setCameraInput(boolean z) {
        this.bj = z;
    }

    public void setFitCameraAuto(boolean z) {
        this.bk = z;
    }

    public void setFrontCamera(boolean z) {
        this.mFrontCamera = z;
    }

    public void setInputDegree(int i) {
        int i2 = ((i % EncoderTextureDrawer.X264_WIDTH) + EncoderTextureDrawer.X264_WIDTH) % EncoderTextureDrawer.X264_WIDTH;
        switch (i) {
            case 0:
                this.mRotationType = RotationType.ROTATE_0;
                return;
            case 90:
                this.mRotationType = RotationType.ROTATE_90;
                return;
            case 180:
                this.mRotationType = RotationType.ROTATE_180;
                return;
            case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                this.mRotationType = RotationType.ROTATE_270;
                return;
            default:
                return;
        }
    }

    public void setInputHeight(int i) {
        this.mInputHeight = i;
    }

    public void setInputSurface(SurfaceTexture surfaceTexture) {
        this.bh = surfaceTexture;
    }

    public void setInputTexture(Texture texture) {
        this.bi = texture;
    }

    public void setInputWidth(int i) {
        this.mInputWidth = i;
    }

    public void setMirriorType(MirriorType mirriorType) {
        this.bl = mirriorType;
    }

    public void setRotationType(RotationType rotationType) {
        this.mRotationType = rotationType;
    }

    public void setSingleFrame(boolean z) {
        this.bn = z;
        if (z) {
            this.bm = true;
            this.bj = false;
            this.mFrontCamera = false;
        }
    }

    public void setSyncInputContent(boolean z) {
        this.bm = z;
    }
}
