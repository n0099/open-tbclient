package com.baidu.platform.core.e;

import com.baidu.platform.base.SearchType;
/* loaded from: classes5.dex */
/* synthetic */ class g {
    static final /* synthetic */ int[] a = new int[SearchType.values().length];

    static {
        try {
            a[SearchType.POI_DETAIL_SHARE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[SearchType.LOCATION_SEARCH_SHARE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
