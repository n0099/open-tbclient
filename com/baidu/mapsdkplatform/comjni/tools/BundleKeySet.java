package com.baidu.mapsdkplatform.comjni.tools;

import android.os.Bundle;
/* loaded from: classes2.dex */
public class BundleKeySet {
    public String[] getBundleKeys(Bundle bundle) {
        String[] strArr = null;
        if (bundle == null) {
            return null;
        }
        if (!bundle.isEmpty()) {
            strArr = new String[bundle.size()];
            int i2 = 0;
            for (String str : bundle.keySet()) {
                strArr[i2] = str.toString();
                i2++;
            }
        }
        return strArr;
    }
}
