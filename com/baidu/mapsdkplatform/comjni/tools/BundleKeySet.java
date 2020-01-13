package com.baidu.mapsdkplatform.comjni.tools;

import android.os.Bundle;
/* loaded from: classes6.dex */
public class BundleKeySet {
    public String[] getBundleKeys(Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return null;
        }
        String[] strArr = new String[bundle.size()];
        int i = 0;
        for (String str : bundle.keySet()) {
            strArr[i] = str.toString();
            i++;
        }
        return strArr;
    }
}
