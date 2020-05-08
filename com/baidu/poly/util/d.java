package com.baidu.poly.util;

import android.os.Build;
import android.os.Bundle;
import android.util.ArrayMap;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class d {
    public static <K, V> Map<K, V> KZ() {
        return Build.VERSION.SDK_INT >= 19 ? new ArrayMap() : new HashMap();
    }

    public static Bundle i(Map<String, String> map) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            bundle.putString(str, map.get(str));
        }
        return bundle;
    }
}
