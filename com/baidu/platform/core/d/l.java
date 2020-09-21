package com.baidu.platform.core.d;

import com.baidu.platform.base.SearchType;
/* loaded from: classes3.dex */
/* synthetic */ class l {
    static final /* synthetic */ int[] a = new int[SearchType.values().length];

    static {
        try {
            a[SearchType.TRANSIT_ROUTE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[SearchType.DRIVE_ROUTE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[SearchType.WALK_ROUTE.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
