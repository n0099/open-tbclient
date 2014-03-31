package com.baidu.adp.framework.e;

import com.baidu.adp.lib.util.BdNetUtil;
/* loaded from: classes.dex */
public final class e {
    private static /* synthetic */ int[] b;
    private int[] a;

    private static /* synthetic */ int[] c() {
        int[] iArr = b;
        if (iArr == null) {
            iArr = new int[BdNetUtil.NetworkStateInfo.valuesCustom().length];
            try {
                iArr[BdNetUtil.NetworkStateInfo.ThreeG.ordinal()] = 4;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[BdNetUtil.NetworkStateInfo.TwoG.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[BdNetUtil.NetworkStateInfo.UNAVAIL.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[BdNetUtil.NetworkStateInfo.WIFI.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            b = iArr;
        }
        return iArr;
    }

    public e(int i, int i2, int i3) {
        this.a = null;
        this.a = new int[3];
        this.a[0] = i;
        this.a[1] = i2;
        this.a[2] = i3;
    }

    public final int a() {
        if (this.a == null || this.a.length != 1) {
            return 0;
        }
        return this.a[0];
    }

    public final int b() {
        if (this.a == null || this.a.length != 3) {
            return 0;
        }
        switch (c()[BdNetUtil.a().ordinal()]) {
            case 2:
                return this.a[2];
            case 3:
                return this.a[0];
            case 4:
                return this.a[1];
            default:
                return this.a[2];
        }
    }
}
