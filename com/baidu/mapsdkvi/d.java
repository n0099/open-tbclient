package com.baidu.mapsdkvi;

import android.net.NetworkInfo;
/* loaded from: classes10.dex */
/* synthetic */ class d {
    static final /* synthetic */ int[] a = new int[NetworkInfo.State.values().length];

    static {
        try {
            a[NetworkInfo.State.CONNECTED.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[NetworkInfo.State.CONNECTING.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[NetworkInfo.State.DISCONNECTED.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            a[NetworkInfo.State.DISCONNECTING.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            a[NetworkInfo.State.SUSPENDED.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
    }
}
