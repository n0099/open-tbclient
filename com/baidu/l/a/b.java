package com.baidu.l.a;

import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class b {
    static ArrayList<Integer> mGf = new ArrayList<>(4);
    static String mGg;

    static {
        mGf.add(10000);
        mGf.add(10001);
        mGf.add(10002);
        mGf.add(20001);
        mGf.add(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int dxO() {
        if (TextUtils.isEmpty(mGg)) {
            mGg = com.baidu.l.a.c.d.getManufacturer();
        }
        if (TextUtils.isEmpty(mGg)) {
            return 20001;
        }
        if (mGg.toUpperCase().contains("HUAWEI")) {
            return 10001;
        }
        return mGg.toUpperCase().contains("XIAOMI") ? 10002 : 20001;
    }
}
