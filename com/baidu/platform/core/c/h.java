package com.baidu.platform.core.c;

import com.baidu.platform.base.SearchType;
/* loaded from: classes5.dex */
/* synthetic */ class h {
    static final /* synthetic */ int[] a = new int[SearchType.values().length];

    static {
        try {
            a[SearchType.POI_NEAR_BY_SEARCH.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[SearchType.POI_IN_CITY_SEARCH.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[SearchType.POI_IN_BOUND_SEARCH.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
