package com.baidu.ar.filter;
/* loaded from: classes12.dex */
public enum FilterNode {
    lutFilter("globalLutFilter"),
    skinFilter("globalSkinFilter"),
    faceFilter("globalFaceFilter"),
    makeupFilter("globalBeautyMakeupFilter"),
    tuneColorFilter("globalTuneColorFilter");
    
    private String mNodeName;

    FilterNode(String str) {
        this.mNodeName = str;
    }

    public String getNodeName() {
        return this.mNodeName;
    }
}
