package com.baidu.live.alablmsdk.config;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class c {
    public static <T> T a(HashMap<String, Object> hashMap, String str, T t) {
        T t2;
        if (hashMap != null && !TextUtils.isEmpty(str) && hashMap.containsKey(str) && (t2 = (T) hashMap.get(str)) != null) {
            com.baidu.live.alablmsdk.a.b.a.eA(" key = " + str + " value = " + t2);
            return t2;
        }
        return t;
    }
}
