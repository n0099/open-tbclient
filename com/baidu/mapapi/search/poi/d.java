package com.baidu.mapapi.search.poi;

import com.baidu.mapapi.search.poi.PoiFilter;
/* loaded from: classes5.dex */
/* synthetic */ class d {
    static final /* synthetic */ int[] a = new int[PoiFilter.IndustryType.values().length];

    static {
        try {
            a[PoiFilter.IndustryType.HOTEL.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[PoiFilter.IndustryType.CATER.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[PoiFilter.IndustryType.LIFE.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
