package com.baidu.ar.filter;

import java.util.List;
/* loaded from: classes.dex */
public class FilterModel {
    public String hS;
    public String qn;
    public List<Object> qo;

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
