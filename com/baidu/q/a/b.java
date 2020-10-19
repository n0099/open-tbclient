package com.baidu.q.a;

import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class b {
    static ArrayList<Integer> nGQ = new ArrayList<>(4);
    static String nGR;

    static {
        nGQ.add(10000);
        nGQ.add(10001);
        nGQ.add(10002);
        nGQ.add(Integer.valueOf((int) com.baidu.sapi2.share.b.h));
        nGQ.add(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int dUH() {
        if (TextUtils.isEmpty(nGR)) {
            nGR = com.baidu.q.a.c.d.getManufacturer();
        }
        if (TextUtils.isEmpty(nGR)) {
            return com.baidu.sapi2.share.b.h;
        }
        if (nGR.toUpperCase().contains("HUAWEI")) {
            return 10001;
        }
        if (nGR.toUpperCase().contains("XIAOMI")) {
            return 10002;
        }
        return com.baidu.sapi2.share.b.h;
    }
}
