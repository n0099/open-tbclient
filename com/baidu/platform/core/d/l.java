package com.baidu.platform.core.d;

import com.baidu.platform.base.SearchType;
/* loaded from: classes2.dex */
public /* synthetic */ class l {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f9341a;

    static {
        int[] iArr = new int[SearchType.values().length];
        f9341a = iArr;
        try {
            iArr[SearchType.TRANSIT_ROUTE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f9341a[SearchType.DRIVE_ROUTE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f9341a[SearchType.WALK_ROUTE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
