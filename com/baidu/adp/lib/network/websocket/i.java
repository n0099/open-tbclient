package com.baidu.adp.lib.network.websocket;

import com.baidu.adp.lib.util.BdNetUtil;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class i {
    private static i a = null;
    private BdNetUtil.NetworkStateInfo b = null;
    private Map<BdNetUtil.NetworkStateInfo, Integer> c = null;

    public static i a() {
        if (a == null) {
            synchronized (i.class) {
                if (a == null) {
                    i iVar = new i();
                    a = iVar;
                    iVar.d();
                }
            }
        }
        return a;
    }

    private void d() {
        int i;
        int i2;
        int i3 = 0;
        this.c = new HashMap();
        int[] iArr = new int[3];
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
        this.c.put(BdNetUtil.NetworkStateInfo.TwoG, Integer.valueOf(i2));
        this.c.put(BdNetUtil.NetworkStateInfo.ThreeG, Integer.valueOf(i));
        this.c.put(BdNetUtil.NetworkStateInfo.WIFI, Integer.valueOf(i4));
        this.b = BdNetUtil.NetworkStateInfo.UNAVAIL;
    }

    public final void b() {
        this.b = BdNetUtil.a();
    }

    public final int c() {
        int i;
        if (this.c == null) {
            d();
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
