package com.baidu.l.a;

import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class b {
    static ArrayList<Integer> miW = new ArrayList<>(4);
    static String miX;

    static {
        miW.add(10000);
        miW.add(10001);
        miW.add(10002);
        miW.add(20001);
        miW.add(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int dsT() {
        if (TextUtils.isEmpty(miX)) {
            miX = com.baidu.l.a.c.d.getManufacturer();
        }
        if (TextUtils.isEmpty(miX)) {
            return 20001;
        }
        if (miX.toUpperCase().contains("HUAWEI")) {
            return 10001;
        }
        return miX.toUpperCase().contains("XIAOMI") ? 10002 : 20001;
    }
}
