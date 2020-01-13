package com.baidu.n.a;

import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class b {
    static ArrayList<Integer> lBF = new ArrayList<>(4);
    static String lBG;

    static {
        lBF.add(10000);
        lBF.add(10001);
        lBF.add(10002);
        lBF.add(20001);
        lBF.add(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int dgC() {
        if (TextUtils.isEmpty(lBG)) {
            lBG = com.baidu.n.a.c.d.getManufacturer();
        }
        if (TextUtils.isEmpty(lBG)) {
            return 20001;
        }
        if (lBG.toUpperCase().contains("HUAWEI")) {
            return 10001;
        }
        return lBG.toUpperCase().contains("XIAOMI") ? 10002 : 20001;
    }
}
