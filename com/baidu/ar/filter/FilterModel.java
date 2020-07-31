package com.baidu.ar.filter;

import java.util.List;
/* loaded from: classes11.dex */
public class FilterModel {
    private String im;

    /* renamed from: pl  reason: collision with root package name */
    private String f960pl;
    private List<Object> pm;

    public String getFilterName() {
        return this.im;
    }

    public String getFilterType() {
        return this.f960pl;
    }

    public List<Object> getUniformList() {
        return this.pm;
    }

    public void setFilterName(String str) {
        this.im = str;
    }

    public void setFilterType(String str) {
        this.f960pl = str;
    }

    public void setUniformList(List<Object> list) {
        this.pm = list;
    }
}
