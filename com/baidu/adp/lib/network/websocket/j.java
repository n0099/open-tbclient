package com.baidu.adp.lib.network.websocket;

import com.baidu.adp.lib.util.BdNetUtil;
import com.baidu.kirin.KirinConfig;
import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class j {
    private static j a = null;
    private BdNetUtil.NetworkStateInfo b = null;
    private Map<BdNetUtil.NetworkStateInfo, Integer> c = null;

    public static j a() {
        if (a == null) {
            synchronized (j.class) {
                if (a == null) {
                    a = new j();
                    a.b();
                }
            }
        }
        return a;
    }

    protected void b() {
        this.c = new HashMap();
        a(new int[3]);
        this.b = BdNetUtil.NetworkStateInfo.UNAVAIL;
    }

    public void a(int[] iArr) {
        int i;
        int i2;
        int i3 = KirinConfig.READ_TIME_OUT;
        int i4 = 0;
        if (iArr == null || iArr.length != 3) {
            i = 0;
            i2 = 0;
        } else {
            i2 = iArr[0];
            i = iArr[1];
            i4 = iArr[2];
        }
        if (i2 < 5000) {
            i2 = 20000;
        }
        if (i < 5000) {
            i = TbConfig.BIG_IMAGE_MIN_CAPACITY;
        }
        if (i4 >= 5000) {
            i3 = i4;
        }
        this.c.put(BdNetUtil.NetworkStateInfo.TwoG, Integer.valueOf(i2));
        this.c.put(BdNetUtil.NetworkStateInfo.ThreeG, Integer.valueOf(i));
        this.c.put(BdNetUtil.NetworkStateInfo.WIFI, Integer.valueOf(i3));
    }

    public void c() {
        this.b = BdNetUtil.a();
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
        return i < 5000 ? KirinConfig.READ_TIME_OUT : i;
    }
}
