package com.baidu.r.a;

import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes14.dex */
public class b {
    static ArrayList<Integer> oJk = new ArrayList<>(4);
    static String oJl;

    static {
        oJk.add(10000);
        oJk.add(10001);
        oJk.add(10002);
        oJk.add(Integer.valueOf((int) com.baidu.sapi2.share.b.h));
        oJk.add(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int ejS() {
        if (TextUtils.isEmpty(oJl)) {
            oJl = com.baidu.r.a.c.d.getManufacturer();
        }
        if (TextUtils.isEmpty(oJl)) {
            return com.baidu.sapi2.share.b.h;
        }
        if (oJl.toUpperCase().contains("HUAWEI")) {
            return 10001;
        }
        if (oJl.toUpperCase().contains("XIAOMI")) {
            return 10002;
        }
        return com.baidu.sapi2.share.b.h;
    }
}
