package com.baidu.ar.filter;

import java.util.List;
/* loaded from: classes3.dex */
public class FilterModel {
    private String im;

    /* renamed from: pl  reason: collision with root package name */
    private String f981pl;
    private List<Object> pm;

    public String getFilterName() {
        return this.im;
    }

    public String getFilterType() {
        return this.f981pl;
    }

    public List<Object> getUniformList() {
        return this.pm;
    }

    public void setFilterName(String str) {
        this.im = str;
    }

    public void setFilterType(String str) {
        this.f981pl = str;
    }

    public void setUniformList(List<Object> list) {
        this.pm = list;
    }
}
