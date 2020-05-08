package com.baidu.l.a;

import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class b {
    static ArrayList<Integer> lPF = new ArrayList<>(4);
    static String lPG;

    static {
        lPF.add(10000);
        lPF.add(10001);
        lPF.add(10002);
        lPF.add(20001);
        lPF.add(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int dlD() {
        if (TextUtils.isEmpty(lPG)) {
            lPG = com.baidu.l.a.c.d.getManufacturer();
        }
        if (TextUtils.isEmpty(lPG)) {
            return 20001;
        }
        if (lPG.toUpperCase().contains("HUAWEI")) {
            return 10001;
        }
        return lPG.toUpperCase().contains("XIAOMI") ? 10002 : 20001;
    }
}
