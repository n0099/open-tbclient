package com.baidu.mapapi.search.poi;

import com.baidu.mapapi.search.poi.PoiFilter;
/* loaded from: classes2.dex */
public /* synthetic */ class d {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f7533a;

    static {
        int[] iArr = new int[PoiFilter.IndustryType.values().length];
        f7533a = iArr;
        try {
            iArr[PoiFilter.IndustryType.HOTEL.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f7533a[PoiFilter.IndustryType.CATER.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f7533a[PoiFilter.IndustryType.LIFE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
