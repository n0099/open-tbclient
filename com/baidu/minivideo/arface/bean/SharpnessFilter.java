package com.baidu.minivideo.arface.bean;

import com.baidu.ar.filter.FilterNode;
import com.baidu.ar.filter.FilterParam;
/* loaded from: classes3.dex */
public enum SharpnessFilter implements FilterParam {
    sharpness("intensity_sharpness");
    
    private String mParamName;

    SharpnessFilter(String str) {
        this.mParamName = str;
    }

    @Override // com.baidu.ar.filter.FilterParam
    public String getParamName() {
        return this.mParamName;
    }

    @Override // com.baidu.ar.filter.FilterParam
    public FilterNode getFilterNode() {
        return FilterNode.skinFilter;
    }
}
