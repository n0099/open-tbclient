package com.baidu.ar;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.ar.arrender.Texture;
import com.baidu.ar.bean.MirriorType;
import com.baidu.ar.bean.RotationType;
import com.baidu.ar.bean.ScaleType;
/* loaded from: classes10.dex */
public class DuMixOutput {
    private RotationType bi;
    private MirriorType bj;
    private Object bm;
    private boolean bn;
    private ScaleType bo;
    private boolean bp;
    private int bq;
    private int br;
    private int mOutputHeight;
    private int mOutputWidth;

    public DuMixOutput() {
        this.bm = null;
        this.bn = false;
        this.bo = ScaleType.CENTER_CROP;
        this.bp = true;
        this.bq = 1;
        this.bi = RotationType.ROTATE_0;
        this.bj = MirriorType.NO_MIRRIOR;
        this.br = 0;
    }

    public DuMixOutput(int i, int i2) {
        this.bm = null;
        this.bn = false;
        this.bo = ScaleType.CENTER_CROP;
        this.bp = true;
        this.bq = 1;
        this.bi = RotationType.ROTATE_0;
        this.bj = MirriorType.NO_MIRRIOR;
        this.br = 0;
        this.mOutputWidth = i;
        this.mOutputHeight = i2;
    }

    public DuMixOutput(SurfaceTexture surfaceTexture, int i, int i2) {
        this.bm = null;
        this.bn = false;
        this.bo = ScaleType.CENTER_CROP;
        this.bp = true;
        this.bq = 1;
        this.bi = RotationType.ROTATE_0;
        this.bj = MirriorType.NO_MIRRIOR;
        this.br = 0;
        this.bm = surfaceTexture;
        this.mOutputWidth = i;
        this.mOutputHeight = i2;
    }

    public DuMixOutput(Surface surface, int i, int i2) {
        this.bm = null;
        this.bn = false;
        this.bo = ScaleType.CENTER_CROP;
        this.bp = true;
        this.bq = 1;
        this.bi = RotationType.ROTATE_0;
        this.bj = MirriorType.NO_MIRRIOR;
        this.br = 0;
        this.bm = surface;
        this.mOutputWidth = i;
        this.mOutputHeight = i2;
    }

    public DuMixOutput(SurfaceHolder surfaceHolder, int i, int i2) {
        this.bm = null;
        this.bn = false;
        this.bo = ScaleType.CENTER_CROP;
        this.bp = true;
        this.bq = 1;
        this.bi = RotationType.ROTATE_0;
        this.bj = MirriorType.NO_MIRRIOR;
        this.br = 0;
        this.bm = surfaceHolder;
        this.mOutputWidth = i;
        this.mOutputHeight = i2;
    }

    public DuMixOutput(Texture texture, int i, int i2) {
        this.bm = null;
        this.bn = false;
        this.bo = ScaleType.CENTER_CROP;
        this.bp = true;
        this.bq = 1;
        this.bi = RotationType.ROTATE_0;
        this.bj = MirriorType.NO_MIRRIOR;
        this.br = 0;
        this.bm = texture;
        this.mOutputWidth = i;
        this.mOutputHeight = i2;
    }

    public MirriorType getMirriorType() {
        return this.bj;
    }

    public int getOutputFPS() {
        return this.br;
    }

    public int getOutputHeight() {
        return this.mOutputHeight;
    }

    public Object getOutputSurface() {
        return this.bm;
    }

    public Texture getOutputTexture() {
        if (this.bm == null || !(this.bm instanceof Texture)) {
            return null;
        }
        return (Texture) this.bm;
    }

    public int getOutputWidth() {
        return this.mOutputWidth;
    }

    public RotationType getRotationType() {
        return this.bi;
    }

    public ScaleType getScaleType() {
        return this.bo;
    }

    public int getScreenOrientation() {
        return this.bq;
    }

    public boolean isFitScreenAuto() {
        return this.bp;
    }

    public boolean isNeedDetach() {
        return this.bn;
    }

    public void setFitScreenAuto(boolean z) {
        this.bp = z;
    }

    public void setMirriorType(MirriorType mirriorType) {
        this.bj = mirriorType;
    }

    public void setNeedDetach(boolean z) {
        this.bn = z;
    }

    public void setOutputFPS(int i) {
        this.br = i;
    }

    public void setOutputHeight(int i) {
        this.mOutputHeight = i;
    }

    public void setOutputSurface(SurfaceTexture surfaceTexture) {
        this.bm = surfaceTexture;
    }

    public void setOutputSurface(Surface surface) {
        this.bm = surface;
    }

    public void setOutputSurface(SurfaceHolder surfaceHolder) {
        this.bm = surfaceHolder;
    }

    public void setOutputTexture(Texture texture) {
        this.bm = texture;
    }

    public void setOutputWidth(int i) {
        this.mOutputWidth = i;
    }

    public void setRotationType(RotationType rotationType) {
        this.bi = rotationType;
    }

    public void setScaleType(ScaleType scaleType) {
        this.bo = scaleType;
    }

    public void setScreenOrientation(int i) {
        this.bq = i;
    }
}
