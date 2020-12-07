package com.baidu.ar.filter;

import java.util.List;
/* loaded from: classes10.dex */
public class FilterModel {
    private String hS;
    private String qn;
    private List<Object> qo;

    public String getFilterName() {
        return this.hS;
    }

    public String getFilterType() {
        return this.qn;
    }

    public List<Object> getUniformList() {
        return this.qo;
    }

    public void setFilterName(String str) {
        this.hS = str;
    }

    public void setFilterType(String str) {
        this.qn = str;
    }

    public void setUniformList(List<Object> list) {
        this.qo = list;
    }
}
