package com.baidu.n.a;

import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class b {
    static ArrayList<Integer> lCt = new ArrayList<>(4);
    static String lCu;

    static {
        lCt.add(10000);
        lCt.add(10001);
        lCt.add(10002);
        lCt.add(20001);
        lCt.add(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int dhU() {
        if (TextUtils.isEmpty(lCu)) {
            lCu = com.baidu.n.a.c.d.getManufacturer();
        }
        if (TextUtils.isEmpty(lCu)) {
            return 20001;
        }
        if (lCu.toUpperCase().contains("HUAWEI")) {
            return 10001;
        }
        return lCu.toUpperCase().contains("XIAOMI") ? 10002 : 20001;
    }
}
