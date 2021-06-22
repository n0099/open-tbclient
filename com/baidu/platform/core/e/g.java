package com.baidu.platform.core.e;

import com.baidu.platform.base.SearchType;
/* loaded from: classes2.dex */
public /* synthetic */ class g {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f9350a;

    static {
        int[] iArr = new int[SearchType.values().length];
        f9350a = iArr;
        try {
            iArr[SearchType.POI_DETAIL_SHARE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f9350a[SearchType.LOCATION_SEARCH_SHARE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
