package com.baidu.r.a;

import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes14.dex */
public class b {
    static ArrayList<Integer> oJi = new ArrayList<>(4);
    static String oJj;

    static {
        oJi.add(10000);
        oJi.add(10001);
        oJi.add(10002);
        oJi.add(Integer.valueOf((int) com.baidu.sapi2.share.b.h));
        oJi.add(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int ejR() {
        if (TextUtils.isEmpty(oJj)) {
            oJj = com.baidu.r.a.c.d.getManufacturer();
        }
        if (TextUtils.isEmpty(oJj)) {
            return com.baidu.sapi2.share.b.h;
        }
        if (oJj.toUpperCase().contains("HUAWEI")) {
            return 10001;
        }
        if (oJj.toUpperCase().contains("XIAOMI")) {
            return 10002;
        }
        return com.baidu.sapi2.share.b.h;
    }
}
