package com.baidu.n.a;

import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b {
    static ArrayList<Integer> oKQ = new ArrayList<>(4);
    static String oKR;

    static {
        oKQ.add(10000);
        oKQ.add(10001);
        oKQ.add(10002);
        oKQ.add(20001);
        oKQ.add(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int ege() {
        if (TextUtils.isEmpty(oKR)) {
            oKR = com.baidu.n.a.c.d.getManufacturer();
        }
        if (TextUtils.isEmpty(oKR)) {
            return 20001;
        }
        if (oKR.toUpperCase().contains("HUAWEI")) {
            return 10001;
        }
        return oKR.toUpperCase().contains("XIAOMI") ? 10002 : 20001;
    }
}
