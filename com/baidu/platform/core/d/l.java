package com.baidu.platform.core.d;

import com.baidu.platform.base.SearchType;
/* loaded from: classes15.dex */
/* synthetic */ class l {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f4774a = new int[SearchType.values().length];

    static {
        try {
            f4774a[SearchType.TRANSIT_ROUTE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f4774a[SearchType.DRIVE_ROUTE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f4774a[SearchType.WALK_ROUTE.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
