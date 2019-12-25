package com.baidu.poly.util;

import android.os.Build;
import android.os.Bundle;
import android.util.ArrayMap;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class d {
    public static Bundle k(Map<String, String> map) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            bundle.putString(str, map.get(str));
        }
        return bundle;
    }

    public static <K, V> Map<K, V> p() {
        return Build.VERSION.SDK_INT >= 19 ? new ArrayMap() : new HashMap();
    }
}
