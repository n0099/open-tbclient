package com.baidu.ar;

import android.opengl.EGLContext;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class DefaultParams {
    private String ax;
    private String ay;
    private boolean az = true;
    private boolean aA = true;
    private boolean aB = true;
    private boolean aC = true;
    private boolean aD = false;
    private EGLContext aE = null;
    private String aF = null;
    private JSONObject aG = null;
    private boolean aH = true;
    private boolean aI = false;

    public void enableLog(boolean z) {
        this.aH = z;
    }

    public String getFaceAlgoModelPath() {
        return this.ax;
    }

    public JSONObject getGradingConfig() {
        return this.aG;
    }

    public String getMdlAlgoModelPath() {
        return this.ay;
    }

    public String getRenderPipeline() {
        return this.aF;
    }

    public EGLContext getShareContext() {
        return this.aE;
    }

    public boolean isLogEnable() {
        return this.aH;
    }

    public boolean isUseBeautyFilter() {
        return this.aA;
    }

    public boolean isUseFaceFilter() {
        return this.aB;
    }

    public boolean isUseInputSizeInEngine() {
        return this.az;
    }

    public boolean isUseMakeupFilter() {
        return this.aC;
    }

    public boolean isUseTextureIO() {
        return this.aD;
    }

    public boolean isUserPlayAudio() {
        return this.aI;
    }

    public void setFaceAlgoModelPath(String str) {
        this.ax = str;
    }

    public void setGradingConfig(JSONObject jSONObject) {
        this.aG = jSONObject;
    }

    public void setMdlAlgoModelPath(String str) {
        this.ay = str;
    }

    public void setRenderPipeline(String str) {
        this.aF = str;
    }

    public void setShareContext(EGLContext eGLContext) {
        this.aE = eGLContext;
    }

    public void setUseBeautyFilter(boolean z) {
        this.aA = z;
    }

    public void setUseFaceFilter(boolean z) {
        this.aB = z;
    }

    public void setUseInputSizeInEngine(boolean z) {
        this.az = z;
    }

    public void setUseMakeupFilter(boolean z) {
        this.aC = z;
    }

    public void setUseTextureIO(boolean z) {
        this.aD = z;
    }

    public void setUserPlayAudio(boolean z) {
        this.aI = z;
    }
}
