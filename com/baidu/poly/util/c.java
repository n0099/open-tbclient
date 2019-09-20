package com.baidu.poly.util;

import android.os.Build;
import android.os.Bundle;
import android.util.ArrayMap;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class c {
    public static <K, V> Map<K, V> uU() {
        if (Build.VERSION.SDK_INT >= 19) {
            return new ArrayMap();
        }
        return new HashMap();
    }

    public static Bundle j(Map<String, String> map) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            bundle.putString(str, map.get(str));
        }
        return bundle;
    }
}
