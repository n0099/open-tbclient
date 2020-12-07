package com.baidu.ar;

import android.opengl.EGLContext;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class DefaultParams {
    private boolean aA = true;
    private boolean aB = true;
    private boolean aC = true;
    private boolean aD = true;
    private boolean aE = false;
    private EGLContext aF = null;
    private String aG = null;
    private JSONObject aH = null;
    private boolean aI = true;
    private boolean aJ = false;
    private boolean aK = true;
    private String aL;
    private String ay;
    private String az;

    public void enableLog(boolean z) {
        this.aI = z;
    }

    public String get3dShaderDBPath() {
        return this.aL;
    }

    public String getFaceAlgoModelPath() {
        return this.ay;
    }

    public JSONObject getGradingConfig() {
        return this.aH;
    }

    public String getMdlAlgoModelPath() {
        return this.az;
    }

    public String getRenderPipeline() {
        return this.aG;
    }

    public EGLContext getShareContext() {
        return this.aF;
    }

    public boolean isLogEnable() {
        return this.aI;
    }

    public boolean isRecordAutoCrop() {
        return this.aK;
    }

    public boolean isUseBeautyFilter() {
        return this.aB;
    }

    public boolean isUseFaceFilter() {
        return this.aC;
    }

    public boolean isUseInputSizeInEngine() {
        return this.aA;
    }

    public boolean isUseMakeupFilter() {
        return this.aD;
    }

    public boolean isUseTextureIO() {
        return this.aE;
    }

    public boolean isUserPlayAudio() {
        return this.aJ;
    }

    public void set3dShaderPath(String str) {
        this.aL = str;
    }

    public void setFaceAlgoModelPath(String str) {
        this.ay = str;
    }

    public void setGradingConfig(JSONObject jSONObject) {
        this.aH = jSONObject;
    }

    public void setMdlAlgoModelPath(String str) {
        this.az = str;
    }

    public void setRecordAutoCrop(boolean z) {
        this.aK = z;
    }

    public void setRenderPipeline(String str) {
        this.aG = str;
    }

    public void setShareContext(EGLContext eGLContext) {
        this.aF = eGLContext;
    }

    public void setUseBeautyFilter(boolean z) {
        this.aB = z;
    }

    public void setUseFaceFilter(boolean z) {
        this.aC = z;
    }

    public void setUseInputSizeInEngine(boolean z) {
        this.aA = z;
    }

    public void setUseMakeupFilter(boolean z) {
        this.aD = z;
    }

    public void setUseTextureIO(boolean z) {
        this.aE = z;
    }

    public void setUserPlayAudio(boolean z) {
        this.aJ = z;
    }
}
