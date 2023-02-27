package com.baidu.ar.filter;
/* loaded from: classes.dex */
public enum FilterNode {
    lutFilter("globalLutFilter"),
    skinFilter("globalSkinFilter"),
    faceFilter("globalFaceFilter"),
    makeupFilter("globalBeautyMakeupFilter"),
    tuneColorFilter("globalTuneColorFilter");
    
    public String mNodeName;

    FilterNode(String str) {
        this.mNodeName = str;
    }

    public String getNodeName() {
        return this.mNodeName;
    }
}
