package com.baidu.n.a;

import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class b {
    static String manufacturer;
    static ArrayList<Integer> oUX = new ArrayList<>(4);

    static {
        oUX.add(10000);
        oUX.add(10001);
        oUX.add(10002);
        oUX.add(20001);
        oUX.add(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int eiw() {
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
