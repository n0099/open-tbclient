package com.baidu.q.a;

import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes25.dex */
public class b {
    static ArrayList<Integer> nrw = new ArrayList<>(4);
    static String nrx;

    static {
        nrw.add(10000);
        nrw.add(10001);
        nrw.add(10002);
        nrw.add(Integer.valueOf((int) com.baidu.sapi2.share.b.h));
        nrw.add(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int dQW() {
        if (TextUtils.isEmpty(nrx)) {
            nrx = com.baidu.q.a.c.d.getManufacturer();
        }
        if (TextUtils.isEmpty(nrx)) {
            return com.baidu.sapi2.share.b.h;
        }
        if (nrx.toUpperCase().contains("HUAWEI")) {
            return 10001;
        }
        if (nrx.toUpperCase().contains("XIAOMI")) {
            return 10002;
        }
        return com.baidu.sapi2.share.b.h;
    }
}
