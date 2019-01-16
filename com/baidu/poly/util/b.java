package com.baidu.poly.util;

import android.os.Build;
import android.util.ArrayMap;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class b {
    public static <K, V> Map<K, V> uE() {
        if (Build.VERSION.SDK_INT >= 19) {
            return new ArrayMap();
        }
        return new HashMap();
    }
}
