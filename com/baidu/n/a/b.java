package com.baidu.n.a;

import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class b {
    static ArrayList<Integer> lEi = new ArrayList<>(4);
    static String lEj;

    static {
        lEi.add(10000);
        lEi.add(10001);
        lEi.add(10002);
        lEi.add(20001);
        lEi.add(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int dis() {
        if (TextUtils.isEmpty(lEj)) {
            lEj = com.baidu.n.a.c.d.getManufacturer();
        }
        if (TextUtils.isEmpty(lEj)) {
            return 20001;
        }
        if (lEj.toUpperCase().contains("HUAWEI")) {
            return 10001;
        }
        return lEj.toUpperCase().contains("XIAOMI") ? 10002 : 20001;
    }
}
