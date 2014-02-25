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

    public void b() {
        this.c = new HashMap();
        a(new int[3]);
        this.b = BdUtilHelper.NetworkStateInfo.UNAVAIL;
    }

    public void a(int[] iArr) {
        int i;
        int i2;
        int i3 = 0;
        if (iArr == null || iArr.length != 3) {
            i = 0;
            i2 = 0;
        } else {
            i2 = iArr[0];
            i = iArr[1];
            i3 = iArr[2];
        }
        if (i2 < 5000) {
            i2 = 20000;
        }
        if (i < 5000) {
            i = 10000;
        }
        int i4 = i3 >= 5000 ? i3 : 5000;
        this.c.put(BdUtilHelper.NetworkStateInfo.TwoG, Integer.valueOf(i2));
        this.c.put(BdUtilHelper.NetworkStateInfo.ThreeG, Integer.valueOf(i));
        this.c.put(BdUtilHelper.NetworkStateInfo.WIFI, Integer.valueOf(i4));
    }

    public void c() {
        this.b = BdUtilHelper.e(com.baidu.adp.a.b.a().b());
    }

    public int d() {
        int i;
        if (this.c == null) {
            b();
        }
        Integer num = this.c.get(this.b);
        if (num == null) {
            i = 0;
        } else {
            i = num.intValue();
        }
        if (i < 5000) {
            return 5000;
        }
        return i;
    }
}
