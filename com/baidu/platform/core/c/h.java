package com.baidu.platform.core.c;

import com.baidu.platform.base.SearchType;
/* loaded from: classes7.dex */
/* synthetic */ class h {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f3189a = new int[SearchType.values().length];

    static {
        try {
            f3189a[SearchType.POI_NEAR_BY_SEARCH.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f3189a[SearchType.POI_IN_CITY_SEARCH.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f3189a[SearchType.POI_IN_BOUND_SEARCH.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
