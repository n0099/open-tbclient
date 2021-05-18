package com.baidu.platform.core.c;

import com.baidu.platform.base.SearchType;
/* loaded from: classes2.dex */
public /* synthetic */ class h {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f9380a;

    static {
        int[] iArr = new int[SearchType.values().length];
        f9380a = iArr;
        try {
            iArr[SearchType.POI_NEAR_BY_SEARCH.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f9380a[SearchType.POI_IN_CITY_SEARCH.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f9380a[SearchType.POI_IN_BOUND_SEARCH.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
