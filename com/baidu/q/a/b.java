package com.baidu.q.a;

import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class b {
    static ArrayList<Integer> nhd = new ArrayList<>(4);
    static String nhe;

    static {
        nhd.add(10000);
        nhd.add(10001);
        nhd.add(10002);
        nhd.add(Integer.valueOf((int) com.baidu.sapi2.share.b.h));
        nhd.add(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int dMP() {
        if (TextUtils.isEmpty(nhe)) {
            nhe = com.baidu.q.a.c.d.getManufacturer();
        }
        if (TextUtils.isEmpty(nhe)) {
            return com.baidu.sapi2.share.b.h;
        }
        if (nhe.toUpperCase().contains("HUAWEI")) {
            return 10001;
        }
        if (nhe.toUpperCase().contains("XIAOMI")) {
            return 10002;
        }
        return com.baidu.sapi2.share.b.h;
    }
}
