package com.baidu.ar.filter;

import java.util.List;
/* loaded from: classes3.dex */
public class FilterModel {
    private String hW;
    private String oL;
    private List<Object> oM;

    public String getFilterName() {
        return this.hW;
    }

    public String getFilterType() {
        return this.oL;
    }

    public List<Object> getUniformList() {
        return this.oM;
    }

    public void setFilterName(String str) {
        this.hW = str;
    }

    public void setFilterType(String str) {
        this.oL = str;
    }

    public void setUniformList(List<Object> list) {
        this.oM = list;
    }
}
