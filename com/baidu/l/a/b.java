package com.baidu.l.a;

import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class b {
    static ArrayList<Integer> mkg = new ArrayList<>(4);
    static String mkh;

    static {
        mkg.add(10000);
        mkg.add(10001);
        mkg.add(10002);
        mkg.add(20001);
        mkg.add(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int dth() {
        if (TextUtils.isEmpty(mkh)) {
            mkh = com.baidu.l.a.c.d.getManufacturer();
        }
        if (TextUtils.isEmpty(mkh)) {
            return 20001;
        }
        if (mkh.toUpperCase().contains("HUAWEI")) {
            return 10001;
        }
        return mkh.toUpperCase().contains("XIAOMI") ? 10002 : 20001;
    }
}
