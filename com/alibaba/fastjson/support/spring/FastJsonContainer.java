package com.alibaba.fastjson.support.spring;
/* loaded from: classes.dex */
public class FastJsonContainer {
    public PropertyPreFilters filters;
    public Object value;

    public FastJsonContainer(Object obj) {
        this.value = obj;
    }

    public PropertyPreFilters getFilters() {
        return this.filters;
    }

    public Object getValue() {
        return this.value;
    }

    public void setFilters(PropertyPreFilters propertyPreFilters) {
        this.filters = propertyPreFilters;
    }

    public void setValue(Object obj) {
        this.value = obj;
    }
}
