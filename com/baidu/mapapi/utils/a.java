package com.baidu.mapapi.utils;

import com.baidu.mapapi.utils.CoordinateConverter;
/* loaded from: classes2.dex */
public /* synthetic */ class a {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f7390a;

    static {
        int[] iArr = new int[CoordinateConverter.CoordType.values().length];
        f7390a = iArr;
        try {
            iArr[CoordinateConverter.CoordType.COMMON.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f7390a[CoordinateConverter.CoordType.GPS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f7390a[CoordinateConverter.CoordType.BD09LL.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f7390a[CoordinateConverter.CoordType.BD09MC.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
