package com.baidu.n.a;

import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class b {
    static ArrayList<Integer> lBK = new ArrayList<>(4);
    static String lBL;

    static {
        lBK.add(10000);
        lBK.add(10001);
        lBK.add(10002);
        lBK.add(20001);
        lBK.add(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int dgE() {
        if (TextUtils.isEmpty(lBL)) {
            lBL = com.baidu.n.a.c.d.getManufacturer();
        }
        if (TextUtils.isEmpty(lBL)) {
            return 20001;
        }
        if (lBL.toUpperCase().contains("HUAWEI")) {
            return 10001;
        }
        return lBL.toUpperCase().contains("XIAOMI") ? 10002 : 20001;
    }
}
