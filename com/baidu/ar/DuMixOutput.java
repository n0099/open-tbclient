package com.baidu.ar;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.ar.arrender.Texture;
import com.baidu.ar.bean.MirriorType;
import com.baidu.ar.bean.RotationType;
import com.baidu.ar.bean.ScaleType;
import com.baidu.ar.bean.Watermark;
/* loaded from: classes10.dex */
public class DuMixOutput {
    private MirriorType bl;
    private Object bo;
    private boolean bp;
    private ScaleType bq;
    private boolean br;
    private int bs;
    private int bt;
    private Watermark bu;
    private int mOutputHeight;
    private int mOutputWidth;
    private RotationType mRotationType;

    public DuMixOutput() {
        this.bo = null;
        this.bp = false;
        this.bq = ScaleType.CENTER_CROP;
        this.br = true;
        this.bs = 1;
        this.mRotationType = RotationType.ROTATE_0;
        this.bl = MirriorType.NO_MIRRIOR;
        this.bt = 0;
    }

    public DuMixOutput(int i, int i2) {
        this.bo = null;
        this.bp = false;
        this.bq = ScaleType.CENTER_CROP;
        this.br = true;
        this.bs = 1;
        this.mRotationType = RotationType.ROTATE_0;
        this.bl = MirriorType.NO_MIRRIOR;
        this.bt = 0;
        this.mOutputWidth = i;
        this.mOutputHeight = i2;
    }

    public DuMixOutput(SurfaceTexture surfaceTexture, int i, int i2) {
        this.bo = null;
        this.bp = false;
        this.bq = ScaleType.CENTER_CROP;
        this.br = true;
        this.bs = 1;
        this.mRotationType = RotationType.ROTATE_0;
        this.bl = MirriorType.NO_MIRRIOR;
        this.bt = 0;
        this.bo = surfaceTexture;
        this.mOutputWidth = i;
        this.mOutputHeight = i2;
    }

    public DuMixOutput(Surface surface, int i, int i2) {
        this.bo = null;
        this.bp = false;
        this.bq = ScaleType.CENTER_CROP;
        this.br = true;
        this.bs = 1;
        this.mRotationType = RotationType.ROTATE_0;
        this.bl = MirriorType.NO_MIRRIOR;
        this.bt = 0;
        this.bo = surface;
        this.mOutputWidth = i;
        this.mOutputHeight = i2;
    }

    public DuMixOutput(SurfaceHolder surfaceHolder, int i, int i2) {
        this.bo = null;
        this.bp = false;
        this.bq = ScaleType.CENTER_CROP;
        this.br = true;
        this.bs = 1;
        this.mRotationType = RotationType.ROTATE_0;
        this.bl = MirriorType.NO_MIRRIOR;
        this.bt = 0;
        this.bo = surfaceHolder;
        this.mOutputWidth = i;
        this.mOutputHeight = i2;
    }

    public DuMixOutput(Texture texture, int i, int i2) {
        this.bo = null;
        this.bp = false;
        this.bq = ScaleType.CENTER_CROP;
        this.br = true;
        this.bs = 1;
        this.mRotationType = RotationType.ROTATE_0;
        this.bl = MirriorType.NO_MIRRIOR;
        this.bt = 0;
        this.bo = texture;
        this.mOutputWidth = i;
        this.mOutputHeight = i2;
    }

    public MirriorType getMirriorType() {
        return this.bl;
    }

    public int getOutputFPS() {
        return this.bt;
    }

    public int getOutputHeight() {
        return this.mOutputHeight;
    }

    public Object getOutputSurface() {
        return this.bo;
    }

    public Texture getOutputTexture() {
        if (this.bo == null || !(this.bo instanceof Texture)) {
            return null;
        }
        return (Texture) this.bo;
    }

    public int getOutputWidth() {
        return this.mOutputWidth;
    }

    public RotationType getRotationType() {
        return this.mRotationType;
    }

    public ScaleType getScaleType() {
        return this.bq;
    }

    public int getScreenOrientation() {
        return this.bs;
    }

    public Watermark getWatermark() {
        return this.bu;
    }

    public boolean isFitScreenAuto() {
        return this.br;
    }

    public boolean isNeedDetach() {
        return this.bp;
    }

    public void setFitScreenAuto(boolean z) {
        this.br = z;
    }

    public void setMirriorType(MirriorType mirriorType) {
        this.bl = mirriorType;
    }

    public void setNeedDetach(boolean z) {
        this.bp = z;
    }

    public void setOutputFPS(int i) {
        this.bt = i;
    }

    public void setOutputHeight(int i) {
        this.mOutputHeight = i;
    }

    public void setOutputSurface(SurfaceTexture surfaceTexture) {
        this.bo = surfaceTexture;
    }

    public void setOutputSurface(Surface surface) {
        this.bo = surface;
    }

    public void setOutputSurface(SurfaceHolder surfaceHolder) {
        this.bo = surfaceHolder;
    }

    public void setOutputTexture(Texture texture) {
        this.bo = texture;
    }

    public void setOutputWidth(int i) {
        this.mOutputWidth = i;
    }

    public void setRotationType(RotationType rotationType) {
        this.mRotationType = rotationType;
    }

    public void setScaleType(ScaleType scaleType) {
        this.bq = scaleType;
    }

    public void setScreenOrientation(int i) {
        this.bs = i;
    }

    public void setWatermark(Watermark watermark) {
        this.bu = watermark;
    }
}
