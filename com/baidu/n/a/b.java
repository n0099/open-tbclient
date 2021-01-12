package com.baidu.n.a;

import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b {
    static ArrayList<Integer> oKP = new ArrayList<>(4);
    static String oKQ;

    static {
        oKP.add(10000);
        oKP.add(10001);
        oKP.add(10002);
        oKP.add(20001);
        oKP.add(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int ege() {
        if (TextUtils.isEmpty(oKQ)) {
            oKQ = com.baidu.n.a.c.d.getManufacturer();
        }
        if (TextUtils.isEmpty(oKQ)) {
            return 20001;
        }
        if (oKQ.toUpperCase().contains("HUAWEI")) {
            return 10001;
        }
        return oKQ.toUpperCase().contains("XIAOMI") ? 10002 : 20001;
    }
}
