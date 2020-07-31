package com.baidu.m.a;

import android.text.TextUtils;
import com.baidu.sapi2.share.m;
import java.util.ArrayList;
/* loaded from: classes12.dex */
public class b {
    static ArrayList<Integer> mOj = new ArrayList<>(4);
    static String mOk;

    static {
        mOj.add(10000);
        mOj.add(10001);
        mOj.add(10002);
        mOj.add(Integer.valueOf((int) m.g));
        mOj.add(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int dBa() {
        if (TextUtils.isEmpty(mOk)) {
            mOk = com.baidu.m.a.c.d.getManufacturer();
        }
        if (TextUtils.isEmpty(mOk)) {
            return m.g;
        }
        if (mOk.toUpperCase().contains("HUAWEI")) {
            return 10001;
        }
        if (mOk.toUpperCase().contains("XIAOMI")) {
            return 10002;
        }
        return m.g;
    }
}
