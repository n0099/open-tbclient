package com.baidu.q.a;

import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class b {
    static ArrayList<Integer> nhv = new ArrayList<>(4);
    static String nhw;

    static {
        nhv.add(10000);
        nhv.add(10001);
        nhv.add(10002);
        nhv.add(Integer.valueOf((int) com.baidu.sapi2.share.b.h));
        nhv.add(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int dMY() {
        if (TextUtils.isEmpty(nhw)) {
            nhw = com.baidu.q.a.c.d.getManufacturer();
        }
        if (TextUtils.isEmpty(nhw)) {
            return com.baidu.sapi2.share.b.h;
        }
        if (nhw.toUpperCase().contains("HUAWEI")) {
            return 10001;
        }
        if (nhw.toUpperCase().contains("XIAOMI")) {
            return 10002;
        }
        return com.baidu.sapi2.share.b.h;
    }
}
