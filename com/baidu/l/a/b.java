package com.baidu.l.a;

import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class b {
    static ArrayList<Integer> lPB = new ArrayList<>(4);
    static String lPC;

    static {
        lPB.add(10000);
        lPB.add(10001);
        lPB.add(10002);
        lPB.add(20001);
        lPB.add(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int dlG() {
        if (TextUtils.isEmpty(lPC)) {
            lPC = com.baidu.l.a.c.d.getManufacturer();
        }
        if (TextUtils.isEmpty(lPC)) {
            return 20001;
        }
        if (lPC.toUpperCase().contains("HUAWEI")) {
            return 10001;
        }
        return lPC.toUpperCase().contains("XIAOMI") ? 10002 : 20001;
    }
}
