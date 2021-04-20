package com.baidu.mapsdkvi;

import android.net.NetworkInfo;
/* loaded from: classes2.dex */
public /* synthetic */ class d {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f7954a;

    static {
        int[] iArr = new int[NetworkInfo.State.values().length];
        f7954a = iArr;
        try {
            iArr[NetworkInfo.State.CONNECTED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f7954a[NetworkInfo.State.CONNECTING.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f7954a[NetworkInfo.State.DISCONNECTED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f7954a[NetworkInfo.State.DISCONNECTING.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f7954a[NetworkInfo.State.SUSPENDED.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
