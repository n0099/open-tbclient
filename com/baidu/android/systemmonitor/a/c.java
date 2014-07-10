package com.baidu.android.systemmonitor.a;

import com.baidu.android.a.n;
/* loaded from: classes.dex */
/* synthetic */ class c {
    static final /* synthetic */ int[] a = new int[n.values().length];

    static {
        try {
            a[n.FREQ_STATISTIC.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[n.APPCHANGE_STATISTIC.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[n.ACTIVE_EVENT.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            a[n.POWER_EVENT.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            a[n.CHARGE_EVENT.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            a[n.STORE_INFORMATION.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        try {
            a[n.NETWORK_EVENT.ordinal()] = 7;
        } catch (NoSuchFieldError e7) {
        }
        try {
            a[n.APKDOWNLOAD_EVENT.ordinal()] = 8;
        } catch (NoSuchFieldError e8) {
        }
        try {
            a[n.PV_EVENT.ordinal()] = 9;
        } catch (NoSuchFieldError e9) {
        }
    }
}
