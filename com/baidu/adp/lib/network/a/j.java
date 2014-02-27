package com.baidu.adp.lib.network.a;

import com.baidu.adp.lib.util.BdUtilHelper;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class j {
    private static j a = null;
    private BdUtilHelper.NetworkStateInfo b = null;
    private Map<BdUtilHelper.NetworkStateInfo, Integer> c = null;

    public static j a() {
        if (a == null) {
            synchronized (j.class) {
                if (a == null) {
                    a = new j();
                }
            }
        }
        return a;
    }

    public final void b() {
        this.b = BdUtilHelper.e(com.baidu.adp.a.b.a().b());
    }

    public final int c() {
        int i;
        int i2;
        int i3;
        if (this.c == null) {
            this.c = new HashMap();
            int[] iArr = new int[3];
            if (iArr == null || iArr.length != 3) {
                i = 0;
                i2 = 0;
                i3 = 0;
            } else {
                i3 = iArr[0];
                i2 = iArr[1];
                i = iArr[2];
            }
            if (i3 < 5000) {
                i3 = 20000;
            }
            if (i2 < 5000) {
                i2 = 10000;
            }
            if (i < 5000) {
                i = 5000;
            }
            this.c.put(BdUtilHelper.NetworkStateInfo.TwoG, Integer.valueOf(i3));
            this.c.put(BdUtilHelper.NetworkStateInfo.ThreeG, Integer.valueOf(i2));
            this.c.put(BdUtilHelper.NetworkStateInfo.WIFI, Integer.valueOf(i));
            this.b = BdUtilHelper.NetworkStateInfo.UNAVAIL;
        }
        Integer num = this.c.get(this.b);
        int intValue = num != null ? num.intValue() : 0;
        if (intValue < 5000) {
            return 5000;
        }
        return intValue;
    }
}
