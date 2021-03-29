package com.baidu.mapsdkplatform.comapi;

import com.baidu.mapsdkplatform.comapi.NativeLoader;
/* loaded from: classes2.dex */
public /* synthetic */ class d {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f7533a;

    static {
        int[] iArr = new int[NativeLoader.a.values().length];
        f7533a = iArr;
        try {
            iArr[NativeLoader.a.ARM64.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f7533a[NativeLoader.a.ARMV7.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f7533a[NativeLoader.a.ARMEABI.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f7533a[NativeLoader.a.X86_64.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f7533a[NativeLoader.a.X86.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
