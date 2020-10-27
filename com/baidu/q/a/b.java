package com.baidu.q.a;

import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class b {
    static ArrayList<Integer> ojs = new ArrayList<>(4);
    static String ojt;

    static {
        ojs.add(10000);
        ojs.add(10001);
        ojs.add(10002);
        ojs.add(Integer.valueOf((int) com.baidu.sapi2.share.b.h));
        ojs.add(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int eaz() {
        if (TextUtils.isEmpty(ojt)) {
            ojt = com.baidu.q.a.c.d.getManufacturer();
        }
        if (TextUtils.isEmpty(ojt)) {
            return com.baidu.sapi2.share.b.h;
        }
        if (ojt.toUpperCase().contains("HUAWEI")) {
            return 10001;
        }
        if (ojt.toUpperCase().contains("XIAOMI")) {
            return 10002;
        }
        return com.baidu.sapi2.share.b.h;
    }
}
