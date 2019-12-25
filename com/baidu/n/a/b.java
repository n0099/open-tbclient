package com.baidu.n.a;

import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b {
    static ArrayList<Integer> lyg = new ArrayList<>(4);
    static String lyh;

    static {
        lyg.add(10000);
        lyg.add(10001);
        lyg.add(10002);
        lyg.add(20001);
        lyg.add(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int dfA() {
        if (TextUtils.isEmpty(lyh)) {
            lyh = com.baidu.n.a.c.d.getManufacturer();
        }
        if (TextUtils.isEmpty(lyh)) {
            return 20001;
        }
        if (lyh.toUpperCase().contains("HUAWEI")) {
            return 10001;
        }
        return lyh.toUpperCase().contains("XIAOMI") ? 10002 : 20001;
    }
}
