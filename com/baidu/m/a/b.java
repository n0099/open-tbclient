package com.baidu.m.a;

import android.text.TextUtils;
import com.baidu.sapi2.share.m;
import java.util.ArrayList;
/* loaded from: classes12.dex */
public class b {
    static ArrayList<Integer> mOl = new ArrayList<>(4);
    static String mOm;

    static {
        mOl.add(10000);
        mOl.add(10001);
        mOl.add(10002);
        mOl.add(Integer.valueOf((int) m.g));
        mOl.add(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int dBb() {
        if (TextUtils.isEmpty(mOm)) {
            mOm = com.baidu.m.a.c.d.getManufacturer();
        }
        if (TextUtils.isEmpty(mOm)) {
            return m.g;
        }
        if (mOm.toUpperCase().contains("HUAWEI")) {
            return 10001;
        }
        if (mOm.toUpperCase().contains("XIAOMI")) {
            return 10002;
        }
        return m.g;
    }
}
