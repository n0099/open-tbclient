package com.baidu.mapapi.synchronization;

import com.baidu.mapapi.synchronization.SyncCoordinateConverter;
/* loaded from: classes2.dex */
public /* synthetic */ class a {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f7478a;

    static {
        int[] iArr = new int[SyncCoordinateConverter.CoordType.values().length];
        f7478a = iArr;
        try {
            iArr[SyncCoordinateConverter.CoordType.COMMON.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f7478a[SyncCoordinateConverter.CoordType.BD09LL.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
