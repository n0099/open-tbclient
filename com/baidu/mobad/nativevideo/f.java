package com.baidu.mobad.nativevideo;

import com.baidu.mobad.feeds.NativeResponse;
/* loaded from: classes2.dex */
public /* synthetic */ class f {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f8064a;

    static {
        int[] iArr = new int[NativeResponse.MaterialType.values().length];
        f8064a = iArr;
        try {
            iArr[NativeResponse.MaterialType.VIDEO.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f8064a[NativeResponse.MaterialType.NORMAL.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
