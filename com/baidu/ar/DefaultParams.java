package com.baidu.ar;

import android.opengl.EGLContext;
/* loaded from: classes3.dex */
public class DefaultParams {
    private String aD;
    private String aE;
    private boolean aF = true;
    private boolean aG = true;
    private boolean aH = true;
    private boolean aI = true;
    private boolean aJ = false;
    private EGLContext aK = null;
    private boolean aL = true;

    public void enableLog(boolean z) {
        this.aL = z;
    }

    public String getFaceAlgoModelPath() {
        return this.aD;
    }

    public String getMdlAlgoModelPath() {
        return this.aE;
    }

    public EGLContext getShareContext() {
        return this.aK;
    }

    public boolean isLogEnable() {
        return this.aL;
    }

    public boolean isUseBeautyFilter() {
        return this.aG;
    }

    public boolean isUseFaceFilter() {
        return this.aH;
    }

    public boolean isUseInputSizeInEngine() {
        return this.aF;
    }

    public boolean isUseMakeupFilter() {
        return this.aI;
    }

    public boolean isUseTextureIO() {
        return this.aJ;
    }

    public void setFaceAlgoModelPath(String str) {
        this.aD = str;
    }

    public void setMdlAlgoModelPath(String str) {
        this.aE = str;
    }

    public void setShareContext(EGLContext eGLContext) {
        this.aK = eGLContext;
    }

    public void setUseBeautyFilter(boolean z) {
        this.aG = z;
    }

    public void setUseFaceFilter(boolean z) {
        this.aH = z;
    }

    public void setUseInputSizeInEngine(boolean z) {
        this.aF = z;
    }

    public void setUseMakeupFilter(boolean z) {
        this.aI = z;
    }

    public void setUseTextureIO(boolean z) {
        this.aJ = z;
    }
}
