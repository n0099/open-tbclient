package com.baidu.mapsdkplatform.comapi;

import com.baidu.mapsdkplatform.comapi.NativeLoader;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public /* synthetic */ class d {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f3025a = new int[NativeLoader.a.values().length];

    static {
        try {
            f3025a[NativeLoader.a.ARM64.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f3025a[NativeLoader.a.ARMV7.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f3025a[NativeLoader.a.ARMEABI.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f3025a[NativeLoader.a.X86_64.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f3025a[NativeLoader.a.X86.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
    }
}
