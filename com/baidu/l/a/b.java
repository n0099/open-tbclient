package com.baidu.l.a;

import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class b {
    static ArrayList<Integer> mGc = new ArrayList<>(4);
    static String mGd;

    static {
        mGc.add(10000);
        mGc.add(10001);
        mGc.add(10002);
        mGc.add(20001);
        mGc.add(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int dxK() {
        if (TextUtils.isEmpty(mGd)) {
            mGd = com.baidu.l.a.c.d.getManufacturer();
        }
        if (TextUtils.isEmpty(mGd)) {
            return 20001;
        }
        if (mGd.toUpperCase().contains("HUAWEI")) {
            return 10001;
        }
        return mGd.toUpperCase().contains("XIAOMI") ? 10002 : 20001;
    }
}
