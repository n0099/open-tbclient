package com.baidu.q.a;

import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class b {
    static ArrayList<Integer> oub = new ArrayList<>(4);
    static String ouc;

    static {
        oub.add(10000);
        oub.add(10001);
        oub.add(10002);
        oub.add(Integer.valueOf((int) com.baidu.sapi2.share.b.h));
        oub.add(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int eee() {
        if (TextUtils.isEmpty(ouc)) {
            ouc = com.baidu.q.a.c.d.getManufacturer();
        }
        if (TextUtils.isEmpty(ouc)) {
            return com.baidu.sapi2.share.b.h;
        }
        if (ouc.toUpperCase().contains("HUAWEI")) {
            return 10001;
        }
        if (ouc.toUpperCase().contains("XIAOMI")) {
            return 10002;
        }
        return com.baidu.sapi2.share.b.h;
    }
}
