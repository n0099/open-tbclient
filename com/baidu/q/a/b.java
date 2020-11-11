package com.baidu.q.a;

import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class b {
    static ArrayList<Integer> osy = new ArrayList<>(4);
    static String osz;

    static {
        osy.add(10000);
        osy.add(10001);
        osy.add(10002);
        osy.add(Integer.valueOf((int) com.baidu.sapi2.share.b.h));
        osy.add(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int eeh() {
        if (TextUtils.isEmpty(osz)) {
            osz = com.baidu.q.a.c.d.getManufacturer();
        }
        if (TextUtils.isEmpty(osz)) {
            return com.baidu.sapi2.share.b.h;
        }
        if (osz.toUpperCase().contains("HUAWEI")) {
            return 10001;
        }
        if (osz.toUpperCase().contains("XIAOMI")) {
            return 10002;
        }
        return com.baidu.sapi2.share.b.h;
    }
}
