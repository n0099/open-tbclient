package com.baidu.p.a;

import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class b {
    static ArrayList<Integer> oPr = new ArrayList<>(4);
    static String oPs;

    static {
        oPr.add(10000);
        oPr.add(10001);
        oPr.add(10002);
        oPr.add(20001);
        oPr.add(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int ejX() {
        if (TextUtils.isEmpty(oPs)) {
            oPs = com.baidu.p.a.c.d.getManufacturer();
        }
        if (TextUtils.isEmpty(oPs)) {
            return 20001;
        }
        if (oPs.toUpperCase().contains("HUAWEI")) {
            return 10001;
        }
        return oPs.toUpperCase().contains("XIAOMI") ? 10002 : 20001;
    }
}
