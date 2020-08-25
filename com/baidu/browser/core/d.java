package com.baidu.browser.core;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes19.dex */
public final class d {
    private static HashMap<String, c> sCache;

    public static synchronized c c(String str, Context context) {
        c cVar;
        synchronized (d.class) {
            if (TextUtils.isEmpty(str)) {
                str = context.getPackageName() + "_preferences";
            }
            if (sCache == null) {
                sCache = new HashMap<>();
            }
            if (sCache.get(str) != null) {
                cVar = sCache.get(str);
            } else {
                cVar = new c(str);
                sCache.put(str, cVar);
            }
        }
        return cVar;
    }
}
