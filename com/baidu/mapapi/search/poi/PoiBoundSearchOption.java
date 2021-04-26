package com.baidu.mapapi.search.poi;

import com.baidu.mapapi.model.LatLngBounds;
/* loaded from: classes2.dex */
public class PoiBoundSearchOption {
    public LatLngBounds mBound = null;
    public String mKeyword = null;
    public int mPageNum = 0;
    public int mPageCapacity = 10;
    public String mTag = "";
    public int mScope = 1;
    public PoiFilter mPoiFilter = null;

    public PoiBoundSearchOption bound(LatLngBounds latLngBounds) {
        this.mBound = latLngBounds;
        return this;
    }

    public PoiBoundSearchOption keyword(String str) {
        this.mKeyword = str;
        return this;
    }

    public PoiBoundSearchOption pageCapacity(int i2) {
        this.mPageCapacity = i2;
        return this;
    }

    public PoiBoundSearchOption pageNum(int i2) {
        this.mPageNum = i2;
        return this;
    }

    public PoiBoundSearchOption poiFilter(PoiFilter poiFilter) {
        this.mPoiFilter = poiFilter;
        return this;
    }

    public PoiBoundSearchOption scope(int i2) {
        this.mScope = i2;
        return this;
    }

    public PoiBoundSearchOption tag(String str) {
        this.mTag = str;
        return this;
    }
}
