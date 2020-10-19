package com.baidu.ar.filter;

import java.util.List;
/* loaded from: classes14.dex */
public class FilterModel {
    private String hE;
    private String pX;
    private List<Object> pY;

    public String getFilterName() {
        return this.hE;
    }

    public String getFilterType() {
        return this.pX;
    }

    public List<Object> getUniformList() {
        return this.pY;
    }

    public void setFilterName(String str) {
        this.hE = str;
    }

    public void setFilterType(String str) {
        this.pX = str;
    }

    public void setUniformList(List<Object> list) {
        this.pY = list;
    }
}
