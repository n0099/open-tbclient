package com.baidu.n.a;

import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class b {
    static ArrayList<Integer> lCr = new ArrayList<>(4);
    static String lCs;

    static {
        lCr.add(10000);
        lCr.add(10001);
        lCr.add(10002);
        lCr.add(20001);
        lCr.add(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int dhS() {
        if (TextUtils.isEmpty(lCs)) {
            lCs = com.baidu.n.a.c.d.getManufacturer();
        }
        if (TextUtils.isEmpty(lCs)) {
            return 20001;
        }
        if (lCs.toUpperCase().contains("HUAWEI")) {
            return 10001;
        }
        return lCs.toUpperCase().contains("XIAOMI") ? 10002 : 20001;
    }
}
