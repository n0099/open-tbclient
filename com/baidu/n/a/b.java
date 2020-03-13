package com.baidu.n.a;

import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class b {
    static ArrayList<Integer> lCE = new ArrayList<>(4);
    static String lCF;

    static {
        lCE.add(10000);
        lCE.add(10001);
        lCE.add(10002);
        lCE.add(20001);
        lCE.add(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int dhV() {
        if (TextUtils.isEmpty(lCF)) {
            lCF = com.baidu.n.a.c.d.getManufacturer();
        }
        if (TextUtils.isEmpty(lCF)) {
            return 20001;
        }
        if (lCF.toUpperCase().contains("HUAWEI")) {
            return 10001;
        }
        return lCF.toUpperCase().contains("XIAOMI") ? 10002 : 20001;
    }
}
