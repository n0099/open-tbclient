package com.baidu.n.a;

import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b {
    static String manufacturer;
    static ArrayList<Integer> oXC = new ArrayList<>(4);

    static {
        oXC.add(10000);
        oXC.add(10001);
        oXC.add(10002);
        oXC.add(20001);
        oXC.add(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int eiO() {
        if (TextUtils.isEmpty(manufacturer)) {
            manufacturer = com.baidu.n.a.c.d.getManufacturer();
        }
        if (TextUtils.isEmpty(manufacturer)) {
            return 20001;
        }
        if (manufacturer.toUpperCase().contains("HUAWEI")) {
            return 10001;
        }
        return manufacturer.toUpperCase().contains("XIAOMI") ? 10002 : 20001;
    }
}
